package ipeps.pwd.wallet.repository;

import ipeps.pwd.wallet.modele.gestionEmployees.Employee;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;
@SpringBootApplication
@ImportResource({"classpath*:application-context.xml"})

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Optional<Employee> findBySsin(String ssin);

    Optional<Employee> findByBirthday(Date birthday);

    Optional<Employee> findByGender(String gender);

    Optional<Employee> findByAddress(String address);

    Optional<Employee> findByFirstname(String firstname);

    Optional<Employee> findByLastname(String lastname);
    List<Employee> findByNameContains(String keyword);

  
}
