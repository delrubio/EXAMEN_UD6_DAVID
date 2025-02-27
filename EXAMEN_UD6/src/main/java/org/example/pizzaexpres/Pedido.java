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
    private Empleado empleado;

    public Pedido(Cliente cliente) {
        estadoPedido = Estado.CREANDO;
        listaPizzas = new ArrayList<>();
        this.cliente=cliente;
    }

    public void aplicarDescuento() {
        for (CartaPizzas pizza : listaPizzas) {
            totalPedido = pizza.getPrecio()-((pizza.getPrecio() * (cliente.getDescuento()))/100);
        }
    }

    public void continuarPedido() {
        System.out.println("Este es el estado del pedido: ");
        for (CartaPizzas carta : listaPizzas) {
            System.out.println(carta);
            totalPedido+=carta.getPrecio();
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
                mostrarEstado();
                cliente.pagar();
            default:
                System.out.println("ERROR. Mala elección");
                System.exit(1);
        }
    }

    public void mostrarEstado() {

        System.out.println("Pedido: " + estadoPedido);
        System.out.println("Importe: " + totalPedido + "€");
        System.out.println("Descuento aplicado: " + cliente.getDescuento() + "%");
        aplicarDescuento();
        System.out.println("Total a pagar: " + getTotalPedido());
        System.out.println("Pasa por caja para pagar cuando el pedido esté listo " + cliente.getNombre());
    }

    public void avanzarEstado() {
        estadoPedido = Estado.MONTANDO_PIZZA;

        for (int i = 0; i < 3; i++) {
            System.out.println(estadoPedido);
            estadoPedido = estadoPedido.siguiente(estadoPedido);
            empleado.entregarPedido(this);
        }
    }

    public void agregarPizzas(String pizza){
        for (CartaPizzas carta: CartaPizzas.values()){
            if (carta.name().equals(pizza)){
                this.listaPizzas.add(carta);
            }else {
                System.out.println("No existe.");
            }
        }
    }
}