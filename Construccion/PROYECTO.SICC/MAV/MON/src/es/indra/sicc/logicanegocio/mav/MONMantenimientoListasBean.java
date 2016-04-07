package es.indra.sicc.logicanegocio.mav;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.dtos.mav.DTOCargaParametrizacion;
import es.indra.sicc.dtos.mav.DTOParametrizacionMAV;
import es.indra.sicc.entidades.mav.DetalleMAVLocalHome;
import es.indra.sicc.entidades.mav.ParametrizacionGerenteRegionLocal;
import es.indra.sicc.entidades.mav.ParametrizacionGerenteRegionLocalHome;
import es.indra.sicc.entidades.mav.ParametrizacionGerenteZonaLocal;
import es.indra.sicc.entidades.mav.ParametrizacionGerenteZonaLocalHome;
import es.indra.sicc.entidades.mav.ParametrizacionMAVLocal;
import es.indra.sicc.entidades.mav.ParametrizacionMAVLocalHome;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;

import java.util.Collection;
import java.util.Iterator;

import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;


public class MONMantenimientoListasBean implements SessionBean {
    private SessionContext ctx;
    private ParametrizacionMAVLocalHome instanciaParamMAV;
    private ParametrizacionGerenteZonaLocalHome instanciaParamGerZona;
    private ParametrizacionGerenteRegionLocalHome instanciaParamGerRegion;
    private ParametrizacionGerenteRegionLocal registroRegion;
    private ParametrizacionGerenteZonaLocal registroZona;
    private DTOCargaParametrizacion dtoCargParam = new DTOCargaParametrizacion();
    private BelcorpService belcorpService;

    public void ejbCreate() {}

    public void ejbActivate() {}

    public void ejbPassivate() {}

    public void ejbRemove() {}

    public void setSessionContext(SessionContext ctx) {
        this.ctx = ctx;
    }

    public void cargarDatosDesdeBusinessPlanning(DTOBelcorp dto)
        throws MareException {
        UtilidadesLog.info("MONMantenimientoListasBean.cargarDatosDesdeBusinessPlanning(DTOBelcorp dto):Entrada");
        StringBuffer query = new StringBuffer();
        BelcorpService belcorpService = null;
        RecordSet rs = null;

        // ***************************************************************************
        // Query modificada por incidencia 10421 de Pruebas
        // Desc: Se filtra tambien por "bps.ind_carg IS NULL"
        // Autor: ssantana, 19/11/2004
        // ***************************************************************************
        query.append("Select bps.OID_BPS_INTE_MAV ");
        query.append("from MAV_BPS_INTER bps, CRA_PERIO peri ");
        query.append("where (bps.IND_CARG = 0 or bps.IND_CARG is NULL) AND ");
        query.append("bps.PERD_OID_PERI = peri.OID_PERI and ");
        query.append("peri.PAIS_OID_PAIS = " + dto.getOidPais());

        try {
            belcorpService = BelcorpService.getInstance();

            rs = new RecordSet();
            rs = belcorpService.dbService.executeStaticQuery(query.toString());
        } catch(MareMiiServiceNotFoundException serviceNotFoundException) {
            UtilidadesLog.error(serviceNotFoundException);
            throw new MareException(serviceNotFoundException,
                UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        } catch(MareException ne) {
            UtilidadesLog.error(ne);
            throw ne;
        } catch(Exception exception) {
            UtilidadesLog.error(exception);
            throw new MareException(exception, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        try {
            for(int i = 0; i < rs.getRowCount(); i++) {
                DetalleMAVProceso DMP = new DetalleMAVProceso(new Long(rs.getValueAt(i, "OID_BPS_INTE_MAV").toString()));
                DMP.cargarRegistro();
            }
        } catch(MareException e) {
            ctx.setRollbackOnly();
            throw e;
        }
        
        UtilidadesLog.info("MONMantenimientoListasBean.cargarDatosDesdeBusinessPlanning(DTOBelcorp dto):Salida");
    }

    public DTOCargaParametrizacion cargarParametrizacion(DTOOID dto)
        throws MareException {
        
        UtilidadesLog.info("MONMantenimientoListasBean.cargarParametrizacion(DTOOID dto):Entrada");
        try {
            UtilidadesLog.debug("Entra en cargarParametrizacion");
            StringBuffer query0 = new StringBuffer();
            StringBuffer query1 = new StringBuffer();
            StringBuffer query2 = new StringBuffer();

            RecordSet rs1 = new RecordSet();
            RecordSet rs2 = new RecordSet();
            RecordSet rs3 = new RecordSet();

            //primer recordset
            query0.append("Select mp.PAIS_OID_PAIS, ");
            query0.append("mp.OID_PARA_MAV, ");
            query0.append("mp.NUM_REGI_AVIS,  ");
            query0.append("mp.VAL_LIMI_PREC_AUTO, ");
            query0.append("mp.IND_REQU_AUTO, ");
            query0.append("mp.VAL_DIRE_ELEC_ENVI_FALT_STOC, ");
            query0.append("mp.TICL_OID_TIPO_CLIE_REGI, ");
            query0.append("mp.TICL_OID_TIPO_CLIE_ZONA, ");
            query0.append("mp.ALMC_OID_ALMA, ");
            query0.append("mp.COES_OID_ESTR ");
            
            // sapaza -- PER-SiCC-2010-0606 -- 18/10/2010
            query0.append(", mp.OCAT_OID_CATA ");
            query0.append(", mp.CNDP_OID_COND_PROM ");
            
            query0.append("from MAV_PARAM mp ");
            query0.append("where mp.PAIS_OID_PAIS = '" + dto.getOidPais() + "'");

            belcorpService = BelcorpService.getInstance();
            rs1 = belcorpService.dbService.executeStaticQuery(query0.toString());

            if(rs1.getRowCount() > 0)
                dtoCargParam.setParametrizacionMAV(rs1);
            else
                dtoCargParam.setParametrizacionMAV(null);

            //segundo recordset
            if(rs1.getRowCount() > 1)
                UtilidadesLog.debug("Existe mas de un registro para el pais de sesion");
            else if(rs1.getRowCount() == 1) {
                query1.append("Select mpgr.OID_PARA_GERE_REGI, ");
                query1.append("mpgr.SBTI_OID_SUBT_CLIE ");
                query1.append("from MAV_PARAM_GEREN_REGIO mpgr ");
                query1.append("where mpgr.PARM_OID_PARA_MAV = '" + rs1.getValueAt(0, "OID_PARA_MAV") + "'");

                belcorpService = BelcorpService.getInstance();
                rs2 = belcorpService.dbService.executeStaticQuery(query1.toString());

                if(rs2.getRowCount() > 0)
                    dtoCargParam.setParametrizacionGRegion(rs2);
                else
                    dtoCargParam.setParametrizacionGRegion(null);
            }

            //tercer recordset
            if(rs1.getRowCount() > 1)
                UtilidadesLog.debug("Existe mas de un registro para el pais de sesion");
            else if(rs1.getRowCount() == 1) {
                query2.append("Select mpgz.OID_PARA_GERE_ZONA, ");
                query2.append("mpgz.SBTI_OID_SUBT_CLIE ");
                query2.append("from MAV_PARAM_GEREN_ZONA mpgz ");
                query2.append("where mpgz.PARM_OID_PARA_MAV = '" + rs1.getValueAt(0, "OID_PARA_MAV") + "'");

                belcorpService = BelcorpService.getInstance();
                rs3 = belcorpService.dbService.executeStaticQuery(query2.toString());

                if(rs3.getRowCount() > 0)
                    dtoCargParam.setParametrizacionGZona(rs3);
                else
                    dtoCargParam.setParametrizacionGZona(null);
            }

            UtilidadesLog.debug("Sale de cargarParametrizacion");
        } catch(MareMiiServiceNotFoundException serviceNotFoundException) {
            UtilidadesLog.error(serviceNotFoundException);
            throw new MareException(serviceNotFoundException,
                UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        } catch(MareException ne) {
            UtilidadesLog.error(ne);
            throw ne;
        } catch(Exception exception) {
            UtilidadesLog.error(exception);
            throw new MareException(exception, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        UtilidadesLog.info("MONMantenimientoListasBean.cargarParametrizacion(DTOOID dto):Salida");
        return dtoCargParam;
    }

    public void guardarParametrizacion(DTOParametrizacionMAV dto)
        throws MareException {
        
        UtilidadesLog.info("MONMantenimientoListasBean.guardarParametrizacion(DTOParametrizacionMAV dto):Entrada");
        ParametrizacionMAVLocal instanciaLocal = null;
  
        try {
            instanciaParamMAV = new ParametrizacionMAVLocalHome();
            instanciaLocal = instanciaParamMAV.findByPrimaryKey(dto.getOidParametrizacionMAV());

            instanciaLocal.setOidPais(dto.getOidPais());
            instanciaLocal.setOidEstrategia(dto.getOidEstrategia());
            instanciaLocal.setNumeroRegistrosAviso(dto.getNumeroRegistrosAviso());
            instanciaLocal.setLimitePrecioAutorizacion(dto.getLimitePrecioAutorizacion());
            instanciaLocal.setDireccionElectronicaEnvioFaltaStock(dto.getDireccionElectronicaEnvio());
            instanciaLocal.setOidTipoClienteZona(dto.getOidTipoClienteZona());
            instanciaLocal.setOidTipoClienteRegion(dto.getOidTipoClienteRegion());
            instanciaLocal.setOidAlmacenes(dto.getOidAlmacen());
            instanciaLocal.setRequerirAutorizacion(dto.getAutorizacionEnvio());
            
            // sapaza -- PER-SiCC-2010-0606 -- 18/10/2010
            instanciaLocal.setOidCatalogo(dto.getOidCatalogo());
            instanciaLocal.setOidCondicionPromocion(dto.getOidCondicionPromocion());
            
            instanciaParamMAV.merge(instanciaLocal);
        } catch(NoResultException fe) {
            try {                
                instanciaLocal = instanciaParamMAV.create(dto.getOidPais(), dto.getOidEstrategia(), dto.getNumeroRegistrosAviso(),
                        dto.getLimitePrecioAutorizacion(), dto.getDireccionElectronicaEnvio(), dto.getOidTipoClienteZona(),
                        dto.getOidTipoClienteRegion(), dto.getOidAlmacen(), dto.getAutorizacionEnvio());
                        
                // sapaza -- PER-SiCC-2010-0606 -- 18/10/2010
                instanciaLocal.setOidCatalogo(dto.getOidCatalogo());
                instanciaLocal.setOidCondicionPromocion(dto.getOidCondicionPromocion());
                instanciaParamMAV.merge(instanciaLocal);
            } catch(PersistenceException ce) {
                ctx.setRollbackOnly();
                UtilidadesLog.error(ce);
                throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }
        }

        if(dto.getOidParametrizacionMAV() != null) {
            try {
                instanciaParamGerZona = new ParametrizacionGerenteZonaLocalHome();
                Collection col = instanciaParamGerZona.findByParametrizacion(dto.getOidParametrizacionMAV());

                Iterator it = col.iterator();

                while(it.hasNext()) {
                    registroZona = (ParametrizacionGerenteZonaLocal)it.next();                    
                    instanciaParamGerZona.remove(registroZona);
                }
            } catch(NoResultException fee) {
                UtilidadesLog.error(fee);
                ctx.setRollbackOnly();
                throw new MareException(fee, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
            } catch(PersistenceException re) {
                UtilidadesLog.error(re);
                ctx.setRollbackOnly();
                throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_BORRADO_DE_DATOS));
            } 
            try {
                instanciaParamGerRegion = new ParametrizacionGerenteRegionLocalHome();
                Collection col = instanciaParamGerRegion.findByParametrizacion(dto.getOidParametrizacionMAV());
                Iterator it = col.iterator();

                while(it.hasNext()) {
                    registroRegion = (ParametrizacionGerenteRegionLocal)it.next();                    
                    instanciaParamGerRegion.remove(registroRegion);
                }
            } catch(NoResultException fee) {
                ctx.setRollbackOnly();
                UtilidadesLog.error(fee);
                throw new MareException(fee, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
            } catch(PersistenceException re) {
                ctx.setRollbackOnly();
                throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_BORRADO_DE_DATOS));
            }
        }

        //Tomar el atributo del dto de entrada "subtiposClienteGerenteRegion" de tipo DTOOIDs,
        //y por cada oid de subtipo de cliente que lleve dentro llamar al "create" de la entidad
        //"ParametrizacionGerenteRegion" usando este oid y el "oidParametrizacionMAV" del dto
        //de entrada. 
        //Hacer lo mismo que en la entidad anterior con el atributo del dto de entrada
        //"subtiposClienteGerenteZona" y sobre la entidad "ParametrizacionGerenteZona" 
        Long[] oIdsRegion = dto.getSubtiposClienteGerenteRegion().getOids();

        for(int i = 0; i < oIdsRegion.length; i++) {
            try {
                instanciaParamGerRegion =  new ParametrizacionGerenteRegionLocalHome();                
                instanciaParamGerRegion.create(instanciaLocal.getOid(), oIdsRegion[i]);
            } catch(PersistenceException ce) {
                ctx.setRollbackOnly();
                UtilidadesLog.error(ce);
                throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }
        }

        Long[] oIdsZona = dto.getSubtiposClienteGerenteZona().getOids();

        for(int i = 0; i < oIdsZona.length; i++) {
            try {
                instanciaParamGerZona = new ParametrizacionGerenteZonaLocalHome();                
                instanciaParamGerZona.create(instanciaLocal.getOid(), oIdsZona[i]);
            } catch(PersistenceException ce) {
                ctx.setRollbackOnly();
                UtilidadesLog.error(ce);
                throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }
        }
        
        UtilidadesLog.info("MONMantenimientoListasBean.guardarParametrizacion(DTOParametrizacionMAV dto):Entrada");        
    }

    private DetalleMAVLocalHome getDetalleMAVLocalHome() throws NamingException {
        final InitialContext context = new InitialContext();
        return (DetalleMAVLocalHome)context.lookup("java:comp/env/DetalleMAV");
    }

}
