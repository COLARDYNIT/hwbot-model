package be.colardyn_it.model;

// Generated Apr 8, 2009 11:16:30 AM by Hibernate Tools 3.2.2.GA

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Memory generated by hbm2java
 */
@Entity
@Table(name = "memory", uniqueConstraints = @UniqueConstraint(columnNames = "NAME"))
@Builder
@ToString(doNotUseGetters = true, exclude = {"memoryratings","gpuModels"})
@AllArgsConstructor
@NoArgsConstructor
public class Memory implements java.io.Serializable {

    private Integer memId;
    private String name;
    private Boolean visible = true;
    private Set<GpuModel> gpuModels = new HashSet<GpuModel>(0);
    private Set<Memoryrating> memoryratings = new HashSet<Memoryrating>(0);

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "MEM_ID", unique = true, nullable = false)
    public Integer getMemId() {
        return this.memId;
    }

    public void setMemId(Integer memId) {
        this.memId = memId;
    }

    @Column(name = "NAME", unique = true, nullable = false, length = 20)
    @NotNull
    @Length(max = 20)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
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

    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}, fetch = FetchType.LAZY, mappedBy = "memory")
    public Set<GpuModel> getGpuModels() {
        return this.gpuModels;
    }

    public void setGpuModels(Set<GpuModel> gpuModels) {
        this.gpuModels = gpuModels;
    }

    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}, fetch = FetchType.LAZY, mappedBy = "memory")
    public Set<Memoryrating> getMemoryratings() {
        return this.memoryratings;
    }

    public void setMemoryratings(Set<Memoryrating> memoryratings) {
        this.memoryratings = memoryratings;
    }

}
