package es.indra.sicc.entidades.ape;

import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.ape.TipoSolicitudBalanceoAreaChequeoLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class TipoSolicitudBalanceoAreaChequeoLocalHome {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-ape");
    private EntityManager em = emf.createEntityManager();
    
    public TipoSolicitudBalanceoAreaChequeoLocal create(Long pbacOidParaBalaAreaCheq, Long tspaOidTipoSoliPais) throws MareException {
        Long oid = SecuenciadorOID.obtenerSiguienteValor("APE_TSAC_SEQ");
        final EntityTransaction et = em.getTransaction();
        et.begin();
        TipoSolicitudBalanceoAreaChequeoLocal local;
        local = new TipoSolicitudBalanceoAreaChequeoLocal(oid, pbacOidParaBalaAreaCheq, tspaOidTipoSoliPais);
        em.persist(local);
        et.commit();
        return local;
    }
    
    public void remove(TipoSolicitudBalanceoAreaChequeoLocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.remove(local);
        et.commit();
    }
    
    public void merge(TipoSolicitudBalanceoAreaChequeoLocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.merge(local);
        et.commit();
    }
    
    public TipoSolicitudBalanceoAreaChequeoLocal findByPrimaryKey(Long  oid) {
        TipoSolicitudBalanceoAreaChequeoLocal local = em.find(TipoSolicitudBalanceoAreaChequeoLocal.class, oid);
        if (local==null) throw new NoResultException();
        return local;
    }
    
    
    public Collection findAll() {
        Query query=em.createNamedQuery("TipoSolicitudBalanceoAreaChequeoLocal.FindAll");
        return query.getResultList();
    }
    
    public Collection findByParametros(Long oidParametros) {
        Query query=em.createNamedQuery("TipoSolicitudBalanceoAreaChequeoLocal.FindByParametros");
        query.setParameter(1, oidParametros);
        return query.getResultList();
    }
    
}
