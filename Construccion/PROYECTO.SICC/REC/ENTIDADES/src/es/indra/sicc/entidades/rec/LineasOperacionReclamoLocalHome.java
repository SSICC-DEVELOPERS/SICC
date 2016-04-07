package es.indra.sicc.entidades.rec;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.rec.LineasOperacionReclamoLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class LineasOperacionReclamoLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-rec");
	private EntityManager em = emf.createEntityManager();

	public LineasOperacionReclamoLocal create(Integer numeroLinea, Long operacion, Long tipoOferta, Long tipoPosicion, Long tipoMovimiento, Long motivoDevolucion) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("REC_LIOR_SEQ");
                final EntityTransaction et = em.getTransaction();
		et.begin();
                LineasOperacionReclamoLocal local = new LineasOperacionReclamoLocal(oid , numeroLinea, operacion, tipoOferta, tipoPosicion, tipoMovimiento, motivoDevolucion);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(LineasOperacionReclamoLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(LineasOperacionReclamoLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public LineasOperacionReclamoLocal findByPrimaryKey(Long  oid) {
		LineasOperacionReclamoLocal local = (LineasOperacionReclamoLocal)em.find(LineasOperacionReclamoLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
	public Collection findAll() {
		Query query=em.createNamedQuery("LineasOperacionReclamoLocal.FindAll");
		
		return query.getResultList();
	}

	public Collection findByOperacion(Long param1) {
		Query query=em.createNamedQuery("LineasOperacionReclamoLocal.FindByOperacion");
		
		query.setParameter(1, param1);

		return query.getResultList();
	}

	public LineasOperacionReclamoLocal findByUK(Long param1,Integer param2) {
		Query query=em.createNamedQuery("LineasOperacionReclamoLocal.FindByUK");
		
		query.setParameter(1, param1);

		query.setParameter(2, param2);

		return (LineasOperacionReclamoLocal)(query.getSingleResult());
	}

}
