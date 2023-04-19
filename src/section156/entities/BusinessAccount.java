package section156.entities;

public class BusinessAccount extends Account {

    private Double loanLimit;

    public BusinessAccount() {
        super(); //executa a lógica do construtor da classe base/super classe
    }

    public BusinessAccount(Integer number, String holder, Double balance, Double loanLimit) { //construtor herdando atributos da classe principal
        super(number, holder, balance); //é o construtor da classe principal, precisa usar a palavra super()
        this.loanLimit = loanLimit;
    }

    public Double getLoanLimit() {
        return loanLimit;
    }

    public void setLoanLimit(Double loanLimit) {
        this.loanLimit = loanLimit;
    }

    public void loan(double amount) {
        if (amount <= loanLimit) { //se o valor que eu quero emprestado é menor ou igual ao meu limite de empréstimo
            balance += amount - 10.0; // soma o valor do saldo à quantia e tira uma tava de 10 reais
        }
    }
    @Override
    public void withdraw(double amount) { //é possível chamar a implementação da superclasse usando a palavra SUPER, e com isso aproveitamos a implementação do método dela
        super.withdraw(amount); //deste caso ele vai chamar o método da classe account que é balance -= amount + 5.0 (taxa de saque de 5 reais)...
        balance -= 2.0; //... e no caso desta classe ainda irá descontar mais 2 reais, totalizando 7 reais de desconto por saque
    }
}
