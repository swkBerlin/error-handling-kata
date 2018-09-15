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