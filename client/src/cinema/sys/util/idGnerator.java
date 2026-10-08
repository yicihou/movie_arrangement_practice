package cinema.sys.util;

import java.util.Random;

public class idGnerator {
    //id生成
    static Random random=new Random();
    //字符，数字存入数组
    static private char[]chars={
            '0','1','2','3','4','5','6','7','8','9'
    };
    //根据长度随机生成字符串
    public static String idgnerator( int length){
        StringBuilder sb=new StringBuilder("CYX_");
        for (int i = 0; i < length; i++) {
            int index=random.nextInt(chars.length);
            sb.append(chars[index]);
        }
        return sb.toString();
    }
}
