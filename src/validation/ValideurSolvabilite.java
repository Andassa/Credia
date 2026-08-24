package validation;

import model.DemandeCredit;

/**
 * ConcreteHandler. Une seule responsabilité : juger la solvabilité du client
 * (fichage Banque Centrale, puis taux d'endettement). Rien d'autre.
 */
public class ValideurSolvabilite extends ValideurDemande {

    @Override
    protected boolean verifier(DemandeCredit d) {
        System.out.println("-> Vérification solvabilité en cours...");

        if (d.isEstFicheBanqueCentrale()) {
            d.setEtatApprobation("REJETEE");
            d.setMotifRejet("Rejeté : le client est fiché à la Banque Centrale.");
            return false;
        }

        if (d.getTauxEndettement() >= 33) {
            d.setEtatApprobation("REJETEE");
            d.setMotifRejet("Rejeté : taux d'endettement de " + d.getTauxEndettement()
                    + "% supérieur au seuil de 33%");
            return false;
        }

        return true;
    }
}
