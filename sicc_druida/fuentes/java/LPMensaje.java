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

//import LPSICCBase;
import es.indra.druida.DruidaBase;
import es.indra.druida.DruidaConector;
import es.indra.druida.dom.DruidaDOMObjeto;
import es.indra.sicc.cmn.presentacion.rastreador.*;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.mare.common.dto.IMareDTO;
import es.indra.mare.common.dto.MareDTO;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.dtos.cal.DTOMensajeCallCenter;


import java.lang.String;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Vector;


public class LPMensaje extends LPSICCBase {
	String casodeuso = new String();
	private Long     lIdioma = null;
    private Long     lPais = null;

	public LPMensaje() {
    }

	public void inicio() throws Exception
	{
		pagina("contenido_parametros_mensaje_actualizar");
	}

	public void ejecucion() throws Exception
	{
        this.rastreo();
        setTrazaFichero();
		try{
			String sAccion = conectorParametro("accion")==null?"":conectorParametro("accion");
			lIdioma = UtilidadesSession.getIdioma(this);
			lPais = UtilidadesSession.getPais(this);
            traza(">>>> Acción................" + sAccion);
            traza(">>>> Idioma................" + lIdioma);
            traza(">>>> Pais.................." + lPais);
            
            //getConfiguracionMenu("LPMensaje","actualizar");
			asignarAtributoPagina("cod","0652");
                
			if (sAccion.equals("Consultar Mensaje"))
			{
				//getConfiguracionMenu("LPMensaje","consultar");
				mostrarPgConsultarActualizarMensaje();
			}
			
			if (sAccion.equals("Actualizar Mensaje"))
			{
				actualizarMensaje();
			}

			getConfiguracionMenu("LPMensaje","actualizar");
		}
        catch(Exception exception){
  		    exception.printStackTrace();
            lanzarPaginaError(exception);
        }
      }

	private void mostrarPgConsultarActualizarMensaje () throws Exception
	{
		//Crear DTOE del tipo DTOBelcorp con: 
		//- pais: pais activo 
		DTOBelcorp dtoB = new DTOBelcorp();
		dtoB.setOidIdioma(lIdioma);
		dtoB.setOidPais(lPais); 


		//Invocar conector ConectorObtenerMensajeCallCenter con el DTOE 
		//Crear IDBusiness="CALObtenerMensajeCallCenter" 
		//Obtiene DTOMensajeCallCenter. 
		MareBusinessID id = new MareBusinessID("CALObtenerMensajeCallCenter");
		Vector paramEntrada = new Vector();
		paramEntrada.add(dtoB);
		paramEntrada.add(id);
		DruidaConector conectorSalida = conectar("ConectorObtenerMensajeCallCenter",paramEntrada);
		DTOMensajeCallCenter dtoMCC = (DTOMensajeCallCenter)conectorSalida.objeto("dtoSalida");

		//Mostrar la página PgConsultarActualizarMensaje con: 
		pagina("contenido_parametros_mensaje_actualizar");		
		if(dtoMCC!= null)
		{
			if (dtoMCC.getOid() != null)
			{
				asignarAtributo("VAR", "hidOid", "valor", dtoMCC.getOid().toString());
				//asignarAtributo("AREATEXTO","atxtTextoMensaje","valor",dtoMCC.getTextoMensaje());
                asignarAtributo("VAR","hidTextoMensaje","valor",dtoMCC.getTextoMensaje());
				traza("Valor del OID" + dtoMCC.getOid().toString());
				traza("Valor del Texto" + dtoMCC.getTextoMensaje());
			}
		}
	}

	private void actualizarMensaje () throws Exception
	{
		//Crear DTOE del tipo DTOMensajeCallCenter con: 
		//- oid 
		//- textoMensaje 
		//- pais: pais activo 
		String oid = conectorParametro("hidOid")==null?"":conectorParametro("hidOid");
		String textoMensaje = conectorParametro("hidTextoMensaje");
		DTOMensajeCallCenter dtoMCC = new DTOMensajeCallCenter();
		if( oid != null && (!oid.equals("")))
		{
			traza("Valor del OID" + oid);
			dtoMCC.setOid(new Long(oid));
		}
		dtoMCC.setTextoMensaje(textoMensaje);
		dtoMCC.setOidPais(lPais);

		//Invocar conector ConectorActualizarMensaje con el DTOE 
		//Crear IDBusiness="CALActualizarMensajeCallCenter"
		MareBusinessID id = new MareBusinessID("CALActualizarMensajeCallCenter");

		Vector paramEntrada = new Vector();
		paramEntrada.add(dtoMCC);
		paramEntrada.add(id);
		DruidaConector conectorSalida = conectar("ConectorActualizarMensajeCallCenter",paramEntrada);
        mostrarPgConsultarActualizarMensaje();
	}
	 
}
