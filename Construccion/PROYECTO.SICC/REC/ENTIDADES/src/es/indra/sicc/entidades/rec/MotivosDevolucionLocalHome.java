package es.indra.sicc.entidades.rec;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.rec.MotivosDevolucionLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class MotivosDevolucionLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-rec");
	private EntityManager em = emf.createEntityManager();

	public MotivosDevolucionLocal create(String codMotivoDevolucion, Long pais)throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("REC_MODV_SEQ");
                final EntityTransaction et = em.getTransaction();
		et.begin();
                MotivosDevolucionLocal local = new MotivosDevolucionLocal(oid, codMotivoDevolucion, pais);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(MotivosDevolucionLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(MotivosDevolucionLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public MotivosDevolucionLocal findByPrimaryKey(Long  oid) {
		MotivosDevolucionLocal local = (MotivosDevolucionLocal)em.find(MotivosDevolucionLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
	public Collection findAll() {
		Query query=em.createNamedQuery("MotivosDevolucionLocal.FindAll");
		
		return (query.getResultList());
	}

}
