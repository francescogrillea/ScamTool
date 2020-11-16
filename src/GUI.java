import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

public class GUI{
	
	private final int N = 5;
	private final String[] names = {"Pepi", "Walter", "Peppe", "Lar", "Ciccio"};

	private JFrame frame;
	private JPanel panel;

	private JLabel intro;
	private TextField scadenza;
	private JLabel importo;
	private TextField importoField;

	private JLabel[] text;
	private TextField[] dateField;
	private JLabel[] result;

	private JLabel error;
	
	public GUI() {
		
		//create a frame
		frame = new JFrame("Scam Tool");
		frame.setIconImage(new ImageIcon("images/icon.png").getImage());
		panel = new JPanel();
		panel.setBackground(Color.darkGray);
		frame.getContentPane();

		intro = new JLabel("Data scadenza Bolletta");
		intro.setBounds(10, 10, 140, 25);
		intro.setForeground(Color.white);
		panel.add(intro);

		scadenza = new TextField();
		scadenza.setBounds(155, 10, 100, 25);
		panel.add(scadenza);

		importo = new JLabel("Importo: €");
		importo.setBounds(280, 10, 60, 25);
		importo.setForeground(Color.white);
		panel.add(importo);

		importoField = new TextField();
		importoField.setBounds(340, 10, 100, 25);
		panel.add(importoField);



		//create sx text
		text = new JLabel[N];
		dateField = new TextField[N];
		result = new JLabel[N];
		for (int i = 0; i < N; i++) {
			//names
			text[i] = new JLabel(names[i]);
			text[i].setBounds(10, 55 + 40*i, 50, 25);
			text[i].setForeground(Color.white);
			panel.add(text[i]);

			//date field
			dateField[i] = new TextField("");
			dateField[i].setBounds(70, 55 + 40*i, 100, 25);
			panel.add(dateField[i]);

			//amount
			result[i] = new JLabel("");
			result[i].setBounds(200, 55+40*i, 40, 25);
			result[i].setForeground(Color.white);
			panel.add(result[i]);
		}

		//error msg
		error = new JLabel("");
		error.setForeground(new Color(102,0,0));
		error.setBounds(230, 240, 300, 25);
		panel.add(error);


		//button
		JButton calculateButton = new JButton(new ImageIcon("images/calculate.png"));
		calculateButton.setBounds(270, 55+25, 135, 135);
		calculateButton.setContentAreaFilled(false);
		calculateButton.addActionListener(new CalculateButton(scadenza, importoField, dateField, result, error));

		panel.add(calculateButton);


		//insert objects inside panel
		panel.setLayout(null);
		panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));		
	    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	    frame.add(panel);
	    frame.setSize(500, 300);
	    frame.setVisible(true);
	}

	

	public static void main(String[] args) {
		new GUI();
	}

}
