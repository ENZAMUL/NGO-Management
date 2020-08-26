package com.enzamul.ngoProjects.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author MD ENZAMUL HOQ
 */
@Entity
@Table(name = "collection")
public class LoanCollection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ngo_total_amount", nullable = false)
    private double ngoOfTotalAmount;

    @Column(name = "collect_kisti_no", nullable = false)
    private int collectedKistiNo;

    @Column(name = "ngo_collect_amount", nullable = false)
    private double ngoOfCollectedAmount;

    @Temporal(TemporalType.TIMESTAMP)
    private Date collectionDate = new Date();

    //RelationShip
    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "account_id", nullable = false)
    private Account account;

    @ManyToOne
    @JoinColumn(name = "loan_id", nullable = false)
    private Loan loan;

    @ManyToOne
    @JoinColumn(name = "branch_id", nullable = false)
    private Branch branch;

    @ManyToOne
    @JoinColumn(name = "coll_type_id", nullable = false)
    private CollectionType collectionType;

    //Constructor
    public LoanCollection() {
    }

    public LoanCollection(double ngoOfTotalAmount, int collectedKistiNo, double ngoOfCollectedAmount, Date collectionDate, Employee employee, Account account, Loan loan, Branch branch, CollectionType collectionType) {
        this.ngoOfTotalAmount = ngoOfTotalAmount;
        this.collectedKistiNo = collectedKistiNo;
        this.ngoOfCollectedAmount = ngoOfCollectedAmount;
        this.collectionDate = collectionDate;
        this.employee = employee;
        this.account = account;
        this.loan = loan;
        this.branch = branch;
        this.collectionType = collectionType;
    }

    //Getter and Setter method
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getNgoOfTotalAmount() {
        return ngoOfTotalAmount;
    }

    public void setNgoOfTotalAmount(double ngoOfTotalAmount) {
        this.ngoOfTotalAmount = ngoOfTotalAmount;
    }

    public int getCollectedKistiNo() {
        return collectedKistiNo;
    }

    public void setCollectedKistiNo(int collectedKistiNo) {
        this.collectedKistiNo = collectedKistiNo;
    }

    public double getNgoOfCollectedAmount() {
        return ngoOfCollectedAmount;
    }

    public void setNgoOfCollectedAmount(double ngoOfCollectedAmount) {
        this.ngoOfCollectedAmount = ngoOfCollectedAmount;
    }

    public Date getCollectionDate() {
        return collectionDate;
    }

    public void setCollectionDate(Date collectionDate) {
        this.collectionDate = collectionDate;
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

    public Loan getLoan() {
        return loan;
    }

    public void setLoan(Loan loan) {
        this.loan = loan;
    }

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    public CollectionType getCollectionType() {
        return collectionType;
    }

    public void setCollectionType(CollectionType collectionType) {
        this.collectionType = collectionType;
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
        LoanCollection that = (LoanCollection) o;
        return Double.compare(that.getNgoOfTotalAmount(), getNgoOfTotalAmount()) == 0
                && getCollectedKistiNo() == that.getCollectedKistiNo()
                && Double.compare(that.getNgoOfCollectedAmount(), getNgoOfCollectedAmount()) == 0
                && Objects.equals(getId(), that.getId())
                && Objects.equals(getCollectionDate(), that.getCollectionDate())
                && Objects.equals(getEmployee(), that.getEmployee())
                && Objects.equals(getAccount(), that.getAccount())
                && Objects.equals(getLoan(), that.getLoan())
                && Objects.equals(getBranch(), that.getBranch())
                && Objects.equals(getCollectionType(), that.getCollectionType());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getId(), getNgoOfTotalAmount(), getCollectedKistiNo(), getNgoOfCollectedAmount(), getCollectionDate(), getEmployee(), getAccount(), getLoan(), getBranch(), getCollectionType());
    }

    //toString method
    @Override
    public String toString() {
        return "LoanCollection{"
                + "id=" + id
                + ", ngoOfTotalAmount=" + ngoOfTotalAmount
                + ", collectedKistiNo=" + collectedKistiNo
                + ", ngoOfCollectedAmount=" + ngoOfCollectedAmount
                + ", collectionDate=" + collectionDate
                + ", employee=" + employee
                + ", account=" + account
                + ", loan=" + loan
                + ", branch=" + branch
                + ", collectionType=" + collectionType
                + '}';
    }
}
