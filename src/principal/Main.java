package principal;

import model.DemandeCredit;
import validation.ValideurDemande;
import validation.ValideurDirection;
import validation.ValideurDocuments;
import validation.ValideurRisque;
import validation.ValideurSolvabilite;

public class Main {

    public static void main(String[] args) {
        scenarioA();
        System.out.println();
        scenarioB();
        System.out.println();
        scenarioC();
    }

    /**
     * Point unique d'assemblage. Changer l'ordre ou ajouter un maillon se fait
     * ici, sans modifier les classes de validation déjà écrites (Open/Closed).
     */
    private static ValideurDemande construireChaine() {
        ValideurDemande solvabilite = new ValideurSolvabilite();
        ValideurDemande documents = new ValideurDocuments();
        ValideurDemande risque = new ValideurRisque();
        ValideurDemande direction = new ValideurDirection();

        solvabilite.setSuivant(documents);
        documents.setSuivant(risque);
        risque.setSuivant(direction);

        return solvabilite;
    }

    private static void scenarioA() {
        System.out.println("=== SCENARIO A : SUCCES ===");

        DemandeCredit demande = new DemandeCredit(
                "Rasoanaivo Hery",
                60_000_000,
                20,
                false,
                true,
                "CDI",
                24,
                "EN_ATTENTE",
                null
        );

        System.out.println("Demande initiale : " + demande);
        construireChaine().valider(demande);
        System.out.println("État d'approbation final : " + demande.getEtatApprobation());
        System.out.println("Demande après traitement : " + demande);
    }

    private static void scenarioB() {
        System.out.println("=== SCENARIO B : ECHEC INTERMEDIAIRE ===");

        DemandeCredit demande = new DemandeCredit(
                "Rakoto Jean",
                15_000_000,
                18,
                false,
                false,
                "CDI",
                36,
                "EN_ATTENTE",
                null
        );

        System.out.println("Demande initiale : " + demande);
        construireChaine().valider(demande);
        System.out.println("État d'approbation final : " + demande.getEtatApprobation());
        System.out.println("Motif du rejet : " + demande.getMotifRejet());
    }

    private static void scenarioC() {
        System.out.println("=== SCENARIO C : SKIP DIRECTION ===");

        // Direction requise uniquement si montant > 50 000 000 Ar.
        // Ici 30 000 000 : le maillon s'exécute (trace console) mais ne lit pas le plafond.
        DemandeCredit demande = new DemandeCredit(
                "Andrianaivo Soa",
                30_000_000,
                22,
                false,
                true,
                "CDI",
                18,
                "EN_ATTENTE",
                null
        );

        System.out.println("Demande initiale : " + demande);
        construireChaine().valider(demande);
        System.out.println("État d'approbation final : " + demande.getEtatApprobation());
        System.out.println("Demande après traitement : " + demande);
    }
}
