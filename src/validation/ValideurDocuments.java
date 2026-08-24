package validation;

import model.DemandeCredit;

/**
 * ConcreteHandler. Une seule responsabilité : vérifier la présence des pièces.
 * Contrôle agrégé via un booléen unique, pas pièce par pièce.
 * Limitation assumée pour ce projet académique.
 */
public class ValideurDocuments extends ValideurDemande {

    @Override
    protected boolean verifier(DemandeCredit d) {
        System.out.println("-> Vérification des pièces justificatives en cours...");

        if (!d.isDocumentsPresents()) {
            d.setEtatApprobation("REJETEE");
            d.setMotifRejet("Rejeté : pièces justificatives manquantes "
                    + "(carte d'identité, 3 derniers bulletins de paie, justificatif de domicile).");
            return false;
        }

        return true;
    }
}
