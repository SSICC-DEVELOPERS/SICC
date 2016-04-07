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
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.cmn.negocio.i18n.DTOI18nSICC;
import es.indra.sicc.cmn.negocio.i18n.Entidadi18nLocal;
import es.indra.sicc.cmn.negocio.i18n.Entidadi18nLocalHome;
import es.indra.sicc.cmn.negocio.validacion.MONValidacion;
import es.indra.sicc.cmn.negocio.validacion.MONValidacionHome;
import es.indra.sicc.dtos.cra.DTOCabecerasGruposZonas;
import es.indra.sicc.dtos.cra.DTODetallesGruposZonas;
import es.indra.sicc.dtos.cra.DTOEntradaEliminarGrupoZonas;
import es.indra.sicc.dtos.cra.DTOGrupoZonas;
import es.indra.sicc.dtos.cra.DTOGruposZonas;
import es.indra.sicc.dtos.cra.DTORegionesZonas;
import es.indra.sicc.dtos.cra.DTOZonas;
import es.indra.sicc.dtos.cra.DTOZonasGruposZonas;
import es.indra.sicc.entidades.cra.CabeceraGruposZonasLocal;
import es.indra.sicc.entidades.cra.CabeceraGruposZonasLocalHome;
import es.indra.sicc.entidades.cra.DetalleGruposZonasLocal;
import es.indra.sicc.entidades.cra.DetalleGruposZonasLocalHome;
import es.indra.sicc.logicanegocio.seg.ConstantesSEG;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.LogAPP;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;

import java.math.BigDecimal;

import java.rmi.RemoteException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Vector;

import javax.ejb.CreateException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import javax.persistence.EntityExistsException;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;

import javax.rmi.PortableRemoteObject;


public class MONMantenimientoGruposZonasBean implements SessionBean {
    private SessionContext ctx;

    public void ejbCreate() {
    }

    public void ejbActivate() {
    }

    public void ejbPassivate() {
    }

    public void ejbRemove() {
    }

    public void setSessionContext(SessionContext ctx) {
        this.ctx = ctx;
    }

    public void crear(DTOGrupoZonas dto) throws  RemoteException, MareException {
    }

    public DTOSalida consulta(DTOGrupoZonas dto) throws  RemoteException, MareException {
       return null;
    }

    public void elimina(DTOGrupoZonas dto) throws  RemoteException, MareException {
    }

    public void modifica(DTOGrupoZonas dto) throws  RemoteException, MareException {
    }

    public DTOGrupoZonas obtenZonasPorGruposZonas(DTOGrupoZonas dto) throws  RemoteException, MareException {
        return null;
    }
    

    /**
     * Se obtienen dos colecciones de Zonas.
     * Una mediante un query sobre UnidadesAdministrativas de zonificacion
     * y la otra mediante una query a la tabla CRA_DETAL_GRUPO_ZONA.
     * Luego se cotejan las colecciones y se registra en un log aquellas zonas que
     * figuran en una colección y no en la otra y viceversa.
     * 
     * 31-05-2005 - rgiorgi: inc. 18762.
     */
    public void compruebaZonasNoAsignadas(Long oidPais) throws MareException {
        UtilidadesLog.info("MONMantenimientoGruposZonasBean.compruebaZonasNoAsignadas(Long oidPais):Entrada");
        BelcorpService belcorpService;
        RecordSet zonasUno, zonasDos;
        Iterator iterUno, iterDos;
        String oidZona;
        Collection listaZonasUno = new ArrayList();
        Collection listaZonasDos = new ArrayList();
        
        try {
            belcorpService = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException serviceNotFoundException) {
            UtilidadesLog.error(serviceNotFoundException);
            throw new MareException(serviceNotFoundException, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        /* Pasos 1 y 2
         * 1.- El sistema toma de la entidad VÍNCULOS todas las posibles combinaciones
         * de Marca, País y Canal para el país recibido (a través del DBService).
         * 2.- Con cada una de las combinaciones existentes, el sistema lee de la entidad de UNIDADES ADMINISTRATIVAS
         * del módulo de Zonificación los códigos de todas las zonas existentes que cumplan
         * para esa combinación Marca, País y Canal y estén activas (a través del DBService).
         */
        try {
            StringBuffer sql = new StringBuffer();
            sql.append(" select distinct Z.OID_ZONA "); 
            sql.append(" from ZON_ZONA Z, ZON_REGIO R, ZON_SUB_GEREN_VENTA SGV, SEG_VINCU_JERAR V ");
            // 1.- De SEG_VINCU_JERAR se toman todas las combinaciones de Marca, País y Canal para el país recibido
            sql.append(" where V.PAIS_OID_PAIS = ? ");
            sql.append(" and V.PAIS_OID_PAIS = SGV.PAIS_OID_PAIS and V.MARC_OID_MARC = SGV.MARC_OID_MARC and V.CANA_OID_CANA = SGV.CANA_OID_CANA ");
            // 2.- De de la entidad de UNIDADES ADMINISTRATIVAS, en este caso, de ZON_ZONA, ZON_REGIO y ZON_SUB_GEREN_VENTA,
            // se obtiene las zonas para esa combinación Marca, País y Canal y estén activas.
            sql.append(" and  R.ZSGV_OID_SUBG_VENT = SGV.OID_SUBG_VENT  and R.OID_REGI = Z.ZORG_OID_REGI ");
            sql.append(" and sgv.ind_acti = 1  and sgv.ind_borr = 0  and r.ind_acti = 1  and r.ind_borr = 0  and z.ind_acti = 1  and z.ind_borr = 0 ");
            Vector vector = new Vector();
            vector.add(oidPais);
            zonasUno = belcorpService.dbService.executePreparedQuery(sql.toString(), vector);
            //pasamos el reocorSet a una coleccion
            iterUno = zonasUno.getRecords().iterator();
            while (iterUno.hasNext()) {
                oidZona = ((Vector) iterUno.next()).elementAt(0).toString();
                listaZonasUno.add(oidZona);
            }
            UtilidadesLog.debug("Lista Zonas Uno: " + listaZonasUno);
        } catch (Exception exception) {
            UtilidadesLog.error(exception);
            throw new MareException(exception,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        /* Pasos 1 y 3
         * 1.- El sistema toma de la entidad VÍNCULOS todas las posibles combinaciones
         * de Marca, País y Canal para el país recibido (a través del DBService).
         * 3.- Se obtienen todas las zonas de todos registros de DETALLE DE GRUPOS DE ZONAS 
         * que cumplan que su CABECERA DE GRUPOS DE ZONAS está relacionada con
         * la Marca, el País y el Canal obtenidos en el paso 1 (a través del DBService). 
         */
        try {
            StringBuffer query = new StringBuffer();
            query.append(" select distinct DGZ.ZZON_OID_ZONA ");
            query.append(" from SEG_VINCU_JERAR V, CRA_CABEC_GRUPO_ZONA CGZ, CRA_DETAL_GRUPO_ZONA DGZ");
            query.append(" where V.PAIS_OID_PAIS = ? ");
            query.append(" and CGZ.OID_CABE_GRUP_ZONA = DGZ.CGZO_OID_CABE_GRUP_ZONA ");
            query.append(" and V.PAIS_OID_PAIS = CGZ.PAIS_OID_PAIS and V.MARC_OID_MARC = CGZ.MARC_OID_MARC and V.CANA_OID_CANA = CGZ.CANA_OID_CANA ");
            query.append(" and CGZ.IND_ESTA = 1 ");
            Vector vector = new Vector();
            vector.add(oidPais);
            zonasDos = belcorpService.dbService.executePreparedQuery(query.toString(), vector);
            //pasamos el reocorSet a una coleccion
            iterDos = zonasDos.getRecords().iterator();
            while (iterDos.hasNext()) {
                oidZona = ((Vector) iterDos.next()).elementAt(0).toString();
                listaZonasDos.add(oidZona);
            }
            UtilidadesLog.debug("Lista Zonas Dos: " + listaZonasDos);
        } catch (Exception exception) {
            UtilidadesLog.error(exception);
            throw new MareException(exception,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        /* Pasos 4 y 5
         * 4.- El sistema compara ambas listas para ver si hay diferencias, estas peden ser de dos tipos: 
         * - Existen en UA Zonas que no están en ningún grupo. Esto implica Zonas "huérfanas".
         * - Existen en Detalle de Grupos de Zonas algunas Zonas que han sido eliminadas y no se ha realizado su actualización en el Cronograma.
         * 5.- El sistema genera un registro en el Log por cada diferencia,
         * indicando cual de los dos casos es el que genera la entrada.
         */
        // Zonas "HUERFANAS" - Que no pertenecen a ningún grupo
        Iterator iterListaUno = listaZonasUno.iterator();
        while (iterListaUno.hasNext()) {
            String oidZonaUno = (String) iterListaUno.next();
            if ( ! listaZonasDos.contains(oidZonaUno) ) {
                UtilidadesLog.debug("[CRA] [Comprobar Zonas no Asignadas] Existen en UA Zonas que no están en ningún grupo. Esto implica Zonas 'huérfanas':\t"+oidZonaUno);
                LogAPP.error("[CRA] [Comprobar Zonas no Asignadas] Existen en UA Zonas que no están en ningún grupo. Esto implica Zonas 'huérfanas':\t"+oidZonaUno);
            }
        }
        
        // Zonas "ELIMINADAS" - Que pertenecen a algún grupo pero que han sido eliminadas
        Iterator iterListaDos = listaZonasDos.iterator();
        while (iterListaDos.hasNext()) {
            String oidZonaDos = (String) iterListaDos.next();
            if ( ! listaZonasUno.contains(oidZonaDos) ) {
                UtilidadesLog.debug("[CRA] [Comprobar Zonas no Asignadas] Existen en Detalle de Grupos de Zonas algunas Zonas que han sido eliminadas y no se ha realizado su actualización en el Cronograma:\t"+oidZonaDos);
                LogAPP.error("[CRA] [Comprobar Zonas no Asignadas] Existen en Detalle de Grupos de Zonas algunas Zonas que han sido eliminadas y no se ha realizado su actualización en el Cronograma:\t"+oidZonaDos);
            }
        }
        
        UtilidadesLog.info("MONMantenimientoGruposZonasBean.compruebaZonasNoAsignadas(Long oidPais):Salida");
    }


    public void asignacion(DTOCabecerasGruposZonas dtoCabecerasGruposZonas)
        throws MareException {
        UtilidadesLog.info("MONMantenimientoGruposZonasBean.asignacion(DTOCabecerasGruposZonas dtoCabecerasGruposZonas):Entrada");
        //Adaptado a la v3.
        String codigoError;
        
        // Recorro la colección de zonas definitivas del grupo
        // para agregar las que faltan
        Collection detalles = dtoCabecerasGruposZonas.getZonas();
        Iterator iterator = detalles.iterator();

        while (iterator.hasNext()) {

            DTODetallesGruposZonas detalle = (DTODetallesGruposZonas) iterator.next();

            try {
                DetalleGruposZonasLocalHome dgzlh = new DetalleGruposZonasLocalHome();
                Collection colRes = dgzlh.findByOidGrupoOidZona(detalle.getOidGrupo(), detalle.getOidZona());

                //si existe listo y si no lo crea
                if (colRes.isEmpty()) {
                    try {
                        dgzlh.create(detalle.getOidZona(), detalle.getOidGrupo());
                    } catch (PersistenceException createException) {
                        UtilidadesLog.error(createException);
                        codigoError = CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS;
                        throw new MareException(createException,
                            UtilidadesError.armarCodigoError(codigoError));
                    }
                }


            } catch (NoResultException finderException) {
                // Si no lo encuentra lo crea
                try {
                    DetalleGruposZonasLocalHome dgzlh = new DetalleGruposZonasLocalHome();
                    dgzlh.create(detalle.getOidZona(), detalle.getOidGrupo());

                } catch (PersistenceException createException) {
                    UtilidadesLog.error(createException);
                    codigoError = CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS;
                    throw new MareException(createException,
                        UtilidadesError.armarCodigoError(codigoError));
                }
            }
        }

        // Se recorre la colección de detalles para eliminar los 
        // que no vienen en el parámetro
        try {
            DetalleGruposZonasLocalHome dgzlh = new DetalleGruposZonasLocalHome();
            Collection detallesLocal = dgzlh.findByCabeceraPK(dtoCabecerasGruposZonas.getOidGrupo());
            iterator = detallesLocal.iterator();


            while (iterator.hasNext()) {
                DetalleGruposZonasLocal detalleLocala = (DetalleGruposZonasLocal) iterator.next();
                DetalleGruposZonasLocal detalleLocal = dgzlh.findByPrimaryKey(detalleLocala.getOid());

                boolean eliminarlo = true;
                Iterator iterator2 = detalles.iterator();


                while (iterator2.hasNext()) {
                    DTODetallesGruposZonas detalle = (DTODetallesGruposZonas) iterator2.next();


                    if (detalle.getOidGrupo().equals(detalleLocal.getOidGrupoZona())) {
                        if (detalle.getOidZona().equals(detalleLocal.getOidZona())) {
                            UtilidadesLog.debug("------->no eliminar");
                            eliminarlo = false;
                        }
                    }
                }


                if (eliminarlo) {
                    try {
                        dgzlh.remove(detalleLocal);
                        
                    } catch (PersistenceException removeException) {
                        UtilidadesLog.debug(removeException);
                        codigoError = CodigosError.ERROR_DE_BORRADO_DE_DATOS;
                        throw new MareException(removeException,
                            UtilidadesError.armarCodigoError(codigoError));
                    }
                }
            }
        } catch (NoResultException finderException) {
            UtilidadesLog.debug(finderException);
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(finderException,
                UtilidadesError.armarCodigoError(codigoError));
        }
        UtilidadesLog.info("MONMantenimientoGruposZonasBean.asignacion(DTOCabecerasGruposZonas dtoCabecerasGruposZonas):Salida");
    }

    public DTOSalida consulta(Long marca, Long pais, Long canal, Long idioma) throws MareException {
        UtilidadesLog.info("MONMantenimientoGruposZonasBean.consulta(Long marca, Long pais, Long canal, Long idioma):Entrada");
        BelcorpService belcorpService;
        String codigoError;
        RecordSet respuesta;
        StringBuffer query = new StringBuffer();

        try {
            belcorpService = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException mmsnfe) {
            UtilidadesLog.error(mmsnfe);
            codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            throw new MareException(mmsnfe,
                UtilidadesError.armarCodigoError(codigoError));
        }

        try {
       
            query.append("SELECT ");
            query.append("c.COD_GRUP, i.VAL_I18N DES_GRUP, c.TIFA_OID_TIPO_FACT, c.OID_CABE_GRUP_ZONA ");
            query.append("FROM ");
            query.append("CRA_CABEC_GRUPO_ZONA c ,  V_GEN_I18N_SICC i ");
            query.append("WHERE ");
            query.append("MARC_OID_MARC = '" + marca + "' ");
            query.append("AND PAIS_OID_PAIS = '" + pais + "' ");
            query.append("AND CANA_OID_CANA = '" + canal + "' ");
            query.append("AND i.ATTR_ENTI = 'CRA_CABEC_GRUPO_ZONA' ");
            query.append("AND i.VAL_OID = c.OID_CABE_GRUP_ZONA "); 
            query.append("AND i.IDIO_OID_IDIO = '" + idioma + "' ");
            query.append("ORDER BY i.VAL_I18N");
            respuesta = belcorpService.dbService.executeStaticQuery(query.toString());
        } catch (Exception exception) {
            UtilidadesLog.error(exception);
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(exception,
                UtilidadesError.armarCodigoError(codigoError));
        }

        if (respuesta.esVacio()) {
            UtilidadesLog.debug(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE);
            throw new MareException(new Exception(),
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }
        UtilidadesLog.info("MONMantenimientoGruposZonasBean.consulta(Long marca, Long pais, Long canal, Long idioma):Salida");
        return new DTOSalida(respuesta);
    }

    public Collection consultaGruposZonasDetalles(Long marca, Long pais, Long canal, Long idioma) throws MareException {
        UtilidadesLog.info("MONMantenimientoGruposZonasBean.consultaGruposZonasDetalles(Long marca, Long pais, Long canal, Long idioma):Entrada");
        Collection grupos = new ArrayList();
        DTOSalida dtoGrupos = this.consulta(marca, pais, canal, idioma);
        Iterator iterator = dtoGrupos.getResultado().getRecords().iterator();

        while (iterator.hasNext()) {
            DTOCabecerasGruposZonas dtoCabecera = new DTOCabecerasGruposZonas();
            dtoCabecera.setCanal(canal);
            dtoCabecera.setMarca(marca);
            dtoCabecera.setPais(pais);

            Vector cabecera = (Vector) iterator.next();
            Integer codigoGrupo = toInt(cabecera.get(0));
            Long oidGrupo = toLong(cabecera.get(3));
            dtoCabecera.setOidGrupo(oidGrupo);
            dtoCabecera.setCodigoGrupo(codigoGrupo);
            dtoCabecera.setNombreGrupo((String) cabecera.get(1));
            dtoCabecera.setTipoFacturacion(toLong(cabecera.get(2)));
            grupos.add(dtoCabecera);
        }
        UtilidadesLog.info("MONMantenimientoGruposZonasBean.consultaGruposZonasDetalles(Long marca, Long pais, Long canal, Long idioma):Salida");
        return this.obtenZonasPorGruposZonas(grupos);

    }


    private Long toLong(Object dato){
        if (dato!=null){
            return new Long(((BigDecimal)dato).toString());
        } else return null;
    }
    private Integer toInt(Object dato){
        if (dato!=null){
            return new Integer(((BigDecimal)dato).intValue());
        } else return null;
    }    
    public Collection crear(Collection dtoCabecerasGruposZonas) throws MareException {
        UtilidadesLog.info("MONMantenimientoGruposZonasBean.crear(Collection dtoCabecerasGruposZonas):Entrada");
        try {
            MONValidacionHome mvh = this.getMONValidacionHome();
            MONValidacion validacion = mvh.create();
            Iterator iterator = dtoCabecerasGruposZonas.iterator();

            while (iterator.hasNext()) {
                DTOCabecerasGruposZonas dtoCabecera = (DTOCabecerasGruposZonas) iterator.next();

                boolean valido = validacion.validarVinculos(dtoCabecera.getOidPais(), null, dtoCabecera.getMarca(), dtoCabecera.getCanal(), null, null).booleanValue();  
                if (!valido) {
                    UtilidadesLog.debug(ConstantesSEG.MODULO_CRA + ErroresDeNegocio.GEN_0013);
                    throw new MareException(new Exception(),
                                      UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_CRA,"",
                                          ErroresDeNegocio.GEN_0013)); }                               
                CabeceraGruposZonasLocalHome cgzlh = new CabeceraGruposZonasLocalHome();
                
                //valido que no exista uno con el mismo nombre
                Entidadi18nLocalHome e18nLH = new Entidadi18nLocalHome();
                
                for (int i=0;i<dtoCabecera.getAttriTraducible().size();i++){
                  DTOI18nSICC dtoTraduccion = (DTOI18nSICC)dtoCabecera.getAttriTraducible().elementAt(i);//devuelve los datos de la traduccion
                  Long oidIdioma = (Long)dtoTraduccion.getOidIdioma();
                  String descripcion = (String)dtoTraduccion.getValorI18n();     
                  try{
                    
                    Collection res = e18nLH.findByEntAtrIdioValor("CRA_CABEC_GRUPO_ZONA",dtoTraduccion.getOidAtriuto(),oidIdioma,descripcion);
                    if(res.size() > 0 && !descripcion.equals(" ")){       
                        UtilidadesLog.debug(ConstantesSEG.MODULO_CRA + ErroresDeNegocio.NOMBRE_DE_GRUPO_EXISTENTE);
                       throw new MareException(new Exception(),
                                  UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_CRA, "", ErroresDeNegocio.NOMBRE_DE_GRUPO_EXISTENTE));
                    }
             
                  } catch (NoResultException fe){
                        UtilidadesLog.debug(fe);
                
                  }
                }
                
                
                CabeceraGruposZonasLocal cabecera = cgzlh.create(dtoCabecera.getPais(),
                        dtoCabecera.getMarca(), dtoCabecera.getCanal(),
                        dtoCabecera.getCodigoGrupo(),                        
                        dtoCabecera.getTipoFacturacion(), Boolean.TRUE);

                for (int i=0;i<dtoCabecera.getAttriTraducible().size();i++){
                  DTOI18nSICC dtoTraduccion = (DTOI18nSICC)dtoCabecera.getAttriTraducible().elementAt(i);//devuelve los datos de la traduccion
                  Long oidIdioma = (Long)dtoTraduccion.getOidIdioma();
                  String descripcion = (String)dtoTraduccion.getValorI18n();
                  e18nLH.create("CRA_CABEC_GRUPO_ZONA",dtoTraduccion.getOidAtriuto(),oidIdioma,descripcion,cabecera.getOid());    
                }     
                Iterator ite = dtoCabecera.getZonas().iterator();

                while (ite.hasNext()) {
                    DTODetallesGruposZonas dtoDetalle = (DTODetallesGruposZonas) ite.next();

                    DetalleGruposZonasLocalHome dgzlh = new DetalleGruposZonasLocalHome();
                    dgzlh.create(dtoDetalle.getOidZona(), cabecera.getOid());
                }
            }
        } catch (RemoteException e) {
            UtilidadesLog.error(e);
            ctx.setRollbackOnly();
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch (EntityExistsException e) {
            UtilidadesLog.debug(e);
            ctx.setRollbackOnly();
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_CLAVE_DUPLICADA));
        } catch(NamingException e) {
          UtilidadesLog.error(e);
          ctx.setRollbackOnly();
          throw new MareException(e,UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch (PersistenceException e) {
            UtilidadesLog.error(e);
            ctx.setRollbackOnly();
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        } catch (CreateException e) {
                UtilidadesLog.error(e);
                ctx.setRollbackOnly();
                throw new MareException(e,
                    UtilidadesError.armarCodigoError(
                        CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
        UtilidadesLog.info("MONMantenimientoGruposZonasBean.crear(Collection dtoCabecerasGruposZonas):Salida");
        return dtoCabecerasGruposZonas;
    }

    public void elimina(DTOEntradaEliminarGrupoZonas dtoEntradaEliminarGrupoZonas) throws MareException {
        UtilidadesLog.info("MONMantenimientoGruposZonasBean.elimina(DTOEntradaEliminarGrupoZonas dtoEntradaEliminarGrupoZonas):Entrada");
        String codigoError;
        BelcorpService belcorpService;
        RecordSet respuesta;
        StringBuffer query = new StringBuffer();

        // Se realiza una verificación para ver si existe en MatrizDias
        // Si existe se lanza una MareException, en caso contrario se 
        // eliminan las entidades Detalles y Cabecera
        try {
            belcorpService = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException mmsnfe) {
            UtilidadesLog.error(mmsnfe);
            codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            throw new MareException(mmsnfe,
                UtilidadesError.armarCodigoError(codigoError));
        }

        try {
            query.append("SELECT OID_MATR_DIAS ");
            query.append("FROM CRA_MATRI_DIAS ");
            query.append("WHERE CGZO_OID_CABE_GRUP_ZONA = '" +
            dtoEntradaEliminarGrupoZonas.getOidGrupo() + "'");

            respuesta = belcorpService.dbService.executeStaticQuery(query.toString());
        } catch (Exception exception) {
            UtilidadesLog.error(exception);
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(exception,
                UtilidadesError.armarCodigoError(codigoError));
        }

        if (!respuesta.getRecords().isEmpty()) {
            codigoError = CodigosError.ERROR_DE_BORRADO_DE_DATOS;
            UtilidadesLog.debug(ConstantesSEG.MODULO_CRA + ErroresDeNegocio.GRUPO_ZONA_REFERENCIADO);
            throw new MareException(new Exception(),
                UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_CRA, "",
                    ErroresDeNegocio.GRUPO_ZONA_REFERENCIADO));
        }

        try {
            DetalleGruposZonasLocalHome dgzlh = new DetalleGruposZonasLocalHome();
            // Se eliminan los detalles
            Collection detalles = dgzlh.findByCabeceraPK(dtoEntradaEliminarGrupoZonas.getOidGrupo());
            Iterator iterator = detalles.iterator();

            while (iterator.hasNext()) {
                dgzlh.remove((DetalleGruposZonasLocal) iterator.next());                
            }

            // Se elimina la cabecera
            CabeceraGruposZonasLocalHome cgzlh = new CabeceraGruposZonasLocalHome();
            
            CabeceraGruposZonasLocal cgzl = cgzlh.findByPrimaryKey(dtoEntradaEliminarGrupoZonas.getOidGrupo());

            Entidadi18nLocalHome e18nLH = new Entidadi18nLocalHome();
            Collection col = e18nLH.findByEntAtrPK("CRA_CABEC_GRUPO_ZONA", new Long(1), cgzl.getOid());
            Iterator it = col.iterator();
            while (it.hasNext()) {
              Entidadi18nLocal e18nLocal= (Entidadi18nLocal)it.next();
              e18nLH.remove(e18nLocal);
            }

            cgzlh.remove(cgzl);
            
        } catch (NoResultException finderException) {
            UtilidadesLog.debug(finderException);
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(finderException,
                UtilidadesError.armarCodigoError(codigoError));
        } catch (PersistenceException removeException) {
            UtilidadesLog.debug(removeException);
            codigoError = CodigosError.ERROR_DE_BORRADO_DE_DATOS;
            throw new MareException(removeException,
                UtilidadesError.armarCodigoError(codigoError));
        }
        UtilidadesLog.info("MONMantenimientoGruposZonasBean.elimina(DTOEntradaEliminarGrupoZonas dtoEntradaEliminarGrupoZonas):Salida");
    }


    public DTOSalida modifica(Long marca, Long pais, Long canal, Integer codigoGrupo, Vector nombresGrupo, Long tipoFactura) throws MareException {
        UtilidadesLog.info("MONMantenimientoGruposZonasBean.modifica(Long marca, Long pais, Long canal, Integer codigoGrupo, Vector nombresGrupo, Long tipoFactura):Entrada");
        try {
            CabeceraGruposZonasLocalHome cabeceraGruposZonasLocalHome = new CabeceraGruposZonasLocalHome();
            Collection cabeceras = cabeceraGruposZonasLocalHome.findByOldPK(marca, pais, canal, codigoGrupo);
            
            Iterator itCab = cabeceras.iterator();

            MONValidacionHome mvh = this.getMONValidacionHome();
            MONValidacion validacion = mvh.create();

            boolean valido = validacion.validarVinculos(pais,null,marca,canal,null,null).booleanValue();

            
            if (!valido) {
                UtilidadesLog.debug( ConstantesSEG.MODULO_CRA + ErroresDeNegocio.GEN_0013 );
                throw new MareException(new Exception(),
                          UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_CRA,"",ErroresDeNegocio.GEN_0013));
            }
            //Al no ser mas la pk la tabla permite que haya mas de uno => es una collection
            //Esta adaptacion modifica todo lo que traiga esa collection
            
            while (itCab.hasNext()) {
                CabeceraGruposZonasLocal unacabecera = (CabeceraGruposZonasLocal) itCab.next();                
                unacabecera.setTipoFacturacion(tipoFactura);   
                
                cabeceraGruposZonasLocalHome.merge(unacabecera);                
                
                Entidadi18nLocalHome e18nLH = new Entidadi18nLocalHome();
                for (int i=0;i< nombresGrupo.size();i++){
                      DTOI18nSICC dtoTraduccion = (DTOI18nSICC) nombresGrupo.elementAt(i); //devuelve los datos de la traducción
                      Long oidIdioma = (Long)dtoTraduccion.getOidIdioma();
                      String descripcion = (String)dtoTraduccion.getValorI18n();
                      try {

                        Entidadi18nLocal e18nL = e18nLH.findByEntAtrIdioPK( "CRA_CABEC_GRUPO_ZONA", dtoTraduccion.getOidAtriuto() ,oidIdioma, unacabecera.getOid());
                        e18nL.setDetalle(descripcion);
                        e18nLH.merge(e18nL);
                        
                      } catch(NoResultException e) {
                            UtilidadesLog.debug("No se encontro la descripcion para ese idioma, vamos a crearlo");
                            e18nLH.create("CRA_CABEC_GRUPO_ZONA",dtoTraduccion.getOidAtriuto(),oidIdioma,descripcion, unacabecera.getOid());
                      }
                }
            }
        } catch (PersistenceException pe) {
            UtilidadesLog.error(pe);
            ctx.setRollbackOnly();
            String error = CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS;
            throw new MareException(pe, UtilidadesError.armarCodigoError(error));
        } catch (RemoteException e) {
            UtilidadesLog.error(e);
            ctx.setRollbackOnly();
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch(NamingException e) {
            UtilidadesLog.error(e);
            ctx.setRollbackOnly();
            throw new MareException(e,UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch (CreateException e) {
            UtilidadesLog.error(e);
            ctx.setRollbackOnly();
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
        UtilidadesLog.info("MONMantenimientoGruposZonasBean.modifica(Long marca, Long pais, Long canal, Integer codigoGrupo, Vector nombresGrupo, Long tipoFactura):Salida");
        return new DTOSalida();
    }


    public void mueveZonas(Collection allGroups) throws MareException {
        UtilidadesLog.info("MONMantenimientoGruposZonasBean.mueveZonas(Collection allGroups):Entrada");
        try {
            // Borra de CRA_DETAL_GRUPO_ZONA las zonas que no estan en la estructura
            // de entrada pero que si estan en la tabla
            this.eliminaZonasAPartirDeEstructura(allGroups);
            UtilidadesLog.debug("Paso Modificacion");
        
            // Inserta en CRA_DETAL_GRUPO_ZONA las zonas que estan en la estructura
            // de entrada pero que no estan en la tabla
            this.insertaZonasAPartirDeEstructura(allGroups);
            UtilidadesLog.debug("Paso Insercion");

        } catch (MareException ex) {
            UtilidadesLog.error(ex);
            throw ex;
        }
        UtilidadesLog.info("MONMantenimientoGruposZonasBean.mueveZonas(Collection allGroups):Salida");
    }


    public Collection obtenZonasPorGruposZonas(Collection dtoGruposZonasCollection) throws MareException {
        UtilidadesLog.info("MONMantenimientoGruposZonasBean.obtenZonasPorGruposZonas( Collection dtoGruposZonasCollection):Entrada");
        BelcorpService belcorpService;
        String codigoError;
        RecordSet respuesta;
        StringBuffer query = new StringBuffer();

        try {
            belcorpService = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException mmsnfe) {
            UtilidadesLog.error(mmsnfe);
            codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            throw new MareException(mmsnfe,
                UtilidadesError.armarCodigoError(codigoError));
        }

        // Se recorre la colección de grupos de zonas y se le va agregando 
        // las zonas a cada uno de los mismos.
        Iterator iterator = dtoGruposZonasCollection.iterator();

        while (iterator.hasNext()) {
            query.delete(0, query.length());

            DTOCabecerasGruposZonas dtoCabecera = (DTOCabecerasGruposZonas) iterator.next();

            try {
                query.append(" SELECT D.ZZON_OID_ZONA, D.OID_DETA_GRUP_ZONA, Z.ZORG_OID_REGI, R.ZSGV_OID_SUBG_VENT, Z.COD_ZONA, R.COD_REGI, Z.DES_ZONA");
                query.append(" FROM CRA_DETAL_GRUPO_ZONA D, ZON_ZONA Z, CRA_CABEC_GRUPO_ZONA C, ZON_REGIO R");
                query.append(" WHERE C.OID_CABE_GRUP_ZONA = '" + dtoCabecera.getOidGrupo() + "' ");
                query.append(" AND D.CGZO_OID_CABE_GRUP_ZONA = C.OID_CABE_GRUP_ZONA");
                query.append(" AND D.ZZON_OID_ZONA = Z.OID_ZONA");
                query.append(" AND Z.ZORG_OID_REGI = R.OID_REGI");
                respuesta = belcorpService.dbService.executeStaticQuery(query.toString());
            } catch (Exception exception) {
                UtilidadesLog.error(exception);
                codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
                throw new MareException(exception,
                    UtilidadesError.armarCodigoError(codigoError));
            }

            Collection detalles = new ArrayList();
            Iterator ite = respuesta.getRecords().iterator();

            while (ite.hasNext()) {
                Vector registro = (Vector) ite.next();
                DTODetallesGruposZonas dtoDetalles = new DTODetallesGruposZonas();
                dtoDetalles.setCodigoGrupoDetalle(((BigDecimal) registro.elementAt(1)).toString());
                dtoDetalles.setOidDetalle(toLong(registro.elementAt(1)));
                
                DTOZonas dtoZona = new DTOZonas();
                dtoZona.setCodigoZona((String) registro.elementAt(4));
                dtoZona.setOidZona(toLong(registro.elementAt(0)));
                dtoZona.setRegion((String) registro.elementAt(5));
                dtoZona.setOidRegion(toLong(registro.elementAt(2)));
                dtoZona.setOidSubgerenciaVentas(toLong(registro.elementAt(3)));
                dtoZona.setPais(dtoCabecera.getPais());
                dtoZona.setMarca(dtoCabecera.getMarca());
                dtoZona.setCanal(dtoCabecera.getCanal());
                dtoZona.setDescZona((String) registro.elementAt(6));
                dtoDetalles.setZona(dtoZona);
                detalles.add(dtoDetalles);
            }

            dtoCabecera.setZonas(detalles);
        }
        UtilidadesLog.info("MONMantenimientoGruposZonasBean.obtenZonasPorGruposZonas( Collection dtoGruposZonasCollection):Salida");
        return dtoGruposZonasCollection;
    }


    /*
     * Obtiene las zonas de un grupo de zonas.
    */
    public DTOSalida obtenerZonasDeGrupo(DTOGruposZonas dtoGrupoZona) throws MareException {
        UtilidadesLog.info("MONMantenimientoGruposZonasBean.obtenerZonasDeGrupo(DTOGruposZonas dtoGrupoZona):Entrada");
        StringBuffer stringBuffer = new StringBuffer();
        Vector vector = new Vector();
        BelcorpService belcorpService;
        try {
            belcorpService = BelcorpService.getInstance();

            //si viene el atributo grupo de zona en el dto, hacemos una consulta
            //incluyendo las zonas del grupo de zonas
            vector = dtoGrupoZona.getOidGrupoZona();
            stringBuffer.append("SELECT D.ZZON_OID_ZONA, D.OID_DETA_GRUP_ZONA,D.CGZO_OID_CABE_GRUP_ZONA, Z.OID_ZONA, Z.DES_ZONA ");
            stringBuffer.append(" FROM  CRA_DETAL_GRUPO_ZONA D, ZON_ZONA Z ");
            stringBuffer.append(" WHERE (");
            //este ciclo esta para que vaya recorriendo el vector de Oids (mdolce) 

            for (int i = 0; i< vector.size(); i++) 
            {
                 String sBuffer =  ( (Long) vector.get(i) ).toString();
                 if ( i != 0) {
                   stringBuffer.append(" OR ");
                 }

                 stringBuffer.append(" D.CGZO_OID_CABE_GRUP_ZONA = " + sBuffer);
              
            }
            stringBuffer.append(" ) "); 

            stringBuffer.append(" AND   D.ZZON_OID_ZONA = Z.OID_ZONA ");

            RecordSet respuesta = belcorpService.dbService.executeStaticQuery(stringBuffer.toString() );
            UtilidadesLog.debug("respuesta: " + respuesta.toString() );
            UtilidadesLog.info("MONMantenimientoGruposZonasBean.obtenerZonasDeGrupo(DTOGruposZonas dtoGrupoZona):Salida");
            return new DTOSalida(respuesta);
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


    public Collection obtenerZonasNoAsignadas(Long pais, Long marca, Long canal) throws MareException {
        UtilidadesLog.info("MONMantenimientoGruposZonasBean.obtenerZonasNoAsignadas(Long pais, Long marca, Long canal):Entrada");
        BelcorpService belcorpService;
        String codigoError;
        RecordSet respuesta;
        StringBuffer query = new StringBuffer();

        try {
            belcorpService = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException mmsnfe) {
            UtilidadesLog.error(mmsnfe);
            codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            throw new MareException(mmsnfe,
                UtilidadesError.armarCodigoError(codigoError));
        }

        try {
            query.append("SELECT R.OID_REGI, R.ZSGV_OID_SUBG_VENT, Z.ZORG_OID_REGI, ");
            query.append("Z.COD_ZONA, Z.OID_ZONA, Z.CLIE_OID_CLIE, Z.ESZO_OID_ESTA_ZONA, Z.IND_ACTI, Z.IND_BORR, Z.COD_NSE1, Z.COD_NSE2, Z.COD_NSE3, COD_REGI, DES_REGI ");
            query.append("FROM ZON_REGIO R, ZON_ZONA Z ");
            query.append("WHERE R.OID_REGI = Z.ZORG_OID_REGI ");
            query.append("AND Z.IND_ACTI = 1 ");
            query.append("AND Z.IND_BORR = 0 ");
            query.append("AND NOT EXISTS ( SELECT D.ZZON_OID_ZONA ");
            query.append("FROM CRA_DETAL_GRUPO_ZONA D, CRA_CABEC_GRUPO_ZONA G ");
            query.append("WHERE G.PAIS_OID_PAIS = '" + pais + "' ");
            query.append("AND MARC_OID_MARC = '" + marca + "' ");
            query.append("AND CANA_OID_CANA =  '" + canal + "' ");
            query.append("AND D.CGZO_OID_CABE_GRUP_ZONA = G.OID_CABE_GRUP_ZONA ");
            query.append("AND D.ZZON_OID_ZONA = Z. OID_ZONA) ");
            query.append("UNION ");
            query.append("SELECT R.OID_REGI, null, null, null, null, null, null, null, null, null, null, null, COD_REGI, DES_REGI "); 
            query.append("FROM ZON_REGIO R, ZON_SUB_GEREN_VENTA S "); 
            query.append("WHERE R.ZSGV_OID_SUBG_VENT = S.OID_SUBG_VENT ");
            query.append("AND S.PAIS_OID_PAIS = '" + pais + "' ");
            query.append("ORDER BY 1");
            respuesta = belcorpService.dbService.executeStaticQuery(query.toString());
        } catch (Exception exception) {
            UtilidadesLog.error(exception);
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(exception,
                UtilidadesError.armarCodigoError(codigoError));
        }

        Vector registro = null;
        DTORegionesZonas dtoRegionZona;
        Collection regionesZonas = new ArrayList();
        Iterator ite = respuesta.getRecords().iterator();
        boolean shouldExit;

        if (ite.hasNext()) {
            registro = (Vector) ite.next();
            shouldExit = false;
        } else {
            shouldExit = true;
        }

        while (!shouldExit) {
            dtoRegionZona = new DTORegionesZonas();
            dtoRegionZona.setPais(pais);
            dtoRegionZona.setMarca(marca);
            dtoRegionZona.setCanal(canal);
            dtoRegionZona.setRegion((String)registro.get(12));
            dtoRegionZona.setDescripcionRegion((String)registro.get(13));            
            dtoRegionZona.setOidRegion(new Long(
                    ((BigDecimal) registro.get(0)).longValue()));
            dtoRegionZona.setZonas(new ArrayList());

            // when reach the 'null' we change the region
            while (!shouldExit && (registro.get(3) != null)) {
                DTOZonas zona = new DTOZonas();
                zona.setPais(pais);
                zona.setMarca(marca);
                zona.setCanal(canal);
                zona.setSubgerenciaVentas(((BigDecimal) registro.get(1)).toString());
                zona.setOidSubgerenciaVentas(new Long(
                        ((BigDecimal) registro.get(1)).longValue()));
                zona.setRegion(((BigDecimal) registro.get(0)).toString());
                zona.setOidRegion(new Long(
                        ((BigDecimal) registro.get(2)).longValue()));
                zona.setCodigoZona((String) registro.get(3));
                zona.setOidZona(new Long(
                        ((BigDecimal) registro.get(4)).longValue()));

                zona.setCodigoGerente(registro.get(5)!=null?((BigDecimal)registro.get(5)).toString():null);

                zona.setCodigoEstadoZona(registro.get(6)!=null?new Long(((BigDecimal) registro.get(6)).longValue()):null);
                zona.setActiva(new Integer(
                        ((BigDecimal) registro.get(7)).intValue()));
                zona.setBorrado(new Integer(
                        ((BigDecimal) registro.get(8)).intValue()));
                zona.setNse1((String) registro.get(9));
                zona.setNse2((String) registro.get(10));
                zona.setNse3((String) registro.get(11));

                dtoRegionZona.getZonas().add(zona);

                if (ite.hasNext()) {
                    registro = (Vector) ite.next();
                    shouldExit = false;
                } else {
                    shouldExit = true;
                }
            }

            regionesZonas.add(dtoRegionZona);

            if (!shouldExit) {
                if (ite.hasNext()) {
                    registro = (Vector) ite.next();
                    shouldExit = false;
                } else {
                    shouldExit = true;
                }
            }
        }
        UtilidadesLog.info("MONMantenimientoGruposZonasBean.obtenerZonasNoAsignadas(Long pais, Long marca, Long canal):Salida");
        return regionesZonas;
    }


    public DTOZonasGruposZonas obtenerZonasPorGruposZonas(DTOZonasGruposZonas gruposZonas) throws MareException {
        UtilidadesLog.info("MONMantenimientoGruposZonasBean.obtenerZonasPorGruposZonas( DTOZonasGruposZonas gruposZonas):Entrada");
        BelcorpService belcorpService;
        String codigoError;
        RecordSet respuesta;
        Vector zonasGrupos = new Vector();

        try {
            belcorpService = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException mmsnfe) {
            UtilidadesLog.error(mmsnfe);
            codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            throw new MareException(mmsnfe,
                UtilidadesError.armarCodigoError(codigoError));
        }

        // Se recorre la colección de grupos de zonas y se le va agregando 
        // las zonas a cada uno de los mismos.
        for (Iterator it = gruposZonas.getCodGrupoZona().iterator();
                it.hasNext();) {
            StringBuffer query = new StringBuffer();

            Long codGrupoZona = (Long) it.next(); //Debe llenarse con Long del lado cliente,
                                                  //en realidad en este caso codGrupoZona es el oid de Grupo

            try {
                query.append(
                    " SELECT D.ZZON_OID_ZONA, D.OID_DETA_GRUP_ZONA, Z.ZORG_OID_REGI, R.ZSGV_OID_SUBG_VENT, Z.COD_ZONA, R.COD_REGI");
                query.append(
                    " FROM CRA_DETAL_GRUPO_ZONA D, ZON_ZONA Z, CRA_CABEC_GRUPO_ZONA C, ZON_REGIO R");
                query.append(" WHERE C.OID_CABE_GRUP_ZONA = '" + codGrupoZona +
                    "' ");
                query.append(
                    " AND D.CGZO_OID_CABE_GRUP_ZONA = C.OID_CABE_GRUP_ZONA");
                query.append(" AND D.ZZON_OID_ZONA = Z.OID_ZONA");
                query.append(" AND Z.ZORG_OID_REGI = R.OID_REGI");

                respuesta = belcorpService.dbService.executeStaticQuery(query.toString());
            } catch (Exception exception) {
                UtilidadesLog.error(exception);
                codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
                throw new MareException(exception,
                    UtilidadesError.armarCodigoError(codigoError));
            }

            Vector zonas = new Vector();
            Iterator ite = respuesta.getRecords().iterator();

            while (ite.hasNext()) {
                Vector registro = (Vector) ite.next();

                DTOZonas dtoZona = new DTOZonas();
                dtoZona.setCodigoZona((String) registro.elementAt(4));
                dtoZona.setOidZona(new Long(
                        ((BigDecimal) registro.elementAt(0)).longValue()));
                dtoZona.setRegion((String) registro.elementAt(5));
                dtoZona.setOidRegion(new Long(
                        ((BigDecimal) registro.elementAt(2)).longValue()));
                dtoZona.setOidSubgerenciaVentas(new Long(
                        ((BigDecimal) registro.elementAt(3)).longValue()));
                dtoZona.setPais(gruposZonas.getPais());
                dtoZona.setMarca(gruposZonas.getMarca());
                dtoZona.setCanal(gruposZonas.getCanal());

                zonas.add(dtoZona);
            }

            zonasGrupos.add(zonas);
        }

        gruposZonas.setZonasGrupos(zonasGrupos);
        UtilidadesLog.info("MONMantenimientoGruposZonasBean.obtenerZonasPorGruposZonas( DTOZonasGruposZonas gruposZonas):Salida");
        return gruposZonas;
    }


    private void eliminaZonasAPartirDeEstructura(Collection allGroups) throws MareException {
        UtilidadesLog.info("MONMantenimientoGruposZonasBean.eliminaZonasAPartirDeEstructura(Collection allGroups):Entrada");
        String codigoError;
        Iterator iteradorGrupos = allGroups.iterator();

        try {
            while (iteradorGrupos.hasNext()) {
                DTOCabecerasGruposZonas dtoCabeceraGZ = (DTOCabecerasGruposZonas) iteradorGrupos.next();
                Long oidGrupo = dtoCabeceraGZ.getOidGrupo();

                // Se consultan todos los detalles que hay en CRA_DETAL_GRUPO_ZONA
                DetalleGruposZonasLocalHome dgzlh = new DetalleGruposZonasLocalHome();
                Collection detalles = dgzlh.findByCabeceraPK(oidGrupo);
                Iterator iterator = detalles.iterator();

                UtilidadesLog.debug("collection en tabla"+ detalles);

                while (iterator.hasNext()) {
                    DetalleGruposZonasLocal detalleTabla = (DetalleGruposZonasLocal) iterator.next();

                    Long oidDetalle = detalleTabla.getOid();

                    if (!estaEnEstructura(dtoCabeceraGZ.getZonas(), oidDetalle)) {
                        UtilidadesLog.debug("ENTIDAD A BORRAR (Grupo: " +
                            detalleTabla.getOidGrupoZona() + "  Zona: " +
                            detalleTabla.getOidZona() + "  Detalle: " +
                            detalleTabla.getOid());
                        dgzlh.remove(detalleTabla);                            
                    }
                    UtilidadesLog.debug("salida"+!estaEnEstructura(dtoCabeceraGZ.getZonas(), oidDetalle));
                }
            }
        } catch (NoResultException finderException) {
            UtilidadesLog.debug(finderException);
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(finderException,
                UtilidadesError.armarCodigoError(codigoError));
        } catch (PersistenceException removeException) {
            UtilidadesLog.debug(removeException);
            codigoError = CodigosError.ERROR_DE_BORRADO_DE_DATOS;
            throw new MareException(removeException,
                UtilidadesError.armarCodigoError(codigoError));
        }
        UtilidadesLog.info("MONMantenimientoGruposZonasBean.eliminaZonasAPartirDeEstructura(Collection allGroups):Salida");
    }

    private boolean estaEnEstructura(Collection zonas, Long oidDetalleTabla) {
        UtilidadesLog.info("MONMantenimientoGruposZonasBean.estaEnEstructura(Collection zonas, Long oidDetalleTabla):Entrada");
        Iterator iteradorZonas = zonas.iterator();
        boolean esta = false;
        UtilidadesLog.debug("DATOS EN LA TABLA : (Detalle: " + oidDetalleTabla);

        if (!zonas.isEmpty()) {
            while (iteradorZonas.hasNext()) {
                DTODetallesGruposZonas detalleGZ = (DTODetallesGruposZonas) iteradorZonas.next();
                String detalle = detalleGZ.getCodigoGrupoDetalle(); //cambio a oid
                Long oidDetalleEstructura = detalleGZ.getOidDetalle();
                String subgerencia = detalleGZ.getZona().getSubgerenciaVentas(); //no lo  uso
                String region = detalleGZ.getZona().getRegion(); //no lo  uso
                String zona = detalleGZ.getZona().getCodigoZona(); //no lo  uso
                UtilidadesLog.debug("DATOS EN LA ESTRUCTURA : (Zona: " + zona +
                    " Detalle: " + detalle + " Subgerencia: " + subgerencia +
                    " Region: " + region + " )");

                if (oidDetalleEstructura.equals(oidDetalleTabla)) {
                    esta = true;
                }
            }
        }

        UtilidadesLog.info("MONMantenimientoGruposZonasBean.estaEnEstructura(Collection zonas, Long oidDetalleTabla):Salida");
        return esta;
    }


    private void insertaZonasAPartirDeEstructura(Collection allGroups) throws MareException {
        UtilidadesLog.info("MONMantenimientoGruposZonasBean.insertaZonasAPartirDeEstructura(Collection allGroups):Entrada");
        BelcorpService belcorpService;
        String codigoError;

        DTOCabecerasGruposZonas dtoCabeceraGZ;
        Iterator iteradorGrupos = allGroups.iterator();

        try {
            belcorpService = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException mmsnfe) {
            codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            UtilidadesLog.error(mmsnfe);
            throw new MareException(mmsnfe,
                UtilidadesError.armarCodigoError(codigoError));
        }

        // Iteración para detectar registros a insertar (si esta en la 
        // estructura pero no esta en la tabla, lo inserto)
        while (iteradorGrupos.hasNext()) {
            StringBuffer query = new StringBuffer();
            RecordSet respuesta = new RecordSet();

            dtoCabeceraGZ = (DTOCabecerasGruposZonas) iteradorGrupos.next();

            Long oidGrupo = dtoCabeceraGZ.getOidGrupo();
            Iterator iteradorZonas = dtoCabeceraGZ.getZonas().iterator();

            try {
                query.append(
                    "SELECT ZZON_OID_ZONA, OID_DETA_GRUP_ZONA, CGZO_OID_CABE_GRUP_ZONA ");
                query.append("FROM CRA_DETAL_GRUPO_ZONA ");
                query.append("WHERE CGZO_OID_CABE_GRUP_ZONA = " + oidGrupo);

                respuesta = belcorpService.dbService.executeStaticQuery(query.toString());
            } catch (Exception exception) {
                UtilidadesLog.error(exception);
                codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
                throw new MareException(exception,
                    UtilidadesError.armarCodigoError(codigoError));
            }

            while (iteradorZonas.hasNext()) {
                DTODetallesGruposZonas dtoDetalleGZ = (DTODetallesGruposZonas) iteradorZonas.next();
                DTOZonas dtoZonas = dtoDetalleGZ.getZona();
                Long oidZona = dtoZonas.getOidZona();

                if (!estaEnLaTabla(respuesta, oidZona, oidGrupo)) {
                    // Insertar el nuevo registro                    
                    try {
                        DetalleGruposZonasLocalHome dgzlh = new DetalleGruposZonasLocalHome();
                        dgzlh.create(oidZona, oidGrupo);
                    } catch (EntityExistsException e) {
                        UtilidadesLog.debug(e);
                        ctx.setRollbackOnly();
                        throw new MareException(e,
                            UtilidadesError.armarCodigoError(
                                CodigosError.ERROR_DE_CLAVE_DUPLICADA));
                    } catch (PersistenceException e) {
                        UtilidadesLog.error(e);
                        ctx.setRollbackOnly();
                        throw new MareException(e,
                            UtilidadesError.armarCodigoError(
                                CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                    }
                }
            }
        }
        UtilidadesLog.info("MONMantenimientoGruposZonasBean.insertaZonasAPartirDeEstructura(Collection allGroups):Salida");
    }


    private boolean estaEnLaTabla(RecordSet tabla, Long paramOidZona, Long paramOidGrupo) {
        UtilidadesLog.info("MONMantenimientoGruposZonasBean.estaEnLaTabla(RecordSet tabla, Long paramOidZona, Long paramOidGrupo):Entrada");
        int cantidadFilas = tabla.getRowCount();
        boolean esta = false;

        if (!tabla.esVacio()) {
            for (int i = 0; i < cantidadFilas; i++) {
                Vector filaActual = tabla.getRow(i);
                Long oidZona = new Long(((BigDecimal)filaActual.elementAt(0)).longValue());
                Long oidGrupo = new Long(((BigDecimal)filaActual.elementAt(2)).longValue());

                if ((oidZona.equals(paramOidZona)) && (oidGrupo.equals(paramOidGrupo))) {
                    esta = true;
                }
            }
        }
        UtilidadesLog.info("MONMantenimientoGruposZonasBean.estaEnLaTabla(RecordSet tabla, Long paramOidZona, Long paramOidGrupo):Salida");
        return esta;
    }

  
  public DTOSalida obtenerZonasNoAsignadasPorRegion(Long pais, Long marca, Long canal, Long OidRegion) throws MareException {
        UtilidadesLog.info("MONMantenimientoGruposZonasBean.obtenerZonasNoAsignadasPorRegion(Long pais, Long marca, Long canal, Long OidRegion):Entrada");
        BelcorpService belcorpService;
        String codigoError;
        RecordSet respuesta;
        StringBuffer query = new StringBuffer();
        String usuario = ctx.getCallerPrincipal().getName();

        try {
            belcorpService = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException mmsnfe) {
            UtilidadesLog.error(mmsnfe);
            codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            throw new MareException(mmsnfe,
                UtilidadesError.armarCodigoError(codigoError));
        }

        try {
            query.append("SELECT  Z.OID_ZONA , Z.DES_ZONA ");//R.OID_REGI,Z.COD_ZONA R.ZSGV_OID_SUBG_VENT
            query.append("FROM VCA_ZON_REGIO R, VCA_ZON_ZONA Z, ZON_REGIO R2 ");
            query.append("WHERE R.OID_REGI = Z.ZORG_OID_REGI "); 
            if (OidRegion!=null){
                query.append("AND R.OID_REGI = '" + OidRegion + "' ");
            }
            query.append("AND Z.IND_ACTI = 1 ");
            query.append("AND Z.IND_BORR = 0 ");
            query.append("AND R.IND_ACTI = 1 ");
            query.append("AND R.IND_BORR = 0 ");
            query.append("AND Z.COD_USUA = '"+usuario+"' ");
            query.append("AND R.COD_USUA = '"+usuario+"' ");
            //Para que las zonas obtenidas pertenezcan al pais, marca y canal (Inc. 6590)
            query.append(" AND R.OID_REGI = R2.OID_REGI ");
            query.append(" AND R2.PAIS_OID_PAIS = " + pais + " ");
            query.append(" AND R2.MARC_OID_MARC = " + marca + " ");
            query.append(" AND R2.CANA_OID_CANA =  " + canal + " ");

            query.append("AND NOT EXISTS ( SELECT D.ZZON_OID_ZONA ");
            query.append("FROM CRA_DETAL_GRUPO_ZONA D, CRA_CABEC_GRUPO_ZONA G "); 
            query.append("WHERE G.PAIS_OID_PAIS = '" + pais + "' ");
            if (marca!=null){
                query.append("AND MARC_OID_MARC = '" + marca + "' ");
            }
            if (canal!=null){
                query.append("AND CANA_OID_CANA =  '" + canal + "'  ");
            }
            query.append("AND D.CGZO_OID_CABE_GRUP_ZONA = G.OID_CABE_GRUP_ZONA "); 
            query.append("AND D.ZZON_OID_ZONA = Z. OID_ZONA) ");
            
            respuesta = belcorpService.dbService.executeStaticQuery(query.toString());
        } catch (Exception exception) {
            UtilidadesLog.error(exception);
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(exception,
                UtilidadesError.armarCodigoError(codigoError));
        }
        UtilidadesLog.info("MONMantenimientoGruposZonasBean.obtenerZonasNoAsignadasPorRegion(Long pais, Long marca, Long canal, Long OidRegion):Salida");
        return new DTOSalida(respuesta);
  }



    private MONValidacionHome getMONValidacionHome() throws NamingException {
        final InitialContext context = new InitialContext();
        return (MONValidacionHome)PortableRemoteObject.narrow(context.lookup("java:comp/env/MONValidacion"), MONValidacionHome.class);
    }


  public DTOSalida obtenerZonasNoAsignadasPorRegion(DTOGrupoZonas dto) throws MareException {
        try {
            UtilidadesLog.info("MONMantenimientoGruposZonasBean.obtenerZonasNoAsignadasPorRegion(DTOGrupoZonas dto):Entrada");
            Long pais = dto.getOidPais();
            Long marca = dto.getOidMarca();
            Long canal = dto.getOidCanal();
            Long region = dto.getOidRegion();
            
            DTOSalida dtoRes = this.obtenerZonasNoAsignadasPorRegion(pais, marca, canal, region);
            UtilidadesLog.info("MONMantenimientoGruposZonasBean.obtenerZonasNoAsignadasPorRegion(DTOGrupoZonas dto):Salida");
            return dtoRes;
            
        } catch (MareException ex) {
            UtilidadesLog.error(ex);
            throw ex;
        }
  }

  public DTOSalida obtieneGruposZona(DTOGrupoZonas dto) throws MareException {
        UtilidadesLog.info("MONMantenimientoGruposZonasBean.obtieneGruposZona(DTOGrupoZonas dto):Entrada");
        BelcorpService belcorpService;
        String codigoError;
        RecordSet respuesta;
        StringBuffer query = new StringBuffer();

        try {
            belcorpService = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException mmsnfe) {
            UtilidadesLog.error(mmsnfe);
            codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            throw new MareException(mmsnfe,
                UtilidadesError.armarCodigoError(codigoError));
        }

        try {
        
            Long pais = dto.getOidPais();
            Long marca = dto.getOidMarca();
            Long canal = dto.getOidCanal();
            Long idioma = dto.getOidIdioma();
                   
            query.append(" SELECT cab.OID_CABE_GRUP_ZONA, i18n.VAL_I18N NOMBRE ");
            query.append(" FROM CRA_CABEC_GRUPO_ZONA cab, V_GEN_I18N_SICC i18n ");
            query.append(" WHERE i18n.VAL_OID = cab.OID_CABE_GRUP_ZONA ");
            query.append(" AND i18n.ATTR_ENTI = 'CRA_CABEC_GRUPO_ZONA' ");             
            query.append(" AND i18n.IDIO_OID_IDIO = '" + idioma + "' ");
            if (pais!=null)
              query.append(" AND cab.PAIS_OID_PAIS = '" + pais + "' ");
            if (marca!=null)
              query.append(" AND cab.MARC_OID_MARC = '" + marca + "' ");
            if (canal!=null)
              query.append(" AND cab.CANA_OID_CANA = '" + canal + "' ");

            respuesta = belcorpService.dbService.executeStaticQuery(query.toString());
            
        } catch (Exception exception) {
            UtilidadesLog.error(exception);
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(exception,
                UtilidadesError.armarCodigoError(codigoError));
        }
        UtilidadesLog.info("MONMantenimientoGruposZonasBean.obtieneGruposZona(DTOGrupoZonas dto):Salida");
        return new DTOSalida(respuesta);
  }


  public DTOSalida obtieneTiposFacturacion(DTOBelcorp dto) throws MareException {
        UtilidadesLog.info("MONMantenimientoGruposZonasBean.obtieneTiposFacturacion(DTOBelcorp dto):Entrada");
        BelcorpService belcorpService;
        String codigoError;
        RecordSet respuesta;
        StringBuffer query = new StringBuffer();

        try {
            belcorpService = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException mmsnfe) {
            UtilidadesLog.error(mmsnfe);
            codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            throw new MareException(mmsnfe,
                UtilidadesError.armarCodigoError(codigoError));
        }

        try {

            query.append(" SELECT cra.oid_tipo_fact, cra.des_tipo_fact ");
            query.append(" FROM cra_tipo_factu cra ");
            query.append(" ORDER BY cra.des_tipo_fact ");

            respuesta = belcorpService.dbService.executeStaticQuery(query.toString());
            
        } catch (Exception exception) {
            UtilidadesLog.error(exception);
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(exception,
                UtilidadesError.armarCodigoError(codigoError));
        }
        UtilidadesLog.info("MONMantenimientoGruposZonasBean.obtieneTiposFacturacion(DTOBelcorp dto):Salida");
        return new DTOSalida(respuesta);
  }

    
    public Long obtieneGrupoPMCZ(Long oidPais, Long oidMarca, Long oidCanal, Long oidZona) throws MareException {
        UtilidadesLog.info("MONMantenimientoGruposZonasBean.obtieneGrupoPMCZ(Long oidPais, Long oidMarca, Long oidCanal, Long oidZona):Entrada");
        DAOCRA daoCra = new DAOCRA();
        RecordSet rs = daoCra.obtieneGrupoPMCZ(oidPais, oidMarca, oidCanal, oidZona);
        
        if ((!rs.esVacio() && (rs.getValueAt(0, "OID")!=null))) {
            UtilidadesLog.info("MONMantenimientoGruposZonasBean.obtieneGrupoPMCZ(Long oidPais, Long oidMarca, Long oidCanal, Long oidZona):Salida");
            return new Long(rs.getValueAt(0, "OID").toString());
        } else {
            UtilidadesLog.info("MONMantenimientoGruposZonasBean.obtieneGrupoPMCZ(Long oidPais, Long oidMarca, Long oidCanal, Long oidZona):Salida");
            return null;
        }
    }
    
    
    /**
	 * Sistema:     Belcorp
	 * Modulo:      CRA
	 * Fecha:       04/08/2005
	 * @version     1.0
	 * @autor       mmaidana
	 */    
    public DTOSalida obtenerTipoFacturacion(DTOOID dto) throws MareException {
        UtilidadesLog.info("MONMantenimientoGruposZonasBean.obtenerTipoFacturacion(DTOOID dto):Entrada");
        DAOCRA dao = new DAOCRA();
        UtilidadesLog.info("MONMantenimientoGruposZonasBean.obtenerTipoFacturacion(DTOOID dto):Salida");        
        return dao.obtenerTipoFacturacion(dto);
    }
    
}