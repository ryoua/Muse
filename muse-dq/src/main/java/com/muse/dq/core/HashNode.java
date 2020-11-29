package com.muse.dq.core;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.LinkedList;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * 哈希节点：总共1000个虚拟节点，默认100个物理节点，支持动态扩容
 * * @Author: RyouA
 * * @Date: 2020/11/19
 **/
@Slf4j
@Getter
@Setter
public class HashNode {
    private static final String JOB_BUCKET = "job:bucket:";

    private static List<String> realNodes = new LinkedList<String>();

    private static SortedMap<Integer, String> virtualNodes = new TreeMap<>();

    private static final int REAL_NODES = 10;

    private static final int VIRTUAL_NODES = 10;

    public static List<String> getRealNodes() {
        return realNodes;
    }

    public static SortedMap<Integer, String> getVirtualNodes() {
        return virtualNodes;
    }

    /**
     * 初始化一致性hash节点
     */
    static {
        for (int i = 0; i < REAL_NODES; i++) {
            realNodes.add(JOB_BUCKET + i);
        }

        realNodes.forEach(realNode -> {
            for (int i = 0; i < VIRTUAL_NODES; i++) {
                String virtualNodeName = realNode + "&&VN" + String.valueOf(i);
                int hash = getHash(virtualNodeName);
                log.info("虚拟bucket节点【" + virtualNodeName + "】被添加, hash值为" + hash);
                virtualNodes.put(hash, virtualNodeName);
            }
        });
    }

    /**
     * 使用FNV1_32_HASH算法计算服务器的Hash值
     * @param str
     * @return
     */
    public static int getHash(String str) {
        final int p = 16777619;
        int hash = (int) 2166136261L;
        for (int i = 0; i < str.length(); i++) {
            hash = (hash ^ str.charAt(i)) * p;
        }
        hash += hash << 13;
        hash ^= hash >> 7;
        hash += hash << 3;
        hash ^= hash >> 17;
        hash += hash << 5;

        // 如果算出来的值为负数则取其绝对值
        if (hash < 0) {
            hash = Math.abs(hash);
        }
        return hash;
    }

    public static String getBucket(String node) throws InterruptedException {
        // 得到带路由的节点的hash值
        int hash = getHash(node);
        // 得到大于该hash值的所有Map
        SortedMap<Integer, String> subMap = virtualNodes.tailMap(hash);
        // 第一个Key就是顺时针过去离node最近的那个节点
        Integer i = 0;
        try {
            i = subMap.firstKey();
        } catch (Exception e) {
            log.info("=-===============");
            Thread.sleep(5000);
            i = subMap.firstKey();
        }
        // 返回对应的虚拟节点名称，这里字符串稍微截取一下
        String virtualNode = subMap.get(i);
        return virtualNode.substring(0, virtualNode.indexOf("&&"));
    }


}