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
import es.indra.druida.DruidaBase;
import es.indra.druida.DruidaConector;
import es.indra.druida.dom.DruidaDOMObjeto;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.UtilidadesFecha;
import es.indra.sicc.util.DTOOID;
import java.lang.String;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Vector;


public class LPCursosReuniones extends LPSICCBase {
	 private Long pais = null;
	 private Long idioma = null;           
	 private String accion = null;
	 private String oidCliente = null;
	 private String oidContacto = null;
	 
         public LPCursosReuniones() {
    	}

         public void inicio() throws Exception
         {
                pagina("contenido_cursos_reuniones_consultar");
         }

         public void ejecucion() throws Exception
         {
          	setTrazaFichero();
          	traza("*** Entrada - LPCursosReuniones - ejecucion ***");
          	try {
          		String accion = conectorParametroLimpia("accion","",true);
          		traza("Accion -> " + accion);

     			this.oidContacto = conectorParametroLimpia("oidContacto","",true);   
			asignar("VAR", "oidContacto", this.oidContacto);
       		
          		this.pais = UtilidadesSession.getPais(this);  
	                this.idioma = UtilidadesSession.getIdioma(this);   
                        if (accion.equals("")) {
                              	cargaInicial();
           		} else if (accion.equals("detalle")) {
                          	detalle();
                        }
          		
          	} catch (Exception e) {
	                 e.printStackTrace();
	                 this.logStackTrace(e);
	                 lanzarPaginaError(e);;
                }
		traza("*** Salida - LPCursosReuniones - ejecucion ***");
         } 
         public void cargaInicial() throws Exception
         {
         	/*INCIDENCIA 12556
         	En LPCursosReuniones, en el método cargaInicial solamente se carga 
 		varOidCliente con el cliente recibido por parámetro.
		*/
         	try{
         	
	         	traza("*** Entrada - LPCursosReuniones - cargaInicial ***"); 
	         	asignarAtributo("PAGINA","contenido_cursos_reuniones_consultar","cod","0651");
		        asignarAtributo("PAGINA","contenido_cursos_reuniones_consultar","msgle","Consultar cursos y reuniones");
		        this.getConfiguracionMenu("LPCursosReuniones", "");     		
          		this.oidCliente = conectorParametroLimpia("oidCliente","",true);					
			asignar("VAR", "oidCliente", this.oidCliente);     			
         
         	} catch (Exception e) {
	                 e.printStackTrace();
	                 this.logStackTrace(e);
	                 lanzarPaginaError(e);;
                }

		traza("*** Salida - LPCursosReuniones - cargaInicial ***");
         } 
	 public void detalle() throws Exception
         {         
         	try{
		traza("*** Entrada - LPCursosReuniones - detalle ***");         
         	/*Se carga la label de la pantalla PantallaDetalleCursosReuniones: 
		lblObjetivoCurso = objetivo del curso seleccionado en la lista 

		Se muestra la pantalla modal PantallaDetalleCursosReuniones
		*/
		 String objetivo = conectorParametroLimpia("objetivo","",true);
                 pagina("contenido_cursos_reuniones_consultar_detalle");	                 	
                 asignarAtributo("PAGINA","contenido_cursos_reuniones_consultar_detalle","cod","0651");
	         asignarAtributo("PAGINA","contenido_cursos_reuniones_consultar_detalle","msgle","Consultar cursos y reuniones");
		 this.getConfiguracionMenu("LPCursosReuniones", "detalle");	         	         		         
		 asignarAtributo("LABELC","lbldtObjetivoCurso","valor",objetivo);

         	} catch (Exception e) {
	                 e.printStackTrace();
	                 this.logStackTrace(e);
	                 lanzarPaginaError(e);;
                }
		traza("*** Salida - LPCursosReuniones - detalle ***");
         }
         
         private void logStackTrace(Throwable e) throws Exception {
	        traza("Se produjo la excepcion: " + e.getMessage());		
          	ByteArrayOutputStream baos = new ByteArrayOutputStream();
          	PrintStream ps = new PrintStream(baos);
          	e.printStackTrace(ps);		
          	traza("Stack Trace: " + baos.toString());
         }	
}

