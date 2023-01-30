package ipeps.pwd.wallet.dto;

import ipeps.pwd.wallet.modele.gestionSalary.Salary;
import lombok.Builder;
import lombok.Data;


import java.math.BigDecimal;
import java.util.Date;
@Builder
@Data

public class SalaryDto {

    private Date create_date;

    private  String title;

    private  String comment;
    private BigDecimal amount;
    //Mapping de salary vers salaryDto
    public static SalaryDto fromEntity(Salary salary)
    {
        if(salary==null){
            return  null;
        }
        return SalaryDto.builder()
                .amount(salary.getAmount())
                .comment(salary.getComment())
                .create_date(salary.getCreate_date())
                .title(salary.getTitle())
                .build();


    }
    //Mapping de salaryDto vers salary
    public static Salary toEntity(SalaryDto salaryDto){
        if(salaryDto==null){
            return  null;
        }
       Salary salary = new Salary();
       salary.setAmount(salaryDto.getAmount());
       salary.setComment(salaryDto.getComment());
       salary.setCreate_date(salaryDto.getCreate_date());
       salary.setTitle(salaryDto.getTitle());
       return salary;
    }
}
