package medecin;
/**
 * Exemple pour expliquer le relation d'héritage
 * et le polymorhisme
 * @author Didier
 * @version 2 
 */
public class Generaliste {
 public void suturer() {
	 System.out.println("Je suture comme un généraliste");
 }
 public void prendreTension() {
	 System.out.println("Je prends la tension comme un généraliste");
 }
 
 public void operer() {
	 throw new UnsupportedOperationException("Je ne sais pas opérer");
 }
 
}
