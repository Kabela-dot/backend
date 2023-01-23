package ipeps.pwd.wallet.controller;

import ipeps.pwd.wallet.controller.api.employeeApi;
import ipeps.pwd.wallet.dto.employeeDto;
import ipeps.pwd.wallet.services.employeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class employeecontroller implements employeeApi {
    private employeeService employeeService;
    @Autowired
    public employeecontroller( employeeService employeeService) {
        this.employeeService = employeeService;

    }

    @Override
    public employeeDto save(employeeDto dto) {
        return employeeService.save(dto);
    }

    @Override
    public employeeDto findById(Long id) {
        return employeeService.findById(id);
    }

    @Override
    public employeeDto findByLastname(String lastname) {
        return employeeService.findByLastname(lastname);
    }

    @Override
    public employeeDto findByFirstname(String firstname) {
        return employeeService.findByFirstname(firstname);
    }

    @Override
    public employeeDto findByAdress(String adress) {
        return employeeService.findByAdress(adress);
    }

    @Override
    public employeeDto findByGender(String gender) {
        return employeeService.findByGender(gender);
    }

    @Override
    public employeeDto findByBirthday(Date birthday) {
        return employeeService.findByBirthday(birthday);
    }

    @Override
    public employeeDto findBySsin(String ssin) {
        return employeeService.findBySsin(ssin);
    }

    @Override
    public List<employeeDto> findAll() {
        return employeeService.findAll();
    }

    @Override
    public void Delete(Long id) {
        employeeService.Delete(id);

    }
}
