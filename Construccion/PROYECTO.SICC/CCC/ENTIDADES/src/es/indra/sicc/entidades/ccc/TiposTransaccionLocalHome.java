package es.indra.sicc.entidades.ccc;

import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;

import es.indra.sicc.entidades.ccc.TiposTransaccionLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class TiposTransaccionLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-ccc");
	private EntityManager em = emf.createEntityManager();

	public TiposTransaccionLocal create(Long pais, String codigo, Character tipoTransaccionCheque) 
                                                                                throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("CCC_TTRA_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		TiposTransaccionLocal local = new TiposTransaccionLocal(oid, pais, codigo, tipoTransaccionCheque);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(TiposTransaccionLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(TiposTransaccionLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public TiposTransaccionLocal findByPrimaryKey(Long  oid) {
		TiposTransaccionLocal local = (TiposTransaccionLocal)em.find(TiposTransaccionLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
}
