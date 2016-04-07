/*
    INDRA/CAR/PROY
    $Id: LPPantallaError.java,v 1.4 2003/05/29 15:50:44 druida Exp $
    DESC
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Locale;

import org.apache.avalon.excalibur.i18n.Resources;

import es.indra.druida.belcorp.MMGDruidaBase;
import es.indra.mare.common.mii.MareMii;
import es.indra.mare.common.mii.MareTopic;
import es.indra.mare.common.mii.services.localization.LocalizationService;
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
					/*
					i18nedMessage = ErrorManager.getErrorMessage(
							new Integer(errCodigo).intValue(), cdosIdioma, country);
					*/
					LocalizationService i18nService = (LocalizationService)MareMii.getService(new MareTopic("LocalizationService"));
					Resources resources = i18nService.createResource(new Locale(cdosIdioma, country));
					i18nedMessage = resources.getString(errCodigo);
		    }catch (NumberFormatException e) {
					traza( "Exception: " + e.getMessage() + ", stackTrace=" + getStackTrace(e));
				}
	
				if( i18nedMessage != null) {
					asignarAtributo("LABELC", "mensajeError", "valor", i18nedMessage.trim() + 
						(conectorParametro(PARAMETRO_ERRORINFO_EXTRA) != null? " " + conectorParametro(PARAMETRO_ERRORINFO_EXTRA): ""));
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