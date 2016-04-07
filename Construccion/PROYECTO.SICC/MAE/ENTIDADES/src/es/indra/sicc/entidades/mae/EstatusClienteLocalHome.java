package es.indra.sicc.entidades.mae;	

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.mae.EstatusClienteLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class EstatusClienteLocalHome {

    //@PersistenceContext private EntityManager em; 
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-mae");
    private EntityManager em = emf.createEntityManager();

    public EstatusClienteLocal create(String cod_esta_clie, Long tesc_oid_tipo_esta) throws MareException {
        Long oid = SecuenciadorOID.obtenerSiguienteValor("MAE_ESTA_SEQ");
        final EntityTransaction et = em.getTransaction();
        et.begin();
        EstatusClienteLocal local = new EstatusClienteLocal(oid, cod_esta_clie, tesc_oid_tipo_esta);
        em.persist(local);
        et.commit();
        return local;
    }
    
    public void remove(EstatusClienteLocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.remove(local);
        et.commit();
    }
    
    public void merge(EstatusClienteLocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.merge(local);
        et.commit();
    }
    
    public EstatusClienteLocal findByPrimaryKey(Long  oid) {
        EstatusClienteLocal local = em.find(EstatusClienteLocal.class, oid);
        if (local==null) throw new NoResultException();
        return local;
    }

    public EstatusClienteLocal findByCodigo(String codigo) {
        Query query = em.createNamedQuery("EstatusClienteLocal.FindByCodigo");
        query.setParameter(1, codigo);
        return (EstatusClienteLocal)query.getSingleResult();
    }

    public Collection findAll() {
        Query query = em.createNamedQuery("EstatusClienteLocal.FindAll");
        return query.getResultList();
    }
}
