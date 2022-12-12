package ipeps.pwd.wallet.repository;

import ipeps.pwd.wallet.dto.employeeDto;
import ipeps.pwd.wallet.dto.salaryDto;
import ipeps.pwd.wallet.modele.gestionSalary.salary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Repository
public interface salaryrepository extends JpaRepository<salary, Long> {
    salaryDto Save(employeeDto dto);
    salaryDto FindById(Long id);
    salaryDto FindByCreate_date(Date date);
    salaryDto FindByAmount(BigDecimal amount);
    List<salaryDto> FindAll();
    void  Delete(Long id);
}
