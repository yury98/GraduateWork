package models;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

@Entity
public class Schemes {
    private int schemeId;
    private String schemeName;
    private String schemeAlias;
    private Timestamp creationDate;
    private Users usersByCratedBy;
    private Collection<Tasks> tasksBySchemeId;

    @Id
    @Column(name = "SchemeId", nullable = false)
    public int getSchemeId() {
        return schemeId;
    }

    public void setSchemeId(int schemeId) {
        this.schemeId = schemeId;
    }

    @Basic
    @Column(name = "SchemeName", nullable = true, length = 50)
    public String getSchemeName() {
        return schemeName;
    }

    public void setSchemeName(String schemeName) {
        this.schemeName = schemeName;
    }

    @Basic
    @Column(name = "SchemeAlias", nullable = true, length = 50)
    public String getSchemeAlias() {
        return schemeAlias;
    }

    public void setSchemeAlias(String schemeAlias) {
        this.schemeAlias = schemeAlias;
    }

    @Basic
    @Column(name = "CreationDate", nullable = true)
    public Timestamp getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Timestamp creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Schemes schemes = (Schemes) o;

        if (schemeId != schemes.schemeId) return false;
        if (schemeName != null ? !schemeName.equals(schemes.schemeName) : schemes.schemeName != null) return false;
        if (schemeAlias != null ? !schemeAlias.equals(schemes.schemeAlias) : schemes.schemeAlias != null) return false;
        if (creationDate != null ? !creationDate.equals(schemes.creationDate) : schemes.creationDate != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = schemeId;
        result = 31 * result + (schemeName != null ? schemeName.hashCode() : 0);
        result = 31 * result + (schemeAlias != null ? schemeAlias.hashCode() : 0);
        result = 31 * result + (creationDate != null ? creationDate.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "CratedBy", referencedColumnName = "UserId", nullable = false)
    public Users getUsersByCratedBy() {
        return usersByCratedBy;
    }

    public void setUsersByCratedBy(Users usersByCratedBy) {
        this.usersByCratedBy = usersByCratedBy;
    }

    @OneToMany(mappedBy = "schemesBySchemeId")
    public Collection<Tasks> getTasksBySchemeId() {
        return tasksBySchemeId;
    }

    public void setTasksBySchemeId(Collection<Tasks> tasksBySchemeId) {
        this.tasksBySchemeId = tasksBySchemeId;
    }
}
