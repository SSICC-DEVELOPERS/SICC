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
    INDRA/CAR/PROY
    $Id: LPConsultarPeriodos.java,v 1.1 2009/12/03 18:32:50 pecbazalar Exp $
    DESC
*/

import es.indra.druida.DruidaConector;
import es.indra.druida.dom.DruidaDOMObjeto;

import es.indra.mare.common.dto.MareDTO;
import es.indra.mare.common.dto.IMareDTO;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.dtos.cra.DTOSeleccionPaisMarcaCanal;
import es.indra.sicc.dtos.cra.DTOCriteriosPeriodo;
import es.indra.mare.common.mgu.manager.Property;

import es.indra.sicc.util.BelcorpError;
import es.indra.sicc.util.DTOError;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.dtos.seg.DTOFiltroPMC;
import es.indra.sicc.cmn.presentacion.rastreador.Rastreador;
import es.indra.sicc.cmn.presentacion.rastreador.IRastreador;

import java.util.HashMap;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Vector;
import org.w3c.dom.Document;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.UtilidadesSession;

// Definicion de la clase
public class LPConsultarPeriodos extends LPSICCBase {

	private String accion		= null;
	private String codigoAcceso	= null;
	private String strCasoDeUso = null;
	private String idioma	= null;
	private String pais		= null;
    private String paisDescripcion = null;
	private String canal	= null;
	private String marca	= null;
	private String anio		= null;
	private String periodo   = null;
	private String tPeriodo   = null;
	private String nPeriodo   = null;
	private Vector paramEntrada = null; 
	private String mensajeLog	= null;

	private final String NOMBRE_LISTA_MARCA	= "cbMarcas";
	private final String NOMBRE_LISTA_CANAL	= "cbCanales";
	private final String NOMBRE_LISTA_ACTIVIDADES = "listado1";
	
	MareBusinessID id = null;
	DruidaConector conectorCargarPaisMarcaCanal	= null;
	DruidaConector conectorObtenerTodosPeriodos = null;
	
    // Definicion del constructor
    public LPConsultarPeriodos() {super();}

    // Definicion del metodo abstracto inicio
    public void inicio() throws Exception {
        // Defino el nombre de la vista
        pagina("contenido_periodos_consultar");
    }


    // Definicion del metodo abstracto ejecucion
    public void ejecucion() throws Exception {
        accion = conectorParametro("accion");
        pais	= conectorParametro("hPais");
        marca	= conectorParametro("hMarca");
        canal	= conectorParametro("hCanal");
        anio	= conectorParametro("hAnio");
        periodo	= conectorParametro("hPeriodo");
        tPeriodo	= conectorParametro("hTPeriodo");
        nPeriodo	= conectorParametro("hNPeriodo");
        strCasoDeUso = conectorParametro("hCasoDeUso");
        idioma = conectorParametro("hIdioma");

        pais   = (this.pais == null) ? "" : pais;
        marca  = (this.marca == null) ? "" : marca;
        canal  = (this.canal == null) ? "" : canal;
        anio   = (this.anio == null) ? "" : anio;
        periodo   = (this.periodo == null) ? "" : periodo;
        tPeriodo   = (this.tPeriodo == null) ? "" : tPeriodo;
        nPeriodo   = (this.nPeriodo == null) ? "" : nPeriodo;
        strCasoDeUso = (this.strCasoDeUso == null) ? "" : strCasoDeUso;
        idioma = (this.idioma == null) ? "" : idioma;
        setTrazaFichero();

		traza("accion " + accion);
		traza("CU " + strCasoDeUso) ;

        paramEntrada = new Vector(); 
        accion = (accion==null )?"":accion;

        asignarAtributo("VAR","hPais","valor",(pais==null || pais.length()==0?"":pais));
        asignarAtributo("VAR","hMarca","valor",(marca==null || marca.length()==0?"":marca));
        asignarAtributo("VAR","hCanal","valor",(canal==null || canal.length()==0?"":canal));
        asignarAtributo("VAR","hAnio","valor",(anio==null || anio.length()==0?"":anio));
        asignarAtributo("VAR","hPeriodo","valor",(periodo==null || periodo.length()==0?"":periodo));
        asignarAtributo("VAR","hTPeriodo","valor",(tPeriodo==null || tPeriodo.length()==0?"":tPeriodo));
        asignarAtributo("VAR","hNPeriodo","valor",(nPeriodo==null || nPeriodo.length()==0?"":nPeriodo));
        asignarAtributo("VAR","hIdioma","valor",(idioma==null || idioma.length()==0?"":idioma));
        asignarAtributo("VAR","hCasoDeUso","valor",strCasoDeUso);
        asignarAtributo("VAR","accion","valor",accion);

        //setamos pais
        this.pais = conectorParametro("hPais"); 
        this.paisDescripcion = conectorParametro("hPaisDescripcion"); 
        if ((this.pais == null) || ((this.pais != null) && this.pais.equals(""))) {
			this.pais = UtilidadesSession.getPais(this).toString();
			this.paisDescripcion = UtilidadesSession.getDescripcionPais(this);
    		traza("pais: " + this.pais);
    		traza("paisDescripcion: " + this.paisDescripcion);
            asignarAtributo("VAR", "hPais", "valor", this.pais);
            asignarAtributo("VAR", "hPaisDescripcion", "valor", this.paisDescripcion);
        }
        //seteamos idioma
        this.idioma = conectorParametro("hIdioma"); 
        if ((this.idioma == null) || ((this.idioma != null) && this.idioma.equals(""))) {
			this.idioma = UtilidadesSession.getIdioma(this).toString();
    		traza("idioma: " + this.idioma);
            asignarAtributo("VAR", "hIdioma", "valor", this.idioma);
        }

        try{
            rastreo();
            if (accion.equals("")) {
                getConfiguracionMenu("LPConsultarPeriodos");
                cargarPaisMarcaCanal();

            } else if (accion.equals("consulta")){
                getConfiguracionMenu();
                cargarPaisMarcaCanal();
                //asignar atributos
                asignarAtributo("VAR","hPais","valor",(pais==null || pais.length()==0?"":pais));
                asignarAtributo("VAR","hPaisDescripcion","valor",(paisDescripcion==null || paisDescripcion.length()==0?"":paisDescripcion));
                asignarAtributo("VAR","hMarca","valor",(marca==null || marca.length()==0?"":marca));
                asignarAtributo("VAR","hCanal","valor",(canal==null || canal.length()==0?"":canal));
                asignarAtributo("VAR","hAnio","valor",(anio==null || anio.length()==0?"":anio));
                asignarAtributo("VAR","hPeriodo","valor",(anio==null || anio.length()==0?"":periodo));
                asignarAtributo("VAR","hTPeriodo","valor",(anio==null || anio.length()==0?"":tPeriodo));
                asignarAtributo("VAR","hNPeriodo","valor",(anio==null || anio.length()==0?"":nPeriodo));
                //cargar lista periodos
                cargarListaPeriodos();
            }
        } catch (Exception ex) {
            logStackTrace(ex);
            this.lanzarPaginaError(ex);
            //asignar atributos
            asignarAtributo("VAR","hPais","valor",(pais==null || pais.length()==0?"":pais));
            asignarAtributo("VAR","hPaisDescripcion","valor",(paisDescripcion==null || paisDescripcion.length()==0?"":paisDescripcion));
            asignarAtributo("VAR","hMarca","valor",(marca==null || marca.length()==0?"":marca));
            asignarAtributo("VAR","hCanal","valor",(canal==null || canal.length()==0?"":canal));
            asignarAtributo("VAR","hAnio","valor",(anio==null || anio.length()==0?"":anio));
            asignarAtributo("VAR","hPeriodo","valor",(anio==null || anio.length()==0?"":periodo));
            asignarAtributo("VAR","hTPeriodo","valor",(anio==null || anio.length()==0?"":tPeriodo));
            asignarAtributo("VAR","hNPeriodo","valor",(anio==null || anio.length()==0?"":nPeriodo));    
        }
    }


    //Carga Paises, Marcas y Canales
    private void cargarPaisMarcaCanal() throws Exception {
        DTOFiltroPMC paisMarcaCanal = new DTOFiltroPMC();
        paisMarcaCanal.setOidIdioma(new Long(1));
        paisMarcaCanal.setPaises(Boolean.TRUE);
        paisMarcaCanal.setMarcas(Boolean.TRUE);
        paisMarcaCanal.setCanales(Boolean.TRUE);
   
        Vector paramEntrada = new Vector();
        paramEntrada.add(paisMarcaCanal);

        paramEntrada.add(new MareBusinessID("CRAPaisMarcaCanal"));
        traza("antes cargar CRAPaisMarcaCanal");
        DruidaConector conectorCargarPaisMarcaCanal = conectar("ConectorCargarPaisMarcaCanal", paramEntrada);

        // Se asigna a los combos los posibles valores para Pais, Marca y Canal.
        traza("despues cargar CRAPaisMarcaCanal");
        asignar("COMBO", "cbMarcas", conectorCargarPaisMarcaCanal, "dtoSalida.marcas_ROWSET");
        asignar("COMBO", "cbCanales", conectorCargarPaisMarcaCanal, "dtoSalida.canales_ROWSET");
        // Pasa los viejos valores seleccionados (si existen).
        asignarAtributo("VAR", "hPais", "valor", this.pais);
        asignarAtributo("VAR", "hPaisDescripcion", "valor", this.paisDescripcion);
        asignarAtributo("VAR", "hMarca", "valor", this.marca);
        asignarAtributo("VAR", "hCanal", "valor", this.canal);
    }


	private void cargarListaPeriodos() throws Exception {
		DTOCriteriosPeriodo dtop = new DTOCriteriosPeriodo();
		dtop.setPais( (pais==null || pais.length()==0?null: new Long(pais)) );
		dtop.setMarca( (marca==null || marca.length()==0?null: new Long(marca)) );
		dtop.setCanal( (canal==null || canal.length()==0?null: new Long(canal)) );
		dtop.setPeriodo( (periodo==null || periodo.length()==0?null: periodo) );
		dtop.setCodigoTipo( (tPeriodo==null || tPeriodo.length()==0?null: tPeriodo) );
		dtop.setNombre( (nPeriodo==null || nPeriodo.length()==0?null: nPeriodo) );
		dtop.setAnio( (anio==null || anio.length()==0?null: new Integer(anio)) );
        dtop.setPrograma(UtilidadesSession.getFuncion(this));
	    dtop.setIpCliente(UtilidadesBelcorp.getIPCliente(this));

		Vector paramEntrada = new Vector();
        paramEntrada.add(dtop);
        paramEntrada.add(new MareBusinessID("CRAConsultarPeriodos"));

        DruidaConector conectorObtenerTodosPeriodos = conectar("ConectorObtenerTodosPeriodosConsulta", paramEntrada);

		Vector listaVacia = new Vector(valorRowset("dtoSalida.resultado_ROWSET", conectorObtenerTodosPeriodos));
		
		if (listaVacia.isEmpty()) {
			traza("Lista vacia");
			asignarAtributo("VAR", "hListaVacia", "valor", "vacio");
	        //asignarAtributo("CAPA", "capa2", "visibilidad", "hidden");
			throw new MareException(new Exception(), 5);
		} else {
			traza("Lista no vacia");
			asignarAtributo("VAR", "hListaVacia", "valor", "no vacio");
			asignar("LISTA", NOMBRE_LISTA_ACTIVIDADES, conectorObtenerTodosPeriodos, "dtoSalida.resultado_ROWSET");
            //asignarAtributo("CAPA", "capa2", "visibilidad", "visible");
		}
	}


	private void logStackTrace(Throwable e) throws Exception {
		traza("Se produjo la excepcion: " + e.getMessage());

		ByteArrayOutputStream pila = new ByteArrayOutputStream();
		PrintStream out = new PrintStream(pila);
		if (e instanceof MareException) {
			MareException e2=(MareException)e;
			traza("Es una mare Exception con codigo de error: "+e2.getCode());
		}
		e.printStackTrace(out);
		traza("stack Trace : " +  pila.toString());
	}

}
