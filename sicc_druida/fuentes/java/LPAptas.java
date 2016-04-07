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
import java.util.HashMap;


import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.util.UtilidadesBelcorp;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mln.MareBusinessID;

import es.indra.druida.DruidaConector;
import es.indra.druida.Contexto;

import es.indra.sicc.logicanegocio.edu.ConstantesEDU;

import es.indra.sicc.cmn.negocio.ConstantesCMN;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;

import es.indra.sicc.dtos.edu.DTOApta;
import es.indra.sicc.dtos.edu.DTOObtenerAptas;
import es.indra.sicc.dtos.edu.DTOInsertaApta;




public class LPAptas extends LPSICCBase {
         
         private String accion = null;
	 private String casoUso = null;   
         private Long idioma;
	 private Long pais;   
	 private Long cursoSeleccionado;
	 private String path = null;
	 
         public LPAptas() {
                  super();
         }

         public void inicio() throws Exception {
                  
         }
         public void ejecucion() throws Exception {
                  setTrazaFichero();
                  try  {	
			traza("LPAptas Entrada");
			
			this.idioma = UtilidadesSession.getIdioma(this);
                        this.pais = UtilidadesSession.getPais(this);
			this.accion = conectorParametroLimpia("accion","", true);
			traza("Accion: "+this.accion);
                        if(this.accion.equals("")){
                        	muestraPantalla();
                        }
                        if(this.accion.equals("Eliminar")){
				eliminaAptas();
                        }
                        if(this.accion.equals("Guardar")){
                        	insertarAptas();
                        }

                        traza("LPAptas Salida");
                  }catch ( Exception e )  {
                           e.printStackTrace();
                           logStackTrace(e);
                           lanzarPaginaError(e);
                  }		
         }


         private void muestraPantalla() throws Exception{
         	traza("LPAptas.muestraPantalla Entrada");		
         	try{
			pagina("contenido_aptas_cursos");
	  		
	  		asignar("VAR", "idioma", idioma.toString());
	        asignar("VAR", "pais", pais.toString());
	  		
	  		asignarAtributo("PAGINA","contenido_aptas_cursos", "cod", "0208");
	        asignarAtributo("PAGINA","contenido_aptas_cursos", "msgle", "Asignar aptas a curso");
	         	
			String curso;
			//String origen = conectorParametroLimpia("origen", "", true);
			String origen = conectorParametroLimpia("origen", "", true);
			String participantes = conectorParametroLimpia("participantes", "", true);
			//Se asigna el campo oidMarca recibido en la llamada 
			//Se asigna el campo oidCanal recibido en la llamada 

			String oidMarca = conectorParametroLimpia("marca", "", true);
			String oidCanal = conectorParametroLimpia("canal", "", true);
			
			this.path = conectorParametroLimpia("path", "", true);

			if (this.path.equals("")){
				traza("PATH VACIO: ");
				curso = conectorParametroLimpia("oidSeleccionado", "", true);
				traza("oidSeleccionado: "+conectorParametroLimpia("oidSeleccionado", "", true));
			}else{
				traza("PATH CON VALOR: ");
				curso = conectorParametroLimpia("oidCurso", "", true);
				traza("oidCurso: "+conectorParametroLimpia("oidCurso", "", true));

				traza("=========NUEVO - FICHEROS=======================");
				traza("propiedades del usuario: " + (HashMap) conectorParametroSesion("propiedades"));
				traza("getWebTmpDir: " + getWebTmpDir());
				String tmpDirDruida = getDirTempDruida();            
			    String fileName   = this.path;        
           		traza("Nombre del fichero: " + fileName);
				traza("Ruta: tmpDirDuirda:"+tmpDirDruida);
				String pathDir    = getWebTmpDir();                   
				traza("Ruta: pathDir WEB:"+pathDir);

				//this.path = Contexto.getPropiedad("TMP.UPLOAD") + "/" + this.path; 
				//this.path = "\\192.168.118.101"+Contexto.getPropiedad("TMP.UPLOAD") + "/" + this.path; 
				
				this.path = pathDir + "/" + this.path;
				traza("Ruta Completa (pathWEB + nombre fichero): "+this.path);
				traza("Path: "+this.path);
			}	
			this.cursoSeleccionado=new Long(curso);
			traza("Parametros: "+ curso +" origen: "+ origen +" "+ participantes +" "+ this.path );

			
			//Se asigna al campo oidCurso el oid recibido en la llamada 
			asignar("VAR", "oidCurso",curso );
			//Se asigna al campo indOrigen el origen recibido en la llamada 
			asignar("VAR", "indOrigen",origen );	
			//Se asigna al campo lblParticipantes el participantes recibido en la llamada 
			//asignar("VAR", "lblParticipantes",participantes );	
			asignarAtributo("LABELC", "lblNOptimoParticipantesXX","valor", participantes );	
			//Se asigna al campo path el path recibido en la llamada 
			asignar("VAR", "path",this.path );	

			asignar("VAR", "marca",oidMarca );	
			asignar("VAR", "canal",oidCanal );	

			
			traza("despues de asignar oidCurso: "+conectorParametroLimpia("oidCurso", "", true));
			//Se habilita el botón Guardar del menú secundario 
			getConfiguracionMenu("LPAptas","Guardar");
			
			cargaParticipantes();
			
			//Se muestra PaginaAptas
		  	
                }catch ( Exception e )  {
                	e.printStackTrace();
                        this.logStackTrace(e);
                        lanzarPaginaError(e);
               }		
	       traza("LPAptas.muestraPantalla Salida");		
         }


	private void cargaParticipantes() throws Exception{
		traza("LPAptas.cargaParticipantes Entrada");		
         	try{
			//Se crea DTOObtenerAptas (dto)
			DTOObtenerAptas dto = new DTOObtenerAptas();
			dto.setOidIdioma(this.idioma);
			dto.setOidPais(this.pais);
			traza("1");
			//String curso = conectorParametroLimpia("oidSeleccionado", "", true);
			String curso = this.cursoSeleccionado.toString();
			traza("2: curso->"+curso+"   path->"+this.path);
			if(curso!=null){
				if(curso.equals("")){
					traza("ENTRA AKI.... MAL ROLLO");
					curso=new String("-1"); 
					}
				traza("3");					
				dto.setOidCurso(new Long(curso));
			}
			traza("4");
			dto.setPath(this.path);
			traza("DTO para enviar: "+dto);
			Vector paramConector = new Vector();
			paramConector.add(dto);           
			//IdNegocio = "EDUObtieneAptas" 
			paramConector.add(new MareBusinessID("EDUObtieneAptas"));      
			traza("Antes de Conectar ConectorObtieneAptas");
			//conector ConectorObtieneAptas 
			DruidaConector conector = conectar("ConectorObtieneAptas", paramConector);							
			traza("Despues de Conectar ConectorObtieneAptas");

			//asigna al campo oidAsigna el valor del oid retornado (DTOOID.oid)
			DTOOID dtoOid = (DTOOID)conector.objeto("DTOOID");	
			traza("DTOOID obtenido: "+dtoOid);									
			asignar("VAR", "oidAsigna", dtoOid.getOid().toString());
			//asignar("VAR", "oidAsigna", "1"); // Era solo pruebas
                }catch ( Exception e )  {
                	e.printStackTrace();
                        this.logStackTrace(e);
                        lanzarPaginaError(e);
               }		
	       traza("LPAptas.cargaParticipantes Salida");		
         }


         private void eliminaAptas() throws Exception{
         	traza("LPAptas.eliminaAptas Entrada");	
         	pagina("salidaGenerica");
        	asignar("VAR", "cerrarVentana", "false");	

                try{
			//Se crea DTOObtenerAptas (dto)
			DTOApta dto = new DTOApta();
			dto.setOidIdioma(this.idioma);
			dto.setOidPais(this.pais);
			
			String datosLista = conectorParametroLimpia("valoresLista", "", true);
			if (datosLista==null){
				datosLista=new String("");
			}
			
			StringTokenizer str = new StringTokenizer(datosLista,",");
			String token = null;
			int i=0;
			
			DTOOID dtos[] = new DTOOID[str.countTokens()];
									
			while(str.hasMoreTokens()){
				token=str.nextToken();
				traza("TOKEN(Codigo): "+token);
				DTOOID dtoOid = new DTOOID();
				dtoOid.setOid(new Long(token));
				dtos[i]=dtoOid;
				i++;						
			}
			dto.setAptas(dtos);
			traza("DTOAptas: "+dto);
			Vector paramConector = new Vector();
			paramConector.add(dto);           
			//IdNegocio = "EDUEliminaAptas" 
			paramConector.add(new MareBusinessID("EDUEliminaAptas"));           
			traza("Antes de Conectar ConectorEliminaApta");
			//conector ConectorEliminaApta 
			DruidaConector conector = conectar("ConectorEliminaApta", paramConector);							
			traza("Despues de Conectar ConectorEliminaApta");
			asignarAtributo("VAR", "ejecutar", "valor", "refrescarLista()");
                }catch ( Exception e )  {
                	e.printStackTrace();
                        this.logStackTrace(e);
                        lanzarPaginaError(e);
               }		
	       traza("LPAptas.eliminaAptas Salida");		
         }

         private void insertarAptas() throws Exception{
         	traza("LPAptas.insertarAptas Entrada");	
         	pagina("salidaGenerica");	
         	asignar("VAR", "cerrarVentana", "false");
		try{

			DTOInsertaApta dto = new DTOInsertaApta();
			dto.setOidIdioma(this.idioma);
			dto.setOidPais(this.pais);

	         	String oidAsigna = conectorParametroLimpia("oidAsigna", "", true);
	         	String oidCurso = conectorParametroLimpia("oidCurso", "", true);
	         	String indOrigen = conectorParametroLimpia("indOrigen", "", true);
			
			traza("Parametros insertarAptas: "+oidAsigna+" "+oidCurso+" "+indOrigen);
			
			if(oidAsigna!=null){
				if(oidAsigna.equals("")){ oidAsigna=new String("1"); }
				dto.setOidAsigna(new Long(oidAsigna));
			}
			if(oidCurso!=null){
				if(oidCurso.equals("")){ oidCurso=new String("1"); }
				dto.setOidCurso(new Long(oidCurso));	
			}
			if(indOrigen!=null){
				if(indOrigen.equals("")){ indOrigen=new String("1"); }
				dto.setIndOrigen(new Integer(indOrigen));
			}

			Vector paramConector = new Vector();
			paramConector.add(dto);           

			//IdNegocio = "EDUInsertaAptas" 
			paramConector.add(new MareBusinessID("EDUInsertaAptas"));           
			//conector ConectorInsertaAptas 
			traza("Antes de Conectar ConectorInsertaAptas");
			DruidaConector conector = conectar("ConectorInsertaAptas", paramConector);							
			traza("Despues de Conectar ConectorInsertaAptas");

			//Se deshabilita el menú secundario 
			//getConfiguracionMenu("LPAptas","Deshabilitar");

			//Se abre una ventana para cerrar la página 
			asignarAtributo("VAR", "ejecutar", "valor", "inserccionCorrecta()");

                }catch ( Exception e )  {
                	e.printStackTrace();
                        this.logStackTrace(e);
                        lanzarPaginaError(e);
               }		
	       traza("LPAptas.insertarAptas Salida");		
         }

	/*
	 * Retorna un String indicando el directorio donde Druida
	 * almacena el archivo transferido desde la LP.
	 * */
	private String getDirTempDruida() throws Exception {                              
		String dir = null;
		dir = Contexto.getPropiedad("TMP.UPLOAD");		
		return dir;
	}
	
	/*
	 * Retorna un String indicando el directorio temporario del 
	 * web server. En dicho directorio se deben dejar los archivos
	 * que se traen desde la pagina cliente. 
	 **/
	private String getWebTmpDir() throws Exception {
		return Contexto.getPropiedad("TMP.UPLOAD2");
	}    



         private void logStackTrace(Throwable e) throws Exception {
	        traza("Se produjo la excepcion: " + e.getMessage());		
          	ByteArrayOutputStream baos = new ByteArrayOutputStream();
          	PrintStream ps = new PrintStream(baos);
          	e.printStackTrace(ps);		
          	traza("Stack Trace: " + baos.toString());
         }	

}

