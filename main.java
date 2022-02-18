import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class main {

    public static void main(String[] args) {

        FichierEchange<Equipe> echange = new FichierEchange<>();

        ArrayList<Equipe> equipes;
        try {
            equipes = new ArrayList<>(echange.lire("Equipes.data"));
            Collections.sort(equipes);
            for (int i = 0; i < equipes.size(); i++) {
                System.out.println(i + "--" + equipes.get(i));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
