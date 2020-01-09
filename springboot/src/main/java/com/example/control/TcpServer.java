package com.example.control;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer {

    /**
     * 接受TCP请求
     * @return
     * @throws Exception
     */
    public String receive(){
        //创建服务器ServerSocket对象
        ServerSocket ss;
        String str = "";
        try {
            ss = new ServerSocket(6666);
            //监听客户端的连接
            Socket s = ss.accept();//在连接传入之前一直阻塞，接收到后开始执行后面的
            //获取输入流
            InputStream is = s.getInputStream();

            byte[] bys = new byte[1024];
            int len = is.read(bys);
            str = new String(bys,0,len);

            //给出获得消息后的反馈
            OutputStream os = s.getOutputStream();
            os.write("消息已经收到".getBytes());

            //释放资源
            s.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(str);
        return str;
    }
}
