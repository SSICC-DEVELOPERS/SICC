package es.indra.sicc.entidades.rec;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.rec.TipoMovimientoLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class TipoMovimientoLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-rec");
	private EntityManager em = emf.createEntityManager();

	public TipoMovimientoLocal create(String codTipoMovimiento) throws MareException{
                Long oid = SecuenciadorOID.obtenerSiguienteValor("REC_TIMO_SEQ");
                final EntityTransaction et = em.getTransaction();
		et.begin();
                TipoMovimientoLocal local = new TipoMovimientoLocal(oid,codTipoMovimiento);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(TipoMovimientoLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(TipoMovimientoLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public TipoMovimientoLocal findByPrimaryKey(Long  oid) {
		TipoMovimientoLocal local = (TipoMovimientoLocal)em.find(TipoMovimientoLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
	public Collection findAll() {
		Query query=em.createNamedQuery("TipoMovimientoLocal.FindAll");
		
		return (query.getResultList());
	}

}
