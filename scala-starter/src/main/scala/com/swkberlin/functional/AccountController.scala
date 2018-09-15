package com.swkberlin.functional

case class Message(s: String)

class AccountController() {
  def makeDeposit(cents: Int): Message = ???

  def makeWithdrawal(cents: Int): Message = ???

  def showStatement(): Message = ???
}
