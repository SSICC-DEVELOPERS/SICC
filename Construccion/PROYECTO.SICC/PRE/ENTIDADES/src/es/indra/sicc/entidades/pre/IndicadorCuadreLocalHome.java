package es.indra.sicc.entidades.pre;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.pre.IndicadorCuadreLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class IndicadorCuadreLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-pre");
	private EntityManager em = emf.createEntityManager();

	public IndicadorCuadreLocal create(Integer cod_indi_cuad, String val_fact_cuad) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("PRE_INDC_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		IndicadorCuadreLocal local = new IndicadorCuadreLocal(oid, cod_indi_cuad, val_fact_cuad);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(IndicadorCuadreLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(IndicadorCuadreLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public IndicadorCuadreLocal findByPrimaryKey(Long  oid) {
		IndicadorCuadreLocal local = (IndicadorCuadreLocal)em.find(IndicadorCuadreLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
}
