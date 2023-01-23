package ipeps.pwd.wallet.services;


import ipeps.pwd.wallet.dto.salaryDto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public interface salaryService {
    salaryDto save(salaryDto dto);
    salaryDto findById(Long id);
    salaryDto findByCreate_date(Date date);
    salaryDto findByAmount(BigDecimal amount);
    List<salaryDto> findAll();
    void  Delete(Long id);





}
