package es.indra.sicc.entidades.fac;

import es.indra.mare.common.exception.MareException;
import es.indra.sicc.entidades.fac.TipoDocumentoLegalLocal;
import es.indra.sicc.util.SecuenciadorOID;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;


public class TipoDocumentoLegalLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-fac");
	private EntityManager em = emf.createEntityManager();

	public TipoDocumentoLegalLocal create(String tipoDocumento, String descripcionDocumento, Long tipoDocLegalContra) throws MareException {
		final EntityTransaction et = em.getTransaction();
		et.begin();
                Long oid = SecuenciadorOID.obtenerSiguienteValor("FAC_TIDO_SEQ");
		TipoDocumentoLegalLocal local = new TipoDocumentoLegalLocal(oid, tipoDocumento, descripcionDocumento, tipoDocLegalContra);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(TipoDocumentoLegalLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(TipoDocumentoLegalLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public TipoDocumentoLegalLocal findByPrimaryKey(Long  oid) {
		TipoDocumentoLegalLocal local = (TipoDocumentoLegalLocal)em.find(TipoDocumentoLegalLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
	public TipoDocumentoLegalLocal findByUK(String param1) {
		Query query=em.createNamedQuery("TipoDocumentoLegalLocal.FindByUK");
		
		query.setParameter(1, param1);

		return (TipoDocumentoLegalLocal)(query.getSingleResult());
	}

}
