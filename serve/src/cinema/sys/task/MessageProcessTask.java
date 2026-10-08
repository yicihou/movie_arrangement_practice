package cinema.sys.task;

import cinema.sys.entity.User;
import cinema.sys.menu.MenuMannager;
import cinema.sys.message.message;
import cinema.sys.util.FileUtil;
import cinema.sys.util.SocketUtil;

import java.net.Socket;
import java.util.*;

public class MessageProcessTask implements Runnable {
    private Socket client;

    public MessageProcessTask(Socket client) {
        this.client = client;
    }

    @Override
    public void run() {
        message mag = SocketUtil.receiveMessage(client);
        if (mag == null) {
            return;
        }
        System.out.println(mag);
        //根据 action 分发到对应处理逻辑
        switch (mag.getAction()) {
            case "register":
                registerApply(mag);
                break;
            //后续的登录、找回密码、申请解冻等请求在此继续扩展
            case "login":
                loginApply(mag);
                break;
            default:
                System.out.println("未知请求：" + mag.getAction());
                break;
        }
    }

    /*
     *注册请求
     */
    private void registerApply(message msg) {
        //接收信息
        User newRegister = (User) msg.getData();
        //获取文档中的用户
        List<User> userStorage = FileUtil.ReaderData(FileUtil.USER_FILE);
        //判断是否存在同名用户（username 唯一）
        boolean exist = userStorage.stream()
                .anyMatch(user -> user.getUsername().equals(newRegister.getUsername()));
        if (exist) {
            //账号已存在
            SocketUtil.sendBack(client, -1);
            return;
        }
        //写入文档
        userStorage.add(newRegister);
        boolean success = FileUtil.saveData(userStorage, FileUtil.USER_FILE);
        //1：注册成功  0：保存失败  -1：账号已注册
        SocketUtil.sendBack(client, success ? 1 : 0);
    }

    /*
     *登录请求
     */
    private void loginApply(message msg) {
        //接收信息
        User loginUser = (User) msg.getData();
        //获取文档中的用户
        List<User> userStorage = FileUtil.ReaderData(FileUtil.USER_FILE);
        if(userStorage.isEmpty()){//文档为空，初始化管理员
            User user=new User("CYXXSJY","admin","123123");
            user.setRole(1);//设置为管理员
            user.setState(0);//0：正常状态（与 User 里的注释保持一致）
            userStorage.add(user);
            //★关键：必须写回文件，否则管理员只存在于本次请求的内存里，下次请求就"消失"了
            FileUtil.saveData(userStorage, FileUtil.USER_FILE);
        }
        //用集合接收
        Map<String, Object> result = new HashMap<>();
        //查看账户是否存在
        Optional<User> opt = userStorage.stream()
                .filter(user -> user.getUsername().equals(loginUser.getUsername()))
                .findFirst();
        if(opt.isPresent()) {//存在
            User user = opt.get();//取出来
            int state = user.getState();
            //检验密码
            if (loginUser.getPassword().equals(user.getPassword())) {
                if (state == 0) {//状态正常
                    result.put("process", 1);
                    result.put("manager", user.isManager());
                } else{//账号冻结
                    result.put("process",-2);
                }
            }else {//密码错误
                result.put("process",0);
            }
        }else {//账号不存在
           result.put("process",-1);
            }
        SocketUtil.sendBack(client,result);
        }

    /*
    *
     */

    /*
    *
     */

}
