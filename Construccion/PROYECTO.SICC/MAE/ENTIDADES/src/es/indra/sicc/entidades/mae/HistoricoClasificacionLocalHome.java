package es.indra.sicc.entidades.mae;	

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.mae.HistoricoClasificacionLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class HistoricoClasificacionLocalHome {

    //@PersistenceContext private EntityManager em; 
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-mae");
    private EntityManager em = emf.createEntityManager();

    public HistoricoClasificacionLocal create(Long clhe_oid_hist_esta, Long clas_oid_clas) throws MareException {
        Long oid = SecuenciadorOID.obtenerSiguienteValor("MAE_HTCL_SEQ");
        final EntityTransaction et = em.getTransaction();
        et.begin();
        HistoricoClasificacionLocal local = new HistoricoClasificacionLocal(oid, clhe_oid_hist_esta, clas_oid_clas);
        em.persist(local);
        et.commit();
        return local;
    }
    
    public void remove(HistoricoClasificacionLocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.remove(local);
        et.commit();
    }
    
    public void merge(HistoricoClasificacionLocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.merge(local);
        et.commit();
    }
    
    public HistoricoClasificacionLocal findByPrimaryKey(Long  oid) {
        HistoricoClasificacionLocal local = em.find(HistoricoClasificacionLocal.class, oid);
        if (local==null) throw new NoResultException();
        return local;
    }
    
    public Collection findAll() {
        Query query = em.createNamedQuery("HistoricoClasificacionLocal.FindAll");
        return query.getResultList();
    }
}
