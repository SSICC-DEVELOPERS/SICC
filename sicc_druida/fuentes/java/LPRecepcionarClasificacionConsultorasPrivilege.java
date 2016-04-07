/**
 * Copyright 2005 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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
 
import es.indra.druida.DruidaConector;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.cmn.negocio.interfaces.IGestorInterfaces;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOString;
import es.indra.sicc.util.DTOSalida;
import java.util.Vector;
import java.util.ArrayList;
import java.util.StringTokenizer;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.dtos.intsys.DTOINTRecepcionarClasificacion;
import es.indra.sicc.dtos.intsys.DTOCargaInicialInterfaz;
 
 public class LPRecepcionarClasificacionConsultorasPrivilege extends LPSICCBase {
	private String accion;
	private Long pais;
	private Long idioma;
	
	public LPRecepcionarClasificacionConsultorasPrivilege() { super(); }
	
	public void inicio() throws Exception {
		pagina("contenido_clasificacion_consultoras_recepcionar");
	    this.getFormatosValidaciones();
	}
	
	public void ejecucion() throws Exception {
		setTrazaFichero();
		traza("*** Entrada - LPRecepcionarClasificacionConsultorasPrivilege.ejecucion()");         
		
		this.accion = conectorParametroLimpia("accion", "", true);
		this.idioma = UtilidadesSession.getIdioma(this);
		this.pais = UtilidadesSession.getPais(this);

		getConfiguracionMenu("LPRecepcionarClasificacionConsultorasPrivilege", "");
		asignarAtributoPagina("cod","01020");      

		try{				
			if (accion.equals("")){
				cargarPantalla();

				traza("*** Sin hardcodear");         
				DTOCargaInicialInterfaz dtoSalida = null;
				Vector paramConector = new Vector();
				DTOString dto = new DTOString();
				
				dto.setCadena(IGestorInterfaces.COD_INTERFAZ_CPR1);
				dto.setOidPais(pais);
				dto.setOidIdioma(idioma);
					  
				paramConector.add(dto);
				paramConector.add(new MareBusinessID("INTCargaInicialInterfaz"));

				traza("**** Antes de conectar");			
				DruidaConector conector = conectar("ConectorObjeto", paramConector);
				traza("**** Despues de conectar");			
				dtoSalida = (DTOCargaInicialInterfaz)conector.objeto("DTOSalida");
				traza ("**** DTOCargaInicialInterfaz: "+ dtoSalida);
				
				//Con el DTOCargaInicialInterfaz obtenido cargamos los campos txtNumeroLote 
				//y txtObservaciones con los atributos numeroLote e observaciones
				traza("***** Antes de rellenar campos");   

				asignarAtributo("AREATEXTO","atxtObservaciones","valor",dtoSalida.getDescripcion());          				
				asignar("VAR","observaciones", dtoSalida.getDescripcion());
				asignar("LABELC","lblvalorLote",dtoSalida.getNumeroLote().toString());
				asignar("VAR","numeroLote",dtoSalida.getNumeroLote().toString());
				asignar("LABELC","lblvalorInterface",IGestorInterfaces.COD_INTERFAZ_CPR1);
			}
			else if (accion.equals("recepcionar")){
				recepcionarClasificacion();
			}
		}
		catch(Exception  e){
			traza("ERROR: " + e);
			e.printStackTrace();
			lanzarPaginaError(e);  
		}
		traza("*** Salida - LPRecepcionarClasificacionConsultorasPrivilege.ejecucion()");         
	}

	private void cargarPantalla() throws Exception {
		traza("*** Entrada - LPRecepcionarClasificacionConsultorasPrivilege.cargarPantalla()");         
		DTOBelcorp dto = new DTOBelcorp();
		dto.setOidPais(this.pais);
        dto.setOidIdioma(this.idioma);

  	    MareBusinessID id = new MareBusinessID("INTCPRCargaInicial");
        Vector params = new Vector();
        params.add(dto);          
        params.add(id);

 	    DruidaConector dc = this.conectar("ConectorRecepcionarClasificacionCargaInicial", params);
        DTOSalida dtoSalida = (DTOSalida)dc.objeto("dtoSalida");
		RecordSet rs = dtoSalida.getResultado();
		traza("**** rs " + rs);
		
		asignar("COMBO", "cbModEjecucion", UtilidadesBelcorp.generarConector("dtoSalida", rs, rs.getColumnIdentifiers()));
		traza("*** Salida - LPRecepcionarClasificacionConsultorasPrivilege.cargarPantalla()");         
	}

	private void recepcionarClasificacion() throws Exception {
		traza("*** Entrada - LPRecepcionarClasificacionConsultorasPrivilege.recepcionarClasificacion()");         
        pagina("salidaGenerica");

		String modoEjecucion = conectorParametroLimpia("modoEjecucion","",true);
        traza("** modoEjecucion: " + modoEjecucion);

		String numeroLote = conectorParametroLimpia("numeroLote","",true);
        traza("** numeroLote: " + numeroLote);

		String descripcionLote = conectorParametroLimpia("descripcionLote","",true);
        traza("** descripcionLote: " + descripcionLote);

		String observaciones = conectorParametroLimpia("observaciones","",true);
        traza("** observaciones: " + observaciones);
		
		DTOINTRecepcionarClasificacion dto = new DTOINTRecepcionarClasificacion();
	    dto.setModoEjecucion(Long.valueOf(modoEjecucion));		
		dto.setNumeroLote(Long.valueOf(numeroLote));
		dto.setDescripcionLote(descripcionLote);
		dto.setObservaciones(observaciones);

		dto.setPais(pais.toString());
		dto.setIdioma(idioma.toString());

		MareBusinessID id = new MareBusinessID("INTCPRRecepcionarClasificacion");
        Vector params = new Vector();
        params.add(dto);          
        params.add(id);

		try {
			DruidaConector dc = this.conectar("ConectorRecepcionarClasificacionConsultorasPrivilege", params);
			traza("*** Salida - LPRecepcionarClasificacionConsultorasPrivilege.recepcionarClasificacion()");       	
			asignarAtributo("VAR", "ejecutar", "valor", "reInicio()");          			
		}
		catch(Exception e) {
			asignarAtributo("VAR", "ejecutarError", "valor", "errorEnRecepcionar()");          
			throw e;
		} 
	}
}