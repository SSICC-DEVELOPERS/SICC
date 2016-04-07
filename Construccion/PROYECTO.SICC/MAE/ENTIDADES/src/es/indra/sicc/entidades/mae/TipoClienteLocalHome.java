package es.indra.sicc.entidades.mae;	

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.mae.TipoClienteLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class TipoClienteLocalHome {

    //@PersistenceContext private EntityManager em; 
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-mae");
    private EntityManager em = emf.createEntityManager();

    public TipoClienteLocal create(String cod_tipo_clie, Long ind_eval_esta) throws MareException {
        Long oid = SecuenciadorOID.obtenerSiguienteValor("MAE_TICL_SEQ");
        final EntityTransaction et = em.getTransaction();
        et.begin();
        TipoClienteLocal local = new TipoClienteLocal(oid, cod_tipo_clie, ind_eval_esta);
        em.persist(local);
        et.commit();
        return local;
    }
    
    public void remove(TipoClienteLocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.remove(local);
        et.commit();
    }
    
    public void merge(TipoClienteLocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.merge(local);
        et.commit();
    }
    
    public TipoClienteLocal findByPrimaryKey(Long  oid) {
        TipoClienteLocal local = em.find(TipoClienteLocal.class, oid);
        if (local==null) throw new NoResultException();
        return local;
    }

    public TipoClienteLocal findByUK(String codigoTipoCliente) {
        Query query=em.createNamedQuery("TipoClienteLocal.FindByUK");
        query.setParameter(1, codigoTipoCliente);
        return (TipoClienteLocal)(query.getSingleResult());
    }
    
    public Collection findAll() {
        Query query = em.createNamedQuery("TipoClienteLocal.FindAll");
        return query.getResultList();
    }

}
