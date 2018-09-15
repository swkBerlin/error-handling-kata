package com.swkberlin.functional

case class Message(s: String)

class AccountController(val account: Account) {
  def makeDeposit(cents: Int): Message = ???

  def makeWithdrawal(cents: Int): Message = ???

  def showStatement(): Message = ???
}
