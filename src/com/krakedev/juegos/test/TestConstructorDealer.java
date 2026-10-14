
package com.krakedev.juegos.test;

import com.krakedev.juegos.servicios.Dealer;

public class TestConstructorDealer {

    public static void main(String[] args) {

        Dealer dealer = new Dealer();

        dealer.imprimirNaipe();

        System.out.println("Cantidad esperada: 52");
        System.out.println(
            "Cantidad generada: " + dealer.getNaipe().size()
        );
    }
}
