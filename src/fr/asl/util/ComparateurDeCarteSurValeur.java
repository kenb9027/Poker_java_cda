package fr.asl.util;

import fr.asl.buisiness.Carte;

import java.util.Comparator ;

public class ComparateurDeCarteSurValeur implements Comparator<Carte> {
    @Override
    public int compare(Carte o1, Carte o2) {

        return Integer.compare(o1.getValeur(), o2.getValeur());
        /**
         *         if (o1.getValeur() < o2.getValeur()){
         *             return -1;
         *         }
         *         else if (o1.getValeur() > o2.getValeur()) {
         *             return 1;
         *         }
         *         else{
         *             return 0;
         *         }
         */

    }
}
