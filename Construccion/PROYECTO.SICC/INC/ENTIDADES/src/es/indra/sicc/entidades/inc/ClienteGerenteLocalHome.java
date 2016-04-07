package es.indra.sicc.entidades.inc;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.inc.ClienteGerenteLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class ClienteGerenteLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-inc");
	private EntityManager em = emf.createEntityManager();

	public ClienteGerenteLocal create(Long copaOidParaGral, Long oidClieGere) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("INC_CLGE_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		ClienteGerenteLocal local = new ClienteGerenteLocal(oid, copaOidParaGral, oidClieGere);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(ClienteGerenteLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(ClienteGerenteLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public ClienteGerenteLocal findByPrimaryKey(Long  oid) {
		ClienteGerenteLocal local = (ClienteGerenteLocal)em.find(ClienteGerenteLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
        public Collection findAll() {
                    Query query = em.createNamedQuery("ClienteGerenteLocal.FindAll");
                    return query.getResultList();
            }

	public ClienteGerenteLocal findByGerenteConcurso(Long oidGerente, Long oidConcurso) {
		Query query=em.createNamedQuery("ClienteGerenteLocal.FindByGerenteConcurso");
		
		query.setParameter(1, oidGerente);

		query.setParameter(2, oidConcurso);

		return (ClienteGerenteLocal)(query.getSingleResult());
	}

	public Collection findByConcurso(Long oidConcurso) {
		Query query=em.createNamedQuery("ClienteGerenteLocal.FindByConcurso");
		
		query.setParameter(1, oidConcurso);

	    return query.getResultList();
	}

}
