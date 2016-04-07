package es.indra.sicc.cmn.negocio.print;

import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.cmn.negocio.print.IMPQueueLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.util.UtilidadesLog;

public class IMPQueueLocalHome {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("cmn-impresion");
    private EntityManager em = emf.createEntityManager();

    public IMPQueueLocal create(Long idType, Long idSpool) throws MareException {
    
        UtilidadesLog.debug("ENTRADA en el ejbCreate del Entity ");
        Long idQueue = null;
        UtilidadesLog.debug("DATOS DE ENTRADA idType= "+idType+ "  --idSpool = "+idSpool);
        UtilidadesLog.debug("Antes de obtener el secuenciador ");
        idQueue = SecuenciadorOID.obtenerSiguienteValor("GEN_GCOL_SEQ");
        UtilidadesLog.debug("Despues de obtener el secuenciador, el secuenciador es = "+ idQueue);
               
        final EntityTransaction et = em.getTransaction();
        et.begin();
        
        IMPQueueLocal local = new IMPQueueLocal(idQueue, idType, idSpool);
        
        //se inicializa el valor de la ultima secuencia a cero
        local.setLastSequence(new Long(0));
        
        em.persist(local);
        et.commit();
        
        UtilidadesLog.debug("SALIDA en el ejbCreate del Entity ");
        return local;
    }
    
    public void remove(IMPQueueLocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.remove(local);
        et.commit();
    }
    
    public void merge(IMPQueueLocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.merge(local);
        et.commit();
    }
    
    public IMPQueueLocal findByPrimaryKey(Long primaryKey) {
        IMPQueueLocal local = em.find(IMPQueueLocal.class, primaryKey);
        if (local==null) throw new NoResultException();
        return local;
    }

    public IMPQueueLocal findByUK(Long spool, Long impre) {
        Query query=em.createNamedQuery("IMPQueueLocal.FindByUK");
        query.setParameter(1, spool);
        query.setParameter(2, impre);
        return (IMPQueueLocal)(query.getSingleResult());
    }

    public Collection findAll() {
        Query query=em.createNamedQuery("IMPQueueLocal.FindAll");
        return query.getResultList();
    }
}
