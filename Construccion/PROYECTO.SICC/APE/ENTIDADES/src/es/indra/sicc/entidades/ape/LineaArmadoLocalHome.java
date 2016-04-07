package es.indra.sicc.entidades.ape;

import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.ape.LineaArmadoLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class LineaArmadoLocalHome {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-ape");
    private EntityManager em = emf.createEntityManager();

    public LineaArmadoLocal create(Long codigo, Long longNunEtiq, Boolean LineaAFP,
            Boolean valDefecto, Long oidCD, Long oidFD) throws MareException {
            
        Long oid = SecuenciadorOID.obtenerSiguienteValor("APE_LIAR_SEQ");
        final EntityTransaction et = em.getTransaction();
        et.begin();
        LineaArmadoLocal local;
        local = new LineaArmadoLocal(oid, codigo, longNunEtiq, LineaAFP, valDefecto, oidCD, oidFD);
        em.persist(local);
        et.commit();
        return local;
    }
    
    public void remove(LineaArmadoLocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.remove(local);
        et.commit();
    }
    
    public void merge(LineaArmadoLocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.merge(local);
        et.commit();
    }
    
    public LineaArmadoLocal findByPrimaryKey(Long  oid) {
        LineaArmadoLocal local = em.find(LineaArmadoLocal.class, oid);
        if (local==null) throw new NoResultException();
        return local;
    }

    public Collection findAll() {
        Query query=em.createNamedQuery("LineaArmadoLocal.FindAll");
        return query.getResultList();
    }

    public LineaArmadoLocal findByUK(Long codigoLinea) {
        Query query=em.createNamedQuery("LineaArmadoLocal.FindByUK");
        query.setParameter(1, codigoLinea);
        return (LineaArmadoLocal)(query.getSingleResult());
    }

}
