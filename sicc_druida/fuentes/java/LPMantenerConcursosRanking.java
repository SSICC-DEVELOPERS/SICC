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
//import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import es.indra.sicc.dtos.inc.DTOConcurso;
import es.indra.sicc.dtos.inc.DTODatosGeneralesConcursoRanking;
import es.indra.sicc.dtos.inc.DTOParametrosGeneralesConcurso;
import es.indra.sicc.dtos.inc.DTOClasificacionParticipantes;
import es.indra.sicc.dtos.inc.DTOParticipante;
import es.indra.sicc.logicanegocio.inc.ConstantesINC;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesSession;

import java.util.Collection;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Vector;

import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

import java.math.BigDecimal;

public class LPMantenerConcursosRanking extends LPIncentivosRanking{
    private Long pais;
    
    private Long idioma;
    private String sIdioma;
    
    private String sOidConcurso;
    private Long oidConcurso;
    private DTOOID dtoOid;
    private MareBusinessID IDBusiness;
    private Vector params;
    private DruidaConector dc;
    private ComposerViewElement cvElement;
    private ComposerViewElementList cvElementList;
    private DTOBelcorp dtob;
    private String sDatosObligatorios;
    private Boolean datosObligatorios;
    private String nombreConcurso;
    private String sOidMarca;
    private Long oidMarca;
    private String sOidCanal;
    private Long oidCanal;

    //Recibe de la pagina los oid de los accesos seleccionados en formato:
    //x,x,x,...
    //El metodo obtenerListaAccesos(String) parsea este String y almacena los Long obtenidos en la
    //Collection lstAccesos.
    private String sLstAccesos;
    private ArrayList lstAccesos;
    private String periodoDesde;
    private String periodoHasta;
    private String indDevoluciones;
    private String indAnulaciones;
    private String indFaltantesNoAnunciados;
    private String oidDirigidoA;
    private String observaciones;
    private String indActivo;
    private String oidConcursoRanking;
    private String oidPeriodoCalificacion;
    private String oidPeriodoPremiacion;
    private String oidNivelAgrupamiento;
    private String tipoRanking;
    private String tipoExigencia;

    private String sLimpiar;
    private boolean limpiar; //flag utilizado para la funcion limpiar del menu secundario

	public LPMantenerConcursosRanking() { super(); }
  
	public void inicio() throws Exception{
        this.pagina("contenido_concurso_ranking_insertar");
    }
  
    /**
     * 
     * @throws java.lang.Exception
     * @author Marcelo J. Maidana -- (Creado)
     * @author Marcelo J. Maidana -- 24/06/2005 (Se agrega la accion 
     *                              "Inicializar Participantes" y la invocacion
     *                              al metodo inicializarParticipantes(), por
     *                              la inc. 18083).
     */
	public void ejecucion() throws Exception{
    
        try {
    
            this.setTrazaFichero();
        
            this.obtenerFlagsPestanyas();
        
            this.traza("LPMantenerConcursosRanking.ejecucion - entro");
        
            accion = this.conectorParametroLimpia("accion", "", true);
            opcionMenu = this.conectorParametroLimpia("opcionMenu", "", true);
            //this.idPestanyaDest = this.conectorParametroLimpia("idPestanyaDest", "", true);
        
            this.traza("LPMantenerConcursosRanking.ejecucion - accion: " + accion);
            this.traza("LPMantenerConcursosRanking.ejecucion - opcionMenu: " + opcionMenu);
            
            this.pais = UtilidadesSession.getPais(this);
            
            this.idioma = UtilidadesSession.getIdioma(this);
            sIdioma = idioma != null ? idioma.toString() : "";
    
            //Se recibe de LPBuscarConcursoRanking en el caso de Modificar, y se utiliza
            //en el metodo inicializar()
            sOidConcurso = this.conectorParametroLimpia("oidConcurso", "", true);
            sDatosObligatorios = this.conectorParametroLimpia("datosObligatorios", "", true);
            sOidMarca = this.conectorParametroLimpia("hMarca", "", true);
            sOidCanal = this.conectorParametroLimpia("hCanal", "", true);
            nombreConcurso = this.conectorParametroLimpia("textNombreConcurso", "", true);
    
            sLstAccesos = this.conectorParametroLimpia("hLstAccesos", "", true);
            this.lstAccesos = this.obtenerListaAccesos(sLstAccesos);
            
            this.periodoDesde = this.conectorParametroLimpia("hPeriodoEvaluacionDesde", "", true);
            this.periodoHasta = this.conectorParametroLimpia("hPeriodoEvaluacionHasta", "", true);
            this.indDevoluciones = this.conectorParametroLimpia("hDevoluciones", "", true);
            this.indAnulaciones = this.conectorParametroLimpia("hAnulaciones", "", true);
            this.indFaltantesNoAnunciados = this.conectorParametroLimpia(
                "hFaltantesNoAnunciados", "", true);
            this.oidDirigidoA = this.conectorParametroLimpia("hConcursoDirigidoA", "", true);
            traza("valor de oidDirigidoA ::: " + oidDirigidoA);
            
            
            this.observaciones = this.conectorParametroLimpia("textObservaciones", "", true);
            this.indActivo = this.conectorParametroLimpia("hActivo", "", true);
            this.oidConcursoRanking = this.conectorParametroLimpia("oidConcursoRanking", "", true);
            this.oidPeriodoCalificacion = this.conectorParametroLimpia("hPeriodoCalificacion", "", true);
            this.oidPeriodoPremiacion = this.conectorParametroLimpia("hPeriodoPremiacion", "", true);
            this.oidNivelAgrupamiento = this.conectorParametroLimpia("hNivelAgrupamiento", "", true);
            this.tipoRanking = this.conectorParametroLimpia("hTipoRanking", "", true);
            this.tipoExigencia = this.conectorParametroLimpia("hTipoExigencia", "", true);
    
            this.sLimpiar = this.conectorParametroLimpia("limpiar", "", true);

            traza("----------------------------------------------------------");
            traza("sLstAccesos: " + sLstAccesos);
            traza("lstAccesos: " + lstAccesos);
            traza("----------------------------------------------------------");
    
            traza("indActivo: " + this.indActivo);
    
            try {
                oidMarca = new Long(sOidMarca);
            } catch (NumberFormatException nfe){}
    
            try { 
                oidCanal = new Long(sOidCanal);
            } catch (NumberFormatException nfe){}
    
            try {
                oidConcurso = new Long(sOidConcurso);
            } catch (NumberFormatException nfe){}
    
            if (sDatosObligatorios.equals("true")){
                datosObligatorios = Boolean.TRUE;
            } else {
                datosObligatorios = Boolean.FALSE;
            }
        
            if (sLimpiar.equalsIgnoreCase("S")){
                limpiar = true;
            } else {
                limpiar = false;
            }
        
            this.traza("LPMantenerConcursosRanking.ejecucion - termino de obtener variables");
        
            //acciones
            if (accion.equalsIgnoreCase("")){
                this.inicializar();
                this.cargarPantallaInsertar();
            } else if (accion.equalsIgnoreCase("cargar")){
                this.cargarPantallaInsertar();
            } else if (accion.equalsIgnoreCase("almacenar")){
                this.almacenar();
                this.redirigir();
            } else if (accion.equalsIgnoreCase("redirigir")){
                this.redirigir();
            } else if (accion.equalsIgnoreCase("guardar")){
                this.almacenar();
                this.guardar();
            } else if (accion.equalsIgnoreCase("Inicializar Participantes")){
                this.inicializarParticipantes();
            } else if (accion.equalsIgnoreCase("Inicializar pestanias")){
                this.inicializarPestanias();
            } else if (accion.equalsIgnoreCase("limpiar")){
                this.limpiar();
            }
    
            traza("LPMantenerConcursosRanking.ejecucion - va a configurar menu");
    
            //menu secundario
            
            if (!accion.equalsIgnoreCase("guardar")){
            
                if (opcionMenu.equalsIgnoreCase("Crear Concurso Ranking")){
                    getConfiguracionMenu("LPMantenerConcursosRanking", "Crear Concurso Ranking");
                    asignarAtributoPagina("cod", "0508");
                } else if (opcionMenu.equalsIgnoreCase("Consultar Concurso Ranking")){
                    getConfiguracionMenu("LPMantenerConcursosRanking", "Consultar Concurso Ranking");
                    asignarAtributoPagina("cod", "0525");
                } else if(opcionMenu.equalsIgnoreCase("Modificar Concurso Ranking")){
                    getConfiguracionMenu("LPMantenerConcursosRanking", "Modificar Concurso Ranking");
                    asignarAtributoPagina("cod", "0524");
                }
            
            }
            
        } catch (Exception e){
            traza("Excepcion en LPMantenerConcursosRanking: " + e.toString());
            traza(e);
            this.lanzarPaginaError(e);
        }
    }

    /**
     * @author Marcelo J. Maidana -- 15/06/2005
     */
    private void inicializar() throws Exception {
    
        traza("LPMantenerConcursosRanking.inicializar - entro");
    
        //dtoConcurso = this.getConcurso();
        //
        //if (dtoConcurso == null){
        //    dtoConcurso = new DTOConcurso();
        //}

        dtoConcurso = new DTOConcurso();
    
        if (this.opcionMenu != null && this.opcionMenu.equalsIgnoreCase("Crear Concurso Ranking")){
            traza("LPMantenerConcursosRanking.inicializar - opcionMenu es Crear Concurso Ranking");
        
            dtoConcurso.setOidPais(this.pais);
            dtoConcurso.setOidIdioma(this.idioma);

            // Se inicializan todas los indicadores de las pestañas a false, 
            //porque ninguna se ha rellenado
            dtoConcurso.setIndParamGenerales(Boolean.FALSE);
            dtoConcurso.setIndObligParamGenerales(Boolean.FALSE);
            
            dtoConcurso.setIndAmbitosGeograficos(Boolean.FALSE);
            dtoConcurso.setIndObligAmbitosGeograficos(Boolean.FALSE);
            
            dtoConcurso.setIndProductosValidos(Boolean.FALSE);
            dtoConcurso.setIndProductosExcluidos(Boolean.FALSE);            
            dtoConcurso.setIndObligProductosValidos(Boolean.FALSE);
            dtoConcurso.setIndObligProductosExcluidos(Boolean.FALSE);
            dtoConcurso.setIndObligProductos(Boolean.FALSE);
            
            dtoConcurso.setIndPremios(Boolean.FALSE);
            dtoConcurso.setIndObligPremios(Boolean.FALSE);
            dtoConcurso.setIndNivelPremiacion(Boolean.FALSE);
            
            dtoConcurso.setIndGerentes(Boolean.FALSE);
            dtoConcurso.setIndObligGerentes(Boolean.FALSE);
            
            dtoConcurso.setIndConsultoras(Boolean.FALSE);
            dtoConcurso.setIndObligConsultoras(Boolean.FALSE);
            
            dtoConcurso.setIndEstatusVenta(Boolean.FALSE);
            dtoConcurso.setIndClasificacionParticipantes(Boolean.FALSE);
            
            dtoConcurso.setIndVariablesVentaRanking(Boolean.FALSE);
            dtoConcurso.setIndObligVariablesVentaRanking(Boolean.FALSE);
            
            // Inicializa los flag de borrado en false
            dtoConcurso.setIndBorradoAmbitosGeograficos(Boolean.FALSE);
            dtoConcurso.setIndBorradoGerentes(Boolean.FALSE);
            dtoConcurso.setIndBorradoConsultorasRanking(Boolean.FALSE);
            dtoConcurso.setIndBorradoClasificacionParticipantes(Boolean.FALSE);
            dtoConcurso.setIndBorradoEstatusVenta(Boolean.FALSE);
            dtoConcurso.setIndBorradoProductosValidos(Boolean.FALSE);
            dtoConcurso.setIndBorradoProductosExcluidos(Boolean.FALSE);
            dtoConcurso.setIndBorradoPremios(Boolean.FALSE);
            dtoConcurso.setIndBorradoVariablesVentaRanking(Boolean.FALSE);
   
            this.setConcurso(this.dtoConcurso);
        
        } else if (this.opcionMenu != null 
                && this.opcionMenu.equalsIgnoreCase("Modificar Concurso Ranking")){

            traza("LPMantenerConcursosRanking.inicializar - opcionMenu es Modificar Concurso Ranking");

            this.inicializarConsultarModificar();

            //TODO -------------------------------------------------------------
            //Por defecto, se deshabilitan todas las pestañas, excepto las siguientes, 
            //que siempre estarán habilitadas: 
            //Habilitar pestanyaDatosGenerales 
            //Habilitar pestanyaAlcanceGeografico 
            //Habilitar pestanyaProductos 
            //Habilitar pestanyaPremios 
            //si dtoConcurso.paramGerentes.oidFormaCalculo == ConstantesINC.OID_FORMA_CALC_VARIABLES_VTA 
            //    Habilitar pestanyaVariablesVenta             
            //------------------------------------------------------------------
         //   if (dtoConcurso.getParamGerentes().
             
             //---Agregado para habilitar la pestania de variables-venta  
        } else if (this.opcionMenu != null 
                && this.opcionMenu.equalsIgnoreCase("Consultar Concurso Ranking")){

            traza("LPMantenerConcursosRanking.inicializar - opcionMenu es Consultar Concurso Ranking");


            this.inicializarConsultarModificar();

            //TODO -------------------------------------------------------------
            //Por defecto, se deshabilitan todas las pestañas, excepto las siguientes, 
            //que siempre estarán habilitadas: 
            //Habilitar pestanyaDatosGenerales 
            //Habilitar pestanyaAlcanceGeografico 
            //Habilitar pestanyaProductos 
            //Habilitar pestanyaPremios 
            //si dtoConcurso.paramGerentes.oidFormaCalculo == ConstantesINC.OID_FORMA_CALC_VARIABLES_VTA 
            //  Habilitar pestanyaVariablesVenta 
            //------------------------------------------------------------------
            
           
        }
        
        traza("LPMantenerConcursosRanking.inicializar - termino");
    }

    private void inicializarConsultarModificar() throws Exception {
        traza("comienzooo inicializar ");
        dtoOid = new DTOOID();
        dtoOid.setOid(oidConcurso);
        dtoOid.setOidIdioma(UtilidadesSession.getIdioma(this));
        dtoOid.setOidPais(UtilidadesSession.getPais(this));
    
        traza("DTOOID " + dtoOid);
        IDBusiness = new MareBusinessID("INCObtenerDatosConcursoRanking");

        params = new Vector();
        params.add(dtoOid);
        params.add(IDBusiness);
        
        this.pagina("salidaGenerica");
        
        dc = this.conectar("ConectorObtenerDatosConcursoRanking", params);
        
        //TODO: verificar la clave de salida de este conector
        this.dtoConcurso = (DTOConcurso)dc.objeto("dtoSalida");

        dtoConcurso.setOidPais(UtilidadesSession.getPais(this));
        dtoConcurso.setOidIdioma(UtilidadesSession.getIdioma(this));
        
        // Inicializa los flag de borrado en false
        dtoConcurso.setIndBorradoAmbitosGeograficos(Boolean.FALSE);
        dtoConcurso.setIndBorradoGerentes(Boolean.FALSE);
        dtoConcurso.setIndBorradoConsultorasRanking(Boolean.FALSE);
        dtoConcurso.setIndBorradoClasificacionParticipantes(Boolean.FALSE);
        dtoConcurso.setIndBorradoEstatusVenta(Boolean.FALSE);
        dtoConcurso.setIndBorradoProductosValidos(Boolean.FALSE);
        dtoConcurso.setIndBorradoProductosExcluidos(Boolean.FALSE);
        dtoConcurso.setIndBorradoPremios(Boolean.FALSE);
        dtoConcurso.setIndBorradoVariablesVentaRanking(Boolean.FALSE);

        this.setConcurso(this.dtoConcurso);
    }

    /**
     * 
     * @throws java.lang.Exception
     * @author Marcelo J. Maidana -- 15/06/2005
     */
    private void cargarPantallaInsertar() throws Exception {
        traza("LPMantenerConcursosRanking.cargarPantallaInsertar - entro");

        this.pagina("contenido_concurso_ranking_insertar");
       
        this.cargarFlagsPestanyas();
        
        this.asignarAtributo("VAR", "accion", "valor", accion);
        this.asignarAtributo("VAR", "opcionMenu", "valor", opcionMenu);
        this.asignarAtributo("VAR", "hPais", "valor", pais != null ? pais.toString() : "");
        this.asignarAtributo("VAR", "hIdioma", "valor", sIdioma);
        
        //Asignar constantes utilizadas en el javascript de la pagina
        this.asignarAtributo("VAR", "OID_DIRIGO_A_CONSULTORA", "valor", ConstantesINC.OID_DIRIGIDO_A_CONSULTORAS.toString());
        this.asignarAtributo("VAR", "OID_DIRIGIDO_A_GERENTE", "valor", ConstantesINC.OID_DIRIGIDO_A_GERENTE.toString());
        this.asignarAtributo("VAR", "OID_TIPO_EXIGENCIA_ACTIVIDAD", "valor", ConstantesINC.OID_TIPO_EXIGENCIA_ACTIVIDAD.toString());
        
        
        ComposerViewElementList cv = this.crearParametrosEntrada();
        ConectorComposerView conector = new ConectorComposerView(cv, this.getRequest());
        conector.ejecucion();
        DruidaConector resultados = conector.getConector();

        asignar("COMBO", "cbMarca", resultados, "SEGConsultaMarcas");
        asignar("COMBO", "cbCanal", resultados, "SEGConsultaCanales");
        asignar("COMBO", "cbConcursoDirigidoA", resultados, "INCConsultaDirigidoA");
        asignar("COMBO", "cbNivelAgrupamiento", resultados, "INCObtenerNivelAgrupamiento");
        asignar("COMBO", "cbTipoRanking", resultados, "INCObtenerTipoRanking");
        asignar("COMBO", "cbTipoExigencia", resultados, "INCRecuperarTiposExigencia");

        traza("LPMantenerConcursosRanking.cargarPantallaInsertar - termino carga combos");

        if (dtoConcurso.getIndParamGenerales() != null 
                && dtoConcurso.getIndParamGenerales().booleanValue()){
        
            traza("LPMantenerConcursosRanking.cargarPantallaInsertar - IndParamGenerales == TRUE");
        
        traza("**************************************************************");
        traza("VALORES A ASIGNAR A COMBOS");
        traza("dtoConcurso.getParamGenerales().getOidPeriodoDesde(): " + dtoConcurso.getParamGenerales().getOidPeriodoDesde());
        traza("dtoConcurso.getParamGenerales().getOidPeriodoHasta(): " + dtoConcurso.getParamGenerales().getOidPeriodoHasta());
        traza("**************************************************************");
        
        
            if (dtoConcurso.getParamGenerales().getOid() != null){
                this.asignarAtributo("VAR", "oidConcurso", "valor", 
                    dtoConcurso.getParamGenerales().getOid().toString());
            }

            if (dtoConcurso.getParamGenerales().getNombreConcurso() != null){
                this.asignarAtributo("CTEXTO", "textNombreConcurso", "valor", 
                    dtoConcurso.getParamGenerales().getNombreConcurso()); //yyy Attr Traducible???
            }
            
            if (dtoConcurso.getParamGenerales().getOidMarca() != null){
                this.asignarAtributo("VAR", "hMarca", "valor", 
                    dtoConcurso.getParamGenerales().getOidMarca().toString());
            }

            if (dtoConcurso.getParamGenerales().getOidCanal() != null){
                this.asignarAtributo("VAR", "hCanal", "valor", 
                    dtoConcurso.getParamGenerales().getOidCanal().toString());
            }

            if (dtoConcurso.getParamGenerales().getOidPeriodoDesde() != null){
                this.asignarAtributo("VAR", "hPeriodoEvaluacionDesde", "valor", 
                    dtoConcurso.getParamGenerales().getOidPeriodoDesde().toString());
            }

            if (dtoConcurso.getParamGenerales().getOidPeriodoHasta() != null){
                this.asignarAtributo("VAR", "hPeriodoEvaluacionHasta", "valor", 
                    dtoConcurso.getParamGenerales().getOidPeriodoHasta().toString());
            }
            
            if (dtoConcurso.getParamGenerales().getIndDevoluciones() != null 
                    && dtoConcurso.getParamGenerales().getIndDevoluciones().booleanValue()){
                this.asignarAtributo("VAR", "hDevoluciones", "valor", "S");
            }
            
            if (dtoConcurso.getParamGenerales().getIndAnulaciones() != null
                    && dtoConcurso.getParamGenerales().getIndAnulaciones().booleanValue()){
                this.asignarAtributo("VAR", "hAnulaciones", "valor", "S");
            }
            
            traza("LPMantenerConcursosRanking.cargarPantallaInsertar - hLstAccesos: " + dtoConcurso.getParamGenerales().getLstAccesos());
            
            //accesos
            if (dtoConcurso.getParamGenerales().getLstAccesos() != null 
                    && !dtoConcurso.getParamGenerales().getLstAccesos().isEmpty()){
                    
                traza("va a asignar accesos");
                
                this.asignarAtributo("VAR", "hLstAccesos", "valor", 
                    this.obtenerStringAccesos(dtoConcurso.getParamGenerales().getLstAccesos()));
            }
            
            if (dtoConcurso.getParamGenerales().getIndFaltantesNoAnunciados() != null
                    && dtoConcurso.getParamGenerales().getIndFaltantesNoAnunciados().booleanValue()){
                this.asignarAtributo("VAR", "hFaltantesNoAnunciados", "valor", "S");
            }
            
            
            //--PAra habilitar la pestañia correspondiente //
            //Gerente = 2
            // Consultora = 1
            traza("dtoConcurso.getParamGenerales() " + dtoConcurso.getParamGenerales());
            
            if (dtoConcurso.getParamGenerales().getOidDirigidoA() != null){
                
                traza(" getOidDirigidoA " + dtoConcurso.getParamGenerales().getOidDirigidoA());
                
                this.asignarAtributo("VAR", "hConcursoDirigidoA", "valor", 
                    dtoConcurso.getParamGenerales().getOidDirigidoA().toString());
                    
                if (dtoConcurso.getParamGenerales().getOidDirigidoA().equals(ConstantesINC.OID_DIRIGIDO_A_CONSULTORAS)){
                    asignarAtributo("VAR", "hIndEstadoParametrosConsultoras", "valor", "S");
                }
                if (dtoConcurso.getParamGenerales().getOidDirigidoA().equals(ConstantesINC.OID_DIRIGIDO_A_GERENTE)){
                    asignarAtributo("VAR", "hIndEstadoParametrosGerentes", "valor", "S");
                }
                    
            }
            
            if (dtoConcurso.getParamGerentes() !=null){    
                traza("dtoConcurso.getParamGerentes().getOidFormaCalculo() " + dtoConcurso.getParamGerentes().getOidFormaCalculo());
                //---Agregado para habilitar la pestania de variables-venta       
                
                if (dtoConcurso.getParamGerentes().getOidFormaCalculo() !=null){
                    if (dtoConcurso.getParamGerentes().getOidFormaCalculo().equals(ConstantesINC.OID_FORMA_CALC_VARIABLES_VTA)) {
                    //    Habilitar pestanyaVariablesVenta  
                        traza("Agregado para habilitar la pestania de variables-venta");
                        asignarAtributo("VAR", "hIndEstadoVariablesVenta", "valor", "S");
        
                    }
                } 
            
            }
            
            
            traza("**********************************************************");
            if (dtoConcurso.getParamGenerales() != null){
                traza("valor a asignar a textObservaciones: " + dtoConcurso.getParamGenerales().getObservaciones());
            } else {
                traza("valor a asignar a textObservaciones: dtoConcurso.getParamGenerales() es null");
            }
            traza("**********************************************************");
            
            if (dtoConcurso.getParamGenerales().getObservaciones() != null){
            
                traza("va a asignar textObservaciones");
            
                this.asignarAtributo("VAR", "hTextObservaciones", "valor", 
                    dtoConcurso.getParamGenerales().getObservaciones());
            }

            traza("-1-");

            if (dtoConcurso.getParamGenerales().getIndActivo() != null
                    && dtoConcurso.getParamGenerales().getIndActivo().booleanValue()){
                this.asignarAtributo("VAR", "hActivo", "valor", "S");
            }

            traza("-2-");

            /*------------------ Modificar -----------------------------------*/ 
            DTODatosGeneralesConcursoRanking dtoDGCR = 
                dtoConcurso.getParamGenerales().getDatosGeneralesRanking();
            
            if (dtoDGCR != null){
                    
                traza("entro cond grande");
                    
                if (dtoDGCR.getOid() != null){
                    this.asignarAtributo("VAR", "oidConcursoRanking", "valor", dtoDGCR.getOid().toString());
                }
                
                if (dtoDGCR.getOidPeriodoCalificacion() != null){
                
                    traza("va a asignar periodo calificacion: " + dtoDGCR.getOidPeriodoCalificacion().toString());
                
                    this.asignarAtributo("VAR", "hPeriodoCalificacion", "valor", 
                        dtoDGCR.getOidPeriodoCalificacion().toString());
                }

                if (dtoDGCR.getOidPeriodoPremiacion() != null){
                
                    traza("va a asignar periodo premiacion: " + dtoDGCR.getOidPeriodoPremiacion().toString());
                
                    this.asignarAtributo("VAR", "hPeriodoPremiacion", "valor", 
                        dtoDGCR.getOidPeriodoPremiacion().toString());
                }

                if (dtoDGCR.getOidNivelAgrupamiento() != null){
                    this.asignarAtributo("VAR", "hNivelAgrupamiento", "valor", 
                        dtoDGCR.getOidNivelAgrupamiento().toString());
                }

                if (dtoDGCR.getOidTipoRanking() != null){
                    this.asignarAtributo("VAR", "hTipoRanking", "valor", 
                        dtoDGCR.getOidTipoRanking().toString());
                }
                
                if (dtoDGCR.getOidTipoExigencia() != null){
                    this.asignarAtributo("VAR", "hTipoExigencia", "valor", 
                        dtoDGCR.getOidTipoExigencia().toString());
                }
            }
            /*------------------ FIN Modificar -------------------------------*/ 

        } else { // si no hay información en el dto 
        
            traza("LPMantenerConcursosRanking.cargarPantallaInsertar - No hay informacion en el DTO");
        
            this.asignarAtributo("VAR", "oidConcurso", "valor", "");
            this.asignarAtributo("VAR", "oidConcursoRanking", "valor", "");
            this.asignarAtributo("CTEXTO", "textNombreConcurso", "valor", "");
            this.asignarAtributo("VAR", "hDevoluciones", "valor", "S");
            this.asignarAtributo("VAR", "hAnulaciones", "valor", "S");
            this.asignarAtributo("VAR", "hFaltantesNoAnunciados", "valor", "S");
            this.asignarAtributo("VAR", "hActivo", "valor", "N");
            this.asignarAtributo("VAR", "hTipoExigencia", "valor", 
                ConstantesINC.OID_TIPO_EXIGENCIA_ACTIVIDAD.toString());
            this.asignarAtributo("AREATEXTO", "textObservaciones", "valor", "");
        }
        
        traza("LPMantenerConcursosRanking.cargarPantallaInsertar - termino");
    }

    public void cargarPantalla() throws Exception{}

    /**
     * 
     * @throws java.lang.Exception
     * @author Marcelo J. Maidana -- 16/06/2005
     */
    public void almacenar() throws Exception{
    
        traza("LPMantenerConcursosRanking.almacenar - entro");
    
    
        traza("==============================================================");
        traza("DATOS A ALMACENAR EN PARAMETROS GENERALES");
        traza("periodoDesde" + periodoDesde);
        traza("periodoHasta" + periodoHasta);
        traza("oidPeriodoCalificacion" + oidPeriodoCalificacion);
        traza("oidPeriodoPremiacion" + oidPeriodoPremiacion);
        traza("==============================================================");
    
        dtoConcurso = this.getConcurso();
        DTOParametrosGeneralesConcurso paramGenerales = null;
        DTODatosGeneralesConcursoRanking datosGeneralesRanking = null;
        
        dtoConcurso.setIndParamGenerales(Boolean.TRUE);
        dtoConcurso.setIndObligParamGenerales(this.datosObligatorios);
        
        traza("datosObligatoriosh: " + datosObligatorios);

        if (dtoConcurso.getParamGenerales() == null){
            dtoConcurso.setParamGenerales(new DTOParametrosGeneralesConcurso());
        }
        
        paramGenerales = dtoConcurso.getParamGenerales();

        paramGenerales.setOid(this.oidConcurso);
        paramGenerales.setOidPais(UtilidadesSession.getPais(this));
        paramGenerales.setNombreConcurso(nombreConcurso);
        paramGenerales.setOidMarca(oidMarca);
        paramGenerales.setOidCanal(oidCanal);
        
        paramGenerales.setLstAccesos(this.lstAccesos);

        paramGenerales.setOidPeriodoDesde(periodoDesde != null && periodoDesde.length() > 0 
            ? new Long(periodoDesde) : null);

        paramGenerales.setOidPeriodoHasta(periodoHasta != null && periodoHasta.length() > 0 
            ? new Long(periodoHasta) : null);

        paramGenerales.setIndDevoluciones(this.indDevoluciones != null 
            && this.indDevoluciones.equalsIgnoreCase("S") ? Boolean.TRUE : Boolean.FALSE);

        paramGenerales.setIndAnulaciones(this.indAnulaciones != null 
            && this.indAnulaciones.equalsIgnoreCase("S") ? Boolean.TRUE : Boolean.FALSE);

        paramGenerales.setIndFaltantesNoAnunciados(this.indFaltantesNoAnunciados != null 
            && this.indFaltantesNoAnunciados.equalsIgnoreCase("S") ? Boolean.TRUE : Boolean.FALSE);
        
        try {
            paramGenerales.setOidDirigidoA(this.oidDirigidoA != null 
                && this.oidDirigidoA.length() > 0 ? new Long(this.oidDirigidoA) : null);
        } catch (NumberFormatException nfe){}
      
        paramGenerales.setObservaciones(this.observaciones);
        
        traza("antes de asignar paramGenerales.setIndActivo: " + paramGenerales.getIndActivo());
        
        paramGenerales.setIndActivo(this.indActivo != null && this.indActivo.equalsIgnoreCase("S") 
            ? Boolean.TRUE : Boolean.FALSE);

        traza("despues de asignar paramGenerales.setIndActivo: " + paramGenerales.getIndActivo());

        
        paramGenerales.setIndRanking(Boolean.TRUE);

        //Datos Generales Ranking

        if (paramGenerales.getDatosGeneralesRanking() == null){
            paramGenerales.setDatosGeneralesRanking(new DTODatosGeneralesConcursoRanking());
        }

        datosGeneralesRanking = paramGenerales.getDatosGeneralesRanking();

        try {
            datosGeneralesRanking.setOid(this.oidConcursoRanking != null 
                && this.oidConcursoRanking.length() > 0 ? new Long(this.oidConcursoRanking) : null);
        } catch(NumberFormatException nfe){}

        try {
            datosGeneralesRanking.setOidPeriodoCalificacion(
                this.oidPeriodoCalificacion != null && this.oidPeriodoCalificacion.length() > 0 
                ? new Long(this.oidPeriodoCalificacion) : null);
        } catch (NumberFormatException nfe){}

        try {
            datosGeneralesRanking.setOidPeriodoPremiacion(this.oidPeriodoPremiacion != null 
                && this.oidPeriodoPremiacion.length() > 0 ? new Long(this.oidPeriodoPremiacion) : null);
        } catch (NumberFormatException nfe){}
    
        try {
            datosGeneralesRanking.setOidNivelAgrupamiento(this.oidNivelAgrupamiento != null 
                && this.oidNivelAgrupamiento.length() > 0 ? new Long(this.oidNivelAgrupamiento) : null);
        } catch (NumberFormatException nfe){}

        try {
            datosGeneralesRanking.setOidTipoRanking(this.tipoRanking != null 
                && this.tipoRanking.length() > 0 ? new Long(this.tipoRanking) : null);
        } catch (NumberFormatException nfe){}

        try {
            datosGeneralesRanking.setOidTipoExigencia(this.tipoExigencia != null 
                && this.tipoExigencia.length() > 0 ? new Long(this.tipoExigencia) : null);
        } catch (NumberFormatException nfe){}

        //TODO
        //Los otros campos se inicializarán según corresponda 
        //( si es un oid en null, si un string en blanco, etc) 

        this.setConcurso(this.dtoConcurso);
        
        traza("LPMantenerConcursosRanking.almacenar - termino");
        
    }

    /**
     * 
     * @return 
     * @param dto
     * @author Marcelo J. Maidana -- 15/06/2005
     */
    private ComposerViewElementList crearParametrosEntrada() throws Exception {
    
        traza("LPMantenerConcursosRanking.crearParametrosEntrada - entro");
    
        if (dtoConcurso == null){
            dtoConcurso = this.getConcurso();
        }
    
        dtoOid = new DTOOID();
        dtoOid.setOidPais(UtilidadesSession.getPais(this));
        dtoOid.setOidIdioma(UtilidadesSession.getIdioma(this));
        dtoOid.setOid(null);

        dtob = new DTOBelcorp();
        dtob.setOidPais(UtilidadesSession.getPais(this));
        dtob.setOidIdioma(UtilidadesSession.getIdioma(this));
        
        cvElementList = new ComposerViewElementList();
        
        //Obtenemos las marcas
        cvElement = new ComposerViewElement();
        cvElement.setIDBusiness("SEGConsultaMarcas");
        cvElement.setDTOE(dtob);
        cvElementList.addViewElement(cvElement);
        
        //Obtenemos los canales 
        cvElement = new ComposerViewElement();
        cvElement.setIDBusiness("SEGConsultaCanales");
        cvElement.setDTOE(dtob);
        cvElementList.addViewElement(cvElement);
        
        //Obtenemos dirigido a
        cvElement = new ComposerViewElement();
        cvElement.setIDBusiness("INCConsultaDirigidoA");
        cvElement.setDTOE(dtob);
        cvElementList.addViewElement(cvElement);
        
        //Obtenemos nivel agrupamiento 
        cvElement = new ComposerViewElement();
        cvElement.setIDBusiness("INCObtenerNivelAgrupamiento");
        cvElement.setDTOE(dtob);
        cvElementList.addViewElement(cvElement);
        
        //Obtenemos tipo ranking 
        cvElement = new ComposerViewElement();
        cvElement.setIDBusiness("INCObtenerTipoRanking");
        cvElement.setDTOE(dtob);
        cvElementList.addViewElement(cvElement);
        
        //Obtenemos Tipos de exigencias
        cvElement = new ComposerViewElement();
        cvElement.setIDBusiness("INCRecuperarTiposExigencia");
        cvElement.setDTOE(dtob);
        cvElementList.addViewElement(cvElement);
        
        traza("LPMantenerConcursosRanking.crearParametrosEntrada - termino");
        
        return cvElementList;
    }

    /**
     * Procesa el String sLista y devuelve un ArrayList con los oids contenidos
     * en sLista
     * @return 
     * @param sLista
     * @author Marcelo J. Maidana -- 16/06/2005
     */
    private ArrayList obtenerListaAccesos(String sLista){
        ArrayList lista = new ArrayList();
    
        if (sLista == null || sLista.length() == 0){
            return lista;
        }
    
        StringTokenizer strToken = new StringTokenizer(sLista, ",");
        String token = null;
        Long oid = null;

        while (strToken.hasMoreTokens()){
            oid = null;
            token = strToken.nextToken();
        
            try {
                oid = new Long(token);
            } catch (NumberFormatException nfe){}
        
            lista.add(oid);
        }
    
        return lista;
    }

    /**
     * 
     * @return 
     * @param c
     * @author Marcelo J. Maidana -- 29/06/2005
     */
    private String obtenerStringAccesos(Collection c){
        StringBuffer sb = new StringBuffer("");
        Iterator i = null;
        Object o = null;
    
        if (c != null && !c.isEmpty()){
            i = c.iterator();
            
            while (i.hasNext()){
                o = i.next();
                
                if (o != null){
                    if (!sb.toString().equals("")){
                        sb.append(",");
                    }

                    sb.append(o.toString());
                }
            }
        }
    
        return sb.toString();
    }
    
    // Viviana Bongiovanni 23/07/2005
    private void limpiar() throws Exception {
    
        opcionMenu = conectorParametroLimpia("opcionMenu", "", true);
        
        if(!opcionMenu.equals("Modificar Concurso Ranking")) {          
            pagina("salidaGenerica");
            asignarAtributo("VAR", "cerrarVentana", "valor", "false");
        }
        
        try{
                
            dtoConcurso = this.getConcurso();
            DTOConcurso dtoConcursoNuevo= new DTOConcurso();
            
            dtoConcursoNuevo.setOidPais(dtoConcurso.getOidPais());
            dtoConcursoNuevo.setOidIdioma(dtoConcurso.getOidIdioma());
            
            if(opcionMenu.equals("Modificar Concurso Ranking")) {
                dtoConcursoNuevo.setParamGenerales(dtoConcurso.getParamGenerales());
                dtoConcursoNuevo.setIndParamGenerales(Boolean.TRUE);
                dtoConcursoNuevo.setIndObligParamGenerales(Boolean.TRUE);
                
                DTOOID dto = new DTOOID();
                dto.setOid(dtoConcursoNuevo.getParamGenerales().getOidDirigidoA());
                dto.setOidPais(UtilidadesSession.getPais(this));
                dto.setOidIdioma(UtilidadesSession.getIdioma(this));
				
                MareBusinessID id = new MareBusinessID("INCObtenerParticipantesConcurso");
                
                params = new Vector();
                params.add(dto);
                params.add(id);
				
                DruidaConector dc = this.conectar("ConectorObtenerParticipantesConcurso", params);
				
                if (dc != null){
                    DTOSalida dtoSalida = (DTOSalida)dc.objeto("dtoSalida");
                  
                    if (dtoSalida != null){
                        RecordSet rs = dtoSalida.getResultado();
                        ArrayList lista = this.obtenerListaParticipantes(rs);
                        
                        DTOClasificacionParticipantes dtoClasificacionParticipantes = new DTOClasificacionParticipantes();
                        dtoClasificacionParticipantes.setLstParticipantes(lista);
                        dtoConcurso.setClasificParticipantes(dtoClasificacionParticipantes);
                    } 
                }
            }
            
            dtoConcursoNuevo.setIndAmbitosGeograficos(Boolean.FALSE);
            dtoConcursoNuevo.setIndObligAmbitosGeograficos(Boolean.FALSE);
            
            dtoConcursoNuevo.setIndProductosValidos(Boolean.FALSE);
            dtoConcursoNuevo.setIndProductosExcluidos(Boolean.FALSE);            
            dtoConcursoNuevo.setIndObligProductosValidos(Boolean.FALSE);
            dtoConcursoNuevo.setIndObligProductosExcluidos(Boolean.FALSE);
            dtoConcursoNuevo.setIndObligProductos(Boolean.FALSE);
            
            dtoConcursoNuevo.setIndPremios(Boolean.FALSE);
            dtoConcursoNuevo.setIndObligPremios(Boolean.FALSE);
            dtoConcursoNuevo.setIndNivelPremiacion(Boolean.FALSE);
            
            dtoConcursoNuevo.setIndGerentes(Boolean.FALSE);
            dtoConcursoNuevo.setIndObligGerentes(Boolean.FALSE);
            
            dtoConcursoNuevo.setIndConsultoras(Boolean.FALSE);
            dtoConcursoNuevo.setIndObligConsultoras(Boolean.FALSE);
            
            dtoConcursoNuevo.setIndEstatusVenta(Boolean.FALSE);
            dtoConcursoNuevo.setIndClasificacionParticipantes(Boolean.FALSE);
            
            dtoConcursoNuevo.setIndVariablesVentaRanking(Boolean.FALSE);
            dtoConcursoNuevo.setIndObligVariablesVentaRanking(Boolean.FALSE);
            
            opcionMenu = conectorParametroLimpia("opcionMenu", "", true);
            
            if(opcionMenu.equals("Modificar Concurso Ranking")) {
                // Inicializa los flag de borrado en false
                dtoConcursoNuevo.setIndBorradoAmbitosGeograficos(Boolean.TRUE);
                dtoConcursoNuevo.setIndBorradoGerentes(Boolean.TRUE);
                dtoConcursoNuevo.setIndBorradoConsultorasRanking(Boolean.TRUE);
                dtoConcursoNuevo.setIndBorradoClasificacionParticipantes(Boolean.TRUE);
                dtoConcursoNuevo.setIndBorradoEstatusVenta(Boolean.TRUE);
                dtoConcursoNuevo.setIndBorradoProductosValidos(Boolean.TRUE);
                dtoConcursoNuevo.setIndBorradoProductosExcluidos(Boolean.TRUE);
                dtoConcursoNuevo.setIndBorradoPremios(Boolean.TRUE);
                dtoConcursoNuevo.setIndBorradoVariablesVentaRanking(Boolean.TRUE);
            } else {
                // Inicializa los flag de borrado en false
                dtoConcursoNuevo.setIndBorradoAmbitosGeograficos(Boolean.FALSE);
                dtoConcursoNuevo.setIndBorradoGerentes(Boolean.FALSE);
                dtoConcursoNuevo.setIndBorradoConsultorasRanking(Boolean.FALSE);
                dtoConcursoNuevo.setIndBorradoClasificacionParticipantes(Boolean.FALSE);
                dtoConcursoNuevo.setIndBorradoEstatusVenta(Boolean.FALSE);
                dtoConcursoNuevo.setIndBorradoProductosValidos(Boolean.FALSE);
                dtoConcursoNuevo.setIndBorradoProductosExcluidos(Boolean.FALSE);
                dtoConcursoNuevo.setIndBorradoPremios(Boolean.FALSE);
                dtoConcursoNuevo.setIndBorradoVariablesVentaRanking(Boolean.FALSE);
            }
            
            super.setConcurso(dtoConcursoNuevo);
            
            if(!opcionMenu.equals("Modificar Concurso Ranking")) {
                asignarAtributo("VAR", "ejecutar", "valor", "focaliza('formulario.textNombreConcurso');");
            } else {
                this.cargarPantallaInsertar();
            }

        } catch(Exception e){
              if(!opcionMenu.equals("Modificar Concurso Ranking")) {
                  asignarAtributo("VAR", "ejecutarError", "valor", "focaliza('formulario.textNombreConcurso');");
              }
              throw e;
        }	
   
    }
    
    
    
    // Viviana Bongiovanni 23/07/2005
    private void inicializarPestanias() throws Exception {
        traza("inicializarPestanias");
        
        pagina("salidaGenerica");
        asignarAtributo("VAR", "cerrarVentana", "valor", "false");
        
        try{
                
            dtoConcurso = this.getConcurso();
            
            traza("dtoConcurso original: " + dtoConcurso);
            
            DTOConcurso dtoConcursoNuevo= new DTOConcurso();
            
            dtoConcursoNuevo.setOidPais(dtoConcurso.getOidPais());
            dtoConcursoNuevo.setOidIdioma(dtoConcurso.getOidIdioma());
            dtoConcursoNuevo.setParamGenerales(dtoConcurso.getParamGenerales());
            
            DTOClasificacionParticipantes dtoClasificacionParticipantes = new DTOClasificacionParticipantes();
           
            if(dtoConcurso.getClasificParticipantes()!=null && dtoConcurso.getClasificParticipantes().getLstParticipantes()!=null) {
                dtoClasificacionParticipantes.setLstParticipantes(dtoConcurso.getClasificParticipantes().getLstParticipantes());
                dtoConcursoNuevo.setClasificParticipantes(dtoClasificacionParticipantes);
            }
            
            
            dtoConcursoNuevo.setIndAmbitosGeograficos(Boolean.FALSE);
            dtoConcursoNuevo.setIndObligAmbitosGeograficos(Boolean.FALSE);
            
            dtoConcursoNuevo.setIndProductosValidos(Boolean.FALSE);
            dtoConcursoNuevo.setIndProductosExcluidos(Boolean.FALSE);            
            dtoConcursoNuevo.setIndObligProductosValidos(Boolean.FALSE);
            dtoConcursoNuevo.setIndObligProductosExcluidos(Boolean.FALSE);
            dtoConcursoNuevo.setIndObligProductos(Boolean.FALSE);

            dtoConcursoNuevo.setIndPremios(Boolean.FALSE);
            dtoConcursoNuevo.setIndObligPremios(Boolean.FALSE);
            dtoConcursoNuevo.setIndNivelPremiacion(Boolean.FALSE);
           
            dtoConcursoNuevo.setIndGerentes(Boolean.FALSE);
            dtoConcursoNuevo.setIndObligGerentes(Boolean.FALSE);
            
            dtoConcursoNuevo.setIndConsultoras(Boolean.FALSE);
            dtoConcursoNuevo.setIndObligConsultoras(Boolean.FALSE);
            
            dtoConcursoNuevo.setIndEstatusVenta(Boolean.FALSE);
            dtoConcursoNuevo.setIndClasificacionParticipantes(Boolean.FALSE);
            
            dtoConcursoNuevo.setIndVariablesVentaRanking(Boolean.FALSE);
            dtoConcursoNuevo.setIndObligVariablesVentaRanking(Boolean.FALSE);

            opcionMenu = conectorParametroLimpia("opcionMenu", "", true);

            if(opcionMenu.equals("Modificar Concurso Ranking")) {
                // Inicializa los flag de borrado en false
                dtoConcursoNuevo.setIndBorradoAmbitosGeograficos(Boolean.TRUE);
                dtoConcursoNuevo.setIndBorradoGerentes(Boolean.TRUE);
                dtoConcursoNuevo.setIndBorradoConsultorasRanking(Boolean.TRUE);
                dtoConcursoNuevo.setIndBorradoClasificacionParticipantes(Boolean.TRUE);
                dtoConcursoNuevo.setIndBorradoEstatusVenta(Boolean.TRUE);
                dtoConcursoNuevo.setIndBorradoProductosValidos(Boolean.TRUE);
                dtoConcursoNuevo.setIndBorradoProductosExcluidos(Boolean.TRUE);
                dtoConcursoNuevo.setIndBorradoPremios(Boolean.TRUE);
                dtoConcursoNuevo.setIndBorradoVariablesVentaRanking(Boolean.TRUE);
            } else {
                // Inicializa los flag de borrado en false
                dtoConcursoNuevo.setIndBorradoAmbitosGeograficos(Boolean.FALSE);
                dtoConcursoNuevo.setIndBorradoGerentes(Boolean.FALSE);
                dtoConcursoNuevo.setIndBorradoConsultorasRanking(Boolean.FALSE);
                dtoConcursoNuevo.setIndBorradoClasificacionParticipantes(Boolean.FALSE);
                dtoConcursoNuevo.setIndBorradoEstatusVenta(Boolean.FALSE);
                dtoConcursoNuevo.setIndBorradoProductosValidos(Boolean.FALSE);
                dtoConcursoNuevo.setIndBorradoProductosExcluidos(Boolean.FALSE);
                dtoConcursoNuevo.setIndBorradoPremios(Boolean.FALSE);
                dtoConcursoNuevo.setIndBorradoVariablesVentaRanking(Boolean.FALSE);
            }
            
            traza("dtoConcursoNuevo: " + dtoConcursoNuevo);
            
            super.setConcurso(dtoConcursoNuevo);
            
            asignarAtributo("VAR", "ejecutar", "valor", "focaliza('formulario.textNombreConcurso');");

        } catch(Exception e){
                asignarAtributo("VAR", "ejecutarError", "valor", "focaliza('formulario.textNombreConcurso');");
          throw e;
        }	
   
    }


    /**
     * Actualiza dtoConcurso.clasificParticipantes.lstParticipantes y 
     * dtoConcurso.paramGerentes en base al valor seleccionado en el combo
     * oidDirigidoA. Creado por la inc. 18083.
     * @throws java.lang.Exception
     * @author Marcelo J. Maidana -- 24/06/2005 (Creado)
     */
    private void inicializarParticipantes() throws Exception {

		pagina("salidaGenerica");
    asignarAtributo("VAR", "cerrarVentana", "valor", "false");
    
    Long oid = null;
    
		try{
			dtoConcurso = this.getConcurso();

			//Solo se obtiene la lista de Participantes de la entidad 
			//ParticipantesConcurso (ya que la lista de Clasificacion Participantes 
			//todavía no ha sido creada, pues se crea al crear el concurso)
      
			DTOOID dto = null;
			MareBusinessID id = null;
			Vector params = null;
			DruidaConector dc = null;
			DTOSalida dtoSalida = null;
			RecordSet rs = null;
			ArrayList lista = null;

			traza("oidDirigidoA: " + this.oidDirigidoA);

			try {
				oid = this.oidDirigidoA != null && this.oidDirigidoA.length() > 0 ? 
					new Long(this.oidDirigidoA) : null;
			} catch (NumberFormatException nfe){}
			
			if (oid != null && this.pais != null && this.idioma != null){
            
				dto = new DTOOID();
				dto.setOid(oid);
				dto.setOidPais(this.pais);
				dto.setOidIdioma(this.idioma);
				
				id = new MareBusinessID("INCObtenerParticipantesConcurso");
				
				params = new Vector();
				params.add(dto);
				params.add(id);
				
				dc = this.conectar("ConectorObtenerParticipantesConcurso", params);
				
				if (dc != null){
					dtoSalida = (DTOSalida)dc.objeto("dtoSalida");
					
					if (dtoSalida != null){
						rs = dtoSalida.getResultado();
						lista = this.obtenerListaParticipantes(rs);
						
						DTOClasificacionParticipantes dtoClasificacionParticipantes = new DTOClasificacionParticipantes();
						dtoClasificacionParticipantes.setLstParticipantes(lista);
						dtoConcurso.setClasificParticipantes(dtoClasificacionParticipantes);
            dtoConcurso.setIndBorradoClasificacionParticipantes(Boolean.TRUE);

					}
				}
			}
			
      if (oid != null && oid.equals(ConstantesINC.OID_DIRIGIDO_A_CONSULTORAS)){
          traza("anularGerentes");
          this.anularGerentes(dtoConcurso);
      } else if (oid != null && oid.equals(ConstantesINC.OID_DIRIGIDO_A_GERENTE)){
          traza("anularConsultoras");
          this.anularConsultoras(dtoConcurso);
      } else {
          this.anularGerentes(dtoConcurso);
          this.anularConsultoras(dtoConcurso);
      }

			super.setConcurso(dtoConcurso);

			asignarAtributo("VAR", "ejecutar", "valor", "inicializarParticipantes('"+ oid +"')");

		} catch(Exception e){
            asignarAtributo("VAR", "ejecutarError", "valor", "inicializarParticipantes('"+ oid +"')");
			throw e;
		}	
    }

    private void anularGerentes(DTOConcurso dto){
        // Gerentes
        dto.setParamGerentes(null);
        dto.setIndGerentes(Boolean.FALSE);
        dto.setIndObligGerentes(Boolean.FALSE);
        dto.setIndBorradoGerentes(Boolean.TRUE);
        // Variables ventas
        dto.setVariablesVentaRanking(null);
        dto.setIndVariablesVentaRanking(Boolean.FALSE);
        dto.setIndObligVariablesVentaRanking(Boolean.FALSE);
        dto.setIndBorradoVariablesVentaRanking(Boolean.TRUE);
    }

    private void anularConsultoras(DTOConcurso dto){
        // Consultora
        dto.setParamConsultorasRanking(null);
        dto.setIndConsultoras(Boolean.FALSE);
        dto.setIndObligConsultoras(Boolean.FALSE);
        dto.setIndBorradoConsultorasRanking(Boolean.TRUE);
        // Estatus Venta
        dto.setVariablesVenta(null);
        dto.setIndEstatusVenta(Boolean.FALSE);
        dto.setIndBorradoEstatusVenta(Boolean.TRUE);
    }

    /**
     * Genera un ArrayList de DTOParticipante a partir de un RecordSet
     * con los datos.
     * @return 
     * @param rs
     * @author Marcelo J. Maidana -- 24/06/2005 (Creado)
     */
    private ArrayList obtenerListaParticipantes(RecordSet rs){
        ArrayList lista = new ArrayList();
        BigDecimal bdOid = null;
        Long oid = null;
        String descripcion = "";
        DTOParticipante dtop = null;

        if (rs != null && !rs.esVacio()){
            for (int i = 0; i < rs.getRowCount(); i++){
                bdOid = (BigDecimal)rs.getValueAt(i, "OID_PART_CONC_CABE");
                descripcion = (String)rs.getValueAt(i, "INC_PARTI");
                
                if (bdOid != null){
                    oid = new Long(bdOid.longValue());
                }

                dtop = new DTOParticipante();
                dtop.setOid(oid);
                dtop.setDescripcion(descripcion);
                lista.add(dtop);
                
                bdOid = null;
                oid = null;
                descripcion = "";
            }
        }

        return lista;
    }


}
