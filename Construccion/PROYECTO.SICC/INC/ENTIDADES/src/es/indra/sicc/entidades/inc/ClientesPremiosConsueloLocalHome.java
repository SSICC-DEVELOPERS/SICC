package es.indra.sicc.entidades.inc;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.inc.ClientesPremiosConsueloLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class ClientesPremiosConsueloLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-inc");
	private EntityManager em = emf.createEntityManager();

	public ClientesPremiosConsueloLocal create(Long clieOidClie, Long prcoOidPremCons) throws MareException {
                Long oidClientesPremioConsuelo = SecuenciadorOID.obtenerSiguienteValor("INC_CLPC_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		ClientesPremiosConsueloLocal local = new ClientesPremiosConsueloLocal(oidClientesPremioConsuelo, clieOidClie, prcoOidPremCons);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(ClientesPremiosConsueloLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(ClientesPremiosConsueloLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public ClientesPremiosConsueloLocal findByPrimaryKey(Long  oidClientesPremioConsuelo) {
		ClientesPremiosConsueloLocal local = (ClientesPremiosConsueloLocal)em.find(ClientesPremiosConsueloLocal.class, oidClientesPremioConsuelo);
		if (local==null) throw new NoResultException();
		return local;
	}

	
    public Collection findAll() {
                    Query query = em.createNamedQuery("ClientesPremiosConsueloLocal.FindAll");
                    return query.getResultList();
            }

}
