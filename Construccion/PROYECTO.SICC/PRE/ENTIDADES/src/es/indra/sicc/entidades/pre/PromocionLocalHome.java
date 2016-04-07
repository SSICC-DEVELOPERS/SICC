package es.indra.sicc.entidades.pre;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.pre.PromocionLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

import java.math.BigDecimal;

public class PromocionLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-pre");
	private EntityManager em = emf.createEntityManager();

	public PromocionLocal create(Long ofer_oid_ofer, Integer num_cond, BigDecimal val_fact_cuad, Long indCuadrePromocion) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("PRE_POMO_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		PromocionLocal local = new PromocionLocal(oid, ofer_oid_ofer, num_cond, val_fact_cuad, indCuadrePromocion);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(PromocionLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(PromocionLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public PromocionLocal findByPrimaryKey(Long  oid) {
		PromocionLocal local = (PromocionLocal)em.find(PromocionLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
	public Collection findByOidOferta(Long oidOferta) {
		Query query=em.createNamedQuery("PromocionLocal.FindByOidOferta");
		
		query.setParameter(1, oidOferta);

		return query.getResultList();
	}

}
