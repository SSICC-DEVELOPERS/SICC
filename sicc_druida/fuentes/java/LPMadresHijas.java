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

import es.indra.druida.DruidaConector; 

import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;

import java.util.Vector;
import java.util.Date;
import java.util.Calendar;
import java.math.BigDecimal;

import java.text.SimpleDateFormat;
import java.text.ParsePosition;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

import es.indra.sicc.dtos.cal.DTODatosClien;

import es.indra.druida.DruidaConector;
 
import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.UtilidadesFecha;
import es.indra.sicc.dtos.cal.DTODatosClien;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.DTOBelcorp;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;



public class LPMadresHijas extends LPSICCBase {
         
         private String accion = null;
         private String casoUso = null;
         private Long pais=null;
         private Long idioma=null;
         private Long oidCliente=null;
         private String oidContacto = null;
         
        
         
         
         public LPMadresHijas() {
                  super();
         }
         public void inicio() throws Exception {
         	pagina("contenido_consultoras_madres_hijas_consultar");  
         }
         public void ejecucion() throws Exception {
         	traza("****LPMadresHijas.ejecucion() Entrada");
         	setTrazaFichero();
          	try  {			
				this.idioma = UtilidadesSession.getIdioma(this);
            	this.pais = UtilidadesSession.getPais(this);
            	this.accion = conectorParametroLimpia("accion","", true);
            	this.oidContacto = conectorParametroLimpia("oidContacto","",true);   
				asignar("VAR", "oidContacto", this.oidContacto);
            	asignarAtributo("PAGINA","contenido_consultoras_madres_hijas_consultar","cod","0575");
				asignarAtributo("PAGINA","contenido_consultoras_madres_hijas_consultar","msgle","Consultar consultoras madres e hijas");
            	if(this.accion.equals("")){   
          
					Byte longitud = this.obtenerLongitudCodigoCliente();
					traza("Longitud"+longitud);
					Long longitudCodigoCliente = new Long(longitud.longValue());
					asignar("VAR","longitudCodigoCliente",longitudCodigoCliente.toString());	
					asignar("VAR","tamanio",longitud.toString());
					traza("Longitud del cod cliente: "+longitudCodigoCliente);
					traza("Longitud del cod cliente: "+longitud);
         	  		asignar("VAR", "idioma", idioma.toString());
         	  		
         			getConfiguracionMenu("LPMadresHijas","");
         			traza("despues de getConfiguracionMenu : ");
         			//this.oidCliente = new Long(conectorParametroLimpia("oidCliente","", true));
                    //this.oidCliente = new Long(1);
					this.oidCliente = new Long(conectorParametroLimpia("oidCliente", "", true));
					traza("Coge el oidCliente");
		         	asignar("VAR", "oidCliente", this.oidCliente.toString());
	         		asignar("VAR", "idioma", this.idioma.toString());
	         		traza("Despues de asignar");
	         	  	asignar("VAR", "pais", pais.toString());	
	         	  	traza("despues de pais");
	         		this.cargaInicial(this.pais, this.oidCliente);
         		}//if accion vacia	
         	}catch(Exception e){
				traza("Estoy en uno");
				e.printStackTrace();
				this.logStackTrace(e);
				lanzarPaginaError(e);			
			}	
		traza("****LPMadresHijas.ejecucion() salida");		
   }//ejecucion
         
	public void cargaInicial( Long oidPais, Long oidCliente) throws Exception {  
       traza("****LPMadresHijas.cargaInicial() Entrada");    	
       try{	
			setTrazaFichero();
			Vector paramConector = new Vector();
			DTOOID dto = new DTOOID();
			dto.setOidIdioma(this.idioma);
			dto.setOidPais(this.pais);
			dto.setOid(oidCliente);
			
			paramConector.add(dto);
			paramConector.add(new MareBusinessID("CALObtenerNombresCliente"));          
			
			traza("Antes de Conectar");			
			DruidaConector conector = conectar("ConectorConsultarNombresCliente", paramConector);							
			traza("Despues de Conectar");
			Object objeto=conector.objeto("DTOSalida");
			traza("Objeto recogido"+objeto);
			DTOSalida  dtoSalida = (DTOSalida)conector.objeto("DTOSalida");
			RecordSet rs =dtoSalida.getResultado();
				
	        traza("Intentamos sacar del Resultado"+rs);
			String codCliente=(String)rs.getValueAt(0,0);
			String nombre1=(String)rs.getValueAt(0,1);
			String nombre2=(String)rs.getValueAt(0,2);
			String ape1=(String)rs.getValueAt(0,3);
			String ape2=(String)rs.getValueAt(0,4);
			String total=" ";
			traza("Nombre1 " +nombre1);
			traza("Nombre2 " +nombre2);
			traza("Ape1 " +ape1);
			traza("Ape2 " +ape2);
			String espacio=" ";
			if(nombre1!=null){
				total=total+nombre1;
				total=total+espacio;
			}
			if(nombre2!=null){
				total=total+nombre2;
				total=total+espacio;	 
			}	 
			if(ape1!=null){
				 total=total+ape1;
				 total=total+espacio;	
			}
			if(ape2!=null){
				total=total+ape2;
				total=total+espacio;	

			}		
			traza("Codigo " +codCliente);
			traza("Total " +total);
			asignarAtributo("LABELC", "lbldtApellidosNombre", "valor" , total.toUpperCase());
			asignarAtributo("LABELC", "lbldtCodConsultora", "valor" , codCliente);
			
			Vector paramEntrada = new Vector();
			
			dto.setOidPais(this.pais);
            dto.setOid(this.oidCliente);
			dto.setOidIdioma(this.idioma);
			paramEntrada.add(dto);
        	paramEntrada.add(new MareBusinessID("CALConsultarConsultorasHijas"));
			conector = conectar("ConectorConsultarConsultorasHijas", paramEntrada);
			asignar("LISTAEDITABLE", "listado1", conector, "dtoSalida.resultado_ROWSET");
			
        }catch(Exception e){
		 	traza(" [csanchez]cargaInicial( Long oidPais, Long oidCliente) my Function ");
			traza("Estoy en dos");
			e.printStackTrace();
			this.logStackTrace(e);
			lanzarPaginaError(e);			
		}	
		traza("[cs]****LPMadresHijas.cargaInicial() salida");
    }
        
        
        
	private void logStackTrace(Throwable e) throws Exception {
		traza("Se produjo la excepcion: " + e.getMessage());		
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        e.printStackTrace(ps);		
        traza("Stack Trace: " + baos.toString());
    }	
         
}//LP
          