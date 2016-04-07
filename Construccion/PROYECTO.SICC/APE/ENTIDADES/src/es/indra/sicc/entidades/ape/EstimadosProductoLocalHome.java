package es.indra.sicc.entidades.ape;

import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.ape.EstimadosProductoLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class EstimadosProductoLocalHome {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-ape");
    private EntityManager em = emf.createEntityManager();

    public EstimadosProductoLocal create(Long numUnidEsti, Boolean indFuerPedi,
            Long prceOidProc, Long liarOidLineArma, Long perdOidPeri, Long prodOidProd)
            throws MareException {
            
        Long oid = SecuenciadorOID.obtenerSiguienteValor("APE_ESPR_SEQ");
        final EntityTransaction et = em.getTransaction();
        et.begin();
        EstimadosProductoLocal local;
        local = new EstimadosProductoLocal(oid, numUnidEsti, indFuerPedi, prceOidProc, liarOidLineArma, perdOidPeri, prodOidProd);
        em.persist(local);
        et.commit();
        return local;
    }
    
    public void remove(EstimadosProductoLocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.remove(local);
        et.commit();
    }
    
    public void merge(EstimadosProductoLocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.merge(local);
        et.commit();
    }
    
    public EstimadosProductoLocal findByPrimaryKey(Long  oid) {
        EstimadosProductoLocal local = em.find(EstimadosProductoLocal.class, oid);
        if (local==null) throw new NoResultException();
        return local;
    }

    
    public Collection findAll() {
        Query query=em.createNamedQuery("EstimadosProductoLocal.FindAll");
        return query.getResultList();
    }

    public EstimadosProductoLocal findByUK(Long oidLineaArmado, Long oidPeriodo, 
            Long oidProce, Long oidProdu, Boolean indFuerPedi) {
        Query query=em.createNamedQuery("EstimadosProductoLocal.FindByUK");
        query.setParameter(1, oidLineaArmado);
        query.setParameter(2, oidPeriodo);
        query.setParameter(3, oidProce);
        query.setParameter(4, oidProdu);
        query.setParameter(5, indFuerPedi);
        return (EstimadosProductoLocal)(query.getSingleResult());
    }

    public Collection findByLineaPeriodo(Long oidLineaArmado, Long oidLineaArmadoMav,  Long oidPeriodo) {
        Query query=em.createNamedQuery("EstimadosProductoLocal.FindByLineaPeriodo");
        query.setParameter(1, oidLineaArmado);
        query.setParameter(2, oidLineaArmadoMav);
        query.setParameter(3, oidPeriodo);
        return query.getResultList();
    }

}
