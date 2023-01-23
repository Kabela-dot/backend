package ipeps.pwd.wallet.controller.api;

import ipeps.pwd.wallet.dto.salaryDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import static ipeps.pwd.wallet.utiles.constante.APP_ROOT;

public interface salaryApi {
    @PostMapping(value = APP_ROOT + "/salary/create", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)

    salaryDto save(@RequestBody salaryDto salaryDto);
    @GetMapping(value = APP_ROOT + "salary/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    salaryDto findById(@PathVariable ("id")Long id);
    @GetMapping(value = APP_ROOT + "salary/{create_date}", produces = MediaType.APPLICATION_JSON_VALUE)
    salaryDto findByCreate_date(@PathVariable ("create_date") Date date);
    @GetMapping(value = APP_ROOT + "salary/{amount}", produces = MediaType.APPLICATION_JSON_VALUE)
    salaryDto findByAmount(@PathVariable("amount") BigDecimal amount);
    @GetMapping(value = APP_ROOT + "salary/all", produces = MediaType.APPLICATION_JSON_VALUE)
    List<salaryDto> findAll();
    @DeleteMapping(APP_ROOT + "salary/delete/{id}")
    void  Delete(@PathVariable ("id") Long id);





}
