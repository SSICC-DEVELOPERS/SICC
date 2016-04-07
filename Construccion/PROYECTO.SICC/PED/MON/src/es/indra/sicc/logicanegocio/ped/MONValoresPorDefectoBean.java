package es.indra.sicc.logicanegocio.ped;

import es.indra.mare.common.exception.MareException;
import es.indra.sicc.dtos.ped.DTOValoresPorDefecto;
import es.indra.sicc.entidades.ped.ValoresPorDefectoLocal;
import es.indra.sicc.entidades.ped.ValoresPorDefectoLocalHome;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOColeccion;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import java.util.ArrayList;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;


public class MONValoresPorDefectoBean implements SessionBean  {
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
  
  public void guarda(DTOColeccion dto) throws MareException {
        try {
            UtilidadesLog.info(
                "MONValoresPorDefectoBean.guarda(DTOColeccion dto): Entrada ");
            ValoresPorDefectoLocal vpdl = null;
            ArrayList lista = dto.getLista();
            DTOValoresPorDefecto dtoVal = new DTOValoresPorDefecto();
            Long oidObli = null;
            Long oidModi = null;

            UtilidadesLog.debug("*********** tamaño de la lista " +
                lista.size());

            for (int i = 0; i < lista.size(); i++) {
                dtoVal = (DTOValoresPorDefecto) lista.get(i);

                Long oidTipo = dtoVal.getOidTipoSolicitudPais();
                Long oidCampo = dtoVal.getOidCampo();
                Boolean indObli = dtoVal.getIndObligatorio();
                Boolean indModi = dtoVal.getIndModificable();
                String valDefe = dtoVal.getValorPorDefecto();
                Long valDefeOid = dtoVal.getOidValorPorDefecto();

                UtilidadesLog.debug("*********** oidTipo " + oidTipo);
                UtilidadesLog.debug("*********** oidCampo " + oidCampo);
                UtilidadesLog.debug("*********** indObli " + indObli);
                UtilidadesLog.debug("*********** indModi " + indModi);
                UtilidadesLog.debug("*********** valDefe " + valDefe);
                UtilidadesLog.debug("*********** valDefeOid " + valDefeOid);

                if (indObli.booleanValue() == true) {
                    oidObli = new Long(1);
                }

                if (indObli.booleanValue() == false) {
                    oidObli = new Long(0);
                }

                if (indModi.booleanValue() == true) {
                    oidModi = new Long(1);
                }

                if (indModi.booleanValue() == false) {
                    oidModi = new Long(0);
                }

                ValoresPorDefectoLocalHome vpdlh = new ValoresPorDefectoLocalHome();
                UtilidadesLog.debug(
                    "***** Llamando a parametrosAuditoria *****");
                UtilidadesLog.debug(
                    "******************* Llamando al create - ValoresPorDefectoLocalHome");
                    
                /* 
                 * Modificacion por ssantana, 25/01/2005, inc. 
                 * Inc. BELC300022504. 
                 * Si ya existe la UK, la pisa, si no, inserta nueva tupla. 
                 */
                try {
                   vpdl = vpdlh.findByUK(oidCampo, oidTipo);
                   UtilidadesLog.debug("Modifica la tupla ya existente");
                } catch (NoResultException nre){
                   UtilidadesLog.debug("No existe, lo crea");
                   vpdl = vpdlh.create(oidTipo, oidCampo, oidObli, oidModi);
                } catch (PersistenceException pe) {
                    ctx.setRollbackOnly();
                    throw new MareException(pe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
                }
                    
                vpdl.setIndObli(oidObli);
                vpdl.setIndModi(oidModi);
                
                /*
                 * Modificacion por ssantana, 25/01/2005, inc. 
                 * Inc. BELC300022504. 
                 */                    
                
                if (valDefeOid != null) {
                    UtilidadesLog.debug(
                        "******** Seteando oid del valor por defecto");
                    vpdl.setValDefeOid(valDefeOid);
                }

                if (valDefe != null) {
                    UtilidadesLog.debug("******** Seteando valor por defecto");
                    vpdl.setValDefe(valDefe);
                }
                
                vpdlh.merge(vpdl);
            }
        } catch (PersistenceException e) {
            ctx.setRollbackOnly();
            UtilidadesLog.error("Exception: ", e);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        } 

        UtilidadesLog.info(
            "MONValoresPorDefectoBean.guarda(DTOColeccion dto): Salida ");
    }

    /**
     * @author Marcelo J. Maidana
     * @date 27/12/2005
     * @throws es.indra.mare.common.exception.MareException
     * @param dto
     * Metodo creado por incidencia 14074.
     */
    public void modifica(DTOColeccion dto) throws MareException {
        UtilidadesLog.info(
            "MONValoresPorDefectoBean.modifica(DTOColeccion dto): Entrada ");

        ArrayList lista = dto.getLista();
        DTOValoresPorDefecto dtoVal = new DTOValoresPorDefecto();
        Long oidObli = null;
        Long oidModi = null;

        UtilidadesLog.info("*********** tamaño de la lista " + lista.size());

        for (int i = 0; i < lista.size(); i++) {
            try {
                dtoVal = (DTOValoresPorDefecto) lista.get(i);

                Long oid = dtoVal.getOid();
                Long oidTipo = dtoVal.getOidTipoSolicitudPais();
                Long oidCampo = dtoVal.getOidCampo();
                Boolean indObli = dtoVal.getIndObligatorio();
                Boolean indModi = dtoVal.getIndModificable();
                String valDefe = dtoVal.getValorPorDefecto();
                Long valDefeOid = dtoVal.getOidValorPorDefecto();


                UtilidadesLog.info("-ITEM-: " + i);
                UtilidadesLog.info("*********** oid " + oid);
                UtilidadesLog.info("*********** oidTipo " + oidTipo);
                UtilidadesLog.info("*********** oidCampo " + oidCampo);
                UtilidadesLog.info("*********** indObli " + indObli);
                UtilidadesLog.info("*********** indModi " + indModi);
                UtilidadesLog.info("*********** valDefe " + valDefe);
                UtilidadesLog.info("*********** valDefeOid " + valDefeOid);

                if (indObli.booleanValue() == true) {
                    oidObli = new Long(1);
                }

                if (indObli.booleanValue() == false) {
                    oidObli = new Long(0);
                }

                if (indModi.booleanValue() == true) {
                    oidModi = new Long(1);
                }

                if (indModi.booleanValue() == false) {
                    oidModi = new Long(0);
                }

                ValoresPorDefectoLocalHome vpdlh = new ValoresPorDefectoLocalHome();
                UtilidadesLog.info("******************* Llamando al create - ValoresPorDefectoLocalHome");

                ValoresPorDefectoLocal vpdl = vpdlh.findByPrimaryKey(oid);

                UtilidadesLog.info("hizo el vpdlh.findByPrimaryKey(oid)");

                if (oidTipo != null) {
                    vpdl.setOidTipoSoliPais(oidTipo);
                }

                if (oidCampo != null) {
                    vpdl.setOidAtriEspe(oidCampo);
                }

                if (oidObli != null) {
                    vpdl.setIndObli(oidObli);
                }

                if (oidModi != null) {
                    vpdl.setIndModi(oidModi);
                }

                vpdl.setValDefeOid(valDefeOid);
                vpdl.setValDefe(valDefe);
                
                try {
                    vpdlh.merge(vpdl);
                } catch (PersistenceException e) {
                    ctx.setRollbackOnly();
                    throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                }
                
            } catch (NoResultException e) {
                ctx.setRollbackOnly();
                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
            } catch (PersistenceException e) {
                ctx.setRollbackOnly();
                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
            }
        } // for

        UtilidadesLog.info(
            "MONValoresPorDefectoBean.modifica(DTOColeccion dto): Salida ");
    }


  public DTOSalida consulta(DTOValoresPorDefecto dto) throws MareException {
  
        UtilidadesLog.info("MONValoresPorDefectoBean.consulta(DTOValoresPorDefecto dto): Entrada ");
        String user = ctx.getCallerPrincipal().getName();
        DAOPED dao = new DAOPED(user);
        DTOSalida dtoSalida;
        dtoSalida = dao.obtieneValoresPorDefecto(dto);
        UtilidadesLog.info("MONValoresPorDefectoBean.consulta(DTOValoresPorDefecto dto): Salida ");
        return dtoSalida;
  }
  
    /**
     * @author Marcelo J. Maidana
     * @date 15/12/2005
     * @throws es.indra.mare.common.exception.MareException
     * @param dto
     * Metodo creado por incidencia 14074.
     */
    public void eliminar(DTOOIDs dto) throws MareException{
        UtilidadesLog.info("MONValoresPorDefectoBean.eliminar(DTOOIDs dto): Entrada");
    
        ValoresPorDefectoLocalHome vpdlh = new ValoresPorDefectoLocalHome();
        ValoresPorDefectoLocal vpdl = null;
        
        if (dto != null && dto.getOids() != null){
            for (int i = 0; i < dto.getOids().length; i++){
                try{
                    vpdl = vpdlh.findByPrimaryKey(dto.getOids()[i]);
                } catch(NoResultException e) {
                    /* no se coloca nada dado que en caso que no se encuentre registros no es*/
                } catch(PersistenceException e) {
                    UtilidadesLog.error("Exception: ", e);
                    ctx.setRollbackOnly();
                    throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
                }
                
                try {
                    vpdlh.remove(vpdl);
                } catch(PersistenceException e) {
                    ctx.setRollbackOnly();
                    UtilidadesLog.error("Exception: ", e);
                    throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_BORRADO_DE_DATOS));
                }
            }
        }
        
        UtilidadesLog.info("MONValoresPorDefectoBean.eliminar(DTOOIDs dto): Salida");
    }
}
