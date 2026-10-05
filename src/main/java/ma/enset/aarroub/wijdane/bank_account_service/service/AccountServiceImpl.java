package ma.enset.aarroub.wijdane.bank_account_service.service;

import ma.enset.aarroub.wijdane.bank_account_service.DTO.BankAccountRequestDTO;
import ma.enset.aarroub.wijdane.bank_account_service.DTO.BankAccountResponseDTO;
import ma.enset.aarroub.wijdane.bank_account_service.entity.BankAccount;
import ma.enset.aarroub.wijdane.bank_account_service.mappers.AccountMapper;
import ma.enset.aarroub.wijdane.bank_account_service.repositories.BankAccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {
    @Autowired
    private BankAccountRepo bankAccountRepo;
    @Autowired
    private AccountMapper accountMapper;

    @Override
    public BankAccountResponseDTO addAccount(BankAccountRequestDTO bankAccountRequestDTO) {
        BankAccount bankAccount = BankAccount.builder()
                .id(UUID.randomUUID().toString())
                .balance(bankAccountRequestDTO.getBalance())
                .type(bankAccountRequestDTO.getType())
                .currency(bankAccountRequestDTO.getCurrency())
                .build();
        BankAccount savedBankAccount = bankAccountRepo.save(bankAccount);

        BankAccountResponseDTO bankAccountResponseDTO = accountMapper.fromBankAccount(savedBankAccount);
        return bankAccountResponseDTO;
    }
}
