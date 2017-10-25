package com.example.lenovo.jinritoutiao.utis;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;

/**
 * Created by Lenovo on 2017/9/5.
 */

public class StreamTools {

        /**
         * 字节流转化成字符串
         */
        public static String readFromNetWork(InputStream is){


            try {

                ByteArrayOutputStream baos = new ByteArrayOutputStream();

                byte[] buffer = new byte[1024];
                int len = 0;
                while ((len = is.read(buffer)) != -1){

                    baos.write(buffer,0,len);

                }

                is.close();
                baos.close();
                return baos.toString();

            } catch (Exception e) {
                e.printStackTrace();
            }

            return null;

        }
}
