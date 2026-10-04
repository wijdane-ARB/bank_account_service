package ma.enset.aarroub.wijdane.bank_account_service.web;


import ma.enset.aarroub.wijdane.bank_account_service.entity.BankAccount;
import ma.enset.aarroub.wijdane.bank_account_service.repositories.BankAccountRepo;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
public class AccountRestController {

    private BankAccountRepo bankAccountRepo;
    public AccountRestController(BankAccountRepo bankAccountRepo) {
        this.bankAccountRepo = bankAccountRepo;

    }
    @GetMapping("/bankAccounts")
    public List<BankAccount> bankAccounts(){
        return bankAccountRepo.findAll();
    }
    @GetMapping("/bankAccounts/{id}")
    public BankAccount bankAccountById(@PathVariable String id){
        return bankAccountRepo.findById(id).orElseThrow(() -> new RuntimeException(String.format("Account not found with id: %s", id)));
    }
    @PostMapping("/bankAccounts")
    public BankAccount save(@RequestBody BankAccount bankAccount){
        if (bankAccount.getId() == null) {
            bankAccount.setId(UUID.randomUUID().toString());
        }
        return bankAccountRepo.save(bankAccount);
    }
    @PutMapping("/bankAccounts/{id}")
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
    @DeleteMapping("/bankAccounts/{id}")
    public void deleteAccount(@PathVariable String id){
        bankAccountRepo.deleteById(id);
}

}
