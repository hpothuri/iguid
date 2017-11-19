package view.servlet;

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
    private static ADFLogger _logger = ADFLogger.createADFLogger(LoginServlet.class);

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    protected void doGet(HttpServletRequest httpServletRequest,
                         HttpServletResponse httpServletResponse) throws ServletException, IOException {
        _logger.info("doPost######START#######");

        String jwtUserToken = null;
        LoginBean loginBean = null;
        ArrayList<RolePojo> roles = null;
        
        if (loginBean == null) {
            loginBean = new LoginBean();
        }
        jwtUserToken = httpServletRequest.getParameter("jwt_tkn");
        System.err.println("jwtUserToken : " + jwtUserToken);
        _logger.info("jwtUserToken : " + jwtUserToken);
        UserService svc =
            new UserService("https://eepz-test.hcm.em2.oraclecloud.com/hcmPeopleRolesV2/UserDetailsService",
                            jwtUserToken);
        try {

            svc.findSelfUserDetails(loginBean);
            loginBean.setUserName(loginBean.getHcmUserName());
            _logger.info("UserName : " + loginBean.getUserName());
            if (loginBean.getUserName() != null) {
                roles = svc.fetchRoles("paas.user@salic.com", "Welcome@123", loginBean.getPersonId());

                if (roles != null && roles.size() > 0) {
                    _logger.info("Roles size : " + roles != null ? roles.size()+"" : "0");
                    loginBean.setAuthenticated("Y");
                    loginBean.setRoleList(roles);
                    for(RolePojo currRole : roles){
                        loginBean.getRoles().put(currRole.getRoleName(), true);
                        _logger.info("Role Name : " + currRole.getRoleName());
                    }

                    // redirect to Dashboard
                    httpServletResponse.sendRedirect("/faces/adf.task-flow?adf.tfId=Dashboard&adf.tfDoc=/WEB-INF/Dashboard.xml");
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
            httpServletResponse.sendRedirect("/ess/Error.html");
        }

        //        Gson gson = new Gson();
        //        String content = gson.toJson(loginBean);
        //        httpServletResponse.setContentType("text/json");
        //        httpServletResponse.getWriter().write(content);
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
        }
    }

}

