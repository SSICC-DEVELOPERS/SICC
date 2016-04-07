package es.indra.sicc.entidades.ped;

import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.ped.SolicitudCabeceraSecuenciaLocal;

public class SolicitudCabeceraSecuenciaLocalHome {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-ped");
    private EntityManager em = emf.createEntityManager();

    public SolicitudCabeceraSecuenciaLocal create(Long  oid) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        SolicitudCabeceraSecuenciaLocal local = new SolicitudCabeceraSecuenciaLocal(oid);
        em.persist(local);
        et.commit();
        return local;
    }
    
    public void remove(SolicitudCabeceraSecuenciaLocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.remove(local);
        et.commit();
    }
    
    public void merge(SolicitudCabeceraSecuenciaLocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.merge(local);
        et.commit();
    }
    
    public SolicitudCabeceraSecuenciaLocal findByPrimaryKey(Long  oid) {
        SolicitudCabeceraSecuenciaLocal local = em.find(SolicitudCabeceraSecuenciaLocal.class, oid);
        if (local==null) throw new NoResultException();
        return local;
    }

    public Collection findAll() {
        Query query=em.createNamedQuery("SolicitudCabeceraSecuenciaLocal.FindAll");
        return query.getResultList();
    }

}
