package be.colardyn_it.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Created by stijnhaesendonck on 14/02/2017.
 */
@Entity
@Table(name = "result")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(doNotUseGetters = true)
public class Result {
    private Integer resultId;
    private Integer contestId;
    private Integer cpuId;
    private Integer gpuId;
    private Integer cpuFamilyId;
    private Integer gpuFamilyId;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "RESULT_ID", unique = true, nullable = false)
    public Integer getResultId() {
        return resultId;
    }

    public void setResultId(Integer resultId) {
        this.resultId = resultId;
    }
    @Column(name = "CONTEST_ID")
    @NotFound(action = NotFoundAction.IGNORE)
    public Integer getContestId() {
        return contestId;
    }

    public void setContestId(Integer contestId) {
        this.contestId = contestId;
    }
    @Column(name = "CPU_ID")
    @NotFound(action = NotFoundAction.IGNORE)
    public Integer getCpuId() {
        return cpuId;
    }

    public void setCpuId(Integer cpuId) {
        this.cpuId = cpuId;
    }
    @Column(name = "GPU_ID")
    @NotFound(action = NotFoundAction.IGNORE)
    public Integer getGpuId() {
        return gpuId;
    }

    public void setGpuId(Integer gpuId) {
        this.gpuId = gpuId;
    }
    @Column(name = "CPUFAMILY_ID")
    @NotFound(action = NotFoundAction.IGNORE)
    public Integer getCpuFamilyId() {
        return cpuFamilyId;
    }

    public void setCpuFamilyId(Integer cpuFamilyId) {
        this.cpuFamilyId = cpuFamilyId;
    }
    @Column(name = "GPUFAMILY_ID")
    @NotFound(action = NotFoundAction.IGNORE)
    public Integer getGpuFamilyId() {
        return gpuFamilyId;
    }

    public void setGpuFamilyId(Integer gpuFamilyId) {
        this.gpuFamilyId = gpuFamilyId;
    }
}
