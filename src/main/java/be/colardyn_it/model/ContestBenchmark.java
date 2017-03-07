package be.colardyn_it.model;

// Generated Jul 23, 2009 9:36:51 PM by Hibernate Tools 3.2.2.GA

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * ContestBenchmark generated by hbm2java
 */
@Entity
@Table(name = "contest_benchmark")
@Builder
@ToString(doNotUseGetters = true, exclude = {"contest","benchmarkLimitations","application"})
@AllArgsConstructor
@NoArgsConstructor
public class ContestBenchmark implements java.io.Serializable {

    private Integer contestBenchmarkId;
    private Contest contest;
    private Application application;
    private Integer weight;
    private Date startdate;
    private Date enddate;
    private String label;
    private String config;
    private String rankingType;
    private String pointsDistribution;
    private String excerptLead;
    private String excerpt;
    private Integer type = 1;
    private Set<BenchmarkLimitation> benchmarkLimitations = new HashSet<BenchmarkLimitation>(0);

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "CONTEST_BENCHMARK_ID", unique = true, nullable = false)
    public Integer getContestBenchmarkId() {
        return this.contestBenchmarkId;
    }

    public void setContestBenchmarkId(Integer contestBenchmarkId) {
        this.contestBenchmarkId = contestBenchmarkId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CONTEST_ID", nullable = false)
    @NotNull
    public Contest getContest() {
        return this.contest;
    }

    public void setContest(Contest contest) {
        this.contest = contest;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "APPLICATION_ID", nullable = false)
    @NotNull
    public Application getApplication() {
        return this.application;
    }

    public void setApplication(Application application) {
        this.application = application;
    }

    @Column(name = "WEIGHT", nullable = false)
    @Type(type = "integer")
    @NotNull
    @Range(min = 1, max = 10)
    public Integer getWeight() {
        return this.weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "STARTDATE", nullable = false, length = 23)
    @NotNull
    public Date getStartdate() {
        return this.startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "ENDDATE", nullable = false, length = 23)
    @NotNull
    @Valid
    public Date getEnddate() {
        return this.enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "contestBenchmark")
    public Set<BenchmarkLimitation> getBenchmarkLimitations() {
        return this.benchmarkLimitations;
    }

    public void setBenchmarkLimitations(Set<BenchmarkLimitation> benchmarkLimitations) {
        this.benchmarkLimitations = benchmarkLimitations;
    }

    @Column(name = "LABEL", nullable = true, length = 255)
    @Size(min = 1,max = 255)
    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Column(name = "CONFIG", nullable = true, length = 255)
    public String getConfig() {
        return config;
    }

    public void setConfig(String config) {
        this.config = config;
    }

    @Column(name = "TYPE", nullable = false)
    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Column(name = "RANKING_TYPE", nullable = true, length = 255)
    public String getRankingType() {
        return rankingType;
    }

    public void setRankingType(String rankingType) {
        this.rankingType = rankingType;
    }

    @Column(name = "POINTS_DISTRIBUTION", nullable = true, length = 255)
    public String getPointsDistribution() {
        return pointsDistribution;
    }

    public void setPointsDistribution(String pointsDistribution) {
        this.pointsDistribution = pointsDistribution;
    }

    @Column(name = "EXCERPT", columnDefinition = "longtext")
    @Lob
    public String getExcerpt() {
        return excerpt;
    }

    public void setExcerpt(String excerpt) {
        this.excerpt = excerpt;
    }

    @Column(name = "EXCERPT_LEAD", columnDefinition = "longtext")
    @Lob
    public String getExcerptLead() {
        return excerptLead;
    }

    public void setExcerptLead(String excerptLead) {
        this.excerptLead = excerptLead;
    }

}
