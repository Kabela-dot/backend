package ipeps.pwd.wallet.controller.api;

import ipeps.pwd.wallet.dto.EmployeeDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.Date;
import java.util.List;

import static ipeps.pwd.wallet.utiles.constante.APP_ROOT;

public interface EmployeeApi {
    @PostMapping(value = APP_ROOT + "/employee/create", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    EmployeeDto save(@RequestBody EmployeeDto dto);

    @GetMapping(value = APP_ROOT + "employee/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    EmployeeDto findById(@PathVariable ("id") Long  id);

    @GetMapping(value = APP_ROOT + "employee/{lastname}", produces = MediaType.APPLICATION_JSON_VALUE)
    EmployeeDto findByLastname(@PathVariable("lastname") String lastname);

    @GetMapping(value = APP_ROOT + "employee/{firstname}", produces = MediaType.APPLICATION_JSON_VALUE)
    EmployeeDto findByFirstname(@PathVariable("firstname") String firstname);

    @GetMapping(value = APP_ROOT + "employee/{address}", produces = MediaType.APPLICATION_JSON_VALUE)
    EmployeeDto findByAddress(@PathVariable("address") String address);



    @GetMapping(value = APP_ROOT + "employee/{gender}", produces = MediaType.APPLICATION_JSON_VALUE)
    EmployeeDto findByGender(@PathVariable("gender") String gender);


    @GetMapping(value = APP_ROOT + "employee/{birthday}", produces = MediaType.APPLICATION_JSON_VALUE)
    EmployeeDto findByBirthday(@PathVariable("birthday") Date birthday);


    @GetMapping(value = APP_ROOT + "employee/{ssin}", produces = MediaType.APPLICATION_JSON_VALUE)
    EmployeeDto findBySsin(@PathVariable("ssin") String ssin);


    @GetMapping(value = APP_ROOT + "employee/all", produces = MediaType.APPLICATION_JSON_VALUE)
    List<EmployeeDto> findAll();


    @DeleteMapping(APP_ROOT + "employee/delete/{id}")
    void Delete(@PathVariable("id") Long id);



    @RequestMapping("/employee/search")
    List<EmployeeDto> searchEmployee(@RequestParam(name = "keyword", defaultValue = "") String keyword);
}
