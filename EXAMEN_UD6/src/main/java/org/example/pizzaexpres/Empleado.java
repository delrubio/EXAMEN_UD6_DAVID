package org.example.pizzaexpres;

import lombok.Data;

@Data
public class Empleado {

    public static final String ID_EMPLEADO="EMP";
    public static int contadorEmp=0;

    private String id_empleado;
    private String nombre;
    private Pedido pedido;

    public Empleado(String nombre){
        this.nombre=nombre;
        id_empleado=crearId();
    }

    public String crearId(){
        contadorEmp++;
        return ID_EMPLEADO + String.format("%03d", contadorEmp);
    }

    public String obtenerDetalles(){
        return "Nombre de empleado: " + nombre + ", ID_EMPLEADO: " + id_empleado;
    }

    public void entregarPedido(Pedido pedido){
        if (pedido.getEstadoPedido().equals(Estado.LISTO)){
            System.out.println("Pedido entregado ha " + pedido.getCliente());
        }else {
            siguienteEstado(pedido);
            System.out.println("El pedido aún no está listo.");
        }
    }

    public void siguienteEstado(Pedido pedido){
        pedido.avanzarEstado();
    }
}
