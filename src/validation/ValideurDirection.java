package validation;

import model.DemandeCredit;

public class ValideurDirection extends ValideurDemande {

    private static final double SEUIL_DIRECTION = 50_000_000;
    private static final double PLAFOND_DIRECTION = 100_000_000;

    @Override
    protected boolean verifier(DemandeCredit d) {
        System.out.println("-> Approbation de la Direction en cours...");

        // En dessous de 50 M Ar, le visa Direction n'est pas exigé : le risque reste limité.
        if (d.getMontant() <= SEUIL_DIRECTION) {
            return true;
        }

        // Au-delà de 50 M Ar, la Direction refuse si le montant dépasse 100 M Ar (exposition trop élevée).
        if (d.getMontant() > PLAFOND_DIRECTION) {
            d.setEtatApprobation("REJETEE");
            d.setMotifRejet("Rejeté par la Direction : montant de " + d.getMontant()
                    + " Ar supérieur au plafond de " + PLAFOND_DIRECTION + " Ar.");
            return false;
        }

        return true;
    }
}
