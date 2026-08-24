package validation;

import model.DemandeCredit;

/**
 * ConcreteHandler. Une seule responsabilité : juger la stabilité de l'emploi.
 */
public class ValideurRisque extends ValideurDemande {

    @Override
    protected boolean verifier(DemandeCredit d) {
        System.out.println("-> Analyse du risque financier en cours...");

        // equals("CDI") est sensible à la casse : "cdi" ou "Cdi" serait rejeté.
        boolean risqueFaible = d.getTypeContrat().equals("CDI") && d.getAncienneteMois() >= 12;

        if (!risqueFaible) {
            d.setEtatApprobation("REJETEE");
            d.setMotifRejet("Rejeté : risque trop élevé (contrat " + d.getTypeContrat()
                    + ", ancienneté de " + d.getAncienneteMois() + " mois ; exigé : CDI >= 12 mois).");
            return false;
        }

        return true;
    }
}
