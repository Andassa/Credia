package validation;

import model.DemandeCredit;

/**
 * Handler abstrait. Template Method : valider() fixe le chaînage une seule fois.
 * Les sous-classes n'écrivent que verifier(). Elles ne peuvent ni appeler le
 * suivant elles-mêmes, ni poser APPROUVEE, donc elles ne peuvent pas casser
 * la chaîne (principe DRY, une seule responsabilité pour le chaînage).
 */
public abstract class ValideurDemande {

    protected ValideurDemande suivant;

    public void setSuivant(ValideurDemande v) {
        this.suivant = v;
    }

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
