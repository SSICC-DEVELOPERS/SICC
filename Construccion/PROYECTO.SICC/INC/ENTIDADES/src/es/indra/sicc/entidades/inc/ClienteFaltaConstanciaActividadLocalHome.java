package es.indra.sicc.entidades.inc;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.inc.ClienteFaltaConstanciaActividadLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class ClienteFaltaConstanciaActividadLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-inc");
	private EntityManager em = emf.createEntityManager();

	public ClienteFaltaConstanciaActividadLocal create(Long perdOidPeri, Long clieOidClie) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("INC_CLFC_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		ClienteFaltaConstanciaActividadLocal local = new ClienteFaltaConstanciaActividadLocal(oid, perdOidPeri, clieOidClie);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(ClienteFaltaConstanciaActividadLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(ClienteFaltaConstanciaActividadLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public ClienteFaltaConstanciaActividadLocal findByPrimaryKey(Long  oid) {
		ClienteFaltaConstanciaActividadLocal local = (ClienteFaltaConstanciaActividadLocal)em.find(ClienteFaltaConstanciaActividadLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
        public Collection findAll() {
                    Query query = em.createNamedQuery("ClienteFaltaConstanciaActividadLocal.FindAll");
                    return query.getResultList();
            }

	public ClienteFaltaConstanciaActividadLocal findByUk(Long oidClie, Long oidPeri) {
		Query query=em.createNamedQuery("ClienteFaltaConstanciaActividadLocal.FindByUk");
		
		query.setParameter(1, oidClie);

		query.setParameter(2, oidPeri);

		return (ClienteFaltaConstanciaActividadLocal)(query.getSingleResult());
	}

}
