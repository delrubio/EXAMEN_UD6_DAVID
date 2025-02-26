package org.example.pizzaexpres;

import java.util.Scanner;

public class AppPizzaExpress {
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        System.out.println("Hola, como te llamas?");
        Cliente cliente1 = new Cliente(teclado.next());
        Pedido pedido = new Pedido(cliente1);

    }
}
