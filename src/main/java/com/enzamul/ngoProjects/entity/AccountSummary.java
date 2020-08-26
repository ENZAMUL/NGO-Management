package com.enzamul.ngoProjects.entity;

import javax.persistence.*;
import java.util.Objects;

/**
 *
 * @author MD ENZAMUL HOQ
 */
@Entity
@Table(name = "account_summary")
public class AccountSummary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // deposit Summary
    @Column(name = "t_depo_amount", nullable = false)
    private double totalDepositAmount;  //getDepositClass

    @Column(name = "p_In_depo_amount", nullable = false)
    private double profitInDepositAmount;

    @Column(name = "t_dep_amount_wprofit", nullable = false)
    private double totalDepositAmountWithProfit;    //does not give data

    @Column(name = "wid_depo_amount", nullable = false)
    private double widthrewDepositAmount;   //getWithdrawClass

    @Column(name = "avail_depo_amount", nullable = false)
    private double availableDepositAmount;    //does not give data

    //loan Summary account wise
    @Column(name = "n_loan_taken", nullable = false)
    private int noOfLoanTaken;

    @Column(name = "n_loan_paid", nullable = false)
    private int noOfLoanPaid;

    @Column(name = "n_loan_due", nullable = false)
    private int noOfLoanDue;       //does not give data

    @Column(name = "t_loan_amount", nullable = false)
    private double totalLoanAmount;

    @Column(name = "t_loan_paid_amount", nullable = false)
    private double totalLoanPaidAmount;

    @Column(name = "t_loan_due_amount", nullable = false)
    private double totalLoanDueAmount;       //does not give data

    //current loan distribute
    @Column(name = "c_loan_amount", nullable = false)
    private double currentLoanAmount;

    @Column(name = "c_loan_paid_amount", nullable = false)
    private double currentLoanPaidAmount;

    @Column(name = "c_loan_due_amount", nullable = false)
    private double currentLoanDueAmount;

    // RelationShip
    //Relation between AccountSummary and Account Class
    @OneToOne
    @JoinColumn(name = "account_id", nullable = false)
    private Account account;

    //Constructor
    public AccountSummary() {
    }

    public AccountSummary(double totalDepositAmount, double profitInDepositAmount, double totalDepositAmountWithProfit, double widthrewDepositAmount, double availableDepositAmount, int noOfLoanTaken, int noOfLoanPaid, int noOfLoanDue, double totalLoanAmount, double totalLoanPaidAmount, double totalLoanDueAmount, double currentLoanAmount, double currentLoanPaidAmount, double currentLoanDueAmount, Account account) {
        this.totalDepositAmount = totalDepositAmount;
        this.profitInDepositAmount = profitInDepositAmount;
        this.totalDepositAmountWithProfit = totalDepositAmountWithProfit;
        this.widthrewDepositAmount = widthrewDepositAmount;
        this.availableDepositAmount = availableDepositAmount;
        this.noOfLoanTaken = noOfLoanTaken;
        this.noOfLoanPaid = noOfLoanPaid;
        this.noOfLoanDue = noOfLoanDue;
        this.totalLoanAmount = totalLoanAmount;
        this.totalLoanPaidAmount = totalLoanPaidAmount;
        this.totalLoanDueAmount = totalLoanDueAmount;
        this.currentLoanAmount = currentLoanAmount;
        this.currentLoanPaidAmount = currentLoanPaidAmount;
        this.currentLoanDueAmount = currentLoanDueAmount;
        this.account = account;
    }

    //Getter and Setter method
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getTotalDepositAmount() {
        return totalDepositAmount;
    }

    public void setTotalDepositAmount(double totalDepositAmount) {
        this.totalDepositAmount = totalDepositAmount;
    }

    public double getProfitInDepositAmount() {
        return profitInDepositAmount;
    }

    public void setProfitInDepositAmount(double profitInDepositAmount) {
        this.profitInDepositAmount = profitInDepositAmount;
    }

    public double getTotalDepositAmountWithProfit() {
        return totalDepositAmountWithProfit;
    }

    public void setTotalDepositAmountWithProfit(double totalDepositAmountWithProfit) {
        this.totalDepositAmountWithProfit = totalDepositAmountWithProfit;
    }

    public double getWidthrewDepositAmount() {
        return widthrewDepositAmount;
    }

    public void setWidthrewDepositAmount(double widthrewDepositAmount) {
        this.widthrewDepositAmount = widthrewDepositAmount;
    }

    public double getAvailableDepositAmount() {
        return availableDepositAmount;
    }

    public void setAvailableDepositAmount(double availableDepositAmount) {
        this.availableDepositAmount = availableDepositAmount;
    }

    public int getNoOfLoanTaken() {
        return noOfLoanTaken;
    }

    public void setNoOfLoanTaken(int noOfLoanTaken) {
        this.noOfLoanTaken = noOfLoanTaken;
    }

    public int getNoOfLoanPaid() {
        return noOfLoanPaid;
    }

    public void setNoOfLoanPaid(int noOfLoanPaid) {
        this.noOfLoanPaid = noOfLoanPaid;
    }

    public int getNoOfLoanDue() {
        return noOfLoanDue;
    }

    public void setNoOfLoanDue(int noOfLoanDue) {
        this.noOfLoanDue = noOfLoanDue;
    }

    public double getTotalLoanAmount() {
        return totalLoanAmount;
    }

    public void setTotalLoanAmount(double totalLoanAmount) {
        this.totalLoanAmount = totalLoanAmount;
    }

    public double getTotalLoanPaidAmount() {
        return totalLoanPaidAmount;
    }

    public void setTotalLoanPaidAmount(double totalLoanPaidAmount) {
        this.totalLoanPaidAmount = totalLoanPaidAmount;
    }

    public double getTotalLoanDueAmount() {
        return totalLoanDueAmount;
    }

    public void setTotalLoanDueAmount(double totalLoanDueAmount) {
        this.totalLoanDueAmount = totalLoanDueAmount;
    }

    public double getCurrentLoanAmount() {
        return currentLoanAmount;
    }

    public void setCurrentLoanAmount(double currentLoanAmount) {
        this.currentLoanAmount = currentLoanAmount;
    }

    public double getCurrentLoanPaidAmount() {
        return currentLoanPaidAmount;
    }

    public void setCurrentLoanPaidAmount(double currentLoanPaidAmount) {
        this.currentLoanPaidAmount = currentLoanPaidAmount;
    }

    public double getCurrentLoanDueAmount() {
        return currentLoanDueAmount;
    }

    public void setCurrentLoanDueAmount(double currentLoanDueAmount) {
        this.currentLoanDueAmount = currentLoanDueAmount;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
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
        AccountSummary that = (AccountSummary) o;
        return Double.compare(that.getTotalDepositAmount(), getTotalDepositAmount()) == 0
                && Double.compare(that.getProfitInDepositAmount(), getProfitInDepositAmount()) == 0
                && Double.compare(that.getTotalDepositAmountWithProfit(), getTotalDepositAmountWithProfit()) == 0
                && Double.compare(that.getWidthrewDepositAmount(), getWidthrewDepositAmount()) == 0
                && Double.compare(that.getAvailableDepositAmount(), getAvailableDepositAmount()) == 0
                && getNoOfLoanTaken() == that.getNoOfLoanTaken()
                && getNoOfLoanPaid() == that.getNoOfLoanPaid()
                && getNoOfLoanDue() == that.getNoOfLoanDue()
                && Double.compare(that.getTotalLoanAmount(), getTotalLoanAmount()) == 0
                && Double.compare(that.getTotalLoanPaidAmount(), getTotalLoanPaidAmount()) == 0
                && Double.compare(that.getTotalLoanDueAmount(), getTotalLoanDueAmount()) == 0
                && Double.compare(that.getCurrentLoanAmount(), getCurrentLoanAmount()) == 0
                && Double.compare(that.getCurrentLoanPaidAmount(), getCurrentLoanPaidAmount()) == 0
                && Double.compare(that.getCurrentLoanDueAmount(), getCurrentLoanDueAmount()) == 0
                && Objects.equals(getId(), that.getId())
                && Objects.equals(getAccount(), that.getAccount());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTotalDepositAmount(), getProfitInDepositAmount(), getTotalDepositAmountWithProfit(), getWidthrewDepositAmount(), getAvailableDepositAmount(), getNoOfLoanTaken(), getNoOfLoanPaid(), getNoOfLoanDue(), getTotalLoanAmount(), getTotalLoanPaidAmount(), getTotalLoanDueAmount(), getCurrentLoanAmount(), getCurrentLoanPaidAmount(), getCurrentLoanDueAmount(), getAccount());
    }

    //toString
    @Override
    public String toString() {
        return "AccountSummary{"
                + "id=" + id
                + ", totalDepositAmount=" + totalDepositAmount
                + ", profitInDepositAmount=" + profitInDepositAmount
                + ", totalDepositAmountWithProfit=" + totalDepositAmountWithProfit
                + ", widthrewDepositAmount=" + widthrewDepositAmount
                + ", availableDepositAmount=" + availableDepositAmount
                + ", noOfLoanTaken=" + noOfLoanTaken
                + ", noOfLoanPaid=" + noOfLoanPaid
                + ", noOfLoanDue=" + noOfLoanDue
                + ", totalLoanAmount=" + totalLoanAmount
                + ", totalLoanPaidAmount=" + totalLoanPaidAmount
                + ", totalLoanDueAmount=" + totalLoanDueAmount
                + ", currentLoanAmount=" + currentLoanAmount
                + ", currentLoanPaidAmount=" + currentLoanPaidAmount
                + ", currentLoanDueAmount=" + currentLoanDueAmount
                + ", account=" + account
                + '}';
    }
}
