package view.session;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LoginBean {
    public LoginBean() {
        super();
    }
    
    private String userName = null;
     private String password = null;
     private String authenticated = null;
     private String error = null;
     private String redirecturl = null;
     private String personId = "300000001213289";//"300000006572107";//= "300000003699668";//"300000001213289";//"300000001092092";// = "300000005807455";//300000004716289";//300000006572107";
     private String personNumber;
     private String hcmUserId;
     private String hcmUserName;
     private String userGUID;
     private String activeFlag;
     private String userDistinguishedName;
     private String title;
     private String lastName;
     private String firstName;
     private String middleNames;
     private String displayName;
     private String suffix;
     private String honors;
     private String preNameAdjunct;
     private String knownAs;
     private String emailAddress;
     private String phoneId;
     private String phoneAreaCode;
     private String phoneCountryCodeNumber;
     private String phoneNumber;
     private String language;
     private String dateFormat;
     private String timeFormat;
     private String currency;
     private String groupingSeparator;
     private String decimalSeparator;
     private String timeZone;
     private String clientEncoding;
     private String territory;
     private String fontSize;
     private String accessibilityMode;
     private String colorContrast;
     private String serverTime;
     private String serverTimeForUserInfo;
     private String businessUnitId;
     private String businessUnitName;
     private String legalEntityName;
     private String personTypeId;
     private String systemPersonType;
     private String userPersonType;
     private String jobName;
     private String departmentName;
     private String locationTownOrCity;
     private String locationPostalCode;
     private String locationCountry;
     private Map<String,Boolean> roles = new HashMap<String,Boolean>();
     private List<RolePojo> roleList;
     private String jwtToken;


    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setAuthenticated(String authenticated) {
        this.authenticated = authenticated;
    }

    public String getAuthenticated() {
        return authenticated;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getError() {
        return error;
    }

    public void setRedirecturl(String redirecturl) {
        this.redirecturl = redirecturl;
    }

    public String getRedirecturl() {
        return redirecturl;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonNumber(String personNumber) {
        this.personNumber = personNumber;
    }

    public String getPersonNumber() {
        return personNumber;
    }

    public void setHcmUserId(String hcmUserId) {
        this.hcmUserId = hcmUserId;
    }

    public String getHcmUserId() {
        return hcmUserId;
    }

    public void setHcmUserName(String hcmUserName) {
        this.hcmUserName = hcmUserName;
    }

    public String getHcmUserName() {
        return hcmUserName;
    }

    public void setUserGUID(String userGUID) {
        this.userGUID = userGUID;
    }

    public String getUserGUID() {
        return userGUID;
    }

    public void setActiveFlag(String activeFlag) {
        this.activeFlag = activeFlag;
    }

    public String getActiveFlag() {
        return activeFlag;
    }

    public void setUserDistinguishedName(String userDistinguishedName) {
        this.userDistinguishedName = userDistinguishedName;
    }

    public String getUserDistinguishedName() {
        return userDistinguishedName;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setMiddleNames(String middleNames) {
        this.middleNames = middleNames;
    }

    public String getMiddleNames() {
        return middleNames;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setHonors(String honors) {
        this.honors = honors;
    }

    public String getHonors() {
        return honors;
    }

    public void setPreNameAdjunct(String preNameAdjunct) {
        this.preNameAdjunct = preNameAdjunct;
    }

    public String getPreNameAdjunct() {
        return preNameAdjunct;
    }

    public void setKnownAs(String knownAs) {
        this.knownAs = knownAs;
    }

    public String getKnownAs() {
        return knownAs;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setPhoneId(String phoneId) {
        this.phoneId = phoneId;
    }

    public String getPhoneId() {
        return phoneId;
    }

    public void setPhoneAreaCode(String phoneAreaCode) {
        this.phoneAreaCode = phoneAreaCode;
    }

    public String getPhoneAreaCode() {
        return phoneAreaCode;
    }

    public void setPhoneCountryCodeNumber(String phoneCountryCodeNumber) {
        this.phoneCountryCodeNumber = phoneCountryCodeNumber;
    }

    public String getPhoneCountryCodeNumber() {
        return phoneCountryCodeNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getLanguage() {
        return language;
    }

    public void setDateFormat(String dateFormat) {
        this.dateFormat = dateFormat;
    }

    public String getDateFormat() {
        return dateFormat;
    }

    public void setTimeFormat(String timeFormat) {
        this.timeFormat = timeFormat;
    }

    public String getTimeFormat() {
        return timeFormat;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getCurrency() {
        return currency;
    }

    public void setGroupingSeparator(String groupingSeparator) {
        this.groupingSeparator = groupingSeparator;
    }

    public String getGroupingSeparator() {
        return groupingSeparator;
    }

    public void setDecimalSeparator(String decimalSeparator) {
        this.decimalSeparator = decimalSeparator;
    }

    public String getDecimalSeparator() {
        return decimalSeparator;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public void setClientEncoding(String clientEncoding) {
        this.clientEncoding = clientEncoding;
    }

    public String getClientEncoding() {
        return clientEncoding;
    }

    public void setTerritory(String territory) {
        this.territory = territory;
    }

    public String getTerritory() {
        return territory;
    }

    public void setFontSize(String fontSize) {
        this.fontSize = fontSize;
    }

    public String getFontSize() {
        return fontSize;
    }

    public void setAccessibilityMode(String accessibilityMode) {
        this.accessibilityMode = accessibilityMode;
    }

    public String getAccessibilityMode() {
        return accessibilityMode;
    }

    public void setColorContrast(String colorContrast) {
        this.colorContrast = colorContrast;
    }

    public String getColorContrast() {
        return colorContrast;
    }

    public void setServerTime(String serverTime) {
        this.serverTime = serverTime;
    }

    public String getServerTime() {
        return serverTime;
    }

    public void setServerTimeForUserInfo(String serverTimeForUserInfo) {
        this.serverTimeForUserInfo = serverTimeForUserInfo;
    }

    public String getServerTimeForUserInfo() {
        return serverTimeForUserInfo;
    }

    public void setBusinessUnitId(String businessUnitId) {
        this.businessUnitId = businessUnitId;
    }

    public String getBusinessUnitId() {
        return businessUnitId;
    }

    public void setBusinessUnitName(String businessUnitName) {
        this.businessUnitName = businessUnitName;
    }

    public String getBusinessUnitName() {
        return businessUnitName;
    }

    public void setLegalEntityName(String legalEntityName) {
        this.legalEntityName = legalEntityName;
    }

    public String getLegalEntityName() {
        return legalEntityName;
    }

    public void setPersonTypeId(String personTypeId) {
        this.personTypeId = personTypeId;
    }

    public String getPersonTypeId() {
        return personTypeId;
    }

    public void setSystemPersonType(String systemPersonType) {
        this.systemPersonType = systemPersonType;
    }

    public String getSystemPersonType() {
        return systemPersonType;
    }

    public void setUserPersonType(String userPersonType) {
        this.userPersonType = userPersonType;
    }

    public String getUserPersonType() {
        return userPersonType;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getJobName() {
        return jobName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setLocationTownOrCity(String locationTownOrCity) {
        this.locationTownOrCity = locationTownOrCity;
    }

    public String getLocationTownOrCity() {
        return locationTownOrCity;
    }

    public void setLocationPostalCode(String locationPostalCode) {
        this.locationPostalCode = locationPostalCode;
    }

    public String getLocationPostalCode() {
        return locationPostalCode;
    }

    public void setLocationCountry(String locationCountry) {
        this.locationCountry = locationCountry;
    }

    public String getLocationCountry() {
        return locationCountry;
    }

    public void setRoleList(List<RolePojo> roleList) {
        this.roleList = roleList;
    }

    public List<RolePojo> getRoleList() {
        return roleList;
    }

    public void setRoles(Map<String, Boolean> roles) {
        this.roles = roles;
    }

    public Map<String, Boolean> getRoles() {
        return roles;
    }

    public void setJwtToken(String jwtToken) {
        this.jwtToken = jwtToken;
    }

    public String getJwtToken() {
        return jwtToken;
    }
}
