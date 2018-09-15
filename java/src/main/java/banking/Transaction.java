package banking;

import java.util.Objects;

public class Transaction {
    private final String accountId;
    private final int cents;

    public Transaction(String accountId,
                       int cents) {
        this.accountId = accountId;
        this.cents = cents;
    }

    public String getAccountId() {
        return accountId;
    }

    public int getCents() {
        return cents;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return cents == that.cents &&
                Objects.equals(accountId, that.accountId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountId, cents);
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "accountId='" + accountId + '\'' +
                ", cents=" + cents +
                '}';
    }
}
