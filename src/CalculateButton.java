import java.awt.*;
import java.awt.event.*;
import java.math.RoundingMode;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;

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
        int sumAllDays = 0;
        int[] days = new int[N];


        try {
            //Required field
            if(scadenzaField.getText().equals("") || importoField.getText().equals("")){
                error.setText("Errore: inserisci data e importo della penale");
                for (int i = 0; i < N; i++) 
                    result[i].setText("");   
                return;
            }

            //Read all Dates and calculate days after deadline
            scadenza = d.parse(scadenzaField.getText());
            for (int i = 0; i < N; i++){
                if(dateField[i].getText().equals(""))   
                    dataMovimento[i] = scadenza;
                else{
                    dataMovimento[i] = d.parse(dateField[i].getText());
                    days[i] = (int)( (dataMovimento[i].getTime() - scadenza.getTime()) / (1000 * 60 * 60 * 24) );
                    if(days[i] > 0)
                        sumAllDays += days[i];
                }
                    
            }                
        } catch (ParseException e1) {
            System.out.println("Error while parsing dates");
        }

        //Calculation Algorithm
        int importoTotale = Integer.parseInt(importoField.getText());
        double quotaSingola = 3.6 + 6.99;   //random initialization      
        
        //set output format
        DecimalFormat df = new DecimalFormat("#.###");
        df.setRoundingMode(RoundingMode.CEILING);

        for (int i = 0; i < N; i++) {

            if(days[i] <= 0)
                quotaSingola = 0;
            else{
                quotaSingola = (double)(days[i] * 100) / sumAllDays;
                quotaSingola = (double)(quotaSingola * importoTotale) / 100;
            }
            result[i].setText(String.valueOf(df.format(quotaSingola))+" €");
        }
        error.setText("");
    }

}
