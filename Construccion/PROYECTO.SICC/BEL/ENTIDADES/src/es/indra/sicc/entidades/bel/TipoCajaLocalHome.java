package es.indra.sicc.entidades.bel;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.bel.TipoCajaLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class TipoCajaLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-bel");
	private EntityManager em = emf.createEntityManager();

	public TipoCajaLocal create(String cod_tipo_caja) throws MareException {
		final EntityTransaction et = em.getTransaction();
		et.begin();
                Long oid = SecuenciadorOID.obtenerSiguienteValor("BEL_TICJ_SEQ");
                TipoCajaLocal local = new TipoCajaLocal(oid, cod_tipo_caja);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(TipoCajaLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(TipoCajaLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public TipoCajaLocal findByPrimaryKey(Long  oid) {
		TipoCajaLocal local = (TipoCajaLocal)em.find(TipoCajaLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
	public TipoCajaLocal findByUK(String codigo) {
		Query query=em.createNamedQuery("TipoCajaLocal.FindByUK");
		query.setParameter(1, codigo);
		return (TipoCajaLocal)(query.getSingleResult());
	}

}
