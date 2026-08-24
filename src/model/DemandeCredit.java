package model;

/**
 * Données d'une demande de crédit. Aucune règle métier ici :
 * la validation est entièrement déléguée à la chaîne de valideurs.
 */
public class DemandeCredit {

    private String nomClient;
    private double montant;
    private double tauxEndettement;
    private boolean estFicheBanqueCentrale;
    private boolean documentsPresents;
    private String typeContrat;
    private int ancienneteMois;
    private String etatApprobation;
    private String motifRejet;

    public DemandeCredit(String nomClient, double montant, double tauxEndettement,
                         boolean estFicheBanqueCentrale, boolean documentsPresents,
                         String typeContrat, int ancienneteMois,
                         String etatApprobation, String motifRejet) {
        this.nomClient = nomClient;
        this.montant = montant;
        this.tauxEndettement = tauxEndettement;
        this.estFicheBanqueCentrale = estFicheBanqueCentrale;
        this.documentsPresents = documentsPresents;
        this.typeContrat = typeContrat;
        this.ancienneteMois = ancienneteMois;
        this.etatApprobation = etatApprobation;
        this.motifRejet = motifRejet;
    }

    public double getMontant() {
        return montant;
    }

    public double getTauxEndettement() {
        return tauxEndettement;
    }

    public boolean isEstFicheBanqueCentrale() {
        return estFicheBanqueCentrale;
    }

    public boolean isDocumentsPresents() {
        return documentsPresents;
    }

    public String getTypeContrat() {
        return typeContrat;
    }

    public int getAncienneteMois() {
        return ancienneteMois;
    }

    public String getEtatApprobation() {
        return etatApprobation;
    }

    public void setEtatApprobation(String etatApprobation) {
        this.etatApprobation = etatApprobation;
    }

    public String getMotifRejet() {
        return motifRejet;
    }

    public void setMotifRejet(String motifRejet) {
        this.motifRejet = motifRejet;
    }

    @Override
    public String toString() {
        return "DemandeCredit ["
                + "client=" + nomClient
                + ", montant=" + String.format("%.0f", montant) + " Ar"
                + ", endettement=" + String.format("%.0f", tauxEndettement) + "%"
                + ", fichéBanqueCentrale=" + estFicheBanqueCentrale
                + ", documentsPrésents=" + documentsPresents
                + ", contrat=" + typeContrat
                + ", ancienneté=" + ancienneteMois + " mois"
                + ", état=" + etatApprobation
                + ", motifRejet=" + motifRejet
                + "]";
    }
}
