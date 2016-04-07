package es.indra.sicc.entidades.rec;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.rec.OperacionReclamoDigitadoLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class OperacionReclamoDigitadoLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-rec");
	private EntityManager em = emf.createEntityManager();

	public OperacionReclamoDigitadoLocal create(Integer numeroOperacion, Long cabeceraReclamo, Long estadoOperacion) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("REC_RODG_SEQ");
                final EntityTransaction et = em.getTransaction();
		et.begin();
                OperacionReclamoDigitadoLocal local = new OperacionReclamoDigitadoLocal(oid, numeroOperacion, cabeceraReclamo, estadoOperacion);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(OperacionReclamoDigitadoLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(OperacionReclamoDigitadoLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public OperacionReclamoDigitadoLocal findByPrimaryKey(Long  oid) {
		OperacionReclamoDigitadoLocal local = (OperacionReclamoDigitadoLocal)em.find(OperacionReclamoDigitadoLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
	public Collection findAll() {
		Query query=em.createNamedQuery("OperacionReclamoDigitadoLocal.FindAll");
		
		return (query.getResultList());
	}

	public Collection findByReclamo(Long param1) {
		Query query=em.createNamedQuery("OperacionReclamoDigitadoLocal.FindByReclamo");
		
		query.setParameter(1, param1);

		return query.getResultList();
	}

}
