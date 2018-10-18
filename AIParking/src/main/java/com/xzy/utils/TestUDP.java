package com.xzy.utils;
import com.xzy.mapper.ParkingMapper;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.net.*;
import java.util.*;
public class TestUDP {
    public  static void  main(String[] args) throws Exception {
        DatagramSocket ds = new DatagramSocket();

        myDatagramSocketReceive receiveData = new myDatagramSocketReceive(ds);
        new Thread(receiveData).start();
        String str = "ep=P89Z15E1NTHM2WJP&pw=654321";
        while (true) {

            ds.send(new DatagramPacket(
                    str.getBytes(), str.getBytes().length,
                    InetAddress.getByName("115.29.240.46"), 6000));
            Thread.sleep(10000);

        }
    }


    static class myDatagramSocketReceive implements Runnable {
        private DatagramSocket ds;
        private DatagramPacket dp;
        private byte[] buf;

        myDatagramSocketReceive(DatagramSocket ds) {
            try {
                this.ds = ds;
            } catch (Exception e) {
                throw new RuntimeException("Receive DatagramSocket");
            }
            buf = new byte[1024 * 4];
        }

        public void close() {
            ds.close();
        }

        public void run() {
            while (true) {
                try {
                    dp = new DatagramPacket(buf, buf.length);
                    ds.receive(dp);
                    String data = new String(dp.getData());

                    if (data.startsWith("{")) {
                        int device = Integer.parseInt(data.substring(12, 13));
                        int status = Integer.parseInt(data.substring(26, 27));
                        System.out.println("dellwith=========================" + device + ":" + status);

                        try {
                            ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
                            ParkingMapper bean = applicationContext.getBean(ParkingMapper.class);
                            Map map = new HashMap();
                            map.put("status", status);
                            map.put("id", device);
                            bean.mappingUpdate(map);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    }
                    System.out.println(dp.getAddress().toString() + ":" + (new String(dp.getData(), 0, dp.getLength())) + (new Date()).toString());
                    System.out.flush();


                } catch (Exception e) {
                    throw new RuntimeException("Receive");
                }
            }
        }
    }
}