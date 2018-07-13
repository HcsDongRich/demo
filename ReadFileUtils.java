package com.example.demo.Utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by admin on 2018/7/4.
 */
public class ReadFileUtils {
    public static void main(String[] args) {
        String pathFile = "D:/han.txt";
        ReadFileUtils fileUtils = new ReadFileUtils();
        String readFile = fileUtils.readFile(pathFile);
        System.out.println(readFile);
    }

    public String readFile(String pathFile){
        FileInputStream fis = null;
        String result = "";
        try {
            fis = new FileInputStream(pathFile);
            int size = fis.available();//返回剩余可读取的字节
            byte[] bytes = new byte[size];//创建一个合适的数组
            fis.read(bytes);//将流中的数据放入字节数组中
            result = new String(bytes);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(fis != null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }
}
