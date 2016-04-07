package es.indra.sicc.entidades.rec;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.rec.TiposOperacionLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class TiposOperacionLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-rec");
	private EntityManager em = emf.createEntityManager();

	public TiposOperacionLocal create(String tipoOperacion, Boolean campanaReferenciaUnica, Long operacion, Long bloqueoPorValidacion) throws MareException{
                Long oid = SecuenciadorOID.obtenerSiguienteValor("REC_TIOP_SEQ");
                final EntityTransaction et = em.getTransaction();
		et.begin();
                TiposOperacionLocal local = new TiposOperacionLocal(oid, tipoOperacion, campanaReferenciaUnica, operacion, bloqueoPorValidacion);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(TiposOperacionLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(TiposOperacionLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public TiposOperacionLocal findByPrimaryKey(Long  oid) {
		TiposOperacionLocal local = (TiposOperacionLocal)em.find(TiposOperacionLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
	public Collection findAll() {
		Query query=em.createNamedQuery("TiposOperacionLocal.FindAll");
		
		return (query.getResultList());
	}

	public Collection findByOperacion(Long param1) {
		Query query=em.createNamedQuery("TiposOperacionLocal.FindByOperacion");
		
		query.setParameter(1, param1);

		return query.getResultList();
	}

}
