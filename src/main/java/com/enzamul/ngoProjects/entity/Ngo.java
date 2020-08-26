package com.enzamul.ngoProjects.entity;

import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author MD ENZAMUL HOQ
 */
@Entity
@Table(name = "ngo")
public class Ngo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ngo_name", unique = true, nullable = false)
    private String name;

    @Column(name = "ngo_owner", unique = true, nullable = false)
    private String ownersName;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date ngoRegiDate = new Date();

    @Column(name = "address", unique = true, nullable = false)
    private String address;

    @Column(name = "ngo_mobile", unique = true, nullable = false)
    private String mobile;

    @Column(name = "ngo_email", unique = true, nullable = false)
    private String email;

    @Column(name = "ngo_service", unique = true)
    private String ngoService;

    //Constructor
    public Ngo() {
    }

    public Ngo(String name, String ownersName, Date ngoRegiDate, String address, String mobile, String email, String ngoService) {
        this.name = name;
        this.ownersName = ownersName;
        this.ngoRegiDate = ngoRegiDate;
        this.address = address;
        this.mobile = mobile;
        this.email = email;
        this.ngoService = ngoService;
    }

    //Setter and Getter method
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwnersName() {
        return ownersName;
    }

    public void setOwnersName(String ownersName) {
        this.ownersName = ownersName;
    }

    public Date getNgoRegiDate() {
        return ngoRegiDate;
    }

    public void setNgoRegiDate(Date ngoRegiDate) {
        this.ngoRegiDate = ngoRegiDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNgoService() {
        return ngoService;
    }

    public void setNgoService(String ngoService) {
        this.ngoService = ngoService;
    }

    //Equals and hashCode method
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Ngo ngo = (Ngo) o;
        return Objects.equals(getId(), ngo.getId())
                && Objects.equals(getName(), ngo.getName())
                && Objects.equals(getOwnersName(), ngo.getOwnersName())
                && Objects.equals(getNgoRegiDate(), ngo.getNgoRegiDate())
                && Objects.equals(getAddress(), ngo.getAddress())
                && Objects.equals(getMobile(), ngo.getMobile())
                && Objects.equals(getEmail(), ngo.getEmail())
                && Objects.equals(getNgoService(), ngo.getNgoService());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getOwnersName(), getNgoRegiDate(), getAddress(), getMobile(), getEmail(), getNgoService());
    }

    //toString
    @Override
    public String toString() {
        return "Ngo{"
                + "id=" + id
                + ", name='" + name + '\''
                + ", ownersName='" + ownersName + '\''
                + ", ngoRegiDate=" + ngoRegiDate
                + ", address='" + address + '\''
                + ", mobile='" + mobile + '\''
                + ", email='" + email + '\''
                + ", ngoService='" + ngoService + '\''
                + '}';
    }
}
