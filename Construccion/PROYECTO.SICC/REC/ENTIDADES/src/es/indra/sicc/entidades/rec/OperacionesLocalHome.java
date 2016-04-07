package es.indra.sicc.entidades.rec;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.rec.OperacionesLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class OperacionesLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-rec");
	private EntityManager em = emf.createEntityManager();

	public OperacionesLocal create(String codOperacion, String descripcionLarga, Boolean anulacion, Long pais, Long precios, Boolean recojo) throws MareException  {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("REC_ROPE_SEQ");
                final EntityTransaction et = em.getTransaction();
		et.begin();
                OperacionesLocal local = new OperacionesLocal(oid, codOperacion, descripcionLarga, anulacion, pais, precios, recojo);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(OperacionesLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(OperacionesLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public OperacionesLocal findByPrimaryKey(Long  oid) {
		OperacionesLocal local = (OperacionesLocal)em.find(OperacionesLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
	public Collection findAll() {
		Query query=em.createNamedQuery("OperacionesLocal.FindAll");
		
		return (query.getResultList());
	}

}
