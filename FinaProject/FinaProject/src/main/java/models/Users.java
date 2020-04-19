package models;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

@Entity
public class Users {
    private int userId;
    private String login;
    private String password;
    private Timestamp lastLogin;
    private String userInfo;
    private Collection<ChangeHistory> changeHistoriesByUserId;
    private Collection<Packs> packsByUserId;
    private Collection<Schemes> schemesByUserId;
    private Collection<Tags> tagsByUserId;
    private Collection<Tasks> tasksByUserId;
    private OrgUnit orgUnitByOrgUnitId;

    @Id
    @Column(name = "UserId", nullable = false)
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "Login", nullable = true, length = 100)
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Basic
    @Column(name = "Password", nullable = true, length = 45)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "LastLogin", nullable = true)
    public Timestamp getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Timestamp lastLogin) {
        this.lastLogin = lastLogin;
    }

    @Basic
    @Column(name = "UserInfo", nullable = true, length = 45)
    public String getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(String userInfo) {
        this.userInfo = userInfo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Users users = (Users) o;

        if (userId != users.userId) return false;
        if (login != null ? !login.equals(users.login) : users.login != null) return false;
        if (password != null ? !password.equals(users.password) : users.password != null) return false;
        if (lastLogin != null ? !lastLogin.equals(users.lastLogin) : users.lastLogin != null) return false;
        if (userInfo != null ? !userInfo.equals(users.userInfo) : users.userInfo != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId;
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (lastLogin != null ? lastLogin.hashCode() : 0);
        result = 31 * result + (userInfo != null ? userInfo.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "usersByChangeHistoryUserId")
    public Collection<ChangeHistory> getChangeHistoriesByUserId() {
        return changeHistoriesByUserId;
    }

    public void setChangeHistoriesByUserId(Collection<ChangeHistory> changeHistoriesByUserId) {
        this.changeHistoriesByUserId = changeHistoriesByUserId;
    }

    @OneToMany(mappedBy = "usersByCreatedBy")
    public Collection<Packs> getPacksByUserId() {
        return packsByUserId;
    }

    public void setPacksByUserId(Collection<Packs> packsByUserId) {
        this.packsByUserId = packsByUserId;
    }

    @OneToMany(mappedBy = "usersByCratedBy")
    public Collection<Schemes> getSchemesByUserId() {
        return schemesByUserId;
    }

    public void setSchemesByUserId(Collection<Schemes> schemesByUserId) {
        this.schemesByUserId = schemesByUserId;
    }

    @OneToMany(mappedBy = "usersByCreatedBy")
    public Collection<Tags> getTagsByUserId() {
        return tagsByUserId;
    }

    public void setTagsByUserId(Collection<Tags> tagsByUserId) {
        this.tagsByUserId = tagsByUserId;
    }

    @OneToMany(mappedBy = "usersByCreatedBy")
    public Collection<Tasks> getTasksByUserId() {
        return tasksByUserId;
    }

    public void setTasksByUserId(Collection<Tasks> tasksByUserId) {
        this.tasksByUserId = tasksByUserId;
    }

    @ManyToOne
    @JoinColumn(name = "OrgUnitId", referencedColumnName = "OrgUnitId", nullable = false, insertable=false, updatable=false)
    public OrgUnit getOrgUnitByOrgUnitId() {
        return orgUnitByOrgUnitId;
    }

    public void setOrgUnitByOrgUnitId(OrgUnit orgUnitByOrgUnitId) {
        this.orgUnitByOrgUnitId = orgUnitByOrgUnitId;
    }
}
