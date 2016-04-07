package es.indra.sicc.entidades.pre;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.pre.CondicionPromocionLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class CondicionPromocionLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-pre");
	private EntityManager em = emf.createEntityManager();
  
	public CondicionPromocionLocal create(String cod_cond_prom) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("PRE_CNDP_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		CondicionPromocionLocal local = new CondicionPromocionLocal(oid, cod_cond_prom);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(CondicionPromocionLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(CondicionPromocionLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public CondicionPromocionLocal findByPrimaryKey(Long  oid) {
		CondicionPromocionLocal local = (CondicionPromocionLocal)em.find(CondicionPromocionLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
	public CondicionPromocionLocal findByUK(String codigoCondicionPromocion) {
		Query query=em.createNamedQuery("CondicionPromocionLocal.FindByUK");
		
		query.setParameter(1, codigoCondicionPromocion);

		return (CondicionPromocionLocal)(query.getSingleResult());
	}

}
