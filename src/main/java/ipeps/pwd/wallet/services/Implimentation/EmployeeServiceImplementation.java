package ipeps.pwd.wallet.services.Implimentation;

import ipeps.pwd.wallet.dto.EmployeeDto;
import ipeps.pwd.wallet.exceptions.entityNotFoundException;
import ipeps.pwd.wallet.exceptions.erreursCodes;
import ipeps.pwd.wallet.exceptions.invalidEntityException;
import ipeps.pwd.wallet.modele.gestionEmployees.Employee;
import ipeps.pwd.wallet.repository.EmployeeRepository;
import ipeps.pwd.wallet.services.EmployeeService;
import ipeps.pwd.wallet.validator.EmployeeValidator;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;

import java.lang.String;
import java.util.stream.Collectors;



@Service
@Slf4j


public class EmployeeServiceImplementation implements EmployeeService {
    private final EmployeeRepository employeerepository;
    @Autowired
    public EmployeeServiceImplementation(EmployeeRepository employeerepository)
    {

        this.employeerepository = employeerepository;
    }

    @Override
    public EmployeeDto save(EmployeeDto dto) {
        List<String>errors= EmployeeValidator.validator(dto);
        if (!errors.isEmpty()){
            log.error("l'employe n'est pas valide {}",dto);
            throw new invalidEntityException("l'employé n'est pas valide",
                    erreursCodes.EMPLOYEE_NOT_VALID, errors);
        }
        Employee saveEmployee = employeerepository.save(EmployeeDto.toEntity(dto));
        return EmployeeDto.fromEntity(saveEmployee) ;
    }

    @Override
    public EmployeeDto findById(Long id) {
        if(id==null){
            log.error("employee Id est nulle");
            return null;
        }
        return employeerepository.findById(id)
                .map(EmployeeDto::fromEntity)
                .orElseThrow(()->new entityNotFoundException("Aucun employé avec l'ID =" + id + "" +
                        " n'est trouvé dans la BD", erreursCodes.EMPLOYEE_NOT_FOUND));

    }

    @Override
    public EmployeeDto findByLastname(String lastname) {
        if (!StringUtils.hasLength(lastname)){
            log.error("Le nom est null");
            return null;
        }
        return employeerepository.findByLastname(lastname)
                .map(EmployeeDto::fromEntity)
                .orElseThrow(()->new entityNotFoundException("Aucun employé avec le nom =" + lastname + "" +
                        " n'est trouvé dans la BD", erreursCodes.EMPLOYEE_NOT_FOUND));



    }

    @Override
    public EmployeeDto findByFirstname(String firstname) {
        if (!StringUtils.hasLength(firstname)){
            log.error("Le prenom est null");
            return null;
        }
        return employeerepository.findByFirstname(firstname)
                .map(EmployeeDto::fromEntity)
                .orElseThrow(()->new entityNotFoundException("Aucun employé avec le prenom =" + firstname + "" +
                        " n'est trouvé dans la BD", erreursCodes.EMPLOYEE_NOT_FOUND));




    }

    @Override
    public EmployeeDto findByAddress(String address) {
        if (!StringUtils.hasLength(address)){
            log.error("l'adresse est null");
            return null;
        }
        return employeerepository.findByAddress(address)
                .map(EmployeeDto::fromEntity)
                .orElseThrow(()->new entityNotFoundException("Aucun employé avec l'adresse =" + address + "" +
                        " n'est trouvé dans la BD", erreursCodes.EMPLOYEE_NOT_FOUND));



    }

    @Override
    public EmployeeDto findByGender(String gender) {
        if (!StringUtils.hasLength((CharSequence)  gender)){
            log.error("la date de naissance est null");
            return null;
        }
        return employeerepository.findByGender(gender)
                .map(EmployeeDto::fromEntity)
                .orElseThrow(()->new entityNotFoundException("Aucun employé avec le genre =" + gender + "" +
                        " n'est trouvé dans la BD", erreursCodes.EMPLOYEE_NOT_FOUND));


    }

    @Override
    public EmployeeDto findByBirthday(Date birthday) {
        if (!StringUtils.hasLength((CharSequence) birthday)) {
            log.error("la date de naissance est null");
            return null;
        }
            return employeerepository.findByBirthday(birthday)
                    .map(EmployeeDto::fromEntity)
                    .orElseThrow(() -> new entityNotFoundException("Aucun employé avec la date de naissance =" + birthday + "" +
                            " n'est trouvé dans la BD", erreursCodes.EMPLOYEE_NOT_FOUND));



    }

    @Override
        public EmployeeDto findBySsin(String ssin){
        if (!StringUtils.hasLength(ssin)){
            log.error("le numero ssin est null");
            return null;
        }
            return employeerepository.findBySsin(ssin)
                   .map(EmployeeDto::fromEntity)
                   .orElseThrow(()->new entityNotFoundException("Aucun employé avec le nom =" + ssin + "" +
                           " n'est trouvé dans la BD", erreursCodes.EMPLOYEE_NOT_FOUND));



    }

    @Override
    public List<EmployeeDto> findAll() {
        return employeerepository.findAll().stream()
                .map(EmployeeDto::fromEntity)
                .collect(Collectors.toList());
    }
  @Override
    public List<EmployeeDto> searchEmployee(String keyword){
        List<EmployeeDto>employeeDtoList = employeerepository.findByNameContains(keyword).stream()
                .map(EmployeeDto::fromEntity)
                .collect(Collectors.toList());
        return employeeDtoList;
    }

    @Override
    public void Delete(Long id) {
        if (id==null){
            log.error("l'Id de l'employee est null");
            return;
        }
        employeerepository.deleteById(id);

    }

    @Override
    public EmployeeDto findByNameContains(String keyword) {
        return null;
    }

}
