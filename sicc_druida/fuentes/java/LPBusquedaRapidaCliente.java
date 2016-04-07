//$Id: LPBusquedaRapidaCliente.java,v 1.1 2009/12/03 18:35:12 pecbazalar Exp $ 
/** 
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
/**
 * Sistema:           Belcorp
 * Modulo:            MAE
 * Submódulo:         Materiales
 * Componente:        LP
 * Fecha:             13/05/2003
 * Observaciones:     Componente construido de acuerdo a la especificación del
 *                    Modelo de Componentes SICC-DMCO-SEG-001-202
 *                    (Subido al portal el 01/05/2003)
 * @version           1.0
 * @autor             Marta Montiel
 */ 

import es.indra.druida.DruidaBase;
import es.indra.druida.DruidaConector;
import es.indra.druida.dom.DruidaDOMObjeto;

import es.indra.sicc.util.BelcorpError;
import es.indra.sicc.util.IBelcorpError;
import es.indra.sicc.util.DTOError;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.druida.dom.DruidaDOMObjeto;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.mare.common.exception.MareException;

import es.indra.sicc.cmn.presentacion.rastreador.Rastreador;
import es.indra.sicc.cmn.presentacion.rastreador.IRastreador;
import es.indra.mare.common.mii.MareCredentials;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.dtos.mae.DTOBusquedaRapidaCliente;
import java.util.Vector;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.sql.Date;
import java.util.Calendar;


public class LPBusquedaRapidaCliente extends LPSICCBase {	
	
	public LPBusquedaRapidaCliente() {
		super();
	}
	
	public void inicio() throws Exception {
		setTrazaFichero();
		/*La página asociada es BusquedaRapidaClientes*/
		pagina("contenido_campos_codigo_cliente_buscar");
	}

	public void ejecucion() throws Exception {
		rastreo();
		
		String accion 		= conectorParametroLimpia( "accion","",true );
		String apellido1 	= conectorParametroLimpia( "hidApellido1","",true );
		String apellido2	= conectorParametroLimpia( "hidApellido2","",true );
		String nombre1 	= conectorParametroLimpia( "hidNombre1","",true );
		String nombre2 	= conectorParametroLimpia( "hidNombre2","",true );
		String codClie 	= conectorParametroLimpia( "hidCodCliente","",true );
		String documento 	= conectorParametroLimpia( "hidDocu","",true );
		String criterioB1 = conectorParametroLimpia( "hidCriterioB1","",true );
		String criterioB2 = conectorParametroLimpia( "hidCriterioB2","",true );
		
		traza("accion   " + accion);
		
		traza("antes de pais-idioma");

		Long pais = UtilidadesSession.getPais(this);
		Long idioma = UtilidadesSession.getIdioma(this);

		traza("despues de pais-idioma: " + pais + " - " + idioma );
		
		try{

			if ( accion.equals("") ) {
				
				asignarAtributo("VAR", "hidOidPais", "valor", pais.toString() );
				asignarAtributo("VAR", "hidOidIdioma", "valor", idioma.toString() );

				traza("OID's asignados");
			
			}else{
				traza("2da vez");
			}

		} catch (Exception ex){
				this.lanzarPaginaError(ex);
		}
		
		getConfiguracionMenu();
	}


  /* 
	*  Retorna el Id de funcion.
   * */
	private String getIdFuncion() throws MareException, Exception {		
		String idFuncion = (String)conectorParametro("hidIdFuncion");
		return idFuncion;		
	}

 }