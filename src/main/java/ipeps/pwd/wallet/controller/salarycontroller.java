package ipeps.pwd.wallet.controller;

import ipeps.pwd.wallet.controller.api.salaryApi;
import ipeps.pwd.wallet.dto.salaryDto;
import ipeps.pwd.wallet.services.salaryService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/salary")
public class salarycontroller implements salaryApi {
    private final   salaryService salaryService;

    public salarycontroller(salaryService salaryService) {
        this.salaryService = salaryService;
    }
     @Override
     public salaryDto save(salaryDto dto) {
        return salaryService.save(dto);
    }
    @Override

    public salaryDto  findById(Long id)
    {
        return salaryService.findById(id);
    }
    @Override
    public salaryDto findByCreate_date(Date date){
        return salaryService.findByCreate_date(date);
    }

    //@Override
    //public salaryDto FindByAmount(String amount) {
      //  return salaryService.FindByAmount( amount);
    //}


    public salaryDto findByAmount(BigDecimal amount){
        return salaryService.findByAmount(amount);
    }
    public List <salaryDto> findAll(){
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
