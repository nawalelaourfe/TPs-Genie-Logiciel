// Exercice 1.2 — Système de gestion des véhicules

// 1. Classe abstraite Vehicule
abstract class Vehicule {
    private String marque;  // Encapsulation : attributs privés
    private String modele;
    private int annee;

    public Vehicule(String marque, String modele, int annee) {
        this.marque = marque;
        this.modele = modele;
        this.annee  = annee;
    }

    public String getMarque() { return marque; }
    public String getModele() { return modele; }
    public int    getAnnee()  { return annee;  }

    // Méthode concrète commune à tous les véhicules
    public void demarrer() {
        System.out.println("Le véhicule démarre.");
    }

    // Abstraction : méthode abstraite
    public abstract void afficherDetails();
}

// 2. Classe Voiture — Héritage de Vehicule
class Voiture extends Vehicule {
    private int nombreDePortes;

    public Voiture(String marque, String modele, int annee, int nombreDePortes) {
        super(marque, modele, annee); // appel constructeur parent
        this.nombreDePortes = nombreDePortes;
    }

    @Override
    public void afficherDetails() {
        demarrer();
        System.out.println("Voiture: " + getMarque() + " " + getModele()
            + " (" + getAnnee() + "), Portes: " + nombreDePortes);
    }
}

// 3. Classe Camion — Héritage de Vehicule
class Camion extends Vehicule {
    private double capaciteDeCharge;

    public Camion(String marque, String modele, int annee, double capaciteDeCharge) {
        super(marque, modele, annee);
        this.capaciteDeCharge = capaciteDeCharge;
    }

    @Override
    public void afficherDetails() {
        demarrer();
        System.out.println("Camion: " + getMarque() + " " + getModele()
            + " (" + getAnnee() + "), Capacité: " + capaciteDeCharge + " tonnes");
    }
}

// 4. Classe Moto — Nouvelle classe héritant de Vehicule
class Moto extends Vehicule {
    private String typeDeGuidon;

    public Moto(String marque, String modele, int annee, String typeDeGuidon) {
        super(marque, modele, annee);
        this.typeDeGuidon = typeDeGuidon;
    }

    @Override
    public void afficherDetails() {
        demarrer();
        System.out.println("Moto: " + getMarque() + " " + getModele()
            + " (" + getAnnee() + "), Guidon: " + typeDeGuidon);
    }
}

// 5. Classe principale
public class GestionTransport {
    public static void main(String[] args) {
        Vehicule maVoiture = new Voiture("Toyota", "Corolla", 2021, 4);
        Vehicule monCamion = new Camion("Volvo", "FMX", 2019, 12.5);
        Vehicule maMoto    = new Moto("Yamaha", "MT-07", 2022, "Sport");

        // Polymorphisme : afficherDetails() se comporte différemment selon l'instance
        maVoiture.afficherDetails();
        System.out.println();
        monCamion.afficherDetails();
        System.out.println();
        maMoto.afficherDetails();
    }
}
