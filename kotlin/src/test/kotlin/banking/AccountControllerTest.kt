package banking

import org.hamcrest.CoreMatchers
import org.junit.Assert
import org.junit.Test
import org.mockito.Mockito.mock

class AccountControllerTest {

    private val account = mock(Account::class.java)
    private val accountController = AccountController { account }

    @Test
    fun `name is totally TODO`() {
        // setup mock for account here

        // and make call to controller

        // check the result



        // just verifying that the test runner works
        Assert.assertThat(2 + 3, CoreMatchers.equalTo(4))
    }

}