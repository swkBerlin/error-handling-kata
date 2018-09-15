package com.swkberlin.functional

import scala.util.Try

class Account(id: String) {
  def deposit(cents: Int): Either[TransactionError, AccountStatus] =
    ???

  def withdraw(cents: Int): Either[WithdrawError, AccountStatus] =
    ???

  def findTransaction(id: String): Try[Option[Transaction]] =
    ???
}

case class AccountStatus(id: String, balanceAfter: Int)

case class Transaction(accountId: String, cents: Int)

sealed class TransactionError(message: String) extends RuntimeException(message)

case class AccountDoesNotExist(accountId: String) extends TransactionError(accountId)

case class AccountBlocked(accountId: String) extends TransactionError(accountId)

case class ConnectionFailure(accountId: String) extends TransactionError(accountId)

sealed class WithdrawError(message: String) extends TransactionError(message)

case class NotEnoughFunds(accountId: String) extends WithdrawError(accountId)
