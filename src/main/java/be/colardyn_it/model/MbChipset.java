package be.colardyn_it.model;

// Generated Apr 14, 2009 1:43:35 PM by Hibernate Tools 3.2.2.GA

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.Length;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * MbChipset generated by hbm2java
 */
@Entity
@Table(name = "mb_chipset")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(doNotUseGetters = true, exclude = {"mbModels", "manufacturer"})
public class MbChipset implements java.io.Serializable {

    private Integer chipsetId;
    private Manufacturer manufacturer;
    private String name;
    private String safeName;
    private String description;
    private Boolean visible = true;
    private Set<MbModel> mbModels = new HashSet<MbModel>(0);
    private Date releaseDate;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "CHIPSET_ID", unique = true, nullable = false)
    public Integer getChipsetId() {
        return this.chipsetId;
    }

    public void setChipsetId(Integer chipsetId) {
        this.chipsetId = chipsetId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MANUFACTURER_ID", nullable = false)
    @NotNull
    @NotFound(action = NotFoundAction.IGNORE)
    public Manufacturer getManufacturer() {
        return this.manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    @Column(name = "SAFE_NAME", nullable = false, length = 30)
    @Length(max = 30)
    public String getSafeName() {
        return this.safeName;
    }

    public void setSafeName(String safeName) {
        this.safeName = safeName;
    }

    @Column(name = "NAME", nullable = false, length = 30)
    @NotNull
    @Length(max = 30)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "DESCRIPTION")
    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "VISIBLE", nullable = false)
    @NotNull
    @Type(type = "yes_no")
    public Boolean getVisible() {
        return this.visible;
    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
    }

    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}, fetch = FetchType.LAZY, mappedBy = "mbChipset")
    public Set<MbModel> getMbModels() {
        return this.mbModels;
    }

    public void setMbModels(Set<MbModel> mbModels) {
        this.mbModels = mbModels;
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
