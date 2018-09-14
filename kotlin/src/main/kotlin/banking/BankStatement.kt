package banking

data class BankStatement(
        val rows: List<StatementRow>
) {
    data class StatementRow(
            val transactionCents: Int,
            val balanceInCents: Int
    )
}
