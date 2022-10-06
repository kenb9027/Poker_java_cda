package fr.asl.buisiness;

import java.util.Set;

public class Couleur {

    private String nom;
    private String symbole;

    private Set<Carte> cartes;

    public Couleur(String nom, String symbole) {
        this.nom = nom;
        this.symbole = symbole;
    }

    @Override
    public String toString() {
        return nom + " " + symbole;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getSymbole() {
        return symbole;
    }

    public void setSymbole(String symbole) {
        this.symbole = symbole;
    }

    public Set<Carte> getCartes() {
        return cartes;
    }

    public void setCartes(Set<Carte> cartes) {
        this.cartes = cartes;
    }
}


