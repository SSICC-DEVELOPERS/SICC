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

/*
    INDRA/CAR/PROY
    $Id: LPVisualizacion.java,v 1.1 2009/12/03 18:41:16 pecbazalar Exp $
    DESC
*/

import java.io.ByteArrayOutputStream; 
import java.io.PrintStream;
import java.util.Vector;

import es.indra.druida.DruidaConector;

import es.indra.sicc.util.DTOBelcorp;

import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.logicanegocio.fac.generaciondocumentos.DTODocumento;

import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import es.indra.sicc.logicanegocio.fac.generaciondocumentos.DTOFACVisualizarDoc;
import es.indra.mare.common.mln.MareBusinessID;

public class LPVisualizacion extends LPSICCBase {
    
    private String accion = null;
    private Long idioma;
    private Long pais;   

    
    // Definicion del constructor
    public LPVisualizacion() {
    	super();
    }

    // Definicion del metodo abstracto inicio
    public void inicio() throws Exception {

          // Defino el nombre de la vista
          pagina("contenido_documentos_facturacion_consultar");
    }

    // Definicion del metodo abstracto ejecucion
	public void ejecucion() throws Exception {
		rastreo();
		try{
        	setTrazaFichero(); 
            traza("***Entrada - LPVISUALIZAR - ejecucion***");
            
            this.idioma = UtilidadesSession.getIdioma(this);
            this.pais = UtilidadesSession.getPais(this);
            asignar("VAR", "idioma", idioma.toString());
            asignar("VAR", "pais", pais.toString()); 
            this.accion = conectorParametroLimpia("accion","",true);
            traza("***accion : "+accion);

            pagina("contenido_visualizacion_prueba");
            
            /*
		objParams.canal = canal;
		objParams.acceso = acceso;
		objParams.subacceso = subacceso;
		objParams.ejercicio = ejercicio;
		objParams.cliente = cliente;
		objParams.numDocInterno = numDocInterno;
		objParams.numSerieLegal = numSerieLegal;
		objParams.docLegal = docLegal;
		objParams.numConsolidado = numConsolidado;
		objParams.fechaFacturacion = fechaFacturacion;
		objParams.fechaProceso = fechaProceso;
*/
	// Esperando tapon o negocio
	
		String oidDocumento = conectorParametroLimpia("oidDocumento","", true);
		traza("Oid del documento: "+oidDocumento);

 		//Se instancia un DTOBelcorp
                  DTOFACVisualizarDoc dtoEntrada = new DTOFACVisualizarDoc();
                  dtoEntrada.setOidPais(pais);
                  dtoEntrada.setOidIdioma(idioma);
                  dtoEntrada.setOidDocumento(new Long(oidDocumento));
                  
                  //- Se crea idNegocio "CCCCargaInicialSeleccionProvisionesDepuraciones" 
                  MareBusinessID idBusiness = new MareBusinessID("FACPruebaImpresion");
                  
                  //Almacenamos los parametros de entrada
                  Vector paramEntrada = new Vector();
                  paramEntrada.addElement(dtoEntrada);
                  paramEntrada.addElement(idBusiness);

                  //- Se invoca al ConectorCargaInicialSeleccion 
                  traza("Antes de conectar");
                  DruidaConector conector = conectar("conectorpruebaimpresion", paramEntrada);
                 
                 /* PIPIRIPIRIIIIIIII  
                  DruidaConector combo = conectar("taponVisual");
                  Vector vector1 = valorVector("COL_SUPL",combo);
                  
                  asignar("AREATEXTO", "nombre","atxtVisualizador","valor",(String)vector1.elementAt(0));       
                 */
                  
                  traza("Despues de conectar");
                  

                  DTODocumento dtodoc = (DTODocumento)conector.objeto("DTODocumento");
	
           	traza("DTODocumento");	
           	traza(dtodoc.getDocumento());	
           	
           	String cosas = new String("aaa&#xa;ccc&#x0020;&#x0020;&#x0020;&#x0020;&#x0020;Hola&#x0020;&#x0020;&#x0020;&#x0020;&#x0020;&#x0020;&#x0020;&#x0020;&#x0020;bbb&#xd;&#xa;");
           	
           	asignar("AREATEXTO", "nombre","atxtVisualizador","valor",dtodoc.getDocumento());
           	
           	
  		//asignar("AREATEXTO","nombre", "atxtVisualizador","valor",espacio+dtodoc.getDocumento());           	
  		//asignar("AREATEXTO","atxtVisualizador",espacio+dtodoc.getDocumento());           	
  		//asignarAtributoElemento("textFactura", "valor","aaa&#xa;ccc#x0020;#x0020;#x0020;#x0020;#x0020;#x0020;bbb&#xd;&#xa;"+dtodoc.getDocumento());           	
  		//asignarAtributoElemento("PAGINA", "valor","aaa&#xa;ccc#x0020;#x0020;#x0020;#x0020;#x0020;#x0020;bbb&#xd;&#xa;"+dtodoc.getDocumento());
  		//asignarAtributoElemento("AREATEXTO", "atxtVisualizador","aaa&#xa;bbb&#xd;&#xa;"+dtodoc.getDocumento());       
  		
  		//asignarAtributoElemento("etiqueta", "valor", dtodoc.getDocumento());
  		
  		//asignar("TEXTODOCUMENTO", "textodocumento", dtodoc.getDocumento());           	
  		
  		
  		
  		


  		
  		traza("==============================================");	
  		//traza(pagina);	
  		//asignarAtributoElemento("textObservacionesAreaReclamos","valor",dtodoc.getDocumento()); 


		
		getConfiguracionMenu("LPConsultaFacturas","");   



	
	         	
               
            	traza("***Salida - LPVISUALIZAR - ejecucion***");
		}catch(Exception e){
        	logStackTrace(e);
            lanzarPaginaError(e);
        }
     }

     
     
 	 	
 	protected void logStackTrace(Throwable e) throws Exception {
          traza("Se produjo la excepcion: " + e.getMessage());
    
          ByteArrayOutputStream baos = new ByteArrayOutputStream();
          PrintStream ps = new PrintStream(baos);
          e.printStackTrace(ps);
                         
          traza("Stack Trace: " + baos.toString());
    }
    
}   
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    