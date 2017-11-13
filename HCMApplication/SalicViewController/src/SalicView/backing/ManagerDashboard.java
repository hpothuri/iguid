package SalicView.backing;

import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.component.rich.layout.RichPanelBox;


import oracle.adf.view.rich.component.rich.layout.RichShowDetailHeader;

import org.apache.myfaces.trinidad.component.UIXGroup;

public class ManagerDashboard {
    private RichPanelBox pb3;
    private UIXGroup g1;

    private RichPanelBox pb2;
    private RichShowDetailHeader sdh1;
    private RichShowDetailHeader sdh2;
    private RichTable t1;
    private RichTable t2;


    public void setPb3(RichPanelBox pb3) {
        this.pb3 = pb3;
    }

    public RichPanelBox getPb3() {
        return pb3;
    }

    public void setG1(UIXGroup g1) {
        this.g1 = g1;
    }

    public UIXGroup getG1() {
        return g1;
    }


    public void setPb2(RichPanelBox pb2) {
        this.pb2 = pb2;
    }

    public RichPanelBox getPb2() {
        return pb2;
    }


    public void setSdh1(RichShowDetailHeader sdh1) {
        this.sdh1 = sdh1;
    }

    public RichShowDetailHeader getSdh1() {
        return sdh1;
    }


    public void setSdh2(RichShowDetailHeader sdh2) {
        this.sdh2 = sdh2;
    }

    public RichShowDetailHeader getSdh2() {
        return sdh2;
    }

    public void setT1(RichTable t1) {
        this.t1 = t1;
    }

    public RichTable getT1() {
        return t1;
    }

    public void setT2(RichTable t2) {
        this.t2 = t2;
    }

    public RichTable getT2() {
        return t2;
    }
}
