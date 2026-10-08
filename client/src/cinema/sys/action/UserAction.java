package cinema.sys.action;

import cinema.sys.entity.User;
import cinema.sys.message.message;
import cinema.sys.util.InputUtil;
import cinema.sys.util.SocketUtil;

import java.util.Map;

public class UserAction {
    User user;
    /*
     *账号注册
     */
    public static void register(){
        //录入
        String userName= InputUtil.getInputText("请输入用户名");
        String userPassword=InputUtil.getInputText("请输入密码");
        String safeid=InputUtil.getInputText("请输入安全码");
        //打包（注意 User 构造参数顺序：safeid, username, password）
        User user=new User(safeid,userName,userPassword);
        message<User> msg=new message<User>("register",user);
        //发出
        Integer result=SocketUtil.sendMessage(msg);
        //接收回信
        if (result!=null&&result==1){
            System.out.println("注册成功");
        }else if(result!=null&&result==-1){
            System.out.println("账号已被注册");
        } else {
            System.out.println("注册失败，请稍后再试");
        }
    }
    /*
     *账号登录
     */
    public static Map<String,Object> login(){
        //录入
        String UserName=InputUtil.getInputText("请输入用户名");
        String passWord=InputUtil.getInputText("请输入密码");
        //打包
        User user=new User(null,UserName,passWord);
        message<User> msg=new message<>("login",user);
        //发出并接受
        return SocketUtil.sendMessage(msg);
    }
    /*
     *密码找回
     */
    public  void find(){
        //打包信息
        System.out.println("请输入要找回的账号");
    }
    /*
     *申请解冻
     */
    public  void apply(){}
    /*
     *退出系统
     */
    public static void exit(){
        System.out.println("");
        System.exit(0);
    }
    /*
     *订单查找
     */
    public void searchOrder(){}
    /*
     *修改订单
     */
    public void changeOrder(){}
    /*
     *取消订单
     */
    public void cancelOrder(){}
    /*
     *返回主菜单
     */
    public void backMain(){}
    /*
     *查看播放计划
     */
    public void getPlan(){}
    /*
     *在线订座
     */
    public void orderSeat(){}
    /*
     *返回登录
     */
    public void backLogin(){}
    /*
     *查看影片
     */
    public void searchFilm(){}
    /*
     *修改影片
     */
    public void changeFilm(){}
    /*
     *添加影片
     */
    public void addFilm(){}
    /*
     *删除影片
     */
    public void deleteFilm(){}
    /*
     *查看影厅
     */
    public void searchFilmHall(){}
    /*
     *增加影厅
     */
    public void addFilmHall(){}
    /*
     *修改影厅
     */
    public void changeFilmHall(){}
    /*
     *删除影厅
     */
    public void deleteFilmHall(){}
    /*
     *修改计划
     */
    public void setPlan(){}
    /*
     *增加计划
     */
    public void addPlan(){}
    /*
     *删除计划
     */
    public void deletePlan(){}
    /*
     *查看用户
     */
    public void searchUser(){}
    /*
     *冻结用户
     */
    public void forzenUser(){}
    /*
     *解冻用户
     */
    public void unforzenUser(){}
    /*
     *查看申请
     */
    public void  searchApply(){}
    /*
     *审核订单
     */
    public void judgeOrder(){}

}
