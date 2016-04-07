package es.indra.sicc.entidades.ape;

import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.ape.FormatoEtiquetaLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class FormatoEtiquetaLocalHome {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-ape");
    private EntityManager em = emf.createEntityManager();

    public FormatoEtiquetaLocal create(Long oidProgramaEtiqueta, Long oidSublinea) throws MareException {
        Long oid = SecuenciadorOID.obtenerSiguienteValor("APE_FOET_SEQ");
        final EntityTransaction et = em.getTransaction();
        et.begin();
        FormatoEtiquetaLocal local = new FormatoEtiquetaLocal(oid, oidProgramaEtiqueta, oidSublinea);
        em.persist(local);
        et.commit();
        return local;
    }
    
    public void remove(FormatoEtiquetaLocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.remove(local);
        et.commit();
    }
    
    public void merge(FormatoEtiquetaLocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.merge(local);
        et.commit();
    }
    
    public FormatoEtiquetaLocal findByPrimaryKey(Long  oid) {
        FormatoEtiquetaLocal local = em.find(FormatoEtiquetaLocal.class, oid);
        if (local==null) throw new NoResultException();
        return local;
    }

    
    public Collection findAll() {
        Query query=em.createNamedQuery("FormatoEtiquetaLocal.FindAll");
        return query.getResultList();
    }

    public FormatoEtiquetaLocal findBySublinea(Long oidSublinea) {
        Query query=em.createNamedQuery("FormatoEtiquetaLocal.FindBySublinea");
        query.setParameter(1, oidSublinea);
        return (FormatoEtiquetaLocal)(query.getSingleResult());
    }

}
