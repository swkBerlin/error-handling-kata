# Error Handling Without Exceptions (Banking Kata Variant)

## Why?

The goal of this exercise is to play around with alternative method of error handling so that we have another tool in our toolbox. This method shines when you have highly concurrent and streaming environment (but we are not going to go there in this exercise, because of too much complexity).

## Narrative

This time around, you don’t have to rewrite existing banking/accounting software. Your task is to create a brand new user interface for the “banking on the go,” and use the remote client to communicate with the banking back-end.

You are free to choose any programming language (as long as it has static types and a functional library).

For now, the app will need to support:

- deposit,
- withdrawal,
- show transaction by ID.

## What do I need to work with?

Because you are implementing a new client application for banking back-end, you’ll need a way to communicate with the said back-end.

For that, you’ll need something like an interface `RemoteBankClient`, that has the following methods/functions defined:

- `string makeTransaction(int cents)`:
  - `cents` can be both negative (withdrawal) and positive (deposit).
  - the method returns a `transaction id`.
  - the method will throw a specific exception when unable to connect to the bank, or the account is blocked, or not enough funds on the account.
- `Transaction getTransactionById(string transactionId)`, and `Transaction` contains the following data:
  - transaction id,
  - balance before the transaction,
  - transaction amount in cents, and
  - balance after the transaction.
  - The method will throw a specific exception when unable to connect to the bank, or the account is blocked, or transaction can’t be found.

NOTE: (optionally) you can replace simple types `string` and `int` with more specific types, e.g. `TransactionId` and `Money`. Up to your preference and time available.

You **DON’T** need to implement this interface. Instead, you’ll need to **mock it away in your tests**, and implement the logic that is **using this interface**:

## What do I need to implement?

To experience different concepts of the functional error handling, you’ll need 2 tiers:

### Service Layer (primary goal for this Kata)

Service layer that uses `RemoteBankClient` and is not dealing with presenting anything to the user:

- Here you will need to translate from the thrown exceptions to functional types like `Either<Left, Right>` and `Option<Value>`.
- Example methods/functions signatures here (for the sake of exploring both types):
    - `Either<DepositError, Transaction> deposit(int cents)`
    - `Either<WithdrawError, Transaction> withdraw(int cents)`
    - `Option<Transaction> findTransaction(string id)`
- NOTE: you are not constrained by these signatures, and if you can make them better, certainly do.

### UI/Controller Layer (stretch goal for this Kata)
  
UI/controller layer that calls the service layer and is presenting the results/errors to the user:

- Here you will need to distinguish between the successful and failure scenarios and present the result to the user.
- Returning some sort of message data structure, or printing the message on the STDOUT will do.
- Since you want to offer the features of `withdraw`, `deposit` and `showTransaction` to the user, that is the methods/functions this part of the application should have.
- For different kinds of failures, you want to show the user a different message.
- You don’t need to deal with user input or its validation. User input is passed as parameters to your methods/functions and is already parsed and of the correct type.
- Example methods/functions signatures:
    - `DepositView deposit(int cents)`
    - `WithdrawView withdraw(int cents)`
    - `TransactionView showTransaction(string id)`
- NOTE: you are not constrained by these signatures, and if you can make them better, certainly do.
