// Exercice 1.1 — Système de gestion d'animaux dans un zoo

// 1. Classe abstraite Animal
abstract class Animal {
    private String nom; // Encapsulation : attribut privé

    public Animal(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom; // getter public pour accéder à l'attribut privé
    }

    // Abstraction : méthode abstraite, chaque sous-classe doit l'implémenter
    public abstract void faireDuBruit();
}

// 2. Classe Mammifere — Héritage de Animal
class Mammifere extends Animal {
    public Mammifere(String nom) {
        super(nom); // appel au constructeur parent
    }

    @Override
    public void faireDuBruit() {
        System.out.println(getNom() + " grogne.");
    }
}

// 3. Classe Oiseau — Héritage de Animal
class Oiseau extends Animal {
    public Oiseau(String nom) {
        super(nom);
    }

    @Override
    public void faireDuBruit() {
        System.out.println(getNom() + " chante.");
    }

    // Méthode spécifique aux oiseaux
    public void voler() {
        System.out.println("L'oiseau vole.");
    }
}

// 4. Classe principale
public class Zoo {
    public static void main(String[] args) {
        Animal tigre     = new Mammifere("Tigre");
        Animal perroquet = new Oiseau("Perroquet");

        // Polymorphisme : même méthode, comportements différents
        tigre.faireDuBruit();      // Tigre grogne.
        perroquet.faireDuBruit();  // Perroquet chante.

        // Utilisation de voler() -> cast nécessaire
        Oiseau o = (Oiseau) perroquet;
        o.voler(); // L'oiseau vole.
    }
}
