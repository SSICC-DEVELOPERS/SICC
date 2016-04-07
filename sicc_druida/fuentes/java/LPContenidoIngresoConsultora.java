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
import java.util.Vector;

import es.indra.mare.common.exception.MareException;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.DTOSalida;
import es.indra.druida.DruidaConector;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mln.MareBusinessID;

import es.indra.sicc.dtos.cal.DTOIngresoConsultora;


public class LPContenidoIngresoConsultora extends LPSICCBase {
         
         private String accion = null;
         private Long pais = null;
         private Long idioma = null;
         private String oidContacto = null;
         public LPContenidoIngresoConsultora() {
         	super();
         }

         public void inicio() throws Exception {
                  pagina("contenido_ingreso_consultora_consultar");
         }

         public void ejecucion() throws Exception {
			setTrazaFichero();
            try  {
              	traza("*** LPContenidoIngresoConsultora.ejecucion: Entrada ***");
                this.accion = conectorParametroLimpia("accion","", true);
                Long idioma = UtilidadesSession.getIdioma(this);
                traza("accion : "+accion);
                asignar("VAR", "idioma", idioma.toString());
                Long pais = UtilidadesSession.getPais(this);
                asignar("VAR", "pais", pais.toString());
                  
                this.oidContacto = conectorParametroLimpia("oidContacto","",true);   
				asignar("VAR", "oidContacto", this.oidContacto);

                asignarAtributo("PAGINA","contenido_ingreso_consultora_consultar", "cod", "0580");
             	asignarAtributo("PAGINA","contenido_ingreso_consultora_consultar", "msgle", "Consultar ingreso de consultora");
             	getConfiguracionMenu("LPContenidoIngresoConsultora", "");

                    	
                if(this.accion.equals("")){
                	//Se obtiene el oidPais, oidMarca, oidCanal y el oidCliente 
					//cargaInicial(oidPais, oidMarca, oidCanal y el oidCliente) 
					String oidMarca = conectorParametroLimpia("oidMarca","",true);
					asignar("VAR", "oidMarca", oidMarca);
					String oidCanal = conectorParametroLimpia("oidCanal","",true);
					asignar("VAR", "oidCanal", oidCanal);
					String oidCliente = conectorParametroLimpia("oidCliente","",true);
					asignar("VAR", "oidCliente", oidCliente);
				 



					traza(" oidMarca = "+oidMarca+" oidCanal = "+oidCanal+" oidCliente = "+oidCliente);
					this.cargaInicial(pais,new Long(oidMarca),new Long(oidCanal),new Long(oidCliente));
				}

				traza("*** LPContenidoIngresoConsultora.ejecucion: Salida ***");			
			}catch ( Exception e )  {
                e.printStackTrace();
                this.logStackTrace(e);
                lanzarPaginaError(e);
			}		
		}
        private void cargaInicial(Long oidPais, Long oidMarca, Long oidCanal, Long oidCliente) throws Exception{
         	/*Documentation
		Realiza la carga inicial de la pantalla. 
		Proceso 
		======== 
		Se crea el elemento: 
		elem1.idNegocio="CALObtenerHistoricoDatos" 
		elem1.dtoe=DTOIngresoConsultora (con el oidPais, oidMarca, oidCanal y oidCliente) 
		*/
			traza("*** LPContenidoIngresoConsultora.cargaInicial: Entrada ***");
			Vector elem1 = new Vector();
			DTOIngresoConsultora dtoe = new DTOIngresoConsultora();
			dtoe.setOidPais(oidPais);
			dtoe.setOidMarca(oidMarca);
			dtoe.setOidCanal(oidCanal);
			dtoe.setOidCliente(oidCliente);
				
			elem1.add(dtoe);
            elem1.add(new MareBusinessID("CALObtenerHistoricoDatos")); 
                
            //Se invoca al conector ConectorObtenerHistoricoDatos 
            traza("Antes de Conectar ConectorObtenerHistoricoDatos  ");
            DruidaConector conector = conectar("ConectorObtenerHistoricoDatos", elem1);							
            traza("Despues de Conectar ConectorObtenerHistoricoDatos ");		    
				
		/*
		Se cargan los label con los valores del oidSalida 
		lbFechaIngreso->fechaIngreso 
		lbPeriodoIngreso->periodoIngreso 
		lbBloqueoAdministrativo->bloqueoAdministrativo 
		lbMotivoBloqueoAdministrativo->motivoBloqueoAdministrativo 
		lbBloqueoFinanciero->bloqueoFinanciero 
		*/
			DTOSalida salida = (DTOSalida)conector.objeto("DTOSalida");
			RecordSet rs = salida.getResultado();
			traza("*** RECORDSET = "+rs);
			if(!rs.esVacio()){
				traza(" *** Entra en el if del recordSet ***");
				if(rs.getValueAt(0,0) != null){
					traza("Asigna fecha **");
					asignar("LABELC","lbldtFechaIngreso", rs.getValueAt(0,0).toString());
				}
				if(rs.getValueAt(0,1) != null){
					traza("Asigna Periodo Ingreso**");
					asignar("LABELC","lbldtPeriodoIngreso",rs.getValueAt(0,1).toString());
				}
				if(rs.getValueAt(0,2) != null){
					traza("Asigna BloqueoAdm **");
					asignar("LABELC","lbldtBloqueo",rs.getValueAt(0,2).toString());
					//asignar("LABELC","lbldtBloqueoAdministrativo",rs.getValueAt(0,2).toString());
				}
				if(rs.getValueAt(0,3) != null){
					traza("Asigna motivo **");
					//asignar("LABELC","lbldtMotivoBloqueoAdministrativo",rs.getValueAt(0,3).toString());
					asignar("LABELC","lbldtMotivoBloqueo",rs.getValueAt(0,3).toString());
				}
				if(rs.getValueAt(0,4) != null){
					traza("Asigna bloqueof **");
					//asignar("LABELC","lbldtBloqueoFinanciero",rs.getValueAt(0,4).toString());
					asignar("LABELC","lbldtObsBloqueo",rs.getValueAt(0,4).toString());
				}
			}
			
			traza("*** LPContenidoIngresoConsultora.cargaInicial: Salida ***");
		}	
		
		private void logStackTrace(Throwable e) throws Exception {
           traza("Se produjo la excepcion: " + e.getMessage());		
           ByteArrayOutputStream baos = new ByteArrayOutputStream();
           PrintStream ps = new PrintStream(baos);
           e.printStackTrace(ps);		
           traza("Stack Trace: " + baos.toString());
		}
}		
