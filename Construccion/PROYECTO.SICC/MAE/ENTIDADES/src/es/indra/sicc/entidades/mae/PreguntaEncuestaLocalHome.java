package es.indra.sicc.entidades.mae;	

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.mae.PreguntaEncuestaLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class PreguntaEncuestaLocalHome {

    //@PersistenceContext private EntityManager em; 
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-mae");
    private EntityManager em = emf.createEntityManager();

    public PreguntaEncuestaLocal create(String codPreg, Long valPesoPreg, Long enseOidEncu) throws MareException {
        Long oid = SecuenciadorOID.obtenerSiguienteValor("MAE_PREN_SEQ");
        final EntityTransaction et = em.getTransaction();
        et.begin();
        PreguntaEncuestaLocal local = new PreguntaEncuestaLocal(oid, codPreg, valPesoPreg, enseOidEncu);
        em.persist(local);
        et.commit();
        return local;
    }
    
    public void remove(PreguntaEncuestaLocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.remove(local);
        et.commit();
    }
    
    public void merge(PreguntaEncuestaLocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.merge(local);
        et.commit();
    }
    
    public PreguntaEncuestaLocal findByPrimaryKey(Long  oid) {
        PreguntaEncuestaLocal local = em.find(PreguntaEncuestaLocal.class, oid);
        if (local==null) throw new NoResultException();
        return local;
    }
    
    public Collection findAll() {
        Query query=em.createNamedQuery("PreguntaEncuestaLocal.FindAll");
        return query.getResultList();
    }
}
