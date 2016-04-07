package es.indra.sicc.entidades.ped;

import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.ped.IndicadorRevisionLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class IndicadorRevisionLocalHome {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-ped");
    private EntityManager em = emf.createEntityManager();

    public IndicadorRevisionLocal create(String cod_indi_reve) throws MareException {
        Long oid = SecuenciadorOID.obtenerSiguienteValor("PED_INRE_SEQ");
        final EntityTransaction et = em.getTransaction();
        et.begin();
        IndicadorRevisionLocal local = new IndicadorRevisionLocal(oid, cod_indi_reve);
        em.persist(local);
        et.commit();
        return local;
    }
    
    public void remove(IndicadorRevisionLocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.remove(local);
        et.commit();
    }
    
    public void merge(IndicadorRevisionLocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.merge(local);
        et.commit();
    }
    
    public IndicadorRevisionLocal findByPrimaryKey(Long oid) {
        IndicadorRevisionLocal local = em.find(IndicadorRevisionLocal.class, oid);
        if (local==null) throw new NoResultException();
        return local;
    }
    
    public Collection findAll() {
        Query query = em.createNamedQuery("IndicadorRevisionLocal.FindAll");
        return query.getResultList();
    }

}
