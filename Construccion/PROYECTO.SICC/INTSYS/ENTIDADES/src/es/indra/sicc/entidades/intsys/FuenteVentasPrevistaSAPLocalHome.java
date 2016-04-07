package es.indra.sicc.entidades.intsys;

import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.intsys.FuenteVentasPrevistaSAPLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class FuenteVentasPrevistaSAPLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-intsys");
	private EntityManager em = emf.createEntityManager();

	public FuenteVentasPrevistaSAPLocal create(Long zona, Long periodo, Long empresa, Long centro) throws MareException {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		Long oid = SecuenciadorOID.obtenerSiguienteValor("INT_FVPS_SEQ");   
                FuenteVentasPrevistaSAPLocal local = new FuenteVentasPrevistaSAPLocal(oid, zona, periodo, empresa, centro);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(FuenteVentasPrevistaSAPLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(FuenteVentasPrevistaSAPLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public FuenteVentasPrevistaSAPLocal findByPrimaryKey(Long  oid) {
		FuenteVentasPrevistaSAPLocal local = em.find(FuenteVentasPrevistaSAPLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
	public Collection findAll() {
		Query query=em.createNamedQuery("FuenteVentasPrevistaSAPLocal.FindAll");
		return query.getResultList();
	}

	public FuenteVentasPrevistaSAPLocal findByUK(Long zona,Long periodo,Long empresa,Long centro) {
		Query query=em.createNamedQuery("FuenteVentasPrevistaSAPLocal.FindByUK");
		query.setParameter(1, zona);
		query.setParameter(2, periodo);
		query.setParameter(3, empresa);
		query.setParameter(4, centro);
		return (FuenteVentasPrevistaSAPLocal)(query.getSingleResult());
	}

}
