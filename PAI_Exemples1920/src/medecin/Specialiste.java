package medecin;

public class Specialiste extends Generaliste {
	public void operer() {
		System.out.println("J'opère");
	}

	@Override
	public void suturer() {
		System.out.println("Je prépare ma suture comme un spécialiste");
		super.suturer();// appel du traitement parent (généraliste)
		System.out.println("J'utilise en plus ma machine spécialisée");
	}

}
