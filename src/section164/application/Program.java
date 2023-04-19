package section164.application;

import section164.entities.Circle;
import section164.entities.Rectangle;
import section164.entities.Shape;
import section164.entities.enums.Color;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<Shape> list = new ArrayList<>();//sempre usar o tipo genérico na coleção pois queremos o polimorfismo, então a lista tem que ser declarada do tipo da SuperClasse.
        //desta forma, essa lista vai aceitar dados de todos os tipos da subclasse.
        //Podemos criar variáveis ou coleções de um tipo abstrato (Shape) desde que eu instancie objetos do tipo concretos (Rectangle e Circle)
        //vai ser feito o Upcasting dele para o Shape e minha lista vai funcionar normalmente, e poderá utilizar do Polimorfismo
        //esse polimorfismo passa totalmente natural pelo compilador, ele não sabe qual o tipo específico de cada figura da minha lista
        //o calculo específico de cada área é naturalmente obtido dos objetos polimorficamente dependendo do tipo de cada objeto (shape.area())

        System.out.print("Enter the number of shapes: ");
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            System.out.println("Shape #" + i + " data:");
            System.out.print("Rectangle or Circle (r/c)? ");
            char ch = sc.next().charAt(0);
            System.out.print("Color (BLACK/BLUE/RED): ");
            Color color = Color.valueOf(sc.next()); //a palavra que o usuário digitar vai ser convertida para o meu objeto do tipo enumerado Color
            if (ch == 'r') {
                System.out.print("Width: ");
                double width = sc.nextDouble();
                System.out.print("Height: ");
                double height = sc.nextDouble();
                list.add(new Rectangle(color, width, height));
            }
            else {
                System.out.print("Radius: ");
                double radius = sc.nextDouble();
                list.add(new Circle(color, radius));
            }
        }

        System.out.println();
        System.out.println("SHAPE AREAS: ");

        for (Shape shape : list) { //para cada Shape shape na minha lista list, eu vou mandar imprimir na tela...
            System.out.println(String.format("%.2f",shape.area()));
        }

        sc.close();
    }
}
