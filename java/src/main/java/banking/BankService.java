package banking;

import java.util.List;

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

    class ConnectionException extends Exception {
        public ConnectionException() {
            super("unable to connect to bank");
        }
    }

    class AccountNotFoundException extends Exception {
        public AccountNotFoundException() {
            super("account not found");
        }
    }

    class AccountBlockedException extends Exception {
        public AccountBlockedException() {
            super("account blocked");
        }
    }

    class NotEnoughFundsException extends Exception {
        public NotEnoughFundsException() {
            super("not enough funds");
        }
    }

}
