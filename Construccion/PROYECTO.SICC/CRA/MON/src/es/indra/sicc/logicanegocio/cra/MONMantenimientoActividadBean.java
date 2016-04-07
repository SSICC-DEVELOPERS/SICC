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
package es.indra.sicc.logicanegocio.cra;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.mare.common.mii.services.MareServiceException;

import es.indra.mare.common.mii.services.ejbservice.EJBLocator;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.cmn.negocio.i18n.DTOI18nSICC;
import es.indra.sicc.cmn.negocio.i18n.Entidadi18nLocal;
import es.indra.sicc.cmn.negocio.i18n.Entidadi18nLocalHome;
import es.indra.sicc.dtos.cra.DTOActividad;
import es.indra.sicc.dtos.cra.DTOActividadesEliminar;
import es.indra.sicc.dtos.cra.DTODepartamentosProcesos;
import es.indra.sicc.dtos.cra.DTOMensajes;
import es.indra.sicc.dtos.mae.*;

import es.indra.sicc.dtos.msg.*;
import es.indra.sicc.entidades.cra.ActividadLocal;
import es.indra.sicc.entidades.cra.ActividadLocalHome;
import es.indra.sicc.entidades.cra.MensajesCRALocalHome;
import es.indra.sicc.entidades.cra.TransaccionesPorActividadLocal;
import es.indra.sicc.entidades.cra.TransaccionesPorActividadLocalHome;
import es.indra.sicc.logicanegocio.mae.*;
import es.indra.sicc.logicanegocio.mae.MONClientesHome;
import es.indra.sicc.logicanegocio.msg.*;
import es.indra.sicc.logicanegocio.zon.*;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.logicanegocio.seg.ConstantesSEG;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.RecuperadorIdiomaDefectoServidor;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import es.indra.sicc.util.UtilidadesPaginacion;

import java.math.BigDecimal;

import java.rmi.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Collection;
import java.util.Date;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.ejb.CreateException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import es.indra.sicc.logicanegocio.msg.MONGestionMensajesHome;
import javax.rmi.PortableRemoteObject;
import es.indra.sicc.dtos.zon.DTOUnidadAdministrativa;
import java.util.*;
import java.util.ArrayList;

import javax.persistence.EntityExistsException;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;


/**
 * Sistema:         Belcorp
 * Modulo:          CRA - Cronograma de Actividades
 * Componente:      MONMantenimientoActividadBean - Clase Bean
 * Fecha:           04/11/2003
 * Observaciones:   Basado en Modelo de Componentes SICC-DMCO-CRA-201-300.zip
 *                  Este componente realiza el ABMC de Actividades
 *
 * @version         3.0
 * @author          Nicolas Rodriguez Minetti, Gustavo De Marzi
 * 
 * @author pperanzola
 * @date 12/09/2005
 *          - Se modifican los log de la clase
 */
public class MONMantenimientoActividadBean implements SessionBean {
    private SessionContext ctx;
    private String codigoPais = null;
    private String codigoPeriodo = null;
    private RecordSet actividadesEbelNoticias = null;

    public void setSessionContext(SessionContext ctx) {
        this.ctx = ctx;
    }

    public void ejbCreate() {
    }

    public void ejbActivate() {
    }

    public void ejbPassivate() {
    }

    public void ejbRemove() {
    }

    private void verificaActividadOrigen(DTOActividad dtoActividad) throws MareException {
        UtilidadesLog.info("MONMantenimientoActividadBean. verificaActividadOrigen(DTOActividad dtoActividad):Entrada");
        StringBuffer query;
        RecordSet respuesta;
        Vector vecQuery;

        if ((dtoActividad.getTipoActividad().equals(new Integer(1))||dtoActividad.getTipoActividad().equals(new Integer(2))  )&& 
                (dtoActividad.getOidActividadOrigen() != null)) {// tipo act. con Origen o Referencia a otra campaña
            // Valida que ya exista en la tabla la actividad origen                                    
            query = new StringBuffer();
            query.append(" SELECT OID_ACTI FROM CRA_ACTIV WHERE ").append(" OID_ACTI = ? ");
            vecQuery = new Vector();
            vecQuery.add(dtoActividad.getOidActividadOrigen());
            respuesta = ejecutaQuery(query.toString(), vecQuery);

            if (respuesta.esVacio()) {
                //No existe la Actividad Origen
                ctx.setRollbackOnly();
                UtilidadesLog.debug(ConstantesSEG.MODULO_CRA + ErroresDeNegocio.VALIDAR_INSERCION_ACTIVIDAD_ORIGEN);
                throw new MareException("",
                    UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_CRA, "",
                        ErroresDeNegocio.VALIDAR_INSERCION_ACTIVIDAD_ORIGEN));
            } else {
                // Existe la actividad origen
                Long oidOrigen = new Long(((BigDecimal) respuesta.getValueAt(
                            0, "OID_ACTI")).intValue());
                dtoActividad.setOidActividadOrigen(oidOrigen);

                // verifica que no se generen ciclos ante la modificación de una actividad
                if (this.originaCiclo(dtoActividad)) {
                    UtilidadesLog.debug(ConstantesSEG.MODULO_CRA + ErroresDeNegocio.VERIFICAR_CICLOS_MODIFICAR_ACTIVIDAD);
                    throw new MareException("",
                        UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_CRA,
                            "",
                            ErroresDeNegocio.VERIFICAR_CICLOS_MODIFICAR_ACTIVIDAD));
                }
            }
        } else {
            dtoActividad.setOidActividadOrigen(null);
        }
        UtilidadesLog.info("MONMantenimientoActividadBean. verificaActividadOrigen(DTOActividad dtoActividad):Salida");
    }

    /** Según el DMCO V3:
        Para todas las combinaciones de Marca y Canal seleccionadas se añade
      un registro en ACTIVIDADES a través del EJBEntity Actividades
      con todos los datos del dto, a excepción del acceso que será null.

        Para todos los procesos existentes dentro de la lista "Procesos Asignados"
      del dto se insertará un nuevo registro en TRANSACCIONES_ACTIVIDADES
      haciendo uso del EJBEntity TransaccionesPorActividad por cada proceso existente.
        Los datos a guardar son:
          - dto.oidActividad
          - dto.proceso[i].codigoProceso.
    */
    public void insertaActividad(DTOActividad dtoActividad)
        throws MareException {
        UtilidadesLog.info("MONMantenimientoActividadBean.insertaActividad(DTOActividad dtoActividad):Entrada");
        verificaActividadOrigen(dtoActividad);

        try {
                ActividadLocalHome actividadLocalHome = new ActividadLocalHome();
                ActividadLocal actividadLocal = null;
                UtilidadesLog.debug("VA A SETEAR EL DTO");
                // Se inserta en la tabla Actividades       
                actividadLocal = actividadLocalHome.create(dtoActividad.getOidMarca(),
                        dtoActividad.getOidCanal(),
                        dtoActividad.getOidDepartamento(),
                        dtoActividad.getCodigoActividad(),
                        dtoActividad.getTipoActividad(),
                        dtoActividad.getEbelNoticias(),
                        dtoActividad.getOidClasificacion(),
                        dtoActividad.getOidPais());

                actividadLocal.setOidActividadOrigen(dtoActividad.getOidActividadOrigen());
                actividadLocal.setEbelNoticias(dtoActividad.getEbelNoticias());
                actividadLocal.setDiasDesplazamiento(dtoActividad.getDiasDesplazamiento());
                actividadLocal.setInLaborables(dtoActividad.getLaborales());
                actividadLocal.setTipoDireccion(dtoActividad.getTipoDireccion());
                actividadLocal.setCampanyaAntelacion(dtoActividad.getCampanyasAntelacion());
                actividadLocal.setInFestivo(dtoActividad.getFestivos());
                /*enozigli 30/10/2007 modificado por COL-CRA-001*/
                actividadLocal.setCampanyasDesplazamiento(dtoActividad.getCampanyasDesplazamiento());
                /*fin enozigli 30/10/2007 modificado por COL-CRA-001*/
                actividadLocal.setMensaje(dtoActividad.getOidMensaje());
                
                actividadLocalHome.merge(actividadLocal);

                Entidadi18nLocalHome e18nLH = new Entidadi18nLocalHome();

                for (int i = 0; i < dtoActividad.getVectorConTraducciones().size(); i++) {
                    DTOI18nSICC dtoTraduccion = (DTOI18nSICC) dtoActividad.getVectorConTraducciones().elementAt(i);
                    Long oidIdioma = (Long) dtoTraduccion.getOidIdioma();
                    String descripcion = (String) dtoTraduccion.getValorI18n();
                    e18nLH.create("CRA_ACTIV", new Long(1), oidIdioma,
                        descripcion, actividadLocal.getOid());
                }

                // Se inserta en la tabla de Transacciones Actividades        
                TransaccionesPorActividadLocalHome transaccionesPorActividadLocalHome = new TransaccionesPorActividadLocalHome();
                Enumeration procesos = dtoActividad.getProcesosAsignados().elements();
                Long oidTran;
               
                while (procesos.hasMoreElements()) {
                    oidTran = (Long) procesos.nextElement();
                    transaccionesPorActividadLocalHome.create(oidTran, actividadLocal.getOid(), new java.util.Date(System.currentTimeMillis()));
                }

        } catch (EntityExistsException e) {
            ctx.setRollbackOnly();
            UtilidadesLog.error(e);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_CLAVE_DUPLICADA));
        } catch (PersistenceException pe) {
            ctx.setRollbackOnly();
            UtilidadesLog.error(pe);
            throw new MareException(pe,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        } catch (Exception e) {
            if (e instanceof MareException){
                UtilidadesLog.error(e);
                throw (MareException)e;
            }
            ctx.setRollbackOnly();
            UtilidadesLog.error(e);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
        UtilidadesLog.info("MONMantenimientoActividadBean.insertaActividad(DTOActividad dtoActividad):Salida");
    }


    /** Según DMCO V3:
          Se a la entidad Actividades a recuperar los registros que cumplan los
        criterios introducidos. Para ello hace uso del DBService.
          Este metodo realiza una consulta en la tabla Actividades y en la tabla
        relacion Transacciones-Actividades.

          Este método deberá construir una SELECT dinámica en función de los
        parámetros de entrada que le lleguen. Utilizará solamente aquellos que
        no le vengan a NULL.

          El metodo devolverá el RecordSet encapsulado dentro del DTOSalida.

          En caso de Error el método lanzará una MareException con lo siguiente:
            - SQLException en el caso de que se haya producido.
            - Error de Lectura en Base de Datos: 0000000002 ó
            - Error de Acceso en Base de Datos: 0000000003

        Se lanza la excepción y se finaliza la ejecución del método.
    */
    public DTOSalida buscaPorCriterio(DTOActividad dtoe) throws MareException {
        UtilidadesLog.info("MONMantenimientoActividadBean.buscaPorCriterio(DTOActividad dtoe):Entrada");
        BelcorpService belcorpService;
        RecordSet respuestaRecordSet;
        RecordSet respuestaRecordSet2;
        RecordSet respuestaRecordSet3;
        

        try {
            belcorpService = BelcorpService.getInstance();
            StringBuffer select = new StringBuffer(" DISTINCT ");
            select.append("  A.OID_ACTI OID ");
            select.append(", CLA.DES_CLAS_ACTI");
            select.append(", A.COD_ACTI COD_ACTIV ");
            select.append(", G.VAL_I18N");
            /*enozigli 30/10/2007 modificado por COL-CRA-001*/
            select.append(", DECODE( A.COD_TIPO_ACTI, 0, 'Fija', DECODE( A.COD_TIPO_ACTI, 1,  'con Origen' , 'Ref. Otra Camp.') ) AS DESC_TIPO"); 
            select.append(", A.NUM_CAMP_REFE ");
            /*fin enozigli 30/10/2007 modificado por COL-CRA-001*/
            select.append(", G2.VAL_I18N AS DES_ORIGEN");
            select.append(", DE.DES_CORT_DPTO AS DESC_AREA_RESP");
            select.append(", DECODE( A.IND_EBEL, 0, 'No', 'Si' ) AS DESC_EBEL");  
            //select.append(", TD.COD_TIPO_DIRE AS DESC_TIPO_DIRE");
            select.append(", G3.VAL_I18N AS DESC_TIPO_DIRE");
            select.append(", A.NUM_CAMP_ANTE"); 


            select.append(", ' ' AS PROC_ASIG");
            select.append(", ' ' AS PROC_DISP");


            select.append(", A.NUM_DIAS_DESP , A.IND_LABO, M.COD_MENS " )
                  .append(", A.COD_TIPO_ACTI, A.COD_ACTI")
                  .append(", A.CACT_OID_ACTI, A.MARC_OID_MARC")
                  .append(", A.CANA_OID_CANA, A.DPTE_OID_DEPA")
                  .append(", A.ACCE_OID_ACCE, A.TIDC_OID_TIPO_DIRE")
                  .append(", A.IND_EBEL, A.IND_FEST")
                  .append(", B.COD_ACTI AS COD_ORIGEN")
                  .append(", ( A.COD_ACTI || ' ' || G.VAL_I18N ) AS DESCRICPCION_LARGA ") 
                  .append(", A.CLAC_OID_CLAS_ACTI , a.mens_oid_mens ");
                  

            StringBuffer from = new StringBuffer(" CRA_ACTIV A ");
            StringBuffer where = new StringBuffer(" 1=1 ");
            Vector vector = new Vector();

            /*  No se donde esta pais!!
            if ( dtoe.getOidPais() != null ) {
                where.append( " AND CRA_ACTIV.PAIS_COD_PAIS = ? " );
                vector.add( dtoe.getOidPais() );
            } */
            where.append(" AND M.OID_MENS (+)= a.mens_oid_mens ");
            where.append(" AND A.OID_ACTI = G.VAL_OID  ");

            where.append(" AND G.ATTR_ENTI = 'CRA_ACTIV' ");
            where.append(" AND B.OID_ACTI =  G2.VAL_OID(+) ");
            where.append(" AND G2.ATTR_ENTI(+) = 'CRA_ACTIV' ");

            where.append(" AND G3.ATTR_ENTI (+) = 'MAE_TIPO_DIREC' ");
            where.append(" AND TD.OID_TIPO_DIRE =  G3.VAL_OID (+) ");
            where.append(" AND  G3.IDIO_OID_IDIO (+) = "+dtoe.getOidIdioma());


            if (dtoe.getOidIdioma() != null) {
                where.append(" AND G.IDIO_OID_IDIO = ?");
                where.append(" AND G2.IDIO_OID_IDIO(+)= ?");
                vector.add(dtoe.getOidIdioma());
                vector.add(dtoe.getOidIdioma());
                
            }

            if (dtoe.getOidMarca() != null) {
                where.append(" AND A.MARC_OID_MARC = ? ");
                vector.add(dtoe.getOidMarca());
            }

            if (dtoe.getOidCanal() != null) {
                where.append(" AND A.CANA_OID_CANA = ? ");
                vector.add(dtoe.getOidCanal());
            }

            if (dtoe.getOidPais() != null) {
                where.append(" AND A.PAIS_OID_PAIS = ? ");
                vector.add(dtoe.getOidPais());
            }

            // Se utiliza OID_ACTI porque se elegió desde la pantalla la LP, entonces se debería conocer.
            if (dtoe.getOid() != null) {
                where.append(" AND A.OID_ACTI = ? ");
                vector.add(dtoe.getOid());
            }

            /*if (dtoe.getTipoActividad() != null) {
                where.append(" AND A.COD_TIPO_ACTI = ? ");
                vector.add(dtoe.getTipoActividad());
            }

            if (dtoe.getOidActividadOrigen() != null) {
                where.append(" AND A.CACT_OID_ACTI = ? ");
                vector.add(dtoe.getOidActividadOrigen());
            }

            if (dtoe.getOidDepartamento() != null) {
                where.append(" AND A.DPTE_OID_DEPA = ? ");
                vector.add(dtoe.getOidDepartamento());
            }*/

            /*if (dtoe.getEbelNoticias() != null) {
                where.append(" AND A.IND_EBEL = ? ");
                vector.add(dtoe.getEbelNoticias());
            }*/
            from.append(", CRA_ACTIV B ");
            from.append(", CRA_CLASE_ACTIV CLA");
            from.append(", GEN_I18N_SICC G ");
            from.append(", GEN_I18N_SICC G2 ");
            from.append(", GEN_I18N_SICC G3 ");
            from.append(", msg_mensa m ");
            where.append(" AND A.CLAC_OID_CLAS_ACTI = CLA.OID_CLAS_ACTI ");
            where.append(" AND A.CACT_OID_ACTI = B.OID_ACTI (+) ");
             

            from.append(", MAE_TIPO_DIREC TD ");
            where.append(" AND A.TIDC_OID_TIPO_DIRE = TD.OID_TIPO_DIRE (+) ");

            // Area Responsable

            from.append(", SEG_DEPTO_EMPRE DE ");
            where.append(" AND A.DPTE_OID_DEPA = DE.OID_DEPA (+) ");

            if ((dtoe.getProcesosAsignados() != null) &&
                    (dtoe.getProcesosAsignados().size() > 0)) {
                from.append(", CRA_TRANS_ACTIV T ");
                where.append(" AND A.OID_ACTI = T.CACT_OID_ACTI ");

                where.append(" AND T.TRAN_OID_TRAN IN (");

                Enumeration procesos = dtoe.getProcesosAsignados().elements();

                Long oidTran;

                while (procesos.hasMoreElements()) {
                    oidTran = (Long) procesos.nextElement();

                    where.append("?, ");
                    vector.add(oidTran);
                }

                where.deleteCharAt(where.length() - 2);
                where.append(") ");
            }

            String query = "SELECT " + select + " FROM " + from + " WHERE " + where;

            String sql = UtilidadesPaginacion.armarQueryPaginacion(query, dtoe);

            respuestaRecordSet = belcorpService.dbService.executePreparedQuery(sql.toString(), vector);

             /*  Incidencia 5251
             * Aca obtengo para cada una de las Actividades, los procesos Asginados y Disponibles
             * Los Nombres de los Procesos no la cantidad como estaba antes
             * */

             for(int r=0;r<respuestaRecordSet.getRowCount();r++){
                     String oid = null;
                     StringBuffer procesosAsignados = new StringBuffer("");
                     StringBuffer procesosDisponibles = new StringBuffer("");
                     oid = respuestaRecordSet.getValueAt(r,"OID").toString();
                  
                     StringBuffer asignados = new StringBuffer(" SELECT  ctran.COD_proc "); 
                     asignados.append( "FROM cra_trans_activ ta, cra_trans ctran ");
                     asignados.append( " WHERE 1=1 and ta.TRAN_OID_TRAN = ctran.OID_TRAN AND ta.CACT_OID_ACTI = ? ");
                     Vector vector2 = new Vector();
                     vector2.add (oid);

                     respuestaRecordSet2 = belcorpService.dbService.executePreparedQuery(asignados.toString(),vector2);

                     if (!(respuestaRecordSet2.esVacio())){
                     
                         for(int r2=0;r2<respuestaRecordSet2.getRowCount();r2++){
                                   
                                   procesosAsignados.append(respuestaRecordSet2.getValueAt(r2,"COD_PROC").toString());
                                   procesosAsignados.append(",");
                               }
                        
                     procesosAsignados.deleteCharAt(procesosAsignados.length()-1);
                     
                     
                    }


                   UtilidadesLog.debug("Procesos Asignados:" + procesosAsignados); 
                   /*enozigli 30/10/2007 modificado por COL-CRA-001*/
                   respuestaRecordSet.setValueAt(procesosAsignados,r,11);
                   /*fin enozigli 30/10/2007 modificado por COL-CRA-001*/

                   StringBuffer disponibles = new StringBuffer(" SELECT  ctran.COD_proc "); 
                   disponibles.append( "FROM cra_trans ctran ");
                   disponibles.append( "  WHERE ctran.COD_proc NOT IN ( SELECT  ctran.COD_proc FROM cra_trans_activ ta, cra_trans ctran WHERE ta.TRAN_OID_TRAN = ctran.OID_TRAN AND ta.CACT_OID_ACTI = ? )" );
                   respuestaRecordSet3 = belcorpService.dbService.executePreparedQuery(disponibles.toString(),vector2);

                     if (!(respuestaRecordSet3.esVacio())){
                              for(int r3=0;r3<respuestaRecordSet3.getRowCount();r3++){
                                        procesosDisponibles.append(respuestaRecordSet3.getValueAt(r3,"COD_PROC").toString());
                                        procesosDisponibles.append(",");
                                        }
                              procesosDisponibles.deleteCharAt(procesosDisponibles.length()-1);
                     }
                     

                   UtilidadesLog.debug("Procesos Disponibles:" + procesosDisponibles);
                   /*enozigli 30/10/2007 modificado por COL-CRA-001*/
                   respuestaRecordSet.setValueAt(procesosDisponibles,r,12);
                   /*fin enozigli 30/10/2007 modificado por COL-CRA-001*/
                      
              }

          // fin de lo nuevo
                    
        } catch (MareMiiServiceNotFoundException serviceNotFoundException) {
            UtilidadesLog.error(serviceNotFoundException);
            throw new MareException(serviceNotFoundException,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        } catch (Exception exception) {
            UtilidadesLog.error(exception);
            if (exception instanceof MareException)
                throw (MareException)exception;
       
            throw new MareException(exception,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        if (respuestaRecordSet.esVacio()) {
            UtilidadesLog.debug(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE);
            throw new MareException(new Exception(),
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }
        UtilidadesLog.info("MONMantenimientoActividadBean.buscaPorCriterio(DTOActividad dtoe):Salida");
        return new DTOSalida(respuestaRecordSet);
    }

    /** Segun DMCO V3:
      1.- Se recupera del EJBEntity Actividades (a través de findByPK) aquella
        actividad identificada por dto.oidActividad y se actualizan los distintos
        atributos tal y como se especifica en el dto.
      2.- Se eliminan todos los registros de TransaccionesPorActividad cuya
        actividad sea dto.oidActividad. Se hará a través de DBService y una
        query DELETE.
      3.- Para todos los procesos existentes dentro de la lista "Procesos Asignados"
        del dto se insertará un nuevo registro en TRANSACCIONES_ACTIVIDADES
        haciendo uso del EJBEntity TransaccionesPorActividad por cada proceso
        existente. Los datos a guardar son:
          - dto.oidActividad
          - dto.proceso[i].codigoProceso.

      Se captura las excepciones FinderException y RemoteException. En caso de
      que se produzca una excepción, se crea una instancia de MareException
      con la excepción capturada y un código que dependerá de dicha excepción:
        - FinderException: error de acceso a BBDD y de lectura en BBDD
        - RemoteException: error de acceso a BBDD
        - Error de Lectura en Base de Datos: 0000000002
        - Error de Escritura en Base de Datos: 0000000001
        - Error de Acceso en Base de Datos: 0000000003
        - Error peticion de datos no existente: 0000000005

      Se lanza la excepción y se finaliza la ejecución del método.
      En caso de que no se produzca ninguna excepción no se devuelve nada.
     */
    public void actualizaActividad(DTOActividad dto) throws MareException {
        UtilidadesLog.info("MONMantenimientoActividadBean.actualizaActividad(DTOActividad dto):Entrada");
        StringBuffer query;
        RecordSet respuesta;
        Vector vecQuery;

        //verifica actividad origen
        verificaActividadOrigen(dto);

        try {
            ActividadLocalHome actLH = new ActividadLocalHome();
            ActividadLocal actL = null;
              
            UtilidadesLog.debug("DTOActividad:" + dto);
            actL = actLH.findByPrimaryKey(dto.getOid());

            actL.setCodigoActividad(dto.getCodigoActividad());
            actL.setTipoActividad(dto.getTipoActividad());
            actL.setClasificacionActividad(dto.getOidClasificacion());

            actL.setEbelNoticias(dto.getEbelNoticias());
            actL.setDiasDesplazamiento(dto.getDiasDesplazamiento());
            actL.setInLaborables(dto.getLaborales());
            actL.setInFestivo(dto.getFestivos());

            actL.setOidPais(dto.getOidPais());
            actL.setOidMarca(dto.getOidMarca());
            actL.setOidCanal(dto.getOidCanal());
            actL.setOidAcceso(dto.getOidAcceso());
            actL.setOidDepartamento(dto.getOidDepartamento());

            actL.setTipoDireccion(dto.getTipoDireccion());
            actL.setCampanyaAntelacion(dto.getCampanyasAntelacion());
            actL.setOidActividadOrigen(dto.getOidActividadOrigen());
            /*enozigli 30/10/2007 modificado por COL-CRA-001*/
            actL.setCampanyasDesplazamiento(dto.getCampanyasDesplazamiento());
            /*fin enozigli 30/10/2007 modificado por COL-CRA-001*/

            actL.setMensaje(dto.getOidMensaje());
            actLH.merge(actL);
              
            Entidadi18nLocalHome e18nLH = new Entidadi18nLocalHome();
              
            for (int i = 0; i < dto.getVectorConTraducciones().size(); i++) {
               
                DTOI18nSICC dtoTraduccion = (DTOI18nSICC) dto.getVectorConTraducciones().elementAt(i);
                Long oidIdioma = (Long) dtoTraduccion.getOidIdioma();
                String descripcion = (String) dtoTraduccion.getValorI18n();

                try {
                    Entidadi18nLocal e18nL = e18nLH.findByEntAtrIdioPK("CRA_ACTIV",
                            new Long(1), oidIdioma, actL.getOid());
                    e18nL.setDetalle(descripcion);
                    e18nLH.merge(e18nL);
                } catch (NoResultException e) {
                    UtilidadesLog.debug("No se encontro la descripcion para ese idioma, vamos a crearlo");
                    e18nLH.create("CRA_ACTIV", new Long(1), oidIdioma,
                        descripcion, actL.getOid());
                }

            }

            //Actualizo la tabla Transacciones  
            TransaccionesPorActividadLocalHome transActLH = new TransaccionesPorActividadLocalHome();
            TransaccionesPorActividadLocal transActL;

            // Busco todas las Transacciones             
            query = new StringBuffer();
            query.append(" SELECT * FROM CRA_TRANS_ACTIV WHERE ").append(" CACT_OID_ACTI = ? ");
            vecQuery = new Vector();
            vecQuery.add(dto.getOid());
               
            respuesta = ejecutaQuery(query.toString(), vecQuery);
               
            // Borro las Transacciones viejas
            if (!respuesta.esVacio()) {
                Vector vector = respuesta.getColumn(respuesta.getColumnPosition(
                            "OID_TRAN_ACTI"));
                Enumeration procesos = vector.elements();
                Long transProActi;

                while (procesos.hasMoreElements()) {
                    transProActi = new Long(((BigDecimal) procesos.nextElement()).intValue());
                    transActL = transActLH.findByPrimaryKey(transProActi);
                    transActLH.remove(transActL);
                }
            }
               
            // inserto las Transacciones nuevas
            Enumeration procesos = dto.getProcesosAsignados().elements();
            Long oidTran;
            while (procesos.hasMoreElements()) {
                oidTran = (Long) procesos.nextElement();
                transActLH.create(oidTran, dto.getOid(), new java.util.Date(System.currentTimeMillis()));
            }

        } catch (NoResultException finderException) {
            UtilidadesLog.debug(finderException);
            ctx.setRollbackOnly();
            throw new MareException(finderException,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        } catch (PersistenceException pe) {
            UtilidadesLog.error(pe);
            ctx.setRollbackOnly();
            throw new MareException(pe,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
        UtilidadesLog.info("MONMantenimientoActividadBean.actualizaActividad(DTOActividad dto):Salida");
    }


    /** Segun DMCO V3:
        1. Se llama al MONPeriodos.obtienePeriodo (a través del interfaz IPeriodos)
          pasándole un DTOPeriodo rellenado con los siguientes datos:
            - dto.oidMarca
            - dto.oidPais
            - dto.oidCanal
            - oidAcceso = null
          Esta llamada devuelve una instancia de DTOPeriodo que llamaremos
          dtoPeriodo con los datos del período actual.
        2. El sistema llama al método obtieneSiguienteFechaActividad() pasándole
          como datos el dto y el dtoPeriodo.
          Si devuelve una fecha posterior a la actual se lanza una excepción:
          "No se puede eliminar la actividad seleccionada".
          Si no retorna ninguna fecha, o devuelve una fecha anterior a la actual:
        3. Obtener todos los registros de Cronograma a través del
          MONMantenimientoCronograma (realmente a través de su interfaz ICronograma)
          y del método obtienePorCriterio con un DTOCronograma que se rellenará
          con los siguientes datos de filtrado:
            · oidActividad.
            · valorFechaInicio = dto.periodo.fechaFin
          Se obtendrá un DTOSalida con un RecordSet.
          Si se obtiene algún registro se lanza una excepción: "No se puede
          eliminar la actividad seleccionada".
          Si no se obtiene ningún registro se elimina la actividad definida por
          dto.oidActividad a través del EJBEntity Actividades.

        Se captura las excepciones FinderException, RemoveException y RemoteException.
        En caso de que se produzca una excepción, se crea una instancia de
        MareException con la excepción capturada y un código que dependerá de
        dicha excepción:
          - FinderException: error de acceso a BBDD y de lectura en BBDD
          - RemoveException: error de acceso a BBDD y de escritura en BBDD
          - RemoteException: error de acceso a BBDD

          - Error de Lectura en Base de Datos: 0000000002
          - Error de Escritura en Base de Datos: 0000000001
          - Error de Acceso en Base de Datos: 0000000003
          - Error peticion de datos no existente: 0000000005

        Se lanza la excepción y se finaliza la ejecución del método.
        En caso de que no se produzca ninguna excepción no se devuelve nada.
     */
    public void eliminaActividad(DTOActividad dto) throws MareException {
        UtilidadesLog.info("MONMantenimientoActividadBean.eliminaActividad(DTOActividad dto):Entrada");
        BelcorpService belcorpService;

        try {
            belcorpService = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException serviceNotFoundException) {
            UtilidadesLog.error(serviceNotFoundException);
            ctx.setRollbackOnly();
            throw new MareException(serviceNotFoundException,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        try {
            TransaccionesPorActividadLocalHome transActLH = new TransaccionesPorActividadLocalHome();
            TransaccionesPorActividadLocal transActL;
            ActividadLocalHome actLH = new ActividadLocalHome();
            ActividadLocal actL;

            if (contieneReferencias(dto.getOid())) {
                UtilidadesLog.debug("No se puede eliminar la actividad seleccionada");
                ctx.setRollbackOnly();
                throw new MareException("No se puede eliminar la actividad seleccionada",
                    UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_CRA, "",
                        ErroresDeNegocio.VALIDAR_ELIMINACION_ACTIVIDAD));
            }

            RecordSet respuesta;

            try {
                // Busco TransaccionesPorActividad asociadas a esa actividad
                StringBuffer query = new StringBuffer();
                query.append(
                    " SELECT OID_TRAN_ACTI FROM CRA_TRANS_ACTIV WHERE ").append(" CACT_OID_ACTI = '" +
                    dto.getOid() + "' ");
                respuesta = belcorpService.dbService.executeStaticQuery(query.toString());
            } catch (Exception exception) {
                UtilidadesLog.error(exception);
                throw new MareException(exception,
                    UtilidadesError.armarCodigoError(
                        CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
            }

            if (!respuesta.esVacio()) {
                // Borro todas las transacciones encontradas
                Vector vector = respuesta.getColumn(respuesta.getColumnPosition("OID_TRAN_ACTI"));
                Enumeration oidsTrans = vector.elements();
                Long oid;

                while (oidsTrans.hasMoreElements()) {
                    oid = new Long(((BigDecimal) oidsTrans.nextElement()).intValue());
                    transActL = transActLH.findByPrimaryKey(oid);
                    transActLH.remove(transActL);
                }
            }

            // Borro la actividad        
            actL = actLH.findByPrimaryKey(dto.getOid());

            Entidadi18nLocalHome e18nLH = new Entidadi18nLocalHome();

            Collection col = e18nLH.findByEntAtrPK("CRA_ACTIV", new Long(1), actL.getOid());
            Iterator it = col.iterator();

            while (it.hasNext()){
                  Entidadi18nLocal e18nLocal = (Entidadi18nLocal)it.next();
                  e18nLH.remove(e18nLocal);
           }

           actLH.remove(actL);
                
        } catch (NoResultException finderException) {
            UtilidadesLog.debug(finderException);
            ctx.setRollbackOnly();
            throw new MareException(finderException,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        } catch (EntityExistsException eee) {
                UtilidadesLog.debug(eee);
                throw new MareException(eee,
                        UtilidadesError.armarCodigoError(
                                CodigosError.ERROR_DE_CLAVE_DUPLICADA));
        } catch (PersistenceException pe) {
            UtilidadesLog.debug(pe);
            ctx.setRollbackOnly();
            throw new MareException(pe,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
        UtilidadesLog.info("MONMantenimientoActividadBean.eliminaActividad(DTOActividad dto):Salida");
    }

    private boolean contieneReferencias(Long oidAct) throws MareException {
        UtilidadesLog.info("MONMantenimientoActividadBean.contieneReferencias(Long oidAct):Entrada");
        BelcorpService bs;
        RecordSet respuesta;
        StringBuffer query;

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException serviceNotFoundException) {
            UtilidadesLog.error(serviceNotFoundException);
            ctx.setRollbackOnly();
            throw new MareException(serviceNotFoundException,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        // Busco referencias en CRA_MENSA, CRA_MATRI_DIAS, CRA_HISTO_MATRI_DIAS,
        // CRA_CRONO_GRUPO_ZONA, CRA_CRONO, CRA_FERIA
        try {
            query = new StringBuffer();
            query.append(" SELECT CACT_OID_ACTI FROM CRA_MENSA WHERE ")
                 .append(" CACT_OID_ACTI = '" + oidAct + "' ").append(" union ")
                 .append(" SELECT CACT_OID_ACTI FROM CRA_MATRI_DIAS WHERE ")
                 .append(" CACT_OID_ACTI = '" + oidAct + "' ").append(" union ")
                 .append(" SELECT CACT_OID_ACTI FROM CRA_HISTO_MATRI_DIAS WHERE ")
                 .append(" CACT_OID_ACTI = '" + oidAct + "' ").append(" union ")
                 .append(" SELECT CACT_OID_ACTI FROM CRA_CRONO_GRUPO_ZONA WHERE ")
                 .append(" CACT_OID_ACTI = '" + oidAct + "' ").append(" union ")
                 .append(" SELECT CACT_OID_ACTI FROM CRA_CRONO WHERE ")
                 .append(" CACT_OID_ACTI = '" + oidAct + "' ").append(" union ")
                 .append(" SELECT CACT_OID_ACTI FROM CRA_FERIA WHERE ").append(" CACT_OID_ACTI = '" +
                oidAct + "' ");
            respuesta = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception exception) {
            UtilidadesLog.error(exception);
            throw new MareException(exception,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        
        UtilidadesLog.info("MONMantenimientoActividadBean.contieneReferencias(Long oidAct):Salida");
        
        if (!respuesta.esVacio()) {
            return true;
        } else {
            return false;
        }
        
    }

    private void eliminaActividades(DTOActividadesEliminar dto) throws MareException {
        UtilidadesLog.info("MONMantenimientoActividadBean.eliminaActividades(DTOActividadesEliminar dto):Entrada");
        Vector oids = dto.getOidsActividades();
        Long oid;
        DTOActividad dtoAct;

        for (int i = 0; i < oids.size(); i++) {
            oid = (Long) oids.get(i);
            dtoAct = new DTOActividad();
            dtoAct.setOid(oid);
            dtoAct.setIpCliente(dto.getIpCliente());
            dtoAct.setPrograma(dto.getPrograma());
            eliminaActividad(dtoAct);
        }
        UtilidadesLog.info("MONMantenimientoActividadBean.eliminaActividades(DTOActividadesEliminar dto):Salida");
    }

    public DTODepartamentosProcesos obtenerDatosInsercion(DTOActividad dto)
        throws MareException {
        UtilidadesLog.info("MONMantenimientoActividadBean.obtenerDatosInsercion(DTOActividad dto):Entrada");
        DTODepartamentosProcesos sal = new DTODepartamentosProcesos();

        // Procesos Disponibles
        DTOSalida salDisp = obtenerProcesosDisponibles(dto);
        sal.setProcesosDisponibles(salDisp.getResultado());

        // Procesos Asignados 
        DTOSalida salAsig = obtenerProcesosAsignados(dto);
        sal.setProcesosAsignados(salAsig.getResultado());

        // Departamentos
        DTOSalida salDepto = obtenerDepartamentos(dto);
        sal.setDepartamentos(salDepto.getResultado());

        // Tipos de direccion      
        DTOSalida salTDir = obtieneTiposDireccion();
        sal.setTiposDireccion(salTDir.getResultado());
        UtilidadesLog.info("MONMantenimientoActividadBean.obtenerDatosInsercion(DTOActividad dto):Salida");
        return sal;
    }

    private DTOSalida obtieneTiposDireccion() throws MareException {
        // Este metodo responde a la incidencia BELC300000379:
        //    Llamada a IConfiguracionCliente.obtenerTiposDireccion() de MAE
        //    para devolver los Tipos de direccion para el combo correspondiente
        //    en la pantalla de modificacion e insercion de actividades.
        // Por ahora no esta construido MAE, procedo a hacer el query por JDBC
        UtilidadesLog.info("MONMantenimientoActividadBean.obtieneTiposDireccion():Entrada");
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(" SELECT OID_TIPO_DIRE, COD_TIPO_DIRE ").append(" FROM MAE_TIPO_DIREC ");
        
        UtilidadesLog.info("MONMantenimientoActividadBean.obtieneTiposDireccion():Salida");
        return new DTOSalida(ejecutaQuery(stringBuffer.toString(), new Vector()));
    }

    private DTOSalida obtenerDepartamentos(DTOActividad dto)
        throws MareException {
        // Busco Los Departamentos en la tabla SEG_DEPTO_EMPRE
        // Cuando este hecho el mon de Seg correspondiente, esto se podria 
        // reemplazar por una llamada a MON
        UtilidadesLog.info("MONMantenimientoActividadBean.obtenerDepartamentos(DTOActividad dto):Entrada");
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(" SELECT OID_DEPA, DES_CORT_DPTO ")
                    .append(" FROM SEG_DEPTO_EMPRE ").append(" WHERE PAIS_OID_PAIS = ?");

        Vector vector = new Vector();
        vector.add(dto.getOidPais());
        UtilidadesLog.info("MONMantenimientoActividadBean.obtenerDepartamentos(DTOActividad dto):Salida");
        return new DTOSalida(ejecutaQuery(stringBuffer.toString(), vector));
    }

    public DTOSalida obtenerProcesosAsignados(DTOActividad dto)
        throws MareException {
        UtilidadesLog.info("MONMantenimientoActividadBean.obtenerProcesosAsignados(DTOActividad dto):Entrada");
        // Busco Las Transacciones que esten en TransaccionesPorActividad
        if (dto.getOid() != null) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(" SELECT TRAN_OID_TRAN, CRA_TRANS.COD_PROC ")
                        .append(" FROM CRA_TRANS_ACTIV, CRA_TRANS ")
                        .append(" WHERE CRA_TRANS_ACTIV.TRAN_OID_TRAN = CRA_TRANS.OID_TRAN ")
                        .append(" AND CRA_TRANS_ACTIV.CACT_OID_ACTI = ?");

            Vector vector = new Vector();
            vector.add(dto.getOid());
            UtilidadesLog.info("MONMantenimientoActividadBean.obtenerProcesosAsignados(DTOActividad dto):Salida");
            return new DTOSalida(ejecutaQuery(stringBuffer.toString(), vector));
        } else { // sin actividad, no hay asignados.
            UtilidadesLog.info("MONMantenimientoActividadBean.obtenerProcesosAsignados(DTOActividad dto):Salida");
            return new DTOSalida(new RecordSet());
        }
    }

    /** Segun DMCO V3:
        Este método consulta (mediante JDBCMARE) la tabla Procesos (CRA) y
      obtiene los procesos existentes que no estén asignados a la actividad
      que se recibirá por parámetro.
        Si se produce algún error lanzará una MareException con:
            Excepcion: La SQLException producida.
            Codigo: 0000000002
     */
    public DTOSalida obtenerProcesosDisponibles(DTOActividad dto) throws MareException {
        UtilidadesLog.info("MONMantenimientoActividadBean.obtenerProcesosDisponibles(DTOActividad dto):Entrada");
        // Busco Las Transacciones que no esten en TransaccionesPorActividad
        StringBuffer query = new StringBuffer();
        Vector vector = new Vector();

        if (dto.getOid() != null) { // si me pasan la actividad:        
            query.append(" SELECT OID_TRAN, COD_PROC FROM CRA_TRANS ")
                 .append(" WHERE OID_TRAN NOT IN ( ")
                 .append("   SELECT TRAN_OID_TRAN FROM CRA_TRANS_ACTIV ")
                 .append("   WHERE CACT_OID_ACTI = ? ) ");
            vector.add(dto.getOid());
            UtilidadesLog.info("MONMantenimientoActividadBean.obtenerProcesosDisponibles(DTOActividad dto):Salida");
            return new DTOSalida(ejecutaQuery(query.toString(), vector));
        } else { // si no me dicen que actividad es, todos.
            query.append(" SELECT OID_TRAN, COD_PROC FROM CRA_TRANS ");
            UtilidadesLog.info("MONMantenimientoActividadBean.obtenerProcesosDisponibles(DTOActividad dto):Salida");
            return new DTOSalida(ejecutaQuery(query.toString(), vector));
        }
    }

    /** Segun DMCO V3:
        Accede a la entidad Cronograma para buscar actividades en periodos
      posteriores con los datos que recibe como parámetros.
     */
    public DTOSalida obtenerActividadesPosteriores(DTOActividad dto)
        throws MareException {
        UtilidadesLog.info("MONMantenimientoActividadBean.obtenerActividadesPosteriores(DTOActividad dto):Entrada");
        Vector vector = new Vector();
        StringBuffer query = new StringBuffer(
                " SELECT * FROM CRA_CRONO WHERE 1=1 ");

        if (dto.getOid() != null) {
            query.append(" AND CACT_OID_ACTI = ? ");
            vector.add(dto.getOid());
        }

        if (dto.getFechaInicioActividad() != null) {
            query.append(" AND FECH_INIC > ? ");
            vector.add(dto.getFechaInicioActividad());
        }
        UtilidadesLog.info("MONMantenimientoActividadBean.obtenerActividadesPosteriores(DTOActividad dto):Salida");
        return new DTOSalida(ejecutaQuery(query.toString(), vector));
    }

    /** Metodo privado, para realizar consultas directo a la base por JDBC
     * @param query sentencia SQL con la consulta
     * @param argumentos valores de los parametros de la consulta
     * @return RecordSet con la respuesta a la consulta realizada */
    private RecordSet ejecutaQuery(String query, Vector argumentos)
        throws MareException {
        UtilidadesLog.info("MONMantenimientoActividadBean.ejecutaQuery(String query, Vector argumentos):Entrada");
        BelcorpService bs;

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException serviceNotFoundException) {
            UtilidadesLog.error(serviceNotFoundException);
            throw new MareException(serviceNotFoundException,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        RecordSet res;

        try {
            res = bs.dbService.executePreparedQuery(query, argumentos);
        } catch (Exception exception) {
            UtilidadesLog.error(exception);
            throw new MareException(exception,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        UtilidadesLog.info("MONMantenimientoActividadBean.ejecutaQuery(String query, Vector argumentos):Salida");

        return res;
    }

    public Date obtieneSiguienteFechaActividad(DTOActividad dtoActividad)
        throws MareException {
        UtilidadesLog.info("MONMantenimientoActividadBean.obtieneSiguienteFechaActividad(DTOActividad dtoActividad):Entrada");
        BelcorpService belcorpService;

        try {
            belcorpService = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException serviceNotFoundException) {
            UtilidadesLog.error(serviceNotFoundException);
            throw new MareException(serviceNotFoundException,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        // Consulta Cronograma con los datos de entrada.
        RecordSet crono;
        StringBuffer sqlQuery = new StringBuffer("");
        
        sqlQuery.append(" SELECT * FROM CRA_CRONO ");
        sqlQuery.append(" WHERE CACT_OID_ACTI = " + dtoActividad.getOid() );
        sqlQuery.append(" AND PERD_OID_PERI = " + dtoActividad.getOidPeriodo() );
        
        if ( dtoActividad.getOidZona() != null)
          sqlQuery.append(" AND ZZON_OID_ZONA = " + dtoActividad.getOidZona() ); 
        
        if (dtoActividad.getOidSeccion() != null) 
          sqlQuery.append(" AND ZSCC_OID_SECC = " + dtoActividad.getOidSeccion() ); 
        
        if (dtoActividad.getOidTipoFacturacion() != null)
          sqlQuery.append(" AND TIFA_OID_TIPO_FACT = " + dtoActividad.getOidTipoFacturacion() );  
        sqlQuery.append(" ORDER BY FEC_INIC ");
        
        try { 
            crono = belcorpService.dbService.executeStaticQuery(sqlQuery.toString());
        } catch (Exception exception){
            UtilidadesLog.error(exception);
            throw new MareException(exception,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        
        UtilidadesLog.debug("RecordSet crono: " + crono);
        
        if (crono.esVacio()){
            UtilidadesLog.info("MONMantenimientoActividadBean.obtieneSiguienteFechaActividad(DTOActividad dtoActividad):Salida");
            return null;
        } else {
          java.util.Date fechaHoy = new java.util.Date();
          java.sql.Date ultFecha = null;
          for (int i = 0; i < crono.getRowCount(); i++) {
            java.sql.Date fecha = (java.sql.Date)crono.getValueAt(i,5);
            if (fecha.getTime() >= fechaHoy.getTime() ){
              UtilidadesLog.info("MONMantenimientoActividadBean.obtieneSiguienteFechaActividad(DTOActividad dtoActividad):Salida");
              return fecha;
            }
              
            ultFecha = fecha;              
          }
          UtilidadesLog.info("MONMantenimientoActividadBean.obtieneSiguienteFechaActividad(DTOActividad dtoActividad):Salida");
          return ultFecha;
        }

    }

    private Date calcularSiguienteFecha(Date fecInicio, Date fecFin,
        int fecMedia, Date hoy) throws MareException {
        UtilidadesLog.info("MONMantenimientoActividadBean.calcularSiguienteFecha(Date fecInicio, Date fecFin, int fecMedia, Date hoy):Entrada");
        // Verifica Fecha Inicio
        if (!fecInicio.before(hoy)) {
            UtilidadesLog.info("MONMantenimientoActividadBean.calcularSiguienteFecha(Date fecInicio, Date fecFin, int fecMedia, Date hoy):Salida");
            return fecInicio;
        } else {
            // Verifica Fecha Fin
            if (!fecFin.after(hoy)) {
                UtilidadesLog.info("MONMantenimientoActividadBean.calcularSiguienteFecha(Date fecInicio, Date fecFin, int fecMedia, Date hoy):Salida");
                return fecFin;
            } else {
                // Obtiene la fecha de la actividad igual o superior a hoy
                Date fechaSiguiente = new Date(fecInicio.getTime() +
                        (fecMedia * 24 * 60 * 60 * 1000));

                while (fechaSiguiente.before(hoy)) {
                    fechaSiguiente = new Date(fechaSiguiente.getTime() +
                            (fecMedia * 24 * 60 * 60 * 1000));
                }

                // Verifica que la fecha encontrada no sea mayor a fecha fin
                if (fechaSiguiente.after(fecFin)) {
                    UtilidadesLog.info("MONMantenimientoActividadBean.calcularSiguienteFecha(Date fecInicio, Date fecFin, int fecMedia, Date hoy):Salida");
                    return fecFin;
                } else {
                    UtilidadesLog.info("MONMantenimientoActividadBean.calcularSiguienteFecha(Date fecInicio, Date fecFin, int fecMedia, Date hoy):Salida");                
                    return fechaSiguiente;
                }
            }
        }

    }

    private Date obtieneSiguienteLaborable(Date date, Long oidActividad) throws MareException {
        UtilidadesLog.info("MONMantenimientoActividadBean.obtieneSiguienteLaborable(Date date, Long oidActividad):Entrada");
        Date fechaLaborable = null;

        BelcorpService belcorpService;

        try {
            belcorpService = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException serviceNotFoundException) {
            UtilidadesLog.error(serviceNotFoundException);
            throw new MareException(serviceNotFoundException,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        Date fecha = date;
        Date proximoDia = null;
        String proximoDiaStr = null;
        String anioStr = null;

        RecordSet feriado = new RecordSet();

        while (fechaLaborable == null) {
            proximoDia = new Date(fecha.getTime() + (24 * 60 * 60 * 1000));
            proximoDiaStr = UtilidadesBelcorp.fechaFormateada(proximoDia,
                    "dd/mm/yyyy");
            anioStr = proximoDiaStr.substring(6);

            // Consulta si la fecha es laborable             
            try {
                StringBuffer query = new StringBuffer();
                query.append(" SELECT OID_FERI ").append(" FROM CRA_FERIA ")
                     .append(" WHERE CACT_OID_ACTI = '" + oidActividad + "' ")
                     .append(" AND FEC_FERI = '" + proximoDiaStr + "' ").append(" AND NUM_ANIO = '" +
                    anioStr + "' ");

                feriado = belcorpService.dbService.executeStaticQuery(query.toString());
            } catch (Exception exception) {
                UtilidadesLog.error(exception);
                throw new MareException(exception,
                    UtilidadesError.armarCodigoError(
                        CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
            }

            if (feriado.esVacio()) {
                fechaLaborable = proximoDia;
            } else {
                fecha = proximoDia;
            }
        }
        UtilidadesLog.info("MONMantenimientoActividadBean.obtieneSiguienteLaborable(Date date, Long oidActividad):Salida");
        return fechaLaborable;
    }

    private int cantidadDeFeriados(Date fechaInicio, Date fechaFin, Long oidActividad) throws MareException {
        UtilidadesLog.info("MONMantenimientoActividadBean.cantidadDeFeriados(Date fechaInicio, Date fechaFin,Long oidActividad):Entrada");
        BelcorpService belcorpService;

        try {
            belcorpService = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException serviceNotFoundException) {
            UtilidadesLog.error(serviceNotFoundException);
            throw new MareException(serviceNotFoundException,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        RecordSet feriado = new RecordSet();

        String fechaInicioStr = UtilidadesBelcorp.fechaFormateada(fechaInicio,
                "dd/mm/yyyy");
        String fechaInicioAnioStr = fechaInicioStr.substring(6);

        String fechaFinStr = UtilidadesBelcorp.fechaFormateada(fechaFin,
                "dd/mm/yyyy");
        String fechaFinAnioStr = fechaFinStr.substring(6);

        // Consulta los feriados
        try {
            StringBuffer query = new StringBuffer();
            query.append(" SELECT 1 ").append(" FROM CRA_FERIA ")
                 .append(" WHERE CACT_OID_ACTI = '" + oidActividad + "' ")
                 .append(" AND FEC_FERI BETWEEN '" + fechaInicioStr +
                "' AND '" + fechaFinStr + "' ")
                 .append(" AND NUM_ANIO BETWEEN '" + fechaInicioAnioStr +
                "' AND '" + fechaFinAnioStr + "' ").append(" AND IND_FEST = 1 ");

            feriado = belcorpService.dbService.executeStaticQuery(query.toString());
        } catch (Exception exception) {
            UtilidadesLog.error(exception);
            throw new MareException(exception,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        UtilidadesLog.info("MONMantenimientoActividadBean.cantidadDeFeriados(Date fechaInicio, Date fechaFin,Long oidActividad):Salida");
        return feriado.getRowCount();
    }

    private Boolean esFestivo(Date date, Long oidActividad) throws MareException {
        UtilidadesLog.info("MONMantenimientoActividadBean.esFestivo(Date date, Long oidActividad):Entrada");
        BelcorpService belcorpService;

        try {
            belcorpService = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException serviceNotFoundException) {
            UtilidadesLog.error(serviceNotFoundException);
            throw new MareException(serviceNotFoundException,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        String diaStr = null;
        String anioStr = null;

        RecordSet feriado = new RecordSet();

        diaStr = UtilidadesBelcorp.fechaFormateada(date, "dd/mm/yyyy");
        anioStr = diaStr.substring(6);

        // Consulta si la fecha es feriado             
        try {
            StringBuffer query = new StringBuffer();
            query.append(" SELECT OID_FERI ").append(" FROM CRA_FERIA ")
                 .append(" WHERE CACT_OID_ACTI = '" + oidActividad + "' ")
                 .append(" AND FEC_FERI = '" + diaStr + "' ")
                 .append(" AND NUM_ANIO = '" + anioStr + "' ").append(" AND IND_FEST = 1 ");

            feriado = belcorpService.dbService.executeStaticQuery(query.toString());
        } catch (Exception exception) {
            UtilidadesLog.error(exception);
            throw new MareException(exception,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        if (feriado.esVacio()) {
            UtilidadesLog.info("MONMantenimientoActividadBean.esFestivo(Date date, Long oidActividad):Salida");
            return Boolean.FALSE;
        } else {
            UtilidadesLog.info("MONMantenimientoActividadBean.esFestivo(Date date, Long oidActividad):Salida");
            return Boolean.TRUE;
        }
    }

    private Date obtenerFechaSinHora(Date fecha) throws MareException {
        UtilidadesLog.info("MONMantenimientoActividadBean.obtenerFechaSinHora(Date fecha):Entrada");
        Date fechaSinHora = null;

        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy.MM.dd");
            String fechaString = formatter.format(fecha);

            fechaSinHora = formatter.parse(fechaString);
        } catch (ParseException pe) {
            UtilidadesLog.error(pe);
            throw new MareException(pe,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_FORMATO_FECHA));
        }
        UtilidadesLog.info("MONMantenimientoActividadBean.obtenerFechaSinHora(Date fecha):Salida");
        return fechaSinHora;
    }


    /**
    * Envia mensajes zona por zona.
    */
    public void enviaMensajes(ArrayList mensajes) throws MareException {
        UtilidadesLog.info("MONMantenimientoActividadBean.enviaMensajes(ArrayList mensajes):Entrada");
        DTOMensajes dtoMensajes;
        Iterator iter = mensajes.iterator();
        while(iter.hasNext()) {
            dtoMensajes = (DTOMensajes) iter.next();
            this.enviaMensajes(dtoMensajes);
        }
        UtilidadesLog.info("MONMantenimientoActividadBean.enviaMensajes(ArrayList mensajes):Salida");
    }


    /**
     * Emvia mensaje para una zona determinada
     * 
     * Proceso: 
    1.- IServiceUnidadesAdministrativas.obtenerGerente y se rellena el DTOUnidadAdministrativa con el oidZona = dto.oidZona. 
    - Devuelve el oid del Gerente de Zona que llamaremos GERENTEZONA. 
    
    Si GERENTEZONA != null continua con a partir del punto (9) sino se finaliza el metodo.
    
    2.- Seleccionar de CRA_ACTIV los registros que cumplan: 
    - departamento.pais = dto.oidPais (seleccionar todos los departamentos de ese pais relacionados con la actividad) 
    - marca = dto.oidMarca 
    - canal = dto.oidCanal 
    - ebelNoticias = True 
    - accesoAcceso = NULL 
    Se obtienen n actividades con todos sus campos ACTi. 
    
    3.- Para cada actividad ACTi hallada se realiza: 
    
    3.a.- Con dto.oidPeriodo ("periodo que inicia") y n (ACTi.campanyasAntelacion) tenemos que obtener el oidPeriodo (de la tabla CRA_PERIO) n veces posterior al periodo que inicia. Un periodo es n veces posterior a otro si ordenando crecientemente por fecha inicio y para el mismo Pais, Marca, Canal y Acceso es el n-ésimo registro encontrado. 
    Esta consulta podrá devolver o no un oidPeriodo; en caso de que no devuelva nada se tomará como oidPeriodo el del parámetro 
    dto.oidPeriodo. El oid obtenido lo llamamos PERIODO. 
    
    3.b. Se llama al método obtieneSiguienteFechaActividad pasándole como datos el DTOActividad relleno con lo siguiente: 
    - oidMarca = dto.oidMarca 
    - oidPais = dto.oidPais 
    - oidCanal = dto.oidCanal 
    - oidPeriodo = PERIODO 
    - oid = ACTi.oid 
    Se obtiene FECHA_ACTIVIDAD 
    
    3.c. Llamar a IServiceUnidadesAdministrativas.obtenerTerritoriosAdministrativos con un DTOUnidadAdministrativa relleno con: 
    - oidZona = dto.oidZona 
    - oidSeccion = dto.oidSeccion 
    Devuelve un RecordSet con n territorios. El primer campo es el oid del territorio. Se cogen todos los oids y haremos el Long[] TERRITORIOS. 
    
    3.d. Llamar a IMaestroClientes.obtenerConsultorasTerritorios con el array de oids TERRITORIOS 
    Devuelve n oids de consultoras que llamaremos CONSj 
    
    3.e. Se llama a la interfaz de MAE IMaestroClientes.obtenerDireccionCliente con: 
    - oidCliente = GERENTEZONA 
    - oidTipoDireccion = ACTi.tipoDireccion 
    
    Si no devuelve ninguna dirección sale del método 
    Si devuelve muchas direcciones coge como DIRECCION la primera del array DTODireccion devuelto 
    
    3.f. Para cada consultora CONSj: 
    3.f.1.- se llama a la interfaz de MSG IMSG.insertaDatosMensaje con los datos: 
    - pais: oidPais 
    - Código de mensaje: "CRA01". 
    - Código de Cliente: CONSj (código de la consultora). 
    - Módulo de origen = "CRA" 
    - CRA0102 - SGV: dto.oidSubgerencia 
    - CRA0103 - Región: dto.oidRegion 
    - CRA0104 - Zona: dto.oidZona 
    - CRA0105 - Sección: dto.oidSeccion 
    - CRA0105 - Período: PERIODO 
    - CRA0106 - Actividad: ACTi.oid, SOLO si ACTi.ebelNoticias es True. 
    - CRA0107 - Descripción de la actividad: ACTi.nombre 
    - CRA0108 - Fecha Calendario: FECHA_ACTIVIDAD 
    - CRA0109 - Direccion del Gerente: DIRECCION 
    
    Devuelve NUMMENSA y FECHA 
    
    3.f.2.- Haciendo uso del EJBEntity MensajesCRA se guarda un nuevo mensaje (método create) con los siguientes datos.: 
    - consultora = CONSj 
    - periodo = PERIODO 
    - actividad = ACTi.oid, SOLO si ACTi.ebelNoticias es True. 
    - seccion = dto.oidSeccion 
    - numMensaje = NUMMENSA 
    - fecha FECHA 
    - zona = dto.oidZona 
    *
    * @cambio mejoras por performance
    * @detalle se obtiene solo una vez el codigo de pais.
    * @detalle se obtiene solo una vez el codigo de periodo.
    * @detalle se obtiene de manera conjunta los codigos y descripciones de zona, region y subgerencia.
    * @detalle se obtiene solo una vez las actividades ebel noticias.
    * @fecha 15/12/2006 in situ
    * @autor gdmarzi
    * 
    * @pendiente aplicar performance a partir del proceso 3 luego de obtener las actividades ebel noticias.
    * 
    **/ 
    private void enviaMensajes(DTOMensajes dtoMensajes) throws MareException {
        UtilidadesLog.info("MONMantenimientoActividadBean.enviaMensajes(DTOMensajes dtoMensajes):Entrada");
        BelcorpService belcorpService;
        RecordSet territorios = null;
        RecordSet rsCodigoDescZon;
        Long periodo = null;
        Long gerenteZona = null;
        Long[] consultoras = null;
        Date fechaActividad = null;
        String horaActividad = null;
        MONClientes monC = null;
        MONGestionMensajes monGM = null;

        try {
            belcorpService = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException serviceNotFoundException) {
            UtilidadesLog.error(serviceNotFoundException);
            throw new MareException(serviceNotFoundException,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        try {
            monC = getMONClientesHome().create();
            monGM = getMONGestionarMensajesHome().create();
        } catch (RemoteException e) {
            UtilidadesLog.debug(e);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch (CreateException e) {
            UtilidadesLog.debug(e);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }

        /**
         * Proceso 1
         */
        //Llamar al metodo de zon obtenerTerritoriosAdministrativos
        MONUnidadesAdministrativas monUA = null;
        DTOUnidadAdministrativa dtoUA = new DTOUnidadAdministrativa();
        try {
            dtoUA.setOidZona(dtoMensajes.getOidZona());
            monUA = getMONUnidadesAdministrativasHome().create();

            gerenteZona = monUA.obtenerGerenteUniAdm(dtoUA);
        } catch (RemoteException e) {
            UtilidadesLog.error(e);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch (CreateException e) {
            UtilidadesLog.error(e);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch (MareException me){
            if(me.getCode() == Integer.parseInt(es.indra.sicc.logicanegocio.zon.ErroresDeNegocio.UNIDAD_ADMINISTRATVA_SIN_GERENTE)){
                UtilidadesLog.info("La zona " + dtoMensajes.getOidZona() + " no tiene gerente asignado.");
            }
        }
        
        // Incidencia 12004. Si GERENTEZONA != null sigue con el proceso de enviarMensage sino finaliza el metodo.
        if (gerenteZona == null) {
            UtilidadesLog.error("La zona " + dtoMensajes.getOidZona() + " no tiene gerente asignado.");
            UtilidadesLog.info("MONMantenimientoActividadBean.enviaMensajes():Salida Dos");
            return; 
        }
        UtilidadesLog.debug("El gerente es:" + gerenteZona);

        //Obtenemos solo una vez el codigo de pais
        if (codigoPais == null) {
            codigoPais = this.obtenerCodigoPais(dtoMensajes.getOidPais());
            UtilidadesLog.warn("codigoPais:" + codigoPais);
        }
        
        // Obtenemos las descripciones y codigos de: zona, region y subgerenciaVentas de una sola vez.
        rsCodigoDescZon = this.obtenerCodigosDescripcionesZonificacion(dtoMensajes.getOidZona());
        String codigoSubgerencia = rsCodigoDescZon.getValueAt(0, "COD_SUBG_VENT").toString();
        String descSubgerencia = rsCodigoDescZon.getValueAt(0, "DES_SUBG_VENT").toString();
        String codigoRegion = rsCodigoDescZon.getValueAt(0, "COD_REGI").toString();
        String descRegion = rsCodigoDescZon.getValueAt(0, "DES_REGI").toString();
        String codigoZona = rsCodigoDescZon.getValueAt(0, "COD_ZONA").toString();
        String descZona = rsCodigoDescZon.getValueAt(0, "DES_ZONA").toString();
        // Incidencia 22372: Se decidio pasar los parametros de oidSeccion en NULL Paola Cabrera 10/01/2006

        // Obtenemos solo una vez el codigo de periodo
        if (codigoPeriodo == null) {
            codigoPeriodo = this.obtenerCodigoPeriodo(dtoMensajes.getOidPeriodo());
            UtilidadesLog.warn("codigoPeriodo: " + codigoPeriodo);
        }

        /**
         * Proceso 2
         */
        // Obtiene las actividades con ebel noticias ativado.
        if (actividadesEbelNoticias == null) {
            actividadesEbelNoticias = this.obtenerActividadesEbelNoticias(dtoMensajes);
            UtilidadesLog.warn("actividades ebel noticias " + actividadesEbelNoticias.getRowCount());
        }

        /**
         * Proceso 3
         */
          for (int i = 0; i < actividadesEbelNoticias.getRowCount(); i++) {
          
              try {
                  /****************************************************************************
                                          * Proceso 3.a*
                   * **************************************************************************/
                  //Obtener Periodo Posterior
                  StringBuffer sql = new StringBuffer();
                  
    
                  sql.append(" select c.*");
                  sql.append(" FROM CRA_PERIO c ");
                  sql.append( "WHERE 1 = 1 ");
                  
                  //---------------------------------
                
                  if( dtoMensajes.getOidCanal() != null ){
                    sql.append(" and C.CANA_OID_CANA = '" + dtoMensajes.getOidCanal() + "' ");
                  }
                  if( dtoMensajes.getOidMarca() != null ){
                    sql.append(" and C.MARC_OID_MARC = '" + dtoMensajes.getOidMarca() + "' ");
                  }

                  if( dtoMensajes.getOidPais() != null ){
                    sql.append(" and C.PAIS_OID_PAIS = '" + dtoMensajes.getOidPais() + "' ");
                  }

                  sql.append(" and C.FEC_INIC <= (select FEC_INIC from CRA_PERIO where ");

                  if( dtoMensajes.getOidPeriodo() != null ){
                    sql.append(" OID_PERI = '" + dtoMensajes.getOidPeriodo() +
                        "' ) order by C.FEC_INIC desc");
                  }
                  RecordSet periodos = belcorpService.dbService.executeStaticQuery(sql.toString());
                  
                  int n = ((actividadesEbelNoticias.getValueAt(i, "NUM_CAMP_ANTE") == null)
                      ? 0
                      : ((BigDecimal) actividadesEbelNoticias.getValueAt(i, "NUM_CAMP_ANTE")).intValue());
                  UtilidadesLog.debug("[MONMantenimientoActividad.enviarMensaje] valor de n:" + n );
                  if (periodos == null || periodos.esVacio() || (periodos.getRowCount() < (n + 1))) {
                      periodo = dtoMensajes.getOidPeriodo();
                  } else {
                      periodo = ( periodos.getValueAt((n), "OID_PERI")==null ? null : 
                        new Long(((BigDecimal) periodos.getValueAt((n), "OID_PERI")).longValue()) );
                  }
                  UtilidadesLog.debug("[MONMantenimientoActividad.enviarMensaje] valor de periodo:" + periodo );
                  /****************************************************************************
                                          * Proceso 3.b*
                   * **************************************************************************/
                  //Llamo Al metodo obtener seguiente actividad
                  DTOActividad dtoActividad = new DTOActividad();
                  dtoActividad.setOidMarca(dtoMensajes.getOidMarca());
                  dtoActividad.setOidPais(dtoMensajes.getOidPais());
                  dtoActividad.setOidCanal(dtoMensajes.getOidCanal());
                  dtoActividad.setOidPeriodo(periodo);
                  dtoActividad.setOidZona(dtoMensajes.getOidZona());
                 
                 /*
                  Se modifica por inc 21989
                  --Paola Cabrera*/
                  dtoActividad.setOid( (actividadesEbelNoticias.getValueAt(i, "OID_ACTI")==null ? null : 
                    new Long(((BigDecimal) actividadesEbelNoticias.getValueAt(i, "OID_ACTI")).longValue())));
                  
                  fechaActividad = this.obtieneSiguienteFechaActividad(dtoActividad);
                  UtilidadesLog.debug("[MONMantenimientoActividad.enviarMensaje] fechaActividad" + fechaActividad ); 
                  //Cleal CRA-03
                  if(fechaActividad==null){
                    break;
                  }
                  //--se agrega por inc 21989
                  //--Pcabrera
                  
                  String formatoFecha = "yyyy-MM-dd";                          
                  SimpleDateFormat fecha = new SimpleDateFormat(formatoFecha);      
                  String fechaF = fecha.format(fechaActividad);
                  
                  horaActividad = this.obtieneSiguienteHoraActividad(dtoActividad); 
                  
                  //-----------------------------
                  
                  
                  /****************************************************************************
                                          * Proceso 3.c*
                   * **************************************************************************/
                  // LLamar al metodo de zon obtenerTerritoriosAdministrativos
                  dtoUA = new es.indra.sicc.dtos.zon.DTOUnidadAdministrativa();
                  dtoUA.setOidZona(dtoMensajes.getOidZona());
                  dtoUA.setOidSeccion(dtoMensajes.getOidSeccion());

                  territorios = monUA.obtenerTerritoriosAdministrativos(dtoUA);
                  Vector vec = null;
                  Enumeration enumer = null;
                  Long[] oidTerritorios = null;

                  if( territorios != null && !territorios.esVacio() ){
                    vec = territorios.getColumn(0);
                    enumer = vec.elements();
                    oidTerritorios = new Long[vec.size()];
                    int x=0;
                    while(enumer.hasMoreElements()){
                        oidTerritorios[x]=(Long)bigDecimalToLong((BigDecimal)enumer.nextElement());
                        UtilidadesLog.debug("[MONMantenimientoActividad.enviarMensaje] oidTerritorios["+ x +"] =" + oidTerritorios[x] );
                        x++;
                    }
                  }
                  
                  /****************************************************************************
                                          * Proceso 3.d*
                   * **************************************************************************/
                   //Llamar a IMaestroClientes.obtenerConsultorasTerritorios con el array de oids TERRITORIOS
                  consultoras = monC.obtenerConsultorasTerritorios(oidTerritorios);
                  UtilidadesLog.debug("[MONMantenimientoActividad.enviarMensaje] obtuvo Consultoras"  );                      
                  /****************************************************************************
                                          * Proceso 3.e*
                   * **************************************************************************/
                  //Se llama a la interfaz de MAE IMaestroClientes.obtenerDireccionCliente
                  DTODireccion[] dtosConsultora = null;

                  BigDecimal bdTipoActividad = null;
                  bdTipoActividad = (BigDecimal)actividadesEbelNoticias.getValueAt(i,"TIDC_OID_TIPO_DIRE");
                  UtilidadesLog.debug("[MONMantenimientoActividad.enviarMensaje] bdTipoActividad = " + bdTipoActividad );  

                  /**    
                   *@Author: pperez 
                   *@Fecha: 28/10/2005
                   *@Observaciones: Cambio generado araiz de incidencia bloqueante Perú. Ref: 21299
                  */ 
                  dtosConsultora = monC.obtenerDireccionesPorTipo( gerenteZona, 
                    ( bdTipoActividad == null ? null : bigDecimalToLong( bdTipoActividad ) ), dtoMensajes.getOidIdioma() );
                
                  if ( dtosConsultora == null || dtosConsultora.length == 0 ) {
                      UtilidadesLog.debug("[MONMantenimientoActividad.enviarMensaje] dtosConsultora es nulo o cero ");  
                  } else {
                      /****************************************************************************
                                              * Proceso 3.f*
                       * **************************************************************************/
                      //Recorro las consultoras
                      UtilidadesLog.debug("[MONMantenimientoActividad.enviarMensaje] consultoras.length = " + consultoras.length );  
                      for (int j = 0; j < consultoras.length; j++) {
                          /****************************************************************************
                                                      * Proceso 3.f.1*
                          * **************************************************************************/
                          //Inserto de Buzon Mensaje
                          DTOBuzonMensajes dtoBuzonMensaje = new DTOBuzonMensajes();
                          dtoBuzonMensaje.setOidPais(dtoMensajes.getOidPais());
                          dtoBuzonMensaje.setCodigoMensaje("CRA01");
                          dtoBuzonMensaje.setOidCliente(consultoras[j]);
    
    
                          //--Se agrega por inc 21989
                          //-- Pcabrera                          
                          String dato = null;                             
                          //-----------------                        
                          
                          
                          //dtoBuzonMensaje.setModuloOrigen("CRA");
                          //como el campo es numerico busco el codigo de CRA en 
                          //en CodigosModulos (mmaidana)
                          dtoBuzonMensaje.setModuloOrigen( new Long( ConstantesSEG.MODULO_CRA ) );
                                              
                         dtoBuzonMensaje.setDatoVariable1(codigoPais);
                         dtoBuzonMensaje.setDatoVariable2(codigoSubgerencia + " " + descSubgerencia ); 
                         dtoBuzonMensaje.setDatoVariable3(codigoRegion + " " + descRegion );
                         dtoBuzonMensaje.setDatoVariable4(codigoZona + " " + descZona );
                     
                         //mdolce 15/06/2006 Se modifico, se debe guardar el codigo de actividad y no el OID
                         String codActi  = (String)actividadesEbelNoticias.getValueAt(i, "COD_ACTI");
                         if(codActi != null){
                            dtoBuzonMensaje.setDatoVariable6(codActi);
                         }
    
                         //setDatoVariable7
                         //mdolce 15/06/2006 Se modifico, se debe guardar la descripcion de 
                         //la actividad y NO la descripcion de la clase de actividad
                         String descActi  = (String)actividadesEbelNoticias.getValueAt(i, "DESCRI");
                         if(descActi != null){
                            dtoBuzonMensaje.setDatoVariable7(descActi);
                         }
                                                  
                         dtoBuzonMensaje.setDatoVariable8(fechaF);
    
                            UtilidadesLog.info("*** dtosConsultora[0]: "+dtosConsultora[0].toString());
                            String obser = dtosConsultora[0].getObservaciones();
                            
                            dato = dtosConsultora[0].getTipoDireccionDescripcion() + " " +
                            dtosConsultora[0].getTipoViaDescripcion() + " " +
                            dtosConsultora[0].getNombreVia() + " " +
                            dtosConsultora[0].getNumeroPrincipal() + " " +
                            dtosConsultora[0].getCodigoPostal() + " " +
                            dtosConsultora[0].getNombreUnidadGeografica();
                            if(obser!=null){
                                dato = dato+ " "+obser;
                            }
                            UtilidadesLog.info("*** Direccion: "+dato);
                            
                         dtoBuzonMensaje.setDatoVariable9( dato );
                          
                         UtilidadesLog.debug("[MONMantenimientoActividad.enviarMensaje] listo todos los datos variables" );  
                          //Obtener hora
                         
                         dtoBuzonMensaje.setDatoVariable10( horaActividad );
                         dtoBuzonMensaje.setDatoVariable11(codigoPeriodo);   
                          
                         UtilidadesLog.debug("[MONMantenimientoActividad.enviarMensaje] monGM.insertaDatosMensaje(dtoBuzonMensaje)" );  
                         DTOBuzonMensajes dtoBMResultado = monGM.insertaDatosMensaje(dtoBuzonMensaje);
    
                         /****************************************************************************
                                                      * Proceso 3.f.2*
                         ***************************************************************************/
                          //Inserto en mensajeCra
                          UtilidadesLog.debug("consultoras[j] = " + consultoras[j] ); 
                          UtilidadesLog.debug("dtoMensajes.getOidZona(), = " + dtoMensajes.getOidZona() );
                          UtilidadesLog.debug("dtoBMResultado.getNumeroSecuencial() = " + dtoBMResultado.getNumeroSecuencial() );
                          UtilidadesLog.debug("dtoMensajes.getOidPeriodo() = " + dtoMensajes.getOidPeriodo());
                          //Cleal - 22463
                          MensajesCRALocalHome craLH = new  MensajesCRALocalHome();
                          craLH.create(consultoras[j],
                                  dtoMensajes.getOidZona(),
                                  dtoBMResultado.getNumeroSecuencial(),
                                  new java.sql.Date(dtoBMResultado.getFechaGrabacion().getTime()),
                                  new Long(((BigDecimal) actividadesEbelNoticias.getValueAt(i,
                                          "OID_ACTI")).longValue()), dtoMensajes.getOidPeriodo());
                      }
                  }

              } catch (PersistenceException pe) {
                      UtilidadesLog.debug(pe);
                      pe.printStackTrace();
                      throw new MareException(pe,
                              UtilidadesError.armarCodigoError(
                                      CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
              } catch (CreateException e) {
                  e.printStackTrace();
                  UtilidadesLog.error(e);
                  ctx.setRollbackOnly();
                  throw new MareException(e,
                      UtilidadesError.armarCodigoError(
                          CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
              } catch (Exception e) {
                  e.printStackTrace();
                  UtilidadesLog.error(e);
                  ctx.setRollbackOnly();
                  throw new MareException(e,
                      UtilidadesError.armarCodigoError(
                          CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
              }
              
          }
        UtilidadesLog.info("MONMantenimientoActividadBean.enviaMensajes(DTOMensajes dtoMensajes):Salida");
    }


    /**
    * Obtiene el codigo del pais.
    */
    private String obtenerCodigoPais(Long oidPais) throws MareException{
        UtilidadesLog.info("MONMantenimientoActividadBean.obtenerCodigoPais():Entrada");
        BelcorpService belcorpService;
        RecordSet rsCodigoPais;
        String codigoPais;

        //---Se agrega por incidencia 21989, Pcabrera  29/12/2005
        RecuperadorIdiomaDefectoServidor recuperadorIdioma = new RecuperadorIdiomaDefectoServidor(); 
        Long idiomaPorDefecto = recuperadorIdioma.getIdiomaDefectoServidor(); 
        UtilidadesLog.debug("idiomaPorDefecto = "+idiomaPorDefecto); 
        try {
            belcorpService = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException serviceNotFoundException) {
            UtilidadesLog.error(serviceNotFoundException);
            throw new MareException(serviceNotFoundException,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        StringBuffer sql1= new StringBuffer(" SELECT v.val_i18n ");
        sql1.append(" FROM seg_pais seg, v_gen_i18n_sicc v ");
        sql1.append(" WHERE seg.oid_pais = v.val_oid ");
        sql1.append(" AND v.attr_enti = 'SEG_PAIS' ");
        sql1.append(" AND v.idio_oid_idio = " + idiomaPorDefecto); 
        sql1.append(" AND v.attr_num_atri = 1 ");
        sql1.append(" AND v.val_oid = "  + oidPais);
                          
        try {
            rsCodigoPais = belcorpService.dbService.executeStaticQuery(sql1.toString());
        } catch (Exception e) {
            UtilidadesLog.error(e);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        codigoPais = rsCodigoPais.getValueAt(0, "VAL_I18N").toString();
        UtilidadesLog.info("MONMantenimientoActividadBean.obtenerCodigoPais():Salida");
        return codigoPais;
    }


    /**
    * Obtiene el codigo del periodo.
    */
    private String obtenerCodigoPeriodo(Long oidPeriodo) throws MareException{
        UtilidadesLog.info("MONMantenimientoActividadBean.obtenerCodigoPeriodo():Entrada");
        BelcorpService belcorpService;
        RecordSet rsCodigoPeriodo;
        String codigoPeriodo;

        try {
            belcorpService = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException serviceNotFoundException) {
            UtilidadesLog.error(serviceNotFoundException);
            throw new MareException(serviceNotFoundException,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        StringBuffer sql6 = new StringBuffer(" SELECT  per.VAL_NOMB_PERI ");
        sql6.append(" FROM CRA_PERIO per ");
        sql6.append(" WHERE per.OID_PERI = " + oidPeriodo);
                         
        try {
            rsCodigoPeriodo = belcorpService.dbService.executeStaticQuery(sql6.toString());
        } catch (Exception e) {
            UtilidadesLog.error(e);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        codigoPeriodo = rsCodigoPeriodo.getValueAt(0, "VAL_NOMB_PERI").toString();

        UtilidadesLog.info("MONMantenimientoActividadBean.obtenerCodigoPeriodo():Salida");
        return codigoPeriodo;
    }


    /**
    * Obtiene las descripciones mas los codigos de zona, region y subgerenciaVentas de una sola vez.
    * @autor gdmarzi
    */
    private RecordSet obtenerCodigosDescripcionesZonificacion(Long oidZona) throws MareException {
        UtilidadesLog.info("MONMantenimientoActividadBean.obtenerCodigosDescripcionesZonificacion():Entrada");
        BelcorpService belcorpService;
        RecordSet rsCodigosDescripcionesZonificacion;
        StringBuffer sql = new StringBuffer();
        
        try {
            belcorpService = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException serviceNotFoundException) {
            UtilidadesLog.error(serviceNotFoundException);
            throw new MareException(serviceNotFoundException,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        sql.append(" SELECT ");
        sql.append("   ZONA.COD_ZONA, ZONA.DES_ZONA, ");
        sql.append("   REGION.COD_REGI, REGION.DES_REGI, ");
        sql.append("   SGV.COD_SUBG_VENT, SGV.DES_SUBG_VENT ");
        sql.append(" FROM ");
        sql.append("   ZON_ZONA ZONA, ZON_REGIO REGION, ZON_SUB_GEREN_VENTA SGV ");
        sql.append(" WHERE ");
        sql.append("   ZONA.OID_ZONA = " + oidZona);
        sql.append("   AND ZONA.ZORG_OID_REGI = REGION.OID_REGI ");
        sql.append("   AND REGION.ZSGV_OID_SUBG_VENT = SGV.OID_SUBG_VENT ");
                         
        try {
            rsCodigosDescripcionesZonificacion = belcorpService.dbService.executeStaticQuery(sql.toString());
        } catch (Exception e) {
            UtilidadesLog.error(e);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        UtilidadesLog.info("MONMantenimientoActividadBean.obtenerCodigosDescripcionesZonificacion():Salida");
        return rsCodigosDescripcionesZonificacion;
    }



    /**
    *  Obtiene las actividades con ebel noticias ativado.
    */
    private RecordSet obtenerActividadesEbelNoticias(DTOMensajes dtoMensajes) throws MareException {
        UtilidadesLog.info("MONMantenimientoActividadBean.obtenerActividadesEbelNoticias():Entrada");
        RecordSet actividades;
        StringBuffer sql = new StringBuffer();
        BelcorpService belcorpService;
        try {
            belcorpService = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException serviceNotFoundException) {
            UtilidadesLog.error(serviceNotFoundException);
            throw new MareException(serviceNotFoundException,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        sql.append(" select C.* , act.DES_CLAS_ACTI, act.OID_CLAS_ACTI, descripcion.VAL_I18N descri ");
        sql.append(" from cra_activ C,  CRA_CLASE_ACTIV act, seg_depto_empre S, gen_i18n_sicc_comun descripcion ");
        sql.append(" where C.PAIS_OID_PAIS = " + dtoMensajes.getOidPais());      
        sql.append(" and C.DPTE_OID_DEPA = S.OID_DEPA ");
        sql.append(" and c.OID_ACTI = descripcion.VAL_OID ");
        sql.append(" and descripcion.ATTR_NUM_ATRI = 1 ");
        sql.append(" and descripcion.IDIO_OID_IDIO = " + dtoMensajes.getOidIdioma());
        sql.append(" and descripcion.ATTR_ENTI = 'CRA_ACTIV' ");
        if( dtoMensajes.getOidMarca() != null ){
          sql.append(" and C.MARC_OID_MARC = '" + dtoMensajes.getOidMarca() +"' ");
        }
        if( dtoMensajes.getOidCanal() != null ){
          sql.append(" and C.CANA_OID_CANA = '" + dtoMensajes.getOidCanal() +"' ");
        }
        sql.append(" and C.IND_EBEL = 1 ");
        sql.append(" and C.ACCE_OID_ACCE is null ");
        sql.append(" and c.CLAC_OID_CLAS_ACTI = act.OID_CLAS_ACTI ");

        try {
            actividades = belcorpService.dbService.executeStaticQuery(sql.toString());
        } catch (Exception e) {
            UtilidadesLog.error(e);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        UtilidadesLog.info("MONMantenimientoActividadBean.obtenerActividadesEbelNoticias():Salida");
        return actividades;
    }

    private Long bigDecimalToLong(BigDecimal valor){
        if (valor==null)
            return null;
        return new Long(valor.longValue());
    }

    private Vector obtenerReferenciadas(DTOActividad actividad)
        throws MareException {
        UtilidadesLog.info("MONMantenimientoActividadBean.obtenerReferenciadas(DTOActividad actividad):Entrada");
        BelcorpService belcorpService;
        RecordSet respuesta;

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
            query.append(" select SYS_CONNECT_BY_PATH(OID_ACTI, '|') CADENA ");
            query.append(" from CRA_ACTIV where  ");
            query.append(" oid_acti = '" + actividad.getOidActividadOrigen() +
                "' ");
            query.append(" start with ");
            query.append(" cact_oid_acti is null ");
            query.append(" connect by ");
            query.append(" prior oid_acti = cact_oid_acti");

            respuesta = belcorpService.dbService.executeStaticQuery(query.toString());
        } catch (Exception exception) {
            UtilidadesLog.error(exception);
            throw new MareException(exception,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        Vector resultado = new Vector();

        if (!respuesta.esVacio()) {
            String cadena = (String) respuesta.getColumn(0).get(0);
            StringTokenizer st = new StringTokenizer(cadena);

            while (st.hasMoreTokens()) {
                resultado.add(st.nextToken("|"));
            }
        }
        UtilidadesLog.info("MONMantenimientoActividadBean.obtenerReferenciadas(DTOActividad actividad):Salida");
        return resultado;
    }

    /** Responde verdadero si el DTO de entrada originaría ciclos */
    private boolean originaCiclo(DTOActividad actividad) throws MareException {
        UtilidadesLog.info("MONMantenimientoActividadBean.originaCiclo(DTOActividad actividad):Entrada");
        Vector referenciadas = this.obtenerReferenciadas(actividad);
        UtilidadesLog.debug("REFERENCIADAS:" + referenciadas); 
        UtilidadesLog.info("MONMantenimientoActividadBean.originaCiclo(DTOActividad actividad):Salida");
        return referenciadas.contains(actividad.getOidActividadOrigen());
    }


    private MONUnidadesAdministrativasHome getMONUnidadesAdministrativasHome() throws MareException {
        MONUnidadesAdministrativasHome mONUnidadesAdministrativasHome = null;
        BelcorpService belcorpService = null;

        try {
            belcorpService = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException serviceNotFoundException) {
            UtilidadesLog.error(serviceNotFoundException);
            ctx.setRollbackOnly();
            throw new MareException(serviceNotFoundException,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        try {
            mONUnidadesAdministrativasHome = (MONUnidadesAdministrativasHome) belcorpService.ejbLocator.getHome(
                    "java:comp/env/MONUnidadesAdministrativas",MONUnidadesAdministrativasHome.class);
        } catch (MareServiceException mareServiceException) {
            ctx.setRollbackOnly();
            throw new MareException(mareServiceException,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }

        return mONUnidadesAdministrativasHome;
    }


    private MONClientesHome getMONClientesHome() throws MareException {
        MONClientesHome mONClientesHome = null;
        BelcorpService belcorpService = null;

        try {
            belcorpService = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException serviceNotFoundException) {
            ctx.setRollbackOnly();
            throw new MareException(serviceNotFoundException,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        try {
            mONClientesHome = (MONClientesHome) belcorpService.ejbLocator.getHome(
                    "java:comp/env/MONClientes",MONClientesHome.class);
        } catch (MareServiceException mareServiceException) {
            ctx.setRollbackOnly();
            throw new MareException(mareServiceException,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }

        return mONClientesHome;
    }

    private MONGestionMensajesHome getMONGestionarMensajesHome() throws MareException {
        MONGestionMensajesHome mONGestionMensajesHome = null;
        BelcorpService belcorpService = null;

        try {
            belcorpService = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException serviceNotFoundException) {
            ctx.setRollbackOnly();
            throw new MareException(serviceNotFoundException,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        try {
            mONGestionMensajesHome = (MONGestionMensajesHome) belcorpService.ejbLocator.getHome(
                    "java:comp/env/MONGestionMensajes",MONGestionMensajesHome.class);
        } catch (MareServiceException mareServiceException) {
            ctx.setRollbackOnly();
            throw new MareException(mareServiceException,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }

        return mONGestionMensajesHome;
    }

    public DTOSalida obtieneActividades(DTOActividad dto)
        throws MareException {
        UtilidadesLog.info("MONMantenimientoActividadBean.obtieneActividades(DTOActividad dto):Entrada");
        BelcorpService bs;
        RecordSet respuestaRecordSet;
        Vector vector = new Vector();

        String entidad = "CRA_ACTIV";
        Integer atributo = new Integer(1);
        Long idioma = dto.getOidIdioma();
        

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException serviceNotFoundException) {
            UtilidadesLog.error(serviceNotFoundException);
            throw new MareException(serviceNotFoundException,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        try {
            StringBuffer query = new StringBuffer();
            query.append(" SELECT C.OID_ACTI , (C.COD_ACTI || ' ' ||  G.VAL_I18N) as descripcion");
            query.append(" FROM CRA_ACTIV C, GEN_I18N_SICC G");
			query.append(" WHERE C.PAIS_OID_PAIS = '" + dto.getOidPais() + "' ");

            if (dto.getOidCanal() != null) {
                query.append(" AND C.CANA_OID_CANA = ? ");
                vector.add(dto.getOidCanal());
            }

            if (dto.getOidMarca() != null) {
                query.append(" AND C.MARC_OID_MARC = ? ");
                vector.add(dto.getOidMarca());
            }
    
            query.append(" AND C.OID_ACTI = G.VAL_OID ");

            query.append(" AND G.ATTR_ENTI = ? ");
            query.append(" AND G.ATTR_NUM_ATRI = ? ");
            query.append(" AND G.IDIO_OID_IDIO = ? ");
            query.append(" ORDER BY G.VAL_I18N ");

            vector.add(entidad);
            vector.add(atributo);
            vector.add(idioma);

            respuestaRecordSet = bs.dbService.executePreparedQuery(query.toString(),
                    vector);
        } catch (Exception exception) {
            UtilidadesLog.error(exception);
            throw new MareException(exception,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        /*if (respuestaRecordSet.esVacio()) {
            throw new MareException(new Exception(),
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }*/
        UtilidadesLog.info("MONMantenimientoActividadBean.obtieneActividades(DTOActividad dto):Salida");
        return new DTOSalida(respuestaRecordSet);
    }

    public DTOSalida obtieneClasesActividades(DTOBelcorp dto) throws MareException {
        UtilidadesLog.info("MONMantenimientoActividadBean.obtieneClasesActividades(DTOBelcorp dto):Entrada");
        BelcorpService bs;
        RecordSet respuestaRecordSet;

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException serviceNotFoundException) {
            UtilidadesLog.error(serviceNotFoundException);
            throw new MareException(serviceNotFoundException,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        try {
            StringBuffer query = new StringBuffer();
            query.append(" SELECT OID_CLAS_ACTI, DES_CLAS_ACTI FROM CRA_CLASE_ACTIV ORDER BY DES_CLAS_ACTI"); // VER EL NOMBRE DE INTERNACIONALIZACION

            respuestaRecordSet = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception exception) {
            UtilidadesLog.error(exception);
            throw new MareException(exception,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        if (respuestaRecordSet.esVacio()) {
            UtilidadesLog.debug(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE);
            throw new MareException(new Exception(),
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }
        UtilidadesLog.info("MONMantenimientoActividadBean.obtieneClasesActividades(DTOBelcorp dto):Salida");
        return new DTOSalida(respuestaRecordSet);
    }

    public void eliminaActividades(DTOOIDs dto) throws MareException {
        UtilidadesLog.info("MONMantenimientoActividadBean.eliminaActividades(DTOOIDs dto):Entrada");
        Long[] oids = dto.getOids();
        DTOActividad dtoAct;
        ActividadLocalHome actHome = new ActividadLocalHome();
        ActividadLocal actLocal = null;

        for (int i = 0; i < oids.length; i++) {
            try {
                actLocal = actHome.findByPrimaryKey((oids[i]));

                dtoAct = new DTOActividad();
                dtoAct.setOid(actLocal.getOid());
                dtoAct.setOidCanal(actLocal.getOidCanal());
                dtoAct.setOidMarca(actLocal.getOidMarca());
                dtoAct.setOidPais(actLocal.getOidPais());

                dtoAct.setIpCliente (dto.getIpCliente ());
                dtoAct.setPrograma (dto.getPrograma ());
                eliminaActividad(dtoAct);
            } catch (NoResultException e) {
                UtilidadesLog.debug(e);
                throw new MareException(e,
                    UtilidadesError.armarCodigoError(
                        CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
            }
        }
        UtilidadesLog.info("MONMantenimientoActividadBean.eliminaActividades(DTOOIDs dto):Salida");
    }


    private MONGestionMensajesHome getMONGestionMensajesHome() throws NamingException
  {
    final InitialContext context = new InitialContext();
    return (MONGestionMensajesHome)PortableRemoteObject.narrow(context.lookup("java:comp/env/MONGestionMensajes"), MONGestionMensajesHome.class);
  }


    /**
     * @throws es.indra.mare.common.exception.MareException
     * @return String
     * @param dtoActividad
     * @version Paola Cabrera
     * 
     * @comentario: Se ha creado este metodo para que sea posible recuperar
     *              la hora de la actividad, deacuerdo al formato correspondiente
     *              a la Base.-
     */

    
    public String obtieneSiguienteHoraActividad(DTOActividad dtoActividad) throws MareException {
        UtilidadesLog.info("MONMantenimientoActividadBean.obtieneSiguienteHoraActividad(DTOActividad dtoActividad):Entrada");
        BelcorpService belcorpService;

        try {
            belcorpService = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException serviceNotFoundException) {
            UtilidadesLog.error(serviceNotFoundException);
            throw new MareException(serviceNotFoundException,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        // Consulta Cronograma con los datos de entrada.
        RecordSet crono;
        String hora = null;
        StringBuffer sqlQuery = new StringBuffer("");
        
        sqlQuery.append(" SELECT to_char(fec_inic, 'HH24:mi') "); 
        sqlQuery.append(" FROM CRA_CRONO ");
        sqlQuery.append(" WHERE CACT_OID_ACTI = " + dtoActividad.getOid() );
        sqlQuery.append(" AND PERD_OID_PERI = " + dtoActividad.getOidPeriodo() );
        
        if ( dtoActividad.getOidZona() != null)
          sqlQuery.append(" AND ZZON_OID_ZONA = " + dtoActividad.getOidZona() ); 
        
        if (dtoActividad.getOidSeccion() != null) 
          sqlQuery.append(" AND ZSCC_OID_SECC = " + dtoActividad.getOidSeccion() ); 
        
        if (dtoActividad.getOidTipoFacturacion() != null)
          sqlQuery.append(" AND TIFA_OID_TIPO_FACT = " + dtoActividad.getOidTipoFacturacion() );  
         
         sqlQuery.append(" ORDER BY FEC_INIC ");
        
        
        try { 
            crono = belcorpService.dbService.executeStaticQuery(sqlQuery.toString());
        } catch (Exception exception){
            UtilidadesLog.error(exception);
            throw new MareException(exception,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        
        if (!crono.esVacio()){
            hora  = crono.getValueAt(0,0).toString();
        }
       
         UtilidadesLog.info("MONMantenimientoActividadBean.obtieneSiguienteHoraActividad(DTOActividad dtoActividad):Salida");
         return hora;
    }

/**
   * Creado por incidencia 10913
   * @throws es.indra.mare.common.exception.MareException
   * @return 
   * @param dto
   */
    public DTOSalida obtieneActividadesPorTipoSolicitud(DTOOID dto)
        throws MareException {
        UtilidadesLog.info("MONMantenimientoActividadBean.obtieneActividadesPorTipoSolicitud(DTOOID dto):Entrada");

        DAOCRA daoActividades = new DAOCRA();
        DTOSalida dtos = daoActividades.obtieneActividadesPorTipoSolicitud(dto);

        UtilidadesLog.info("MONMantenimientoActividadBean.obtieneActividadesPorTipoSolicitud(DTOOID dto):Salida");
        return dtos;
    }

    /**
     * Cambio CRA-01
     * Obtiene informacion de la actividad cuyo OID se recibe por parametro
     * y tambien de su actividad origen en caso de poseerla
     * @author dmorello
     * @since 18-jun-2008
     */
    public DTOSalida obtenerInfoActividad(DTOOID dtoOidActividad) throws MareException {
        UtilidadesLog.info("MONMantenimientoActividadBean.obtenerInfoActividad(DTOOID dtoOidActividad):Entrada");
        RecordSet rs = new DAOCRA().obtenerInfoActividad(dtoOidActividad.getOid());
        UtilidadesLog.info("MONMantenimientoActividadBean.obtenerInfoActividad(DTOOID dtoOidActividad):Salida");
        return new DTOSalida(rs);
    }

}
