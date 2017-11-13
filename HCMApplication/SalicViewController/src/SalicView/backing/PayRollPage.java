package SalicView.backing;

import SalicView.backing.Utils.ADFUtils;

import javax.faces.event.ActionEvent;

import oracle.jbo.ViewCriteria;
import oracle.jbo.ViewObject;
import oracle.jbo.server.ViewObjectImpl;

public class PayRollPage {
    public void onClickFilterTotalStatus(ActionEvent actionEvent) {
        filterPayRollDashboardStatus(null);
    }

    public void onClickFilterPendingStatus(ActionEvent actionEvent) {
        filterPayRollDashboardStatus("Draft");
    }

    public void filterPayRollDashboardStatus(String statusVal) {
        ViewObject employeeVO =
            ADFUtils.findIterator("payRollObjROVO1Iterator").getViewObject();
        ViewObjectImpl employeeVOImpl =
            (ViewObjectImpl)employeeVO.getViewObject();
        ViewCriteria employeeVC =
            employeeVOImpl.getViewCriteria("findByPayStatus");
        employeeVO.applyViewCriteria(employeeVC);
        employeeVO.setNamedWhereClauseParam("BV_PAY_STATUS", statusVal);
        employeeVO.executeQuery();
    }

    public void onClickFilterCompletedStatus(ActionEvent actionEvent) {
        filterPayRollDashboardStatus("COMPLETED");
    }

    public void onClickFilterErrorStatus(ActionEvent actionEvent) {
        filterPayRollDashboardStatus("Error");
    }

    public void onClickFilterInProgressStatus(ActionEvent actionEvent) {
        filterPayRollDashboardStatus("InProgress");
    }
}
