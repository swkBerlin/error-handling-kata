package banking;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

public class AccountTest {

    private BankService bankService = mock(BankService.class);
    private Account account = new Account(bankService, "MYACCOUNT");

    @Test
    public void name_is_totally_TODO() {
        // setup mock for bankService here

        // make a call to account

        // verify the result is correct




        // just verifying that the test runner works
        assertThat(2 + 3, equalTo(4));
    }
}