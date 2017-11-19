package view.session;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;

import view.session.LoginBean;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;

import javax.xml.namespace.QName;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPBodyElement;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Dispatch;
import javax.xml.ws.Service;
import javax.xml.ws.Service.Mode;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.soap.SOAPBinding;
import oracle.adf.share.logging.ADFLogger;

import org.json.JSONArray;
import org.json.JSONObject;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class UserService
{
  static ADFLogger logger = ADFLogger.createADFLogger(UserService.class);
  private String username;
  private String password;
  private String jwtUserToken;
  private String userServiceEndPoint;
  private String empUrl = "https://eepz-test.hcm.em2.oraclecloud.com/hcmCoreApi/resources/11.12.1.0/emps/";
  
  public UserService(String userServiceEndPoint, String username, String password)
  {
    this.username = username;
    this.password = password;
    this.userServiceEndPoint = userServiceEndPoint;
  }
  
  public UserService(String userServiceEndPoint, String jwtUserToken)
  {
    this.userServiceEndPoint = userServiceEndPoint;
    this.jwtUserToken = jwtUserToken;
  }
  
  public LoginBean findSelfUserDetails(LoginBean currentUser)
    throws Exception
  {
    try
    {
      QName serviceName = new QName("http://xmlns.oracle.com/apps/hcm/people/roles/userDetailsServiceV2/", "UserDetailsService");
      
      QName portName = new QName("http://xmlns.oracle.com/apps/hcm/people/roles/userDetailsServiceV2/", "UserDetailsServiceSoapHttpPort");
      
      Service service = Service.create(serviceName);
      
      service.addPort(portName, "http://schemas.xmlsoap.org/wsdl/soap/http", this.userServiceEndPoint);
      
      Dispatch<SOAPMessage> dispatch = service.createDispatch(portName, SOAPMessage.class, Service.Mode.MESSAGE);
      
      BindingProvider bp = dispatch;
      
      Map<String, Object> rc = bp.getRequestContext();
      rc.put("javax.xml.ws.soap.http.soapaction.use", Boolean.TRUE);
      rc.put("javax.xml.ws.soap.http.soapaction.uri", "http://xmlns.oracle.com/apps/hcm/people/roles/userDetailsServiceV2/findSelfUserDetails");
      if ((this.jwtUserToken != null) && (this.jwtUserToken.length() > 0))
      {
        String authZParameterValue = "Bearer " + this.jwtUserToken;
        
        Map<String, List<String>> authMap = new HashMap();
        List<String> authZList = new ArrayList();
        authZList.add(authZParameterValue);
        
        authMap.put("Authorization", authZList);
        rc.put("javax.xml.ws.http.request.headers", authMap);
        logger.info("AuthHeader: " + authMap);
      }
      else
      {
        rc.put("javax.xml.ws.security.auth.username", this.username);
        rc.put("javax.xml.ws.security.auth.password", this.password);
      }
      MessageFactory factory = ((SOAPBinding)bp.getBinding()).getMessageFactory();
      
      SOAPMessage request1 = factory.createMessage();
      
      SOAPHeader header = request1.getSOAPHeader();
      
      SOAPBody body = request1.getSOAPBody();
      
      QName payloadName = new QName("http://xmlns.oracle.com/apps/hcm/people/roles/userDetailsServiceV2/types/", "findSelfUserDetails", "typ");
      
      SOAPBodyElement payload = body.addBodyElement(payloadName);
      
      SOAPMessage reply = null;
      
      ByteArrayOutputStream ba = new ByteArrayOutputStream();
      request1.writeTo(ba);
      logger.info("XML Content:");
      logger.info(ba.toString());
      
      Map<String, Object> req = bp.getRequestContext();
      for (String key : req.keySet()) {
        logger.info("Key: " + key + " = " + req.get(key));
      }
      try
      {
        reply = (SOAPMessage)dispatch.invoke(request1);
      }
      catch (WebServiceException wse)
      {
        logger.severe(wse);
        throw new RuntimeException("Invalid Jwt user Token.");
      }
      Document doc = reply.getSOAPBody().extractContentAsDocument();
      
      currentUser.setPersonId(getFirstChildNodeValue(doc, "http://xmlns.oracle.com/apps/hcm/people/roles/userDetailsServiceV2/", "PersonId"));
      
      currentUser.setPersonNumber(getFirstChildNodeValue(doc, "http://xmlns.oracle.com/apps/hcm/people/roles/userDetailsServiceV2/", "PersonNumber"));
      
      currentUser.setHcmUserId(getFirstChildNodeValue(doc, "http://xmlns.oracle.com/apps/hcm/people/roles/userDetailsServiceV2/", "UserId"));
      
      currentUser.setHcmUserName(getFirstChildNodeValue(doc, "http://xmlns.oracle.com/apps/hcm/people/roles/userDetailsServiceV2/", "Username"));
      
      currentUser.setUserGUID(getFirstChildNodeValue(doc, "http://xmlns.oracle.com/apps/hcm/people/roles/userDetailsServiceV2/", "UserGUID"));
      
      currentUser.setActiveFlag(getFirstChildNodeValue(doc, "http://xmlns.oracle.com/apps/hcm/people/roles/userDetailsServiceV2/", "ActiveFlag"));
      
      currentUser.setUserDistinguishedName(getFirstChildNodeValue(doc, "http://xmlns.oracle.com/apps/hcm/people/roles/userDetailsServiceV2/", "UserDistinguishedName"));
      
      currentUser.setTitle(getFirstChildNodeValue(doc, "http://xmlns.oracle.com/apps/hcm/people/roles/userDetailsServiceV2/", "Title"));
      
      currentUser.setLastName(getFirstChildNodeValue(doc, "http://xmlns.oracle.com/apps/hcm/people/roles/userDetailsServiceV2/", "LastName"));
      
      currentUser.setFirstName(getFirstChildNodeValue(doc, "http://xmlns.oracle.com/apps/hcm/people/roles/userDetailsServiceV2/", "FirstName"));
      
      currentUser.setMiddleNames(getFirstChildNodeValue(doc, "http://xmlns.oracle.com/apps/hcm/people/roles/userDetailsServiceV2/", "MiddleNames"));
      
      currentUser.setDisplayName(getFirstChildNodeValue(doc, "http://xmlns.oracle.com/apps/hcm/people/roles/userDetailsServiceV2/", "DisplayName"));
      
      currentUser.setSuffix(getFirstChildNodeValue(doc, "http://xmlns.oracle.com/apps/hcm/people/roles/userDetailsServiceV2/", "Suffix"));
      
      currentUser.setHonors(getFirstChildNodeValue(doc, "http://xmlns.oracle.com/apps/hcm/people/roles/userDetailsServiceV2/", "Honors"));
      
      currentUser.setPreNameAdjunct(getFirstChildNodeValue(doc, "http://xmlns.oracle.com/apps/hcm/people/roles/userDetailsServiceV2/", "PreNameAdjunct"));
      
      currentUser.setKnownAs(getFirstChildNodeValue(doc, "http://xmlns.oracle.com/apps/hcm/people/roles/userDetailsServiceV2/", "KnownAs"));
      
      currentUser.setEmailAddress(getFirstChildNodeValue(doc, "http://xmlns.oracle.com/apps/hcm/people/roles/userDetailsServiceV2/", "EmailAddress"));
      
      currentUser.setPhoneId(getFirstChildNodeValue(doc, "http://xmlns.oracle.com/apps/hcm/people/roles/userDetailsServiceV2/", "PhoneId"));
      
      currentUser.setPhoneAreaCode(getFirstChildNodeValue(doc, "http://xmlns.oracle.com/apps/hcm/people/roles/userDetailsServiceV2/", "PhoneAreaCode"));
      
      currentUser.setPhoneCountryCodeNumber(getFirstChildNodeValue(doc, "http://xmlns.oracle.com/apps/hcm/people/roles/userDetailsServiceV2/", "PhoneCountryCodeNumber"));
      
      currentUser.setPhoneNumber(getFirstChildNodeValue(doc, "http://xmlns.oracle.com/apps/hcm/people/roles/userDetailsServiceV2/", "PhoneNumber"));
      
      currentUser.setLanguage(getFirstChildNodeValue(doc, "http://xmlns.oracle.com/apps/hcm/people/roles/userDetailsServiceV2/", "Language"));
      
      currentUser.setDateFormat(getFirstChildNodeValue(doc, "http://xmlns.oracle.com/apps/hcm/people/roles/userDetailsServiceV2/", "DateFormat"));
      
      currentUser.setTimeFormat(getFirstChildNodeValue(doc, "http://xmlns.oracle.com/apps/hcm/people/roles/userDetailsServiceV2/", "TimeFormat"));
      
      currentUser.setCurrency(getFirstChildNodeValue(doc, "http://xmlns.oracle.com/apps/hcm/people/roles/userDetailsServiceV2/", "Currency"));
      
      currentUser.setGroupingSeparator(getFirstChildNodeValue(doc, "http://xmlns.oracle.com/apps/hcm/people/roles/userDetailsServiceV2/", "GroupingSeparator"));
      
      currentUser.setDecimalSeparator(getFirstChildNodeValue(doc, "http://xmlns.oracle.com/apps/hcm/people/roles/userDetailsServiceV2/", "DecimalSeparator"));
      
      currentUser.setTimeZone(getFirstChildNodeValue(doc, "http://xmlns.oracle.com/apps/hcm/people/roles/userDetailsServiceV2/", "TimeZone"));
      
      currentUser.setClientEncoding(getFirstChildNodeValue(doc, "http://xmlns.oracle.com/apps/hcm/people/roles/userDetailsServiceV2/", "ClientEncoding"));
      
      currentUser.setTerritory(getFirstChildNodeValue(doc, "http://xmlns.oracle.com/apps/hcm/people/roles/userDetailsServiceV2/", "Territory"));
      
      currentUser.setFontSize(getFirstChildNodeValue(doc, "http://xmlns.oracle.com/apps/hcm/people/roles/userDetailsServiceV2/", "FontSize"));
      
      NodeList nlist = doc.getElementsByTagNameNS("http://xmlns.oracle.com/apps/hcm/people/roles/userDetailsServiceV2/", "AccessibilityMode");
      if ((nlist != null) && (nlist.getLength() > 0)) {
        if (nlist.item(0).getChildNodes().getLength() > 0)
        {
          Node n = nlist.item(0).getFirstChild();
          if (n.getNodeValue() != null) {
            currentUser.setAccessibilityMode(n.getNodeValue());
          }
        }
      }
      currentUser.setColorContrast(getFirstChildNodeValue(doc, "http://xmlns.oracle.com/apps/hcm/people/roles/userDetailsServiceV2/", "ColorContrast"));
      
      currentUser.setServerTime(getFirstChildNodeValue(doc, "http://xmlns.oracle.com/apps/hcm/people/roles/userDetailsServiceV2/", "ServerTime"));
      
      currentUser.setServerTimeForUserInfo(getFirstChildNodeValue(doc, "http://xmlns.oracle.com/apps/hcm/people/roles/userDetailsServiceV2/", "ServerTimeForMstWfLoginBean"));
      
      currentUser.setBusinessUnitId(getFirstChildNodeValue(doc, "http://xmlns.oracle.com/apps/hcm/people/roles/userDetailsServiceV2/", "BusinessUnitId"));
      
      currentUser.setBusinessUnitName(getFirstChildNodeValue(doc, "http://xmlns.oracle.com/apps/hcm/people/roles/userDetailsServiceV2/", "BusinessUnitName"));
      
      currentUser.setLegalEntityName(getFirstChildNodeValue(doc, "http://xmlns.oracle.com/apps/hcm/people/roles/userDetailsServiceV2/", "LegalEntityName"));
      
      currentUser.setPersonTypeId(getFirstChildNodeValue(doc, "http://xmlns.oracle.com/apps/hcm/people/roles/userDetailsServiceV2/", "PersonTypeId"));
      
      currentUser.setSystemPersonType(getFirstChildNodeValue(doc, "http://xmlns.oracle.com/apps/hcm/people/roles/userDetailsServiceV2/", "SystemPersonType"));
      
      currentUser.setUserPersonType(getFirstChildNodeValue(doc, "http://xmlns.oracle.com/apps/hcm/people/roles/userDetailsServiceV2/", "UserPersonType"));
      
      currentUser.setJobName(getFirstChildNodeValue(doc, "http://xmlns.oracle.com/apps/hcm/people/roles/userDetailsServiceV2/", "JobName"));
      
      currentUser.setDepartmentName(getFirstChildNodeValue(doc, "http://xmlns.oracle.com/apps/hcm/people/roles/userDetailsServiceV2/", "DepartmentName"));
      
      currentUser.setLocationTownOrCity(getFirstChildNodeValue(doc, "http://xmlns.oracle.com/apps/hcm/people/roles/userDetailsServiceV2/", "LocationTownOrCity"));
      
      currentUser.setLocationPostalCode(getFirstChildNodeValue(doc, "http://xmlns.oracle.com/apps/hcm/people/roles/userDetailsServiceV2/", "LocationPostalCode"));
      
      currentUser.setLocationCountry(getFirstChildNodeValue(doc, "http://xmlns.oracle.com/apps/hcm/people/roles/userDetailsServiceV2/", "LocationCountry"));
      
      return currentUser;
    }
    catch (Exception ue)
    {
        logger.info("Error while calling self user: " + ue.getMessage());
      throw ue;
    }
  }
  
  private String getFirstChildNodeValue(Document doc, String namespaceURI, String namespaceLocalName)
  {
    logger.info(getClass().getName() + " : getFirstChildNodeValue (namespaceURI: '" + namespaceURI + "' - namespaceLocalName: '" + namespaceLocalName + "')");
    
    String nodeValue = null;
    if (doc != null)
    {
      NodeList nlist = doc.getElementsByTagNameNS(namespaceURI, namespaceLocalName);
      if ((nlist != null) && (nlist.getLength() > 0)) {
        if (nlist.item(0).getChildNodes().getLength() > 0)
        {
          Node n = nlist.item(0).getFirstChild();
          if (n.getNodeValue() != null) {
            nodeValue = nlist.item(0).getFirstChild().getNodeValue();
          }
        }
      }
    }
    logger.info("nodeValue=" + nodeValue);
    
    return nodeValue;
  }

    public ArrayList<RolePojo> fetchRoles(String username, String password, String personId) {
        logger.info("personId : " + personId);
        ArrayList<RolePojo> roles = new ArrayList<RolePojo>();
        try {
            HttpResponse<JsonNode> output =
                RestHelper.invokeJsonRequestViaUnirestClient(username, password, null,
                                                             empUrl + "?q=PersonId=" + personId, "REST_SERVICE_GET",
                                                             "application/json", null, true);
            
            logger.info("Rest response : " + output);
            
            String href = null;
            if (output != null) {
                JsonNode body = output.getBody();
                JSONObject object = body.getObject();
                JSONArray items = object.getJSONArray("items");
                for (int i = 0; i < items.length(); i++) {
                    JSONObject currItem = items.getJSONObject(i);
                    JSONArray links = currItem.getJSONArray("links");
                    for (int j = 0; j < links.length(); j++) {
                        JSONObject currObject = links.getJSONObject(j);
                        if (currObject.getString("name").equalsIgnoreCase("roles")) {
                            href = currObject.getString("href");
                        }
                    }
                }

                String roleRestUrl = href + "?onlyData=true&limit=1000&fields=RoleName,RoleCommonName";
                output =
                    RestHelper.invokeJsonRequestViaUnirestClient(username, password, null, roleRestUrl,
                                                                 "REST_SERVICE_GET", "application/json", null, true);
                
                logger.info("Rest response : " + output);
                
                if (output != null) {
                    body = output.getBody();
                    object = body.getObject();
                    items = object.getJSONArray("items");
                    for (int i = 0; i < items.length(); i++) {
                        JSONObject item = items.getJSONObject(i);
                        String roleName = item.getString("RoleName");
                        String roleCommonName = item.getString("RoleCommonName");
                        RolePojo role = new RolePojo(roleName, roleCommonName);
                        roles.add(role);
                    }
                }
            }

        } catch (Exception e) {
            logger.info("Error while calling rest service for roles : " + e.getMessage());
            e.printStackTrace();
        }
        return roles;
    }
  
//    https://eepz-test.hcm.em2.oraclecloud.com/hcmCoreApi/resources/11.12.1.0/emps/?q=PersonId=300000009808202
//  https://eepz-test.hcm.em2.oraclecloud.com:443/hcmCoreApi/resources/11.12.1.0/emps/00020000000EACED00057708000110D93204694A0000004AACED00057372000D6A6176612E73716C2E4461746514FA46683F3566970200007872000E6A6176612E7574696C2E44617465686A81014B597419030000787077080000015FCC6CC00078/child/roles?onlyData=true&limit=1000&fields=RoleName,RoleCommonName
  
  public static void main(String[] args) throws Exception
  {
      String token = "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCIsIng1dCI6InVLOUVtMTR3S3pDd0FPMFRaNmpjRDJaMHppayIsImtpZCI6InRydXN0c2VydmljZSJ9.eyJleHAiOjE1MTExMDUzODksInN1YiI6IlBBQVMuVVNFUkBTQUxJQy5DT00iLCJpc3MiOiJ3d3cub3JhY2xlLmNvbSIsInBybiI6IlBBQVMuVVNFUkBTQUxJQy5DT00iLCJpYXQiOjE1MTEwOTA5ODl9.q_PDpudBqo04NPA6fWvSFX2GAFpEOiWP3E48xhshVDQ_Fz-A2tPfOdy9oEHdxlgmYwfLiFfAJ_Kih9R4UgEkcssWTPs5xxDsF70eIBjWveUUo_d9qi54B-utVN4OEMKSli-bMglkuPZEkjRLEwXyrFBOxf_28h68J17mNIlkxSpF9VdI5RoZ7vbkHc2hukIL2xqgAxyKuLDTYwnPlvgHszGLA_0Fkwvkpufcq-9NWQ2RDW1ak3FxtA-ruwemxrVsgE7RWZpA0vU5MM31PvxrehKiAQbDhZ5oGzGb9WZzqSIKzwngnEIyrYQlgd6UbtyOWb31FbWBzYHdpKD_9HjcAQ";
    UserService mm = new UserService("https://eepz-test.hcm.em2.oraclecloud.com/hcmPeopleRolesV2/UserDetailsService", token);
      LoginBean loginBean  = null;
      loginBean =   mm.findSelfUserDetails(new LoginBean());
//      UserService serv = new UserService(null, "paas.user@salic.com", "Welcome@123");
      //"300000009808202"
      List<RolePojo> roles = mm.fetchRoles("paas.user@salic.com", "Welcome@123", loginBean.getPersonId());
      
      for(RolePojo role : roles)
       System.err.println(role.getRoleName());
  }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }
}

