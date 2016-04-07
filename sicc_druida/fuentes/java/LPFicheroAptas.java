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
import java.util.StringTokenizer;

import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.util.UtilidadesBelcorp;

import es.indra.mare.common.exception.MareException;

import es.indra.mare.common.mln.MareBusinessID;

import es.indra.druida.DruidaConector;

//import es.indra.sicc.logicanegocio.edu.ConstantesEDU;

import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;

import es.indra.sicc.dtos.edu.DTOApta;
import es.indra.sicc.dtos.edu.DTOObtenerAptas;
import es.indra.sicc.dtos.edu.DTOInsertaApta;

public class LPFicheroAptas extends LPSICCBase {
         
         private String accion = null;
	 private String casoUso = null;   
         private Long idioma;
	 private Long pais;   
	 
         public LPFicheroAptas() {
                  super();
         }

         public void inicio() throws Exception {
                  
         }
         public void ejecucion() throws Exception {
                  setTrazaFichero();
                  try  {	
			traza("LPFicheroAptas Entrada");
			
			this.idioma = UtilidadesSession.getIdioma(this);
                        this.pais = UtilidadesSession.getPais(this);
			this.accion = conectorParametroLimpia("accion","", true);
			traza("Accion: "+this.accion);
                        if(this.accion.equals("")){
                        	muestraPantalla();
                        }
                        traza("LPFicheroAptas Salida");
                  }catch ( Exception e )  {
                           e.printStackTrace();
                           logStackTrace(e);
                           lanzarPaginaError(e);
                  }		
         }


         private void muestraPantalla() throws Exception{
         	traza("LPFicheroAptas.muestraPantalla Entrada");		
         	try{
			pagina("contenido_seleccion_fichero_dataMart");
	
			asignar("VAR", "idioma", idioma.toString());
	         	asignar("VAR", "pais", pais.toString());	

	  		asignarAtributo("PAGINA","contenido_seleccion_fichero_dataMart", "cod", "0208");
	        	asignarAtributo("PAGINA","contenido_seleccion_fichero_dataMart", "msgle", "Asignar aptas a cursos");
	         	
	         	String curso = conectorParametroLimpia("oidSeleccionado", "", true);
	         	String origen = conectorParametroLimpia("origen", "", true);
	         	String participantes = conectorParametroLimpia("participantes", "", true);
			
			//Se asigna al campo oidMarca el oid de la marca recibida 
			//Se asigna al campo oidCanal el oid del canal recibido 
	         	String oidMarca = conectorParametroLimpia("marca", "", true);
	         	String oidCanal = conectorParametroLimpia("canal", "", true);
			
			if(curso==null){
				curso=new String("");
			}
			if(origen==null){
				origen=new String("");
			}
			if(participantes==null){
				participantes=new String("");
			}
			
			//Se asigna al campo oidCurso el oid recibido en la llamada 
			asignar("VAR", "oidCurso",curso );
			//Se asigna al campo indOrigen el origen recibido en la llamada 
			asignar("VAR", "indOrigen",origen );	
			//Se asigna al campo numParticipantes el participantes recibido en la llamada 
			asignar("VAR", "numParticipantes",participantes );	

			asignar("VAR", "marca",oidMarca );	
			asignar("VAR", "canal",oidCanal );	

			
			getConfiguracionMenu("LPFicheroAptas","");
			//Se muestra PaginaFicheroAptas
		  	
                }catch ( Exception e )  {
                	e.printStackTrace();
                        this.logStackTrace(e);
                        lanzarPaginaError(e);
               }		
	       traza("LPFicheroAptas.muestraPantalla Salida");		
         }


         private void logStackTrace(Throwable e) throws Exception {
	        traza("Se produjo la excepcion: " + e.getMessage());		
          	ByteArrayOutputStream baos = new ByteArrayOutputStream();
          	PrintStream ps = new PrintStream(baos);
          	e.printStackTrace(ps);		
          	traza("Stack Trace: " + baos.toString());
         }	

}

