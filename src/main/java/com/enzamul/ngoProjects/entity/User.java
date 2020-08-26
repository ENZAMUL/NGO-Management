package com.enzamul.ngoProjects.entity;

import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

/**
 *
 * @author MD ENZAMUL HOQ
 */
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 2, max = 30, message = "Hey, Size must be between 2 and 30")
    @Column(name = "user_name", unique = true, nullable = false)
    private String username;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthDate;

    @Min(value = 18, message = "Hey, Minium Age is 18")
    private byte age;

    @Column(name = "gender", nullable = false)
    private String gender;

    @Column(name = "address", nullable = false)
    private String address;

    @Temporal(TemporalType.TIMESTAMP)
    private Date regiDate = new Date();

    @NotEmpty(message = "Enter your valid email")
    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "mobile", unique = true)
    private String mobile;

    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate = new Date();

    //password
    @Column(nullable = true)
    private String password;

    //status
    private boolean status;

    //Token Activation
    @Column(nullable = false)
    private String conformationToken;

    ///ralation  between user class and role class
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles;

    //Constructor
    public User() {
    }

    public User(User user) {
        this.firstName = user.firstName;
        this.username = user.username;
        this.password = user.password;
        this.email = user.email;
        this.status = user.status;
        this.roles = user.roles;
    }

    public User(@NotNull @Size(min = 2, max = 30, message = "Hey, Size must be between 2 and 30") String username, String firstName, String lastName, Date birthDate, @Min(value = 18, message = "Hey, Minium Age is 18") byte age, String gender, String address, Date regiDate, @NotEmpty(message = "Enter your valid email") String email, String mobile, Date lastModifiedDate, String password, boolean status, String conformationToken, Set<Role> roles) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.age = age;
        this.gender = gender;
        this.address = address;
        this.regiDate = regiDate;
        this.email = email;
        this.mobile = mobile;
        this.lastModifiedDate = lastModifiedDate;
        this.password = password;
        this.status = status;
        this.conformationToken = conformationToken;
        this.roles = roles;
    }

    //Setter and Getter method
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public byte getAge() {
        return age;
    }

    public void setAge(byte age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getRegiDate() {
        return regiDate;
    }

    public void setRegiDate(Date regiDate) {
        this.regiDate = regiDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getConformationToken() {
        return conformationToken;
    }

    public void setConformationToken(String conformationToken) {
        this.conformationToken = conformationToken;
    }

    //Equals and hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return getAge() == user.getAge()
                && isStatus() == user.isStatus()
                && Objects.equals(getId(), user.getId())
                && Objects.equals(getUsername(), user.getUsername())
                && Objects.equals(getFirstName(), user.getFirstName())
                && Objects.equals(getLastName(), user.getLastName())
                && Objects.equals(getBirthDate(), user.getBirthDate())
                && Objects.equals(getGender(), user.getGender())
                && Objects.equals(getAddress(), user.getAddress())
                && Objects.equals(getRegiDate(), user.getRegiDate())
                && Objects.equals(getEmail(), user.getEmail())
                && Objects.equals(getMobile(), user.getMobile())
                && Objects.equals(getLastModifiedDate(), user.getLastModifiedDate())
                && Objects.equals(getPassword(), user.getPassword())
                && Objects.equals(getConformationToken(), user.getConformationToken())
                && Objects.equals(getRoles(), user.getRoles());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getId(), getUsername(), getFirstName(), getLastName(), getBirthDate(), getAge(), getGender(), getAddress(), getRegiDate(), getEmail(), getMobile(), getLastModifiedDate(), getPassword(), isStatus(), getConformationToken(), getRoles());
    }

    // toString
    @Override
    public String toString() {
        return "User{"
                + "id=" + id
                + ", username='" + username + '\''
                + ", firstName='" + firstName + '\''
                + ", lastName='" + lastName + '\''
                + ", birthDate=" + birthDate
                + ", age=" + age
                + ", gender='" + gender + '\''
                + ", address='" + address + '\''
                + ", regiDate=" + regiDate
                + ", email='" + email + '\''
                + ", mobile='" + mobile + '\''
                + ", lastModifiedDate=" + lastModifiedDate
                + ", password='" + password + '\''
                + ", status=" + status
                + ", conformationToken='" + conformationToken + '\''
                + ", roles=" + roles
                + '}';
    }
}
