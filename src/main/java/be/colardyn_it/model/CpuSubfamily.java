package be.colardyn_it.model;

// Generated Apr 8, 2009 11:16:30 AM by Hibernate Tools 3.2.2.GA


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * CpuSubfamily generated by hbm2java
 */
@Entity
@Table(name = "cpu_subfamily", uniqueConstraints = @UniqueConstraint(columnNames = "NAME"))
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CpuSubfamily implements java.io.Serializable {

    private Integer subfamilyId;
    private CpuFamily cpuFamily;
    private String name;
    private Set<CpuModel> cpuModels = new HashSet<CpuModel>(0);

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "SUBFAMILY_ID", unique = true, nullable = false)
    public Integer getSubfamilyId() {
        return this.subfamilyId;
    }

    public void setSubfamilyId(Integer subfamilyId) {
        this.subfamilyId = subfamilyId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FAMILY_ID", nullable = false)
    @NotNull
    @NotFound(action = NotFoundAction.IGNORE)
    public CpuFamily getCpuFamily() {
        return this.cpuFamily;
    }

    public void setCpuFamily(CpuFamily cpuFamily) {
        this.cpuFamily = cpuFamily;
    }

    @Column(name = "NAME", unique = true, length = 50)
    @Length(max = 50)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}, fetch = FetchType.LAZY, mappedBy = "cpuSubfamily")
    public Set<CpuModel> getCpuModels() {
        return this.cpuModels;
    }

    public void setCpuModels(Set<CpuModel> cpuModels) {
        this.cpuModels = cpuModels;
    }

}
