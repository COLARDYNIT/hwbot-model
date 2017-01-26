package be.colardyn_it.model;

// Generated Jul 23, 2009 9:36:51 PM by Hibernate Tools 3.2.2.GA


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * ContestAchievement generated by hbm2java
 */
@Entity
@Table(name = "contest_achievement", uniqueConstraints = @UniqueConstraint(columnNames = {"LABEL", "CONTEST_ID"}))
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ContestAchievement implements java.io.Serializable {

    private Integer contestAchievementId;
    private Contest contest;
    private String label;
    private Integer position;

    @PrePersist()
    public void prePersist() {
        System.out.println("empty image, removing");
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "CONTEST_ACHIEVEMENT_ID", unique = true, nullable = false)
    public Integer getContestAchievementId() {
        return this.contestAchievementId;
    }

    public void setContestAchievementId(Integer contestAchievementId) {
        this.contestAchievementId = contestAchievementId;
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

    @Column(name = "LABEL", nullable = false)
    @NotNull
    public String getLabel() {
        return this.label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Column(name = "POSITION")
    public Integer getPosition() {
        return this.position;
    }

    public void setPosition(Integer Position) {
        this.position = Position;
    }


}
