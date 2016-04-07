//$Id: LPParametrosCAR.java,v 1.1 2009/12/03 18:36:16 pecbazalar Exp $ 
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

import com.evermind.server.rmi.OrionRemoteException;

import es.indra.druida.DruidaBase;
import es.indra.druida.DruidaConector;
import es.indra.mare.common.dto.IMareDTO;
import es.indra.mare.common.dto.MareDTO;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.MareCredentials;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import es.indra.sicc.cmn.presentacion.rastreador.IRastreador;
import es.indra.sicc.cmn.presentacion.rastreador.Rastreador;
import es.indra.sicc.dtos.car.DTOAsignacionCod;
import es.indra.sicc.dtos.car.DTOAsignaciones;
import es.indra.sicc.dtos.car.DTOCodigoConfiguracion;
import es.indra.sicc.dtos.zon.DTOUnidadAdministrativa;
import es.indra.sicc.util.BelcorpError;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOError;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.IBelcorpError;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.logicanegocio.car.ConstantesCAR;
import es.indra.sicc.dtos.car.DTOEliminarCodigoConf;

import java.io.*;

import java.lang.Boolean;
import java.lang.reflect.InvocationTargetException;

import java.math.BigDecimal;

import java.sql.Date;
import java.sql.Timestamp;

import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Vector;

import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import es.indra.sicc.dtos.car.DTOAsignacionCod;
import es.indra.sicc.dtos.car.DTOAsignaciones;
import es.indra.sicc.dtos.car.DTOCodigoConfiguracion;
import es.indra.sicc.dtos.car.DTOEliminarCodigoConf;

//Agregado por Sergio Platas - 19/07/2005
import es.indra.sicc.dtos.car.DTOFiltroGrupoSolicitud;
import es.indra.sicc.dtos.zon.DTOUnidadAdministrativa;
import es.indra.sicc.logicanegocio.car.ConstantesCAR;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.UtilidadesSession;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.Boolean;
import java.math.BigDecimal;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Vector;

public class LPParametrosCAR extends LPSICCBase {
    private final static String FECHA_JDBC = "yyyy-mm-dd";
    private Long marcaDefecto = null;
    private Long canalDefecto = null;
    private Long sgvDefecto = null;
    private Integer regionDefecto = null;
    private Long zonaDefecto = null;
    String accion = "";
    String casoDeUso = "";
    String oid = "";
    Long pais = null;
    Long idioma = null;
    DTOCodigoConfiguracion dtoCodConf = null;
    String oidCodConf;
    String txtCodConfiguracion;
    String cbNivelRiesgo;
    String cbGrupoSolicitud;
    String DiasDeudaVencida;
    String txtDiasDeudaVencidaPermitida;
    String LineaCredito;
    String txtFechaVigenciaDesde;
    String txtFechaVigenciaHasta;
    String cbIndicadorValidacion;
    String txtPorcentaje;
    String MontoMaximo;
    String txtMontoMaximoPermitido;
    String PorcentajeMaximo;
    String txtPorcentajeMaximoPermitido;
    String txtNDiasAdicionales;
    Long pestania;
    String codigoTitulo;
    String hcodConf;
    String hnivelRiesgo;
    String hgrupoSolicitud;
    String hindDiasDeuda;
    String hdiasDeuda;
    String hindLinCre;
    String hfechaDesde;
    String hfechaHasta;
    String hindValidacion;
    String hporcValidacion;
    String hindMonMax;
    String hmontoMax;
    String hindPorcMax;
    String hporcMaxPerm;
    String hdiasAdici;
    String hoid;
    String hasignaciones;

    //Datos Pantalla
    public LPParametrosCAR() {
        super();
    }

    public void inicio() throws Exception {
        setTrazaFichero();
        traza("*********** Entre a inicio");
        pais = UtilidadesSession.getPais(this);
        traza("*********** pais = " + pais.toString());
        idioma = UtilidadesSession.getIdioma(this);
        traza("*********** idioma = " + idioma.toString());

        String formatoFecha = UtilidadesSession.getFormatoFecha(this);
        traza("*********** formato fecha");
        accion = conectorParametroLimpia("accion", "", true);
        casoDeUso = conectorParametroLimpia("casoDeUso", "", true);
        oid = conectorParametroNumero("oid", this.FORMATO_DEFAULT);
        
        traza("     ACCION =    " + accion.toString());
        traza("     CASO DE USO =       " + casoDeUso.toString());
        traza("     OID =       " + oid.toString());
        
    }

    private void logStackTrace(Throwable e) {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(os);

        e.printStackTrace(ps);

        try {
            traza("Se produjo la excepcion: " + e.getMessage() + "\n" +
                "stackTrace = " + os.toString());
        } catch (Exception ex) {
            //traza ("Error en logStackTrace: " + ex.getMessage ());
            e.printStackTrace();
        }
    }

    /**
     * Sistema:     Belcorp
     * Modulo:      CAR
     * Fecha:
     * @version
     * @autor
     * Fecha:      19/07/2005
     * @modified   mmaidana
     * Se modifico el metodo ejecucion por Inc. BELC300014826
     */
    public void ejecucion() throws Exception {
        setTrazaFichero();
        traza("accion   " + accion);
        traza("el oid es " + oid);
        traza("el caso de uso es " + casoDeUso);

        traza("******* Obtiene marca por defecto");
        marcaDefecto = UtilidadesSession.getMarcaPorDefecto(this);
        
        traza("******* Obtiene canal por defecto");
        canalDefecto = UtilidadesSession.getCanalPorDefecto(this);
        traza("         INICIO -> EJECUCION, CanalDefecto es :" + canalDefecto);
        
        
        traza("******* Obtiene SGV por defecto");
        sgvDefecto = UtilidadesSession.getSGVPorDefecto(this);
        traza("******* Obtiene region por defecto");
        regionDefecto = UtilidadesSession.getRegion(this);
        traza("******* Obtiene zona por defecto");
        zonaDefecto = UtilidadesSession.getZonaPorDefecto(this);
        traza("exito");

        //pais = UtilidadesSession.getPais(this);
        //idioma = UtilidadesSession.getIdioma(this);
        try {
            //asignarAtributo("VAR","casoDeUso","valor",casoDeUso);
            //if( accion.equals("inserta")){

            /* if( accion.equals("")){
                traza("inserta   ");
                pagina("contenido_parametros_cartera_modificar");
                getConfiguracionMenu();
                     cargarCampos();
               }*/
            codigoTitulo = obtenerCodigoTitulo();

            if (accion.equals("inserta")) {
                traza("inserta");
                pagina("contenido_parametros_cartera_insertar2");
                this.getFormatosValidaciones();

                if (((conectorParametroLimpia("hidAsignaciones", "", true)) != null) &&
                        !(conectorParametroLimpia("hidAsignaciones", "", true)
                                  .equals(""))) {
                    asignarAtributo("VAR", "hidAsignaciones", "valor",
                        conectorParametroLimpia("hidAsignaciones", "", true));
                }

                if (casoDeUso.equals("consultarModificar") ||
                        (casoDeUso.equals("consultarEliminar")) ||
                        (casoDeUso.equals("consultarDetalle"))) {
                    leeHiddens();
                    asignaHiddens();
                }

                asignarAtributoPagina("cod", "0435");
                pestania = new Long(2);
                cargarCampos();
            }

            if (accion.equals("asignaCodigo")) {
                traza("asignaCodigo");

                pagina("contenido_parametros_cartera_insertar");
                this.getFormatosValidaciones();
                
                asignarAtributo("VAR", "marcaDefecto", "valor",
                    marcaDefecto.toString());
                asignarAtributo("VAR", "canalDefecto", "valor",
                    canalDefecto.toString());
                asignarAtributo("VAR", "sgvDefecto", "valor",
                    sgvDefecto.toString());
                asignarAtributo("VAR", "regionDefecto", "valor",
                    regionDefecto.toString());
                asignarAtributo("VAR", "zonaDefecto", "valor",
                    zonaDefecto.toString());

                String foco = conectorParametroLimpia("foco", "", true);
                traza("************** foco " + foco);
                asignarAtributo("VAR", "focoSolapa", "valor", foco);

                if (((conectorParametroLimpia("hidAsignaciones", "", true)) != null) &&
                        !(conectorParametroLimpia("hidAsignaciones", "", true)
                                  .equals(""))) {
                    asignarAtributo("VAR", "hidAsignaciones", "valor",
                        conectorParametroLimpia("hidAsignaciones", "", true));
                    traza("     asigno 'hidAsignaciones'    ");
                }

                if (casoDeUso.equals("consultarModificar") ||
                        (casoDeUso.equals("consultarEliminar")) ||
                        (casoDeUso.equals("consultarDetalle"))) {
                    leeHiddens();
                    asignaHiddens();
                    traza("    lee y asigna 'Hiddens'    ");
                }

                asignarAtributo("VAR", "hIdioma", "valor", idioma.toString());
                asignarAtributo("VAR", "hPais", "valor", pais.toString());
                traza("     asigna IDIOMA = " + idioma.toString());
                traza("     asigna PAIS = " + pais.toString());
                
                pestania = new Long(1);
               
                cargarCampos();
            }

            if (accion.equals("consulta")) {
                pagina("contenido_parametros_cartera_modificar");

                //   asignarAtributoPagina("cod", "0438");
                cargaCamposCriterios();
                traza("*******la constante " +
                    ConstantesCAR.MAX_OID_ASIG_CODI_CONF.toString());
                asignarAtributo("VAR", "hCteMaxOidAsiCodConf", "valor",
                    ConstantesCAR.MAX_OID_ASIG_CODI_CONF.toString());
                asignarAtributo("VAR", "hIdioma", "valor", idioma.toString());
                asignarAtributo("VAR", "hPais", "valor", pais.toString());
            }

            if (accion.equals("elimina")) {
                pagina("contenido_parametros_cartera_modificar");

                //asignarAtributoPagina("cod", "0436");
                cargaCamposCriterios();
                traza("la constante " +
                    ConstantesCAR.MAX_OID_ASIG_CODI_CONF.toString());
                asignarAtributo("VAR", "hCteMaxOidAsiCodConf", "valor",
                    ConstantesCAR.MAX_OID_ASIG_CODI_CONF.toString());
                asignarAtributo("VAR", "hIdioma", "valor", idioma.toString());
                asignarAtributo("VAR", "hPais", "valor", pais.toString());
            }

            if (accion.equals("modifica")) {
                pagina("contenido_parametros_cartera_modificar");

                //  asignarAtributoPagina("cod", "0436");
                cargaCamposCriterios();
                asignarAtributo("VAR", "hIdioma", "valor", idioma.toString());
                asignarAtributo("VAR", "hPais", "valor", pais.toString());
            }

            if (accion.equals("GuardarCodigo")) {
                traza("antes de guardar codigo");
                pagina("salidaGenerica");
                asignarAtributo("VAR", "ejecutar", "valor", "guardoOk();");
                asignarAtributo("VAR", "ejecutarError", "valor", "noGuardo();");
                guardarCodigo();
                traza("despues de guardar codigo");

                /*pagina("contenido_parametros_cartera_insertar");
                asignarAtributo("VAR","hIdioma","valor", idioma.toString());
                asignarAtributo("VAR","hPais","valor", pais.toString());
                asignarAtributoPagina("cod","0435");
                pestania = new Long(1);
                cargarCampos();
                traza("despues de cargar codigoooooooooooooooooo");*/
            }

            if (accion.equals("consultaCodConf")) {
                traza("     ACCION = consultaCodConf !!      ");
                pagina("contenido_parametros_cartera_insertar");

                //  asignarAtributoPagina("cod", "0438");
                pestania = new Long(1);
                
                consultarCodig();
                cargarCampos();
                llenarCamposCodigo(Boolean.FALSE);
            }

            if (accion.equals("modificaCodConf")) {
                traza("**** accion = modificaCodConf");                
                pagina("contenido_parametros_cartera_insertar");                
                this.getFormatosValidaciones();

                pestania = new Long(1);
                idioma = UtilidadesSession.getIdioma(this);
                asignarAtributo("VAR", "hIdioma", "valor", idioma.toString());                

		        pais = UtilidadesSession.getPais(this);
                asignarAtributo("VAR", "hPais", "valor", pais.toString());                
                
				traza("**** llamando a consultarCodig()");
                consultarCodig();
                traza("**** llamando a cargarCampos()");
                cargarCampos();
                traza("**** llamando a llenarCamposCodigo");
                llenarCamposCodigo(Boolean.TRUE);
            }

            if (accion.equals("copiaCodConf")) {
                traza("     ACCION = copiaCodConf !!      ");
                pagina("contenido_parametros_cartera_insertar");
                this.getFormatosValidaciones();
                consultarCodig();
                
                pestania = new Long(1);
                
                cargarCampos();
                asignarAtributo("VAR", "indCopia", "valor", "true");
                llenarCamposCodigo(Boolean.TRUE);
            }

            if (accion.equals("guardaAsignacion")) {
                traza("     ACCION = guardaAsignacion !!      ");
                pagina("salidaGenerica");
                asignarAtributo("VAR", "ejecutar", "valor", "guardoOk();");
                asignarAtributo("VAR", "ejecutarError", "valor", "noGuardo();");
                guardarAsignaciones();

                //pagina("contenido_parametros_cartera_insertar");
                // pestania = new Long(1);
                //cargarCampos();
            }

            if (accion.equals("eliminaCodigo")) {
                traza("     ACCION = eliminaCodigo !!      ");
                this.eliminar();
            }

            /*********Verificar si hay que enviar oculto****************/
            if (!(accion.equals("guardaAsignacion"))) {
                traza("     ACCION = !(guardaAsignacion)      ");
                asignarAtributo("VAR", "casoDeUso", "valor", casoDeUso);
                asignarAtributo("VAR", "accion", "valor", accion);

                //asignarAtributo("VAR", "oid", "valor", oid);
            }

            asignarAtributoPagina("cod", codigoTitulo);

            if (casoDeUso.equals("copiar")) {
                traza("     CASO DE USO = copiar !!      ");
                getConfiguracionMenu("LPParametrosCAR", "insertar");
            } else {
                getConfiguracionMenu("LPParametrosCAR", casoDeUso);
                traza("     CASO DE USO = " + casoDeUso);
            }
        } catch (Exception ex) {
            traza("EXCEPCION " + ex);

            ByteArrayOutputStream stack = new ByteArrayOutputStream();
            PrintStream out = new PrintStream(stack);
            ex.printStackTrace(out);
            traza("EXCEPCION:" + stack.toString());
            lanzarPaginaError(ex);
        }
    }

    private void leeHiddens() throws Exception {
        hcodConf = conectorParametroLimpia("hidCodConf", "", true);
        hnivelRiesgo = conectorParametroLimpia("hidNivelRiesgo", "", true);
        hgrupoSolicitud = conectorParametroLimpia("hidGrupoSolicitud", "", true);
        hindDiasDeuda = conectorParametroLimpia("hidIndDiasDeuda", "", true);
        hdiasDeuda = conectorParametroLimpia("hidDiasDeuda", "", true);
        hindLinCre = conectorParametroLimpia("hidIndLineaCredito", "", true);
        hfechaDesde = conectorParametroLimpia("hidFechaDesde", "", true);
        hfechaHasta = conectorParametroLimpia("hidFechaHasta", "", true);
        hindValidacion = conectorParametroLimpia("hidIndValidacion", "", true);
        hporcValidacion = conectorParametroLimpia("hidPorcValidacion", "", true);
        hindMonMax = conectorParametroLimpia("hidIndMontoMax", "", true);
        hmontoMax = conectorParametroLimpia("hidMontoMax", "", true);
        hindPorcMax = conectorParametroLimpia("hidIndPorcMax", "", true);
        hporcMaxPerm = conectorParametroLimpia("hidPorcMaxPerm", "", true);
        hdiasAdici = conectorParametroLimpia("hidDiasAdici", "", true);
        hoid = conectorParametroLimpia("oid", "", true);
        hasignaciones = conectorParametroLimpia("hidAsignaciones", "", true);
    }

    private void asignaHiddens() throws Exception {
        asignarAtributo("VAR", "hidCodConf", "valor", hcodConf);
        asignarAtributo("VAR", "hidNivelRiesgo", "valor", hnivelRiesgo);
        asignarAtributo("VAR", "hidGrupoSolicitud", "valor", hgrupoSolicitud);
        asignarAtributo("VAR", "hidIndDiasDeuda", "valor", hindDiasDeuda);
        asignarAtributo("VAR", "hidDiasDeuda", "valor", hdiasDeuda);
        asignarAtributo("VAR", "hidIndLineaCredito", "valor", hindLinCre);
        asignarAtributo("VAR", "hidFechaDesde", "valor", hfechaDesde);
        asignarAtributo("VAR", "hidFechaHasta", "valor", hfechaHasta);
        asignarAtributo("VAR", "hidIndValidacion", "valor", hindValidacion);
        asignarAtributo("VAR", "hidPorcValidacion", "valor", hporcValidacion);
        asignarAtributo("VAR", "hidIndMontoMax", "valor", hindMonMax);
        asignarAtributo("VAR", "hidMontoMax", "valor", hmontoMax);
        asignarAtributo("VAR", "hidIndPorcMax", "valor", hindPorcMax);
        asignarAtributo("VAR", "hidPorcMaxPerm", "valor", hporcMaxPerm);
        asignarAtributo("VAR", "hidDiasAdici", "valor", hdiasAdici);
        asignarAtributo("VAR", "oid", "valor", hoid);
        asignarAtributo("VAR", "hidAsignaciones", "valor", hasignaciones);
    }

    /**
     * Modificado por Sergio Platas - 19/07/2005
     * Inc. 19834
     * Este metodo se encarga de cargar los datos de los combos de la pagina
     * "InsertaParametrosCartera".
     */
    private void cargarCampos() throws Exception {
        traza(" metodo cargarCampos() ");
        
        DTOBelcorp dtobelcorp = new DTOBelcorp();
        dtobelcorp.setOidIdioma(idioma);
        dtobelcorp.setOidPais(pais);
        traza(" -----------> Generó el DTOBelcorp");
        
        //Se crea un DTOOID, "dtooid" y se le asigna el idioma y el pais de la sesion, 
        //ademas al oid se le asigna "NULL".
        DTOOID dtooid = new DTOOID();
        dtooid.setOidIdioma(idioma);
        dtooid.setOidPais(pais);
        dtooid.setOid(null);
        traza(" -----------> Generó el DTOOID");

        //Se crea un DTOFiltroGrupoSolicitud, "dtogrupoSolicitud" y se le asigna el idioma y 
        //el pais de la sesion, ademas al oidCodConf y nivel de riesgo se le asigna "NULL".
        DTOFiltroGrupoSolicitud dtoGrupoSolicitud = new DTOFiltroGrupoSolicitud();
        dtoGrupoSolicitud.setOidIdioma(idioma);
        dtoGrupoSolicitud.setOidPais(pais);
        dtoGrupoSolicitud.setOidCodConf(null);
        dtoGrupoSolicitud.setNivelRiesgo(null);
        traza(" -----------> Generó el DTOFiltroGrupoSolicitud");

        //Se crea un ComposerViewElementList y se le agregan los siguientes ComposerViewElement 
        ComposerViewElementList lista = new ComposerViewElementList();
      
        //1,. ComposerViewElement con: dtooid, MareBusinessID="CARNivelesRiesgo"
        ComposerViewElement cbNR = new ComposerViewElement();
        cbNR.setDTOE(dtooid);
        cbNR.setIDBusiness("CARNivelesRiesgo");
        lista.addViewElement(cbNR);
        
        //2,. ComposerViewElement con: dtogrupoSolicitud, MareBusinessID="CARGruposSolicitud"
        ComposerViewElement cbGS = new ComposerViewElement();
        cbGS.setDTOE(dtoGrupoSolicitud);
        cbGS.setIDBusiness("CARGruposSolicitud");
        lista.addViewElement(cbGS);
        
        //3,. ComposerViewElement con: dtobelcorp, MareBusinessID="CARCodigosConfiguracion"
        ComposerViewElement cbCC = new ComposerViewElement();
        cbCC.setDTOE(dtobelcorp);
        cbCC.setIDBusiness("CARCodigosConfiguracion");
        lista.addViewElement(cbCC);
        
        //4,. ComposerViewElement con: dtobelcorp, MareBusinessID="CARIndicadoresValidacion"
        ComposerViewElement indVal = new ComposerViewElement();
        indVal.setDTOE(dtobelcorp);
        indVal.setIDBusiness("CARIndicadoresValidacion");
        lista.addViewElement(indVal);
        
        //5,. ComposerViewElement con: dtobelcorp, MareBusinessID="SEGConsultaMarcas", 
        ComposerViewElement marcas = new ComposerViewElement();
        marcas.setDTOE(dtobelcorp);
        marcas.setIDBusiness("SEGConsultaMarcas");
        lista.addViewElement(marcas);
        
        //6,. ComposerViewElement con: dtobelcorp, MareBusinessID="SEGConsultaCanales", 
        ComposerViewElement canales = new ComposerViewElement();
        canales.setDTOE(dtobelcorp);
        canales.setIDBusiness("SEGConsultaCanales");
        lista.addViewElement(canales);
        
        ConectorComposerView conector = new ConectorComposerView(lista,
                this.getRequest());
        traza("El tamaño de la LISTA es =   " + lista.getSize()); 
        
        conector.ejecucion(); 
        DruidaConector resultados = conector.getConector();
        traza(" ----->  Realiza la 1er. asignación");        
        if (pestania.longValue() == 2) {
            traza("asigna a la pantalla de codigosConfiguracion");
            
            asignar("COMBO", "cbIndicadorValidacion", resultados, "CARIndicadoresValidacion");
            asignar("COMBO", "cbGrupoSolicitud", resultados, "CARGruposSolicitud");
            asignar("COMBO", "cbNivelRiesgo", resultados, "CARNivelesRiesgo");
            
        } else {
            traza("asigna a la pantalla de unidades administrativas");
            
            asignar("COMBO", "cbCodConfiguracion", resultados, "CARCodigosConfiguracion");
            asignar("COMBO", "cbNivelRiesgoInicial", resultados, "CARNivelesRiesgo");
            asignar("COMBO", "cbMarca", resultados, "SEGConsultaMarcas");
            asignar("COMBO", "cbCanal", resultados, "SEGConsultaCanales");
        }
         
        
        //Si existe un valor por defecto para el usuario para la marca o el canal Entonces { 
        //7,. ComposerViewElement con: DTOUnidadAdministrativa, asignandole el valor de la marca  
        //  y/o canal por defecto y el país de la sesion activa. 
        // MareBusinessID="ZONObtenerSubgerenciasVentas", posOID=1, posDesc=3       
        if ((this.marcaDefecto != null) || (this.canalDefecto != null)) {
            traza("entró al 1er. IF()");
            
            ComposerViewElement sgv = new ComposerViewElement();
            DTOUnidadAdministrativa dtoUA = new DTOUnidadAdministrativa();
            dtoUA.setOidMarca(marcaDefecto);
            dtoUA.setOidCanal(canalDefecto); 
            dtoUA.setOidPais(pais);
            sgv.setDTOE(dtoUA);
            sgv.setIDBusiness("ZONObtenerSubgerenciasVentas");
            sgv.setPosOID( (byte)0 );
            sgv.setPosDesc( (byte)4 );
            lista.addViewElement(sgv);
            traza("     Se cargó una SGV según MARCADefecto y CANALDefecto      ");
            
            //Si además existe un valor por defecto para la SGV entonces: 
            //8,. ComposerViewElement con: DTOUnidadAdministrativa, con el valor de la  
            //  subgerencia de venta por defecto. MareBusinessID="ZONObtenerRegiones", posOID=1 
            //  posDesc=3
            traza("SubGerVtasDefecto es = " + sgvDefecto.toString());
            if (this.sgvDefecto != null) {
                traza("entró al 2do. IF()");

                ComposerViewElement reg = new ComposerViewElement();
                DTOUnidadAdministrativa dtoUA1 = new DTOUnidadAdministrativa();
                dtoUA1.setOidSGV(this.sgvDefecto);
                reg.setDTOE(dtoUA1);
                reg.setIDBusiness("ZONObtenerRegiones");
                reg.setPosOID( (byte)0 );
                reg.setPosDesc( (byte)5 );
                lista.addViewElement(reg);
                traza("     Se cargó una REGIÓN segun SGVDefecto      ");

                //Si además existe un valor por defecto para la Region entonces: 
                //9,. ComposerViewElement con: 
                // DTOUnidadAdministrativa, con el valor de la region por defecto. 
                // MareBusinessID="ZONObtenerZonas", posOID=1, posDesc=3
                traza(" RegionDefecto es =  " + regionDefecto.toString());
                if (this.regionDefecto != null) {
                    traza("entró al 3er. IF()");
                    
                    ComposerViewElement zon = new ComposerViewElement();
                    DTOUnidadAdministrativa dtoUA2 = new DTOUnidadAdministrativa();
                    dtoUA2.setOidRegion(new Long(this.regionDefecto.longValue()));
                    zon.setDTOE(dtoUA2);
                    zon.setIDBusiness("ZONObtenerZonas");
                    zon.setPosOID( (byte)0 );
                    zon.setPosDesc( (byte)5 );
                    lista.addViewElement(zon);
                    traza("     Se cargó una ZONA segun REGIONDefecto  ");
                    
                    traza("TERMINÓ el 3er. IF() !!!!");
                }
            }
        }
        
        /////////////   TERMINO LA CARGA    //////////////
        conector = new ConectorComposerView(lista, this.getRequest());
        traza("El tamaño de la LISTA es =   " + lista.getSize()); 
        
        conector.ejecucion();
        resultados = conector.getConector();

        if(pestania.longValue() == 1){
            traza(" ----->  Realiza la 2da. asignación en: Unidades Administrativas");
            
            asignar("COMBO", "cbSubgerenciaVentas", resultados, "ZONObtenerSubgerenciasVentas");
            //@ssaavedr, al no ser oblig. la region la zona debera estar vacia (inc.: BELC300024045)    asignar("COMBO", "cbZona", resultados, "ZONObtenerZonas");
            asignar("COMBO", "cbRegion", resultados, "ZONObtenerRegiones");
        }

        
        
        /*  -- VERSION ANTERIOR --  
        ComposerViewElementList cv = crearParametrosEntrada();
        ConectorComposerView conector = new ConectorComposerView(cv, this.getRequest());
        conector.ejecucion();
        DruidaConector resultados = conector.getConector();
        traza(" 4 " + resultados.getXML());

        if(pestania.longValue() == 2){
            traza("asigna a la pantalla de codigosConfiguracion");
            asignar("COMBO","cbGrupoSolicitud",resultados,"CARGruposSolicitud");
            asignar("COMBO","cbIndicadorValidacion",resultados,"CARIndicadoresValidacion");
            asignar("COMBO","cbNivelRiesgo",resultados,"CARNivelesRiesgo");
        }else{
            traza("asigna a la pantalla de unidades administrativas");
            asignar("COMBO","cbCodConfiguracion",resultados,"CARCodigosConfiguracion");
            asignar("COMBO","cbNivelRiesgo",resultados,"CARNivelesRiesgo");
            asignar("COMBO","cbGrupoSolicitud",resultados,"CARGruposSolicitud");
            asignar("COMBO","cbMarca",resultados,"SEGConsultaMarcas");
            asignar("COMBO","cbCanal",resultados,"SEGConsultaCanales");
            asignar("COMBO","cbSubgerenciaVentas",resultados,"ZONObtenerSubgerenciasVentas");
            asignar("COMBO","cbRegion",resultados,"ZONObtenerRegiones");
            asignar("COMBO","cbZona",resultados,"ZONObtenerZonas");
            asignar("COMBO","cbNivelRiesgoInicial",resultados,"CARNivelesRiesgo");
        }
        */
    }

    private ComposerViewElementList crearParametrosEntrada()
        throws Exception {
        traza("metodo crearParametrosEntrada() ");

        DTOOID dtoOid = new DTOOID();
        dtoOid.setOidPais(pais);
        dtoOid.setOidIdioma(idioma);

        DTOBelcorp dtoBel = new DTOBelcorp();
        dtoBel.setOidPais(pais);
        dtoBel.setOidIdioma(idioma);

        DTOUnidadAdministrativa dtoUA = new DTOUnidadAdministrativa();
        dtoUA.setOidPais(pais);
        dtoUA.setOidIdioma(idioma);

        ComposerViewElementList lista = new ComposerViewElementList();

        //combo codigo configuracion
        ComposerViewElement cbCC = new ComposerViewElement();
        cbCC.setIDBusiness("CARCodigosConfiguracion");
        cbCC.setDTOE(dtoBel);

        //combo nivel de riesgo
        ComposerViewElement cbNR = new ComposerViewElement();
        cbNR.setIDBusiness("CARNivelesRiesgo");
        cbNR.setDTOE(dtoOid);

        //combo grupo solicitud
        ComposerViewElement cbGS = new ComposerViewElement();
        cbGS.setIDBusiness("CARGruposSolicitud");
        cbGS.setDTOE(dtoOid);

        //combo marcas
        ComposerViewElement cbMar = new ComposerViewElement();
        cbMar.setIDBusiness("SEGConsultaMarcas");
        cbMar.setDTOE(dtoBel);
        cbMar.setPosOID((byte) 0);
        cbMar.setPosDesc((byte) 1);

        //combo canal
        ComposerViewElement cbCanales = new ComposerViewElement();
        cbCanales.setIDBusiness("SEGConsultaCanales");
        cbCanales.setDTOE(dtoBel);

        //cbCanales.setPosOID((byte)0);
        //cbCanales.setPosDesc((byte)1);
        ComposerViewElement cbIValidacion = null;

        //if(accion.equals("")){
        //combo Indicador de validacion
        cbIValidacion = new ComposerViewElement();
        cbIValidacion.setIDBusiness("CARIndicadoresValidacion");
        cbIValidacion.setDTOE(dtoBel);

        // }
        //   *******VER ESssssTO******************** ///
        //combo Region
        ComposerViewElement cbReg = new ComposerViewElement();
        cbReg.setIDBusiness("ZONObtenerRegiones");
        cbReg.setDTOE(dtoUA);
        cbReg.setPosOID((byte) 0);
        cbReg.setPosDesc((byte) 5);

        //combo zonas
        ComposerViewElement cbZon = new ComposerViewElement();
        cbZon.setIDBusiness("ZONObtenerZonas");
        cbZon.setDTOE(dtoUA);
        cbZon.setPosOID((byte) 0);
        cbZon.setPosDesc((byte) 5);

        //combo subgerencia de ventas
        ComposerViewElement cbSV = new ComposerViewElement();
        cbSV.setIDBusiness("ZONObtenerSubgerenciasVentas");
        cbSV.setDTOE(dtoUA);
        cbSV.setPosOID((byte) 0);
        cbSV.setPosDesc((byte) 4);

        lista.addViewElement(cbCC);
        lista.addViewElement(cbNR);
        lista.addViewElement(cbGS);
        lista.addViewElement(cbMar);
        lista.addViewElement(cbCanales);

        //if(accion.equals("")){
        traza("entre aca para asignar a la lista");
        lista.addViewElement(cbIValidacion);
        traza("paso 1");

        //}
        lista.addViewElement(cbReg);
        traza("paso 2");
        lista.addViewElement(cbZon);
        traza("paso 3");
        lista.addViewElement(cbSV);
        traza("paso 4");

        return lista;
    }

    private ComposerViewElementList crearParametrosEntradaCorta()
        throws Exception {
        traza("metodo crearParametrosEntrada() ");

        DTOOID dtoOid = new DTOOID();
        dtoOid.setOidPais(pais);
        dtoOid.setOidIdioma(idioma);

        DTOBelcorp dtoBel = new DTOBelcorp();
        dtoBel.setOidPais(pais);
        dtoBel.setOidIdioma(idioma);

        DTOUnidadAdministrativa dtoUA = new DTOUnidadAdministrativa();
        dtoUA.setOidPais(pais);
        dtoUA.setOidIdioma(idioma);

        ComposerViewElementList lista = new ComposerViewElementList();

        ComposerViewElement cbNR = new ComposerViewElement();
        cbNR.setIDBusiness("CARNivelesRiesgo");
        cbNR.setDTOE(dtoOid);

        ComposerViewElement cbGS = new ComposerViewElement();
        cbGS.setIDBusiness("CARGruposSolicitud");
        cbGS.setDTOE(dtoOid);

        ComposerViewElement cbIValidacion = null;
        cbIValidacion = new ComposerViewElement();
        cbIValidacion.setIDBusiness("CARIndicadoresValidacion");
        cbIValidacion.setDTOE(dtoBel);

        ComposerViewElement cbMar = new ComposerViewElement();
        cbMar.setIDBusiness("SEGConsultaMarcas");
        cbMar.setDTOE(dtoBel);
        cbMar.setPosOID((byte) 0);
        cbMar.setPosDesc((byte) 1);

        ComposerViewElement cbCanales = new ComposerViewElement();
        cbCanales.setIDBusiness("SEGConsultaCanales");
        cbCanales.setDTOE(dtoBel);

        lista.addViewElement(cbNR);
        lista.addViewElement(cbGS);
        lista.addViewElement(cbMar);
        lista.addViewElement(cbCanales);
        lista.addViewElement(cbIValidacion);

        //}
        return lista;
    }

	/**
     * Modificado por Damasia Maneiro - 19/08/2005
     * Inc. 14826
     * Este metodo se encarga de cargar los datos de los combos de la pagina
     * se modifico la carga de cada uno de los elementos de ComposerViewElementList.
     */
    private void cargaCamposCriterios() throws Exception {
        traza(" metodo cargarCamposcriterios() ");

       // ComposerViewElementList cv = crearParametrosEntradaCorta();

		  DTOBelcorp dtobelcorp = new DTOBelcorp();
        dtobelcorp.setOidIdioma(idioma);
        dtobelcorp.setOidPais(pais);
        traza(" -----------> Generó el DTOBelcorp");
        
        //Se crea un DTOOID, "dtooid" y se le asigna el idioma y el pais de la sesion, 
        //ademas al oid se le asigna "NULL".
        DTOOID dtooid = new DTOOID();
        dtooid.setOidIdioma(idioma);
        dtooid.setOidPais(pais);
        dtooid.setOid(null);
        traza(" -----------> Generó el DTOOID");

        //Se crea un DTOFiltroGrupoSolicitud, "dtogrupoSolicitud" y se le asigna el idioma y 
        //el pais de la sesion, ademas al oidCodConf y nivel de riesgo se le asigna "NULL".
        DTOFiltroGrupoSolicitud dtoGrupoSolicitud = new DTOFiltroGrupoSolicitud();
        dtoGrupoSolicitud.setOidIdioma(idioma);
        dtoGrupoSolicitud.setOidPais(pais);
        dtoGrupoSolicitud.setOidCodConf(null);
        dtoGrupoSolicitud.setNivelRiesgo(null);
        traza(" -----------> Generó el DTOFiltroGrupoSolicitud");

        //Se crea un ComposerViewElementList y se le agregan los siguientes ComposerViewElement 
        ComposerViewElementList lista = new ComposerViewElementList();
      
        //1,. ComposerViewElement con: dtooid, MareBusinessID="CARNivelesRiesgo"
        ComposerViewElement cbNR = new ComposerViewElement();
        cbNR.setDTOE(dtooid);
        cbNR.setIDBusiness("CARNivelesRiesgo");
        lista.addViewElement(cbNR);
        
        //2,. ComposerViewElement con: dtogrupoSolicitud, MareBusinessID="CARGruposSolicitud"
        ComposerViewElement cbGS = new ComposerViewElement();
        cbGS.setDTOE(dtoGrupoSolicitud);
        cbGS.setIDBusiness("CARGruposSolicitud");
        lista.addViewElement(cbGS);
        
        //3,. ComposerViewElement con: dtobelcorp, MareBusinessID="CARCodigosConfiguracion"
        ComposerViewElement cbCC = new ComposerViewElement();
        cbCC.setDTOE(dtobelcorp);
        cbCC.setIDBusiness("CARCodigosConfiguracion");
        lista.addViewElement(cbCC);
        
        //4,. ComposerViewElement con: dtobelcorp, MareBusinessID="CARIndicadoresValidacion"
        ComposerViewElement indVal = new ComposerViewElement();
        indVal.setDTOE(dtobelcorp);
        indVal.setIDBusiness("CARIndicadoresValidacion");
        lista.addViewElement(indVal);
        
        //5,. ComposerViewElement con: dtobelcorp, MareBusinessID="SEGConsultaMarcas", 
        ComposerViewElement marcas = new ComposerViewElement();
        marcas.setDTOE(dtobelcorp);
        marcas.setIDBusiness("SEGConsultaMarcas");
        lista.addViewElement(marcas);
        
        //6,. ComposerViewElement con: dtobelcorp, MareBusinessID="SEGConsultaCanales", 
        ComposerViewElement canales = new ComposerViewElement();
        canales.setDTOE(dtobelcorp);
        canales.setIDBusiness("SEGConsultaCanales");
        lista.addViewElement(canales);
        
        ConectorComposerView conector = new ConectorComposerView(lista,
                this.getRequest());
     
        conector.ejecucion();

        DruidaConector resultados = conector.getConector();
        traza(" 4 " + resultados.getXML());

		  asignar("COMBO", "cbNivelRiesgo", resultados, "CARNivelesRiesgo");
        asignar("COMBO", "cbGrupoSolicitud", resultados, "CARGruposSolicitud");

        //asignar("COMBO","cbIndicadorValidacion",resultados,"CARIndicadoresValidacion");
      
        asignar("COMBO", "cbMarca", resultados, "SEGConsultaMarcas");
        asignar("COMBO", "cbCanal", resultados, "SEGConsultaCanales");
    }

    /*******FECHA**************/
    private String dateToString(Date dFecha) throws Exception {
        String formato = UtilidadesSession.getFormatoFecha(this);
        formato = formato.replace('m', 'M');

        SimpleDateFormat miFecha = new SimpleDateFormat(formato);
        String fechaRes = miFecha.format(dFecha);
        traza("fechaRes: " + fechaRes);

        return fechaRes;
    }

    private Date toDate(String sFecha) throws Exception {
        String formatoFecha = UtilidadesSession.getFormatoFecha(this);

        //formatoFecha = formatoFecha.replace('m', 'M');      
        return this.toDate(sFecha, formatoFecha);
    }

    private Date toDate(String sFecha, String formatoFecha)
        throws Exception {
        traza("formatoSesion: " + formatoFecha);

        //formatoFecha = formatoFecha.replace("m","M");
        formatoFecha = formatoFecha.replace('m', 'M');

        //SimpleDateFormat miFecha = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat miFecha = new SimpleDateFormat(formatoFecha);

        /* La fecha viene de la forma dd/MM/yyyy */
        java.util.Date fecha = miFecha.parse(sFecha);
        miFecha = new SimpleDateFormat(formatoFecha);

        String fechaRes = miFecha.format(fecha);
        fecha = miFecha.parse(fechaRes);
        traza(fechaRes);

        //java.sql.Date sql = new java.sql.Date(fecha.getTime() + (86400*1000));
        java.sql.Date sql = new java.sql.Date(fecha.getTime());
        traza("sql Date: " + sql.toString());

        return sql;
    }

    private void guardarCodigo() throws Exception {
        traza("**************** Entre a guardarCodigo");

        DTOCodigoConfiguracion dtoCodConf = new DTOCodigoConfiguracion();

        recuperaDatosPantalla();
        dtoCodConf.setOidPais(pais);

        if ((oidCodConf == null) || (oidCodConf.equals(""))) {
            dtoCodConf.setOidCodConf(new Long(-1));
        } else {
            dtoCodConf.setOidCodConf(new Long(oidCodConf));
        }

        dtoCodConf.setCodConf(txtCodConfiguracion);
        dtoCodConf.setNivelRiesgo((cbNivelRiesgo == "") ? null
                                                        : Long.valueOf(
                cbNivelRiesgo));
        dtoCodConf.setGrupoSolicitud((cbGrupoSolicitud == "") ? null
                                                              : Long.valueOf(
                cbGrupoSolicitud));
        dtoCodConf.setValDiasDeuda(DiasDeudaVencida.equals("S") ? Boolean.TRUE
                                                                : Boolean.FALSE);

        if ((txtDiasDeudaVencidaPermitida != null) &&
                !(txtDiasDeudaVencidaPermitida.equals(""))) {
            dtoCodConf.setDiasDeudaVenPerm(Integer.valueOf(
                    txtDiasDeudaVencidaPermitida));
        }

        dtoCodConf.setValLineaCredito(LineaCredito.equals("S") ? Boolean.TRUE
                                                               : Boolean.FALSE);

        if ((txtFechaVigenciaDesde != null) &&
                !(txtFechaVigenciaDesde.equals(""))) {
            traza("************ La fecha desde " + txtFechaVigenciaDesde);

            Date fec = this.toDate(txtFechaVigenciaDesde);
            String sFec = fec.toString();
            traza("************ La fecha despues del toDate: " + sFec);
            dtoCodConf.setFechaVigenciaDesde(toDate(txtFechaVigenciaDesde));
        }

        if ((txtFechaVigenciaHasta != null) &&
                !(txtFechaVigenciaHasta.equals(""))) {
            dtoCodConf.setFechaVigenciaHasta(toDate(txtFechaVigenciaHasta));
        }

        if ((cbIndicadorValidacion != null) &&
                !(cbIndicadorValidacion.equals(""))) {
            dtoCodConf.setIndicadorValidacion(Long.valueOf(
                    cbIndicadorValidacion));
        }

        if ((txtPorcentaje != null) && !(txtPorcentaje.equals(""))) {
            dtoCodConf.setPorcentajeValidacion(Float.valueOf(txtPorcentaje));
        }

        dtoCodConf.setValMontoMaximo(MontoMaximo.equals("S") ? Boolean.TRUE
                                                             : Boolean.FALSE);

        if ((txtMontoMaximoPermitido != null) &&
                !(txtMontoMaximoPermitido.equals(""))) {
            dtoCodConf.setMontoMaximoPermitido(new BigDecimal(
                    txtMontoMaximoPermitido));
        }

        dtoCodConf.setValporcentajeMaximo(PorcentajeMaximo.equals("S")
            ? Boolean.TRUE : Boolean.FALSE);

        if ((txtPorcentajeMaximoPermitido != null) &&
                !(txtPorcentajeMaximoPermitido.equals(""))) {
            dtoCodConf.setPorcentajeMaximoPermitido(Float.valueOf(
                    txtPorcentajeMaximoPermitido));
        }

        if ((txtNDiasAdicionales != null) && !(txtNDiasAdicionales.equals(""))) {
            dtoCodConf.setNumDiasAdicionales(Integer.valueOf(
                    txtNDiasAdicionales));
        }

        MareBusinessID id = new MareBusinessID("CARCodigoConfGuardar");
        Vector paramEntrada = new Vector();
        dtoCodConf.setIpCliente(UtilidadesBelcorp.getIPCliente(this));
        dtoCodConf.setPrograma(UtilidadesSession.getFuncion(this));

        traza("**************** El dto es " + dtoCodConf);
        paramEntrada.add(dtoCodConf);
        paramEntrada.add(id);
        traza("*************** Antes de conectar");

        DruidaConector con = conectar("CARGuardarCodigoConf", paramEntrada);
        traza("*************** Despues de conectar");
    }

    private void guardarAsignaciones() throws Exception {
        String strListado = conectorParametro("hDatosLista");
        traza(" :" + strListado);

        String[] arrAsignacion = construirLineas(strListado, "#");
        traza("Este son las lineas de la pagina: " + arrAsignacion.toString());

        for (int i = 0; i < arrAsignacion.length; i++) {
            traza("Linea uno: " + arrAsignacion[i]);
        }

        DTOAsignaciones dtoAsignaciones = obtenerAsignaciones(arrAsignacion);
        traza("Ya cree el dtoAsignaciones...");

        MareBusinessID idBusiness = new MareBusinessID(
                "CARAsignaCodConfGuardar");
        traza("Creo el idBusiness...");

        //Setear ipCliente y programa
        dtoAsignaciones.setIpCliente(UtilidadesBelcorp.getIPCliente(this));
        dtoAsignaciones.setPrograma(UtilidadesSession.getFuncion(this));
        
        // PARA QUE NO PINCHE EN 'MONCARParametrizacion.guardarAsignacionesCod(DTO)'
        dtoAsignaciones.setOidPais(pais);
        // PARA QUE NO PINCHE EN 'MONCARParametrizacion.guardarAsignacionesCod(DTO)'

        Vector paramEntrad = new Vector();
        paramEntrad.addElement(dtoAsignaciones);
        paramEntrad.addElement(idBusiness);
        traza("Ya se seteo el vector...");

        DruidaConector conector = conectar("CARGuardarAsignaCod", paramEntrad);
        traza("Se invoco al conector....");
    }

    private void consultarCodig() throws Exception {
        /*
         * Creo un DTOOID y le asigna el oid recibido desde la pantalla.
        Crear el IDBusiness="CARCodConfConsulta"
        Ejecuta el conector "CARConsultaCodigoConf"
        Se asgina el resultado de la llamada al conector a la propiedad "resp" de la LP.
        Si se recibe una MAREException se muestran la ventana de error al usuario con el mensaje recibido en la Excepcion
         * */
        traza("el oid es " + oid);

        DTOOID dtoOid = new DTOOID();
        dtoOid.setOidPais(pais);
        dtoOid.setOidIdioma(idioma);
        dtoOid.setOid(new Long(oid));        

        traza("dtoOid " + dtoOid);

        MareBusinessID id = new MareBusinessID("CARCodConfConsulta");
        Vector paramEntrada = new Vector();
        paramEntrada.add(dtoOid);
        paramEntrada.add(id);
        traza("los parametros de entrada son " + paramEntrada);

        traza("****************************** antes de conectar con 'CARConsultaCodigoConf' ");
        DruidaConector con = conectar("CARConsultaCodigoConf", paramEntrada);
        traza("****************************** después de conectar con 'CARConsultaCodigoConf' ");
        
        dtoCodConf = (DTOCodigoConfiguracion) con.objeto(
                "DTOCodigoConfiguracion");         
        traza("dtoCodConf  " + dtoCodConf.toString());
    }

/*
Modificado por: Cristian Valenzuela
Incidencia bloqueante: V_CAR_01
Fecha: 12/12/2006
Comentario: Al cargar la pantalla modal se recuperaban
4700 registros y se caia la aplicacion, ahora se
carga la lista usando el configurar paginado 
y recuperando solo los primeros 20 registros
*/

    private void llenarCamposCodigo(Boolean copia) throws Exception {
        traza("LPParametrosCAR.llenarCamposCodigo() - Entrada");
        traza("EL DTO dtoCodConf  ES " + dtoCodConf);

        //String strAsignaciones = strObtenerAsignaciones(dtoCodConf.getAsignaciones());
        //asignarAtributo("VAR", "hidAsignaciones", "valor", strAsignaciones);
        //traza("Paso 1 strAsignaciones " + strAsignaciones);

        String codConf = dtoCodConf.getCodConf();

        if (!copia.booleanValue()) {
            asignarAtributo("VAR", "hidCodConf", "valor", "");
        } else {
            asignarAtributo("VAR", "hidCodConf", "valor", codConf);
        }

        Long nivelRiesgo = dtoCodConf.getNivelRiesgo();
        asignarAtributo("VAR", "hidNivelRiesgo", "valor", nivelRiesgo.toString());

        Long grupoSolicitud = dtoCodConf.getGrupoSolicitud();
        asignarAtributo("VAR", "hidGrupoSolicitud", "valor",
            grupoSolicitud.toString());

        Boolean valDiasDeuda = dtoCodConf.getValDiasDeuda();
        asignarAtributo("VAR", "hidIndDiasDeuda", "valor",
            valDiasDeuda.toString());

        if ((dtoCodConf.getDiasDeudaVenPerm() != null) &&
                !(dtoCodConf.getDiasDeudaVenPerm().equals(""))) {
            Integer diasDeudaVenPerm = dtoCodConf.getDiasDeudaVenPerm();
            asignarAtributo("VAR", "hidDiasDeuda", "valor",
                diasDeudaVenPerm.toString());
        }

        Boolean valLineaCredito = dtoCodConf.getValLineaCredito();
        asignarAtributo("VAR", "hidIndLineaCredito", "valor",
            valLineaCredito.toString());

        if ((dtoCodConf.getFechaVigenciaDesde() != null) &&
                !(dtoCodConf.getFechaVigenciaDesde().equals(""))) {
            Date fechaVigenciaDesde = dtoCodConf.getFechaVigenciaDesde();
            asignarAtributo("VAR", "hidFechaDesde", "valor",
                (this.dateToString(fechaVigenciaDesde)).toString());
        }

        if ((dtoCodConf.getFechaVigenciaHasta() != null) &&
                !(dtoCodConf.getFechaVigenciaHasta().equals(""))) {
            Date fechaVigenciaHasta = dtoCodConf.getFechaVigenciaHasta();
            asignarAtributo("VAR", "hidFechaHasta", "valor",
                (this.dateToString(fechaVigenciaHasta)).toString());
        }

        if ((dtoCodConf.getIndicadorValidacion() != null) &&
                !(dtoCodConf.getIndicadorValidacion().equals(""))) {
            Long indicadorValidacion = dtoCodConf.getIndicadorValidacion();
            asignarAtributo("VAR", "hidIndValidacion", "valor",
                indicadorValidacion.toString());
        }

        traza("el porc validacion es " + dtoCodConf.getPorcentajeValidacion());

        if ((dtoCodConf.getPorcentajeValidacion() != null) &&
                !(dtoCodConf.getPorcentajeValidacion().equals(""))) {
            Float fPor = dtoCodConf.getPorcentajeValidacion();
            traza("*********** fPor " + fPor);

            String sPor = new String(fPor.toString());
            traza("*********** sPor " + sPor);

            String sPorcentajeValidacion = UtilidadesBelcorp.formateaNumeroSICC(sPor,
                    this.FORMATO_DEFAULT, this);
            traza("*********** sPorcentajeValidacion " + sPorcentajeValidacion);
            asignarAtributo("VAR", "hidPorcValidacion", "valor",
                sPorcentajeValidacion);
        }

        Boolean valMontoMax = dtoCodConf.getValMontoMaximo();
        asignarAtributo("VAR", "hidIndMontoMax", "valor", valMontoMax.toString());
        traza("Paso 13");

        if ((dtoCodConf.getMontoMaximoPermitido() != null) &&
                !(dtoCodConf.getMontoMaximoPermitido().equals(""))) {
            Long lMonto = new Long(dtoCodConf.getMontoMaximoPermitido()
                                             .longValue());
            traza("*************** lMonto " + lMonto);

            Double dMontoMaximo = new Double(dtoCodConf.getMontoMaximoPermitido()
                                                       .doubleValue());
            traza("*************** dMontoMaximo " + dMontoMaximo);

            String sMontoMaximo = new String(dMontoMaximo.toString());
            traza("************ sMontoMaximo " + sMontoMaximo);

            String sMonto = UtilidadesBelcorp.formateaNumeroSICC(sMontoMaximo,
                    this.FORMATO_DEFAULT, this);
            traza("************ sMonto " + sMonto);

            asignarAtributo("VAR", "hidMontoMax", "valor", sMonto);
        }

        traza("Paso 14");

        Boolean valPorcMaximo = dtoCodConf.getValporcentajeMaximo();
        asignarAtributo("VAR", "hidIndPorcMax", "valor",
            valPorcMaximo.toString());
        traza("Paso 15");

        if ((dtoCodConf.getPorcentajeMaximoPermitido() != null) &&
                !(dtoCodConf.getPorcentajeMaximoPermitido().equals(""))) {
            Float fPorcentajeMaximo = dtoCodConf.getPorcentajeMaximoPermitido();
            traza("************** fPorcentajeMaximo " + fPorcentajeMaximo);

            String sPorcentajeMax = new String(fPorcentajeMaximo.toString());
            traza("************** sPorcentajeMax " + sPorcentajeMax);

            String sPorcentaje = UtilidadesBelcorp.formateaNumeroSICC(sPorcentajeMax,
                    this.FORMATO_DEFAULT, this);
            traza("************** sPorcentaje " + sPorcentaje);
            asignarAtributo("VAR", "hidPorcMaxPerm", "valor", sPorcentaje);
        }

        traza("Paso 16");

        if ((dtoCodConf.getNumDiasAdicionales() != null) &&
                !(dtoCodConf.getNumDiasAdicionales().equals(""))) {
            Integer nroDiasAdicionales = dtoCodConf.getNumDiasAdicionales();
            asignarAtributo("VAR", "hidDiasAdici", "valor",
                nroDiasAdicionales.toString());
        }

        traza("Paso 17");

        Long oidCodConf = dtoCodConf.getOidCodConf();
        traza("el oid " + oidCodConf.toString());

        if (!accion.equals("copiaCodConf")) {
            asignarAtributo("VAR", "oid", "valor", oidCodConf.toString());
        }
    }

    private String strObtenerAsignaciones(RecordSet rAsignaciones)
        throws Exception {
        String asignaciones = "";

        traza("Esta es la cantidad de registros: " +
            rAsignaciones.getRowCount());

        for (int i = 0; i < rAsignaciones.getRowCount(); i++) {
            Long oidAsig = new Long(((BigDecimal) rAsignaciones.getValueAt(i, 0)).longValue());
            traza("paso 1");

            String codConf = (String) rAsignaciones.getValueAt(i, 1);
            traza("paso 2");

            String nivelRiesgo = (String) rAsignaciones.getValueAt(i, 2);
            traza("paso 3");

            String grupoSolicitud = (String) rAsignaciones.getValueAt(i, 3);
            traza("paso 4");

            String marca = (String) rAsignaciones.getValueAt(i, 4);
            traza("paso 5");

            String canal = (String) rAsignaciones.getValueAt(i, 5);
            traza("paso 6");

            String subGerencia = (String) rAsignaciones.getValueAt(i, 6);
            traza("paso 7");

            String region = (String) rAsignaciones.getValueAt(i, 7);
            traza("paso 8");

            String zona = (String) rAsignaciones.getValueAt(i, 8);
            traza("paso 9");

            BigDecimal bdLinea = (BigDecimal) rAsignaciones.getValueAt(i, 9);
            traza("*********** bdLinea " + bdLinea);

            Float fLinea = new Float(bdLinea.floatValue());
            traza("*********** fLinea " + fLinea);

            String sValor = new String(fLinea.toString());
            traza("*********** sValor " + sValor);

            String linCreIni = UtilidadesBelcorp.formateaNumeroSICC(sValor,
                    this.FORMATO_DEFAULT, this);

            traza("*********** linCreIni " + linCreIni);

            //String linCreIni       = ((BigDecimal) rAsignaciones.getValueAt(i,9)).toString();
            traza("paso 10");

            String niveRiesIni = (String) rAsignaciones.getValueAt(i, 10);
            traza("paso 11");

            Long oidCodConf = new Long(((BigDecimal) rAsignaciones.getValueAt(
                        i, 11)).longValue());
            traza("paso 12");

            Long oidNivelRiesgo = new Long(((BigDecimal) rAsignaciones.getValueAt(
                        i, 12)).longValue());
            traza("paso 13");

            Long oidGrupoSolicitud = new Long(((BigDecimal) rAsignaciones.getValueAt(
                        i, 13)).longValue());
            traza("paso 14");

            Long oidMarca = new Long(((BigDecimal) rAsignaciones.getValueAt(i,
                        14)).longValue());
            traza("paso 15");

            Long oidCanal = new Long(((BigDecimal) rAsignaciones.getValueAt(i,
                        15)).longValue());
            traza("paso 16");

            Long oidSGV = new Long(((BigDecimal) rAsignaciones.getValueAt(i, 16)).longValue());
            traza("paso 17");

            Long oidRegion = new Long(((BigDecimal) rAsignaciones.getValueAt(
                        i, 17)).longValue());
            traza("paso 18");

            Long oidZona = new Long(((BigDecimal) rAsignaciones.getValueAt(i, 18)).longValue());
            traza("paso 19");

            Long oidNiveRiesini = new Long(((BigDecimal) rAsignaciones.getValueAt(
                        i, 19)).longValue());
            traza("paso 20");

            asignaciones += (oidAsig + "@" + codConf + "@" + nivelRiesgo + "@" +
            grupoSolicitud + "@" + marca + "@" + canal + "@" + subGerencia +
            "@" + region + "@" + zona + "@" + linCreIni + "@" + niveRiesIni +
            "@" + oidCodConf + "@" + oidNivelRiesgo + "@" + oidGrupoSolicitud +
            "@" + oidMarca + "@" + oidCanal + "@" + oidSGV + "@" + oidRegion +
            "@" + oidZona + "@" + oidNiveRiesini + "|");
        }

        return asignaciones;
    }

    //	private void consultarCodig(){}
    private void recuperaDatosPantalla() throws Exception {
        traza("*************** Entre a recuperaDatosPantalla");

        oidCodConf = conectorParametroLimpia("oid", "", true);
        traza("oidCodConf " + oidCodConf);

        txtCodConfiguracion = conectorParametroLimpia("txtCodConfiguracion",
                "", true);
        traza("txtCodConfiguracion " + txtCodConfiguracion);

        cbNivelRiesgo = conectorParametroLimpia("cbNivelRiesgo", "", true);
        traza("cbNivelRiesgo " + cbNivelRiesgo);

        cbGrupoSolicitud = conectorParametroLimpia("cbGrupoSolicitud", "", true);
        traza("cbGrupoSolicitud " + cbGrupoSolicitud);

        DiasDeudaVencida = conectorParametroLimpia("DiasDeudaVencida", "", true);
        traza("DiasDeudaVencida " + DiasDeudaVencida);

        txtDiasDeudaVencidaPermitida = conectorParametroLimpia("txtDiasDeudaVencidaPermitida",
                "", true);
        traza("txtDiasDeudaVencidaPermitida " + txtDiasDeudaVencidaPermitida);

        LineaCredito = conectorParametroLimpia("LineaCredito", "", true);
        traza("LineaCredito " + LineaCredito);

        txtFechaVigenciaDesde = conectorParametroLimpia("txtFechaVigenciaDesde",
                "", true);
        traza("txtFechaVigenciaDesde " + txtFechaVigenciaDesde);

        txtFechaVigenciaHasta = conectorParametroLimpia("txtFechaVigenciaHasta",
                "", true);
        traza("txtFechaVigenciaHasta " + txtFechaVigenciaHasta);

        cbIndicadorValidacion = conectorParametroLimpia("cbIndicadorValidacion",
                "", true);
        traza("cbIndicadorValidacion " + cbIndicadorValidacion);

        txtPorcentaje = conectorParametroNumero("txtPorcentaje",
                this.FORMATO_DEFAULT);
        traza("txtPorcentaje " + txtPorcentaje);

        MontoMaximo = conectorParametroLimpia("MontoMaximo", "", true);
        traza("MontoMaximo " + MontoMaximo);

        txtMontoMaximoPermitido = conectorParametroNumero("txtMontoMaximoPermitido",
                this.FORMATO_DEFAULT);
        traza("txtMontoMaximoPermitido " + txtMontoMaximoPermitido);

        PorcentajeMaximo = conectorParametroLimpia("PorcentajeMaximo", "", true);
        traza("PorcentajeMaximo " + PorcentajeMaximo);

        txtPorcentajeMaximoPermitido = conectorParametroNumero("txtPorcentajeMaximoPermitido",
                this.FORMATO_DEFAULT);
        traza("txtPorcentajeMaximoPermitido " + txtPorcentajeMaximoPermitido);

        txtNDiasAdicionales = conectorParametroLimpia("txtNDiasAdicionales",
                "", true);
        traza("txtNDiasAdicionales " + txtNDiasAdicionales);
    }

    private String[] construirLineas(String elementos, String delim)
        throws Exception {
        StringTokenizer stk = new StringTokenizer(elementos, delim);
        String[] arr = new String[stk.countTokens()];
        int cuenta = 0;

        while (stk.hasMoreTokens()) {
            arr[cuenta] = stk.nextToken();
            cuenta++;
        }

        return arr;
    }

    public void eliminar() throws Exception {
        pagina("salidaGenerica");

        DTOEliminarCodigoConf dto = new DTOEliminarCodigoConf();

        String paramCarte = conectorParametroLimpia("hidParamCarte", "", true);
        String asignaciones = conectorParametroLimpia("hidAsignaciones", "",
                true);
        traza("paramCarte: " + paramCarte);
        traza("asignaciones: " + asignaciones);

        StringTokenizer stkParamCarte = new StringTokenizer(paramCarte, ",");
        Long[] oidsParamCarte = new Long[stkParamCarte.countTokens()];

        StringTokenizer stkAsignaciones = new StringTokenizer(asignaciones, ",");
        Long[] oidsAsignaciones = new Long[stkAsignaciones.countTokens()];

        int contadorParamCarte = 0;
        int contadorAsignaciones = 0;

        if (!paramCarte.equals("")) {
            while (stkParamCarte.hasMoreTokens()) {
                StringTokenizer stkParseoParamCarte = new StringTokenizer(stkParamCarte.nextToken(),
                        "_");
                traza("stkParseoParamCarte.countTokens(): " +
                    stkParseoParamCarte.countTokens());

                while (stkParseoParamCarte.hasMoreTokens()) {
                    stkParseoParamCarte.nextToken();
                    oidsParamCarte[contadorParamCarte] = new Long(stkParseoParamCarte.nextToken());
                    contadorParamCarte++;
                }
            }
        }

        if (!asignaciones.equals("")) {
            while (stkAsignaciones.hasMoreTokens()) {
                oidsAsignaciones[contadorAsignaciones] = new Long(stkAsignaciones.nextToken());
                contadorAsignaciones++;
            }
        }

        dto.setCodigos(oidsParamCarte);
        dto.setAsignaciones(oidsAsignaciones);

        MareBusinessID id = new MareBusinessID("CARCodigoConfEliminar");

        Vector param = new Vector();
        param.add(dto);
        param.add(id);

        DruidaConector con = conectar("CARGuardarCodigoConf", param);

        asignarAtributo("VAR", "ejecutar", "valor", "recargaLista();");

        //.Ejecuta el conector "CARGuardarAsignaCod" 
        //Si se recibe una MAREException se muestran la ventana de error al usuario con el mensaje recibido en la Excepcion. 
        //Si no se genera una pagina para que se cargue en la ventana oculta con una funciona javascript que llame al metodo refrescar de la listaEditable y luego se cierre. 
    }

    private DTOAsignaciones obtenerAsignaciones(String[] asignaciones)
        throws Exception {
        DTOAsignaciones dtoAsignaciones = new DTOAsignaciones();
        ArrayList aAsign = new ArrayList();

        for (int i = 0; i < asignaciones.length; i++) {
            DTOAsignacionCod dtoAsignacionesCod = new DTOAsignacionCod();
            String[] strAsign = construirLineas(asignaciones[i], "|");

            traza("Esta es una linea de la pantalla: ");
            for (int j = 0; j < strAsign.length; j++) {
                traza("Atributo: " + strAsign[j]);
            }

            if (!strAsign[0].startsWith("cod")) {
                dtoAsignacionesCod.setOidAsignacion(new Long(strAsign[0]));
            }

            //mamontie Incidencia Peru DBLG000000334 
            traza("strAsign[1] " + strAsign[1]);

            String lineaCreditoInicial = desFormatearNumero(strAsign[1],
                    this.FORMATO_DEFAULT);

            traza("************* lineaCreditoInicial " + lineaCreditoInicial);
            traza("this.FORMATO_DEFAULT  " + this.FORMATO_DEFAULT);

            traza("***** Asigno 1 " + strAsign[1]);
            dtoAsignacionesCod.setLCIni(((lineaCreditoInicial != null) &&
                !lineaCreditoInicial.equals(""))
                ? new BigDecimal(lineaCreditoInicial) : null);

            //dtoAsignacionesCod.setLCIni(new BigDecimal(strAsign[1]));
            traza("***** Asigno 2 strAsign[2] " + strAsign[2]);
            dtoAsignacionesCod.setOidCodConf((strAsign[2] != "")
                ? new Long(strAsign[2]) : null);
            traza("***** Asigno 3  strAsign[3]  " + strAsign[3]);
            dtoAsignacionesCod.setNivelRiesgo((strAsign[3] != "")
                ? new Long(strAsign[3]) : null);
            traza("***** Asigno 4 strAsign[4]  " + strAsign[4]);
            dtoAsignacionesCod.setGrupoSolicitud((strAsign[4] != "")
                ? new Long(strAsign[4]) : null);
            traza("***** Asigno 5 strAsign[7] " + strAsign[7]);

            //las posiciones 5 y 6 corresponden a marca y canal
            dtoAsignacionesCod.setOidSgv((strAsign[7] != "")
                ? new Long(strAsign[7]) : null);

			/*
            traza("***** Asigno 6 strAsign[8]  " + strAsign[8]);
            dtoAsignacionesCod.setOidRegion((strAsign[8] != "")
                ? new Long(strAsign[8]) : null);
            
			traza("***** Asigno 7  strAsign[9]  " + strAsign[9]);
            dtoAsignacionesCod.setOidZona((strAsign[9] != "")
                ? new Long(strAsign[9]) : null);
			*/

			if (strAsign[8].equals("_")){
				dtoAsignacionesCod.setOidRegion(null);	
			}else{
				traza("***** Asigno 6 strAsign[8]  " + strAsign[8]); 
				dtoAsignacionesCod.setOidRegion(new Long(strAsign[8]));	
			}
			
			
			if (strAsign[9].equals("_")){
				dtoAsignacionesCod.setOidZona(null);	
			}else{
				traza("***** Asigno 7  strAsign[9]  " + strAsign[9]);
				dtoAsignacionesCod.setOidZona(new Long(strAsign[9]));	
			}

            traza("***** Asigno 8 strAsign[10] " + strAsign[10]);
            dtoAsignacionesCod.setNRIni((strAsign[10] != "")
                ? new Long(strAsign[10]) : null);

            traza("Este es el DTO que se genero: " + dtoAsignacionesCod);
            aAsign.add(dtoAsignacionesCod);
        }

        dtoAsignaciones.setAsignaciones(aAsign);

        return dtoAsignaciones;
    }

    private String obtenerCodigoTitulo() throws Exception {
        String codigo = null;

        if (casoDeUso != null) {
            if (casoDeUso.equals("modificar") ||
                    casoDeUso.equals("consultarModificar")) {
                codigo = "0436";
            }

            if (casoDeUso.equals("eliminar") ||
                    casoDeUso.equals("consultarEliminar")) {
                codigo = "0437";
            }

            if (casoDeUso.equals("consultar") ||
                    casoDeUso.equals("consultarDetalle")) {
                codigo = "0438";
            }

            if (casoDeUso.equals("insertar") || casoDeUso.equals("copiar")) {
                codigo = "0435";
            }
        }

        return codigo;
    }
}
