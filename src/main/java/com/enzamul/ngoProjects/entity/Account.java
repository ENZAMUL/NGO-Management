package com.enzamul.ngoProjects.entity;

import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.*;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

/**
 *
 * @author MD ENZAMUL HOQ
 */
@Entity
@Table(name = "account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "acc_hold_name", nullable = false)
    private String accountHolderName;

    @Column(name = "account_namber", nullable = false)
    private Long accountNumber;

    @Column(name = "acc_code_number")
    private String accountCodeNumber;

    @Column(name = "pri_Dep_amount", nullable = false)
    private double primaryDepositAmount;

    @Column(name = "total_withdraw", nullable = false)
    private double totalWithdraw;

    @Column(name = "balance_amount", nullable = false)
    private double balanceAmount;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthDate;

    @Column(name = "acc_hold_age", nullable = false)
    private int accountHolderAge;

    @Column(name = "gender", nullable = false)
    private String gender;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(nullable = false, unique = true)
    private String mobile;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "nid_number", nullable = false, unique = true)
    private String nidNumber;

    @Column(name = "profession", nullable = false)
    private String profession;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "acc_open_date", nullable = false)
    private Date accountOpeningDate = new Date();

    /*
numberoftotalaccount
     */
    //RelationShip
    @ManyToOne
    @JoinColumn(name = "account_type_id", nullable = false)
    private AccountType accountType;

    @ManyToOne
    @JoinColumn(name = "branch_id", nullable = false)
    private Branch branch;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "account_nominee",
            joinColumns = @JoinColumn(name = "account_id"),
            inverseJoinColumns = @JoinColumn(name = "nominee_id")
    )
    private Set<Nominee> nominees;

    //Constructor
    public Account() {
    }

    public Account(String accountHolderName, Long accountNumber, String accountCodeNumber, double primaryDepositAmount, double totalWithdraw, double balanceAmount, Date birthDate, int accountHolderAge, String gender, String email, String mobile, String address, String nidNumber, String profession, Date accountOpeningDate, AccountType accountType, Branch branch, Set<Nominee> nominees) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        this.accountCodeNumber = accountCodeNumber;
        this.primaryDepositAmount = primaryDepositAmount;
        this.totalWithdraw = totalWithdraw;
        this.balanceAmount = balanceAmount;
        this.birthDate = birthDate;
        this.accountHolderAge = accountHolderAge;
        this.gender = gender;
        this.email = email;
        this.mobile = mobile;
        this.address = address;
        this.nidNumber = nidNumber;
        this.profession = profession;
        this.accountOpeningDate = accountOpeningDate;
        this.accountType = accountType;
        this.branch = branch;
        this.nominees = nominees;
    }

    //Getter and Setter method
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public Long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountCodeNumber() {
        return accountCodeNumber;
    }

    public void setAccountCodeNumber(String accountCodeNumber) {
        this.accountCodeNumber = accountCodeNumber;
    }

    public double getPrimaryDepositAmount() {
        return primaryDepositAmount;
    }

    public void setPrimaryDepositAmount(double primaryDepositAmount) {
        this.primaryDepositAmount = primaryDepositAmount;
    }

    public double getTotalWithdraw() {
        return totalWithdraw;
    }

    public void setTotalWithdraw(double totalWithdraw) {
        this.totalWithdraw = totalWithdraw;
    }

    public double getBalanceAmount() {
        return balanceAmount;
    }

    public void setBalanceAmount(double balanceAmount) {
        this.balanceAmount = balanceAmount;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public int getAccountHolderAge() {
        return accountHolderAge;
    }

    public void setAccountHolderAge(int accountHolderAge) {
        this.accountHolderAge = accountHolderAge;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNidNumber() {
        return nidNumber;
    }

    public void setNidNumber(String nidNumber) {
        this.nidNumber = nidNumber;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public Date getAccountOpeningDate() {
        return accountOpeningDate;
    }

    public void setAccountOpeningDate(Date accountOpeningDate) {
        this.accountOpeningDate = accountOpeningDate;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    public Set<Nominee> getNominees() {
        return nominees;
    }

    public void setNominees(Set<Nominee> nominees) {
        this.nominees = nominees;
    }

    //Equals and HashCode method
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Account account = (Account) o;
        return Double.compare(account.getPrimaryDepositAmount(), getPrimaryDepositAmount()) == 0
                && Double.compare(account.getTotalWithdraw(), getTotalWithdraw()) == 0
                && Double.compare(account.getBalanceAmount(), getBalanceAmount()) == 0
                && getAccountHolderAge() == account.getAccountHolderAge()
                && Objects.equals(getId(), account.getId())
                && Objects.equals(getAccountHolderName(), account.getAccountHolderName())
                && Objects.equals(getAccountNumber(), account.getAccountNumber())
                && Objects.equals(getAccountCodeNumber(), account.getAccountCodeNumber())
                && Objects.equals(getBirthDate(), account.getBirthDate())
                && Objects.equals(getGender(), account.getGender())
                && Objects.equals(getEmail(), account.getEmail())
                && Objects.equals(getMobile(), account.getMobile())
                && Objects.equals(getAddress(), account.getAddress())
                && Objects.equals(getNidNumber(), account.getNidNumber())
                && Objects.equals(getProfession(), account.getProfession())
                && Objects.equals(getAccountOpeningDate(), account.getAccountOpeningDate())
                && Objects.equals(getAccountType(), account.getAccountType())
                && Objects.equals(getBranch(), account.getBranch())
                && Objects.equals(getNominees(), account.getNominees());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getAccountHolderName(), getAccountNumber(), getAccountCodeNumber(), getPrimaryDepositAmount(), getTotalWithdraw(), getBalanceAmount(), getBirthDate(), getAccountHolderAge(), getGender(), getEmail(), getMobile(), getAddress(), getNidNumber(), getProfession(), getAccountOpeningDate(), getAccountType(), getBranch(), getNominees());
    }

    //toString
    @Override
    public String toString() {
        return "Account{"
                + "id=" + id
                + ", accountHolderName='" + accountHolderName + '\''
                + ", accountNumber=" + accountNumber
                + ", accountCodeNumber='" + accountCodeNumber + '\''
                + ", primaryDepositAmount=" + primaryDepositAmount
                + ", totalWithdraw=" + totalWithdraw
                + ", balanceAmount=" + balanceAmount
                + ", birthDate=" + birthDate
                + ", accountHolderAge=" + accountHolderAge
                + ", gender='" + gender + '\''
                + ", email='" + email + '\''
                + ", mobile='" + mobile + '\''
                + ", address='" + address + '\''
                + ", nidNumber='" + nidNumber + '\''
                + ", profession='" + profession + '\''
                + ", accountOpeningDate=" + accountOpeningDate
                + ", accountType=" + accountType
                + ", branch=" + branch
                + ", nominees=" + nominees
                + '}';
    }
}
