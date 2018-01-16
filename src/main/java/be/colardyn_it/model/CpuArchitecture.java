package be.colardyn_it.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.util.HashSet;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Created by stijnhaesendonck on 09/02/2017.
 */
@Entity
@Table(name = "cpu_architecture")
@NoArgsConstructor
@AllArgsConstructor
@ToString(doNotUseGetters = true, exclude = {"cpuCores"})
@Builder
public class CpuArchitecture {

    private Integer architectureId;
    private String name;
    private String type;
    private Integer bits;
    private Set<CpuCore> cpuCores = new HashSet<CpuCore>(0);


    @Id()
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "ARCHITECTURE_ID", unique = true, nullable = false)
    public Integer getArchitectureId() {
        return architectureId;
    }

    public void setArchitectureId(Integer architectureId) {
        this.architectureId = architectureId;
    }

    @Column(name = "NAME", nullable = false, length = 255)
    @NotNull
    @Length(min = 1, max = 255)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Column(name = "TYPE", nullable = false, length = 10)
    @NotNull
    @Length(min = 1, max = 10)
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    @Column(name = "BITS", nullable = false)
    @NotNull
    public Integer getBits() {
        return bits;
    }

    public void setBits(Integer bits) {
        this.bits = bits;
    }

    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}, fetch = FetchType.LAZY, mappedBy = "cpuArchitecture")
    public Set<CpuCore> getCpuCores() {
        return this.cpuCores;
    }

    public void setCpuCores(Set<CpuCore> cpuCores) {
        this.cpuCores = cpuCores;
    }
}
