package es.indra.sicc.entidades.mae;	

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.mae.TipoComunicacionLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class TipoComunicacionLocalHome {

    //@PersistenceContext private EntityManager em; 
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-mae");
    private EntityManager em = emf.createEntityManager();

    public TipoComunicacionLocal create(String codTipoComu) throws MareException {
        Long oid = SecuenciadorOID.obtenerSiguienteValor("MAE_TICL_SEQ");
        final EntityTransaction et = em.getTransaction();
        et.begin();
        TipoComunicacionLocal local = new TipoComunicacionLocal(oid, codTipoComu);
        em.persist(local);
        et.commit();
        return local;
    }
    
    public void remove(TipoComunicacionLocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.remove(local);
        et.commit();
    }
    
    public void merge(TipoComunicacionLocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.merge(local);
        et.commit();
    }
    
    public TipoComunicacionLocal findByPrimaryKey(Long oid) {
        TipoComunicacionLocal local = em.find(TipoComunicacionLocal.class, oid);
        if (local==null) throw new NoResultException();
        return local;
    }

    public Collection findAll() {
        Query query=em.createNamedQuery("TipoComunicacionLocal.FindAll");
        return query.getResultList();
    }

    public TipoComunicacionLocal findByUK(String codTC) {
        Query query=em.createNamedQuery("TipoComunicacionLocal.FindByUK");
        query.setParameter(1, codTC);
        return (TipoComunicacionLocal)(query.getSingleResult());
    }

}
