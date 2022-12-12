package ipeps.pwd.wallet.controller;

import ipeps.pwd.wallet.repository.salaryrepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/salary")
public class salarycontroller {
    private  final salaryrepository salaryrepository;

    public salarycontroller(ipeps.pwd.wallet.repository.salaryrepository salaryrepository) {
        this.salaryrepository = salaryrepository;
    }
    @GetMapping
    public ResponseEntity getAllsalaries(){
        return ResponseEntity.ok( this.salaryrepository.findAll());
    }
}
