package es.indra.sicc.entidades.app;

import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;

import es.indra.sicc.entidades.app.RutasTerritoriosLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class RutasTerritoriosLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-app");
	private EntityManager em = emf.createEntityManager();

	public RutasTerritoriosLocal create(Long numeroSecuencia, Long ruta, Long territorio) throws MareException {
		final EntityTransaction et = em.getTransaction();
		et.begin();
                Long oid = SecuenciadorOID.obtenerSiguienteValor("APP_RUTE_SEQ");
		RutasTerritoriosLocal local = new RutasTerritoriosLocal(oid, numeroSecuencia, ruta, territorio);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(RutasTerritoriosLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(RutasTerritoriosLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public RutasTerritoriosLocal findByPrimaryKey(Long  oid) {
		RutasTerritoriosLocal local = (RutasTerritoriosLocal)em.find(RutasTerritoriosLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
}
