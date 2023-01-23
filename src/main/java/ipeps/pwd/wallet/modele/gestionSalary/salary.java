package ipeps.pwd.wallet.modele.gestionSalary;

import ipeps.pwd.wallet.modele.AbstractEntity;
import ipeps.pwd.wallet.modele.gestionEmployees.employee;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


@Entity
@Data
@EqualsAndHashCode(callSuper = false)

//@NoArgsConstructor
//@AllArgsConstructor
@Table(name = "salary")
@ToString

public class salary extends AbstractEntity implements Serializable {
    public salary(Long id, Date create_date, String title, String comment, BigDecimal amount, ipeps.pwd.wallet.modele.gestionEmployees.employee employee) {
        this.id = id;
        this.create_date = create_date;
        this.title = title;
        this.comment = comment;
        this.amount = amount;
        this.employee = employee;
    }
    public salary(){

    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long id;
    @Column(name = "CreationDate")
    private Date create_date;
    @Column(name="Title")
    private  String title;
    @Column(name="Comment")
    private  String comment;
    private BigDecimal amount;
    @ManyToOne
    private employee employee;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
