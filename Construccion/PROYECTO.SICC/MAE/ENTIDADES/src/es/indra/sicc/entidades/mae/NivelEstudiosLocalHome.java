package es.indra.sicc.entidades.mae;	

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.mae.NivelEstudiosLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class NivelEstudiosLocalHome {

    //@PersistenceContext private EntityManager em; 
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-mae");
    private EntityManager em = emf.createEntityManager();

    public NivelEstudiosLocal create(Long pais, String codigo) throws MareException {
        Long oid = SecuenciadorOID.obtenerSiguienteValor("MAE_NIED_SEQ");
        final EntityTransaction et = em.getTransaction();
        et.begin();
        NivelEstudiosLocal local = new NivelEstudiosLocal(oid, pais, codigo);
        em.persist(local);
        et.commit();
        return local;
    }
    
    public void remove(NivelEstudiosLocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.remove(local);
        et.commit();
    }
    
    public void merge(NivelEstudiosLocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.merge(local);
        et.commit();
    }
    
    public NivelEstudiosLocal findByPrimaryKey(Long  oid) {
        NivelEstudiosLocal local = em.find(NivelEstudiosLocal.class, oid);
        if (local==null) throw new NoResultException();
        return local;
    }

    public Collection findAll() {
        Query query=em.createNamedQuery("NivelEstudiosLocal.FindAll");
        return query.getResultList();
    }

    public NivelEstudiosLocal findByUK(Long oidPais,String codigo) {
        Query query=em.createNamedQuery("NivelEstudiosLocal.FindByUK");
        query.setParameter(1, oidPais);
        query.setParameter(2, codigo);
        return (NivelEstudiosLocal)(query.getSingleResult());
    }
}
