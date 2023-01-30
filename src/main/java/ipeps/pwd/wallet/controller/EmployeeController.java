package ipeps.pwd.wallet.controller;

import ipeps.pwd.wallet.controller.api.EmployeeApi;
import ipeps.pwd.wallet.dto.EmployeeDto;
import ipeps.pwd.wallet.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/employee")
@CrossOrigin("*")
public class EmployeeController implements EmployeeApi {
    private final EmployeeService employeeService;
    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;

    }

    @Override
    public EmployeeDto save(EmployeeDto dto) {
        return employeeService.save(dto);
    }

    @Override
    public EmployeeDto findById(Long id) {
        return employeeService.findById(id);
    }

    @Override
    public EmployeeDto findByLastname(String lastname) {
        return employeeService.findByLastname(lastname);
    }

    @Override
    public EmployeeDto findByFirstname(String firstname) {
        return employeeService.findByFirstname(firstname);
    }

    @Override
    public EmployeeDto findByAddress(String address) {
        return employeeService.findByAddress(address);
    }

    @Override
    public EmployeeDto findByGender(String gender) {

        return employeeService.findByGender(gender);
    }

    @Override
    public EmployeeDto findByBirthday(Date birthday) {

        return employeeService.findByBirthday(birthday);
    }

    @Override
    public EmployeeDto findBySsin(String ssin) {
        return employeeService.findBySsin(ssin);
    }

    @Override
    public List<EmployeeDto> findAll() {

        return employeeService.findAll();
    }

    @Override
    public void Delete(Long id) {
        employeeService.Delete(id);

    }
    public EmployeeDto findByNameContains(String keyword){
        return employeeService.findByNameContains(keyword);
    }
    @Override
    @RequestMapping("/employee/search")
    public  List<EmployeeDto> searchEmployee(@RequestParam(name = "keyword", defaultValue = "") String keyword)
    {

        return employeeService.searchEmployee(keyword);
    }
}
