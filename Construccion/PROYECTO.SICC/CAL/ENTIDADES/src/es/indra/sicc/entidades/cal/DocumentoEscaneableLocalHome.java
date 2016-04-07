package es.indra.sicc.entidades.cal;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.cal.DocumentoEscaneableLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class DocumentoEscaneableLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-cal");
	private EntityManager em = emf.createEntityManager();

	public DocumentoEscaneableLocal create(String numeroDocumentoEscaneable, Long tipoDocumento, Long cliente) throws MareException {
	        Long oid = SecuenciadorOID.obtenerSiguienteValor("CAL_TDCL_SEQ");
                final EntityTransaction et = em.getTransaction();
		et.begin();
		DocumentoEscaneableLocal local = new DocumentoEscaneableLocal(oid, numeroDocumentoEscaneable, tipoDocumento, cliente);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(DocumentoEscaneableLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(DocumentoEscaneableLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public DocumentoEscaneableLocal findByPrimaryKey(Long  oid) {
		DocumentoEscaneableLocal local = (DocumentoEscaneableLocal)em.find(DocumentoEscaneableLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
    public Collection findAll() {
        Query query=em.createNamedQuery("DocumentoEscaneableLocal.FindAll");
        return query.getResultList();
    }
}
