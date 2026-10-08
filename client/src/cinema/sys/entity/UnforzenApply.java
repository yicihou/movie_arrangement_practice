package cinema.sys.entity;

public class UnforzenApply {
/*
解冻申请：编号，状态，原因，账号
 */
    private String id;
    private int state;
    //0：待处理 1：已通过 2：已驳回
    private String reason;
    private String username;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
