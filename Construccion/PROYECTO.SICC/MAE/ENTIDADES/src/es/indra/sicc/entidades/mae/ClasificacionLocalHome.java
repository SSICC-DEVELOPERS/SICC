package es.indra.sicc.entidades.mae;	

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.mae.ClasificacionLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class ClasificacionLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-mae");
	private EntityManager em = emf.createEntityManager();

	public ClasificacionLocal create(Long tipoClasificacion, String codigo) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("MAE_CLAS_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		ClasificacionLocal local = new ClasificacionLocal(oid, tipoClasificacion, codigo);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(ClasificacionLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(ClasificacionLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public ClasificacionLocal findByPrimaryKey(Long  oid) {
		ClasificacionLocal local = em.find(ClasificacionLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
	public Collection findAll() {
		Query query=em.createNamedQuery("ClasificacionLocal.FindAll");
		return query.getResultList();
	}

	public ClasificacionLocal findByUK(Long oidTipoClasificacion,String codigo) {
		Query query=em.createNamedQuery("ClasificacionLocal.FindByUK");
		query.setParameter(1, oidTipoClasificacion);
		query.setParameter(2, codigo);
		return (ClasificacionLocal)(query.getSingleResult());
	}

}
