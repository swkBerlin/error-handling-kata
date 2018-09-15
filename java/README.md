# Functional Banking Kata [Java]

(using [functionaljava](https://www.functionaljava.org/) library for functional stuff)

## 1. Handling “foreign” libraries that throw exceptions, and converting to functional world

Your first task is to implement an `Account` class with the following interface:

```java
public class Account {

    private final BankService bankService;
    private final String id;

    public Account(BankService bankService,
                   String id) {
        this.bankService = bankService;
        this.id = id;
    }

    public Either<DepositError, AccountStatus> deposit(int cents) {
        throw new RuntimeException("TODO: not implemented yet");
    }

    public enum DepositError {
        CONNECTION_ERROR,
        ACCOUNT_NOT_FOUND,
        ACCOUNT_BLOCKED
    }

    public Either<WithdrawError, AccountStatus> withdraw(int cents) {
        throw new RuntimeException("TODO: not implemented yet");
    }

    public enum WithdrawError {
        CONNECTION_ERROR,
        ACCOUNT_NOT_FOUND,
        ACCOUNT_BLOCKED,
        NOT_ENOUGH_FUNDS
    }

    // Either<L, R> would have worked a bit better here
    // but we want to learn Option<A> as well, so… :)
    public Option<BankStatement> createStatement() {
        throw new RuntimeException("TODO: not implemented yet");
    }
}
```

The dependency that you have is a `BankService` interface:

```java
public interface BankService {

    AccountStatus makeTransaction(Transaction transaction)
            throws ConnectionException,
            AccountNotFoundException,
            AccountBlockedException,
            NotEnoughFundsException;

    List<Transaction> listTransactions(String accountId)
            throws ConnectionException,
            AccountNotFoundException,
            AccountBlockedException;

    // ...
}
```

You don’t need to implement the `BankService` itself, just mock it out in your test suite using Mockito library.

By the way, here are the definitions of the data classes:

```java
public class AccountStatus {
    private final int id;
    private final int balanceInCents;
    
    // .. constructor, getters, equals, hashCode, toString ..
}

public class Transaction {
    private final String accountId;
    private final int cents;
    
    // .. constructor, getters, equals, hashCode, toString ..
}

public class BankStatement {
    private final List<StatementRow> rows;
    
    // .. constructor, getters, equals, hashCode, toString ..
    
    public class StatementRow {
        private final int transactionCents;
        private final int balanceInCents;
        
        // .. constructor, getters, equals, hashCode, toString ..
    }
}
```

## 2. Handling errors of functional world

Your second task is to implement the `AccountController`—some kind of user interface:

```java
public class AccountController {

    private final Account account;
    
    public AccountController(AccountFactory accountFactory) {
        this.account = accountFactory.create();
    }

    @FunctionalInterface
    public interface AccountFactory {
        Account create();
    }

    // - tell the user that amount was deposited
    //   and tell them their balance after the deposit
    // - in case of failure, tell the user about it
    public Message makeDeposit(int cents) {
        throw new RuntimeException("TODO: not implemented yet");
    }

    // - tell the user that amount was withdrawn
    //   and tell them their balance after the withdrawal
    // - in case of failure, tell the user about it
    public Message makeWithdrawal(int cents) {
        throw new RuntimeException("TODO: not implemented yet");
    }

    // - render a statement table for the user
    // - if unable to create statement,
    //   tell the user to contact support
    public Message showStatement() {
        throw new RuntimeException("TODO: not implemented yet");
    }

    public class Message {
        private final String text;

        // .. constructor, getters, equals, hashCode, toString ..
    }

}
```
