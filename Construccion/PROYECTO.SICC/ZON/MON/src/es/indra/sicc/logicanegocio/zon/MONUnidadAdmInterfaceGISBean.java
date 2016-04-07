package es.indra.sicc.logicanegocio.zon;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.mare.common.mii.services.MareServiceException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.dtos.cra.DTOCriteriosPeriodo;
import es.indra.sicc.dtos.zon.DTOFicheroDisp;
import es.indra.sicc.dtos.zon.DTOLISTUniNSE;
import es.indra.sicc.dtos.zon.DTOListaFicheroDisp;
import es.indra.sicc.dtos.zon.DTOManagerFileResult;
import es.indra.sicc.dtos.zon.DTOUnidadAdmCabecera;
import es.indra.sicc.dtos.zon.DTOUnidadAdmRegistro;
import es.indra.sicc.dtos.zon.DTOUnidadAdministrativa;
import es.indra.sicc.entidades.zon.HistoricoGerentesLideresLocal;
import es.indra.sicc.entidades.zon.HistoricoGerentesLideresLocalHome;
import es.indra.sicc.entidades.zon.RegionLocal;
import es.indra.sicc.entidades.zon.RegionLocalHome;
import es.indra.sicc.entidades.zon.SeccionLocal;
import es.indra.sicc.entidades.zon.SeccionLocalHome;
import es.indra.sicc.entidades.zon.SubGerenciaVentaLocal;
import es.indra.sicc.entidades.zon.SubGerenciaVentaLocalHome;
import es.indra.sicc.entidades.zon.TerritorioAdministrativoLocal;
import es.indra.sicc.entidades.zon.TerritorioAdministrativoLocalHome;
import es.indra.sicc.entidades.zon.TerritorioLocal;
import es.indra.sicc.entidades.zon.TerritorioLocalHome;
import es.indra.sicc.entidades.zon.ZonaLocal;
import es.indra.sicc.entidades.zon.ZonaLocalHome;
import es.indra.sicc.logicanegocio.cra.MONPeriodos;
import es.indra.sicc.logicanegocio.cra.MONPeriodosHome;
import es.indra.sicc.logicanegocio.mae.MONClientes;
import es.indra.sicc.logicanegocio.mae.MONClientesHome;
import es.indra.sicc.logicanegocio.seg.MONMantenimientoSEG;
import es.indra.sicc.logicanegocio.seg.MONMantenimientoSEGHome;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.logicanegocio.seg.ConstantesSEG;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import java.text.SimpleDateFormat;
import java.io.File;

import java.math.BigDecimal;
import java.rmi.RemoteException;

import java.sql.Timestamp;

import java.util.Collection;
import java.util.Date;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.ArrayList;

import javax.ejb.CreateException;
import javax.ejb.DuplicateKeyException;
import javax.ejb.FinderException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import javax.persistence.NoResultException;

import javax.persistence.PersistenceException;

import javax.rmi.PortableRemoteObject;


/*
 * Modelo: 'SICC-DMCO-ZON-201-305'
 * 15-06-2005 - rgiorgi: inc. 18887
 */
public class MONUnidadAdmInterfaceGISBean implements SessionBean{//, IManagerFileInterface {
    private static final int MAX_UA_CODE = 5;
    private static final String ZON_PROCESAR_CREAR_UA = "ZONProcesarFicheroCrearUA";
    private static final String ZON_PROCESAR_ELIMINAR_UA = "ZONProcesarFicheroEliminarUA";
    private static final String CODIGO_BAJA = "B";
    private static final String CODIGO_ALTA = "A";
    private static final String UA_SEPARATOR = "/";
    private static final String SEP_DETALLE = ":";
    private SessionContext ctx;
    private String codigoError = null;
    private Hashtable entidadCreadasH = null;
    private Hashtable entidadCreadasSinSeccionH = null;
    private FileInterfaceMensajes fim = new FileInterfaceMensajes();
    private MONMantenimientoSEG monMSEG = null;
    private MONClientes mon = null;	
    private String terminoOK = "S";
    private boolean activa = false;
    private Long oidPais = null;
    private Long oidMarca = null;
    private Long oidCanal = null;
    private Long oidCliente = null;
    private String cliente = null;
    private String operacion = null;
    private String dato1 = null;
    private String dato2 = null;
    private String dato3 = null;
    private String dato4 = null;
    private String dato5 = null;
    private String dato6 = null;
    private String dato7 = null;
    private String ipCliente = "";
    private String programa = "";
    private BelcorpService bs;
    private Long oidPeriodoFichero = null;
	
    public void ejbCreate() throws CreateException {
        /*try {
            bs = BelcorpService.getInstance();
        } catch(MareMiiServiceNotFoundException mmsnfe) {
            throw new CreateException("MareMiiServiceNotFoundException: " + mmsnfe.getMessage());
        }*/
    }
	
    public void ejbActivate() {}

    public void ejbPassivate() {}

    public void ejbRemove() {}

    public void setSessionContext(SessionContext ctx) {
        this.ctx = ctx;
    }

    //Metodos proveniente de la interfaz IManagerFileInterface.
    public DTOManagerFileResult procesarsinc(DTOFicheroDisp datos)
        throws MareException {
        
        UtilidadesLog.info("MONUnidadAdmInterfaceGISBean.procesarsinc(DTOFicheroDisp datos): Entrada");
        UtilidadesLog.debug("*** datos: "+datos);
        UtilidadesLog.debug("*** datos.getDatos(): "+datos.getDatos());
        
        DTOManagerFileResult result = null;
        Long idProc = null;
        terminoOK = "S";

        this.ipCliente = datos.getIpCliente();
        this.programa = datos.getPrograma();

        // Valida la cabecera
        if(!validarCabecera(datos.getDatos(), datos.getTypeProc(), datos.getPathFichero(), datos.getNombreFichero()).booleanValue()){
            UtilidadesLog.info("MONUnidadAdmInterfaceGISBean.procesarsinc(DTOFicheroDisp datos): Salida");
            UtilidadesLog.error("ERROR AL VALIDAR LA CABECERA");
            ctx.setRollbackOnly();
            throw new MareException(null, null,
                UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_ZON, "", ErroresDeNegocio.PAIS_DE_FICHERO_DIFERENTE_PAIS_ACTIVO));
        }
        // Abre un log para el proceso
        try {
            idProc = this.getMONZONLogLocalHome().create().crearLogProceso(datos.getTypeProc());
            this.getMONUnidadAdmInterfaceGISLocalHome().create().procesar(idProc, datos.getPathFichero(), datos.getTypeProc(), datos.getNombreFichero());
            result = this.obtenerResultado(idProc);
            
            UtilidadesLog.info("MONUnidadAdmInterfaceGISBean.procesarsinc(DTOFicheroDisp datos): Salida");
    
            return result;
        } catch(CreateException re) {
            UtilidadesLog.error("ERROR", re);
            ctx.setRollbackOnly();
            throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch(MareException re) {
            UtilidadesLog.error("ERROR", re);
            ctx.setRollbackOnly();
            throw re;
        } catch(Exception re) {
            UtilidadesLog.error("ERROR", re);
            ctx.setRollbackOnly();
            throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
    }

    public void procesar(Long idProc, String filePath, String typeProc, String filename)
        throws MareException {
        UtilidadesLog.info("MONUnidadAdmInterfaceGISBean.procesar(Long idProc, String filePath, String typeProc, String filename): Entrada");
        
        String fullPath = filePath + File.separator + filename;

        if(typeProc.equals(ZON_PROCESAR_CREAR_UA))
            this.procesarCrearUA(idProc, fullPath, typeProc);
        else if(typeProc.equals(ZON_PROCESAR_ELIMINAR_UA))
            this.procesarEliminarUA(idProc, fullPath, typeProc);

        UtilidadesLog.info("MONUnidadAdmInterfaceGISBean.procesar(Long idProc, String filePath, String typeProc, String filename): Salida");

    }

    /* Método que realiza la creacion de unidad administrativa a partir de una
     * linea de datos (codigo de operacion = 'A' ) desde el fichero.
     * Modelo realizado: SICC-DMCO-ZON-201-304
     **/
    private void procesarCrearUA(Long iDProc, String filePath, String typeProc)
        throws MareException {
        
        UtilidadesLog.info("MONUnidadAdmInterfaceGISBean.procesarCrearUA(Long iDProc, String filePath, String typeProc): Entrada");
        
        //La logica de este metodo esta descripta en el 
        //diagrama de secuencia. Con varios puntos.
        entidadCreadasH = new Hashtable();
        entidadCreadasSinSeccionH = new Hashtable();
        DTOUnidadAdmCabecera dtoC = new DTOUnidadAdmCabecera();
        String filePath1 = filePath.substring(0, filePath.lastIndexOf(File.separator));
        String fileName = filePath.substring(filePath.lastIndexOf(File.separator) + 1, filePath.length());
        String pais_cod;
        String canal_cod;
        String marca_cod;
        String init_period;
        String type_period;
        boolean validaCliente = true;
        terminoOK = "S";
        DTOUnidadAdmRegistro dtoR = new DTOUnidadAdmRegistro();
        DTOUnidadAdministrativa dtoUA = new DTOUnidadAdministrativa();

        String[] codUA = null;

        UnidadAdmFileWrapper fileReader = new UnidadAdmFileWrapper();
        fileReader.abrirArchivo(filePath1, fileName);

        //Obtengo datos de cabecera. Pto 5.
        dtoC = (DTOUnidadAdmCabecera)fileReader.leerCabecera();

        pais_cod = dtoC.getPais();
        marca_cod = dtoC.getMarca();
        canal_cod = dtoC.getCanal();
        type_period = dtoC.getTipoPeriodo();
        init_period = dtoC.getPeriodoInicio();

        // Pto. 8 -- Valida Pais
        try{
            oidPais = obtenerOidPais(pais_cod);
        } catch(MareException me) {
            // Error critico
            generaDetalle(iDProc, typeProc, dtoC.dumpToString(), "M00035");
            reportaResultado(iDProc, typeProc, IManagerFileInterface.PROCESAMIENTO_FINALIZADO_ERROR, "M00035");
            terminoOK = "N";
        }
        // Pto. 10  -- Valida Marca
        try{
            oidMarca = obtenerOidMarca(marca_cod);
        } catch(MareException me) {
            // Error critico
            generaDetalle(iDProc, typeProc, dtoC.dumpToString(), "M00036");
            reportaResultado(iDProc, typeProc, IManagerFileInterface.PROCESAMIENTO_FINALIZADO_ERROR, "M00036");
            terminoOK = "N";
        }
        // Pto. 12  -- Valida Canal
        try{
            oidCanal = obtenerOidCanal(canal_cod);
        } catch(MareException me) {
            // Error critico
            generaDetalle(iDProc, typeProc, dtoC.dumpToString(), "M00037");
            reportaResultado(iDProc, typeProc, IManagerFileInterface.PROCESAMIENTO_FINALIZADO_ERROR, "M00037");
            terminoOK = "N";
        }

        if(terminoOK.equals("S")){
            // Pto. 6 y 16. Chequeo de Periodos.
            //Esta despues porque necesita oidPais, oidMarca y oidCanal
            //activa = true; //TODO Falta ver que pasa con CRA_PERIO.COD_PERI y MONPeriodo.obtenerPeriodosConsulta
            activa = chequeoPeriodo(init_period, type_period, iDProc, typeProc, dtoC);

            //Se busca el tipo de operacion "A". 
            while(((dtoR = this.leerRegistro(fileReader, iDProc, typeProc)) != null) && (terminoOK.equals("S"))) {
                //De forma de insertar una nueva Unidad Administrativa.
                if(dtoR.getTipoOP().equals(CODIGO_ALTA)) {
                    // Unidad Adminstrativa. "Pais","Subgerencia de venta","Region", "Zona", "Seccion" y "Territorio".     
                    operacion = dtoR.getTipoOP();
                    cliente = dtoR.getCliente();
                    //dato1 es el codigo de Unidad Adminstrativa.
                    dato1 = dtoR.getDato1();
                    dato2 = dtoR.getDato2();
                    dato3 = dtoR.getDato3();
                    dato4 = dtoR.getDato4();
                    dato5 = dtoR.getDato5();
                    dato6 = dtoR.getDato6();
                    dato7 = dtoR.getDato7();
                    codUA = getUACode(dato1);

                    dtoUA = new DTOUnidadAdministrativa();
                    dtoUA.setOidCanal(oidCanal);
                    dtoUA.setOidMarca(oidMarca);
                    dtoUA.setOidPais(oidPais);

                    if ((cliente == null) || (cliente.equals("") || (cliente.equals(" ")))) {
                        oidCliente = null;
                        validaCliente = true;											
                    } else {
                        //Pto. 17,18. TODO: FALTA EL ENTITY MAE_CLIEN = CLIENTE BASICO.
                        //Actualmente se realiza con un Tapon. Incidencia 'BELC300000371'
                        oidCliente = obtenerOidCliente(cliente, oidPais);
                        if(oidCliente == null) {
                            validaCliente = false;
                        } else {
                            validaCliente = true;						
                        }
                    }

                    if (!validaCliente) {
                            this.generaDetalle(iDProc, typeProc, dtoR.dumpToString(), "M00018");
                    } else {
                        //Alta de Entidades relacionadas a la Unidad Administrativa.
                        //Pto. 19,20.
                        Long uaOid = null;
                        Long uaOidN = null;

                        // Controla que las entidades a las cuales referencia, ya existen.
                        // y fueron creadas desde este archivo.
                        if((uaOid = controlEntidad(codUA, pais_cod, marca_cod, canal_cod, true)) != null) {
                            //Pto. 19  Se crea la entidad U.A. necesaria y se obtiene su oid.
                            uaOidN = createEntidades(codUA, oidPais, oidMarca, oidCanal, pais_cod, marca_cod, canal_cod, uaOid, activa, dtoUA, iDProc,
                                    typeProc, dtoR);

                            //Se actualiza la tabla de hash.
                            if(uaOidN != null)
                                entidadCreadasH.put(getHashKey(codUA, pais_cod, marca_cod, canal_cod, false), uaOidN);
                        } else {
                            //Entonces segun table a chequear, varian los parametros.
                            uaOid = obtenerUAporCodigo(codUA);

                            if(uaOid != null) {
                                //Pto 19 Se crea la entidad U.A. necesaria y se obtiene su oid.
                                uaOidN = createEntidades(codUA, oidPais, oidMarca, oidCanal, pais_cod, marca_cod, canal_cod, uaOid, activa, dtoUA, iDProc,
                                        typeProc, dtoR);

                                //Se actualiza la tabla de hash con el oid previamente creado.
                                if(uaOidN != null)
                                    entidadCreadasH.put(getHashKey(codUA, pais_cod, marca_cod, canal_cod, false), uaOidN);
                            } else
                                // Se genera error, porque la entidad de la cual se depende
                                // no existe. Y no se puede dar de alta la entidad.
                                this.generaDetalle(iDProc, typeProc, dtoR.dumpToString(), "M00019");
                        }
                    }
                }
            }
        }
        //reportaResultado() Pto. 21
        if(terminoOK.equals("S"))
            reportaResultado(iDProc, typeProc, IManagerFileInterface.PROCESAMIENTO_FINALIZADO_OK, "M00046");
            
        UtilidadesLog.info("MONUnidadAdmInterfaceGISBean.procesarCrearUA(Long iDProc, String filePath, String typeProc): Salida");

    }

    private Long obtenerUAporCodigo(String[] codUA) throws MareException {
        UtilidadesLog.info("MONUnidadAdmInterfaceGISBean.obtenerUAporCodigo(String[] codUA): Entrada");
        
        DAOZON daoZon = new DAOZON();
        Long uaOid = new Long(-1);

        if(checkStr(codUA[0]) && checkStr(codUA[1]) && checkStr(codUA[2]) && checkStr(codUA[3]) && checkStr(codUA[4]))
            //Se controla Seccion, para insertar Territorio.
            uaOid = daoZon.obtenerUAporcodigo(oidMarca, oidCanal, oidPais, codUA[0], codUA[1], codUA[2], codUA[3], null);
        else if(checkStr(codUA[0]) && checkStr(codUA[1]) && checkStr(codUA[2]) && checkStr(codUA[3]) && !checkStr(codUA[4]))
            //Se controla Zona, para insertar Seccion.
            uaOid = daoZon.obtenerUAporcodigo(oidMarca, oidCanal, oidPais, codUA[0], codUA[1], codUA[2], null, null);
        else if(checkStr(codUA[0]) && checkStr(codUA[1]) && checkStr(codUA[2]) && !checkStr(codUA[3]) && !checkStr(codUA[4]))
            //Se controla Region, para insertar Zona.
            uaOid = daoZon.obtenerUAporcodigo(oidMarca, oidCanal, oidPais, codUA[0], codUA[1], null, null, null);
        else if(checkStr(codUA[0]) && checkStr(codUA[1]) && !checkStr(codUA[2]) && !checkStr(codUA[3]) && !checkStr(codUA[4]))
            //Se controla SGV, para insertar REGION
            uaOid = daoZon.obtenerUAporcodigo(oidMarca, oidCanal, oidPais, codUA[0], null, null, null, null);
        else if(checkStr(codUA[0]) && !checkStr(codUA[1]) && !checkStr(codUA[2]) && !checkStr(codUA[3]) && !checkStr(codUA[4]))
            return uaOid;

        UtilidadesLog.info("MONUnidadAdmInterfaceGISBean.obtenerUAporCodigo(String[] codUA): Salida");

        return uaOid;
    }

    /** Retorna una concatenacion de codigos como clave.
     *  El tipo de clave depende de la u.a. que se necesite
     *  crear.
    *  Recibe una variable boolean para sebar si esta buscando una key o si la esta agregando
     * */
    private String getHashKey(String[] codUA, String codPais, String codMarca, String codCanal, boolean busca) {
        UtilidadesLog.info("MONUnidadAdmInterfaceGISBean.getHashKey(String[] codUA, String codPais, String codMarca, String codCanal, boolean busca): Entrada");
        
        String key = "";

        if((codUA[4] != null) && (codUA[4].length() > 0)) {
            if((codUA[4] != null) && (codUA[4].length() == 6) && (codUA[3] != null) && (codUA[3].length() == 1) && (codUA[2] != null)
                && (codUA[2].length() == 4) && (codUA[1] != null) && (codUA[1].length() == 2) && (codUA[0] != null)
                && (codUA[0].length() == 2)) {
                if(busca)
                    key = codUA[0] + codUA[1] + codUA[2] + codUA[3];
                else
                    key = codUA[0] + codUA[1] + codUA[2] + codUA[3] + codUA[4];
            }
        } else if((codUA[3] != null) && (codUA[3].length() > 0)) {
            if((codUA[3] != null) && (codUA[3].length() == 1) && (codUA[2] != null) && (codUA[2].length() == 4) && (codUA[1] != null)
                && (codUA[1].length() == 2) && (codUA[0] != null) && (codUA[0].length() == 2)) {
                if(busca)
                    key = codUA[0] + codUA[1] + codUA[2];
                else
                    key = codUA[0] + codUA[1] + codUA[2] + codUA[3];
            }
        } else if((codUA[2] != null) && (codUA[2].length() > 0)) {
            if((codUA[2] != null) && (codUA[2].length() == 4) && (codUA[1] != null) && (codUA[1].length() == 2) && (codUA[0] != null)
                && (codUA[0].length() == 2)) {
                if(busca)
                    key = codUA[0] + codUA[1];
                else
                    key = codUA[0] + codUA[1] + codUA[2];
            }
        } else if((codUA[1] != null) && (codUA[1].length() > 0)) {
            if((codUA[1] != null) && (codUA[1].length() == 2) && (codUA[0] != null) && (codUA[0].length() == 2)) {
                if(busca)
                    key = codUA[0];
                else
                    key = codUA[0] + codUA[1];
            }
        } else if((codUA[0] != null) && (codUA[0].length() == 2)) {
            if(busca)
                key = codPais + codMarca + codCanal;
            else
                key = codUA[0];
        }
        
        UtilidadesLog.info("MONUnidadAdmInterfaceGISBean.getHashKey(String[] codUA, String codPais, String codMarca, String codCanal, boolean busca): Salida");
        return key;
    }

    /**
     * Este metodo controla que la entidad que se necesita para
     * completar la unidad administrativa, haya sido previamente
     * creada.
     * Ej. codUA[0]=SGV,codUA[1]=Region,codUA[2]=Zona,codUA[3]=Seccion,
     *           codUA[4]=Territorio.
     * Retorn NULL, si no la encuentra. Si la encuentra, retorna el oid.
     * de la entidad de la cual se depende.
     */
    private Long controlEntidad(String[] codUA, String codPais, String codMarca, String codCanal, boolean busca) {
        UtilidadesLog.info("MONUnidadAdmInterfaceGISBean.controlEntidad(String[] codUA, String codPais, String codMarca, String codCanal, boolean busca): Entrada");
        
        String key = null;
        Long result = null;
        key = getHashKey(codUA, codPais, codMarca, codCanal, busca);

        if(key != null)
            result = (Long)entidadCreadasH.get(key);

        UtilidadesLog.info("MONUnidadAdmInterfaceGISBean.controlEntidad(String[] codUA, String codPais, String codMarca, String codCanal, boolean busca): Salida");

        return result;
    }

/**
     * Este metodo controla que la entidad no haya sido previamente
     * creada.
     * Ej. codUA[0]=SGV,codUA[1]=Region,codUA[2]=Zona,codUA[3]=Seccion,
     *           codUA[4]=Territorio.
     * Retorn NULL, si no la encuentra. Si la encuentra, retorna el oid.     
     */
    private Long controlEntidadSinSeccion(String[] codUA) {
        UtilidadesLog.info("MONUnidadAdmInterfaceGISBean.controlEntidadSinSeccion(String[] codUA): Entrada");
        
        String key = null;
        Long result = null;
        key = getHashKeySinSeccion(codUA);

        if(key != null)
            result = (Long)entidadCreadasSinSeccionH.get(key);

        UtilidadesLog.info("MONUnidadAdmInterfaceGISBean.controlEntidadSinSeccion(String[] codUA): Salida");
        return result;
    }




    /** Retorna una concatenacion de codigos como clave.
     *  El tipo de clave depende de la u.a. que se necesite
     *  crear.   
     * */
    private String getHashKeySinSeccion(String[] codUA) {
        UtilidadesLog.info("MONUnidadAdmInterfaceGISBean.getHashKeySinSeccion(String[] codUA): Entrada");
        
        String key = "";

        if((codUA[4] != null) && (codUA[4].length() > 0)) {
            if((codUA[4] != null) && (codUA[4].length() == 6) &&  (codUA[2] != null)
                && (codUA[2].length() == 4) && (codUA[1] != null) && (codUA[1].length() == 2) && (codUA[0] != null)
                && (codUA[0].length() == 2)) {
              
                  key = codUA[0] + codUA[1] + codUA[2] + codUA[4];
            }
        } 
        
        UtilidadesLog.info("MONUnidadAdmInterfaceGISBean.getHashKeySinSeccion(String[] codUA): Salida");
        return key;
    }



    private boolean checkStr(String s) {
        return ((s != null) && (s.length() > 0)) ? true : false;
    }

    private void reportaResultado(Long idProc, String typeProc, Long state, String msg)
        throws MareException {
        UtilidadesLog.info("MONUnidadAdmInterfaceGISBean.reportaResultado(Long idProc, String typeProc, Long state, String msg): Entrada");
        try {
            this.getMONZONLogLocalHome().create().reportarResultado(idProc, typeProc, state, msg);
        } catch(CreateException e) {
            UtilidadesLog.error("ERROR",e);
            codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } catch(Exception e) {
            UtilidadesLog.error("ERROR",e);
            codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } 
        
        UtilidadesLog.info("MONUnidadAdmInterfaceGISBean.reportaResultado(Long idProc, String typeProc, Long state, String msg): Salida");
    }

    /*
     * */
    private void generaDetalle(Long idProc, String typeProc, Object datos, String msg)
        throws MareException {
        
        UtilidadesLog.info("MONUnidadAdmInterfaceGISBean.generaDetalle(Long idProc, String typeProc, Object datos, String msg): Entrada");
        
        try {
            MONZONLogLocal monito = this.getMONZONLogLocalHome().create();
            String aux = logString(datos.toString(),monito);
            monito.agregarDetalle(idProc, typeProc, msg, aux);
            
        } catch(CreateException e) {
            UtilidadesLog.error("ERROR",e);
            codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } catch(Exception e) {
            UtilidadesLog.error("ERROR",e);
            codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }
        
        UtilidadesLog.info("MONUnidadAdmInterfaceGISBean.generaDetalle(Long idProc, String typeProc, Object datos, String msg): Salida");
    }

    private Long obtenerOidPais(String codPais) throws MareException {
        UtilidadesLog.info("MONUnidadAdmInterfaceGISBean.obtenerOidPais(String codPais): Entrada");
        
        Long result = null;

        try {
            MONMantenimientoSEG obj = getMONMantenimientoSEG();
            result = obj.obtenerOidPais(codPais);
        } catch(RemoteException re) {
            codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(re, UtilidadesError.armarCodigoError(codigoError));
        }
        UtilidadesLog.info("MONUnidadAdmInterfaceGISBean.obtenerOidPais(String codPais): Salida");
        return result;
    }

    private Long obtenerOidMarca(String codMarca) throws MareException {
        UtilidadesLog.info("MONUnidadAdmInterfaceGISBean.obtenerOidMarca(String codMarca): Entrada");
        
        Long result = null;

        try {
            MONMantenimientoSEG obj = getMONMantenimientoSEG();
            result = obj.obtenerOidMarca(codMarca);
        } catch(RemoteException re) {
            codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(re, UtilidadesError.armarCodigoError(codigoError));
        }
        
        UtilidadesLog.info("MONUnidadAdmInterfaceGISBean.obtenerOidMarca(String codMarca): Salida");
        return result;
    }

    private Long obtenerOidCanal(String codCanal) throws MareException {
    
        UtilidadesLog.info("MONUnidadAdmInterfaceGISBean.obtenerOidCanal(String codCanal): Entrada");
        
        Long result = null;

        try {
            MONMantenimientoSEG obj = getMONMantenimientoSEG();
            result = obj.obtenerOidCanal(codCanal);
        } catch(RemoteException re) {
            codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(re, UtilidadesError.armarCodigoError(codigoError));
        }
        UtilidadesLog.info("MONUnidadAdmInterfaceGISBean.obtenerOidCanal(String codCanal): Salida");
        return result;
    }

    /** Esta funcion arma un String con el contenido del DTOUnidadAdmCabecera y
    *  el DTOUnidadAdmRegistro. Se concatenan los datos usando el separador ":".
    **/
    private String getDatos(DTOUnidadAdmCabecera dtoC, DTOUnidadAdmRegistro dtoR) {
        UtilidadesLog.info("MONUnidadAdmInterfaceGISBean.getDatos(DTOUnidadAdmCabecera dtoC, DTOUnidadAdmRegistro dtoR)): Entrada");
        
        StringBuffer result = new StringBuffer();
        result.append(dtoC.dumpToString() + SEP_DETALLE + dtoR.dumpToString());
        UtilidadesLog.info("MONUnidadAdmInterfaceGISBean.getDatos(DTOUnidadAdmCabecera dtoC, DTOUnidadAdmRegistro dtoR): Salida");
        return result.toString();
    }

    /* Este metodo realiza el contro sobre la tabla MAE_CLIEN, de forma
     * de averiguar el Oid de Cliente. Si el cliente no existe, retorna
     * nulo.
     ***/
    private Long obtenerOidCliente(String codCliente, Long oidPais)
        throws MareException {
        
        UtilidadesLog.info("MONUnidadAdmInterfaceGISBean.obtenerOidCliente(String codCliente, Long oidPais): Entrada");
          
		DAOMAE dao = new DAOMAE();
		return dao.obtenerOidCliente(codCliente, oidPais);
    }

    
    private Boolean tieneClientesUA(DTOUnidadAdministrativa unidadAdm)
        throws MareException {
        
        UtilidadesLog.info("MONUnidadAdmInterfaceGISBean.tieneClientesUA(DTOUnidadAdministrativa unidadAdm): Entrada");

        mon = getMONClientes();
        Long terri = unidadAdm.getOidTerritorioAdministrativo();
        UtilidadesLog.debug("Este es el territorio!!!: " + terri);
        try {
             return mon.hayClientesTerrAdm(terri);
        } catch(RemoteException e) {
            codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }
    }

    private Integer estadoProc(java.lang.Long a) {
        return null;
    }

    public Boolean validarCabecera(Object datos, String typeProc, String filePath, String fileName)
        throws MareException {
        
        UtilidadesLog.info("MONUnidadAdmInterfaceGISBean.validarCabecera(Object datos, String typeProc, String filePath, String fileName): Entrada");
        
        String paisSession = ((DTOBelcorp)datos).getOidPais().toString();
        DTOUnidadAdmCabecera dtoCab;

        // Abro el archivo
        UnidadAdmFileWrapper fileReader = new UnidadAdmFileWrapper();
        fileReader.abrirArchivo(filePath, fileName);

        // Lee la cabecera
        try {
            dtoCab = (DTOUnidadAdmCabecera)fileReader.leerCabecera();
        } catch(MareException me) {
            throw new MareException(me,
                UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_ZON, "", ErroresDeNegocio.CABECERA_FICHERO_NO_VALIDA));            
		}
        Long oidPais;    

        // Convierte el codigo de pais a oid de pais
        try {
            oidPais = getMONMantenimientoSEG().obtenerOidPais(dtoCab.getPais());
        } catch(RemoteException re) {
            UtilidadesLog.error("ERROR",re);
            ctx.setRollbackOnly();
            throw new MareException(re,
                UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch(MareException me) {
            throw new MareException(me,
                UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_ZON, "", ErroresDeNegocio.CABECERA_FICHERO_NO_VALIDA));            
        }    
        
        // Cerrar el archivo
        fileReader.cerrarArchivo();

        // Valida el pais del fichero con el de session del usuario activo
        if(oidPais.toString().equals(paisSession)) {
            UtilidadesLog.info("MONUnidadAdmInterfaceGISBean.validarCabecera(Object datos, String typeProc, String filePath, String fileName): Salida");
            return Boolean.TRUE;            
        } else {
            UtilidadesLog.info("MONUnidadAdmInterfaceGISBean.validarCabecera(Object datos, String typeProc, String filePath, String fileName): Salida");
            return Boolean.FALSE;
        }
    }

    public DTOManagerFileResult obtenerResultado(Long iDproc)
        throws MareException {
        
        UtilidadesLog.info("MONUnidadAdmInterfaceGISBean.obtenerResultado(Long iDproc): Entrada");
        
        DTOManagerFileResult dtoResult = null;

        try {
            dtoResult = this.getMONZONLogLocalHome().create().obtenerResultado(iDproc, "");
        } catch(CreateException e) {
            UtilidadesLog.error("ERROR",e);
            ctx.setRollbackOnly();
            codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } catch(Exception e) {
            UtilidadesLog.error("ERROR",e);
            ctx.setRollbackOnly();
            codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } 
        UtilidadesLog.info("MONUnidadAdmInterfaceGISBean.obtenerResultado(Long iDproc): Salida");
        return dtoResult;
    }

    public DTOListaFicheroDisp ficherosDisponibles(String typeProc)
        throws MareException {
        return null;
    }

    /** Este metodo crea el conjunto de entidades relacionadas,
     *  a la unidad Administrativa. SubGenerenciaVenta,Region,Zona,
     *  Seccion,Territorio.
     *  */
    private Long createEntidades(String[] codUA, Long oIdpais, Long oidMarca, Long oidCanal, String pais, String marca, String canal, Long prevEntOid,
        boolean activa, DTOUnidadAdministrativa dtoUA, Long iDProc, String typeProc, DTOUnidadAdmRegistro dtoR)
        throws MareException {
        
        UtilidadesLog.info("MONUnidadAdmInterfaceGISBean.createEntidades(String[] codUA, Long oIdpais, Long oidMarca, Long oidCanal, String pais, String marca, String canal, Long prevEntOid,boolean activa, DTOUnidadAdministrativa dtoUA, Long iDProc, String typeProc, DTOUnidadAdmRegistro dtoR): Entrada");

        dtoUA.setIpCliente(this.ipCliente);
        dtoUA.setPrograma(this.programa);

        Long newOid = null;

        if((codUA[4] != null) && (codUA[4].length() > 0)) {
            if((codUA[4] != null) && (codUA[4].length() == 6) && (codUA[3] != null) && (codUA[3].length() == 1) && (codUA[2] != null)
                && (codUA[2].length() == 4) && (codUA[1] != null) && (codUA[1].length() == 2) && (codUA[0] != null)
                && (codUA[0].length() == 2))
                //Alta de Territorio.
                newOid = crearTerritorio(codUA, oIdpais, pais, marca, canal, prevEntOid, activa, dtoUA, dtoR, iDProc, typeProc);
            else {
                generaDetalle(iDProc, typeProc, dtoR.dumpToString(), "M00013");
                reportaResultado(iDProc, typeProc, IManagerFileInterface.PROCESAMIENTO_FINALIZADO_ERROR, "M00013");
                // No termino correctamente el proceso
                terminoOK = "N";
                // Deshace la transacción                                   
                //ctx.setRollbackOnly();
            }
        } else if((codUA[3] != null) && (codUA[3].length() > 0)) {
            if((codUA[3] != null) && (codUA[3].length() == 1) && (codUA[2] != null) && (codUA[2].length() == 4) && (codUA[1] != null)
                && (codUA[1].length() == 2) && (codUA[0] != null) && (codUA[0].length() == 2)){
                //Alta de Seccion.
                newOid = crearSeccion(codUA, oidPais, pais, oidMarca, oidCanal, marca, canal, prevEntOid, activa, dtoUA, dtoR, iDProc, typeProc);
                UtilidadesLog.debug("*** Despues de alta seccion - newOid: "+newOid);
            } else {
                generaDetalle(iDProc, typeProc, dtoR.dumpToString(), "M00013");
                reportaResultado(iDProc, typeProc, IManagerFileInterface.PROCESAMIENTO_FINALIZADO_ERROR, "M00013");
                // No termino correctamente el proceso
                terminoOK = "N";
                // Deshace la transacción                                   
                //ctx.setRollbackOnly();
            }
        } else if((codUA[2] != null) && (codUA[2].length() > 0)) {
            if((codUA[2] != null) && (codUA[2].length() == 4) && (codUA[1] != null) && (codUA[1].length() == 2) && (codUA[0] != null)
                && (codUA[0].length() == 2)){
                //Alta de Zona.
                newOid = crearZona(codUA, pais, marca, canal, prevEntOid, activa, dtoUA, dtoR, iDProc, typeProc);
                UtilidadesLog.debug("*** Despues de alta zona - newOid: "+newOid);
            }else {
                generaDetalle(iDProc, typeProc, dtoR.dumpToString(), "M00013");
                reportaResultado(iDProc, typeProc, IManagerFileInterface.PROCESAMIENTO_FINALIZADO_ERROR, "M00013");
                // No termino correctamente el proceso
                terminoOK = "N";
                // Deshace la transacción                                   
                //ctx.setRollbackOnly();
            }
        } else if((codUA[1] != null) && (codUA[1].length() > 0)) {
            if((codUA[1] != null) && (codUA[1].length() == 2) && (codUA[0] != null) && (codUA[0].length() == 2))
                //Alta de Region.
                newOid = crearRegion(codUA, pais, marca, canal, prevEntOid, activa, dtoUA, dtoR, iDProc, typeProc);
            else {
                generaDetalle(iDProc, typeProc, dtoR.dumpToString(), "M00013");
                reportaResultado(iDProc, typeProc, IManagerFileInterface.PROCESAMIENTO_FINALIZADO_ERROR, "M00013");
                // No termino correctamente el proceso
                terminoOK = "N";
                // Deshace la transacción                                   
                //ctx.setRollbackOnly();
            }
        } else if((codUA[0] != null) && (codUA[0].length() == 2))
            //Alta de SGV.
            newOid = crearSgv(codUA, pais, marca, canal, activa, dtoUA, dtoR, iDProc, typeProc);
        else {
            generaDetalle(iDProc, typeProc, dtoR.dumpToString(), "M00013");
            reportaResultado(iDProc, typeProc, IManagerFileInterface.PROCESAMIENTO_FINALIZADO_ERROR, "M00013");
            // No termino correctamente el proceso
            terminoOK = "N";
            // Deshace la transacción                                   
            //ctx.setRollbackOnly();
        }
        UtilidadesLog.info("MONUnidadAdmInterfaceGISBean.createEntidades(String[] codUA, Long oIdpais, Long oidMarca, Long oidCanal, String pais, String marca, String canal, Long prevEntOid,boolean activa, DTOUnidadAdministrativa dtoUA, Long iDProc, String typeProc, DTOUnidadAdmRegistro dtoR): Salida");
        return newOid;
    }

    /**
    * Se crea la entidad territorio (ZON_TERRI) y la relacion TerritorioAdministrativo
    * (ZON_TERRI_ADMIN).
    */
    private Long crearTerritorio(String[] codigos, Long oidPais, String pais, String codMarca, String codCanal, Long seccOid, boolean activa, DTOUnidadAdministrativa dto, DTOUnidadAdmRegistro dtoR, Long iDProc, String typeProc)
        throws MareException {
        
        UtilidadesLog.info("MONUnidadAdmInterfaceGISBean.crearTerritorio(String[] codigos, Long oidPais, String pais, String codMarca, String codCanal, Long seccOid, boolean activa, DTOUnidadAdministrativa dto, DTOUnidadAdmRegistro dtoR, Long iDProc, String typeProc): Entrada");
        
        Long territorioOid = null;
        TerritorioLocalHome tLocalH = null;
        TerritorioLocal tLocal = null;
        Collection territorios;
        Collection territoriosSeccion;
        Collection territoriosPaisMarcaCanal;

        TerritorioAdministrativoLocalHome tALocalH = null;
        TerritorioAdministrativoLocal tALocal = null;
        Timestamp st = new Timestamp((new Date()).getTime());

        try {
            tLocalH = this.getTerritorioLocalHome();
            tALocalH = this.getTerritorioAdministrativoLocalHome();
                 
            territorios = tLocalH.findByCodigoPais(new Long(codigos[4]), oidPais);
            
            if (territorios.isEmpty() && controlEntidad(codigos, pais, codMarca, codCanal, false)==null && controlEntidadSinSeccion(codigos)==null) {
                      // Crea el territorio
              tLocal = tLocalH.create(new Long(codigos[4]), oidPais, new Long(0), null, st);
              tLocal.setNse1(dato4);
              tLocal.setNse2(dato5);
              
              tLocalH.merge(tLocal);
      
              // Crea el territorio Administrativo
              //tALocal = tALocalH.create(oidPais, oidMarca, oidCanal, seccOid, tLocal.getOid(), st);
              //19/01/2006 mdolce no estaba guardando el periodo
              tALocal = tALocalH.create(oidPais, oidMarca, oidCanal, seccOid, tLocal.getOid(), oidPeriodoFichero, st);
              tALocal.setBorrado(new Long(0));
              
              tALocalH.merge(tALocal);
              
              territorioOid = tLocal.getOid();
      
              // Guarda el territorio creado
              entidadCreadasSinSeccionH.put(getHashKeySinSeccion(codigos), tLocal.getOid());
                      
            } else {
                // Verifica si esta la relacion territorio - seccion
                Iterator iteTerri = territorios.iterator();
                tLocal = (TerritorioLocal)iteTerri.next();
                territoriosSeccion = tALocalH.findBySeccionTerritorio(seccOid, tLocal.getOid());
    
                if (!territoriosSeccion.isEmpty() || controlEntidad(codigos, null, null, null, false)!=null) {
                    // Ya esta insertado el registro
                    generaDetalle(iDProc, typeProc, dtoR.dumpToString(), "M00039");	
                } else {
                    // Verifica si el territorio esta para el pais, marca y canal
                    territoriosPaisMarcaCanal = tALocalH.findByPaisMarcaCanal(oidPais, oidMarca, oidCanal, tLocal.getOid());
    
                    if (territoriosPaisMarcaCanal.isEmpty() && controlEntidadSinSeccion(codigos)==null) {
                        // Crea el territorio Administrativo
                        // dmorello, 16/05/2006: Se setea el período de inicio en el siguiente create
                        tALocal = tALocalH.create(oidPais, oidMarca, oidCanal, seccOid, tLocal.getOid(), oidPeriodoFichero, st);
                        tALocal.setBorrado(new Long(0));
                        tALocalH.merge(tALocal);
                        territorioOid = tLocal.getOid();
                    } else {
                        // Ya esta insertado el registro
                        generaDetalle(iDProc, typeProc, dtoR.dumpToString(), "M00040");	
                    }                    
                }
            }
            
        } catch(Exception e) {
            UtilidadesLog.error("ERROR", e);
            generaDetalle(iDProc, typeProc, dtoR.dumpToString() + e.getMessage(), "M00030");
            UtilidadesLog.info("MONUnidadAdmInterfaceGISBean.crearTerritorio(String[] codigos, Long oidPais, String pais, String codMarca, String codCanal, Long seccOid, boolean activa, DTOUnidadAdministrativa dto, DTOUnidadAdmRegistro dtoR, Long iDProc, String typeProc): Salida");
			return null;			
        }
        UtilidadesLog.info("MONUnidadAdmInterfaceGISBean.crearTerritorio(String[] codigos, Long oidPais, String pais, String codMarca, String codCanal, Long seccOid, boolean activa, DTOUnidadAdministrativa dto, DTOUnidadAdmRegistro dtoR, Long iDProc, String typeProc): Salida");
        return territorioOid;
    }

    /**
    * Se crea la entidad Seccion (ZON_SECCI).
    * */
    private Long crearSeccion(String[] codigos, Long oidPais, String pais, Long oidMarca, Long oidCanal, String codMarca, String codCanal, Long oidZona, boolean activa, DTOUnidadAdministrativa dto, DTOUnidadAdmRegistro dtoR, Long iDProc, String typeProc)
        throws MareException {
        
        UtilidadesLog.info("MONUnidadAdmInterfaceGISBean.crearSeccion(String[] codigos, Long oidPais, String pais, Long oidMarca, Long oidCanal, String codMarca, String codCanal, Long oidZona, boolean activa, DTOUnidadAdministrativa dto, DTOUnidadAdmRegistro dtoR, Long iDProc, String typeProc): Entrada");
        
        Long seccionOid = null;
        SeccionLocalHome sLocalH = null;
        SeccionLocal sLocal = null;
        Collection secciones;

        try {
            sLocalH = this.getSeccionLocalHome();
            //Long pais, Long marca, Long canal, String codZona, String codSeccion
            secciones = sLocalH.findByCodigo(oidPais, oidMarca, oidCanal, oidZona, codigos[3]);
            if (secciones.isEmpty() && controlEntidad(codigos, pais, codMarca, codCanal, false)==null) {
                sLocal = sLocalH.create(codigos[3], oidZona, oidPeriodoFichero);
                sLocal.setActivo(new Long(((activa == true) ? 1 : 0)));
                sLocal.setCodNse1(this.dato4);
                sLocal.setCodNse2(this.dato5);
                sLocal.setBorrado(new Long(0));
                sLocal.setClienteOid(oidCliente);
                sLocal.setDesripcion(this.dato7);
                sLocalH.merge(sLocal);
                seccionOid = sLocal.getOid();
            } else {
                generaDetalle(iDProc, typeProc, dtoR.dumpToString(), "M00038");				
            }
        } catch(Exception e) {
            UtilidadesLog.info("*** Entro por 1.-");
            UtilidadesLog.error("ERROR", e);
            generaDetalle(iDProc, typeProc, dtoR.dumpToString() + e.getMessage(), "M00030");
        }
        UtilidadesLog.info("MONUnidadAdmInterfaceGISBean.crearSeccion(String[] codigos, Long oidPais, String pais, Long oidMarca, Long oidCanal, String codMarca, String codCanal, Long oidZona, boolean activa, DTOUnidadAdministrativa dto, DTOUnidadAdmRegistro dtoR, Long iDProc, String typeProc): Salida");
        return seccionOid;
    }

    /* Crea una entidad de Zona.
     * La misma depende de Region.
     * */
    private Long crearZona(String[] codigos, String pais, String codMarca, String codCanal, Long oidRegion, boolean activa, DTOUnidadAdministrativa dto, DTOUnidadAdmRegistro dtoR, Long iDProc, String typeProc)
        throws MareException {
        
        UtilidadesLog.info("MONUnidadAdmInterfaceGISBean.crearZona(String[] codigos, String pais, String codMarca, String codCanal, Long oidRegion, boolean activa, DTOUnidadAdministrativa dto, DTOUnidadAdmRegistro dtoR, Long iDProc, String typeProc): Entrada");
        
        Long oidZona = null;
        ZonaLocalHome zLocalH = null;
        ZonaLocal zLocal = null;
        Timestamp st = new Timestamp((new Date()).getTime());
        Collection zonas;

        try {
            zLocalH = this.getZonaLocalHome();
            zonas = zLocalH.findByCodigo(oidRegion, codigos[2]);
            if (zonas.isEmpty() && controlEntidad(codigos, pais, codMarca, codCanal, false)==null) {
                UtilidadesLog.debug("*** codigos[2]: "+codigos[2]);
                UtilidadesLog.debug("*** oidPais: "+oidPais);
                UtilidadesLog.debug("*** oidMarca: "+oidMarca);
                UtilidadesLog.debug("*** oidCanal: "+oidCanal);
                UtilidadesLog.debug("*** oidRegion: "+oidRegion);
                UtilidadesLog.debug("*** st: "+st);
                UtilidadesLog.debug("*** oidPeriodoFichero: "+oidPeriodoFichero);
                try{
                    zLocal = zLocalH.findByUK(oidPais, oidMarca, oidCanal, codigos[2]);
                }catch (NoResultException e){
                    UtilidadesLog.debug("NO EXISTE LA CREAMOS");
                    zLocal = zLocalH.create(codigos[2], oidPais, oidMarca, oidCanal, oidRegion, st , oidPeriodoFichero);
                }  catch (PersistenceException ce) {   
                    UtilidadesLog.error("ERROR ", ce);
                    throw new MareException(ce, 
                    UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                }
                if (zLocal.getOidRegion().longValue() != oidRegion.longValue()){
                    generaDetalle(iDProc, typeProc, dtoR.dumpToString(), "M00038");
                    terminoOK = "N";
                    return null;
                }
                zLocal.setPeriodoInic(oidPeriodoFichero);
                zLocal.setFechaRezonificacion(st);
                zLocal.setActiva(new Long(((activa == true) ? 1 : 0)));
                zLocal.setBorrado(new Long(0));
                zLocal.setRezonificacion(new Long(0));
                zLocal.setNse1(this.dato4);
                zLocal.setNse2(this.dato5);
                zLocal.setDescripcion(this.dato7);
                zLocal.setCliente(oidCliente);
                zLocal.setFechaCambioEstado(null);
                zLocal.setOidEstadoZona(null);
                zLocalH.merge(zLocal);
                oidZona = zLocal.getOid();
            } else {
                generaDetalle(iDProc, typeProc, dtoR.dumpToString(), "M00038");
            }
        }catch(Exception e) {
            UtilidadesLog.error("ERROR AL CREAR LA ZONA",e);
            terminoOK = "N";
            ctx.setRollbackOnly();
            generaDetalle(iDProc, typeProc, dtoR.dumpToString() + e.getMessage(), "M00030");            
        }
        UtilidadesLog.info("MONUnidadAdmInterfaceGISBean.crearZona(String[] codigos, String pais, String codMarca, String codCanal, Long oidRegion, boolean activa, DTOUnidadAdministrativa dto, DTOUnidadAdmRegistro dtoR, Long iDProc, String typeProc): Salida");
        return oidZona;
    }

    /**
     * Se realiza un alta de la entidad 'SubGerenciaVenta'.
     * La misma tiene relacion con las entidades Pais,Marca,Canal.
     */
    private Long crearSgv(String[] codUA, String pais, String codMarca, String codCanal, boolean activa, DTOUnidadAdministrativa dto, DTOUnidadAdmRegistro dtoR, Long iDProc, String typeProc)
        throws MareException {
        
        UtilidadesLog.info("MONUnidadAdmInterfaceGISBean.crearSgv(String[] codUA, String pais, String codMarca, String codCanal, boolean activa, DTOUnidadAdministrativa dto, DTOUnidadAdmRegistro dtoR, Long iDProc, String typeProc): Entrada");
        
        Long oidSgv = null;
        SubGerenciaVentaLocalHome sgvLocalH = null;
        SubGerenciaVentaLocal sgvLocal = null;
        Timestamp st = new Timestamp((new java.util.Date()).getTime());
		Collection sgvs;
		
        try {
            sgvLocalH = this.getSubGerenciaVentaLocalHome();
            sgvs = sgvLocalH.findByCodigo(oidMarca, oidPais, oidCanal, codUA[0]);
            if (sgvs.isEmpty() && controlEntidad(codUA, pais, codMarca, codCanal, false)==null) {
                UtilidadesLog.debug("*** codUA[0]: "+codUA[0]+" oidCanal: "+ oidCanal+" oidMarca: "+oidMarca+" oidPais: "+ oidPais+"oidPeriodoFichero: "+ oidPeriodoFichero);
                sgvLocal = sgvLocalH.create(codUA[0], oidCanal, oidMarca, oidPais, oidPeriodoFichero);
                sgvLocal.setCodNse1(this.dato4);
                sgvLocal.setCodNse2(this.dato5);
                sgvLocal.setActivo(new Long(((activa == true) ? 1 : 0)));
                sgvLocal.setOidCliente(oidCliente);
                sgvLocal.setDescripcionSubgVenta(this.dato7);
                sgvLocal.setBorrado(new Long(0));
                sgvLocalH.merge(sgvLocal);
                oidSgv = sgvLocal.getOidSubgVenta();
            } else {
                generaDetalle(iDProc, typeProc, dtoR.dumpToString(), "M00038");				
            }
        } catch(Exception e) {
            generaDetalle(iDProc, typeProc, dtoR.dumpToString() + e.getMessage(), "M00030");
        }
        UtilidadesLog.info("MONUnidadAdmInterfaceGISBean.crearSgv(String[] codUA, String pais, String codMarca, String codCanal, boolean activa, DTOUnidadAdministrativa dto, DTOUnidadAdmRegistro dtoR, Long iDProc, String typeProc): Salida");
        return oidSgv;
    }

    /**
    *   Se encarga de crear una nueva entidad de tipo Region.
    *   la misma depende del Codigo de SubGerencia de Venta.
    *   14-06-2005 - rgiorgi: inc. 19143: cambia el create
    */
    private Long crearRegion(String[] codigos, String pais, String codMarca, String codCanal, Long oidSgv, boolean activa, DTOUnidadAdministrativa dto, DTOUnidadAdmRegistro dtoR, Long iDProc, String typeProc)
        throws MareException {
        
        UtilidadesLog.info("MONUnidadAdmInterfaceGISBean.crearRegion(String[] codigos, String pais, String codMarca, String codCanal, Long oidSgv, boolean activa, DTOUnidadAdministrativa dto, DTOUnidadAdmRegistro dtoR, Long iDProc, String typeProc): Entrada");
        
        Long oidRegion = null;
        RegionLocalHome rLocalH = null;
        RegionLocal rLocal = null;
        //verificar con el decu dif fecha rezo y fechaultaact
        //mamontie 07/06/05 incidencia Peru
        Timestamp fecUltAct = new Timestamp((new Date()).getTime());
		Collection regiones;

        try {
            rLocalH = this.getRegionLocalHome();
            regiones = rLocalH.findByCodigo(oidSgv, codigos[1]);
            if (regiones.isEmpty() && controlEntidad(codigos, pais, codMarca, codCanal, false)==null) {
                UtilidadesLog.debug("crearRegion activa  "  + activa);
                rLocal = rLocalH.create(codigos[1], oidPais, oidMarca, oidCanal, oidSgv, oidPeriodoFichero, new Long(((activa == true) ? 1 : 0)),new Long(0));
                rLocal.setCodNse1(this.dato4);
                rLocal.setCodNse2(this.dato5);
                rLocal.setOidCliente(oidCliente);
                rLocal.setDescripcionRegion(this.dato7);
                rLocalH.merge(rLocal);
                oidRegion = rLocal.getOid();
            } else {
                generaDetalle(iDProc, typeProc, dtoR.dumpToString(), "M00038");				
            }
        } catch(Exception e) {
            generaDetalle(iDProc, typeProc, dtoR.dumpToString() + e.getMessage(), "M00030");
        }
        UtilidadesLog.info("MONUnidadAdmInterfaceGISBean.crearRegion(String[] codigos, String pais, String codMarca, String codCanal, Long oidSgv, boolean activa, DTOUnidadAdministrativa dto, DTOUnidadAdmRegistro dtoR, Long iDProc, String typeProc): Salida");
        return oidRegion;
    }

    /**
    * Obtiene el codigo de Unidad Administrativa obtenido de la linea
    * pasada como argumento.
    */
    private String[] getUACode(String line) {
        UtilidadesLog.info("MONUnidadAdmInterfaceGISBean.getUACode(String line): Entrada");
        
        String[] result = new String[MAX_UA_CODE];
		int pos = 0;
		int[] longi = new int[]{0,2,4,8,9,15,20};  //Posiciones (de 0 a 2 1er elem., de 2 a 4 2do....))
		int cantidad = 0;

		while ((pos < MAX_UA_CODE) && (cantidad < line.length()) ) { 
			result[pos] = line.substring(longi[pos], Math.min(longi[pos+1],line.length()));
			cantidad += result[pos].length();
			pos++;

		}
        UtilidadesLog.info("MONUnidadAdmInterfaceGISBean.getUACode(String line): Salida");
        return result;
    }

    /** Realiza un chequeo en base a un perido pasado como argumento si las fecha
    *  actual se encuentra dentro de los limites impuestos por el registro de
    *  periodo.
    *  currentDate
    */
    private boolean chequeoPeriodo(String periodoInicio, String tipoPeriodo, Long iDProc, String typeProc, DTOUnidadAdmCabecera dtoC)
        throws MareException {
        
        UtilidadesLog.info("MONUnidadAdmInterfaceGISBean.chequeoPeriodo(String periodoInicio, String tipoPeriodo, Long iDProc, String typeProc, DTOUnidadAdmCabecera dtoC): Entrada");
        
        boolean activa = false;
        MONPeriodosHome monPeriodosH = getPeriodoHome();
        MONPeriodos periodos = null;
        DTOCriteriosPeriodo dtoEntrada = new DTOCriteriosPeriodo();
        DTOSalida dtoSalida = new DTOSalida();
        RecordSet result = null;
        dtoEntrada.setPeriodo(periodoInicio);
        dtoEntrada.setMarca(oidMarca);
        dtoEntrada.setPais(oidPais);
        dtoEntrada.setCanal(oidCanal);

        // El metodo se usa también para consulta paginada
        dtoEntrada.setTamanioPagina(new Integer(20));
      //  dtoEntrada.setIndicadorSituacion(new Integer(1));
        dtoEntrada.setIndicadorSituacion(new Long(1));
        
        try {
            periodos = monPeriodosH.create();
            dtoSalida = periodos.obtienePeriodosConsulta(dtoEntrada);
        } catch(RemoteException e) {
            codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } catch(CreateException e) {
            codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } catch(MareException e) {
            generaDetalle(iDProc, typeProc, dtoC.dumpToString(), "M00020");
            reportaResultado(iDProc, typeProc, IManagerFileInterface.PROCESAMIENTO_FINALIZADO_ERROR, "M00020");
            terminoOK = "N";
            return false;
        }

        // Hay Periodos
        result = dtoSalida.getResultado();
        
        oidPeriodoFichero = Long.valueOf(((BigDecimal)result.getValueAt(0, "OID")).toString());
        UtilidadesLog.debug("oidPeriodoFichero: "  + oidPeriodoFichero);

        java.sql.Date fInicio = (java.sql.Date)result.getValueAt(0, "FEC_INIC");
        java.sql.Date fechaFin = (java.sql.Date)result.getValueAt(0, "FEC_FINA");

        long fecha_init = fInicio.getTime();
        long currentDate = (new java.util.Date()).getTime();
        long fecha_fin = fechaFin.getTime();

        activa = (((currentDate >= fecha_init) && (currentDate < fecha_fin)) ? true : false);
        
        UtilidadesLog.info("MONUnidadAdmInterfaceGISBean.chequeoPeriodo(String periodoInicio, String tipoPeriodo, Long iDProc, String typeProc, DTOUnidadAdmCabecera dtoC): Salida");
        return activa;
        
    }

    private MONPeriodosHome getPeriodoHome() throws MareException {
    
        UtilidadesLog.info("MONUnidadAdmInterfaceGISBean.getPeriodoHome(): Entrada");
        
        String codigoError;
        MONPeriodosHome monH = null;
        BelcorpService bs = null;

        try {
            bs = BelcorpService.getInstance();
        } catch(MareMiiServiceNotFoundException e) {
            codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }

        try {
            monH = (MONPeriodosHome)bs.ejbLocator.getHome("MONPeriodos", MONPeriodosHome.class);
        } catch(MareServiceException e) {
            codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }
        
        UtilidadesLog.info("MONUnidadAdmInterfaceGISBean.getPeriodoHome(): Salida");
        return monH;
    }

    /**
    * Retorna una instancia del MONMantenimientoSEG,
    * de forma de utilizar los metodos de la interface IServicioSEG.
    * implementados en dicho mon.
    **/
    private MONMantenimientoSEG getMONMantenimientoSEG() throws MareException {
        UtilidadesLog.info("MONUnidadAdmInterfaceGISBean.getMONMantenimientoSEG(): Entrada");
        
        if(monMSEG == null) {
            MONMantenimientoSEGHome monH = null;
            BelcorpService bs = null;

            try {
                bs = BelcorpService.getInstance();
            } catch(MareMiiServiceNotFoundException e) {
                codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
                throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
            }

            try {
                monH = (MONMantenimientoSEGHome)bs.ejbLocator.getHome("MONMantenimientoSEG", MONMantenimientoSEGHome.class);
                monMSEG = monH.create();
            } catch(MareServiceException e) {
                codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
                throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
            } catch(CreateException e) {
                codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
                throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
            } catch(RemoteException re) {
                codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
                throw new MareException(re, UtilidadesError.armarCodigoError(codigoError));
            }
        }

        UtilidadesLog.info("MONUnidadAdmInterfaceGISBean.getMONMantenimientoSEG(): Salida");
        return monMSEG;
    }

    /**
    * Retorna una instancia del MONClientes,
    * de forma de utilizar los metodos de la interface IServicioSEG.
    * implementados en dicho mon.
    **/
    private MONClientes getMONClientes() throws MareException {
        UtilidadesLog.info("MONUnidadAdmInterfaceGISBean.getMONClientes(): Entrada");
        if(mon == null) {
            MONClientesHome monH = null;
            BelcorpService bs = null;

            try {
                bs = BelcorpService.getInstance();
            } catch(MareMiiServiceNotFoundException e) {
                codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
                throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
            }

            try {
                monH = (MONClientesHome)bs.ejbLocator.getHome("MONClientes", MONClientesHome.class);
                mon = monH.create();
            } catch(MareServiceException e) {
                codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
                throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
            } catch(CreateException e) {
                codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
                throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
            } catch(RemoteException re) {
                codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
                throw new MareException(re, UtilidadesError.armarCodigoError(codigoError));
            }
        }

        UtilidadesLog.info("MONUnidadAdmInterfaceGISBean.getMONClientes(): Salida");
        return mon;
    }	

    //---------------------------------------------------------------------------------------------------------------------------------------------------------------------
    private void eliminarTerritorio(Long oidUA, DTOUnidadAdministrativa dtoUA, Long iDProc, String typeProc, DTOUnidadAdmRegistro dtoR)
        throws MareException {
        UtilidadesLog.info("MONUnidadAdmInterfaceGISBean.eliminarTerritorio(Long oidUA, DTOUnidadAdministrativa dtoUA, Long iDProc, String typeProc, DTOUnidadAdmRegistro dtoR): Entrada");
        
        //Obtener uidades Inferiores    Pto. 12
        DAOZON daoZon = new DAOZON();
        StringBuffer query = new StringBuffer();
        StringBuffer query1 = new StringBuffer();
		NivelUA nivel = new NivelUA();
		Boolean clientesAsignados = Boolean.FALSE;
        
		DTOUnidadAdministrativa dtoaux = daoZon.obtenerUnidadAdministrativa(oidMarca, oidPais, oidCanal, oidUA, null);
		UtilidadesLog.debug("Este es el DTO aux: "  + dtoaux);
        
		if (dtoaux != null)	{	
			UtilidadesLog.debug("Es diferente de null...!!!");
			clientesAsignados = tieneClientesUA(dtoaux); //TODO
		}

        if (dtoaux == null)	{
            // No se ha encontrado el Territorio administrativo
            generaDetalle(iDProc, typeProc, dtoR.dumpToString(), "M00003");
            
        } else if(clientesAsignados.booleanValue()) {
            //TIENE CLIENTES ASIGNADOS
			generaDetalle(iDProc, typeProc, dtoR.dumpToString(), "M00002");
			
		} else {
            
            try {
                bs = BelcorpService.getInstance();
            } catch(MareMiiServiceNotFoundException e) {
                codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
                throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
            }
            
            SimpleDateFormat formatter = new SimpleDateFormat ("dd-MM-yyyy hh:mm:ss");
            Timestamp date = new Timestamp(System.currentTimeMillis());
            
            try {
               
                //mdolce 19/01/2006 modifique para que guarde el periodo fin
                //mdolce 20/01/2006 Agregue que pase la 
                query.append(" UPDATE " + nivel.obtenerEntidad(new Integer(5)));
                query.append(" SET IND_BORR = 1 , ");
                query.append(" PERD_OID_PERI_FINA = " + oidPeriodoFichero + " , ");
                query.append(" FEC_RTZ = TO_DATE('" + formatter.format(date) + "', 'dd-MM-yyyy hh24:mi:ss')");
                query.append(" where ");
                query.append(nivel.obtenerNombreRelacion(new Integer(6)) + " = "  + oidUA);
                query.append(" AND " + nivel.obtenerNombreRelacion(new Integer(5)) + " = "  + dtoaux.getOidSeccion());
                           
                //bs.dbService.executeUpdate(query.toString());
                             
                bs.dbService.executeUpdate(query.toString());
            } catch(Exception e) {
                codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
                throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
            }

            // Busca otras secciones asociadas al territorio
            ArrayList aList = daoZon.obtenerSeccionesdeTerritorio(oidUA);           
            
             if (aList.size()==0){
                try {
                    query1.append(" UPDATE " + nivel.obtenerEntidad(new Integer(6)));
                    query1.append(" SET IND_BORR = 1, " );
                    query1.append(" FEC_RTZ = TO_DATE('" + formatter.format(date) + "', 'dd-MM-yyyy hh24:mi:ss')");
                    query1.append(" where ");
                    query1.append(nivel.obtenerNombreClave(new Integer(6)) + " = "  + oidUA);
                    
                    bs.dbService.executeUpdate(query1.toString());
                } catch(Exception e) {
                    codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
                    throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
                }
                       
             }           
		}
    
    UtilidadesLog.info("MONUnidadAdmInterfaceGISBean.eliminarTerritorio(Long oidUA, DTOUnidadAdministrativa dtoUA, Long iDProc, String typeProc, DTOUnidadAdmRegistro dtoR): Salida");
	}

    private void eliminarSeccion(Long oidUA, DTOUnidadAdministrativa dtoUA, Long iDProc, String typeProc, DTOUnidadAdmRegistro dtoR)
        throws MareException {
        UtilidadesLog.info("MONUnidadAdmInterfaceGISBean.eliminarSeccion(Long oidUA, DTOUnidadAdministrativa dtoUA, Long iDProc, String typeProc, DTOUnidadAdmRegistro dtoR): Entrada");
        
        //Obtener uidades Inferiores    Pto. 12
        DAOZON daoZon = new DAOZON();
        DTOLISTUniNSE aux = new DTOLISTUniNSE();
        aux = daoZon.obtenerUAinferioresUA(oidUA, new Integer(4));
        StringBuffer query = new StringBuffer();
        NivelUA nivel = new NivelUA();
        try {
            bs = BelcorpService.getInstance();
        } catch(MareMiiServiceNotFoundException e) {
            codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }

        if(aux.getArrayDTOUniNSE() == null) {
            try {
                query.append(" UPDATE " + nivel.obtenerEntidad(new Integer(4)));
                query.append(" SET IND_BORR = 1, ");
                query.append("     IND_ACTI = 0, "); //06-08-2007 (Sapaza), agregado por incidencia SiCC-20070365                
                query.append("     CLIE_OID_CLIE = NULL, "); //02-08-2007 (Sapaza), agregado por incidencia SiCC-20070365                
                query.append(" PERD_OID_PERI_FINA = " + oidPeriodoFichero + " where ");
                query.append(nivel.obtenerNombreClave(new Integer(4)) + " = "  + oidUA);
                bs.dbService.executeUpdate(query.toString());

                //02-08-2007 (Sapaza), agregado por incidencia SiCC-20070365                
                actualizaHistoricoResponsable(dtoUA);
            } catch(Exception e) {
                codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
                throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
            }
        } else
            //ERROR TIENE UNIDADES INF
            generaDetalle(iDProc, typeProc, dtoR.dumpToString(), "M00001");
            
        UtilidadesLog.info("MONUnidadAdmInterfaceGISBean.eliminarSeccion(Long oidUA, DTOUnidadAdministrativa dtoUA, Long iDProc, String typeProc, DTOUnidadAdmRegistro dtoR): Salida");
    }

    private void eliminarZona(Long oidUA, DTOUnidadAdministrativa dtoUA, Long iDProc, String typeProc, DTOUnidadAdmRegistro dtoR)
        throws MareException {
        
        UtilidadesLog.info("MONUnidadAdmInterfaceGISBean.eliminarZona(Long oidUA, DTOUnidadAdministrativa dtoUA, Long iDProc, String typeProc, DTOUnidadAdmRegistro dtoR): Entrada");
        
        //Obtener uidades Inferiores    Pto. 12
        DAOZON daoZon = new DAOZON();
        DTOLISTUniNSE aux = new DTOLISTUniNSE();
        aux = daoZon.obtenerUAinferioresUA(oidUA, new Integer(3));
        StringBuffer query = new StringBuffer();
        NivelUA nivel = new NivelUA();
        try {
            bs = BelcorpService.getInstance();
        } catch(MareMiiServiceNotFoundException e) {
            codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }

        if(aux.getArrayDTOUniNSE() == null) {
            try {
                query.append(" UPDATE " + nivel.obtenerEntidad(new Integer(3)));
                query.append(" SET IND_BORR = 1, ");
                query.append("     IND_ACTI = 0, "); //06-08-2007 (Sapaza), agregado por incidencia SiCC-20070365                
                query.append("     CLIE_OID_CLIE = NULL, "); //02-08-2007 (Sapaza), agregado por incidencia SiCC-20070365
                query.append(" PERD_OID_PERI_FINA = " + oidPeriodoFichero + " where ");
                query.append(nivel.obtenerNombreClave(new Integer(3)) + " = "  + oidUA);
                bs.dbService.executeUpdate(query.toString());

                //02-08-2007 (Sapaza), agregado por incidencia SiCC-20070365                
                actualizaHistoricoResponsable(dtoUA);
            } catch(Exception e) {
                codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
                throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
            }
        } else{
            //ERROR TIENE UNIDADES INF
            generaDetalle(iDProc, typeProc, dtoR.dumpToString(), "M00001");
        }
      UtilidadesLog.info("MONUnidadAdmInterfaceGISBean.eliminarZona(Long oidUA, DTOUnidadAdministrativa dtoUA, Long iDProc, String typeProc, DTOUnidadAdmRegistro dtoR): Salida");            
    }

    private void eliminarRegion(Long oidUA, DTOUnidadAdministrativa dtoUA, Long iDProc, String typeProc, DTOUnidadAdmRegistro dtoR)
        throws MareException {
        
        UtilidadesLog.info("MONUnidadAdmInterfaceGISBean.eliminarRegion(Long oidUA, DTOUnidadAdministrativa dtoUA, Long iDProc, String typeProc, DTOUnidadAdmRegistro dtoR): Entrada");
        
        //Obtener uidades Inferiores    Pto. 12
        DAOZON daoZon = new DAOZON();
        DTOLISTUniNSE aux = new DTOLISTUniNSE();
        aux = daoZon.obtenerUAinferioresUA(oidUA, new Integer(2));
        StringBuffer query = new StringBuffer();
        NivelUA nivel = new NivelUA();
        try {
            bs = BelcorpService.getInstance();
        } catch(MareMiiServiceNotFoundException e) {
            codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }

        if(aux.getArrayDTOUniNSE() == null) {
            try {
                query.append(" UPDATE " + nivel.obtenerEntidad(new Integer(2)));
                query.append(" SET IND_BORR = 1, ");
                query.append("     IND_ACTI = 0, "); //06-08-2007 (Sapaza), agregado por incidencia SiCC-20070365
                query.append("     CLIE_OID_CLIE = NULL, "); //02-08-2007 (Sapaza), agregado por incidencia SiCC-20070365
                query.append(" PERD_OID_PERI_FINA = " + oidPeriodoFichero + " where ");
                query.append(nivel.obtenerNombreClave(new Integer(2)) + " = "  + oidUA);
                bs.dbService.executeUpdate(query.toString());

                //02-08-2007 (Sapaza), agregado por incidencia SiCC-20070365                
                actualizaHistoricoResponsable(dtoUA);
            } catch(Exception e) {
                codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
                throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
            }
        } else
            //ERROR TIENE UNIDADES INF
            generaDetalle(iDProc, typeProc, dtoR.dumpToString(), "M00001");
            
      UtilidadesLog.info("MONUnidadAdmInterfaceGISBean.eliminarRegion(Long oidUA, DTOUnidadAdministrativa dtoUA, Long iDProc, String typeProc, DTOUnidadAdmRegistro dtoR): Salida");            
    }

    private void eliminarSgv(Long oidUA, DTOUnidadAdministrativa dtoUA, Long iDProc, String typeProc, DTOUnidadAdmRegistro dtoR)
        throws MareException {
        
        UtilidadesLog.info("MONUnidadAdmInterfaceGISBean.eliminarSgv(Long oidUA, DTOUnidadAdministrativa dtoUA, Long iDProc, String typeProc, DTOUnidadAdmRegistro dtoR): Entrada");
                
        //Obtener uidades Inferiores    Pto. 12
        DAOZON daoZon = new DAOZON();
        DTOLISTUniNSE aux = new DTOLISTUniNSE();
        aux = daoZon.obtenerUAinferioresUA(oidUA, new Integer(1));
        StringBuffer query = new StringBuffer();
        NivelUA nivel = new NivelUA();
        try {
            bs = BelcorpService.getInstance();
        } catch(MareMiiServiceNotFoundException e) {
            codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }

        if(aux.getArrayDTOUniNSE() == null) {
            try {
              query.append(" UPDATE " + nivel.obtenerEntidad(new Integer(1)));
                query.append(" SET IND_BORR = 1, ");
                query.append("     IND_ACTI = 0, "); //06-08-2007 (Sapaza), agregado por incidencia SiCC-20070365                
                query.append("     CLIE_OID_CLIE = NULL, "); //02-08-2007 (Sapaza), agregado por incidencia SiCC-20070365                
                query.append(" PERD_OID_PERI_FINA = " + oidPeriodoFichero + " where ");
                query.append(nivel.obtenerNombreClave(new Integer(1)) + " = "  + oidUA);
                bs.dbService.executeUpdate(query.toString());

                //02-08-2007 (Sapaza), agregado por incidencia SiCC-20070365                
                actualizaHistoricoResponsable(dtoUA);
            } catch(Exception e) {
                codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
                throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
            }
        } else{
            //ERROR TIENE UNIDADES INF
            generaDetalle(iDProc, typeProc, dtoR.dumpToString(), "M00001");
        }            
        UtilidadesLog.info("MONUnidadAdmInterfaceGISBean.eliminarSgv(Long oidUA, DTOUnidadAdministrativa dtoUA, Long iDProc, String typeProc, DTOUnidadAdmRegistro dtoR): Salida");            
    }

    private void eliminaEntidades(String[] codUA, Long oidUA, DTOUnidadAdministrativa dtoUA, Long iDProc, String typeProc,
        DTOUnidadAdmRegistro dtoR) throws MareException {
        
        UtilidadesLog.info("MONUnidadAdmInterfaceGISBean.eliminaEntidades(String[] codUA, Long oidUA, DTOUnidadAdministrativa dtoUA, Long iDProc, String typeProc, DTOUnidadAdmRegistro dtoR) : Entrada");

        dtoUA.setIpCliente(this.ipCliente);
        dtoUA.setPrograma(this.programa);

        if((codUA[4] != null) && (codUA[4].length() > 0)) 
		{
            if( (codUA[4] != null) && (codUA[4].length() == 6) &&
			    (codUA[3] != null) && (codUA[3].length() == 1) && 
				(codUA[2] != null) && (codUA[2].length() == 4) &&
				(codUA[1] != null) && (codUA[1].length() == 2) && 
				(codUA[0] != null) && (codUA[0].length() == 2)) 
			{
				
                UtilidadesLog.debug("A eliminar territorio");
                dtoUA.setOidTerritorio(oidUA);
                eliminarTerritorio(oidUA, dtoUA, iDProc, typeProc, dtoR);
            } else {
                generaDetalle(iDProc, typeProc, dtoR.dumpToString(), "M00013");
                reportaResultado(iDProc, typeProc, IManagerFileInterface.PROCESAMIENTO_FINALIZADO_ERROR, "M00013");
                // No termino correctamente el proceso
                terminoOK = "N";
                // Deshace la transacción                                   
                //ctx.setRollbackOnly();
            }
        } else if((codUA[3] != null) && (codUA[3].length() > 0)) {
            if((codUA[3] != null) && (codUA[3].length() == 1) && 
			   (codUA[2] != null) && (codUA[2].length() == 4) && 
			   (codUA[1] != null) && (codUA[1].length() == 2) && 
			   (codUA[0] != null) && (codUA[0].length() == 2)) {
				UtilidadesLog.debug("A eliminar Seccion");
                dtoUA.setOidSeccion(oidUA);
                eliminarSeccion(oidUA, dtoUA, iDProc, typeProc, dtoR);
            } else {
                generaDetalle(iDProc, typeProc, dtoR.dumpToString(), "M00013");
                reportaResultado(iDProc, typeProc, IManagerFileInterface.PROCESAMIENTO_FINALIZADO_ERROR, "M00013");
                // No termino correctamente el proceso
                terminoOK = "N";
                // Deshace la transacción                                   
                //ctx.setRollbackOnly();
            }
        } else if((codUA[2] != null) && (codUA[2].length() > 0)) {
            if((codUA[2] != null) && (codUA[2].length() == 4) && 
			   (codUA[1] != null) && (codUA[1].length() == 2) && 
			   (codUA[0] != null) && (codUA[0].length() == 2)) {
				UtilidadesLog.debug("A eliminar ZOna");
                dtoUA.setOidZona(oidUA);
                eliminarZona(oidUA, dtoUA, iDProc, typeProc, dtoR);
            } else {
                generaDetalle(iDProc, typeProc, dtoR.dumpToString(), "M00013");
                reportaResultado(iDProc, typeProc, IManagerFileInterface.PROCESAMIENTO_FINALIZADO_ERROR, "M00013");
                // No termino correctamente el proceso
                terminoOK = "N";
                // Deshace la transacción                                   
                //ctx.setRollbackOnly();
            }
        } else if((codUA[1] != null) && (codUA[1].length() > 0)) {
            if((codUA[1] != null) && (codUA[1].length() == 2) && 
			   (codUA[0] != null) && (codUA[0].length() == 2)) {
				UtilidadesLog.debug("A eliminar Region");
                dtoUA.setOidRegion(oidUA);
                eliminarRegion(oidUA, dtoUA, iDProc, typeProc, dtoR);
            } else {
                generaDetalle(iDProc, typeProc, dtoR.dumpToString(), "M00013");
                reportaResultado(iDProc, typeProc, IManagerFileInterface.PROCESAMIENTO_FINALIZADO_ERROR, "M00013");
                // No termino correctamente el proceso
                terminoOK = "N";
                // Deshace la transacción                                   
                //ctx.setRollbackOnly();
            }
        } else if((codUA[0] != null) && (codUA[0].length() == 2)) {
			UtilidadesLog.debug("A eliminar SGV");
            dtoUA.setOidSGV(oidUA);
            eliminarSgv(oidUA, dtoUA, iDProc, typeProc, dtoR);
        } else {
            generaDetalle(iDProc, typeProc, dtoR.dumpToString(), "M00013");
            reportaResultado(iDProc, typeProc, IManagerFileInterface.PROCESAMIENTO_FINALIZADO_ERROR, "M00013");
            // No termino correctamente el proceso
            terminoOK = "N";
            // Deshace la transacción                                   
            //ctx.setRollbackOnly();
        }
        
        UtilidadesLog.info("MONUnidadAdmInterfaceGISBean.eliminaEntidades(String[] codUA, Long oidUA, DTOUnidadAdministrativa dtoUA, Long iDProc, String typeProc, DTOUnidadAdmRegistro dtoR): Salida");
    }

    public void procesarEliminarUA(Long iDProc, String filePath, String typeProc)
        throws MareException {
        
        UtilidadesLog.info("MONUnidadAdmInterfaceGISBean.procesarEliminarUA(Long iDProc, String filePath, String typeProc): Entrada");
        //La logica de este metodo esta descripta en el 
        //diagrama de secuencia. Con varios puntos.
        DAOZON daoZon = new DAOZON();
        Long oidUA;
        String filePath1 = filePath.substring(0, filePath.lastIndexOf(File.separator));
        String fileName = filePath.substring(filePath.lastIndexOf(File.separator) + 1, filePath.length());
        String pais_cod;
        String canal_cod;
        String marca_cod;
        String init_period;
        String type_period;
        String operacion;
        DTOUnidadAdministrativa dtoUA = null;
        String[] codUA = null;
        DTOUnidadAdmCabecera dtoC = new DTOUnidadAdmCabecera();
        DTOUnidadAdmRegistro dtoR = new DTOUnidadAdmRegistro();

        UnidadAdmFileWrapper fileReader = new UnidadAdmFileWrapper();

        //reportaResultado() Pto. 4
        reportaResultado(iDProc, typeProc, IManagerFileInterface.EN_EJECUCION, fim.obtenerDescMen("M00004"));
        //abrirArchivo Pto. 5
        fileReader.abrirArchivo(filePath1, fileName);

        //Obtengo datos de cabecera. Pto 6.
        try {
            dtoC = (DTOUnidadAdmCabecera)fileReader.leerCabecera();
        } catch(MareException me) {
            // Error critico            
			UtilidadesLog.debug("Error critico de la validacion de la Cabecera");			
            generaDetalle(iDProc, typeProc, dtoC.dumpToString(), "M00012");
            reportaResultado(iDProc, typeProc, IManagerFileInterface.PROCESAMIENTO_FINALIZADO_ERROR, "M00012");
            return;
        }

        pais_cod = dtoC.getPais();
        marca_cod = dtoC.getMarca();
        canal_cod = dtoC.getCanal();
        type_period = dtoC.getTipoPeriodo();
        init_period = dtoC.getPeriodoInicio();

        // Valida Pais
        try{
            oidPais = obtenerOidPais(pais_cod);
         } catch(MareException me) {
            // Error critico
			UtilidadesLog.debug("Error critico de la validacion del Pais");			
            generaDetalle(iDProc, typeProc, dtoC.dumpToString(), "M00035");
            reportaResultado(iDProc, typeProc, IManagerFileInterface.PROCESAMIENTO_FINALIZADO_ERROR, "M00035");
            return;
        }

        // Valida Marca
        try{
            oidMarca = obtenerOidMarca(marca_cod);
        } catch(MareException me) {
            // Error critico
			UtilidadesLog.debug("Error critico de la validacion del MArca");
            generaDetalle(iDProc, typeProc, dtoC.dumpToString(), "M00036");
            reportaResultado(iDProc, typeProc, IManagerFileInterface.PROCESAMIENTO_FINALIZADO_ERROR, "M00036");
            return;
        }

        // Valida Canal
        try{
            oidCanal = obtenerOidCanal(canal_cod);
        } catch(MareException me) {
            // Error critico
			UtilidadesLog.debug("Error critico de la validacion del canal");
            generaDetalle(iDProc, typeProc, dtoC.dumpToString(), "M00037");
            reportaResultado(iDProc, typeProc, IManagerFileInterface.PROCESAMIENTO_FINALIZADO_ERROR, "M00037");
            return;
        }
        
        
        // Obtiene el periodo de fin
        MONPeriodosHome monPeriodosH = getPeriodoHome();
        MONPeriodos periodos = null;
        DTOCriteriosPeriodo dtoEntrada = new DTOCriteriosPeriodo();
        DTOSalida dtoSalida = new DTOSalida();
        RecordSet result = null;
        dtoEntrada.setPeriodo(init_period);
        dtoEntrada.setMarca(oidMarca);
        dtoEntrada.setPais(oidPais);
        dtoEntrada.setCanal(oidCanal);

        // El metodo se usa también para consulta paginada
        dtoEntrada.setTamanioPagina(new Integer(20));
        //dtoEntrada.setIndicadorSituacion(new Integer(1));
        dtoEntrada.setIndicadorSituacion(new Long(1));

        try {
            periodos = monPeriodosH.create();
            dtoSalida = periodos.obtienePeriodosConsulta(dtoEntrada);
        } catch(RemoteException e) {
            codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } catch(CreateException e) {
            codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } catch(MareException e) {
            generaDetalle(iDProc, typeProc, dtoC.dumpToString(), "M00020");
            reportaResultado(iDProc, typeProc, IManagerFileInterface.PROCESAMIENTO_FINALIZADO_ERROR, "M00020");
            return;
        }

        // Hay Periodos
        result = dtoSalida.getResultado();
        
        oidPeriodoFichero = Long.valueOf(((BigDecimal)result.getValueAt(0, "OID")).toString());
        UtilidadesLog.debug("oidPeriodoFichero: "  + oidPeriodoFichero);

        //leerRegistro(). Pto. 7
        while(((dtoR = this.leerRegistro(fileReader, iDProc, typeProc)) != null) && (terminoOK.equals("S"))) {
            //Se busca el tipo de operacion "B"	Pto. 9
			UtilidadesLog.debug("dtoR.getTipoOP(): " + dtoR.getTipoOP());  
            if(dtoR.getTipoOP().equals(CODIGO_BAJA)) {
				UtilidadesLog.debug("Entro al if!!!!!  el tipo OP es CODIGO_BAJA");
                operacion = dtoR.getTipoOP();
                dato1 = dtoR.getDato1();
				
                codUA = getUACode(dato1);

                dtoUA = new DTOUnidadAdministrativa();
                dtoUA.setOidCanal(oidCanal);
                dtoUA.setOidMarca(oidMarca);
                dtoUA.setOidPais(oidPais);

                oidUA = daoZon.obtenerUAporcodigo(oidMarca, oidCanal, oidPais, codUA[0], codUA[1], codUA[2], codUA[3], codUA[4]);

                if(oidUA == null){
                    //ERROR NO EXISTE UA
					UtilidadesLog.debug("ERROR NO EXISTE UA ");
                    generaDetalle(iDProc, typeProc, dtoR.dumpToString(), "M00003");
				} else {
                    //Borrado de Entidades.
                    dtoUA.setCodUA(dato1); //02-08-2007 (Sapaza), agregado por incidencia SiCC-20070365
					UtilidadesLog.debug("Borrado de Entidades");
                    eliminaEntidades(codUA, oidUA, dtoUA, iDProc, typeProc, dtoR);
				}
            }
        }

        //reportaResultado() Pto. 21
		UtilidadesLog.debug("terminoOK" + terminoOK);
        if(terminoOK.equals("S"))
            reportaResultado(iDProc, typeProc, IManagerFileInterface.PROCESAMIENTO_FINALIZADO_OK, "M00005");
            
      UtilidadesLog.info("MONUnidadAdmInterfaceGISBean.procesarEliminarUA(Long iDProc, String filePath, String typeProc): Salida");            
    }

    private DTOUnidadAdmRegistro leerRegistro(UnidadAdmFileWrapper fr, Long idProc, String typeProc)
        throws MareException {
        
        UtilidadesLog.info("MONUnidadAdmInterfaceGISBean.leerRegistro(UnidadAdmFileWrapper fr, Long idProc, String typeProc): Entrada");
        
        DTOUnidadAdmRegistro f = new DTOUnidadAdmRegistro();

        try {
            f = (DTOUnidadAdmRegistro)fr.leerRegistro();
            UtilidadesLog.info("MONUnidadAdmInterfaceGISBean.leerRegistro(UnidadAdmFileWrapper fr, Long idProc, String typeProc): Salida");
            return f;
        } catch(MareException me) {
            // Error critico           
//            generaDetalle(idProc, typeProc, f.dumpToString(), "M00013");
            // dmorello, 16/06/2006: En lugar de String vacio como dato irá el mensaje de la excepción
            generaDetalle(idProc, typeProc, me.getMessage(), "M00013");
            reportaResultado(idProc, typeProc, IManagerFileInterface.PROCESAMIENTO_FINALIZADO_ERROR, "M00013");
            // No termino correctamente el proceso
            terminoOK = "N";
            // Deshace la transacción                                   
            //ctx.setRollbackOnly();
            UtilidadesLog.info("MONUnidadAdmInterfaceGISBean.leerRegistro(UnidadAdmFileWrapper fr, Long idProc, String typeProc): Salida");
            return null;
        }
    }

    private String logString(String dtos, MONZONLogLocal log) {
        UtilidadesLog.info("MONUnidadAdmInterfaceGISBean.logString(String dtos, MONZONLog log): Entrada");
        int limSup = (dtos.length() < log.CANT_CARACTERES_MENSAJE_ERROR)?dtos.length():log.CANT_CARACTERES_MENSAJE_ERROR;
        UtilidadesLog.info("MONUnidadAdmInterfaceGISBean.logString(String dtos, MONZONLog log): Salida");
        return dtos.substring(0,limSup);
        
    }    

    private MONClientesHome getMONClientesHome() throws NamingException {
        final InitialContext context = new InitialContext();
        return (MONClientesHome)PortableRemoteObject.narrow(context.lookup("java:comp/env/MONClientes"), MONClientesHome.class);
    }

    private MONZONLogLocalHome getMONZONLogLocalHome() throws NamingException{
        final InitialContext context = new InitialContext();
        return (MONZONLogLocalHome)context.lookup("java:comp/env/ejb/local/MONZONLog");
    }
    
    private MONUnidadAdmInterfaceGISLocalHome getMONUnidadAdmInterfaceGISLocalHome() throws NamingException{
        final InitialContext context = new InitialContext();
        return (MONUnidadAdmInterfaceGISLocalHome)context.lookup("java:comp/env/ejb/local/MONUnidadAdmInterfaceGIS");
    }
    
    /**
     * 02-08-2007       (Sapaza) agregado por incidencia SiCC-20070365, actualiza en la entidad 
     *                  [historico gerente] para unidad administrativa con fecha hasta
     * @throws es.indra.mare.common.exception.MareException
     * @return 
     * @param dtoUA
     */
    public void actualizaHistoricoResponsable(DTOUnidadAdministrativa dtoUA) throws MareException {
        UtilidadesLog.info("MONUnidadAdmInterfaceGISBean.actualizaHistoricoResponsable(DTOUnidadAdministrativa dtoUA): Entrada");

        /* 
         * Comprueba si la unidad administratriva tenia un gerente anterior 
         * y en ese caso actualiza el historico con la fecha hasta 
         */
        HistoricoGerentesLideresLocal historico = null;
        HistoricoGerentesLideresLocalHome historicoHome =  this.getHistoricoGerentesLideresLocalHome();
 
        try {
            historico = historicoHome.findByNoFechaHasta(dtoUA.getCodUA(),
                                                         dtoUA.getOidPais(), 
                                                         dtoUA.getOidMarca(), 
                                                         dtoUA.getOidCanal());
            historico.setFechaHasta(new Timestamp(new Date(System.currentTimeMillis()).getTime()));
            historicoHome.merge(historico);
        } catch (NoResultException fe) {
            UtilidadesLog.debug("****Metodo  actualizaHistoricoResponsable: no existe histórico, lo creo");
        }  catch (PersistenceException ce) {   
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } 
        
        UtilidadesLog.info("MONUnidadAdmInterfaceGISBean.actualizaHistoricoResponsable (DTOUnidadAdministrativa dtoUA): Salida");
    }
    
   
    private TerritorioLocalHome getTerritorioLocalHome()  {
        return new TerritorioLocalHome();
    }
    
    private TerritorioAdministrativoLocalHome getTerritorioAdministrativoLocalHome() {
        return new TerritorioAdministrativoLocalHome();
    }
    
    private RegionLocalHome getRegionLocalHome() {
        return new RegionLocalHome();        
    }
    
    private SeccionLocalHome getSeccionLocalHome() {
        return new SeccionLocalHome();
    }
    
    private SubGerenciaVentaLocalHome getSubGerenciaVentaLocalHome() {
        return new SubGerenciaVentaLocalHome();
    }
    
    private ZonaLocalHome getZonaLocalHome() {
        return new ZonaLocalHome();
    }
    
    private HistoricoGerentesLideresLocalHome getHistoricoGerentesLideresLocalHome()  {
        return new HistoricoGerentesLideresLocalHome();
    }
    
   
}