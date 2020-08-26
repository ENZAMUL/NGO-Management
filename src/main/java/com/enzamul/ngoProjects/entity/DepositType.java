package com.enzamul.ngoProjects.entity;

import javax.persistence.*;
import java.util.Objects;

/**
 *
 * @author MD ENZAMUL HOQ
 */
@Entity
@Table(name = "diposit_type")
public class DepositType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //   ( microCredit= weekly, quarterly, monthly),
    //   ( FixedTime = Six monthly, Yearly, Five year, Ten year)
    @Column(name = "type_name", nullable = false, unique = true)
    private String typeName;

    // Constructor
    public DepositType() {
    }

    public DepositType(String typeName) {
        this.typeName = typeName;
    }

    //Getter and Setter method
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
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
        DepositType that = (DepositType) o;
        return Objects.equals(getId(), that.getId())
                && Objects.equals(getTypeName(), that.getTypeName());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getId(), getTypeName());
    }

    //toString method
    @Override
    public String toString() {
        return "DepositType{"
                + "id=" + id
                + ", typeName='" + typeName + '\''
                + '}';
    }
}
