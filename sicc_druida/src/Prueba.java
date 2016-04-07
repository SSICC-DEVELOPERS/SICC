import java.math.BigDecimal;


public class Prueba {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String numero = "1,222.78";
		
		BigDecimal a = new BigDecimal(numero.replace(",", ""));
	}

}
