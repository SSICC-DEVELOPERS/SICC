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

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mln.MareBusinessID;

import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.DTOOID;

import es.indra.druida.DruidaConector;

import es.indra.sicc.logicanegocio.edu.ConstantesEDU;

import es.indra.sicc.cmn.negocio.ConstantesCMN;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;


public class LPAptasCurso extends LPSICCBase {
         
         private String accion = null;
	 private String casoUso = null;   
         private Long idioma;
	 private Long pais;  
	 private Long cursoSeleccionado; 
	 private Integer indicadorOrigen;
	 
         public LPAptasCurso() {
                  super();
         }

         public void inicio() throws Exception {
                  
         }
         public void ejecucion() throws Exception {
                  setTrazaFichero();
                  try  {	
			traza("LPAptasCurso Entrada");

			pagina("contenido_aptas_cursos_asignar");

			// Cambiarlo cuando se resuelva la incidencia: 
			//asignar("VAR", "constantesCMN", "true");
			asignar("VAR", "constantesCMN", ConstantesCMN.VAL_TRUE.toString());
			//asignar("VAR", "constantesCMN", "true");
			asignar("VAR", "ConstantesEDU", ConstantesEDU.ORIG_PROBAR.toString());

			this.idioma = UtilidadesSession.getIdioma(this);
                        this.pais = UtilidadesSession.getPais(this);
			this.accion = conectorParametroLimpia("accion","", true);
                        traza("Accion definida : "+accion);

                        if(this.accion.equals("AsignarAptasCurso")){
				//Se asigna el valor ConstantesEDU.ORIG_APTAS al campo indOrigen 
				asignar("VAR", "indOrigen", ConstantesEDU.ORIG_APTAS.toString());
				this.indicadorOrigen = ConstantesEDU.ORIG_APTAS;
				asignarAtributo("PAGINA","contenido_aptas_cursos_asignar", "cod", "0208");
				cargaInicial();
                		}
                        if(this.accion.equals("ProbarMatrizCurso")){
				//Se asigna el valor ConstantesEDU.ORIG_PROBAR al campo indOrigen 
				asignar("VAR", "indOrigen", ConstantesEDU.ORIG_PROBAR.toString());
				this.indicadorOrigen = ConstantesEDU.ORIG_PROBAR;
				asignarAtributo("PAGINA","contenido_aptas_cursos_asignar", "cod", "0204");
				cargaInicial();
                        }
                        if(this.accion.equals("Guardar")){
                        	aceptaMatriz();
                        }
                        
                        traza("LPAptasCurso Salida");
                  }catch ( Exception e )  {
                           e.printStackTrace();
                           logStackTrace(e);
                           lanzarPaginaError(e);
                  }		
         }

         private void cargaInicial() throws Exception{
         	traza("LPAptasCurso.cargaInicial Entrada");		
		try{
	         	asignar("VAR", "idioma", idioma.toString());
	         	asignar("VAR", "pais", pais.toString());	
  			
  			
         		asignarAtributo("PAGINA","contenido_aptas_cursos_asignar", "msgle", "Asignar Aptas");

			traza("--> indOrigenINTEGER: "+this.indicadorOrigen.intValue());
			if (this.indicadorOrigen != null){
				asignar("VAR", "indOrigen",this.indicadorOrigen.toString()); //[1]
			}

			traza("--> ConstanteEDU.ORIG_APTAS: "+ConstantesEDU.ORIG_APTAS.intValue());
			
			//Si indOrigen == ConstantesEDU.ORIG_APTAS (Asignar Aptas a Curso)     
			//if(conectorParametroLimpia("indOrigen", "", true).equals(ConstantesEDU.ORIG_APTAS.toString())){
			if(indicadorOrigen.equals(ConstantesEDU.ORIG_APTAS)){
				getConfiguracionMenu("LPAptasCurso","Deshabilitar"); 
				traza("MENU DESHABILITADO");
			}else{
				getConfiguracionMenu("LPAptas","Guardar");
				traza("MENU GUARDAR HABILITADO");
			}
	
			ComposerViewElementList listelem = new ComposerViewElementList();
	         	ComposerViewElement elem = new ComposerViewElement();
	         	ComposerViewElement elem1 = new ComposerViewElement();
	         	
	         	DTOBelcorp dto = new DTOBelcorp();
	         	dto.setOidPais(pais);
	         	dto.setOidIdioma(idioma);
	         	
	         	elem.setIDBusiness("SEGConsultaMarcas");
	         	elem.setDTOE(dto);
	         	elem.setPosOID((byte)0);
	         	elem.setPosDesc((byte)1);
			traza("Elemento 0");
	         	elem1.setIDBusiness("SEGConsultaCanales");
	         	elem1.setDTOE(dto);
	         	elem1.setPosOID((byte)0);
	         	elem1.setPosDesc((byte)1);
	         	traza("Elemento 1");
	         	listelem.addViewElement(elem);
	         	traza("Elemento 0 anandido");
	         	listelem.addViewElement(elem1);
	         	traza("Elemento 1 anandido");
	         	//Se llama al subsistema GestorCargaPantalla. 
	         	ConectorComposerView conector = new ConectorComposerView(listelem,this.getRequest());
	         	traza("conector creado");
	         	conector.ejecucion();
	         	traza("ejecutado");
	         	DruidaConector conConsultar = conector.getConector();
	         	traza("Obtener conConsultar");
	
			//Con los datos obtenidos en el ROWSET SEGConsultaMarcas se carga la combo cmbMarca 
			//Con los datos obtenidos en el ROWSET SEGConsultaCanales se carga la combo cmbCanal
	         	asignar("COMBO","cbMarca", conConsultar,"SEGConsultaMarcas");
			asignar("COMBO","cbCanal", conConsultar,"SEGConsultaCanales");
	
                }catch ( Exception e )  {
                	e.printStackTrace();
                        this.logStackTrace(e);
                        lanzarPaginaError(e);
               }		
	       traza("LPAptasCurso.accionVacia Salida");		
         }
         
         private void aceptaMatriz() throws Exception{
         	traza("LPAptasCurso.aceptaMatriz Entrada");		
         	pagina("salidaGenerica");
         	asignar("VAR", "cerrarVentana", "false");	
	    	try{
			DTOOID dto = new DTOOID();
			dto.setOidPais(this.pais);
			dto.setOidIdioma(this.idioma);
			//dto.oid = oid del curso seleccionado en lstCursos 
			Long oidcursoSelec = new Long(conectorParametroLimpia("curso", "", true));
			traza("Oid Seleccionado: "+oidcursoSelec);
			dto.setOid(oidcursoSelec);
	
			Vector paramConector = new Vector();
			paramConector.add(dto);           
			//IdNegocio = "EDUAceptaMatriz" 
			paramConector.add(new MareBusinessID("EDUAceptaMatriz"));           
			//Se invoca el conector ConectorAceptarMatriz 
			traza("Antes de Conectar ConectorAceptarMatriz");
			DruidaConector conector = conectar("ConectorAceptarMatrz", paramConector);
			traza("Despues de Conectar ConectorAceptarMatriz");
			//Se refresca la lista lstCursos
                }catch ( Exception e )  {
                	e.printStackTrace();
                        this.logStackTrace(e);
                        lanzarPaginaError(e);
                }		
                traza("LPAptasCurso.cargaInicial Salida");		
         }			

         private void logStackTrace(Throwable e) throws Exception {
	        traza("Se produjo la excepcion: " + e.getMessage());		
          	ByteArrayOutputStream baos = new ByteArrayOutputStream();
          	PrintStream ps = new PrintStream(baos);
          	e.printStackTrace(ps);		
          	traza("Stack Trace: " + baos.toString());
         }	

}

