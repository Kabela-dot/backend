package ipeps.pwd.wallet.dto;

import ipeps.pwd.wallet.modele.gestionEmployees.Employee;
import lombok.Builder;
import lombok.Data;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
@Builder
@Data
public class EmployeeDto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long id;

    private String lastname;

    private String firstname;
    private  String active;
    private  String deleted_by;
    private  String address;
    private  String gender;
    private Date birthday;
    private  String ssin;
    private  String status;
    private  String deleted;

    public static EmployeeDto fromEntity(Employee employee){
        if (employee==null){
            return null;
        }
        //Mapping de employee vers employeeDto
     return EmployeeDto.builder()
             .id(employee.getId())
             .lastname(employee.getLastname())
             .firstname(employee.getFirstname())
             .address(employee.getAddress())
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
    public static Employee toEntity(EmployeeDto employeeDto)
    {
        if(employeeDto==null)
        {
            return null;
        }
       Employee employee=new Employee();
        employee.setId(employeeDto.getId());
        employee.setActive(employeeDto.getActive());
        employee.setDeleted(employeeDto.getDeleted());
        employee.setAddress(employeeDto.getAddress());
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
