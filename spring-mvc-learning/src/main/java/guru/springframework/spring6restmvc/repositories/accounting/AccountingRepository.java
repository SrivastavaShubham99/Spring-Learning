package guru.springframework.spring6restmvc.repositories.accounting;

import guru.springframework.spring6restmvc.entities.accounting.BankAccount;
import guru.springframework.spring6restmvc.entities.accounting.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AccountingRepository extends JpaRepository<BankAccount, Long> {
    public BankAccount findByAccountNumber(String accountNumber);
}
