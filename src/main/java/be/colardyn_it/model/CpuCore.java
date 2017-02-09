package be.colardyn_it.model;

// Generated Apr 8, 2009 11:16:30 AM by Hibernate Tools 3.2.2.GA

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * CpuCore generated by hbm2java
 */
@Entity
@Table(name = "cpu_core")
@Builder
@ToString(exclude = {"cpuFamily","cpuModels","cpuArchitecture"})
@AllArgsConstructor
@NoArgsConstructor
public class CpuCore implements java.io.Serializable {

    private Integer coreId;
    private CpuFamily cpuFamily;
    private String codename;
    private String name;
    private BigDecimal manufacturingProcess;
    private BigDecimal voltage;
    private Integer l1cache;
    private Integer l2cache;
    private Integer l3cache;
    private Integer size;
    private Integer transistors;
    private Date launchDate;
    private CpuArchitecture cpuArchitecture;
    private Set<CpuModel> cpuModels = new HashSet<CpuModel>(0);

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "CORE_ID", unique = true, nullable = false)
    public Integer getCoreId() {
        return this.coreId;
    }

    public void setCoreId(Integer coreId) {
        this.coreId = coreId;
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

    @Column(name = "CODENAME", length = 50)
    @Length(max = 50)
    public String getCodename() {
        return this.codename;
    }

    public void setCodename(String codename) {
        this.codename = codename;
    }

    @Column(name = "NAME", length = 50)
    @Length(max = 50)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "MANUFACTURING_PROCESS", precision = 4, scale = 3)
    @Type(type = "big_decimal")
    public BigDecimal getManufacturingProcess() {
        return this.manufacturingProcess;
    }

    public void setManufacturingProcess(BigDecimal manufacturingProcess) {
        this.manufacturingProcess = manufacturingProcess;
    }

    @Column(name = "VOLTAGE", precision = 3)
    public BigDecimal getVoltage() {
        return this.voltage;
    }

    public void setVoltage(BigDecimal voltage) {
        this.voltage = voltage;
    }

    @Column(name = "L1CACHE")
    public Integer getL1cache() {
        return this.l1cache;
    }

    public void setL1cache(Integer l1cache) {
        this.l1cache = l1cache;
    }

    @Column(name = "L2CACHE")
    public Integer getL2cache() {
        return this.l2cache;
    }

    public void setL2cache(Integer l2cache) {
        this.l2cache = l2cache;
    }

    @Column(name = "L3CACHE")
    public Integer getL3cache() {
        return this.l3cache;
    }

    public void setL3cache(Integer l3cache) {
        this.l3cache = l3cache;
    }

    @Column(name = "SIZE")
    public Integer getSize() {
        return this.size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    @Column(name = "TRANSISTORS")
    public Integer getTransistors() {
        return this.transistors;
    }

    public void setTransistors(Integer transistors) {
        this.transistors = transistors;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "LAUNCH_DATE", length = 23)
    public Date getLaunchDate() {
        return this.launchDate;
    }

    public void setLaunchDate(Date launchDate) {
        this.launchDate = launchDate;
    }

    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}, fetch = FetchType.LAZY, mappedBy = "cpuCore")
    public Set<CpuModel> getCpuModels() {
        return this.cpuModels;
    }

    public void setCpuModels(Set<CpuModel> cpuModels) {
        this.cpuModels = cpuModels;
    }

    public CpuArchitecture getCpuArchitecture() {
        return cpuArchitecture;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ARCHITECTURE_ID")
    @NotFound(action = NotFoundAction.IGNORE)
    public void setCpuArchitecture(CpuArchitecture cpuArchitecture) {
        this.cpuArchitecture = cpuArchitecture;
    }
}
