package com.example.util;

import org.apache.http.util.TextUtils;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPUtil {

    public static String receive() throws Exception{
        //创建服务器ServerSocket对象
        ServerSocket ss = new ServerSocket(6666);

        //监听客户端的连接
        Socket s = ss.accept();//在连接传入之前一直阻塞，接收到后开始执行后面的
        //获取输入流
        InputStream is = s.getInputStream();
        byte[] bys = new byte[1024];
        int len = is.read(bys);
        String str = new String(bys,0,len);

        //给出获得消息后的反馈
        OutputStream os = s.getOutputStream();
        os.write("消息已经收到".getBytes());

        //释放资源
        s.close();

        return str;
    }

    /**
     * 发送tcp请求并接受返回信息
     * @param cmdInfor
     * @param hostStr
     * @param portNum
     * @return
     */
    public static String send(String cmdInfor, String hostStr, int portNum){
        String strReturn = null;
        try {
            //要连接的服务端IP地址
            String host = hostStr;
            //要连接的服务端对应的监听端口
            int port = portNum;
            //将十六进制的字符串转换成字节数组
            byte[] cmdInfor2 = hexStrToBinaryStr(cmdInfor);

            //1.建立客户端socket连接，指定服务器位置及端口
            Socket clientSocket =new Socket(host,port);

            //2.得到socket读写流
            OutputStream os=clientSocket.getOutputStream();
            PrintWriter pw=new PrintWriter(os);
            //输入流
            InputStream is=clientSocket.getInputStream();

            //3.利用流按照一定的操作，对socket进行读写操作
            os.write(cmdInfor2);
            os.flush();
            clientSocket.shutdownOutput();

            //接收服务器的响应
            int line = 0;
            byte[] buf = new byte[is.available()];

            //接收收到的数据
            while((line=is.read(buf))!=-1){
                //将字节数组转换成十六进制的字符串
                strReturn= BinaryToHexString(buf);
            }
            //4.关闭资源
            is.close();
            pw.close();
            os.close();
            clientSocket.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return strReturn;
    }

    /**
     * 将十六进制的字符串转换成字节数组
     *
     * @param hexString
     * @return
     */
    public static byte[] hexStrToBinaryStr(String hexString) {

        if (TextUtils.isEmpty(hexString)) {
            return null;
        }

        hexString = hexString.replaceAll(" ", "");

        int len = hexString.length();
        int index = 0;

        byte[] bytes = new byte[len / 2];

        while (index < len) {

            String sub = hexString.substring(index, index + 2);

            bytes[index/2] = (byte)Integer.parseInt(sub,16);

            index += 2;
        }


        return bytes;
    }

    /**
     * 将字节数组转换成十六进制的字符串
     *
     * @return
     */
    public static String BinaryToHexString(byte[] bytes) {
        String hexStr = "0123456789ABCDEF";
        String result = "";
        String hex = "";
        for (byte b : bytes) {
            hex = String.valueOf(hexStr.charAt((b & 0xF0) >> 4));
            hex += String.valueOf(hexStr.charAt(b & 0x0F));
            result += hex + " ";
        }
        return result;
    }
}
