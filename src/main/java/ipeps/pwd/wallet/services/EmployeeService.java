package ipeps.pwd.wallet.services;

import ipeps.pwd.wallet.dto.EmployeeDto;

import java.util.Date;
import java.util.List;

public interface EmployeeService {
    EmployeeDto save(EmployeeDto dto);
    EmployeeDto findById(Long id);
    EmployeeDto findByLastname(String lastname);
    EmployeeDto findByFirstname(String firstname);
    EmployeeDto findByAddress(String address);
    EmployeeDto findByGender(String gender);
    EmployeeDto findByBirthday(Date birthday);
    EmployeeDto findBySsin(String ssin);
    List<EmployeeDto>findAll();
    void  Delete(Long id);
    EmployeeDto findByNameContains(String keyword);
    List<EmployeeDto> searchEmployee(String keyword);
}
