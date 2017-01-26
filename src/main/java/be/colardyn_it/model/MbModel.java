package be.colardyn_it.model;

// Generated Apr 14, 2009 1:43:35 PM by Hibernate Tools 3.2.2.GA

import be.colardyn_it.util.StringUtil;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * MbModel generated by hbm2java
 */
@Entity
@Table(name = "mb_model")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MbModel implements java.io.Serializable {

    private Integer modelId;
    private Socket socket;
    private Manufacturer manufacturer;
    private MbChipset mbChipset;
    private String name;
    private String safeName;
    private Boolean visible = true;
    private Date releaseDate;

    @PrePersist
    @PreUpdate
    public void checkSafeName() {
        this.safeName = StringUtil.makeUrlSafe(name);
    }

    @Id()
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "MODEL_ID", unique = true, nullable = false)
    public Integer getModelId() {
        return this.modelId;
    }

    public void setModelId(Integer modelId) {
        this.modelId = modelId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SOCKET_ID", nullable = true)
    @NotFound(action = NotFoundAction.IGNORE)
    public Socket getSocket() {
        return this.socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MANUFACTURER_ID")
    @NotFound(action = NotFoundAction.IGNORE)
    public Manufacturer getManufacturer() {
        return this.manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CHIPSET_ID")
    @NotFound(action = NotFoundAction.IGNORE)
    public MbChipset getMbChipset() {
        return this.mbChipset;
    }

    public void setMbChipset(MbChipset mbChipset) {
        this.mbChipset = mbChipset;
    }

    @Column(name = "NAME", nullable = false)
    @NotNull
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "SAFE_NAME", nullable = false)
    @NotNull
    public String getSafeName() {
        return this.safeName;
    }

    public void setSafeName(String safeName) {
        this.safeName = safeName;
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

}
