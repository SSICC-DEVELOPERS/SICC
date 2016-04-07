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

package es.indra.sicc.cmn.negocio.i18n;

import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import es.indra.sicc.util.CMNEjbLocators;
import es.indra.sicc.cmn.negocio.i18n.DTOI18nSICC;

import java.util.Vector;
import java.util.Iterator;
import java.util.Collection;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;


/**
 * Sistema:           Belcorp
 * Modulo:            CMN - Requisitos Generales
 * Componente:        MONI18nBean - Clase Bean
 * Fecha:             03/12/2003
 * Observaciones:     Basado en Modelo de Componentes SICC-DMCO-GEN-201-310
 *
 * @version           1.0
 * @autor             Gustavo De Marzi
 */


public class MONI18nBean implements SessionBean {

    private SessionContext ctx;
    private BelcorpService belcorpService;


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


    /**
     * Recupera, para un entidad segun el nombre de la tabla y el oid de la entidad,
     * un dtoSalida con un recordSet de:
     * - OIDs de idiomas. 
     * - Traducción por cada idioma.
     */
    public DTOSalida recuperarTraducciones(String entidad, Long pk) throws MareException {
        UtilidadesLog.info("MONI18nBean.recuperarTraducciones(): Entrada");

        try {
            belcorpService = BelcorpService.getInstance();

            StringBuffer query = new StringBuffer();
            query.append(" select IDIO_OID_IDIO, VAL_I18N ");
            query.append(" from GEN_I18N_SICC ");
            query.append(" where ATTR_ENTI = ? and VAL_OID = ? ");
            Vector parametros = new Vector();
            parametros.add(entidad);
            parametros.add(pk);

            RecordSet traducciones = belcorpService.dbService.executePreparedQuery(query.toString(),parametros);

            UtilidadesLog.info("MONI18nBean.recuperarTraducciones(): Salida");
            return new DTOSalida(traducciones);

        } catch (MareMiiServiceNotFoundException serviceNotFoundException) {
            throw new MareException(serviceNotFoundException,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        } catch (Exception exception) {
            throw new MareException(exception,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
    }

    /*
     * Inserta traducciones en la entidad I18N
     */
    public void insertarTraducciones(String entidad, Long oid, Vector valores) throws MareException {
        UtilidadesLog.info("MONI18nBean.insertarTraducciones(String entidad, Long oid, Vector valores): Entrada");
        Iterator iteValores;
        DTOI18nSICC valor;
        
        for (iteValores = valores.iterator();
             iteValores.hasNext();) {
            valor = (DTOI18nSICC)iteValores.next();

            if (valor!=null) {
                insertarTraduccion(entidad,oid,valor);
            }
        }
        UtilidadesLog.info("MONI18nBean.insertarTraducciones(String entidad, Long oid, Vector valores): Salida");
    }

    private Long insertarTraduccion (String entidad, Long oid, DTOI18nSICC valor) throws MareException {
        UtilidadesLog.info("MONI18nBean.insertarTraducciones(String entidad, Long oid, DTOI18nSICC valor): Entrada");

        String codigoError;
        Entidadi18nLocalHome localHome;
        Entidadi18nLocal local;
        localHome = new Entidadi18nLocalHome();

            try {
                local = localHome.findByEntAtrIdioPK(entidad,
                                             valor.getOidAtriuto(),
                                             valor.getOidIdioma(),
                                             oid);

                //local.setDetalle(valor.getValorI18n());
                //  Modificado por HRCS - Incidencia Sicc20080595
                StringBuffer consulta = new StringBuffer(); 
                Vector parametros = new Vector();
                consulta.append("UPDATE GEN_I18N_SICC ");
                consulta.append("SET VAL_I18N = ? ");
                parametros.add(valor.getValorI18n());
                consulta.append("WHERE OID_I18N = ? ");
                parametros.add(local.getOid());
                consulta.append("  AND ATTR_ENTI = ? ");
                parametros.add(entidad);
                
                belcorpService = belcorpService = BelcorpService.getInstance();
                try {
                    belcorpService.dbService.executePreparedUpdate(consulta.toString(), parametros);
                } catch(Exception e) {
                    UtilidadesLog.error(e);
                    codigoError = CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS;
                    throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
                }
      
                UtilidadesLog.info("MONI18nBean.insertarTraducciones(String entidad, Long oid, DTOI18nSICC valor): Salida");
                return local.getOid();
            } catch (NoResultException nre) {
                try {
                    UtilidadesLog.info("MONI18nBean.insertarTraducciones(String entidad, Long oid, DTOI18nSICC valor): Salida");
                    return localHome.create(entidad,
                                            valor.getOidAtriuto(),
                                            valor.getOidIdioma(),
                                            valor.getValorI18n(),
                                            oid).getOid();
                } catch (PersistenceException pe) {
                   ctx.setRollbackOnly();
                   codigoError = CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS;
                   throw new MareException(pe,UtilidadesError.armarCodigoError(codigoError));         
                }
            } catch (PersistenceException pe) {
                ctx.setRollbackOnly();
                codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
                throw new MareException(pe,UtilidadesError.armarCodigoError(codigoError));
            }
    }

    public void eliminarTraducciones(String entidad, Long oidPK) throws MareException {
        UtilidadesLog.info("MONI18nBean.eliminarTraducciones(String entidad, Long oidPK): Entrada");
        String codigoError;
        Entidadi18nLocalHome localHome;
        Collection traducciones;
        localHome = new Entidadi18nLocalHome();

            try {
                traducciones = localHome.findByEntPK(entidad,
                                                       oidPK);
                UtilidadesLog.debug("Cantidad traducciones -> eliminarTraducciones : "+traducciones.size());
                for (Iterator ite = traducciones.iterator();
                     ite.hasNext();) {
                    localHome.remove((Entidadi18nLocal)ite.next());
                }
            } catch (PersistenceException re) {
                UtilidadesLog.error("RemoveException en -> eliminarTraducciones : "+re.getMessage());
                ctx.setRollbackOnly();
                codigoError = CodigosError.ERROR_DE_BORRADO_DE_DATOS;
                throw new MareException(re,UtilidadesError.armarCodigoError(codigoError));
            }
        UtilidadesLog.info("MONI18nBean.eliminarTraducciones(String entidad, Long oidPK): Salida");
    }

	public DTOSalida recuperarTraducciones(String entidad, Long oid, Long idioma) throws MareException {
		return recuperarTraducciones(entidad, oid, idioma, new Byte("1"));
	}

	public DTOSalida recuperarTraducciones(String entidad, Long oid, Long idioma, Byte atributo) throws MareException {
        UtilidadesLog.info("MONI18nBean.recuperarTraducciones(String entidad, Long oid, Long idioma, Byte atributo): Entrada");
        try {
            belcorpService = BelcorpService.getInstance();

            StringBuffer query = new StringBuffer();
            query.append(" SELECT VAL_I18N FROM V_GEN_I18N_SICC ");
            query.append(" WHERE ATTR_ENTI = '"+ entidad +"' AND ");
            query.append(" ATTR_NUM_ATRI = "+ atributo +" AND ");			
            query.append(" IDIO_OID_IDIO = "+ idioma +" AND  ");			
            query.append(" VAL_OID = "+ oid + " ");						
//            query.append(" where ATTR_ENTI = ? and VAL_OID = ? ");

            RecordSet traducciones = belcorpService.dbService.executeStaticQuery(query.toString());

            UtilidadesLog.info("MONI18nBean.recuperarTraducciones(String entidad, Long oid, Long idioma, Byte atributo): Salida");
            return new DTOSalida(traducciones);

        } catch (MareMiiServiceNotFoundException serviceNotFoundException) {
            throw new MareException(serviceNotFoundException,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        } catch (Exception exception) {
            throw new MareException(exception,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
    }

    
    public void actualizaTraducciones (String entidad, Long oid, Vector valores) throws MareException {
        UtilidadesLog.info("MONI18nBean.actualizaTraducciones(): Entrada");
        Long oidIdioma = null;
        String descripcion = null;
        Entidadi18nLocalHome e18nLH = null;
        Entidadi18nLocal e18nL = null;
        Iterator iteValores;
        DTOI18nSICC dtoTraduccion;
        
        e18nLH = new Entidadi18nLocalHome();

		if (valores != null){
		
			for (iteValores = valores.iterator(); iteValores.hasNext();) {
				try{
					dtoTraduccion = (DTOI18nSICC)iteValores.next();
					oidIdioma = dtoTraduccion.getOidIdioma();
					descripcion = dtoTraduccion.getValorI18n();

					e18nL = e18nLH.findByEntAtrIdioPK( entidad, dtoTraduccion.getOidAtriuto(), oidIdioma, oid );
            
					if (descripcion!=null && !descripcion.trim().equals("")){
						e18nL.setDetalle( descripcion );
                                                e18nLH.merge(e18nL);
                                        }else{
						e18nLH.remove(e18nL);
					}            
				}catch (NoResultException nre){
					try{
						if (descripcion!=null && !descripcion.trim().equals(""))
							e18nLH.create(entidad, new Long("1"), oidIdioma, descripcion, oid);
					} catch(PersistenceException pe){
						ctx.setRollbackOnly();
						pe.printStackTrace();
						throw new MareException(pe,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
					}
				}catch (PersistenceException pe){
					  ctx.setRollbackOnly();
					  pe.printStackTrace();
					  throw new MareException(pe,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
				}
			}
		}
        UtilidadesLog.info("MONI18nBean.actualizaTraducciones(): Salida");
    }

}