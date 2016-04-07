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

import es.indra.sicc.util.DTOString;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.util.UtilidadesBelcorp;

import es.indra.mare.common.exception.MareException;
import es.indra.druida.DruidaConector;
import es.indra.mare.common.mln.MareBusinessID;

import es.indra.sicc.dtos.rec.DTOConsultarCabeceraReclamo;

public class LPConsultarInforme extends LPSICCBase {
          
	private String accion = null;
	private Long idioma = null;
	private Long pais = null;
	
	public LPConsultarInforme() {
	        super();
	}
	
	public void inicio() throws Exception {
		pagina("contenido_resultados_chequeos_buscar");
	}

	public void ejecucion() throws Exception {
		setTrazaFichero();
		try  {         
			traza("*** Entrada - LPConsultarInforme - ejecucion ***"); 
			
			this.idioma = UtilidadesSession.getIdioma(this);
			traza("Idioma: "+this.idioma);
			this.pais = UtilidadesSession.getPais(this);
			traza("Pais: "+this.pais);
			this.accion = conectorParametroLimpia("accion","", true);
			traza("Accion: "+this.accion);
					
			
			if(this.accion.equals("")){
                String codigoCliente = conectorParametroLimpia("codCliente","", true);
				//Eliminada esta pagina por incidencia 15849
				//pagina("contenido_reclamos_cliente_buscar");
				pagina("contenido_resultados_chequeos_buscar");
				Byte longitudCodigoCliente = obtenerLongitudCodigoCliente();
				asignar("VAR","longitudCodigoCliente", longitudCodigoCliente.toString());
				asignar("VAR","casoUso", "consultarInforme");
				// Inc. DBLG700000144 Seteo automáticamente el codigo de cliente que viene de Callcenter
                if (codigoCliente != null && !codigoCliente.equals("")) {
                    traza("LPConsultarInforme - codCliente para pre-carga de CTEXTO_" + codigoCliente);
				    asignarAtributo("CTEXTO", "txtCodigoCliente", "valor", codigoCliente);
				}
				configurarMenuSecundario();
			}
			
			if(this.accion.equals("consultar reclamo")){
				traza("Antes de llamar a accionConsultar");
				accionConsultar();
			}
			
			traza("*** Salida - LPConsultarInforme - ejecucion ***"); 
		}catch ( Exception e )  {
		      e.printStackTrace();
		      logStackTrace(e);
		      lanzarPaginaError(e);
		}              
	}
	private void accionConsultar() throws Exception{
		traza("*** Entrada - LPConsultarInforme - accionConsultar ***"); 
		/*
		- Crear un DTOE del tipo DTOString con el codCliente (además pais y el idioma) 
		- Invocar al conector ConectorConsultarCabeceraReclamo con el DTOE 
		- Crear IDBusiness="RECConsultarCabeceraReclamo" 
		
		- Mostrar la PantallaDetalleReclamosCliente asignando: 
		- oidCliente = DTOConsultarCabeceraReclamo.oidCliente 
		- codCliente = DTOConsultarCabeceraReclamo.codCliente 
		- nombre = DTOConsultarCabeceraReclamo.nombre 
		- zona = DTOConsultarCabeceraReclamo.zona 
		- estadoCliente = DTOConsultarCabeceraReclamo.estadoCliente 
		*/
		Byte longitudCodigoCliente = obtenerLongitudCodigoCliente();
		asignar("VAR","longitudCodigoCliente", longitudCodigoCliente.toString());
		String codCliente = conectorParametroLimpia("txtCodigoCliente","",true);
		String oidZona = conectorParametroLimpia("oidZona","",true);
		traza ("Codigo Cliente Del cuadro de texto: "+codCliente);
		if(conectorParametroLimpia("codCliente","", true)!=null && conectorParametroLimpia("codCliente","", true) != ""){
		    codCliente = conectorParametroLimpia("codCliente","", true);
			traza ("Usamos el Codigo Cliente de Parametro");
		}
		traza ("Codigo Cliente Recibido como parametro : "+codCliente);
		traza ("Odi Zona Recibido como parametro : "+oidZona);
		asignar("CTEXTO","txtCodigoCliente",codCliente);
		asignar("VAR","casoUso", "consultarInforme");
		traza ("Codigo Cliente: "+codCliente);
		DTOString dtoe = new DTOString();
		dtoe.setOidPais(this.pais);
		dtoe.setOidIdioma(this.idioma);
		/*77777777777777777*/
		traza("7777777777 oidZona: " + oidZona);
        
		if (!oidZona.equals(""))
		{
		
			dtoe.setCadena(codCliente + "/" + oidZona);
		}else{
			dtoe.setCadena(codCliente + "/");
		}

		Vector paramConector = new Vector();
              paramConector.add(dtoe);
              paramConector.add(new MareBusinessID("RECConsultarCabeceraReclamo"));             
              traza("Antes de Conectar ConectorConsultarCabeceraReclamo");
              DruidaConector conector = conectar("ConectorConsultarCabeceraReclamo", paramConector);							
              traza("Despues de Conectar ConectorConsultarCabeceraReclamo");
              
              Object objeto=conector.objeto("DTOConsultarCabeceraReclamo");
              traza("DTOConsultarCabeceraReclamo recogido"+objeto);
              DTOConsultarCabeceraReclamo dtoSalida = (DTOConsultarCabeceraReclamo)conector.objeto("DTOConsultarCabeceraReclamo");
              traza("DTOConsultarCabeceraReclamo obtenido");
         
              pagina("contenido_reclamos_cliente_detalle");
              configurarMenuSecundario();
              
              traza("Antes asigar a las labels");  
              traza("CodClienteX: "+dtoSalida.getCodCliente().toString());
              asignar("LABELC","lblCodClienteX",dtoSalida.getCodCliente().toString());
              traza("Nombre: "+dtoSalida.getNombre().toString());
              asignar("LABELC","lblNomApeClienteX",dtoSalida.getNombre().toString());
              traza("Zona: "+dtoSalida.getZona().toString());
              asignar("LABELC","lblZonaX",dtoSalida.getZona().toString());
              traza("Estado Cliente: "+dtoSalida.getEstadoCliente().toString());
              asignar("LABELC","lblEstadoClienteX",dtoSalida.getEstadoCliente().toString());
              asignar("VAR","pais",this.pais.toString());
		asignar("VAR","idioma", this.idioma.toString());
		asignar("VAR","oidCliente", dtoSalida.getOidCliente().toString());
		traza("OidCliente: "+dtoSalida.getOidCliente().toString());
	
		traza("*** Salida - LPConsultarInforme - accionConsultar ***"); 
	}
	
	private void configurarMenuSecundario() throws Exception{
		traza("*** Entrada - LPConsultarInforme - configurarMenuSecundario ***"); 
		traza("Accion: "+this.accion);
		
		if (this.accion.equals("")){
			asignarAtributo("PAGINA","contenido_resultados_chequeos_buscar", "cod", "0133");
			asignarAtributo("PAGINA","contenido_resultados_chequeos_buscar", "msgle", "Buscar Reclamos por Cliente");
			getConfiguracionMenu("LPConsultarInforme","");
		}
		
		if (this.accion.equals("consultar reclamo")){
			asignarAtributo("PAGINA","contenido_reclamos_cliente_detalle", "cod", "0133");
			asignarAtributo("PAGINA","contenido_reclamos_cliente_detalle", "msgle", "Consultar Reclamos por Cliente Detalle");
			getConfiguracionMenu("LPConsultarInforme","detalle");			
		}
		
		traza("*** Salida - LPConsultarInforme - configurarMenuSecundario ***"); 		
	}	

	private void logStackTrace(Throwable e) throws Exception {
	      traza("Se produjo la excepcion: " + e.getMessage());		
	      ByteArrayOutputStream baos = new ByteArrayOutputStream();
	      PrintStream ps = new PrintStream(baos);
	      e.printStackTrace(ps);		
	      traza("Stack Trace: " + baos.toString());
	}	
}