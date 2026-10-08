package cinema.sys.entity;

public class Order {
    //编号，影片计划（播放日期，结束日期,影厅），状态，所属用户，座位
    private String id;
    private plan plan;
    private int state;
    private User owner;
    private seat seat;

}
