package com.example.demo.Utils;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by admin on 2018/7/4.
 */
public class WriterFileUtils {
    public static void main(String[] args) {
        WriterFileUtils utils = new WriterFileUtils();
        String name = utils.getClass().getName();
        System.out.println(name);
        String pathFile = "D:/chun.txt";
        String content = "素胚勾勒出青花，笔锋浓转淡";
        WriterFileUtils fileUtils = new WriterFileUtils();
        String readFile = fileUtils.writerFile(pathFile,content);
        System.out.println(readFile);
       /* try {
            fileUtils.downloadNet();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }*/
    }

    public String writerFile(String pathFile,String content){
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(pathFile);
                 //
            byte[] bytes = content.getBytes();//将文本改为字节数组
            fos.write(bytes);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(fos != null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return "写入成功";
    }

    public void downloadNet() throws MalformedURLException {
        // 下载网络文件
        int bytesum = 0;
        int byteread = 0;
        //
        URL url = new URL("http://dd.sjtxt.la/down/61/61184/%E4%BB%99%E8%B7%AF%E8%87%B3%E5%B0%8A.zip");
        try {
            URLConnection conn = url.openConnection();
            InputStream inStream = conn.getInputStream();
            FileOutputStream fs = new FileOutputStream("D:/a.zip");

            byte[] buffer = new byte[1204];
            int length;
            while ((byteread = inStream.read(buffer)) != -1) {
                bytesum += byteread;
                System.out.println(bytesum);
                fs.write(buffer, 0, byteread);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
