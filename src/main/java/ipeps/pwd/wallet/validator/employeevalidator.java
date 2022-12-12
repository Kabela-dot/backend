package ipeps.pwd.wallet.validator;

import ipeps.pwd.wallet.dto.employeeDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.util.StringUtils.hasLength;

public class employeevalidator {

    public  static List<String>validator(employeeDto employeeDto){
        List<String>errors= new ArrayList<>();
        if(employeeDto==null){
            errors.add("Veuillez annoncer l'adresse !");
            errors.add("Veuillez annoncer le nom !");
            errors.add("Veuillez annoncer le prénom !");
            errors.add("Veuillez annoncer le genre !");
            return errors;

        }

        if(employeeDto.getAdress()==null)
        {
            errors.add("Veuillez annoncer l'adresse !");
        }
        else{
            if (employeeDto == null || !hasLength(employeeDto.getLastname())) {
                errors.add("Veuillez annoncer le nom !");
            }
            if (employeeDto == null || !hasLength(employeeDto.getFirstname())) {
                errors.add("Veuillez annoncer le prénom !");
            }

            if (employeeDto == null || !hasLength(employeeDto.getGender())) {
                errors.add("Veuillez annoncer le genre !");
            }
        }

            return errors;
    }
}
