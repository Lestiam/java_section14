package section161.application;

import section161.entities.Employee;
import section161.entities.OutsourcedEmployee;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<Employee> list = new ArrayList<>();

        System.out.print("Enter the number of employees: ");
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            System.out.println("Employee #" + i + " data:");
            System.out.print("Outsourced (y/n)? ");
            char ch = sc.next().charAt(0);
            System.out.print("Name: ");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.print("Hours: ");
            int hours = sc.nextInt();
            System.out.print("Value per hour: ");
            double valuePerHour = sc.nextDouble();

            if (ch == 'y') {//se a resposta do ch que pergunta se é terceirizado ou não, for igual a y, eu vou ter que
                System.out.print("Additional charge: "); // ler o valor da dispesa adicional
                double additionalCharge = sc.nextDouble();
                Employee emp = new OutsourcedEmployee(name, hours, valuePerHour, additionalCharge);
                list.add(emp); // adiciono esse funcionário a minha lista
                //ou eu faço da forma acima, adicionando a variável emp, ou eu faço como na forma abaixo,
                // que nem precisa dessa variável
            }
            else { //se não, eu pego um funcionário normal
                list.add(new Employee(name, hours, valuePerHour));
            }
        }
        System.out.println();
        System.out.println("PAYMENTS: ");
        for (Employee employee : list) { //para cada funcionário employee na minha lista... (lembrando que o funcionário...
            System.out.println(employee.getName() + " - $" + String.format("%.2f", employee.payment()));
            //...terceiricado (OutsourcedEmployee) também É-UM funcionário)
        }

        //resumindo: o tipo da lista é Employee mas a instancia de cada objeto pode ser tanto Employee quanto
        // OutsourcedEmployee, quando eu chamo para imprimir o pagamento de cada um, o cálculo desse pagamento vai se
        // comportar diferente dependendo de cada funcionário, por isso nós temos um Polimorfismo.

        sc.close();
    }
}
