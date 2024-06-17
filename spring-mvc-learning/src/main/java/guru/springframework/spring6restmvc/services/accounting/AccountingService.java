package guru.springframework.spring6restmvc.services.accounting;

import guru.springframework.spring6restmvc.entities.accounting.BankAccount;
import guru.springframework.spring6restmvc.model.accounting.BankDetails;

public interface AccountingService {

    public void addBackAccount(BankAccount bankAccount);

    public BankAccount fetchAccountDetails(String accountNumber);

    public BankDetails withdrawMoney(double amount, String bankAccount);
}
