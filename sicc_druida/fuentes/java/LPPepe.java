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

import es.indra.druida.DruidaConector;
import es.indra.mare.common.dto.IMareDTO;
import es.indra.mare.common.dto.MareDTO;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mgu.manager.Property;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.dtos.cra.DTOAsociadosAPeriodo;
import es.indra.sicc.dtos.cra.DTOPeriodo;
import es.indra.sicc.dtos.cra.DTORecalculoPeriodos;
import es.indra.sicc.util.BelcorpError;
import es.indra.sicc.util.DTOError;
import es.indra.sicc.util.DTOSalida;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import java.sql.Date;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashMap;
import java.util.Vector;
import java.util.StringTokenizer;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

import es.indra.sicc.cmn.presentacion.rastreador.Rastreador;
import es.indra.sicc.cmn.presentacion.rastreador.IRastreador;
import es.indra.sicc.dtos.cra.DTOSeleccionPaisMarcaCanal;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.UtilidadesSession;
import java.math.BigDecimal;


// Definicion de la clase
public class LPPepe extends LPSICCBase {

    private String paisDescripcion = null;
    private String pais = null;
    private String marca = null;
    private String canal = null;
    private String anio = null;
    private DocumentBuilder docBuilder = null;
    private String hCasoDeUsoOrig = null;
    private static String strCasoDeUso = "insertar";

    
    // Definicion del constructor
    public LPPepe() {
        super();
    }


    // Definicion del metodo abstracto inicio
    public void inicio() throws Exception {
        // Defino el nombre de la vista
        pagina("contenido_periodos_crear");
    }


    // Definicion del metodo abstracto ejecucion
    public void ejecucion() throws Exception {
        setTrazaFichero();
        generarHiddenFormatoFecha();
        String accion  = conectorParametro("accion");
        accion = (accion == null) ? "" : accion;

        this.pais = conectorParametro("hPais"); 
        this.paisDescripcion = conectorParametro("hPaisDescripcion"); 

        if ((this.pais == null) || ((this.pais != null) && this.pais.equals(""))) {
			this.pais = UtilidadesSession.getPais(this).toString();
			this.paisDescripcion = UtilidadesSession.getDescripcionPais(this);
    		traza("pais " + this.pais);
    		traza("paisDescripcion " + this.paisDescripcion);
            asignarAtributo("VAR", "hPais", "valor", this.pais);
            asignarAtributo("VAR", "hPaisDescripcion", "valor", this.paisDescripcion);
        }

		traza("E.1");
        this.marca  = conectorParametro("hMarca");
        this.canal  = conectorParametro("hCanal");
        this.anio   = conectorParametro("hAnio");
		traza("E.2");
        this.marca  = (this.marca == null) ? "" : this.marca;
        this.canal  = (this.canal == null) ? "" : this.canal;
        this.anio   = (this.anio == null) ? "" : this.anio;
        traza("E.3");
        hCasoDeUsoOrig = (String)conectorParametroSesion("hCasoDeUso");
		traza("E.4");
        hCasoDeUsoOrig = (hCasoDeUsoOrig == null) ? "" : hCasoDeUsoOrig;
		traza("accion: " + accion);
        asignarAtributo("VAR","accion","valor",accion);

        try {
            rastreo();
            if (accion.equals("")) {
                asignarAtributo("VAR","hCasoDeUso", "valor", this.strCasoDeUso);
                conectorParametroSesion("hCasoDeUso", this.strCasoDeUso);
                this.cargarPaisMarcaCanal();
                asignarAtributo("VAR", "hEnableSave", "valor", "");
                getConfiguracionMenu("LPInsertaPeriodo");

            } else if (accion.equals("buscar")) {
                //Rama en deshuso por carga con paginacion
                //this.accionBuscar();
                //asignarAtributo("VAR","hEnableSave","valor","enable");
				//getConfiguracionMenu();

            } else if (accion.equals("modificarPeriodo")) {
                //Rama en deshuso por edicion en la lista editable
                //this.modificarPeriodo();
				//getConfiguracionMenu();

            } else if (accion.equals("grabar")) {
                this.grabarPeriodos();
                asignarAtributo("VAR", "hEnableSave", "valor", "");
				getConfiguracionMenu();

            } else if (accion.equals("actualizarPeriodo")) {
                //Rama en deshuso por edicion en la lista editable
                //this.actualizarPeriodo();
                //asignarAtributo("VAR","hEnableSave","valor","enable");
				//getConfiguracionMenu();

            } else if (accion.equals("recalculaPeriodos")) {
                this.recalculaPeriodos();
                asignarAtributo("VAR","hEnableSave","valor","enable");
				getConfiguracionMenu();

            } else if (accion.equals("volverSinCambios")) {
                //Rama en deshuso por edicion en la lista editable
				//ArrayList listadoDePeriodos = (ArrayList)conectorParametroSesion("listadoDePeriodos");
				//this.recargaListaPeriodos(listadoDePeriodos);
                //asignarAtributo("VAR","hEnableSave","valor","enable");
				//getConfiguracionMenu("LPInsertaPeriodo");
			}

        } catch (Exception ex) {
			logStackTrace(ex);
			this.lanzarPaginaError(ex);
            asignarAtributo("VAR","hPais", "valor", this.pais);
            asignarAtributo("VAR","hPaisDescripcion", "valor", this.paisDescripcion);
            asignarAtributo("VAR","hMarca", "valor", this.marca);
            asignarAtributo("VAR","hCanal", "valor", this.canal);
            //asignarAtributo("VAR","hAnio", "valor", this.anio);
            this.marca = ""; this.canal = ""; this.anio = "";
            this.cargarPaisMarcaCanal();
        }
	}


    /**
     * Se carga Pais Marca y Canal en los combos.
     */
    private void cargarPaisMarcaCanal() throws Exception {
        // Carga Paises, Marcas y Canales
        es.indra.sicc.dtos.seg.DTOFiltroPMC paisMarcaCanal = new es.indra.sicc.dtos.seg.DTOFiltroPMC();
        paisMarcaCanal.setOidIdioma(UtilidadesSession.getIdioma(this));
        traza("idioma: " + UtilidadesSession.getIdioma(this));
        paisMarcaCanal.setPaises(Boolean.TRUE);
        paisMarcaCanal.setMarcas(Boolean.TRUE);
        paisMarcaCanal.setCanales(Boolean.TRUE);
   
        Vector paramEntrada = new Vector();
        paramEntrada.add(paisMarcaCanal);

        paramEntrada.add(new MareBusinessID("CRAPaisMarcaCanal"));
        traza("antes cargar CRAPaisMarcaCanal");
        DruidaConector conectorCargarPaisMarcaCanal = conectar("ConectorCargarPaisMarcaCanal", paramEntrada);
        // Se asigna a los combos los posibles valores para Marca y Canal.
        traza("despues cargar CRAPaisMarcaCanal");
        asignar("COMBO", "comboMarca", conectorCargarPaisMarcaCanal, "dtoSalida.marcas_ROWSET");
        asignar("COMBO", "comboCanal", conectorCargarPaisMarcaCanal, "dtoSalida.canales_ROWSET");

        // Pasa los viejos valores seleccionados (si existen).
        traza("pmc.1");
        asignarAtributo("VAR", "hPais", "valor", this.pais);
        asignarAtributo("VAR", "hPaisDescripcion", "valor", this.paisDescripcion);
        traza("pmc.2");
        asignarAtributo("VAR", "hMarca", "valor", this.marca);
        asignarAtributo("VAR", "hCanal", "valor", this.canal);
        traza("pmc.3");
    }


    /**
     * Calcula la proxima fecha, incrementando segun dias.
     * @return Date - Fecha con el avance en dias.
     * @param fecha - Fecha base sobre la cual se calcula el incremento.
     *        incrementoDias - Dias que se le suma a la fecha base.
     */
    private Date calculaProximaFecha(Date fecha, Integer incrementoDias) throws Exception{
        traza("fecha " + fecha.toString());
        traza("incrementoDias " + incrementoDias);
        Calendar cal = Calendar.getInstance();
        cal.setTime(fecha);
        cal.add(Calendar.DATE, incrementoDias.intValue());
        Date fechaIncrementada = new java.sql.Date(cal.getTime().getTime());
		traza("fechaIncrementada " + fechaIncrementada.toString() );

        return fechaIncrementada;
    }


    /**
     * El usuario seleccionó pais, marcal, canal y anio, 
     * y pulso buscar para levantar la tabla de periodos.
     * ---> DEPRECATED. Ahora se utiliza la carga con paginado por javascript.
     */
    private void accionBuscar() throws Exception {
		traza("B 1");
        DTOAsociadosAPeriodo dtoAsociadosAPeriodo = new DTOAsociadosAPeriodo();
		traza("B 2");
		traza("pais: " + pais);
        dtoAsociadosAPeriodo.setPais(new Long(this.pais));
		traza("B 3");
        dtoAsociadosAPeriodo.setMarca(new Long(this.marca));
		traza("B 4");
        dtoAsociadosAPeriodo.setCanal(new Long(this.canal));
		traza("B 5");
        dtoAsociadosAPeriodo.setAnio(new Integer(this.anio));
		traza("B 6");

		dtoAsociadosAPeriodo.setPrograma(UtilidadesSession.getFuncion(this));
		traza("B 7");
	    dtoAsociadosAPeriodo.setIpCliente(UtilidadesBelcorp.getIPCliente(this));
        Vector paramEntrada = new Vector();
		traza("B 8");

		/*
		 * Obtener periodos corporativos: CRAobtieneDatosPeriodosCorporativos
		 */
		traza("antes de CRAobtieneDatosPeriodosCorporativos");
        paramEntrada.add(dtoAsociadosAPeriodo);
		paramEntrada.add(new MareBusinessID("CRAobtieneDatosPeriodosCorporativos"));
        DruidaConector conObtDatPerCorp;
        traza(dtoAsociadosAPeriodo);   
        conObtDatPerCorp = conectar("ConectorObtieneDatosPeriodosCorporativos", paramEntrada);
		traza("despeues de CRAobtieneDatosPeriodosCorporativos");

        DTOSalida dtoSalida = (DTOSalida)conObtDatPerCorp.objeto("dtoSalida");
		traza(dtoSalida);
		traza("pc.1");
        RecordSet rsPeriCorpo = dtoSalida.getResultado();
		traza("pc.2");
		traza(rsPeriCorpo);

		// Tomo del primer row el valor CantidadPeriodos
		Integer intCantidadPeriodos = (Integer)(rsPeriCorpo.getColumn(rsPeriCorpo.getColumnPosition("CantidadPeriodos"))).elementAt(0);
		traza("pc.3");

        /*
         * Para obtener ultimo periodo del anio anterior: CRAobtienePeriodo
         */
        Integer intAnio = new Integer(this.anio);
        // retrocedo un anio, respecto del que seleccionó el usuario, para
        // obtener el ultimo periodo de (anio-1), y arrancar desde aqui.
        dtoAsociadosAPeriodo.setAnio(new Integer(intAnio.intValue()-1));
		traza("4");
        String inicioAnioAnterior = (intAnio.intValue()-1) + "-01-01";
		traza("5");

		paramEntrada = new Vector();
        paramEntrada.add(dtoAsociadosAPeriodo);
		traza("dtoAsociadosAPeriodo 1 " +dtoAsociadosAPeriodo);
        paramEntrada.add(new MareBusinessID("CRAobtienePeriodo"));
        DruidaConector conObtPer = null;
		traza("antes de CRAobtienePeriodo");
        conObtPer = conectar("ConectorObtienePeriodosCrear", paramEntrada);
		traza("despues de CRAobtienePeriodo");

		DTOSalida dtoSal = (DTOSalida)conObtPer.objeto("dtoSalida");
		traza(dtoSal);
        RecordSet rsUltimoPeriodo = dtoSal.getResultado();

		traza ("1 x"); 
        Date fechaInicProxPeriod = null;
        traza ("2 x"); 
        Date ultimaFechaFin;
		if ((rsUltimoPeriodo.getColumn(rsUltimoPeriodo.getColumnPosition("FEC_FINA"))).elementAt(0)!=null){
			traza ("21 x"); 
			traza (" FEC_FINA fin " + (rsUltimoPeriodo.getColumn(rsUltimoPeriodo.getColumnPosition("FEC_FINA"))).elementAt(0));
            ultimaFechaFin = (Date)(rsUltimoPeriodo.getColumn(rsUltimoPeriodo.getColumnPosition("FEC_FINA"))).elementAt(0);
        }else{
			traza ("22 x"); 
            ultimaFechaFin = null;
        }
        traza ("3 x"); 

        if (ultimaFechaFin.toString().equals(inicioAnioAnterior)) {
            // Primero de Enero del anio seleccionado.
            fechaInicProxPeriod = Date.valueOf(this.anio+"-01-01"); // YYYY-01-01
			traza ("4 x"); 
        } else {
            fechaInicProxPeriod = this.calculaProximaFecha(ultimaFechaFin, new Integer(1));
			traza ("5 x"); 
        }
        traza ("6 x"); 

        Document docDestino = newDocument();
        traza ("7 x"); 
        Element rowset = docDestino.createElement("ROWSET");
        rowset.setAttribute("ID", "dtoSalida.periodos_ROWSET");
        traza ("8 x"); 

        ArrayList listadoDePeriodos = new ArrayList(intCantidadPeriodos.intValue());
        for (int i = 1; i <= intCantidadPeriodos.intValue(); i++) {
			traza ("9 x"); 
            DTOPeriodo dtoPeriodo = new DTOPeriodo();
	        dtoPeriodo.setIpCliente(UtilidadesBelcorp.getIPCliente(this));
            dtoPeriodo.setPrograma(UtilidadesSession.getFuncion(this));
			traza("10x");
            dtoPeriodo.setPais(new Long(this.pais));
			traza("11x");
            dtoPeriodo.setMarca(new Long(this.marca));
 			traza("12x");
			dtoPeriodo.setCanal(new Long(this.canal));
			traza("13x");
            dtoPeriodo.setAcceso(null); // para completar la información default
            dtoPeriodo.setStatus(new Boolean(true)); // para completar la info. default
			traza("14x");

			// Tomamos del row correspondiente: oidTipoPeriodo, codigoTipoPeriodo , Duracion y oidPeriCorpo
			Long oidTipoPeriodo = new Long( (String)(rsPeriCorpo.getColumn(rsPeriCorpo.getColumnPosition("oidTipoPeriodo"))).elementAt(i-1));
			traza("15x");
			String strCodigoTipoPeriodo = (String)(rsPeriCorpo.getColumn(rsPeriCorpo.getColumnPosition("TipoPeriodo"))).elementAt(i-1);
			traza("16x");
			String strDuracion = (String)(rsPeriCorpo.getColumn(rsPeriCorpo.getColumnPosition("Duracion"))).elementAt(i-1);
			traza("17x");
			String codigoPeriodo = (String)(rsPeriCorpo.getColumn(rsPeriCorpo.getColumnPosition("codigoPeriodo"))).elementAt(i-1);
			traza("18x");
			Long oidPeriCorpo = new Long( (String)(rsPeriCorpo.getColumn(rsPeriCorpo.getColumnPosition("oidPeriCorpo"))).elementAt(i-1) );
			traza("19x");

            Element eRow = docDestino.createElement("ROW");
            rowset.appendChild(eRow);

            Element eCampo = docDestino.createElement("CAMPO");
            eCampo.setAttribute("NOMBRE", "idfila");
            eCampo.setAttribute("TIPO", "STRING");
            Text txtDesc = docDestino.createTextNode(oidPeriCorpo.toString());
            eCampo.appendChild(txtDesc);
            eRow.appendChild(eCampo);
			dtoPeriodo.setOidPeriodoCorporativo(oidPeriCorpo);

			//Creo que aca hay que agregar campo con el codigo de periodo
			dtoPeriodo.setCodigoPeriodo(codigoPeriodo);// Inicialmente el nombre y el codigo periodo serán el mismo

            eCampo = null;
            eCampo = docDestino.createElement("CAMPO");
            eCampo.setAttribute("NOMBRE", "tipo");
            eCampo.setAttribute("TIPO", "STRING");
            txtDesc = null;
            txtDesc = docDestino.createTextNode(strCodigoTipoPeriodo);
            eCampo.appendChild(txtDesc);
            eRow.appendChild(eCampo);
            dtoPeriodo.setCodigoTipoPeriodo(strCodigoTipoPeriodo);
            dtoPeriodo.setTipo(oidTipoPeriodo);

            eCampo = null;
            eCampo = docDestino.createElement("CAMPO");
            eCampo.setAttribute("NOMBRE", "nombre");
            eCampo.setAttribute("TIPO", "STRING");
            txtDesc = null;
            txtDesc = docDestino.createTextNode(codigoPeriodo);
            eCampo.appendChild(txtDesc);
            eRow.appendChild(eCampo);
            dtoPeriodo.setNombre(codigoPeriodo);

            eCampo = null;
            eCampo = docDestino.createElement("CAMPO");
            eCampo.setAttribute("NOMBRE", "duracion");
            eCampo.setAttribute("TIPO", "STRING");
            txtDesc = null;
            txtDesc = docDestino.createTextNode(strDuracion);
            eCampo.appendChild(txtDesc);
            eRow.appendChild(eCampo);
            dtoPeriodo.setDuracion(new Integer(strDuracion));

            eCampo = null;
            eCampo = docDestino.createElement("CAMPO");
            eCampo.setAttribute("NOMBRE", "fInicio");
            eCampo.setAttribute("TIPO", "STRING");
            txtDesc = null;
            txtDesc = docDestino.createTextNode(fechaInicProxPeriod.toString());
            eCampo.appendChild(txtDesc);
            eRow.appendChild(eCampo);
            dtoPeriodo.setFechaInicio(fechaInicProxPeriod);

            Integer durac = new Integer((new Integer(strDuracion)).intValue()-1);

            // a la fecha de inicio le sumo la duracion standard y me da la de fin
            fechaInicProxPeriod = this.calculaProximaFecha(fechaInicProxPeriod, durac);

            eCampo = null;
            eCampo = docDestino.createElement("CAMPO");
            eCampo.setAttribute("NOMBRE", "fFin");
            eCampo.setAttribute("TIPO", "STRING");
            txtDesc = null;
            txtDesc = docDestino.createTextNode(fechaInicProxPeriod.toString());
            eCampo.appendChild(txtDesc);
            eRow.appendChild(eCampo);
            // Ahora en "fechaInicProxPeriod" está la fecha de fin
            dtoPeriodo.setFechaFin(fechaInicProxPeriod);

            // sumo un dia y obtengo la proxima fecha de inicio.
            fechaInicProxPeriod = this.calculaProximaFecha(fechaInicProxPeriod, new Integer(1));
            listadoDePeriodos.add(dtoPeriodo);
        }

        DruidaConector drCon = new DruidaConector();
        drCon.setXML(rowset);

        asignarAtributo("CAPA", "capaResultado", "visibilidad", "visible");
		asignarAtributo("CAPA", "botonesCrear", "visibilidad", "visible");

		asignar("LISTA", "ListaPeriodo", drCon, "dtoSalida.periodos_ROWSET");

        this.cargarPaisMarcaCanal();
        asignarAtributo("VAR","hAnio", "valor", this.anio);
        asignarAtributo("VAR", "hListadoDisponible", "valor", "SI");
        conectorParametroSesion("listadoDePeriodos", listadoDePeriodos);
    }
    

    /**
     * Una vez seleccionado el periodo para editar Duracion, F.Inicio, F.Fin, se
     * transfiere el control a LPModificar para permitir la modificación en formato
     * formulario.
     * ---> DEPRECATED. Ahora se modifica directamente en la lista editable.
     */
    private void modificarPeriodo() throws Exception {
        String periodoSeleccionado = conectorParametro("hPeriodoSeleccionado");
        periodoSeleccionado = (periodoSeleccionado == null) ? "" : periodoSeleccionado;
       
		ArrayList listadoDePeriodos = (ArrayList)conectorParametroSesion("listadoDePeriodos");

        DTOPeriodo dtoPeriodo = null;
        boolean encontro = false;

        for (int iPeriodo = 0; iPeriodo < listadoDePeriodos.size(); iPeriodo++)  {
            dtoPeriodo = (DTOPeriodo) listadoDePeriodos.get(iPeriodo);
            if (dtoPeriodo.getOidPeriodoCorporativo().toString().equalsIgnoreCase(periodoSeleccionado)) {
                encontro = true;
                break;
            }
        }
        traza("dtoPeriodo: " +dtoPeriodo);
        if (encontro) {
            // Invoco a la otra LP (LPModificaPeriodoCRA)
            conectorAction("LPModificaPeriodoCRA");
            conectorParametroSesion("hCasoDeUso",this.strCasoDeUso);
            conectorParametroSesion("periodoSeleccionado", dtoPeriodo);
            conectorActionParametro("accion","modificarPeriodo");
        }
    }


    /**
     * Se graban los periodos listados para el anio seleccinado
     */
    private void grabarPeriodos() throws Exception {
        //Tomamos la lista de periodos a insertar
        String listaPeriodosStr = conectorParametro("hListaPeriodos");
        listaPeriodosStr = (listaPeriodosStr == null) ? "" : listaPeriodosStr;
        traza("listaPeriodosStr: " + listaPeriodosStr);

        ArrayList listaDePeriodos = this.armarListaPeriodosAInsertar(listaPeriodosStr);
        traza("listaDePeriodos: " + listaDePeriodos);

        if (listaDePeriodos == null) {
            listaDePeriodos = new ArrayList();
        }

        IMareDTO lista = new MareDTO();
        Vector paramEntrada = new Vector();
        lista.addProperty("listaDePeriodos", listaDePeriodos);
        paramEntrada.add(lista);
        paramEntrada.add(new MareBusinessID("CRAInsertaListaPeriodos"));
		traza("antes de CRAInsertaListaPeriodos");
        DruidaConector drd = conectar("ConectorInsertaPeriodo", paramEntrada);
		traza("despues de CRAInsertaListaPeriodos");

        this.marca = "";
        this.canal = "";
        this.anio = "";
        this.cargarPaisMarcaCanal();
        asignarAtributo("VAR", "hListadoDisponible", "valor", "");
        asignarAtributo("VAR","hCasoDeUso", "valor", "insertar");
    }


    /**
     * Retorna un ArrayList de dtoPeriodo.
     * Separa cada dtoPeriodo segun cantidad de columnas de la lista editable de periodos.
     */
    private ArrayList armarListaPeriodosAInsertar(String listaPeriodosStr) throws Exception {
        traza("armarListaPeriodosAInsertar");
        DTOPeriodo dtoPeriodo;
        ArrayList listaPeriodos = new ArrayList();
        //fijamos el caracter separador
        StringTokenizer str = new StringTokenizer(listaPeriodosStr,",");
        while (str.hasMoreTokens()) {
            //nuevo periodo
            dtoPeriodo = new DTOPeriodo();
            //oidPeriodoCorporativo
            String oidPeriCorpoStr = str.nextToken();
            dtoPeriodo.setOidPeriodoCorporativo(new Long(oidPeriCorpoStr));
            //codigoTipoPeriodo
            String codigoTipoPeriodoStr = str.nextToken();
            dtoPeriodo.setCodigoTipoPeriodo(codigoTipoPeriodoStr);
            //codigoPeriodo
            String codigoPeriodoStr = str.nextToken();
            dtoPeriodo.setCodigoPeriodo(codigoPeriodoStr);
            //nombrePeriodo
            String nombrePeriodooStr = str.nextToken();
            dtoPeriodo.setNombre(nombrePeriodooStr);
            //duracion
            String duracionStr = str.nextToken();
            dtoPeriodo.setDuracion(new Integer(duracionStr));
            //fechaInicio
            String fechaInicioStr = str.nextToken();
            fechaInicioStr = obtenerFechaFormatoDate(fechaInicioStr);
            dtoPeriodo.setFechaInicio(Date.valueOf(fechaInicioStr));
            //fechaFin
            String fechaFinStr = str.nextToken();
            fechaFinStr = obtenerFechaFormatoDate(fechaFinStr);
            dtoPeriodo.setFechaFin(Date.valueOf(fechaFinStr));
            //oidTipoPeriodo
            String oidTipoPeriodoStr = str.nextToken();
            dtoPeriodo.setTipo(new Long(oidTipoPeriodoStr));
            //periodoCorto
            String periodoCortoStr = str.nextToken();
            dtoPeriodo.setPeriodoCorto(new Boolean(periodoCortoStr));
            //periodoCruce
            String periodoCruceStr = str.nextToken();
            dtoPeriodo.setPeriodoCruce(new Boolean(periodoCruceStr));
            //basicos
            dtoPeriodo.setPais(new Long(this.pais));
            dtoPeriodo.setMarca(new Long(this.marca));
			dtoPeriodo.setCanal(new Long(this.canal));
            //default
            dtoPeriodo.setAcceso(null);
            dtoPeriodo.setStatus(new Boolean(true));
            //extras
            dtoPeriodo.setPrograma(UtilidadesSession.getFuncion(this));
            dtoPeriodo.setIpCliente(UtilidadesBelcorp.getIPCliente(this));
            //agrego el periodo a la lista
            listaPeriodos.add(dtoPeriodo);
        }
        return listaPeriodos;
    }


    /**
     * Retorna un dtoPeriodo.
     * Separa cada campo del dtoPeriodo a partir del string dado.
     */
    private DTOPeriodo armarPeriodoModificadoCUInsertar(String periodoModificadoStr) throws Exception {
        traza("armarPeriodoModificado");
        //fijamos el caracter separador
        StringTokenizer str = new StringTokenizer(periodoModificadoStr,",");
        //dtoPeriodo
        DTOPeriodo dtoPeriodo = new DTOPeriodo();
        //oidPeriodoCorporativo
        String oidPeriCorpoStr = str.nextToken();
        dtoPeriodo.setOidPeriodoCorporativo(new Long(oidPeriCorpoStr));
        //codigoTipoPeriodo
        String codigoTipoPeriodoStr = str.nextToken();
        dtoPeriodo.setCodigoTipoPeriodo(codigoTipoPeriodoStr);
        //codigoPeriodo
        String codigoPeriodoStr = str.nextToken();
        dtoPeriodo.setCodigoPeriodo(codigoPeriodoStr);
        //nombrePeriodo
        String nombrePeriodooStr = str.nextToken();
        dtoPeriodo.setNombre(nombrePeriodooStr);
        //duracion
        String duracionStr = str.nextToken();
        dtoPeriodo.setDuracion(new Integer(duracionStr));
        //fechaInicio
        String fechaInicioStr = str.nextToken();
        fechaInicioStr = obtenerFechaFormatoDate(fechaInicioStr);
        dtoPeriodo.setFechaInicio(Date.valueOf(fechaInicioStr));
        //fechaFin
        String fechaFinStr = str.nextToken();
        fechaFinStr = obtenerFechaFormatoDate(fechaFinStr);
        dtoPeriodo.setFechaFin(Date.valueOf(fechaFinStr));
        //oidTipoPeriodo
        String oidTipoPeriodoStr = str.nextToken();
        dtoPeriodo.setTipo(new Long(oidTipoPeriodoStr));
        //periodoCorto
        String periodoCortoStr = str.nextToken();
        dtoPeriodo.setPeriodoCorto(new Boolean(periodoCortoStr));
        //periodoCruce
        String periodoCruceStr = str.nextToken();
        dtoPeriodo.setPeriodoCruce(new Boolean(periodoCruceStr));
        //basicos
        dtoPeriodo.setPais(new Long(this.pais));
        dtoPeriodo.setMarca(new Long(this.marca));
        dtoPeriodo.setCanal(new Long(this.canal));
        //default
        dtoPeriodo.setAcceso(null);
        dtoPeriodo.setStatus(new Boolean(true));
        //extras
        dtoPeriodo.setPrograma(UtilidadesSession.getFuncion(this));
        dtoPeriodo.setIpCliente(UtilidadesBelcorp.getIPCliente(this));
        return dtoPeriodo;
    }


    /**
     * Actualiza el periodo modifica en la pantalla de modificacion de un periodo.
     * ---> DEPRECATED. Ahora se modifica directamente en la lista editable.
     */
    private void actualizarPeriodo() throws Exception {
        DTOPeriodo dtoPeriodoActualizado = (DTOPeriodo) conectorParametroSesion("peridoActualizado");
        traza("peridoActualizado" + dtoPeriodoActualizado);
        ArrayList listadoDePeriodos = (ArrayList)conectorParametroSesion("listadoDePeriodos");

        DTOPeriodo dtoPeriodo = null;
        traza("peridoActualizado1 " + dtoPeriodoActualizado);
        traza("listadoDePeriodos1 " + listadoDePeriodos);
        for (int iPeriodo = 0; iPeriodo < listadoDePeriodos.size(); iPeriodo++)  {
            dtoPeriodo = (DTOPeriodo) listadoDePeriodos.get(iPeriodo);
            traza("dtoPeriodo.getCodigoPeriodo() "  + dtoPeriodo.getCodigoPeriodo());
            traza("dtoPeriodoActualizado.getCodigoPeriodo() " + dtoPeriodoActualizado.getCodigoPeriodo());
            if (dtoPeriodo.getCodigoPeriodo().equalsIgnoreCase(dtoPeriodoActualizado.getCodigoPeriodo())) {
				traza("entre");
                listadoDePeriodos.set(iPeriodo, dtoPeriodoActualizado);
                break;
            }
        }
		this.recargaListaPeriodos(listadoDePeriodos);
    }


	/**
	* Aplica los cambios (si los hubieron) y carga nuevamente el listado
     * ---> DEPRECATED. Ahora se modifica directamente en la lista editable.
	*/
	private void recargaListaPeriodos(ArrayList listadoDePeriodos) throws Exception {
        traza(" recarga lista periodos "); 
		this.actualizarLista(listadoDePeriodos);
        traza(" listadoDePeriodos: " + listadoDePeriodos);
        conectorParametroSesion("listadoDePeriodos", listadoDePeriodos);

        if (listadoDePeriodos.size() > 0) {
            DTOPeriodo dto = (DTOPeriodo)listadoDePeriodos.get(0);
            this.pais   = dto.getPais().toString();
            this.marca  = dto.getMarca().toString();
            this.canal  = dto.getCanal().toString();
            asignarAtributo("VAR","hAnio", "valor", dto.getCodigoPeriodo().substring(0,4));
        }
        this.cargarPaisMarcaCanal();
	}


    /**
     * Toma la lista actualizada y la refresca en la pantalla
     */
    private void actualizarLista(ArrayList listaDePeriodos) throws Exception {
        traza("actualizarLista");
        Document docDestino = newDocument();
        Element rowset = docDestino.createElement("ROWSET");
        rowset.setAttribute("ID", "dtoSalida.periodos_ROWSET");

        for (int i = 0; i < listaDePeriodos.size(); i++) {
            DTOPeriodo dtoPeriodo = (DTOPeriodo)listaDePeriodos.get(i);
            Element eRow = docDestino.createElement("ROW");
            rowset.appendChild(eRow);

            Element eCampo = docDestino.createElement("CAMPO");
            eCampo.setAttribute("NOMBRE", "idfila");
            eCampo.setAttribute("TIPO", "STRING");
            Text txtDesc = docDestino.createTextNode(dtoPeriodo.getOidPeriodoCorporativo().toString());
            eCampo.appendChild(txtDesc);
            eRow.appendChild(eCampo);

            eCampo = null;
            eCampo = docDestino.createElement("CAMPO");
            eCampo.setAttribute("NOMBRE", "tipo");
            eCampo.setAttribute("TIPO", "STRING");
            txtDesc = null;
            txtDesc = docDestino.createTextNode(dtoPeriodo.getCodigoTipoPeriodo());
            eCampo.appendChild(txtDesc);
            eRow.appendChild(eCampo);

            eCampo = null;
            eCampo = docDestino.createElement("CAMPO");
            eCampo.setAttribute("NOMBRE", "codigo");
            eCampo.setAttribute("TIPO", "STRING");
            txtDesc = null;
            txtDesc = docDestino.createTextNode(dtoPeriodo.getCodigoPeriodo());
            eCampo.appendChild(txtDesc);
            eRow.appendChild(eCampo);

            eCampo = null;
            eCampo = docDestino.createElement("CAMPO");
            eCampo.setAttribute("NOMBRE", "nombre");
            eCampo.setAttribute("TIPO", "STRING");
            txtDesc = null;
            txtDesc = docDestino.createTextNode(dtoPeriodo.getNombre());
            eCampo.appendChild(txtDesc);
            eRow.appendChild(eCampo);

            eCampo = null;
            eCampo = docDestino.createElement("CAMPO");
            eCampo.setAttribute("NOMBRE", "duracion");
            eCampo.setAttribute("TIPO", "STRING");
            txtDesc = null;
            txtDesc = docDestino.createTextNode(dtoPeriodo.getDuracion().toString());
            eCampo.appendChild(txtDesc);
            eRow.appendChild(eCampo);

            eCampo = null;
            eCampo = docDestino.createElement("CAMPO");
            eCampo.setAttribute("NOMBRE", "fInicio");
            eCampo.setAttribute("TIPO", "STRING");
            txtDesc = null;
            txtDesc = docDestino.createTextNode(obtenerFechaFormatoPais(dtoPeriodo.getFechaInicio()));
            eCampo.appendChild(txtDesc);
            eRow.appendChild(eCampo);

            eCampo = null;
            eCampo = docDestino.createElement("CAMPO");
            eCampo.setAttribute("NOMBRE", "fFin");
            eCampo.setAttribute("TIPO", "STRING");
            txtDesc = null;
            txtDesc = docDestino.createTextNode(obtenerFechaFormatoPais(dtoPeriodo.getFechaFin()));
            eCampo.appendChild(txtDesc);
            eRow.appendChild(eCampo);

            eCampo = null;
            eCampo = docDestino.createElement("CAMPO");
            eCampo.setAttribute("NOMBRE", "oidTipo");
            eCampo.setAttribute("TIPO", "STRING");
            txtDesc = null;
            txtDesc = docDestino.createTextNode(dtoPeriodo.getTipo().toString());
            eCampo.appendChild(txtDesc);
            eRow.appendChild(eCampo);

            eCampo = null;
            eCampo = docDestino.createElement("CAMPO");
            eCampo.setAttribute("NOMBRE", "periodoCorto");
            eCampo.setAttribute("TIPO", "STRING");
            txtDesc = null;
            String periodoCortoCheckBox;
            if (dtoPeriodo.getPeriodoCorto().toString() == "true" ) periodoCortoCheckBox = "S";
            else periodoCortoCheckBox = "N";
            txtDesc = docDestino.createTextNode(periodoCortoCheckBox);
            eCampo.appendChild(txtDesc);
            eRow.appendChild(eCampo);

            eCampo = null;
            eCampo = docDestino.createElement("CAMPO");
            eCampo.setAttribute("NOMBRE", "periodoCruce");
            eCampo.setAttribute("TIPO", "STRING");
            txtDesc = null;
            txtDesc = docDestino.createTextNode(dtoPeriodo.getPeriodoCruce().toString());
            eCampo.appendChild(txtDesc);
            eRow.appendChild(eCampo);
        }

        DruidaConector drCon = new DruidaConector();
        drCon.setXML(rowset);
        traza("ROWSET: " + rowset);
        asignar("LISTA", "listado1", drCon, "dtoSalida.periodos_ROWSET");
        asignarAtributo("VAR", "hListadoDisponible", "valor", "SI");
        traza("ac.4");
    }


    /**
     * Solicita el recalculo de periodos a negocio.
     * Estando por insertar periodos.
     */
    private void recalculaPeriodos() throws Exception {
        traza(" recalculaPeriodos ");
        ArrayList listaDePeriodos = new ArrayList();
        DTOPeriodo dtoPeriodoModificado = new DTOPeriodo();

        //Tomamos la lista de periodos a recalcular.
        String listaPeriodosStr = conectorParametro("hListaPeriodos");
        listaPeriodosStr = (listaPeriodosStr == null) ? "" : listaPeriodosStr;
        traza("listaPeriodosStr: " + listaPeriodosStr);

        //Tomamos el periodo modificado, para recalcular desde ahi.
        String periodoModificadoStr = conectorParametro("hPeriodoModificado");
        periodoModificadoStr = (periodoModificadoStr == null) ? "" : periodoModificadoStr;
        traza("periodoModificadoStr: " + periodoModificadoStr);

        //armo lista de periodos y el periodo modificado segun el caso de uso.
        listaDePeriodos = this.armarListaPeriodosAInsertar(listaPeriodosStr);
        dtoPeriodoModificado = this.armarPeriodoModificadoCUInsertar(periodoModificadoStr);

        traza("listaDePeriodos: " + listaDePeriodos);
        traza("dtoPeriodoModificado: " + dtoPeriodoModificado);

        if (dtoPeriodoModificado != null) {
            this.pais = dtoPeriodoModificado.getPais().toString();
            this.marca = dtoPeriodoModificado.getMarca().toString();
            this.canal = dtoPeriodoModificado.getCanal().toString();
            this.anio = dtoPeriodoModificado.getCodigoPeriodo().substring(0,4);

            DTORecalculoPeriodos dtoRecalculoPeriodos = new DTORecalculoPeriodos();
            dtoRecalculoPeriodos.setPais(new Long(this.pais));
            dtoRecalculoPeriodos.setMarca(new Long(this.marca));
            dtoRecalculoPeriodos.setCanal(new Long(this.canal));
            dtoRecalculoPeriodos.setPeriodo(dtoPeriodoModificado);
            dtoRecalculoPeriodos.setPrograma(UtilidadesSession.getFuncion(this));
            dtoRecalculoPeriodos.setIpCliente(UtilidadesBelcorp.getIPCliente(this));

            // Signatura del metodo en el MON
            // public Collection recalculaPeriodos(DTORecalculoPeriodos recalculoPeriodos,Collection collPeriodos)
            IMareDTO parametrosRecalcula = new MareDTO();
            parametrosRecalcula.addProperty("dtoRecalculoPeriodos", dtoRecalculoPeriodos);
            parametrosRecalcula.addProperty("listadoDePeriodos", listaDePeriodos);

            Vector paramEntrada = new Vector();
            paramEntrada.add(parametrosRecalcula);
            paramEntrada.add(new MareBusinessID("CRARecalculaPeriodos"));
            traza("parametrosRecalcula " + parametrosRecalcula);

            traza("antes de CRARecalculaPeriodos");
            DruidaConector conectorRecalculaPeriodos = conectar("ConectorRecalculaPeriodos", paramEntrada);
            traza("despues de CRARecalculaPeriodos");

            IMareDTO dtoSalida = (MareDTO) conectorRecalculaPeriodos.objeto("dtoSalida");
            Collection listadoModificado = (ArrayList)dtoSalida.getProperty("listadoModificado");
            this.actualizarLista((ArrayList)listadoModificado);
            conectorParametroSesion("listadoDePeriodos", listadoModificado);

        } else {
            this.actualizarLista(listaDePeriodos);
        }

        this.cargarPaisMarcaCanal();
        asignarAtributo("VAR","hAnio", "valor", this.anio);
        asignarAtributo("VAR","hCasoDeUso", "valor", "insertar");
        traza(" Fin RecalculoPeriodos ");                
    }


    /**
     * Genera el documento para la presentacion de la rejilla.
     */
    private Document newDocument() throws Exception{
        if(docBuilder == null) {
            docBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        }
        return docBuilder.newDocument();
    }

    /**
     * Imprime el stack trace en caso de errores.
     */
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


    /**
     * Retorna string fecha en formato YYYY-MM-DD, tal como lo maneja Date.
     * Recibe el string fecha en formato en el formato del pais. 
     */
    private String obtenerFechaFormatoDate(String fecha) throws Exception {
        // obtenemos el formato de fecha segun el pais
        String formatoFecha = conectorParametro("hFormatoFechaPais");
        // aseguro el indicador de mes a mayuscula  
        formatoFecha = formatoFecha.replace('m','M');
        //trabajamos con el formato del pais
        SimpleDateFormat formatoPais = new SimpleDateFormat(formatoFecha);
        //formateamos la fecha segun el formato Date yyyy-mmm-dd
        Date fechaFormatoDate = new java.sql.Date(formatoPais.parse(fecha).getTime());
        //retorna la fecha formateada
        return fechaFormatoDate.toString();
    }


    /**
     * Retorna el string fecha segun el formato por pais.
     * La fecha a formatear viene en formato Date YYYY-MM-DD.
     */
    private String obtenerFechaFormatoPais(Date fecha) throws Exception {
        // obtenemos el formato de fecha segun el pais
        String formatoFecha = conectorParametro("hFormatoFechaPais");
        // aseguro el indicador de mes a mayuscula  
        formatoFecha = formatoFecha.replace('m','M');
        //trabajamos con el formato del pais
        SimpleDateFormat formatoPais = new SimpleDateFormat(formatoFecha);
        //formateamos la fecha segun el formato del pais
        String fechaFormatoPaisStr = formatoPais.format(fecha);
        //retorna la fecha formateada
        return fechaFormatoPaisStr;
    }

}
