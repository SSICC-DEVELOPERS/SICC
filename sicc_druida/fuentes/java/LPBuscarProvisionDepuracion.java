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
 
import java.util.Vector;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import es.indra.mare.common.mln.MareBusinessID;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

import es.indra.druida.DruidaConector;

import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.dtos.ccc.DTOCargaInicialBuscarLotes;
import es.indra.sicc.logicanegocio.ccc.CCCConstantes;
 
public class LPBuscarProvisionDepuracion extends LPSICCBase 
{
	public LPBuscarProvisionDepuracion() {
		super();
	}
	
	public void inicio() throws Exception {
		pagina("contenido_lotes_busqueda");
	}
	
	public void ejecucion() throws Exception {
		setTrazaFichero();
		traza("*** Entrada - LPBuscarProvisionDepuracion - ejecucion ***");
		
		try {
			String accion = conectorParametroLimpia("accion","",true);
			if (accion.equals("")) {
				accionVacia();
			}
		} catch (Exception e) {
			lanzarPaginaError(e);
			logStackTrace(e);
		}
		
		traza("*** Salida - LPBuscarProvisionDepuracion - ejecucion ***");
	}
	
	private void accionVacia() throws Exception {
		traza("*** Entrada - LPBuscarProvisionDepuracion - accionVacia ***");
		
		UtilidadesSession sesion = new UtilidadesSession(); 
		Long oidPais = UtilidadesSession.getPais(this);
		Long oidIdioma = UtilidadesSession.getIdioma(this);
		String pais = UtilidadesSession.getDescripcionPais(this);
		
		String casoUso = conectorParametroLimpia("casoUso", "", true);
        asignarAtributo("VAR", "casoUso", "valor", casoUso);
		
		asignarAtributo("VAR","idioma","valor",oidIdioma.toString());
        asignarAtributo("VAR","pais","valor",oidPais.toString());
        
        /*Long canal = UtilidadesSession.getCanalPorDefecto(this);        
		if (canal != null) {
			asignar("VAR", "canal", canal.toString());
			traza("paso 4");
		}
 		Long subacceso = UtilidadesSession.getSubaccesoPorDefecto(this); 		
		if (subacceso != null) {
			asignar("VAR", "subacceso", subacceso.toString());
			traza("paso 6");
		}*/

		
		// -Creamos un DTOBelcorp con el idioma y el pais del usuario.
		
		DTOBelcorp dtoBelcorp = new DTOBelcorp();
		dtoBelcorp.setOidIdioma(oidIdioma);
		dtoBelcorp.setOidPais(oidPais);
		
		// -idBusiness: "CCCCargaInicialBuscarLotes" 
		MareBusinessID idBussiness = new MareBusinessID("CCCCargaInicialBuscarLotes");
		
		// Se almacenan los parametros de entrada
		Vector paramEntrada = new Vector();
		paramEntrada.addElement(dtoBelcorp);
		paramEntrada.addElement(idBussiness);
		
		// -Llamamos al ConectorCargaInicialBuscarLotes
		traza("Antes de llamar al conector");
		DruidaConector conector = conectar("ConectorCargaInicialBuscarLotes", paramEntrada);
        traza("Despues de llamar al conector");
                        
        // Se recibe un DTOSalida devuelto por el conector
		traza("Obteniendo DTO de salida, DTOCargaInicialBuscarLotes");
		DTOCargaInicialBuscarLotes dtoSalida = (DTOCargaInicialBuscarLotes)conector.objeto("DTOCargaInicialBuscarLotes");
		traza("Obtenido2 DTO de salida, DTOCargaInicialBuscarLotes");
				
		
		//Con el dto obtenido hacemos lo siguiente: 
		//cargamos los combos tipoCargoAbono, situacion y canales con los recordsets correspondientes (oid + descripcion). 
		//los recordsets accesos y subaccesos los guardamos en listas ocultas para recargar dinánicamente. 
		
		if (dtoSalida == null)
			traza("DtoSalida es nulo");
		else
			traza("DtoSalida no es nulo");
		
		// Se genera un conector a partir del recordset, y se carga el combo
		RecordSet rsTipoAbono = dtoSalida.getTipoCargoAbono();
		Vector colTipoAbono = rsTipoAbono.getColumnIdentifiers();
        DruidaConector conectorCC_tipoAbono = UtilidadesBelcorp.generarConector("DTOSalida.resultado_ROWSET", rsTipoAbono, colTipoAbono);
        traza("conector CC:",conectorCC_tipoAbono);
        asignar("COMBO", "cbTipoAbono", conectorCC_tipoAbono, "DTOSalida.resultado_ROWSET");
        traza("Combo tipo cargo abono cargado");
        
        RecordSet rsSituaciones = dtoSalida.getSituaciones();
		Vector colSituaciones = rsSituaciones.getColumnIdentifiers();
        DruidaConector conectorCC_Situaciones = UtilidadesBelcorp.generarConector("DTOSalida.resultado_ROWSET", rsSituaciones, colSituaciones);
        traza("conector CC:",conectorCC_Situaciones);
        asignar("COMBO", "cbSituacion", conectorCC_Situaciones, "DTOSalida.resultado_ROWSET");
        /* Si (cu="aprobarRechazar") 
			{ 
			El combo situacion tendrá como valor seleccionado por 
			defecto: CCCConstantes.INCOBRABLE_SITUACION_SOLICITADO. Y no se podrá cambiar. 
			} 
			Guardamos el valor de cu (Caso de uso llamante) en la variable oculta de la pantalla "cu". 
		}*/
        if (casoUso.equals("aprobarRechazar")) {
        	asignar("COMBO", "cbSituacion", conectorCC_Situaciones, "DTOSalida.resultado_ROWSET",colSituaciones.get(0).toString(), CCCConstantes.INCOBRABLE_SITUACION_SOLICITADO.toString());
        	
        	//guardamos el valor de situacion
        	asignarAtributo("VAR", "situacion", "valor", CCCConstantes.INCOBRABLE_SITUACION_SOLICITADO.toString());
        	//deshabilitamos el combo
        	asignarAtributoElemento("cbSituacion","disabled","S");
        }
        traza("Combo situacion cargado");
        
        RecordSet rsCanales = dtoSalida.getCanales();
		Vector colCanales = rsCanales.getColumnIdentifiers();
        DruidaConector conectorCC_Canales = UtilidadesBelcorp.generarConector("DTOSalida.resultado_ROWSET", rsCanales,colCanales);
        traza("conector CC:",conectorCC_Canales);
        asignar("COMBO", "cbCanal", conectorCC_Canales, "DTOSalida.resultado_ROWSET");
        
        traza("Combo canales cargado");
		
		// oidAcceso, descripcion, oidcanal
		RecordSet rsAccesos = dtoSalida.getAccesos();
		Vector colAccesos = rsAccesos.getColumnIdentifiers();
        DruidaConector conectorCC_Accesos = UtilidadesBelcorp.generarConector("DTOSalida.combo_ROWSET", rsAccesos,colAccesos);
        traza("conector CC:",conectorCC_Accesos);
        asignar("MATRIZJS", "datosAccesos", conectorCC_Accesos);
        traza("Lista accesos cargado");
        
        // oid, descripcion, oidAcceso, oidCanal        
        RecordSet rsSubaccesos = dtoSalida.getSubaccesos();
		Vector colSubaccesos = rsSubaccesos.getColumnIdentifiers();
        DruidaConector conectorCC_Subaccesos = UtilidadesBelcorp.generarConector("DTOSalida.combo_ROWSET", rsSubaccesos,colSubaccesos);
        traza("conector CC:",conectorCC_Subaccesos);
        asignar("MATRIZJS", "datosSubaccesos", conectorCC_Subaccesos);
        traza("Lista subaccesos cargado");
        
        generarHiddenFormatoFecha();
        
 
        if (casoUso.indexOf("eliminarDepuracion") != -1) {
        	asignarAtributo("PAGINA","contenido_lotes_busqueda", "cod", "0349"); 
        	asignarAtributo("PAGINA", "contenido_lotes_busqueda", "msgle", "Eliminar provisiones/depuraciones");
			getConfiguracionMenu("LPBuscarProvisionDepuracion", "Eliminar");
		} else if (casoUso.indexOf("modificarDepuracion") != -1){
        	asignarAtributo("PAGINA","contenido_lotes_busqueda", "cod", "0350"); 
        	asignarAtributo("PAGINA", "contenido_lotes_busqueda", "msgle", "Modificar provisiones/depuraciones");
			getConfiguracionMenu("LPBuscarProvisionDepuracion", "Modificar");
		} else if (casoUso.indexOf("aprobarRechazar") != -1){
        	asignarAtributo("PAGINA","contenido_lotes_busqueda", "cod", "0162"); 
        	asignarAtributo("PAGINA", "contenido_lotes_busqueda", "msgle", "Aprobar/Rechazar provisiones/depuraciones");
			getConfiguracionMenu("LPBuscarProvisionDepuracion", "Aprobar");
		} else {
        	asignarAtributo("PAGINA","contenido_lotes_busqueda", "cod", "0348"); 
        	asignarAtributo("PAGINA", "contenido_lotes_busqueda", "msgle", "Consultar provisiones/depuraciones");			
			getConfiguracionMenu("LPBuscarProvisionDepuracion", "Consultar");
		}
			
		traza("*** Salida - LPBuscarProvisionDepuracion - accionVacia ***");
	}
	
	private void logStackTrace(Throwable e) throws Exception {
		traza("Se produjo la excepcion: " + e.getMessage());

		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		e.printStackTrace(ps);
		
		traza("Stack Trace: " + baos.toString());
	}
}