public class Equipe implements java.io.Serializable, Comparable<Equipe> {

    private static final long serialVersionUID = 1L;
    private String nom;
    private Integer nbMatchsGagnes;
    private Integer nbMatchsPerdus;
    private Integer nbMatchsNuls;
    private Integer butsPour;
    private Integer butsContre;

    public Equipe(String nom, Integer nbMatchsGagnes, Integer nbMatchsPerdus, Integer nbMatchsNuls, Integer butsPour,
            Integer butsContre) {
        this.nom = nom;
        this.nbMatchsGagnes = nbMatchsGagnes;
        this.nbMatchsPerdus = nbMatchsPerdus;
        this.nbMatchsNuls = nbMatchsNuls;
        this.butsPour = butsPour;
        this.butsContre = butsContre;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Integer getNbMatchsGagnes() {
        return nbMatchsGagnes;
    }

    public void setNbMatchsGagnes(Integer nbMatchsGagnes) {
        this.nbMatchsGagnes = nbMatchsGagnes;
    }

    public Integer getNbMatchsPerdus() {
        return nbMatchsPerdus;
    }

    public void setNbMatchsPerdus(Integer nbMatchsPerdus) {
        this.nbMatchsPerdus = nbMatchsPerdus;
    }

    public Integer getNbMatchsNuls() {
        return nbMatchsNuls;
    }

    public void setNbMatchsNuls(Integer nbMatchsNuls) {
        this.nbMatchsNuls = nbMatchsNuls;
    }

    public Integer getButsPour() {
        return butsPour;
    }

    public void setButsPour(Integer butsPour) {
        this.butsPour = butsPour;
    }

    public Integer getButsContre() {
        return butsContre;
    }

    public void setButsContre(Integer butsContre) {
        this.butsContre = butsContre;
    }

    @Override
    public String toString() {
        return nom  + (nom.length() > 7 ? "\t" : "\t\t") + getMatchsJoues() +
                "\t    "+ nbMatchsGagnes +
                "\t\t" + nbMatchsPerdus +
                "\t" + nbMatchsNuls +
                "\t" + butsPour +
                "\t" + butsContre +
                "\t  " + getPoints() +
                "\t\t" + getDif();
    }

    public Integer getPoints() {
        return nbMatchsGagnes * 3 + nbMatchsNuls;
    }

    public Integer getDif() {
        return butsPour - butsContre;
    }

    @Override
    public int compareTo(Equipe o) {
        if(o.getPoints() == getPoints()){
            return o.getDif().compareTo(getDif());
        }else{
            return o.getPoints().compareTo(getPoints());
        }
    }

    public Integer getMatchsJoues() {
        return nbMatchsGagnes + nbMatchsPerdus + nbMatchsNuls;
    }

    

}
