package es.indra.sicc.entidades.pre;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.pre.RangosPromocionLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class RangosPromocionLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-pre");
	private EntityManager em = emf.createEntityManager();

	public RangosPromocionLocal create(Long ocat_oid_cata, Long pomo_oid_prom, String cod_tipo_rang, Integer num_rang_inte, String val_desd) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("PRE_RAPR_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		RangosPromocionLocal local = new RangosPromocionLocal(oid, ocat_oid_cata, pomo_oid_prom, cod_tipo_rang, num_rang_inte, val_desd);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(RangosPromocionLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(RangosPromocionLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public RangosPromocionLocal findByPrimaryKey(Long  oid) {
		RangosPromocionLocal local = (RangosPromocionLocal)em.find(RangosPromocionLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
	public Collection findByOidPromo(Long oidProm) {
		Query query=em.createNamedQuery("RangosPromocionLocal.FindByOidPromo");
		
		query.setParameter(1, oidProm);

		return query.getResultList();
	}

}
