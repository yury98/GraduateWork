package model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class OrgUnit {
    private int orgUnitId;
    private String orgUnitFullName;
    private String orgUnitShartName;

    @Id
    @Column(name = "OrgUnitId", nullable = false)
    public int getOrgUnitId() {
        return orgUnitId;
    }

    public void setOrgUnitId(int orgUnitId) {
        this.orgUnitId = orgUnitId;
    }

    @Basic
    @Column(name = "OrgUnitFullName", nullable = true, length = 100)
    public String getOrgUnitFullName() {
        return orgUnitFullName;
    }

    public void setOrgUnitFullName(String orgUnitFullName) {
        this.orgUnitFullName = orgUnitFullName;
    }

    @Basic
    @Column(name = "OrgUnitShartName", nullable = true, length = 30)
    public String getOrgUnitShartName() {
        return orgUnitShartName;
    }

    public void setOrgUnitShartName(String orgUnitShartName) {
        this.orgUnitShartName = orgUnitShartName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrgUnit orgUnit = (OrgUnit) o;

        if (orgUnitId != orgUnit.orgUnitId) return false;
        if (orgUnitFullName != null ? !orgUnitFullName.equals(orgUnit.orgUnitFullName) : orgUnit.orgUnitFullName != null)
            return false;
        if (orgUnitShartName != null ? !orgUnitShartName.equals(orgUnit.orgUnitShartName) : orgUnit.orgUnitShartName != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = orgUnitId;
        result = 31 * result + (orgUnitFullName != null ? orgUnitFullName.hashCode() : 0);
        result = 31 * result + (orgUnitShartName != null ? orgUnitShartName.hashCode() : 0);
        return result;
    }
}
