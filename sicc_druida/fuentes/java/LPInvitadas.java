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
 /*
    INDRA/EDU/PROY
    $Id: LPInvitadas.java,v 1.1 2009/12/03 18:37:47 pecbazalar Exp $
    DESC
 */


import es.indra.druida.DruidaConector;

import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.exception.MareException;

import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;

import es.indra.druida.DruidaConector;

import java.util.StringTokenizer;
import java.util.Vector;

import java.io.PrintStream;
import java.io.ByteArrayOutputStream;


import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.util.UtilidadesBelcorp;

import es.indra.sicc.util.DTOBelcorp;

import es.indra.sicc.dtos.edu.DTOInvita;
import es.indra.sicc.dtos.edu.DTOClienteInvitada;

// Definicion de la clase
public class LPInvitadas extends LPSICCBase {
	
	public LPInvitadas() {
		super();
		}

	private String accion = null;
	private Long idioma;
    private Long pais;   
       
	public void inicio() throws Exception {
		
	}
     
	public void ejecucion() throws Exception {

		try {
			setTrazaFichero();
			traza("*** Entrada - LPInvitadas - ejecucion ***");
			pagina("contenido_invitar_cursos");
			this.generarHiddenFormatoFecha();
			
			this.idioma = UtilidadesSession.getIdioma(this);
        	asignar("VAR", "idioma", idioma.toString());
        	this.pais = UtilidadesSession.getPais(this);
        	asignar("VAR", "pais", pais.toString());
			this.accion = conectorParametroLimpia("accion", "", true);
			traza("accion = "+accion);
			Byte longitudCodigoCliente = obtenerLongitudCodigoCliente();
            asignar("VAR","numDigitosCodigoCliente", longitudCodigoCliente.toString());

			
			if (accion.equals("")) {
				traza("*** Entrada - LPInvitadas - accion vacia ***");
				muestraPantalla();
				traza("*** Salida - LPInvitadas - accion vacia ***");
			} else if (accion.equals("Load")) {
				traza("*** Entrada - LPInvitadas - accion Load ***");
				cargaInicial();
				traza("*** Salida - LPInvitadas - accion Load ***");
			} else if (accion.equals("Invitar")) {
				traza("*** Entrada - LPInvitadas - accion Invitar ***");
				invitaCliente();
				traza("*** Salida - LPInvitadas - accion Invitar ***");
			}
			
		} catch (Exception ex) {
			logStackTrace(ex);
			this.lanzarPaginaError(ex);   
		}
		traza("*** Salida - LPInvitadas - ejecucion ***");
	}
	
	private void muestraPantalla() throws Exception {
		
		traza("*** Entrada - LPInvitadas - muestraPantalla ***");
		asignarAtributo("PAGINA","contenido_invitar_cursos", "cod", "734");
        asignarAtributo("PAGINA","contenido_invitar_cursos", "msgle", "Registrar extemporáneas a cursos");
		getConfiguracionMenu("LPInvitadas","");
        
        traza("Antes de obtener oid");
        String oid = conectorParametroLimpia("oid", "", true);
        traza("oid = "+oid);
        traza("despues de obtener oid");
		asignar("VAR","oid", oid);
		cargaInicial();
		traza("*** Salida - LPInvitadas - muestraPantalla ***");
		
	}
	
	private void cargaInicial() throws Exception {
		//Rellenamos los combos canal y marca
		traza("*** Entrada - LPInvitadas - cargaInicial ***");
		DTOBelcorp dtoBelcorp = new DTOBelcorp();
				
		dtoBelcorp.setOidIdioma(idioma);
		dtoBelcorp.setOidPais(pais);
		ComposerViewElementList listelem = new ComposerViewElementList();
		ComposerViewElement elem = new ComposerViewElement();

		elem.setIDBusiness("SEGConsultaMarcas");
		elem.setDTOE(dtoBelcorp);
		elem.setPosOID((byte)0);
        elem.setPosDesc((byte)1);
		listelem.addViewElement(elem);

		elem = new ComposerViewElement();
		elem.setIDBusiness("SEGConsultaCanales");
		elem.setDTOE(dtoBelcorp);
		elem.setPosOID((byte)0);
        elem.setPosDesc((byte)1);
		listelem.addViewElement(elem);
		
		ConectorComposerView conector = new ConectorComposerView(listelem, this.getRequest());
		conector.ejecucion();
		DruidaConector conConsultar = conector.getConector();
		
		asignar("COMBO", "cbMarca", conConsultar, "SEGConsultaMarcas"); 
		asignar("COMBO", "cbCanal", conConsultar, "SEGConsultaCanales"); 
		
		traza("*** Salida - LPInvitadas - cargaInicial ***");
	}
	
	private void invitaCliente() throws Exception {
		traza("*** Entrada - invitaCliente - invitaCliente ***");
		pagina("salidaGenerica");
		DTOInvita dtoInvita = new DTOInvita();
		
		String oid = conectorParametroLimpia("oid","",true);
		dtoInvita.setOidCurso(new Long(oid));
		
		StringTokenizer st = new StringTokenizer(conectorParametroLimpia("datosInvitadas", "", true),"*");
		int numSeleccionados = st.countTokens();
		traza("Seleccionados = "+numSeleccionados);
		
		DTOClienteInvitada arrayClienteInvitada[] = new DTOClienteInvitada[numSeleccionados];
		DTOClienteInvitada dtoClienteInvitada = new DTOClienteInvitada();
		String datosFila = null;
		StringTokenizer st2 = null;
		Long oidCliente = null;
		Long oidSubtipo = null;
		traza("antes bucle");
		for (int i = 0; i < numSeleccionados; i++){
			if (!st.hasMoreTokens()) break;
			dtoClienteInvitada = new DTOClienteInvitada();
			traza("antes de obtener datos fila");
			datosFila = st.nextToken();
			traza("datos fila -- " + datosFila);
			st2 = new StringTokenizer(datosFila,",");
			if (st2.hasMoreTokens()){
				oidCliente = new Long(st2.nextToken());
				dtoClienteInvitada.setOidCliente(oidCliente);
				traza(i + " -- oidCliente : " + oidCliente);
			}
			if (st2.hasMoreTokens()){
				oidSubtipo = new Long(st2.nextToken());
				dtoClienteInvitada.setOidSubtipo(oidSubtipo);
				traza(i + " -- oidSubtipo : " + oidSubtipo);
			}
			
			arrayClienteInvitada[i] = dtoClienteInvitada;
		}
		traza("fin bucle");
		dtoInvita.setInvitadas(arrayClienteInvitada);
		traza(" dtoInvita = "+dtoInvita);
		// Se invoca al conector ConectorInvita 
        Vector paramEntrada = new Vector();
        paramEntrada.add(dtoInvita);
        paramEntrada.add(new MareBusinessID("EDUInvitar"));
        traza("antes de conectar");
        DruidaConector conector = conectar("ConectorInvita", paramEntrada);
		traza("Despues de conectar ");
		traza("*** Salida - invitaCliente - invitaCliente ***");
	}
	
	private void logStackTrace(Throwable e) throws Exception {
		traza("Se produjo la excepcion: " + e.getMessage());		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		e.printStackTrace(ps);		
		traza("Stack Trace: " + baos.toString());
	}
}