package es.indra.sicc.logicanegocio.dto;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.entidades.dto.*;
import es.indra.sicc.util.UtilidadesEJB;

import es.indra.sicc.cmn.negocio.i18n.Entidadi18nLocalHome;
import es.indra.sicc.cmn.negocio.i18n.Entidadi18nLocal;
import es.indra.sicc.cmn.negocio.i18n.DTOI18nSICC;

import javax.ejb.RemoveException;
import javax.ejb.FinderException;
import javax.ejb.CreateException;
import javax.ejb.SessionContext;

import es.indra.sicc.util.CMNEjbLocators;

import java.math.BigDecimal;

import java.util.Iterator;
import java.util.Vector;
import java.util.Collection;

import javax.ejb.EJBLocalHome;

import es.indra.sicc.cmn.negocio.i18n.*;

import es.indra.sicc.util.UtilidadesLog;

import javax.persistence.EntityExistsException;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;

public class UtilidadesDTO  {
	
	public static RecordSet getQuery(String sQuery)throws MareException {
		BelcorpService bs = null;
		try {
			bs = BelcorpService.getInstance();
		} catch(MareMiiServiceNotFoundException ex) {
			throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
		}
		RecordSet r = null;		
		try { 
			r = bs.dbService.executeStaticQuery(sQuery);
		} catch(Exception e) {
			throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
		}
		return r;
	}

	public static RecordSet getQuery(String sQuery, Vector bindVars)throws MareException {
		BelcorpService bs = null;
		try {
			bs = BelcorpService.getInstance();
		} catch(MareMiiServiceNotFoundException ex) {
			throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
		}
		RecordSet r = null;		
		try { 
			r = bs.dbService.executePreparedQuery(sQuery,bindVars);
		} catch(Exception e) {
			throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
		}
		return r;
	}

	public static Boolean getBoole(Long num) {
		return (num.intValue()==1)?Boolean.TRUE:Boolean.FALSE;
	}

	public static Boolean getBoole(String flag) {
		try{
			return (Integer.parseInt(flag)==1)?Boolean.TRUE:Boolean.FALSE;
		}catch(NumberFormatException e) {
			return Boolean.TRUE;
		}
		
	}
	

	public static Object[] vec2Array(Vector vec){
        Iterator iter = vec.iterator();
        Object[] objs = new Object[vec.size()] ;
        for(int i = 0; iter.hasNext() ; i++){
            objs[i] = iter.next();
        }
        return objs;
    }
	public static Long[] vec2Longs(Vector vec){
        Iterator iter = vec.iterator();
        Long[] objs = new Long[vec.size()] ;
        for(int i = 0; iter.hasNext() ; i++){
            objs[i] = (Long)iter.next();
        }
        return objs;
    }

    public static Long[] vec2LongsBD(Vector vec){
        Iterator iter = vec.iterator();
        Long[] objs = new Long[vec.size()] ;
        for(int i = 0; iter.hasNext() ; i++){
            objs[i] = getLongFromBigDecimal((BigDecimal)iter.next());
        }
        return objs;
    }


    public static Long getLongFromBigDecimal(BigDecimal object){
        return new Long(object.longValue());
    }

    public static Long getLong(Object obj){
        return getLongFromBigDecimal((BigDecimal) obj);
    }

	public static Long getLong(Boolean flag ) {
		return new Long(((flag.booleanValue())?1:0));
	}

    public static Integer getIntegerFromBigDecimal(BigDecimal object){
        return new Integer(object.intValue());
    }

    public static Integer getInteger(Object obj){
        return getIntegerFromBigDecimal((BigDecimal) obj);
    }

    public static void eliminarTraducciones(String entidad,Long nroAtributo, Long oid) throws MareException{
        String codigoError = null;
    
        try  {

            Entidadi18nLocalHome e18nLH = new Entidadi18nLocalHome();
            Collection col = e18nLH.findByEntAtrPK(entidad,nroAtributo,oid);
            Iterator it = col.iterator();

            while (it.hasNext())  {
                Entidadi18nLocal e18nLocal = (Entidadi18nLocal)it.next();
                e18nLH.remove(e18nLocal);
            }            
        } catch (NoResultException ex)  {
            codigoError = CodigosError.ERROR_CLAVE_INVALIDA;
            throw new MareException(ex,UtilidadesError.armarCodigoError(codigoError));
        } catch (PersistenceException ex)  {
            codigoError = CodigosError.ERROR_DE_BORRADO_DE_DATOS;
            throw new MareException(ex,UtilidadesError.armarCodigoError(codigoError));
        }
    }

    public static void insertarTraducciones(String entidad, Long oid, Vector valores, SessionContext ctx) throws MareException {
        Iterator iteValores;
        DTOI18nSICC valor;

        for (iteValores = valores.iterator(); iteValores.hasNext();) {
            valor = (DTOI18nSICC) iteValores.next();
            if (valor != null) {
                UtilidadesLog.debug("entidad: " + entidad);
                UtilidadesLog.debug("oid: " + oid);
                UtilidadesLog.debug("valor: " + valor);
                UtilidadesLog.debug("ctx: " + ctx);                

                insertarTraduccion(entidad, oid, valor, ctx);
            }
        }
    }

          
        
    private static Long insertarTraduccion(String entidad, Long oid, DTOI18nSICC valor, SessionContext ctx) throws MareException {
        String codigoError;
        Entidadi18nLocalHome localHome;
        Entidadi18nLocal local;
        localHome = new Entidadi18nLocalHome();

        try {
            local = localHome.findByEntAtrIdioPK(entidad,valor.getOidAtriuto(), valor.getOidIdioma(), oid);
            local.setDetalle(valor.getValorI18n());
            return local.getOid();
            
        } catch (NoResultException fe) {
            try {
                return localHome.create(entidad, valor.getOidAtriuto(),valor.getOidIdioma(), valor.getValorI18n(), oid).getOid();
            } catch (PersistenceException pe) {
                ctx.setRollbackOnly();
                codigoError = CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS;
                throw new MareException(pe,UtilidadesError.armarCodigoError(codigoError));
            }
        }
    }

    public static Vector recuperarTraducciones(String entidad, Long oid) throws MareException {
        Vector vDescripciones = new Vector();

        String sQuery = " SELECT v.val_i18n, v.idio_oid_idio " +
        "  FROM v_gen_i18n_sicc v  "  +
        "  WHERE v.val_oid = " + oid.toString() + 
        "    AND v.attr_enti = '" + entidad + "'";

        RecordSet r = getQuery(sQuery);

        for (int i=0; i<r.getRowCount(); i++)  {

            DTOI18nSICC dtoi18n = new DTOI18nSICC();
            dtoi18n.setValorI18n((String) r.getValueAt(i,0));
            dtoi18n.setOidIdioma(getLong(r.getValueAt(i,1)));
            dtoi18n.setOidAtriuto(new Long(1));
            vDescripciones.add(dtoi18n);
        }
        return vDescripciones;
    }

        

    
}