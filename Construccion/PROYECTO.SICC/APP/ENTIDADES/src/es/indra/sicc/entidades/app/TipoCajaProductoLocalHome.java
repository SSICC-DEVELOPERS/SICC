package es.indra.sicc.entidades.app;

import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.app.TipoCajaProductoLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class TipoCajaProductoLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-app");
	private EntityManager em = emf.createEntityManager();

	public TipoCajaProductoLocal create(String codCaja, Long paisOidPais) throws MareException {
		final EntityTransaction et = em.getTransaction();
		et.begin();
                Long oid = SecuenciadorOID.obtenerSiguienteValor("APP_TICP_SEQ");
		TipoCajaProductoLocal local = new TipoCajaProductoLocal(oid, codCaja, paisOidPais);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(TipoCajaProductoLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(TipoCajaProductoLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public TipoCajaProductoLocal findByPrimaryKey(Long  oid) {
		TipoCajaProductoLocal local = (TipoCajaProductoLocal)em.find(TipoCajaProductoLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
	public Collection findAll() {
		Query query=em.createNamedQuery("TipoCajaProductoLocal.FindAll");
		return (query.getResultList());
	}

}
