package es.indra.sicc.entidades.mae;	

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.mae.ParametrosClientesLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class ParametrosClientesLocalHome {

    //@PersistenceContext private EntityManager em; 
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-mae");
    private EntityManager em = emf.createEntityManager();

    public ParametrosClientesLocal create(Long pais_oid_pais, String cod_tipo_asig) throws MareException {
        Long oid = SecuenciadorOID.obtenerSiguienteValor("MAE_PACL_SEQ");
        final EntityTransaction et = em.getTransaction();
        et.begin();
        ParametrosClientesLocal local = new ParametrosClientesLocal(oid, pais_oid_pais, cod_tipo_asig);
        em.persist(local);
        et.commit();
        return local;
    }
    
    public void remove(ParametrosClientesLocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.remove(local);
        et.commit();
    }
    
    public void merge(ParametrosClientesLocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.merge(local);
        et.commit();
    }
    
    public ParametrosClientesLocal findByPrimaryKey(Long oid) {
        ParametrosClientesLocal local = em.find(ParametrosClientesLocal.class, oid);
        if (local==null) throw new NoResultException();
        return local;
    }
    
    public Collection findAll() {
        Query query = em.createNamedQuery("ParametrosClientesLocal.FindAll");
        return query.getResultList();
    }
    
    public ParametrosClientesLocal findByPais(Long oidPais) {
        Query query = em.createNamedQuery("ParametrosClientesLocal.FindByPais");
        query.setParameter(1, oidPais);
        return (ParametrosClientesLocal)query.getSingleResult();
    }
}
