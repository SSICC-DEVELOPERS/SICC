package es.indra.sicc.entidades.intsys;

import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.intsys.OperacionPostVentaLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class OperacionPostVentaLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-intsys");
	private EntityManager em = emf.createEntityManager();

	public OperacionPostVentaLocal create(String codigo, String descripcion) throws MareException {
		final EntityTransaction et = em.getTransaction();
		et.begin();
                Long oid = SecuenciadorOID.obtenerSiguienteValor("INT_OIVR_SEQ");   
		OperacionPostVentaLocal local = new OperacionPostVentaLocal(oid, codigo, descripcion);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(OperacionPostVentaLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(OperacionPostVentaLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public OperacionPostVentaLocal findByPrimaryKey(Long  oid) {
		OperacionPostVentaLocal local = em.find(OperacionPostVentaLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
	public Collection findAll() {
		Query query=em.createNamedQuery("OperacionPostVentaLocal.FindAll");
		return query.getResultList();
	}

}
