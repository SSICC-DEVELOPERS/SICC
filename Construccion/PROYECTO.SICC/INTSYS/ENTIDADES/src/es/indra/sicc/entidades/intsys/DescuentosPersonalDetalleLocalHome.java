package es.indra.sicc.entidades.intsys;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.intsys.DescuentosPersonalDetalleLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

import java.math.BigDecimal;

public class DescuentosPersonalDetalleLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-intsys");
	private EntityManager em = emf.createEntityManager();

	public DescuentosPersonalDetalleLocal create(BigDecimal impDeudaCalculado, Long cliente, Long subtipo, Long numeroDocumento) throws MareException {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		Long oid = SecuenciadorOID.obtenerSiguienteValor("INT_DPED_SEQ");
                DescuentosPersonalDetalleLocal local = new DescuentosPersonalDetalleLocal(oid, impDeudaCalculado, cliente, subtipo, numeroDocumento);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(DescuentosPersonalDetalleLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(DescuentosPersonalDetalleLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public DescuentosPersonalDetalleLocal findByPrimaryKey(Long  oid) {
		DescuentosPersonalDetalleLocal local = em.find(DescuentosPersonalDetalleLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
	public Collection findAll() {
		Query query=em.createNamedQuery("DescuentosPersonalDetalleLocal.FindAll");
		return query.getResultList();
	}

	public Collection findByCabecera(Long param1) {
		Query query=em.createNamedQuery("DescuentosPersonalDetalleLocal.FindByCabecera");
		query.setParameter(1, param1);
		return query.getResultList();
	}

}
