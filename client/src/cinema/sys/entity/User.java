package cinema.sys.entity;

import java.io.Serializable;

public class User implements Serializable {
    /*
    账号，密码，安全码，状态，角色
     */
    private String safeid;
    private String username;//唯一
    private String password;
    private int state=0;//0，正常 1，冻结
    private int role=0;//0 用户 1 管理员

    public String getSafeid() {
        return safeid;
    }

    public void setSafeid(String safeid) {
        this.safeid = safeid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public boolean isManager(){
        if(role==1){
            return true;
        }
        return false;
    }

    public User(String safeid, String username, String password) {
        this.safeid = safeid;
        this.username = username;
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", state=" + state +
                ", role=" + role +
                '}';
    }
}
