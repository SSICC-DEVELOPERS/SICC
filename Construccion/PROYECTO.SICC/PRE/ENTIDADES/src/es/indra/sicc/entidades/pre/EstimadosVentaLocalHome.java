package es.indra.sicc.entidades.pre;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.pre.EstimadosVentaLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class EstimadosVentaLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-pre");
	private EntityManager em = emf.createEntityManager();

	public EstimadosVentaLocal create(Long prod_oid_prod, Long perd_oid_peri, Long fopa_oid_form_pago, Long argv_oid_argu_vent, Long cndp_oid_cond_prom, Long coes_oid_estr, Long mone_oid_mone, Long tofe_oid_tipo_ofer, Long civi_oid_cicl_vida, Long ocat_oid_cata) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("PRE_ESVN_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		EstimadosVentaLocal local = new EstimadosVentaLocal(oid, prod_oid_prod, perd_oid_peri, fopa_oid_form_pago, argv_oid_argu_vent, cndp_oid_cond_prom, coes_oid_estr, mone_oid_mone, tofe_oid_tipo_ofer, civi_oid_cicl_vida, ocat_oid_cata);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(EstimadosVentaLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(EstimadosVentaLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public EstimadosVentaLocal findByPrimaryKey(Long  oid) {
		EstimadosVentaLocal local = (EstimadosVentaLocal)em.find(EstimadosVentaLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
	public EstimadosVentaLocal findByUK(Long oidProd,Long oidPeri,Long oidTipoOfer,Long oidCicloVida) {
		Query query=em.createNamedQuery("EstimadosVentaLocal.FindByUK");
		
		query.setParameter(1, oidProd);

		query.setParameter(2, oidPeri);

		query.setParameter(3, oidTipoOfer);

		query.setParameter(4, oidCicloVida);

		return (EstimadosVentaLocal)(query.getSingleResult());
	}

}
