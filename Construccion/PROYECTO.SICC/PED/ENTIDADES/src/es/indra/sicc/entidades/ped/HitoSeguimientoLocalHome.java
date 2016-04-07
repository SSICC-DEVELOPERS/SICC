package es.indra.sicc.entidades.ped;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.ped.HitoSeguimientoLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class HitoSeguimientoLocalHome {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-ped");
    private EntityManager em = emf.createEntityManager();

    public HitoSeguimientoLocal create(String cod_hito) throws MareException {
        Long oid = SecuenciadorOID.obtenerSiguienteValor("PED_HISE_SEQ");
        final EntityTransaction et = em.getTransaction();
        et.begin();
        HitoSeguimientoLocal local = new HitoSeguimientoLocal(oid, cod_hito);
        em.persist(local);
        et.commit();
        return local;
    }
    
    public void remove(HitoSeguimientoLocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.remove(local);
        et.commit();
    }
    
    public void merge(HitoSeguimientoLocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.merge(local);
        et.commit();
    }
    
    public HitoSeguimientoLocal findByPrimaryKey(Long  oid) {
        HitoSeguimientoLocal local = em.find(HitoSeguimientoLocal.class, oid);
        if (local==null) throw new NoResultException();
        return local;
    }

    
    public HitoSeguimientoLocal findByUK(String cod) {
        Query query=em.createNamedQuery("HitoSeguimientoLocal.FindByUK");
        query.setParameter(1, cod);
        return (HitoSeguimientoLocal)(query.getSingleResult());
    }

    public Collection findAll() {
        Query query = em.createNamedQuery("HitoSeguimientoLocal.FindAll");
        return query.getResultList();
    }

}
