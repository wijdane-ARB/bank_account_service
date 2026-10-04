package ma.enset.aarroub.wijdane.bank_account_service.web;


import ma.enset.aarroub.wijdane.bank_account_service.entity.BankAccount;
import ma.enset.aarroub.wijdane.bank_account_service.repositories.BankAccountRepo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
}
