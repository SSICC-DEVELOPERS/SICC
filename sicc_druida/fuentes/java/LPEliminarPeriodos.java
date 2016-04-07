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
*
* @author  jnieva
*
**/

import es.indra.druida.DruidaConector;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mgu.manager.Property;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.dtos.cra.DTOAsociadosAPeriodo;
import es.indra.sicc.dtos.cra.DTOCriteriosPeriodo;
import es.indra.sicc.dtos.cra.DTOID;
import es.indra.sicc.dtos.cra.DTOPeriodo;
import es.indra.sicc.dtos.cra.DTORecalculoPeriodos;
import es.indra.sicc.dtos.cra.DTOSeleccionPaisMarcaCanal;
import es.indra.sicc.dtos.seg.DTOFiltroPMC;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.mare.common.dto.IMareDTO;
import es.indra.mare.common.dto.MareDTO;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.StringTokenizer;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Vector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Collection;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import es.indra.sicc.cmn.presentacion.rastreador.Rastreador;
import es.indra.sicc.cmn.presentacion.rastreador.IRastreador;

import org.w3c.dom.Document;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;  
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;

// Definicion de la clase
public class LPEliminarPeriodos extends LPSICCBase {

    private final String CAPA_PERIODOS = "capaResultado";
    private final String PERIODOS = "Periodos";  
    private final String PERIODO_RECALCULO = "Periodo_recalculo";
    private DocumentBuilder docBuilder = null;
  
    String pais = null;
    String paisDescripcion = null;
    String marca = null;
    String canal = null;
    String anio = null;
    String accion = null;
    String casoDeUso = null;
	String acceso = null;

    // Definicion del constructor
    public LPEliminarPeriodos() {
        super();
    }

    // Definicion del metodo abstracto inicio
    public void inicio() throws Exception {
        // Defino el nombre de la vista
        pagina("contenido_periodos_eliminar");
    }

    // Definicion del metodo abstracto ejecucion
    public void ejecucion() throws Exception {
        setTrazaFichero();
        generarHiddenFormatoFecha();
        this.accion = conectorParametroLimpia("accion", "", true);
        this.pais = conectorParametroLimpia("hPais", "", true);
        this.marca = conectorParametroLimpia("hMarca", "", true);
        this.canal = conectorParametroLimpia("hCanal", "", true);
        this.anio = conectorParametroLimpia("hAnio", "", true);
		this.acceso = conectorParametroLimpia("hAcceso", "", true);
        casoDeUso = conectorParametroLimpia("hCasoDeUso ", "", true);

        casoDeUso = (casoDeUso == null) ? "" : casoDeUso;
        traza("CU " + casoDeUso);

        this.pais = conectorParametro("hPais"); 
        this.paisDescripcion = conectorParametro("hPaisDescripcion"); 

        if ((this.pais == null) || ((this.pais != null) && this.pais.equals(""))) {
            this.pais = UtilidadesSession.getPais(this).toString();
            this.paisDescripcion = UtilidadesSession.getDescripcionPais(this);
            traza("pais: " + this.pais);
            asignarAtributo("VAR", "hPais", "valor", this.pais);
            asignarAtributo("VAR", "hPaisDescripcion", "valor", this.paisDescripcion);
        }

        try {
            rastreo();
            if (accion.equals("")) {
                // Carga Pais, Marca y Canal
                this.cargarPaisMarcaCanal();
                getConfiguracionMenu("LPEliminarPeriodos");

            } else if (accion.equals("buscar")) {
                //Rama en deshuso por carga con paginacion
                //this.cargarPaisMarcaCanal();
                //this.accionBuscar();
                //getConfiguracionMenu();

            } else if (accion.equals("eliminarPeriodo")) {
                //Rama en deshuso por uso de eliminarFilas en paginado
                //this.accionEliminar();
                //this.cargarPaisMarcaCanal();
                //getConfiguracionMenu();

            } else if (accion.equals("recalcularPeriodos")) {
                // Recalcular Periodos
                this.recalcularPeriodos();
                this.grabarPeriodos();
                this.cargarPaisMarcaCanal();
                getConfiguracionMenu();

            }
            asignarAtributo("VAR", "accion", "valor", accion);
		
        } catch (Exception ex) {
            logStackTrace(ex);
            this.lanzarPaginaError(ex);
            asignarAtributo("VAR", "hPais", "valor", this.pais);
            asignarAtributo("VAR", "hMarca", "valor", this.marca);
            asignarAtributo("VAR", "hCanal", "valor", this.canal);
            asignarAtributo("VAR", "hAnio", "valor", this.anio);
            asignarAtributo("VAR", "accion", "valor", this.accion);
			asignarAtributo("VAR", "hAcceso", "valor", this.acceso);
            this.cargarPaisMarcaCanal();
        }
    }


    /**
    * Se carga Pais Marca y Canal en los combos.
    */
    private void cargarPaisMarcaCanal() throws Exception {
        DTOFiltroPMC paisMarcaCanal = new es.indra.sicc.dtos.seg.DTOFiltroPMC();
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
		traza("despues cargar CRAPaisMarcaCanal");
        // Se asigna a los combos los posibles valores para Pais, Marca y Canal.
        //asignar("COMBO", "comboMarca", conectorCargarPaisMarcaCanal, "dtoSalida.marcas_ROWSET");
        //asignar("COMBO", "comboCanal", conectorCargarPaisMarcaCanal, "dtoSalida.canales_ROWSET");

		/*traza("7777carga de combo acceso7777");

			  ComposerViewElementList listElement = new ComposerViewElementList();

              es.indra.sicc.util.DTOOID dto = new es.indra.sicc.util.DTOOID();

              
              dto.setOidIdioma(UtilidadesSession.getIdioma(this));              
              ComposerViewElement elem1 = new ComposerViewElement();
              elem1.setIDBusiness("SEGObtenerAccesosSinFiltro");
              elem1.setDTOE(dto);
              listElement.addViewElement(elem1);
                    
              ConectorComposerView conector = new ConectorComposerView(listElement,this.getRequest());

              conector.ejecucion();
            
              DruidaConector conConsultar = conector.getConector();

              asignar("COMBO", "comboAcceso", conConsultar, "SEGObtenerAccesosSinFiltro");   
         traza("77777777777");
		 */
		 asignar("COMBO", "comboMarca", conectorCargarPaisMarcaCanal, "dtoSalida.marcas_ROWSET");
        asignar("COMBO", "comboCanal", conectorCargarPaisMarcaCanal, "dtoSalida.canales_ROWSET");

        // Pasa los viejos valores seleccionados (si existen).
        asignarAtributo("VAR", "hPais", "valor", this.pais);
        asignarAtributo("VAR", "hPaisDescripcion", "valor", this.paisDescripcion);
        asignarAtributo("VAR", "hMarca", "valor", this.marca);
        asignarAtributo("VAR", "hCanal", "valor", this.canal);
		asignarAtributo("VAR", "hAcceso", "valor", this.acceso);
        asignarAtributo("VAR", "hAnio", "valor", this.anio);
    }


    /**
    * El usuario seleccionó P-M-C y anio, y pulso buscar para levantar la tabla de periodos.
    * ---> DEPRECATED. Ahora se utiliza la carga con paginado por javascript.
    */
    private void accionBuscar() throws Exception {
        DTOCriteriosPeriodo dtoCriterioPeriodo = new DTOCriteriosPeriodo();
        dtoCriterioPeriodo.setPais(new Long(this.pais));
        dtoCriterioPeriodo.setMarca(new Long(this.marca));
        dtoCriterioPeriodo.setCanal(new Long(this.canal));
        dtoCriterioPeriodo.setAnio(new Integer(this.anio));
		dtoCriterioPeriodo.setAcceso(new Long(this.acceso));
        dtoCriterioPeriodo.setPrograma(UtilidadesSession.getFuncion(this));
        dtoCriterioPeriodo.setIpCliente(UtilidadesBelcorp.getIPCliente(this));

        Vector paramEntrada = new Vector();
        paramEntrada.add(dtoCriterioPeriodo);
        paramEntrada.add(new MareBusinessID("CRAConsultarPeriodos"));
        DruidaConector conectorObtenerTodosPeriodos = conectar("ConectorObtenerTodosPeriodos", paramEntrada);
        asignar("LISTA", "ListaPeriodo", conectorObtenerTodosPeriodos, "dtoSalida.resultado_ROWSET");

        //Guarda el listado de periodos en la sesion 
        Vector vectorPeriodos = valorRowset("dtoSalida.resultado_ROWSET", conectorObtenerTodosPeriodos);
        Iterator i = vectorPeriodos.iterator();

        ArrayList listaPeriodos = new ArrayList();
        while (i.hasNext()){
            DTOPeriodo dtoPeriodo = new DTOPeriodo();
            Vector peri = (Vector) i.next();
            dtoPeriodo.setPais(new Long(this.pais));
            dtoPeriodo.setMarca(new Long(this.marca));
            dtoPeriodo.setCanal(new Long(this.canal));
            dtoPeriodo.setOid(new Long ((String) peri.elementAt(0)));      
            dtoPeriodo.setCodigoTipoPeriodo((String) peri.elementAt(1));
            dtoPeriodo.setNombre((String) peri.elementAt(2));
            dtoPeriodo.setDuracion(new Integer(peri.elementAt(3).toString()));
            dtoPeriodo.setFechaInicio(Date.valueOf((String) peri.elementAt(4)));
            dtoPeriodo.setFechaFin(Date.valueOf((String) peri.elementAt(5)));
            dtoPeriodo.setTipo(new Long(peri.elementAt(6).toString()));
            listaPeriodos.add(dtoPeriodo);
        }
        conectorParametroSesion(PERIODOS, listaPeriodos);  
    }


    /**
    * El usuario selecciona un periodo a eliminar de la tabla de periodos.
    * ---> DEPRECATED. Ahora se utiliza la eliminacion con paginado por javascript.
    */
    private void accionEliminar() throws Exception {
        Long oidPeriodo  = new Long (conectorParametroLimpia("hPeriodoSeleccionado", "", true));
        DTOID dtoId = new DTOID();
        traza("oidPeriodo" + oidPeriodo);
        dtoId.setPais(new Long(this.pais));
        dtoId.setMarca(new Long(this.marca));
        dtoId.setCanal(new Long(this.canal));
		dtoId.setAcceso(new Long(this.acceso));
        dtoId.setOid(oidPeriodo);
        this.eliminar(dtoId);
        this.actualizarDatosSesion(oidPeriodo);
    }


    /**
    * Se actualizan en sesion los datos de los periodos para recalcular. 
    * ---> DEPRECATED. Ahora se utiliza la eliminacion con paginado por javascript.
    */
    private void actualizarDatosSesion(Long oidPeriodo) throws Exception {
        ArrayList colPeriodos = (ArrayList) conectorParametroSesion(PERIODOS);
        Iterator i = colPeriodos.iterator();
        DTORecalculoPeriodos dtoRecalculo = null;
        int indicePeriodoEliminado = -1;
    
        while (i.hasNext()) {
            DTOPeriodo periodo = (DTOPeriodo) i.next();
            if (periodo.getOid().equals(oidPeriodo)) {
                indicePeriodoEliminado = colPeriodos.indexOf(periodo);
                colPeriodos.remove(periodo);
                //Si el periodo eliminado no es el primero de la lista o el ultimo, llamo a recalcular
                if (!((indicePeriodoEliminado == 0) || (indicePeriodoEliminado == colPeriodos.size()))) {
                    //Obtengo el periodo anterior al eliminado
                    DTOPeriodo periodoAnterior = (DTOPeriodo) colPeriodos.get(indicePeriodoEliminado-1);
                    dtoRecalculo =  new DTORecalculoPeriodos();
                    dtoRecalculo.setPais(new Long(this.pais));
                    dtoRecalculo.setCanal(new Long(this.canal));
                    dtoRecalculo.setMarca(new Long(this.marca));
                    dtoRecalculo.setPeriodo(periodoAnterior);
                    conectorParametroSesion(PERIODO_RECALCULO, dtoRecalculo);
                }
                break;
            }
        }
        conectorParametroSesion(PERIODOS, colPeriodos);
        this.actualizarLista(colPeriodos);
    }
  

    /**
    * Se invoca al conector para que elimine un periodo de la tabla Periodos   
    * ---> DEPRECATED. Ahora se utiliza la eliminacion con paginado por javascript.
    *
    */
    private void eliminar(DTOID dtoId) throws Exception {
        Vector paramEntrada = new Vector();
        dtoId.setPrograma(UtilidadesSession.getFuncion(this));
        dtoId.setIpCliente(UtilidadesBelcorp.getIPCliente(this));
        paramEntrada.add(dtoId);
        traza("antes de eliminar " + dtoId);
        paramEntrada.add(new MareBusinessID("CRAEliminaPeriodos"));
        DruidaConector conectorEliminaPeriodo = conectar("ConectorEliminaPeriodo", paramEntrada);
        traza("despues de eliminar " + dtoId);
    }


    /**
    * Solicita el recalculo a negocio.
    * Luego de eliminar periodos.
    */
    private void recalcularPeriodos() throws Exception {
        //Obtengo de la sesion todos los periodos y el periodo eliminado
        ArrayList listaDePeriodos = new ArrayList();
        DTOPeriodo dtoPeriodoDesde = null;

        //Tomamos la lista de periodos a recalcular.
        String listaPeriodosStr = conectorParametro("hListaPeriodos");
        listaPeriodosStr = (listaPeriodosStr == null) ? "" : listaPeriodosStr;
        traza("listaPeriodosStr: " + listaPeriodosStr);

        //Tomamos la lista de oidPeriodos eliminados
        String listaPeriodosEliminadosStr = conectorParametro("hPeriodosSeleccionados");
        listaPeriodosEliminadosStr = (listaPeriodosEliminadosStr == null) ? "" : listaPeriodosEliminadosStr;
        traza("listaPeriodosEliminadosStr: " + listaPeriodosEliminadosStr);

        //0-armo lista de periodos
        listaDePeriodos = this.armarListaPeriodos(listaPeriodosStr);
        traza("listaDePeriodos: " + listaDePeriodos);

        //1-obtengo la posicion en la lista desde donde recalcular
        Integer posicionDesde = this.posicionDesdeDondeRecalcular(listaDePeriodos, listaPeriodosEliminadosStr);
        traza("posicionDesde: " + posicionDesde);

        //2-filtrar los periodos eliminados
        listaDePeriodos = this.filtrarPeriodosEliminados(listaDePeriodos, listaPeriodosEliminadosStr);
        traza("listaDePeriodos filtrados: " + listaDePeriodos);

        //3-obtengo el periodo desde donde recalcular, de la lista de periodos filtrada
        if (posicionDesde != null) {
            dtoPeriodoDesde = (DTOPeriodo)listaDePeriodos.get(posicionDesde.intValue());
            traza("dtoPeriodoDesde: " + dtoPeriodoDesde);
        }

        //si existe un periodo desde donde recalcular
        if (dtoPeriodoDesde != null) {
            IMareDTO parametrosRecalcula = new MareDTO();
            DTORecalculoPeriodos dtoRecalculoPeriodos = new DTORecalculoPeriodos();
            dtoRecalculoPeriodos.setPeriodo(dtoPeriodoDesde);
            dtoRecalculoPeriodos.setPrograma(UtilidadesSession.getFuncion(this));
            dtoRecalculoPeriodos.setIpCliente(UtilidadesBelcorp.getIPCliente(this));

            parametrosRecalcula.addProperty("dtoRecalculoPeriodos", dtoRecalculoPeriodos);
            parametrosRecalcula.addProperty("listadoDePeriodos", listaDePeriodos);

            Vector paramEntrada = new Vector();
            paramEntrada.add(parametrosRecalcula);
            paramEntrada.add(new MareBusinessID("CRARecalculaPeriodos"));

            DruidaConector conectorRecalculaPeriodos = conectar("ConectorRecalculaPeriodos", paramEntrada);

            IMareDTO dtoSalida = (MareDTO) conectorRecalculaPeriodos.objeto("dtoSalida");
            listaDePeriodos = (ArrayList) dtoSalida.getProperty("listadoModificado");
        }    
        this.actualizarLista(listaDePeriodos);
        asignarAtributo("VAR","hAnio", "valor", this.anio);
        //ponemos la lista de periodos en sesion para luego grabar los cambios.
        conectorParametroSesion(PERIODOS, listaDePeriodos);
    }


    /**
     * Toma la lista actualizada y la refresca en la pantalla
     */
    private void actualizarLista(ArrayList listaDePeriodos) throws Exception {
        traza("ActualizarLista");
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
        asignar("LISTA", "listado1", drCon, "dtoSalida.periodos_ROWSET");
        asignarAtributo("VAR", "hListadoDisponible", "valor", "SI");
    }


    /**
    * Se graban los periodos recalculados para el anio seleccinado
    */
    private void grabarPeriodos() throws Exception {
        try {
            ArrayList listadoDePeriodos = (ArrayList)conectorParametroSesion(PERIODOS);    
            traza("listadoDePeriodos grabar " + listadoDePeriodos);

            if (listadoDePeriodos == null) {
            listadoDePeriodos = new ArrayList();
            }

            IMareDTO lista = new MareDTO();
            lista.addProperty("ListaDePeriodos", listadoDePeriodos);
            Vector paramEntrada = new Vector();
            paramEntrada.add(lista);
            paramEntrada.add(new MareBusinessID("CRAActualizaPeriodos"));
            traza("antes de CRAActualizaPeriodos");
            DruidaConector drd = conectar("ConectorModificaPeriodo", paramEntrada);
            traza("despues de CRAActualizaPeriodos");
        } catch (Exception ex) {
            logStackTrace(ex);
            this.lanzarPaginaError(ex);
            asignarAtributo("VAR","hPais", "valor", this.pais);
            asignarAtributo("VAR", "hPaisDescripcion", "valor", this.paisDescripcion);
            asignarAtributo("VAR","hMarca", "valor", this.marca);
            asignarAtributo("VAR","hCanal", "valor", this.canal);
            asignarAtributo("VAR","hAnio", "valor", this.anio);
            this.actualizarLista((ArrayList) conectorParametroSesion(PERIODOS));    
        }
    }
  

    /**
     * Retorna un ArrayList de dtoPeriodo.
     * Separa cada dtoPeriodo segun cantidad de columnas de la lista editable de periodos.
     */
    private ArrayList armarListaPeriodos(String listaPeriodosStr) throws Exception {
        traza("armarListaPeriodos, cu eliminar");
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
     * Retorna la posicin desde donde donde recalcular los periodos posteriores.
     * Retorna cero si se recalcula desde el principio.
     * Retorna null si no es necesario recalcular.
     * Retorna null si se eliminaron todos los periodos
     */
    private Integer posicionDesdeDondeRecalcular(ArrayList periodos, String peridosEliminadosStr) throws Exception {
        traza("obtenerPeriodoDesdeDondeRecalcular");
        int indicePeriodoEliminado = -1;
        Integer posicionDesde = null;
        //fijamos el caracter separador
        StringTokenizer str = new StringTokenizer(peridosEliminadosStr,",");
        
        //si no se eliminaron todos los periodos
        traza("periodos.size() :" + periodos.size() );
        traza("str.countTokens()) :" + str.countTokens() );
        if (periodos.size() != str.countTokens()) {

            //tomo el primer periodo eliminado
            Long oidPrimerPeriodoEliminado = new Long(str.nextToken());

            //buscamos el primer periodo eliminado y obtenemos su posicion en la lista 
            Iterator iter = periodos.iterator();
            while ( iter.hasNext() && (posicionDesde == null) ) {
                DTOPeriodo periodo = (DTOPeriodo) iter.next();
                if (periodo.getOid().equals(oidPrimerPeriodoEliminado)) {
                    indicePeriodoEliminado = periodos.indexOf(periodo);
                    traza("indicePeriodoEliminado: " + indicePeriodoEliminado);
                    //Si el periodo eliminado no es el primero de la lista o el ultimo
                    if ( ! ((indicePeriodoEliminado == 0) || (indicePeriodoEliminado == (periodos.size()-1))) ) {
                        //obtenemos la posicion anterior a la del primer periodo eliminado
                        posicionDesde = new Integer(indicePeriodoEliminado-1);
                    } else {
                        // si el periodo eliminado es el primero
                        if (indicePeriodoEliminado == 0) {
                            posicionDesde = new Integer(0);
                        }
                    }
                }
            }
        }
        return posicionDesde;
    }


    /**
     * Retorna un ArrayList con los periodos, excluyendo los que fueron eliminados.
     * Precondicion: se sabe que ambas listas esta en el mismo orden
     */
    private ArrayList filtrarPeriodosEliminados(ArrayList periodos, String peridosEliminadosStr) throws Exception {
        traza("filtrarPeriodosEliminados");
        boolean encontre = false;
        StringTokenizer str = new StringTokenizer(peridosEliminadosStr,",");
        //recorremos los oidPeriodos eliminados
        while (str.hasMoreTokens()) {
            //obtenemos el oidPeriodo eliminado
            Long oidPeriodoEliminado = new Long(str.nextToken());
            //recorremos la lista de periodos
            encontre = false;
            Iterator iter = periodos.iterator();
            while(iter.hasNext() && (!encontre)) {
                DTOPeriodo periodo = (DTOPeriodo) iter.next();
                traza("oidPeriodo eliminado: " + oidPeriodoEliminado);
                if (periodo.getOid().equals(oidPeriodoEliminado)) {
                    encontre = true;
                    //eliminamos el periodo
                    periodos.remove(periodo);
                }
            }
        }
        return periodos;
    }


    /**
    * Borra de la sesion los periodos y el periodo para recalculo
    */
    private void borrarDatosSesion() throws Exception {
        conectorParametroSesion(PERIODOS, new ArrayList());
        conectorParametroSesion(PERIODO_RECALCULO, new DTORecalculoPeriodos());
    }


    /**
     * Retorna un nuevo Document.
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
