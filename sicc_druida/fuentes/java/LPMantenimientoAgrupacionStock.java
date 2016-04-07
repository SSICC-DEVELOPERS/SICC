/*
 * Copyright 2003 © por Indra Sistemas,S.A.. Todos los derechos reservados.
 * Avda. de Bruselas, 35
 * Parque Empresarial Arroyo de la Vega
 * 28108 Alcobendas, Madrid
 * España
 *
 * Privado y Confidencial.
 * La información contenida en este documento es propiedad de Indra sistemas.
 * Para uso exclusivo de empleados autorizados no permitiéndose
 * la distribución de este código sin permiso expreso.
 */
 
import java.io.ByteArrayOutputStream;
import java.io.PrintStream; 
import java.util.Vector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.Enumeration;

import es.indra.druida.DruidaConector;

import es.indra.mare.common.mln.MareBusinessID;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOBelcorp;

import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;

import es.indra.sicc.cmn.negocio.i18n.DTOI18nSICC;

import es.indra.sicc.dtos.bel.DTOAgrupacionStock;
import es.indra.sicc.dtos.bel.DTOAgrupacionStockCabecera;
import es.indra.sicc.dtos.bel.DTOAgrupacionStockDetalle;
 
public class LPMantenimientoAgrupacionStock extends LPSICCBase {

	private String casoUso = "";
	private String accion = null;
	public LPMantenimientoAgrupacionStock() {
		super();
	}
          
	public void inicio() throws Exception {
	}

	public void ejecucion() throws Exception {
		setTrazaFichero();
		traza("*** Entrada - LPMantenimientoAgrupacionStock - ejecucion ***");
		try  {
			this.accion  = conectorParametroLimpia("accion","",true);
            
			if (this.accion.equals("insertar")) {
				this.casoUso = "insertar";
				cargarPaginaInsertar();
            } else if (this.accion.equals("modificar")) {
            	this.casoUso = "modificar";
            	cargarPaginaBuscar();
        	} else if (this.accion.equals("consultar")) {
        		this.casoUso = "consultar";
            	cargarPaginaBuscar();
        	} else if (this.accion.equals("eliminar")) {
        		this.casoUso = "eliminar";
            	cargarPaginaBuscar();
        	} else if (this.accion.equals("detalle")) {
        		this.casoUso = conectorParametroLimpia("casoUso","",true);
        		cargarPaginaInsertar();
        	} else if (this.accion.equals("anadirDetalle")) {
        		this.casoUso = conectorParametroLimpia("casoUso","",true);
        		cargarPaginaAnadirDetalle();
        	} else if (this.accion.equals("modificarDetalle")) {
        		this.casoUso = conectorParametroLimpia("casoUso","",true);
        		cargarPaginaModificarDetalle();
        	} else if (this.accion.equals("guardar")) {
        		guardar();
        	}
        	
        	if(this.casoUso.equals("insertar")){
        		getConfiguracionMenu("LPMantenimientoAgrupacionStock",this.casoUso);
        	}
        	if(this.casoUso.equals("eliminar")){
        		getConfiguracionMenu("LPMantenimientoAgrupacionStock",this.casoUso);
        	}
        	if(this.casoUso.equals("modificar")){
        		getConfiguracionMenu("LPMantenimientoAgrupacionStock",this.casoUso);
        	}
        	if(this.casoUso.equals("consultar")){
        		getConfiguracionMenu("LPMantenimientoAgrupacionStock",this.casoUso);
        	}
        	if((this.accion.equals("detalle"))&&(this.casoUso.equals("modificar"))){
        		getConfiguracionMenu("LPMantenimientoAgrupacionStock","modificarDetalle");	
        	}
        	if((this.accion.equals("detalle"))&&(this.casoUso.equals("consultar"))){
        		getConfiguracionMenu("LPMantenimientoAgrupacionStock","consultarDetalle");
        	}
        	if((this.accion.equals("detalle"))&&(this.casoUso.equals("eliminar"))){
        		getConfiguracionMenu("LPMantenimientoAgrupacionStock","eliminarDetalle");
        	}
        	if((this.accion.equals("modificarDetalle"))&&(this.casoUso.equals("modificar"))){
        		getConfiguracionMenu("LPMantenimientoAgrupacionStock","ModificardetalleModificar");
        	}else if (this.accion.equals("modificarDetalle")) {
        		getConfiguracionMenu("LPMantenimientoAgrupacionStock","detalleModificar");
        	}
        	if((this.accion.equals("anadirDetalle"))&&(this.casoUso.equals("modificar"))){
        		getConfiguracionMenu("LPMantenimientoAgrupacionStock","anadirDetalleModificar");
        	}else if (this.accion.equals("anadirDetalle")) {
        		getConfiguracionMenu("LPMantenimientoAgrupacionStock","anadirDetalle");
        	}
        	
        	
		} catch (Exception e) {
			logStackTrace(e);
			this.lanzarPaginaError(e);
		}
		traza("*** Salida - LPMantenimientoAgrupacionStock - ejecucion ***");
	}
	
	private void cargarPaginaInsertar() throws Exception {
		traza("*** Entrada - LPMantenimientoAgrupacionStock - cargarPaginaInsertar ***");
		pagina("contenido_agrupacion_stock_insertar");
		
		if (this.casoUso == null) {
			this.casoUso = conectorParametroLimpia("casoUso","",true);
		}
		
		asignarAtributo("VAR","accion","valor",this.accion);
		asignarAtributo("VAR","casoUso","valor",this.casoUso);
		String strOidAgrupacionStockCabecera = conectorParametroLimpia("oidAgrupacionStockCabecera","",true);
		Long oidAgrupacionStockCabecera = null;
		if (!strOidAgrupacionStockCabecera.equals("")) {
			oidAgrupacionStockCabecera = new Long(strOidAgrupacionStockCabecera);
		}
		if (this.casoUso.equals("modificar") || this.casoUso.equals("consultar") || 
			this.casoUso.equals("eliminar")) {
			// Se obtiene el oid
			String strOid = conectorParametroLimpia("oidAgrupacionStock","",true);
			Long oid = null;
			if (!strOid.equals("")) {
				oid = new Long(strOid);
			}
			// Se obtiene el pais e idioma de sesion
			Long pais = UtilidadesSession.getPais(this);
			Long idioma = UtilidadesSession.getIdioma(this);
			
			// Se crea un DTOOID
			DTOOID dtoOID = new DTOOID();
			dtoOID.setOidPais(pais);
			dtoOID.setOidIdioma(idioma);
			dtoOID.setOid(oid);
			
			// idBusiness = "BELConsultarAgrupacionStock"
			MareBusinessID idBusiness = new MareBusinessID("BELConsultarAgrupacionStock");
			
			Vector paramEntrada = new Vector();
			paramEntrada.add(dtoOID);
			paramEntrada.add(idBusiness);
			
			// Se invoca al conector 
			DruidaConector conector = conectar("ConectorConsultarAgrupacionStock",paramEntrada);
			
			// Se obtiene el DTOAgrupacionStock devuelto por el conector
			DTOAgrupacionStock dtoAgrupacion = (DTOAgrupacionStock)conector.objeto("DTOAgrupacionStock");
			
			// Se obtiene la cabecera y el detalle de la agrupacion de stock
			DTOAgrupacionStockCabecera cabecera = dtoAgrupacion.getCabecera();
			ArrayList detalles = dtoAgrupacion.getDetalle();
			// Se muestran los datos de cabecera en los campos de la pantalla
			String codigoAS = cabecera.getCodigoASC();
			asignarAtributo("CTEXTO","txtCodAgrupacionStock","valor",(codigoAS != null) ? codigoAS : "" );
			String descripcion = cabecera.getDescripcion();
			asignarAtributo("CTEXTO","txtDescripcion","valor",(descripcion != null) ? descripcion : "" );
			Boolean indicadorDefecto = cabecera.getIndicadorDefecto();
			String valorIndicador = "N";
			if (indicadorDefecto != null && indicadorDefecto.booleanValue()) {
				valorIndicador = "S";
			}
			
			// Se desactivan los dos radio buttons
			asignarAtributo("RBINPUT","rbIndicadorDefecto_S","check","N");
			asignarAtributo("RBINPUT","rbIndicadorDefecto_N","check","N");
                                    
			// Se activa el radio button correspondiente
			String nombreRadio = "rbIndicadorDefecto_"+valorIndicador;
			asignarAtributo("RBINPUT",nombreRadio,"check","S");
			
			//Se guardan los datos en los hidden
			asignarAtributo("VAR","indicadorDef","valor",valorIndicador);
			asignarAtributo("VAR","codAgrupacionStock","valor",codigoAS);
			asignarAtributo("VAR","descripcion","valor",descripcion);
						
			oidAgrupacionStockCabecera = cabecera.getOidAgrupacionStockCabecera();
			asignarAtributo("VAR","oidAgrupacionStockCabecera","valor",
				oidAgrupacionStockCabecera.toString());
			
			// Se recorre la lista de detalles y se crea un recordset
			RecordSet rs = new RecordSet();
			rs.addColumn("oidAgrupacionStockDetalle");
			rs.addColumn("descripcionEstadoMercancia");
			rs.addColumn("operacion");
			rs.addColumn("oidEstadoMercancia");
			
			for (Iterator i = detalles.iterator(); i.hasNext(); ) {
				DTOAgrupacionStockDetalle detalle = (DTOAgrupacionStockDetalle)i.next();
				
				Long oidAgrupacionStockDetalle = detalle.getOidAgrupacionStockDetalle();
				String descripcionEstadoMercancia = detalle.getDescripcionEstadoMercancia();
				Character operacion = detalle.getOperacion();
				Long oidEstadoMercancia = detalle.getOidEstadoMercancia();
				
				Vector fila = new Vector();
				fila.add(oidAgrupacionStockDetalle);
				fila.add(descripcionEstadoMercancia);
				fila.add(operacion);
				fila.add(oidEstadoMercancia);
				
				rs.addRow(fila);
			}
			//Bloqueo de los radio button
			if((this.casoUso.equals("consultar"))||(this.casoUso.equals("eliminar"))){
				asignarAtributoElemento("rbIndicadorDefecto","disabled","S");
				
			}
			// Se asigna el recordset a la lista editable
			Vector cols = rs.getColumnIdentifiers();
			DruidaConector conectorLista = UtilidadesBelcorp.generarConector("DTOSalida.resultado", rs, cols);
			asignar("LISTAEDITABLE", "listado1", conectorLista, "DTOSalida.resultado");			
		}
		if(this.casoUso.equals("modificar") || this.casoUso.equals("insertar")){
			anyadeHiddensI18N(true,"BEL_AGRUP_STOCK_CABEC",oidAgrupacionStockCabecera,new Integer(1),"formulario","txtDescripcion",false);
		}else{
			anyadeHiddensI18N(true,"BEL_AGRUP_STOCK_CABEC",oidAgrupacionStockCabecera,new Integer(1),"formulario","txtDescripcion",true);
		}
		if(this.accion.equals("insertar")){
			asignarAtributo("PAGINA","contenido_agrupacion_stock_insertar","cod","0392");
			asignarAtributo("PAGINA","contenido_agrupacion_stock_insertar","msgle","Insertar Agrupación Stock"); 	
		}else if(this.casoUso.equals("eliminar")){
			asignarAtributo("PAGINA","contenido_agrupacion_stock_insertar","cod","0395");
			asignarAtributo("PAGINA","contenido_agrupacion_stock_insertar","msgle","Eliminar Agrupación Stock"); 
		}else if(this.casoUso.equals("modificar")){
			asignarAtributo("PAGINA","contenido_agrupacion_stock_insertar","cod","0393");
			asignarAtributo("PAGINA","contenido_agrupacion_stock_insertar","msgle","Modificar Agrupación Stock"); 
		}else if(this.casoUso.equals("consultar")){
			asignarAtributo("PAGINA","contenido_agrupacion_stock_insertar","cod","0394");
			asignarAtributo("PAGINA","contenido_agrupacion_stock_insertar","msgle","Consultar Agrupación Stock"); 
		}
		traza("*** Salida - LPMantenimientoAgrupacionStock - cargarPaginaInsertar ***");
	}
	
	private void cargarPaginaBuscar() throws Exception {
		traza("*** Entrada - LPMantenimientoAgrupacionStock - cargarPaginaBuscar ***");
		
		pagina("contenido_agrupacion_stock_modificar");
		// Se obtiene el pais e idioma de sesion
		Long pais = UtilidadesSession.getPais(this);
		Long idioma = UtilidadesSession.getIdioma(this);
		
		asignarAtributo("VAR","accion","valor",this.casoUso);
		asignarAtributo("VAR","casoUso","valor",this.casoUso);
		asignarAtributo("VAR","oidIdioma","valor",idioma.toString());
		asignarAtributo("VAR","oidPais","valor",pais.toString());
		
		if(this.accion.equals("eliminar")){
			asignarAtributo("PAGINA","contenido_agrupacion_stock_modificar","cod","0395");
			asignarAtributo("PAGINA","contenido_agrupacion_stock_modificar","msgle","Eliminar Agrupación Stock"); 
		}else if(this.accion.equals("modificar")){
			asignarAtributo("PAGINA","contenido_agrupacion_stock_modificar","cod","0393");
			asignarAtributo("PAGINA","contenido_agrupacion_stock_modificar","msgle","Modificar Agrupación Stock"); 
		}else if(this.accion.equals("consultar")){
			asignarAtributo("PAGINA","contenido_agrupacion_stock_modificar","cod","0394");
			asignarAtributo("PAGINA","contenido_agrupacion_stock_modificar","msgle","Consultar Agrupación Stock"); 
		}
				
		traza("*** Salida - LPMantenimientoAgrupacionStock - cargarPaginaBuscar ***");
	}
	
	private void cargarPaginaAnadirDetalle() throws Exception {
		traza("*** Entrada - LPMantenimientoAgrupacionStock - cargarPaginaAnadirDetalle ***");
		
		pagina("contenido_agrupacion_stock_insertar_detalle");
		if(this.accion.equals("insertar")){
			asignarAtributo("PAGINA","contenido_agrupacion_stock_insertar_detalle","cod","0392");
		}
		if(this.casoUso.equals("modificar")){
			asignarAtributo("PAGINA","contenido_agrupacion_stock_insertar_detalle","cod","0393");
		}
		// Se obtiene el pais e idioma de sesion
		Long pais = UtilidadesSession.getPais(this);
		Long idioma = UtilidadesSession.getIdioma(this);
			
		// Se crea un DTOBelcorp
		DTOBelcorp dtoBelcorp = new DTOBelcorp();
		dtoBelcorp.setOidPais(pais);
		dtoBelcorp.setOidIdioma(idioma);
		
		// Se llama al subsistema de carga de pantalla
		ComposerViewElementList listelem = new ComposerViewElementList();
		ComposerViewElement elem = new ComposerViewElement();
        elem.setIDBusiness("BELObtenerEstadosMercancia");
        elem.setDTOE(dtoBelcorp);
        listelem.addViewElement(elem);
		
		ConectorComposerView conector = new ConectorComposerView(listelem, this.getRequest());
		conector.ejecucion();
		DruidaConector conConsultar = conector.getConector();
		
		// Se carga el combo estado
		asignar("COMBO","cbEstado",conConsultar,"BELObtenerEstadosMercancia");
		asignarAtributo("VAR","accion","valor","anadir");
		
		// Se asigna valor al campo oculto oidEstadoMercancia
		String oidEstadoMercancia = conectorParametroLimpia("oidEstadoMercancia","",true);
		asignarAtributo("VAR","oidEstadoMercancia","valor",oidEstadoMercancia);

		traza("*** Salida - LPMantenimientoAgrupacionStock - cargarPaginaAnadirDetalle ***");
	}
	
	private void cargarPaginaModificarDetalle() throws Exception {
		traza("*** Entrada - LPMantenimientoAgrupacionStock - cargarPaginaModificarDetalle ***");
		
		pagina("contenido_agrupacion_stock_insertar_detalle");
		if(this.accion.equals("insertar")){
			asignarAtributo("PAGINA","contenido_agrupacion_stock_insertar_detalle","cod","0392");
		}
		if(this.casoUso.equals("modificar")){
			asignarAtributo("PAGINA","contenido_agrupacion_stock_insertar_detalle","cod","0393");
		}
		
		String oidEstadoMercancia = conectorParametroLimpia("oidEstadoMercancia","",true);
		// Falta la descripción internacionalizada del estado 
		String descripcion = conectorParametroLimpia("descripcion","",true);
		String operacion = conectorParametroLimpia("operacion","",true);
		String codOperacion = conectorParametroLimpia("codOperacion","",true);
		String codDescrip = conectorParametroLimpia("codDescrip","",true);
		//Cargamos combo estado
		Vector valores = new Vector();
        valores.add(codDescrip);
        valores.add(descripcion);
        
        RecordSet rs = new RecordSet();
        rs.addColumn("CODIGO");
        rs.addColumn("DESCRIPCION");
        rs.addRow(valores);
        
        Vector cols = rs.getColumnIdentifiers();
        DruidaConector conectorCargaCombo = UtilidadesBelcorp.generarConector( "DTOSalida.combo_ROWSET", rs, cols);
        asignar("COMBO", "cbEstado", conectorCargaCombo, "DTOSalida.combo_ROWSET", cols.get(1).toString(), 
                 descripcion);
		
		// Se asigna el valor modificar a la variable oculta accion
		asignarAtributo("VAR","accion","valor","modificar");
		// Se asigna el valor del oidEstadoMercancia a la variable oculta del mismo nombre
		asignarAtributo("VAR","oidEstadoMercancia","valor",oidEstadoMercancia);
		// Se asigna el valor modificar a la variable oculta operacion
		asignarAtributo("VAR","operacion","valor",operacion);
		// Se asigna el valor modificar a la variable oculta codOperacion
		asignarAtributo("VAR","codOperacion","valor",codOperacion);
		// Se asigna el valor modificar a la variable oculta codDescrip
		asignarAtributo("VAR","codDescripcion","valor",codDescrip);

		traza("*** Salida - LPMantenimientoAgrupacionStock - cargarPaginaModificarDetalle ***");
	}
	
	private void guardar() throws Exception {
		traza("*** Entrada - LPMantenimientoAgrupacionStock - guardar ***");
		
		pagina("salidaGenerica");
		//Asignamos valor al hidden ejecutar
		asignar("VAR","ejecutar","fGuardadoCorrecto()");
		
		DTOAgrupacionStock dtoAgrupacion = new DTOAgrupacionStock();
		
		// Se obtienen los parámetros de la página
		String strOidAgrupacionStockCabecera = conectorParametroLimpia("oidAgrupacionStockCabecera","",true);
		Long oidAgrupacionStockCabecera = null;
		if (!strOidAgrupacionStockCabecera.equals("")) {
			oidAgrupacionStockCabecera = new Long(strOidAgrupacionStockCabecera);
		}
		String codigoAgrupacionStock = conectorParametroLimpia("txtCodAgrupacionStock","",true);
		String strIndicadorDefecto = conectorParametroLimpia("rbIndicadorDefecto","",true);
		Boolean indicadorDefecto = new Boolean(false);
		if (strIndicadorDefecto != null && strIndicadorDefecto.equals("S")) {
			indicadorDefecto = new Boolean(true);
		}	
		// Se rellena un DTOAgrupacionStockCabecera
		DTOAgrupacionStockCabecera cabecera = new DTOAgrupacionStockCabecera();
		cabecera.setOidAgrupacionStockCabecera(oidAgrupacionStockCabecera);
		cabecera.setCodigoASC(codigoAgrupacionStock);
		DTOI18nSICC attriTraducible[] = this.rellenaAtributoTraducible(new Integer(1));
		ArrayList atribuTraduci = new ArrayList();
		for(int i=0;i < attriTraducible.length;i++){
			 	atribuTraduci.add(attriTraducible[i]);
		}
		cabecera.setAttTraducible(atribuTraduci);
		cabecera.setIndicadorDefecto(indicadorDefecto);
		dtoAgrupacion.setCabecera(cabecera);
		
		// Con los datos de la lista construir un objeto DTOAgrupacionStockDetalle 
		// por registro y meterlo en un arrayList 
		String lista = conectorParametroLimpia("lista","",true);
		
		ArrayList detallesList = new ArrayList();
		StringTokenizer st = new StringTokenizer(lista,"#");
		while (st.hasMoreTokens()) {
			String fila = st.nextToken();
			DTOAgrupacionStockDetalle detalle = new DTOAgrupacionStockDetalle();
			
			StringTokenizer stFila = new StringTokenizer(fila,"@");
			while (stFila.hasMoreTokens()) {
				String descripcionEstadoMercancia = stFila.nextToken();
				String strOperacion = stFila.nextToken();
				Character operacion = new Character(strOperacion.charAt(0));
				String strOidEstadoMercancia = stFila.nextToken();
				Long oidEstadoMercancia = new Long(strOidEstadoMercancia);
				if(stFila.hasMoreTokens()){
					String oidOperacion = stFila.nextToken();
				}
				detalle.setDescripcionEstadoMercancia(descripcionEstadoMercancia);
				detalle.setOperacion(operacion);
				detalle.setOidEstadoMercancia(oidEstadoMercancia);
				
				detallesList.add(detalle);
			}	
		}
		
		dtoAgrupacion.setDetalle(detallesList);
		
		// Se obtiene el pais e idioma de sesion
		Long pais = UtilidadesSession.getPais(this);
		Long idioma = UtilidadesSession.getIdioma(this);
		
		dtoAgrupacion.setOidPais(pais);
		dtoAgrupacion.setOidIdioma(idioma);
		
		// idBusiness = "BELGuardarAgrupacionStock"
		MareBusinessID idBusiness = new MareBusinessID("BELGuardarAgrupacionStock");
			
		Vector paramEntrada = new Vector();
		paramEntrada.add(dtoAgrupacion);
		paramEntrada.add(idBusiness);
		
		// Se invoca al conector 
		DruidaConector conector = conectar("ConectorGuardarAgrupacionStock",paramEntrada);
				
		traza("*** Salida - LPMantenimientoAgrupacionStock - guardar ***");
	}
	
    private void logStackTrace(Throwable e) throws Exception {
		traza("Se produjo la excepcion: " + e.getMessage());
                    
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		e.printStackTrace(ps);
                    
		traza("Stack Trace: " + baos.toString());
     }
     
     private DTOI18nSICC[] rellenaAtributoTraducible(Integer num) throws Exception {
		DTOI18nSICC attriTraducible[] = null;
		Vector traducciones = recuperaTraduccionesI18N(num);
		if (traducciones != null) {
			attriTraducible = new DTOI18nSICC[traducciones.size()];
                  
			int i = 0;
			for (Enumeration e = traducciones.elements(); e.hasMoreElements(); i++) {
				attriTraducible[i] = (DTOI18nSICC)e.nextElement();
			} 
		}
		
		return attriTraducible;
	}
}

