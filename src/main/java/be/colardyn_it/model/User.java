package be.colardyn_it.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "user", uniqueConstraints = @UniqueConstraint(columnNames = "NAME"))
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(doNotUseGetters = true)
public class User implements java.io.Serializable {

    private Integer userId;
    private Team team;
    private String name;
    private String password;
    private String email;
    private Date dateJoined;
    private int donations;
    private Date lastVisit;
    private String forumUserName;
    private String forumUserPassword;
    private Integer forumUserId;
    private int forumLoginFailureCount;
    private Integer blogUserId;
    private Integer countryId;
    private Boolean blocked;
    private Boolean agreedToTerms;
    private Set<Role> roles = new HashSet<>();

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "USER_ID", unique = true, nullable = false)
    public Integer getUserId() {
        return this.userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TEAM_ID")
    public Team getTeam() {
        return this.team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    @Column(name = "NAME", unique = true, nullable = false, length = 50)
    @NotNull
    @Length(max = 50)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "PASSWORD", nullable = false)
    @NotNull
    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "EMAIL", nullable = false, length = 100)
    @NotNull
    @Length(max = 100)
    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DATE_JOINED", length = 23)
    public Date getDateJoined() {
        return this.dateJoined;
    }

    public void setDateJoined(Date dateJoined) {
        this.dateJoined = dateJoined;
    }

    @Column(name = "DONATIONS", nullable = false)
    public int getDonations() {
        return this.donations;
    }

    public void setDonations(int donations) {
        this.donations = donations;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "LAST_VISIT", length = 23)
    public Date getLastVisit() {
        return this.lastVisit;
    }

    public void setLastVisit(Date lastVisit) {
        this.lastVisit = lastVisit;
    }

    @Column(name = "BLOCKED", nullable = false)
    @NotNull
    @Type(type = "yes_no")
    public Boolean getBlocked() {
        return this.blocked;
    }

    public void setBlocked(Boolean blocked) {
        this.blocked = blocked;
    }

    @Column(name = "FORUM_USER_NAME", length = 50)
    @Length(max = 50)
    public String getForumUserName() {
        return this.forumUserName;
    }

    public void setForumUserName(String forumUserName) {
        this.forumUserName = forumUserName;
    }

    @Column(name = "FORUM_USER_PASSWORD", length = 50)
    @Length(max = 50)
    public String getForumUserPassword() {
        return this.forumUserPassword;
    }

    public void setForumUserPassword(String forumUserPassword) {
        this.forumUserPassword = forumUserPassword;
    }

    @Column(name = "FORUM_USER_ID")
    public Integer getForumUserId() {
        return this.forumUserId;
    }

    public void setForumUserId(Integer forumUserId) {
        this.forumUserId = forumUserId;
    }

    @Column(name = "FORUM_LOGIN_FAILURE_COUNT", nullable = false)
    public int getForumLoginFailureCount() {
        return this.forumLoginFailureCount;
    }

    public void setForumLoginFailureCount(int forumLoginFailureCount) {
        this.forumLoginFailureCount = forumLoginFailureCount;
    }

    @Column(name = "BLOG_USER_ID")
    public Integer getBlogUserId() {
        return this.blogUserId;
    }

    public void setBlogUserId(Integer blogUserId) {
        this.blogUserId = blogUserId;
    }

    @Column(name = "COUNTRY_ID")
    public Integer getCountryId() {
        return this.countryId;
    }

    public void setCountryId(Integer countryId) {
        this.countryId = countryId;
    }

    @Column(name = "AGREED_TO_TERMS", nullable = false)
    @Type(type = "yes_no")
    public Boolean getAgreedToTerms() {
        return this.agreedToTerms;
    }

    public void setAgreedToTerms(Boolean agreedToTerms) {
        this.agreedToTerms = agreedToTerms;
    }

    public Set<Role> addRole(Role role) {
        if (roles == null) {
            roles = new HashSet<>();
        }
        roles.add(role);
        return roles;
    }

    @ManyToMany(cascade = {CascadeType.PERSIST}, targetEntity = Role.class)
    @JoinTable(name = "userrole",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id")})
    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
