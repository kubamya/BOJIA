package com.example.TCPServer;

import org.springframework.beans.factory.annotation.Value;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {

//    @Value("${tcpServer.port}")
//    private int tcpServePort;

    public void startServer(){
        //创建服务器ServerSocket对象
        try{
            ServerSocket ss = new ServerSocket(6666);
            while (recevieTCP(ss)){
                recevieTCP(ss);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private boolean recevieTCP(ServerSocket ss){
        try{
            //监听客户端的连接
            Socket s = ss.accept();//在连接传入之前一直阻塞，接收到后开始执行后面的
            //获取输入流
            InputStream is = s.getInputStream();
            byte[] bys = new byte[1024];
            int len = is.read(bys);
            String str = new String(bys,0,len);

            //将从客户端传来的消息输出到控制台
            System.out.println("来自客户端："+str);

            //给出获得消息后的反馈
            OutputStream os = s.getOutputStream();
            os.write("消息已经收到".getBytes());

            //释放资源
            s.close();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

}
