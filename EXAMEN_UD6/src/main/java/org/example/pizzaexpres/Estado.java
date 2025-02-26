package org.example.pizzaexpres;

public enum Estado {
    CREANDO, CANCELADO, RECIBIDO, MONTANDO_PIZZA, HORNEANDO, PREPARANDO_PEDIDO, LISTO;

    public Estado siguiente(Estado estado){
        switch (estado){
            case MONTANDO_PIZZA:
                return Estado.HORNEANDO;
            case HORNEANDO:
                return Estado.PREPARANDO_PEDIDO;
            case PREPARANDO_PEDIDO:
                return Estado.LISTO;
            default:
                return CREANDO;
        }
    }
}
