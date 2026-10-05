package ma.enset.aarroub.wijdane.bank_account_service.web;

import ma.enset.aarroub.wijdane.bank_account_service.DTO.BankAccountRequestDTO;
import ma.enset.aarroub.wijdane.bank_account_service.DTO.BankAccountResponseDTO;
import ma.enset.aarroub.wijdane.bank_account_service.entity.BankAccount;
import ma.enset.aarroub.wijdane.bank_account_service.repositories.BankAccountRepo;
import ma.enset.aarroub.wijdane.bank_account_service.service.AccountService;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/bankAccounts")
public class AccountRestController {

    private BankAccountRepo bankAccountRepo;
    private AccountService accountService;

    public AccountRestController(BankAccountRepo bankAccountRepo) {
        this.bankAccountRepo = bankAccountRepo;
    }

    @GetMapping
    public List<BankAccount> bankAccounts(){
        return bankAccountRepo.findAll();
    }

    @GetMapping("/{id}")
    public BankAccount bankAccountById(@PathVariable String id){
        return bankAccountRepo.findById(id).orElseThrow(() -> new RuntimeException(String.format("Account not found with id: %s", id)));
    }

    @PostMapping
    public BankAccountResponseDTO save(@RequestBody BankAccountRequestDTO requestDTO){
        return accountService.addAccount(requestDTO);
    }

    @PutMapping("/{id}")
    public BankAccount update ( @PathVariable String id, @RequestBody BankAccount bankAccount){
        BankAccount account = bankAccountRepo.findById(id).orElseThrow();
        if (bankAccount.getBalance() != null) {
            account.setBalance(bankAccount.getBalance());
        }
        if (bankAccount.getCreatedAt() != null) {
            account.setCreatedAt(bankAccount.getCreatedAt());
        }
        if (bankAccount.getCurrency() != null) {
            account.setCurrency(bankAccount.getCurrency());
        }
        if (bankAccount.getType() != null) {
            account.setType(bankAccount.getType());
        }
        return bankAccountRepo.save(account);
    }

    @DeleteMapping("/{id}")
    public void deleteAccount(@PathVariable String id){
        bankAccountRepo.deleteById(id);
    }
}