package es.indra.sicc.entidades.edu;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.edu.AptasAsignadasLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class AptasAsignadasLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-edu");
	private EntityManager em = emf.createEntityManager();

	public AptasAsignadasLocal create(Integer numConvocatoria, Long cliente, Long curso, Long subtipo, Boolean apta, Boolean dataMart) throws MareException {
                Long oid=SecuenciadorOID.obtenerSiguienteValor("EDU_APAS_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		AptasAsignadasLocal local = new AptasAsignadasLocal(oid, numConvocatoria, cliente, curso, subtipo, apta, dataMart);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(AptasAsignadasLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(AptasAsignadasLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public AptasAsignadasLocal findByPrimaryKey(Long  oid) {
		AptasAsignadasLocal local = (AptasAsignadasLocal)em.find(AptasAsignadasLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
	public Collection findfindByCurso(Long oid) {
		Query query=em.createNamedQuery("AptasAsignadasLocal.FindfindByCurso");
		
		query.setParameter(1, oid);

		return query.getResultList();
	}

}
