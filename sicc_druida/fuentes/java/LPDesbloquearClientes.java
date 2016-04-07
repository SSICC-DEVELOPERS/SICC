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

import es.indra.mare.common.mln.MareBusinessID;

import es.indra.druida.DruidaConector;

import es.indra.sicc.dtos.mae.DTOBuscarClienteBloqueo;
import es.indra.sicc.dtos.ccc.DTOBloquearCliente;
import es.indra.sicc.dtos.ccc.DTOBloquearClientes;

import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.util.UtilidadesBelcorp;

import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import java.util.Vector;
import java.util.StringTokenizer;


public class LPDesbloquearClientes extends LPSICCBase {

	private String accion = null;
	private Long idioma;
	private Long pais;

	public LPDesbloquearClientes() {
		super();
	}

	public void inicio() throws Exception {
	}

	public void ejecucion() throws Exception {

		try {
			setTrazaFichero();
            		traza("***Entrada - LPDesbloquearClientes - ejecucion***");

			accion = conectorParametroLimpia("accion", "", true);
			traza("***accion : " + accion);

    			this.idioma = UtilidadesSession.getIdioma(this);
			this.pais = UtilidadesSession.getPais(this);

			if (accion.equals("")) {
			        // Defino el nombre de la vista
			    	pagina("contenido_clientes_desbloquear");
				Byte longitud = this.obtenerLongitudCodigoCliente();
				Long longitudCodigoCliente = new Long(longitud.longValue());
				asignar("VAR","tamanio",longitud.toString());
			}

			if (accion.equals("desbloquear")) {
				accionDesbloquear();
			}

			if (accion.equals("bloquear")) {
				accionBloquear();
			}


			traza("***Salida - LPDesbloquearClientes - ejecucion***");

			getConfiguracionMenu("LPDesbloquearClientes", accion);

		} catch (Exception e){
			lanzarPaginaError(e);
			logStackTrace(e);
		}
	}

	private void accionDesbloquear() throws Exception {
		traza("***Entrada -  LPDesbloquearClientes - accionDesbloquear");
		pagina("salidaGenerica");
             	traza("Salida Generica");
		
		asignar("VAR", "cerrarVentana", "false");

		//Long idioma = UtilidadesSession.getIdioma(this);
		//Long pais = UtilidadesSession.getPais(this);
		traza("------------------------- IDIOMA: " + this.idioma);
		traza("------------------------- PAIS: " + this.pais);

		// ahora se llama a una pagina generica oculta
		// con el asignar se evita que se cierre la ventana que abrio la ventana oculta
		
		// Creamos un DTOOIDs y metemos los oids ocultos de aquellas filas que 
		// tencan el checkbox marcado		
		DTOOIDs dtoOIDs = new DTOOIDs();

		String listaOIDs = conectorParametroLimpia("oidsSeleccionados", "", true);
		traza("------- listaOIDs: " + listaOIDs);		

		StringTokenizer st = new StringTokenizer(listaOIDs, ",");
		Long oids[] = new Long[st.countTokens()];
		int i = 0;
		while (st.hasMoreTokens()) {
			oids[i++] = new Long(st.nextToken());
		}
		
		traza("-------/////////////////////////// OIDs: ");
		for (i=0; i<oids.length; i++)
			traza("------- OID: " + oids[i]);

		dtoOIDs.setOids(oids);
		dtoOIDs.setOidIdioma(this.idioma);
		dtoOIDs.setOidPais(this.pais);

		// asigno los valores de pais e idioma a los campos ocultos de la pagina
		//asignarAtributo("VAR", "pais", "valor", pais.toString());
		//asignarAtributo("VAR", "idioma", "valor", idioma.toString());

		// idBusiness =" CCCDesBloquearClientes"
		MareBusinessID idBusiness = new MareBusinessID("CCCDesbloquearClientes");

		// Llamamos al ConectorEliminar
		Vector params = new Vector();
		params.add(dtoOIDs);
		params.add(idBusiness);

        	DruidaConector conector = conectar("ConectorDesbloquearClientes", params);

		// una vez hecho esto ejecutamos la accion ="buscar" para que se 
		// recargue la pantalla con el efecto de la operación ejecutada 
		// Esto se hace en javascript mediante DruidaTransaction (BELC300003494)

		asignarAtributo("VAR", "ejecutar", "valor", "accionBuscar()");
		
		traza("***Salida -  LPDesbloquearClientes - accionDesbloquear");
	}
	

	private void accionBloquear() throws Exception {
		traza("***Entrada -  accionbloquear - accionBloquear");
		pagina("salidaGenerica");
             	traza("Salida Generica");
		
		asignar("VAR", "cerrarVentana", "false");

		traza("- IDIOMA: " + this.idioma);
		traza("- PAIS: " + this.pais);



		DTOOIDs dtoOIDs = new DTOOIDs();

		String listaOIDs = conectorParametroLimpia("oidsSeleccionados", "", true);
		traza("------- listaOIDs: " + listaOIDs);		


		String datos = conectorParametroLimpia("datos", "", true);
		traza("------- Datos: " + datos);		

		
		StringTokenizer st = new StringTokenizer(listaOIDs, ",");
		Long oids[] = new Long[st.countTokens()];
		int i = 0;
		while (st.hasMoreTokens()) {
			oids[i++] = new Long(st.nextToken());
		}
		
		
	/*	
		-Creamos un DTOBloquearCliente y metemos los campos siguientes de aquellas filas que tencan el checkbox marcado: 
		oid, observacionesBloqueo, motivoBloqueo 
	*/


		StringTokenizer fila = new StringTokenizer(datos, ";");
		StringTokenizer columna;
		String tok;
		DTOBloquearClientes dtoBloquearClientes = new DTOBloquearClientes();
		DTOBloquearCliente clientes[] = new DTOBloquearCliente[fila.countTokens()];
		
		int coma,posicion,k=0;
		while (fila.hasMoreTokens()) {
			DTOBloquearCliente dto = new DTOBloquearCliente();			
			columna = new StringTokenizer(fila.nextToken(), ",",true);
			coma=0;
			while (columna.hasMoreTokens()) {
				tok = columna.nextToken();
				if (!tok.equals(",")){
					switch (coma){
						case 0: { dto.setOidCliente(new Long(tok)); break;}
						case 1: { dto.setMotivoBloqueo(tok);        break;}
						case 2: { dto.setObservacionesBloqueo(tok); break;}
					}
				}else{
					coma++;
				}
			}
			clientes[k]=dto;
			k++;
		}
		dtoBloquearClientes.setBloquearCliente(clientes);
	

		// idBusiness =" CCCBloquearClientes"
		MareBusinessID idBusiness = new MareBusinessID("CCCBloquearClientes");

		// Llamamos 
		//	-idBusiness = "CCCBloquearClientes" 
		//	-Llamamos al ConectorBloquearClientes 

		Vector params = new Vector();
		params.add(dtoBloquearClientes);
		params.add(idBusiness);

        	DruidaConector conector = conectar("ConectorBloquearClientes", params);

		// una vez hecho esto ejecutamos la accion ="buscar" para que se 
		// recargue la pantalla con el efecto de la operación ejecutada 
		// Esto se hace en javascript mediante DruidaTransaction (BELC300003494)

		asignarAtributo("VAR", "ejecutar", "valor", "accionBuscar()");
		
		traza("***Salida -  accionBloquear - accionBloquear");
	}

	
	private void logStackTrace(Throwable e) throws Exception {
	    	traza("Se produjo la excepcion: " + e.getMessage());
	
	        ByteArrayOutputStream baos = new ByteArrayOutputStream();
	        PrintStream ps = new PrintStream(baos);
	        e.printStackTrace(ps);
	                  
	        traza("Stack Trace: " + baos.toString());
   	}
	
}