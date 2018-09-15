package banking

interface BankService {

    @Throws(ConnectionException::class,
            AccountNotFoundException::class,
            AccountBlockedException::class,
            NotEnoughFundsException::class)
    fun makeTransaction(transaction: Transaction): AccountStatus

    @Throws(ConnectionException::class,
            AccountNotFoundException::class,
            AccountBlockedException::class)
    fun listTransactions(accountId: String): List<Transaction>

    class ConnectionException : RuntimeException("unable to connect to bank")
    class AccountNotFoundException : RuntimeException("account not found")
    class AccountBlockedException : RuntimeException("account blocked")
    class NotEnoughFundsException : RuntimeException("not enough funds")
}
