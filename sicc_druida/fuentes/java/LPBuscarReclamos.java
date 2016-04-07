/**
 * Copyright 2004 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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

import java.io.PrintStream;
import java.io.ByteArrayOutputStream;
import java.util.Vector;
import es.indra.sicc.dtos.ccc.DTOBancoSucursal;
import es.indra.sicc.dtos.ccc.DTOBuscarReclamos;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.druida.DruidaConector;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.dtos.ccc.DTOCargaInicialReclamos;
import es.indra.sicc.util.DTOSalida;

public class LPBuscarReclamos extends LPSICCBase {
	
	private String accion = null;
	
	public LPBuscarReclamos() {
		super();
	}


	public void inicio() throws Exception {
		pagina("contenido_reclamos_buscar");

	}
	public void ejecucion() throws Exception {
		//Se sustituye la accion buscar debido a la incidencia BELC300003493
		setTrazaFichero();
		try  {	
			traza("LPBuscarReclamos Entrada");
			this.accion = conectorParametroLimpia("accion", "", true);
			Long idioma = UtilidadesSession.getIdioma(this);
			traza("Idioma de Session: "+idioma);
			asignar("VAR", "hIdioma", idioma.toString());
			Long pais = UtilidadesSession.getPais(this);
			asignar("VAR", "hPais", pais.toString());
			
			this.accionVacia(idioma, pais);				
			traza("LPBuscarReclamos Salida");			
		}catch ( Exception e )  {
			e.printStackTrace();
			this.logStackTrace(e);
			lanzarPaginaError(e);
		}
	}
	

	
	
	private void accionVacia(Long idioma,Long pais) throws Exception{
		traza("LPBuscarReclamos.accionVacia Entrada");
		
		try{
			Byte longitud = this.obtenerLongitudCodigoCliente();
			Long longitudCodigoCliente = new Long(longitud.longValue());
			asignarAtributo("VAR","longitudCodigoCliente","valor",longitudCodigoCliente.toString());			
			
			String casoUso=conectorParametroLimpia("casoUso", "", true);
			if(casoUso.equals("consultarReclamo")){
				asignarAtributo("VAR","casoUso","valor","consultarReclamo");
				asignarAtributo("PAGINA","reclamos_buscar","cod","0534");	
				asignarAtributo("PAGINA","reclamos_buscar","msgle","Buscar reclamos");	
				getConfiguracionMenu("LPBuscarReclamos", "consultar");
			}else if(casoUso.equals("eliminarReclamo")){
				asignarAtributo("VAR","casoUso","valor","eliminarReclamo");
				asignarAtributo("PAGINA","reclamos_buscar","cod","0535");	
				asignarAtributo("PAGINA","reclamos_buscar","msgle","Eliminar reclamos");	
				getConfiguracionMenu("LPBuscarReclamos", "eliminar");				
			}else if(casoUso.equals("modificarReclamo")){
				asignarAtributo("VAR","casoUso","valor","modificarReclamo");
				asignarAtributo("PAGINA","reclamos_buscar","cod","0533");	
				asignarAtributo("PAGINA","reclamos_buscar","msgle","Consultar reclamos");	
				getConfiguracionMenu("LPBuscarReclamos", "modificar");						
			}
			
			this.generarHiddenFormatoFecha();
			//String descPais = UtilidadesSession.getDescripcionPais(this);
			//traza("Descripcion de Pais: "+descPais);
			//asignar("LABELC", "lblPaisActual", descPais);	
			DTOBancoSucursal dtoBancoS=new DTOBancoSucursal();
			
			dtoBancoS.setOidPais(pais);
			
			dtoBancoS.setOidIdioma(idioma);
			traza("dtopais ="+ dtoBancoS.getOidPais());
			traza("dtoidiaomas ="+dtoBancoS.getOidIdioma());			
			Vector paramConector = new Vector();
			paramConector.add(dtoBancoS);
			paramConector.add(new MareBusinessID("CCCCargaInicialReclamos"));	           
			traza("Antes de Conectar");
			
			
			DruidaConector conector = conectar("ConectorCargaInicialReclamo", paramConector);						
			traza("Despues de Conectar");
			DTOCargaInicialReclamos dtoSalida = (DTOCargaInicialReclamos)conector.objeto("DTOSalida");
			traza("[cs]DTOCargaInicialReclamos dtoSalida: "+ dtoSalida);
			
			RecordSet rs=dtoSalida.getBancos();
			traza("[cs]rs : "+ rs);	
			if(rs!=null){
				Vector cols = rs.getColumnIdentifiers();
				DruidaConector conectorCargaCombo = UtilidadesBelcorp.generarConector( "DTOSalida.combo_ROWSET", rs, cols);
				asignar("COMBO", "cbBancoRecaudacion", conectorCargaCombo, "DTOSalida.combo_ROWSET");				
			}
			rs=dtoSalida.getUsuarios();
			traza("[cs] <---USUARIOS---> rs : "+ rs);	
			if(rs!=null){
				Vector cols = rs.getColumnIdentifiers();
				DruidaConector conectorCargaCombo = UtilidadesBelcorp.generarConector( "DTOSalida.combo_ROWSET", rs, cols);
				asignar("COMBO", "cbUsuarioSolicitante", conectorCargaCombo, "DTOSalida.combo_ROWSET");	
				asignar("COMBO", "cbUsuarioGestorReclamoPrevisto", conectorCargaCombo, "DTOSalida.combo_ROWSET");	
				asignar("COMBO", "cbUsuarioGestorReclamoReal", conectorCargaCombo, "DTOSalida.combo_ROWSET");				
			}
			rs=dtoSalida.getSituaciones();
			if(rs!=null){
				Vector cols = rs.getColumnIdentifiers();
				DruidaConector conectorCargaCombo = UtilidadesBelcorp.generarConector( "DTOSalida.combo_ROWSET", rs, cols);
				asignar("COMBO", "cbSituacion", conectorCargaCombo, "DTOSalida.combo_ROWSET");								
			}
			
					
			
			
			
		}catch( Exception e ){
			e.printStackTrace();
			this.logStackTrace(e);
			lanzarPaginaError(e);			
		}
		
		traza("LPBuscarReclamos.accionVacia Salida");

	}
	
		
	

	private void logStackTrace(Throwable e) throws Exception {
		traza("Se produjo la excepcion: " + e.getMessage());		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		e.printStackTrace(ps);		
		traza("Stack Trace: " + baos.toString());
	}
}
