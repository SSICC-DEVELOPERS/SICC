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


import es.indra.druida.DruidaConector;

import es.indra.mare.common.mln.MareBusinessID;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
 
import es.indra.sicc.cmn.negocio.comun.DTOComunes.DTOString;

import es.indra.sicc.dtos.bel.DTORegistroAbastecimiento;
import es.indra.sicc.dtos.bel.DTORegistroAbastecimientoDetalle;
import es.indra.sicc.dtos.bel.DTOERecuperarRegistroAbastecimiento;

import es.indra.sicc.logicanegocio.bel.ConstantesBEL;

import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.UtilidadesSession; 

import java.io.ByteArrayOutputStream; 
import java.io.PrintStream;

import java.sql.Timestamp;

import java.util.ArrayList;
import java.util.Vector;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import es.indra.sicc.util.xml.XMLDocument;


public class LPActualizarHojaDemanda extends LPSICCBase {
    
	private String accion = null;
	private Long idioma;
	private Long pais;   
	private Long subacceso;
    
	public LPActualizarHojaDemanda() {
		super();
	}
    
	public void inicio() throws Exception {
		// Defino el nombre de la vista
		pagina("contenido_hoja_demanda_confirmar");
	}
	
	public void ejecucion() throws Exception {
         
	   // falta: si se accede directamente a esta LP desde el menu principal debo descomentar la siguiente linea
	   //rastreo();
	            
	   try {
			setTrazaFichero(); 
			traza("***Entrada - LPActualizarHojaDemanda - ejecucion***");
			
			this.idioma = UtilidadesSession.getIdioma(this);
			this.pais = UtilidadesSession.getPais(this);
			asignar("VAR", "idioma", idioma.toString());
			asignar("VAR", "pais", pais.toString()); 
			this.accion = conectorParametroLimpia("accion", "", true);
                           
			traza("***accion : " + accion);
			
			// genero los campos en la pagina que contienen el formato de fecha para el usuario
			generarHiddenFormatoFecha();
			
			if (accion.equals("")) {
				this.cargarPagina();
			} else if (accion.equals("actualizar")) {
				this.actualizar();
				// hacemos que se recargue la pagina
				this.cargarPagina();
			}
                           
			traza("***Salida - LPActualizarHojaDemanda - ejecucion***");
                  
      } catch(Exception e) {
	      logStackTrace(e);
	      lanzarPaginaError(e);
      }
	}
	
	private void cargarPagina() throws Exception {

		traza("***Entrada - LPActualizarHojaDemanda - cargarPagina***");

		// Asignar página "contenido_hoja_demanda_confirmar" 
		pagina("contenido_hoja_demanda_confirmar");
		
		// nombre="contenido_hoja_demanda_confirmar" cod="0484" titulo="	"
		asignarAtributo("PAGINA", "contenido_hoja_demanda_confirmar", "cod", "0484");
		asignarAtributo("PAGINA", "contenido_hoja_demanda_confirmar", "msgle", "Actualizar hoja de demanda");
		getConfiguracionMenu("LPActualizarHojaDemanda", "");			
		
		// ejecutar método "obtenerSubacceso" 
		this.obtenerSubacceso();
		
		// Crear objeto DTOERecuperarRegistroAbastecimiento de la forma siguiente 
		DTOERecuperarRegistroAbastecimiento dtoRecupRegAbast = new DTOERecuperarRegistroAbastecimiento();
		// DTOERecuperarRegistroAbastecimiento.pais = pais de sesión 
		dtoRecupRegAbast.setOidPais(this.pais);
		// DTOERecuperarRegistroAbastecimiento.idioma = idioma de sesión 
		dtoRecupRegAbast.setOidIdioma(this.idioma);
		// DTOERecuperarRegistroAbastecimiento.subacceso = this.subacceso
		dtoRecupRegAbast.setSubacceso(this.subacceso);
		// DTOERecuperarRegistroAbastecimiento.estado = ConstantesBEL.ESTADO_HOJA_DEMANDA_ENVIADO 
		dtoRecupRegAbast.setEstado(ConstantesBEL.ESTADO_HOJA_DEMANDA_ENVIADO);
		// DTOERecuperarRegistroAbastecimiento.indicadorSAP = "true" 
		dtoRecupRegAbast.setIndicadorSAP(Boolean.TRUE);
		
		traza("--------------------- DTOERecuperarRegistroAbastecimiento.pais : " + this.pais);
		traza("--------------------- DTOERecuperarRegistroAbastecimiento.idioma : " + this.idioma);
		traza("--------------------- DTOERecuperarRegistroAbastecimiento: " + dtoRecupRegAbast);
		
		// llamamos a negocio
		// Crear idBusiness = "BELObtenerHojaDemanda" 
      MareBusinessID idNegocio = new MareBusinessID("BELObtenerHojaDemanda");

      Vector paramsEntrada = new Vector();
      paramsEntrada.add(dtoRecupRegAbast);
      paramsEntrada.add(idNegocio);
      // Asignar conector "ConectorObtenerHojaDemanda" 
      DruidaConector conector = conectar("ConectorObtenerHojaDemanda", paramsEntrada);
      
		// Recuperar DTOSalida de respuesta y mapear RecordSet en lista editable de la pantalla
		DTOSalida dtoSalida = (DTOSalida)conector.objeto("DTOSalida");
		// se obtiene el RecordSet
		RecordSet rs = dtoSalida.getResultado();
		
		// del recordset recuperado mapeo en la lista las columnas: OID, NUM_SOLI y FEC_ENVI
		Vector cols = new Vector();
		cols.add(rs.getColumnName(rs.getColumnPosition("OID")));
		cols.add(rs.getColumnName(rs.getColumnPosition("NUM_SOLI")));
		cols.add(rs.getColumnName(rs.getColumnPosition("FEC_ENVI")));
		DruidaConector conectorCargaLista = generarConectorFormato("DTOSalida.matriz_ROWSET", rs, cols);
 		asignar("LISTAEDITABLE", "datosHojaDemanda", conectorCargaLista, "DTOSalida.matriz_ROWSET");

		traza("***Salida - LPActualizarHojaDemanda - cargarPagina***");
	}
	
	
	private void actualizar() throws Exception {

		traza("***Entrada - LPActualizarHojaDemanda - actualizar***");
		
		// Crear objeto DTORegistroAbastecimiento haciendo el siguiente mapeo: 
		DTORegistroAbastecimiento dtoRegAbast = new DTORegistroAbastecimiento();
		// RegistroAbastecimiento.oid = pagina.datosHojaDemanda.oidRegistroAbastecimientoCabecera 
		String oidSeleccionado = conectorParametroLimpia("oidSeleccionado", "", true);
		traza("****** oidSeleccionado: " + oidSeleccionado);	
		dtoRegAbast.setOid(new Long(oidSeleccionado));
		// incidencia BELC300012218
		dtoRegAbast.setOidEstadoHojaDemanda(ConstantesBEL.ESTADO_HOJA_DEMANDA_CONFIRMADO);
		// RegistroAbastecimientoCabecera.fechaConfirmado = fecha del sistema 
		dtoRegAbast.setFechaConfirmado(new Timestamp(System.currentTimeMillis()));
		// asigno el pais y el idioma
		dtoRegAbast.setOidPais(this.pais);
		dtoRegAbast.setOidIdioma(this.idioma);
		
		traza("******DTORegistroAbastecimiento.pais: " + dtoRegAbast.getOidPais());
		traza("******DTORegistroAbastecimiento.idioma: " + dtoRegAbast.getOidIdioma());
		traza("******DTORegistroAbastecimiento: " + dtoRegAbast);
		
		traza("******ConstantesBEL.ESTADO_HOJA_DEMANDA_CONFIRMADO: " + ConstantesBEL.ESTADO_HOJA_DEMANDA_CONFIRMADO);
		
		// llamamos a negocio
		// Crear idBusiness = "BELActualizarHojaDemanda" 
      MareBusinessID idNegocio = new MareBusinessID("BELActualizarHojaDemanda");

      Vector paramsEntrada = new Vector();
      paramsEntrada.add(dtoRegAbast);
      paramsEntrada.add(idNegocio);
      // Asignar conector "ConectorActualizarHojaDemanda" con idBuisness y dto creados
      DruidaConector conector = conectar("ConectorActualizarHojaDemanda", paramsEntrada);		

		traza("***Salida - LPActualizarHojaDemanda - actualizar***");
	}
	
	
	private void obtenerSubacceso() throws Exception {

		traza("***Entrada - LPActualizarHojaDemanda - obtenerSubacceso***");
		
		// Obtener la dirección IP del cliente a través del request 
		traza("****** antes de obtener la IP");
		
		String ip = this.getRequest().getRemoteAddr();
		
		traza("****** IP obtenida: " + ip);
		
		// Crear objeto DTOString, asignando a su atributo "cadena" la dirección IP obtenida en la actividad anterior 
		DTOString dtoString = new DTOString();
		dtoString.setCadena(ip);
		// asigno el pais y el idioma
		dtoString.setOidPais(this.pais);
		dtoString.setOidIdioma(this.idioma);
		
		// Crear idBusiness = "BELObtenerSubaccesoAsociado" 
		MareBusinessID idNegocio = new MareBusinessID("BELObtenerSubaccesoAsociado");
		// Asignar conector "ConectorObtenerSubaccesoAsociado" con idBusiness y dto creados 
      Vector paramsEntrada = new Vector();
      paramsEntrada.add(dtoString);
      paramsEntrada.add(idNegocio);
      DruidaConector conector = conectar("ConectorObtenerSubaccesoAsociado", paramsEntrada);		
		
		// Recuperar DTOOID y guardar el oid del subacceso en el atributo "subacceso" de esta LP
		DTOOID dtoOID = null;
		dtoOID = (DTOOID)conector.objeto("DTOOID");
		
		if (dtoOID != null) {
			this.subacceso = dtoOID.getOid();
		}

		traza("***Salida - LPActualizarHojaDemanda - obtenerSubacceso***");
	}
	

	// para que formatee correctamente la fecha
	private String obtieneCadenaFecha(java.sql.Date valor) throws Exception {
    	String fecha = new String("");
    	if (valor != null) {
			fecha = UtilidadesBelcorp.fechaFormateada(valor, UtilidadesSession.getFormatoFecha(this));
    	}
    	
    	return fecha;
	}
    
    
	// para que formatee correctamente la fecha
	private DruidaConector generarConectorFormato(String rowsetID, RecordSet datos, Vector columns) 
		throws Exception, DOMException 
	{
        StringBuffer salida = new StringBuffer();
        int sizeColums = datos.getColumnCount();
        int sizeRows = datos.getRowCount();
        if(columns == null)
            columns = new Vector();
        Vector columsDesc = datos.getColumnIdentifiers();
        DruidaConector conectorValoresPosibles = new DruidaConector();
        XMLDocument xmlDoc = new XMLDocument();
        Document docDestino = xmlDoc.makeDocument("<ROWSET2/>");
        Element e_rows = docDestino.createElement("ROWSET");
        e_rows.setAttribute("ID", rowsetID);
        docDestino.getDocumentElement().appendChild(e_rows);
        for (int i = 0; i < sizeRows; i++) {
            Element e_row = docDestino.createElement("ROW");
            e_rows.appendChild(e_row);
            for(int j = 0; j < sizeColums; j++)
                if(columns.contains(columsDesc.elementAt(j))) {
                    Element e_campo2 = docDestino.createElement("CAMPO");
                    e_campo2.setAttribute("NOMBRE", columsDesc.elementAt(j).toString());
                    e_campo2.setAttribute("TIPO", "OBJECTO");
                    e_campo2.setAttribute("LONGITUD", "50");
                    String dato = "";
                    Object datoObj = datos.getValueAt(i, j);
                    if (datoObj != null ) {
                    	if (datoObj instanceof java.sql.Date)
                    		dato = this.obtieneCadenaFecha((java.sql.Date) datoObj);
                    	else
                    		dato = datoObj.toString();
                    }
                    org.w3c.dom.Text txt = docDestino.createTextNode(dato);
                    e_campo2.appendChild(txt);
                    e_row.appendChild(e_campo2);
                }
        }

        conectorValoresPosibles.setXML(docDestino.getDocumentElement());
        return conectorValoresPosibles;
    }
	
	
	protected void logStackTrace(Throwable e) throws Exception {
		traza("Se produjo la excepcion: " + e.getMessage());

		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		e.printStackTrace(ps);
                  
		traza("Stack Trace: " + baos.toString());
	}

}