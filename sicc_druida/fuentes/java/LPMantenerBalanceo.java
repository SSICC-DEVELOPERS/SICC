import es.indra.druida.DruidaConector;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.DTOSalida;
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
import es.indra.sicc.dtos.ape.DTOBalanceoLinea;
import es.indra.sicc.dtos.ape.DTOPorcentajeSublinea;
import es.indra.sicc.dtos.ape.DTOMantenerAsignacionProductosAnaqueles;
import es.indra.sicc.dtos.ape.DTOZonasEvaluarCarga;
import es.indra.sicc.dtos.ape.DTOSublineaEvaluarCarga;
import es.indra.sicc.dtos.ape.DTOSublineasLineaOrdenacion;

public class LPMantenerBalanceo extends LPSICCBase {	

    public LPMantenerBalanceo () { super(); }

	private String opcionMenu = null;
	private String accion = null;
	private Long pais = null;     
	private Long idioma = null;

	public void inicio() throws Exception { }
  
    public void ejecucion() throws Exception {
		setTrazaFichero();
		traza("LPMantenerBalanceo.ejecucion() - Entrada");

     	opcionMenu = conectorParametroLimpia("opcionMenu", "", true);
     	accion = conectorParametroLimpia("accion", "", true);
	    pais = UtilidadesSession.getPais(this);
		idioma = UtilidadesSession.getIdioma(this);

		traza("**** opcionMenu : " + opcionMenu);
		traza("**** accion : " + accion);
		traza("**** pais : " + pais);
		traza("**** idioma : " + idioma);
	    
		try  {			
			if (accion.equals("") && opcionMenu.equals("ejecutar")) {
				pagina("contenido_balanceo_ejecutar");
				getFormatosValidaciones();
				cargarCombos(); 
			}
			else if(accion.equals("aceptar")) {
				recuperarSublineas();
			}	
			else if(accion.equals("ejecutar")) {
				ejecutarBalanceo();
			}			
			else if(accion.equals("evaluarCarga")) {
				evaluarCarga();
			}		
      /* vbongiov -- BELC400000598 -- 25/07/2007
			else if(accion.equals("nuevaVersion")) {
				pagina("contenido_version_ejecutar_balanceo");      		
        asignarAtributoPagina("cod", "0569");      
				getFormatosValidaciones();
				
				String casoDeUso = conectorParametroLimpia("casoDeUso", "", true);
				String oidMapaCentroDistribucion = conectorParametroLimpia("oidMapaCentroDistribucion", "", true);
				String oidMapaZona = conectorParametroLimpia("oidMapaZona", "", true);
				String oidPeriodo = conectorParametroLimpia("oidPeriodo", "", true);

				traza("**** casoDeUso : " + casoDeUso);
				traza("**** oidMapaCentroDistribucion : " + oidMapaCentroDistribucion);
				traza("**** oidMapaZona : " + oidMapaZona);
				traza("**** oidPeriodo : " + oidPeriodo);
				
				asignarAtributo("VAR","oidIdioma","valor", idioma.toString());
				asignarAtributo("VAR","oidPais","valor",  pais.toString());
				asignarAtributo("VAR","casoDeUso","valor", casoDeUso);				
				asignarAtributo("VAR","hOidMapaCentroDistribucion","valor", oidMapaCentroDistribucion);
				asignarAtributo("VAR","hOidMapaZona","valor",  oidMapaZona);
				asignarAtributo("VAR","hOidPeriodo","valor", oidPeriodo);
			}	*/
			else if(accion.equals("validarNuevaVersion")) {
				validarNuevaVersion();
			}			

			cargarMenuSecundario();
			traza("LPMantenerBalanceo.ejecucion() - Salida");
		}
		catch ( Exception e )  {			
            e.printStackTrace();
			traza("Exception en LPMantenerBalanceo");
			traza(e);
			lanzarPaginaError(e);
	    }
	}

	public void evaluarCarga() throws Exception {
		traza("LPMantenerBalanceo.evaluarCarga() - Entrada");
		pagina("contenido_carga_evaluar");
		getFormatosValidaciones();
		asignarAtributo("VAR", "hFormatoDef", "valor", (new Integer(this.FORMATO_DEFAULT)).toString());

		String separadorDecimales = UtilidadesSession.getSeparadorDecimales(this);
		String separadorMiles = ",";
		if (separadorDecimales.equals(",")) {
			separadorMiles = ".";
		}	

		asignar("VAR","hid_SeparadorMiles", separadorMiles);
		asignar("VAR","hid_NumeroDecimales", UtilidadesSession.getFormatoNumerico(this));
		asignar("VAR","hid_SeparadorDecimales", separadorDecimales);


		DTOBalanceoLinea dtoBalanceo = (DTOBalanceoLinea)this.getSessionCache().get("DTOBalanceoLinea");
		traza("********* DTOBalanceoLinea (de sesion) " + dtoBalanceo);

		//Datos hardcodeados para probar
        //ArrayList cargaSublineasTemp = new ArrayList();
		//DTOBalanceoLinea dtoBalanceo = new DTOBalanceoLinea();

		//Sublinea1 **********************************************
		/*DTOSublineaEvaluarCarga sublinea1 = new DTOSublineaEvaluarCarga();
        sublinea1.setOidSublinea(new Long(1));
        sublinea1.setDescripcion(new String("sublinea1"));
        sublinea1.setErrorPromedio(new Float(1.1));
		sublinea1.setUnidadesPromedio(new Float(2.2));
		ArrayList zonas1 = new ArrayList(); 

		DTOZonasEvaluarCarga dtoZonas1 = new DTOZonasEvaluarCarga();
        dtoZonas1.setIdZona(new Long(4));
        dtoZonas1.setUnidadesAsignadas(new Long(40));
        dtoZonas1.setPorcentaje(new Float(40));          

		DTOZonasEvaluarCarga dtoZonas2 = new DTOZonasEvaluarCarga();
        dtoZonas2.setIdZona(new Long(5));
        dtoZonas2.setUnidadesAsignadas(new Long(50));	
        dtoZonas2.setPorcentaje(new Float(50));    
		
		zonas1.add(dtoZonas1);
		zonas1.add(dtoZonas2);*/

		//sublinea1.setZonas(zonas1);
		
		//Sublinea2 **********************************************
		/*DTOSublineaEvaluarCarga sublinea2 = new DTOSublineaEvaluarCarga();
        sublinea2.setOidSublinea(new Long(2));
        sublinea2.setDescripcion(new String("sublinea2"));
        sublinea2.setErrorPromedio(new Float(3.3));
		sublinea2.setUnidadesPromedio(new Float(4.4));
		ArrayList zonas2 = new ArrayList();      

		DTOZonasEvaluarCarga dtoZonas3 = new DTOZonasEvaluarCarga();
        dtoZonas3.setIdZona(new Long(6));
        dtoZonas3.setUnidadesAsignadas(new Long(60));
        dtoZonas3.setPorcentaje(new Float(60));          

		DTOZonasEvaluarCarga dtoZonas4 = new DTOZonasEvaluarCarga();
        dtoZonas4.setIdZona(new Long(7));
        dtoZonas4.setUnidadesAsignadas(new Long(70));	
        dtoZonas4.setPorcentaje(new Float(70));    
		
		zonas2.add(dtoZonas3);
		zonas2.add(dtoZonas4);

		sublinea2.setZonas(zonas2);	
		cargaSublineasTemp.add(sublinea1);
		cargaSublineasTemp.add(sublinea2);
		
		dtoBalanceo.setLstCargaSublineas(cargaSublineasTemp);*/
		//FIN - Datos hardcodeados para probar
		//traza("********** DTOBalanceoLinea " + dtoBalanceo);

		ArrayList cargaSublineas = dtoBalanceo.getLstCargaSublineas();
		int cant = cargaSublineas.size();
		traza("********** cant " + cant);

		String lstSublineas = new String();	
		for(int i=0; i<cant; i++) {
			StringBuffer strFila = new StringBuffer();
			DTOSublineaEvaluarCarga dto = (DTOSublineaEvaluarCarga)cargaSublineas.get(i);
			Long oidSublinea = dto.getOidSublinea();
			String descripcion  = dto.getDescripcion();

			if(oidSublinea!=null){
				strFila.append(oidSublinea.toString());
			}
			else {
				strFila.append(" ");
			}

			strFila.append("$");

			if(descripcion!=null){
				strFila.append(descripcion.toString());
			}
			else {
				strFila.append(" ");
			}

			if(i==0) {
				lstSublineas = lstSublineas + strFila.toString();
			}
			else {
				lstSublineas = lstSublineas + "|" + strFila.toString();
			}
		}
		//Este cadena es para cargar el combo sublinea de la modal evaluar carga
		traza("********** asignando lstSublineas");
		traza("********** lstSublineas " + lstSublineas);
		asignarAtributo("VAR","lstSublineas","valor", lstSublineas);

		//*********************************************************************

		String lstCargaSublineas = new String();	
		for(int i=0; i<cant; i++) {
			StringBuffer strFila = new StringBuffer();
			DTOSublineaEvaluarCarga dto = (DTOSublineaEvaluarCarga)cargaSublineas.get(i);

			Long oidSublinea = dto.getOidSublinea();
			String descripcion = dto.getDescripcion();
			Float errorPromedio = dto.getErrorPromedio();
			Float unidadesPromedio = dto.getUnidadesPromedio();

			if(oidSublinea!=null){
				strFila.append(oidSublinea.toString());
			}
			else {
				strFila.append(" ");
			}

			strFila.append("$");

			if(descripcion!=null){
				strFila.append(descripcion.toString());
			}
			else {
				strFila.append(" ");
			}

			strFila.append("$");

			if(errorPromedio!=null){
				traza("********** errorPromedio " + errorPromedio);
				String errorPromedioTemp = UtilidadesBelcorp.formateaNumeroSICC(errorPromedio.toString(), 
				this.FORMATO_DEFAULT, this);
				traza("********** errorPromedioTemp " + errorPromedioTemp);
				strFila.append(errorPromedioTemp);
			}
			else {
				strFila.append(" ");
			}

			strFila.append("$");

			if(unidadesPromedio!=null){
				traza("********** unidadesPromedio " + unidadesPromedio);
				String unidadesPromedioTemp = UtilidadesBelcorp.formateaNumeroSICC(unidadesPromedio.toString(), 
				this.FORMATO_DEFAULT, this);
				traza("********** unidadesPromedioTemp " + unidadesPromedioTemp);
				strFila.append(unidadesPromedioTemp);
			}
			else {
				strFila.append(" ");
			}

			strFila.append("$");

			ArrayList zonas = dto.getZonas();
			int cantZonas = zonas.size();
			String strZonas = new String();	

			for(int j=0; j<cantZonas; j++) {
				StringBuffer strFila2doNivel = new StringBuffer();

				DTOZonasEvaluarCarga dtoTemp = (DTOZonasEvaluarCarga)zonas.get(j);
				Long idZona = dtoTemp.getIdZona();
				Long unidadesAsignadas = dtoTemp.getUnidadesAsignadas();
				Float porcentaje = dtoTemp.getPorcentaje();			

				if(idZona!=null){
					strFila2doNivel.append(idZona.toString());
				}
				else {
					strFila2doNivel.append(" ");
				}

				strFila2doNivel.append("?");

				if(unidadesAsignadas!=null){
					strFila2doNivel.append(unidadesAsignadas);
				}
				else {
					strFila2doNivel.append(" ");
				}

				strFila2doNivel.append("?");

				if(porcentaje!=null){
					traza("********** porcentaje " + porcentaje);
					String porcentajeTemp = UtilidadesBelcorp.formateaNumeroSICC(porcentaje.toString(), 
					this.FORMATO_DEFAULT, this);
					traza("********** porcentajeTemp " + porcentajeTemp);
					strFila2doNivel.append(porcentajeTemp);
				}
				else {
					strFila2doNivel.append(" ");
				}

				if(j==0) {
					strZonas = strZonas + strFila2doNivel.toString();
				}
				else {
					strZonas = strZonas + "+" + strFila2doNivel.toString();
				}
			}

			if(!strZonas.equals("")){
				strFila.append(strZonas.toString());
			}
			else {
				strFila.append("null");
			}

			if(i==0) {
				lstCargaSublineas = lstCargaSublineas + strFila.toString();
			}
			else {
				lstCargaSublineas = lstCargaSublineas + "|" + strFila.toString();
			}
		}
		//Este cadena es para la carga de datos en la modal evaluar carga
		traza("********** asignando lstCargaSublineas");
		traza("********** lstCargaSublineas " + lstCargaSublineas);
		asignarAtributo("VAR","lstCargaSublineas","valor", lstCargaSublineas);

		asignarAtributo("VAR","oidIdioma","valor", idioma.toString());
		asignarAtributo("VAR","oidPais","valor",  pais.toString());
		traza("LPMantenerBalanceo.evaluarCarga() - Salida");
	}    

	public void cargarCombos() throws Exception {
		traza("LPMantenerBalanceo.cargarCombos() - Entrada");

		DTOBelcorp dtoe = new DTOBelcorp();
		dtoe.setOidPais(pais);
		dtoe.setOidIdioma(idioma);

		ComposerViewElementList lista = new ComposerViewElementList();
		ComposerViewElement composer1 = new ComposerViewElement();
		ComposerViewElement composer2 = new ComposerViewElement();
		ComposerViewElement composer3 = new ComposerViewElement();
		ComposerViewElement composer4 = new ComposerViewElement();
		ComposerViewElement composer5 = new ComposerViewElement();

		composer1.setIDBusiness("APEObtenerDescripcionesCD");
		composer1.setDTOE(dtoe);
		lista.addViewElement(composer1);
		composer2.setIDBusiness("SEGObtenerMarcasSinFiltro");
		composer2.setDTOE(dtoe);
		lista.addViewElement(composer2);
		composer3.setIDBusiness("SEGObtenerCanalesSinFiltro");
		composer3.setDTOE(dtoe);
		lista.addViewElement(composer3);
		composer4.setIDBusiness("APEObtenerFuentesPeriodoPreasignacion");
		composer4.setDTOE(dtoe);
		lista.addViewElement(composer4);
		composer5.setIDBusiness("APEObtenerOrdenacionProductos");
		composer5.setDTOE(dtoe);
		lista.addViewElement(composer5);

		ConectorComposerView conector = new ConectorComposerView(lista,this.getRequest());

		traza("*********** Antes de llamar a ejecucion");
		conector.ejecucion();
	    traza("*********** Despues de llamar a ejecucion");

		DruidaConector con = conector.getConector();

		asignar("COMBO", "comboCentro", con, "APEObtenerDescripcionesCD");
		asignar("COMBO", "comboMarca", con, "SEGObtenerMarcasSinFiltro");
		asignar("COMBO", "comboCanal", con, "SEGObtenerCanalesSinFiltro");
		asignar("COMBO", "comboOrigenDatos", con, "APEObtenerFuentesPeriodoPreasignacion");
		asignar("COMBO", "comboOrdenacionProductos", con, "APEObtenerOrdenacionProductos");
		obtenerValoresDefecto();

		asignarAtributo("VAR", "opcionMenu", "valor",opcionMenu);
		asignarAtributo("VAR", "accion", "valor", accion);
		asignarAtributo("VAR", "pais", "valor", pais.toString());
		asignarAtributo("VAR", "idioma", "valor", idioma.toString());

		traza("LPMantenerBalanceo.cargarCombos() - Salida");
	}    

	private void obtenerValoresDefecto() throws Exception {
		traza("LPMantenerBalanceo.obtenerValoresDefecto() - Entrada");
		DTOBelcorp dtoBelcorp = new DTOBelcorp();
        dtoBelcorp.setOidIdioma(idioma);
        dtoBelcorp.setOidPais(pais);

		Vector parametros = new Vector();
		parametros.add(dtoBelcorp);
		parametros.add(new MareBusinessID("APEObtenerValoresDefecto"));

		traza("*** antes de conectar para obtener valores por defecto");
		DruidaConector conector2 = conectar("ConectorObtenerValoresDefecto", parametros);
		traza("*** despues de conectar para obtener valores por defecto");

		DTOSalida dtoSalida = (DTOSalida)conector2.objeto("DTOSalida");
		RecordSet rs = dtoSalida.getResultado();
		traza("*** rs: " + rs);

		StringBuffer lineasDef = new StringBuffer();
		int size = rs.getRowCount();
		for (int i = 0; i < size; i++) {
			Object combo = rs.getValueAt(i, "COMBO");
			if (ConstantesAPE.CONFIGURACION_CD.equals(combo)) {
				asignar("VAR", "hOidCentroDistribucionDefecto", rs.getValueAt(i, "OID").toString());
			} else if (ConstantesAPE.LINEA_ARMADO.equals(combo)) {
				lineasDef.append(rs.getValueAt(i, "OID").toString()).append('|');
			}
		}

		int length = lineasDef.length();
		if (length > 0) {
			lineasDef.delete(length-1, length);
		}
		asignar("VAR", "hOidsLineasArmadoDefecto", lineasDef.toString());
		traza("LPMantenerBalanceo.obtenerValoresDefecto() - Salida");
	}

	public void ejecutarBalanceo() throws Exception {
		traza("LPMantenerBalanceo.ejecutarBalanceo() - Entrada");
		pagina("salidaGenerica");

		String oidCentroDistribucion = conectorParametroLimpia("oidCentroDistribucion", "", true);
		String oidLineaArmado = conectorParametroLimpia("oidLineaArmado", "", true);
		String oidMapaCentroDistribucion = conectorParametroLimpia("oidMapaCentroDistribucion", "", true);
		String oidOrdenAnaqueles = conectorParametroLimpia("oidOrdenAnaqueles", "", true);
		String oidPeriodo = conectorParametroLimpia("oidPeriodo", "", true);
		String oidAsignacionProductosAnaqueles = conectorParametroLimpia("oidAsignacionProductosAnaqueles", "", true);
		String oidOrigenDatos = conectorParametroLimpia("oidOrigenDatos", "", true);
		String oidOrdenacionProductos = conectorParametroLimpia("oidOrdenacionProductos", "", true);
		String version = conectorParametroLimpia("version", "", true);
		String lstPorcentajeSublineas = conectorParametroLimpia("lstPorcentajeSublineas", "", true);

		traza("***** oidCentroDistribucion " + oidCentroDistribucion);
		traza("***** oidLineaArmado " + oidLineaArmado);
		traza("***** oidMapaCentroDistribucion " + oidMapaCentroDistribucion);
		traza("***** oidOrdenAnaqueles " + oidOrdenAnaqueles);
		traza("***** oidPeriodo " + oidPeriodo);
		traza("***** oidAsignacionProductosAnaqueles " + oidAsignacionProductosAnaqueles);
		traza("***** oidOrigenDatos " + oidOrigenDatos);
		traza("***** oidOrdenacionProductos " + oidOrdenacionProductos);
		traza("***** version " + version);
		traza("***** lstPorcentajeSublineas " + lstPorcentajeSublineas);
		
		ArrayList arrayListPorcentajeSublineas = obtenerListaPorcentajeSublineas(lstPorcentajeSublineas);
		
		DTOBalanceoLinea dto = new DTOBalanceoLinea();
		dto.setOidCentroDistribucion(new Long(oidCentroDistribucion));
		dto.setOidLineaArmado(new Long(oidLineaArmado));
		dto.setOidMapaCentroDistribucion(new Long(oidMapaCentroDistribucion));
		dto.setOidOrdenAnaqueles(new Long(oidOrdenAnaqueles));
		dto.setOidPeriodo(new Long(oidPeriodo));
		dto.setOidAsignacionProductosAnaqueles(new Long(oidAsignacionProductosAnaqueles));
		dto.setOidOrigenDatos(oidOrigenDatos);
		dto.setOidOrdenacionProductos(new Long(oidOrdenacionProductos));
		dto.setVersion(version);
		dto.setLstPorcentajeSublineas(arrayListPorcentajeSublineas);
		dto.setOidIdioma(idioma);
		dto.setOidPais(pais);

		MareBusinessID businessID = new MareBusinessID("APEEjecutarBalanceo");
		Vector parametros = new Vector();
		parametros.add(dto);
		parametros.add(businessID);

		try {
	        traza("******************* Antes de conectar");
			DruidaConector con = conectar("ConectorEjecutarBalanceo", parametros);
	        traza("******************* Despues de conectar");
			DTOBalanceoLinea dtoRespuesta = (DTOBalanceoLinea)con.objeto("dtoSalida");			
			traza("********  DTOBalanceoLinea (se sube a sesion) " + dtoRespuesta);

			//Se deja el DTOBalanceoLinea recibido en sesion para poder 
			//usarlo al levantar la modal "Evaluar carga"
			this.getSessionCache().put("DTOBalanceoLinea", dtoRespuesta);
			
  		    String codigoError = new String();
			if(dtoRespuesta.getCodigoError()!=null) {
				codigoError = dtoRespuesta.getCodigoError();
			}
	        traza("******************* codigoError: " + codigoError);

			traza("******************* Despues de conectar");
			asignarAtributo("VAR","ejecutar","valor","ejecutarBalanceoOK('" + codigoError + "')");
		}
		catch(Exception e) {
			traza("******************* Entrando al catch...");
			asignarAtributo("VAR", "ejecutarError", "valor", "ejecutarBalanceoERR()");  
			throw e;
		}

		traza("LPMantenerBalanceo.ejecutarBalanceo() - Salida");
	}    

	private ArrayList obtenerListaPorcentajeSublineas(String valores) throws Exception{
		traza("LPMantenerBalanceo.obtenerListaPorcentajeSublineas() - Entrada");
		traza("**************** valores " + valores);

		ArrayList lista = new ArrayList();
		StringTokenizer stFilas = new StringTokenizer(valores,"&");
		StringTokenizer stCampos;
		
        while (stFilas.hasMoreTokens()){
			String fila = stFilas.nextToken();
			stCampos = new StringTokenizer(fila, "|");

            String oid = stCampos.nextToken();
            String porcentaje = stCampos.nextToken();

			traza("**************** oid " + oid);
			traza("**************** porcentaje " + porcentaje);

			DTOPorcentajeSublinea dto = new DTOPorcentajeSublinea();
			dto.setOidSublinea(new Long(oid));
			dto.setPorcentaje(new Float(porcentaje));
			
			lista.add(dto);		
		}

		traza("LPMantenerBalanceo.obtenerListaPorcentajeSublineas() - Salida");
		return lista;
	}

	public void validarNuevaVersion() throws Exception {
		traza("LPMantenerBalanceo.validarNuevaVersion() - Entrada");
		pagina("salidaGenerica");

		String version = conectorParametroLimpia("txtVersion", "", true);
		String oidMapaCentroDistribucion = conectorParametroLimpia("hOidMapaCentroDistribucion", "", true);
		String oidMapaZona = conectorParametroLimpia("hOidMapaZona", "", true);
		String oidPeriodo = conectorParametroLimpia("hOidPeriodo", "", true);

		traza("***** version " + version);
		traza("***** oidMapaCentroDistribucion " + oidMapaCentroDistribucion);
		traza("***** oidMapaZona " + oidMapaZona);
		traza("***** oidPeriodo " + oidPeriodo);

		DTOMantenerAsignacionProductosAnaqueles dto = new DTOMantenerAsignacionProductosAnaqueles();
		dto.setVersion(version);
		dto.setOidMapaCentroDistribucion(new Long(oidMapaCentroDistribucion));
		dto.setOidMapaZona(new Long(oidMapaZona));
		dto.setOidPeriodo(new Long(oidPeriodo));

		MareBusinessID businessID = new MareBusinessID("APEValidarNuevaVersionAsignacion");
		Vector parametros = new Vector();
		parametros.add(dto);
		parametros.add(businessID);

		try {
	        traza("******************* Antes de conectar");
			DruidaConector con = conectar("ConectorValidarNuevaVersionAsignacion", parametros);

			DTOOID dtoRespuesta = (DTOOID)con.objeto("DTOOID");			
			traza("********  DTOOID " + dtoRespuesta);
			traza("******************* Despues de conectar");
			String oid = new String();
			if(dtoRespuesta.getOid()!=null) {
				oid = dtoRespuesta.getOid().toString();
			}

			traza("******************* oid: " + oid);

		    asignarAtributo("VAR","ejecutar","valor","ejecutarOK('" + oid + 
															  "','" + version + "')");        
		}
		catch(Exception e) {
			traza("******************* Entrando al catch...");
			asignarAtributo("VAR", "ejecutarError", "valor", "ejecutarERR()");  
			throw e;
		}

		traza("LPMantenerBalanceo.validarNuevaVersion() - Salida");
	}    

	public void recuperarSublineas() throws Exception {
		traza("LPMantenerBalanceo.recuperarSublineas() - Entrada");				
		pagina("salidaGenerica");
		String oidLineaArmado = conectorParametroLimpia("oidLineaArmado", "", true);
    String oidOrdenAnaquelCab = conectorParametroLimpia("comboOrdenAnaqueles", "", true);
		traza("***** oidLineaArmado " + oidLineaArmado);
		DTOSublineasLineaOrdenacion dto = new DTOSublineasLineaOrdenacion();
		dto.setOidLinea(new Long(oidLineaArmado));
    dto.setOidOrdenAnaquelCab(new Long(oidOrdenAnaquelCab));
		dto.setOidIdioma(idioma);

		MareBusinessID businessID = new MareBusinessID("APERecuperarSublineasLineaBalanceo");
		Vector parametros = new Vector();
		parametros.add(dto);
		parametros.add(businessID);

		try {
	        traza("******************* Antes de conectar");
			DruidaConector con = conectar("ConectorRecuperarSublineasLinea", parametros);
			traza("******************* Despues de conectar");
			DTOSalida dtoSalida = (DTOSalida)con.objeto("dtoSalida");			
			traza("********  DTOSalida " + dtoSalida);

			String cadena = transformarRecordSetToString(dtoSalida.getResultado());
		    asignarAtributo("VAR","ejecutar","valor","recuperarSublineasOK('" + cadena + "')");        
		}
		catch(Exception e) {
			traza("******************* Entrando al catch...");
			asignarAtributo("VAR", "ejecutarError", "valor", "recuperarSublineasERR()");  
			throw e;
		}

		traza("LPMantenerBalanceo.recuperarSublineas() - Salida");		
	}

	private String transformarRecordSetToString(RecordSet rs) throws Exception  {
		String cadena = "";
		for(int i=0; i<rs.getRowCount() ;i++){
 			String oidTemp = rs.getValueAt(i,"OID_SUBL_ARMA").toString();
			String desTemp = rs.getValueAt(i,"VAL_I18N").toString();
			String porTemp = " ";
			
			if(i==0) {
				cadena = cadena + oidTemp + "," + desTemp + "," + porTemp;
			}
			else {
				cadena = cadena + "|" +oidTemp + "," + desTemp + "," + porTemp;
			}					
		}
		traza("*************** cadena " + cadena);
		return cadena;
 	}
	
	private void cargarMenuSecundario() throws Exception {     
		traza("LPMantenerBalanceo.cargarMenuSecundario() - Entrada");		

		if(accion.equals("")) {
			getConfiguracionMenu("LPMantenerBalanceo","");
			asignarAtributoPagina("cod","0569");
		}
		else if(accion.equals("nuevaVersion")) {
			getConfiguracionMenu("LPPreasignarProductos","nuevaVersion");
			asignarAtributoPagina("cod","0968");
		}		
		else if(accion.equals("evaluarCarga")) {
			getConfiguracionMenu("LPMantenerBalanceo","evaluarCarga");
			asignarAtributoPagina("cod","0570");
		}		

		traza("LPMantenerBalanceo.cargarMenuSecundario() - Salida");
	}
}
