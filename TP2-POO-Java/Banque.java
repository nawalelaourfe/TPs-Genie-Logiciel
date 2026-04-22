// Exercice 1.3 — Gestion des comptes bancaires

// 1. Classe de base CompteBancaire
class CompteBancaire {
    private String numeroCompte; // Encapsulation : privé
    protected double solde;      // protected : accessible aux sous-classes

    public CompteBancaire(String numeroCompte, double soldeInitial) {
        this.numeroCompte = numeroCompte;
        this.solde        = soldeInitial;
    }

    public String getNumeroCompte() { return numeroCompte; }
    public double getSolde()        { return solde; }

    public void deposer(double montant) {
        if (montant > 0) {
            solde += montant;
            System.out.println("Dépôt de " + montant + "€. Solde: " + solde + "€");
        } else {
            System.out.println("Montant invalide.");
        }
    }

    public void retirer(double montant) {
        if (montant > solde) {
            System.out.println("Solde insuffisant ! Solde actuel: " + solde + "€");
        } else {
            solde -= montant;
            System.out.println("Retrait de " + montant + "€. Solde: " + solde + "€");
        }
    }
}

// 2. Classe CompteCourant — Héritage de CompteBancaire
class CompteCourant extends CompteBancaire {
    public CompteCourant(String numeroCompte, double soldeInitial) {
        super(numeroCompte, soldeInitial);
    }
}

// 3. Classe CompteEpargne — Héritage + méthode supplémentaire
class CompteEpargne extends CompteBancaire {
    public CompteEpargne(String numeroCompte, double soldeInitial) {
        super(numeroCompte, soldeInitial);
    }

    // Méthode spécifique : calcul des intérêts
    public void calculerInterets(double taux) {
        double interets = solde * taux / 100;
        solde += interets;
        System.out.println("Intérêts (" + taux + "%): +" + interets + "€. Solde: " + solde + "€");
    }
}

// 4. Classe principale
public class Banque {
    public static void main(String[] args) {
        CompteCourant  cc = new CompteCourant("CC-001", 1000.0);
        CompteEpargne  ce = new CompteEpargne("CE-001", 5000.0);

        System.out.println("=== Compte Courant (" + cc.getNumeroCompte() + ") ===");
        cc.deposer(500);
        cc.retirer(200);
        cc.retirer(2000); // test : solde insuffisant

        System.out.println("\n=== Compte Épargne (" + ce.getNumeroCompte() + ") ===");
        ce.deposer(1000);
        ce.calculerInterets(3.5); // 3.5% d'intérêts sur 6000€
    }
}
