import javax.swing.*;
import java.awt.*;

public class PrimaView {
    private JFrame finestra;
    private JLabel lblTitolo;
    private JLabel lblModalita;
    private JLabel lblInizioFine;
    private JToggleButton btnFacile;
    private JToggleButton btnInizioFine;
    private JToggleButton btnSenzaVerona;
    private JToggleButton btnDifficile;
    private JButton btnGioca;
    private JLabel lblSalvataggi;
    private JButton btnTutorial;
    private JComboBox cmbComuneInizio;
    private JComboBox cmbComuneFine;
    private JComboBox cmbTentativi;
    private boolean inizioFine = false;
    private boolean facile = false;
    private boolean senzaVerona = false;
    private boolean difficile = false;
    private JPanel pannelloModalita;
    private JPanel pannelloInizioFine;
    private JScrollPane pannelloSalvataggi;
    private JLabel lblComuneInizio;
    private JLabel lblNumeroMinimoTentativi;
    private JLabel lblNumeroTentativiUtente;
    private JPanel pnlPartitaSingola;
    private JLabel lblVittoria;
    private JButton btnUsa;
    private Provincia provincia;
    private JPanel pnlTotal;
    private JButton btnClear;
    private JButton btnCancellaStorico;

    public PrimaView(Provincia provincia) {
        this.provincia = provincia;
//            UIManager.put("ToggleButton.select", Color.yellow  );
        finestra = new JFrame();
        lblTitolo = new JLabel("Trevol Verona");
        lblModalita = new JLabel("Modalità");
        lblInizioFine = new JLabel("Scelta Comuni di Inizio e Fine");
        btnDifficile = new JToggleButton("Difficile");
        btnFacile = new JToggleButton("Facile");
        btnInizioFine = new JToggleButton("Inizio Fine");
        btnSenzaVerona = new JToggleButton("Senza Verona");
        btnGioca = new JButton("Gioca!");
        lblSalvataggi = new JLabel("Salvataggi");
        btnTutorial = new JButton("Come si gioca?");
        JToggleButton prova[] = new JToggleButton[5];
        pnlTotal = new JPanel();
        pnlTotal.setLayout(new BoxLayout(pnlTotal, BoxLayout.Y_AXIS));
        pannelloSalvataggi = new JScrollPane(pnlTotal);
        btnClear = new JButton("Clear");
        btnCancellaStorico = new JButton("Cancella Storico");


        // Update the layout manager of pannelloModalita to GridBagLayout
        pannelloModalita = new JPanel(new GridBagLayout());
        pannelloModalita.setBounds(15, 100, 800, 300);
//            pannelloModalita.setBackground(Color.gray);

        JScrollPane scrollPaneModalita = new JScrollPane(pannelloModalita);
        scrollPaneModalita.setBounds(15, 125, 400, 260);
        scrollPaneModalita.getVerticalScrollBar().setPreferredSize(new Dimension(0,0));
        scrollPaneModalita.setBorder(pannelloSalvataggi.getBorder());

        lblModalita.setBounds(15, 100, 400, 20);

        lblModalita.setFont(new Font("Dialog", Font.BOLD, 17));


        // Initialize GridBagConstraints
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.gridx = 0;
        gbc.gridy = GridBagConstraints.RELATIVE;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;


//            pannelloInizioFine = new JPanel();
//            pannelloInizioFine.setBounds(670, 100, 400, 300);
//            pannelloInizioFine.setBackground(Color.yellow);
//            pannelloInizioFine.setLayout(null);

        String[] comuniFine = new String[provincia.getComuni().size() + 1];
        comuniFine[0] = "Seleziona il comune di fine";
        for (int i = 0; i < comuniFine.length - 1; i++) {
            comuniFine[i + 1] = provincia.getComuni().get(i).getNome();
        }
        cmbComuneFine = new JComboBox(comuniFine);
        String[] comuniInizio = new String[provincia.getComuni().size() + 1];
        comuniInizio[0] = "Seleziona il comune di inizio";
        for (int i = 0; i < comuniInizio.length - 1; i++) {
            comuniInizio[i + 1] = provincia.getComuni().get(i).getNome();
        }
        cmbComuneInizio = new JComboBox(comuniInizio);
        String[] ipotesi = new String[3];
        ipotesi[0] = "Tentativi Predefiniti";
        ipotesi[1] = "Solo il percorso più breve";
        ipotesi[2] = "Tentativi illimitati";
        cmbTentativi = new JComboBox(ipotesi);


        // setBounds()
        lblTitolo.setBounds(440, 25, 300, 50);
        lblTitolo.setForeground(Color.BLACK);
        lblModalita.setForeground(Color.BLACK);
        lblInizioFine.setForeground(Color.BLACK);
        lblTitolo.setFont(new Font("Impact", Font.PLAIN, 40));

//            lblModalita.setFont(new Font("Impact", Font.PLAIN, 30));

        lblInizioFine.setFont(new Font("Dialog", Font.BOLD, 17));

        //lblModalita.setBounds(0, 0, 400, 40);
        lblModalita.setHorizontalAlignment(SwingConstants.LEADING);

        lblInizioFine.setBounds(720, 100, 350, 20);
//            lblInizioFine.setHorizontalAlignment(SwingConstants.CENTER);

            /*
            btnFacile.setPreferredSize(new Dimension(370,40));
            btnFacile.setFont(Costanti.FONT_BTN_PRIMAVIEW);
            btnFacile.setBorderPainted(false);
            btnFacile.setFocusPainted(false);
//            btnFacile.setBackground(Color.red);

            btnInizioFine.setPreferredSize(new Dimension(370,40));
            btnInizioFine.setFont(Costanti.FONT_BTN_PRIMAVIEW);
            btnInizioFine.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
//            btnInizioFine.setBorderPainted(false);
            btnInizioFine.setFocusPainted(false);
//            btnInizioFine.setBackground(Color.red);
*/
        cmbComuneInizio.setBounds(720, 125, 350, 35);
        cmbComuneInizio.setFont(Costanti.FONT_BTN_PRIMAVIEW);

        cmbComuneFine.setBounds(720, 170, 350, 35);
        cmbComuneFine.setFont(Costanti.FONT_BTN_PRIMAVIEW);
/*
            btnSenzaVerona.setPreferredSize(new Dimension(370,40));
            btnSenzaVerona.setFont(Costanti.FONT_BTN_PRIMAVIEW);
            btnSenzaVerona.setBorderPainted(false);
            btnSenzaVerona.setFocusPainted(false);
//            btnSenzaVerona.setBackground(Color.red);

            btnDifficile.setPreferredSize(new Dimension(370,40));
            btnDifficile.setFont(Costanti.FONT_BTN_PRIMAVIEW);
            btnDifficile.setBorderPainted(false);
            btnDifficile.setFocusPainted(false);
//            btnDifficile.setBackground(Color.red);
*/
        cmbTentativi.setPreferredSize(new Dimension(370,40));
        cmbTentativi.setFont(Costanti.FONT_BTN_PRIMAVIEW);


        btnGioca.setBounds(15, 530, 200, 40);
        btnGioca.setFont(new Font("Dialog", Font.BOLD, 24));

        lblSalvataggi.setFont(new Font("Dialog", Font.BOLD, 17));
        lblSalvataggi.setBounds(15, 405, 400, 20);

        btnCancellaStorico.setFont(new Font("Dialog", Font.BOLD, 17));
        btnCancellaStorico.setBounds(890, 395, 180, 30);
//            lblSalvataggi.setFont(new Font("Dialog", Font.BOLD, 12));

        pannelloSalvataggi.setBounds(15, 430, 1055, 80);

        pannelloSalvataggi.getVerticalScrollBar().setPreferredSize(new Dimension(0,0));

        btnTutorial.setBounds(870, 530, 200, 40);
        btnTutorial.setFont(new Font("Dialog", Font.BOLD, 17));

        btnClear.setFont(new Font("Dialog", Font.BOLD, 17));
        btnClear.setBounds(890, 355, 180, 30);


        finestra.setLayout(null);


            /*
            JPanel pnlPersonalizzazioni = new JPanel();

            pnlPersonalizzazioni.setLayout(new GridLayout(1, 2));
            pnlPersonalizzazioni.add(pannelloModalita);
            pnlPersonalizzazioni.add(pannelloInizioFine);

            JPanel pnlCentrale = new JPanel();

            pnlCentrale.setLayout(new GridLayout(2, 1));

            pnlCentrale.add(pnlPersonalizzazioni);
            pnlCentrale.add(pannelloSalvataggi);


            JPanel pnlPulsanti = new JPanel();

            pnlPulsanti.add(btnGioca);
            pnlPulsanti.add(btnTutorial);


            JPanel pnlSuperiore = new JPanel();

            pnlSuperiore.add(lblTitolo);
            pnlSuperiore.add(btnClear);


             */
//            pannelloModalita.add(lblModalita, gbc);

        initBottone(btnFacile, 370, 40);
        initBottone(btnDifficile, 370, 40);
        initBottone(btnInizioFine, 370, 40);
        initBottone(btnSenzaVerona, 370, 40);

        pannelloModalita.add(btnFacile, gbc);
        pannelloModalita.add(btnInizioFine, gbc);
        pannelloModalita.add(btnSenzaVerona, gbc);
        pannelloModalita.add(btnDifficile, gbc);
//            for (int i = 0; i<5; i++){
//                prova[i] = new JToggleButton("Prova numero : " + i);
//                prova[i].setFont(Costanti.FONT_BTN_PRIMAVIEW);
//                prova[i].setPreferredSize(new Dimension(370,40));
//                prova[i].setBorderPainted(false);
//                prova[i].setFocusPainted(false);
//                prova[i].setBackground(Color.red);
//                pannelloModalita.add(prova[i], gbc);
//            }
        pannelloModalita.add(cmbTentativi, gbc);


        // Ensure the remaining components are added to the main frame as before
//            pannelloInizioFine.add(lblInizioFine);
//            pannelloInizioFine.add(cmbComuneInizio);
//            pannelloInizioFine.add(cmbComuneFine);

        finestra.add(lblTitolo);
        finestra.add(btnGioca);
        finestra.add(lblSalvataggi);
        finestra.add(btnTutorial);
        finestra.add(scrollPaneModalita);
//            finestra.add(pannelloInizioFine);
        finestra.add(pannelloSalvataggi);
        finestra.add(btnClear);
        finestra.add(lblModalita);
        finestra.add(btnCancellaStorico);
        finestra.add(lblInizioFine);
        finestra.add(cmbComuneFine);
        finestra.add(cmbComuneInizio);




//            finestra.add(pnlSuperiore, BorderLayout.NORTH);
//            finestra.add(pnlCentrale, BorderLayout.CENTER);
//            finestra.add(pnlPulsanti, BorderLayout.SOUTH);





        cmbComuneFine.setEnabled(false);
        cmbComuneInizio.setEnabled(false);

        // lblTitolo.setBounds();
        finestra.setSize(1100, 620);
        finestra.setLocationRelativeTo(null);
        finestra.setResizable(false);
        finestra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        finestra.setIconImage(Costanti.ICONA.getImage());
        finestra.setVisible(true);
    }

    void initBottone (JToggleButton jToggleButton, int width, int height) {
        jToggleButton.setPreferredSize(new Dimension(width, height));
        jToggleButton.setFont(Costanti.FONT_BTN_PRIMAVIEW);
        jToggleButton.setFocusPainted(false);
        jToggleButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
    }

    JPanel creaPartita (int n, ListaPartite listaPartite) {
        lblComuneInizio = new JLabel(listaPartite.listaPartiteGiocate.get(n).getInizio().getNome());
        JLabel lblComuneFine = new JLabel(listaPartite.listaPartiteGiocate.get(n).getFine().getNome());
        lblNumeroMinimoTentativi = new JLabel(listaPartite.listaPartiteGiocate.get(n).getNumeroMinimoTentativi()+"");
        lblNumeroTentativiUtente = new JLabel(listaPartite.listaPartiteGiocate.get(n).getNumeroTentativiUtente()+"");
        lblVittoria = new JLabel(listaPartite.listaPartiteGiocate.get(n).isVittoria()+"");
        pnlPartitaSingola = new JPanel();
        btnUsa = new JButton("Invia");

        pnlPartitaSingola.add(lblComuneInizio);
        pnlPartitaSingola.add(lblComuneFine);
        pnlPartitaSingola.add(lblNumeroTentativiUtente);
        pnlPartitaSingola.add(lblNumeroMinimoTentativi);
        pnlPartitaSingola.add(lblVittoria);
        pnlPartitaSingola.add(btnUsa);


        return pnlPartitaSingola;
    }

    public void popolaPannello (ListaPartite listaPartite) {
        pnlTotal.removeAll();
        pnlTotal.add(pannelloIntestazione());
        if (!listaPartite.listaPartiteGiocate.isEmpty()) {
            for (int i = 0; i < listaPartite.listaPartiteGiocate.size(); i++) {
                pnlTotal.add(partitaSingola(listaPartite, i));
            }
        }
        pnlTotal.revalidate();
        pnlTotal.repaint();
    }

    JPanel pannelloIntestazione () {
        JPanel pannelloIntestazione = new JPanel(new GridLayout(1, 6));

        pannelloIntestazione.setBackground(Color.GREEN);
        pannelloIntestazione.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

        pannelloIntestazione.add(new JLabel("Comune di inizio"));
        pannelloIntestazione.add(new JLabel("Comune di fine"));
        pannelloIntestazione.add(new JLabel("Tentativi utente"));
        pannelloIntestazione.add(new JLabel("Tentativi minimi"));
        //        pannelloIntestazione.add(new JLabel("Scelta tentativi"));
        pannelloIntestazione.add(new JLabel("Vittoria/Sconfitta"));
        pannelloIntestazione.add(new JLabel());
        pannelloIntestazione.add(new JLabel());

        pannelloIntestazione.setPreferredSize(new Dimension(pannelloIntestazione.getWidth(), 26));

        return pannelloIntestazione;
    }

    public JPanel partitaSingola(ListaPartite listaPartite, int n) {
        JPanel pnlPartitaSingola = new JPanel(new GridLayout(1,6));

        pnlPartitaSingola.add(new JLabel(listaPartite.listaPartiteGiocate.get(n).getInizio().getNome()));
        pnlPartitaSingola.add(new JLabel(listaPartite.listaPartiteGiocate.get(n).getFine().getNome()));
        pnlPartitaSingola.add(new JLabel(listaPartite.listaPartiteGiocate.get(n).getNumeroMinimoTentativi()+""));
        pnlPartitaSingola.add(new JLabel(listaPartite.listaPartiteGiocate.get(n).getNumeroTentativiUtente()+""));
        if (listaPartite.listaPartiteGiocate.get(n).isVittoria()) pnlPartitaSingola.add(new JLabel("Vittoria"));
        else pnlPartitaSingola.add(new JLabel("Sconfitta"));
        pnlPartitaSingola.add(new JButton("Modalità"));
        pnlPartitaSingola.add(new JButton("Gioca"));

        pnlPartitaSingola.getComponent(0).setPreferredSize(new Dimension(150, pnlPartitaSingola.getHeight()));
        pnlPartitaSingola.getComponent(1).setPreferredSize(new Dimension(150, pnlPartitaSingola.getHeight()));

        return pnlPartitaSingola;
    }

    public Color coloreFacile (boolean facile) {
        return facile ? Color.GREEN : Color.RED;
    }

    public Color coloreSenzaVerona (boolean senzaVerona) {
        return senzaVerona ? Color.GREEN : Color.RED;
    }

    public Color coloreInizioFine (boolean inizioFine) {
        return inizioFine ? Color.GREEN : Color.RED;
    }

    public Color coloreDifficile (boolean difficile) {
        return difficile ? Color.GREEN : Color.RED;
    }

    public String nomeFacile(boolean facile) {
        return facile ? "\u2713 Facile \u2713" : "Facile";
    }

    public String nomeInizioFine(boolean inizioFine) {
        return inizioFine ? "\u2713 Custom \u2713" : "Custom";
    }

    public String nomeSenzaVerona(boolean senzaVerona) {
        return senzaVerona ? "\u2713 Senza Verona \u2713" : "Senza Verona";
    }

    public String nomeDifficile(boolean difficile) {
        return difficile ? "\u2713 Difficile \u2713" : "Difficile";
    }

    public JFrame getFinestra() {
        return finestra;
    }

    public JButton getBtnGioca() {
        return btnGioca;
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

    public JToggleButton getBtns(String identificativo) {
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

    public boolean getBooleans(JToggleButton jToggleButton) {
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
            return nomeDifficile(state);


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

    public String getNomi (JToggleButton jToggleButton, boolean state) {
        if (jToggleButton.equals(btnFacile)) {
            return nomeFacile(state);
        } else if (jToggleButton.equals(btnDifficile)) {
            return nomeDifficile(state);
        } else if (jToggleButton.equals(btnInizioFine)) {
            return nomeInizioFine(state);
        } else if (jToggleButton.equals(btnSenzaVerona)) {
            return nomeSenzaVerona(state);
        }

        return null;
    }

    public Color getColors (JToggleButton jToggleButton, boolean state) {
        if (jToggleButton.equals(btnFacile))
            return coloreFacile(state);
        else if (jToggleButton.equals(btnSenzaVerona))
            return coloreSenzaVerona(state);
        else if (jToggleButton.equals(btnDifficile))
            return coloreDifficile(state);
        else if (jToggleButton.equals(btnInizioFine))
            return coloreInizioFine(state);

        return null;
    }

    public void setFinestra(JFrame finestra) {
        this.finestra = finestra;
    }

    public JLabel getLblTitolo() {
        return lblTitolo;
    }

    public void setLblTitolo(JLabel lblTitolo) {
        this.lblTitolo = lblTitolo;
    }

    public JLabel getLblModalita() {
        return lblModalita;
    }

    public void setLblModalita(JLabel lblModalita) {
        this.lblModalita = lblModalita;
    }

    public JLabel getLblInizioFine() {
        return lblInizioFine;
    }

    public void setLblInizioFine(JLabel lblInizioFine) {
        this.lblInizioFine = lblInizioFine;
    }

    public JToggleButton getBtnFacile() {
        return btnFacile;
    }

    public void setBtnFacile(JToggleButton btnFacile) {
        this.btnFacile = btnFacile;
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

    public JToggleButton getBtnDifficile() {
        return btnDifficile;
    }

    public void setBtnDifficile(JToggleButton btnDifficile) {
        this.btnDifficile = btnDifficile;
    }

    public void setBtnGioca(JButton btnGioca) {
        this.btnGioca = btnGioca;
    }

    public JLabel getLblSalvataggi() {
        return lblSalvataggi;
    }

    public void setLblSalvataggi(JLabel lblSalvataggi) {
        this.lblSalvataggi = lblSalvataggi;
    }

    public JButton getBtnTutorial() {
        return btnTutorial;
    }

    public void setBtnTutorial(JButton btnTutorial) {
        this.btnTutorial = btnTutorial;
    }

    public void setCmbComuneInizio(JComboBox cmbComuneInizio) {
        this.cmbComuneInizio = cmbComuneInizio;
    }

    public void setCmbComuneFine(JComboBox cmbComuneFine) {
        this.cmbComuneFine = cmbComuneFine;
    }

    public void setCmbTentativi(JComboBox cmbTentativi) {
        this.cmbTentativi = cmbTentativi;
    }

    public boolean isInizioFine() {
        return inizioFine;
    }

    public void setInizioFine(boolean inizioFine) {
        this.inizioFine = inizioFine;
    }

    public boolean isFacile() {
        return facile;
    }

    public void setFacile(boolean facile) {
        this.facile = facile;
    }

    public boolean isSenzaVerona() {
        return senzaVerona;
    }

    public void setSenzaVerona(boolean senzaVerona) {
        this.senzaVerona = senzaVerona;
    }

    public boolean isDifficile() {
        return difficile;
    }

    public void setDifficile(boolean difficile) {
        this.difficile = difficile;
    }

    public JPanel getPannelloModalita() {
        return pannelloModalita;
    }

    public void setPannelloModalita(JPanel pannelloModalita) {
        this.pannelloModalita = pannelloModalita;
    }

    public JPanel getPannelloInizioFine() {
        return pannelloInizioFine;
    }

    public void setPannelloInizioFine(JPanel pannelloInizioFine) {
        this.pannelloInizioFine = pannelloInizioFine;
    }

    public JScrollPane getPannelloSalvataggi() {
        return pannelloSalvataggi;
    }

    public void setPannelloSalvataggi(JScrollPane pannelloSalvataggi) {
        this.pannelloSalvataggi = pannelloSalvataggi;
    }

    public JLabel getLblComuneInizio() {
        return lblComuneInizio;
    }

    public void setLblComuneInizio(JLabel lblComuneInizio) {
        this.lblComuneInizio = lblComuneInizio;
    }

    public JLabel getLblNumeroMinimoTentativi() {
        return lblNumeroMinimoTentativi;
    }

    public void setLblNumeroMinimoTentativi(JLabel lblNumeroMinimoTentativi) {
        this.lblNumeroMinimoTentativi = lblNumeroMinimoTentativi;
    }

    public JLabel getLblNumeroTentativiUtente() {
        return lblNumeroTentativiUtente;
    }

    public void setLblNumeroTentativiUtente(JLabel lblNumeroTentativiUtente) {
        this.lblNumeroTentativiUtente = lblNumeroTentativiUtente;
    }

    public JPanel getPnlPartitaSingola() {
        return pnlPartitaSingola;
    }

    public void setPnlPartitaSingola(JPanel pnlPartitaSingola) {
        this.pnlPartitaSingola = pnlPartitaSingola;
    }

    public JLabel getLblVittoria() {
        return lblVittoria;
    }

    public void setLblVittoria(JLabel lblVittoria) {
        this.lblVittoria = lblVittoria;
    }

    public JButton getBtnUsa() {
        return btnUsa;
    }

    public void setBtnUsa(JButton btnUsa) {
        this.btnUsa = btnUsa;
    }

    public Provincia getProvincia() {
        return provincia;
    }

    public void setProvincia(Provincia provincia) {
        this.provincia = provincia;
    }

    public JPanel getPnlTotal() {
        return pnlTotal;
    }

    public void setPnlTotal(JPanel pnlTotal) {
        this.pnlTotal = pnlTotal;
    }

    public JButton getBtnClear() {
        return btnClear;
    }

    public void setBtnClear(JButton btnClear) {
        this.btnClear = btnClear;
    }

    public JButton getBtnCancellaStorico() {
        return btnCancellaStorico;
    }

    public void setBtnCancellaStorico(JButton btnCancellaStorico) {
        this.btnCancellaStorico = btnCancellaStorico;
    }
}