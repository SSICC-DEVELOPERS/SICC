package es.indra.sicc.cmn.negocio.print;

import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.cmn.negocio.print.IMPSpoolLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

import java.sql.Timestamp;

public class IMPSpoolLocalHome {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("cmn-impresion");
    private EntityManager em = emf.createEntityManager();

    public IMPSpoolLocal create(Timestamp fecAper, Boolean indActi, Boolean indAper, Long valAcceFisi)
            throws MareException {
            
        Long idSpool = SecuenciadorOID.obtenerSiguienteValor("GEN_GSPO_SEQ");
        final EntityTransaction et = em.getTransaction();
        et.begin();
        IMPSpoolLocal local = new IMPSpoolLocal(idSpool, fecAper, indActi, indAper, valAcceFisi);
        em.persist(local);
        et.commit();
        return local;
    }
    
    public void remove(IMPSpoolLocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.remove(local);
        et.commit();
    }
    
    public void merge(IMPSpoolLocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.merge(local);
        et.commit();
    }
    
    public IMPSpoolLocal findByPrimaryKey(Long primaryKey) {
        IMPSpoolLocal local = em.find(IMPSpoolLocal.class, primaryKey);
        if (local==null) throw new NoResultException();
        return local;
    }

    public Collection findAll() {
        Query query=em.createNamedQuery("IMPSpoolLocal.FindAll");
        return query.getResultList();
    }

}
