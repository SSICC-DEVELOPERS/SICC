package es.indra.sicc.entidades.mae;	

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.mae.CodigosClientesAnterioresLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

import java.sql.Timestamp;

public class CodigosClientesAnterioresLocalHome {

    //@PersistenceContext private EntityManager em; 
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-mae");
    private EntityManager em = emf.createEntityManager();

    public CodigosClientesAnterioresLocal create(Long clieOidClieNuev, String codClieAnti, Long paisOidPais, Timestamp fecUltiActu)
            throws MareException {
        
        Long oid = SecuenciadorOID.obtenerSiguienteValor("MAE_CCLA_SEQ");
        final EntityTransaction et = em.getTransaction();
        et.begin();
        CodigosClientesAnterioresLocal local = new CodigosClientesAnterioresLocal(oid, clieOidClieNuev, codClieAnti, paisOidPais, fecUltiActu);
        em.persist(local);
        et.commit();
        return local;
    }
    
    public void remove(CodigosClientesAnterioresLocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.remove(local);
        et.commit();
    }
    
    public void merge(CodigosClientesAnterioresLocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.merge(local);
        et.commit();
    }
    
    public CodigosClientesAnterioresLocal findByPrimaryKey(Long  oid) {
        CodigosClientesAnterioresLocal local = em.find(CodigosClientesAnterioresLocal.class, oid);
        if (local==null) throw new NoResultException();
        return local;
    }
    
    public Collection findAll() {
        Query query=em.createNamedQuery("CodigosClientesAnterioresLocal.FindAll");
        return query.getResultList();
    }

    public CodigosClientesAnterioresLocal findByUk(Long oidClienNuev) {
        Query query=em.createNamedQuery("CodigosClientesAnterioresLocal.FindByUk");
        query.setParameter(1, oidClienNuev);
        return (CodigosClientesAnterioresLocal)(query.getSingleResult());
    }

}
