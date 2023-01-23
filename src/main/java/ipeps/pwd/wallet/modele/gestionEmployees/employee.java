package ipeps.pwd.wallet.modele.gestionEmployees;

import ipeps.pwd.wallet.modele.AbstractEntity;
import ipeps.pwd.wallet.modele.gestionSalary.salary;
import lombok.*;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;



@Entity

@Data
//@NoArgsConstructor
//@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Table(name = "employee")
@Embeddable
public class employee extends AbstractEntity implements Serializable {
    public employee(Long id, String lastname, String firstname, String active,
                    String deleted_by, String adress, String gender, Date birthday,
                    String ssin, String status, String deleted, List<salary> salaries) {
        this.id = id;
        this.lastname = lastname;
        this.firstname = firstname;
        this.active = active;
        this.deleted_by = deleted_by;
        this.adress = adress;
        this.gender = gender;
        this.birthday = birthday;
        this.ssin = ssin;
        this.status = status;
        this.deleted = deleted;
        this.salaries = salaries;
    }
    public employee(){

    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long id;
    @Column(name="Latsname")
    private String lastname;
    @Column(name="Firstname")
    private String firstname;
    private  String active;
    private  String deleted_by;
    @Embedded
    private  String adress;
    private  String gender;
    private Date birthday;
    private  String ssin;
    private  String status;
    private  String deleted;
   @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
   //@JoinColumn(name = "id")
   @MapsId(value = "id")
    private List<salary> salaries;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLastname() {
        return lastname;
    }

    //public void setLastname(String lastname) {
     //   this.lastname = lastname;
    //}

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getDeleted_by() {
        return deleted_by;
    }

    public void setDeleted_by(String deleted_by) {
        this.deleted_by = deleted_by;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getSsin() {
        return ssin;
    }

    public void setSsin(String ssin) {
        this.ssin = ssin;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDeleted() {
        return deleted;
    }

    public void setDeleted(String deleted) {
        this.deleted = deleted;
    }
}
