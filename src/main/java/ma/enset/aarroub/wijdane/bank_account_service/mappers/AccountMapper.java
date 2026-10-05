package ma.enset.aarroub.wijdane.bank_account_service.mappers;

import ma.enset.aarroub.wijdane.bank_account_service.DTO.BankAccountResponseDTO;
import ma.enset.aarroub.wijdane.bank_account_service.entity.BankAccount;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class AccountMapper {
    public BankAccountResponseDTO fromBankAccount(BankAccount bankAccount){
        BankAccountResponseDTO bankAccountResponseDTO = new BankAccountResponseDTO();
        BeanUtils.copyProperties(bankAccount, bankAccountResponseDTO);
        return bankAccountResponseDTO;
    }
}