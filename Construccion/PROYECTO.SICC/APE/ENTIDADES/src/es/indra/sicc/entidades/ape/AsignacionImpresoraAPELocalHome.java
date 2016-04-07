package es.indra.sicc.entidades.ape;

import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.ape.AsignacionImpresoraAPELocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class AsignacionImpresoraAPELocalHome {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-ape");
    private EntityManager em = emf.createEntityManager();

    public AsignacionImpresoraAPELocal create(Long imviOidImpr, Long sbarOidSublArma, Long teimOidTecn) throws MareException {
        Long oid = SecuenciadorOID.obtenerSiguienteValor("APE_AIMP_SEQ");
        final EntityTransaction et = em.getTransaction();
        et.begin();
        AsignacionImpresoraAPELocal local = new AsignacionImpresoraAPELocal(oid, imviOidImpr, sbarOidSublArma, teimOidTecn);
        em.persist(local);
        et.commit();
        return local;
    }
    
    public void remove(AsignacionImpresoraAPELocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.remove(local);
        et.commit();
    }
    
    public void merge(AsignacionImpresoraAPELocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.merge(local);
        et.commit();
    }
    
    public AsignacionImpresoraAPELocal findByPrimaryKey(Long oid) {
        AsignacionImpresoraAPELocal local = em.find(AsignacionImpresoraAPELocal.class, oid);
        if (local==null) throw new NoResultException();
        return local;
    }

    
    public Collection findAll() {
        Query query=em.createNamedQuery("AsignacionImpresoraAPELocal.FindAll");
        return query.getResultList();
    }

    public AsignacionImpresoraAPELocal findByUk(Long oidSubLinea) {
        Query query=em.createNamedQuery("AsignacionImpresoraAPELocal.FindByUk");
        query.setParameter(1, oidSubLinea);
        return (AsignacionImpresoraAPELocal)(query.getSingleResult());
    }

}
