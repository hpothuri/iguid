package view.session;

import view.session.LoginBean;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
  
  public static void main(String[] args)
    throws Exception
  {
      String token = "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCIsIng1dCI6InVLOUVtMTR3S3pDd0FPMFRaNmpjRDJaMHppayIsImtpZCI6InRydXN0c2VydmljZSJ9.eyJleHAiOjE1MTEwMjM1ODQsInN1YiI6IlBBQVMuVVNFUkBTQUxJQy5DT00iLCJpc3MiOiJ3d3cub3JhY2xlLmNvbSIsInBybiI6IlBBQVMuVVNFUkBTQUxJQy5DT00iLCJpYXQiOjE1MTEwMDkxODR9.uBtWWyvY1iUUN00B74y4Ef39wInkc4RiTqOK7IXNx4oNcA3MjGpGD3WurxqSHosDvPLsEth8Fl2o1Iz5HXdm59ipzM1v8vElWuXh-tYuSv_yXqvGpY5AnYGU02UfocjT7Q5gEB5W5mVeNI9SFB0-kS_Y9oL1BKqolrgr2-C95ik5sbZNIdCrHuIlAWk_2l7726HNZ-S650FDBoibcP51IupoKMu9ZMiyTg2aldISs1iXn5yLp9xyVuT4IwZtPJ6ZCikoOuBIeHCs9SgMSSOCvPPv6KfU-Oa0Hz9Pn2YO9m5SyRPjeHb6Rw1TG3tmhiWqMoRnLc5oWDt-8VTd68LPKg";
    UserService mm = new UserService("https://eepz-test.hcm.em2.oraclecloud.com/hcmPeopleRolesV2/UserDetailsService", token);
    
    mm.findSelfUserDetails(new LoginBean());
  }
}

