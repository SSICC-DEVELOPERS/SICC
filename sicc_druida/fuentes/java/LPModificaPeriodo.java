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

import LPSICCBase;
import es.indra.druida.DruidaConector;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mgu.manager.Property;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.dtos.cra.DTOAsociadosAPeriodo;
import es.indra.sicc.dtos.cra.DTOSeleccionPaisMarcaCanal;
import es.indra.sicc.dtos.cra.DTOCriteriosPeriodo;
import es.indra.sicc.dtos.seg.DTOFiltroPMC;
import es.indra.sicc.util.BelcorpError;
import es.indra.sicc.util.DTOError;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.dtos.cra.DTOPeriodo;
import es.indra.sicc.dtos.cra.DTORecalculoPeriodos;
import es.indra.mare.common.dto.MareDTO;
import es.indra.mare.common.dto.IMareDTO;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Vector;
import java.util.Collection;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.StringTokenizer;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import es.indra.sicc.cmn.presentacion.rastreador.Rastreador;
import es.indra.sicc.cmn.presentacion.rastreador.IRastreador;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;



// Definicion de la clase
public class LPModificaPeriodo extends LPSICCBase {
    final String NOMBRE_LISTA_PERIODOS = "listado1";
    final String CASO_DE_USO = "modificar";

    String pais = null;
    String paisDescripcion = null;
    String marca = null;
    String canal = null;
    String anio = null;

	private DocumentBuilder docBuilder = null;
	
    // Definicion del constructor
    public LPModificaPeriodo() {
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
        asignarAtributoPagina("cod","096");

        String accion  = conectorParametro("accion");
        accion = (accion == null) ? "" : accion;

        this.pais   = conectorParametro("hPais");
        this.marca  = conectorParametro("hMarca");
        this.canal  = conectorParametro("hCanal");
        this.anio   = conectorParametro("hAnio");

        this.pais   = (this.pais == null) ? "" : this.pais;
        this.marca  = (this.marca == null) ? "" : this.marca;
        this.canal  = (this.canal == null) ? "" : this.canal;
        this.anio   = (this.anio == null) ? "" : this.anio;

        //Asignar caso de uso
        asignarAtributo("VAR","hCasoDeUso", "valor", CASO_DE_USO);
        //Asignar el caso de uso a la sesion
        conectorParametroSesion("hCasoDeUso", CASO_DE_USO);

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
		traza("accion: " + accion);
        asignarAtributo("VAR","accion","valor",accion);

        try {
            rastreo();
            if (accion.equals("")) {
                this.cargarPaisMarcaCanal();
                asignarAtributo("VAR", "hEnableSave", "valor", "");
                getConfiguracionMenu("LPModificaPeriodo");

            } else if (accion.equals("buscar")) {
                //Rama en deshuso por carga con paginacion
                //this.obtenerTodosLosPeriodos();
                //this.cargarPaisMarcaCanal();
                //asignarAtributo("VAR","hAnio", "valor", anio);
                //asignarAtributo("VAR", "hCasoDeUso", "valor", this.CASO_DE_USO);
                //asignarAtributo("VAR","hEnableSave","valor","enable");
                //getConfiguracionMenu();

            } else if (accion.equals("modificarPeriodo")) {
                //Rama en deshuso por edicion en la lista editable
                //this.modificarPeriodo();
                //getConfiguracionMenu();

            } else if(accion.equals("actualizarPeriodo")) {
                //Rama en deshuso por edicion en la lista editable
                //this.actualizarPeriodo();
                //asignarAtributo("VAR","hEnableSave","valor","enable");
                //getConfiguracionMenu();

            } else if (accion.equals("grabar")) {
                this.grabarPeriodos();
                asignarAtributo("VAR","hAnio", "valor", anio);
                asignarAtributo("VAR", "hCasoDeUso", "valor", this.CASO_DE_USO);
                asignarAtributo("VAR","hEnableSave","valor","");
                getConfiguracionMenu();

            } else if (accion.equals("recalculaPeriodos")) {
                this.recalculaPeriodos();
                asignarAtributo("VAR","hEnableSave","valor","enable");
				getConfiguracionMenu();

            } else if (accion.equals("volverSinCambios")) {
                //Rama en deshuso por edicion en la lista editable
                //ArrayList listadoDePeriodos = (ArrayList)conectorParametroSesion("listadoDePeriodos");
                //this.recargaListaPeriodos(listadoDePeriodos);
                //asignarAtributo("VAR","hEnableSave","valor","enable");
            }

        } catch (Exception ex) {
            logStackTrace(ex);
            this.lanzarPaginaError(ex);
            asignarAtributo("VAR","hAnio", "valor", this.anio);
            asignarAtributo("VAR", "hCasoDeUso", "valor", this.CASO_DE_USO);
            this.marca = ""; this.canal = ""; this.anio = "";
            this.cargarPaisMarcaCanal();
        }
    }


    /**
    * Se carga Pais Marca y Canal en los combos.
    */
    private void cargarPaisMarcaCanal() throws Exception {
        //Carga Paises, Marcas y Canales
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
        traza("despues cargar CRAPaisMarcaCanal");
        // Se asigna a los combos los posibles valores para Pais, Marca y Canal.
        asignar("COMBO", "comboMarca", conectorCargarPaisMarcaCanal, "dtoSalida.marcas_ROWSET");
        asignar("COMBO", "comboCanal", conectorCargarPaisMarcaCanal, "dtoSalida.canales_ROWSET");

        // Pasa los viejos valores seleccionados (si existen).
        asignarAtributo("VAR", "hPais", "valor", this.pais);
        asignarAtributo("VAR", "hPaisDescripcion", "valor", this.paisDescripcion);
        asignarAtributo("VAR", "hMarca", "valor", this.marca);
        asignarAtributo("VAR", "hCanal", "valor", this.canal);
    }


    /**
    * Calcula la proxima fecha, incrementando segun dias.
    * @return Date - Fecha con el avance en dias.
    * @param fecha - Fecha base sobre la cual se calcula el incremento.
    *        incrementoDias - Dias que se le suma a la fecha base.
    */
    private Date calculaProximaFecha(Date fecha, Integer incrementoDias) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(fecha);
        cal.add(Calendar.DATE, incrementoDias.intValue());
        Date fechaIncrementada = new java.sql.Date(cal.getTime().getTime());

        return fechaIncrementada;
    }


    /**
    * Se consultan periodos a los efectos de su modificacion
    * ---> DEPRECATED. Ahora se utiliza la carga con paginado por javascript.
    */
    private void obtenerTodosLosPeriodos() throws Exception{
        DTOCriteriosPeriodo dtoCriteriosPeriodo = new DTOCriteriosPeriodo();
        dtoCriteriosPeriodo.setPais(new Long(this.pais));
        dtoCriteriosPeriodo.setMarca(new Long(this.marca));
        dtoCriteriosPeriodo.setCanal(new Long(this.canal));
        dtoCriteriosPeriodo.setAnio(new Integer(this.anio));
        dtoCriteriosPeriodo.setPrograma(UtilidadesSession.getFuncion(this));
        dtoCriteriosPeriodo.setIpCliente(UtilidadesBelcorp.getIPCliente(this));

        Vector paramEntrada = new Vector();
        paramEntrada.add(dtoCriteriosPeriodo);
        paramEntrada.add(new MareBusinessID("CRAConsultarPeriodos"));
        traza ("antes de CRAConsultarPeriodos");   
        DruidaConector conectorObtenerTodosPeriodos = conectar("ConectorObtenerTodosPeriodos", paramEntrada);
        traza ("despues de CRAConsultarPeriodos");

        Vector v = valorRowset("dtoSalida.resultado_ROWSET", conectorObtenerTodosPeriodos);
        traza("periodos cargados inicialmente .." + v.toString());

        //********//
        //Se reemplaza el Vector que contiene recordsets por un ArrayList con DTOPeriodo
        ArrayList listadoDePeriodos = new ArrayList();
        Vector v1 = null;
        traza("v.elements() " + v.elements());
        Enumeration e = v.elements();
        DTOPeriodo dtp = null;
    
        while(e.hasMoreElements()){
            v1 = (Vector) e.nextElement();
            traza ("v1 " + v1);

            /*  Desde el sql: DESC_PAIS, DURA, DES_MARC,
                DESC_CANAL, COD_TIPO_PERI, COD_PERI, VAL_NOMB_PERI, FEC_INIC,
                FEC_FINA, OID_PERI, OID_TIPO_PERI, PERI_OID_PERI,
                PAIS_OID_PAIS, P.MARC_OID_MARC, P.CANA_OID_CANA	*/
            /*  Orden al transformar en el conector : OID_PERI, COD_TIPO_PERI, VAL_NOMB_PERI
                DURA, FEC_INIC, FEC_FINA, OID_TIPO_PERI, PERI_OID_PERI, COD_PERI */

            dtp = new DTOPeriodo();
            traza ("1" );
            dtp.setOid(new Long((String) v1.elementAt(0)));
            dtp.setCodigoTipoPeriodo((String) v1.elementAt(1));
            dtp.setNombre(v1.elementAt(2).toString());
            dtp.setDuracion(new Integer(v1.elementAt(3).toString()));
            dtp.setFechaInicio(Date.valueOf(v1.elementAt(4).toString()));
            dtp.setFechaFin(Date.valueOf(v1.elementAt(5).toString()));
            dtp.setTipo(new Long(v1.elementAt(6).toString()));
            dtp.setOidPeriodoCorporativo(new Long(v1.elementAt(7).toString()));
            dtp.setCodigoPeriodo(v1.elementAt(8).toString());

            dtp.setPais(new Long( pais ));
            dtp.setMarca(new Long( marca ));
            dtp.setCanal(new Long( canal ));

            traza ("2" );
            dtp.setAcceso(null); // para completar la información default
            dtp.setSubAcceso(null);
            dtp.setStatus(new Boolean(true)); // para completar la info. default

            listadoDePeriodos.add(dtp);
            traza ("3" );
        }
        //********//
    
        if(v==null || v.isEmpty()){
            asignarAtributo("VAR","errCodigo", "valor", "" + "160");
            //asignarAtributo("VAR","hidErrDescripcion", "valor", "No hay datos");
        } else{
            traza ("4");
            asignarAtributo("CAPA", "capaResultado", "visibilidad", "visible");
            asignarAtributo("CAPA", "botonesCrear", "visibilidad", "visible");
            traza ("5" );
            asignar("LISTA", NOMBRE_LISTA_PERIODOS, conectorObtenerTodosPeriodos, "dtoSalida.resultado_ROWSET");
            traza ("6" );
            conectorParametroSesion("listadoDePeriodos", listadoDePeriodos);
            asignarAtributo("VAR", "hListadoDisponible", "valor", "SI");
            traza ("7" );
        }
    }


    /**
    * Una vez seleccionado el periodo para editar Duracion, F.Inicio, F.Fin, se
    * transfiere el control a LPModificar para permitir la modificación en formato formulario.
    * ---> DEPRECATED. Ahora se modifica directamente en la lista editable.
    */
    private void modificarPeriodo() throws Exception {
        String periodoSeleccionado = conectorParametro("hPeriodoSeleccionado");
        periodoSeleccionado = (periodoSeleccionado == null) ? "" : periodoSeleccionado;
        ArrayList al = (ArrayList)conectorParametroSesion("listadoDePeriodos");
        DTOPeriodo dto = null;
        DTOPeriodo dtoPeriodo = null;
        boolean encontro = false;

        Iterator i = al.iterator();
        while(i.hasNext() && !encontro){
            dto = (DTOPeriodo) i.next();
            if(dto.getOid().longValue()== Long.parseLong(periodoSeleccionado)){
                dtoPeriodo = new DTOPeriodo();
                dtoPeriodo.setOid( dto.getOid() );
                dtoPeriodo.setCodigoTipoPeriodo(dto.getCodigoTipoPeriodo());
                dtoPeriodo.setNombre( dto.getNombre() );
                dtoPeriodo.setDuracion( dto.getDuracion() );
                dtoPeriodo.setFechaInicio( dto.getFechaInicio() );
                dtoPeriodo.setFechaFin( dto.getFechaFin() );
                dtoPeriodo.setPais(new Long(pais));
                dtoPeriodo.setMarca(new Long(marca));
                dtoPeriodo.setCanal(new Long(canal));
                dtoPeriodo.setCodigoPeriodo( dto.getCodigoPeriodo() );
                dtoPeriodo.setOidPeriodoCorporativo( dto.getOidPeriodoCorporativo());
                dtoPeriodo.setTipo( dto.getTipo() );
                encontro = true;
            }
        }
        //Guardar en sesion
        if (encontro) {
            conectorAction("LPModificaPeriodoCRA");
            conectorParametroSesion("hCasoDeUso",this.CASO_DE_USO);
            conectorParametroSesion("periodoSeleccionado", dtoPeriodo);
            conectorParametroSesion("anio", anio);
            conectorActionParametro("accion","modificarPeriodo");
        }
    }


    /**
    * Se graban los periodos listados para el anio seleccinado
    */
    private void grabarPeriodos() throws Exception {
        //Tomamos la lista de periodos a modificar
        String listaPeriodosStr = conectorParametro("hListaPeriodos");
        listaPeriodosStr = (listaPeriodosStr == null) ? "" : listaPeriodosStr;
        traza("listaPeriodosStr: " + listaPeriodosStr);

        ArrayList listaDePeriodos = this.armarListaPeriodosAModificar(listaPeriodosStr);
        traza("Lista de Periodos a Modificar: " + listaDePeriodos);

        if (listaDePeriodos == null) {
            listaDePeriodos = new ArrayList();
        }

        IMareDTO lista = new MareDTO();
        Vector paramEntrada = new Vector();
        lista.addProperty("ListaDePeriodos", listaDePeriodos);
        paramEntrada.add(lista);
        paramEntrada.add(new MareBusinessID("CRAActualizaPeriodos"));
        traza ("antes de CRAActualizaPeriodos");
        DruidaConector drd = conectar("ConectorModificaPeriodo", paramEntrada);
        traza ("despues de CRAActualizaPeriodos");

        this.cargarPaisMarcaCanal();
        this.actualizarLista(listaDePeriodos);
        asignarAtributo("VAR", "hListadoDisponible", "valor", "SI");
    }


    /**
     * Retorna un ArrayList de dtoPeriodo.
     * Separa cada dtoPeriodo segun cantidad de columnas de la lista editable de periodos.
     */
    private ArrayList armarListaPeriodosAModificar(String listaPeriodosStr) throws Exception {
        traza("armarListaPeriodosAModificar");
        DTOPeriodo dtoPeriodo;
        ArrayList listaPeriodos = new ArrayList();
        //fijamos el caracter separador
        StringTokenizer str = new StringTokenizer(listaPeriodosStr,",");
        while (str.hasMoreTokens()) {
            //nuevo periodo
            dtoPeriodo = new DTOPeriodo();
            //oidPeriodo
            String oidPeriodoStr = str.nextToken();
            dtoPeriodo.setOid(new Long(oidPeriodoStr));
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
            //extras
            dtoPeriodo.setPrograma(UtilidadesSession.getFuncion(this));
            dtoPeriodo.setIpCliente(UtilidadesBelcorp.getIPCliente(this));
            //agrego el periodo a la lista
            listaPeriodos.add(dtoPeriodo);
        }
        return listaPeriodos;
    }


    /**
    * Actualiza el periodo modifica en la pantalla de modificacion de un periodo
    * ---> DEPRECATED. Ahora se modifica directamente en la lista editable.
    */
    private void actualizarPeriodo() throws Exception {
        DTOPeriodo dtoPeriodoActualizado = (DTOPeriodo) conectorParametroSesion("peridoActualizado");
        traza("peridoActualizado " + dtoPeriodoActualizado);
        ArrayList listadoDePeriodos = (ArrayList) conectorParametroSesion("listadoDePeriodos");
        DTOPeriodo dtoPeriodo = null;
        traza("listadoDePeriodos " + listadoDePeriodos);
        for (int iPeriodo = 0; iPeriodo < listadoDePeriodos.size(); iPeriodo++)  {
            traza("AP1");
            dtoPeriodo = (DTOPeriodo) listadoDePeriodos.get(iPeriodo);
            traza("AP2");
            if (dtoPeriodo.getOid().longValue()==dtoPeriodoActualizado.getOid().longValue()) {
                traza("AP3");
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
        traza("recargaListaPeriodos");
        this.actualizarLista(listadoDePeriodos);
        traza("R1");
        conectorParametroSesion("listadoDePeriodos", listadoDePeriodos);
        traza("R2");
        if (listadoDePeriodos.size() > 0) {
            traza("R3");
            DTOPeriodo dto = (DTOPeriodo)listadoDePeriodos.get(0);
            this.pais   = dto.getPais().toString();
            this.marca  = dto.getMarca().toString();
            this.canal  = dto.getCanal().toString();
            asignarAtributo("VAR","hAnio", "valor", dto.getCodigoPeriodo().substring(0,4));
        }
        traza("R4");
        this.cargarPaisMarcaCanal();
	}


    /**
    * Toma la lista actualizada y la refresca en la pantalla
    */
    private void actualizarLista(ArrayList listaDePeriodos) throws Exception {
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
            Text txtDesc = docDestino.createTextNode(dtoPeriodo.getOid().toString());
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
		
        asignarAtributo("CAPA", "capaResultado", "visibilidad", "visible");
        asignarAtributo("CAPA", "botonesCrear", "visibilidad", "visible");
        asignar("LISTA", "listado1", drCon, "dtoSalida.periodos_ROWSET");
        asignarAtributo("VAR", "hListadoDisponible", "valor", "SI");
    }


    /**
     * Retorna un dtoPeriodo.
     * Separa cada campo del dtoPeriodo a partir del string dado.
     */
    private DTOPeriodo armarPeriodoModificadoCUModicar(String periodoModificadoStr) throws Exception {
        traza("armarPeriodoModificado");
        //fijamos el caracter separador
        StringTokenizer str = new StringTokenizer(periodoModificadoStr,",");
        //dtoPeriodo
        DTOPeriodo dtoPeriodo = new DTOPeriodo();
        //oidPeriodoCorporativo
        String oidStr = str.nextToken();
        dtoPeriodo.setOid(new Long(oidStr));
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
     * Solicita el recalculo de periodos a negocio.
     * Estando por modificar periodos.
     */
    private void recalculaPeriodos() throws Exception {
        traza(" recalculaPeriodos, cu modificar.");
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

        //armo lista de periodos y el periodo modificado.
        listaDePeriodos = this.armarListaPeriodosAModificar(listaPeriodosStr);
        dtoPeriodoModificado = this.armarPeriodoModificadoCUModicar(periodoModificadoStr);

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
        asignarAtributo("VAR","hCasoDeUso", "valor", "modificar");
        traza(" Fin RecalculoPeriodos, cu modificar. ");                
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
