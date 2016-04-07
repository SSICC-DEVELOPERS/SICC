package es.indra.sicc.entidades.inc;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.inc.ClienteGerenteRecomendadoLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class ClienteGerenteRecomendadoLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-inc");
	private EntityManager em = emf.createEntityManager();

	public ClienteGerenteRecomendadoLocal create(Long clieOidClie, Long perdOidPeri, Long clgeOidClieGere) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("INC_CLGR_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		ClienteGerenteRecomendadoLocal local = new ClienteGerenteRecomendadoLocal(oid, clieOidClie, perdOidPeri, clgeOidClieGere);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(ClienteGerenteRecomendadoLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(ClienteGerenteRecomendadoLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public ClienteGerenteRecomendadoLocal findByPrimaryKey(Long  oid) {
		ClienteGerenteRecomendadoLocal local = (ClienteGerenteRecomendadoLocal)em.find(ClienteGerenteRecomendadoLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
    public Collection findAll() {
                    Query query = em.createNamedQuery("ClienteGerenteRecomendadoLocal.FindAll");
                    return query.getResultList();
            }


	public ClienteGerenteRecomendadoLocal findByClienteGerente(Long cliente, Long gerente) {
		Query query=em.createNamedQuery("ClienteGerenteRecomendadoLocal.FindByClienteGerente");
		
		query.setParameter(1, cliente);

		query.setParameter(2, gerente);

		return (ClienteGerenteRecomendadoLocal)(query.getSingleResult());
	}

}
