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

import es.indra.mare.common.mln.MareBusinessID;
import es.indra.druida.DruidaConector;

import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.util.DTOBelcorp;

import es.indra.sicc.cmn.presentacion.cache.Cache;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Vector;

public class LPPedidosNoFacturados extends LPSICCBase {
	
	public LPPedidosNoFacturados() {super();}
	
	private String accion = null;
	private Long pais = null;
	private Long idioma = null;
	private String oidContacto = null;
	
	public void inicio() throws Exception {
		pagina("contenido_pedidos_nofacturados_consultar");
	}
	public void ejecucion() throws Exception {
		try{
			setTrazaFichero();
			traza("***Entrada - LPPedidosNoFacturados - ejecucion***");
			
			accion = conectorParametroLimpia("accion","",true);
			traza("***accion : "+accion);
			
			this.pais=UtilidadesSession.getPais(this);
			this.idioma=UtilidadesSession.getIdioma(this);
			asignar("VAR", "idioma", idioma.toString());
			asignar("VAR", "pais", pais.toString());			
			this.oidContacto = conectorParametroLimpia("oidContacto","",true);   
			this.traza("********************El oid Contacto es************: "+ 	  oidContacto);
			asignar("VAR", "oidContacto", this.oidContacto);

			asignarAtributo("PAGINA","contenido_pedidos_nofacturados_consultar", "cod", "0581");
			asignarAtributo("PAGINA","contenido_pedidos_nofacturados_consultar", "msgle", "Consultar pedidos no facturados");
			
			this.traza("********************Antes de obtener cache ************:");
			//Cache cache = this.getSessionCache();
			String oidCliente  = this.conectorParametroSesion("oidCliente33").toString();
			this.traza("********************Se obtiene cache ***************:");
			
			this.traza("********************El oid cliente es************: "+ 	  oidCliente);
			
			if (oidCliente != null){
			 		asignarAtributo("VAR","oidCliente", "valor", oidCliente);
			}
			
			if ( accion.equals("")) {
			       cargaInicial();
			}
			
			getConfiguracionMenu("LPPedidosNoFacturados","Consultar");
			traza("***Salida - LPPedidosNoFacturados - ejecucion***");
		}catch(Exception e){
			logStackTrace(e);
			lanzarPaginaError(e);
		}
	}
	private void cargaInicial() throws Exception{
		traza("***Entrada - LPPedidosNoFacturados - cargaInicial**");
		/*
		Realiza la carga inicial de la pantalla. 		
		Proceso 
		======== 
		Se crea el elemento: 		
		elem1.idNegocio="SEGObtenerTiposPeriodo" 
		elem1.dtoe=DTOBelcorp 		
		Se llama al subsistema GestorCargaPantalla. 		
		Con los datos obtenidos en el ROWSET SEGObtenerTiposPeriodo se carga la combo cmbTipoPeriodo*/
		
		DTOBelcorp dto = new DTOBelcorp();
		dto.setOidPais(pais);
      dto.setOidIdioma(idioma);

      //Invocar al subsistema GestorCargaPantalla 
      ComposerViewElementList listelem = new ComposerViewElementList();
      ComposerViewElement elem = null;
               
		elem=new ComposerViewElement(); 
		elem.setIDBusiness("SEGObtenerTiposPeriodo");
		elem.setDTOE(dto);
		listelem.addViewElement(elem);
		
		ConectorComposerView conector = new ConectorComposerView(listelem, this.getRequest());
		conector.ejecucion();
		DruidaConector conConsultar = conector.getConector();
		
	   asignar("COMBO", "cbTipoPeriodo", conConsultar, "SEGObtenerTiposPeriodo");		
		
		/* Ariel D. Agregado por CAL-04 
		Los parámetros recibidos se cargan en las variables ocultas de la pantalla: */		
		String oidCliente = conectorParametroLimpia("oidCliente","",true);
		String oidTipoCliente = conectorParametroLimpia("oidTipoCliente","",true);
		String indConsultoraInterna = conectorParametroLimpia("indConsultoraInterna","",true);
		String oidSubTipoCliente = conectorParametroLimpia("oidSubTipoCliente","",true);

		asignarAtributo("VAR", "oidCliente", "valor", oidCliente.toString());
		asignarAtributo("VAR", "oidTipoCliente", "valor", oidTipoCliente.toString());
		asignarAtributo("VAR", "indConsultoraInterna", "valor", indConsultoraInterna.toString());
		asignarAtributo("VAR", "oidSubTipoCliente", "valor", oidSubTipoCliente.toString());
		/* fin Agregado por CAL-04 */

		traza("***Salida - LPPedidosNoFacturados - cargaInicial**");
	}	
	private void logStackTrace(Throwable e) throws Exception {
		traza("Se produjo la excepcion: " + e.getMessage());
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		e.printStackTrace(ps);
		
		traza("Stack Trace: " + baos.toString());
	}
}