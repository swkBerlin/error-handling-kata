# Functional Banking Kata [Kotlin]

(using [ArrowKt](https://arrow-kt.io/) library for functional stuff)

## 1. Handling “foreign” libraries that throw exceptions, and converting to functional world

Your first task is to implement an `Account` class with the following interface:

```kotlin
class Account(private val bankService: BankService,
              private val id: String) {

    fun deposit(cents: Int): Either<DepositError, AccountStatus> {
        TODO("not implemented yet")
    }

    enum class DepositError {
        CONNECTION_ERROR,
        ACCOUNT_NOT_FOUND,
        ACCOUNT_BLOCKED
    }

    fun withdraw(cents: Int): Either<WithdrawError, AccountStatus> {
        TODO("not implemented yet")
    }

    enum class WithdrawError {
        CONNECTION_ERROR,
        ACCOUNT_NOT_FOUND,
        ACCOUNT_BLOCKED,
        NOT_ENOUGH_FUNDS
    }

    // Either<L, R> would have worked a bit better here
    // but we want to learn Option<A> as well, so… :)
    fun createStatement(): Option<BankStatement> {
        TODO("not implemented yet")
    }

}
```

The dependency that you have is a `BankService` interface:

```kotlin
interface BankService {

    @Throws(ConnectionException::class,
            AccountNotFoundException::class,
            AccountBlockedException::class,
            NotEnoughFundsException::class)
    fun makeTransaction(transaction: Transaction): AccountStatus

    @Throws(ConnectionException::class,
            AccountNotFoundException::class,
            AccountBlockedException::class)
    fun listTransactions(): List<Transaction>

    // ...
}
```

You don’t need to implement the `BankService` itself, just mock it out in your test suite using Mockito library.

By the way, here are the definitions of the data classes:

```kotlin
data class AccountStatus(
        val id: String,
        val balanceInCents: Int
)

data class Transaction(
        val accountId: String,
        val cents: Int
)

data class BankStatement(
        val rows: List<StatementRow>
) {
    data class StatementRow(
            val transactionCents: Int,
            val balanceInCents: Int
    )
}
```

## 2. Handling errors of functional world

Your second task is to implement the `AccountController`—some kind of user interface:

```kotlin
package banking

class AccountController(accountFactory: () -> Account) {

    val account = accountFactory()

    // - tell the user that amount was deposited
    //   and tell them their balance after the deposit
    // - in case of failure, tell the user about it
    fun makeDeposit(cents: Int): Message {
        TODO("not implemented yet")
    }

    // - tell the user that amount was withdrawn
    //   and tell them their balance after the withdrawal
    // - in case of failure, tell the user about it
    fun makeWithdrawal(cents: Int): Message {
        TODO("not implemented yet")
    }

    // - render a statement table for the user
    // - if unable to create statement,
    //   tell the user to contact support
    fun showStatement(): Message {
        TODO("not implemented yet")
    }

    data class Message(val text: String)

}
```
