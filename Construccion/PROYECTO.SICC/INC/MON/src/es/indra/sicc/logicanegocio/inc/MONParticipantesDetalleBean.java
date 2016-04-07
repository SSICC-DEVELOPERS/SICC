package es.indra.sicc.logicanegocio.inc;

import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.dtos.inc.DTOParticipantesDetalle;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.UtilidadesLog;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.entidades.inc.ParticipantesConcursoDetalleLocalHome;
import es.indra.sicc.entidades.inc.ParticipantesConcursoDetalleLocal;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;

public class MONParticipantesDetalleBean implements SessionBean {
    private SessionContext sessionContext;
    
    public void ejbCreate() { }
    public void ejbActivate()  {  }
    public void ejbPassivate() {  }
    public void ejbRemove() {  }

    public void setSessionContext(SessionContext ctx)  {
        this.sessionContext = ctx;
    }
    
    /**
      * Sistema:     Belcorp
      * Modulo:      INC
      * Fecha:       17/07/2006
      * @version     1.0
      * @autor       Cristian Valenzuela
      */
    public DTOSalida obtenerGruposCliente(DTOBelcorp DTOE) throws MareException  {
        UtilidadesLog.info("MONParticipantesDetalleBean.obtenerListaVersionesConcurso(DTOBelcorp DTOE):Entrada"); 
        DAOParticipantesDetalle dao = new DAOParticipantesDetalle();
        DTOSalida dtos = dao.obtenerGruposCliente(DTOE);
        UtilidadesLog.info("MONParticipantesDetalleBean.obtenerListaVersionesConcurso(DTOBelcorp DTOE):Salida");
        return dtos;       
    }

    /**
      * Sistema:     Belcorp
      * Modulo:      INC
      * Fecha:       18/07/2006
      * @version     1.0
      * @autor       Cristian Valenzuela
      */
    public void guardarDetalle(DTOParticipantesDetalle DTOE) throws MareException  {  
        UtilidadesLog.info("MONParticipantesDetalleBean.guardarDetalle(DTOParticipantesDetalle DTOE):Entrada");     
        UtilidadesLog.debug("dtoEntrada: " + DTOE);
        try {
            ParticipantesConcursoDetalleLocalHome pcdh = this.getParticipantesConcursoDetalleLocalHome();
            ParticipantesConcursoDetalleLocal pcdl;
            if( DTOE.getOid() == null){
              pcdl = pcdh.create(DTOE.getOidCabecera(),
              DTOE.getTipoCliente());            
              pcdl.setSubtipoCliente(DTOE.getSubtipoCliente());
              pcdl.setTipoClasificacion(DTOE.getTipoClasificacion());
              pcdl.setClasificacion(DTOE.getClasificacion()); 
              pcdl.setDescripcion( DTOE.getDescripcion() );
              pcdh.merge(pcdl);
            } else {
              pcdl = pcdh.findByPrimaryKey( DTOE.getOid() );
              pcdl.setDescripcion( DTOE.getDescripcion() );
              pcdh.merge(pcdl);
            }
            UtilidadesLog.info("MONParticipantesDetalleBean.guardarDetalle(DTOParticipantesDetalle DTOE):Salida");     
        } catch (NoResultException e){
            UtilidadesLog.error("ERROR ", e);
            sessionContext.setRollbackOnly();
            throw new MareException(e, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));          
        } catch (PersistenceException ce) {
            UtilidadesLog.error("ERROR ", ce);
            sessionContext.setRollbackOnly();
            throw new MareException(ce, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_CLAVE_DUPLICADA));
        }
    }

    /**
      * Sistema:     Belcorp
      * Modulo:      INC
      * Fecha:       17/07/2006
      * @version     1.0
      * @autor       Cristian Valenzuela
      */
    public DTOSalida buscarDetalle(DTOParticipantesDetalle DTOE) throws MareException  {         
        UtilidadesLog.info("MONParticipantesDetalleBean.buscarDetalle(DTOParticipantesDetalle DTOE):Entrada"); 
        DAOParticipantesDetalle dao = new DAOParticipantesDetalle();
        DTOSalida dtos = dao.buscarDetalle(DTOE);
        UtilidadesLog.info("MONParticipantesDetalleBean.buscarDetalle(DTOParticipantesDetalle DTOE):Salida");
        return dtos; 
    }

     /**
      * Sistema:     Belcorp
      * Modulo:      INC
      * Fecha:       17/07/2006
      * @version     1.0
      * @autor       Cristian Valenzuela
      */
    public void eliminarDetalle(DTOOIDs DTOE) throws MareException {
        UtilidadesLog.info("MONParticipantesDetalleBean.eliminarDetalle(DTOOIDs DTOE):Entrada"); 
        Long[] oids = DTOE.getOids();
        int longitud = oids.length;
        UtilidadesLog.debug("**** longitud " + longitud);         
        
        try {
            for(int i=0; i<longitud; i++) {
                ParticipantesConcursoDetalleLocalHome pcdh = this.getParticipantesConcursoDetalleLocalHome();
                ParticipantesConcursoDetalleLocal pcdl = pcdh.findByPrimaryKey(oids[i]);
                UtilidadesLog.debug("**** Borrando con oid:" + oids[i]);         
                pcdh.remove(pcdl);
            }
            UtilidadesLog.info("MONParticipantesDetalleBean.eliminarDetalle(DTOOIDs DTOE):Salida"); 
        } catch (NoResultException fe) {
            UtilidadesLog.error("ERROR ", fe);
        } catch (PersistenceException re) {
            UtilidadesLog.error("ERROR ", re);
            sessionContext.setRollbackOnly();
            throw new MareException(re, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_BORRADO_DE_DATOS));
        }
    }
    
    private ParticipantesConcursoDetalleLocalHome getParticipantesConcursoDetalleLocalHome() {
            return new ParticipantesConcursoDetalleLocalHome();
    }

    

}
