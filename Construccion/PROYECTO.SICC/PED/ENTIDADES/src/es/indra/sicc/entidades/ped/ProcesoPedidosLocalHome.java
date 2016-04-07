package es.indra.sicc.entidades.ped;

import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.ped.ProcesoPedidosLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class ProcesoPedidosLocalHome {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-ped");
    private EntityManager em = emf.createEntityManager();

    public ProcesoPedidosLocal create(String cod_proc, Long grpr_oid_grup_proc) throws MareException {
        Long oid = SecuenciadorOID.obtenerSiguienteValor("PED_PROC_SEQ");
        final EntityTransaction et = em.getTransaction();
        et.begin();
        ProcesoPedidosLocal local = new ProcesoPedidosLocal(oid, cod_proc, grpr_oid_grup_proc);
        em.persist(local);
        et.commit();
        return local;
    }
    
    public void remove(ProcesoPedidosLocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.remove(local);
        et.commit();
    }
    
    public void merge(ProcesoPedidosLocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.merge(local);
        et.commit();
    }
    
    public ProcesoPedidosLocal findByPrimaryKey(Long  oid) {
        ProcesoPedidosLocal local = em.find(ProcesoPedidosLocal.class, oid);
        if (local==null) throw new NoResultException();
        return local;
    }

    public ProcesoPedidosLocal findByUK(String cod) {
        Query query=em.createNamedQuery("ProcesoPedidosLocal.FindByUK");
        query.setParameter(1, cod);
        return (ProcesoPedidosLocal)(query.getSingleResult());
    }

    public Collection findAll() {
        Query query=em.createNamedQuery("ProcesoPedidosLocal.FindAll");
        return query.getResultList();
    }

}
