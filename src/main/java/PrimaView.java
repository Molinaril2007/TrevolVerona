import javax.swing.*;
import java.awt.*;
import java.util.List;

public class PrimaView {
    private JFrame finestra;
    private JButton btnOkay;
    private JLabel lblFacile, lblCustom, lblRemove, lblInizio, lblFine, lblTitolo;
    private JToggleButton btnFacile, btnCustom, btnRemove;
    private JComboBox<String> comboBoxInizio, comboBoxFine;
    private JPanel pnlFacile, pnlCustom, pnlRemove, pnlTotal, pnlComuneInzio, pnlComuneFine, pnlSceltaComuni;
    private boolean chosenCustom, chosenFacile, chosenRemove;

    public PrimaView(List<Comune> comuni) {
        String [] tempInizio = new String[comuni.size()];
        for (int i = 0; i < comuni.size(); i++)
            tempInizio[i] = comuni.get(i).getNome();
        String [] tempFine = new String[comuni.size()];
        for (int i = 0; i < comuni.size(); i++) {
            tempFine[i] = comuni.get(i).getNome();
        }
        finestra = new JFrame();
        btnOkay = new JButton("GIOCHIAMO!");
        lblTitolo = new JLabel("TreVol Verona");
        lblFacile = new JLabel("Seleziona per la modalità facile");
        lblCustom = new JLabel("Seleziona per scegliere i comuni di inizio e di fine");
        lblRemove = new JLabel("Seleziona per la modalità senza Verona");
        lblInizio = new JLabel("Seleziona il comune di inizio");
        lblFine = new JLabel("Seleziona il comune di fine");
        btnFacile = new JToggleButton(""+chosenFacile);
        btnCustom = new JToggleButton(""+chosenCustom);
        btnRemove = new JToggleButton(""+chosenRemove);
        comboBoxInizio = new JComboBox<>(tempInizio);
        comboBoxFine = new JComboBox<>(tempFine);
        pnlCustom = new JPanel();
        pnlFacile = new JPanel();
        pnlRemove = new JPanel();
        pnlTotal = new JPanel();
        pnlComuneInzio = new JPanel();
        pnlComuneFine = new JPanel();
        pnlSceltaComuni = new JPanel();


        pnlRemove.add(lblRemove);
        pnlRemove.add(btnRemove);

        pnlFacile.add(lblFacile);
        pnlFacile.add(btnFacile);

        pnlCustom.add(lblCustom);
        pnlCustom.add(btnCustom);

        pnlComuneInzio.add(lblInizio);
        pnlComuneInzio.add(comboBoxInizio);

        pnlComuneFine.add(lblFine);
        pnlComuneFine.add(comboBoxFine);

        pnlSceltaComuni.setLayout(new GridLayout(3, 1));
        pnlSceltaComuni.add(pnlCustom);
        pnlSceltaComuni.add(pnlComuneInzio);
        pnlSceltaComuni.add(pnlComuneFine);

        pnlTotal.setLayout(new GridLayout(3, 1));
        pnlTotal.add(pnlRemove);
        pnlTotal.add(pnlFacile);
        pnlTotal.add(pnlCustom);

        finestra.add(lblTitolo, BorderLayout.NORTH);
        finestra.add(pnlTotal, BorderLayout.CENTER);
        finestra.add(btnOkay, BorderLayout.SOUTH);

        finestra.setSize(400, 200);
        finestra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        finestra.setVisible(true);
    }

    public boolean isChosenCustom() {
        return chosenCustom;
    }

    public void setChosenCustom(boolean chosenCustom) {
        this.chosenCustom = chosenCustom;
    }

    public boolean isChosenFacile() {
        return chosenFacile;
    }

    public void setChosenFacile(boolean chosenFacile) {
        this.chosenFacile = chosenFacile;
    }

    public boolean isChosenRemove() {
        return chosenRemove;
    }

    public void setChosenRemove(boolean chosenRemove) {
        this.chosenRemove = chosenRemove;
    }

    public JFrame getFinestra() {
        return finestra;
    }

    public void setFinestra(JFrame finestra) {
        this.finestra = finestra;
    }

    public JButton getBtnOkay() {
        return btnOkay;
    }

    public void setBtnOkay(JButton btnOkay) {
        this.btnOkay = btnOkay;
    }

    public JLabel getLblFacile() {
        return lblFacile;
    }

    public void setLblFacile(JLabel lblFacile) {
        this.lblFacile = lblFacile;
    }

    public JLabel getLblCustom() {
        return lblCustom;
    }

    public void setLblCustom(JLabel lblCustom) {
        this.lblCustom = lblCustom;
    }

    public JLabel getLblRemove() {
        return lblRemove;
    }

    public void setLblRemove(JLabel lblRemove) {
        this.lblRemove = lblRemove;
    }

    public JLabel getLblInizio() {
        return lblInizio;
    }

    public void setLblInizio(JLabel lblInizio) {
        this.lblInizio = lblInizio;
    }

    public JLabel getLblFine() {
        return lblFine;
    }

    public void setLblFine(JLabel lblFine) {
        this.lblFine = lblFine;
    }

    public JToggleButton getBtnFacile() {
        return btnFacile;
    }

    public void setBtnFacile(JToggleButton btnFacile) {
        this.btnFacile = btnFacile;
    }

    public JToggleButton getBtnCustom() {
        return btnCustom;
    }

    public void setBtnCustom(JToggleButton btnCustom) {
        this.btnCustom = btnCustom;
    }

    public JToggleButton getBtnRemove() {
        return btnRemove;
    }

    public void setBtnRemove(JToggleButton btnRemove) {
        this.btnRemove = btnRemove;
    }

    public JComboBox<String> getComboBoxInizio() {
        return comboBoxInizio;
    }

    public void setComboBoxInizio(JComboBox<String> comboBoxInizio) {
        this.comboBoxInizio = comboBoxInizio;
    }

    public JComboBox<String> getComboBoxFine() {
        return comboBoxFine;
    }

    public void setComboBoxFine(JComboBox<String> comboBoxFine) {
        this.comboBoxFine = comboBoxFine;
    }
}
