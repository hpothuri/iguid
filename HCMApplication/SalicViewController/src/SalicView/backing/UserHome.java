package SalicView.backing;

import oracle.adf.controller.TaskFlowId;
import oracle.adf.view.rich.component.rich.fragment.RichRegion;
import oracle.adf.view.rich.component.rich.layout.RichDecorativeBox;
import oracle.adf.view.rich.component.rich.layout.RichPanelGroupLayout;
import oracle.adf.view.rich.component.rich.nav.RichCommandButton;

public class UserHome {
    private String taskFlowId = "/WEB-INF/overtimeSearchBTF.xml#overtimeSearchBTF";
    private RichDecorativeBox db1;
    private RichPanelGroupLayout pgl1;
    private RichCommandButton cb1;
    private RichRegion r1;

    public TaskFlowId getDynamicTaskFlowId() {
        return TaskFlowId.parse(taskFlowId);
    }


    public void setDb1(RichDecorativeBox db1) {
        this.db1 = db1;
    }

    public RichDecorativeBox getDb1() {
        return db1;
    }

    public void setPgl1(RichPanelGroupLayout pgl1) {
        this.pgl1 = pgl1;
    }

    public RichPanelGroupLayout getPgl1() {
        return pgl1;
    }

    public void setCb1(RichCommandButton cb1) {
        this.cb1 = cb1;
    }

    public RichCommandButton getCb1() {
        return cb1;
    }


    public void setR1(RichRegion r1) {
        this.r1 = r1;
    }

    public RichRegion getR1() {
        return r1;
    }
}
