package es.indra.sicc.entidades.inc;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.inc.ClienteRecomendanteLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class ClienteRecomendanteLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-inc");
	private EntityManager em = emf.createEntityManager();

	public ClienteRecomendanteLocal create(Long clieOidClie, Long copaOidParaGral) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("INC_CLR3_SEQ"); //sapaza -- PER-SiCC-2010-0437 -- 12/07/2010
		final EntityTransaction et = em.getTransaction();
		et.begin();
		ClienteRecomendanteLocal local = new ClienteRecomendanteLocal(oid, clieOidClie, copaOidParaGral);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(ClienteRecomendanteLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(ClienteRecomendanteLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public ClienteRecomendanteLocal findByPrimaryKey(Long  oid) {
		ClienteRecomendanteLocal local = (ClienteRecomendanteLocal)em.find(ClienteRecomendanteLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
    public Collection findAll() {
                    Query query = em.createNamedQuery("ClienteRecomendanteLocal.FindAll");
                    return query.getResultList();
            }
            
	public ClienteRecomendanteLocal findByUK(Long recomendante, Long concurso) {
		Query query=em.createNamedQuery("ClienteRecomendanteLocal.FindByUK");
		
		query.setParameter(1, recomendante);

		query.setParameter(2, concurso);

		return (ClienteRecomendanteLocal)(query.getSingleResult());
	}

	public Collection findByConcurso(Long oidConcurso) {
		Query query=em.createNamedQuery("ClienteRecomendanteLocal.FindByConcurso");
		
		query.setParameter(1, oidConcurso);

	    return query.getResultList();
	}

}
