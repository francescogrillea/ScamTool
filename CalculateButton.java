import java.awt.*;
import java.awt.event.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.swing.*;

public class CalculateButton implements ActionListener {

    private final int N = 5;
    private TextField scadenzaField;
    private TextField importoField;
    private TextField[] dateField;
    private JLabel[] result;
    private Date scadenza;
    private Date[] dataMovimento;
    private JLabel error;

    public CalculateButton(TextField s, TextField i, TextField[] d, JLabel[] r, JLabel e) {
        scadenzaField = s;
        importoField = i;
        dateField = d;
        result = r;
        dataMovimento = new Date[N];
        error = e;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        SimpleDateFormat d = new SimpleDateFormat("dd/MM/yyyy", Locale.ITALY);
        try {
            if(scadenzaField.getText().equals("") || importoField.getText().equals("")){
                error.setText("Errore: inserisci data e importo della penale");
                for (int i = 0; i < N; i++) 
                    result[i].setText("");   
                return;
            }

            scadenza = d.parse(scadenzaField.getText());
            
            for (int i = 0; i < N; i++){
                if(dateField[i].getText().equals(""))   
                    dataMovimento[i] = scadenza;
                else
                    dataMovimento[i] = d.parse(dateField[i].getText());
            }                
        } catch (ParseException e1) {
            System.out.println("Error while parsing dates");
        }

        //TODO - insert function here

        int importo = Integer.parseInt(importoField.getText());
        int quota = 0;     
        for (int i = 0; i < N; i++) {
            if(dataMovimento[i].compareTo(scadenza) <= 0)
                quota = 0;
            else{
                quota = 20;
                /*  

                    TODO - calcolare la funzione e mettere il risultato nella variabile quota

                    importo := importo della penale
                    quota := quanto deve mettere il singolo coinquilino
                    scadenza := data scadenza bollette
                    dataMovimento[i] := quando il coinquilino i ha messo i soldi


                */
            }
            result[i].setText(String.valueOf(quota)+" €");
        }
        error.setText("");
    }



}
