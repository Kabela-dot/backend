package ipeps.pwd.wallet.modele;

import lombok.*;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;

@Data
@Builder
@MappedSuperclass
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
public class AbstractEntity implements Serializable {
    @Id
    @GeneratedValue
    private  Long id;
    @CreatedDate
    @JsonIgnore
    @Column(name = "creationDate",nullable = false, insertable = false, updatable = false)
    private  Instant creationDate;
    @LastModifiedDate
    @JsonIgnore
    @Column(name = "lastmodificationDate")
    private Instant lastmodificationDate;
}
