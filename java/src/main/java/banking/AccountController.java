package banking;

import java.util.Objects;

public class AccountController {

    private final Account account;

    public AccountController(AccountFactory accountFactory) {
        this.account = accountFactory.create();
    }

    @FunctionalInterface
    public interface AccountFactory {
        Account create();
    }

    // - tell the user that amount was deposited
    //   and tell them their balance after the deposit
    // - in case of failure, tell the user about it
    public Message makeDeposit(int cents) {
        throw new RuntimeException("TODO: not implemented yet");
    }

    // - tell the user that amount was withdrawn
    //   and tell them their balance after the withdrawal
    // - in case of failure, tell the user about it
    public Message makeWithdrawal(int cents) {
        throw new RuntimeException("TODO: not implemented yet");
    }

    // - render a statement table for the user
    // - if unable to create statement,
    //   tell the user to contact support
    public Message showStatement() {
        throw new RuntimeException("TODO: not implemented yet");
    }

    public class Message {
        private final String text;

        public Message(String text) {
            this.text = text;
        }

        public String getText() {
            return text;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Message message = (Message) o;
            return Objects.equals(text, message.text);
        }

        @Override
        public int hashCode() {
            return Objects.hash(text);
        }

        @Override
        public String toString() {
            return "Message{" +
                    "text='" + text + '\'' +
                    '}';
        }
    }

}
