package es.indra.sicc.entidades.ped;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.ped.EstadosSolicitudesLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class EstadosSolicitudesLocalHome {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-ped");
    private EntityManager em = emf.createEntityManager();

    public EstadosSolicitudesLocal create(String cod_esta_soli) throws MareException {
        Long oid = SecuenciadorOID.obtenerSiguienteValor("PED_ESSO_SEQ");
        final EntityTransaction et = em.getTransaction();
        et.begin();
        EstadosSolicitudesLocal local = new EstadosSolicitudesLocal(oid, cod_esta_soli);
        em.persist(local);
        et.commit();
        return local;
    }
    
    public void remove(EstadosSolicitudesLocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.remove(local);
        et.commit();
    }
    
    public void merge(EstadosSolicitudesLocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.merge(local);
        et.commit();
    }
    
    public EstadosSolicitudesLocal findByPrimaryKey(Long  oid) {
        EstadosSolicitudesLocal local = em.find(EstadosSolicitudesLocal.class, oid);
        if (local==null) throw new NoResultException();
        return local;
    }
    
    public Collection findAll() {
        Query query = em.createNamedQuery("EstadosSolicitudesLocal.FindAll");
        return query.getResultList();
    }

}
