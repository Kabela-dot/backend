package ipeps.pwd.wallet.repository;


import ipeps.pwd.wallet.dto.SalaryDto;
import ipeps.pwd.wallet.modele.gestionSalary.Salary;
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
public interface SalaryRepository extends JpaRepository<Salary, Long> {
    SalaryDto save(SalaryDto dto);
    //salaryDto findById(Long id);
    //salaryDto findByCreate_date( date);
    //salaryDto findByAmount(BigDecimal amount);


    @Override
    List<Salary> findAll();

    void  Delete(Long id);

    Optional<Salary> findByCreate_date(Date date);

    Optional<Salary> findByAmount(BigDecimal amount);

}
