/**
 * Copyright 2004 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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
package es.indra.sicc.logicanegocio.fac;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

import es.indra.sicc.dtos.fac.DTOTipoOfertaExcluido;
import es.indra.sicc.entidades.fac.TiposOfertaExcluidosLocal;
import es.indra.sicc.entidades.fac.TiposOfertaExcluidosLocalHome;
import es.indra.sicc.logicanegocio.seg.ConstantesSEG;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;

import java.sql.Timestamp;

import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;


public class MONTipoOfertaExcluidoBean implements SessionBean {
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

    /**
     * @author Guido Pons
     * @date 03/07/2006
     * @throws es.indra.mare.common.exception.MareException
     * @param dto
     */
    public void actualizarTipoOfertaExcluido(DTOTipoOfertaExcluido dto)
        throws MareException {
        
        UtilidadesLog.info("MONTipoOfertaExcluidoBean.actualizarTipoOfertaExcluido(DTOTipoOfertaExcluido dto): Entrada ");

        DAOTipoOfertaExcluido dao = new DAOTipoOfertaExcluido();
        RecordSet fechasSolapadas = dao.obtenerTipoOferExcluidoFechasSolapadas(dto);

        // Si ( fechasSolapadas != null ) // existen registros con mismo pais y Tipo de oferta con fechas solapadas 
        if (fechasSolapadas != null) {
            MareException me = new MareException(new Exception(),
                    UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_FAC,
                    ErroresDeNegocio.FAC_0007));
            UtilidadesLog.error(me);
            //Sacar
            UtilidadesLog.info("Cod Error: " + UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_FAC,
                              ErroresDeNegocio.FAC_0007));
            throw me;
        }

        TiposOfertaExcluidosLocalHome tipoOfertaExcluidosLocalHome = this.getTiposOfertaExcluidosLocalHome();
        TiposOfertaExcluidosLocal tiposOfertaExcluidosLocal = null;

        if (dto.getOid() == null) {
            try {
                tiposOfertaExcluidosLocal = tipoOfertaExcluidosLocalHome.create(dto.getOidPais(),
                        dto.getOidTipoOferta(),
                        new Timestamp(dto.getFechaDesde().getTime()),
                        new Timestamp(dto.getFechaHasta().getTime()));
            } catch (PersistenceException ce) {
            }
        } else {
            try {
                tiposOfertaExcluidosLocal = tipoOfertaExcluidosLocalHome.findByPrimaryKey(dto.getOid());

                
                tiposOfertaExcluidosLocal.setTipoOferta(dto.getOidTipoOferta());
                tiposOfertaExcluidosLocal.setFechaDesde(new Timestamp(dto.getFechaDesde().getTime()));                
                tiposOfertaExcluidosLocal.setFechaHasta(new Timestamp(dto.getFechaHasta().getTime()));
                tipoOfertaExcluidosLocalHome.merge(tiposOfertaExcluidosLocal);
            } catch (NoResultException fe) {
            }
        }
        UtilidadesLog.info("MONTipoOfertaExcluidoBean.actualizarTipoOfertaExcluido(DTOTipoOfertaExcluido dto): Salida ");
    }

    

    /**
     * @author Guido Pons
     * @date 03/07/2006
     * @throws es.indra.mare.common.exception.MareException
     * @param dto
     */
    public DTOSalida buscarTiposOfertaExcluidos(DTOTipoOfertaExcluido dto) throws MareException {
        UtilidadesLog.info("MONTipoOfertaExcluidoBean.buscarTiposOfertaExcluidos(DTOTipoOfertaExcluido dto): Entrada ");
        DAOTipoOfertaExcluido dao = new DAOTipoOfertaExcluido();
        DTOSalida dtoSalida = new DTOSalida();
        dtoSalida.setResultado(dao.buscarTiposOfertaExcluidos(dto));

        UtilidadesLog.info("MONTipoOfertaExcluidoBean.buscarTiposOfertaExcluidos(DTOTipoOfertaExcluido dto): Salida ");
        return dtoSalida;
    }

    /**
     * @author Guido Pons
     * @date 03/07/2006
     * @throws es.indra.mare.common.exception.MareException
     * @param dto
     */
    public void eliminarTipoOfertaExcluido(DTOOIDs dto) throws MareException {
        UtilidadesLog.info("MONTipoOfertaExcluidoBean.eliminarTipoOfertaExcluido(DTOOIDs dto): Entrada");

        TiposOfertaExcluidosLocalHome tipoOfertaExcluidosLocalHome = this.getTiposOfertaExcluidosLocalHome();
        TiposOfertaExcluidosLocal tiposOfertaExcluidosLocal = null;

        if ((dto != null) && (dto.getOids() != null)) {
            for (int i = 0; i < dto.getOids().length; i++) {
                try {
                    tiposOfertaExcluidosLocal = tipoOfertaExcluidosLocalHome.findByPrimaryKey(dto.getOids()[i]);
                    tipoOfertaExcluidosLocalHome.remove(tiposOfertaExcluidosLocal);                    
                } catch (NoResultException fe) {
                } catch (PersistenceException re) {
                    ctx.setRollbackOnly();
                    UtilidadesLog.error("Exception: ", re);
                    throw new MareException(re,
                        UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_BORRADO_DE_DATOS));
                }
            }
        }
        UtilidadesLog.info("MONTipoOfertaExcluidoBean.eliminarTipoOfertaExcluido(DTOOIDs dto): Salida");
    }

    private TiposOfertaExcluidosLocalHome getTiposOfertaExcluidosLocalHome() throws MareException {
        return new TiposOfertaExcluidosLocalHome();
    }

}
