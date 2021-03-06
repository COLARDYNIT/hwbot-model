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
 * ContestModerator generated by hbm2java
 */
@Entity
@Table(name = "contest_moderator", uniqueConstraints = @UniqueConstraint(columnNames = {
        "CONTEST_ID", "USER_ID"}))
@Builder
@ToString(doNotUseGetters = true)
@AllArgsConstructor
@NoArgsConstructor
public class ContestModerator implements java.io.Serializable {

    private Integer contestModeratorId;
    private User user;
    private Contest contest;

    public ContestModerator(User user, Contest contest) {
        this.user = user;
        this.contest = contest;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "CONTEST_MODERATOR_ID", unique = true, nullable = false)
    public Integer getContestModeratorId() {
        return this.contestModeratorId;
    }

    public void setContestModeratorId(Integer contestModeratorId) {
        this.contestModeratorId = contestModeratorId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID", nullable = false)
    @NotNull
    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
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

}
