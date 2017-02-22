package be.colardyn_it.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "contest_limitation")
@Builder
@ToString(doNotUseGetters = true, exclude = {"benchmarkLimitationType","contest"})
@AllArgsConstructor
@NoArgsConstructor
public class ContestLimitation implements Serializable {

    private Integer id;
    private Contest contest;
    private BenchmarkLimitationType benchmarkLimitationType;
    private String configKey;
    private String configValue;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CONTEST_ID", nullable = false)
    @NotNull
    public Contest getContest() {
        return contest;
    }

    public void setContest(Contest contest) {
        this.contest = contest;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TYPE_ID", nullable = false)
    @NotNull
    public BenchmarkLimitationType getBenchmarkLimitationType() {
        return this.benchmarkLimitationType;
    }

    public void setBenchmarkLimitationType(BenchmarkLimitationType benchmarkLimitationType) {
        this.benchmarkLimitationType = benchmarkLimitationType;
    }

    @Column(name = "config_key")
    public String getConfigKey() {
        return configKey;
    }

    public void setConfigKey(String configKey) {
        this.configKey = configKey;
    }

    @Column(name = "config_value")
    public String getConfigValue() {
        return configValue;
    }

    public void setConfigValue(String configValue) {
        this.configValue = configValue;
    }

}