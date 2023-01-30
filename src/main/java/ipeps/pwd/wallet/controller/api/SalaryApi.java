package ipeps.pwd.wallet.controller.api;

import ipeps.pwd.wallet.dto.SalaryDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import static ipeps.pwd.wallet.utiles.constante.APP_ROOT;

public interface SalaryApi {
    @PostMapping(value = APP_ROOT + "/salary/create", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    SalaryDto save(@RequestBody SalaryDto salaryDto);
    @GetMapping(value = APP_ROOT + "salary/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    SalaryDto findById(@PathVariable ("id")Long id);
    @GetMapping(value = APP_ROOT + "salary/{create_date}", produces = MediaType.APPLICATION_JSON_VALUE)
    SalaryDto findByCreate_date(@PathVariable ("create_date") Date date);
    @GetMapping(value = APP_ROOT + "salary/{amount}", produces = MediaType.APPLICATION_JSON_VALUE)
    SalaryDto findByAmount(@PathVariable("amount") BigDecimal amount);
    @GetMapping(value = APP_ROOT + "salary/all", produces = MediaType.APPLICATION_JSON_VALUE)
    List<SalaryDto> findAll();
    @DeleteMapping(APP_ROOT + "salary/delete/{id}")
    void  Delete(@PathVariable ("id") Long id);





}
