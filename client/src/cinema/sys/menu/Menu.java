package cinema.sys.menu;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    //编号
    private int order;
    //名称
    private String name;
    //行为
    private String action;
    //子菜单
    private List<Menu> children=new ArrayList<>();
    //父菜单(唯一)
    private  Menu parent;

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public List<Menu> getChildren() {
        return children;
    }

    public void setChildren(List<Menu> children) {
        this.children = children;
    }

    public Menu getParent() {
        return parent;
    }

    public void setParent(Menu parent) {
        this.parent = parent;
    }

    public Menu(int order, String name, String action) {
        this(order,name,action,null);
    }

    public Menu(List<Menu> children, String action, String name, int order) {
        this.children = children;
        this.action = action;
        this.name = name;
        this.order = order;
    }

    public Menu(int order, String name, String action, Menu parent) {
        this.order = order;
        this.name = name;
        this.action = action;
        this.parent = parent;
    }

    public Menu(int order, String name, String action, List<Menu> children, Menu parent) {
        this.order = order;
        this.name = name;
        this.action = action;
        this.children = children;
        this.parent = parent;
    }

    public void Addchildren(Menu child){
        children.add(child);
    }

    @Override
    public String toString() {
        return order+"."+name;
    }
}
