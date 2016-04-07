package es.indra.sicc.entidades.inc;

import es.indra.mare.common.exception.MareException;
import es.indra.sicc.util.SecuenciadorOID;

import java.math.BigDecimal;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class ReemplazoArticuloLoteLocalHome {
    //@PersistenceContext private EntityManager em; 
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-inc");
    private EntityManager em = emf.createEntityManager();

    public ReemplazoArticuloLoteLocal create(Long indDesp, BigDecimal impPrecPubi, Long numUnid, String codVentFict, 
                                      Long prodOidProd, Long indCentDistGara, String indTipoEntrPrem, Long ctreOidCritReem, Long valCritReem,
                                      Long arloOidArtiLote, Long numOrde, Long indActi, Long indComu, String valUsua) throws MareException {
                                      
            Long oid = SecuenciadorOID.obtenerSiguienteValor("INC_RARL_SEQ");
            final EntityTransaction et = em.getTransaction();
            et.begin();
            ReemplazoArticuloLoteLocal local = new ReemplazoArticuloLoteLocal(oid, indDesp, impPrecPubi, numUnid, codVentFict, prodOidProd,
                                                                              indCentDistGara, indTipoEntrPrem, ctreOidCritReem,valCritReem,
                                                                              arloOidArtiLote, numOrde, indActi, indComu, valUsua);
            em.persist(local);
            et.commit();
            return local;
    }
    
    public void remove(ReemplazoArticuloLoteLocal local) {
            final EntityTransaction et = em.getTransaction();
            et.begin();
            em.remove(local);
            et.commit();
    }
    
    public void merge(ReemplazoArticuloLoteLocal local) {
            final EntityTransaction et = em.getTransaction();
            et.begin();
            em.merge(local);
            et.commit();
    }
    
    public ReemplazoArticuloLoteLocal findByPrimaryKey(Long  oid) {
            ReemplazoArticuloLoteLocal local = (ReemplazoArticuloLoteLocal)em.find(ReemplazoArticuloLoteLocal.class, oid);
            if (local==null) throw new NoResultException();
            return local;
    }

    
    public Collection findAll() {
                Query query = em.createNamedQuery("ReemplazoArticuloLoteLocal.FindAll");
                return query.getResultList();
        }  

}
