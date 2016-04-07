package es.indra.sicc.entidades.inc;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.inc.ProgramaNuevasLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class ProgramaNuevasLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-inc");
	private EntityManager em = emf.createEntityManager();

	public ProgramaNuevasLocal create(Integer numPediEval, Long copaOidParaGral, Long treqOidTipoRequ, Integer numPediPrem) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("INC_PRNU_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		ProgramaNuevasLocal local = new ProgramaNuevasLocal(oid, numPediEval, copaOidParaGral, treqOidTipoRequ, numPediPrem);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(ProgramaNuevasLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(ProgramaNuevasLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public ProgramaNuevasLocal findByPrimaryKey(Long  oid) {
		ProgramaNuevasLocal local = (ProgramaNuevasLocal)em.find(ProgramaNuevasLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
	public Collection findAll() {
		Query query = em.createNamedQuery("ProgramaNuevasLocal.FindAll");
		return query.getResultList();
	}

	public ProgramaNuevasLocal findByConcurso(Long oidConcurso) {
		Query query=em.createNamedQuery("ProgramaNuevasLocal.FindByConcurso");
		
		query.setParameter(1, oidConcurso);

	    return (ProgramaNuevasLocal)(query.getSingleResult());
	}

}
