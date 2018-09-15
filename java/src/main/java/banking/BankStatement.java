package banking;

import java.util.List;
import java.util.Objects;

public class BankStatement {
    private final List<StatementRow> rows;

    public BankStatement(List<StatementRow> rows) {
        this.rows = rows;
    }

    public List<StatementRow> getRows() {
        return rows;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BankStatement that = (BankStatement) o;
        return Objects.equals(rows, that.rows);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rows);
    }

    @Override
    public String toString() {
        return "BankStatement{" +
                "rows=" + rows +
                '}';
    }

    public class StatementRow {
        private final int transactionCents;
        private final int balanceInCents;

        public StatementRow(int transactionCents,
                            int balanceInCents) {
            this.transactionCents = transactionCents;
            this.balanceInCents = balanceInCents;
        }

        public int getTransactionCents() {
            return transactionCents;
        }

        public int getBalanceInCents() {
            return balanceInCents;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            StatementRow that = (StatementRow) o;
            return transactionCents == that.transactionCents &&
                    balanceInCents == that.balanceInCents;
        }

        @Override
        public int hashCode() {
            return Objects.hash(transactionCents, balanceInCents);
        }

        @Override
        public String toString() {
            return "StatementRow{" +
                    "transactionCents=" + transactionCents +
                    ", balanceInCents=" + balanceInCents +
                    '}';
        }
    }
}
