package es.indra.sicc.entidades.rec;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.rec.PeriodoReclamoLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class PeriodoReclamoLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-rec");
	private EntityManager em = emf.createEntityManager();

	public PeriodoReclamoLocal create(String codPeriodoReclamo) throws MareException{
                Long oid = SecuenciadorOID.obtenerSiguienteValor("REC_PERE_SEQ");
                final EntityTransaction et = em.getTransaction();
		et.begin();
                PeriodoReclamoLocal local = new PeriodoReclamoLocal(oid, codPeriodoReclamo);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(PeriodoReclamoLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(PeriodoReclamoLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public PeriodoReclamoLocal findByPrimaryKey(Long  oid) {
		PeriodoReclamoLocal local = (PeriodoReclamoLocal)em.find(PeriodoReclamoLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
	public Collection findAll() {
		Query query=em.createNamedQuery("PeriodoReclamoLocal.FindAll");
		
		return (query.getResultList());
	}

}
