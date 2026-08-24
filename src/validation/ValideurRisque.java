package validation;

import model.DemandeCredit;

public class ValideurRisque extends ValideurDemande {

    @Override
    protected boolean verifier(DemandeCredit d) {
        System.out.println("-> Analyse du risque financier en cours...");

        // CDI + au moins 12 mois d'ancienneté = emploi assez stable pour valider le risque.
        boolean risqueFaible = "CDI".equals(d.getTypeContrat()) && d.getAncienneteMois() >= 12;

        if (!risqueFaible) {
            d.setEtatApprobation("REJETEE");
            d.setMotifRejet("Rejeté : risque trop élevé (contrat " + d.getTypeContrat()
                    + ", ancienneté de " + d.getAncienneteMois() + " mois ; exigé : CDI ≥ 12 mois).");
            return false;
        }

        return true;
    }
}
