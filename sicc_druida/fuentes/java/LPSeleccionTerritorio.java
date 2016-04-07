//$Id: LPSeleccionTerritorio.java,v 1.1 2009/12/03 18:37:38 pecbazalar Exp $ 
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
import es.indra.druida.DruidaBase;
import LPSICCBase;
import es.indra.druida.DruidaConector;
import es.indra.sicc.util.BelcorpError;
import es.indra.sicc.util.IBelcorpError;
import es.indra.sicc.util.DTOError;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.util.UtilidadesBelcorp;

import es.indra.mare.common.dto.MareDTO;
import es.indra.mare.common.dto.IMareDTO;
import java.lang.reflect.InvocationTargetException;
import com.evermind.server.rmi.OrionRemoteException;

import es.indra.mare.common.mln.MareBusinessID;
import es.indra.mare.common.exception.MareException;

import es.indra.sicc.cmn.presentacion.rastreador.Rastreador;
import es.indra.sicc.cmn.presentacion.rastreador.IRastreador;
import es.indra.mare.common.mii.MareCredentials;


import es.indra.sicc.util.BelcorpError;
import es.indra.sicc.util.IBelcorpError;
import es.indra.sicc.util.DTOError;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOSalida;

import es.indra.sicc.dtos.mae.DTOCargaInicialTerritorios;

import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;
import java.util.Vector;
import java.lang.Boolean;
import java.io.*;

public class LPSeleccionTerritorio extends LPSICCBase {		
	public LPSeleccionTerritorio() {	 super();  }
	public void inicio() throws Exception { pagina("contenido_territorio_seleccionar"); }
	public void ejecucion() throws Exception {		
		   setTrazaFichero();
         traza("ejecucion");
         String accion	= conectorParametroLimpia("accion", "", true);
         String casoDeUso	= conectorParametroLimpia("casoDeUso", "", true);

         try { 
           MareBusinessID bid = new MareBusinessID("MAECargaInicialTerritorios");
           Vector paramEntrada = new Vector();
           DTOBelcorp dtoe = new DTOBelcorp();
           dtoe.setOidPais( UtilidadesSession.getPais(this));
           dtoe.setOidIdioma( UtilidadesSession.getIdioma(this));
           paramEntrada.addElement(dtoe); 
           paramEntrada.addElement(bid);
           traza("conectando a ConectorCargaInicialTerritorios");
           DruidaConector conector = conectar("ConectorCargaInicialTerritorios",paramEntrada);
           traza("esta conectado a ConectorCargaInicialTerritorios");
           DTOCargaInicialTerritorios dtos = (DTOCargaInicialTerritorios) conector.objeto("dtoSalida");           
           String lbls = "";
           traza("Niveles: " + dtos.getNiveles().get(0).toString());
           for(int i = 0;i < dtos.getNiveles().size();i++) {               
               lbls += ((i == 0)?"":"_") + (dtos.getNiveles()).get(i).toString();               
               asignarAtributo("CAPA", "capaCombo" + (i+1), "visibilidad", "V");                              
           }          
           asignarAtributo("VAR", "hidComboLabels", "valor", lbls);
           asignarAtributo("VAR", "hidPais", "valor", UtilidadesSession.getPais(this).toString());           
           traza("caso de uso " + casoDeUso);

			     getConfiguracionMenu();
			  
            if (casoDeUso.equals("clienteBasico")){
               getConfiguracionMenu("LPSeleccionTerritorio"); 
               asignarAtributoPagina("cod","0408");
            }

            if (casoDeUso.equals("impuesto_ubigeo_insertar")){
               asignarAtributoPagina("cod","0310");
            }

            if (casoDeUso.equals("impuesto_ubigeo_modificar")){
               asignarAtributoPagina("cod","0398");
            }

            if (casoDeUso.equals("impuesto_ubigeo_consultar")){
               asignarAtributoPagina("cod","0400");
            }

            if (casoDeUso.equals("impuesto_ubigeo_eliminar")){
               asignarAtributoPagina("cod","0399");
            }  

            if (casoDeUso.equals("InsertarCliente")){
                getConfiguracionMenu("LPSeleccionTerritorio"); 
                asignarAtributoPagina("cod","0309");
            }        
	                   
         } catch (Exception ex) {

				ByteArrayOutputStream stack = new ByteArrayOutputStream();
				PrintStream out = new PrintStream(stack);
				ex.printStackTrace(out);
				traza("EXCEPCION:" + stack.toString());
				lanzarPaginaError(ex);

         }				            
	}
}
