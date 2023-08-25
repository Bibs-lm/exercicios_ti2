import java.util.Scanner;

public class SomaNumeros {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        System.out.print("Insira o primeiro número: ");
        float numero1 = scanner.nextFloat();

        System.out.print("Insira o segundo número: ");
        float numero2 = scanner.nextFloat();

        float soma = numero1 + numero2;

        System.out.println("A soma dos números é: " + soma);

        scanner.close();
        
    }
    
}
