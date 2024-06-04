import javax.swing.*;
import java.awt.*;
import org.apache.batik.swing.JSVGCanvas;

public class View extends JFrame {
    private JFrame finestra;
    private JPanel pannelloInput, pannelloMappa, pannelloNomi, pannelloElencoComuni, pannelloTentativi;
    private JButton pulsanteInvia;
    private JTextField inserisciComuni;
    private String comuneInserito;
    private JLabel etichetta, mappaTesto, lblMaxGuess, source, destination;
    private ImageIcon icona = new ImageIcon(".\\src\\main\\java\\img\\VeronaStemma.png");
    private int guess, preGuess;
    public JLabel[] inserimenti;
    private JSVGCanvas canvas;
    private Comune comuneS, comuneD;

    int min;

    public View(String titolo) {
        super();
        pannelloMappa = new JPanel();
        pannelloInput = new JPanel();
        pannelloNomi = new JPanel();
        pannelloTentativi = new JPanel();
        etichetta = new JLabel("Inserisci Comuni: ");
        inserisciComuni = new JTextField("", 30);
        pulsanteInvia = new JButton("Invia");
        comuneInserito = "";
        source = new JLabel();
        source.setForeground(new Color(163, 73, 164));
        destination = new JLabel();
        destination.setForeground(new Color(255, 242, 0));
        canvas = new JSVGCanvas();
        lblMaxGuess = new JLabel();

/*
        if (min <= 3)
            guess = min + 4;
        else if (min <= 6)
            guess = min + 5;
        else if (min <= 9)
            guess = min + 6;
        else if (min <= 12)
            guess = min + 7;
        else
            guess = min + 8;


 */


//        lblMaxGuess = new JLabel("Tentativi massimi: " + guess);
//        lblMaxGuess.setFont(new Font("Arial", Font.BOLD, 18));

        pannelloInput.setBackground(new Color(0, 0, 0, 0));
        pannelloInput.add(etichetta);
        pannelloInput.add(inserisciComuni);
        pannelloInput.add(pulsanteInvia);


        pannelloElencoComuni = new JPanel();
        pannelloElencoComuni.setLayout(new BoxLayout(pannelloElencoComuni, BoxLayout.Y_AXIS));

//        pannelloElencoComuni.add(inserimenti[0]); // Aggiunge Source
//        pannelloElencoComuni.add(inserimenti[inserimenti.length-1]); //Aggiunge Destination


        pannelloNomi.setLayout(new BorderLayout());
        pannelloNomi.add(new JScrollPane(pannelloElencoComuni), BorderLayout.CENTER);

        pannelloNomi.setBackground(new Color(255, 0, 0));
        pannelloTentativi.add(lblMaxGuess);
/*
        pannelloMappa.setBackground(new Color(40, 40, 40));
        pannelloInput.setBackground(new Color(40, 40, 40));
        pannelloTentativi.setBackground(new Color(40, 40, 40));
        pannelloNomi.setBackground(new Color(40, 40, 40));
        pannelloElencoComuni.setBackground(new Color(40, 40, 40));
*/
        add(pannelloInput, BorderLayout.NORTH);
        add(pannelloNomi);
        add(pannelloMappa, BorderLayout.LINE_START);
        add(pannelloTentativi, BorderLayout.SOUTH);
        pack();
        setResizable(false);
        setTitle(titolo);
        setSize(800, 570);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(false);
        setIconImage(icona.getImage());
        System.out.println("Dimensioni pannello input: " + pannelloInput.getSize());
        System.out.println("Dimensione pannello tentativi : " + pannelloTentativi.getSize());
        System.out.println("Dimensione mappa: " + canvas.getPreferredSize());
    }

    void initInserimenti () {
        inserimenti = new JLabel[guess];
    }

    public void aggiornaComuni (JLabel[] inserimenti) {
        for (int i = 1; i < inserimenti.length; i++) {
            if (!(inserimenti[i] == null))
                this.pannelloElencoComuni.add(inserimenti[i]);
            else
                this.pannelloElencoComuni.add(new JLabel(""));
        }
    }

    public Comune getComuneS() {
        return comuneS;
    }
    public void setComuneS(Comune comuneS) {
        this.comuneS = comuneS;
    }
    public Comune getComuneD() {
        return comuneD;
    }
    public void setComuneD(Comune comuneD) {
        this.comuneD = comuneD;
    }
    public JLabel[] getInserimenti() {
        return inserimenti;
    }
    public void setInserimenti(JLabel[] inserimenti) {
        this.inserimenti = inserimenti;
    }
    public JSVGCanvas getCanvas() {
        return canvas;
    }
    public void setCanvas(JSVGCanvas canvas) {
        this.canvas = canvas;
    }
    public JLabel getLblMaxGuess() {
        return lblMaxGuess;
    }
    public void setLblMaxGuess(JLabel lblMaxGuess) {
        this.lblMaxGuess = lblMaxGuess;
    }
    public int getGuess() {
        return guess;
    }
    public void setGuess(int guess) {
        this.guess = guess;
    }
    public JFrame getFinestra() {
        return finestra;
    }
    public void setFinestra(JFrame finestra) {
        this.finestra = finestra;
    }
    public JPanel getPannelloInput() {
        return pannelloInput;
    }
    public void setPannelloInput(JPanel pannelloInput) {
        this.pannelloInput = pannelloInput;
    }
    public JPanel getPannelloMappa() {
        return pannelloMappa;
    }
    public void setPannelloMappa(JPanel pannelloMappa) {
        this.pannelloMappa = pannelloMappa;
    }
    public JPanel getPannelloNomi() {
        return pannelloNomi;
    }
    public void setPannelloNomi(JPanel pannelloNomi) {
        this.pannelloNomi = pannelloNomi;
    }
    public JButton getPulsanteInvia() {
        return pulsanteInvia;
    }
    public void setPulsanteInvia(JButton pulsanteInvia) {
        this.pulsanteInvia = pulsanteInvia;
    }
    public JTextField getInserisciComuni() {
        return inserisciComuni;
    }
    public void setInserisciComuni(JTextField inserisciComuni) {
        this.inserisciComuni = inserisciComuni;
    }
    public JLabel getEtichetta() {
        return etichetta;
    }
    public void setEtichetta(JLabel etichetta) {
        this.etichetta = etichetta;
    }
    public JLabel getMappaTesto() {
        return mappaTesto;
    }
    public void setMappaTesto(JLabel mappaTesto) {
        this.mappaTesto = mappaTesto;
    }
    public String getComuneInserito() {
        return comuneInserito;
    }
    public void setComuneInserito(String comuneInserito) {
        this.comuneInserito = comuneInserito;
    }
    public JPanel getPannelloElencoComuni() {
        return pannelloElencoComuni;
    }
    public void setPannelloElencoComuni(JPanel pannelloElencoComuni) {
        this.pannelloElencoComuni = pannelloElencoComuni;
    }
    public void setSource(JLabel source) {
        this.source = source;
    }
    public JLabel getSource() {
        return source;
    }
    public JLabel getDestination() {
        return destination;
    }
    public void setDestination(JLabel destination) {
        destination = this.destination;
    }
    public ImageIcon getIcona() {
        return icona;
    }
    public void setIcona(ImageIcon icona) {
        this.icona = icona;
    }
    public int getPreGuess() {
        return preGuess;
    }
    public void setPreGuess(int preGuess) {
        this.preGuess = preGuess;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }
}
