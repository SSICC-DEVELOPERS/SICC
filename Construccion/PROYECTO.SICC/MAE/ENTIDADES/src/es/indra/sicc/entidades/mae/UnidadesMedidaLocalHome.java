package es.indra.sicc.entidades.mae;	

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.mae.UnidadesMedidaLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class UnidadesMedidaLocalHome {

    //@PersistenceContext private EntityManager em; 
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-mae");
    private EntityManager em = emf.createEntityManager();

    public UnidadesMedidaLocal create(Long paisOidPais, String codUnidMedi, Long magnOidMagn, Boolean indUmStnd) throws MareException {
        Long oid = SecuenciadorOID.obtenerSiguienteValor("MAE_UNMD_SEQ");
        final EntityTransaction et = em.getTransaction();
        et.begin();
        UnidadesMedidaLocal local = new UnidadesMedidaLocal(oid, paisOidPais, codUnidMedi, magnOidMagn, indUmStnd);
        em.persist(local);
        et.commit();
        return local;
    }
    
    public void remove(UnidadesMedidaLocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.remove(local);
        et.commit();
    }
    
    public void merge(UnidadesMedidaLocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.merge(local);
        et.commit();
    }
    
    public UnidadesMedidaLocal findByPrimaryKey(Long oid) {
        UnidadesMedidaLocal local = em.find(UnidadesMedidaLocal.class, oid);
        if (local==null) throw new NoResultException();
        return local;
    }

    public Collection findAll() {
        Query query=em.createNamedQuery("UnidadesMedidaLocal.FindAll");
        return query.getResultList();
    }

    public UnidadesMedidaLocal findByUk(Long oidPais,String codigoUnidadMedida) {
        Query query=em.createNamedQuery("UnidadesMedidaLocal.FindByUk");
        query.setParameter(1, oidPais);
        query.setParameter(2, codigoUnidadMedida);
        return (UnidadesMedidaLocal)(query.getSingleResult());
    }

}
