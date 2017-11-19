package view.session;

public class RolePojo {
    public RolePojo() {
        super();
    }
    
    private String roleName;
    private String roleCommonName;

    public RolePojo(String roleName, String roleCommonName){
        this.roleName = roleName;
        this.roleCommonName = roleCommonName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleCommonName(String roleCommonName) {
        this.roleCommonName = roleCommonName;
    }

    public String getRoleCommonName() {
        return roleCommonName;
    }
}
