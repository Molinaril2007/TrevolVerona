import java.io.Serializable;
import java.util.Arrays;

public class Partita implements Serializable {
    private Comune inizio;
    private Comune fine;
    private int numeroTentativiUtente;
    private int numeroMinimoTentativi;
    private boolean vittoria;
    private boolean[] opzioni;
    private int sceltaTentativi;

    public Partita(Comune fine, Comune inizio, int numeroMinimoTentativi, int numeroTentativiUtente, boolean[] opzioni, int sceltaTentativi, boolean vittoria) {
        this.fine = fine;
        this.inizio = inizio;
        this.numeroMinimoTentativi = numeroMinimoTentativi;
        this.numeroTentativiUtente = numeroTentativiUtente;
        this.opzioni = opzioni;
        this.sceltaTentativi = sceltaTentativi;
        this.vittoria = vittoria;
    }


    @Override
    public String toString() {
        return "Partita{" +
                "fine=" + fine +
                ", inizio=" + inizio +
                ", numeroTentativiUtente=" + numeroTentativiUtente +
                ", numeroMinimoTentativi=" + numeroMinimoTentativi +
                ", vittoria=" + vittoria +
                ", opzioni=" + Arrays.toString(opzioni) +
                ", sceltaTentativi=" + sceltaTentativi +
                '}';
    }

    public Comune getFine() {
        return fine;
    }

    public void setFine(Comune fine) {
        this.fine = fine;
    }

    public Comune getInizio() {
        return inizio;
    }

    public void setInizio(Comune inizio) {
        this.inizio = inizio;
    }

    public int getNumeroMinimoTentativi() {
        return numeroMinimoTentativi;
    }

    public void setNumeroMinimoTentativi(int numeroMinimoTentativi) {
        this.numeroMinimoTentativi = numeroMinimoTentativi;
    }

    public int getNumeroTentativiUtente() {
        return numeroTentativiUtente;
    }

    public void setNumeroTentativiUtente(int numeroTentativiUtente) {
        this.numeroTentativiUtente = numeroTentativiUtente;
    }

    public boolean[] getOpzioni() {
        return opzioni;
    }

    public void setOpzioni(boolean[] opzioni) {
        this.opzioni = opzioni;
    }

    public int getSceltaTentativi() {
        return sceltaTentativi;
    }

    public void setSceltaTentativi(int sceltaTentativi) {
        this.sceltaTentativi = sceltaTentativi;
    }

    public boolean isVittoria() {
        return vittoria;
    }

    public void setVittoria(boolean vittoria) {
        this.vittoria = vittoria;
    }
}
