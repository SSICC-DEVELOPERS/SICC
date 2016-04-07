/*
 * Copyright 2003 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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

import es.indra.druida.DruidaConector;

import es.indra.mare.common.mln.MareBusinessID;

import es.indra.sicc.util.UtilidadesSession;

import es.indra.sicc.dtos.edu.DTOSegundaConvocatoria;
 
 public class LPSegundaConvocatoria extends LPSICCBase {

         private String accion = null;
         public LPSegundaConvocatoria() {
                  super();
         }
           
         public void inicio() throws Exception {
         }

         public void ejecucion() throws Exception {
                  setTrazaFichero();
                  traza("*** Entrada - LPSegundaConvocatoria - ejecucion ***");
                  try{
                           this.accion  = conectorParametroLimpia("accion","",true);
             
                           if (this.accion.equals("")) {
                                    muestraPantalla();
             }else if(this.accion.equals("SegundaConvocatoria")){
                  segundaConvocatoria();	
             }
         } catch (Exception e) {
                           logStackTrace(e);
                           this.lanzarPaginaError(e);
                  }
                  getConfiguracionMenu("LPSegundaConvocatoria",this.accion);
                  traza("*** Salida - LPSegundaConvocatoria - ejecucion ***");
         }
         
         private void muestraPantalla() throws Exception {
                  traza("*** Entrada - LPSegundaConvocatoria - muestraPantalla ***");
                  
                  pagina("contenido_no_asistentes_seleccionar");
                  asignarAtributo("PAGINA","contenido_no_asistentes_seleccionar", "cod", "0208");
         asignarAtributo("PAGINA","contenido_no_asistentes_seleccionar", "msgle", "Asignar aptas a cursos");
         getConfiguracionMenu("LPSegundaConvocatoria", "");
                  
                  asignarAtributo("VAR","accion","valor",this.accion);
                  
                  String strOid = conectorParametroLimpia("oidAsigna","",true);

		  //Se carga en el campo oidMarca el oid de la marca recibido en la llamada 
		  String marca = conectorParametroLimpia("oidMarca","",true);
		  asignar("VAR", "marca",marca );	

 		  //Se carga en el campo oidCanal el oid del canal recibido en la llamada 
                  String canal = conectorParametroLimpia("oidCanal","",true);
                  asignar("VAR", "canal",canal );	
                  
                  Long oid = null;
                  if(!strOid.equals("")){
                           oid = new Long(strOid);	
                           asignarAtributo("VAR","oidAsigna","valor",strOid);
                  }
                  traza("*** Salida - LPSegundaConvocatoria - muestraPantalla ***");
         }
         
         private void segundaConvocatoria() throws Exception {
                  traza("*** Entrada - LPSegundaConvocatoria - segundaConvocatoria ***");
                  
                  pagina("salidaGenerica");
                  
                  asignarAtributo("VAR","accion","valor",this.accion);
                  
                  //recogemos pais e idioma de sesion
                  Long pais = UtilidadesSession.getPais(this);
                  Long idioma = UtilidadesSession.getIdioma(this);
                  
                  //recogemos parámetros
                  String strOid = conectorParametroLimpia("oidAsigna","",true);
                  Long oid = null;
                  if(!strOid.equals("")){
                           oid = new Long(strOid);	
                  }


                  String strOidmarca = conectorParametroLimpia("marca","",true);
                  Long oidMarca = null;
                  if(!strOidmarca.equals("")){
                           oidMarca = new Long(strOidmarca);	
                  }
                  String strOidcanal = conectorParametroLimpia("canal","",true);
                  Long oidCanal = null;
                  if(!strOidcanal.equals("")){
                           oidCanal = new Long(strOidcanal);	
                  }
                  
                  
                  
                  String strCodigo = conectorParametroLimpia("txtCodCurso","",true);
                  traza("Codigo curso: "+strCodigo);
                  Integer codigo = null;
                  if(!strCodigo.equals("")){
                           codigo = new Integer(strCodigo);	
                  
                           //Creamos DTOSegundaConvocatoria
                           DTOSegundaConvocatoria dto = new DTOSegundaConvocatoria();
                           dto.setOidPais(pais);
                           dto.setOidIdioma(idioma);
                           dto.setCodCurso(codigo);
                           dto.setOidAsigna(oid);
                           dto.setOidMarca(oidMarca);
                           dto.setOidCanal(oidCanal);
                           
                           /// idBusiness = "EDUSegundaConvocatoria"
                           MareBusinessID idBusiness = new MareBusinessID("EDUSegundaConvocatoria");
                                    
                           Vector paramEntrada = new Vector();
                           paramEntrada.add(dto);
                           paramEntrada.add(idBusiness);
                           
                           // Se invoca al conector 
                           DruidaConector conector = conectar("ConectorSegundaConvocatoria",paramEntrada);
                  }
                  traza("Ejecutando fAceptarCorrecto");
                  asignar("VAR","ejecutar","fAceptarCorrecto()");
                  traza("*** Salida - LPSegundaConvocatoria - segundaConvocatoria ***");
         }
         
         private void logStackTrace(Throwable e) throws Exception {
                  traza("Se produjo la excepcion: " + e.getMessage());
                      
                  ByteArrayOutputStream baos = new ByteArrayOutputStream();
                  PrintStream ps = new PrintStream(baos);
                  e.printStackTrace(ps);
                      
                  traza("Stack Trace: " + baos.toString());
     }
}
