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
@Table(name = "nominee")
public class Nominee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nomi_name", nullable = false)
    private String nomineeName;

    @Column(name = "nomi_age", nullable = false)
    private int nomineeAge;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "nomi_birth_date", nullable = false)
    private Date nomineeBirthDate;

    @Column(name = "nomi_gender", nullable = false)
    private String nomineeGender;

    @Column(name = "nomi_address", nullable = false)
    private String nomineeAddress;

    @Column(name = "nomi_mobile", nullable = false)
    private String nomineeMobile;


    @Column(name = "nomi_nid", nullable = false, unique = true)
    private String nomineeNid;


    //Nominee Relation with AccountHolder
    @Column(name = "nomi_relation", nullable = false)
    private String nomineeRelation;




 //Constructor

    public Nominee() {
    }

    public Nominee(String nomineeName, int nomineeAge, Date nomineeBirthDate, String nomineeGender, String nomineeAddress, String nomineeMobile, String nomineeNid, String nomineeRelation) {
        this.nomineeName = nomineeName;
        this.nomineeAge = nomineeAge;
        this.nomineeBirthDate = nomineeBirthDate;
        this.nomineeGender = nomineeGender;
        this.nomineeAddress = nomineeAddress;
        this.nomineeMobile = nomineeMobile;
        this.nomineeNid = nomineeNid;
        this.nomineeRelation = nomineeRelation;
    }



    //Getter and Setter method


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomineeName() {
        return nomineeName;
    }

    public void setNomineeName(String nomineeName) {
        this.nomineeName = nomineeName;
    }

    public int getNomineeAge() {
        return nomineeAge;
    }

    public void setNomineeAge(int nomineeAge) {
        this.nomineeAge = nomineeAge;
    }

    public Date getNomineeBirthDate() {
        return nomineeBirthDate;
    }

    public void setNomineeBirthDate(Date nomineeBirthDate) {
        this.nomineeBirthDate = nomineeBirthDate;
    }

    public String getNomineeGender() {
        return nomineeGender;
    }

    public void setNomineeGender(String nomineeGender) {
        this.nomineeGender = nomineeGender;
    }

    public String getNomineeAddress() {
        return nomineeAddress;
    }

    public void setNomineeAddress(String nomineeAddress) {
        this.nomineeAddress = nomineeAddress;
    }

    public String getNomineeMobile() {
        return nomineeMobile;
    }

    public void setNomineeMobile(String nomineeMobile) {
        this.nomineeMobile = nomineeMobile;
    }

    public String getNomineeNid() {
        return nomineeNid;
    }

    public void setNomineeNid(String nomineeNid) {
        this.nomineeNid = nomineeNid;
    }

    public String getNomineeRelation() {
        return nomineeRelation;
    }

    public void setNomineeRelation(String nomineeRelation) {
        this.nomineeRelation = nomineeRelation;
    }


    //Equals and HashCode method

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Nominee nominee = (Nominee) o;
        return getNomineeAge() == nominee.getNomineeAge() &&
                Objects.equals(getId(), nominee.getId()) &&
                Objects.equals(getNomineeName(), nominee.getNomineeName()) &&
                Objects.equals(getNomineeBirthDate(), nominee.getNomineeBirthDate()) &&
                Objects.equals(getNomineeGender(), nominee.getNomineeGender()) &&
                Objects.equals(getNomineeAddress(), nominee.getNomineeAddress()) &&
                Objects.equals(getNomineeMobile(), nominee.getNomineeMobile()) &&
                Objects.equals(getNomineeNid(), nominee.getNomineeNid()) &&
                Objects.equals(getNomineeRelation(), nominee.getNomineeRelation());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNomineeName(), getNomineeAge(), getNomineeBirthDate(), getNomineeGender(), getNomineeAddress(), getNomineeMobile(), getNomineeNid(), getNomineeRelation());
    }


    //toString


    @Override
    public String toString() {
        return "Nominee{" +
                "id=" + id +
                ", nomineeName='" + nomineeName + '\'' +
                ", nomineeAge=" + nomineeAge +
                ", nomineeBirthDate=" + nomineeBirthDate +
                ", nomineeGender='" + nomineeGender + '\'' +
                ", nomineeAddress='" + nomineeAddress + '\'' +
                ", nomineeMobile='" + nomineeMobile + '\'' +
                ", nomineeNid='" + nomineeNid + '\'' +
                ", nomineeRelation='" + nomineeRelation + '\'' +
                '}';
    }
}
