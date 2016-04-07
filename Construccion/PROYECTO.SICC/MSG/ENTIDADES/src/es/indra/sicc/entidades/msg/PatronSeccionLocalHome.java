package es.indra.sicc.entidades.msg;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.msg.PatronSeccionLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class PatronSeccionLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-msg");
	private EntityManager em = emf.createEntityManager();

	public PatronSeccionLocal create(String cod_secc, Long patr_oid_patr, Integer num_orde_secc) throws MareException {
		final EntityTransaction et = em.getTransaction();
		et.begin();
	        Long oid = SecuenciadorOID.obtenerSiguienteValor("MSG_PASE_SEQ");
		PatronSeccionLocal local = new PatronSeccionLocal(oid, cod_secc, patr_oid_patr, num_orde_secc);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(PatronSeccionLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(PatronSeccionLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public PatronSeccionLocal findByPrimaryKey(Long  oid) {
		PatronSeccionLocal local = (PatronSeccionLocal)em.find(PatronSeccionLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
	public Collection findByPatron(Long param1) {
		Query query=em.createNamedQuery("PatronSeccionLocal.FindByPatron");
		
		query.setParameter(1, param1);

		return query.getResultList();
	}

	public PatronSeccionLocal findByOrdenSeccion(Long param1,Integer param2) {
		Query query=em.createNamedQuery("PatronSeccionLocal.FindByOrdenSeccion");
		
		query.setParameter(1, param1);

		query.setParameter(2, param2);

		return (PatronSeccionLocal)(query.getSingleResult());
	}

}
