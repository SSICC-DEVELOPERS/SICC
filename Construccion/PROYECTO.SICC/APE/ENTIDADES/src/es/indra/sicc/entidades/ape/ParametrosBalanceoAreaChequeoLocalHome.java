package es.indra.sicc.entidades.ape;

import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.ape.ParametrosBalanceoAreaChequeoLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class ParametrosBalanceoAreaChequeoLocalHome {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-ape");
    private EntityManager em = emf.createEntityManager();

    public ParametrosBalanceoAreaChequeoLocal create(Long numPediHoraArma, Long numUnidHoraPersCheq,
            Long numParaDist, Long ccdiOidConfCentDist, Long liarOidLineArma, Double horaDia, Long codAgru) throws MareException {
            
        Long oid = SecuenciadorOID.obtenerSiguienteValor("APE_PBAC_SEQ");
        final EntityTransaction et = em.getTransaction();
        et.begin();
        ParametrosBalanceoAreaChequeoLocal local = new ParametrosBalanceoAreaChequeoLocal(oid, numPediHoraArma, numUnidHoraPersCheq,
            numParaDist, ccdiOidConfCentDist, liarOidLineArma, horaDia, codAgru);
        em.persist(local);
        et.commit();
        return local;
    }
    
    public void remove(ParametrosBalanceoAreaChequeoLocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.remove(local);
        et.commit();
    }
    
    public void merge(ParametrosBalanceoAreaChequeoLocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.merge(local);
        et.commit();
    }
    
    public ParametrosBalanceoAreaChequeoLocal findByPrimaryKey(Long  oid) {
        ParametrosBalanceoAreaChequeoLocal local = em.find(ParametrosBalanceoAreaChequeoLocal.class, oid);
        if (local==null) throw new NoResultException();
        return local;
    }
    
    public Collection findAll() {
        Query query=em.createNamedQuery("ParametrosBalanceoAreaChequeoLocal.FindAll");
        return query.getResultList();
    }

}
