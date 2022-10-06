package fr.asl.util;

import fr.asl.buisiness.Carte;

import java.util.Comparator ;

public class ComparateurDeCarteSurCouleurEtSurValeur implements Comparator<Carte> {
    @Override
    public int compare(Carte o1, Carte o2) {


         if ( o1.getCouleur().getNom().equals( o2.getCouleur().getNom() ) ){

             if (o1.getValeur() < o2.getValeur()){
                 return -1;
             }
             else if (o1.getValeur() > o2.getValeur()) {
                 return 1;
             }
             else{
                 return 0;
             }
         }

         return -2;


    }
}
