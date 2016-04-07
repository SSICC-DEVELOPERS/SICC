package es.indra.sicc.entidades.rec;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.rec.TipoIngresoLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class TipoIngresoLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-rec");
	private EntityManager em = emf.createEntityManager();

	public TipoIngresoLocal create(String codTipoIngreso) throws MareException{
                Long oid = SecuenciadorOID.obtenerSiguienteValor("REC_TIIN_SEQ");
                final EntityTransaction et = em.getTransaction();
		et.begin();
                TipoIngresoLocal local = new TipoIngresoLocal(oid, codTipoIngreso);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(TipoIngresoLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(TipoIngresoLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public TipoIngresoLocal findByPrimaryKey(Long  oid) {
		TipoIngresoLocal local = (TipoIngresoLocal)em.find(TipoIngresoLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
	public Collection findAll() {
		Query query=em.createNamedQuery("TipoIngresoLocal.FindAll");
		
		return (query.getResultList());
	}

}
