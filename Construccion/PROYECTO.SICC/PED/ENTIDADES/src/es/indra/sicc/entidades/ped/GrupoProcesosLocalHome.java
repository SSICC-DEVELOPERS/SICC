package es.indra.sicc.entidades.ped;

import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.ped.GrupoProcesosLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class GrupoProcesosLocalHome {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-ped");
    private EntityManager em = emf.createEntityManager();

    public GrupoProcesosLocal create(String cod_grup_proc) throws MareException {
        Long oid = SecuenciadorOID.obtenerSiguienteValor("PED_SEPR_SEQ");
        final EntityTransaction et = em.getTransaction();
        et.begin();
        GrupoProcesosLocal local = new GrupoProcesosLocal(oid, cod_grup_proc);
        em.persist(local);
        et.commit();
        return local;
    }
    
    public void remove(GrupoProcesosLocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.remove(local);
        et.commit();
    }
    
    public void merge(GrupoProcesosLocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.merge(local);
        et.commit();
    }
    
    public GrupoProcesosLocal findByPrimaryKey(Long  oid) {
        GrupoProcesosLocal local = em.find(GrupoProcesosLocal.class, oid);
        if (local==null) throw new NoResultException();
        return local;
    }
	
    public Collection findAll() {
        Query query = em.createNamedQuery("GrupoProcesosLocal.FindAll");
        return query.getResultList();
    }
}
