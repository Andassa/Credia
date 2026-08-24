package validation;

import model.DemandeCredit;

/**
 * ConcreteHandler. Une seule responsabilité : le visa Direction.
 * Le maillon s'exécute toujours (la trace console s'affiche dans tous les cas).
 * Seule la logique de contrôle se simplifie si le montant est sous le seuil :
 * pas de lecture du plafond, return true tout de suite.
 */
public class ValideurDirection extends ValideurDemande {

    private static final double SEUIL_DIRECTION = 50_000_000;
    private static final double PLAFOND_DIRECTION = 100_000_000;

    @Override
    protected boolean verifier(DemandeCredit d) {
        System.out.println("-> Approbation de la Direction en cours...");

        if (d.getMontant() <= SEUIL_DIRECTION) {
            return true;
        }

        if (d.getMontant() > PLAFOND_DIRECTION) {
            d.setEtatApprobation("REJETEE");
            d.setMotifRejet("Rejeté par la Direction : montant de " + d.getMontant()
                    + " Ar supérieur au plafond de " + PLAFOND_DIRECTION + " Ar.");
            return false;
        }

        return true;
    }
}
