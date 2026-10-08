package cinema.sys.serve;

import cinema.sys.task.MessageProcessTask;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class CinemaServe {
    //通道
    private ServerSocket ss;
    //创建对象（客户端）
    public CinemaServe(int port) throws IOException {
        //通过端口连接
        this.ss=new ServerSocket(port);
    }
    //服务器启动
    public void start(){
        System.out.println("服务端已启动，等待连接...");
        while (true) {
            try {
                Socket client=ss.accept();
                new Thread(new MessageProcessTask(client)).start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        try {
            CinemaServe serve=new CinemaServe(8888);
            serve.start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
