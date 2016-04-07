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
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.cra.util.TADMatrizDias;
import es.indra.sicc.dtos.cra.DTOMatrizDias;
import es.indra.sicc.dtos.cra.DTOGrupoMatriz;
import es.indra.sicc.dtos.cra.DTOActividadMatriz;
import es.indra.sicc.dtos.cra.DTOActividad;
import es.indra.sicc.dtos.seg.DTOFiltroPMC;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.dtos.cra.DTOGrupoZonas;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mln.MareBusinessID;
import java.util.Vector;
import java.util.Iterator;
import java.util.StringTokenizer;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.util.xml.XMLDocument;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;


/**
 * Sistema:           Belcorp
 * Modulo:            CRA
 * Submódulo:         Mantenimiento Matriz de Dias en Modo Grafico y No Grafico
 * Componente:        Logica de Presentacion
 * Fecha:             17/05/2004
 * Observaciones:     Componente construido de acuerdo a la especificación del 
 *                    Modelo de Componentes SICC-DMCO-CRA-001-321
 * @version           1.0
 * @autor             Gustavo De Marzi
 */

 // Definicion de la clase
public class LPMantieneMatrizDias extends LPUtilidadesMatrizDias {
    protected static final String SI = "si";
    private String sesionMatriz = "craMatrizDias";
    private String accion = null;
    private String idioma = null;
    private String paisDescripcion = null;
    private String pais = null;
    private String marca = null;
    private String canal = null;
    private String mostrarCreada = null;

    // Definicion del constructor
    public LPMantieneMatrizDias() {
        super();
    }


    // Definicion del metodo abstracto inicio
    public void inicio() throws Exception {
        // Defino el nombre de la vista
        pagina("contenido_matriz_dias_grafico_insertar");
    }


    // Definicion del metodo abstracto ejecucion
    public void ejecucion() throws Exception {
        // 0.- Obtenemos la accion el pais, el idioma, la marca y el canal.
        this.obtenerAccionPaisIdiomaMarcaCanal();

        // 1.- Capta la matriz de sesión: 
        this.captarMatrizDeSesion();

        // 2.- Recoge modo y el componente de la matriz: 
        this.obtenerModosComponentes();

        // 3.- Ejecuta la acción: 
        try {
            if (accion.equals("creaGrafica")) {
                this.muestra(true, true); 
                
            } else if (accion.equals("creaNoGrafica")) {
                this.muestra(true, false);
                
            } else if (accion.equals("modificaGrafica")) {
                this.muestra(false, true);
                
            } else if (accion.equals("modificaNoGrafica")) {
                this.muestra(false, false);
                
            } else if (accion.equals("consulta")) {
                this.muestraConsulta();

            } else if (accion.equals("consultar")) {
                this.consultaMatriz();

            } else if (accion.equals("insertaGrupo")) {
                this.insertaGrupos();

            } else if (accion.equals("verMatriz")) {
                this.cambiaVistaMatriz();

            } else if (accion.equals("buscar")) {
                this.busca();
                if ( modoCrerModificar.equals(MODO_MODIFICAR) )
                    this.vistaMatriz();

            } else if (accion.equals("insertaActividad")) {
                this.insertaActividad();

            } else if (accion.equals("guardar")) {
                this.guardaMatriz();
                
            } else if (accion.equals("eliminar")) {
                this.eliminaActividad();

            } else if (accion.equals("modificar")) {
                this.modificaActividad();

            } else if (accion.equals("guardaModificacion")) {
                this.guardaModificacion();
                
            } else if (accion.equals("refrescaModificacion")) {
                this.refrescaModificacion();
                
            }
            getTituloPagina();
            getConfiguracionMenu();
            
        } catch (Exception ex ) {
			logStackTrace(ex);
            this.lanzarPaginaError(ex);
            asignarAtributo("VAR","hIdioma", "valor", this.idioma);
            asignarAtributo("VAR","hPais", "valor", this.pais);
            asignarAtributo("VAR","hPaisDescripcion", "valor", this.paisDescripcion);
            asignarAtributo("VAR","hMarca", "valor", this.marca);
            asignarAtributo("VAR","hCanal", "valor", this.canal);
            asignarAtributo("VAR","varModo","valor",this.modoCrerModificar);
            asignarAtributo("VAR","varTipo","valor",this.modoGrafico);
            this.recargaPostError(ex);
        }
    }


    /**
     * Obtiene la accion, el pais, el idioma, la marca y el canal.
     */
    private void obtenerAccionPaisIdiomaMarcaCanal() throws Exception {
        //manejo de traza
        this.setTrazaFichero();

        //Obtiene la pagina consulta o insercion/modificacion
        accion = conectorParametro("accion");
        if (accion.equals("consulta") || accion.equals("consultar")) {
            traza(" Pagina Consultar ");
            pagina("contenido_matriz_dias_grafico_consultar");
        } else {
            traza(" Pagina Insertar ");
            pagina("contenido_matriz_dias_grafico_insertar");
        }

        //Obtiene accion       
        this.accion = conectorParametro("accion");
        if (this.accion==null) this.accion = "";
        asignarAtributo("VAR","accion","valor",accion);
        traza("accion: " + this.accion);

        //Obtiene idioma
        this.idioma = conectorParametro("hIdioma"); 
        if ((this.idioma == null) || ((this.idioma != null) && this.idioma.equals(""))) {
            this.idioma = (UtilidadesSession.getIdioma(this)).toString();
    		traza("idioma:  " + this.idioma);
            asignarAtributo("VAR", "hIdioma", "valor", this.idioma);
        }

        //Obtiene el pais
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

        //Obtiene marca y canal
        this.marca  = conectorParametro("hMarca");
        this.canal  = conectorParametro("hCanal");
        traza("marca: " + this.marca);
        traza("canal: " + this.canal);
        this.marca  = (this.marca == null) ? "" : this.marca;
        this.canal  = (this.canal == null) ? "" : this.canal;
        asignarAtributo("VAR", "hMarca", "valor", this.marca);
        asignarAtributo("VAR", "hCanal", "valor", this.canal);
    }


    /**
     * Obtiene modoGrafico, modoCreacionModificacion y componentesGraficos.
     */
    private void obtenerModosComponentes() throws Exception {
        //modo grafico
        modoGrafico = conectorParametro("varTipo");
        traza("modoGrafico: " + modoGrafico);
        this.modoGrafico = (this.modoGrafico == null) ? "" : this.modoGrafico;        
        asignarAtributo("VAR", "varTipo", "valor", this.modoGrafico);

        //modo crearModificar
        modoCrerModificar = conectorParametro("varModo");
        traza("modoCrerModificar: " + modoCrerModificar);
        this.modoCrerModificar  = (this.modoCrerModificar == null) ? "" : this.modoCrerModificar;
        asignarAtributo("VAR", "varModo", "valor", this.modoCrerModificar);

        //mostrarCreada
        mostrarCreada = conectorParametro("hMostrarCreada");
        traza("mostrarCreada: " + mostrarCreada);
        this.mostrarCreada =  (this.mostrarCreada == null) ? "" : this.mostrarCreada;        
        asignarAtributo("VAR", "hMostrarCreada", "valor", this.mostrarCreada);

        //componentes
        componenteGrafico = "rejMatrizDias"; 
        listaFueraPeriodo = "lstFueraPeriodo"; 
        componenteGraficoDos = "rejMatrizDiasNoGrafica";
    }


    private void captarMatrizDeSesion() throws Exception {
        traza("conectorParametroSesion(sesionMatriz): " + conectorParametroSesion(sesionMatriz));
        // si va a buscar una nueva matriz
        if ( accion.equals("buscar") ) {
            //se esta por crear el tadMatriz (solo se crea una vez)
            tadMatriz = new TADMatrizDias(new Long(this.pais), new Long(this.marca), new Long(this.canal));
            traza("tadMatriz creada: " + tadMatriz.getMatrizDias() );
        } else {
            // si ya tengo una matriz en sesion
            if (conectorParametroSesion(sesionMatriz) != null) {
                //tomamos la matriz de sesion (solo se crea una vez)
                tadMatriz = (TADMatrizDias)conectorParametroSesion(sesionMatriz); 
                traza("tadMatriz sesion: " + tadMatriz.getMatrizDias() );
            } else {
                traza("No esta tomando la matriz de sesion.");
            }
        }
    }


    /**
     * Setea el titulo de la pagina de acuerdo al modoCrerModificar.
     */
    private void getTituloPagina() throws Exception {
        traza("getTituloPagina modo: " + modoCrerModificar );
        // Setea el titulo de la pagina
        if (modoCrerModificar.equalsIgnoreCase(MODO_CREAR)) {
            // Crear matriz de días
            asignarAtributoPagina("cod","0663");
        } else if (modoCrerModificar.equalsIgnoreCase(MODO_MODIFICAR)) {
            // Modificar matriz de días
            asignarAtributoPagina("cod","0664");
        }
    }
    

    /**
     * Muestra el pais, carga el combo de marcas y el combo canales.
     * Muestra la pagina PantallaCrearMatrizDias.
     */
    private void muestra(boolean esCrear, boolean esGrafica) throws Exception {
        traza("metodo muestra " + esCrear + " " + esGrafica );
        //1.- 2.- carga pais, marcas y canales
        this.cargarPaisMarcaCanal();

        //3.- Deshabilita el botón btnBuscar 

        //4.- Setea los modo creacion/modificacion y garfica/nografica 
        if (esCrear) {
            asignarAtributo("VAR", "varModo", "valor", MODO_CREAR);
            this.modoCrerModificar = MODO_CREAR;
        } else {
            asignarAtributo("VAR", "varModo", "valor", MODO_MODIFICAR);
            this.modoCrerModificar = MODO_MODIFICAR;
        }
        if (esGrafica) {
            asignarAtributo("VAR", "varTipo", "valor", TIPO_GRAFICA);
            this.modoGrafico = TIPO_GRAFICA;
        } else {
            asignarAtributo("VAR", "varTipo", "valor", TIPO_NOGRAFICA);
            this.modoGrafico = TIPO_NOGRAFICA;
        }
    }


    /**
     * Muestra el pais, carga el combo de marcas y el combo canales.
     * Muestra la pagina PantallaConsultarMatrizDias 
     */
    private void muestraConsulta() throws Exception {
        traza("metodo muestraConsulta");
        // 0.- Pagina Consulta MatrizDias
        pagina("contenido_matriz_dias_grafico_consultar");

        // 1.- 2.- carga pais, marcas y canales
        if (accion.equals("consulta")) {
            // carga pais marca canal, los gruposZonas se cargan por recargaCombo
            this.cargarPaisMarcaCanal();
        } else {
            // ya selecciono marca y canal, entonces tambiem cargo los gruposZonas
            this.cargarPaisMarcaCanalGrupos();
        }

        // 3.- Deshabilita el botón btnBuscar 

        // 4.- varTipo = TIPO_CONSULTA 
        asignarAtributo("VAR", "varTipo", "valor", TIPO_CONSULTA);
        this.modoGrafico = TIPO_CONSULTA;

        // 5.- Muestra la pagina PantallaConsultarMatrizDias  
    }


    /**
     * Carga el combo de Grupos Zonas, el combo de Actividades y el combo de Grupos Zonas Seleccionados.
     * Obtiene la Matriz Dias y la guarda en sesion.
     * Ademas recarga el pais, el combo de marcas y el combo de canales.       
     * La busqueda es utilizada desde la PantallaCrearMatrizDias.     
     */
    private void busca() throws Exception {
        traza("metodo busca");
        // 1.a.- Obtengo DTOMatrizDias de la matrizDias recien creada
        DTOMatrizDias dtoMatrizDias = tadMatriz.getMatrizDias();
        dtoMatrizDias.setOidIdioma(new Long(this.idioma));
        dtoMatrizDias.setOidPais(new Long(this.pais));
        dtoMatrizDias.setMarca(new Long(this.marca));
        dtoMatrizDias.setCanal(new Long(this.canal));

        // 1.b.- Crea un DTOActividad
        DTOActividad dtoActividad = new DTOActividad();
        dtoActividad.setOidIdioma(new Long(this.idioma));
        dtoActividad.setOidPais(new Long(this.pais));
        dtoActividad.setOidMarca(new Long(this.marca));
        dtoActividad.setOidCanal(new Long(this.canal));

        // 1.c - Crea un DTOBelcorp para marcas y canales
        DTOBelcorp dtoBelcorp = new DTOBelcorp();
        dtoBelcorp.setOidPais(new Long(this.pais));
        dtoBelcorp.setOidIdioma(new Long(this.idioma));

        // 2.- Crea una lista ComposerViewElementList conConsultar 
        ComposerViewElementList cvLista = new ComposerViewElementList();

        // 3.a.- Crea un elemento de tipo ComposerViewElement() para cargar los gruposZonas 
        ComposerViewElement cvGruposZonas = new ComposerViewElement();
        cvGruposZonas.setIDBusiness("CRAObtieneGruposFueraMatriz");
        cvGruposZonas.setDTOE(dtoMatrizDias);
        cvLista.addViewElement(cvGruposZonas);

        // 3.b.- Crea un elemento de tipo ComposerViewElement() para cargar los actividades
        ComposerViewElement cvActividades = new ComposerViewElement();
        cvActividades.setIDBusiness("CRAObtieneActividad");
        cvActividades.setDTOE(dtoActividad);
        cvLista.addViewElement(cvActividades);

        // 3.c.- Crea un elemento de tipo ComposerViewElement() para cargar las marcas
        ComposerViewElement cvMarcas = new ComposerViewElement();
        cvMarcas.setIDBusiness("SEGConsultaMarcas");
        cvMarcas.setDTOE(dtoBelcorp);
        cvLista.addViewElement(cvMarcas);

        // 3.d.- Crea un elemento de tipo ComposerViewElement() para cargar los canales
        ComposerViewElement cvCanales = new ComposerViewElement();
        cvCanales.setIDBusiness("SEGConsultaCanales");
        cvCanales.setDTOE(dtoBelcorp);
        cvLista.addViewElement(cvCanales);

        // 4.- Invoca al subsistema GestorCargaPantalla o CargaInicial
        traza("carga inicial");
        ConectorComposerView conector = new ConectorComposerView(cvLista, this.getRequest());
        conector.ejecucion();
        DruidaConector conConsultar = conector.getConector();

        // 5.a.- Cragamos los combos con los resultados
        traza("asginacion combos");
        asignarAtributo("CAPA", "capaSeleccion", "visibilidad", "visible");
        asignar("COMBO", "cbGrupoDeZonas", conConsultar, "CRAObtieneGruposFueraMatriz"); 
		asignar("COMBO", "cbActividades", conConsultar, "CRAObtieneActividad");
		asignar("COMBO", "cbMarcas", conConsultar, "SEGConsultaMarcas"); 
		asignar("COMBO", "cbCanales", conConsultar, "SEGConsultaCanales");
		traza("combos cargados por carga inicial");

        // 5.b.- Pasa los viejos valores seleccionados (si existen).
        traza("mantenemos valores actuales");
        asignarAtributo("VAR", "hIdioma", "valor", this.idioma);
        asignarAtributo("VAR", "hPais", "valor", this.pais);
        asignarAtributo("VAR", "hPaisDescripcion", "valor", this.paisDescripcion);
        asignarAtributo("VAR", "hMarca", "valor", this.marca);
        asignarAtributo("VAR", "hCanal", "valor", this.canal);
        asignarAtributo("VAR", "hOidsGruposAnyadir", "valor", conectorParametro("hOidsGruposAnyadir"));
        asignarAtributo("VAR", "hOidsGruposAnyadirMatriz", "valor", conectorParametro("hOidsGruposAnyadirMatriz"));
        asignarAtributo("VAR", "hOidActividadAnyadirMatriz", "valor", conectorParametro("hOidActividadAnyadirMatriz"));

        // 5.c.- Muestra el nombre del pais activo en el campo lblPais.
        asignarAtributo("LABELC","lblValorPais","valor",this.paisDescripcion);

        // 6.- Asignamos el modo crear/modificar al dtoMatrizDias
        traza("modoCrerModificar: " + modoCrerModificar);
        String varModo = modoCrerModificar; 
        if (varModo.equals(MODO_CREAR)) { 
            dtoMatrizDias.setEsCrear(new Boolean(true)); 
        }
        if (varModo.equals(MODO_MODIFICAR) || mostrarCreada.equals(this.SI)) {
            dtoMatrizDias.setEsCrear(new Boolean(false));
        }
        asignarAtributo("VAR","varModo","valor",this.modoCrerModificar);
        asignarAtributo("VAR","varTipo","valor",this.modoGrafico);

        /* Solo obtengo la matrizDias si la accion es "buscar", sino ya la tengo en sesion */
        if (accion.equalsIgnoreCase("buscar")) {
            // 7.- Se crea idNegocio = "CRAObtieneMatrizDias" y uso el DTOMatrizDias 
            Vector paramEntrada = new Vector();
            paramEntrada.add(dtoMatrizDias);
            paramEntrada.add(new MareBusinessID("CRAObtieneMatrizDias"));
            traza("CRAObtieneMatrizDias dtoMatrizDias: " + dtoMatrizDias);

            // 8.- Se invoca al conector ConectorObtieneMatrizDias
            DruidaConector conectorObtieneMatrizDias = conectar("ConectorObtieneMatrizDias", paramEntrada);
            traza("despues de CRAObtieneMatrizDias");

            // 9.- El dto DTOMatrizDias que obtiene lo llamamos dtoMatrizDiasSalida 
            DTOMatrizDias dtoMatrizDiasSalida = (DTOMatrizDias) conectorObtieneMatrizDias.objeto("dtoMatrizDiasSalida");
            traza("dtoMatrizDiasSalida: " + dtoMatrizDiasSalida);

            // 10.a.- Asignamos el tadMatrizDias con el dtoMatrizDiasSalida obtenido
            tadMatriz.setMatrizDias(dtoMatrizDiasSalida); 
            traza("tadMatriz.getMatrizDias(): " + tadMatriz.getMatrizDias());
        }

        // 10.b.- Se carga el cmbGrupoSeleccionado llamada a tadMatriz.obtieneRecordSetGruposZona()
        RecordSet rsGruposSeleccionados = new RecordSet();
        rsGruposSeleccionados = tadMatriz.obtieneRecordSetGruposZona();
        traza("rsGruposSeleccionados" + rsGruposSeleccionados);
        rsGruposSeleccionados.sortByColumn(rsGruposSeleccionados.getColumnPosition("descripcion"), true);
        DruidaConector conectorGruposSeleccionados = this.generaConector(rsGruposSeleccionados, "dtoSalida.gruposzonas_ROWSET", "oid", "descripcion");
        asignar("COMBO", "cbGrupoDeZonasSeleccionados", conectorGruposSeleccionados, "dtoSalida.gruposzonas_ROWSET"); 

        // 11.- Introduce la matriz en sesión
        conectorParametroSesion(sesionMatriz, tadMatriz);

        // 12.- Si (varModo == MODO_MODIFICAR) invoca a vistaMatriz(). 
        // Pasamos esto a la accion "buscar",´porque este metodo se usa desde otras acciones.
    }


    /**
     * Obtiene la Matriz Dias y la guarda en sesion.
     * La busqueda es utilizada desde la PantallaConsultarMatrizDias .     
     */
    private void consultaMatriz() throws Exception {
        traza("metodo consultaMatriz");
        /* 1.- Crear un DTOMatrizDias dtoMatrizDias con: */
        // 1.a.- Setamos idioma pais marca canal y esCrear en false.
        DTOMatrizDias dtoMatrizDias = new DTOMatrizDias();
        dtoMatrizDias.setOidIdioma(new Long(this.idioma));
        dtoMatrizDias.setOidPais(new Long(this.pais));
        dtoMatrizDias.setMarca(new Long(this.marca));
        dtoMatrizDias.setCanal(new Long(this.canal));
        dtoMatrizDias.setEsCrear(new Boolean(false));
        // 1.b.- Se crean tantos elementos DTOGrupoMatriz en dtoMatrizDias.grupos como elementos estén seleccionados en cbGrupoDeZonas 
        // y tan sólo se rellena el atributo grupoZona de cada uno con el oid del elemento seleccionado.
        String oidsGruposZonas = conectorParametro("hGruposZonas");
        StringTokenizer oidsGruposZonasTk = new StringTokenizer(oidsGruposZonas,",");
        Vector vecGruposMatriz = new Vector();
        while (oidsGruposZonasTk.hasMoreTokens()) {
            DTOGrupoMatriz dtoGrupoMatriz = new DTOGrupoMatriz();
            Long oidGrupoZona = new Long(oidsGruposZonasTk.nextToken());
            dtoGrupoMatriz.setGrupoZona(oidGrupoZona);
            traza("oidGrupoZona: " + oidGrupoZona);
            vecGruposMatriz.add(dtoGrupoMatriz);
        }
        dtoMatrizDias.setGrupos(vecGruposMatriz);

        // 2.- Se crea idNegocio = "CRAObtieneMatrizDias" ; 
        Vector paramEntrada = new Vector();
        paramEntrada.add(dtoMatrizDias);
        paramEntrada.add(new MareBusinessID("CRAObtieneMatrizDias"));
        traza("CRAObtieneMatrizDias dtoMatrizDias: " + dtoMatrizDias);

        // 3.- Se invoca al conector ConectorObtieneMatrizDias; 
        DruidaConector conectorObtieneMatrizDias = conectar("ConectorObtieneMatrizDias", paramEntrada);
        traza("despues de CRAObtieneMatrizDias");

        // 4.- El dto DTOMatrizDias que obtiene lo llamamos dtoMatrizDiasSalida. 
        DTOMatrizDias dtoMatrizDiasSalida = (DTOMatrizDias) conectorObtieneMatrizDias.objeto("dtoMatrizDiasSalida");
        traza("dtoMatrizDiasSalida: " + dtoMatrizDiasSalida);

        // 5.- tadMatriz = new TADMatrizDias(dtoS); 
        tadMatriz = new TADMatrizDias(new Long(this.pais), new Long(this.marca), new Long(this.canal));
        traza("tadMatriz consulta creada: " + tadMatriz.getMatrizDias() );
        tadMatriz.setMatrizDias(dtoMatrizDiasSalida); 
        traza("tadMatriz.getMatrizDias(): " + tadMatriz.getMatrizDias());

        // 6.- Introduce la matriz en sesión: getSessionCache().put(sesionMatriz,dtoS); 
        conectorParametroSesion(sesionMatriz, tadMatriz);

        //7.- vistaMatriz(); 
        this.muestraConsulta();
        this.vistaMatriz();
    }


    /**
     * Cambia de tipo de vista de la matriz y la genera. 
     */
    private void cambiaVistaMatriz() throws Exception {
        // 1.- Cambia el tipo de vista de la pantalla: 
        if (modoGrafico.equals(TIPO_GRAFICA)) {
            asignarAtributo("VAR", "varTipo", "valor", TIPO_NOGRAFICA);
            this.modoGrafico = TIPO_NOGRAFICA;
        } else {
            asignarAtributo("VAR", "varTipo", "valor", TIPO_GRAFICA);
            this.modoGrafico = TIPO_GRAFICA;
        }
        // 2.- Genera la matriz: invoca a vistaMatriz() 
        this.busca();
        this.vistaMatriz();
        // 3.- Cambia el título del botón btnVerMatriz. (Cambio la capa visible)
        // Se cambia de capa en vistaMatriz() con lo cual cambia el boton        
    }


    /**
     * Añade una actividad más sus referencias a la matriz de días. 
     */
    private void insertaActividad() throws Exception {
        traza("metodo insertaActividad");
        DTOGrupoMatriz dtoGrupoMatrizSalida = null;
        //obtenemos los grupos de zonas seleccionados a anyadir en la matriz
        String oidsGruposAnyadirMatriz = conectorParametro("hOidsGruposAnyadirMatriz");
        //obtenemos los grupos de zonas con tokens
        StringTokenizer oidsGruposAnyadirMatrizTk = new StringTokenizer(oidsGruposAnyadirMatriz,",");
        //obtenemos la actividad seleccionada para anyadir en la matriz
        String oidActividadAnyadirMatriz = conectorParametro("hOidActividadAnyadirMatriz");

        /* A) Por cada uno de los grupos seleccionados en cmbGrupoSeleccionado */
        Vector vecGruposMatriz = new Vector();
        while (oidsGruposAnyadirMatrizTk.hasMoreTokens()) {
            // 1.- Se crea un vector de DTOGrupoMatriz por cada grupoZonaSelecciondo
            DTOGrupoMatriz dtoGrupoMatriz = new DTOGrupoMatriz();
            //un oidGrupoZona seleccionado de cmbGrupoSeleccionado 
            Long oidGrupoZona = new Long(oidsGruposAnyadirMatrizTk.nextToken());
            dtoGrupoMatriz.setGrupoZona(oidGrupoZona);       
            traza("oidGrupoZona: " + oidGrupoZona);
            //actividades = null 
            dtoGrupoMatriz.setActividades(new Vector());
            //oidActividad seleccionado de cbActividad
            Long oidActividad = new Long(oidActividadAnyadirMatriz);
            dtoGrupoMatriz.setActividad(oidActividad);
            traza("oidActividad: " + oidActividad);
            dtoGrupoMatriz.setOidIdioma(new Long(this.idioma));

            // 2.- Se crea idNegocio = "CRAObtieneReferenciadas" 
            Vector paramEntrada = new Vector();
            paramEntrada.add(dtoGrupoMatriz);
            paramEntrada.add(new MareBusinessID("CRAObtieneReferenciadas"));
            traza("CRAObtieneReferenciadas dtoGrupoMatriz: " + dtoGrupoMatriz);

            // 3.- Se invoca a ConectorObtieneReferenciadas 
            DruidaConector conectorObtieneReferenciadas = conectar("ConectorObtieneReferenciadas", paramEntrada);
            traza("despues de ConectorObtieneReferenciadas");

            // 4.- Devuelve un DTOGrupoMatriz dtoGrupoMatrizSalida 
            dtoGrupoMatrizSalida = (DTOGrupoMatriz) conectorObtieneReferenciadas.objeto("dtoGrupoMatrizSalida");
            traza("dtoGrupoMatrizSalida: " + dtoGrupoMatrizSalida);

            // 5.- Si la actividad genera un ciclo lanza error de negocio 180800008
            if (this.generaCiclo(dtoGrupoMatrizSalida)) {
                // 180800008 "No se puede realizar la operación ya que se está creando una dependencia cíclica. ..."
                throw new MareException(new Exception(), 180800008);
            }
            
            // 6.- Se invoca a insertaActividades(dtoGrupoMatrizSalida)
            this.insertaActividades(dtoGrupoMatrizSalida);
        }
        // 7.- vistaMatriz(tadMatriz)
        this.vistaMatriz();   

        // 8.- Recargamos la pagina
        this.busca();
    }


    /**
     * Inserta los grupos seleccionados en el combo cmbGrupo a la matriz de días.     
     */
    private void insertaGrupos() throws Exception {
        traza("metodo insertaGrupos");
        //obtenemos los grupos de zonas a anyadir
        String oidsGruposAnyadir = conectorParametro("hOidsGruposAnyadir");
        String nombresGruposAnyadir = conectorParametro("hNombresGruposAnyadir");
        //obtenemos los grupos de zonas con tokens
        StringTokenizer oidsGruposAnyadirTk = new StringTokenizer(oidsGruposAnyadir,",");
        StringTokenizer nombresGruposAnyadirTk = new StringTokenizer(nombresGruposAnyadir,",");

        // 1.- Se crea un vector de DTOGrupoMatriz por cada grupoZona y asignamos
        Vector vecGruposMatriz = new Vector();
        while (oidsGruposAnyadirTk.hasMoreTokens()) {
            //nuevo dtoGrupoMatriz
            DTOGrupoMatriz dtoGrupoMatriz = new DTOGrupoMatriz();
            //oidGrupoZona
            Long oidGrupoZona = new Long(oidsGruposAnyadirTk.nextToken());
            dtoGrupoMatriz.setGrupoZona(oidGrupoZona);       
            traza("oidGrupoZona: " + oidGrupoZona);
            //nombreGrupoZona
            String nombreGrupoZona = nombresGruposAnyadirTk.nextToken();
            dtoGrupoMatriz.setTextoGrupo(nombreGrupoZona);       
            traza("nombreGrupoZona: " + nombreGrupoZona);
            //actividades = null 
            dtoGrupoMatriz.setActividades( new Vector());
            //actividad = null 
            dtoGrupoMatriz.setActividad(null);
            //agregamos el grupoZona al vector
            vecGruposMatriz.add(dtoGrupoMatriz);
        }
        // 2.- Se invoca a super.insertaGrupos(vecGruposMatriz);
        this.insertaGrupos(vecGruposMatriz);

        // 3.- Recargamos la pagina, actualizando el cbGruposZonasSeleccionados
        this.busca();
    }


    /**
     * Guarda la matriz de días en base de datos.
     */
    private void guardaMatriz() throws Exception {
        // 0.- Pagina Salida Generica para usar el formulario oculto
        //pagina("salidaGenerica");   //sin envio oculto, necesita recarga
        
        // 1.- DTOMatrizDias dtoe = tadMatriz.getMatrizDias();
        DTOMatrizDias dtoMatrizDias = tadMatriz.getMatrizDias();
        dtoMatrizDias.setIpCliente(UtilidadesBelcorp.getIPCliente(this));
        dtoMatrizDias.setPrograma(UtilidadesSession.getFuncion(this));
        // 2.- Se crea idNegocio="CRAActualizaMatrizDias" 
        MareBusinessID idNegocio = new MareBusinessID("CRAActualizaMatrizDias");
        Vector parametros = new Vector();
        parametros.add(dtoMatrizDias);
        parametros.add(idNegocio);
        traza("CRAActualizaMatrizDias dtoMatrizDias: " + dtoMatrizDias);
        // 3.- Se invoca a ConectorActualizaMatrizDias
        DruidaConector conectorActualizaMatrizDias = conectar("ConectorActualizaMatrizDias", parametros);
        traza("despues de CRAActualizaMatrizDias");
        // 4.- Recargamos la pagina dependiendo del modoCrerModificar 
        this.recargaPostGrabar();
    }


    /**
     * Elimina una actividad de la matriz de días. 
     */
    private void eliminaActividad() throws Exception {
        traza("metodo eliminaActividad");
        //1.- Se coge el idVista de la actividad seleccionada en la rejilla de la matriz de días (rejMatrizDias). 
        String idVistaActividad = conectorParametro("hActividadSeleccionada");

        //2.- Se invoca a eliminaActividad(idVista)        
        this.eliminaActividad(new Integer(idVistaActividad));
        traza("Matriz luego de eliminaActividad: " + tadMatriz.getMatrizDias());

        // 3.- Recargamos la pagina, actualizando el cbGruposZonasSeleccionados
        this.busca();
    }


    /**
     * Muestra la pantalla para modificar una actividad de la matriz de días. 
     */
    private void modificaActividad() throws Exception {
        traza("metodo modificaActividad");
        // tomo los modos pasados por parametro
        this.modoCrerModificar = conectorParametro("varModo");
        this.modoGrafico = conectorParametro("varTipo");
        
        // 0.- Pagina modificar actividad
        pagina("contenido_mdg_actividad_modificar");

        // 1.- Se coge el idVista de la actividad seleccionada en la rejilla de la matriz de días (rejMatrizDias). 
        String idVistaActividadModificar = conectorParametro("idVistaActividadModificar");
        traza("idVistaActividadModificar: "   + idVistaActividadModificar);

        // 2.- Se invoca a modificaActividad(idVista)
        this.modificaActividad(new Integer(idVistaActividadModificar));
    }


    /**
     * Modifica una actividad de la matriz de días. 
     */
    private void guardaModificacion() throws Exception {
        traza("metodo guardaModificacion");
        // 0.- Pagina Salida Generica para usar el formulario oculto
        pagina("salidaGenerica");
        
        // 1.- Se instancia un objeto DTOActividadMatriz que llamamos actividad 
        // y se rellena con los datos de la pantalla PantallaModificarActividades del siguiente modo: 
        DTOActividadMatriz actividad = new DTOActividadMatriz();

        // 1.a.- cmbTipoActividad: combo con dos valores posibles: {[0,"Sin actividad origen"], [1,"Referenciada"]} 
        String tipoActividad = conectorParametro("cbTipoActividad");
        traza("tipoActividad: " + tipoActividad);
		//enozigli 06/12/2007 cra1
        if (tipoActividad.equals("1")) {
            // esta seleccionado 1 (referenciada), - actividad.origen <- cmbActividadOrigen 
            String actividadOrigen = conectorParametro("cbActividadDeOrigen");
            traza("actividadOrigen: " + actividadOrigen);
			String txtActOrigen = conectorParametro("hTextoActOrigen");
			actividad.setTextoActOrigen(txtActOrigen);
            actividad.setOrigen(new Long(actividadOrigen));
        } else  if (tipoActividad.equals("2")) {
            // esta seleccionado 1 (referenciada), - actividad.origen <- cmbActividadOrigen 
            String actividadOrigen = conectorParametro("cbActividadDeOrigen");
            traza("actividadOrigen: " + actividadOrigen);
            actividad.setOrigen(new Long(actividadOrigen));
			String txtActOrigen = conectorParametro("hTextoActOrigen");
			actividad.setTextoActOrigen(txtActOrigen);
            traza("txtActOrigen: " + txtActOrigen);
			String campDes = conectorParametro("txtCampDesp");
			traza("campDes: " + campDes);
			actividad.setCampDesplazamiento(Integer.valueOf(campDes));
		} else {
            // esta selecionado 0 (sin actividad origen), - actividad.origen <- null
            actividad.setOrigen(null);
        }
		//enozigli 06/12/2007 cra1

        // 1.b.- chkRepetitiva: 
        String repetitiva = conectorParametro("chkRepetitiva");
        traza("repetitiva: " + repetitiva);
        if (repetitiva.equalsIgnoreCase("S")) {
            //- actividad.diasFinal <- txtFechaFinal 
            String diasFinal = conectorParametro("txtFechaFinal");
            traza("diasFinal: " + diasFinal);
            actividad.setDiasFinal((diasFinal.equals("")) ? new Long(0) : new Long(diasFinal));
            //- actividad.diasIntervalo <- txtCadaCuantosDias 
            String diasIntervalo = conectorParametro("txtCadaCuantosDias");
            traza("diasIntervalo: " + diasIntervalo);
            actividad.setDiasIntervalo((diasIntervalo.equals("")) ? new Long(0) : new Long(diasIntervalo));
        } else {
            //- actividad.diasFinal = 0 
            actividad.setDiasFinal(new Long(0));
            //- actividad.diasIntervalo = 0 
            actividad.setDiasIntervalo(new Long(0));
        }

        // 1.c.- actividad.dia <- txtDiasDeDesplazamiento 
        String dias = conectorParametro("txtDiasDeDesplazamiento");
        traza("dias: " + dias);
        actividad.setDia(new Long(dias));

        //1.d.- actividad.actividad <- varActividad
        String oidActividad = conectorParametro("hVarActividad");
        traza("oidActividad: " + oidActividad);
        actividad.setActividad(new Long(oidActividad));
        // 1.e.- actividad.grupo <- varGrupo 
        String oidGrupo = conectorParametro("hVarGrupo");
        traza("oidGrupo: " + oidGrupo);
        actividad.setGrupo(new Long(oidGrupo));

        // 1.f.- actividad.esMover <- rbtnMoverActividades ("S" pasa a ser true y "N" pasa a ser false) 
        String esMover = conectorParametro("rbMoverActividadesOrigen");
        traza("esMover: " + esMover);
        if (esMover.equalsIgnoreCase("S")) {
            actividad.setEsMover(new Boolean(true));
        } else {
            actividad.setEsMover(new Boolean(false));
        }
        // 1.g.- actividad.idVista <- hIdVistaActividad
        String idVista = conectorParametro("hIdVistaActividad");
        actividad.setIdVista(new Integer(idVista));
        traza("datos parciales modificados actividad: " + actividad);

        // 2.- Se invoca a guardaModificacion(actividad)
        this.guardaModificacion(actividad);

        // Asignamos funcion a ejecutar luego de guardar modificacion
        asignarAtributo( "VAR", "ejecutar", "valor", "vueltaGuardaModificacion()");
    }


    /**
     * Refresca la matriz de dias luego de modificar una actividad en la ventana modal. 
     */
    private void refrescaModificacion() throws Exception {
        // 0.- Volvemos a setear la pagina principal
        pagina("contenido_matriz_dias_grafico_insertar");
        // 1.- Muestra la matriz modificada
        this.vistaMatriz();
        // 2.- Recargamos la pagina
        this.busca();
    }




    /**----** Metodos Auxiliares **---**/

    /**
     * Carga el pais, el combo de marcas y el combo de canales
     */
    private void cargarPaisMarcaCanal() throws Exception {
        /* 1.- Carga Marcas y Canales */
        // 1.a.- Crea un DTOBelcorp para marcas y canales
        DTOBelcorp dtoBelcorp = new DTOBelcorp();
        dtoBelcorp.setOidPais(new Long(this.pais));
        dtoBelcorp.setOidIdioma(new Long(this.idioma));

        // 1.b.- Crea una lista ComposerViewElementList conConsultar 
        ComposerViewElementList cvLista = new ComposerViewElementList();

        // 1.c.- Crea un elemento de tipo ComposerViewElement() para cargar las marcas
        ComposerViewElement cvMarcas = new ComposerViewElement();
        cvMarcas.setIDBusiness("SEGConsultaMarcas");
        cvMarcas.setDTOE(dtoBelcorp);
        cvLista.addViewElement(cvMarcas);

        // 1.d.- Crea un elemento de tipo ComposerViewElement() para cargar los canales
        ComposerViewElement cvCanales = new ComposerViewElement();
        cvCanales.setIDBusiness("SEGConsultaCanales");
        cvCanales.setDTOE(dtoBelcorp);
        cvLista.addViewElement(cvCanales);

        // 1.e.- Invoca al subsistema GestorCargaPantalla o CargaInicial
        traza("carga inicial marcas y canales");
        ConectorComposerView conector = new ConectorComposerView(cvLista, this.getRequest());
        conector.ejecucion();
        DruidaConector conConsultar = conector.getConector();

        // 1.f.- Cragamos los combos con los resultados
        asignar("COMBO", "cbMarcas", conConsultar, "SEGConsultaMarcas"); 
        asignar("COMBO", "cbCanales", conConsultar, "SEGConsultaCanales");
 
        // 1.g.- Pasa los viejos valores seleccionados (si existen).
        traza("mantenemos valores actuales");
        asignarAtributo("VAR", "hIdioma", "valor", this.idioma);
        asignarAtributo("VAR", "hPais", "valor", this.pais);
        asignarAtributo("VAR", "hPaisDescripcion", "valor", this.paisDescripcion);
        asignarAtributo("VAR", "hMarca", "valor", this.marca);
        asignarAtributo("VAR", "hCanal", "valor", this.canal);

        /* 2.- Muestra el nombre del pais activo en el campo lblPais. */
        asignarAtributo("LABELC","lblValorPais","valor",this.paisDescripcion);
        traza("Carga completa de pais marcas y canales");
    }


    /**
     * Carga el pais, el combo de marcas, el combo de canales y el combo de gruposZonas.
     */
    private void cargarPaisMarcaCanalGrupos() throws Exception {
        /* 1.- Carga Marcas, Canales y GruposZonas */
        // 1.a.- Crea un DTOBelcorp para marcas y canales
        DTOBelcorp dtoBelcorp = new DTOBelcorp();
        dtoBelcorp.setOidPais(new Long(this.pais));
        dtoBelcorp.setOidIdioma(new Long(this.idioma));

        // 1.b.- Crea un DTOBelcorp para marcas y canales
        DTOGrupoZonas dtoGruposZonas = new DTOGrupoZonas();
        dtoGruposZonas.setOidIdioma(new Long(this.idioma));
        dtoGruposZonas.setOidPais(new Long(this.pais));
        dtoGruposZonas.setOidMarca(new Long(this.marca));
        dtoGruposZonas.setOidCanal(new Long(this.canal));

        // 1.c.- Crea una lista ComposerViewElementList conConsultar 
        ComposerViewElementList cvLista = new ComposerViewElementList();

        // 1.d.- Crea un elemento de tipo ComposerViewElement() para cargar las marcas
        ComposerViewElement cvMarcas = new ComposerViewElement();
        cvMarcas.setIDBusiness("SEGConsultaMarcas");
        cvMarcas.setDTOE(dtoBelcorp);
        cvLista.addViewElement(cvMarcas);

        // 1.e.- Crea un elemento de tipo ComposerViewElement() para cargar los canales
        ComposerViewElement cvCanales = new ComposerViewElement();
        cvCanales.setIDBusiness("SEGConsultaCanales");
        cvCanales.setDTOE(dtoBelcorp);
        cvLista.addViewElement(cvCanales);

        // 1.f.- Crea un elemento de tipo ComposerViewElement() para cargar los gruposZonas
        ComposerViewElement cvGrupos = new ComposerViewElement();
        cvGrupos.setIDBusiness("CRAObtieneGruposZonas");
        cvGrupos.setDTOE(dtoGruposZonas);
        cvLista.addViewElement(cvGrupos);

        // 1.g.- Invoca al subsistema GestorCargaPantalla o CargaInicial
        traza("carga inicial marcas y canales");
        ConectorComposerView conector = new ConectorComposerView(cvLista, this.getRequest());
        conector.ejecucion();
        DruidaConector conConsultar = conector.getConector();

        // 1.h.- Cragamos los combos con los resultados
        asignar("COMBO", "cbMarcas", conConsultar, "SEGConsultaMarcas"); 
        asignar("COMBO", "cbCanales", conConsultar, "SEGConsultaCanales");
        asignar("COMBO", "cbGrupoDeZonas", conConsultar, "CRAObtieneGruposZonas");
 
        // 1.i.- Pasa los viejos valores seleccionados (si existen).
        traza("mantenemos valores actuales");
        asignarAtributo("VAR", "hIdioma", "valor", this.idioma);
        asignarAtributo("VAR", "hPais", "valor", this.pais);
        asignarAtributo("VAR", "hPaisDescripcion", "valor", this.paisDescripcion);
        asignarAtributo("VAR", "hMarca", "valor", this.marca);
        asignarAtributo("VAR", "hCanal", "valor", this.canal);
        asignarAtributo("VAR", "hGruposZonas", "valor", conectorParametro("hGruposZonas"));

        /* 2.- Muestra el nombre del pais activo en el campo lblPais. */
        asignarAtributo("LABELC","lblValorPais","valor",this.paisDescripcion);
        traza("Carga completa de pais marcas canales y grupoZonas");
    }


    /**
     * Recarga la pagina segun el modo, despues de grabar.
     * Provoca que se reanude el caso de uso (el crear no se reinicia segun inc 10707).
     * Hace los pasos como si se hubieze llamado al metodo ejecucion.
     * El estado deseado es el mismo que produce ejecucion.
     */
    private void recargaPostGrabar() throws Exception {
        traza("metodo recargaPostGrabar");
        // A.- En modo crear
        if (modoCrerModificar.equalsIgnoreCase(MODO_CREAR)) {
            /* segun incidencia 10707 ahora se debe mostrar la matriz creada para solo cambiar de vista */
            // 1.a.- Limpia la matriz en sesión, se carga luego en la busqueda
            this.getRequest().getSession().removeAttribute(sesionMatriz);
            // 1.b.- Se esta por crear el tadMatriz (solo se crea una vez)
            tadMatriz = new TADMatrizDias(new Long(this.pais), new Long(this.marca), new Long(this.canal));
            traza("tadMatriz creada: " + tadMatriz.getMatrizDias() );
            // 2.-  seteamos la accion buscar y ejecutamos su metodo asociado
            this.mostrarCreada = this.SI;;
            asignarAtributo("VAR","hMostrarCreada","valor", mostrarCreada);
            this.accion = "buscar";     //para obtener la matrizDias recien creada.
            asignarAtributo("VAR","accion","valor","buscar");
            this.busca();
            // 3.- muestra la matriz recien creada, solo se puede cambiar de vista
            this.vistaMatriz();
        }
        // B.- En modo modificar
        if (modoCrerModificar.equalsIgnoreCase(MODO_MODIFICAR)) {
            // 1.a.- Limpia la matriz en sesión, se carga luego en la busqueda
            this.getRequest().getSession().removeAttribute(sesionMatriz);
            // 1.b.- Se esta por crear el tadMatriz (solo se crea una vez)
            tadMatriz = new TADMatrizDias(new Long(this.pais), new Long(this.marca), new Long(this.canal));
            traza("tadMatriz creada: " + tadMatriz.getMatrizDias() );
            // 2.- seteamos la accion buscar y ejecutamos su metodo asociado
            this.accion = "buscar";     //para obtener la matrizDias sin las eliminadas.
            asignarAtributo("VAR","accion","valor","buscar");
            this.busca();
            // 3.- muestra la matriz sin la eliminadas
            this.vistaMatriz();
        }
        getTituloPagina();
        getConfiguracionMenu();
    }


    /**
     * Recarga la pagina luego de un error.
     * Si es un error de negocio, recarga la pagina segun el error particular.
     * El estado deseado es el mismo que produce ejecucion.
     */
    private void recargaPostError(Exception ex) throws Exception {
        traza("metodo recargaPostError");
        // Vemos que errores de negocio necesitan una carga especial de la pagina.
		if (ex instanceof MareException) {
			MareException mex =(MareException)ex;
            //Recarga post error existe ya el grupo de zonas en la matriz
            if (mex.getCode() == 180120001) {
                traza("Recarga de error al agregar grupo zona existente: " + mex.getCode());
                // 1.- recarga la pagina con el estado actual
                this.busca();
                // 2.- muestra la matriz sin la eliminadas
                this.vistaMatriz();
                // fin de recarga estado actual
                return;
            }
            //Recarga post error existe ya la actividad en el mismo grupo de zonas de la matriz.
            if (mex.getCode() == 180120002) {
                traza("Recarga de error al agregar actividad existente: " + mex.getCode());
                // 1.- recarga la pagina con el estado actual
                this.busca();
                // 2.- muestra la matriz sin la eliminadas
                this.vistaMatriz();
                // fin de recarga estado actual
                return;
            }
            //Recarga post error "No se puede realizar la operación ya que se está creando una dependencia cíclica. ..."
            if (mex.getCode() == 180800008) {
                traza("Recarga de error al crear una dependencia cíclica: " + mex.getCode());
                // 1.- recarga la pagina con el estado actual
                this.busca();
                // 2.- muestra la matriz sin la eliminadas
                this.vistaMatriz();
                // fin de recarga estado actual
                return;
            }
		}
        // Error peticion de datos no existente.
        traza("Error peticion de datos no existente.");
        asignarAtributo("CAPA", "capaSeleccion", "visibilidad", "hidden");
        asignarAtributo("CAPA", "capaTablaGrafica", "visibilidad", "hidden");
        asignarAtributo("CAPA", "capaTablaNoGrafica", "visibilidad", "hidden");
        this.marca = ""; this.canal = "";
        this.cargarPaisMarcaCanal();
    }


    /**
     * Retorna true si la actividad genera un ciclo.
     * Verifica si existen dos ocurrencias de la misma actividad en dtoGrupoMatriz.
     * Sabiendo que en dtoGrupoMatriz viene una actividad mas sus actividades referenciadas.
     */
    private boolean generaCiclo(DTOGrupoMatriz dtoGrupoMatriz) throws Exception {
        traza("metodo generaCiclo()");
        Vector actividadesSinRepetir = new Vector();
        DTOActividadMatriz dtoActividadMatriz;
        boolean ciclo = false;
        
        // Se verifica que ninguna de las actividades de dtoGrupoMatriz.actividades este repetida.
        Iterator iter = dtoGrupoMatriz.getActividades().iterator();
        while (iter.hasNext() && (! ciclo)) {
            dtoActividadMatriz = (DTOActividadMatriz) iter.next();
            if (actividadesSinRepetir.contains(dtoActividadMatriz.getActividad())) {
                traza("Esta actividad y sus referenciadas esta generando un ciclo.");
                ciclo = true;
            } else {
                actividadesSinRepetir.add(dtoActividadMatriz.getActividad());
            }
        }
        return ciclo;
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



}
