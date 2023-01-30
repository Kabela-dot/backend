package ipeps.pwd.wallet.controller;

import ipeps.pwd.wallet.controller.api.SalaryApi;
import ipeps.pwd.wallet.dto.SalaryDto;
import ipeps.pwd.wallet.services.SalaryService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/salary")
@CrossOrigin("*")
public class SalaryController implements SalaryApi {
    private final SalaryService salaryService;

    public SalaryController(SalaryService salaryService) {
        this.salaryService = salaryService;
    }
     @Override
     public SalaryDto save(SalaryDto dto) {
        return salaryService.save(dto);
    }
    @Override

    public SalaryDto findById(Long id)
    {
        return salaryService.findById(id);
    }
    @Override
    public SalaryDto findByCreate_date(Date date){
        return salaryService.findByCreate_date(date);
    }

    //@Override
    //public salaryDto FindByAmount(String amount) {
      //  return salaryService.FindByAmount( amount);
    //}


    public SalaryDto findByAmount(BigDecimal amount){
        return salaryService.findByAmount(amount);
    }
    public List <SalaryDto> findAll(){
        return salaryService.findAll();
    }
    public void  Delete(Long id){
        salaryService.Delete(id);
    }

    //@GetMapping
    //public ResponseEntity getAllsalaries(){
     //   return ResponseEntity.ok( this.salaryrepository.findAll());
    //}
}
