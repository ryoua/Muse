package com.muse.common.controller;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.StringUtils;
import org.aspectj.lang.annotation.Before;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class StreamApi {
    static List<Vehicle> vehicles = new ArrayList<>();

    public static void main(String[] args) {


        //遍历集合
        vehicles.forEach(vehicle -> {
            System.out.println(vehicle);
        });

    }

    public void init(){
        List<String> imeis = new ArrayList<>();
        for (int i = 0; i <5 ; i++) {
            List<String> singleVehicleDevices = new ArrayList<>();
            for (int j = 0; j < 3; j++) {
                String imei = RandomStringUtils.randomAlphanumeric(15);
                singleVehicleDevices.add(imei);
            }
            imeis.add(StringUtils.join(singleVehicleDevices,','));
        }
        vehicles.add(new Vehicle("KPTSOA1K67P081452","17620411498","9420",1,4.5,imeis.get(0)));
        vehicles.add(new Vehicle("KPTCOB1K18P057071","15073030945","张玲",2,1.4,imeis.get(1)));
        vehicles.add(new Vehicle("KPTS0A1K87P080237","19645871598","sanri1993",1,3.0,imeis.get(2)));
        vehicles.add(new Vehicle("KNAJC526975740490","15879146974","李种",1,3.9,imeis.get(3)));
        vehicles.add(new Vehicle("KNAJC521395884849","13520184976","袁绍",2,4.9,imeis.get(4)));
    }
}
