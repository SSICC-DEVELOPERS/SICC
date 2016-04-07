/*
    INDRA/CAR/PROY
    $Id: MMGLPPantallaError.java,v 1.1 2009/12/03 18:35:03 pecbazalar Exp $
    DESC
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import es.indra.druida.belcorp.MMGDruidaBase;
import es.indra.sicc.util.ErrorManager;

public class MMGLPPantallaError extends MMGDruidaBase {

    public MMGLPPantallaError() {super();}

    public void inicio() throws Exception {
        pagina("MMGPantallaError");
    }

    public void ejecucion() throws Exception {

		setTrazaFichero();

		String errCodigo = conectorParametro(PARAMETRO_CODIGO_ERROR);
		String cdosIdioma = conectorParametro(PARAMETRO_IDIOMA);
		String country = conectorParametro(PARAMETRO_PAIS);

		if( errCodigo != null && cdosIdioma != null && country != null) {
			String i18nedMessage = null;

			try	{
				i18nedMessage = ErrorManager.getErrorMessage(
						new Integer(errCodigo).intValue(), cdosIdioma, country);
		    } catch (NumberFormatException e) {
				traza( "Exception: " + e.getMessage() + ", stackTrace=" + getStackTrace(e));
			}

			if( i18nedMessage != null) {
				asignarAtributo("LABELC", "mensajeError", "valor", i18nedMessage.trim());
			}
		}

		traza( "Se ejecutó la página de error.");

    }

	private String getStackTrace(Exception e) {
		ByteArrayOutputStream os = new ByteArrayOutputStream();
	    PrintStream ps = new PrintStream(os);

		e.printStackTrace(ps);
	    return new String(os.toByteArray());
  }
}