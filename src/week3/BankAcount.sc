class BankAcount{
  private var balance = 0

  def deposit(amount: Int) =
    if( amount > 0) {
      balance = balance + amount
      balance
    }


  def withdraw(amount: Int) =
    if(amount > 0 && amount <= balance){
      balance -= amount
      balance
    } else throw new Error("Insuficinet Founds")
}

val acc = new BankAcount

acc.deposit(50)
acc.withdraw(20)
acc.withdraw(20)
acc.withdraw(15)