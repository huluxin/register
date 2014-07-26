package com.IsoftStone.cto51.course.server;

import java.io.*;
import java.net.Socket;

/**
 * 专门处理不同的客户端请求的 多线程
 * Created by Ivan Wang on 2014/7/26.
 */
public class HandlerRequestThread implements Runnable{

    private InputStream in = null;
    //因为要涉及浏览器内容的输出，所以使用了PrintStream 标准输出流
    private PrintStream out = null;

    /**
     * Web 应用 根路径
     * D:\JavaWorkSpace\MyWeb
     */
    private static final String WEB_ROOT = "D:" + File.separator+"JavaWorkSpace"+File.separator + "MyWeb"+File.separator;
    /**
     * 通过构造器获得socket
     * 并通过socket获取对客户端的输入和输出流
     * @param socket
     */
    public HandlerRequestThread(Socket socket) {
        try {
                in = socket.getInputStream();
                out = new PrintStream(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 解析请求头，获得客户端请求的资源名称
     * @param in 输入流
     * @return  请求的资源名称
     */
    public String parseRequestHead(InputStream in) throws IOException {
        //客户端发起请求会将一些请求数据包含在请求头中
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        //请求头的第一行将包含请求的方式，请求的资源名称，请求的协议版本
        String headContent = br.readLine();
        System.out.println(headContent);
        //使用空格分割 获取中间的请求资源名称 数据
        String[] heads = headContent.split(" ");
        return heads[1];
    }

    public void getFile(String fileName) throws IOException {
        File file = new File(WEB_ROOT + fileName);

        if(!file.exists()){
            System.out.println("你请求的资源【"+fileName+"】不存在！请确认请求的资源名称是否正确！");
            return;
        }else{
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
            byte[] buff = new byte[(int)file.length()];
            bis.read(buff);

            out.println("HTTP/1.1 200 OK");
            out.println();
            out.write(buff);
            out.flush();
            out.close();
        }

    }

    public void sendError(String errorNumber,String errorMsg){
           StringBuilder sb = new StringBuilder("<html><title>错误页面</title>");
    }

    @Override
    public void run() {
        try {
            String fileName = parseRequestHead(this.in);
            getFile(fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
