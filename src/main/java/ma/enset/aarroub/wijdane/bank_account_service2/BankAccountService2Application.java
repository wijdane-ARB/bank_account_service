package ma.enset.aarroub.wijdane.bank_account_service2;

import ma.enset.aarroub.wijdane.bank_account_service2.entity.BankAccount;
import ma.enset.aarroub.wijdane.bank_account_service2.enums.AccountType;
import ma.enset.aarroub.wijdane.bank_account_service2.repositories.BankAccountRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class BankAccountService2Application {

    public static void main(String[] args) {
        SpringApplication.run(BankAccountService2Application.class, args);
    }
    CommandLineRunner start(BankAccountRepo bankAccountRepo){
        return args -> {
            for (int i = 0; i < 10; i++) {
                BankAccount bankAccount = new BankAccount();
                bankAccount.setId((long) i);
                bankAccount.setBalance(Math.random() * 10000);
                bankAccount.setCurrency("MAD");
                bankAccount.setType(Math.random() > 0.5 ? AccountType.CURRENT_ACCOUNT : AccountType.SAVING_ACCOUNT);
                bankAccount.setCreatedAt(new Date());
                bankAccountRepo.save(bankAccount);
            }
        };
    }

}
