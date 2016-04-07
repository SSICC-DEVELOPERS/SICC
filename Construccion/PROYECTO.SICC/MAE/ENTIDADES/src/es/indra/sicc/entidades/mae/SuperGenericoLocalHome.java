package es.indra.sicc.entidades.mae;	

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.mae.SuperGenericoLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class SuperGenericoLocalHome {

    //@PersistenceContext private EntityManager em; 
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-mae");
    private EntityManager em = emf.createEntityManager();

    public SuperGenericoLocal create(Long paisOidPais, String codSupeGene) throws MareException {
        Long oid = SecuenciadorOID.obtenerSiguienteValor("MAE_SGEN_SEQ");
        final EntityTransaction et = em.getTransaction();
        et.begin();
        SuperGenericoLocal local = new SuperGenericoLocal(oid, paisOidPais, codSupeGene);
        em.persist(local);
        et.commit();
        return local;
    }
    
    public void remove(SuperGenericoLocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.remove(local);
        et.commit();
    }
    
    public void merge(SuperGenericoLocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.merge(local);
        et.commit();
    }
    
    public SuperGenericoLocal findByPrimaryKey(Long  oid) {
        SuperGenericoLocal local = (SuperGenericoLocal)em.find(SuperGenericoLocal.class, oid);
        if (local==null) throw new NoResultException();
        return local;
    }

    public Collection findAll() {
        Query query=em.createNamedQuery("SuperGenericoLocal.FindAll");
        return query.getResultList();
    }

    public SuperGenericoLocal findByUk(Long oidPais, String codigoSupergenerico) {
        Query query=em.createNamedQuery("SuperGenericoLocal.FindByUk");
        query.setParameter(1, oidPais);
        query.setParameter(2, codigoSupergenerico);
        return (SuperGenericoLocal)(query.getSingleResult());
    }
}
