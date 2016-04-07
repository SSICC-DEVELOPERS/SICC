package es.indra.sicc.entidades.intsys;

import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.intsys.ImportesContabilizacionLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class ImportesContabilizacionLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-intsys");
	private EntityManager em = emf.createEntityManager();

	public ImportesContabilizacionLocal create(String codigo, String identificadorCabeceraDetalle, String descripcionImporte) throws MareException {
		final EntityTransaction et = em.getTransaction();
		et.begin();
                Long oid = SecuenciadorOID.obtenerSiguienteValor("INT_IMCF_SEQ");   
		ImportesContabilizacionLocal local = new ImportesContabilizacionLocal(oid, codigo, identificadorCabeceraDetalle, descripcionImporte);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(ImportesContabilizacionLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(ImportesContabilizacionLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public ImportesContabilizacionLocal findByPrimaryKey(Long  oid) {
		ImportesContabilizacionLocal local = em.find(ImportesContabilizacionLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
	public Collection findAll() {
		Query query=em.createNamedQuery("ImportesContabilizacionLocal.FindAll");
		return query.getResultList();
	}

	public ImportesContabilizacionLocal findByUk(String param1) {
		Query query=em.createNamedQuery("ImportesContabilizacionLocal.FindByUk");
		query.setParameter(1, param1);
		return (ImportesContabilizacionLocal)(query.getSingleResult());
	}

}
