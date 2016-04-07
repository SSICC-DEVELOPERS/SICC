package es.indra.sicc.entidades.ped;

import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.ped.SeguimientoPedidosLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class SeguimientoPedidosLocalHome {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-ped");
    private EntityManager em = emf.createEntityManager();

    public SeguimientoPedidosLocal create(Long tdse_oid_tipo, Long hise_oid_hito, String num_docu) throws MareException {
        Long oid = SecuenciadorOID.obtenerSiguienteValor("PED_SEPE_SEQ");
        final EntityTransaction et = em.getTransaction();
        et.begin();
        SeguimientoPedidosLocal local = new SeguimientoPedidosLocal(oid, tdse_oid_tipo, hise_oid_hito, num_docu);
        em.persist(local);
        et.commit();
        return local;
    }
    
    public void remove(SeguimientoPedidosLocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.remove(local);
        et.commit();
    }
    
    public void merge(SeguimientoPedidosLocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.merge(local);
        et.commit();
    }
    
    public SeguimientoPedidosLocal findByPrimaryKey(Long  oid) {
        SeguimientoPedidosLocal local = em.find(SeguimientoPedidosLocal.class, oid);
        if (local==null) throw new NoResultException();
        return local;
    }

    
    public Collection findBySolicitud(Long solicitud) {
        Query query=em.createNamedQuery("SeguimientoPedidosLocal.FindBySolicitud");
        query.setParameter(1, solicitud);
        return query.getResultList();
    }
    
    public Collection findAll() {
        Query query=em.createNamedQuery("SeguimientoPedidosLocal.FindAll");
        return query.getResultList();
    }

}
