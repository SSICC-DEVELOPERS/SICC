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
 
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
 
import es.indra.sicc.util.DTOBelcorp;

import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;                
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList; 
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;

import es.indra.druida.DruidaConector; 

import es.indra.sicc.util.UtilidadesSession;
 
public class LPEliminarCargosAbonos extends LPSICCBase 
{
	public LPEliminarCargosAbonos() {
		super();
	}
	
	public void inicio() throws Exception {
		pagina("contenido_cargos_abonos_directos_buscar");
	}
	
	public void ejecucion() throws Exception {
		setTrazaFichero();
		traza("*** Entrada - LPEliminarCargosAbonos - ejecucion ***");
		
		try {
			String accion = conectorParametroLimpia("accion","",true);
			if (accion.equals("")) {
				accionVacia();
			}
		} catch (Exception e) {
			logStackTrace(e);
			lanzarPaginaError(e);
		}
		
		traza("*** Salida - LPEliminarCargosAbonos - ejecucion ***");
	}
	
	private void accionVacia() throws Exception {
		traza("*** Entrada - LPEliminarCargosAbonos - accionVacia ***");
		
		asignarAtributo("VAR","casoUso","valor","eliminar");
		asignarAtributo("PAGINA","contenido_cargos_abonos_directos_buscar","cod","0357");
		
		// Se obtiene el idioma y el pais de sesión
		UtilidadesSession session = new UtilidadesSession();
		Long pais = session.getPais(this);
        Long idioma = session.getIdioma(this);
		
		asignarAtributo("VAR","idioma","valor",idioma.toString());
		asignarAtributo("VAR","pais","valor",pais.toString());
		
		//Creamos un DTOBelcorp
        DTOBelcorp dto = new DTOBelcorp();
        dto.setOidPais(pais);
        dto.setOidIdioma(idioma);
        
        traza("*** Creado DTOBelcorp ***");
                  
        // Se llama al subsistema de carga de pantalla
        ComposerViewElementList listelem = new ComposerViewElementList();
        ComposerViewElement elem = new ComposerViewElement();
        elem.setIDBusiness("CCCObtenerDatosInicialesProcesos");
        elem.setDTOE(dto);
        listelem.addViewElement(elem);
        
        traza("*** Creado lista elementos ***");
        
        ConectorComposerView conector = new ConectorComposerView(listelem, this.getRequest());
        traza("*** ejecutamos el conector ***");
        conector.ejecucion();             
        traza("*** recogemos datos conector ***");                             
        DruidaConector conConsultar = conector.getConector();      
        
        traza("*** cargamos combo ***");
        asignar("COMBO","cbProceso",conConsultar,"CCCObtenerDatosInicialesProcesos");
        traza("*** combo cargado ***");
		
		// Genera un campo oculto que contiene el formato de fecha
		generarHiddenFormatoFecha();
		
		// Se llama a obtenerLongitudCodigoCliente y con el resultado se
        // rellena el campo oculto longitudCodigoCliente 
        Byte longitudCodigoCliente = this.obtenerLongitudCodigoCliente();
        asignarAtributo("VAR","longitudCodigoCliente", "valor", longitudCodigoCliente.toString());
		
		// Muestra el menú secundario
		getConfiguracionMenu("LPEliminarCargosAbonos","");
		
		traza("*** Salida - LPEliminarCargosAbonos - accionVacia ***");
	}
	
	private void logStackTrace(Throwable e) throws Exception {
		traza("Se produjo la excepcion: " + e.getMessage());

		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		e.printStackTrace(ps);
		
		traza("Stack Trace: " + baos.toString());
	}
}