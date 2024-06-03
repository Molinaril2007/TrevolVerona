import org.apache.xmlgraphics.image.loader.impl.AbstractImageSessionContext;

import javax.swing.*;
import java.awt.*;

public class PrimaView {
    private JFrame finestra;
    private JLabel lblTitolo;
    private JLabel lblFacile;
    private JLabel lblCustom;
    private JLabel lblComuneInizio;
    private JLabel lblComuneFine;
    private JLabel lblRemove;
    private JLabel lblDifficile;
    private JToggleButton btnFacile;
    private JToggleButton btnInizioFine;
    private JToggleButton btnSenzaVerona;
    private JToggleButton btnDifficile;
    private JButton btnOkay;
    private JComboBox cmbComuneInizio;
    private JComboBox cmbComuneFine;
    private boolean chosenCustom = false;
    private boolean chosenFacile = false;
    private boolean chosenRemove = false;
    private boolean chosenDifficile = false;

    public PrimaView(Provincia provincia) {
        finestra = new JFrame();
        lblTitolo = new JLabel("Trevol Verona");
        lblFacile = new JLabel("Clicca il pulsante per la modalità facile");
        lblCustom = new JLabel("Clicca il pulsante per scegliere i comuni di inizio e di fine");
        lblComuneInizio = new JLabel("Comune di inizio:");
        lblComuneFine = new JLabel("Comune di fine:");
        lblRemove = new JLabel("Clicca il pulsante per giocare senza Verona");
        lblDifficile = new JLabel("Clicca il pulsante per la modalità difficile");
        btnDifficile = new JToggleButton(nomeDiffficile(chosenDifficile));
        btnFacile = new JToggleButton(nomeFacile(chosenFacile));
        btnInizioFine = new JToggleButton(nomeCustom(chosenCustom));
        btnSenzaVerona = new JToggleButton(nomeRemove(chosenRemove));
        btnOkay = new JButton("OK!");
        String[] comuniFine = new String[provincia.getComuni().size()+1];
        comuniFine[0] = "Seleziona il comune di fine";
        for (int i = 0; i < comuniFine.length-1; i++) {
            comuniFine[i+1] = provincia.getComuni().get(i).getNome();
        }
        cmbComuneFine = new JComboBox(comuniFine);
        String[] comuniInizio = new String[provincia.getComuni().size()+1];
        comuniInizio[0] = "Seleziona il comune di inizio";
        for (int i = 0; i < comuniInizio.length-1; i++) {
            comuniInizio[i+1] = provincia.getComuni().get(i).getNome();
        }
        cmbComuneInizio = new JComboBox(comuniInizio);

        //setBounds()
        lblTitolo.setBounds(440, 40, 300, 50);
        lblTitolo.setFont(new Font("SansSerif", Font.ITALIC, 36));
        lblFacile.setBounds(20, 130, 700, 30);
        lblFacile.setFont(new Font("SansSerif", Font.PLAIN, 26));
        lblCustom.setBounds(20, 190, 700, 30);
        lblCustom.setFont(new Font("SansSerif", Font.PLAIN, 26));
        lblComuneInizio.setBounds(20, 280, 300, 30);
        lblComuneInizio.setFont(new Font("SansSerif", Font.PLAIN, 26));
        lblComuneFine.setBounds(20, 340, 300, 30);
        lblComuneFine.setFont(new Font("SansSerif", Font.PLAIN, 26));
        lblDifficile.setFont(new Font("SansSerif", Font.PLAIN, 26));
        lblDifficile.setBounds(20, 495, 700, 30);
        lblRemove.setBounds(20, 430, 700, 30);
        lblRemove.setFont(new Font("SansSerif", Font.PLAIN, 26));
        btnFacile.setBounds(950, 125, 100, 40);
        btnFacile.setFont(new Font("SansSerif", Font.PLAIN, 18));
        btnInizioFine.setBounds(950, 185, 100, 40);
        btnInizioFine.setFont(new Font("SansSerif", Font.PLAIN, 18));
        btnSenzaVerona.setBounds(950, 425, 100, 40);
        btnSenzaVerona.setFont(new Font("SansSerif", Font.PLAIN, 18));
        btnOkay.setBounds(500, 550, 100, 40);
        btnOkay.setFont(new Font("SansSerif", Font.PLAIN, 24));
        btnDifficile.setFont(new Font("SansSerif", Font.PLAIN, 18));
        btnDifficile.setBounds(950, 495, 100, 40);
        cmbComuneInizio.setBounds(300, 275, 300, 40);
        cmbComuneInizio.setFont(new Font("SansSerif", Font.PLAIN, 18));
        cmbComuneFine.setBounds(300, 335, 300, 40);
        cmbComuneFine.setFont(new Font("SansSerif", Font.PLAIN, 18));

        finestra.setLayout(null);
        finestra.add(lblTitolo);
        finestra.add(lblFacile);
        finestra.add(lblCustom);
        finestra.add(lblComuneInizio);
        finestra.add(lblComuneFine);
        finestra.add(lblRemove);
        finestra.add(btnFacile);
        finestra.add(btnInizioFine);
        finestra.add(btnSenzaVerona);
        finestra.add(btnOkay);
        finestra.add(cmbComuneInizio);
        finestra.add(cmbComuneFine);
        finestra.add(lblDifficile);
        finestra.add(btnDifficile);

        cmbComuneFine.setEnabled(false);
        cmbComuneInizio.setEnabled(false);

        //lblTitolo.setBounds();
        finestra.setSize(1100, 650);
        finestra.setLocationRelativeTo(null);
        finestra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        finestra.setVisible(true);

        /*
        GroupLayout groupLayout = new GroupLayout(finestra.getContentPane());
        groupLayout.setAutoCreateGaps(true);

        groupLayout.setHorizontalGroup(groupLayout.createSequentialGroup().addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(lblRemove)
                        .addComponent(lblFacile)
                        .addComponent(lblCustom)
                        .addComponent(lblInizio)
                        .addComponent(lblFine))
                .addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(btnRemove)
                        .addComponent(btnFacile)
                        .addComponent(btnCustom)
                ));


        finestra.setLayout(groupLayout);

        finestra.setSize(400, 200);
        finestra.setLocationRelativeTo(null);
        finestra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        finestra.setVisible(true);
        */

    }

    public String nomeFacile (boolean chosenFacile) {
        String stringChosenFacile;
        return stringChosenFacile = chosenFacile ? "Attivato": "Disattivato";
    }

    public String nomeCustom (boolean chosenCustom) {
        String stringChosenCustom;
        return stringChosenCustom = chosenCustom ? "Attivato" : "Disattivato";
    }

    public String nomeRemove (boolean chosenRemove) {
        String stringChosenRemove;
        return stringChosenRemove = chosenRemove ? "Attivato" : "Disattivato";
    }

    public String nomeDiffficile (boolean chosenDifficile) {
        String stringChosenDifficile;
        return stringChosenDifficile = chosenDifficile ? "Attivato" : "Disattivato";
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

    public JToggleButton getBtnFacile() {
        return btnFacile;
    }

    public void setBtnFacile(JToggleButton btnFacile) {
        this.btnFacile = btnFacile;
    }

    public JLabel getLblTitolo() {
        return lblTitolo;
    }

    public void setLblTitolo(JLabel lblTitolo) {
        this.lblTitolo = lblTitolo;
    }

    public JLabel getLblComuneInizio() {
        return lblComuneInizio;
    }

    public void setLblComuneInizio(JLabel lblComuneInizio) {
        this.lblComuneInizio = lblComuneInizio;
    }

    public JLabel getLblComuneFine() {
        return lblComuneFine;
    }

    public void setLblComuneFine(JLabel lblComuneFine) {
        this.lblComuneFine = lblComuneFine;
    }

    public JToggleButton getBtnInizioFine() {
        return btnInizioFine;
    }

    public void setBtnInizioFine(JToggleButton btnInizioFine) {
        this.btnInizioFine = btnInizioFine;
    }

    public JToggleButton getBtnSenzaVerona() {
        return btnSenzaVerona;
    }

    public void setBtnSenzaVerona(JToggleButton btnSenzaVerona) {
        this.btnSenzaVerona = btnSenzaVerona;
    }

    public JComboBox getCmbComuneInizio() {
        return cmbComuneInizio;
    }

    public void setCmbComuneInizio(JComboBox cmbComuneInizio) {
        this.cmbComuneInizio = cmbComuneInizio;
    }

    public JComboBox getCmbComuneFine() {
        return cmbComuneFine;
    }

    public void setCmbComuneFine(JComboBox cmbComuneFine) {
        this.cmbComuneFine = cmbComuneFine;
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

    public JToggleButton getBtnDifficile() {
        return btnDifficile;
    }

    public void setBtnDifficile(JToggleButton btnDifficile) {
        this.btnDifficile = btnDifficile;
    }

    public boolean isChosenDifficile() {
        return chosenDifficile;
    }

    public void setChosenDifficile(boolean chosenDifficile) {
        this.chosenDifficile = chosenDifficile;
    }

    public JLabel getLblDifficile() {
        return lblDifficile;
    }

    public void setLblDifficile(JLabel lblDifficile) {
        this.lblDifficile = lblDifficile;
    }

    public JToggleButton getBtns (String identificativo) {
        if (identificativo.equalsIgnoreCase("SenzaVerona"))
            return btnSenzaVerona;
        else if (identificativo.equalsIgnoreCase("Facile"))
            return btnFacile;
        else if (identificativo.equalsIgnoreCase("InizioFine"))
            return btnInizioFine;
        else if (identificativo.equalsIgnoreCase("Difficile"))
            return btnDifficile;

        return null;
    }

    public boolean getBooleans (JToggleButton jToggleButton) {
        if (jToggleButton.equals(btnSenzaVerona))
            return chosenRemove;
        else if (jToggleButton.equals(btnFacile))
            return chosenFacile;
        else if (jToggleButton.equals(btnInizioFine))
            return chosenCustom;
        else if (jToggleButton.equals(btnDifficile))
            return chosenDifficile;

        return false;
    }

    public String getStrings (JToggleButton jToggleButton, boolean state) {
        if (jToggleButton.equals(btnSenzaVerona))
            return nomeRemove(state);
        else if (jToggleButton.equals(btnFacile))
            return nomeFacile(state);
        else if (jToggleButton.equals(btnInizioFine))
            return nomeCustom(state);
        else if (jToggleButton.equals(btnDifficile))
            return nomeDiffficile(state);


        return null;
    }

    public void setBooleans (JToggleButton jToggleButton, boolean state) {
        if (jToggleButton.equals(btnSenzaVerona))
            chosenRemove = state;
        else if (jToggleButton.equals(btnFacile))
            chosenFacile = state;
        else if (jToggleButton.equals(btnInizioFine))
            chosenCustom = state;
        else if (jToggleButton.equals(btnDifficile))
            chosenDifficile = state;
    }
}
