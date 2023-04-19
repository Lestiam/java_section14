package section165.exercicio.application;

import section165.exercicio.entities.Pessoa;
import section165.exercicio.entities.PessoaFisica;
import section165.exercicio.entities.PessoaJuridica;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        List<Pessoa> list = new ArrayList<>();//upcasting: a variável do tipo mais genérico aceita um objeto do tipo mais específico

        System.out.print("Enter the number of tax payers: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 1; i <= n; i++) {
            System.out.println("Tax payer #"+ i + " data:");
            System.out.print("Individual or company (i/c)? ");
            char ch = sc.next().charAt(0);
            sc.nextLine();
            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("Anual income: ");
            Double renda = sc.nextDouble();
            if (ch == 'i') {
                System.out.print("Health expenditures: ");
                Double gastoSaude = sc.nextDouble();
                list.add(new PessoaFisica(name,renda, gastoSaude)); //lembrar sempre de por o new...alguma coisa
            }
            else {
                System.out.print("Number of employees: ");
                Integer funcionario = sc.nextInt();
                list.add(new PessoaJuridica(name, renda, funcionario));
            }
        }
        System.out.println();
        System.out.println("TAXES PAID: ");

        double sum = 0.0;
        for (Pessoa pessoa : list) {//para cada Pessoa pessoa na minha lista list, eu vou mandar imprimir na tela...
            System.out.println(pessoa.getNome() + ": $" + String.format("%.2f",pessoa.imposto())); //o compilador não sabe...
            // ...se o elento pessoa será do tipo Fisica ou Juridica, isto será determinado em tempo de execução, dependendo...
            //do tipo de objeto que eu instanciar. Isto é o polimorfismo: Comportamento diferente determinado em tempo de execução.
            sum += pessoa.imposto();
        }

        System.out.println();
        System.out.println("TOTAL TAXES: $ " + String.format("%.2f",sum));
        sc.close();
    }
}
