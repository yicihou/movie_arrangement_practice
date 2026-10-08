package cinema.sys.util;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {
    /*
    *文件操作工具类
     */
    public static final String FILM_FILE="data/film.obj";
    public static final String USER_FILE="data/user.obj";
    public static final String FILM_PLAN_FILE="data/plan.obj";
    public static final String FILM_HALL_FILE="data/filmhall.obj";
    public static final String ORDER_FILE="data/order.obj";
    public static final String UNFORZEN_APPLY_FILE ="data/unforzenApply.obj";

    /*
    *保存数据
     */
    public static <T> boolean saveData(List<T> data,String path){
        //创建文件
        File file=new File(path);
        File parent=file.getParentFile();
        //判断文件是否存在
        if(!parent.exists()){
            //不存在则创建
            parent.mkdirs();
        }
        //IO流写入文件

        try {
            OutputStream os = new FileOutputStream(file);
            ObjectOutputStream oos=new ObjectOutputStream(os);
            oos.writeObject(data);
            oos.flush();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    /*
    *读取数据
     */
    public static <T>List<T> ReaderData(String path){
        //创建文件
        File file=new File(path);
        //获取IO流
        try {
            InputStream is=new FileInputStream(file);
            ObjectInputStream ois=new ObjectInputStream(is);
            List<T> data= (List<T>) ois.readObject();
            return data;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
        //读取
    }
}
