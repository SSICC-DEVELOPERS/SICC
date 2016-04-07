package es.indra.sicc.entidades.rec;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.rec.SolicitudesOperacionLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class SolicitudesOperacionLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-rec");
	private EntityManager em = emf.createEntityManager();

	public SolicitudesOperacionLocal create(Long operacion, Long numeroSolicitud, Long tipoSolicitud) throws MareException{
                Long oid = SecuenciadorOID.obtenerSiguienteValor("REC_SOOP_SEQ");
                final EntityTransaction et = em.getTransaction();
		et.begin();
                SolicitudesOperacionLocal local = new SolicitudesOperacionLocal(oid, operacion, numeroSolicitud, tipoSolicitud);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(SolicitudesOperacionLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(SolicitudesOperacionLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public SolicitudesOperacionLocal findByPrimaryKey(Long  oid) {
		SolicitudesOperacionLocal local = (SolicitudesOperacionLocal)em.find(SolicitudesOperacionLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
	public Collection findAll() {
		Query query=em.createNamedQuery("SolicitudesOperacionLocal.FindAll");
		
		return (query.getResultList());
	}

}
