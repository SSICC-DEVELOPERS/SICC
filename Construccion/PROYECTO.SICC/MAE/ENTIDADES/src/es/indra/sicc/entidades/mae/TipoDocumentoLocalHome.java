package es.indra.sicc.entidades.mae;	

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.mae.TipoDocumentoLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class TipoDocumentoLocalHome {

    //@PersistenceContext private EntityManager em; 
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-mae");
    private EntityManager em = emf.createEntityManager();

    public TipoDocumentoLocal create(Long pais_oid_pais, String cod_tipo_docu, Long ind_obli,
            Long ind_dni, Long ind_doc_iden_fisc, Long tipoDocumentoLegal) throws MareException {
        
        Long oid = SecuenciadorOID.obtenerSiguienteValor("MAE_TICL_SEQ");
        final EntityTransaction et = em.getTransaction();
        et.begin();
        TipoDocumentoLocal local = new TipoDocumentoLocal(oid, pais_oid_pais, cod_tipo_docu, ind_obli, ind_dni, ind_doc_iden_fisc, tipoDocumentoLegal);
        em.persist(local);
        et.commit();
        return local;
    }
    
    public void remove(TipoDocumentoLocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.remove(local);
        et.commit();
    }
    
    public void merge(TipoDocumentoLocal local) {
        final EntityTransaction et = em.getTransaction();
        et.begin();
        em.merge(local);
        et.commit();
    }
    
    public TipoDocumentoLocal findByPrimaryKey(Long oid) {
        TipoDocumentoLocal local = em.find(TipoDocumentoLocal.class, oid);
        if (local==null) throw new NoResultException();
        return local;
    }

    public TipoDocumentoLocal findByUK(Long pais,String cod) {
        Query query=em.createNamedQuery("TipoDocumentoLocal.FindByUK");
        query.setParameter(1, pais);
        query.setParameter(2, cod);
        return (TipoDocumentoLocal)(query.getSingleResult());
    }

    public Collection findAll() {
        Query query=em.createNamedQuery("TipoDocumentoLocal.FindAll");
        return query.getResultList();
    }
}
