package ipeps.pwd.wallet.services.Implimentation;

import ipeps.pwd.wallet.dto.employeeDto;
import ipeps.pwd.wallet.dto.salaryDto;
import ipeps.pwd.wallet.repository.employeerepository;
import ipeps.pwd.wallet.repository.salaryrepository;
import ipeps.pwd.wallet.services.salaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Service
public class salaryServiceImplementation implements salaryService {
    private ipeps.pwd.wallet.repository.salaryrepository salaryrepository;
    @Autowired
    public salaryServiceImplementation(salaryrepository salaryrepository) {
        this.salaryrepository = salaryrepository;

    }

    @Override
    public salaryDto Save(employeeDto dto) {
        return null;
    }

    @Override
    public salaryDto FindById(Long id) {
        return null;
    }

    @Override
    public salaryDto FindByCreate_date(Date date) {
        return null;
    }

    @Override
    public salaryDto FindByAmount(BigDecimal amount) {
        return null;
    }

    @Override
    public List<salaryDto> FindAll() {
        return null;
    }

    @Override
    public void Delete(Long id) {

    }
}
