import com.swkberlin.functional.{Account, AccountDoesNotExist, DepositTransaction, Transaction}
import org.scalatest.{EitherValues, FunSuite, Matchers, TryValues}

class AccountTest extends FunSuite with Matchers with EitherValues with TryValues {

  test("an account should register a deposit and return the current balance") {
    val account = new Account("12345A")
    account.deposit(100).right.value shouldBe DepositTransaction(Transaction(), 100)
  }

  test("an account should not register a deposit if the account cannot be found") {
    val missingAccount = "B"
    val account        = new Account(missingAccount)
    account.deposit(120).left.value shouldBe AccountDoesNotExist(missingAccount)
  }

  test("an account should find a transaction by its id if it exists") {
    val account = new Account("12345A")
    account.findTransaction("transactionId").success.value.get shouldBe Transaction()
  }
}
