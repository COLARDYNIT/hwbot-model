package be.colardyn_it.model;

// Generated Apr 14, 2009 1:32:23 PM by Hibernate Tools 3.2.2.GA


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.Type;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * be.colardyn_it.Application generated by hbm2java
 */
@Entity
@Table(name = "application", uniqueConstraints = @UniqueConstraint(columnNames = "NAME"))
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(doNotUseGetters = true)
public class Application implements java.io.Serializable {

    private Integer applicationId;
    private String version;
    private String name;
    private String website;
    private String downloadlink;
    private String verificationUrlPattern;
    private String unit;
    private Boolean lowerbetter;
    private String ranking;
    private String type;
    private Boolean hidden;
    private Boolean supportsChecksumValidation;
    private float hwweight;
    private String supportedClients;
    private String recommendation;
    private String countryCode;
    private String regionCode;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "APPLICATION_ID", unique = true, nullable = false)
    public Integer getApplicationId() {
        return this.applicationId;
    }

    public void setApplicationId(Integer applicationId) {
        this.applicationId = applicationId;
    }

    @Column(name = "VERSION", length = 20)
    public String getVersion() {
        return this.version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    @Column(name = "NAME", unique = true, nullable = false, length = 50)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "WEBSITE", nullable = false, length = 100)
    public String getWebsite() {
        return this.website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    @Column(name = "DOWNLOADLINK", nullable = false, length = 100)
    public String getDownloadlink() {
        return this.downloadlink;
    }

    public void setDownloadlink(String downloadlink) {
        this.downloadlink = downloadlink;
    }

    @Column(name = "VERIFICATION_URL_PATTERN", length = 200)
    public String getVerificationUrlPattern() {
        return this.verificationUrlPattern;
    }

    public void setVerificationUrlPattern(String verificationUrlPattern) {
        this.verificationUrlPattern = verificationUrlPattern;
    }

    @Column(name = "UNIT", nullable = false, length = 20)
    public String getUnit() {
        return this.unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    @Column(name = "LOWERBETTER", nullable = false)
    @Type(type = "yes_no")
    public Boolean getLowerbetter() {
        return this.lowerbetter;
    }

    public void setLowerbetter(Boolean lowerbetter) {
        this.lowerbetter = lowerbetter;
    }

    @Column(name = "RANKING", nullable = false)
    public String getRanking() {
        return ranking;
    }

    public void setRanking(String ranking) {
        this.ranking = ranking;
    }

    @Column(name = "TYPE", length = 20)
    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Column(name = "HIDDEN", nullable = false)
    @Type(type = "yes_no")
    public Boolean getHidden() {
        return this.hidden;
    }

    public void setHidden(Boolean hidden) {
        this.hidden = hidden;
    }

    @Column(name = "SUPPORTS_CHECKSUM_VALIDATION", nullable = false)
    @Type(type = "yes_no")
    public Boolean getSupportsChecksumValidation() {
        return this.supportsChecksumValidation;
    }

    public void setSupportsChecksumValidation(Boolean supportsChecksumValidation) {
        this.supportsChecksumValidation = supportsChecksumValidation;
    }

    @Column(name = "HWWEIGHT", nullable = false, precision = 4, scale = 2)
    @Type(type = "float")
    public float getHwweight() {
        return this.hwweight;
    }

    public void setHwweight(float hwweight) {
        this.hwweight = hwweight;
    }

    @Column(name = "SUPPORTED_CLIENTS")
    public String getSupportedClients() {
        return this.supportedClients;
    }

    public void setSupportedClients(String supportedClients) {
        this.supportedClients = supportedClients;
    }

    @Column(name = "RECOMMENDATION")
    public String getRecommendation() {
        return this.recommendation;
    }

    public void setRecommendation(String recommendation) {
        this.recommendation = recommendation;
    }

    @Column(name = "country_code", length = 2)
    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    @Column(name = "region_code", length = 20)
    public String getRegionCode() {
        return regionCode;
    }

    public void setRegionCode(String regionCode) {
        this.regionCode = regionCode;
    }

}
