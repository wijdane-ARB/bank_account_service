package ma.enset.aarroub.wijdane.bank_account_service2.repositories;

import ma.enset.aarroub.wijdane.bank_account_service2.entity.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankAccountRepo extends JpaRepository<BankAccount, String> {
}
