package com.swkberlin.functional

import scala.util.Try

class Account(id: String) {
  def deposit(amount: Int): Either[TransactionError, DepositTransaction] =
    amount match {
      case 100 => Right(DepositTransaction(Transaction(), 100))
      case 120 => Left(AccountDoesNotExist(id))
      case _   => ???
    }

  def withdraw(amount: Int): Either[WithdrawError, WithdrawTransaction] = ???
  def findTransaction(id: String): Try[Option[Transaction]]             = ???
}

case class DepositTransaction(transaction: Transaction, balanceAfter: Int)
case class Transaction()
case class WithdrawTransaction()

sealed class TransactionError(message: String)    extends RuntimeException(message)
case class AccountDoesNotExist(accountId: String) extends TransactionError(accountId)
case class AccountBlocked(accountId: String)      extends TransactionError(accountId)
case class ConnectionFailure(accountId: String)   extends TransactionError(accountId)

sealed class WithdrawError(message: String)  extends TransactionError(message)
case class NotEnoughFunds(accountId: String) extends WithdrawError(accountId)
