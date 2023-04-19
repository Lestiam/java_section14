package section156.entities;

public/* final */ class SavingsAccount extends Account{ //o final faz com que essa classe não possa mais ser herdada

    private Double interestRate; //taxa de juros que a conta rende

    public SavingsAccount() {
        super();
    }

    public SavingsAccount(Integer number, String holder, Double balance, Double interestRate) {
        super(number, holder, balance);
        this.interestRate = interestRate;
    }

    public Double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(Double interestRate) {
        this.interestRate = interestRate;
    }

    public void updateBalance() {
        balance += balance * interestRate; //saldo recebe ele mesmo * a taxa de juros
    }

    @Override
    public final void withdraw(double amount) {//na classe saque da conta poupança, não tem o desconto de 5 reis que existe na classe Account, é importante usar o @Override para indicar ao compilador que é uma sobreposição de método e facilitar o entendimento do código
        balance -= amount;
    }
    //a palavra "final" evita que esté método seja sobreposto (Override) novamente, sobrepozições múltiplas são uma porta para inconsistências
}
