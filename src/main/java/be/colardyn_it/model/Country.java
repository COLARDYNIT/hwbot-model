package be.colardyn_it.model;

// Generated Apr 8, 2009 11:16:30 AM by Hibernate Tools 3.2.2.GA


import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Country generated by hbm2java
 */
@Entity
@Table(name = "country", uniqueConstraints = @UniqueConstraint(columnNames = "CODE"))
public class Country implements java.io.Serializable {

    private Integer countryId;
    private String code;
    private String name;

    public Country() {
    }

    public Country(String code, String name) {
        this.code = code;
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "COUNTRY_ID", unique = true, nullable = false)
    public Integer getCountryId() {
        return this.countryId;
    }

    public void setCountryId(Integer countryId) {
        this.countryId = countryId;
    }

    @Column(name = "CODE", unique = true, nullable = false, length = 2)
    @NotNull
    @Length(max = 2)
    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Column(name = "NAME", nullable = false)
    @NotNull
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
