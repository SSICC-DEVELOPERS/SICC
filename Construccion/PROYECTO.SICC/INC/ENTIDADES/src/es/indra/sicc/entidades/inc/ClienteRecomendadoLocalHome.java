package es.indra.sicc.entidades.inc;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.inc.ClienteRecomendadoLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class ClienteRecomendadoLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-inc");
	private EntityManager em = emf.createEntityManager();

	public ClienteRecomendadoLocal create(Long clieOidClie, Long perdOidPeri, Long recomendante) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("INC_CLRE_SEQ"); //sapaza -- PER-SiCC-2010-0437 -- 12/07/2010
		final EntityTransaction et = em.getTransaction();
		et.begin();
		ClienteRecomendadoLocal local = new ClienteRecomendadoLocal(oid, clieOidClie, perdOidPeri, recomendante);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(ClienteRecomendadoLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(ClienteRecomendadoLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public ClienteRecomendadoLocal findByPrimaryKey(Long  oid) {
		ClienteRecomendadoLocal local = (ClienteRecomendadoLocal)em.find(ClienteRecomendadoLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
    public Collection findAll() {
                    Query query = em.createNamedQuery("ClienteRecomendadoLocal.FindAll");
                    return query.getResultList();
            }

	public ClienteRecomendadoLocal findByUK(Long recomendante, Long recomendado) {
		Query query=em.createNamedQuery("ClienteRecomendadoLocal.FindByUK");
		
		query.setParameter(1, recomendante);

		query.setParameter(2, recomendado);

		return (ClienteRecomendadoLocal)(query.getSingleResult());
	}

}
