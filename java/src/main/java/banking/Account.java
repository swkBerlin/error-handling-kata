package banking;

import fj.data.Either;
import fj.data.Option;

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
