package model;

/**
 * Objet Request du pattern Chain of Responsibility.
 * Contient uniquement les données du dossier. Aucune règle de validation ici :
 * ce sont les valideurs qui décident d'approuver ou de rejeter.
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

    public String getNomClient() {
        return nomClient;
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
                + ", ficheBanqueCentrale=" + estFicheBanqueCentrale
                + ", documentsPresents=" + documentsPresents
                + ", contrat=" + typeContrat
                + ", anciennete=" + ancienneteMois + " mois"
                + ", etat=" + etatApprobation
                + ", motifRejet=" + motifRejet
                + "]";
    }
}
