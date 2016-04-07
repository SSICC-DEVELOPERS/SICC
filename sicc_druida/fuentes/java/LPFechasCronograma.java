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
import java.io.PrintStream;
import java.io.ByteArrayOutputStream;

import es.indra.sicc.util.UtilidadesSession;


public class LPFechasCronograma extends LPSICCBase {
         
          private Long idioma;
          private Long pais;
          private String accion = null;
          private String oidContacto = null;
                   
          public LPFechasCronograma() {
                    super();
          }

          public void inicio() throws Exception {
          	pagina("contenido_fechas_cronograma_consultar");
          }
          public void ejecucion() throws Exception {
                    setTrazaFichero();
                    try  {         
                           traza("*** Entrada: LPFechasCronograma - Ejecucion");
                           getConfiguracionMenu("LPFechasCronograma", "consultar");
                           this.idioma = UtilidadesSession.getIdioma(this);
                           this.pais = UtilidadesSession.getPais(this);
                           this.accion = conectorParametroLimpia("accion","", true);
                           this.oidContacto = conectorParametroLimpia("oidContacto","",true);
									
			   asignar("VAR", "oidContacto", this.oidContacto);
			   
                           traza("Accion: "+this.accion);
                           if(this.accion.equals("")){
                           		traza("Antes de llamar a cargaInicial");
                                    cargaInicial();
                           }
                           
                           traza("*** Salida: LPFechasCronograma - Ejecucion");
                    }catch ( Exception e )  {
                              e.printStackTrace();
                              logStackTrace(e);
                              lanzarPaginaError(e);
                    }              
          }

	private void cargaInicial() throws Exception{
		traza("*** Entrada: LPFechasCronograma - cargaInicial");
		/*
		Se ponen en las variables ocultas de la pantalla los datos recibidos por parámetro: 
		varOidZona = zona 
		varOidPeriodo = periodo
		*/
		
              asignarAtributo("PAGINA","contenido_fechas_cronograma_consultar", "cod", "0650");
              asignarAtributo("PAGINA","contenido_fechas_cronograma_consultar", "msgle", "Consultar fechas de cronograma de actividades");
              
		String oidZona = conectorParametroLimpia("oidZona","", true);
		String oidPeriodo = conectorParametroLimpia("oidPeriodo","", true);

		//String oidZona = "1";
		//String oidPeriodo = "17";

		traza("oidZona: "+oidZona);
		traza("oidPeriodo: "+oidPeriodo);
		traza("pais: "+this.pais.toString());
		traza("idioma: "+this.idioma.toString());
		
		asignar("VAR", "oidZona",oidZona);
		asignar("VAR", "oidPeriodo",oidPeriodo);
		asignar("VAR", "pais",this.pais.toString());
		asignar("VAR", "idioma",this.idioma.toString());

		traza("*** Salida: LPFechasCronograma - cargaInicial");
	}

	private void logStackTrace(Throwable e) throws Exception {
	      traza("Se produjo la excepcion: " + e.getMessage());		
	      ByteArrayOutputStream baos = new ByteArrayOutputStream();
	      PrintStream ps = new PrintStream(baos);
	      e.printStackTrace(ps);		
	      traza("Stack Trace: " + baos.toString());
	}  

}