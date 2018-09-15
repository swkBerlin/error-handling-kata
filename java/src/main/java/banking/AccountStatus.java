package banking;

import java.util.Objects;

public class AccountStatus {
    private final int id;
    private final int balanceInCents;

    public AccountStatus(int id,
                         int balanceInCents) {
        this.id = id;
        this.balanceInCents = balanceInCents;
    }

    public int getId() {
        return id;
    }

    public int getBalanceInCents() {
        return balanceInCents;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountStatus that = (AccountStatus) o;
        return id == that.id &&
                balanceInCents == that.balanceInCents;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, balanceInCents);
    }

    @Override
    public String toString() {
        return "AccountStatus{" +
                "id=" + id +
                ", balanceInCents=" + balanceInCents +
                '}';
    }
}
