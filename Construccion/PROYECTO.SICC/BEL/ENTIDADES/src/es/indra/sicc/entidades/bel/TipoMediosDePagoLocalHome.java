package es.indra.sicc.entidades.bel;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.bel.TipoMediosDePagoLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class TipoMediosDePagoLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-bel");
	private EntityManager em = emf.createEntityManager();

	public TipoMediosDePagoLocal create() throws MareException  {
		final EntityTransaction et = em.getTransaction();
		et.begin();
                Long oid = SecuenciadorOID.obtenerSiguienteValor("BEL_TMEP_SEQ");
                TipoMediosDePagoLocal local = new TipoMediosDePagoLocal(oid);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(TipoMediosDePagoLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(TipoMediosDePagoLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public TipoMediosDePagoLocal findByPrimaryKey(Long  oid) {
		TipoMediosDePagoLocal local = (TipoMediosDePagoLocal)em.find(TipoMediosDePagoLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
}
