package com.enzamul.ngoProjects.entity;

import javax.persistence.*;
import java.util.Objects;

/**
 *
 * @author MD ENZAMUL HOQ
 */
@Entity
@Table(name = "branch")
public class Branch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "branch_name", nullable = false)
    private String branchName;

    @Column(name = "branch_code", nullable = false)
    private String branchCode;

    @Column(name = "branch_address", nullable = false)
    private String branchAddress;
    /*
brnachPhoneNo
numberOfTotalBranch
     */

    @ManyToOne
    @JoinColumn(name = "ngo_id")
    private Ngo ngo;

    //Constructor
    public Branch() {
    }

    public Branch(String branchName, String branchCode, String branchAddress, Ngo ngo) {
        this.branchName = branchName;
        this.branchCode = branchCode;
        this.branchAddress = branchAddress;
        this.ngo = ngo;
    }

//Getter and Setter method
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getBranchCode() {
        return branchCode;
    }

    public void setBranchCode(String branchCode) {
        this.branchCode = branchCode;
    }

    public String getBranchAddress() {
        return branchAddress;
    }

    public void setBranchAddress(String branchAddress) {
        this.branchAddress = branchAddress;
    }

    public Ngo getNgo() {
        return ngo;
    }

    public void setNgo(Ngo ngo) {
        this.ngo = ngo;
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
        Branch branch = (Branch) o;
        return Objects.equals(getId(), branch.getId())
                && Objects.equals(getBranchName(), branch.getBranchName())
                && Objects.equals(getBranchCode(), branch.getBranchCode())
                && Objects.equals(getBranchAddress(), branch.getBranchAddress())
                && Objects.equals(getNgo(), branch.getNgo());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getBranchName(), getBranchCode(), getBranchAddress(), getNgo());
    }

    //toString
    @Override
    public String toString() {
        return "Branch{"
                + "id=" + id
                + ", branchName='" + branchName + '\''
                + ", branchCode='" + branchCode + '\''
                + ", branchAddress='" + branchAddress + '\''
                + ", ngo=" + ngo
                + '}';
    }
}
