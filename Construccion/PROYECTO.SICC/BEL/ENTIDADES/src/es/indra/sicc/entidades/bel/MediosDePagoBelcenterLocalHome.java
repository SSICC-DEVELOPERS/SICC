package es.indra.sicc.entidades.bel;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.bel.MediosDePagoBelcenterLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class MediosDePagoBelcenterLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-bel");
	private EntityManager em = emf.createEntityManager();

	public MediosDePagoBelcenterLocal create(Long mediosDePago, Long subacceso) throws MareException{
		final EntityTransaction et = em.getTransaction();
		et.begin();
                Long oid = SecuenciadorOID.obtenerSiguienteValor("BEL_MPBC_SEQ");
                MediosDePagoBelcenterLocal local = new MediosDePagoBelcenterLocal(oid, mediosDePago, subacceso);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(MediosDePagoBelcenterLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(MediosDePagoBelcenterLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public MediosDePagoBelcenterLocal findByPrimaryKey(Long  oid) {
		MediosDePagoBelcenterLocal local = (MediosDePagoBelcenterLocal)em.find(MediosDePagoBelcenterLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
}
