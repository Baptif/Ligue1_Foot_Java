import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public final class FichierEchange<T> {
    public List<T> lire(String nomFichier) throws IOException, ClassNotFoundException {
        List<T> objectList = new ArrayList<>();
        try {
            FileInputStream fileIn = new FileInputStream(nomFichier);
            try (ObjectInputStream objectIn = new ObjectInputStream(fileIn)) {
                while (true) {
                    @SuppressWarnings("unchecked")
                    T object = (T) objectIn.readObject();
                    objectList.add(object);
                }
            }
        } catch (EOFException eof) {
            // Signal de fin de fichier
        }

        return objectList;
    }

    public void ecrireLigne(String nomFichier, T ligne)
            throws IOException, ClassNotFoundException {
        List<T> objectList = lire(nomFichier);
        objectList.add(ligne);

        FileOutputStream fileOut = new FileOutputStream(nomFichier);
        try (ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {
            for (T ligneListe : objectList) {
                objectOut.writeObject(ligneListe);
            }
        }
    }

    public void videFichier(String nomFichier)
            throws IOException, ClassNotFoundException {
        new FileOutputStream(nomFichier).close();
    }
}
