package ipeps.pwd.wallet.repository;


import ipeps.pwd.wallet.dto.salaryDto;
import ipeps.pwd.wallet.modele.gestionSalary.salary;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;
@SpringBootApplication
@ImportResource({"classpath*:application-context.xml"})

@Repository
public interface salaryrepository extends JpaRepository<salary, Long> {
    salaryDto save(salaryDto dto);
    //salaryDto findById(Long id);
    //salaryDto findByCreate_date( date);
    //salaryDto findByAmount(BigDecimal amount);


    @Override
    List<salary> findAll();

    void  Delete(Long id);

    Optional<salary> findByCreate_date(Date date);

    Optional<salary> findByAmount(BigDecimal amount);

}
