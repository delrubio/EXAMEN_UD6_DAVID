package org.example.pizzaexpres;

import lombok.Data;

import java.util.Scanner;

@Data
public class Cliente {

    static Scanner teclado = new Scanner(System.in);

    public static final int DESCUENTODEFAULT = 20;

    private String nombre;
    private int descuento;
    private Pedido pedido;

    public Cliente(String nombre) {
        descuento = DESCUENTODEFAULT;
        pedir();
    }

    public void pedir() {
        mostrarCarta();
        System.out.println("Dime que te apetece: ");

    }

    public void mostrarCarta() {
        System.out.println("Buenas, aquí está la carta:");
        System.out.println("---------------------------");
        for (CartaPizzas carta : CartaPizzas.values()) {
            System.out.println("Pizza: " + carta);
            System.out.println("Precio: " + carta.getPrecio() + "€");
        }
    }

    public void recoger(){
        System.out.println("Ya era hora. Ha comerme " + pedido.getListaPizzas());
    }

    public void pagar(){
        System.out.println("Pagaré con bizum la cuenta de " + pedido.getTotalPedido());
    }
}
