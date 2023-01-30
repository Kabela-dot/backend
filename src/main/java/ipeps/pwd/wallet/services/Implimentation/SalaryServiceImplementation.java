package ipeps.pwd.wallet.services.Implimentation;



import ipeps.pwd.wallet.dto.SalaryDto;
import ipeps.pwd.wallet.exceptions.entityNotFoundException;
import ipeps.pwd.wallet.exceptions.erreursCodes;
import ipeps.pwd.wallet.exceptions.invalidEntityException;
import ipeps.pwd.wallet.modele.gestionSalary.Salary;
import ipeps.pwd.wallet.repository.SalaryRepository;
import ipeps.pwd.wallet.services.SalaryService;
import ipeps.pwd.wallet.validator.SalaryValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import java.util.stream.Collectors;

@Service
@Slf4j
public class SalaryServiceImplementation implements SalaryService {
    private final SalaryRepository salaryrepository;
    @Autowired
    public SalaryServiceImplementation(SalaryRepository salaryrepository)
    {
        this.salaryrepository = salaryrepository;

    }

    @Override
    public SalaryDto save(SalaryDto dto) {
        List<String>errors= SalaryValidator.validator(dto);
        if (!errors.isEmpty()){
            log.error("le salaire n'est pas valide {}",dto);
            throw new invalidEntityException("le salaire n'est pas valide",
                    erreursCodes.SALARY_NOT_VALID, errors);
        }
        Salary savesalary = salaryrepository.save(SalaryDto.toEntity(dto));
        return SalaryDto.fromEntity(savesalary) ;

    }



    @Override
    public SalaryDto findById(Long id) {
            if(id==null){
                log.error("salaire Id est nulle");
                return null;
            }
        return salaryrepository.findById(id)
                .map(SalaryDto::fromEntity)
                .orElseThrow(()->new entityNotFoundException("Aucun salaire avec l'id =" + id + "" +
                        " n'est trouvé dans la BD", erreursCodes.EMPLOYEE_NOT_FOUND));
           // Optional<salary> salary = salaryrepository.findById(id);
            //return Optional.of(salaryDto.fromEntity(salary.get())).orElseThrow(()->
            //        new entityNotFoundException("Aucun salaire avec l'ID =" + id + "" +
            //                " n'est trouvé dans la BD", erreursCodes.SALARY_NOT_FOUND)
           // );
    }

    @Override
    public SalaryDto findByCreate_date(Date date) {
            if (!StringUtils.hasLength((CharSequence) date)){
                log.error("la date de creation est nulle");
                return null;
            }
        return salaryrepository.findByCreate_date(date)
                .map(SalaryDto::fromEntity)
                .orElseThrow(()->new entityNotFoundException("Aucun salaire avec la date de creation =" + date  + "" +
                        " n'est trouvé dans la BD", erreursCodes.EMPLOYEE_NOT_FOUND));
           // Optional<salary>salary = salaryrepository.findByCreate_date(date);
           // return Optional.of(salaryDto.fromEntity(salary.get())).orElseThrow(()->
           //         new entityNotFoundException("Aucun salaire avec le nom =" + date + "" +
           //                 " n'est trouvé dans la BD", erreursCodes.SALARY_NOT_FOUND)
           // );
    }

    @Override
    public SalaryDto findByAmount(BigDecimal amount) {

            if (!StringUtils.hasLength((CharSequence) amount)){
                log.error("le montant de salaire est nulle");
                return null;
            }
        return salaryrepository.findByAmount(amount)
                .map(SalaryDto::fromEntity)
                .orElseThrow(()->new entityNotFoundException("Aucun salaire avec le montant indique =" + amount + "" +
                        " n'est trouvé dans la BD", erreursCodes.EMPLOYEE_NOT_FOUND));
            //Optional<salary>salary = salaryrepository.findByAmount(amount);
            //return Optional.of(salaryDto.fromEntity(salary.get())).orElseThrow(()->
             //       new entityNotFoundException("Aucune somme de salaire avec le nom =" + amount + "" +
             //               " n'est trouvé dans la BD", erreursCodes.SALARY_NOT_FOUND)
            //);



    }

    @Override
    public List<SalaryDto> findAll() {
            return salaryrepository.findAll().stream()
                    .map(SalaryDto::fromEntity)
                    .collect(Collectors.toList());
    }

    @Override
    public void Delete(Long id) {

            if (id==null)
            {
                log.error("l'Id de salaire est null");
            }
        assert id != null;
        salaryrepository.deleteById(id);

    }
}
