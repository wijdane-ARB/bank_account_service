package ma.enset.aarroub.wijdane.bank_account_service.entity;

import ma.enset.aarroub.wijdane.bank_account_service.enums.AccountType;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.data.rest.core.config.Projection;

@Projection(types = BankAccount.class , name = "p1")
public interface AccountProjection {
    public String getId();
    public Double getBalance();
    public AccountType getType();
}
