package ipeps.pwd.wallet.services.Implimentation;

import ipeps.pwd.wallet.dto.employeeDto;
import ipeps.pwd.wallet.exceptions.entityNotFoundException;
import ipeps.pwd.wallet.exceptions.erreursCodes;
import ipeps.pwd.wallet.exceptions.invalidEntityException;
import ipeps.pwd.wallet.modele.gestionEmployees.employee;
import ipeps.pwd.wallet.repository.employeerepository;
import ipeps.pwd.wallet.services.employeeService;
import ipeps.pwd.wallet.validator.employeevalidator;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.lang.String;
import java.util.stream.Collectors;



@Service
@Slf4j


public class employeeServiceImplementation implements employeeService {
    private employeerepository employeerepository;
    @Autowired
    public employeeServiceImplementation(employeerepository employeerepository)
    {

        this.employeerepository = employeerepository;
    }

    @Override


    public employeeDto Save( employeeDto dto) {
        List<String>errors= employeevalidator.validator(dto);
        if (!errors.isEmpty()){
            log.error("l'employe n'est pas valide {}",dto);
            throw new invalidEntityException("l'employé n'est pas valide",
                    erreursCodes.EMPLOYEE_NOT_VALID, errors);
        }
        employee saveEmployee = employeerepository.save(employeeDto.toEntity(dto));
        return employeeDto.fromEntity(employeerepository.save(employeeDto.toEntity(dto))) ;
    }

    @Override
    public employeeDto FindById(Long id) {
        if(id==null){
            log.error("employee Id est nulle");
            return null;
        }
        Optional<employee>employee=employeerepository.findById(id);
        return Optional.of(employeeDto.fromEntity(employee.get())).orElseThrow(()->
        new entityNotFoundException("Aucun employé avec l'ID =" + id + "" +
                " n'est trouvé dans la BD", erreursCodes.EMPLOYEE_NOT_FOUND)
        );
    }

    @Override
    public employeeDto FindByLastname(String lastname) {
        if (!StringUtils.hasLength(lastname)){
            log.error("Le nom est null");
            return null;
        }
        Optional<employee>employee = employeerepository.findByLastname(lastname);
        return Optional.of(employeeDto.fromEntity(employee.get())).orElseThrow(()->
                new entityNotFoundException("Aucun employé avec le nom =" + lastname + "" +
                        " n'est trouvé dans la BD", erreursCodes.EMPLOYEE_NOT_FOUND)
        );


    }

    @Override
    public employeeDto FindByFirstname( String firstname) {
        if (!StringUtils.hasLength(firstname)){
            log.error("Le prenom est null");
            return null;
        }
        Optional<employee>employee = employeerepository.findByFirstname(firstname);
        return Optional.of(employeeDto.fromEntity(employee.get())).orElseThrow(()->
                new entityNotFoundException("Aucun employé avec le nom =" + firstname + "" +
                        " n'est trouvé dans la BD", erreursCodes.EMPLOYEE_NOT_FOUND)
        );



    }

    @Override
    public employeeDto FindByAdress(String adress) {
        if (!StringUtils.hasLength(adress)){
            log.error("l'adresse est null");
            return null;
        }
        Optional<employee>employee = employeerepository.findByAdress(adress);
        return Optional.of(employeeDto.fromEntity(employee.get())).orElseThrow(()->
                new entityNotFoundException("Aucun employé avec le nom =" + adress + "" +
                        " n'est trouvé dans la BD", erreursCodes.EMPLOYEE_NOT_FOUND)
        );


    }

    @Override
    public employeeDto FindByGender(String gender) {
        if (!StringUtils.hasLength(gender)){
            log.error("le genre est null");
            return null;
        }
        Optional<employee>employee = employeerepository.findByGender(gender);
        return Optional.of(employeeDto.fromEntity(employee.get())).orElseThrow(()->
                new entityNotFoundException("Aucun employé avec le nom =" + gender + "" +
                        " n'est trouvé dans la BD", erreursCodes.EMPLOYEE_NOT_FOUND)
        );


    }

    @Override
    public employeeDto FindByBirthday(Date birthday) {
        if (!StringUtils.hasLength((CharSequence) birthday)){
            log.error("la date de naissance est null");
            return null;
        }
        Optional<employee>employee = employeerepository.findByBirthday(birthday);
        return Optional.of(employeeDto.fromEntity(employee.get())).orElseThrow(()->
                new entityNotFoundException("Aucun employé avec le nom =" + birthday + "" +
                        " n'est trouvé dans la BD", erreursCodes.EMPLOYEE_NOT_FOUND)
        );


    }

    @Override
    public employeeDto FindBySsin(String ssin) {
        if (!StringUtils.hasLength(ssin)){
            log.error("le numero ssin est null");
            return null;
        }
        Optional<employee>employee = employeerepository.findBySsin(ssin);
        return Optional.of(employeeDto.fromEntity(employee.get())).orElseThrow(()->
                new entityNotFoundException("Aucun employé avec le nom =" + ssin  + "" +
                        " n'est trouvé dans la BD", erreursCodes.EMPLOYEE_NOT_FOUND)
        );


    }

    @Override
    public List<employeeDto> FindAll() {
        return employeerepository.findAll().stream()
                .map(employeeDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void Delete(Long id) {
        if (id==null){
            log.error("l'Id de l'employee est null");
            return;
        }
        employeerepository.deleteById(id);

    }
}
