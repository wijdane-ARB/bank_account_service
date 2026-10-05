package ma.enset.aarroub.wijdane.bank_account_service.service;

import ma.enset.aarroub.wijdane.bank_account_service.DTO.BankAccountRequestDTO;
import ma.enset.aarroub.wijdane.bank_account_service.DTO.BankAccountResponseDTO;
import ma.enset.aarroub.wijdane.bank_account_service.entity.BankAccount;

public interface AccountService {
    BankAccountResponseDTO addAccount(BankAccountRequestDTO bankAccountRequestDTO);
}
