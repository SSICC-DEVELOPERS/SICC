//import LPSICCBase;

import es.indra.sicc.dtos.msg.DTOPatron;
import es.indra.sicc.dtos.msg.DTOSeccion;
import es.indra.sicc.dtos.msg.DTOMensajeSeccion;
import es.indra.sicc.dtos.msg.ConstantesMSG;

import es.indra.sicc.dtos.pre.ConstantesPRE;

import es.indra.mare.common.mln.MareBusinessID;

import es.indra.druida.DruidaConector;

import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;

import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.UtilidadesSession;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;
import java.util.StringTokenizer;

import es.indra.sicc.cmn.ListaEditableDinamica;
import es.indra.sicc.util.xml.XMLDocument;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


import es.indra.mare.common.mii.services.jdbcservice.RecordSet;


public class LPMantenimientoPatrones extends LPSICCBase {
    static final int PATRON_HEADER_HEIGHT = 120;
    static final int SIN_ESPECIFICAR = -1;

	private String accion;
	private String opcionMenu;
	private String oidPatron;
	private String codigoPatron;
	private String descripcionPatron;
	private String oidFormulario;
	private String oidMedioEnvio;
	private String activo;
	private String patronPeriodo;
	private String oidPatronOrigen;
	private String oidPeriodo;
	private String oidPatronPeriodo;
	private String codigoCopiarPatron;
	private String copiarPatron;
	private Long pais;
	private Long idioma;
    private Document doc = null;
    private XMLDocument xml = null;
    private Integer yLista;

	public LPMantenimientoPatrones() {
		super();
	}	

	public void inicio() throws Exception {
		traza("Asignar pagina = PGDatosPatron");
		pagina("contenido_patron_crear");
	}

	public void ejecucion() throws Exception {
		setTrazaFichero();
		try  {
			//rastreo();
			pais = UtilidadesSession.getPais(this);
			idioma = UtilidadesSession.getIdioma(this);
			

			accion = conectorParametroLimpia( "accion", "", true );
			opcionMenu = conectorParametroLimpia( "opcionMenu", "", true );

			traza("Recibe los parámetros:  ");
			traza("OpcionMenu: " + opcionMenu);              
			traza("Accion: " + accion);
			traza("Pais: " + pais);
			traza("Idioma: " + idioma);

			if (accion.equals(""))  {
				inicializar();
			} else if (accion.equals("Cargar pagina PGAsignarPeriodo"))  {
				cargarPaginaAsignarPeriodo(); 
			} else if (accion.equals("Guardar patron"))  {
				guardarPatron();
			} else if (accion.equals("Eliminar seccion"))  {
				eliminarSeccion();
			} else if (accion.equals("Guardar patron por periodo"))  {
				guardarPatronPorPeriodo();
			} else if (accion.equals("Mostrar lista patrones"))  {
				mostrarListaPatrones();
			} else if (accion.equals("Copiar patron"))  {
				copiarPatron();
			} else if (accion.equals("Modificar patron"))  {
				modificarPatron();
			} else if (accion.equals("Buscar patrones"))  {
				buscarPatrones();
			} else if (accion.equals("Mostrar detalle patron"))  {
				mostrarDetallePatron();
			}

			asignarAtributo("VAR","opcionMenu","valor",opcionMenu);
			asignarAtributo("VAR","accion","valor",accion);

			if (opcionMenu.equals("Crear patron"))
				asignarAtributoPagina("cod","0248");
			else if (opcionMenu.equals("Modificar patron"))
				asignarAtributoPagina("cod","0275");
			else if (opcionMenu.equals("Eliminar patron"))
				asignarAtributoPagina("cod","0251");
			else if (opcionMenu.equals("Consultar patron"))
				asignarAtributoPagina("cod","0238");
			

			String accionMenu = null;
			//if (opcionMenu.equals("Crear patron")) {
			//	accionMenu = (accion + "" + "CrearPatron").trim();
			//} else {
				accionMenu = (accion + " " + opcionMenu).trim();
			//}
			traza("Esta es la accion que se le pasa para el menu sendario: *" + accionMenu + "*");

			getConfiguracionMenu("LPMantenimientoPatrones", accionMenu);
		} catch ( Exception e )  {
			e.printStackTrace();     
			lanzarPaginaError(e);
		}	
	}

	public void inicializar() throws Exception{
		traza("Entro a inicializar()");
		codigoCopiarPatron = ConstantesMSG.COPIAR_PATRON;
		copiarPatron = new String("False");

		if (opcionMenu.equals("Crear patron"))  {
			asignarAtributo("VAR","hCopiarPatronHabilitado","valor","true");
			asignarAtributo("VAR","hVerPatronHabilitado","valor","false");
			asignarAtributo("VAR","hAnadirSeccionHabilitado","valor","true");
			asignarAtributo("VAR","hModificarSeccionHabilitado","valor","false");
			asignarAtributo("VAR","hEliminarSeccionHabilitado","valor","false");
			cargarPaginaDatosPatron();
		} else if (opcionMenu.equals("Modificar patron"))  {
			//Asigna la pagina PGBuscarPatrones 
			pagina("contenido_patron_modificar");
			cargarPaginaBuscarPatrones();
			asignarAtributo("VAR","hBuscarHabilitado","valor","true");
			asignarAtributo("VAR","hListaResultadosOculta","valor","true");
			asignarAtributo("VAR","hDetalleOculto","valor","true");
			asignarAtributo("VAR","hTipoPeriodoHabilitado","valor","false");
			asignarAtributo("VAR","hPeriodoCorporativoHabilitado","valor","false");
		} else if (opcionMenu.equals("Eliminar patron"))  {
			pagina("contenido_patron_modificar");
			cargarPaginaBuscarPatrones();
			asignarAtributo("VAR","hBuscarHabilitado","valor","true");
			asignarAtributo("VAR","hListaResultadosOculta","valor","true");
			asignarAtributo("VAR","hModificarOculto","valor","true");
			asignarAtributo("VAR","hTipoPeriodoHabilitado","valor","false");
			asignarAtributo("VAR","hPeriodoCorporativoHabilitado","valor","false");
		} else if (opcionMenu.equals("Consultar patron"))  {
			pagina("contenido_patron_modificar");
			cargarPaginaBuscarPatrones();
			asignarAtributo("VAR","hBuscarHabilitado","valor","true");
			asignarAtributo("VAR","hListaResultadosOculta","valor","true");
			asignarAtributo("VAR","hModificarOculto","valor","true");
			asignarAtributo("VAR","hTipoPeriodoHabilitado","valor","false");
			asignarAtributo("VAR","hPeriodoCorporativoHabilitado","valor","false");
		}		
		traza("Salio de inicializar()");
	}

	public void cargarPaginaAsignarPeriodo() throws Exception{
		String patr = conectorParametro("hCodigoPatron");
		String esCopiar = conectorParametro("esCopiar");
		String oidPatronOrigen = conectorParametro("oidPatronOrigen");
		pagina("contenido_periodo_asignar");

		asignarAtributo("VAR","hCodigoPatron","valor",patr);
        DTOBelcorp dto = new  DTOBelcorp();
        dto.setOidPais(pais);
        dto.setOidIdioma(idioma);

        ComposerViewElementList cv = crearParametrosAsignarPeriodos(dto);
        ConectorComposerView conector = new ConectorComposerView(cv, this.getRequest());
        conector.ejecucion();
        DruidaConector resultados = conector.getConector();

		asignar("COMBO", "comboTipoPeriodo", resultados, "SEGObtenerTiposPeriodo");
		asignar("COMBO", "comboPatronOrigen", resultados, "MSGObtenerPatronesOrigen");

		traza("copiarPatron: "+esCopiar);
		traza("patron origen: "+oidPatronOrigen);
		if (oidPatronOrigen != null)  {
			//if (copiarPatron.equals("True")){
			if (esCopiar.equals("true")){
				traza("esCopiar");
				//Deshabilita el combo cbPatronOrigen 
				asignarAtributo("VAR","hPatronOrigenHabilitado","valor","false");
				asignarAtributo("VAR","hOidPatronOrigen","valor", oidPatronOrigen);
			}

			asignarAtributo("VAR","hOidPeriodoCorporativo","valor","false");
			asignarAtributo("VAR","hOidTipoPeriodo","valor","false");
			//Selecciona el valor correspondiente a oidPeriodo en cbTipoPeriodo
			//Selecciona el valor correspondiente a oidPeriodo en cbPeriodoCorporativo
			if (!oidPatronOrigen.equals(oidPatron))  {
				//	Selecciona el valor correspondiente a oidPatronOrigen en cbPatronOrigen					
			} else {  //el patron origen y el patron son iguales, no debe seleccionarse ningún valor para la combo cbPatronOrigen
				//	  no se selecciona ningún valor para la combo cbPatronOrigen
			}

			//if(copiarPatron.equals("True")||opcionMenu.equals("Modificar Patron"))
				// Deshabilitar el combo cbPatronOrigen
		}
	}

	public void guardarPatron() throws Exception{

		pagina("salidaGenerica");
		asignarAtributo("VAR", "ejecutar", "valor", "guardarOK();");
		asignarAtributo("VAR", "ejecutarError", "valor", "guardarKO();");

		DruidaConector resp = new DruidaConector();
        DTOPatron dtoPatron = new DTOPatron();
        dtoPatron = crearDTOPatron();

		traza("Este es el DTO que se va a Actualizar: ");
		traza(dtoPatron);
		
        MareBusinessID idBusiness = new MareBusinessID("MSGActualizarPatron");

        Vector paramEntrad = new Vector();
        paramEntrad.addElement(dtoPatron);
        paramEntrad.addElement(idBusiness);

        traza("Antes del conector ConectorActualizarPatron");
        resp  = conectar("ConectorActualizarPatron", paramEntrad);
        traza("Despues del conector ConectorActualizarPatron");

		DTOPatron patron = (DTOPatron) resp.objeto("DTOSalida");
		if (patron.getOidPatronPeriodo() != null)
			oidPatronPeriodo = patron.getOidPatronPeriodo().toString();				

	}

	public void eliminarSeccion() throws Exception{
	
		obtenerDatosPatron();

		DruidaConector resp = new DruidaConector();
		String oidSeccionStr = conectorParametro("hOidSeccion")==null?"":conectorParametro("hOidSeccion");
		Long oidSeccion = new Long(oidSeccionStr);
        DTOOID dtoOid = new DTOOID();
		dtoOid.setOid(oidSeccion);
		dtoOid.setOidIdioma(idioma);
		dtoOid.setOidPais(pais);

        MareBusinessID idBusiness = new MareBusinessID("MSGEliminarSeccion");

        Vector paramEntrad = new Vector();
        paramEntrad.addElement(dtoOid);
        paramEntrad.addElement(idBusiness);

        traza("Antes del conector ConectorEliminarSeccion");
        resp  = conectar("ConectorEliminarSeccion", paramEntrad);
        traza("Despues del conector ConectorEliminarSeccion");

		cargarPaginaDatosPatron();
	}

	public void guardarPatronPorPeriodo() throws Exception{
		traza("Entro a guardarPatronPorPeriodo()");
		//Obtiene de la página PGAsignarPeriodo los atributos: 
		oidPeriodo = conectorParametro("hOidPeriodoCorporativo")==null?"":conectorParametro("hOidPeriodoCorporativo");
		oidPatronOrigen = conectorParametro("hOidPatronOrigen")==null?"":conectorParametro("hOidPatronOrigen");
		traza("Este es el oidPeriodo: " + oidPeriodo);
		traza("Este es el oidPatronOrigen: " + oidPatronOrigen);

		if (oidPatronOrigen.equals(""))
			oidPatronOrigen = ConstantesMSG.PRIMER_PATRON_PERIODO.toString();

		pagina("salidaGenerica");
		asignarAtributo("VAR", "ejecutar", "valor", "cerrar('" + oidPatronOrigen + "');");

		//Asigna la pagina PGVentanaOcultaPeriodo y pasa los parámetros: 
		//- oidPeriodo
		//- oidPatronOrigen 
		//
		traza("Salio de guardarPatronPorPeriodo()");
	}

	public void mostrarListaPatrones() throws Exception{
		String valores = conectorParametro("valores")==null?"":conectorParametro("valores");
		traza("valores: "+valores);
		conectorParametroSesion("valores",valores);
		pagina("contenido_patron_listar");
		asignarAtributo("VAR","hPais","valor",pais.toString());
		asignarAtributo("VAR","hIdioma","valor",idioma.toString());
	}

	public void copiarPatron() throws Exception{

		traza("Entro a copiarPatron()");

		DruidaConector resp = new DruidaConector();
		DTOPatron dtoPatron = new DTOPatron();
		oidPatron = conectorParametro("hOidPatron")==null?"":conectorParametro("hOidPatron");
		//Modificado por Sapaza - fecha 27-08-2007 - incidencia Sicc20070398, se comenta la conversion a mayusculas
		codigoPatron = conectorParametro("hCodigoPatronNuevo")==null?"":conectorParametro("hCodigoPatronNuevo");
		traza("Este es oid del patron que voy a copiar: " + oidPatron);
		traza("Este es codigo nuevo del patron: " + codigoPatron);
		dtoPatron.setOidPatron(new Long(oidPatron));
		dtoPatron.setCodigo(codigoPatron);
		dtoPatron.setOidPais(pais);
		dtoPatron.setOidIdioma(idioma);

		MareBusinessID idBusiness = new MareBusinessID("MSGCopiarPatron");

        Vector paramEntrad = new Vector();
        paramEntrad.addElement(dtoPatron);
        paramEntrad.addElement(idBusiness);

        traza("Antes del conector ConectorCopiarPatron");
		try  {
	        resp  = conectar("ConectorCopiarPatron", paramEntrad);			
		} catch (Exception ex)  {
			traza("Se produjo un error en copiar Patron..");
			asignarAtributo("VAR","hCopiarPatronHabilitado","valor","true");
			asignarAtributo("VAR","hVerPatronHabilitado","valor","false");
			asignarAtributo("VAR","hAnadirSeccionHabilitado","valor","true");
			asignarAtributo("VAR","hModificarSeccionHabilitado","valor","false");
			asignarAtributo("VAR","hEliminarSeccionHabilitado","valor","false");
			codigoPatron = "";
			oidPatron = "";
			cargarPaginaDatosPatron();
			asignarDatosSesion();
			throw ex;
		}
        traza("Despues del conector ConectorCopiarPatron");

		DTOPatron patron = (DTOPatron) resp.objeto("DTOSalida");

		traza("Este es DTOPatron que devuelve " + patron);

		if (patron !=null){
			oidPatron = patron.getOidPatron().toString();
			//Modificado por Sapaza - fecha 27-08-2007 - incidencia Sicc20070398, se comenta la conversion a mayusculas
			codigoPatron = patron.getCodigo();
			descripcionPatron = patron.getDescripcion();
			if (patron.getOidFormulario() != null)
				oidFormulario = patron.getOidFormulario().toString();
			if (patron.getOidMedioEnvio() != null)
				oidMedioEnvio = patron.getOidMedioEnvio().toString();		
			if (patron.getActivo() != null)
				activo = patron.getActivo().toString();
			if (patron.getPatronPeriodo() != null)
				patronPeriodo = patron.getPatronPeriodo().toString();
			if (patron.getOidPeriodo() != null)
				oidPeriodo = patron.getOidPeriodo().toString();
			if (patron.getOidPatronOrigen() != null)
				oidPatronOrigen = patron.getOidPatronOrigen().toString();
			if (patron.getOidPatronPeriodo() != null)
				oidPatronPeriodo = patron.getOidPatronPeriodo().toString();
			codigoCopiarPatron = patron.getCodigo();
			copiarPatron = new String("True");
		}

		cargarPaginaDatosPatron();
		asignarAtributo("VAR","esCopiar","valor","true");
//		mostrarDatosPatron();  INC 9446;
		traza("Salio de copiarPatron()");
	}

	public void asignarDatosSesion() throws Exception{
		String val = (String) conectorParametroSesion("valores");
		if(val!=null){
			//StringTokenizer st = new StringTokenizer(val,",",true);
			StringTokenizer st = new StringTokenizer(val,",");
			traza(new Integer(st.countTokens()).toString());
			while(st.hasMoreTokens()){
				String ind = (String) st.nextToken();
				String valor = (String) st.nextToken();
				if(ind.equals("codPatron")){
					if(valor!=null && !valor.equals("NAN"))
						asignarAtributo("VAR","hCodigoPatron","valor",valor);
				}
				if(ind.equals("descripcion")){
					if(valor!=null && !valor.equals("NAN"))
						asignarAtributo("VAR","hDescripcionPatron","valor",valor);
				}
				if(ind.equals("formulario")){
					if(valor!=null && !valor.equals("NAN"))
						asignarAtributo("VAR","hOidFormulario","valor",valor);
				}
				if(ind.equals("medioEnvio")){
					if(valor!=null && !valor.equals("NAN"))
						asignarAtributo("VAR","hOidMedioEnvio","valor",valor);
				}
				if(ind.equals("activo")){
					if(valor!=null && !valor.equals("NAN"))
						if(valor.equals("S"))
							asignarAtributo("VAR","hActivo","valor","true");
					   else asignarAtributo("VAR","hActivo","valor","false");
				}
				if(ind.equals("periodo")){
					if(valor!=null && !valor.equals(""))
						if(valor.equals("S"))
							asignarAtributo("VAR","hPatronPeriodo","valor","true");
						else asignarAtributo("VAR","hPatronPeriodo","valor","false");
				}
			}
		}
	}

	public void modificarPatron() throws Exception{
		oidPatron = conectorParametro("hOidPatron")==null?"":conectorParametro("hOidPatron");
		asignarAtributo("VAR","hCopiarPatronHabilitado","valor","false");		
		obtenerPatron();
	}

	public void buscarPatrones() throws Exception{
	}

	public void mostrarDetallePatron() throws Exception{

		traza("Entro al metodo mostrarDetallePatron()");
		oidPatron = conectorParametro("hOidPatron")==null?"":conectorParametro("hOidPatron");
		DruidaConector resp = new DruidaConector();

		DTOOID dtoOid = new DTOOID();
		dtoOid.setOid(new Long(oidPatron));
		dtoOid.setOidIdioma(idioma);
		dtoOid.setOidPais(pais);

		MareBusinessID idBusiness = new MareBusinessID("MSGObtenerDetallePatron");

        Vector paramEntrad = new Vector();
        paramEntrad.addElement(dtoOid);
        paramEntrad.addElement(idBusiness);

        traza("Antes del conector ConectorObtenerDetallePatron");
        resp  = conectar("ConectorObtenerDetallePatron", paramEntrad);
        traza("Despues del conector ConectorObtenerDetallePatron");

		DTOPatron patron = (DTOPatron) resp.objeto("DTOSalida");
		traza("Este es el DTOPATRON: " + patron);
		verPatron(patron);
		traza("Salio del metodo mostrarDetallePatron()");
	}

	private void cargarPaginaDatosPatron() throws Exception {
		traza("Entro a cargarPaginaDatosPatron()");
		DTOBelcorp dtoBelcorp = new DTOBelcorp();
		dtoBelcorp.setOidPais(pais);
		dtoBelcorp.setOidIdioma(idioma);
		
        ComposerViewElementList cv = crearParametrosDatosPatron(dtoBelcorp);
        ConectorComposerView conector = new ConectorComposerView(cv, this.getRequest());
        conector.ejecucion();
        DruidaConector resultados = conector.getConector();

		asignar("COMBO", "comboMedioEnvio", resultados, "MSGObtenerMediosEnvioPorPais");
		asignar("COMBO", "cmbFormulario", resultados, "FACObtenerFormularios");

		if (oidPatron != null)  {
			mostrarDatosPatron();
		} else {
			//Envia a la pagina PGDatosPatron los parámetros: 
			asignarAtributo("VAR","hOidPatron","valor","");
			asignarAtributo("VAR","hOidPeriodo","valor","");
			asignarAtributo("VAR","hOidPatronOrigen","valor","");
			asignarAtributo("VAR","hOidPatronPeriodo","valor","");
		}		
		traza("Salio de cargarPaginaDatosPatron()");
	}

	public void cargarPaginaBuscarPatrones() throws Exception {

		asignarAtributo("VAR","hPais","valor",pais.toString());
		asignarAtributo("VAR","hIdioma","valor",idioma.toString());
		asignarAtributo("VAR","accion","valor", accion);
		asignarAtributo("VAR","opcionMenu","valor", opcionMenu);

		//Crear un DTOBelcorp dtoe con: 
		//- pais = Pais activo 
		//- idioma = Idioma del usuario 
		DTOBelcorp dtoBelcorp = new DTOBelcorp();
		dtoBelcorp.setOidPais(pais);
		dtoBelcorp.setOidIdioma(idioma);
		

        ComposerViewElementList cv = crearParametrosDatosPatron(dtoBelcorp);
        ConectorComposerView conector = new ConectorComposerView(cv, this.getRequest());
        conector.ejecucion();
        DruidaConector resultados = conector.getConector();

		asignar("COMBO", "cmbMedioEnvio", resultados, "MSGObtenerMediosEnvioPorPais");
		asignar("COMBO", "cmbFormulario", resultados, "FACObtenerFormularios");

		RecordSet mi = new RecordSet();
		prepararRecordSet(mi);

		DruidaConector druidaConector = UtilidadesBelcorp.generarConector("ROWSET",mi,mi.getColumnIdentifiers());
		asignar("COMBO","cmbActivo",druidaConector,"ROWSET");		
		asignar("COMBO","cmbIndicadorPatronPeriodo",druidaConector,"ROWSET");		
		
	}
	public void obtenerDatosPatron() throws Exception {
		oidPatron = conectorParametro("hOidPatron")==null?"":conectorParametro("hOidPatron");
		//Modificado por Sapaza - fecha 27-08-2007 - incidencia Sicc20070398, se comenta la conversion a mayusculas
		codigoPatron = conectorParametro("hCodigoPatron")==null?"":conectorParametro("hCodigoPatron");
		descripcionPatron = conectorParametro("hDescripcionPatron")==null?"":conectorParametro("hDescripcionPatron");
		oidFormulario = conectorParametro("hOidFormulario")==null?"":conectorParametro("hOidFormulario");
		oidMedioEnvio = conectorParametro("hOidMedioEnvio")==null?"":conectorParametro("hOidMedioEnvio");
		activo = conectorParametro("hActivo")==null?"":conectorParametro("hActivo");
		patronPeriodo = conectorParametro("hPatronPeriodo")==null?"":conectorParametro("hPatronPeriodo");
		oidPeriodo = conectorParametro("hOidPeriodo")==null?"":conectorParametro("hOidPeriodo");
		oidPatronOrigen = conectorParametro("hOidPatronOrigen")==null?"":conectorParametro("hOidPatronOrigen");
		oidPatronPeriodo = conectorParametro("hOidPatronPeriodo")==null?"":conectorParametro("hOidPatronPeriodo");
	}


	public void mostrarDatosPatron() throws Exception {
		//Documentation
		//Envia a la página PGDatosPatron la información del patrón: 
		traza("Entro a mostrarDatosPatron()");
		if (codigoPatron != null)
			//Modificado por Sapaza - fecha 27-08-2007 - incidencia Sicc20070398, se comenta la conversion a mayusculas
			asignarAtributo("VAR","hCodigoPatron","valor", codigoPatron);
		if (descripcionPatron != null)
			asignarAtributo("VAR","hDescripcionPatron","valor", descripcionPatron);
		if (oidFormulario != null)
			asignarAtributo("VAR","hOidFormulario","valor", oidFormulario);
		if (oidMedioEnvio != null)
			asignarAtributo("VAR","hOidMedioEnvio","valor", oidMedioEnvio);
		if (activo != null)
			asignarAtributo("VAR","hActivo","valor", activo);
		if (patronPeriodo != null)
			asignarAtributo("VAR","hPatronPeriodo","valor", patronPeriodo);
		if (oidPatron != null)
			asignarAtributo("VAR","hOidPatron","valor", oidPatron);
		if (oidPeriodo != null)
			asignarAtributo("VAR","hOidPeriodo","valor", oidPeriodo);
		if (oidPatronOrigen != null)
			asignarAtributo("VAR","hOidPatronOrigen","valor", oidPatronOrigen);
		if (oidPatronPeriodo != null)
			asignarAtributo("VAR","hOidPatronPeriodo","valor", oidPatronPeriodo);
		if (copiarPatron != null)
			asignarAtributo("VAR","hCopiarPatron","valor", copiarPatron);
		if (codigoCopiarPatron != null)
			asignarAtributo("VAR","hCodigoCopiarPatron","valor",codigoCopiarPatron);

		traza("ESTA ES LA OPCION DE MENU: " + opcionMenu);

		if (opcionMenu.equals("Modificar patron"))  {
			traza("Setea habilitados");
			asignarAtributo("VAR","hCodigoPatronHabilitado","valor","false");
			asignarAtributo("VAR","hMedioEnvioHabilitado","valor","false");
		}
		traza("Salio de mostrarDatosPatron()");
	}

	public void obtenerPatron() throws Exception {
		DruidaConector resp = new DruidaConector();
		//Crea un DTOOID con: 
		//- oid = oidPatron 
		//

		DTOOID dtoOid = new DTOOID();
		dtoOid.setOid(new Long(oidPatron));
		dtoOid.setOidIdioma(idioma);
		dtoOid.setOidPais(pais);

		//Crea un idBusiness = "MSGObtenerPatron" 
		//
		MareBusinessID idBusiness = new MareBusinessID("MSGObtenerPatron");

        Vector paramEntrad = new Vector();
        paramEntrad.addElement(dtoOid);
        paramEntrad.addElement(idBusiness);

        traza("Antes del conector ConectorObtenerPatron");
        resp  = conectar("ConectorObtenerPatron", paramEntrad);
        traza("Despues del conector ConectorObtenerPatron");

		DTOPatron patron = (DTOPatron) resp.objeto("DTOSalida");		

		traza("Est es el DTO: " + patron);
		oidPatron = patron.getOidPatron().toString();
		//Modificado por Sapaza - fecha 27-08-2007 - incidencia Sicc20070398, se comenta la conversion a mayusculas
		codigoPatron = patron.getCodigo();

		descripcionPatron = patron.getDescripcion();
		if (patron.getOidFormulario() != null)		
			oidFormulario = patron.getOidFormulario().toString();				
		if (patron.getOidMedioEnvio() != null)
			oidMedioEnvio = patron.getOidMedioEnvio().toString();
		if (patron.getActivo() != null)
			activo = patron.getActivo().toString();
		if (patron.getPatronPeriodo() != null)
			patronPeriodo = patron.getPatronPeriodo().toString();
		if (patron.getOidPeriodo() != null)
			oidPeriodo = patron.getOidPeriodo().toString();
		if (patron.getOidPatronOrigen() != null)
			oidPatronOrigen = patron.getOidPatronOrigen().toString();
		if (patron.getOidPatronPeriodo() != null)
			oidPatronPeriodo = patron.getOidPatronPeriodo().toString();

		cargarPaginaDatosPatron();
	}

	public void verPatron(DTOPatron dtoPatron) throws Exception {
		pagina("contenido_patron_detalle");
		//Documentation
		//Muestra en la pagina PGDetallePatron la información del patron contenida en DTOPatron 
		//
		//// Muestra los datos generales del patron 

		// INC 22027 - dmorello, 05/01/2006
		this.getFormatosValidaciones();
		
		asignarAtributo("LABELC","lblvalorCodigoPatron","valor", dtoPatron.getCodigo() != null? dtoPatron.getCodigo() : "");
		asignarAtributo("LABELC","lblvalorDesc","valor", dtoPatron.getDescripcion() != null? dtoPatron.getDescripcion(): "");
		asignarAtributo("LABELC","lblvalorFormulario","valor", dtoPatron.getCodigoFormulario() != null? dtoPatron.getCodigoFormulario(): "");		
		asignarAtributo("LABELC","lblvalorMedioEnvio","valor", dtoPatron.getDescripcionMedioEnvio() != null? dtoPatron.getDescripcionMedioEnvio() : "");

		if (dtoPatron.getActivo() != null)
			if (dtoPatron.getActivo().booleanValue())
				asignarAtributo("LABELC","lblvalorActivo","valor", ConstantesPRE.SI);
			else if (!dtoPatron.getActivo().booleanValue())
				asignarAtributo("LABELC","lblvalorActivo","valor", ConstantesPRE.NO);				

		if (dtoPatron.getPatronPeriodo().booleanValue()){
			asignarAtributo("LABELC","lblvalorIndicadorPatronPeriodo","valor", ConstantesPRE.SI);		
			traza("este es el tipoPeriodo: "+dtoPatron.getDesTipoPeriodo()+" , y el periodoCorp: "+dtoPatron.getDesPeriodo());
			asignarAtributo("LABELC","lbldtTipoPeriodo","valor", dtoPatron.getDesTipoPeriodo());		//inc. 14024
			asignarAtributo("LABELC","lbldtPeriodoCorporativo","valor", dtoPatron.getDesPeriodo());	//inc. 14024	
		}else
			asignarAtributo("LABELC","lblvalorIndicadorPatronPeriodo","valor", ConstantesPRE.NO);		
		
		//// Muestra las diferentes secciones 
		//Para cada DTOSeccion encontrado en el DTOPatron realizamos lo siguiente: 
		//
		//- Creamos una nueva capa con el número de la sección ("Seccion N"), donde N es un número secuencial comenzando en 1. 
		//- txtCodigoSeccion = DTOSeccion.codigo 
		//- txtOrdenSecuencia = DTOSeccion.ordenSecuencia 
		//- txtMetacaracterEstructura = DTOSeccion.desMetacaracter 
		//
		//- Creamos la lista de mensajes de la sección: 
		//- Añadimos tantas filas a la lista como DTOMensajeSeccion encontrados en el DTOSeccion 
		//- Cada fila tendrá la siguiente información del mensaje: 
		//- Orden de impresión = DTOMensajeSeccion.ordenImpresion 
		//- Texto fijo y datos variables = DTOMensajeSeccion.texto
        xml = new XMLDocument();
        doc = xml.makeDocument("<table/>");

        Element listadoG = armarListaSecciones(dtoPatron.getSecciones());
        DruidaConector conG = new DruidaConector();
        conG.setXML(listadoG);
        asignar("REJILLA", "rejSecciones", conG);
        asignarAtributo("VAR", "hdnSecciones", "valor", String.valueOf(dtoPatron.getSecciones().size()) );
	}

    private Element armarListaSecciones(ArrayList vectorDTOSeccion)
        throws Exception {

        Element div = doc.createElement("DIV");
        yLista = new Integer(PATRON_HEADER_HEIGHT);
        for (Iterator secciones = vectorDTOSeccion.iterator();
                secciones.hasNext();) {
            DTOSeccion seccion = (DTOSeccion) secciones.next();
            int ordenSecuencia = seccion.getOrdenSecuencia() != null? seccion.getOrdenSecuencia().intValue() : -1;
            Element capaSeccion = doc.createElement("CAPA");
			/*
			 * DBLG400000890 - dmorello, 17/02/2006
			 * En la BD los números de orden secuencia empiezan en cero. No debe ser así en pantalla, por lo cual
			 * se incrementará en 1 para asignarlo al título y al campo no editable orden secuencia.
			 */
            capaSeccion.setAttribute("nombre","capaSeccion" + (ordenSecuencia + 1));
            capaSeccion.setAttribute("alto", "100%");
            capaSeccion.setAttribute("ancho", "100%");
            capaSeccion.setAttribute("colorf", "");
            capaSeccion.setAttribute("borde", "0");
            capaSeccion.setAttribute("imagenf", "");
            capaSeccion.setAttribute("repeat", "");
            capaSeccion.setAttribute("padding", "");
            capaSeccion.setAttribute("visibilidad", "visible");
            capaSeccion.setAttribute("contravsb", "");
            capaSeccion.setAttribute("x", "0");
            capaSeccion.setAttribute("y", yLista.toString());
            capaSeccion.setAttribute("zindex", "");

            Element tablaAfueraS = doc.createElement("table");
            tablaAfueraS.setAttribute("width", "100%");
            tablaAfueraS.setAttribute("border", "0");
            tablaAfueraS.setAttribute("cellspacing", "0");
            tablaAfueraS.setAttribute("cellpadding", "0");

            /*-----------------------------------------------------------------------------------------------------*/
            Element tr = getTR(3);

            Element td = (Element) tr.getChildNodes().item(0);
            td.setAttribute("width", "12");
            td.setAttribute("align", "center");
            td.appendChild(getIMG(12, 12));

            td = (Element) tr.getChildNodes().item(1);
            td.setAttribute("width", "750");
            td.appendChild(getIMG(SIN_ESPECIFICAR, SIN_ESPECIFICAR));

            td = (Element) tr.getChildNodes().item(2);
            td.setAttribute("width", "12");
            td.appendChild(getIMG(12, 1));

            tablaAfueraS.appendChild(tr);

            /*-----------------------------------------------------------------------------------------------------*/
            Element fieldset = getFIELDSET();
            Element legend1 = getLEGENDSeccion(ordenSecuencia + 1); 
            fieldset.appendChild(legend1); //agrego el titulo del fieldset

            Element cabecera = getContenidoSeccion(seccion); 
            fieldset.appendChild(cabecera); //agrego los datos de cabecera de cada seccion
	         Element listaEditableObtenida = (Element) (doc.importNode((Node) armarListaEditable(seccion), true));
            fieldset.appendChild(listaEditableObtenida); //agrego la lista editable con los mensajes
            listaEditableObtenida.setAttribute("ancho","720");
            tr = getTR(3);
            tr.getChildNodes().item(0).appendChild(getIMG(SIN_ESPECIFICAR,
                    SIN_ESPECIFICAR));
            tr.getChildNodes().item(1).appendChild(fieldset);
            tr.getChildNodes().item(2).appendChild(getIMG(SIN_ESPECIFICAR,
                    SIN_ESPECIFICAR));
            tablaAfueraS.appendChild(tr);

            tr = getTR(3);

            td = (Element) tr.getChildNodes().item(0);
            td.setAttribute("width", "12");
            td.setAttribute("align", "center");
            td.appendChild(getIMG(12, 12));

            td = (Element) tr.getChildNodes().item(1);
            td.setAttribute("width", "756");
            td.appendChild(getIMG(SIN_ESPECIFICAR, SIN_ESPECIFICAR));

            td = (Element) tr.getChildNodes().item(2);
            td.setAttribute("width", "12");
            td.appendChild(getIMG(12, 1));

            tablaAfueraS.appendChild(tr);
            yLista = new Integer(yLista.intValue() + 400);
            capaSeccion.appendChild(tablaAfueraS);
            div.appendChild(capaSeccion);
        }

        return div;
    }

    private Element getContenidoSeccion(DTOSeccion seccion)
        throws Exception {
        int ordenSecuencia = seccion.getOrdenSecuencia() != null? seccion.getOrdenSecuencia().intValue() : -1;
        Element tableRow = doc.createElement("table");
        tableRow.setAttribute("width", "100%");
        tableRow.setAttribute("border", "0");
        tableRow.setAttribute("align", "center");
        tableRow.setAttribute("cellspacing", "0");
        tableRow.setAttribute("cellpadding", "0");

        Element tableCols = doc.createElement("table");
        tableCols.setAttribute("width", "740");
        tableCols.setAttribute("border", "0");
        tableCols.setAttribute("align", "left");
        tableCols.setAttribute("cellspacing", "0");
        tableCols.setAttribute("cellpadding", "0");

        Element trCols = getTR(1);
        ((Element) trCols.getChildNodes().item(0)).setAttribute("colspan", "9");
        trCols.getChildNodes().item(0).appendChild(getIMG(8, 8));
        tableCols.appendChild(trCols);

        trCols = getTR(7);
        trCols.getChildNodes().item(0).appendChild(getIMG(8, 8));
		/*
		 * INC 22279 - dmorello, 03/01/2006
		 * Se modifica el nombre para el label de título Código sección para que no contenga números
		 * salvo los de ordenSecuencia
		 */
		trCols.getChildNodes().item(1).appendChild(getLABELC(
                "lblCodigoSeccionTitulo" + ordenSecuencia, null, "13",
                "1", "", "datosTitle", "824"));
        ((Element) trCols.getChildNodes().item(1)).setAttribute("nowrap",
            "nowrap");

        trCols.getChildNodes().item(2).appendChild(getIMG(25, 8));

		/*
		 * INC 22279 - dmorello, 03/01/2006
		 * Se modifica el nombre para el label de título Orden de secuencia para que no contenga números
		 * salvo los de ordenSecuencia
		 *
		 * dmorello, 20/02/2006
		 * Los números de orden de secuencia comienzan por cero en la BD, por eso se incrementarán en 1
		 */
        trCols.getChildNodes().item(3).appendChild(getLABELC(
                "lblOrdenSecuenciaTitulo" + ordenSecuencia, null, "13",
                "1", "", "datosTitle", "952"));
        ((Element) trCols.getChildNodes().item(3)).setAttribute("nowrap",
            "nowrap");

        trCols.getChildNodes().item(4).appendChild(getIMG(25, 8));

		/*
		 * INC 22279 - dmorello, 03/01/2006
		 * Se modifica el nombre para el label de título Metacaracteres estructura para que no contenga números
		 * salvo los de ordenSecuencia
		 */
        trCols.getChildNodes().item(5).appendChild(getLABELC(
                "lblMetacaracteresEstructuraTitulo" + ordenSecuencia,
                null, "13", "1", "", "datosTitle", "2479"));
        ((Element) trCols.getChildNodes().item(5)).setAttribute("nowrap",
            "nowrap");

        trCols.getChildNodes().item(6).appendChild(getIMG(8, 8));
        ((Element) trCols.getChildNodes().item(6)).setAttribute("width", "100%");
        tableCols.appendChild(trCols);

        trCols = getTR(7);
        trCols.getChildNodes().item(0).appendChild(getIMG(8, 8));

        trCols.getChildNodes().item(1).appendChild(getLABELC("lblCodigoSeccion" +
                ordenSecuencia, null, "13", "1",
                seccion.getCodigo() != null ? seccion.getCodigo() : "" , "datosCampos", null));
        ((Element) trCols.getChildNodes().item(1)).setAttribute("nowrap",
            "nowrap");

        trCols.getChildNodes().item(2).appendChild(getIMG(25, 8));

        trCols.getChildNodes().item(3).appendChild(getLABELC(
                "lblOrdenSecuencia" + ordenSecuencia, null, "13",
                "1", String.valueOf(ordenSecuencia + 1), "datosCampos", null));
        ((Element) trCols.getChildNodes().item(3)).setAttribute("nowrap",
            "nowrap");

        trCols.getChildNodes().item(4).appendChild(getIMG(25, 8));

        trCols.getChildNodes().item(5).appendChild(getLABELC(
                "lblMetacaracteresEstructura" + ordenSecuencia,
                null, "13", "1", seccion.getDesMetacaracter() != null? seccion.getDesMetacaracter() : "", "datosCampos",
                null));
        ((Element) trCols.getChildNodes().item(5)).setAttribute("nowrap",
            "nowrap");

        trCols.getChildNodes().item(6).appendChild(getIMG(8, 8));
        ((Element) trCols.getChildNodes().item(6)).setAttribute("width", "100%");
        tableCols.appendChild(trCols);

        trCols = getTR(1);
        ((Element) trCols.getChildNodes().item(0)).setAttribute("colspan", "9");
        trCols.getChildNodes().item(0).appendChild(getIMG(8, 8));
        tableCols.appendChild(trCols);

        trCols = getTR(1);
        ((Element) trCols.getChildNodes().item(0)).setAttribute("colspan", "8");
        trCols.getChildNodes().item(0).appendChild(getIMG(8, 319));
        tableCols.appendChild(trCols);
        
        Element trRow = getTR(1);
        trRow.getChildNodes().item(0).appendChild(tableCols);
        tableRow.appendChild(trRow);

        return tableRow;
    }

    private Element getIMG(int width, int height) {
        Element img = doc.createElement("IMG");
        img.setAttribute("src", "b.gif");

        if (width != SIN_ESPECIFICAR) {
            img.setAttribute("width", "" + width);
        }

        if (height != SIN_ESPECIFICAR) {
            img.setAttribute("height", "" + height);
        }

        return img;
    }

    private Element getTR(int tds) {
        Element tr = doc.createElement("tr");

        while (tds > 0) {
            tr.appendChild(doc.createElement("td"));
            tds--;
        }

        return tr;
    }

    private Element getFIELDSET() {
        Element fieldset = doc.createElement("fieldset");

        return fieldset;
    }

    private Element getLABELC(String nombre, String ancho, String alto,
        String filas, String valor, String id, String cod) {
        Element labelC = doc.createElement("LABELC");
        labelC.setAttribute("nombre", nombre);

        if (ancho != null) {
            labelC.setAttribute("ancho", ancho);
        }

        labelC.setAttribute("alto", alto);
        labelC.setAttribute("filas", filas);
        labelC.setAttribute("valor", valor);
        labelC.setAttribute("id", id);

        if (cod != null) {
            labelC.setAttribute("cod", cod);
        }

        return labelC;
    }

    private Element getLEGENDSeccion(int nroSeccion) throws Exception {
        Element legend = doc.createElement("legend");
        legend.setAttribute("class", "legend");

        Element tableLegend = doc.createElement("table");
        tableLegend.setAttribute("border", "0");
        tableLegend.setAttribute("cellspacing", "0");
        tableLegend.setAttribute("cellpadding", "0");
        tableLegend.setAttribute("bordercolor", "#CCCCCC");

        Element trLegend = getTR(3);
        Element td = (Element) trLegend.getChildNodes().item(0);
        td.appendChild(getLABELC("lbSeccion", null, "13", "1", "", "legend",
                "00234"));

        td = (Element) trLegend.getChildNodes().item(1);
        td.appendChild(getIMG(8, 8));

        td = (Element) trLegend.getChildNodes().item(2);
        td.appendChild(getLABELC("Seccion" + nroSeccion, null, "13", "1",
                "" + nroSeccion + " ", "legend", null));
        tableLegend.appendChild(trLegend);
        legend.appendChild(tableLegend);

        return legend;
    }

    private Element armarListaEditable(DTOSeccion seccion)
        throws Exception {

		traza("Entro al método armarListaEditable");
		if (seccion == null) {
			traza("El DTOSeccion recibido es null");
		} else {
			traza("DTOSeccion recibido: " + seccion);
		}

        int ordenSecuencia = seccion.getOrdenSecuencia() != null ? seccion.getOrdenSecuencia().intValue(): -1;
        String paginado = "mipgndo"+ordenSecuencia; 
        ListaEditableDinamica listado = new ListaEditableDinamica(this,
                "listaMensajesSeccion" + ordenSecuencia , 3, 0,
                true, paginado); //inc. 14027

        listado.setCodigoColumna(0, "951");
		  listado.setCodigoColumna(1, "821"); //inc. 14027
        listado.setCodigoColumna(2, "2480");
        listado.setAnchoColumna(0, 150); 
        listado.setAnchoColumna(1, 150); //inc. 14027
        listado.setAnchoColumna(2, 500);
        
        listado.setAlto(320);
        listado.setX(24);
        listado.setY(60);
        if(seccion.getMensajes()!=null){ //inc DBLG400000890 GACEVEDO
			for (   Iterator mensajes = seccion.getMensajes().iterator(); mensajes.hasNext(); ) {
				DTOMensajeSeccion mensaje = (DTOMensajeSeccion) mensajes.next();
				traza("DTOMensajeSeccion tomado con el iterador: " + mensaje);
				listado.addFila(new String[] {	mensaje.getOidMensaje() != null? mensaje.getOidMensaje().toString() : "",
														   mensaje.getOrdenImpresion() != null ? mensaje.getOrdenImpresion().toString() : "", 
															mensaje.getCodigoMensaje() != null? mensaje.getCodigoMensaje() : "", //inc. 14027
															mensaje.getTexto() != null? mensaje.getTexto() : ""
					});
			}
		}
        Element titulo = listado.getLista().getOwnerDocument().createElement("TITULO");
        titulo.setAttribute("colFondo", "#CECFCE");
        titulo.setAttribute("alto", "22");
        titulo.setAttribute("imgFondo","");
        titulo.setAttribute("ID", "datosTitle");
        titulo.setAttribute("cod", "00545");
        listado.getLista().appendChild(titulo);

        return listado.getLista();
    }


	public DTOPatron crearDTOPatron() throws Exception {
		traza("Entro al metodo crearDTOPatron");
		obtenerDatosPatron();
		trazarAtributosLP();
		DTOPatron dtoPatron = new DTOPatron();
		dtoPatron.setOidPatron(new Long(oidPatron));
		//Modificado por Sapaza - fecha 27-08-2007 - incidencia Sicc20070398, se comenta la conversion a mayusculas
		dtoPatron.setCodigo(codigoPatron);
		dtoPatron.setDescripcion(descripcionPatron);
		dtoPatron.setOidFormulario(new Long(oidFormulario));
		dtoPatron.setOidMedioEnvio(new Long(oidMedioEnvio));
		if (!activo.equals(""))
			if (activo.equals("S"))
				dtoPatron.setActivo(new Boolean("True"));
			else
				dtoPatron.setActivo(new Boolean("False"));
		if (patronPeriodo.equals("") || patronPeriodo.equals("N"))		
			dtoPatron.setPatronPeriodo(new Boolean("False"));
		else
			dtoPatron.setPatronPeriodo(new Boolean("True"));
		if (!oidPeriodo.equals("")){
			dtoPatron.setOidPeriodo(new Long(oidPeriodo));
		}
		if (!oidPatronOrigen.equals("")){
			dtoPatron.setOidPatronOrigen(new Long(oidPatronOrigen));
		}
		if (!oidPatronPeriodo.equals("")){
			dtoPatron.setOidPatronPeriodo(new Long(oidPatronPeriodo));
		}

		traza("Salio del metodo crearDTOPatron");				
		return dtoPatron;
	}

	private ComposerViewElementList crearParametrosAsignarPeriodos(DTOBelcorp dto) throws Exception{

		ComposerViewElementList lista = new ComposerViewElementList(); 
		
		ComposerViewElement element1 = new ComposerViewElement();
		element1.setDTOE(dto);
		element1.setIDBusiness("SEGObtenerTiposPeriodo");
		//elem.posOID=1; 
		lista.addViewElement(element1);

		ComposerViewElement element2 = new ComposerViewElement();
		element2.setDTOE(dto);
		element2.setIDBusiness("MSGObtenerPatronesOrigen");
		lista.addViewElement(element2);

		return lista;
	}


	private ComposerViewElementList crearParametrosDatosPatron(DTOBelcorp dto) throws Exception {

		ComposerViewElementList lista = new ComposerViewElementList(); 
		
		ComposerViewElement element1 = new ComposerViewElement();
		element1.setDTOE(dto);
		element1.setIDBusiness("MSGObtenerMediosEnvioPorPais");
		lista.addViewElement(element1);

		ComposerViewElement element2 = new ComposerViewElement();
		element2.setDTOE(dto);
		element2.setIDBusiness("FACObtenerFormularios");
		lista.addViewElement(element2);

		return lista;

	}

	private void prepararRecordSet(RecordSet record){
		record.addColumn("OID");
		record.addColumn("DESC");
		Vector vectorFila = new Vector(); 
		vectorFila.add("1");
		vectorFila.add(ConstantesPRE.NO);
		record.addRow(vectorFila);
		vectorFila = new Vector(); 
		vectorFila.add("2");
		vectorFila.add(ConstantesPRE.SI);
		record.addRow(vectorFila);	
	}

	private void trazarAtributosLP() throws Exception {
		traza("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
		traza("ATRIBUTOS DE LA LP");
		traza("Accion: " + accion);
		traza("opcionMenu: " + opcionMenu);
		traza("oidPatron: " + oidPatron);
		traza("codigoPatron: " + codigoPatron);
		traza("descripcionPatron: " + descripcionPatron);
		traza("oidFormulario: " + oidFormulario);
		traza("oidMedioEnvio: " + oidMedioEnvio);
		traza("activo: " + activo);
		traza("patronPeriodo: " + patronPeriodo);
		traza("oidPatronOrigen: " + oidPatronOrigen);
		traza("oidPeriodo: " + oidPeriodo);
		traza("oidPatronPeriodo" + oidPatronPeriodo);
		traza("codigoCopiarPatron: " + codigoCopiarPatron);
		traza("copiarPatron: " + copiarPatron);
		traza("FIN ATRIBUTOS DE LA LP");
		traza("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
	}
}
