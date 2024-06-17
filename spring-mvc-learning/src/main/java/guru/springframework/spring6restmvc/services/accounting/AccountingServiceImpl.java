package guru.springframework.spring6restmvc.services.accounting;

import guru.springframework.spring6restmvc.entities.accounting.BankAccount;
import guru.springframework.spring6restmvc.entities.accounting.User;
import guru.springframework.spring6restmvc.model.accounting.BankDetails;
import guru.springframework.spring6restmvc.repositories.accounting.AccountingRepository;
import guru.springframework.spring6restmvc.repositories.accounting.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;


@Service
public class AccountingServiceImpl implements AccountingService{

    private final AccountingRepository accountingRepository;

    private final UserRepository userRepository;


    AccountingServiceImpl(AccountingRepository accountingRepository,UserRepository userRepository){
        this.accountingRepository=accountingRepository;
        this.userRepository=userRepository;
    }


    @Override
    public void addBackAccount(BankAccount bankAccount) {
        /*
        In your User class, you have a List<BankAccount> named accountList annotated with @OneToMany(mappedBy="user", cascade = CascadeType.ALL, fetch = FetchType.EAGER).
        This configuration specifies a one-to-many relationship between User and BankAccount. The cascade = CascadeType.ALL part indicates that whenever you save a User,
         any associated BankAccount objects in the accountList will also be saved (cascaded persistence).

         However, you're not setting the user property within the BankAccount object itself when you create a new BankAccount.
         This means that when you try to save a User with its accountList populated, the BankAccount entities might be detached from the persistence context.
        Why it might cause an issue:
        JPA relies on the relationships between entities to track changes and persist them correctly.
        Since the user property in BankAccount isn't set, JPA might not recognize the association between the BankAccount and the User you're trying to save.
        This can lead to the "detached entity passed to persist" error if you try to save the User without establishing the relationship properly.

       Possible Solutions:

       Set the user property in BankAccount:
         */
        User user=userRepository.findById(bankAccount.getUser().getId()).get();
        bankAccount.setUser(user);
        accountingRepository.save(bankAccount);
    }

    @Override
    public BankAccount fetchAccountDetails(String accountNumber) {
        return accountingRepository.findByAccountNumber(accountNumber);
    }


    @Transactional
    @Override
    public BankDetails withdrawMoney(double amount, String bankAccount) {
        BankAccount bankAccount1=accountingRepository.findByAccountNumber(bankAccount);
        if(bankAccount1.getBalance() <=0){
            return BankDetails
                    .builder()
                    .message("Account balance is empty")
                    .amountLeft(bankAccount1.getBalance())
                    .accountNumber(bankAccount1.getAccountNumber())
                    .build();
        } else if (bankAccount1.getBalance() < amount) {
            return BankDetails
                    .builder()
                    .message("Sufficient Amount not present")
                    .amountLeft(bankAccount1.getBalance())
                    .accountNumber(bankAccount1.getAccountNumber())
                    .build();

        }else{
            double newAmount = bankAccount1.getBalance() - amount;
            bankAccount1.setBalance(newAmount);
            accountingRepository.save(bankAccount1);
            return BankDetails
                    .builder()
                    .message("Balance detected successfully")
                    .amountLeft(bankAccount1.getBalance())
                    .accountNumber(bankAccount1.getAccountNumber())
                    .build();
        }
    }
}
