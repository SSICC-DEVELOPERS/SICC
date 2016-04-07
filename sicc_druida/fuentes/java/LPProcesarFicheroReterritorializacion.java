//import LPGenericaSubirFichero;
import es.indra.sicc.dtos.zon.DTOPeriodosRezonificacion;
import es.indra.sicc.dtos.cra.DTOPeriodo;

//import es.indra.sicc.cmn.presentacion.subidaFichero.DTOFicheroDisp;
import es.indra.sicc.cmn.presentacion.subidaFichero.DTOFicheroResultado;
import es.indra.sicc.dtos.zon.DTOFicheroDisp;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.util.UtilidadesBelcorp;
import java.util.Vector;
import java.util.Collection;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.File;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

import es.indra.mare.common.mln.MareBusinessID;
import es.indra.druida.DruidaConector;

public class LPProcesarFicheroReterritorializacion extends LPGenericaSubirFichero {

  public LPProcesarFicheroReterritorializacion() {
    super();
  }

	public void ejecucion() throws Exception {
		rastreo();
		setTrazaFichero();
		traza("*** Entrada - LPProcesarFicheroReterritorializacion - ejecucion ***");

		try {
         	String accion = conectorParametroLimpia("accion", "", true);

			if (accion.equals("")) {
				this.seleccionar();
			} else if (accion.equals("procesar")) {
				this.procesar();
			}

			getConfiguracionMenu("LPProcesarFicheroReterritorializacion", accion);

		} catch(Exception e) {
			logStackTrace(e);
			lanzarPaginaError(e);
		}
		traza("*** Salida - LPProcesarFicheroReterritorializacion - ejecucion ***");
    
	}

	public void seleccionar() throws Exception {
		traza("*** Entrada - LPProcesarFicheroReterritorializacion - seleccionar ***");

		pagina("contenido_seleccion_fichero");
		asignar("VAR", "conectorAction", "LPProcesarFicheroReterritorializacion");
		asignar("VAR", "accion", "procesar");
		asignarAtributoElemento("frmFichero", "oculto", "S");
		asignarAtributo("PAGINA", "contenido_seleccion_fichero", "cod", "00662"); //"Selección fichero Reterritorialización" 

		traza("*** Salida - LPProcesarFicheroReterritorializacion - seleccionar ***");
	}

	public void procesar() throws Exception {
		traza("*** Entrada - LPProcesarFicheroReterritorializacion - procesar ***");



		pagina("salidaGenerica");
		Long pais = UtilidadesSession.getPais(this); 
		Long idioma = UtilidadesSession.getIdioma(this);

		//prueba
		

		String s1 = this.getDirTempDruida();
		String s2 = conectorParametroLimpia("seleccion", "", true); 
		String s3 = this.getWebTmpDir(); 

		DTOFicheroDisp dtoin = new DTOFicheroDisp();
		dtoin.setNombreFichero(s2); 
		dtoin.setPathFichero(s3); 
		dtoin.setOidPais(pais);
		dtoin.setOidIdioma(idioma);

		//Los atributo TypeProc y Datos se deben asignar si el metodo de negocio que va a procesar el fichero los requiere. 

		//Se crea el idbusiness "ZONLanzarReterritorializacion" 
		MareBusinessID idBussiness = new MareBusinessID("ZONLanzarReterritorializacion");
		
		
		// Se almacenan los parametros de entrada
		Vector paramEntrada = new Vector();
		paramEntrada.addElement(dtoin);
		paramEntrada.addElement(idBussiness);
		
		//Se ejecuta el conector "ConectorProcesarFichero" 
		traza("*** invocamos conector dto zon***");
		DruidaConector conector = conectar("ConectorProcesarFichero", paramEntrada);

		traza("*** Salida - LPProcesarFicheroReterritorializacion - procesar ***");

		// vbongiov - 6/03/2006 - inc 21883
		asignarAtributo("VAR", "ejecutar", "valor", "mensajeProcesando()");
	}


	private void logStackTrace(Throwable e) throws Exception {
		traza("Se produjo la excepcion: " + e.getMessage());
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		e.printStackTrace(ps);
		
		traza("Stack Trace: " + baos.toString());
	}

  
}


