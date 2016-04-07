package es.indra.sicc.entidades.seg;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.seg.RelacionMCorpoMProduLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class RelacionMCorpoMProduLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-seg");
	private EntityManager em = emf.createEntityManager();

	public RelacionMCorpoMProduLocal create(Long oidMarcaCorporativa, Long oidMarcaProducto, Long oidPais) throws MareException {
		Long oid = SecuenciadorOID.obtenerSiguienteValor("SEG_MMPR_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		RelacionMCorpoMProduLocal local = new RelacionMCorpoMProduLocal(oid, oidMarcaCorporativa, oidMarcaProducto, oidPais);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(RelacionMCorpoMProduLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(RelacionMCorpoMProduLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public RelacionMCorpoMProduLocal findByPrimaryKey(Long  oid) {
		RelacionMCorpoMProduLocal local = em.find(RelacionMCorpoMProduLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}
	
	public Collection findAll() {
		Query query=em.createNamedQuery("RelacionMCorpoMProduLocal.FindAll");
		return query.getResultList();
	}

	public RelacionMCorpoMProduLocal findByUk(Long oidPais, Long oidMarcaCorporativa, Long oidMarcaProducto) {
		Query query=em.createNamedQuery("RelacionMCorpoMProduLocal.FindByUk");
		
		query.setParameter(1, oidPais);
		query.setParameter(2, oidMarcaCorporativa);
		query.setParameter(3, oidMarcaProducto);

		return (RelacionMCorpoMProduLocal)(query.getSingleResult());
	}

}
