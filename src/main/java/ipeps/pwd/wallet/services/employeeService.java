package ipeps.pwd.wallet.services;

import ipeps.pwd.wallet.dto.employeeDto;

import java.util.Date;
import java.util.List;

public interface employeeService {
    employeeDto Save(employeeDto dto);
    employeeDto FindById(Long id);
    employeeDto FindByLastname(String lastname);
    employeeDto FindByFirstname(String firstname);
    employeeDto FindByAdress(String adress);
    employeeDto FindByGender(String gender);
    employeeDto FindByBirthday(Date birthday);
    employeeDto FindBySsin(String ssin);
    List<employeeDto>FindAll();
    void  Delete(Long id);


}
