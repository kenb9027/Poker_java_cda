package fr.asl.util;

import fr.asl.buisiness.Carte;
import fr.asl.buisiness.Couleur;
import fr.asl.buisiness.Joueur;

import java.util.List;

public class CorrectionComparateur {

    public static String analyserMain(Joueur joueur) {
        List<Carte> main = List.copyOf(joueur.getMain());
        String resultat = "";
        int[] occurrences = new int[15];
        int nbPaires = 0;
        int nbBrelan = 0;
        boolean contientCarre = false;
        // L'As pour vérifier la quinte flush royale (Si suite && As && couleur =
        // forcément quinte
        // flush royale
        boolean asPresent = false;
        // Permet de vérifier avec la couleur précedente
        Couleur couleurTemp = main.get(0).getCouleur();
        // Par défaut la couleur est identique partout
        boolean estMemeCouleur = true;
        // On compte le Pseudobre de fois où des occurences à 1 se suivent
        int compteurSuite = 0;
        for (Carte carte : main) {
            occurrences[carte.getValeur()]++;
            // Si la valeur est 14, l'as est présent
            if (carte.getValeur() == 14) {
                asPresent = true;
            }
            // Si la couleur est différente d'avant le main n'a pas la couleur
            if (carte.getCouleur() != couleurTemp) {
                estMemeCouleur = false;
            }
        }
        for (int i = 0; i < occurrences.length; i++) {
            switch (occurrences[i]) {
                case 1:
                    // Si 1 occurence on regarde celle qui suit sauf à 14(fin de tableau)
                    if (i != 14) {
                        if (occurrences[i] == occurrences[i + 1]) {
                            // On incrémente le compteur pour la suite si l'occurence suivante est aussi de
                            // 1
                            compteurSuite++;
                        }
                    }
                    break;
                case 2:
                    nbPaires++;
                    break;
                case 3:
                    nbBrelan++;
                    break;
                case 4:
                    contientCarre = true;
                    break;
                default:
                    break;
            }
        }
        if (nbPaires == 2) {
            resultat = "deux paires";
        }
        // 1 paire + 1 brelan = 1 full
        else if (nbPaires == 1 && nbBrelan == 1) {
            resultat = "un full";
        } else if (nbPaires == 0 && nbBrelan == 1) {
            resultat = "un brelan";
        } else if (nbPaires == 1 && nbBrelan == 0) {
            resultat = "une paire";
        } else if (contientCarre) {
            resultat = "un carré";
        }
        // Si on a eu 4 fois l'élément suivant à 1,on a une suite
        // L'as est présent et la couleur aussi donc quinte flush royale
        else if (compteurSuite == 4 && estMemeCouleur && asPresent) {
            resultat = "une quinte flush royale";
        }
        // Si suite et même couleur en même temps on a une quinte flush
        else if (compteurSuite == 4 && estMemeCouleur) {
            resultat = "une quinte flush";
        }
        // On a uniquement la suite
        else if (compteurSuite == 4 && !estMemeCouleur) {
            resultat = "une suite";
        }
        // On a la même couleur mais pas de suite
        else if (estMemeCouleur && compteurSuite != 4) {
            resultat = "une couleur";
        }
        // Enfin on a trouvé aucune combinaison
        else {
            resultat = "aucune combinaison";
        }
        return resultat;
    }

}
