package es.indra.sicc.entidades.rec;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.rec.MotivosDevolucionOperacionLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class MotivosDevolucionOperacionLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-rec");
	private EntityManager em = emf.createEntityManager();

	public MotivosDevolucionOperacionLocal create(Long codMotivoDevolucion, Long pais, Long operacion) throws MareException  {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("REC_MODO_SEQ");
                final EntityTransaction et = em.getTransaction();
		et.begin();
                MotivosDevolucionOperacionLocal local = new MotivosDevolucionOperacionLocal(oid, codMotivoDevolucion, pais, operacion);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(MotivosDevolucionOperacionLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(MotivosDevolucionOperacionLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public MotivosDevolucionOperacionLocal findByPrimaryKey(Long  oid) {
		MotivosDevolucionOperacionLocal local = (MotivosDevolucionOperacionLocal)em.find(MotivosDevolucionOperacionLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
	public Collection findAll() {
		Query query=em.createNamedQuery("MotivosDevolucionOperacionLocal.FindAll");
		
		return (query.getResultList());
	}

}
