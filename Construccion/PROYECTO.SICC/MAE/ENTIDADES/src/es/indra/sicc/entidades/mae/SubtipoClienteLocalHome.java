package es.indra.sicc.entidades.mae;	

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.mae.SubtipoClienteLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class SubtipoClienteLocalHome {

    //@PersistenceContext private EntityManager em; 
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-mae");
    private EntityManager em = emf.createEntityManager();

    public SubtipoClienteLocal create(String codigo, Long tipoCliente) throws MareException {
        Long oid = SecuenciadorOID.obtenerSiguienteValor("MAE_SBTI_SEQ");
        final EntityTransaction et = em.getTransaction();
        et.begin();
        SubtipoClienteLocal local = new SubtipoClienteLocal(oid, codigo, tipoCliente);
        em.persist(local);
        et.commit();
        return local;
    }
    
    public void remove(SubtipoClienteLocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.remove(local);
        et.commit();
    }
    
    public void merge(SubtipoClienteLocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.merge(local);
        et.commit();
    }
    
    public SubtipoClienteLocal findByPrimaryKey(Long  oid) {
        SubtipoClienteLocal local = em.find(SubtipoClienteLocal.class, oid);
        if (local==null) throw new NoResultException();
        return local;
    }

    public Collection findAll() {
        Query query=em.createNamedQuery("SubtipoClienteLocal.FindAll");
        return query.getResultList();
    }

    public SubtipoClienteLocal findByUK(String codigo, Long oidTipoCliente) {
        Query query=em.createNamedQuery("SubtipoClienteLocal.FindByUK");
        query.setParameter(1, codigo);
        query.setParameter(2, oidTipoCliente);
        return (SubtipoClienteLocal)(query.getSingleResult());
    }

}
