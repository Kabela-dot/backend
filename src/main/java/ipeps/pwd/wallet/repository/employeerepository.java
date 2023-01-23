package ipeps.pwd.wallet.repository;

import ipeps.pwd.wallet.modele.gestionEmployees.employee;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.Optional;
@SpringBootApplication
@ImportResource({"classpath*:application-context.xml"})

@Repository
public interface employeerepository extends JpaRepository<employee, Long> {
    Optional<employee> findBySsin(String ssin);

    Optional<employee> findByBirthday(Date birthday);

    Optional<employee> findByGender(String gender);

    Optional<employee> findByAdress(String adress);

    Optional<employee> findByFirstname(String firstname);

    Optional<employee> findByLastname(String lastname);

  
}
