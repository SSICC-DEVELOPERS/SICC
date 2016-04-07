package es.indra.sicc.entidades.mae;	

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.mae.NegocioLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class NegocioLocalHome {

    //@PersistenceContext private EntityManager em; 
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-mae");
    private EntityManager em = emf.createEntityManager();

    public NegocioLocal create(Long paisOidPais, String codNego) throws MareException {
        Long oid = SecuenciadorOID.obtenerSiguienteValor("MAE_NEGO_SEQ");
        final EntityTransaction et = em.getTransaction();
        et.begin();
        NegocioLocal local = new NegocioLocal(oid, paisOidPais, codNego);
        em.persist(local);
        et.commit();
        return local;
    }
    
    public void remove(NegocioLocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.remove(local);
        et.commit();
    }
    
    public void merge(NegocioLocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.merge(local);
        et.commit();
    }
    
    public NegocioLocal findByPrimaryKey(Long  oid) {
        NegocioLocal local = em.find(NegocioLocal.class, oid);
        if (local==null) throw new NoResultException();
        return local;
    }

    public Collection findAll() {
        Query query=em.createNamedQuery("NegocioLocal.FindAll");
        return query.getResultList();
    }

    public NegocioLocal findByUk(Long oidPais,String codigoNegocio) {
        Query query=em.createNamedQuery("NegocioLocal.FindByUk");
        query.setParameter(1, oidPais);
        query.setParameter(2, codigoNegocio);
        return (NegocioLocal)(query.getSingleResult());
    }
}
