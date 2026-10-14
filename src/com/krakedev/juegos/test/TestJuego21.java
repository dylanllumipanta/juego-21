
package com.krakedev.juegos.test;

import java.util.ArrayList;

import com.krakedev.juegos.entidades.Jugador;
import com.krakedev.juegos.servicios.Juego21;

public class TestJuego21 {

    public static void main(String[] args) {

        Juego21 juego = new Juego21();

        Jugador jugador1 = new Jugador();
        jugador1.setNickname("Dylan");

        Jugador jugador2 = new Jugador();
        jugador2.setNickname("Carlos");

        Jugador jugador3 = new Jugador();
        jugador3.setNickname("Maria");

        juego.agregarJugador(jugador1);
        juego.agregarJugador(jugador2);
        juego.agregarJugador(jugador3);

        juego.inicializar();

        // PRIMERA PRUEBA
        System.out.println("===== PRIMERA PARTIDA =====");

        ArrayList<Jugador> ganadores = juego.jugar();

        if (ganadores.isEmpty()) {
            System.out.println("No hubo ganadores.");
        } else {
            System.out.println("GANADORES:");

            for (Jugador ganador : ganadores) {
                ganador.imprimir();
            }
        }

        System.out.println(
            "Cartas restantes: " + juego.getDealer()
                    .getNaipe().size()
        );

        System.out.println("\n===== PRUEBA DE 10 PARTIDAS =====");

        boolean huboGanador = false;

        for (int i = 1; i <= 10; i++) {

            juego.reiniciarJuego();

            System.out.println("\nPARTIDA NUMERO " + i);

            ganadores = juego.jugar();

            if (!ganadores.isEmpty()) {

                huboGanador = true;

                System.out.println("Ganadores de la partida:");

                for (Jugador ganador : ganadores) {
                    ganador.imprimir();
                }

                break;
            } else {
                System.out.println(
                    "No hubo ganador en esta partida."
                );
            }
        }

        if (!huboGanador) {
            System.out.println(
                "No hubo ganadores en las 10 partidas."
            );
        }
    }
}
