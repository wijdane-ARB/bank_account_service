package ma.enset.aarroub.wijdane.bank_account_service;

import ma.enset.aarroub.wijdane.bank_account_service.entity.BankAccount;
import ma.enset.aarroub.wijdane.bank_account_service.enums.AccountType;
import ma.enset.aarroub.wijdane.bank_account_service.repositories.BankAccountRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.UUID;

@SpringBootApplication
public class BankAccountServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BankAccountServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner start(BankAccountRepo bankAccountRepo){
        return args -> {
            for (int i = 0; i < 10; i++) {
                BankAccount bankAccount = BankAccount.builder()
                        .id(UUID.randomUUID().toString())
                        .balance(10000+Math.random() * 90000)
                        .currency("MAD")
                        .type(Math.random() > 0.5 ? AccountType.CURRENT_ACCOUNT : AccountType.SAVING_ACCOUNT)
                        .createdAt(new Date())
                        .build();
                bankAccountRepo.save(bankAccount);
            }
        };
    }

}
