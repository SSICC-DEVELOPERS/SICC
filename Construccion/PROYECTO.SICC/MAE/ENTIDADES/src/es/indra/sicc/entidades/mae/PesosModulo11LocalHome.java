package es.indra.sicc.entidades.mae;	

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.mae.PesosModulo11Local;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class PesosModulo11LocalHome {

    //@PersistenceContext private EntityManager em; 
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-mae");
    private EntityManager em = emf.createEntityManager();

    public PesosModulo11Local create(Long num_posi, Long val_peso_apli) throws MareException {
        Long oid = SecuenciadorOID.obtenerSiguienteValor("MAE_PM11_SEQ");
        final EntityTransaction et = em.getTransaction();
        et.begin();
        PesosModulo11Local local = new PesosModulo11Local(oid, num_posi, val_peso_apli);
        em.persist(local);
        et.commit();
        return local;
    }
    
    public void remove(PesosModulo11Local local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.remove(local);
        et.commit();
    }
    
    public void merge(PesosModulo11Local local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.merge(local);
        et.commit();
    }
    
    public PesosModulo11Local findByPrimaryKey(Long  oid) {
        PesosModulo11Local local = em.find(PesosModulo11Local.class, oid);
        if (local==null) throw new NoResultException();
        return local;
    }
    
    public Collection findAll() {
        Query query = em.createNamedQuery("PesosModulo11Local.FindAll");
        return query.getResultList();
    }
}
