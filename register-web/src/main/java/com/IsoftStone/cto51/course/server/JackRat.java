package com.IsoftStone.cto51.course.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 51CTO Java 视频教程  用JAVA创建高端大气上档次的山寨WEB服务器tomMonkey
 * <p/>
 * 目标：仿照教程开发一个山寨 WEB服务器
 * 1.支持多个浏览器访问（多线程）
 * 2.如何提供服务（Socket）
 * 3.如何返回响应（IO）
 * Created by Ivan Wang on 2014/7/25.
 */
public class JackRat {
    //默认端口
    private static int PORT = 8080;

    //程序方法入口
    public static void main(String[] args) {
        //动态设置服务器的端口（通过命令行传递）
        int p = args.length > 0 ? Integer.parseInt(args[0]) : PORT;
        new JackRat().start(p);
    }

    /**
     * 服务启动方法
     * 创建Socket服务器
     */
    public void start(int port) {
        try {
            ServerSocket ss = new ServerSocket(8080);
            System.out.println("-----------监听[" + port + "]端口的服务器启动------------");
            while (true) {
                Socket socket = ss.accept();
                System.out.println("-----------有客户端请求------------");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
