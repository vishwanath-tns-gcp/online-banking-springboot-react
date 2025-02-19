package bankproject.onlinebanking.Model;

import java.sql.Date;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Table(name = "userdata")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "userid")
    private String userId;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "password")
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    public Role role;

    @Column(name = "accountreq")
    private boolean accountopenningreq = false;

    private boolean locked = false;
    private boolean enabled = true;

    @Column(name = "createdate")
    private Date createdDate;

    // @Column(name = "resetPasswordToken")
    // private String resetPasswordToken;

    // @Column
    // private boolean emailVerified;

    // @Column(name = "otp")
    // public String otp;

    @Transient
    public String token;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private UserDetail userdetails;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonManagedReference(value = "user-account")
    private List<BankAccount> accounts;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Beneficiaries> beneficiaries;

    // public boolean isEmailVerified() {
    // return emailVerified;
    // }

    // public void setEmailverified(boolean emailVerified) {
    // this.emailVerified = emailVerified;
    // }

    // @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    // @JsonManagedReference(value = "user-loan")
    // private List<LoanAccount> loanAccounts;

    // user active we can add in in future

}
