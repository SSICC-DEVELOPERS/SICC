package es.indra.sicc.entidades.mae;	

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.mae.UnidadesNegocioLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class UnidadesNegocioLocalHome {

    //@PersistenceContext private EntityManager em; 
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-mae");
    private EntityManager em = emf.createEntityManager();

    public UnidadesNegocioLocal create(Long paisOidPais, String codUnidNego) throws MareException {
        Long oid = SecuenciadorOID.obtenerSiguienteValor("MAE_NEGO_SEQ");
        final EntityTransaction et = em.getTransaction();
        et.begin();
        UnidadesNegocioLocal local = new UnidadesNegocioLocal(oid, paisOidPais, codUnidNego);
        em.persist(local);
        et.commit();
        return local;
    }
    
    public void remove(UnidadesNegocioLocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.remove(local);
        et.commit();
    }
    
    public void merge(UnidadesNegocioLocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.merge(local);
        et.commit();
    }
    
    public UnidadesNegocioLocal findByPrimaryKey(Long  oid) {
        UnidadesNegocioLocal local = em.find(UnidadesNegocioLocal.class, oid);
        if (local==null) throw new NoResultException();
        return local;
    }

    public Collection findAll() {
        Query query=em.createNamedQuery("UnidadesNegocioLocal.FindAll");
        return query.getResultList();
    }

    public UnidadesNegocioLocal findByUk(Long oidPais,String codigoUnidadNegocio) {
        Query query=em.createNamedQuery("UnidadesNegocioLocal.FindByUk");
        query.setParameter(1, oidPais);
        query.setParameter(2, codigoUnidadNegocio);
        return (UnidadesNegocioLocal)(query.getSingleResult());
    }

}
