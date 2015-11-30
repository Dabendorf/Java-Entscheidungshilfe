package muenzwurf;

import java.util.Random;

import javax.swing.JOptionPane;

/**
 * Diese Klasse repraesentiert einen x mal durchgefuehrten Muenzwurf.<br>
 * Der Prozentwert der geworfenen Koepfe ist ausschlaggebend dafuer, ob das Programm dazu raet, Entscheidung y durchzufuehren.
 * 
 * @author Lukas Schramm
 * @version 1.0
 *
 */
public class Muenzwurf {

	private double anzr1 = 1000000;
	private double endergebnis;
	private Random muenze = new Random();
	
	private Muenzwurf() {
		auswertung();
	}
	
	/**
	 * Diese Methode fuehrt alle Wuerfe durch, zaehlt die geworfenen Koepfe und berechnet den Prozentwert.
	 * @return Der berechnete Prozentwert wird zurueckgegeben.
	 */
	private double runde1() {
		int wahrzaehler1 = 0;
		for(int n=0;n<anzr1;n++) {
			if(muenze.nextInt(2) == 1) {
				wahrzaehler1++;
			}
		}
		endergebnis = 100*wahrzaehler1/anzr1;
		return endergebnis;
	}
	
	/**
	 * Diese Methode sagt dem Nutzer, was er tun sollte und beendet das Programm.
	 */
	private void auswertung() {
		JOptionPane.showMessageDialog(null, "Willkommen!\nBitte habe ein kleines bisschen Geduld,\nbis Deine Entscheidung ermittelt wurde.\nSie scheint sehr schwierig zu sein.", "Geduld", JOptionPane.PLAIN_MESSAGE);
		if(runde1() > 50) {
			JOptionPane.showMessageDialog(null, "Ich rate Dir dazu, das was Du tun möchtest auszuführen.\n"+endergebnis+" % des Programmes halten zu Dir!", "Mach es!", JOptionPane.PLAIN_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(null, "Nur "+endergebnis+" % des Programmes halten zu Dir!\nEs wird Dir dringend davon abgeraten Dein Vorhaben umzusetzen.", "Lass es!", JOptionPane.WARNING_MESSAGE);
		}
		System.exit(0);
	}
	
	public static void main(String[] args) {
		new Muenzwurf();
	}
}