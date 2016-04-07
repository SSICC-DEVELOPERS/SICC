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
 /*
    INDRA/CCC/PROY
    $Id: LPPagarCOM.java,v 1.1 2009/12/03 18:36:39 pecbazalar Exp $
    DESC
 */
 
import es.indra.druida.DruidaConector;
import es.indra.mare.common.mln.MareBusinessID;

import es.indra.sicc.cmn.negocio.interfaces.IGestorInterfaces;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;

import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.dtos.com.DTODatosPagarComision;
import es.indra.sicc.util.DTOString;
import es.indra.sicc.dtos.com.DTOBuscarComisionesPagar;
import java.util.Vector;
import java.util.Date;
 
public class LPPagarCOM extends LPSICCBase {

	private String accion = "";
	private Long pais;
	private Long idioma;
	
	public LPPagarCOM() {
		super();
	}
	
	public void inicio() throws Exception {
	}
	
	public void ejecucion() throws Exception {
		setTrazaFichero();
		traza("*** Entrada - LPPagarCOM - ejecucion ***");          
		
		this.accion = conectorParametroLimpia("accion", "", true);
		this.idioma = UtilidadesSession.getIdioma(this);
		this.pais = UtilidadesSession.getPais(this);

		pagina("contenido_comisiones_pagar");
		asignarAtributo("PAGINA","contenido_comisiones_pagar", "cod", "0522");
		asignarAtributo("PAGINA","contenido_comisiones_pagar", "msgle", "Pagar Comisiones");
		asignar("VAR","pais",this.pais.toString());
		asignar("VAR","idioma",this.idioma.toString());
		 // Fecha:
		this.generarHiddenFormatoFecha();

		getConfiguracionMenu("LPPagarCOM","");
		
		
		traza("Accion: "+this.accion+" Idioma: "+this.idioma+" Pais: "+this.pais);
		try{				/*
		if (accion.equals("")){
			//- muestra la PaginaBuscarComisionesPagar 
			pagina("contenido_comisiones_pagar");
			asignarAtributo("PAGINA","contenido_comisiones_pagar", "cod", "0522");
			asignarAtributo("PAGINA","contenido_comisiones_pagar", "msgle", "Pagar Comisiones");
			asignar("VAR","pais",this.pais.toString());
			asignar("VAR","idioma",this.idioma.toString());
			getConfiguracionMenu("LPPagarCOM","");
		}*/
		if (accion.equals("Detalle")){
			//- muestra la PaginaDetalleComision asignandole el oidComision recogido a la variable de la pagina oidComision
			String oidComision = conectorParametroLimpia("oidComision","",true);
      String fechaCalculo = conectorParametroLimpia("fechaCalculo","",true);
			traza("---> OidComision: "+oidComision);
			pagina("contenido_comisiones_pagar_detalle");
			asignar("VAR","oidComision",oidComision);
      asignar("VAR","txtFechaCalculo",fechaCalculo);
			asignar("VAR","pais",this.pais.toString());
			asignar("VAR","idioma",this.idioma.toString());
			 // Fecha:
			this.generarHiddenFormatoFecha();
			
			getConfiguracionMenu("LPPagarCOM","detalle");
		}
		if (accion.equals("Pagar")){
			/*
			Recoge el oid recibido por pantalla. 
			Crea un DTOE del tipo DTOOid con este oid recibido. 
			Invocar al conector ConectorPagarComisiones con el DTOE 
			Crear IDBusiness="COMPagarComisiones" */
			pagina("salidaGenerica");
			
			traza("AccionCorrecta: " + conectorParametroLimpia("accionCorrecta","",true));

			Long oidComision = new Long(conectorParametroLimpia("oidComision","",true));
      String fechaCalculo = conectorParametroLimpia("txtFechaCalculo","",true);
      			
			DTODatosPagarComision dto = new DTODatosPagarComision();
      dto.setOidPais(this.pais);
      dto.setOidIdioma(this.idioma);
      dto.setOidComision(oidComision);
      dto.setFechaCalculo(fechaCalculo);
      dto.setFormatoFecha(UtilidadesSession.getFormatoFecha(this));
                     
			Vector paramConector = new Vector();
      paramConector.add(dto);             
      paramConector.add(new MareBusinessID("COMPagarComisiones"));             
  
      traza("Antes de conectar ConectorPagarComisiones");
      DruidaConector conector = conectar("ConectorPagarComisiones", paramConector);
      traza("Despues de Conectar ConectorPagarComisiones");
      
      asignar("VAR", "ejecutar", conectorParametroLimpia("accionCorrecta","",true));
						
		}
		
		}catch(Exception  e){
			traza("ERROR: " + e);
			e.printStackTrace();
			lanzarPaginaError(e);  
		}
		traza("*** Salida - LPPagarCOM - ejecucion ***");          
	}
}
