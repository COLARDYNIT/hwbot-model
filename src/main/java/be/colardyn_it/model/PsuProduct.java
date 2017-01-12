package be.colardyn_it.model;

// Generated Apr 8, 2009 11:16:30 AM by Hibernate Tools 3.2.2.GA


import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "psu_productgroup", uniqueConstraints = @UniqueConstraint(columnNames = "name"))
public class PsuProduct implements java.io.Serializable {

    private Integer groupId;
    private Manufacturer manufacturer;
    private String name;
    private Date releaseDate;



    public PsuProduct() {
    }

    public PsuProduct(Manufacturer manufacturer, String name) {
        this.manufacturer = manufacturer;
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "GROUP_ID", unique = true, nullable = false)
    public Integer getGroupId() {
        return this.groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    @Column(name = "NAME", unique = true, nullable = false, length = 50)
    @NotNull
    @Length(max = 50)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "MANUFACTURER_ID")
    @NotFound(action = NotFoundAction.IGNORE)
    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
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
