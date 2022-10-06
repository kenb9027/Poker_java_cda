import fr.asl.buisiness.Carte;
import fr.asl.buisiness.Couleur;
import fr.asl.buisiness.Joueur;
import fr.asl.util.CorrectionComparateur ;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import static fr.asl.util.CorrectionComparateur.analyserMain;

public class Main {

    private static ArrayList<Couleur> couleurs = new ArrayList<>();
    private static ArrayList<Carte> cartes = new ArrayList<>();
    private static ArrayList<Joueur> joueurs = new ArrayList<>();

    public static void main(String[] args) {

        createCouleursList();
        createCartesList();
        createJoueurs();

        // On mélange... 3 fois
        Collections.shuffle(cartes);
        Collections.shuffle(cartes);
        Collections.shuffle(cartes);
        
        /*
        DISTRIBUTION
        5 cartes par joueurs
        pour chaque joueur, on ajoute la première du paquet carte à sa main , et on la supprime du paquet
         */
        for (int i=0 ; i < 5; i++) {
            for (Joueur joueur :
                    joueurs) {
                Carte carteDistribuee = cartes.get(0);
                joueur.getMain().add(carteDistribuee);
                cartes.remove(0);
            }
        }

        //affichage de la main de chaque joueur
        for (Joueur joueur :
                joueurs) {

            // tri de la main par valeur des cartes
            joueur.getMain().sort(Comparator.comparing(Carte::getValeur));

            System.out.println(joueur);
            System.out.println(joueur.getMain());

            //getMainScoreName(joueur.getMain());

            String result = analyserMain(joueur);
            System.out.println(result);
            System.out.println();
        }

        System.out.println("Cartets restantes: " + cartes.size());
        //System.out.println(cartes);

    }

    private static void createCouleursList() {
        Couleur pique = new Couleur("Pique" , "♠");
        Couleur trefle = new Couleur("Trèfle" , "♣");
        Couleur coeur = new Couleur("Coeur" , "♥");
        Couleur carreau = new Couleur("Carreau" , "♦");

        couleurs.add(pique);
        couleurs.add(trefle);
        couleurs.add(coeur);
        couleurs.add(carreau);
    }

    private static void createCartesList() {

        for (Couleur couleur :
                couleurs) {

            for (int i=2 ; i < 15 ; i++){

                Carte carte = new Carte( i , couleur);
                cartes.add(carte);
            }

        }

    }

    private static void createJoueurs() {

            Joueur joueur1 = new Joueur("Alice");
            Joueur joueur2 = new Joueur("Bob");
            Joueur joueur3 = new Joueur("Carla");
            Joueur joueur4 = new Joueur("Donald");
            Joueur joueur5 = new Joueur("Elsa");
            Joueur joueur6 = new Joueur("Fabienne");
            Joueur joueur7 = new Joueur("Georges");
            Joueur joueur8 = new Joueur("Hubert");
            Joueur joueur9 = new Joueur("Isabelle");
            Joueur joueur10 = new Joueur("Juliette");

            joueurs.add(joueur1);
            joueurs.add(joueur2);
            joueurs.add(joueur3);
            joueurs.add(joueur4);
            /*
            joueurs.add(joueur5);
            joueurs.add(joueur6);
            joueurs.add(joueur7);
            joueurs.add(joueur8);
            joueurs.add(joueur9);
            joueurs.add(joueur10);
             */
    }

    private  static void getMainScoreName(ArrayList<Carte> main) {
        int counterCoeur = 0;
        int counterCarreau = 0;
        int counterPique = 0;
        int counterTrefle = 0;

        for (Carte carte :
                main) {
            switch (carte.getCouleur().getNom()) {
                case "Coeur":
                    counterCoeur++;
                    break;
                case "Pique":
                    counterPique++;
                    break;
                case "Trèfle":
                    counterTrefle++;
                    break;
                case "Carreau":
                    counterCarreau++;
                    break;

            }
        }

        System.out.println("Coeur: " + counterCoeur);
        System.out.println("Pique: " + counterPique);
        System.out.println("Carreau: " + counterCarreau);
        System.out.println("Trefle: " + counterTrefle);
    }
}