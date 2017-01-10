package be.colardyn_it.model;

// Generated Apr 8, 2009 11:16:30 AM by Hibernate Tools 3.2.2.GA


import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * CpuFamily generated by hbm2java
 */
@Entity
@Table(name = "cpu_family", uniqueConstraints = @UniqueConstraint(columnNames = "NAME"))
public class CpuFamily implements java.io.Serializable {

    private Integer familyId;
    private Manufacturer manufacturer;
    private String name;
    private Date launchDate;
    private Set<CpuCore> cpuCores = new HashSet<CpuCore>(0);
    private Set<CpuSubfamily> cpuSubfamilies = new HashSet<CpuSubfamily>(0);

    public CpuFamily() {
    }

    public CpuFamily(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public CpuFamily(Manufacturer manufacturer, String name, Date launchDate,
                     Set<CpuCore> cpuCores, Set<CpuSubfamily> cpuSubfamilies) {
        this.manufacturer = manufacturer;
        this.name = name;
        this.launchDate = launchDate;
        this.cpuCores = cpuCores;
        this.cpuSubfamilies = cpuSubfamilies;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "FAMILY_ID", unique = true, nullable = false)
    public Integer getFamilyId() {
        return this.familyId;
    }

    public void setFamilyId(Integer familyId) {
        this.familyId = familyId;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "MANUFACTURER_ID", nullable = false)
    @NotNull
    @NotFound(action = NotFoundAction.IGNORE)
    public Manufacturer getManufacturer() {
        return this.manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    @Column(name = "NAME", unique = true, length = 50)
    @Length(max = 50)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "LAUNCH_DATE", length = 23)
    public Date getLaunchDate() {
        return this.launchDate;
    }

    public void setLaunchDate(Date launchDate) {
        this.launchDate = launchDate;
    }

    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}, fetch = FetchType.LAZY, mappedBy = "cpuFamily")
    public Set<CpuCore> getCpuCores() {
        return this.cpuCores;
    }

    public void setCpuCores(Set<CpuCore> cpuCores) {
        this.cpuCores = cpuCores;
    }

    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}, fetch = FetchType.LAZY, mappedBy = "cpuFamily")
    public Set<CpuSubfamily> getCpuSubfamilies() {
        return this.cpuSubfamilies;
    }

    public void setCpuSubfamilies(Set<CpuSubfamily> cpuSubfamilies) {
        this.cpuSubfamilies = cpuSubfamilies;
    }

}
