package fr.asl.buisiness;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Joueur {

    private static long compteur = 0L;
    private long id;
    private String pseudo;

    private ArrayList<Carte> main;

    public Joueur() {
        super();
        id = ++compteur;
        main = new ArrayList<Carte>();
    }

    public Joueur(String pseudo) {
        this();
        this.pseudo = pseudo;

    }

    @Override
    public String toString() {
        return id +" - "+ pseudo ;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public ArrayList<Carte> getMain() {
        return main;
    }

    public void setMain(ArrayList<Carte> main) {
        this.main = main;
    }

    public long getId() {
        return id;
    }
}
