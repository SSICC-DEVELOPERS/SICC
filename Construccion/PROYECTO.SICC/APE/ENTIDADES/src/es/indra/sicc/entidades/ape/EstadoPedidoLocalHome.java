package es.indra.sicc.entidades.ape;

import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.ape.EstadoPedidoLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class EstadoPedidoLocalHome {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-ape");
    private EntityManager em = emf.createEntityManager();

    public EstadoPedidoLocal create(Long numOrde, String valEstaCaja) throws MareException {
        Long oid = SecuenciadorOID.obtenerSiguienteValor("APE_ESTP_SEQ");
        final EntityTransaction et = em.getTransaction();
        et.begin();
        EstadoPedidoLocal local = new EstadoPedidoLocal(oid, numOrde, valEstaCaja);
        em.persist(local);
        et.commit();
        return local;
    }
    
    public void remove(EstadoPedidoLocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.remove(local);
        et.commit();
    }
    
    public void merge(EstadoPedidoLocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.merge(local);
        et.commit();
    }
    
    public EstadoPedidoLocal findByPrimaryKey(Long  oid) {
        EstadoPedidoLocal local = em.find(EstadoPedidoLocal.class, oid);
        if (local==null) throw new NoResultException();
        return local;
    }
    
    public Collection findAll() {
        Query query=em.createNamedQuery("EstadoPedidoLocal.FindAll");
        return query.getResultList();
    }

}
