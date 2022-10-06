package fr.asl.buisiness;

public class Carte {

    private String nom;
    private int valeur;

    private Couleur couleur;

    public Carte( int valeur, Couleur couleur) {
        super();
        this.valeur = valeur;
        this.couleur = couleur;
        //this.couleur.getCartes().add(this);

        switch (valeur) {
            case 14 -> this.nom = "As";
            case 13 -> this.nom = "Roi";
            case 12 -> this.nom = "Dame";
            case 11 -> this.nom = "Valet";
            default -> this.nom = Integer.toString(valeur);
        }
    }

    @Override
    public String toString() {
        return nom + " de " + couleur.getSymbole() ;
    }


    public String getNom() {
        return nom ;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getValeur() {
        return valeur;
    }

    public void setValeur(int valeur) {
        this.valeur = valeur;
    }

    public Couleur getCouleur() {
        return couleur;
    }

    public void setCouleur(Couleur couleur) {
        this.couleur = couleur;
    }
}
