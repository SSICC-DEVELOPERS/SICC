package es.indra.sicc.entidades.mae;	

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.mae.RespuestasEncuestaLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class RespuestasEncuestaLocalHome {

    //@PersistenceContext private EntityManager em; 
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-mae");
    private EntityManager em = emf.createEntityManager();

    public RespuestasEncuestaLocal create(Long prenOidPreg, String codResp, Long valPeso) throws MareException {
        Long oid = SecuenciadorOID.obtenerSiguienteValor("MAE_REEN_SEQ");
        final EntityTransaction et = em.getTransaction();
        et.begin();
        RespuestasEncuestaLocal local = new RespuestasEncuestaLocal(oid, prenOidPreg, codResp, valPeso);
        em.persist(local);
        et.commit();
        return local;
    }
    
    public void remove(RespuestasEncuestaLocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.remove(local);
        et.commit();
    }
    
    public void merge(RespuestasEncuestaLocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.merge(local);
        et.commit();
    }
    
    public RespuestasEncuestaLocal findByPrimaryKey(Long  oid) {
        RespuestasEncuestaLocal local = em.find(RespuestasEncuestaLocal.class, oid);
        if (local==null) throw new NoResultException();
        return local;
    }
    
    public Collection findAll() {
        Query query=em.createNamedQuery("RespuestasEncuestaLocal.FindAll");
        return query.getResultList();
    }

}
