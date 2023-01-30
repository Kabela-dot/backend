package ipeps.pwd.wallet.validator;

import ipeps.pwd.wallet.dto.SalaryDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class SalaryValidator {

    public static   List<String> validator(SalaryDto salaryDto) {
        List<String> errors = new ArrayList<>();
        if(salaryDto==null){
            errors.add("Veuillez renseigner le Titre !");
            errors.add("Veuillez renseigner le commentaire !");
            errors.add("Veuillez renseigner le montant !");
            return errors;

        }
        if(!StringUtils.hasLength(salaryDto.getTitle())){
            errors.add("Veuillez renseigner le Titre !");
        }
        if(!StringUtils.hasLength(salaryDto.getComment())){
            errors.add("Veuillez renseigner le commentaire !");
        }
        if(!StringUtils.hasLength((CharSequence) salaryDto.getAmount())){
            errors.add("Veuillez renseigner le montant !");
        }
    return errors;
    }
}
