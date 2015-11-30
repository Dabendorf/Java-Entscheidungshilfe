package muenzwurf;

import java.util.Random;

import javax.swing.JOptionPane;

/**
 * Diese Klasse repraesentiert einen x mal durchgefuehrten Muenzwurf.<br>
 * Nach dem Prinzip der Raetedemokratie werden kleine Gruppen von Wuerfen gebildet und geben ihr Mehrheitsergebnis in die naechste Runde weiter.
 * 
 * @author Lukas Schramm
 * @version 1.0
 *
 */
public class Raetedemokratie {
	
	private int anzr1 = 10000;
	private int anzr2 = 1000;
	private int anzr3 = 100;
	private int endergebnis;
	private Random muenze = new Random();
	
	public Raetedemokratie() {
		auswertung();
	}
	
	/**
	 * Diese Methode wertet die untere Ebene der Raete aus und gibt einen boolean zurueck, ob der Rat zustimmt.
	 * @return Gibt einen boolean der Zustimmung zurueck.
	 */
	private boolean runde1() {
		int wahrzaehler1 = 0;
		for(int n=0;n<anzr1;n++) {
			if(muenze.nextInt(2) == 1) {
				wahrzaehler1++;
			}
		}
		if(wahrzaehler1 > anzr1/2) {
			return true;
		} else if(wahrzaehler1==anzr1/2) {
			if(muenze.nextInt(2) == 1) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	
	/**
	 * Diese Methode wertet die mittlere Ebene der Raete aus und gibt einen boolean zurueck, ob der Rat zustimmt.
	 * @return Gibt einen boolean der Zustimmung zurueck.
	 */
	private boolean runde2() {
		int wahrzaehler2 = 0;
		for(int n=0;n<anzr2;n++) {
			if(runde1() == true) {
				wahrzaehler2++;
			}
		}
		if(wahrzaehler2 > anzr2/2) {
			return true;
		} else if(wahrzaehler2==anzr2/2) {
			if(muenze.nextInt(2) == 1) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	
	/**
	 * Diese Methode wertet die hoechste Ebene der Raete aus und gibt einen Prozentwert zurueck, wie hoch die Zustimmung des Rates ist.
	 * @return Der berechnete Prozentwert wird zurueckgegeben.
	 */
	private int runde3() {
		int wahrzaehler3 = 0;
		for(int n=0;n<anzr3;n++) {
			if(runde2() == true) {
				wahrzaehler3++;
			}
		}
		endergebnis = wahrzaehler3;
		return wahrzaehler3;
	}
	
	/**
	 * Diese Methode sagt dem Nutzer, was er tun sollte und beendet das Programm.
	 */
	private void auswertung() {
		JOptionPane.showMessageDialog(null, "Willkommen!\nBitte habe ein kleines bisschen Geduld,\nbis Deine Entscheidung ermittelt wurde.\nSie scheint sehr schwierig zu sein.", "Geduld", JOptionPane.PLAIN_MESSAGE);
		if(runde3() > anzr3/2) {
			JOptionPane.showMessageDialog(null, "Ich rate Dir dazu, das was Du tun möchtest auszuführen.\n"+endergebnis+" % des Programmes halten zu Dir!", "Mach es!", JOptionPane.PLAIN_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(null, "Nur "+endergebnis+" % des Programmes halten zu Dir!\nEs wird Dir dringend davon abgeraten Dein Vorhaben umzusetzen.", "Lass es!", JOptionPane.WARNING_MESSAGE);
		}
		System.exit(0);
	}
	
	public static void main(String[] args) {
		new Raetedemokratie();
	}
}