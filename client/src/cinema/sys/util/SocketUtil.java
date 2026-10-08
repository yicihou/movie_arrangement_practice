package cinema.sys.util;

import cinema.sys.message.message;

import java.io.*;
import java.net.Socket;

public class SocketUtil {//用于接发消息的工具类
    private static String IP="localhost";
    private static int port=8888;
    /*
    *向服务器端发送信息
     */
    public static  <V,T> V sendMessage(message<T> mag){
        Socket client=null;
        try {
            client=new Socket(IP,port);
            //获取输出流
            OutputStream os=client.getOutputStream();
            //包装为序列流
            ObjectOutputStream oos=new ObjectOutputStream(os);
            //写出
            oos.writeObject(mag);
            //刷新
            oos.flush();
            //告诉客户端已经写出完毕
            client.shutdownOutput();
            //获取输入流
            InputStream is=client.getInputStream();
            //包装
            ObjectInputStream ois=new ObjectInputStream(is);
            //读取
            V result = (V) ois.readObject();
            //告诉客户端已经读取完毕
            client.shutdownInput();
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            //关闭连接，防止连接泄漏
            if (client != null) {
                try {
                    client.close();
                } catch (IOException ignored) {
                }
            }
        }
    }
}
