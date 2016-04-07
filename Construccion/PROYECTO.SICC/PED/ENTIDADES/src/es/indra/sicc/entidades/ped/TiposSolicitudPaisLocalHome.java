package es.indra.sicc.entidades.ped;

import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.ped.TiposSolicitudPaisLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class TiposSolicitudPaisLocalHome {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-ped");
    private EntityManager em = emf.createEntityManager();

    public TiposSolicitudPaisLocal create(Long oidPais, Long oidTipoSolicitud, Boolean sujetoFlete,
            Boolean reservaStock, Boolean permiteReversion, Boolean indPedidoPrueba, 
            Boolean indComisionable, Boolean indVentaSAB14, Boolean permiteUnionSolicitudes, 
            Boolean indPedGtZona, Boolean indCambioVentaBEL) throws MareException {
            
        Long oid = SecuenciadorOID.obtenerSiguienteValor("PED_TSPA_SEQ");
        final EntityTransaction et = em.getTransaction();
        et.begin();
        TiposSolicitudPaisLocal local = new TiposSolicitudPaisLocal(oid, oidPais, oidTipoSolicitud, sujetoFlete,
            reservaStock, permiteReversion, indPedidoPrueba, indComisionable, indVentaSAB14, permiteUnionSolicitudes, 
            indPedGtZona, indCambioVentaBEL);
        em.persist(local);
        et.commit();
        return local;
    }
    
    public void remove(TiposSolicitudPaisLocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.remove(local);
        et.commit();
    }
    
    public void merge(TiposSolicitudPaisLocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.merge(local);
        et.commit();
    }
    
    public TiposSolicitudPaisLocal findByPrimaryKey(Long  oid) {
        TiposSolicitudPaisLocal local = em.find(TiposSolicitudPaisLocal.class, oid);
        if (local==null) throw new NoResultException();
        return local;
    }

    
    public TiposSolicitudPaisLocal findByUK(Long oidPais,Long oidTipoSolicitud) {
        Query query=em.createNamedQuery("TiposSolicitudPaisLocal.FindByUK");
        query.setParameter(1, oidPais);
        query.setParameter(2, oidTipoSolicitud);
        return (TiposSolicitudPaisLocal)(query.getSingleResult());
    }

    public Collection findAll() {
        Query query=em.createNamedQuery("TiposSolicitudPaisLocal.FindAll");
        return query.getResultList();
    }

}
