package ipeps.pwd.wallet.dto;

import ipeps.pwd.wallet.modele.gestionEmployees.employee;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
@Builder
@Data
public class employeeDto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long id;

    private String lastname;

    private String firstname;
    private  String active;
    private  String deleted_by;
    private  String adress;
    private  String gender;
    private Date birthday;
    private  String ssin;
    private  String status;
    private  String deleted;

    public static   employeeDto fromEntity(employee employee){
        if (employee==null){
            return null;
        }
        //Mapping de employee vers employeeDto
     return employeeDto.builder()
             .id(employee.getId())
             .lastname(employee.getLastname())
             .firstname(employee.getFirstname())
             .adress(employee.getAdress())
             .active(employee.getActive())
             .deleted(employee.getDeleted())
             .birthday(employee.getBirthday())
             .deleted_by(employee.getDeleted_by())
             .gender(employee.getGender())
             .ssin(employee.getSsin())
             .status(employee.getStatus())
             .build();


    }
    //Mapping de employeeDto vers employee
    public static employee toEntity(employeeDto employeeDto)
    {
        if(employeeDto==null)
        {
            return null;
        }
       employee employee=new employee();
        employee.setId(employeeDto.getId());
        employee.setActive(employeeDto.getActive());
        employee.setDeleted(employeeDto.getDeleted());
        employee.setAdress(employeeDto.getAdress());
        employee.setBirthday(employeeDto.getBirthday());
        employee.setFirstname(employeeDto.getFirstname());
        employee.setGender(employeeDto.getGender());
        employee.setFirstname(employeeDto.getFirstname());
        employee.setDeleted_by(employeeDto.getDeleted_by());
        employee.setSsin(employeeDto.getSsin());
        employee.setStatus(employeeDto.getStatus());
    return employee;

    }
}
