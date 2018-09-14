package banking

import org.hamcrest.CoreMatchers.equalTo
import org.junit.Assert.assertThat
import org.junit.Test
import org.mockito.Mockito.mock

class AccountTest {

    private val bankService = mock(BankService::class.java)
    private val account = Account(bankService, id = "MYACCOUNT")

    @Test
    fun `name is totally TODO`() {
        // setup mock for bankService here

        // make a call to account

        // verify the result is correct



        // just verifying that the test runner works
        assertThat(2 + 3, equalTo(4))
    }

}