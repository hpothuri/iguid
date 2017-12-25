package view.servlet;

import SalicView.backing.Utils.ADFUtils;

import com.google.gson.Gson;

import view.session.UserService;

import java.io.IOException;
import java.io.PrintWriter;

import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import oracle.adf.share.logging.ADFLogger;

import org.json.JSONObject;

import view.session.LoginBean;
import view.session.RolePojo;

public class LoginServlet extends HttpServlet {
    @SuppressWarnings("compatibility:-5529223165066085645")
    private static final long serialVersionUID = 1L;
    private static final String CONTENT_TYPE = "text/html; charset=UTF-8";
    private static final String DASHBOARD_URL =
        "/ess/faces/adf.task-flow?adf.tfId=Dashboard&adf.tfDoc=/WEB-INF/Dashboard.xml";
    private static final String OVERTIME_URL = "/ess/faces/pages/OvertimeRequest.jsf";
    private static final String HOUSING_ADVANCE_URL = "/ess/faces/pages/HousingAdvance.jsf";
    private static final String APPROVAL_GROUP_URL = "/ess/faces/pages/ApprovalGroup.jsf";
    private static final String APPROVAL_SETUP_URL = "/ess/faces/pages/ApprovalSetup.jsf";
    private static final String BUSINESS_TRIP_URL = "/ess/faces/pages/BusinessTrip.jsf";
    private static final String BUSINESS_TRIP_COMPLETION_URL = "/ess/faces/pages/BusinessTripCompletion.jsf";
    private static final String EDUCATION_ALLOWANCE_URL = "/ess/faces/pages/EducationAllowance.jsf";
    private static final String EMPLOYEE_DASHBOARD_URL = "/ess/faces/pages/EmployeeDashboard.jsf";
    private static final String HR_ADMIN_DASHBOARD_URL = "/ess/faces/pages/HRAdminDashboard.jsf";
    private static final String HR_LETTER_URL = "/ess/faces/pages/HRLetter.jsf";
    private static final String LOOKUP_URL = "/ess/faces/pages/LookUp.jsf";
    private static final String MANAGER_DASHBOARD_URL = "/ess/faces/pages/ManagerDashboard.jsf";
    private static final String MENU_URL = "/ess/faces/pages/Menu.jsf";
    private static final String MENU_ACCESS_URL = "/ess/faces/pages/MenuAccess.jsf";
    private static final String NOTIFICATION_URL = "/ess/faces/pages/Notification.jsf";
    private static final String PAYROLL_DASHBOARD_URL = "/ess/faces/pages/PayRollDashboard.jsf";
    private static final String REPORT_URL = "/ess/faces/pages/Report.jsf";
    private static final String SALARY_IN_ADVANCE_URL = "/ess/faces/pages/SalaryInAdvance.jsf";
    private static final String SETUP_URL = "/ess/faces/pages/Setup.jsf";
    private static final String VACATION_ALLOWANCE_URL = "/ess/faces/pages/VacationAllowance.jsf";
    private static ADFLogger _logger = ADFLogger.createADFLogger(LoginServlet.class);

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    protected void doGet(HttpServletRequest httpServletRequest,
                         HttpServletResponse httpServletResponse) throws ServletException, IOException {
        _logger.info("doGet######START#######");
        System.out.println("doGet######START#######");
        String jwtUserToken = null;
        String pageName = null;
        LoginBean loginBean = (LoginBean) httpServletRequest.getSession().getAttribute("loginBean");
        ; //ADFUtils.evaluateEL("#{loginBean}");

        jwtUserToken = httpServletRequest.getParameter("jwt_tkn");
        pageName = httpServletRequest.getParameter("pageName");
        System.err.println("jwtUserToken : " + jwtUserToken);
        System.err.println("pageName : " + pageName);

        if (loginBean == null) {

            loginBean = new LoginBean();

            redirectToPage(loginBean, jwtUserToken, pageName, httpServletRequest, httpServletResponse);

            // login bean already exists
        } else {

            // token dint change
            if (jwtUserToken.equals(loginBean.getJwtToken())) {
                System.err.println("Redirecting to page - jwt didnt change" + pageName);
                httpServletResponse.sendRedirect(fetchPageURL(pageName));

            } else {
                // if same user
                if (loginBean.getUserName().equalsIgnoreCase(getUsernameFromJwt(jwtUserToken))) {
                    System.err.println("Redirecting to page - same user accessing app " + pageName);
                    httpServletResponse.sendRedirect(fetchPageURL(pageName));
                } else {
                    loginBean = new LoginBean();

                    redirectToPage(loginBean, jwtUserToken, pageName, httpServletRequest, httpServletResponse);
                }
            }
        }

        _logger.info("doPost######END#######");
    }

    private void raiseException(LoginBean loginBean, String msg, Exception exp) {
        loginBean.setUserName(null);
        loginBean.setPassword(null);
        loginBean.setAuthenticated("N");
        if (exp == null) {
            loginBean.setError(msg);
        } else {
            loginBean.setError(msg + ".Exception Details : " + exp.getMessage());
            _logger.info("Error while populating login bean: " + exp.getMessage());
            System.err.println(msg + ".Exception Details : " + exp.getMessage());
        }
    }

    private String fetchPageURL(String pageName) {
        if ("OVERTIME".equals(pageName))
            return OVERTIME_URL;
        else if ("APPROVAL_GROUP".equals(pageName))
            return APPROVAL_GROUP_URL;
        else if ("APPROVAL_SETUP".equals(pageName))
            return APPROVAL_SETUP_URL;
        else if ("BUSINESS_TRIP".equals(pageName))
            return BUSINESS_TRIP_URL;
        else if ("BUSINESS_TRIP_COMPLETION".equals(pageName))
            return BUSINESS_TRIP_COMPLETION_URL;
        else if ("EDUCATION_ALLOWANCE".equals(pageName))
            return EDUCATION_ALLOWANCE_URL;
        else if ("EMPLOYEE_DASHBOARD".equals(pageName))
            return EMPLOYEE_DASHBOARD_URL;
        else if ("HOUSING_ADVANCE".equals(pageName))
            return HOUSING_ADVANCE_URL;
        else if ("HR_ADMIN_DASHBOARD".equals(pageName))
            return HR_ADMIN_DASHBOARD_URL;
        else if ("HR_LETTER".equals(pageName))
            return HR_LETTER_URL;
        else if ("LOOKUP".equals(pageName))
            return LOOKUP_URL;
        else if ("MANAGER_DASHBOARD".equals(pageName))
            return MANAGER_DASHBOARD_URL;
        else if ("MENU".equals(pageName))
            return MENU_URL;
        else if ("MENU_ACCESS".equals(pageName))
            return MENU_ACCESS_URL;
        else if ("NOTIFICATION".equals(pageName))
            return NOTIFICATION_URL;
        else if ("PAYROLL_DASHBOARD".equals(pageName))
            return PAYROLL_DASHBOARD_URL;
        else if ("REPORT".equals(pageName))
            return REPORT_URL;
        else if ("SALARY".equals(pageName))
            return SALARY_IN_ADVANCE_URL;
        else if ("SETUP".equals(pageName))
            return SETUP_URL;
        else if ("VACATION_ALLOWANCE".equals(pageName))
            return VACATION_ALLOWANCE_URL;
        else
            return DASHBOARD_URL;
    }

    private void redirectToPage(LoginBean loginBean, String jwtUserToken, String pageName,
                                HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        ArrayList<RolePojo> roles = null;
        UserService svc =
            new UserService("https://eepz-test.hcm.em2.oraclecloud.com/hcmPeopleRolesV2/UserDetailsService",
                            jwtUserToken);
        try {

            svc.findSelfUserDetails(loginBean);
            loginBean.setUserName(loginBean.getHcmUserName());
            _logger.info("UserName : " + loginBean.getUserName());
            System.err.println("UserName : " + loginBean.getUserName());
            if (loginBean.getUserName() != null) {
                roles = svc.fetchRoles("paas.user@salic.com", "Welc@me123", loginBean.getPersonId());

                if (roles != null && roles.size() > 0) {
                    _logger.info("Roles size : " + roles != null ? roles.size() + "" : "0");
                    System.err.println("Roles size : " + roles != null ? roles.size() + "" : "0");
                    loginBean.setAuthenticated("Y");
                    loginBean.setRoleList(roles);
                    for (RolePojo currRole : roles) {
                        loginBean.getRoles().put(currRole.getRoleCommonName(), true);
                        _logger.info("Role Name : " + currRole.getRoleName());
                        System.err.println("Role Code : " + currRole.getRoleCommonName());
                    }

                    // redirect to corresponding page
                    System.err.println("Redirecting to page " + pageName);
                    httpServletRequest.getSession().setAttribute("loginBean", loginBean);
                    httpServletResponse.sendRedirect(fetchPageURL(pageName));
                } else {

                    raiseException(loginBean, "User doesn't sufficient roles to access the application.", null);

                    loginBean.setAuthenticated("N");

                    // redirect to Error
                    httpServletResponse.sendRedirect("/ess/Error.html");
                }
            } else {
                raiseException(loginBean, "User doesn't sufficient roles to access the application.", null);

                loginBean.setAuthenticated("N");

                // redirect to Error
                httpServletResponse.sendRedirect("/ess/Error.html");
            }
        } catch (Exception exp) {
            raiseException(loginBean, "Failure in JWT token validation", exp);

            // redirect to Error
            try {
                httpServletResponse.sendRedirect("/ess/Error.html");
            } catch (Exception e) {
                raiseException(loginBean, "Unknown exception : " + e.getMessage(), null);

            }
        }
    }

    private String getUsernameFromJwt(String jwt) {
        String[] splitJwt = getDecodedJwt(jwt);

        JSONObject json = new JSONObject(splitJwt[1]);
        System.out.println("Username from JWT : " + json.getString("sub"));
        return json.getString("sub");
    }

    private String[] getDecodedJwt(String jwt) {
        String[] result = new String[2];
        String[] parts = jwt.split("[.]");
        try {
            int index = 0;
            for (String part : parts) {
                if (index > 1)
                    break;
                byte[] partAsBytes = part.getBytes("UTF-8");
                String decodedPart = new String(java.util
                                                    .Base64
                                                    .getUrlDecoder()
                                                    .decode(partAsBytes), "UTF-8");
                result[index] = decodedPart;
                index++;
            }
        } catch (Exception e) {
            result = null;
        }
        return result;
    }
}

