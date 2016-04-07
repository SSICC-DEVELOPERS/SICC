package es.indra.sicc.entidades.cal;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.cal.TipoDocumentoEscaneableLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class TipoDocumentoEscaneableLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-cal");
	private EntityManager em = emf.createEntityManager();

	public TipoDocumentoEscaneableLocal create(String tipoDocumento) throws MareException {
	        Long oid = SecuenciadorOID.obtenerSiguienteValor("CAL_TDES_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		TipoDocumentoEscaneableLocal local = new TipoDocumentoEscaneableLocal(oid, tipoDocumento);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(TipoDocumentoEscaneableLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(TipoDocumentoEscaneableLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public TipoDocumentoEscaneableLocal findByPrimaryKey(Long  oid) {
		TipoDocumentoEscaneableLocal local = (TipoDocumentoEscaneableLocal)em.find(TipoDocumentoEscaneableLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
        public Collection findAll() {
                 Query query=em.createNamedQuery("TipoDocumentoEscaneableLocal.FindAll");
                 return query.getResultList();
       }

}
