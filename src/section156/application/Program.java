package section156.application;

import section156.entities.Account;
import section156.entities.BusinessAccount;
import section156.entities.SavingsAccount;

public class Program {
    public static void main(String[] args) {

        Account acc = new Account(1001, "Alex", 0.0);
        BusinessAccount bacc = new BusinessAccount(1002, "Maria", 0.0, 500.0);

        //UPCASTING (pega um objeto da subclasse (BusinessAccount) e o atribui para uma variavel da classe principal (Account))

        Account acc1 = bacc;
        acc1.getBalance(); //funciona por causa da relação "é-um", ou seja, uma Conta empresarial É UMA Conta

        Account acc2 = new BusinessAccount(1003, "Bob", 0.0, 200.0); //é possível pois a conta empresarial também é uma conta

        Account acc3 = new SavingsAccount(1004, "Ana", 0.0, 0.01);

        //DOWNCASTING (converter um objeto da Superclasse para a subclasse)

        //acc2.loan não funciona, pois acc2 pois acc2 é da classe Account...
        //BusinessAccount acc4 = acc2; Não dá para converter pois a conversão não é natural, se eu quiser fazer uma conversão da superclasse para a subclasse, eu preciso fazer um casting manual
        BusinessAccount acc4 = (BusinessAccount) acc2; //assim funciona, com o casting manual
        acc4.loan(100.0); //eu posso até chamar o loan que é da subclasse, mesmo sendo um método do businessAccount
        //((BusinessAccount) acc2).loan(); ... depois do DOWNCASTING funciona.

        //BusinessAccount acc5 = (BusinessAccount) acc3; //o compilador não sabe que a acc3 é uma SavingAccount e não uma BussinessAccount, então ele só vai dar erro ao executar o programa (tempo de execução)
        if (acc3 instanceof BusinessAccount) {
            BusinessAccount acc5 = (BusinessAccount) acc3;
            acc5.loan(200.00);
            System.out.println("Loan!");
        }

        if (acc3 instanceof SavingsAccount) {
            SavingsAccount acc5 = (SavingsAccount) acc3;
            acc5.updateBalance();
            System.out.println("Update!");
        }
        //ESTES IFs TESTAM SE A CONVERSÃO FUNCIONA OU NÃO, OU SEJA, O PRIMEIRO IF FALHOU E O SEGUNDO PASSOU
        //ENTÃO SÓ O SEGUNDO DOWNSCASTING FUNCIONA

        Account acc01 = new Account(1001, "Alex", 1000.0);
        acc01.withdraw(200.0);//descontou o valor do saque mais a tava de 5 reais
        System.out.println(acc01.getBalance());

        Account acc02 = new SavingsAccount(1002, "Maria", 1000.0, 0.01);
        acc02.withdraw(200.0);//descontou o valor do saque e não cobrou a taxa de 5 reais por causa do Override
        System.out.println(acc02.getBalance());

        Account acc03 = new BusinessAccount(1003, "Bob", 1000.0, 500.0);
        acc03.withdraw(200.0); //descontou 5 e depois mais 2, totalizando 7 reais de desconto
        System.out.println(acc03.getBalance());


        //POLIMORFISMO (MUITAS FORMAS)
        //apesar de as variáveis x e y serem do mesmo tipo "Account", na memória (heap) eles são objetos de tipo diferentes: Account e SavingsAccount
        //eu chamei a mesma operação em variáveis do mesmo tipo (tipo account), mas elas tiveram comportamentos diferentes, conforme o objeto que elas apontam
        /*  A associação do tipo específico com o tipo genérico é feita em tempo de
            execução (upcasting).
        • O compilador não sabe para qual tipo específico a chamada do método
            Withdraw está sendo feita (ele só sabe que são duas variáveis tipo Account) */
        Account x = new Account(1020, "Alex", 1000.0);
        Account y = new SavingsAccount(1023, "Maria", 1000.0, 0.01);

        x.withdraw(50.0);
        y.withdraw(50.0);

        System.out.println(x.getBalance());
        System.out.println(y.getBalance());
    }
}