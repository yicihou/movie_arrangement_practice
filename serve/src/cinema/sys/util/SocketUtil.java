package cinema.sys.util;
import cinema.sys.message.message;

import java.io.*;
import java.net.Socket;

/*
*套接字工具类
 */
public class SocketUtil {
    /*
    *从客户端获取信息
     */
    public static <T> message<T> receiveMessage(Socket client){
        try {
            InputStream is=client.getInputStream();
            ObjectInputStream ois=new ObjectInputStream(is);
            message<T>mag= (message<T>) ois.readObject();
            client.shutdownInput();
            return mag;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    /*
    *回写信息
     */
    public static <V> void sendBack(Socket client,V data){
        try {
            OutputStream os=client.getOutputStream();
            ObjectOutputStream oos=new ObjectOutputStream(os);
            oos.writeObject(data);
            oos.flush();
            client.shutdownOutput();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
