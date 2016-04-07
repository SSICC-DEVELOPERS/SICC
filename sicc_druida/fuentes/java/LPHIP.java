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

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
 
import java.util.Vector;
import java.util.ArrayList;

import es.indra.druida.DruidaConector;

import es.indra.mare.common.mln.MareBusinessID;

import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;

import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.DTOString;

import es.indra.sicc.cmn.negocio.interfaces.IGestorInterfaces;

import es.indra.sicc.dtos.intsys.DTOCargaInicialInterfaz;
import es.indra.sicc.dtos.intsys.DTOHIPRecepcionar;

import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
 
public class LPHIP extends LPSICCBase {

		  private String accion = "";
		  private String casoUso = null;
		  private Long pais = null;
		  private Long idioma = null;

          public LPHIP() {
                    super();
          }
          
          public void inicio() throws Exception {
          
          }

          public void ejecucion() throws Exception {
          rastreo();
          setTrazaFichero();
          
          accion = conectorParametroLimpia("accion","",true);
          traza("***accion : " + accion);                   
                           
          this.idioma = UtilidadesSession.getIdioma(this); 
          this.pais = UtilidadesSession.getPais(this);

          
          traza("*** Entrada - LPHIP - ejecucion ***");
                    try  {
                        if(this.accion.equals("")){
                           	this.casoUso = "";
                           	this.cargaInicial();
                        } 
                        if(this.accion.equals("recepcionar")){
                        	this.casoUso="recepcionar";
                        	this.recepcionar();
                        }
                    }catch ( Exception e )  {
                              logStackTrace(e);
                              lanzarPaginaError(e);
                    }
           traza("*** Salida - LPHIP - ejecucion ***");
          }
          
    private void cargaInicial() throws Exception{
    	traza("*** Entrada - LPHIP - cargaInicial ***");
    	pagina("contenido_registro_ventas_recepcionar");
    	
    	this.cargaCombos();
    	
    	DTOString dto = new DTOString();
    	dto.setOidPais(this.pais);
    	traza("*** pais ***"+ this.pais);
    	dto.setOidIdioma(this.idioma);
    	traza("*** idioma ***"+ this.idioma);
    	dto.setCadena(IGestorInterfaces.COD_INTERFAZ_HIP1);
    	traza("*** cargaInicial Cadena ***"+ dto.getCadena());
    	
    	MareBusinessID idNegocio = new MareBusinessID("INTCargaInicialInterfaz");
    	
    	Vector paramsEntrada = new Vector();
		paramsEntrada.add(dto);
		paramsEntrada.add(idNegocio);
		traza("***Antes del conector - ConectorObjeto");
		DruidaConector conector = conectar("ConectorObjeto", paramsEntrada);			
		traza("***Valor del conector :" + conector);

		// Recuperar el DTOCargaInicialInterfaz  de respuesta 
		DTOCargaInicialInterfaz dtoCargaInicial = (DTOCargaInicialInterfaz)conector.objeto("DTOSalida");
		
		/*DTOCargaInicialInterfaz dtoCargaInicial = new DTOCargaInicialInterfaz();
		dtoCargaInicial.setNumeroLote(new Long("200502040001"));
		dtoCargaInicial.setDescripcion("Probando en construcción");*/
    	
    	asignar("LABELC", "lbldtLote", dtoCargaInicial.getNumeroLote().toString());
    	asignar("VAR", "numLote", dtoCargaInicial.getNumeroLote().toString());
    	asignar("CTEXTO", "txtDescripcionLote", dtoCargaInicial.getDescripcion().toString());
    	
    	asignarAtributo("PAGINA","contenido_registro_ventas_recepcionar","cod","0293");
        asignarAtributo("PAGINA","contenido_registro_ventas_recepcionar","msgle","Recepcionar registro de ventas");
    	
    	getConfiguracionMenu("LPHIP",this.casoUso);
    	
    	traza("*** Salida - LPHIP - cargaInicial ***");

	}
	
	private void recepcionar()throws Exception{
		traza("*** Entrada - LPHIP - recepcionar ***");
		pagina("salidaGenerica");
		asignarAtributo("VAR", "ejecutar","valor","Correcto()");

		
		//Recuperamos parámetros
		String sociedad = conectorParametroLimpia("oidSociedad","",true);
		traza("*** Sociedad ***"+ sociedad);
		String numLote = conectorParametroLimpia("numLote","",true);
		traza("*** numero Lote ***"+ numLote);
		String observaciones = conectorParametroLimpia("areatxtObservaciones","",true);
		traza("*** observaciones ***"+ observaciones);
		String descripcion = conectorParametroLimpia("txtDescripcionLote","",true);
		traza("*** descripcion ***"+ descripcion);
		
		DTOHIPRecepcionar dto= new DTOHIPRecepcionar();
		dto.setOidPais(this.pais);
		dto.setOidIdioma(this.idioma);
		dto.setOidSociedad(new Long(sociedad));
		dto.setNumLote(numLote);
		dto.setObservaciones(observaciones);
		dto.setDescripcionLote(descripcion);
		
		traza("*** DTOHIPRecepcionar ***"+ dto);
		
		try  {		
			MareBusinessID idNegocio = new MareBusinessID("HIPRecepcionarRegistroVentasBatch");
    	
	    	Vector paramsEntrada = new Vector();
			paramsEntrada.add(dto);
			paramsEntrada.add(idNegocio);
			traza("***Antes del conector - ConectorObjeto");
			DruidaConector conector = conectar("ConectorRecepcionarRegistroVentasBatch", paramsEntrada);			
			traza("***Valor del conector :" + conector);
		
			traza("*** Salida - LPHIP - recepcionar ***");


        }catch ( Exception e )  {
			logStackTrace(e);
            lanzarPaginaError(e);
		}
	}
	
	private void cargaCombos() throws Exception {
    	traza("*** Entrada - cargaCombos ***");
      
      	DTOBelcorp dtoe = new DTOBelcorp();               
		dtoe.setOidPais(this.pais);
		dtoe.setOidIdioma(this.idioma);
    	
		MareBusinessID idNegocio = new MareBusinessID("SEGObtenerEmpresasPorPais");
		
		// cada usuario tiene una Sociedad por defecto que deben seleccionarse
		Long sociedad = UtilidadesSession.getSociedadPorDefecto(this);
    	traza("*** Sociedad ***"+ sociedad);
    	asignar("VAR", "oidSociedad", sociedad.toString());
		
		Vector paramsEntrada = new Vector();
		paramsEntrada.add(dtoe);
		paramsEntrada.add(idNegocio);
		traza("***Antes del conector - ConectorObjeto");
		DruidaConector conector = conectar("ConectorEmpresasPorPais", paramsEntrada);			
		traza("***Valor del conector :" + conector);

		// Recuperar el DTOCargaInicialInterfaz  de respuesta 
		DTOSalida dtoSalida = (DTOSalida)conector.objeto("DTOSalida");
		RecordSet rs = dtoSalida.getResultado();
		
		Vector cols = rs.getColumnIdentifiers();
		DruidaConector conectorSociedad = UtilidadesBelcorp.generarConector("DTOSalida.resultado",rs,cols);
		asignar("COMBO", "cbSociedad", conectorSociedad, "DTOSalida.resultado", cols.get(0).toString(), sociedad.toString());

    	  
      traza("*** Salida - cargaCombos ***");
   }	

    private void logStackTrace(Throwable e) throws Exception {
                    traza("Se produjo la excepcion: " + e.getMessage());
                    
                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    PrintStream ps = new PrintStream(baos);
                    e.printStackTrace(ps);
                    
                    traza("Stack Trace: " + baos.toString());
     }

}