package be.colardyn_it.model;

// Generated Apr 8, 2009 11:16:30 AM by Hibernate Tools 3.2.2.GA

import be.colardyn_it.util.StringUtil;
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

import static javax.persistence.GenerationType.IDENTITY;

/**
 * CpuModel generated by hbm2java
 */
@Entity
@Table(name = "cpu_model")
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CpuModel implements java.io.Serializable {

    private Integer cpuId;
    private Socket socket;
    private CpuSubfamily cpuSubfamily;
    private CpuCore cpuCore;
    private int cores = 1;
    private String keywords;
    private String model;
    private Integer mhz;
    private Integer fsb;
    private BigDecimal thermalheat;
    private Boolean marked = false;
    private String safeName;
    private Date releaseDate;

    @PrePersist
    @PreUpdate
    public void checkSafeName() {
        this.safeName = StringUtil.makeUrlSafe(model);
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "CPU_ID", unique = true, nullable = false)
    public Integer getCpuId() {
        return this.cpuId;
    }

    public void setCpuId(Integer cpuId) {
        this.cpuId = cpuId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SOCKET_ID")
    @NotFound(action = NotFoundAction.IGNORE)
    public Socket getSocket() {
        return this.socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SUBFAMILY_ID")
    @NotFound(action = NotFoundAction.IGNORE)
    public CpuSubfamily getCpuSubfamily() {
        return this.cpuSubfamily;
    }

    public void setCpuSubfamily(CpuSubfamily cpuSubfamily) {
        this.cpuSubfamily = cpuSubfamily;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CORE_ID")
    @NotFound(action = NotFoundAction.IGNORE)
    public CpuCore getCpuCore() {
        return this.cpuCore;
    }

    public void setCpuCore(CpuCore cpuCore) {
        this.cpuCore = cpuCore;
    }

    @Column(name = "CORES", nullable = false)
    @NotNull
    public int getCores() {
        return this.cores;
    }

    public void setCores(int cores) {
        this.cores = cores;
    }

    @Column(name = "KEYWORDS", length = 50)
    @Length(max = 50)
    public String getKeywords() {
        return this.keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    @Column(name = "MODEL", nullable = false, length = 50)
    @NotNull
    @Length(max = 50)
    public String getModel() {
        return this.model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Column(name = "SAFE_NAME", nullable = false, length = 50)
    @NotNull
    @Length(max = 50)
    public String getSafeName() {
        return this.safeName;
    }

    public void setSafeName(String model) {
        this.safeName = model;
    }

    @Column(name = "MHZ", precision = 5, scale = 0)
    public Integer getMhz() {
        return this.mhz;
    }

    public void setMhz(Integer mhz) {
        this.mhz = mhz;
    }

    @Column(name = "FSB")
    public Integer getFsb() {
        return this.fsb;
    }

    public void setFsb(Integer fsb) {
        this.fsb = fsb;
    }

    @Column(name = "THERMALHEAT", precision = 5)
    public BigDecimal getThermalheat() {
        return this.thermalheat;
    }

    public void setThermalheat(BigDecimal thermalheat) {
        this.thermalheat = thermalheat;
    }

    @Column(name = "MARKED", nullable = false)
    @NotNull
    @Type(type = "yes_no")
    public Boolean getMarked() {
        return this.marked;
    }

    public void setMarked(Boolean marked) {
        this.marked = marked;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "release_date", nullable = true)
    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

}
