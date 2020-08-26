package com.enzamul.ngoProjects.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author MD ENZAMUL HOQ
 */
@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "employee_name", nullable = false)
    private String employeeName;

    @Column(name = "employee_code", unique = true, nullable = false)
    private String employeeCode;

    @Column(name = "employee_gender", nullable = false)
    private String employeeGender;

    @Column(name = "employee_age", nullable = false)
    private int employeeAge;

    @Column(name = "employee_salary", nullable = false)
    private String employeeSalary;

    @Temporal(TemporalType.TIMESTAMP)
    private Date regiDate = new Date();

    @Column(name = "employee_mobile", nullable = false)
    private String emplooyeeMobile;

    @Column(name = "employee_address", nullable = false)
    private String employeeddress;

    @Column(name = "employee_nid", unique = true, nullable = false)
    private String employeeNid;
    /*
numberOfTotalEmployee
     */

    //RelationShip
    @ManyToOne
    @JoinColumn(name = "ngo_id", nullable = false)
    private Ngo ngo;

    @ManyToOne
    @JoinColumn(name = "branch_id", nullable = false)
    private Branch branch;

    @ManyToOne
    @JoinColumn(name = "emp_type_id", nullable = false)
    private EmployeeType employeeType;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    //Constructor
    public Employee() {
    }

    public Employee(String employeeName, String employeeCode, String employeeGender, int employeeAge, String employeeSalary, Date regiDate, String emplooyeeMobile, String employeeddress, String employeeNid, Ngo ngo, Branch branch, EmployeeType employeeType, User user) {
        this.employeeName = employeeName;
        this.employeeCode = employeeCode;
        this.employeeGender = employeeGender;
        this.employeeAge = employeeAge;
        this.employeeSalary = employeeSalary;
        this.regiDate = regiDate;
        this.emplooyeeMobile = emplooyeeMobile;
        this.employeeddress = employeeddress;
        this.employeeNid = employeeNid;
        this.ngo = ngo;
        this.branch = branch;
        this.employeeType = employeeType;
        this.user = user;
    }

//Getter and Setter method
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    public String getEmployeeGender() {
        return employeeGender;
    }

    public void setEmployeeGender(String employeeGender) {
        this.employeeGender = employeeGender;
    }

    public int getEmployeeAge() {
        return employeeAge;
    }

    public void setEmployeeAge(int employeeAge) {
        this.employeeAge = employeeAge;
    }

    public String getEmployeeSalary() {
        return employeeSalary;
    }

    public void setEmployeeSalary(String employeeSalary) {
        this.employeeSalary = employeeSalary;
    }

    public Date getRegiDate() {
        return regiDate;
    }

    public void setRegiDate(Date regiDate) {
        this.regiDate = regiDate;
    }

    public String getEmplooyeeMobile() {
        return emplooyeeMobile;
    }

    public void setEmplooyeeMobile(String emplooyeeMobile) {
        this.emplooyeeMobile = emplooyeeMobile;
    }

    public String getEmployeeddress() {
        return employeeddress;
    }

    public void setEmployeeddress(String employeeddress) {
        this.employeeddress = employeeddress;
    }

    public String getEmployeeNid() {
        return employeeNid;
    }

    public void setEmployeeNid(String employeeNid) {
        this.employeeNid = employeeNid;
    }

    public Ngo getNgo() {
        return ngo;
    }

    public void setNgo(Ngo ngo) {
        this.ngo = ngo;
    }

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    public EmployeeType getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(EmployeeType employeeType) {
        this.employeeType = employeeType;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
        Employee employee = (Employee) o;
        return getEmployeeAge() == employee.getEmployeeAge()
                && Objects.equals(getId(), employee.getId())
                && Objects.equals(getEmployeeName(), employee.getEmployeeName())
                && Objects.equals(getEmployeeCode(), employee.getEmployeeCode())
                && Objects.equals(getEmployeeGender(), employee.getEmployeeGender())
                && Objects.equals(getEmployeeSalary(), employee.getEmployeeSalary())
                && Objects.equals(getRegiDate(), employee.getRegiDate())
                && Objects.equals(getEmplooyeeMobile(), employee.getEmplooyeeMobile())
                && Objects.equals(getEmployeeddress(), employee.getEmployeeddress())
                && Objects.equals(getEmployeeNid(), employee.getEmployeeNid())
                && Objects.equals(getNgo(), employee.getNgo())
                && Objects.equals(getBranch(), employee.getBranch())
                && Objects.equals(getEmployeeType(), employee.getEmployeeType())
                && Objects.equals(getUser(), employee.getUser());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getEmployeeName(), getEmployeeCode(), getEmployeeGender(), getEmployeeAge(), getEmployeeSalary(), getRegiDate(), getEmplooyeeMobile(), getEmployeeddress(), getEmployeeNid(), getNgo(), getBranch(), getEmployeeType(), getUser());
    }

    //toString method
    @Override
    public String toString() {
        return "Employee{"
                + "id=" + id
                + ", employeeName='" + employeeName + '\''
                + ", employeeCode='" + employeeCode + '\''
                + ", employeeGender='" + employeeGender + '\''
                + ", employeeAge=" + employeeAge
                + ", employeeSalary='" + employeeSalary + '\''
                + ", regiDate=" + regiDate
                + ", emplooyeeMobile='" + emplooyeeMobile + '\''
                + ", employeeddress='" + employeeddress + '\''
                + ", employeeNid='" + employeeNid + '\''
                + ", ngo=" + ngo
                + ", branch=" + branch
                + ", employeeType=" + employeeType
                + ", user=" + user
                + '}';
    }
}
