import javax.swing.*;
import java.awt.*;

public class PrimaView {
    private JFrame finestra;
    private JLabel lblTitolo;
    private JLabel lblFacile;
    private JLabel lblInizioFine;
    private JLabel lblComuneInizio;
    private JLabel lblComuneFine;
    private JLabel lblSenzaVerona;
    private JLabel lblDifficile;
    private JLabel lblTentativi;
    private JToggleButton btnFacile;
    private JToggleButton btnInizioFine;
    private JToggleButton btnSenzaVerona;
    private JToggleButton btnDifficile;
    private JButton btnOkay;
    private JComboBox cmbComuneInizio;
    private JComboBox cmbComuneFine;
    private JComboBox cmbTentativi;
    private boolean inizioFine = false;
    private boolean facile = false;
    private boolean senzaVerona = false;
    private boolean difficile = false;

    public PrimaView(Provincia provincia) {
        finestra = new JFrame();
        lblTitolo = new JLabel("Trevol Verona");
        lblFacile = new JLabel("Clicca il pulsante per la modalità facile");
        lblInizioFine = new JLabel("Clicca il pulsante per scegliere i comuni di inizio e di fine");
        lblComuneInizio = new JLabel("Comune di inizio:");
        lblComuneFine = new JLabel("Comune di fine:");
        lblSenzaVerona = new JLabel("Clicca il pulsante per giocare senza Verona");
        lblDifficile = new JLabel("Clicca il pulsante per la modalità difficile");
        lblTentativi = new JLabel("Tentativi extra?");
        btnDifficile = new JToggleButton(nomeDiffficile(difficile));
        btnFacile = new JToggleButton(nomeFacile(facile));
        btnInizioFine = new JToggleButton(nomeInizioFine(inizioFine));
        btnSenzaVerona = new JToggleButton(nomeSenzaVerona(senzaVerona));
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
        String[] ipotesi = new String[3];
        ipotesi[0] = "Tentativi Predefiniti";
        ipotesi[1] = "Solo il percorso più breve";
        ipotesi[2] = "Tentativi illimitati";
        cmbTentativi = new JComboBox(ipotesi);

        //setBounds()
        lblTitolo.setBounds(440, 20, 300, 50);
        lblTitolo.setForeground(Color.BLACK);
        lblTitolo.setFont(new Font("Impact", Font.PLAIN, 40));

        lblFacile.setBounds(20, 100, 700, 30);
        lblFacile.setFont(Costanti.FONT_LBL_PRIMAVIEW);
        btnFacile.setBounds(950, 95, 100, 40);
        btnFacile.setFont(Costanti.FONT_BTN_PRIMAVIEW);

        lblInizioFine.setBounds(20, 160, 700, 30);
        lblInizioFine.setFont(Costanti.FONT_LBL_PRIMAVIEW);
        btnInizioFine.setBounds(950, 155, 100, 40);
        btnInizioFine.setFont(Costanti.FONT_BTN_PRIMAVIEW);

        lblComuneInizio.setBounds(20, 220, 300, 30);
        lblComuneInizio.setFont(Costanti.FONT_LBL_PRIMAVIEW);
        cmbComuneInizio.setBounds(300, 215, 300, 40);
        cmbComuneInizio.setFont(Costanti.FONT_BTN_PRIMAVIEW);

        lblComuneFine.setBounds(20, 280, 300, 30);
        lblComuneFine.setFont(Costanti.FONT_LBL_PRIMAVIEW);
        cmbComuneFine.setBounds(300, 275, 300, 40);
        cmbComuneFine.setFont(Costanti.FONT_BTN_PRIMAVIEW);

        lblSenzaVerona.setBounds(20, 340, 700, 30);
        lblSenzaVerona.setFont(Costanti.FONT_LBL_PRIMAVIEW);
        btnSenzaVerona.setBounds(950, 335, 100, 40);
        btnSenzaVerona.setFont(Costanti.FONT_BTN_PRIMAVIEW);

        lblDifficile.setBounds(20, 400, 700, 30);
        lblDifficile.setFont(Costanti.FONT_LBL_PRIMAVIEW);
        btnDifficile.setBounds(950, 395, 100, 40);
        btnDifficile.setFont(Costanti.FONT_BTN_PRIMAVIEW);

        lblTentativi.setBounds(20, 460, 700, 30);
        lblTentativi.setFont(Costanti.FONT_LBL_PRIMAVIEW);
        cmbTentativi.setBounds(750, 455, 300, 40);
        cmbTentativi.setFont(Costanti.FONT_BTN_PRIMAVIEW);

        btnOkay.setBounds(500, 520, 100, 40);
        btnOkay.setFont(new Font("SansSerif", Font.PLAIN, 24));

        finestra.setLayout(null);

        finestra.add(lblTitolo);
        finestra.add(lblFacile);
        finestra.add(lblInizioFine);
        finestra.add(lblComuneInizio);
        finestra.add(lblComuneFine);
        finestra.add(lblSenzaVerona);
        finestra.add(btnFacile);
        finestra.add(btnInizioFine);
        finestra.add(btnSenzaVerona);
        finestra.add(btnOkay);
        finestra.add(cmbComuneInizio);
        finestra.add(cmbComuneFine);
        finestra.add(lblDifficile);
        finestra.add(btnDifficile);
        finestra.add(cmbTentativi);
        finestra.add(lblTentativi);

        cmbComuneFine.setEnabled(false);
        cmbComuneInizio.setEnabled(false);

        //lblTitolo.setBounds();
        finestra.setSize(1100, 620);
        finestra.setLocationRelativeTo(null);
        finestra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        finestra.setIconImage(Costanti.ICONA.getImage());
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

    public String nomeFacile (boolean facile) {
        return facile ? Costanti.BOTTONE_ATTIVO: Costanti.BOTTONE_NON_ATTIVO;
    }

    public String nomeInizioFine(boolean inizioFine) {
        return inizioFine ? Costanti.BOTTONE_ATTIVO : Costanti.BOTTONE_NON_ATTIVO;
    }

    public String nomeSenzaVerona(boolean senzaVerona) {
        return senzaVerona ? Costanti.BOTTONE_ATTIVO: Costanti.BOTTONE_NON_ATTIVO;
    }

    public String nomeDiffficile (boolean difficile) {
        return difficile ? Costanti.BOTTONE_ATTIVO : Costanti.BOTTONE_NON_ATTIVO;
    }

    public JFrame getFinestra() {
        return finestra;
    }

    public JButton getBtnOkay() {
        return btnOkay;
    }

    public JComboBox getCmbComuneInizio() {
        return cmbComuneInizio;
    }

    public JComboBox getCmbComuneFine() {
        return cmbComuneFine;
    }

    public JComboBox getCmbTentativi() {
        return cmbTentativi;
    }

    public JToggleButton getBtns (String identificativo) {
        if (identificativo.equalsIgnoreCase(Costanti.ID_SENZA_VERONA))
            return btnSenzaVerona;
        else if (identificativo.equalsIgnoreCase(Costanti.ID_FACILE))
            return btnFacile;
        else if (identificativo.equalsIgnoreCase(Costanti.ID_INIZIO_FINE))
            return btnInizioFine;
        else if (identificativo.equalsIgnoreCase(Costanti.ID_DIFFICILE))
            return btnDifficile;

        return null;
    }

    public boolean getBooleans (JToggleButton jToggleButton) {
        if (jToggleButton.equals(btnSenzaVerona))
            return senzaVerona;
        else if (jToggleButton.equals(btnFacile))
            return facile;
        else if (jToggleButton.equals(btnInizioFine))
            return inizioFine;
        else if (jToggleButton.equals(btnDifficile))
            return difficile;

        return false;
    }

    public String getStrings (JToggleButton jToggleButton, boolean state) {
        if (jToggleButton.equals(btnSenzaVerona))
            return nomeSenzaVerona(state);
        else if (jToggleButton.equals(btnFacile))
            return nomeFacile(state);
        else if (jToggleButton.equals(btnInizioFine))
            return nomeInizioFine(state);
        else if (jToggleButton.equals(btnDifficile))
            return nomeDiffficile(state);


        return null;
    }

    public void setBooleans (JToggleButton jToggleButton, boolean state) {
        if (jToggleButton.equals(btnSenzaVerona))
            senzaVerona = state;
        else if (jToggleButton.equals(btnFacile))
            facile = state;
        else if (jToggleButton.equals(btnInizioFine))
            inizioFine = state;
        else if (jToggleButton.equals(btnDifficile))
            difficile = state;
    }
}