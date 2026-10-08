package cinema.sys.menu;

import java.util.Arrays;

public class MenuMannager {
    /*
    *登录菜单
     */
    public static final Menu[] Login_Menu ={
        new Menu(1,"登录","login"),//不返回
        new Menu(2,"注册","register"),
            new Menu(3,"找回密码","find"),
            new Menu(4,"申请解冻","apply"),
        new Menu(5,"退出","exit")
    };

    /*
     *普通用户菜单
     */
    public static final Menu[] user_Menu;
    static {
        Menu menu1 =new Menu(1,"我的订单","showchildren");
        menu1.Addchildren(new Menu(1,"查看订单","searchOrder",menu1));
        menu1.Addchildren(new Menu(2,"修改订单","changeOrder",menu1));
        menu1.Addchildren(new Menu(3,"取消订单","cancelOrder",menu1));
        menu1.Addchildren(new Menu(4,"返回主菜单","backMain",menu1));

        Menu menu2=new Menu(2,"购买影票","showchildren");
        menu2.Addchildren(new Menu(1,"查看影片计划","getPlan",menu2));
        menu2.Addchildren(new Menu(2,"在线订票","orderSeat",menu2));
        menu2.Addchildren(new Menu(3,"返回主菜单","backMain",menu2));

        Menu menu3=new Menu(3,"返回登录","backLogin");

        user_Menu=new Menu[]{menu1,menu2,menu3};
    }
    /*
     *管理员菜单
     */
    public static final Menu[] mannger_Menu;
    static {
        Menu menu1=new Menu(1,"影片管理","showchildren");
        menu1.Addchildren(new Menu(1,"查看影片","searchFilm",menu1));
        menu1.Addchildren(new Menu(2,"修改影片","changeFilm",menu1));
        menu1.Addchildren(new Menu(3,"新增影片","addFilm",menu1));
        menu1.Addchildren(new Menu(4,"删除影片","deleteFilm",menu1));
        menu1.Addchildren(new Menu(5,"返回主菜单","backMain",menu1));

        Menu menu2=new Menu(2,"影厅管理","showchildren");
        menu2.Addchildren(new Menu(1,"查找影厅","searchFilmHall",menu2));
        menu2.Addchildren(new Menu(2,"修改影厅","changeFilmHall",menu2));
        menu2.Addchildren(new Menu(3,"新增影厅","addFilmHall",menu2));
        menu2.Addchildren(new Menu(4,"删除影厅","deleteFilmHall",menu2));
        menu2.Addchildren(new Menu(5,"返回主菜单","backMain",menu2));

        Menu menu3=new Menu(3,"播放计划管理","showchildren");
        menu3.Addchildren(new Menu(1,"查看计划","getPlan",menu3));
        menu3.Addchildren(new Menu(2,"修改计划","setPlan",menu3));
        menu3.Addchildren(new Menu(3,"删除计划","deletePlan",menu3));
        menu3.Addchildren(new Menu(4,"新增计划","addPlan",menu3));
        menu3.Addchildren(new Menu(5,"返回主菜单","backMain",menu3));


        Menu menu4=new Menu(4,"用户管理","showchildren");
        menu4.Addchildren(new Menu(1,"查看用户","searchUser",menu4));
        menu4.Addchildren(new Menu(2,"冻结用户","forzenUser",menu4));
        menu4.Addchildren(new Menu(3,"解冻用户","unforzenUser",menu4));
        menu4.Addchildren(new Menu(4,"查看申请","searchApply",menu4));
        menu4.Addchildren(new Menu(5,"返回主菜单","backMain",menu4));

        Menu menu5=new Menu(5,"订单管理","showchildren");
        menu5.Addchildren(new Menu(1,"查找订单","searchOrder",menu5));
        menu5.Addchildren(new Menu(2,"审核订单","judgeOrder",menu5));
        menu5.Addchildren(new Menu(3,"返回主菜单","backMain",menu5));

        Menu menu6=new Menu(6,"返回登录","backLogin");

        mannger_Menu=new Menu[]{menu1,menu2,menu3,menu4,menu5,menu6};
    }
    /*
     *展示方法
     */
    public static void showMenus(Menu[] menus) {
        Arrays.stream(menus).forEach(System.out::println);
    }
}

