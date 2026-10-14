
package com.krakedev.juegos.test;

import com.krakedev.juegos.servicios.Dealer;

public class TestAleatorio {

    public static void main(String[] args) {

        Dealer dealer = new Dealer();

        int maximo = 10;
        boolean encontroCero = false;
        boolean encontroMaximo = false;

        for (int i = 0; i < 100; i++) {

            int numero = dealer.generarAleatorio(maximo);

            System.out.println(numero);

            if (numero < 0 || numero > maximo) {
                System.out.println("ERROR: fuera del rango");
                return;
            }

            if (numero == 0) {
                encontroCero = true;
            }

            if (numero == maximo) {
                encontroMaximo = true;
            }
        }

        System.out.println("¿Salió el cero?: " + encontroCero);
        System.out.println(
            "¿Salió el máximo?: " + encontroMaximo
        );
    }
}
