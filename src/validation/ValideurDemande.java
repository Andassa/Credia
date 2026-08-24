package validation;

import model.DemandeCredit;

/**
 * Maillon abstrait de la chaîne : chaque valideur concret ne connaît que
 * sa propre règle. L'enchaînement et l'approbation finale sont gérés ici.
 */
public abstract class ValideurDemande {

    protected ValideurDemande suivant;

    public void setSuivant(ValideurDemande v) {
        this.suivant = v;
    }

    /**
     * Template method : applique la règle locale, puis transmet ou s'arrête.
     * Si le maillon est le dernier et que la vérification réussit, la demande
     * est marquée APPROUVEE (aucun maillon concret ne doit le faire).
     */
    public final boolean valider(DemandeCredit d) {
        if (!verifier(d)) {
            return false;
        }
        if (suivant != null) {
            return suivant.valider(d);
        }
        d.setEtatApprobation("APPROUVEE");
        return true;
    }

    protected abstract boolean verifier(DemandeCredit d);
}
