package es.indra.sicc.entidades.inc;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.inc.ClienteRecomendadoMultinivelLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class ClienteRecomendadoMultinivelLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-inc");
	private EntityManager em = emf.createEntityManager();

	public ClienteRecomendadoMultinivelLocal create(Long recomendado, Long recomendanteMultinivel, Long periodo) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("INC_CLRM_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		ClienteRecomendadoMultinivelLocal local = new ClienteRecomendadoMultinivelLocal(oid, recomendado, recomendanteMultinivel, periodo);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(ClienteRecomendadoMultinivelLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(ClienteRecomendadoMultinivelLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public ClienteRecomendadoMultinivelLocal findByPrimaryKey(Long  oid) {
		ClienteRecomendadoMultinivelLocal local = (ClienteRecomendadoMultinivelLocal)em.find(ClienteRecomendadoMultinivelLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
        public Collection findAll() {
                    Query query = em.createNamedQuery("ClienteRecomendadoMultinivelLocal.FindAll");
                    return query.getResultList();
            }

	public ClienteRecomendadoMultinivelLocal findByUK(Long recomendado, Long recomendanteMultinivel) {
		Query query=em.createNamedQuery("ClienteRecomendadoMultinivelLocal.FindByUK");
		
		query.setParameter(1, recomendado);

		query.setParameter(2, recomendanteMultinivel);

		return (ClienteRecomendadoMultinivelLocal)(query.getSingleResult());
	}

}
