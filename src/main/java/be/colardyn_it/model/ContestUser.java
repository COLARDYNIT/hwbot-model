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
 * ContestUser generated by hbm2java
 */
@Entity
@Table(name = "contest_user", uniqueConstraints = @UniqueConstraint(columnNames = {
        "CONTEST_ID", "USER_ID"}))
@Builder
@ToString(doNotUseGetters = true)
@AllArgsConstructor
@NoArgsConstructor
public class ContestUser implements java.io.Serializable {

    private Integer contestUserId;
    private User user;
    private Contest contest;

    public ContestUser(User user, Contest contest) {
        this.user = user;
        this.contest = contest;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "CONTEST_USER_ID", unique = true, nullable = false)
    public Integer getContestUserId() {
        return this.contestUserId;
    }

    public void setContestUserId(Integer contestUserId) {
        this.contestUserId = contestUserId;
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
