package interfaceSwitch;

public class Lampe implements ISwitchable {

	private boolean allume = false;

	@Override
	public void on() {
		if (allume)
			System.out.println("Lampe déjà allumée");
		else {
			allume = true;
			System.out.println("Lampe allumée");

		}

	}

	@Override
	public void off() {
		if (!allume)
			System.out.println("Lampe déjà éteinte");
		else {
			allume = false;
			System.out.println("Lampe éteinte");

		}

	}

}
