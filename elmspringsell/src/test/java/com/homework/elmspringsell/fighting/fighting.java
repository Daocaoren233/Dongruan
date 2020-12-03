package com.homework.elmspringsell.fighting;

import com.homework.elmspringsell.utils.KeyUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
public class fighting
{
    public static void main(String[] args) throws IOException
    {
            String code = KeyUtil.getcode();
            URL url=new URL("https://itdage.com/kkb/kkbsms?key=xzk&number=13145218853&code="+code);//new一个URL对象，为保护隐私注意此处电话号码为空，需要的可以填写自己的号码，
            URLConnection con=url.openConnection();//通过网址url打开服务器连接，并得到连接对象
            InputStream is=con.getInputStream();//得到用于读取页面资源的字节输入流
            BufferedReader br=new BufferedReader(new InputStreamReader(is,"UTF-8"));//将字节输入流封装为一次读取一行的字符缓冲输入流，并设置编码方式为UTF-8
            String text=br.readLine();//读取一行资源并显示
            System.out.println(text);
            br.close();//关闭连接


    }
}
