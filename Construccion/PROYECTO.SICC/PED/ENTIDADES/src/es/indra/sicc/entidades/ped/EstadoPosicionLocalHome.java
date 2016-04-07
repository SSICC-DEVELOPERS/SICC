package es.indra.sicc.entidades.ped;

import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.ped.EstadoPosicionLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class EstadoPosicionLocalHome {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-ped");
    private EntityManager em = emf.createEntityManager();

    public EstadoPosicionLocal create(String cod_esta_posi) throws MareException {
        Long oid = SecuenciadorOID.obtenerSiguienteValor("PED_ESPO_SEQ");
        final EntityTransaction et = em.getTransaction();
        et.begin();
        EstadoPosicionLocal local = new EstadoPosicionLocal(oid, cod_esta_posi);
        em.persist(local);
        et.commit();
        return local;
    }
    
    public void remove(EstadoPosicionLocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.remove(local);
        et.commit();
    }
    
    public void merge(EstadoPosicionLocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.merge(local);
        et.commit();
    }
    
    public EstadoPosicionLocal findByPrimaryKey(Long  oid) {
        EstadoPosicionLocal local = em.find(EstadoPosicionLocal.class, oid);
        if (local==null) throw new NoResultException();
        return local;
    }
    
    public Collection findAll() {
        Query query = em.createNamedQuery("EstadoPosicionLocal.FindAll");
        return query.getResultList();
    }
	
}
