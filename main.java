import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class main {

    public static void main(String[] args) {

        FichierEchange<Equipe> echange = new FichierEchange<>();

        ArrayList<Equipe> equipes;
        // ArrayList<Equipe> classement;
        try {
            echange.videFichier("Classement.data");

            equipes = new ArrayList<>(echange.lire("Equipes.data"));
            Collections.sort(equipes);

            System.out.println("-----------------------------------------------------------------------------------------------------------");
            System.out.println("Rang |   Equipe   |   Matchs  |  Victoire  | Défaite | Nul |  Buts + | Buts - | Points | Différence de buts");
            System.out.println("-----------------------------------------------------------------------------------------------------------");

            for (int i = 0; i < equipes.size(); i++) {
                System.out.println((i+1) + "\t" + equipes.get(i));
                echange.ecrireLigne("Classement.data", equipes.get(i));
            }

            System.out.println("Fichier de classement crée.");

            // classement = new ArrayList<>(echange.lire("Classement.data"));
            // Collections.sort(classement);

            // for (int i = 0; i < classement.size(); i++) {
            //     System.out.println((i+1) + "--" + classement.get(i));
            // }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
