import es.indra.druida.DruidaConector;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.UtilidadesSession;
import java.math.BigDecimal;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Vector;
import java.util.Date;
import java.text.DateFormat;
import es.indra.sicc.util.DTOOID;
//import java.sql.Date;
import java.text.SimpleDateFormat;

import es.indra.sicc.dtos.com.DTOEstado;
import es.indra.sicc.dtos.com.DTOEstados;
import es.indra.sicc.dtos.com.DTOPermitirModificar;
import es.indra.sicc.logicanegocio.com.ConstantesCOM;

public class LPDosMantenimientoComisiones extends LPSICCBase 
{
	private String accion = null;
	private String sPais = null;     
	private String sIdioma = null;
	private String sDescPais = null;     
	private Long lIdioma = null;
	private Long lPais = null;   

	private String oidPlantilla = null;     
	private String canal = null;     
	private String indComparativo = null;     
	private String indTratamientoDif = null;     
	private String oidCanal = null;     
	private String oidComision = null;     
	private String oidEstado = null;    
	private String codComision = null;       
	private String version = null;
	private String descripcion = null;
	private String tipoComision = null;
	private String marca = null;
	private String acceso = null;       
	private String concepto = null;
	private String fecIniVigor = null;

	public LPDosMantenimientoComisiones() { super(); }

	public void inicio() throws Exception { }  
  
	public void ejecucion() throws Exception 
	{     
		this.rastreo();
		setTrazaFichero();    
  		traza("************ Entre a LPDosMantenimientoComisiones");
		accion = conectorParametroLimpia("accion", "", true);

		if(accion.equals("")) 
			accion = "InsertarComisiones";

 		traza("************ accion:" + accion);
	  
		sPais = UtilidadesSession.getPais(this).toString();
		sIdioma = UtilidadesSession.getIdioma(this).toString();
		sDescPais = UtilidadesSession.getDescripcionPais(this).toString();  	  
		lIdioma = UtilidadesSession.getIdioma(this);
		lPais = UtilidadesSession.getPais(this);
		
		try 
		{			  
			if(accion.equals("InsertarComisiones"))  { 		
				cargaBuscarInsertarComisiones();
			}
			else if(accion.equals("AceptarInsertar")) {           				
				oidPlantilla = conectorParametroLimpia("oidPlantilla", "", true);
				canal = conectorParametroLimpia("canal", "", true);
				indComparativo = conectorParametroLimpia("indComparativo", "", true);
				indTratamientoDif = conectorParametroLimpia("indTratamientoDif", "", true);
				oidCanal = conectorParametroLimpia("oidCanal", "", true);

				//cargaDatosGenerales(oidPlantilla, canal, indComparativo,indTratamientoDif, oidCanal);
			}
			else if(accion.equals("MarcarComisiones")) {           
				cargaMarcarComisiones();
			}
			else if(accion.equals("MarcarModificar")) {
				oidComision = conectorParametroLimpia("oidComision", "", true);
				marcarModificar(new Long(oidComision));
			}
			else if(accion.equals("AceptarModificacion"))
				cargaBuscarAceptarModificacion();
			else if(accion.equals("PermitirModificar")) 
			{
  				oidComision = conectorParametroLimpia("oidComision", "", true);
				cargaPermitirModificar(new Long(oidComision));				
			}
			else if(accion.equals("GuardarPermitirModificar")) {
				oidComision = conectorParametroLimpia("oidComision", "", true);
				oidEstado = conectorParametroLimpia("cbEstadoComision", "", true);
				traza(" en GuardarPermitirModificar ");
				traza("oidComision:   " + oidComision);
				traza("oidEstado:   " + oidEstado);
				guardarPermitirModificar(new Long(oidComision), new Long(oidEstado));				
			}
			else if(accion.equals("ConfirmarModificar")) {
				oidComision = conectorParametroLimpia("oidComision", "", true);
				codComision = conectorParametroLimpia("codComision", "", true);
				version = conectorParametroLimpia("version", "", true);
				descripcion = conectorParametroLimpia("descripcion", "", true);
				tipoComision = conectorParametroLimpia("tipoComision", "", true);
				marca = conectorParametroLimpia("marca", "", true);
				canal = conectorParametroLimpia("canal", "", true);
				acceso = conectorParametroLimpia("acceso", "", true);
				concepto = conectorParametroLimpia("concepto", "", true);
				fecIniVigor = conectorParametroLimpia("fecIniVigor", "", true);

				traza(" fecIniVigor:  " + fecIniVigor);
        
				//Date fecha = DateFormat.getInstance().parse(fecIniVigor);
				Date fecha = toDate(fecIniVigor, "dd/MM/yy");
				cargaConfirmarModificar(new Long(oidComision), codComision, new Integer(version),
				descripcion, tipoComision, marca, canal, acceso, concepto, fecha); 				 
			}
			else if(accion.equals("ConfirmarAceptar")) {
				oidComision = conectorParametroLimpia("oidComision", "", true);
				traza("oidComision en ConfirmarAceptar:  " + oidComision);
				aceptaConfirmarModificar(new Long(oidComision));
			}
			else if(accion.equals("ConfirmarRechazar")) {
				oidComision = conectorParametroLimpia("oidComision", "", true);
				traza("oidComision en ConfirmarRechazar:  " + oidComision);
				rechazaConfirmarModificar(new Long(oidComision));
			}			
			else if(accion.equals("CopiarComisiones")) {
				cargaBuscarModificar(accion);
			}
			else if(accion.equals("CopiarComision")) {
				oidComision = conectorParametroLimpia("oidComision", "", true);
				copiaComision(new Long(oidComision));
			}
			else if(accion.equals("EliminarComisiones")) {
				cargaBuscarModificar(accion);
			}
			else if(accion.equals("EliminarComision")) {
				oidComision = conectorParametroLimpia("oidComision", "", true);
				eliminaComision(new Long(oidComision));
			}
			else if(accion.equals("ModificarComisiones")) {
				cargaBuscarModificar(accion);
			}
			else if(accion.equals("ConsultarComisiones")) {
				cargaBuscarModificar(accion);
			}
			cargarMenuSecundario();
		}
		catch(Exception e)  {
			ByteArrayOutputStream pila = new ByteArrayOutputStream();
			PrintStream out = new PrintStream(pila);
			e.printStackTrace(out);
			traza("EL STACK ES COMO SIGUE : " +  pila.toString());
			e.printStackTrace(); 
			e.getMessage();
			lanzarPaginaError(e);
		}
		
	}     

	public void cargaBuscarInsertarComisiones() throws Exception 
	{
		traza("************ Entre a cargaBuscarInsertarComisiones");
		pagina("contenido_comisiones_insertar");
    
		/*Carga la pantalla PaginaBuscarInsertarComisiones 
		Proceso 
		======== 
		Se crean cuatro elementos: 

		elem1.idNegocio="COMDescripcionesPlantillas" 
		elem1.dtoe=DTOBelcorp 

		elem2.idNegocio="COMCanalesPlantillas" 
		elem2.dtoe=DTOBelcorp 

		elem3.idNegocio="COMAccesosPlantilla" 
		elem3.dtoe=DTOOID (donde DTOOID.oid = null) 

		elem4.idNegocio="COMMarcasPlantilla" 
		elem4.dtoe=DTOOID (donde DTOOID.oid = null) 

		Se llama al subsistema GestorCargaPantalla. 
		Con los datos obtenidos en el ROWSET COMDescripcionesPlantillas se carga la combo cmbDescripcion 
		Con los datos obtenidos en el ROWSET COMCanalesPlantillas se carga la combo cmbCanal 
		Con los datos obtenidos en el ROWSET COMAccesosPlantilla se carga la combo cmbAcceso 
		Con los datos obtenidos en el ROWSET COMMarcasPlantilla se carga la combo cmbMarca*/
    
		ComposerViewElementList cv = crearParametrosEntrada();
		ConectorComposerView conector = new ConectorComposerView(cv, this.getRequest());
		conector.ejecucion();
		DruidaConector resultados = conector.getConector();
    
		traza("************ Asignando datos a los combos");    
		asignar("COMBO", "cbDescripcion", resultados, "COMDescripcionesPlantillas");
		asignar("COMBO", "cbMarca", resultados, "COMMarcasPlantilla");
		asignar("COMBO", "cbCanal", resultados, "COMCanalesPlantillas");
		asignar("COMBO", "cbAcceso", resultados, "COMAccesosPlantilla");
		asignarAtributo("VAR", "varPais", "valor", sPais);
		asignarAtributo("VAR", "varIdioma", "valor", sIdioma);
	}
  
  private ComposerViewElementList crearParametrosEntrada()
  {
		DTOBelcorp dtoe = new DTOBelcorp(); 
		dtoe.setOidIdioma(lIdioma);
		dtoe.setOidPais(lPais);
    
		DTOOID dtoOid = new DTOOID();
		dtoOid.setOid(null);
		dtoOid.setOidIdioma(lIdioma);
		dtoOid.setOidPais(lPais);
    
		ComposerViewElementList lista = new ComposerViewElementList(); 
		
		//Primer combo
		ComposerViewElement cve1 = new ComposerViewElement();
		cve1.setIDBusiness("COMDescripcionesPlantillas");
		cve1.setDTOE(dtoe);
    
		//Segundo combo
		ComposerViewElement cve2 = new ComposerViewElement();
		cve2.setIDBusiness("COMCanalesPlantillas");
		cve2.setDTOE(dtoe);
    
		//Tercer combo
		ComposerViewElement cve3 = new ComposerViewElement();
		cve3.setIDBusiness("COMAccesosPlantilla");
		cve3.setDTOE(dtoOid);
    
		//Cuarto combo
		ComposerViewElement cve4 = new ComposerViewElement();
		cve4.setIDBusiness("COMMarcasPlantilla");
		cve4.setDTOE(dtoOid);    
    
		lista.addViewElement(cve1);
		lista.addViewElement(cve2);
		lista.addViewElement(cve3);
		lista.addViewElement(cve4);    
		return lista;
	}

    /*Marca una comisión para solicitar su modificación. 
	Proceso 
	======== 
		Se crea DTOOID 
		DTOOID.oid = oidComision 
		IdNegocio = "COMMarcarModificar" 
		Se invoca al conector ConectorMarcarModificar
	*/
    // idedough 14/03/2005
	public void marcarModificar(Long oidComision) throws Exception 
	{
		traza("************ Entre a marcarModificar");
		traza("************ oidComision " + oidComision);
        
		DTOOID dtoOid = new DTOOID();
        dtoOid.setOid(oidComision);
		dtoOid.setOidPais(lPais);
		dtoOid.setOidIdioma(lIdioma);
		MareBusinessID businessID = new MareBusinessID("COMMarcarModificar");
		Vector params = new Vector();
        params.add(dtoOid); params.add(businessID);
		traza("# conectar ->  ConectorMarcarModificar ");
		DruidaConector con = conectar("ConectorMarcarModificar", params);
		traza("# conectar ............................... [OK] ");
		pagina("salidaGenerica"); 
		asignarAtributo("VAR", "ejecutar", "valor", "resetButtons()");
        //asignarAtributo("VAR", "cerrarVentana", "valor", "0");
	}
    
	/*Carga la pantalla PaginaBuscarAceptarModificacion 
	Proceso 
	======== 
		Se deshabilitan los botones btnPermitir y btnConfirmar. 
		Se crea la variable DTOEstado dtoEstado. 
		Se crea la variable DTOEstados dtoE que se carga como sigue: 
		dtoE.idioma = idioma de la sesión 
		dtoEstado.oidEstadoComision = ConstantesCOM.ESTADO_COMISION_SOLICITUD_CAMBIO 
		Se añade dtoEstado a dtoE.estados 
		dtoEstado.oidEstadoComision = ConstantesCOM.ESTADO_COMISION_CONFIRMACION_CAMBIOS 
		Se añade dtoEstado a dtoE.estados 
		Se crea un elemento: 
		elem1.idNegocio="COMEstadosComisiones" 
		elem1.dtoe=dtoE 
		Se llama al subsistema GestorCargaPantalla. 
		Con los datos obtenidos en el ROWSET COMEstadosComisiones se carga la combo cmbEstado
	*/    
	// idedough 14/03/2005
	public void cargaBuscarAceptarModificacion() throws Exception 
	{
		traza("** LP DOS *** Entre a cargaBuscarAceptarModificacion ....");
		pagina("contenido_comisiones_modificar_autorizar");
		DTOEstado dtoEstado = new DTOEstado();
		DTOEstados dtoe = new DTOEstados();
		dtoe.setOidIdioma(lIdioma);
		traza("ConstantesCOM.ESTADO_COMISION_SOLICITUD_CAMBIO: " + ConstantesCOM.ESTADO_COMISION_SOLICITUD_CAMBIO);
        dtoEstado.setOidEstadoComision(ConstantesCOM.ESTADO_COMISION_SOLICITUD_CAMBIO);
		ArrayList alEstados = new ArrayList();
        alEstados.add(dtoEstado);
		traza("ConstantesCOM.ESTADO_COMISION_CONFIRMACION_CAMBIOS: " + ConstantesCOM.ESTADO_COMISION_CONFIRMACION_CAMBIOS);
        DTOEstado dtoEstado2 = new DTOEstado();
        dtoEstado2.setOidEstadoComision(ConstantesCOM.ESTADO_COMISION_CONFIRMACION_CAMBIOS);
        alEstados.add(dtoEstado2);
        dtoe.setEstados(alEstados);

		traza("dtoe:  " + dtoe);

		ComposerViewElement cve = new ComposerViewElement();		
		cve.setDTOE(dtoe);
		loadCmb("COMEstadosComisiones","cbEstadoComision",cve);

		/*ComposerViewElementList list = new ComposerViewElementList();
		ComposerViewElement cve = new ComposerViewElement();
		cve.setIDBusiness("COMEstadosComisiones");
		cve.setDTOE(dtoe);
		list.addViewElement(cve);
		traza(" creando conector ");
		ConectorComposerView conector = new ConectorComposerView(list,this.getRequest());
		traza(" conector.ejecucion COMEstadosComisiones ");
        conector.ejecucion();
		traza(" conector.ejecucion COMEstadosComisiones ...... [ok] ");
        DruidaConector con = conector.getConector();
		traza(" asignando combo ");
        asignar("COMBO", "cbEstadoComision", con, "COMEstadosComisiones");*/

		asignarAtributo("VAR", "varOidPais", "valor", sPais);
		asignarAtributo("VAR", "varOidIdioma", "valor", sIdioma);
		

		//COMEstadosComisiones
		traza(" asignando combo ...... [ok] ");
	}

	/*Carga la pantalla PaginaPermitirModificar 
		Proceso 
		======== 
		Se carga el atributo varOidComision de PaginaPermitirModificar con oidComision recibido. 
		Se crea la variable DTOEstado dtoEstado. 
		Se crea la variable DTOEstados dtoE que se carga como sigue: 
		dtoE.idioma = idioma de la sesión 
		dtoEstado.oidEstadoComision = ConstantesCOM.ESTADO_COMISION_SOLICITUD_ACEPTADA 
		Se añade dtoEstado a dtoE.estados 
		dtoEstado.oidEstadoComision = ConstantesCOM.ESTADO_COMISION_SOLICITUD_RECHAZADA 
		Se añade dtoEstado a dtoE.estados 
		Se crea un elemento: 
		elem1.idNegocio="COMEstadosComisiones" 
		elem1.dtoe=dtoE 
		Se llama al subsistema GestorCargaPantalla. 
		Con los datos obtenidos en el ROWSET COMEstadosComisiones se carga la combo cmbEstado
	*/
	// idedough 14/03/2005
	public void cargaPermitirModificar(Long oidComision) throws Exception 
	{
		traza("************ Entre a cargaPermitirModificar");
		traza("************ oidComision " + oidComision);
		pagina("contenido_comisiones_modificar_autorizar_2");
		asignarAtributo("VAR", "oidComision", "valor", oidComision.toString());
        //asignarAtributo("VAR", "varOidComision", "valor", oidComision.toString());
		DTOEstado dtoEstado = new DTOEstado();
		DTOEstados dtoe = new DTOEstados();
		dtoe.setOidIdioma(lIdioma);
		//dtoe.setOidPais(lPais);
		traza("ConstantesCOM.ESTADO_COMISION_SOLICITUD_ACEPTADA:   " + ConstantesCOM.ESTADO_COMISION_SOLICITUD_ACEPTADA);
        dtoEstado.setOidEstadoComision(ConstantesCOM.ESTADO_COMISION_SOLICITUD_ACEPTADA);
		ArrayList alEstados = new ArrayList();
        alEstados.add(dtoEstado);
		DTOEstado dtoEstado2 = new DTOEstado();
		traza("ConstantesCOM.ESTADO_COMISION_SOLICITUD_RECHAZADA:   " + ConstantesCOM.ESTADO_COMISION_SOLICITUD_RECHAZADA);
        dtoEstado2.setOidEstadoComision(ConstantesCOM.ESTADO_COMISION_SOLICITUD_RECHAZADA);
        alEstados.add(dtoEstado2);
        dtoe.setEstados(alEstados);

        ComposerViewElement cve = new ComposerViewElement();		
		cve.setDTOE(dtoe);
		loadCmb("COMEstadosComisiones","cbEstadoComision",cve);
        
		/*ComposerViewElementList list = new ComposerViewElementList();
		ComposerViewElement cve = new ComposerViewElement();
		cve.setIDBusiness("COMEstadosComisiones");
		cve.setDTOE(dtoe);
		list.addViewElement(cve);
		ConectorComposerView conector = new ConectorComposerView(list,this.getRequest());
		traza(" conector.ejecucion COMEstadosComisiones ");
        conector.ejecucion();
		traza(" conector.ejecucion COMEstadosComisiones ..... [ok]"); 
        DruidaConector con = conector.getConector();
        asignar("COMBO", "cbEstadoComision", con, "COMEstadosComisiones");	*/	
	}
    
	/*Carga la pantalla PaginaConfirmarModificar 
		Proceso 
		======== 
		Se cargan los siguientes atributos de PaginaConfirmarModificar con los parámetros recibidos: 
		varOidComisionPendiente = oidComision 
		varFechaInicioVigorModificacion = fecIniVigor 
		lblCodComisionPendiente = codComision 
		lblVersionPendiente = version 
		lblDescripcionPendiente = descripcion 
		lblTipoPendiente = tipoComision 
		lblMarcaPendiente = marca 
		lblCanalPendiente = canal 
		lblAccesoPendiente = acceso 
		lblConceptoPendiente = concepto 

		Se crea DTOOID 

		DTOOID.oid = oidComision 
		DTOOID.pais = pais de la sesion 
		DTOOID.idioma = idioma de la sesion 

		IdNegocio = "COMCargaConfirmarModificar" 

		Se invoca al conector ConectorCargaConfirmarModificar 

		Con el DTOSalida que se obtiene, 
		si DTOSalida.resultado tiene registros se cargan los siguientes 
		atributos de PaginaConfirmarModificar: 
		varOidComisionVigente = DTOSalida.resultado(0).oid 
		varFechaInicioPeriodoActual = DTOSalida.resultado(0).fecIniPeriodoActual 
		lblCodComisionVigente = DTOSalida.resultado(0).codigo 
		lblVersionVigente = DTOSalida.resultado(0).version 
		lblDescripcionVigente = DTOSalida.resultado(0).descripcion 
		lblTipoVigente = DTOSalida.resultado(0).tipoComision 
		lblMarcaVigente = DTOSalida.resultado(0).marca 
		lblCanalVigente = DTOSalida.resultado(0).canal 
		lblAccesoVigente = DTOSalida.resultado(0).acceso 
		lblConceptoVigente = DTOSalida.resultado(0).concepto
	*/
	// idedough 14/03/2005
	public void cargaConfirmarModificar(Long oidComision, 
										String codComision, 
										Integer version, 
										String descripcion, 
										String tipoComision, 
										String marca,
										String canal, 
										String acceso, 
										String concepto, 
										Date fecIniVigor) throws Exception 
	{
    
		traza("************ Entre a cargaConfirmarModificar");
		traza("************ oidComision " + oidComision);
		traza("************ codComision " + codComision);
		traza("************ version " + version);
		traza("************ descripcion " + descripcion);
		traza("************ tipoComision " + tipoComision);
		traza("************ marca " + marca);
		traza("************ canal " + canal);
		traza("************ acceso " + acceso);
		traza("************ concepto " + concepto);
		traza("************ fecIniVigor " + fecIniVigor);

        pagina("contenido_comisiones_modificar_autorizar_detalle");

		traza(" seteando valores 1 ");
		asignarAtributo("VAR", "oidComision", "valor", oidComision.toString());
		asignarAtributo("VAR", "varOidComisionPendiente", "valor", oidComision.toString());
		asignarAtributo("VAR", "varFechaInicioVigorModificacion", "valor", dateToString(fecIniVigor));
		
		asignarAtributo("LABELC", "lblCodComisionPendiente", "valor", codComision);
		asignarAtributo("LABELC", "lblVersionPendiente", "valor", version.toString());
		asignarAtributo("LABELC", "lblDescripcionPendiente", "valor", descripcion);
		asignarAtributo("LABELC", "lblTipoPendiente", "valor", tipoComision);
		asignarAtributo("LABELC", "lblMarcaPendiente", "valor", marca);
		asignarAtributo("LABELC", "lblCanalPendiente", "valor", canal);
		asignarAtributo("LABELC", "lblAccesoPendiente", "valor", acceso);
		asignarAtributo("LABELC", "lblConceptoPendiente", "valor", concepto);
		asignarAtributo("VAR", "varOidPais", "valor", sPais);
		asignarAtributo("VAR", "varOidIdioma", "valor", sIdioma);
		traza(" seteando valores 1 ........ [ok] ");

		DTOOID dtoOid = new DTOOID();
        dtoOid.setOid(oidComision);
		dtoOid.setOidPais(lPais);
		dtoOid.setOidIdioma(lIdioma);
		MareBusinessID businessID = new MareBusinessID("COMCargaConfirmarModificar");
		Vector params = new Vector();
        params.add(dtoOid); params.add(businessID);
		traza("# conectar ->  ConectorCargaConfirmarModificar ");
		DruidaConector con = conectar("ConectorCargaConfirmarModificar", params);
        traza("# ....................................................... [OK] "); 
		//traza(" con.objeto  : " + con.objeto("DTOSalida"));
		DTOSalida dtos = new DTOSalida();    
        dtos = (DTOSalida)con.objeto("DTOSalida");   
        traza("DTOSalida:   " + dtos);    
        RecordSet rs = new RecordSet();   
        rs = dtos.getResultado();   
        if(!rs.esVacio())
        {                
			traza(" RecordSet :   " + rs);
            if(rs.getValueAt(0,"oid") != null)
			  asignarAtributo("VAR", "varOidComisionVigente", "valor", rs.getValueAt(0,"oid").toString());
            if(rs.getValueAt(0,"fecIniPeriodoActual") != null)			   
			  asignarAtributo("VAR", "varFechaInicioPeriodoActual", "valor", dateToString((Date)rs.getValueAt(0,"fecIniPeriodoActual")));
			  //asignarAtributo("VAR", "varFechaInicioPeriodoActual", "valor", rs.getValueAt(0,"fecIniPeriodoActual").toString());
			if(rs.getValueAt(0,"codigo") != null)
			  asignarAtributo("LABELC", "lblCodComisionVigente", "valor", rs.getValueAt(0,"codigo").toString());
			if(rs.getValueAt(0,"version") != null)
			  asignarAtributo("LABELC", "lblVersionVigente", "valor", rs.getValueAt(0,"version").toString());
			if(rs.getValueAt(0,"descripcion") != null )
			  asignarAtributo("LABELC", "lblDescripcionVigente", "valor", rs.getValueAt(0,"descripcion").toString());
			if(rs.getValueAt(0,"tipoComision") != null )
			  asignarAtributo("LABELC", "lblTipoVigente", "valor", rs.getValueAt(0,"tipoComision").toString());
			if(rs.getValueAt(0,"marca") != null)
			  asignarAtributo("LABELC", "lblMarcaVigente", "valor", rs.getValueAt(0,"marca").toString());
			if(rs.getValueAt(0,"canal") != null)
			  asignarAtributo("LABELC", "lblCanalVigente", "valor", rs.getValueAt(0,"canal").toString());
			if(rs.getValueAt(0,"acceso") != null)
			  asignarAtributo("LABELC", "lblAccesoVigente", "valor", rs.getValueAt(0,"acceso").toString());
			if(rs.getValueAt(0,"concepto") != null)
			  asignarAtributo("LABELC", "lblConceptoVigente", "valor", rs.getValueAt(0,"concepto").toString());
		}
	}

	/*
	Guarda el estado seleccionado en PaginaPermitirModificar para la comisión que se está tratando. 
	Proceso 
	======== 
		Se crea DTOPermitirModificar 
		DTOPermitirModificar.oidComision = oidComision 
		DTOPermitirModificar.oidEstado = oidEstado 
		IdNegocio = "COMPermitirModificar" 
		Se invoca al conector ConectorPermitirModificar 
		Se cierra la página.
    */
	// idedough 14/03/2005
	public void guardarPermitirModificar (Long oidComision, Long oidEstado) throws Exception 
	{
		traza("************ Entre a guardarPermitirModificar");
		traza("************ oidComision " + oidComision);
		traza("************ oidEstado " + oidEstado);
		DTOPermitirModificar dtoe = new DTOPermitirModificar();
		if(oidComision != null)
			dtoe.setOidComision(oidComision);
		if(oidEstado != null)
			dtoe.setOidEstado(oidEstado);
		dtoe.setOidPais(lPais);
		dtoe.setOidIdioma(lIdioma);
		MareBusinessID businessID = new MareBusinessID("COMPermitirModificar");
		Vector params = new Vector();
        params.add(dtoe); params.add(businessID);
		//traza("# conectar ->  ConectorPermitirModificar ");
		DruidaConector con = conectar("ConectorPermitirModificar", params);
        //traza("# ....................................................... [OK] ");
		asignarAtributo("VAR", "varOidPais", "valor", sPais);
		asignarAtributo("VAR", "varOidIdioma", "valor", sIdioma);
		// cierra la pagina
		pagina("salidaGenerica"); 
        asignarAtributo("VAR", "cerrarVentana", "valor", "1"); 
        //asignarAtributo("VAR", "ejecutar", "valor", "registroFueraCondicion()");
	}

	
	/*Aceptación de una modificación de una comisión. 
	  Proceso 
	  ======= 
		  Se crea DTOOID 
		  DTOOID.oid = oidComision 
		  IdNegocio = "COMAceptarModificacion" 
		  Se invoca al conector ConectorAceptarModificacion 
		  Se cierra la página.
	*/
	// idedough 14/03/2005
	public void aceptaConfirmarModificar(Long oidComision) throws Exception 
	{
		traza("************ Entre a aceptaConfirmarModificar");
		traza("************ oidComision " + oidComision);
		DTOOID dtoe = new DTOOID();
		dtoe.setOidIdioma(lIdioma);
		dtoe.setOidPais(lPais);
		if(oidComision != null)
			dtoe.setOid(oidComision);
		MareBusinessID businessID = new MareBusinessID("COMAceptarModificacion");
		Vector params = new Vector();
        params.add(dtoe); params.add(businessID);
		traza("# conectar ->  ConectorAceptarModificacion ");
		DruidaConector con = conectar("ConectorAceptarModificacion", params);
        traza("# ....................................................... [OK] ");
		// cierra la pagina
		pagina("salidaGenerica");
		asignarAtributo("VAR", "cerrarVentana", "valor", "1");
	}

    /*Rechazo de una modificación de una comisión. 
	  Proceso 
	  ======= 
		Se crea DTOOID 
		DTOOID.oid = oidComision 
		IdNegocio = "COMRechazarModificacion" 
		Se invoca al conector ConectorRechazarModificacion 
		Se cierra la página.
	*/
    // idedough 14/03/2005
	public void rechazaConfirmarModificar (Long oidComision) throws Exception 
	{
		traza("************ Entre a consultaComision");
		traza("************ oidComision " + oidComision);
		DTOOID dtoe = new DTOOID();
		dtoe.setOidIdioma(lIdioma);
		dtoe.setOidPais(lPais);
		if(oidComision != null)
			dtoe.setOid(oidComision);
		MareBusinessID businessID = new MareBusinessID("COMRechazarModificacion");
		Vector params = new Vector();
        params.add(dtoe); params.add(businessID);
		traza("# conectar ->  ConectorRechazarModificacion ");
		DruidaConector con = conectar("ConectorRechazarModificacion", params);
        traza("# ....................................................... [OK] ");
		// cierra la pagina
		pagina("salidaGenerica");
		asignarAtributo("VAR", "cerrarVentana", "valor", "1");
	}



	/*Carga la pantalla PaginaMarcarModificar 
	Proceso 
	======== 
		Se crean cinco elementos: 
		elem1.idNegocio="COMCodigosComisiones" 
		elem1.dtoe=DTOBelcorp 
		elem2.idNegocio="COMMarcasComisiones" 
		elem2.dtoe=DTOBelcorp 
		elem3.idNegocio="COMCanalesComisiones" 
		elem3.dtoe=DTOBelcorp 
		elem4.idNegocio="COMAccesosComisiones" 
		elem4.dtoe=DTOBelcorp 
		elem5.idNegocio="COMObtenerTipoComision" 
		elem5.dtoe=DTOBelcorp 
		Se llama al subsistema GestorCargaPantalla. 
		Con los datos obtenidos en el ROWSET COMCodigosComisiones se carga la combo cmbCodigo 
		Con los datos obtenidos en el ROWSET COMMarcasComisiones se carga la combo cmbMarca 
		Con los datos obtenidos en el ROWSET COMCanalesComisiones se carga la combo cmbCanal 
		Con los datos obtenidos en el ROWSET COMAccesosComisiones se carga la combo cmbAcceso 
		Con los datos obtenidos en el ROWSET COMObtenerTipoComision se carga la combo cmbTipo
	*/
	// idedough 14/03/2005
	public void cargaMarcarComisiones() throws Exception 
	{   traza("************ Entre a cargaMarcarComisiones");
	    pagina("contenido_comisiones_marcar");
		traza("carga CodigosComisiones ");
		loadCmb("COMCodigosComisiones", "cbCodComision");
		traza("carga MarcasComisiones ");
		loadCmb("COMMarcasComisiones", "cbMarca");
		traza("carga CanalesComisiones ");
		loadCmb("COMCanalesComisiones", "cbCanal");
		traza("carga AccesosComisiones ");
		loadCmb("COMAccesosComisiones", "cbAcceso");
		traza("carga ObtenerTipoComision ");
		loadCmb("COMObtenerTipoComision", "cbTipoComision");
		asignarAtributo("VAR", "varOidPais", "valor", sPais);
		asignarAtributo("VAR", "varOidIdioma", "valor", sIdioma);
	}

	private void loadCmb(String bid, String cmb_name) throws Exception
	{   ComposerViewElementList list = new ComposerViewElementList();
		ComposerViewElement cve = new ComposerViewElement();
		DTOBelcorp dtoe = new DTOBelcorp();
		dtoe.setOidIdioma(lIdioma);
		dtoe.setOidPais(lPais);
		cve.setIDBusiness(bid);
		cve.setDTOE(dtoe);
		list.addViewElement(cve);
		ConectorComposerView conector = new ConectorComposerView(list,this.getRequest());
        conector.ejecucion();
        DruidaConector con = conector.getConector();
        asignar("COMBO", cmb_name, con, bid);
	}

	private void loadCmb(String bid, String cmb_name, ComposerViewElement cve) throws Exception
	{   ComposerViewElementList list = new ComposerViewElementList();
	    cve.setIDBusiness(bid);
		list.addViewElement(cve);
		ConectorComposerView conector = new ConectorComposerView(list,this.getRequest());
        conector.ejecucion();
        DruidaConector con = conector.getConector();
        asignar("COMBO", cmb_name, con, bid);
	}

	public void cargaBuscarModificar(String accion) throws Exception 
	{
		traza("************ Entre a cargaBuscarModificar");
		traza("************ accion " + accion);
	  /*Carga la pantalla PaginaBuscarModificar 

		Proceso 
		======== 
		Se carga la variable oculta de la pantalla: 
		varAccion = accion 

		Se crea la variable DTOEstado dtoEstado 

		Se crea la variable DTOEstados dtoE que se carga: 
		dtoE.idioma = idioma de la sesión 

		Si accion == "CopiarComisiones" 
		Hace visible el botón btnCopiar 
		Hace invisibles los botones btnModificar y btnDetalle 
		Hace invisible el combo cmbEstado (en este caso el estado siempre es "Activa") 
		Fin del Si 

		Si accion == "EliminarComisiones" ó accion == "ConsultarComisiones" 
		Hace visible el botón btnDetalle 
		Hace invisibles los botones btnModificar y btnCopiar 
		Fin del Si 

		Si accion == "ModificarComisiones" 
		Hace visible el botón btnModificar 
		Hace invisibles los botones btnDetalle y btnCopiar 

		dtoEstado.oidEstadoComision = ConstantesCOM.ESTADO_COMISION_EN_CREACION 
		Se añade dtoEstado a dtoE.estados 

		dtoEstado.oidEstadoComision = ConstantesCOM.ESTADO_COMISION_SOLICITUD_ACEPTADA 
		Se añade dtoEstado a dtoE.estados 
		Fin del Si 

		Se crean cinco elementos: 

		elem1.idNegocio="COMCodigosComisiones" 
		elem1.dtoe=DTOBelcorp 

		elem2.idNegocio="COMMarcasComisiones" 
		elem2.dtoe=DTOBelcorp 

		elem3.idNegocio="COMCanalesComisiones" 
		elem3.dtoe=DTOBelcorp 

		elem4.idNegocio="COMAccesosComisiones" 
		elem4.dtoe=DTOBelcorp 

		elem5.idNegocio="COMObtenerTipoComision" 
		elem5.dtoe=DTOBelcorp 

		Si cmbEstado está visible 
		Se crea el elemento: 
		elem6.idNegocio="COMEstadosComisiones" 
		elem6.dtoe=dtoE 
		Fin del Si 

		Se llama al subsistema GestorCargaPantalla. 

		Con los datos obtenidos en el ROWSET COMCodigosComisiones se carga la combo cmbCodigo 

		Con los datos obtenidos en el ROWSET COMMarcasComisiones se carga la combo cmbMarca 

		Con los datos obtenidos en el ROWSET COMCanalesComisiones se carga la combo cmbCanal 

		Con los datos obtenidos en el ROWSET COMAccesosComisiones se carga la combo cmbAcceso 

		Con los datos obtenidos en el ROWSET COMObtenerTipoComision se carga la combo cmbTipo 

		Si cmbEstado está visible 
		Con los datos obtenidos en el ROWSET COMEstadosComisiones se carga la combo cmbEstado 
		Fin del Si*/


	}

	public void copiaComision(Long oidComision) throws Exception 
	{
  		traza("************ Entre a copiaComision");
  		traza("************ oidComision " + oidComision);

		/*Crea una comisión copia de otra. 
		Proceso 
		======== 
		Se crea DTOOID 

		DTOOID.oid = oidComision 

		IdNegocio = "COMCopiarComision" 

		Se invoca al conector ConectorCopiarComision*/
	}

	public void eliminaComision (Long oidComision) throws Exception 
	{
  		traza("************ Entre a eliminaComision");
  		traza("************ oidComision " + oidComision);

		/*Elimina una comisión. 

		Proceso 
		======== 
		Se crea DTOOID 

		DTOOID.oid = oidComision 

		IdNegocio = "COMEliminarComision" 

		Se invoca al conector ConectorEliminarComision*/

	}

	private void cargarMenuSecundario() throws Exception 
	{     
  		traza("************ Entre a cargarMenuSecundario");
  		traza("************ accion " + accion);

		if ("InsertarComisiones".equals(accion)) {
			getConfiguracionMenu("LPMantenimientoComisiones","InsertarComisiones");
		}
		else if ("AceptarModificacion".equals(accion)) { 
			getConfiguracionMenu("LPDosMantenimientoComisiones","");
		}
		else if ("PermitirModificar".equals(accion)) {
			getConfiguracionMenu("LPDosMantenimientoComisiones","");
		}
		else if ("ConfirmarModificar".equals(accion)) {
			getConfiguracionMenu("LPDosMantenimientoComisiones","");
		}
		else if ("MarcarComisiones".equals(accion))
		{
            getConfiguracionMenu("LPDosMantenimientoComisiones","MarcarComisiones");
		}
		/*else if ("ConfirmarRechazar".equals(accion))
		{
            getConfiguracionMenu("LPDosMantenimientoComisiones","");
		}
		else if ("ConfirmarAceptar".equals(accion))
		{
            getConfiguracionMenu("LPDosMantenimientoComisiones","");
		}*/
    }
    
	//------------------------- UTILITIES ------------------------------------------------
    private Date toDate(String sFecha) throws Exception
    {   String formatoFecha = UtilidadesSession.getFormatoFecha(this);
        return this.toDate(sFecha, formatoFecha);
    }

    private Date toDate(String sFecha, String formatoFecha) throws Exception 
    {		
        formatoFecha = formatoFecha.replace('m', 'M');	
        SimpleDateFormat miFecha = new SimpleDateFormat(formatoFecha);
        java.util.Date fecha = miFecha.parse(sFecha);
        miFecha = new SimpleDateFormat(formatoFecha);
        String fechaRes = miFecha.format(fecha);
        fecha = miFecha.parse(fechaRes);
        java.sql.Date sql = new java.sql.Date(fecha.getTime());    
        //traza("************** sql " + sql);  	  	  
        return sql;
    }
	private String dateToString(Date dFecha) throws Exception
    {
        String formato = UtilidadesSession.getFormatoFecha(this);
        formato = formato.replace('m', 'M');
        SimpleDateFormat miFecha = new SimpleDateFormat(formato);
        String fechaRes = miFecha.format(dFecha);		  	  	  
        return fechaRes;
    }
}
