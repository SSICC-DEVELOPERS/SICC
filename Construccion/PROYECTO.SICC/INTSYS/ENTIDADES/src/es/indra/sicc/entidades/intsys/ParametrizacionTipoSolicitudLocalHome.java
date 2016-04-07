package es.indra.sicc.entidades.intsys;

import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.intsys.ParametrizacionTipoSolicitudLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class ParametrizacionTipoSolicitudLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-intsys");
	private EntityManager em = emf.createEntityManager();

	public ParametrizacionTipoSolicitudLocal create(Long tipoSolicitud) throws MareException {
		final EntityTransaction et = em.getTransaction();
		et.begin();
                Long oid = SecuenciadorOID.obtenerSiguienteValor("INT_IPTS_SEQ");
                ParametrizacionTipoSolicitudLocal local = new ParametrizacionTipoSolicitudLocal(oid, tipoSolicitud);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(ParametrizacionTipoSolicitudLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(ParametrizacionTipoSolicitudLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public ParametrizacionTipoSolicitudLocal findByPrimaryKey(Long  oid) {
		ParametrizacionTipoSolicitudLocal local = em.find(ParametrizacionTipoSolicitudLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
	public Collection findAll() {
		Query query=em.createNamedQuery("ParametrizacionTipoSolicitudLocal.FindAll");
		return query.getResultList();
	}

}
