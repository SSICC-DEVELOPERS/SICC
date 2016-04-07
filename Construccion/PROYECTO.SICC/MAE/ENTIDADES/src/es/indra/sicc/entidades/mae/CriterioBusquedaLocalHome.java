package es.indra.sicc.entidades.mae;	

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.mae.CriterioBusquedaLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class CriterioBusquedaLocalHome {

    //@PersistenceContext private EntityManager em; 
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-mae");
    private EntityManager em = emf.createEntityManager();

    public CriterioBusquedaLocal create(Long pais_oid_pais, Long atre_oid_atri_esp1, Long atre_oid_atri_esp2)
            throws MareException {
        Long oid = SecuenciadorOID.obtenerSiguienteValor("MAE_CRBU_SEQ");
        final EntityTransaction et = em.getTransaction();
        et.begin();
        CriterioBusquedaLocal local = new CriterioBusquedaLocal(oid, pais_oid_pais, atre_oid_atri_esp1, atre_oid_atri_esp2);
        em.persist(local);
        et.commit();
        return local;
    }
    
    public void remove(CriterioBusquedaLocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.remove(local);
        et.commit();
    }
    
    public void merge(CriterioBusquedaLocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.merge(local);
        et.commit();
    }
    
    public CriterioBusquedaLocal findByPrimaryKey(Long  oid) {
        CriterioBusquedaLocal local = em.find(CriterioBusquedaLocal.class, oid);
        if (local==null) throw new NoResultException();
        return local;
    }

    public CriterioBusquedaLocal findByPais(Long pais) {
        Query query = em.createNamedQuery("CriterioBusquedaLocal.FindByPais");
        query.setParameter(1, pais);
        return (CriterioBusquedaLocal)query.getSingleResult();
    }
    
    public Collection findAll() {
        Query query = em.createNamedQuery("CriterioBusquedaLocal.FindAll");
        return query.getResultList();
    }
}
