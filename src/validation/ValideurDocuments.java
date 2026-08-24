package validation;

import model.DemandeCredit;

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
