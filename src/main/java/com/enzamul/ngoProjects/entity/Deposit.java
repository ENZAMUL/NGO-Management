package com.enzamul.ngoProjects.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author MD ENZAMUL HOQ
 */
@Entity
@Table(name = "deposit")
public class Deposit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "deposit_branch", nullable = false) //Branch Deposit unique false Korte hobe
    private String depositBranch;

    @Column(unique = true, nullable = false)
    private Long loanCodeNumber;    //depositCodeNumber/account Code number

    @Temporal(TemporalType.TIMESTAMP)
    private Date depositDate = new Date();

    @Column(name = "deposit_amount", nullable = false)
    private double amount;     // totalDepositAmount

    /*
    depositKistiAmount
    depositKistiNo
   targatedDepositAmount
    dueDepositTargatedAmount
     */
    //RelationShip
    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "account_id", nullable = false)
    private Account account;

    @ManyToOne
    @JoinColumn(name = "deposit_type_id", nullable = false)
    private DepositType depositType;

    //Constructor
    public Deposit() {
    }

    public Deposit(String depositBranch, Long loanCodeNumber, Date depositDate, double amount, Employee employee, Account account, DepositType depositType) {
        this.depositBranch = depositBranch;
        this.loanCodeNumber = loanCodeNumber;
        this.depositDate = depositDate;
        this.amount = amount;
        this.employee = employee;
        this.account = account;
        this.depositType = depositType;
    }

    //Getter and Setter method
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDepositBranch() {
        return depositBranch;
    }

    public void setDepositBranch(String depositBranch) {
        this.depositBranch = depositBranch;
    }

    public Long getLoanCodeNumber() {
        return loanCodeNumber;
    }

    public void setLoanCodeNumber(Long loanCodeNumber) {
        this.loanCodeNumber = loanCodeNumber;
    }

    public Date getDepositDate() {
        return depositDate;
    }

    public void setDepositDate(Date depositDate) {
        this.depositDate = depositDate;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public DepositType getDepositType() {
        return depositType;
    }

    public void setDepositType(DepositType depositType) {
        this.depositType = depositType;
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
        Deposit deposit = (Deposit) o;
        return Double.compare(deposit.getAmount(), getAmount()) == 0
                && Objects.equals(getId(), deposit.getId())
                && Objects.equals(getDepositBranch(), deposit.getDepositBranch())
                && Objects.equals(getLoanCodeNumber(), deposit.getLoanCodeNumber())
                && Objects.equals(getDepositDate(), deposit.getDepositDate())
                && Objects.equals(getEmployee(), deposit.getEmployee())
                && Objects.equals(getAccount(), deposit.getAccount())
                && Objects.equals(getDepositType(), deposit.getDepositType());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getId(), getDepositBranch(), getLoanCodeNumber(), getDepositDate(), getAmount(), getEmployee(), getAccount(), getDepositType());
    }

    //toString method
    @Override
    public String toString() {
        return "Deposit{"
                + "id=" + id
                + ", depositBranch='" + depositBranch + '\''
                + ", loanCodeNumber=" + loanCodeNumber
                + ", depositDate=" + depositDate
                + ", amount=" + amount
                + ", employee=" + employee
                + ", account=" + account
                + ", depositType=" + depositType
                + '}';
    }
}
