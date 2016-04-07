import es.indra.druida.DruidaConector;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.dtos.ape.DTODatosEtiqueta;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.UtilidadesSession;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Vector;
import java.util.StringTokenizer;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import es.indra.sicc.logicanegocio.ape.ConstantesAPE;

public class LPFormatosEtiquetas extends LPSICCBase {	

    public LPFormatosEtiquetas () { super(); }

	private String casoUso = null;
	private String accion = null;
	private Long pais = null;     
	private Long idioma = null;

	public void inicio() throws Exception { }
  
    public void ejecucion() throws Exception {
		setTrazaFichero();
		traza("LPFormatosEtiquetas.ejecucion() - Entrada");

     	accion = conectorParametroLimpia("accion", "", true);
	    pais = UtilidadesSession.getPais(this);
		idioma = UtilidadesSession.getIdioma(this);

		traza("**** accion : " + accion);
		traza("**** pais : " + pais);
		traza("**** idioma : " + idioma);
	    
		try  {			
			if (accion.equals("insertar") || accion.equals("consultar")
			 || accion.equals("modificar") || accion.equals("eliminar")) {
				cargarPantalla(); 
			}
			else if(accion.equals("guardar")) {
				guardar();
			}			
			else if(accion.equals("detalle")) {
				detalle();
			}			
			else if(accion.equals("modificacion")) {
				modificacion();
			}			
			
			cargarMenuSecundario();
			traza("LPFormatosEtiquetas.ejecucion() - Salida");
		}
		catch ( Exception e )  {			
            e.printStackTrace();
			traza("Exception en LPFormatosEtiquetas");
			traza(e);
			lanzarPaginaError(e);
	    }
	}

    public void detalle() throws Exception {
		traza("LPFormatosEtiquetas.detalle() - Entrada");		
		pagina("contenido_formatos_etiquetas_insertar"); 
		/*
		 * dmorello, 19/04/2007
		 * Se pasarán directamente los valores que rellenan los combos,
		 * sin realizar ninguna carga ni llamar a los onChange del código JS
		 */
		//cargarComboCentroDistribucion();
		asignarAtributo("VAR", "casoUso", "valor", "detalle");
		asignarAtributo("VAR", "accion", "valor", accion);
		asignarAtributo("VAR", "pais", "valor", pais.toString());
		asignarAtributo("VAR", "idioma", "valor", idioma.toString());

		/* dmorello, 19/04/2007: Las variables hidden se usan para guardar descripciones y no OIDs */
		String oidFormatoEtiqueta = conectorParametroLimpia("oidFormatoEtiqueta", "", true);
		String oidProgramaEtiquetas = conectorParametroLimpia("oidProgramaEtiquetas", "", true);
		String oidCentroDistribucion = conectorParametroLimpia("oidCentroDistribucion", "", true);
		String oidLineaArmado = conectorParametroLimpia("oidLineaArmado", "", true);
		String oidSublineaArmado = conectorParametroLimpia("oidSublineaArmado", "", true);

		traza("******** oidFormatoEtiqueta " + oidFormatoEtiqueta);
		traza("******** oidProgramaEtiquetas " + oidProgramaEtiquetas);
		traza("******** oidCentroDistribucion " + oidCentroDistribucion);
		traza("******** oidLineaArmado " + oidLineaArmado);
		traza("******** oidSublineaArmado " + oidSublineaArmado);

		asignarAtributo("VAR", "oidFormatoEtiqueta", "valor", oidFormatoEtiqueta);
		//asignarAtributo("VAR", "formato", "valor", formato);
		asignarAtributo("VAR", "oidProgramaEtiquetas", "valor", oidProgramaEtiquetas);
		asignarAtributo("VAR", "oidCentroDistribucion", "valor", oidCentroDistribucion);
		asignarAtributo("VAR", "oidLineaArmado", "valor", oidLineaArmado);
		asignarAtributo("VAR", "oidSublineaArmado", "valor", oidSublineaArmado);

		/* Fin dmorello 17/04/2007 */

		traza("LPFormatosEtiquetas.detalle() - Salida");
	}

	public void modificacion() throws Exception {
		traza("LPFormatosEtiquetas.modificacion() - Entrada");
		pagina("contenido_formatos_etiquetas_insertar"); 
		cargarComboCentroDistribucion();
		cargarComboProgramasEtiquetas();
		asignarAtributo("VAR", "casoUso", "valor", "modificacion");
		asignarAtributo("VAR", "accion", "valor", accion);
		asignarAtributo("VAR", "pais", "valor", pais.toString());
		asignarAtributo("VAR", "idioma", "valor", idioma.toString());

		/*
		 * BELC300024733 - dmorello, 17/04/2007
		 * Se pasa a la página el OID del programa de etiquetas
		 */
		String oidFormatoEtiqueta = conectorParametroLimpia("oidFormatoEtiqueta", "", true);
		//String formato = conectorParametroLimpia("formato", "", true);
		String oidProgramaEtiquetas = conectorParametroLimpia("oidProgramaEtiquetas", "", true);
		String oidCentroDistribucion = conectorParametroLimpia("oidCentroDistribucion", "", true);
		String oidLineaArmado = conectorParametroLimpia("oidLineaArmado", "", true);
		String oidSublineaArmado = conectorParametroLimpia("oidSublineaArmado", "", true);

		traza("******** oidFormatoEtiqueta " + oidFormatoEtiqueta);
		traza("******** oidProgramaEtiquetas " + oidProgramaEtiquetas);
		traza("******** oidCentroDistribucion " + oidCentroDistribucion);
		traza("******** oidLineaArmado " + oidLineaArmado);
		traza("******** oidSublineaArmado " + oidSublineaArmado);

		asignarAtributo("VAR", "oidFormatoEtiqueta", "valor", oidFormatoEtiqueta);
		//asignarAtributo("VAR", "formato", "valor", formato);
		asignarAtributo("VAR", "oidProgramaEtiquetas", "valor", oidProgramaEtiquetas);
		asignarAtributo("VAR", "oidCentroDistribucion", "valor", oidCentroDistribucion);
		asignarAtributo("VAR", "oidLineaArmado", "valor", oidLineaArmado);
		asignarAtributo("VAR", "oidSublineaArmado", "valor", oidSublineaArmado);

		/* Fin BELC300024733 dmorello 17/04/2007 */

		traza("LPFormatosEtiquetas.modificacion() - Salida");
	}

	private void cargarComboCentroDistribucion() throws Exception {
		DTOBelcorp dtoe = new DTOBelcorp();
		dtoe.setOidPais(pais);
		dtoe.setOidIdioma(idioma);

		ComposerViewElementList lista = new ComposerViewElementList();
		ComposerViewElement composer1 = new ComposerViewElement();
		composer1.setIDBusiness("APEObtenerDescripcionesCD");
		composer1.setDTOE(dtoe);
		lista.addViewElement(composer1);

		ConectorComposerView conector = new ConectorComposerView(lista,this.getRequest());
		traza("*** Llamando a APEObtenerDescripcionesCD");
		conector.ejecucion();
		DruidaConector con = conector.getConector();
		asignar("COMBO", "cbCentroDistribucion", con, "APEObtenerDescripcionesCD");
	}


	/* Agregado por BELC300024733 - dmorello, 17/04/2007 */
	private void cargarComboProgramasEtiquetas() throws Exception {
		DTOBelcorp dtoe = new DTOBelcorp();
		dtoe.setOidPais(pais);
		dtoe.setOidIdioma(idioma);

		ComposerViewElementList lista = new ComposerViewElementList();
		ComposerViewElement composer1 = new ComposerViewElement();
		composer1.setIDBusiness("APEObtenerProgramasEtiquetas");
		composer1.setDTOE(dtoe);
		lista.addViewElement(composer1);

		ConectorComposerView conector = new ConectorComposerView(lista,this.getRequest());
		traza("*** Llamando a APEObtenerProgramasEtiquetas");
		conector.ejecucion();
		DruidaConector con = conector.getConector();
		asignar("COMBO", "cbFormato", con, "APEObtenerProgramasEtiquetas");
	}

	
    public void cargarPantalla() throws Exception {
		traza("LPFormatosEtiquetas.cargarPantalla() - Entrada");

		if (accion.equals("insertar")) {
			pagina("contenido_formatos_etiquetas_insertar");  
		}
		else {
			pagina("contenido_formatos_etiqueta_modificar");  
		}

		asignarAtributo("VAR", "casoUso", "valor", accion);
		asignarAtributo("VAR", "accion", "valor", accion);
		asignarAtributo("VAR", "pais", "valor", pais.toString());
		asignarAtributo("VAR", "idioma", "valor", idioma.toString());

		this.getFormatosValidaciones();
		cargarComboCentroDistribucion();
		/* BELC300024733 - dmorello, 17/04/2007 */
		if (accion.equals("insertar")) {
			cargarComboProgramasEtiquetas();
		}

		DTOBelcorp dtoe = new DTOBelcorp();
		dtoe.setOidPais(pais);
		dtoe.setOidIdioma(idioma);

		MareBusinessID businessID = new MareBusinessID("APEObtenerCentrosDistribucionXDefecto");
		Vector parametros = new Vector();
		parametros.add(dtoe);
		parametros.add(businessID);
		traza("*** Llamando a APEObtenerCentrosDistribucionXDefecto");
		DruidaConector con2 = conectar("ConectorObtenerCentrosDistribucionXDefecto", parametros);
		DTOOID dtoOid = (DTOOID)con2.objeto("dtoSalida");
		traza("******** dtoOid.getOid() " + dtoOid.getOid());

		if(dtoOid.getOid()!=null) {
			asignarAtributo("VAR", "hidOidDefecto", "valor", dtoOid.getOid().toString());
		}
		else {
			asignarAtributo("VAR", "hidOidDefecto", "valor", "");
		}		

		//Agregado por cvalenzu - 19/01/2007
		//Esta parte no esta en el modelo de componentes, se agrego para poder
		//recuperar el valor por defecto para el combo Linea armado,
		//ya que en la llamada al id de negocio APEObtenerLineasArmadoCD
		//que se ejecuta en la llamada al evento onchange del combo Centro distribucion
		//se pierde la tercer columna que trae la consulta, la que posee el valor por defecto ya que
		//el componente combo solo tiene dos columnas: oid y texto
		Vector param = new Vector();
		param.add(dtoe);
		param.add(new MareBusinessID("APEObtenerValoresDefecto"));

		traza("*** antes de conectar para obtener valores por defecto");
		DruidaConector conector2 = conectar("ConectorObtenerValoresDefecto", param);
		traza("*** despues de conectar para obtener valores por defecto");

		DTOSalida dtoSalida = (DTOSalida)conector2.objeto("DTOSalida");
		RecordSet rs = dtoSalida.getResultado();
		traza("*** rs: " + rs);

		StringBuffer lineasDef = new StringBuffer();

		int size = rs.getRowCount();
		for (int i = 0; i < size; i++) {
			Object combo = rs.getValueAt(i, "COMBO");
			if (ConstantesAPE.LINEA_ARMADO.equals(combo)) {
				lineasDef.append(rs.getValueAt(i, "OID").toString()).append('|');
			}
		}

		int length = lineasDef.length();
		if (length > 0) {
			lineasDef.delete(length-1, length);
		}
		asignar("VAR", "hOidsLineasArmadoDefecto", lineasDef.toString());
		//FIN - Agregado por cvalenzu - 19/01/2007

		traza("LPFormatosEtiquetas.cargarPantalla() - Salida");
	}

    public void guardar() throws Exception {
		traza("LPFormatosEtiquetas.guardar() - Entrada");
		pagina("salidaGenerica");
		
		/*
		 * BELC300024733 - dmorello, 18/04/2007
		 * Se reemplaza el textbox "formato" por el combo "cbFormato"
		 */
		String oidFormatoEtiqueta = conectorParametroLimpia("oidFormatoEtiqueta", "", true);
		String oidCentroDistribucion = conectorParametroLimpia("oidCentroDistribucion", "", true);
		String oidLineaArmado = conectorParametroLimpia("oidLineaArmado", "", true);
		String oidSublineaArmado = conectorParametroLimpia("oidSublineaArmado", "", true);
		//String formato = conectorParametroLimpia("formato", "", true);
		String oidProgramaEtiqueta = conectorParametroLimpia("oidProgramaEtiquetas", "", true);

		traza("***** oidFormatoEtiqueta " + oidFormatoEtiqueta);
		traza("***** oidCentroDistribucion " + oidCentroDistribucion);
		traza("***** oidLineaArmado " + oidLineaArmado);
		traza("***** oidSublineaArmado " + oidSublineaArmado);
		//traza("***** formato " + formato);
		traza("***** programa " + oidProgramaEtiqueta);

		DTODatosEtiqueta dtoe = new DTODatosEtiqueta();
		
		if(!oidFormatoEtiqueta.equals("")) {
			dtoe.setOidFormatoEtiqueta(new Long(oidFormatoEtiqueta));
		}

		dtoe.setOidCentroDistribucion(new Long(oidCentroDistribucion));
		dtoe.setOidLineaArmado(new Long(oidLineaArmado));
		dtoe.setOidSublineaArmado(new Long(oidSublineaArmado));
		//dtoe.setFormato(formato);
		dtoe.setOidProgramaEtiqueta(new Long(oidProgramaEtiqueta));
		/* Fin BELC300024733 dmorello 18/04/2007 */
		dtoe.setOidPais(pais);
		dtoe.setOidIdioma(idioma);
  	    MareBusinessID businessID = new MareBusinessID("APEInsertarFormatoEtiqueta");
		Vector parametros = new Vector();
		parametros.add(dtoe);
		parametros.add(businessID);

		try {
	        traza("******************* Antes de conectar");
			DruidaConector con = conectar("ConectorInsertarFormatosEtiquetas", parametros);
			traza("******************* Despues de conectar");
		    asignarAtributo("VAR","ejecutar","valor","fGuardarOK()");        
		}
		catch(Exception e) {
			traza("******************* Entrando al catch...");
			asignarAtributo("VAR", "ejecutarError", "valor", "fGuardarERR()");  
			throw e;
		}

		traza("LPFormatosEtiquetas.guardar() - Salida");
	}

	private void cargarMenuSecundario() throws Exception {     
		traza("LPFormatosEtiquetas.cargarMenuSecundario() - Entrada");		
		if(accion.equals("insertar")) {
			getConfiguracionMenu("LPFormatosEtiquetas","insertar");
		    asignarAtributoPagina("cod","01061");
		}	
		else if(accion.equals("consultar") || accion.equals("detalle")) {
			getConfiguracionMenu("LPFormatosEtiquetas","consultar");
		    asignarAtributoPagina("cod","01062");
		}	
		else if(accion.equals("modificar") || accion.equals("modificacion")) {
			getConfiguracionMenu("LPFormatosEtiquetas","modificar");
		    asignarAtributoPagina("cod","01063");
		}	
		else if(accion.equals("eliminar")) {
			getConfiguracionMenu("LPFormatosEtiquetas","eliminar");
		    asignarAtributoPagina("cod","01064");
		}			
		traza("LPFormatosEtiquetas.cargarMenuSecundario() - Salida");
	}
}