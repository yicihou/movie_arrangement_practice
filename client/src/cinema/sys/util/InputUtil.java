package cinema.sys.util;

import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;

public class InputUtil {
    private static Scanner scanner=new Scanner(System.in);

    //从控制台获取整数并判断
    public static int inputjudge(String tip,int min,int max){
        System.out.println(tip);
        while (true){
            if(scanner.hasNextInt()){
                int number=scanner.nextInt();
                if(number>=min&&number<=max){
                    return number;
                }else{
                    System.out.println("请输入"+min+"~"+max+"之间的数字");
                }
            }else{
                System.out.println("请输入"+min+"~"+max+"之间的数字");
                scanner.next();
            }
        }
    }

    //从控制台获取字符串
    public static String getInputText(String tip){
        System.out.println(tip);
        return scanner.next();
    }

    //从控制台获取日期
    public static Date getIntputDate(String tip){
        System.out.println(tip);
        while (true){
            String datestr=scanner.nextLine();
            try {
              return DateUtil.StringToDate(datestr);
            } catch (ParseException e) {
                System.out.println("格式有误，重新输入");
            }
        }
    }



}
