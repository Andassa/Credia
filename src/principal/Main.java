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
    }

    /**
     * Assemble la chaîne. Changer l'ordre (ou insérer un maillon) se fait ici,
     * sans modifier DemandeCredit ni les classes de validation existantes.
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
}
