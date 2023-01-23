package ipeps.pwd.wallet.services;

import ipeps.pwd.wallet.dto.employeeDto;

import java.util.Date;
import java.util.List;

public interface employeeService {
    employeeDto save(employeeDto dto);
    employeeDto findById(Long id);
    employeeDto findByLastname(String lastname);
    employeeDto findByFirstname(String firstname);
    employeeDto findByAdress(String adress);
    employeeDto findByGender(String gender);
    employeeDto findByBirthday(Date birthday);
    employeeDto findBySsin(String ssin);
    List<employeeDto>findAll();
    void  Delete(Long id);


}
