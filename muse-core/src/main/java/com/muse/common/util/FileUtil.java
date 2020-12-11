package com.muse.common.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * * @Author: RyouA
 * * @Date: 2020/11/11
 **/
public class FileUtil {
    /**
     * 文件读取
     * TODO：文件量大的时候
     * @param remotePath
     * @return
     */
    public static String readContentFromFile(String remotePath) {
        try {
            URL url = new URL(remotePath);
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
            String s;
            while ((s = reader.readLine()) != null) {}
            reader.close();
            return s;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}
