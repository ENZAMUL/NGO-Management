package com.enzamul.ngoProjects.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author MD ENZAMUL HOQ
 */
@Entity
@Table(name = "withdraw_deposit")
public class Withdraw {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "amount", nullable = false)
    private double amount;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "withdraw_date", nullable = false)
    private Date withdrawDate = new Date();

    //RelationShip
    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "account_id", nullable = false)
    private Account account;

    //Constructor
    public Withdraw() {
    }

    public Withdraw(double amount, Date withdrawDate, Employee employee, Account account) {
        this.amount = amount;
        this.withdrawDate = withdrawDate;
        this.employee = employee;
        this.account = account;
    }

    //Getter and Setter method
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getWithdrawDate() {
        return withdrawDate;
    }

    public void setWithdrawDate(Date withdrawDate) {
        this.withdrawDate = withdrawDate;
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

    //Equals and HashCode method
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Withdraw withdraw = (Withdraw) o;
        return Double.compare(withdraw.getAmount(), getAmount()) == 0
                && Objects.equals(getId(), withdraw.getId())
                && Objects.equals(getWithdrawDate(), withdraw.getWithdrawDate())
                && Objects.equals(getEmployee(), withdraw.getEmployee())
                && Objects.equals(getAccount(), withdraw.getAccount());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getAmount(), getWithdrawDate(), getEmployee(), getAccount());
    }

    //toString
    @Override
    public String toString() {
        return "Withdraw{"
                + "id=" + id
                + ", amount=" + amount
                + ", withdrawDate=" + withdrawDate
                + ", employee=" + employee
                + ", account=" + account
                + '}';
    }
}
