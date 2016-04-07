package es.indra.sicc.entidades.inc;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.inc.ClienteRecomendanteMultinivelLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class ClienteRecomendanteMultinivelLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-inc");
	private EntityManager em = emf.createEntityManager();

	public ClienteRecomendanteMultinivelLocal create(Long oidClieRecoMult, Long copaOidParaGral) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("INC_CLR2_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		ClienteRecomendanteMultinivelLocal local = new ClienteRecomendanteMultinivelLocal(oid, oidClieRecoMult, copaOidParaGral);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(ClienteRecomendanteMultinivelLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(ClienteRecomendanteMultinivelLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public ClienteRecomendanteMultinivelLocal findByPrimaryKey(Long  oid) {
		ClienteRecomendanteMultinivelLocal local = (ClienteRecomendanteMultinivelLocal)em.find(ClienteRecomendanteMultinivelLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
    public Collection findAll() {
                    Query query = em.createNamedQuery("ClienteRecomendanteMultinivelLocal.FindAll");
                    return query.getResultList();
            }

	public ClienteRecomendanteMultinivelLocal findByUK(Long recomendante, Long concurso) {
		Query query=em.createNamedQuery("ClienteRecomendanteMultinivelLocal.FindByUK");
		
		query.setParameter(1, recomendante);

		query.setParameter(2, concurso);

		return (ClienteRecomendanteMultinivelLocal)(query.getSingleResult());
	}

	public Collection findByConcurso(Long oidConcurso) {
		Query query=em.createNamedQuery("ClienteRecomendanteMultinivelLocal.FindByConcurso");
		
		query.setParameter(1, oidConcurso);

	    return query.getResultList();
	}

}
