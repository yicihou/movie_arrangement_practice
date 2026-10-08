package cinema.sys.starter;

import cinema.sys.action.UserAction;
import cinema.sys.menu.Menu;
import cinema.sys.menu.MenuMannager;
import cinema.sys.util.InputUtil;

import java.util.List;
import java.util.Map;

public class CinemaClient {
    //当前登录身份：false=普通用户，true=管理员（"返回主菜单"要按身份回到对应的主菜单）
    private static boolean isManager = false;

    public static void main(String[] args) {
        InterfaceMenu(MenuMannager.Login_Menu);
    }

    public static void InterfaceMenu(Menu[] menus) {
        //用 while 循环代替"方法递归"：当前菜单存在 current 里，切换菜单 = 给 current 重新赋值
        Menu[] current = menus;

        while (true) {
            //展示当前菜单
            MenuMannager.showMenus(current);
            //选择（用 current.length 作上限，避免出现 1~0 这种非法区间）
            int number = InputUtil.inputjudge("请选择菜单编号：", 1, current.length);
            Menu select = current[number - 1];

            //根据选择分发
            switch (select.getAction()) {
                case "register":
                    UserAction.register();
                    break;//注册完留在登录菜单（current 不变，循环会重新显示菜单）

                case "login": {
                    Map<String, Object> result = UserAction.login();
                    if (result == null) {//通信异常
                        System.out.println("账号或密码错误，请稍后重试");
                        break;
                    }
                    int process = (int) result.get("process");
                    if (process == 1) {
                        //登录成功：切换当前菜单（注意不是只"打印"菜单！）
                        isManager = (boolean) result.get("manager");
                        current = isManager ? MenuMannager.mannger_Menu : MenuMannager.user_Menu;
                    } else if (process == 0) {
                        System.out.println("账号或密码错误，请稍后重试");
                    } else if (process == -1) {
                        System.out.println("账号不存在，请先行注册账号后再登陆");
                    } else if (process == -2) {
                        System.out.println("账号已被冻结，请申请解冻后重试");
                    }
                    break;//★ 每个 case 都必须要 break，否则会"穿透"到下一个 case
                }

                case "showchildren": {
                    List<Menu> children = select.getChildren();
                    Menu[] childrenMenus = children.toArray(new Menu[0]);
                    if (childrenMenus.length == 0) {//防御空菜单：否则 inputjudge 会拿到 1~0 变成死循环
                        System.out.println("【该菜单暂无可用项】");
                        break;
                    }
                    current = childrenMenus;//进入子菜单
                    break;
                }

                case "backLogin":
                    isManager = false;//返回登录 = 退出登录状态
                    current = MenuMannager.Login_Menu;
                    break;

                case "backMain":
                    //回到"当前身份"的主菜单（原来回到的是上一级子菜单，是错的）
                    current = isManager ? MenuMannager.mannger_Menu : MenuMannager.user_Menu;
                    break;

                case "exit":
                    UserAction.exit();//内部会 System.exit(0)
                    return;

                default:
                    //其余还没实现的动作，给个提示，避免看起来像"卡死"
                    System.out.println("【功能尚未实现：" + select.getName() + "】");
                    break;
            }
        }
    }
}
