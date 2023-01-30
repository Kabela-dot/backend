package ipeps.pwd.wallet.services;


import ipeps.pwd.wallet.dto.SalaryDto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public interface SalaryService {
    SalaryDto save(SalaryDto dto);
    SalaryDto findById(Long id);
    SalaryDto findByCreate_date(Date date);
    SalaryDto findByAmount(BigDecimal amount);
    List<SalaryDto> findAll();
    void  Delete(Long id);





}
