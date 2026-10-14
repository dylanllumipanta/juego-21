
package com.krakedev.juegos.servicios;

import java.util.ArrayList;
import java.util.Random;

import com.krakedev.juegos.entidades.Carta;

public class Dealer {

    private ArrayList<Carta> naipe;

    public Dealer() {
        naipe = new ArrayList<Carta>();
        generarNaipe();
    }

    public ArrayList<Carta> getNaipe() {
        return naipe;
    }

    public void setNaipe(ArrayList<Carta> naipe) {
        this.naipe = naipe;
    }

    public void generarNaipe() {
        naipe.clear();

        String[] valores = {
            "A", "2", "3", "4", "5", "6", "7",
            "8", "9", "10", "J", "Q", "K"
        };

        String[] palos = {"T", "CN", "D", "CR"};

        for (int i = 0; i < palos.length; i++) {
            for (int j = 0; j < valores.length; j++) {
                Carta carta = new Carta();

                carta.setValor(valores[j]);
                carta.setPalo(palos[i]);

                // El valorJuego se asignará en Juego21.
                naipe.add(carta);
            }
        }
    }

    public void imprimirNaipe() {
        for (Carta carta : naipe) {
            carta.imprimir();
        }

        System.out.println("Total de cartas en el naipe: "
                + naipe.size());
    }

    public int generarAleatorio(int maximo) {
        if (maximo < 0) {
            throw new IllegalArgumentException(
                "El máximo no puede ser negativo"
            );
        }

        Random random = new Random();
        return random.nextInt(maximo + 1);
    }

    public Carta entregarCarta() {
        if (naipe == null || naipe.isEmpty()) {
            return null;
        }

        int posicion = generarAleatorio(naipe.size() - 1);

        Carta carta = naipe.get(posicion);

        naipe.remove(posicion);

        return carta;
    }
}
