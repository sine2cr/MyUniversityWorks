package com.javaSElearn;

import org.hamcrest.core.Is;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class file1Test {
    public static void fileTest() {
        File f1 = new File("D:\\学习资料\\c++编程\\c++实验考试模拟上机题（参考答案）.txt");
        System.out.println("文件路径：" + f1.getAbsolutePath());
        System.out.println("文件路径:" + f1.getPath());
        System.out.println("文件名:" + f1.getName());
        System.out.println("文件大小:" + f1.length());
        long time = f1.lastModified();
        System.out.println("最后的修改时间:" + new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(time));
        try {
            InputStream is = new FileInputStream("D:\\学习资料\\c++编程\\c++实验考试模拟上机题（参考答案）.txt");
            int b;
            while ((b = is.read()) != -1) {
                System.out.print((char) b);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
    //文件拷贝

    public static void copyTest() {
        try {
            InputStream is = new FileInputStream("D:\\学习资料\\c++编程\\c++实验考试模拟上机题（参考答案）.txt");
            OutputStream os = new FileOutputStream("D:\\学习资料\\c++编程\\测试c++实验考试模拟上机题（参考答案）.txt");
            byte[] buffer = new byte[1024];
            int len;
            while ((len = is.read(buffer)) != -1) {
                os.write(buffer, 0, len);
            }
            System.out.println("复制完成了");
            os.close();
            is.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //拷贝出师表(错误ing）

    public static void copyTXT() {
        try {
            //创建缓冲字符输入流管道与源文件接通
            BufferedReader br = new BufferedReader(new FileReader("src\\1.txt"));
            //定义一个list集合存储每行内容
            List<String> data = new ArrayList<>();
            String line;
            //定义循环，按照行读取文章
            while ((line = br.readLine()) != null) {
                data.add(line);

            }
            System.out.println(data);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
