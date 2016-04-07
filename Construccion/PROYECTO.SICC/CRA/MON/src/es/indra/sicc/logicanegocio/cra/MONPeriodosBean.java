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
 *
 */
package es.indra.sicc.logicanegocio.cra;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.dtos.cra.DTOAsociadosAPeriodo;
import es.indra.sicc.dtos.cra.DTOBuscarPeriodos;
import es.indra.sicc.dtos.cra.DTOCriteriosPeriodo;
import es.indra.sicc.dtos.cra.DTOEntradaMatrizDias;
import es.indra.sicc.dtos.cra.DTOID;
import es.indra.sicc.dtos.cra.DTOPeriodo;
import es.indra.sicc.dtos.cra.DTORecalculoPeriodos;
import es.indra.sicc.entidades.cra.PeriodoLocal;
import es.indra.sicc.entidades.cra.PeriodoLocalHome;
import es.indra.sicc.logicanegocio.seg.ConstantesSEG;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOBoolean;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.ExcepcionParametrizada;
import es.indra.sicc.util.UtilidadesBD;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;

import java.math.BigDecimal;

import java.sql.Date;
import java.sql.Timestamp;

import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Vector;

import javax.ejb.FinderException;
import javax.ejb.RemoveException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

import javax.persistence.EntityExistsException;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;


/**
 * Sistema:           Belcorp
 * Modulo:            CRA
 * Submódulo:           
 * Componente:        MON's
 * Fecha:             23/10/2003
 * Observaciones:     Componente construido de acuerdo a la especificación del
 *                    Modelo de Componentes SICC-DMCO-CRA-201-304
 *
 * @version           2.0
 * @autor             Gustavo De Marzi
 */
public class MONPeriodosBean implements SessionBean {
    private SessionContext sessionContext;

    public void ejbCreate() {
    }

    public void ejbActivate() {
    }

    public void ejbPassivate() {
    }

    public void ejbRemove() {
    }

    public void setSessionContext(SessionContext ctx) {
        sessionContext = ctx;
    }


    /**
     * Obtiene los todos los periodos que cumplan los criterios que contiene el dto de entrada
     * (país, marca, canal, año, periodo, tipo de periodo, nombre del periodo).
     *  Realiza una consulta SQL filtrada por PAIS utilizando el servicio JDBCMare
     *  que se obtendrá a partir del MII.
     *  Devuelve un RecordSet construido a partir de la consulta.
     *  El RecordSet contiene:
     *   - Pais
     *   - Marca
     *   - Canal
     *   - Tipo de Periodo
     *   - codigoPeriodo
     *   - Nombre del Periodo
     *   - Fecha Inicio
     *   - Fecha Fin
     *   - oidPeriodo
     *   - oidTipoPeriodo
     *   - oidPeriodoCorporativo
     *   
     *  Se captura la excepcion SQLException. En caso de que se produzca, se crea
     *  una instancia de MareException con la excepción capturada y un código de error:
     *   - Error de Lectura en Base de Datos: 01101000001
     *   - Error de Acceso en Base de Datos: 01101000001
     *   - Error peticion de datos no existente: 01101000001
     */
     /**
	  * @Modifico: Hugo Andrés Mansi
	  * @Fecha: 25/11/2004
	  * @Incidencia Nº BELC300010875
	  *
	  **/
	  
	 
    public DTOSalida obtienePeriodosConsulta(DTOCriteriosPeriodo criteriosPeriodo) throws MareException {
        UtilidadesLog.info("MONPeriodosBean.obtienePeriodosConsulta(DTOCriteriosPeriodo criteriosPeriodo):Entrada");
        String codigoError;
        BelcorpService belcorpService;
        RecordSet respuestaRecordSet;
        Long oidIdioma;
        Vector parametros = new Vector();
        
        try {
            belcorpService = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException serviceNotFoundException) {
            UtilidadesLog.error(serviceNotFoundException);
            codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            throw new MareException(serviceNotFoundException,
                UtilidadesError.armarCodigoError(codigoError));
        }

        //armamos la sentencia SQL para obtener los periodos
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(" SELECT distinct pais.val_i18n desc_pais, (FEC_FINA - FEC_INIC + 1) AS DURA, SEG_MARCA.DES_MARC, ");   // marca.val_i18n desc_marca, ");
        stringBuffer.append(" canal.val_i18n desc_canal, COD_TIPO_PERI, PC.COD_PERI, VAL_NOMB_PERI, FEC_INIC, ");
        stringBuffer.append(" FEC_FINA, P.OID_PERI as OID, ");
        stringBuffer.append(" decode(IND_PERI_CORT,1,'true','false') as IND_PERI_CORT, decode(IND_PERI_CRUC,1,'true','false') as IND_PERI_CRUC, ");
        stringBuffer.append(" OID_TIPO_PERI, P.PERI_OID_PERI, ");
        stringBuffer.append(" P.PAIS_OID_PAIS, P.MARC_OID_MARC, P.CANA_OID_CANA ");   //agregado por i18n
        stringBuffer.append(" FROM CRA_PERIO P, SEG_PERIO_CORPO PC, SEG_TIPO_PERIO TP, SEG_MARCA, ");
        //i18n from
        stringBuffer.append( i18nFromPaisMarcaCanal() );
        if (criteriosPeriodo.getOidIdioma() == null) oidIdioma = new Long(1); //idioma por defecto
            else oidIdioma = criteriosPeriodo.getOidIdioma();
        //Al desinternacionalizar la marca tengo solo 4 repeticiones de idioma en ves de 6
        for (int i=1;i<=4;i++) parametros.add( oidIdioma );

        //Agregamos esta condicion por si no vienen filtros
        stringBuffer.append(" WHERE 1=1 ");
        //joins para obtener el tipo de periodo
        stringBuffer.append(" AND P.PERI_OID_PERI = PC.OID_PERI ");
        stringBuffer.append(" AND PC.TIPE_OID_TIPO_PERI = TP.OID_TIPO_PERI ");
        //por desinternacionalizacion de marca
        stringBuffer.append(" AND SEG_MARCA.OID_MARC = P.MARC_OID_MARC ");
        //i18n pais marca canal
        stringBuffer.append(" AND seg_acces.OID_ACCE(+) = p.ACCE_OID_ACCE ");
        stringBuffer.append(" AND c.pais_oid_pais = b.oid_pais ");
        stringBuffer.append(" AND c.ind_borr = 0 ");
        stringBuffer.append(" AND P.pais_oid_pais = b.oid_pais ");
        //stringBuffer.append(" AND P.marc_oid_marc = f.oid_marc ");
        stringBuffer.append(" AND P.cana_oid_cana = g.oid_cana ");
        stringBuffer.append(" and pais.val_oid = b.oid_pais ");
        //stringBuffer.append(" and marca.val_oid = f.oid_marc ");						
        stringBuffer.append(" and canal.val_oid = g.oid_cana ");

        //filtros
        if (criteriosPeriodo.getOidPeriodo() != null){
            stringBuffer.append(" AND P.OID_PERI = ? ");
            parametros.add(criteriosPeriodo.getOidPeriodo());
        }
        if (criteriosPeriodo.getPais() != null){
            stringBuffer.append(" AND P.PAIS_OID_PAIS = ? ");
            parametros.add(criteriosPeriodo.getPais());
        }else if (criteriosPeriodo.getOidPais() != null){
            stringBuffer.append(" AND P.PAIS_OID_PAIS = ? ");
            parametros.add(criteriosPeriodo.getOidPais());
        }
        if (criteriosPeriodo.getMarca() != null){
            //Si el oid de la marca es 0, metadato todos, entonces se omite el filtro de marca
            if (criteriosPeriodo.getMarca().longValue() != 0) {
                stringBuffer.append(" AND P.MARC_OID_MARC = ? ");
                parametros.add(criteriosPeriodo.getMarca());
            }
        }
        
        if(criteriosPeriodo.getAcceso() != null)
        {
            stringBuffer.append(" AND p.ACCE_OID_ACCE = ? ");
            parametros.add(criteriosPeriodo.getAcceso());
        }
        if (criteriosPeriodo.getCanal() != null){
            stringBuffer.append(" AND P.CANA_OID_CANA = ? ");
            parametros.add(criteriosPeriodo.getCanal());
        }
        if (criteriosPeriodo.getAnio() != null){
            stringBuffer.append(" AND PC.VAL_ANIO = '"+criteriosPeriodo.getAnio()+"' ");
        }
        if (criteriosPeriodo.getPeriodo() != null) {
            stringBuffer.append(" AND UPPER(PC.COD_PERI) LIKE ?");
            parametros.add(criteriosPeriodo.getPeriodo().toUpperCase());
        }
        if (criteriosPeriodo.getNombre() != null) {
            stringBuffer.append(" AND UPPER(VAL_NOMB_PERI) LIKE ?");
            parametros.add(criteriosPeriodo.getNombre().toUpperCase());
        }
        if (criteriosPeriodo.getCodigoTipo() != null) {
            stringBuffer.append(" AND UPPER(COD_TIPO_PERI) LIKE ?");
            parametros.add(criteriosPeriodo.getCodigoTipo().toUpperCase());
        }
        if (criteriosPeriodo.getTipo() != null) {
            stringBuffer.append(" AND OID_TIPO_PERI = ?");
            parametros.add(criteriosPeriodo.getTipo());
        }
         //Hugo Mansi
         //Agregado por incidencia BELC300010875 
         stringBuffer.append(" ORDER BY VAL_NOMB_PERI");

        try {
            respuestaRecordSet = belcorpService.dbService.executePreparedQuery(stringBuffer.toString(),
                    parametros);
        } catch (Exception exception) {
            UtilidadesLog.error(exception);
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(exception,
                UtilidadesError.armarCodigoError(codigoError));
        }
        
        if (respuestaRecordSet.esVacio()) {
            UtilidadesLog.debug("respuestaRecordSet.esVacio()");
            throw new MareException(new Exception(),UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }
        UtilidadesLog.info("MONPeriodosBean.obtienePeriodosConsulta(DTOCriteriosPeriodo criteriosPeriodo):Salida");
        return new DTOSalida(respuestaRecordSet);
    }


    /*
     * Retrorna el from de internacionalizacion para pais, marca y canal.
     * Esta parte del query espera seis parametros idioma.
     * Soporta valores por defecto de idioma.
     * Si no encuentra un pais, marca o canal buscado segun el idioma,
     * se basa en el idioma por defecto.
     */
    /* Ahora desinternacionalizarion la marca */
    private String i18nFromPaisMarcaCanal() {
        UtilidadesLog.info("MONPeriodosBean.i18nFromPaisMarcaCanal():Entrada");
        StringBuffer s = new StringBuffer();
        s.append(" seg_pais b, zon_estru_geopo c, seg_canal g, seg_acces, "); //seg_marca f, ");
        s.append(" (select i1.val_oid, i1.val_i18n ");
        s.append(" from gen_i18n_sicc i1 ");
        //PAIS
        s.append("   where i1.attr_enti = 'SEG_PAIS' ");
        s.append("      and i1.attr_num_atri = 1 ");
        s.append("      and i1.idio_oid_idio = ? ");    //idioma por parametro
        s.append("      and i1.val_oid in ( ");
        s.append("          select distinct b.oid_pais ");
        s.append("          from seg_pais b, zon_estru_geopo c ");
        s.append("          where c.pais_oid_pais = b.oid_pais ");
        s.append("              and c.ind_borr = 0 ");
        s.append("          ) ");
        s.append("  UNION ALL ");		 
        s.append("  select i1.val_oid, i1.val_i18n ");
        s.append("  from gen_i18n_sicc i1 ");
        s.append("  where i1.attr_enti = 'SEG_PAIS' ");
        s.append("      and i1.attr_num_atri = 1 ");
        s.append("      and i1.idio_oid_idio = 1 ");
        s.append("      and i1.val_oid in ( ");
        s.append("          select distinct b.oid_pais ");
        s.append("          from seg_pais b, zon_estru_geopo c ");
        s.append("          where c.pais_oid_pais = b.oid_pais ");
        s.append("              and c.ind_borr = 0 ");
        s.append("          ) ");
        s.append("  AND NOT EXISTS ( ");
        s.append("  select 1 ");
        s.append("  from gen_i18n_sicc i2 ");
        s.append("  where i2.attr_enti = 'SEG_PAIS' ");
        s.append("      and i2.attr_num_atri = 1 ");
        s.append("      and i2.idio_oid_idio = ? ");     //idioma por parametro
        s.append("      and i2.val_oid in ( ");
        s.append("          select distinct b.oid_pais ");
        s.append("          from seg_pais b, zon_estru_geopo c ");
        s.append("          where c.pais_oid_pais = b.oid_pais ");
        s.append("              and c.ind_borr = 0 ");
        s.append("          ) ");
        s.append("      and i1.val_oid = i2.val_oid) ");
        s.append("  ) pais, ");
        //CANAL
        s.append("  (select i1.val_oid, i1.val_i18n ");
        s.append("  from gen_i18n_sicc i1 ");
        s.append("  where i1.attr_enti = 'SEG_CANAL' ");
        s.append("      and i1.attr_num_atri = 1 ");
        s.append("      and i1.idio_oid_idio =  ? ");    //idioma por parametro
        s.append("      and i1.val_oid in ( ");
        s.append("          select distinct g.oid_cana ");
        s.append("          from seg_canal g ");
        s.append("          ) ");
        s.append("  UNION ALL ");
        s.append("  select i1.val_oid, i1.val_i18n ");
        s.append("  from gen_i18n_sicc i1 ");
        s.append("  where i1.attr_enti = 'SEG_CANAL' ");
        s.append("      and i1.attr_num_atri = 1 ");
        s.append("      and i1.idio_oid_idio = 1 ");
        s.append("      and i1.val_oid in ( ");
        s.append("          select distinct g.oid_cana ");
        s.append("          from seg_canal g ");
        s.append("          ) ");
        s.append("  AND NOT EXISTS ( ");
        s.append("  select 1 ");
        s.append("  from gen_i18n_sicc i2 ");
        s.append("  where i2.attr_enti = 'SEG_CANAL' ");
        s.append("      and i2.attr_num_atri = 1 ");
        s.append("      and i2.idio_oid_idio =  ? ");    //idioma por parametro
        s.append("      and i2.val_oid in ( ");
        s.append("          select distinct g.oid_cana ");
        s.append("          from seg_canal g ");
        s.append("          ) ");
        s.append("      and i1.val_oid = i2.val_oid) ");
        s.append("  ) canal ");
        UtilidadesLog.info("MONPeriodosBean.i18nFromPaisMarcaCanal():Salida");
        return s.toString(); 
    }

    private String i18nWherePaisMarcaCanal() {
        StringBuffer s = new StringBuffer();
        s.append(" c.pais_oid_pais = b.oid_pais ");
        s.append(" AND c.ind_borr = 0 ");
        s.append(" AND pais.val_oid = b.oid_pais ");
        s.append(" AND marca.val_oid = f.oid_marc ");
        s.append(" AND canal.val_oid = g.oid_cana ");

        return s.toString();
    }


    /**
     * Crea todos los periodos recibidos en la Collection
     */
     public void insertaPeriodos(java.util.Collection periodos) throws MareException{
        UtilidadesLog.info("MONPeriodosBean.insertaPeriodos(java.util.Collection periodos):Entrada");
        //iteramos la collection insertando los periodos
        Iterator iterPeriodos = periodos.iterator();
        
        while (iterPeriodos.hasNext())
            this.insertaPeriodo((DTOPeriodo)iterPeriodos.next());
            
        UtilidadesLog.info("MONPeriodosBean.insertaPeriodos(java.util.Collection periodos):Salida");
     }

    /**
     * Crea un nuevo periodo haciendo uso de la entidad Periodo.
     * Se captura las excepciones CreateException y RemoteException.
     * En caso de que se produzca alguna, se crea una instancia de MareException
     * con la excepción capturada y un código de error:
     * - Error de Escritura en Base de Datos: 0000000001
     * - Error de Acceso en Base de Datos: 0000000003
     * - Clave duplicada: 0000000004
     * 
     * SE ASUME QUE VIENE ARMADO EL ID Y EL NOMBRE COMO AAAAPP
     * -VER INCIDENCIA 3460 de V2
     */
    public void insertaPeriodo(DTOPeriodo dtoPeriodo) throws MareException {
        UtilidadesLog.info("MONPeriodosBean.insertaPeriodo(DTOPeriodo dtoPeriodo):Entrada");
        BelcorpService belcorpService = null;
        try {
            belcorpService = BelcorpService.getInstance();
            UtilidadesLog.debug("Dto antes de Insertar Periodo: " + dtoPeriodo);
            
            //creamos el periodo
            PeriodoLocalHome periodoLocalHome = new PeriodoLocalHome();            
            PeriodoLocal periodoLocal = periodoLocalHome.create(dtoPeriodo.getCanal(),
                                                dtoPeriodo.getMarca(), dtoPeriodo.getPais(),
                                                dtoPeriodo.getOidPeriodoCorporativo(), dtoPeriodo.getFechaInicio(),
                                                dtoPeriodo.getFechaFin(), dtoPeriodo.getStatus(),
                                                dtoPeriodo.getNombre(),  dtoPeriodo.getAcceso());
            //periodoLocal.setOidAcceso(dtoPeriodo.getAcceso());
            periodoLocal.setPeriodoCorto(dtoPeriodo.getPeriodoCorto());
            periodoLocal.setPeriodoCruce(dtoPeriodo.getPeriodoCruce());
            periodoLocalHome.merge(periodoLocal);

        } catch (EntityExistsException eee) {
            UtilidadesLog.debug(eee);
            sessionContext.setRollbackOnly();
            throw new MareException(eee,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_CLAVE_DUPLICADA));
        } catch (PersistenceException createException) {
            UtilidadesLog.debug(createException);
            sessionContext.setRollbackOnly();
            throw new MareException(createException,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        } catch (Exception exception){
            UtilidadesLog.error(exception);
            sessionContext.setRollbackOnly();
            throw new MareException(exception,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        UtilidadesLog.info("MONPeriodosBean.insertaPeriodo(DTOPeriodo dtoPeriodo):Salida");
    }


    /**
     * Obtiene los Periodos Corporativos de SEG filtrando por anio y canal, ordenando código de periodo. 
     * Sistema Accede, utilizando el servicio JDBCMare que se obtendrá a partir del MII,
     * a la tabla periodos del módulo SEG y recupera el tipo de período asociado al canal elegido,
     * así como la duración estándar para este tipo de período y el número de períodos estándar.  
     * Utiliza la tabla de canales, la de tipo de periodos, la de periodos corporativos y la de i18n.
     * Necesita del dto de entrada: canal, año e idioma.
     * Devuelve el recordSet:
     * - Tipo de Periodo 
     * - NumeroDias eq Duracion eq (FechaInicio - FechaFin + 1)
     * - Oid Tipo de Periodo
     * - Codigo Periodo
     * - Oid Periodo Corporativo
     * - Nombre Periodo Corporativo (internacionalizable)
     * @author gdmarzi
     */
    public DTOSalida obtieneDatosPeriodosCorporativos( DTOAsociadosAPeriodo asociadosAPeriodo) throws MareException {
        UtilidadesLog.info("MONPeriodosBean.obtieneDatosPeriodosCorporativos( DTOAsociadosAPeriodo asociadosAPeriodo):Entrada");
        String codigoError;
        BelcorpService belcorpService;
        RecordSet resultadoQuery;
        String entidad = "SEG_PERIO_CORPO";
        Integer atributo = new Integer(1);
        Long idioma = asociadosAPeriodo.getOidIdioma();

        try {
            belcorpService = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException serviceNotFoundException) {
            UtilidadesLog.error(serviceNotFoundException);
            codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            throw new MareException(serviceNotFoundException,
                UtilidadesError.armarCodigoError(codigoError));
        }

        /* Obtencion de periodos corporativos */
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(" SELECT TP.COD_TIPO_PERI, TP.NUM_DIAS, TP.OID_TIPO_PERI, ");
        stringBuffer.append(" PC.COD_PERI, PC.OID_PERI as OID, i18n.val_i18n NOMB_PERI ");    
        stringBuffer.append(" FROM SEG_CANAL C, SEG_TIPO_PERIO TP, SEG_PERIO_CORPO PC, V_GEN_I18N_SICC i18n ");
        stringBuffer.append(" WHERE C.OID_CANA = ? AND ");
        stringBuffer.append(" PC.VAL_ANIO = ? ");
        //por i18n
        stringBuffer.append(" AND i18n.ATTR_ENTI = ? ");
        stringBuffer.append(" AND i18n.ATTR_NUM_ATRI = ? ");
        stringBuffer.append(" AND i18n.IDIO_OID_IDIO = ? ");
        stringBuffer.append(" AND PC.OID_PERI = i18n.VAL_OID ");
        //join entre tablas
        stringBuffer.append(" AND TP.OID_TIPO_PERI = C.TIPE_OID_TIPO_PERI ");
        stringBuffer.append(" AND TP.OID_TIPO_PERI = PC.TIPE_OID_TIPO_PERI ");
        stringBuffer.append(" ORDER BY PC.cod_peri ");

        Vector vector = new Vector();
        vector.add(asociadosAPeriodo.getCanal());
        vector.add(asociadosAPeriodo.getAnio());
        //por i18n
        vector.add(entidad);
        vector.add(atributo);
        vector.add(idioma);
           
        try {
            resultadoQuery = belcorpService.dbService.executePreparedQuery(stringBuffer.toString(),
                                                                           vector);
        } catch (Exception exception) {
            UtilidadesLog.error(exception);
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(exception, UtilidadesError.armarCodigoError(codigoError));
        }
        
        if (resultadoQuery.esVacio()) {
            UtilidadesLog.debug("resultadoQuery.esVacio()");
            throw new MareException(new Exception(),UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }
        UtilidadesLog.info("MONPeriodosBean.obtieneDatosPeriodosCorporativos( DTOAsociadosAPeriodo asociadosAPeriodo):Salida");
        return new DTOSalida(resultadoQuery);
    }


    /** 
    * Pseudocódigo: 
    * 1.- Tabla canales(modulo CRA) -> obtiene "tipo de periodo" asociados a los datos 
    * que le hemos suministrado. 
    * 2.- Tabla tipo periodos (SEG) -> obtiene la duración que tiene ese determinado tipo de periodo. 
    * Necesita el país, la marca o las marcas y el canal. 
    * Devuelve un RecordSet construido a partir de las consultas. 
    * El RecordSet contiene: 
    * - Duracion (FechaFin - FechaInicio + 1)
    */
    /** Este metodo  debe ser adaptado a como fue refinado obtieneDatosPeriodosCorporativos(DTOAsociadosAPeriodo) */        
    public DTOSalida obtieneDatosPeriodosCorporativos(DTOEntradaMatrizDias dtoEntradaMatrizDias) throws MareException {
        UtilidadesLog.info("MONPeriodosBean.obtieneDatosPeriodosCorporativos(DTOEntradaMatrizDias dtoEntradaMatrizDias):Entrada");

        String codigoError;
        BelcorpService belcorpService;
        RecordSet respuestaRecordSet;

        try {
            belcorpService = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException serviceNotFoundException) {
            codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            UtilidadesLog.error(serviceNotFoundException);
            throw new MareException(serviceNotFoundException,
                UtilidadesError.armarCodigoError(codigoError));
        }
        //Obtencion de tipo de periodo
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("SELECT TP.NUM_DIAS ");
        stringBuffer.append(" FROM SEG_CANAL C, SEG_TIPO_PERIO TP");

        //condiciones para el where
        String whereString = UtilidadesBD.armarSQLWhere(new String[] {
                    "C.OID_CANA"
                }, new Object[] { dtoEntradaMatrizDias.getCanal() },
                new boolean[] { false });

        stringBuffer.append(whereString);

        //join entre tablas
        stringBuffer.append(" AND TP.OID_TIPO_PERI = C.TIPE_OID_TIPO_PERI");

        //ejecutamos la consulta
        try {
            respuestaRecordSet = belcorpService.dbService.executeStaticQuery(stringBuffer.toString());
        } catch (Exception exception) {
            UtilidadesLog.error(exception);
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(exception,
                UtilidadesError.armarCodigoError(codigoError));
        }

        java.math.BigDecimal numeroDiasString = null;
        if (!respuestaRecordSet.esVacio()) {
            numeroDiasString = (java.math.BigDecimal)respuestaRecordSet.getRow(0).elementAt(0);
        } else {
            //error de peticion de datos
            codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
            throw new MareException("El canal no existe", UtilidadesError.armarCodigoError(codigoError));
        }

        //preparamos el recordSet
        respuestaRecordSet = new RecordSet();
        respuestaRecordSet.addColumn("Duracion");

        //agregamos la row al recordset
        respuestaRecordSet.addRow(new Object[] {
                numeroDiasString
        });
        UtilidadesLog.info("MONPeriodosBean.obtieneDatosPeriodosCorporativos(DTOEntradaMatrizDias dtoEntradaMatrizDias):Salida");
        //finalmente devolvemos el DTO
        return new DTOSalida(respuestaRecordSet);
    }
    

    /**
     * Accede a la entidad PERÍODOS y accede con los datos Marca, País y Canal y Año.
     * Si existen buscar el que tenga fecha más tardía y recupera el de esta fecha ->
     * devuelve el recorset de la consulta.
     * Si no existen: Fecha = 1 de enero del año indicado.
     * -----Nota------------------------
     * Al obtener el periodo:
     * Necesita del dto de entrada: país, marca, canal, año.
     * Realiza una consulta SQL filtrada por pais utilizando el servicio JDBCMare que
     * se obtendrá a partir del MII.
     * Devuelve un RecordSet construido a partir de la consulta.
     * El RecordSet contiene:
     * - Tipo de Periodo
     * - Periodo
     * - Nombre del Periodo
     * - Fecha Inicio
     * - Fecha Fin
     * - Duración (FechaFin - FechaInicio + 1)
     * - Numero de Periodos
     * Se captura la excepcion SQLException. En caso de que se produzca, se crea
     * una instancia de MareException con la excepción capturada y un código de error:
     * - Error de Lectura en Base de Datos: 01101000001
     * - Error de Acceso en Base de Datos: 01101000001
     * - Error peticion de datos no existente: 01101000001
     */
    public DTOSalida obtienePeriodo(DTOAsociadosAPeriodo asociadosAPeriodo)
        throws MareException {
        /* Incidencia BELCO00001360
        La marca solo puede ser una, ya que el atributo todas no se va a
        tener en cuenta en esta versión.*/
        return this.obtienePeriodo(
                                    asociadosAPeriodo.getPais(),
                                    asociadosAPeriodo.getMarca(),
                                    asociadosAPeriodo.getCanal(), 
                                    asociadosAPeriodo.getAnio().toString());
    }

    /**
     * Elimina el periodo seleccionado a través de la entidad.
     * Se capturan las excepciones FinderException, RemoveException y RemoteException.
     * En caso de que se produzca una excepción, se crea una instancia de MareException
     * con la excepción capturada.
     * - Error de Escritura en Base de Datos: 0000000001
     * - Error de Lectura en Base de Datos: 0000000002
     * - Error de Acceso en Base de Datos: 0000000003
     * - Error peticion de datos no existente: 0000000005
     */
    public void eliminaPeriodo(DTOID dtoID) throws MareException {
        UtilidadesLog.info("MONPeriodosBean.eliminaPeriodo(DTOID dtoID):Entrada");

        try {
            //validamos que no haya actividades planificadas con fecha anterior a la actual
             if (this.validarActividadesPlanificadasAnteriores(dtoID.getOid()))
                   throw new MareException("", UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_CRA,"",
                       ErroresDeNegocio.VALIDAR_ELIMINAR_PERIODO));    

            //esta todo OK, eliminamos
            PeriodoLocalHome periodoLocalHome = new PeriodoLocalHome();
            PeriodoLocal periodoLocal = periodoLocalHome.findByPrimaryKey(dtoID.getOid());
            periodoLocalHome.remove(periodoLocal);
        } catch(MareException me) {
            UtilidadesLog.error(me);
            throw me;
        } catch (NoResultException finderException) {
            UtilidadesLog.debug(finderException);
            sessionContext.setRollbackOnly();
            throw new MareException(finderException,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        } catch (PersistenceException pe) {
                UtilidadesLog.debug(pe);
                sessionContext.setRollbackOnly();
                throw new MareException(pe,
                    UtilidadesError.armarCodigoError(
                        CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        } catch (Exception exception) {
            UtilidadesLog.error(exception);
            sessionContext.setRollbackOnly();
            throw new MareException(exception,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
        UtilidadesLog.info("MONPeriodosBean.eliminaPeriodo(DTOID dtoID):Salida");
    }

    /**
     * Elimina varios periodos a través de la entidad.
     * Se capturan las excepciones FinderException, RemoveException y RemoteException.
     * En caso de que se produzca una excepción, se crea una instancia de MareException
     * con la excepción capturada.
     */
    public void eliminaVariosPeriodos(DTOOIDs dtoOids) throws MareException {
        UtilidadesLog.info("MONPeriodosBean.eliminaVariosPeriodos(DTOOIDs dtoOids):Entrada");
        Long oidPeriodo;
        
        try {
            //por cada oidPeriodo
            for (int i=0; i < dtoOids.getOids().length; i++) {
                //obtengo el oid del periodo a eliminar
                oidPeriodo = dtoOids.getOids()[i];
                //validamos que no haya actividades planificadas con fecha anterior a la actual
                 if (this.validarActividadesPlanificadasAnteriores(oidPeriodo))
                       throw new MareException("", UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_CRA,"",
                           ErroresDeNegocio.VALIDAR_ELIMINAR_PERIODO));    

                //esta todo OK, eliminamos
                PeriodoLocalHome periodoLocalHome = new PeriodoLocalHome();
                PeriodoLocal periodoLocal = periodoLocalHome.findByPrimaryKey(oidPeriodo);
                periodoLocalHome.remove(periodoLocal);
            }
        }catch(MareException me){
            UtilidadesLog.error(me);
            throw me;
        } catch (FinderException finderException) {
            UtilidadesLog.debug(finderException);
            sessionContext.setRollbackOnly();
            throw new MareException(finderException,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        } catch (PersistenceException pe) {
                UtilidadesLog.debug(pe);
                sessionContext.setRollbackOnly();
                throw new MareException(pe,
                    UtilidadesError.armarCodigoError(
                        CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        } catch (Exception exception) {
            UtilidadesLog.error(exception);
            sessionContext.setRollbackOnly();
            throw new MareException(exception,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
        UtilidadesLog.info("MONPeriodosBean.eliminaVariosPeriodos(DTOOIDs dtoOids):Salida");
    }


    /**
     * Devuelve true si hay actividades planificadas para la fecha anterior a la actual
     * y ademas pertenezcan a la marca, canal, pais y periodo pasado por parametro.
     */
    private boolean validarActividadesPlanificadasAnteriores(Long oidPeriodo) throws MareMiiServiceNotFoundException, Exception{
        UtilidadesLog.info("MONPeriodosBean.validarActividadesPlanificadasAnteriores(Long oidPeriodo):Entrada");
		BelcorpService belcorpService;
        RecordSet respuestaRecordSet = null;
    	belcorpService = BelcorpService.getInstance();
        /* gdmarzi -- Ahora en la V3, busco por el oidPeriodo, en ves de por marca, canal, pais y periodo */

        //armamos la consulta 
        StringBuffer query = new StringBuffer("SELECT * FROM CRA_CRONO C, CRA_PERIO P ");
        query.append(" WHERE C.PERD_OID_PERI = P.OID_PERI AND ");
        query.append(" P.OID_PERI = ? AND ");
        query.append(" C.FEC_INIC < TO_DATE(?,'YYYY-MM-DD') ");

        //armamos los parametros
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String strFechaHoy = sdf.format(new java.sql.Date(System.currentTimeMillis()));
        UtilidadesLog.debug("strFechaHoy: " + strFechaHoy);
        Vector parametros = new Vector();
        parametros.add(oidPeriodo);
        parametros.add(strFechaHoy);

        //ejecutamos la consulta
    	respuestaRecordSet = belcorpService.dbService.executePreparedQuery(query.toString(),parametros);
        UtilidadesLog.info("MONPeriodosBean.validarActividadesPlanificadasAnteriores(Long oidPeriodo):Salida");
        return (!respuestaRecordSet.esVacio());
    }


    /**
     * 1.- Accede a la TABLA PERIODOS (A TRAVES DE DBService) a recuperar todos los períodos 
     * posteriores al período recibido en el dtoEntrada. 
     * 2.- De la información de los períodos recuperados, el Sistema modifica 
     * las fechas de inicio y fin en función del período inicial recibido por parámetro,
     * manteniendo para cada período la duración en días que ya tenía. 
     * 3.- Sistema modifica registros de la ENTIDAD PERIODO. Verificará que los períodos
     * que se están modificando no son anteriores a la fecha actual, es decir,
     * que no se ha procesado ya, ni tampoco esté en proceso en este momento,
     * teniendo en cuenta que puede tener actividades anteriores a la fecha de inicio del período 
     * y por lo tanto puede tener actividades que ya se han ejecutado. 
     */
    public void recalculaPeriodos(DTORecalculoPeriodos recalculoPeriodos) throws MareException{
        UtilidadesLog.info("MONPeriodosBean.recalculaPeriodos(DTORecalculoPeriodos recalculoPeriodos):Entrada");
        //coleccion de periodos posteriores desde BBDD
        Collection periodos = new ArrayList();
        Iterator iterPeriodos;
        
        /* 1.- recuperar todos los períodos posteriores al período recibido en el recalculoPeriodos. */
        periodos = this.obtienePeriodosPosteriores(recalculoPeriodos.getPeriodo());

        /* 2.- Actualizamos los periodos */
        Collection collResultado = new ArrayList(); //coleccion de periodos despues de procesar
        Iterator iterCollResultado;
        try {
            //recalculamos el periodo que ha sido modificado para verificar que 
            //las fechas no caigan feriados, le pasamos su misma fecha de inicio para 
            //que no la desplace.
            this.recalcularUnaFechaPeriodo(recalculoPeriodos.getPeriodo(),recalculoPeriodos.getPeriodo().getFechaInicio());

            //recorremos los periodos recalculando los que son posteriores al recibido
            //en el DTO y reacomodando las fechas del mismo si son feriados
            int idPeriodoRecalculado = Integer.parseInt(recalculoPeriodos.getPeriodo().getCodigoPeriodo());
            DTOPeriodo periodoAnterior = new DTOPeriodo();
            periodoAnterior = recalculoPeriodos.getPeriodo();

            iterPeriodos = periodos.iterator();
            while (iterPeriodos.hasNext()) {
                DTOPeriodo periodoProcesado = (DTOPeriodo)iterPeriodos.next();
                int idPeriodoProcesado = Integer.parseInt(periodoProcesado.getCodigoPeriodo());
                
                if (idPeriodoProcesado > idPeriodoRecalculado){
                    //obtenemos el dia despues de la fecha de finalizacion del periodo anterior
                    java.sql.Date fechaFinPeriodoAnterior = null;
                    fechaFinPeriodoAnterior = this.addDaysToDate(periodoAnterior.getFechaFin(),1);
                    
                    this.recalcularUnaFechaPeriodo(periodoProcesado,fechaFinPeriodoAnterior);

                    //actualizamos el periodoAnterior
                    periodoAnterior = periodoProcesado;                    
                }//if

                if (idPeriodoProcesado == idPeriodoRecalculado)
                    collResultado.add(recalculoPeriodos.getPeriodo());
                else
                    collResultado.add(periodoProcesado);                
            }//while

            /* 3.- Persistimos los registros procesados */
            //persistimos el periodo inicial
            this.actualizaPeriodo(recalculoPeriodos.getPeriodo());
            //persistimos los posteriores
            iterCollResultado = collResultado.iterator();
            while (iterCollResultado.hasNext()) {
                DTOPeriodo dtoPeriodo = (DTOPeriodo)iterCollResultado.next();
                this.actualizaPeriodo(dtoPeriodo);
            }

        } catch (MareMiiServiceNotFoundException serviceNotFoundException) {
            UtilidadesLog.error(serviceNotFoundException);
            throw new MareException(serviceNotFoundException,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        } catch (Exception exception) {
            UtilidadesLog.error(exception);
            sessionContext.setRollbackOnly();
            throw new MareException(exception,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        UtilidadesLog.info("MONPeriodosBean.recalculaPeriodos(DTORecalculoPeriodos recalculoPeriodos):Salida");
    }


    /**
     * Reacomoda todos los periodos posteriores al recibido en el DTORecalculoPeriodos. 
     * El recalculo de periodos se realiza de manera tal que estos queden contiguos; para 
     * ello se corren las fechas de inicio y fin de los posteriores (se mantiene la duracion 
     * de los periodos) para que comiencen un dia habil despues de sus correspondientes 
     * periodos predecesores.
     */
    public Collection recalculaPeriodos(DTORecalculoPeriodos recalculoPeriodos,Collection collPeriodos)
        throws MareException {
        UtilidadesLog.info("MONPeriodosBean.recalculaPeriodos(DTORecalculoPeriodos recalculoPeriodos,Collection collPeriodos):Entrada");

        //la collection resultado
        Collection collResultado = new ArrayList();
        Iterator iterPeriodos = collPeriodos.iterator();
            
        try {
            //recalculamos el periodo que ha sido modificado para verificar que 
            //las fechas no caigan feriados, le pasamos su misma fecha de inicio para 
            //que no la desplace.
            this.recalcularUnaFechaPeriodo(recalculoPeriodos.getPeriodo(),recalculoPeriodos.getPeriodo().getFechaInicio());

            //recorremos los periodos recalculando los que son posteriores al recibido
            //en el DTO y reacomodando las fechas del mismo si son feriados
            int idPeriodoRecalculado = Integer.parseInt(recalculoPeriodos.getPeriodo().getCodigoPeriodo());
            DTOPeriodo periodoAnterior = new DTOPeriodo();
            periodoAnterior = recalculoPeriodos.getPeriodo();
            
            while (iterPeriodos.hasNext()){
                DTOPeriodo periodoProcesado = (DTOPeriodo)iterPeriodos.next();
                int idPeriodoProcesado = Integer.parseInt(periodoProcesado.getCodigoPeriodo());
                
                if (idPeriodoProcesado > idPeriodoRecalculado){
                    //obtenemos el dia despues de la fecha de finalizacion del periodo anterior
                    java.sql.Date fechaFinPeriodoAnterior = null;
                    fechaFinPeriodoAnterior = this.addDaysToDate(periodoAnterior.getFechaFin(),1);
                    
                    this.recalcularUnaFechaPeriodo(periodoProcesado,fechaFinPeriodoAnterior);

                    //actualizamos el periodoAnterior
                    periodoAnterior = periodoProcesado;                    
                }//if

                if (idPeriodoProcesado == idPeriodoRecalculado)
                    collResultado.add(recalculoPeriodos.getPeriodo());
                else
                    collResultado.add(periodoProcesado);                
            }//while

            //finalmente devolvemos la collection
            UtilidadesLog.info("MONPeriodosBean.recalculaPeriodos(DTORecalculoPeriodos recalculoPeriodos,Collection collPeriodos):Salida");
            return collResultado;           
        } catch (MareMiiServiceNotFoundException serviceNotFoundException) {
            UtilidadesLog.error(serviceNotFoundException);
            throw new MareException(serviceNotFoundException,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        } catch (Exception exception) {
            UtilidadesLog.error(exception);
            sessionContext.setRollbackOnly();
            throw new MareException(exception,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        

    }


    /**
     * Suma la diferencia de dias recibida a la fecha de inicio o fin del 
     * periodo recibido, verificando que las nueva fechas no sean feriados (se actualiza la 
     * duracion del periodo en conseconsecuencia).
     * duracion (fechaFin - FechaInicio + 1)
     */
    private void recalcularUnaFechaPeriodo(DTOPeriodo periodo,Date newFechaInicio) throws Exception{
        UtilidadesLog.info("MONPeriodosBean.recalcularUnaFechaPeriodo(DTOPeriodo periodo,Date newFechaInicio):Entrada");

        UtilidadesLog.debug(" -------- Recalculando la fecha de inicio del periodo " + periodo.getCodigoPeriodo() + "-------" );
        UtilidadesLog.debug(" -------- Fecha de inicio del periodo anterior " + newFechaInicio + "-------" );        
        java.sql.Date newFechaFin = null;
        Integer duracion = periodo.getDuracion();
          
        //Hasta que no estamos seguros que la fecha inicio no es feriado seguimos recalculando
        Integer anio = Integer.valueOf(periodo.getCodigoPeriodo().substring(0,4));
        while (this.esFestivo(newFechaInicio,anio,periodo.getCanal(),periodo.getMarca(),periodo.getPais())){
            UtilidadesLog.debug("La fecha " + newFechaInicio + " es feriado, la nueva fecha quedo: " +
                                                            this.addDaysToDate(newFechaInicio,1));
            newFechaInicio = this.addDaysToDate(newFechaInicio,1);
        }
        
        //seteamos la nueva fecha de inicio
        periodo.setFechaInicio(newFechaInicio);

        //desplazamos la fecha fin ( fechaFin = fechaInicio + duracion  - 1)
        newFechaFin = this.addDaysToDate( periodo.getFechaInicio(), periodo.getDuracion().intValue() - 1);
        
        //Hasta que no estamos seguros que la fecha fin no es feriado seguimos recalculando
        while (this.esFestivo(newFechaFin,anio,periodo.getCanal(),periodo.getMarca(),periodo.getPais())){
            UtilidadesLog.debug("La fecha " + newFechaFin + " es feriado, la nueva fecha quedo: " +
                                                            this.addDaysToDate(newFechaFin,1));
            newFechaFin = this.addDaysToDate(newFechaFin,1);
        }

        //seteamos los nuevos atributos recalculando la duracion 
        //segun diseñador hgarcia: duracion = fechaInicio - fechaFin + 1
        duracion = new Integer((this.dayDiff(newFechaFin,newFechaInicio)).intValue() + 1) ;
        UtilidadesLog.debug("Fecha Inicio: " + newFechaInicio + " / Fecha Fin: " + newFechaFin + " / Duracion: " + duracion);                    
        periodo.setDuracion(duracion);
        periodo.setFechaFin(newFechaFin);
        UtilidadesLog.debug(" -------- Fin del Recalculo de la fecha de inicio del periodo " + periodo.getCodigoPeriodo() + "-------" );    
        UtilidadesLog.info("MONPeriodosBean.recalcularUnaFechaPeriodo(DTOPeriodo periodo,Date newFechaInicio):Salida");
    }


    /**
     * Si la fecha pasada por parametro es un feriado devuelve true, sino devuelve false 
     */
    private boolean esFestivo(java.sql.Date fecha,Integer anio,Long canal,Long marca, Long pais) throws Exception{
            UtilidadesLog.info("MONPeriodosBean.esFestivo(java.sql.Date fecha,Integer anio,Long canal,Long marca, Long pais):Entrada");
            //verificamos si existe el feriado en la tabla
            BelcorpService belcorpService = BelcorpService.getInstance();
            RecordSet respuestaRecordSet = null;
            
            StringBuffer stringBuffer = new StringBuffer(" SELECT F.IND_FEST FROM CRA_FERIA F, CRA_CABEC_GRUPO_ZONA C ");
            stringBuffer.append(" WHERE F.CGZO_OID_CABE_GRUP_ZONA = C.OID_CABE_GRUP_ZONA AND ");
            stringBuffer.append(" F.FEC_FERI = ? AND F.NUM_ANIO = ? AND C.CANA_OID_CANA = ? ");
            stringBuffer.append(" AND C.MARC_OID_MARC = ? AND C.PAIS_OID_PAIS = ?");
            
            Vector vector = new Vector();
            vector.add(fecha);
            vector.add(anio);
            vector.add(canal);
            vector.add(marca);            
            vector.add(pais);
            //ejecutamos la consulta
            respuestaRecordSet = belcorpService.dbService.executePreparedQuery
                                        (stringBuffer.toString(),vector);

            //si es recordSet volvio vacio (no estaba el dia festivo) no es festivo
            if (respuestaRecordSet.esVacio()){
                UtilidadesLog.info("MONPeriodosBean.esFestivo(java.sql.Date fecha,Integer anio,Long canal,Long marca, Long pais):Salida");
                return false;
            }else{
                UtilidadesLog.info("MONPeriodosBean.esFestivo(java.sql.Date fecha,Integer anio,Long canal,Long marca, Long pais):Salida");
                return true;
            }
    }
    

    /**
     * Devuelve la fecha suministrada + la cantidad de dias suministrados
     */
    private java.sql.Date addDaysToDate(java.sql.Date fecha, int numDays){
        //la cantidad de milisegundos en un dia
        long oneDayMillis = 1000L*60L*60L*24L;
        
        //pasamos el resultado a dias
        return new java.sql.Date(fecha.getTime() + (numDays*oneDayMillis));
    }

    
    public DTOSalida recuperaTodos() throws MareException {
        UtilidadesLog.info("MONPeriodosBean.recuperaTodos():Entrada");
        BelcorpService belcorpService;
        RecordSet respuestaRecordSet;

        try {
            belcorpService = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException serviceNotFoundException) {
            UtilidadesLog.error(serviceNotFoundException);
            throw new MareException(serviceNotFoundException,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        try {
            StringBuffer stringBuffer = new StringBuffer(" SELECT PAIS_OID_PAIS, MARC_OID_MARC, ACCE_OID_ACCE, ");
            stringBuffer.append(" CANA_OID_CANA, PC.COD_PERI, VAL_NOMB_PERI, (FEC_FINA - FEC_INIC + 1) AS DURA, FEC_INIC, ");
            stringBuffer.append(" FEC_FINA, VAL_ESTA, PERI_OID_PERI, ");
            stringBuffer.append(" decode(IND_PERI_CORT,1,'true','false') as IND_PERI_CORT, decode(IND_PERI_CRUC,1,'true','false') as IND_PERI_CRUC ");
            stringBuffer.append(" FROM CRA_PERIO P, SEG_PERIO_CORPO PC ");
            stringBuffer.append(" WHERE P.PERI_OID_PERI = PC.OID_PERI ");

            respuestaRecordSet = belcorpService.dbService.executeStaticQuery(stringBuffer.toString());
        } catch (Exception exception) {
            UtilidadesLog.error(exception);
            throw new MareException(exception,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        UtilidadesLog.info("MONPeriodosBean.recuperaTodos():Salida");
        return new DTOSalida(respuestaRecordSet);
    }


    /**
     * Accede a la entidad PERÍODOS y accede con los datos Marca, País y Canal y Año.
     * Si existen buscar el que tenga fecha más tardía y recupera el de esta fecha ->
     * devuelve el recorset de la consulta.
     * Si no existen: Fecha = 1 de enero del año indicado mas uno.
     * 
     * Precondiciones:
     *      -se recibe por parametro el anio anterior.
     *      -se retorna la fecha del año actual (anio siguiente al parametro anio)
     */
    public DTOSalida obtienePeriodo(Long pais, Long marca, Long canal, String anio) throws MareException {
        UtilidadesLog.info("MONPeriodosBean.obtienePeriodo(Long pais, Long marca, Long canal, String anio):Entrada");
        BelcorpService belcorpService;

        try {
            belcorpService = BelcorpService.getInstance();

            //hacemos la consulta usando JDBC
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("SELECT TP.COD_TIPO_PERI, PC.COD_PERI, VAL_NOMB_PERI, ");
            stringBuffer.append("(FEC_FINA - FEC_INIC + 1) AS DURA, FEC_INIC, FEC_FINA, PC.OID_PERI");
            stringBuffer.append(" FROM CRA_PERIO P, SEG_PERIO_CORPO PC, SEG_TIPO_PERIO TP ");
            stringBuffer.append(" WHERE PC.VAL_ANIO = ? AND");
            stringBuffer.append(" PAIS_OID_PAIS = ? AND");
            //Si el oid de la marca es 0, metadato todos, entonces se omite el filtro de marca
            if (marca.longValue() != 0)  stringBuffer.append(" MARC_OID_MARC = ? AND");
            stringBuffer.append(" CANA_OID_CANA = ? AND");
            //joins para obtener el tipo de periodo
            stringBuffer.append(" P.PERI_OID_PERI = PC.OID_PERI AND");
            stringBuffer.append(" PC.TIPE_OID_TIPO_PERI = TP.OID_TIPO_PERI ");
            stringBuffer.append(" ORDER BY FEC_FINA DESC ");

            Vector vector = new Vector();
            vector.add(anio);
            vector.add(pais);
            //Si el oid de la marca es 0, metadato todos, entonces se omite el filtro de marca
            if (marca.longValue() != 0)  vector.add(marca);
            vector.add(canal);

            RecordSet recordSet = belcorpService.dbService.executePreparedQuery(stringBuffer.toString(),
                    vector);

            //creamos un nuevo recordSet con un solo registro
            RecordSet nuevoRecordSet = new RecordSet();
          
            //Si no existen: Fecha = 1 de enero del año indicado.
            if (recordSet.esVacio()){
                UtilidadesLog.debug("No existe registros, 1 de enero del año indicado.");
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");                
                Vector resultado = new Vector();
                String anioSiguiente = (new Integer((new Integer(anio)).intValue() + 1)).toString();
                resultado.add(new java.sql.Date(sdf.parse("1/1/" + anioSiguiente).getTime()));
                nuevoRecordSet.addColumn("FEC_FINA");                      
                nuevoRecordSet.addRow(resultado);
            }else{
                UtilidadesLog.debug("Se retorna el periodo que tiene la fecha más tardía.");
                nuevoRecordSet.addColumn("COD_TIPO_PERI");
                nuevoRecordSet.addColumn("COD_PERI");
                nuevoRecordSet.addColumn("VAL_NOMB_PERI");
                nuevoRecordSet.addColumn("DURA");
                nuevoRecordSet.addColumn("FEC_INIC");            
                nuevoRecordSet.addColumn("FEC_FINA");
                nuevoRecordSet.addColumn("OID_PERI");
                nuevoRecordSet.addRow(recordSet.getRow(0));
            }
            UtilidadesLog.info("MONPeriodosBean.obtienePeriodo(Long pais, Long marca, Long canal, String anio):Salida");
            return new DTOSalida(nuevoRecordSet);
        } catch (MareMiiServiceNotFoundException serviceNotFoundException) {
            UtilidadesLog.error(serviceNotFoundException);
            throw new MareException(serviceNotFoundException,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        } catch (Exception exception) {
            UtilidadesLog.error(exception);
            throw new MareException(exception,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
    }


    /**
     * Selecciona mediante DBService los periodos con el filtro pais, marca, canal
     * y cuya fecha inicial es mayor que la actual.
     *
     * Devuelve un RecordSet construido a partir de la consulta.
     * El RecordSet contiene:
     * - Tipo de Periodo
     * - Periodo
     * - Nombre del Periodo
     * Se captura la excepcion SQLException. En caso de que se produzca, se crea una
     * instancia de MareException con la excepción capturada y un código de error:
     * - Error de Lectura en Base de Datos: 01101000001
     * - Error de Acceso en Base de Datos: 01101000001
     * - Error peticion de datos no existente: 01101000001
     */
    public DTOSalida obtienePeriodosPMCPosteriores(Integer pais, Integer marca,
        Integer canal) throws MareException {
        UtilidadesLog.info("MONPeriodosBean. obtienePeriodosPMCPosteriores(Integer pais, Integer marca,Integer canal):Entrada");
        BelcorpService belcorpService;

        try {
            belcorpService = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException serviceNotFoundException) {
            UtilidadesLog.error(serviceNotFoundException);
            throw new MareException(serviceNotFoundException,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        try {
            //obtenemos la fecha actual
            java.sql.Date currentDate = new java.sql.Date(System.currentTimeMillis());

            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(" SELECT PERI_OID_PERI, PC.COD_PERI, VAL_NOMB_PERI ");
            stringBuffer.append(" FROM CRA_PERIO P, SEG_PERIO_CORPO PC ");
            stringBuffer.append(" WHERE FEC_INIC > ? AND ");
            stringBuffer.append(" PAIS_OID_PAIS = ? AND ");
            stringBuffer.append(" P.PERI_OID_PERI = PC.OID_PERI AND");
            //Si el oid de la marca es 0, metadato todos, entonces se omite el filtro de marca
            if (marca.longValue() != 0) stringBuffer.append(" MARC_OID_MARC = ? AND");
            stringBuffer.append(" CANA_OID_CANA = ? ");

            Vector vector = new Vector();
            vector.add(currentDate);
            vector.add(pais);
            //Si el oid de la marca es 0, metadato todos, entonces se omite el filtro de marca
            if (marca.longValue() != 0) vector.add(marca);
            vector.add(canal);

            RecordSet recordSet = belcorpService.dbService.executePreparedQuery(stringBuffer.toString(),
                    vector);
            UtilidadesLog.info("MONPeriodosBean. obtienePeriodosPMCPosteriores(Integer pais, Integer marca,Integer canal):Salida");
            return new DTOSalida(recordSet);
        } catch (Exception exception) {
            UtilidadesLog.error(exception);
            throw new MareException(exception,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
    }

    /**
     * Obtiene los periodos anteriores a uno dado que esten en la matriz de facturacion.
     * Se recibe en el dtoPeriodo el oid de periodo. Se filtra segun la fecha de inicio de ese periodo.
     * @author gdmarzi
     */
    public DTOSalida obtienePeriodosAnteriores(DTOPeriodo dtoID) throws MareException {
        UtilidadesLog.info("MONPeriodosBean.obtienePeriodosAnteriores(DTOPeriodo dtoID):Entrada");
        //Este metodo es usado en PRE usando el BusinessID PREObtenerPeriodosAnteriores
        int SECOND = 1000;
        int MINUTE = 60 * SECOND;
        int HOUR = 60 * MINUTE;
        long DAY = 24 * HOUR;

        BelcorpService miBerlcorpService = null;
        String codigoError = null;
        RecordSet respuesta = null;
        long anio = 365 * DAY;

        try {
            miBerlcorpService = BelcorpService.getInstance();

            PeriodoLocalHome periodoLocalHome = new PeriodoLocalHome();
            PeriodoLocal periodoLocal = periodoLocalHome.findByPrimaryKey(dtoID.getOid());

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String strFechaInicioMenosAnio = sdf.format(new java.sql.Date(periodoLocal.getFechainicio().getTime() - anio));

            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(" SELECT DISTINCT  PC.COD_PERI, P.VAL_NOMB_PERI, P.OID_PERI ");
            stringBuffer.append(" FROM CRA_PERIO P, PRE_MATRI_FACTU_CABEC MFC, SEG_PERIO_CORPO PC ");
            stringBuffer.append(" WHERE TO_DATE(' " + strFechaInicioMenosAnio + "', 'yyyy-mm-dd') < P.FEC_INIC and ");
            stringBuffer.append(" P.MARC_OID_MARC = " + periodoLocal.getOidMarca() + " and ");
            stringBuffer.append(" P.CANA_OID_CANA = " + periodoLocal.getOidCanal() + " and ");
            stringBuffer.append(" P.PAIS_OID_PAIS = " + periodoLocal.getOidPais() + " and ");
            stringBuffer.append(" P.PERI_OID_PERI = PC.OID_PERI and ");
            stringBuffer.append(" P.OID_PERI = MFC.PERD_OID_PERI ");

            respuesta = miBerlcorpService.dbService.executeStaticQuery(stringBuffer.toString());
            UtilidadesLog.info("MONPeriodosBean.obtienePeriodosAnteriores(DTOPeriodo dtoID):Salida");
            return new DTOSalida(respuesta);
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error(e);
            sessionContext.setRollbackOnly();
            codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
         } catch (FinderException finderException) {
            UtilidadesLog.debug(finderException);
            sessionContext.setRollbackOnly();
            throw new MareException(finderException,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        } catch (RemoveException removeException) {
            UtilidadesLog.debug(removeException);
            sessionContext.setRollbackOnly();
            throw new MareException(removeException,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        } catch (Exception e) {
            UtilidadesLog.error(e);
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
       }
    }


    /**
     * Método que a partir del periodoActual y el desplazamiento devuelve el periodo
     * correspondiente a periodoActual + desplazamiento, es decir, si el periodoActual
     * es 05/03 y desplazamiento es +2 devolvería el 07/03. En caso de que el año 2003 
     * tuviera únicamente 6 periodos devolvería el primero 
     * del año siguiente: 01/04.     
     * 
     * Esto lo realizará una consulta SQL a través de DBService sobre la entidad
     * Periodo y devolverá el código de periodo que cumpla lo anterior para el pais,
     * marca y canal de entrada al método.
     *
     * El valor del campo desplazamiento también puede ser negativo, con lo que devolvería
     * un periodo anterior al actual.
     * El método devolverá el código del periodo que viene encapsulado en el ResultSet
     * devuelto por la consulta
     * 
     * SI EL DESPLAZAMIENTO ES 0 ó ES MAYOR A LA CANTIDAD DE PERIODOS ANTERIORES O POSTERIORES
     * LAMZAMOS UNA MARE EXCEPTION.
     */
    public DTOSalida obtienePeriodoEvaluacion(Integer desplazamiento, String periodoActual, Long pais, Long marca, Long canal)
        throws MareException {
        UtilidadesLog.info("MONPeriodosBean.obtienePeriodoEvaluacion(Integer desplazamiento, String periodoActual, Long pais, Long marca, Long canal):Entrada");
        BelcorpService belcorpService;

       if (desplazamiento.intValue() == 0) {
            RecordSet respuesta = new RecordSet();
            respuesta.addColumn("idPeriodo");
            respuesta.addRow(new Object[]{periodoActual});
            UtilidadesLog.info("MONPeriodosBean.obtienePeriodoEvaluacion(Integer desplazamiento, String periodoActual, Long pais, Long marca, Long canal):Salida");
            return new DTOSalida(respuesta);
       }
       
        try {
            belcorpService = BelcorpService.getInstance();

            StringBuffer query = new StringBuffer("SELECT PC.COD_PERI ");
            query.append(" FROM CRA_PERIO P, SEG_PERIO_CORPO PC ");
            query.append(" WHERE PAIS_OID_PAIS = ? AND ");
            //Si el oid de la marca es 0, metadato todos, entonces se omite el filtro de marca
            if (marca.longValue() != 0) query.append(" MARC_OID_MARC = ? AND ");
            query.append(" CANA_OID_CANA = ? AND ");
            query.append(" P.PERI_OID_PERI = PC.OID_PERI AND ");

            //si el offset es positivo buscamos las siguintes a la fecha
            if (desplazamiento.intValue() > 0) 
                query.append(" FEC_INIC > ");            
            else   //si el offset es negativo buscamos las anteriores a la fecha
                query.append(" FEC_INIC < ");

            //agregamos la consulta anidada                
                query.append(" (SELECT FEC_INIC ");
                query.append(" FROM CRA_PERIO P, SEG_PERIO_CORPO PC ");
                query.append(" WHERE PAIS_OID_PAIS = ? AND ");
                //Si el oid de la marca es 0, metadato todos, entonces se omite el filtro de marca
                if (marca.longValue() != 0) query.append(" MARC_OID_MARC = ? AND ");
                query.append(" CANA_OID_CANA = ? AND ");
                query.append(" P.PERI_OID_PERI = PC.OID_PERI AND ");
                query.append(" PC.COD_PERI = ? ) ");

            //agregamos el order by de acuerdo al desplazamiento
            if (desplazamiento.intValue() > 0) 
                query.append(" ORDER BY FEC_INIC ASC ");
            else   //si el offset es negativo buscamos las anteriores a la fecha
                query.append(" ORDER BY FEC_INIC DESC ");
            
            //armamos el vector de parametros
            Vector parametros = new Vector();
            parametros.add(pais);
            //Si el oid de la marca es 0, metadato todos, entonces se omite el filtro de marca
            if (marca.longValue() != 0) parametros.add(marca);
            parametros.add(canal);
            parametros.add(pais);
            //Si el oid de la marca es 0, metadato todos, entonces se omite el filtro de marca
            if (marca.longValue() != 0) parametros.add(marca);
            parametros.add(canal);
            parametros.add(periodoActual);
            
            //hacemos la consulta
            RecordSet respuesta = belcorpService.dbService.executePreparedQuery(
                            query.toString(),parametros);

            //obtenemos el registro con el offset = desplazamiento
            if (!respuesta.esVacio()){
                //si la cantidad de registros es menor que el valor absoluto del desplazamiento
                //tiramos una mareException
                if (respuesta.getRowCount() < Math.abs(desplazamiento.intValue()))
                    throw new MareException("Desplazamiento mayor al esperado: " + 
                    respuesta.getRowCount() + " > " + Math.abs(desplazamiento.intValue()));

                //si esta todo ok armamos el nuevo recordSet
                String idPeriodo = (String)respuesta.getRow(Math.abs(desplazamiento.intValue())-1).get(0);
                respuesta = new RecordSet();
                respuesta.addColumn("idPeriodo");
                respuesta.addRow(new Object[]{idPeriodo});
                UtilidadesLog.info("MONPeriodosBean.obtienePeriodoEvaluacion(Integer desplazamiento, String periodoActual, Long pais, Long marca, Long canal):Salida");
                return new DTOSalida(respuesta);
            }else{                
                UtilidadesLog.info("MONPeriodosBean.obtienePeriodoEvaluacion(Integer desplazamiento, String periodoActual, Long pais, Long marca, Long canal):Salida");
                return new DTOSalida(new RecordSet());
            }
        } catch (MareMiiServiceNotFoundException serviceNotFoundException) {
            UtilidadesLog.error(serviceNotFoundException);
            throw new MareException(serviceNotFoundException,
                UtilidadesError.armarCodigoError(
                   CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        } catch (Exception exception) {
            UtilidadesLog.error(exception);
            throw new MareException(exception,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }        
    }


    /**
     * Previamente a la actualización de la BD verificará que el período que se quiere 
     * modificar no es anterior a la fecha actual, es decir, que no se ha procesado ya,
     * ni tampoco esté en proceso en este momento, teniendo en cuenta que puede tener 
     * actividades anteriores a la fecha de inicio del período y por lo tanto puede 
     * tener actividades que ya se han ejecutado.
     * En caso de que todo sea correcto Actualiza un periodo haciendo uso de la 
     * entidad Periodo. 
     * 
     * SE DEBEN VALIDAR DOS COSAS:
     * - QUE EL PERIODO TENGA FECHA DE INICIO MAYOR O IGUAL A LA ACTUAL.
     * - QUE NO HAYA ACTIVIDADES PROGRAMADAS (ENTIDAD CRONOGRAMA) CON FECHA DE INICIO
     * MENOR A LA ACTUAL.
     */
    public void actualizaPeriodo(DTOPeriodo dtoEntrada) throws MareException {
        UtilidadesLog.info("MONPeriodosBean.actualizaPeriodo(DTOPeriodo dtoEntrada):Entrada");
        BelcorpService belcorpService;
        boolean bModificado = false;
        
        try {
            belcorpService = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException serviceNotFoundException) {
            UtilidadesLog.error(serviceNotFoundException);
            throw new MareException(serviceNotFoundException,
                UtilidadesError.armarCodigoError(
                   CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        PeriodoLocalHome periodoLocalHome = new PeriodoLocalHome();
        try {
            PeriodoLocal periodoLocal = periodoLocalHome.findByPrimaryKey(dtoEntrada.getOid());

            //si el atributo boolean es null en la BBDD, entonces su valor por defecto es false 
            if (periodoLocal.getPeriodoCorto() == null) {
                periodoLocal.setPeriodoCorto(Boolean.FALSE);
            }
            if (periodoLocal.getPeriodoCruce() == null) {
                periodoLocal.setPeriodoCruce(Boolean.FALSE);
            }

            // Verificamos si de modifico algun dato del periodo
            if ( (! dtoEntrada.getNombre().equals(periodoLocal.getNombrePeriodo())) || 
                    (! dtoEntrada.getFechaInicio().equals(periodoLocal.getFechainicio())) ||
                    (! dtoEntrada.getFechaFin().equals(periodoLocal.getFechaFin())) ||
                    (! dtoEntrada.getPeriodoCorto().equals(periodoLocal.getPeriodoCorto())) ||
                    (! dtoEntrada.getPeriodoCruce().equals(periodoLocal.getPeriodoCruce())) ) {
                UtilidadesLog.debug(" El periodo " + dtoEntrada.getCodigoPeriodo() + " viene modificado.");
                bModificado = true;
            }

            // Si se modifico algun atributo del periodo entonces valida y modifica
            if ( bModificado ) {

                // chequeamos la fecha de inicio del periodo contra la fecha actual,
                // si es menor se indica que no se puede modificar un periodo que ya se inicio.
//                if (periodoLocal.getFechainicio().getTime() < System.currentTimeMillis()) {
//                    UtilidadesLog.debug(" El periodo " + dtoEntrada.getCodigoPeriodo() + " tiene fecha de inicio menor a la actual.");
//                    throw new MareException("", UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_CRA,"",
//                            ErroresDeNegocio.VALIDAR_ELIMINACION_PERIODO_ANTERIOR));
//                }

                //validamos que no haya actividades planificadas con fecha anterior a la actual
                if (this.validarActividadesPlanificadasAnteriores(dtoEntrada.getOid())){
                    UtilidadesLog.debug(" El periodo " + dtoEntrada.getCodigoPeriodo() + " tiene actividades planificadas anteriores.");
                    throw new MareException("", UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_CRA,"",
                        ErroresDeNegocio.VALIDAR_MODIFICAR_PERIODO));    
                }

                //si la ejecucion llego hasta aca, seteamos los atributos
                periodoLocal.setFechaFin(dtoEntrada.getFechaFin());
                periodoLocal.setFechainicio(dtoEntrada.getFechaInicio());
                periodoLocal.setNombrePeriodo(dtoEntrada.getNombre());
                periodoLocal.setPeriodoCorto(dtoEntrada.getPeriodoCorto());
                periodoLocal.setPeriodoCruce(dtoEntrada.getPeriodoCruce());
                UtilidadesLog.debug(" El periodo " + dtoEntrada.getCodigoPeriodo() + " fue modificado con exito.");
            }

            periodoLocalHome.merge(periodoLocal);

        } catch (NoResultException fe) {
            UtilidadesLog.debug(fe);
            sessionContext.setRollbackOnly();
            throw new MareException(fe, UtilidadesError.armarCodigoError( CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        } catch (PersistenceException pe) {
                UtilidadesLog.debug(pe);
                sessionContext.setRollbackOnly();
                throw new MareException(pe, UtilidadesError.armarCodigoError( CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        } catch(MareException me){
            UtilidadesLog.error(me);
            sessionContext.setRollbackOnly();
            throw me;
        } catch (Exception e) {
            sessionContext.setRollbackOnly();
            UtilidadesLog.error(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
        UtilidadesLog.info("MONPeriodosBean.actualizaPeriodo(DTOPeriodo dtoEntrada):Salida");
    }


    /**
     * Realiza una consulta SQL utilizando el servicio JDBCMare que se obtendrá a partir del MII. 
     * El sistema por cada período elegido accede a la tabla CRONOGRAMA con los siguientes datos: 
     * · Marca. 
     * · País. 
     * · Canal. 
     * · Período. 
     * Y se recuperan TODAS las actividades FIJAS (no referenciadas) existentes mayores que hoy. 
     * - Error en caso de que haya alguna con fecha de ejecución menor o igual que hoy: 01101000001 
     *
     * Se captura la excepcion SQLException. En caso de que se produzca, se crea una instancia 
     * de MareException con la excepción capturada y un código de error: 
     *
     * - Error de Lectura en Base de Datos: 01101000001 
     * - Error de Acceso en Base de Datos: 01101000001 
     * - Error peticion de datos no existente: 01101000001 
     * 
     **/
    public DTOSalida obtieneActividades(DTOID dtoEntrada) throws MareException {
        UtilidadesLog.info("MONPeriodosBean.obtieneActividades(DTOID dtoEntrada):Entrada");
        BelcorpService belcorpService;
        
        try{
            //Obtenemos las actividades fijas mayores que hoy                     
            belcorpService = BelcorpService.getInstance();

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String strFechaActual = sdf.format(new java.sql.Date(System.currentTimeMillis()));
            UtilidadesLog.debug("strFechaActual: " + strFechaActual);

            //armamos la consulta
            StringBuffer query = new StringBuffer("SELECT * FROM CRA_CRONO C, CRA_PERIO P ");
            query.append(" WHERE C.PERD_OID_PERI = P.OID_PERI AND ");
            query.append(" C.IND_FIJA = 1 AND");
            query.append(" C.FEC_INIC > TO_DATE(?,'YYYY-MM-DD') AND");
            query.append(" P.PAIS_OID_PAIS = ? AND");
            query.append(" P.MARC_OID_MARC = ? AND");
            query.append(" P.OID_PERI = ? AND");
            query.append(" P.CANA_OID_CANA = ? ");
            
            //armamos los parametros
            Vector parametros = new Vector();
            parametros.add(strFechaActual);
            parametros.add(dtoEntrada.getPais());
            parametros.add(dtoEntrada.getMarca());
            parametros.add(dtoEntrada.getOid());
            parametros.add(dtoEntrada.getCanal());
            
            //ejecutamos la consulta
            RecordSet recordSet = belcorpService.dbService.executePreparedQuery(
                                                            query.toString(),parametros);

            //si no hay resultados tiramos la excepcion
            if (recordSet.esVacio())
                throw new MareException("",
                        UtilidadesError.armarCodigoError(
                                CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));                        

            UtilidadesLog.info("MONPeriodosBean.obtieneActividades(DTOID dtoEntrada):Salida");
            return new DTOSalida(recordSet);
        } catch (MareMiiServiceNotFoundException serviceNotFoundException) {
            UtilidadesLog.error(serviceNotFoundException);
            throw new MareException(serviceNotFoundException,
                UtilidadesError.armarCodigoError(
                   CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        } catch (Exception exception) {
            UtilidadesLog.error(exception);
            throw new MareException(exception,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }        
    }


    /**
    * Obtiene los todos los periodos que cumplan los criterios de entrada (se concatenan 
    * los campos id y año para formar el id completo del periodo y realizar la búsqueda por ese campo) 
    * 
    * Realiza una consulta SQL filtrada por pais utilizando el servicio JDBCMare 
    * que se obtendrá a partir del MII. 
    * 
    * Devuelve un RecordSet construido a partir de la consulta. 
    * El RecordSet contiene: 
    * - Pais 
    * - Marca 
    * - Canal 
    * - Tipo de Periodo 
    * - Periodo 
    * - Nombre del Periodo 
    * - Fecha Inicio 
    * - Fecha Fin 
    * 
    * Se captura la excepcion SQLException. En caso de que se produzca, se crea una 
    * instancia de MareException con la excepción capturada y un código de error: 
    *
    * - Error de Lectura en Base de Datos: 01101000001 
    * - Error de Acceso en Base de Datos: 01101000001 
    * - Error peticion de datos no existente: 01101000001 
    * 
    * -VER INCIDENCIA 3460
    **/
     
    public DTOSalida obtienePeriodosConsulta(String id, String anio, String pais) throws MareException {
        UtilidadesLog.info("MONPeriodosBean.obtienePeriodosConsulta(String id, String anio, String pais):Entrada");
        BelcorpService belcorpService;
        
        try{
            //Obtenemos las actividades fijas mayores que hoy                     
            belcorpService = BelcorpService.getInstance();

            //armamos la consulta
            StringBuffer query = new StringBuffer(" SELECT P.OID_PERI, PC.COD_PERI, ");
            query.append(" MARC_OID_MARC, CANA_OID_CANA, PAIS_OID_PAIS, ACCE_OID_ACCE, ");
            query.append(" PERI_OID_PERI, FEC_INIC,	FEC_FINA, ");
            query.append(" decode(VAL_ESTA,1,'true','false') as VAL_ESTA, VAL_NOMB_PERI, ");
            query.append(" decode(IND_PERI_CORT,1,'true','false') as IND_PERI_CORT, decode(IND_PERI_CRUC,1,'true','false') as IND_PERI_CRUC ");
            query.append(" FROM CRA_PERIO P, SEG_PERIO_CORPO PC ");
            query.append(" WHERE COD_PERI = ? AND ");
            query.append(" PAIS_OID_PAIS = ? AND ");
            query.append(" P.PERI_OID_PERI = PC.OID_PERI ");
            
            //armamos los parametros
            Vector parametros = new Vector();
            parametros.add(anio + id);
            parametros.add(new Integer(pais));
            
            //ejecutamos la consulta
            RecordSet recordSet = belcorpService.dbService.executePreparedQuery(
                                                        query.toString(),parametros);
            
            UtilidadesLog.info("MONPeriodosBean.obtienePeriodosConsulta(String id, String anio, String pais):Salida");
            return new DTOSalida(recordSet);
        } catch (MareMiiServiceNotFoundException serviceNotFoundException) {
            UtilidadesLog.error(serviceNotFoundException);
            throw new MareException(serviceNotFoundException,
                UtilidadesError.armarCodigoError(
                   CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        } catch (Exception exception) {
            UtilidadesLog.error(exception);
            throw new MareException(exception,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }       
    }


    /**
     * Metodo que comprueba si la fecha pasada se encuentra dentro del periodo indicado. 
     * Devuelve true si la fecha está dentro del periodo, false si no.
     * 
     * -VER INCIDENCIA 3460
     * */

    public Boolean fechaEnPeriodo(java.sql.Date fecha, DTOPeriodo dto) throws MareException {
        BelcorpService belcorpService;
        UtilidadesLog.info("MONPeriodosBean.fechaEnPeriodo(java.sql.Date fecha, DTOPeriodo dto):Entrada");
        try {
            belcorpService = BelcorpService.getInstance();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String strFechaParam = sdf.format(fecha);
            UtilidadesLog.debug("strFechaParam: " + strFechaParam);

            //armamos la consulta
            StringBuffer query = new StringBuffer(" SELECT P.OID_PERI, PC.COD_PERI, ");
            query.append(" MARC_OID_MARC, CANA_OID_CANA, PAIS_OID_PAIS, ACCE_OID_ACCE, ");
            query.append(" PERI_OID_PERI, FEC_INIC,	FEC_FINA, ");
            query.append(" decode(VAL_ESTA,1,'true','false') as VAL_ESTA, VAL_NOMB_PERI ");
            query.append(" FROM CRA_PERIO P, SEG_PERIO_CORPO PC ");
            query.append(" WHERE ( TO_DATE(?,'YYYY-MM-DD') BETWEEN FEC_INIC AND FEC_FINA ) AND ");
            query.append(" PAIS_OID_PAIS = ? AND ");
            query.append(" CANA_OID_CANA = ? AND ");
            query.append(" MARC_OID_MARC = ? AND ");            
            query.append(" PC.COD_PERI = ? AND ");        
            query.append(" P.PERI_OID_PERI = PC.OID_PERI ");

            //armamos el vector de parametros
            Vector parametros = new Vector();
            parametros.add(strFechaParam);
            parametros.add(dto.getPais());
            parametros.add(dto.getCanal());
            parametros.add(dto.getMarca());
            parametros.add(dto.getCodigoPeriodo());

            //ejecutamos la consulta y devolvemos si es vacio o no
            UtilidadesLog.info("MONPeriodosBean.fechaEnPeriodo(java.sql.Date fecha, DTOPeriodo dto):Salida");
            return new Boolean(!(belcorpService.dbService.executePreparedQuery(
                                        query.toString(),parametros)).esVacio());
            
        } catch (MareMiiServiceNotFoundException serviceNotFoundException) {
            UtilidadesLog.error(serviceNotFoundException);
            sessionContext.setRollbackOnly();
            throw new MareException(serviceNotFoundException,
                UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }catch (Exception exception){
            UtilidadesLog.error(exception);
            sessionContext.setRollbackOnly();
            throw new MareException(exception,
                UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }
    }


    /**
     * Modifica todos los periodos recibidos en la Collection
     */
    public void actualizaPeriodos(java.util.Collection collPeriodos) throws MareException {
        //iteramos la collection insertando los periodos
        UtilidadesLog.info("MONPeriodosBean.actualizaPeriodos(java.util.Collection collPeriodos):Entrada");
        Iterator iterPeriodos = collPeriodos.iterator();

        while (iterPeriodos.hasNext())
                this.actualizaPeriodo((DTOPeriodo)iterPeriodos.next());
        
        UtilidadesLog.info("MONPeriodosBean.actualizaPeriodos(java.util.Collection collPeriodos):Salida");
    }


    /**
     * Obtiene el periodo actual, 
     * entendiendo por periodo actual aquel cuya fecha de inicio es menoro igual que la fecha actual
     * y la fecha final es mayor o igual que la fecha actual.
     * Se ordena descendentemente por fecha inicio y coge el primero. 
     * Lo obtendrá para el país, la marca y el canal dados. 
     * Si la consulta devuelve un periodo, se instanciará un objeto DTOPeriodo y se devolverá.
    */
    public DTOPeriodo obtienePeriodoActual(Long pais, Long marca, Long canal) throws  MareException {
        UtilidadesLog.info("MONPeriodosBean.obtienePeriodoActual(Long pais, Long marca, Long canal):Entrada");
        BelcorpService belcorpService;
        ExcepcionParametrizada exParam;
        try {
        
            belcorpService = BelcorpService.getInstance();
            
            SimpleDateFormat formatter = new SimpleDateFormat ("dd-MM-yyyy");
            Timestamp date = new Timestamp(System.currentTimeMillis());

            //hacemos la consulta usando JDBC
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(" select P.OID_PERI, COD_PERI, MARC_OID_MARC, CANA_OID_CANA, ");
            stringBuffer.append(" PAIS_OID_PAIS, ACCE_OID_ACCE, PERI_OID_PERI, FEC_INIC, ");
            stringBuffer.append(" FEC_FINA, decode(VAL_ESTA,1,'true','false') as VAL_ESTA, VAL_NOMB_PERI, ");
            stringBuffer.append(" decode(IND_PERI_CORT,1,'true','false') as IND_PERI_CORT, decode(IND_PERI_CRUC,1,'true','false') as IND_PERI_CRUC ");
            stringBuffer.append(" FROM CRA_PERIO P, SEG_PERIO_CORPO PC ");
            stringBuffer.append(" where FEC_INIC <= to_date('" + formatter.format(date) + "', 'DD-MM-YYYY') and to_date('" + formatter.format(date) + "', 'DD-MM-YYYY') <= FEC_FINA and ");
            stringBuffer.append(" PAIS_OID_PAIS = ? and ");
            //Si el oid de la marca es 0, metadato todos, entonces se omite el filtro de marca
            if (marca.longValue() != 0) stringBuffer.append(" MARC_OID_MARC = ? and ");
            stringBuffer.append(" CANA_OID_CANA = ? and ");
            stringBuffer.append(" P.PERI_OID_PERI = PC.OID_PERI ");
            //ordena descendentemente por fecha inicio
            stringBuffer.append(" ORDER BY FEC_INIC DESC ");
            
            //armamos el vector de parametros
            Vector parametros = new Vector();
            parametros.add(pais);
            //Si el oid de la marca es 0, metadato todos, entonces se omite el filtro de marca
            if (marca.longValue() != 0) parametros.add(marca);
            parametros.add(canal);

            RecordSet recordSet = belcorpService.dbService.executePreparedQuery(stringBuffer.toString(), parametros);

            DTOPeriodo dtoPeriodo = new DTOPeriodo();
            if ( ! recordSet.esVacio()) {
                
                dtoPeriodo.setOid( new Long(((BigDecimal)recordSet.getValueAt(0,"OID_PERI")).longValue()));
                dtoPeriodo.setCodigoPeriodo( (String) recordSet.getValueAt(0,"COD_PERI"));
                dtoPeriodo.setMarca( new Long(((BigDecimal)recordSet.getValueAt(0,"MARC_OID_MARC")).longValue()));
                dtoPeriodo.setCanal( new Long(((BigDecimal)recordSet.getValueAt(0,"CANA_OID_CANA")).longValue()));
                dtoPeriodo.setPais( new Long(((BigDecimal)recordSet.getValueAt(0,"PAIS_OID_PAIS")).longValue()));
                if (((BigDecimal)recordSet.getValueAt(0,"ACCE_OID_ACCE")) != null)
                    dtoPeriodo.setAcceso( new Long(((BigDecimal)recordSet.getValueAt(0,"ACCE_OID_ACCE")).longValue()));
                dtoPeriodo.setOidPeriodoCorporativo( new Long(((BigDecimal)recordSet.getValueAt(0,"PERI_OID_PERI")).longValue()));
                dtoPeriodo.setFechaInicio((Date) recordSet.getValueAt(0,"FEC_INIC"));
                dtoPeriodo.setFechaFin( (Date) recordSet.getValueAt(0,"FEC_FINA"));
                if (recordSet.getValueAt(0,"VAL_ESTA").toString().equalsIgnoreCase("true")) {
                    dtoPeriodo.setStatus(Boolean.TRUE);
                } else {
                    dtoPeriodo.setStatus(Boolean.FALSE);
                }
                dtoPeriodo.setNombre( (String) recordSet.getValueAt(0,"VAL_NOMB_PERI"));
                //dtoPeriodo.setTipo(); de ser necesario hacer el join para obtener el tipo de periodo
                dtoPeriodo.setPeriodoCorto( new Boolean( (String)recordSet.getValueAt(0,"IND_PERI_CORT") ) );
                dtoPeriodo.setPeriodoCruce( new Boolean( (String)recordSet.getValueAt(0,"IND_PERI_CRUC") ) );
            } else {

              //como no se obtuvieron registros se muestra el mensaje
              //Actualmente no existe un periodo definido para la marca "{0}" y el canal "{1}"
              //Obtener las descripciones de Marca y Canal
              String queryMarca = "SELECT DES_MARC FROM SEG_MARCA WHERE OID_MARC = ?";
              String queryCanal = "SELECT VAL_I18N FROM GEN_I18N_SICC WHERE ATTR_ENTI = 'SEG_CANAL' AND VAL_OID = ?";

              Vector paramMarca = new Vector();
              Vector paramCanal = new Vector();

              paramMarca.add( marca );
              paramCanal.add( canal );
              
              RecordSet rsMarca = belcorpService.dbService.executePreparedQuery(queryMarca, paramMarca);
              RecordSet rsCanal = belcorpService.dbService.executePreparedQuery(queryCanal, paramCanal);
              
              String descMarca = "";
              String descCanal = "";

              if( rsMarca != null && !rsMarca.esVacio() ){
                descMarca = (String)rsMarca.getValueAt( 0, "DES_MARC" );
              }
              if( rsCanal != null && !rsCanal.esVacio() ){
                descCanal = (String)rsCanal.getValueAt( 0, "VAL_I18N" );
              }

              //excepcion parametrizada 180240004
              exParam = new ExcepcionParametrizada(new MareException(),   
                                                    UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_CRA,"",
                                                        ErroresDeNegocio.NO_EXISTE_PERIODO_PARA_MARCA_CANAL_INDICADOS));
              exParam.setPosicion(ExcepcionParametrizada.POSICION_MEDIO);
              exParam.addParameter( descMarca );
              exParam.addParameter( descCanal );
              throw exParam;
            }
            UtilidadesLog.info("MONPeriodosBean.obtienePeriodoActual(Long pais, Long marca, Long canal):Salida");
            return dtoPeriodo;
            
        } catch (MareMiiServiceNotFoundException serviceNotFoundException) {
            UtilidadesLog.error(serviceNotFoundException);
            throw new MareException(serviceNotFoundException,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        } catch (MareException me) {
            UtilidadesLog.error(me);
            throw me;
        } catch (Exception exception) {
            UtilidadesLog.error(exception);
            throw new MareException(exception,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
    }



    /**
     * Obtiene los periodos posteriores a una fecha, para un pais, marca y canal.
     */
    public Collection obtienePeriodosPosteriores(DTOPeriodo dtoEntrada) throws MareException {
        UtilidadesLog.info("MONPeriodosBean.obtienePeriodosPosteriores(DTOPeriodo dtoEntrada):Entrada");
        BelcorpService belcorpService;

        try {
            belcorpService = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException serviceNotFoundException) {
            UtilidadesLog.error(serviceNotFoundException);
            throw new MareException(serviceNotFoundException,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        try {

            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(" SELECT P.OID_PERI, PC.COD_PERI, VAL_NOMB_PERI, FEC_INIC, FEC_FINA, (FEC_FINA - FEC_INIC + 1) AS DURA, "); 
            stringBuffer.append(" decode(IND_PERI_CORT,1,'true','false') as IND_PERI_CORT, decode(IND_PERI_CRUC,1,'true','false') as IND_PERI_CRUC ");
            stringBuffer.append(" FROM CRA_PERIO P, SEG_PERIO_CORPO PC ");
            stringBuffer.append(" WHERE FEC_INIC > TO_DATE(?,'YYYY-MM-DD') AND ");
            stringBuffer.append(" PAIS_OID_PAIS = ? AND ");
            stringBuffer.append(" MARC_OID_MARC = ? AND ");
            stringBuffer.append(" CANA_OID_CANA = ? AND ");
            stringBuffer.append(" P.PERI_OID_PERI = PC.OID_PERI ");
            stringBuffer.append(" ORDER BY PC.COD_PERI ");

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String strFecha = sdf.format(dtoEntrada.getFechaInicio());
            UtilidadesLog.debug("strFecha: " + strFecha);
            Vector vector = new Vector();
            vector.add(strFecha);
            vector.add(dtoEntrada.getPais());
            vector.add(dtoEntrada.getMarca());
            vector.add(dtoEntrada.getCanal());

            RecordSet recordSet = belcorpService.dbService.executePreparedQuery(stringBuffer.toString(),
                    vector);

            //Pasamos el resultSet a una Collection
            Collection periodos = new ArrayList();
            for (int pos = 0; pos < recordSet.getRowCount(); pos++) {
                DTOPeriodo periodo = new DTOPeriodo();                
                periodo.setOid(new Long(((BigDecimal)recordSet.getValueAt(pos,"OID_PERI")).longValue())) ;
                periodo.setPais(dtoEntrada.getPais());
                periodo.setMarca(dtoEntrada.getMarca());
                periodo.setCanal(dtoEntrada.getCanal());
                periodo.setCodigoPeriodo((String)recordSet.getValueAt(pos,"COD_PERI"));
                periodo.setNombre((String)recordSet.getValueAt(pos,"VAL_NOMB_PERI"));
                periodo.setFechaInicio((Date)recordSet.getValueAt(pos,"FEC_INIC"));
                periodo.setFechaFin((Date)recordSet.getValueAt(pos,"FEC_FINA"));
                periodo.setDuracion(new Integer(((BigDecimal)recordSet.getValueAt(pos,"DURA")).intValue()));
                periodo.setPeriodoCorto( new Boolean( (String)recordSet.getValueAt(pos,"IND_PERI_CORT") ) );
                periodo.setPeriodoCruce( new Boolean( (String)recordSet.getValueAt(pos,"IND_PERI_CRUC") ) );
                periodo.setIpCliente(dtoEntrada.getIpCliente());
                periodo.setPrograma(dtoEntrada.getPrograma());
                //agrego el periodo a la coleccion
                periodos.add(periodo);
                UtilidadesLog.debug("Periodo: " + periodo);
            }
            UtilidadesLog.info("MONPeriodosBean.obtienePeriodosPosteriores(DTOPeriodo dtoEntrada):Salida");
            return periodos;
        } catch (Exception exception) {
            UtilidadesLog.error(exception);
            throw new MareException(exception,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
    }


    /**
     * Obtiene los periodos corporativos asociandole las fechas de inicio y fin correspondientes.
     * Utiliza los periodos corporativos segun el canal y el anio.
     * Utiliza el ultimo periodo del año anterior para partir desde ahi con las fechas de inicio y fin.
     * Realiza el calculo para obtener los periodos corporativos con sus fechas y demas informacion.
     * @author gdmarzi
     */
    public DTOSalida obtienePeriodosCalculados(DTOAsociadosAPeriodo asociadosAPeriodo) throws MareException {
        UtilidadesLog.info("MONPeriodosBean.obtienePeriodosCalculados(DTOAsociadosAPeriodo asociadosAPeriodo):Entrada");
        Integer numPeriodosAnio, anioAnterior;
        DTOSalida dtoSalidaPeriCorpo, dtoSalidaUltimoPeriodo;
        RecordSet rsUltimoPeriodo, rsPeriodosCorpo, rsPeriodos;
        String oidPeriCorpo, tipoPeriodo, codigoPeriodo, nombrePeriodo, duracion, oidTipoPeriodo;
        Date fechaInicio, fechaFin, fechaDesde;
        String periodoCorto, periodoCruce;

        /*
         * 1.- Recupera el número de periodos por año, segun el tipo de periodo, asociado al canal.
         */
        numPeriodosAnio = this.obtieneNumeroPeriodosTipoPeriodo(asociadosAPeriodo.getCanal()); 

        /*
         * 2.- Obtiene los Periodos Corporativos de SEG filtrando por anio y ordenando por su código de periodo.
         * Obtengo un recordSet con: oidPeriodo, codigoTipoPeriodo, codigoPeriodo, nombrePeriodo, numeroDias.
         */
        dtoSalidaPeriCorpo = this.obtieneDatosPeriodosCorporativos(asociadosAPeriodo);
        rsPeriodosCorpo = dtoSalidaPeriCorpo.getResultado();

        /*
         * 3.- Verifica que la cantidad de periodos coporativos obtenidos es igual que el valor numPeriodosAnio. 
         */
        if (numPeriodosAnio.intValue() != dtoSalidaPeriCorpo.getResultado().getRowCount()) {
            //Si no es cierto lanza una excepción CRA-0005 
            throw new MareException(new Exception(), UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_CRA,"",
               ErroresDeNegocio.PERIODOS_CORPORATIVOS_MAL_GENERADOS));    
        }

        /*
         * 4.- Recupera el último periodo del año anterior a dtoAsociados.anio 
         * Obtengo un recordSet de UN SÓLO registro con la siguiente columna entre otras: FEC_FINA
         */
        anioAnterior = new Integer(asociadosAPeriodo.getAnio().intValue()-1);
        asociadosAPeriodo.setAnio(anioAnterior);
        dtoSalidaUltimoPeriodo = this.obtienePeriodo(asociadosAPeriodo);
        rsUltimoPeriodo = dtoSalidaUltimoPeriodo.getResultado();

        /* 
         * 5.- Se realiza el cálculo, construyendo fecha inicio y fecha fin. 
         * Se va generando el RecordSet rsPeriodos que será devuelto. 
         */
        rsPeriodos = new RecordSet();
        rsPeriodos.addColumn("OID");    
        rsPeriodos.addColumn("COD_TIPO_PERI");
        rsPeriodos.addColumn("COD_PERI");
        rsPeriodos.addColumn("NOMB_PERI");
        rsPeriodos.addColumn("NUM_DIAS");
        rsPeriodos.addColumn("FEC_INIC");
        rsPeriodos.addColumn("FEC_FINA");
        rsPeriodos.addColumn("OID_TIPO_PERI");
        rsPeriodos.addColumn("IND_PERI_CORT");
        rsPeriodos.addColumn("IND_PERI_CRUC");
        //obtengo fecha desde donde empezar el proximo periodo
        if ( rsUltimoPeriodo.getColumnCount() == 1 ) {
            //tomamos el primer dia del año, por no existir un periodo en el año anterior
            fechaDesde = (Date) rsUltimoPeriodo.getValueAt(0,"FEC_FINA");
        } else {
            //tomamos la fecha del ultimo periodo del año y le agregamos un dia
            fechaDesde = (Date) rsUltimoPeriodo.getValueAt(0,"FEC_FINA");
            fechaDesde = addDaysToDate(fechaDesde,1);
        }
        //Calculamos las fecha para los periodos de manera consecutiva
        for (int i=0; i < rsPeriodosCorpo.getRowCount(); i++) {
            oidPeriCorpo = rsPeriodosCorpo.getValueAt(i,"OID").toString();
            tipoPeriodo = rsPeriodosCorpo.getValueAt(i,"COD_TIPO_PERI").toString();
            codigoPeriodo = rsPeriodosCorpo.getValueAt(i,"COD_PERI").toString();
            nombrePeriodo = rsPeriodosCorpo.getValueAt(i,"NOMB_PERI").toString();
            duracion = rsPeriodosCorpo.getValueAt(i,"NUM_DIAS").toString();
            oidTipoPeriodo = rsPeriodosCorpo.getValueAt(i,"OID_TIPO_PERI").toString();
            periodoCorto = "false";
            periodoCruce = "false";
            //fechaInicio es fechaDesde
            fechaInicio = fechaDesde;
            //fechaFin es fechaInicio mas duracion menos 1.
            fechaFin = addDaysToDate(fechaInicio, Integer.valueOf(duracion).intValue() - 1 );
            //fechaDesde es fechaFin mas un dia
            fechaDesde = addDaysToDate(fechaFin, 1);
            //agregamos la row al recordset            
            rsPeriodos.addRow( new Object[] { oidPeriCorpo, tipoPeriodo, codigoPeriodo, nombrePeriodo,
                                                duracion, fechaInicio, fechaFin, oidTipoPeriodo, periodoCorto, periodoCruce } );
        }
        UtilidadesLog.debug("Periodos Corporativos: " + rsPeriodos );

        /*
         * 6.- Se devuelve rsPeriodos encapsulado en un DTOSalida
         */
        UtilidadesLog.info("MONPeriodosBean.obtienePeriodosCalculados(DTOAsociadosAPeriodo asociadosAPeriodo):Salida");
        return new DTOSalida(rsPeriodos);
    }


    /**
     * Recupera el número de periodos por año segun el tipo de Periodo.
     * Lo obtiene de (numPeriodosAnio) de TiposPeriodo de SEG del tipo de periodo asociado al canal. 
     */
    private Integer obtieneNumeroPeriodosTipoPeriodo(Long canal) throws MareException {
        UtilidadesLog.info("MONPeriodosBean.obtieneNumeroPeriodosTipoPeriodo(Long canal):Entrada");
        Integer numPeriodosAnio;
        BelcorpService belcorpService;
        RecordSet recordSet;
        
        try {
            belcorpService = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException serviceNotFoundException) {
            UtilidadesLog.error(serviceNotFoundException);
            throw new MareException(serviceNotFoundException,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        try {
            StringBuffer query = new StringBuffer();
            query.append(" SELECT seg_tipo_perio.num_peri_anio ");
            query.append(" FROM  seg_canal, seg_tipo_perio ");
            query.append(" WHERE seg_tipo_perio.oid_tipo_peri = seg_canal.tipe_oid_tipo_peri ");
            query.append(" AND seg_canal.oid_cana = " + canal );

            recordSet = belcorpService.dbService.executeStaticQuery(query.toString());
        } catch (Exception exception) {
            UtilidadesLog.error(exception);
            throw new MareException(exception,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        //Retorna valor num_peri_anio, si no hay ningún registro retorna 0.
        if (recordSet.esVacio()) {
            numPeriodosAnio = new Integer(0);
        } else {
            numPeriodosAnio = new Integer(((BigDecimal)recordSet.getValueAt(0,"num_peri_anio")).toString());
        }
        UtilidadesLog.info("MONPeriodosBean.obtieneNumeroPeriodosTipoPeriodo(Long canal):Salida");
        return numPeriodosAnio;
    }


    /**
     * Obtiene los periodos segun los filtros del dtoPeriodo.
     * Sin paginado, para carga de comnbos.
     */
    public DTOSalida obtienePeriodos(DTOPeriodo dtoPeriodo) throws MareException {
        DAOCRA dao  = new DAOCRA();
        return dao.obtienePeriodo(dtoPeriodo);
    }

  public DTOSalida obtienePeriodosFecha(DTOPeriodo dto) throws MareException {
      DAOCRA dao = new DAOCRA();
      return dao.obtienePeriodosFecha(dto);
  }

  public DTOPeriodo obtienePeriodosPMCCodigo(DTOPeriodo dto) throws MareException {
      UtilidadesLog.info("MONPeriodosBean.obtienePeriodosPMCCodigo(DTOPeriodo dto):Entrada");
      DAOCRA dao = new DAOCRA();
      DTOSalida dtoSal = dao.obtienePeriodoPMCCodigo(dto);
      RecordSet rs = dtoSal.getResultado();
      DTOPeriodo dtoPeriodo = new DTOPeriodo();
      if (!rs.esVacio()) {
          dtoPeriodo.setMarca(new Long(((BigDecimal) rs.getValueAt(0,"MARCA")).toString()));
          dtoPeriodo.setOid(new Long(((BigDecimal) rs.getValueAt(0,"OID")).toString()));
          dtoPeriodo.setCodigoPeriodo(dto.getCodigoPeriodo());
          dtoPeriodo.setPais(new Long(((BigDecimal) rs.getValueAt(0,"PAIS")).toString()));
          dtoPeriodo.setCanal(new Long(((BigDecimal) rs.getValueAt(0,"CANAL")).toString()));
          if (rs.getValueAt(0,"ACCESO") != null)
              dtoPeriodo.setAcceso(new Long(((BigDecimal) rs.getValueAt(0,"ACCESO")).toString()));
          dtoPeriodo.setNombre((String) rs.getValueAt(0,"NOMBRE"));
          dtoPeriodo.setFechaInicio((Date) rs.getValueAt(0,"FECHAINI"));
          dtoPeriodo.setFechaFin((Date) rs.getValueAt(0,"FECHAFIN"));
          if (((BigDecimal) rs.getValueAt(0,"ESTADO")).toString().equals("1"))
              dtoPeriodo.setStatus(Boolean.TRUE);
          else
              dtoPeriodo.setStatus(Boolean.FALSE);
          if (rs.getValueAt(0,"ESCORTO") != null) {
              if (((BigDecimal) rs.getValueAt(0,"ESCORTO")).toString().equals("1"))
                  dtoPeriodo.setPeriodoCorto(Boolean.TRUE);
              else
                  dtoPeriodo.setPeriodoCorto(Boolean.FALSE);
          }
          if (rs.getValueAt(0,"ESCRUCE") != null) {
              if (((BigDecimal) rs.getValueAt(0,"ESCRUCE")).toString().equals("1"))
                  dtoPeriodo.setPeriodoCruce(Boolean.TRUE);
              else
                  dtoPeriodo.setPeriodoCruce(Boolean.FALSE);
          }
          dtoPeriodo.setOidPeriodoCorporativo(new Long(((BigDecimal) rs.getValueAt(0,"PERIODOCORPORATIVO")).toString()));
          
      }
    UtilidadesLog.info("MONPeriodosBean.obtienePeriodosPMCCodigo(DTOPeriodo dto):Salida");
    return dtoPeriodo;
  }

  public DTOOIDs obtienePeriodosEntre(Long oidPeriodoIni, Long oidPeriodoFin) throws MareException {
        UtilidadesLog.info("MONPeriodosBean.obtienePeriodosEntre(Long oidPeriodoIni, Long oidPeriodoFin):Entrada");

        BelcorpService belcorpService;
        RecordSet recordSet;
        DTOOIDs oids = new DTOOIDs();

        if (oidPeriodoIni == null || oidPeriodoFin == null) {
          UtilidadesLog.info("MONPeriodosBean.obtienePeriodosEntre(Long oidPeriodoIni, Long oidPeriodoFin):Salida");
          return oids;
        }

        try {
            belcorpService = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException serviceNotFoundException) {
            UtilidadesLog.error(serviceNotFoundException);
            throw new MareException(serviceNotFoundException,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        try {
            StringBuffer query = new StringBuffer();
            query.append("Select peri.oid_peri as oid ");
            query.append("from CRA_PERIO peri,   ");
            query.append("(SELECT PAIS_OID_PAIS pais, MARC_OID_MARC marca, CANA_OID_CANA canal ");
            query.append(" FROM CRA_PERIO WHERE OID_PERI = "+  oidPeriodoIni  +" ) X  ");
            query.append("where peri.FEC_INIC >= (Select FEC_INIC from CRA_PERIO where oid_peri = '" + oidPeriodoIni + "') and ");
            query.append("peri.FEC_FINA <= (Select FEC_FINA from CRA_PERIO where oid_peri = '" + oidPeriodoFin + "')  ");
            query.append(" AND PAIS_OID_PAIS = X.pais AND MARC_OID_MARC = X.marca AND CANA_OID_CANA = X.canal ");

            recordSet = belcorpService.dbService.executeStaticQuery(query.toString());
        } catch (Exception exception) {
            UtilidadesLog.error(exception);
            throw new MareException(exception,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        if (recordSet.getRowCount() > 0) {
          Vector row = null;
          Long oid = null;
          Long lvect[] = new Long[recordSet.getRowCount()];           
          for (int i = 0; i < recordSet.getRowCount(); i++) {
            row = recordSet.getRow(i);
            oid = new Long(((BigDecimal) row.get(0)).toString());
            lvect[i] = oid;
          } 
        oids.setOids(lvect);  
        }  
    UtilidadesLog.info("MONPeriodosBean.obtienePeriodosEntre(Long oidPeriodoIni, Long oidPeriodoFin):Salida");
    return oids;
  }
  
  /* Metodo: dayDiff
   * Autor: Cristian Valenzuela
   * Fecha: 17/1/2005
   * Descripcion: Este metodo se cambio a publico debido a la incidencia BELC300012204 
   */

  public Integer dayDiff(Date fecha1, Date fecha2) throws MareException {
    //la cantidad de milisegundos en un dia
    long oneDayMillis = 1000*60*60*24;

    //pasamos el resultado a dias
    int dayDifference = (int)((fecha1.getTime() - fecha2.getTime())/oneDayMillis);
    return new Integer(dayDifference);  
  }

  public DTOSalida obtienePeriodosAnioAcceso(DTOPeriodo dto) throws MareException{
    DAOCRA dao  = new DAOCRA();
    return dao.obtienePeriodoAnioAcceso(dto);
    
  }

  /**
   * Marta Aurora Montiel
   * 22/03/05
   * Incidencia BELC300015141
   * */
  public DTOSalida obtenerListaPeriodosPosteriores(DTOPeriodo dto) throws MareException{
    DAOCRA dao  = new DAOCRA();
    return dao.obtienePeriodosPosteriores(dto.getPais(), dto.getMarca(), dto.getCanal());
  }

  public DTOSalida obtienePeriodosPosterioresFechaActual(DTOID dto) throws MareException {
    UtilidadesLog.info("MONPeriodosBean.obtienePeriodosPosterioresFechaActual(DTOID dto):Entrada");
    DAOCRA dao  = new DAOCRA();
    DTOSalida dtoSalida;
    dtoSalida = dao.obtienePeriodosPosterioresFechaActual(dto);
    UtilidadesLog.info("MONPeriodosBean.obtienePeriodosPosterioresFechaActual(DTOID dto):Salida");
    return dtoSalida;
  }

  public DTOPeriodo obtienePrimerPeriodoFecha(Long pais, Long marca, Long canal, Date fecha) throws MareException {
        UtilidadesLog.info("MONPeriodosBean.obtienePrimerPeriodoFecha(Long pais, Long marca, Long canal, Date fecha):Entrada");
        UtilidadesLog.debug(" -----P:"+pais+"M:"+marca+"C:"+canal+"F:"+fecha);
        BelcorpService belcorpService;
        RecordSet recordSet = null;
        try {
        
            belcorpService = BelcorpService.getInstance();
            
            SimpleDateFormat formatter = new SimpleDateFormat ("dd-MM-yyyy");            

            //hacemos la consulta usando JDBC
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(" select P.OID_PERI, COD_PERI, MARC_OID_MARC, CANA_OID_CANA, ");
            stringBuffer.append(" PAIS_OID_PAIS, ACCE_OID_ACCE, PERI_OID_PERI, FEC_INIC, ");
            stringBuffer.append(" FEC_FINA, decode(VAL_ESTA,1,'true','false') as VAL_ESTA, VAL_NOMB_PERI, ");
            stringBuffer.append(" decode(IND_PERI_CORT,1,'true','false') as IND_PERI_CORT, decode(IND_PERI_CRUC,1,'true','false') as IND_PERI_CRUC ");
            stringBuffer.append(" FROM CRA_PERIO P, SEG_PERIO_CORPO PC ");
            stringBuffer.append(" where FEC_INIC <= to_date('" + formatter.format(fecha) + "', 'DD-MM-YYYY') and to_date('" + formatter.format(fecha) + "', 'DD-MM-YYYY') <= FEC_FINA and ");
            stringBuffer.append(" PAIS_OID_PAIS = ? and ");
            //Si el oid de la marca es 0, metadato todos, entonces se omite el filtro de marca
            if (marca.longValue() != 0) stringBuffer.append(" MARC_OID_MARC = ? and ");
            stringBuffer.append(" CANA_OID_CANA = ? and ");
            stringBuffer.append(" P.PERI_OID_PERI = PC.OID_PERI AND");
            stringBuffer.append(" P.VAL_ESTA = 1 ");//PERIODO ACTIVO
            //ordena descendentemente por fecha inicio
            stringBuffer.append(" ORDER BY FEC_INIC DESC ");
            
            //armamos el vector de parametros
            Vector parametros = new Vector();
            parametros.add(pais);
            //Si el oid de la marca es 0, metadato todos, entonces se omite el filtro de marca
            if (marca.longValue() != 0) parametros.add(marca);
            parametros.add(canal);
            
            try{
              recordSet = belcorpService.dbService.executePreparedQuery(stringBuffer.toString(), parametros);
            } catch (Exception exception) {
                UtilidadesLog.error(exception);
                throw new MareException(exception, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
            }
            
            DTOPeriodo dtoPeriodo = null;
            if (!recordSet.esVacio()) {
                dtoPeriodo = new DTOPeriodo();
                UtilidadesLog.debug("RecordSet: " + recordSet.toString() );
                dtoPeriodo.setOid( new Long(((BigDecimal)recordSet.getValueAt(0,"OID_PERI")).longValue()));
                dtoPeriodo.setCodigoPeriodo( (String) recordSet.getValueAt(0,"COD_PERI"));
                dtoPeriodo.setMarca( new Long(((BigDecimal)recordSet.getValueAt(0,"MARC_OID_MARC")).longValue()));
                dtoPeriodo.setCanal( new Long(((BigDecimal)recordSet.getValueAt(0,"CANA_OID_CANA")).longValue()));
                dtoPeriodo.setPais( new Long(((BigDecimal)recordSet.getValueAt(0,"PAIS_OID_PAIS")).longValue()));
                if (((BigDecimal)recordSet.getValueAt(0,"ACCE_OID_ACCE")) != null)
                    dtoPeriodo.setAcceso( new Long(((BigDecimal)recordSet.getValueAt(0,"ACCE_OID_ACCE")).longValue()));
                dtoPeriodo.setOidPeriodoCorporativo( new Long(((BigDecimal)recordSet.getValueAt(0,"PERI_OID_PERI")).longValue()));
                dtoPeriodo.setFechaInicio((Date) recordSet.getValueAt(0,"FEC_INIC"));
                dtoPeriodo.setFechaFin( (Date) recordSet.getValueAt(0,"FEC_FINA"));
                if (recordSet.getValueAt(0,"VAL_ESTA").toString().equalsIgnoreCase("true")) {
                    dtoPeriodo.setStatus(Boolean.TRUE);
                } else {
                    dtoPeriodo.setStatus(Boolean.FALSE);
                }
                dtoPeriodo.setNombre( (String) recordSet.getValueAt(0,"VAL_NOMB_PERI"));                
                dtoPeriodo.setPeriodoCorto( new Boolean( (String)recordSet.getValueAt(0,"IND_PERI_CORT") ) );
                dtoPeriodo.setPeriodoCruce( new Boolean( (String)recordSet.getValueAt(0,"IND_PERI_CRUC") ) );
            }
            UtilidadesLog.info("MONPeriodosBean.obtienePrimerPeriodoFecha(Long pais, Long marca, Long canal, Date fecha):Salida");
            return dtoPeriodo;
        } catch (MareMiiServiceNotFoundException serviceNotFoundException) {
            UtilidadesLog.error(serviceNotFoundException);
            throw new MareException(serviceNotFoundException, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        } catch (MareException me) {
            UtilidadesLog.error(me);
            throw me;
        }
        
  }

    public DTOOID obtenerPrimerPeriodoREP(DTOBelcorp dto) throws MareException{
      DAOCRA dao  = new DAOCRA();
      DTOOID oid = new DTOOID();
      oid.setOid(dao.obtenerPrimerPeriodoREP(dto));
      return oid;
    }

   public DTOBoolean validaPeriodosREP(DTOOIDs dto) throws MareException {
      DAOCRA dao  = new DAOCRA();
      return dao.validaPeriodosREP(dto);
    }
   
   /**    
     *@Autor: cvalenzu
     *@Fecha: 02/05/2006
     *@throws: MareException
     *@return: DTOSalida
     *@param: DTOPeriodo
    */ 
  public DTOSalida obtenerPeriodosPosterioresActual(DTOPeriodo dtoPeriodo) 
    throws MareException {       
    UtilidadesLog.info("MONPeriodosBean.obtenerPeriodosPosterioresActual(DTOPeriodo dtoPeriodo):Entrada");
    DAOCRA dao = new DAOCRA();
    DTOSalida dtoSalida;
    dtoSalida = dao.obtenerPeriodosPosterioresActual(dtoPeriodo);
    UtilidadesLog.info("MONPeriodosBean.obtenerPeriodosPosterioresActual(DTOPeriodo dtoPeriodo):Salida");
    return dtoSalida;   
  }

  /**    
     *@Autor: cvalenzu
     *@Fecha: 02/05/2006
     *@throws: MareException
     *@return: DTOSalida
     *@param: DTOPeriodo
    */ 
  public DTOSalida obtenerPeriodosPosterioresActivos(DTOPeriodo dtoPeriodo) 
    throws MareException {
    UtilidadesLog.info("MONPeriodosBean.obtenerPeriodosPosterioresActivos(DTOPeriodo dtoPeriodo):Entrada");
    DAOCRA dao = new DAOCRA();
    DTOSalida dtoSalida;
    dtoSalida = dao.obtenerPeriodosPosterioresActivos(dtoPeriodo);
    UtilidadesLog.info("MONPeriodosBean.obtenerPeriodosPosterioresActivos(DTOPeriodo dtoPeriodo):Salida");
    return dtoSalida;      
  }
  
   /**    
     *@Autor: cvalenzu
     *@Fecha: 23/05/2006
     *@throws: MareException
     *@return: DTOSalida
     *@param: DTOOIDs
    */ 
  public DTOSalida obtenerPeriodosEntre(DTOOIDs dtoe) throws MareException {
    UtilidadesLog.info("MONPeriodosBean.obtenerPeriodosEntre(DTOOIDs dtoe):Entrada");    
    DAOCRA dao = new DAOCRA();
    DTOSalida dtoSalida;
    dtoSalida = dao.obtenerPeriodosEntre(dtoe);       
    UtilidadesLog.info("MONPeriodosBean.obtenerPeriodosEntre(DTOOIDs dtoe):Salida");
    return dtoSalida;
  }
  
  /**    
     *@Autor: mdolce
     *@Fecha: 14/06/2006
     *@throws: MareException
     *@return: DTOSalida
     *@param: DTOPeriodo
     * Este metodo fue creado por incidencia mejora DBLG500000712.
    */ 

  public DTOSalida obtenerListaPeriodosPosterioresMAV(DTOPeriodo dto) throws MareException  {
    DAOCRA dao  = new DAOCRA();
    return dao.obtenerListaPeriodosPosterioresMAV(dto.getPais(), dto.getMarca(), dto.getCanal());
  }

  /**    
     *@Autor: Gacevedo
     *@Fecha: 20/07/2006
     *@throws: MareException
     *@return: DTOSalida
     *@param: DTOPeriodo
     * Este metodo fue creado por incidencia DBLG400001108.
    */ 
  public DTOSalida obtenerPeriodosEntreFechas(DTOPeriodo dtoe) throws MareException {
    UtilidadesLog.info("MONPeriodosBean.obtenerPeriodosEntreFechas(DTOPerido dtoe):Entrada");    
    DAOCRA dao = new DAOCRA();
    DTOSalida dtoSalida = new DTOSalida();
    dtoSalida.setResultado(dao.obtenerPeriodosEntreFechas(dtoe));
    UtilidadesLog.info("MONPeriodosBean.obtenerPeriodosEntreFechas(DTOPerido dtoe):Salida");
    return dtoSalida;
  }

  /**Fecha de Creación: 19/10/2006
    * Autor: Hugo Mansi
    * Incidencia: BELC300024295
  */
  public DTOSalida obtienePeriodosRecMasivos(DTOPeriodo dtoe) throws MareException
  {
    UtilidadesLog.info("MONPeriodosBean.obtienePeriodosRecMasivos(DTOPerido dtoe):Entrada");    
    DAOCRA dao = new DAOCRA();
    DTOSalida dtoSalida = new DTOSalida();
    dtoSalida = dao.obtienePeriodosRecMasivos(dtoe);
    UtilidadesLog.info("MONPeriodosBean.obtienePeriodosRecMasivos(DTOPerido dtoe):Salida");    
    return dtoSalida;
  }

  /**
   * DBLG500000746 - gPineda - 06/11/2006
   * 
   * @throws es.indra.mare.common.exception.MareException
   * @return DTOPeriodo
   * @param canal
   * @param marca
   * @param pais
   */
  public DTOPeriodo obtieneMenorPeriodoActual(Long pais, Long marca, Long canal) 
    throws MareException {
      UtilidadesLog.info("MONPeriodosBean.obtieneMenorPeriodoActual(Long pais, Long marca, Long canal):Entrada");
      BelcorpService belcorpService;
      ExcepcionParametrizada exParam;
      try {
      
          belcorpService = BelcorpService.getInstance();
          
          SimpleDateFormat formatter = new SimpleDateFormat ("dd-MM-yyyy");
          Timestamp date = new Timestamp(System.currentTimeMillis());
    
          //hacemos la consulta usando JDBC
          StringBuffer stringBuffer = new StringBuffer();
          stringBuffer.append(" select P.OID_PERI, COD_PERI, MARC_OID_MARC, CANA_OID_CANA, ");
          stringBuffer.append(" PAIS_OID_PAIS, ACCE_OID_ACCE, PERI_OID_PERI, FEC_INIC, ");
          stringBuffer.append(" FEC_FINA, decode(VAL_ESTA,1,'true','false') as VAL_ESTA, VAL_NOMB_PERI, ");
          stringBuffer.append(" decode(IND_PERI_CORT,1,'true','false') as IND_PERI_CORT, decode(IND_PERI_CRUC,1,'true','false') as IND_PERI_CRUC ");
          stringBuffer.append(" FROM CRA_PERIO P, SEG_PERIO_CORPO PC ");
          stringBuffer.append(" where FEC_INIC <= to_date('" + formatter.format(date) + "', 'DD-MM-YYYY') and to_date('" + formatter.format(date) + "', 'DD-MM-YYYY') <= FEC_FINA and ");
          stringBuffer.append(" PAIS_OID_PAIS = ? and ");
          //Si el oid de la marca es 0, metadato todos, entonces se omite el filtro de marca
          if (marca.longValue() != 0) stringBuffer.append(" MARC_OID_MARC = ? and ");
          stringBuffer.append(" CANA_OID_CANA = ? and ");
          stringBuffer.append(" P.PERI_OID_PERI = PC.OID_PERI ");
          //ordena ascendentemente por fecha inicio
          stringBuffer.append(" ORDER BY FEC_INIC ASC ");
          
          //armamos el vector de parametros
          Vector parametros = new Vector();
          parametros.add(pais);
          //Si el oid de la marca es 0, metadato todos, entonces se omite el filtro de marca
          if (marca.longValue() != 0) parametros.add(marca);
          parametros.add(canal);
    
          RecordSet recordSet = belcorpService.dbService.executePreparedQuery(stringBuffer.toString(), parametros);
    
          DTOPeriodo dtoPeriodo = new DTOPeriodo();
          if ( ! recordSet.esVacio()) {
              
              dtoPeriodo.setOid( new Long(((BigDecimal)recordSet.getValueAt(0,"OID_PERI")).longValue()));
              dtoPeriodo.setCodigoPeriodo( (String) recordSet.getValueAt(0,"COD_PERI"));
              dtoPeriodo.setMarca( new Long(((BigDecimal)recordSet.getValueAt(0,"MARC_OID_MARC")).longValue()));
              dtoPeriodo.setCanal( new Long(((BigDecimal)recordSet.getValueAt(0,"CANA_OID_CANA")).longValue()));
              dtoPeriodo.setPais( new Long(((BigDecimal)recordSet.getValueAt(0,"PAIS_OID_PAIS")).longValue()));
              if (((BigDecimal)recordSet.getValueAt(0,"ACCE_OID_ACCE")) != null)
                  dtoPeriodo.setAcceso( new Long(((BigDecimal)recordSet.getValueAt(0,"ACCE_OID_ACCE")).longValue()));
              dtoPeriodo.setOidPeriodoCorporativo( new Long(((BigDecimal)recordSet.getValueAt(0,"PERI_OID_PERI")).longValue()));
              dtoPeriodo.setFechaInicio((Date) recordSet.getValueAt(0,"FEC_INIC"));
              dtoPeriodo.setFechaFin( (Date) recordSet.getValueAt(0,"FEC_FINA"));
              if (recordSet.getValueAt(0,"VAL_ESTA").toString().equalsIgnoreCase("true")) {
                  dtoPeriodo.setStatus(Boolean.TRUE);
              } else {
                  dtoPeriodo.setStatus(Boolean.FALSE);
              }
              dtoPeriodo.setNombre( (String) recordSet.getValueAt(0,"VAL_NOMB_PERI"));
              //dtoPeriodo.setTipo(); de ser necesario hacer el join para obtener el tipo de periodo
              dtoPeriodo.setPeriodoCorto( new Boolean( (String)recordSet.getValueAt(0,"IND_PERI_CORT") ) );
              dtoPeriodo.setPeriodoCruce( new Boolean( (String)recordSet.getValueAt(0,"IND_PERI_CRUC") ) );
          } else {
    
            //como no se obtuvieron registros se muestra el mensaje
            //Actualmente no existe un periodo definido para la marca "{0}" y el canal "{1}"
            //Obtener las descripciones de Marca y Canal
            String queryMarca = "SELECT DES_MARC FROM SEG_MARCA WHERE OID_MARC = ?";
            String queryCanal = "SELECT VAL_I18N FROM GEN_I18N_SICC WHERE ATTR_ENTI = 'SEG_CANAL' AND VAL_OID = ?";
    
            Vector paramMarca = new Vector();
            Vector paramCanal = new Vector();
    
            paramMarca.add( marca );
            paramCanal.add( canal );
            
            RecordSet rsMarca = belcorpService.dbService.executePreparedQuery(queryMarca, paramMarca);
            RecordSet rsCanal = belcorpService.dbService.executePreparedQuery(queryCanal, paramCanal);
            
            String descMarca = "";
            String descCanal = "";
    
            if( rsMarca != null && !rsMarca.esVacio() );{
              descMarca = (String)rsMarca.getValueAt( 0, "DES_MARC" );
            }
            if( rsCanal != null && !rsCanal.esVacio() ){
              descCanal = (String)rsCanal.getValueAt( 0, "VAL_I18N" );
            }
    
            exParam = new ExcepcionParametrizada(new MareException(),   
                                                  UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_CRA,"",
                                                      ErroresDeNegocio.NO_EXISTE_PERIODO_PARA_MARCA_CANAL_INDICADOS));
            exParam.setPosicion(ExcepcionParametrizada.POSICION_MEDIO);
            exParam.addParameter( descMarca );
            exParam.addParameter( descCanal );
            throw exParam;
          }
          UtilidadesLog.info("MONPeriodosBean.obtieneMenorPeriodoActual(Long pais, Long marca, Long canal):Salida");
          return dtoPeriodo;
          
      } catch (MareMiiServiceNotFoundException serviceNotFoundException) {
          UtilidadesLog.error(serviceNotFoundException);
          throw new MareException(serviceNotFoundException,
              UtilidadesError.armarCodigoError(
                  CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
      } catch (MareException me) {
          UtilidadesLog.error(me);
          throw me;
      } catch (Exception exception) {
          UtilidadesLog.error(exception);
          throw new MareException(exception,
              UtilidadesError.armarCodigoError(
                  CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
      }
    }

    public DTOOID  obtenerCodigoPeriodoComercial(DTOPeriodo dto) throws MareException {
        UtilidadesLog.info("MONPeriodosBean.obtenerCodigoPeriodoComercial(DTOPeriodo dto):Entrada");

        BelcorpService belcorpService;
        RecordSet recordSet;
        DTOOID dtoID = new DTOOID();

        try {
            belcorpService = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException serviceNotFoundException) {
            UtilidadesLog.error(serviceNotFoundException);
            throw new MareException(serviceNotFoundException,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        try {
            StringBuffer query = new StringBuffer();
            query.append(" SELECT OID_PERI FROM SEG_PERIO_CORPO ");
            query.append(" where COD_PERI = TO_CHAR(TO_CHAR(SYSDATE,'YYYY')||" +  dto.getOidPeriodoCorporativo() + ")");
            query.append(" AND TIPE_OID_TIPO_PERI = " +  dto.getTipo());
            
            UtilidadesLog.info("MONPeriodosBean.obtenerCodigoPeriodoComercial() : query.toString():" + query.toString());	          
            
            recordSet = belcorpService.dbService.executeStaticQuery(query.toString());
        } catch (Exception exception) {
            UtilidadesLog.error(exception);
            throw new MareException(exception,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        if (recordSet.getRowCount() > 0) {
            dtoID.setOid(new Long(((BigDecimal)recordSet.getValueAt(0,0)).longValue()));
        }  
        UtilidadesLog.info("MONPeriodosBean.obtenerCodigoPeriodoComercial(DTOPeriodo dto):Salida");
        return dtoID;
    }

    /** 
     * Metodo que obtiene las fechas de un periodo dado
     * @throws es.indra.mare.common.exception.MareException
     * @return Objeto DTOSalida
     * @param dtoPeriodo
     */
    public DTOSalida obtenerFechasPeriodo(DTOPeriodo dtoPeriodo) throws MareException {
        DAOCRA dao  = new DAOCRA();
        return dao.obtieneFechasPeriodo(dtoPeriodo);
    }

    /**
     * Modificado por HRCS - Fecha 27/02/2008 - Incidencia Sicc20080570
     * @throws es.indra.mare.common.exception.MareException
     * @return 
     * @param dtoPeriodo
     */
    public DTOSalida obtienePeriodosMayorIgualActual(DTOPeriodo dtoPeriodo) throws MareException {

        UtilidadesLog.info("MONPeriodosBean.obtienePeriodosMayorIgualActual():Entrada");

        DTOSalida salida = new DTOSalida();
        SimpleDateFormat formatter = new SimpleDateFormat ("dd-MM-yyyy");
        Timestamp date = new Timestamp(System.currentTimeMillis());
          
        StringBuffer sql = new StringBuffer();
        Vector parametros = new Vector();
        RecordSet resultado = new RecordSet();
        String codigoError = null;
        
        sql.append("SELECT * FROM ( ");
        sql.append(" SELECT p.oid_peri, cod_peri, marc_oid_marc, cana_oid_cana, pais_oid_pais, ");
        sql.append("  acce_oid_acce, peri_oid_peri, fec_inic, fec_fina, ");
        sql.append("  DECODE (val_esta, 1, 'true', 'false') AS val_esta, val_nomb_peri, ");
        sql.append("  DECODE (ind_peri_cort, 1, 'true', 'false') AS ind_peri_cort, ");
        sql.append("  DECODE (ind_peri_cruc, 1, 'true', 'false') AS ind_peri_cruc ");
        sql.append(" FROM cra_perio p, seg_perio_corpo pc ");
        sql.append(" WHERE ");
        sql.append("  fec_fina >= TO_DATE ('"+ formatter.format(date) +"', 'DD-MM-YYYY') ");
        sql.append("  AND pais_oid_pais = ? ");
        parametros.add( dtoPeriodo.getPais() );
        sql.append("  AND marc_oid_marc = ? ");
        parametros.add( dtoPeriodo.getMarca() );
        sql.append("  AND cana_oid_cana = ? ");
        parametros.add( dtoPeriodo.getCanal() );
        sql.append("  AND p.peri_oid_peri = pc.oid_peri ");
        sql.append(" ORDER BY cod_peri ASC ");
        sql.append(") periodos WHERE ROWNUM <= 4 ");
        
        BelcorpService bs = UtilidadesEJB.getBelcorpService();         
        try {
            resultado = bs.dbService.executePreparedQuery(sql.toString(), parametros);                                                       
        } catch (Exception e) {     
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;      
            UtilidadesLog.error(" obtienePeriodosMayorIgualActual : Exception",e);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }
        
        salida.setResultado( resultado );
        UtilidadesLog.info("MONPeriodosBean.obtienePeriodosMayorIgualActual():Salida");
        return salida;
    }

    public DTOPeriodo obtienePeriodoActual(Long pais, Long marca, Long canal, Long periodo) throws MareException {
             UtilidadesLog.info("MONPeriodosBean.obtienePeriodoActual(Long pais, Long marca, Long canal, Long periodo):Entrada");
        BelcorpService belcorpService;
        ExcepcionParametrizada exParam;
        try {
        
            UtilidadesLog.info("MONPeriodosBean.obtienePeriodoActual, pais="+pais+" marca="+marca+" canal="+canal+" periodo="+periodo);
            
            belcorpService = BelcorpService.getInstance();
            
            SimpleDateFormat formatter = new SimpleDateFormat ("dd-MM-yyyy");
            Timestamp date = new Timestamp(System.currentTimeMillis());

            //hacemos la consulta usando JDBC
            StringBuffer stringBuffer = new StringBuffer();

            stringBuffer.append(" select 1 NUM, P.OID_PERI, COD_PERI, MARC_OID_MARC, CANA_OID_CANA, ");
            stringBuffer.append(" PAIS_OID_PAIS, ACCE_OID_ACCE, PERI_OID_PERI, FEC_INIC, ");
            stringBuffer.append(" FEC_FINA, decode(VAL_ESTA,1,'true','false') as VAL_ESTA, VAL_NOMB_PERI, ");
            stringBuffer.append(" decode(IND_PERI_CORT,1,'true','false') as IND_PERI_CORT, decode(IND_PERI_CRUC,1,'true','false') as IND_PERI_CRUC ");
            stringBuffer.append(" FROM CRA_PERIO P, SEG_PERIO_CORPO PC ");
            stringBuffer.append(" where FEC_INIC <= to_date('" + formatter.format(date) + "', 'DD-MM-YYYY') and to_date('" + formatter.format(date) + "', 'DD-MM-YYYY') <= FEC_FINA and ");
            stringBuffer.append(" PAIS_OID_PAIS = " + pais +" and ");
            if (marca.longValue() != 0) 
                stringBuffer.append(" MARC_OID_MARC = "+ marca +" and ");
            stringBuffer.append(" CANA_OID_CANA = "+ canal +" and ");
            stringBuffer.append(" P.PERI_OID_PERI = PC.OID_PERI ");
            stringBuffer.append(" and  P.OID_PERI = " + periodo);
            
            stringBuffer.append(" UNION ");
            
            stringBuffer.append(" select 2 NUM, P.OID_PERI, COD_PERI, MARC_OID_MARC, CANA_OID_CANA, ");
            stringBuffer.append(" PAIS_OID_PAIS, ACCE_OID_ACCE, PERI_OID_PERI, FEC_INIC, ");
            stringBuffer.append(" FEC_FINA, decode(VAL_ESTA,1,'true','false') as VAL_ESTA, VAL_NOMB_PERI, ");
            stringBuffer.append(" decode(IND_PERI_CORT,1,'true','false') as IND_PERI_CORT, decode(IND_PERI_CRUC,1,'true','false') as IND_PERI_CRUC ");
            stringBuffer.append(" FROM CRA_PERIO P, SEG_PERIO_CORPO PC ");
            stringBuffer.append(" where FEC_INIC <= to_date('" + formatter.format(date) + "', 'DD-MM-YYYY') and to_date('" + formatter.format(date) + "', 'DD-MM-YYYY') <= FEC_FINA and ");
            stringBuffer.append(" PAIS_OID_PAIS = ? and ");
            if (marca.longValue() != 0) 
                stringBuffer.append(" MARC_OID_MARC = ? and ");
            stringBuffer.append(" CANA_OID_CANA = ? and ");
            stringBuffer.append(" P.PERI_OID_PERI = PC.OID_PERI ");
            stringBuffer.append(" ORDER BY NUM, FEC_INIC  ");
            
            //armamos el vector de parametros
            Vector parametros = new Vector();
            parametros.add(pais);
            //Si el oid de la marca es 0, metadato todos, entonces se omite el filtro de marca
            if (marca.longValue() != 0) parametros.add(marca);
            parametros.add(canal);

            RecordSet recordSet = belcorpService.dbService.executePreparedQuery(stringBuffer.toString(), parametros);

            DTOPeriodo dtoPeriodo = new DTOPeriodo();
            if ( ! recordSet.esVacio()) {
                
                dtoPeriodo.setOid( new Long(((BigDecimal)recordSet.getValueAt(0,"OID_PERI")).longValue()));
                dtoPeriodo.setCodigoPeriodo( (String) recordSet.getValueAt(0,"COD_PERI"));
                dtoPeriodo.setMarca( new Long(((BigDecimal)recordSet.getValueAt(0,"MARC_OID_MARC")).longValue()));
                dtoPeriodo.setCanal( new Long(((BigDecimal)recordSet.getValueAt(0,"CANA_OID_CANA")).longValue()));
                dtoPeriodo.setPais( new Long(((BigDecimal)recordSet.getValueAt(0,"PAIS_OID_PAIS")).longValue()));
                if (((BigDecimal)recordSet.getValueAt(0,"ACCE_OID_ACCE")) != null)
                    dtoPeriodo.setAcceso( new Long(((BigDecimal)recordSet.getValueAt(0,"ACCE_OID_ACCE")).longValue()));
                dtoPeriodo.setOidPeriodoCorporativo( new Long(((BigDecimal)recordSet.getValueAt(0,"PERI_OID_PERI")).longValue()));
                dtoPeriodo.setFechaInicio((Date) recordSet.getValueAt(0,"FEC_INIC"));
                dtoPeriodo.setFechaFin( (Date) recordSet.getValueAt(0,"FEC_FINA"));
                if (recordSet.getValueAt(0,"VAL_ESTA").toString().equalsIgnoreCase("true")) {
                    dtoPeriodo.setStatus(Boolean.TRUE);
                } else {
                    dtoPeriodo.setStatus(Boolean.FALSE);
                }
                dtoPeriodo.setNombre( (String) recordSet.getValueAt(0,"VAL_NOMB_PERI"));
                //dtoPeriodo.setTipo(); de ser necesario hacer el join para obtener el tipo de periodo
                dtoPeriodo.setPeriodoCorto( new Boolean( (String)recordSet.getValueAt(0,"IND_PERI_CORT") ) );
                dtoPeriodo.setPeriodoCruce( new Boolean( (String)recordSet.getValueAt(0,"IND_PERI_CRUC") ) );
            } else {

              //como no se obtuvieron registros se muestra el mensaje
              //Actualmente no existe un periodo definido para la marca "{0}" y el canal "{1}"
              //Obtener las descripciones de Marca y Canal
              String queryMarca = "SELECT DES_MARC FROM SEG_MARCA WHERE OID_MARC = ?";
              String queryCanal = "SELECT VAL_I18N FROM GEN_I18N_SICC WHERE ATTR_ENTI = 'SEG_CANAL' AND VAL_OID = ?";

              Vector paramMarca = new Vector();
              Vector paramCanal = new Vector();

              paramMarca.add( marca );
              paramCanal.add( canal );
              
              RecordSet rsMarca = belcorpService.dbService.executePreparedQuery(queryMarca, paramMarca);
              RecordSet rsCanal = belcorpService.dbService.executePreparedQuery(queryCanal, paramCanal);
              
              String descMarca = "";
              String descCanal = "";

              if( rsMarca != null && !rsMarca.esVacio() ){
                descMarca = (String)rsMarca.getValueAt( 0, "DES_MARC" );
              }
              if( rsCanal != null && !rsCanal.esVacio() ){
                descCanal = (String)rsCanal.getValueAt( 0, "VAL_I18N" );
              }

              //excepcion parametrizada 180240004
              exParam = new ExcepcionParametrizada(new MareException(),   
                                                    UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_CRA,"",
                                                        ErroresDeNegocio.NO_EXISTE_PERIODO_PARA_MARCA_CANAL_INDICADOS));
              exParam.setPosicion(ExcepcionParametrizada.POSICION_MEDIO);
              exParam.addParameter( descMarca );
              exParam.addParameter( descCanal );
              throw exParam;
            }
            UtilidadesLog.info("MONPeriodosBean.obtienePeriodoActual, getOid="+dtoPeriodo.getOid());
            UtilidadesLog.info("MONPeriodosBean.obtienePeriodoActual(Long pais, Long marca, Long canal, Long periodo):Salida");
            return dtoPeriodo;
            
        } catch (MareMiiServiceNotFoundException serviceNotFoundException) {
            UtilidadesLog.error(serviceNotFoundException);
            throw new MareException(serviceNotFoundException,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        } catch (MareException me) {
            UtilidadesLog.error(me);
            throw me;
        } catch (Exception exception) {
            UtilidadesLog.error(exception);
            throw new MareException(exception,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
    }

    /**
     * Recupera una lista de DTOPeriodo con oidPeriodo, oidMarca y oidCanal en cada DTO.
     * Se trata de una lista pues puede haber un periodo actual para cada combinacion de
     * marca y canal.
     * Se utiliza para poder seleccionar por default el combo de Periodos con el 
     * periodo actual.
     * @author eiraola
     * @since 05/Sep/2007
     */
    public Collection obtienePeriodosActuales(DTOBuscarPeriodos dtoE) throws MareException {
        UtilidadesLog.info("MONPeriodosBean.obtienePeriodosActuales(DTOBuscarPeriodos dtoE):Entrada");
        Collection periodos = new ArrayList();
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        
        SimpleDateFormat formatter = new SimpleDateFormat ("dd-MM-yyyy");
        Timestamp date = new Timestamp(System.currentTimeMillis()); // Fecha actual
        
        StringBuffer consulta = new StringBuffer();
        RecordSet rs = new RecordSet();
        
        consulta.append("SELECT per.MARC_OID_MARC, ");
        consulta.append("       per.CANA_OID_CANA, ");
        consulta.append("       per.OID_PERI ");
        consulta.append("  FROM CRA_PERIO per, ");
        consulta.append("       (SELECT MARC_OID_MARC, ");
        consulta.append("               CANA_OID_CANA, ");
        
        if (dtoE.getPeriodoMasNuevoPrimero() != null && dtoE.getPeriodoMasNuevoPrimero().booleanValue() == true) {
            consulta.append("               MAX(FEC_INIC) FEC_INIC ");
        } else {
            consulta.append("               MIN(FEC_INIC) FEC_INIC ");
        }
        consulta.append("          FROM CRA_PERIO  ");
        consulta.append("         WHERE FEC_INIC <= TO_DATE('"+formatter.format(date)+"', 'DD-MM-YYYY') ");
        consulta.append("           AND TO_DATE('"+formatter.format(date)+"', 'DD-MM-YYYY') <= FEC_FINA ");
        consulta.append("           AND PAIS_OID_PAIS = " + dtoE.getOidPais());
        consulta.append("         GROUP BY MARC_OID_MARC, CANA_OID_CANA) subquery ");
        consulta.append(" WHERE per.FEC_INIC <= TO_DATE('"+formatter.format(date)+"', 'DD-MM-YYYY') ");
        consulta.append("   AND TO_DATE('"+formatter.format(date)+"', 'DD-MM-YYYY') <= per.FEC_FINA ");
        consulta.append("   AND per.PAIS_OID_PAIS = " + dtoE.getOidPais());
        consulta.append("   AND per.MARC_OID_MARC = subquery.MARC_OID_MARC ");
        consulta.append("   AND per.CANA_OID_CANA = subquery.CANA_OID_CANA ");
        consulta.append("   AND per.FEC_INIC = subquery.FEC_INIC ");
        consulta.append(" ORDER BY per.MARC_OID_MARC, per.CANA_OID_CANA ");
        
        try {
            rs = bs.dbService.executeStaticQuery(consulta.toString());
        } catch (Exception e) {
            String codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            UtilidadesLog.error(" --- obtienePeriodosActuales: Exception", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }
        UtilidadesLog.debug(" --- rs (periodos actuales): " + rs);
        if (!rs.esVacio()) {
            DTOPeriodo dtoPeriodo = null;
            int cantRegistros = rs.getRowCount();
            
            for (int i = 0; i < cantRegistros; i++) {
                dtoPeriodo = new DTOPeriodo();
                dtoPeriodo.setOid(new Long(((BigDecimal)rs.getValueAt(i, "OID_PERI")).longValue()));
                dtoPeriodo.setMarca(new Long(((BigDecimal)rs.getValueAt(i, "MARC_OID_MARC")).longValue()));
                dtoPeriodo.setCanal(new Long(((BigDecimal)rs.getValueAt(i, "CANA_OID_CANA")).longValue()));
                
                periodos.add(dtoPeriodo);
            }
        }
        
        UtilidadesLog.info("MONPeriodosBean.obtienePeriodosActuales(DTOBuscarPeriodos dtoE):Salida");
        return periodos;
    }

    /**
     * Cambio CRA-01
     * Obtiene el año del periodo cuyo OID se recibe por parametro.
     * Si no existe tal periodo, el DTO de salida no guarda ningun valor.
     * @author dmorello
     * @since 20-jun-2008
     */
    public DTOSalida obtenerAnioPeriodo(DTOOID dtoe) throws MareException {
        UtilidadesLog.info("MONPeriodosBean.obtenerAnioPeriodo(DTOOID dtoe): Entrada");
        RecordSet rs = new DAOCRA().obtenerAnioPeriodo(dtoe);
        UtilidadesLog.info("MONPeriodosBean.obtenerAnioPeriodo(DTOOID dtoe): Salida");
        return new DTOSalida(rs);
    }

    /**
     * Cambio RI 20080621
     * Obtiene y devuelve pais, marca, canal y oid del periodo actual
     * cuyo pais, marca y canal recibe por parametro.
     * @author dmorello
     * @since 19-sep-2008
     */
    public DTOID obtenerPeriodoActual(DTOID dtoe) throws MareException {
        UtilidadesLog.info("MONPeriodosBean.obtenerPeriodoActual(DTOID dtoe): Entrada");
        DTOID dtoRetorno = new DAOCRA().obtenerPeriodoActual(dtoe);
        UtilidadesLog.info("MONPeriodosBean.obtenerPeriodoActual(DTOID dtoe): Salida");
        return dtoRetorno;
    }

    /**
     * Cambio RI 20080621
     * Obtiene y devuelve pais, marca, canal y oid del periodo posterior al actual
     * cuyo pais, marca y canal recibe por parametro.
     * @author dmorello
     * @since 19-sep-2008
     */
    public DTOID obtenerPeriodoPosteriorActual(DTOID dtoe) throws MareException {
        UtilidadesLog.info("MONPeriodosBean.obtenerPeriodoPosteriorActual(DTOID dtoe): Entrada");
        DTOID dtoRetorno = new DAOCRA().obtenerPeriodoPosteriorActual(dtoe);
        UtilidadesLog.info("MONPeriodosBean.obtenerPeriodoPosteriorActual(DTOID dtoe): Salida");
        return dtoRetorno;
    }

    /**
     * Cambio RI 20080621
     * Devuelve un DTOPeriodo con la info del periodo cuyo OID recibe por parametro.
     * Si no existe tal periodo devuelve null.
     * @author dmorello
     * @since 22-sep-2008
     */
    public DTOPeriodo obtenerPeriodo(DTOOID dtoe) throws MareException {
        UtilidadesLog.info("MONPeriodosBean.obtenerPeriodo(DTOOID dtoe): Entrada");
        DTOPeriodo dtoRetorno = new DAOCRA().obtenerPeriodo(dtoe);
        UtilidadesLog.info("MONPeriodosBean.obtenerPeriodo(DTOOID dtoe): Salida");
        return dtoRetorno;
    }

    /**
     * Cambio RI 20080621
     * Obtiene OID y nombre del periodo actual y de los posteriores para
     * pais, marca y canal recibidos por parametro.
     * @author dmorello
     * @since 07-oct-2008
     */
    public DTOSalida obtienePeriodoActualYPosteriores(DTOID dtoe) throws MareException {
        UtilidadesLog.info("MONPeriodosBean.obtienePeriodoActualYPosteriores(DTOOID dtoe): Entrada");
        DTOSalida dtoRetorno = new DAOCRA().obtienePeriodoActualYPosteriores(dtoe);
        UtilidadesLog.info("MONPeriodosBean.obtienePeriodoActualYPosteriores(DTOOID dtoe): Salida");
        return dtoRetorno;
    }

}
