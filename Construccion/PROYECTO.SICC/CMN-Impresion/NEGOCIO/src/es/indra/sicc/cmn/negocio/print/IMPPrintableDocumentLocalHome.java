package es.indra.sicc.cmn.negocio.print;

import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;

import es.indra.sicc.cmn.negocio.print.IMPPrintableDocumentLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

import java.util.Collection;

public class IMPPrintableDocumentLocalHome {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("cmn-impresion");
    private EntityManager em = emf.createEntityManager();

    public IMPPrintableDocumentLocal create(Long gcolOidCola) throws MareException {
        Long idDocument = SecuenciadorOID.obtenerSiguienteValor("GEN_GDIM_SEQ");
        final EntityTransaction et = em.getTransaction();
        et.begin();
        IMPPrintableDocumentLocal local = new IMPPrintableDocumentLocal(idDocument, gcolOidCola);
        em.persist(local);
        et.commit();
        return local;
    }
    
    public void remove(IMPPrintableDocumentLocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.remove(local);
        et.commit();
    }
    
    public void merge(IMPPrintableDocumentLocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.merge(local);
        et.commit();
    }
    
    public IMPPrintableDocumentLocal findByPrimaryKey(Long primaryKey) {
        IMPPrintableDocumentLocal local = em.find(IMPPrintableDocumentLocal.class, primaryKey);
        if (local==null) throw new NoResultException();
        return local;
    }
    
    public Collection findAll() {
        Query query=em.createNamedQuery("IMPPrintableDocumentLocal.FindAll");
        return query.getResultList();
    }

}
