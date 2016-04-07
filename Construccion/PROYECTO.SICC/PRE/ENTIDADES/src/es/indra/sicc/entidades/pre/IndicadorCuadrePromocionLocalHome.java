package es.indra.sicc.entidades.pre;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.pre.IndicadorCuadrePromocionLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class IndicadorCuadrePromocionLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-pre");
	private EntityManager em = emf.createEntityManager();

	public IndicadorCuadrePromocionLocal create(Integer cod_indi_cuad_prom, String val_fact_cuad) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("PRE_ICPR_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		IndicadorCuadrePromocionLocal local = new IndicadorCuadrePromocionLocal(oid, cod_indi_cuad_prom, val_fact_cuad);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(IndicadorCuadrePromocionLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(IndicadorCuadrePromocionLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public IndicadorCuadrePromocionLocal findByPrimaryKey(Long  oid) {
		IndicadorCuadrePromocionLocal local = (IndicadorCuadrePromocionLocal)em.find(IndicadorCuadrePromocionLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
}
