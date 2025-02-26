package org.example.pizzaexpres;

import lombok.Data;

import java.util.ArrayList;
import java.util.Scanner;

@Data
public class Pedido {

    Scanner teclado = new Scanner(System.in);

    private Cliente cliente;
    private ArrayList<CartaPizzas> listaPizzas;
    private Estado estadoPedido;
    private double totalPedido;

    public Pedido(Cliente cliente) {
        estadoPedido = Estado.CREANDO;
    }

    public void aplicarDescuento() {
        for (CartaPizzas pizza : listaPizzas) {
            totalPedido = pizza.getPrecio() * (1 * cliente.getDescuento());
        }
    }

    public void continuarPedido() {
        System.out.println("Este es el estado del pedido: ");
        for (CartaPizzas carta : listaPizzas) {
            System.out.println(carta);
        }
        System.out.println("Total: " + totalPedido + "€");
        System.out.println("---------------------------------");
        System.out.println("¿Quieres seguir?");
        switch (teclado.next().toUpperCase()) {
            case "S":
                cliente.pedir();
                break;
            case "N":
                estadoPedido = Estado.RECIBIDO;
                cliente.pagar();
            default:
                System.out.println("ERROR. Mala elección");
                System.exit(1);
        }
    }

    public void mostrarEstado() {

        int importe = 0;
        for (CartaPizzas carta : listaPizzas) {
            importe += carta.getPrecio();
        }

        System.out.println("Pedido: " + estadoPedido);
        System.out.println("Importe: " + importe);
        System.out.println("Descuento aplicado: " + cliente.getDescuento());
        System.out.println("Total a pagar: " + totalPedido);
        System.out.println("Pasa por caja para pagar cuando el pedido esté listo " + cliente.getNombre());
    }

    public void avanzarEstado() {
        Estado estado = Estado.MONTANDO_PIZZA;

        for (int i = 0; i < 3; i++) {
            System.out.println(estado);
            estado = estado.siguiente(estado);
        }

        if (estado.equals(Estado.LISTO)) {
            cliente.recoger();
        }

    }
}