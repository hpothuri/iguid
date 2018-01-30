package SalicView.backing;

import java.io.Serializable;

public class RequestStatusPSB implements Serializable {
    @SuppressWarnings("compatibility:3634376635860854492")
    private static final long serialVersionUID = 1L;

private String reqNumber;

    public RequestStatusPSB() {
        super();
    }

    public void setReqNumber(String reqNumber) {
        this.reqNumber = reqNumber;
    }

    public String getReqNumber() {
        return reqNumber;
    }
}
