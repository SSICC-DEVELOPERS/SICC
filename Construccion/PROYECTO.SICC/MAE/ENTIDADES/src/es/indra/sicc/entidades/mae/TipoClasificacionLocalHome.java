package es.indra.sicc.entidades.mae;	

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.mae.TipoClasificacionLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class TipoClasificacionLocalHome {

    //@PersistenceContext private EntityManager em; 
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-mae");
    private EntityManager em = emf.createEntityManager();

    public TipoClasificacionLocal create(Long sbti_oid_subt_clie, String cod_tipo_clas) throws MareException {
        Long oid = SecuenciadorOID.obtenerSiguienteValor("MAE_TCCL_SEQ");
        final EntityTransaction et = em.getTransaction();
        et.begin();
        TipoClasificacionLocal local = new TipoClasificacionLocal(oid, sbti_oid_subt_clie, cod_tipo_clas);
        em.persist(local);
        et.commit();
        return local;
    }
    
    public void remove(TipoClasificacionLocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.remove(local);
        et.commit();
    }
    
    public void merge(TipoClasificacionLocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.merge(local);
        et.commit();
    }
    
    public TipoClasificacionLocal findByPrimaryKey(Long  oid) {
        TipoClasificacionLocal local = em.find(TipoClasificacionLocal.class, oid);
        if (local==null) throw new NoResultException();
        return local;
    }

    public TipoClasificacionLocal findByUK(String codigo,Long oidSubtipoCliente) {
        Query query=em.createNamedQuery("TipoClasificacionLocal.FindByUK");
        query.setParameter(1, codigo);
        query.setParameter(2, oidSubtipoCliente);
        return (TipoClasificacionLocal)(query.getSingleResult());
    }

    public Collection findAll() {
        Query query=em.createNamedQuery("TipoClasificacionLocal.FindByUK");
        return query.getResultList();
    }
}
