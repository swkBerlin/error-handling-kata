package banking

import arrow.core.Either
import arrow.core.Option

open class Account(private val bankService: BankService,
                   private val id: String) {

    open fun deposit(cents: Int): Either<DepositError, AccountStatus> {
        TODO("not implemented yet")
    }

    enum class DepositError {
        CONNECTION_ERROR,
        ACCOUNT_NOT_FOUND,
        ACCOUNT_BLOCKED
    }

    open fun withdraw(cents: Int): Either<WithdrawError, AccountStatus> {
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
    open fun createStatement(): Option<BankStatement> {
        TODO("not implemented yet")
    }

}