package ipeps.pwd.wallet.controller.api;

import ipeps.pwd.wallet.dto.employeeDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.Date;
import java.util.List;

import static ipeps.pwd.wallet.utiles.constante.APP_ROOT;

public interface employeeApi {
    @PostMapping(value = APP_ROOT + "/employee/create", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    employeeDto Save(@RequestBody employeeDto dto);

    @GetMapping(value = APP_ROOT + "employee/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    employeeDto FindById(@PathVariable ("id") Long  id);

    @GetMapping(value = APP_ROOT + "employee/{lastname}", produces = MediaType.APPLICATION_JSON_VALUE)
    employeeDto FindByLastname(@PathVariable("lastname") String lastname);

    @GetMapping(value = APP_ROOT + "employee/{firstname}", produces = MediaType.APPLICATION_JSON_VALUE)
    employeeDto FindByFirstname(@PathVariable("firstname") String firstname);

    @GetMapping(value = APP_ROOT + "employee/{adress}", produces = MediaType.APPLICATION_JSON_VALUE)
    employeeDto FindByAdress(@PathVariable("adress") String adress);

    @GetMapping(value = APP_ROOT + "employee/{gender}", produces = MediaType.APPLICATION_JSON_VALUE)
    employeeDto FindByGender(@PathVariable("gender") String gender);


    @GetMapping(value = APP_ROOT + "employee/{birthday}", produces = MediaType.APPLICATION_JSON_VALUE)
    employeeDto FindByBirthday(@PathVariable("birthday") Date birthday);


    @GetMapping(value = APP_ROOT + "employee/{ssin}", produces = MediaType.APPLICATION_JSON_VALUE)
    employeeDto FindBySsin(@PathVariable("ssin") String ssin);


    @GetMapping(value = APP_ROOT + "employee/all", produces = MediaType.APPLICATION_JSON_VALUE)
    List<employeeDto> FindAll();


    @DeleteMapping(APP_ROOT + "employee/delete/{id}")
    void Delete(@PathVariable("id") Long id);

}
