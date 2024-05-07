import org.apache.batik.swing.JSVGCanvas;
import sun.swing.UIAction;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.util.*;
import java.util.List;
import java.io.*;


public class Controller {
    //Attributi
    private View vista;
    private PrimaView primaView;
    List<String> comuniSVG = new ArrayList<>();
    List<String> nomiInseriti = new ArrayList<>();
    Set<Comune> percorso = new HashSet<>();
    boolean primoAvvio = true, stato = false;
    Set<Comune> percorsoBreve = new HashSet<>();
    static List<Comune> comuni;


    //Costruttore
    public Controller(View vista, PrimaView primaView, List<Comune> comuni, List<Comune> scelte) {
        this.vista = vista;
        this.primaView = primaView;
        Controller.comuni = comuni;

        percorsoBreve.addAll(scelte);

        percorsoBreve.remove(vista.getComuneS());
        percorsoBreve.remove(vista.getComuneD());
        aggiornaMappa();
        primoAvvio = false;

        vista.getPulsanteInvia().addActionListener(e-> invia(comuni, scelte));
        vista.getInserisciComuni().addActionListener(e -> invia(comuni, scelte));

        primaView.getBtnFacile().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (primaView.getBtnFacile().isSelected()){
                    primaView.setChosenFacile(!primaView.isChosenFacile());
                    primaView.getBtnFacile().setText(""+primaView.isChosenFacile());
                    System.out.println(primaView.isChosenFacile());
                } else {
                    primaView.setChosenFacile(!primaView.isChosenFacile());
                    primaView.getBtnFacile().setText(""+primaView.isChosenFacile());
                    System.out.println(primaView.isChosenFacile());
                }
            }
        });
    }

    //Metodi vari ed eventuali
    public void invia (List<Comune> comuni, List<Comune> scelte) {
        int i = 1;

        JLabel lblNuovoComune = null;
        String comuneInserito = vista.getInserisciComuni().getText().toUpperCase();

        if (nomiInseriti.contains(comuneInserito)) {
            JOptionPane.showMessageDialog(null, "Il comune inserito \u00e8 uguale ad uno inserito precedentemente!", "Errore", JOptionPane.ERROR_MESSAGE);
            vista.getInserisciComuni().setText("");
        } else if (vista.getSource().getText().equals(comuneInserito)) {
            JOptionPane.showMessageDialog(null, "Il comune inserito \u00e8 uguale alla partenza ", "Errore", JOptionPane.ERROR_MESSAGE);
            vista.getInserisciComuni().setText("");
        } else if (vista.getDestination().getText().equals(comuneInserito)) {
            JOptionPane.showMessageDialog(null, "Il comune inserito \u00e8 uguale alla destinazione ", "Errore", JOptionPane.ERROR_MESSAGE);
            vista.getInserisciComuni().setText("");
        } else if (checkNome(comuni, comuneInserito)) {
            aggiungiNome(comuni, comuneInserito);

            createNewSVGFile(comuneInserito.toLowerCase(), comuniSVG, vista.getSource().getText(), vista.getDestination().getText());
            aggiornaMappa();

            if (checkScelte(scelte, comuneInserito)) {
                lblNuovoComune = new JLabel(comuneInserito.toUpperCase() + " \u263A");
                lblNuovoComune.setForeground(Color.GREEN);
                vista.inserimenti[i] = lblNuovoComune;
            } else if (checkConfini(scelte, comuneInserito)) {
                lblNuovoComune = new JLabel(comuneInserito.toUpperCase());
                lblNuovoComune.setForeground(Color.ORANGE);
                vista.inserimenti[i] = lblNuovoComune;
            } else {
                lblNuovoComune = new JLabel(comuneInserito.toUpperCase());
                lblNuovoComune.setForeground(Color.RED);
                vista.inserimenti[i] = lblNuovoComune;
            }

            vista.aggiornaComuni(vista.inserimenti);
            vista.getPannelloElencoComuni().validate();

            if (checkVittorie()) {

                JOptionPane.showMessageDialog(null, "Complimenti, sei riuscito a collegare inizio e fine!", "HAI VINTO!", JOptionPane.INFORMATION_MESSAGE);
                if (checkShortestPath())
                    JOptionPane.showMessageDialog(null, "Sei andato da " + vista.getComuneS().getNome() + " a " + vista.getComuneD().getNome() + " con " + percorso.size() + " tentativi" + "\nLa soluzione più breve era in " + percorsoBreve.size() + " tentativi");
                else {
                    String tentativo = percorsoBreve.size() == 1 ? "tentativo" : "tentativi";
                    JOptionPane.showMessageDialog(null, "Sei andato da " + vista.getComuneS().getNome() + " a " + vista.getComuneD().getNome() + " con " + percorso.size() +" " + tentativo +
                            "\nIl percorso più corto era: " + printCollection(scelte) + "\nLa soluzione più breve era di " + percorsoBreve.size() + " " + tentativo);

                }
                int scelta = JOptionPane.showConfirmDialog(null, "Vuoi fare un altra partita?");
                if (scelta == 0) {
                    System.out.println("Hai premuto si");
                } else if (scelta == 1)
                    System.out.println("hai premuto no");
                else if (scelta == 2)
                    System.out.println("hai premuto annulla");
                else
                    System.out.println("Finestra chiusa");
                System.exit(0);
                System.out.println("Helo");
                vista.getInserisciComuni().setEditable(false);
                vista.getPulsanteInvia().setEnabled(false);
            }
            vista.setGuess(vista.getGuess() - 1);
            vista.getLblMaxGuess().setText("Tentativi rimasti: " + vista.getGuess() + "/" + vista.getPreGuess());
            vista.getInserisciComuni().setText("");
            if (vista.getGuess() <= 0) {
                JOptionPane.showMessageDialog(null, "Non sei riuscito a collegare inizio e fine entro i tentativi", "Hai esaurito i tentativi!", JOptionPane.INFORMATION_MESSAGE);
                vista.getInserisciComuni().setEditable(false);
                vista.getPulsanteInvia().setEnabled(false);
            }

        } else {
            JOptionPane.showMessageDialog(null, comuneInserito + " non \u00E8 un comune", "Errore", JOptionPane.ERROR_MESSAGE);
            vista.getInserisciComuni().setText("");
        }

    }
    public void aggiornaMappa () {
        if (primoAvvio) {
            createNewSVGFile(null, comuniSVG, vista.getSource().getText(), vista.getDestination().getText());
        }
        vista.setCanvas(null);
        vista.getPannelloMappa().removeAll();
        vista.setCanvas(new JSVGCanvas());
        vista.getCanvas().setPreferredSize(new Dimension(381, 459));
//        vista.getPannelloMappa().setSize(381, 459);
        vista.getCanvas().setURI(".\\src\\main\\java\\img\\mappaNuova.svg");
        vista.getPannelloMappa().add(vista.getCanvas());
        vista.getPannelloMappa().revalidate();
        vista.getPannelloMappa().repaint();
    }
    void aggiungiNome(List<Comune> comuni, String comuneInserito) {
        for (Comune c : comuni) {
            if (c.getNome().equalsIgnoreCase(comuneInserito)) {
                nomiInseriti.add(comuneInserito);
                percorso.add(c);
            }

        }
    }
    public void createNewSVGFile(String desiredId, List<String> comuniSVG, String source, String destination) {
        try (BufferedReader reader = new BufferedReader(new FileReader(".\\src\\main\\java\\img\\mappa.svg"));
             BufferedWriter writer = new BufferedWriter(new FileWriter(".\\src\\main\\java\\img\\mappaNuova.svg"))) {
            String line;
            writer.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
            writer.write("<svg xmlns=\"http://www.w3.org/2000/svg\" xmlns:xlink=\"http://www.w3.org/1999/xlink\" width=\"381px\" height=\"459px\"  viewBox=\"0 0 381 459\" version=\"1.1\">\r\n" + //
                    "\n");
            writer.write("<g id=\"surface1\">\n");

            boolean writeNextLines = false;
            int linesToWrite = 0;
            while ((line = reader.readLine()) != null) {

                if (primaView.isChosenFacile())
                    contornoMappa(line, writer);


                if (line.contains("<path id=\"" + source.toLowerCase())) {
                    line = line.replace("rgb(97.254902%,76.470588%,0%)", "rgb(163, 73, 164)");
                    writer.write(line + "\n");
                }
                if (line.contains("<path id=\"" + destination.toLowerCase())) {
                    line = line.replace("rgb(97.254902%,76.470588%,0%)", "rgb(255, 242, 0)");
                    writer.write(line + "\n");
                }
                if (line.contains("<path id=\"" + desiredId)) {
                    writeNextLines = true;
                    linesToWrite = 1;
                }
                if (writeNextLines || linesToWrite > 0) {
                    comuniSVG.add(line + "\n");
                    for (String string : comuniSVG) {
                        string = string.replace("rgb(97.254902%,76.470588%,0%)", "rgb(216, 63, 89)");
                        writer.write(string);
                    }
                    linesToWrite = 0;
                }
                if (linesToWrite == 0) {
                    writeNextLines = false;
                }
            }
            String string;
            for (Comune c : comuni) {
                while ((string = reader.readLine()) != null) {
                    if (string.contains("<path id=\" " + c.getNome().toLowerCase())) {
                        String temp = string;
                        temp = temp.replace(c.getNome().toLowerCase(), c.getNome().toLowerCase() + "Contorno");
                        temp = temp.replace("fill:rgb(97.254902%,76.470588%,0%);", "");
                        System.out.println(temp);
                    }
                }
            }


            writer.write("<path id=\"lago\" style=\"fill-rule:nonzero;fill:#529eff;fill-opacity:1,stroke-width:2;stroke-linecap:butt;stroke-linejoin:round;stroke:rgb(0%,0%,0%);stroke-opacity:1;stroke-miterlimit:4;\" d=\"M 511.643004 211.915678 L 515.428564 215.575663 L 519.09131 219.367146 L 524.27117 220.630973 L 526.539616 221.135043 L 527.428211 224.919219 L 532.095142 226.058856 L 532.095142 230.726981 L 531.589438 234.898342 L 529.068139 238.814015 L 525.282579 248.405953 L 521.114128 260.905425 L 521.114128 260.781234 L 520.355571 271.264426 L 518.838458 277.82464 L 517.957087 284.647846 L 514.164302 290.70399 L 505.834625 297.651388 L 505.581773 301.311374 L 504.317511 304.467289 L 500.654765 307.119135 L 495.099239 310.65493 L 493.083645 314.446412 L 489.796565 323.410089 L 486.769562 332.629454 L 485.12241 339.825234 L 483.482482 344.120786 L 481.71974 347.021014 L 478.179808 346.641135 L 476.164214 348.788911 L 475.152805 352.828775 L 477.421251 355.232239 L 476.792733 358.892224 L 474.011357 364.071725 L 470.854316 367.476023 L 466.693089 370.763435 L 463.911714 372.151454 L 463.283196 375.563057 L 463.7889 378.967355 L 461.766082 382.123271 L 456.586222 386.798701 L 454.946294 392.730654 L 450.655029 399.926434 L 447.620802 404.601865 L 445.222317 410.029748 L 442.448166 414.201108 L 439.038272 420.51294 L 436.134083 424.428613 L 431.459928 431.120323 L 427.797182 438.695982 L 425.023031 442.984228 L 422.241655 447.031398 L 421.360285 450.187314 L 419.843171 454.607057 L 417.950391 456.879024 L 412.900569 462.810977 L 410.249232 467.354911 L 407.850748 469.758374 L 406.586486 472.658603 L 405.705115 476.325893 L 403.559483 479.730191 L 401.406626 485.537953 L 398.502437 491.981281 L 394.846915 495.896954 L 394.969729 501.828907 L 393.582654 509.404566 L 391.054131 512.94036 L 387.897089 518.62393 L 386.257161 522.539604 L 385.245752 526.579468 L 385.122938 531.751663 L 385.498604 535.923024 L 386.510014 536.551285 L 388.402794 536.302903 L 391.184169 534.155127 L 394.088358 531.627472 L 397.498252 530.495141 L 402.042369 529.983766 L 405.575077 532.767108 L 409.237823 534.155127 L 411.766346 535.923024 L 411.130603 539.458818 L 410.754937 542.110664 L 413.78194 546.654598 L 416.433277 552.213978 L 417.444686 556.502224 L 418.456095 561.426037 L 419.337466 565.84578 L 419.337466 567.233799 L 422.624546 568.249244 L 424.011622 572.157612 L 423.758769 578.476748 L 423.383103 583.020683 L 425.145845 588.068687 L 426.287292 595.644345 L 427.674368 600.064089 L 428.685777 605.243589 L 429.444334 615.726781 L 424.64014 622.286995 L 421.483099 629.110202 L 418.708948 634.793772 L 416.563315 639.841776 L 416.310463 643.625953 L 413.406274 644.765589 L 413.153421 646.913365 L 411.88916 651.961369 L 406.962152 656.001233 L 403.429445 660.172594 L 402.042369 665.600477 L 403.935149 674.060084 L 403.935149 677.471688 L 399.766698 674.944033 L 393.076949 668.128132 L 385.498604 664.212458 L 382.724454 661.056543 L 369.460544 657.769131 L 364.287909 655.752851 L 361.889424 651.837178 L 360.242272 649.185332 L 357.215269 650.829038 L 353.552523 652.721127 L 347.368478 649.94509 L 341.682913 647.161747 L 341.177209 639.337706 L 339.667319 633.654136 L 339.912947 629.234393 L 341.430061 626.326859 L 341.560099 623.046752 L 339.912947 622.038613 L 339.912947 619.766646 L 341.935766 616.983303 L 340.042986 614.711336 L 337.767315 610.42309 L 336.38024 610.42309 L 332.970346 613.447509 L 333.981755 615.975164 L 335.498869 618.378627 L 337.897353 620.394907 L 339.161615 622.79837 L 338.525872 624.434771 L 338.150206 628.474635 L 337.644501 636.430173 L 335.246016 639.337706 L 330.701899 641.989552 L 328.173376 645.525346 L 324.257778 650.573351 L 317.185138 652.341248 L 305.192715 648.301383 L 300.265707 647.541626 L 291.430325 645.021277 L 288.396098 640.090158 L 288.901802 630.49822 L 288.020431 625.442911 L 285.491908 623.426631 L 279.430678 623.426631 L 274.633708 622.542683 L 271.353853 619.890837 L 267.943959 614.083075 L 269.713925 609.663332 L 274.633708 602.971622 L 280.066421 597.032364 L 286.250465 591.224602 L 292.058844 587.564617 L 297.491556 584.153013 L 301.529969 582.764995 L 302.541378 580.748716 L 301.407155 577.08873 L 301.154302 573.552935 L 302.541378 570.645402 L 307.338347 566.101468 L 310.372575 564.077883 L 312.012502 564.581953 L 313.905282 560.797776 L 316.180953 559.533949 L 317.568029 555.998154 L 316.932286 551.834099 L 314.158135 550.44608 L 311.001093 548.802374 L 309.108313 547.282859 L 310.871055 544.506822 L 310.625427 542.738925 L 307.591199 544.382631 L 304.564196 545.894841 L 301.529969 545.010892 L 298.120075 542.614734 L 295.72159 539.203131 L 295.851628 536.551285 L 299.131484 532.511421 L 302.917044 528.215869 L 305.315529 528.347365 L 308.096904 524.555883 L 311.506798 524.555883 L 311.629612 521.655655 L 313.65243 520.13614 L 316.679433 519.507879 L 316.180953 518.499739 L 311.75965 517.988364 L 307.468385 508.520617 L 300.771412 507.512477 L 292.441735 508.140738 L 287.261875 509.024687 L 281.959201 511.296654 L 277.415084 511.296654 L 274.763747 510.792584 L 274.763747 505.868771 L 276.656527 501.573219 L 281.453496 501.449028 L 284.86339 500.820767 L 287.139061 497.913234 L 294.710181 495.517075 L 297.744408 494.129057 L 301.154302 493.624987 L 301.407155 491.725593 L 308.349756 488.569678 L 313.399578 483.901552 L 314.786653 482.761916 L 321.100736 482.886107 L 326.40341 476.070206 L 330.196195 471.774654 L 335.246016 474.046621 L 340.671504 476.829963 L 343.322841 476.574276 L 345.974178 473.41836 L 346.22703 469.626878 L 347.62133 463.446543 L 348.379887 459.779252 L 351.284076 456.879024 L 357.720973 451.071262 L 361.38372 447.27978 L 365.674984 443.364107 L 368.709212 439.075861 L 369.843435 436.292518 L 371.736215 436.044136 L 372.364734 433.772169 L 370.471954 432.128463 L 370.219101 430.484757 L 372.494772 427.964407 L 374.640404 421.141201 L 378.556003 417.357024 L 382.977306 412.301715 L 384.9929 409.145799 L 388.908498 405.610004 L 392.946911 403.842107 L 396.103952 400.941879 L 397.873918 398.034346 L 401.03096 395.88657 L 403.306631 394.754239 L 406.333634 392.350775 L 408.984971 388.566599 L 411.383455 385.410683 L 413.153421 380.735252 L 416.816168 377.959215 L 421.360285 374.29923 L 426.03444 370.763435 L 429.567148 368.615659 L 431.71278 367.855902 L 432.095671 364.955674 L 434.241303 362.807898 L 435.375526 360.535931 L 436.89264 357.628397 L 438.409754 355.984691 L 439.666791 353.712724 L 440.555386 349.548668 L 443.459575 348.920407 L 442.823833 347.021014 L 442.448166 344.624856 L 445.222317 340.4608 L 448.256545 338.437215 L 450.402177 335.661178 L 453.42918 330.985748 L 454.693442 327.325762 L 457.474817 324.673916 L 461.007525 320.758243 L 462.900305 318.990346 L 462.647453 314.446412 L 462.647453 311.794566 L 464.417419 309.018529 L 465.934533 306.235186 L 467.198794 303.334958 L 467.57446 298.535337 L 469.850131 295.123733 L 470.731502 292.727575 L 473.635691 292.223505 L 473.758505 286.160056 L 475.658509 282.755758 L 478.685513 279.724033 L 480.708331 277.452066 L 485.375262 275.80836 L 490.555122 272.520948 L 496.110648 269.240841 L 498.256281 266.588995 L 498.256281 262.045061 L 498.003428 255.097663 L 501.54336 252.577314 L 502.301917 247.901883 L 504.317511 244.99435 L 504.823216 242.342504 L 504.064659 239.822155 L 502.930436 238.178449 L 503.688993 232.874757 L 505.451735 231.10686 L 505.957439 227.066995 L 507.098887 221.514922 L 506.846034 217.343561 L 508.738814 213.427888 L 509.750224 211.65999 Z M 511.643004 211.915678 \" transform=\"matrix(0.540706,0,0,0.53471,-144.335933,-112.637672)\"/>\n");
            writer.write("</g>\n");
            writer.write("</svg>");
        } catch (IOException e) {
            throw new RuntimeException("Errore durante la lettura o scrittura del file");
        }
    }
    boolean checkNome (List<Comune> comuni, String nome) {
        for (Comune c : comuni) {
            String temp = c.getNome();
            if (temp.equalsIgnoreCase(nome)) {
                return true;
            }
        }
        return false;
    }
    boolean checkScelte (List<Comune> scelte, String scelta) {
        for (Comune c : scelte) {
            String temp = c.getNome();
            if (temp.equalsIgnoreCase(scelta))
                return true;
        }
        return false;
    }

    public boolean checkConfini (List<Comune> scelte, String comuneInserito) {
        for (Comune c : scelte) {
            Set<Comune> temp = c.getNeighbours();
            for (Comune comune : temp) {
                if (comune.getNome().equalsIgnoreCase(comuneInserito))
                    return true;
            }
        }
        return false;
    }
    public boolean checkVittorie() {
        Queue<Comune> q = new LinkedList<>();
        Set<Comune> visited = new HashSet<>();
        q.add(vista.getComuneS());
        Comune dest = vista.getComuneD();
        while (!q.isEmpty()) {
            Comune node = q.poll();
            visited.add(node);
            for (Comune neighbor : node.getNeighbours()) {
                if (neighbor.getId() == dest.getId()) {
                    return true;
                }
                if (this.percorso.contains(neighbor) && !visited.contains(neighbor)) {
                    q.add(neighbor);
                }
            }
        }
        return false;
    }

    public String printCollection (List<Comune> scelte) {
        String comuni = "";
        for (Comune c : scelte) {
            if (c.equals(vista.getComuneS())) {
                comuni += c.getNome();
                break;
            }
            comuni += c.getNome() + " \u2192 ";
        }
        return comuni;
    }

    public boolean checkShortestPath () {
        return percorsoBreve.containsAll(percorso);
    }

    public void contornoMappa (String line, Writer writer) throws IOException {
        //--------------------------------------------------------------------------------------------
        //Codice per creare la griglia della mappa di comuni per creare la modalità facile

        for (Comune c : comuni) {
            if (line.contains(c.getNome().toLowerCase())) {
                String temp = line;
                temp = temp.replace(c.getNome().toLowerCase(), c.getNome().toLowerCase() + "Contorno");
                temp = temp.replace("rgb(97.254902%,76.470588%,0%)", "");
                temp = temp.replace("fill-opacity:1;", "fill-opacity:0;");
                writer.write(temp + "\n");
            }
        }

        //--------------------------------------------------------------------------------------------
    }
}
