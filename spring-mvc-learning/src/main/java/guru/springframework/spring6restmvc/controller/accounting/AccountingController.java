package guru.springframework.spring6restmvc.controller.accounting;


import guru.springframework.spring6restmvc.entities.accounting.BankAccount;
import guru.springframework.spring6restmvc.model.MessageResponse;
import guru.springframework.spring6restmvc.model.accounting.BankDetails;
import guru.springframework.spring6restmvc.services.accounting.AccountingServiceImpl;
import guru.springframework.spring6restmvc.utility.constants.ApiEndPoints;
import guru.springframework.spring6restmvc.utility.constants.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(ApiEndPoints.accountingEndPoint)
public class AccountingController {


    @Autowired
    private AccountingServiceImpl accountingService;


    @PostMapping
    public ResponseEntity<MessageResponse> addAccount(@RequestBody BankAccount bankAccount){
        MessageResponse messageResponse=MessageResponse
                .builder()
                .message(Messages.bankAccountAdded)
                .build();

        accountingService.addBackAccount(bankAccount);
        return new ResponseEntity<>(messageResponse, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<BankAccount> fetchAccountDetails(@RequestParam String accountNumber){
        BankAccount bankAccount=accountingService.fetchAccountDetails(accountNumber);
        return new ResponseEntity<>(bankAccount,HttpStatus.OK);
    }


    @PostMapping("/withdraw")
    public ResponseEntity<BankDetails> withdrawMoney(
            @RequestParam double amountToBeWithdraw,
            @RequestParam String accountNumber){
        BankDetails bankDetails=accountingService.withdrawMoney(amountToBeWithdraw,accountNumber);
        return new ResponseEntity<>(bankDetails,HttpStatus.OK);
    }
}
