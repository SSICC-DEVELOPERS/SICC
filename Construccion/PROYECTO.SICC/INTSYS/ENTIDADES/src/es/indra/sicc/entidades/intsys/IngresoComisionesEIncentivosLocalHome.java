package es.indra.sicc.entidades.intsys;

import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.intsys.IngresoComisionesEIncentivosLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class IngresoComisionesEIncentivosLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-intsys");
	private EntityManager em = emf.createEntityManager();

	public IngresoComisionesEIncentivosLocal create(Long importePagar, Long oidTipoSubtipo, Long oidComisionIncentivo) throws MareException {
		final EntityTransaction et = em.getTransaction();
		et.begin();
                Long oid = SecuenciadorOID.obtenerSiguienteValor("INT_ICEI_SEQ"); 
		IngresoComisionesEIncentivosLocal local = new IngresoComisionesEIncentivosLocal(oid, importePagar, oidTipoSubtipo, oidComisionIncentivo);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(IngresoComisionesEIncentivosLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(IngresoComisionesEIncentivosLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public IngresoComisionesEIncentivosLocal findByPrimaryKey(Long  oid) {
		IngresoComisionesEIncentivosLocal local = em.find(IngresoComisionesEIncentivosLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
	public Collection findAll() {
		Query query=em.createNamedQuery("IngresoComisionesEIncentivosLocal.FindAll");
		return query.getResultList();
	}

}
