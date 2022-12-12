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
    public employeeDto Save(employeeDto dto) {
        return employeeService.Save(dto);
    }

    @Override
    public employeeDto FindById(Long id) {
        return employeeService.FindById(id);
    }

    @Override
    public employeeDto FindByLastname(String lastname) {
        return employeeService.FindByLastname(lastname);
    }

    @Override
    public employeeDto FindByFirstname(String firstname) {
        return employeeService.FindByFirstname(firstname);
    }

    @Override
    public employeeDto FindByAdress(String adress) {
        return employeeService.FindByAdress(adress);
    }

    @Override
    public employeeDto FindByGender(String gender) {
        return employeeService.FindByGender(gender);
    }

    @Override
    public employeeDto FindByBirthday(Date birthday) {
        return employeeService.FindByBirthday(birthday);
    }

    @Override
    public employeeDto FindBySsin(String ssin) {
        return employeeService.FindBySsin(ssin);
    }

    @Override
    public List<employeeDto> FindAll() {
        return employeeService.FindAll();
    }

    @Override
    public void Delete(Long id) {
        employeeService.Delete(id);

    }
}
