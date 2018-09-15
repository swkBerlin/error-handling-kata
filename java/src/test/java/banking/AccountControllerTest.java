package banking;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

public class AccountControllerTest {

    private Account account = mock(Account.class);
    private AccountController accountController =
            new AccountController(() -> account);

    @Test
    public void name_is_totally_TODO() {
        // setup mock for account here

        // make a call to controller

        // verify the result is correct




        // just verifying that the test runner works
        assertThat(2 + 3, equalTo(4));
    }

}