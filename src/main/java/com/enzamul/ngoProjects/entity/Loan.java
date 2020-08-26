package com.enzamul.ngoProjects.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author MD ENZAMUL HOQ
 */
@Entity
@Table(name = "loan")
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "loan_code", nullable = false)
    private String loanCodeNumber;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "loan_date", nullable = false)
    private Date loanDate = new Date();

    @Column(name = "loan_amount", nullable = false)
    private double loanAmount;

    @Column(name = "no_loan_kisti", nullable = false)
    private int noOfKisti;   //loanAmountPerKisti

    @Column(name = "loan_payable_kisti", nullable = false)
    private String loanPayableKisti;   //numberofLoanPayableKisti

    /*
    interestRate
    profitOnLoanAmount
    payableLoanAmount
     */
 /*
    totalLoanAmount    //summary Hobe
     */
    //RelationShip
    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "account_id", nullable = false)
    private Account account;

    @ManyToOne
    @JoinColumn(name = "branch_id", nullable = false)
    private Branch branch;

    //Constructor
    public Loan() {
    }

    public Loan(String loanCodeNumber, Date loanDate, double loanAmount, int noOfKisti, String loanPayableKisti, Employee employee, Account account, Branch branch) {
        this.loanCodeNumber = loanCodeNumber;
        this.loanDate = loanDate;
        this.loanAmount = loanAmount;
        this.noOfKisti = noOfKisti;
        this.loanPayableKisti = loanPayableKisti;
        this.employee = employee;
        this.account = account;
        this.branch = branch;
    }

    //Getter and Setter method
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLoanCodeNumber() {
        return loanCodeNumber;
    }

    public void setLoanCodeNumber(String loanCodeNumber) {
        this.loanCodeNumber = loanCodeNumber;
    }

    public Date getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(Date loanDate) {
        this.loanDate = loanDate;
    }

    public double getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(double loanAmount) {
        this.loanAmount = loanAmount;
    }

    public int getNoOfKisti() {
        return noOfKisti;
    }

    public void setNoOfKisti(int noOfKisti) {
        this.noOfKisti = noOfKisti;
    }

    public String getLoanPayableKisti() {
        return loanPayableKisti;
    }

    public void setLoanPayableKisti(String loanPayableKisti) {
        this.loanPayableKisti = loanPayableKisti;
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

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
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
        Loan loan = (Loan) o;
        return Double.compare(loan.getLoanAmount(), getLoanAmount()) == 0
                && getNoOfKisti() == loan.getNoOfKisti()
                && Objects.equals(getId(), loan.getId())
                && Objects.equals(getLoanCodeNumber(), loan.getLoanCodeNumber())
                && Objects.equals(getLoanDate(), loan.getLoanDate())
                && Objects.equals(getLoanPayableKisti(), loan.getLoanPayableKisti())
                && Objects.equals(getEmployee(), loan.getEmployee())
                && Objects.equals(getAccount(), loan.getAccount())
                && Objects.equals(getBranch(), loan.getBranch());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getId(), getLoanCodeNumber(), getLoanDate(), getLoanAmount(), getNoOfKisti(), getLoanPayableKisti(), getEmployee(), getAccount(), getBranch());
    }

    //toString method
    @Override
    public String toString() {
        return "Loan{"
                + "id=" + id
                + ", loanCodeNumber='" + loanCodeNumber + '\''
                + ", loanDate=" + loanDate
                + ", loanAmount=" + loanAmount
                + ", noOfKisti=" + noOfKisti
                + ", loanPayableKisti='" + loanPayableKisti + '\''
                + ", employee=" + employee
                + ", account=" + account
                + ", branch=" + branch
                + '}';
    }
}
