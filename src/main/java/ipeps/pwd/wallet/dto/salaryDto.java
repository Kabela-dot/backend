package ipeps.pwd.wallet.dto;

import ipeps.pwd.wallet.modele.gestionSalary.salary;
import lombok.Builder;
import lombok.Data;


import java.math.BigDecimal;
import java.util.Date;
@Builder
@Data

public class salaryDto {

    private Date create_date;

    private  String title;

    private  String comment;
    private BigDecimal amount;
    //Mapping de salary vers salaryDto
    public static  salaryDto fromEntity(salary salary)
    {
        if(salary==null){
            return  null;
        }
        return salaryDto.builder()
                .amount(salary.getAmount())
                .comment(salary.getComment())
                .create_date(salary.getCreate_date())
                .title(salary.getTitle())
                .build();


    }
    //Mapping de salaryDto vers salary
    public static    salary toEntity(salaryDto salaryDto){
        if(salaryDto==null){
            return  null;
        }
       salary salary = new salary();
       salary.setAmount(salaryDto.getAmount());
       salary.setComment(salaryDto.getComment());
       salary.setCreate_date(salaryDto.getCreate_date());
       salary.setTitle(salaryDto.getTitle());
       return salary;
    }
}
