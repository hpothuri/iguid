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

import view.session.LoginBean;
import view.session.RolePojo;

public class LoginServlet extends HttpServlet {
    @SuppressWarnings("compatibility:-5529223165066085645")
    private static final long serialVersionUID = 1L;
    private static final String CONTENT_TYPE = "text/html; charset=UTF-8";
    private static final String DASHBOARD_URL = "/ess/faces/adf.task-flow?adf.tfId=Dashboard&adf.tfDoc=/WEB-INF/Dashboard.xml";
    private static final String OVERTIME_URL = "/ess/faces/pages/OvertimeRequest.jsf";
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
        LoginBean loginBean = (LoginBean)httpServletRequest.getSession().getAttribute("loginBean");;//ADFUtils.evaluateEL("#{loginBean}");
                   
        jwtUserToken = httpServletRequest.getParameter("jwt_tkn");
        pageName = httpServletRequest.getParameter("pageName");
        System.err.println("jwtUserToken : " + jwtUserToken);
        System.err.println("pageName : " + pageName);
       
        if (loginBean == null) {
            
            loginBean = new LoginBean();
            
            redirectToPage(loginBean,jwtUserToken,pageName,httpServletRequest,httpServletResponse);
        
        // login bean already exists
        } else {
            
            // token dint change
            if(jwtUserToken.equals(loginBean.getJwtToken())) {
                System.err.println("Redirecting to page " + pageName);
                httpServletResponse.sendRedirect(fetchPageURL(pageName));
            
            } else {
                loginBean = new LoginBean();
                
                redirectToPage(loginBean,jwtUserToken,pageName,httpServletRequest,httpServletResponse);
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
        if("OVERTIME".equals(pageName))
            return OVERTIME_URL;
        else
            return DASHBOARD_URL;
    }

    private void redirectToPage(LoginBean loginBean,String jwtUserToken,String pageName, HttpServletRequest httpServletRequest,
                         HttpServletResponse httpServletResponse) {
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
                roles = svc.fetchRoles("paas.user@salic.com", "Welcome@123", loginBean.getPersonId());

                if (roles != null && roles.size() > 0) {
                    _logger.info("Roles size : " + roles != null ? roles.size()+"" : "0");
                    System.err.println("Roles size : " + roles != null ? roles.size()+"" : "0");
                    loginBean.setAuthenticated("Y");
                    loginBean.setRoleList(roles);
                    for(RolePojo currRole : roles){
                        loginBean.getRoles().put(currRole.getRoleCommonName(), true);
                        _logger.info("Role Name : " + currRole.getRoleName());
                        System.err.println("Role Code : " + currRole.getRoleCommonName());
                    }

                    // redirect to corresponding page
                    System.err.println("Redirecting to page " + pageName);
                    httpServletRequest.getSession().setAttribute("loginBean",loginBean);
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
            } catch(Exception e){
                raiseException(loginBean, "Unknown exception : "+ e.getMessage(), null);

            }
        }
    }
}

