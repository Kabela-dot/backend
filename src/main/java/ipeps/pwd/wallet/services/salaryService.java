package ipeps.pwd.wallet.services;

import ipeps.pwd.wallet.dto.employeeDto;
import ipeps.pwd.wallet.dto.salaryDto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public interface salaryService {
    salaryDto Save(employeeDto dto);
    salaryDto FindById(Long id);
    salaryDto FindByCreate_date(Date date);
    salaryDto FindByAmount(BigDecimal amount);
    List<salaryDto> FindAll();
    void  Delete(Long id);





}
