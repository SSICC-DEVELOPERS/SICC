package es.indra.sicc.entidades.pre;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.pre.IndicadorCuadrePorTipoEstrategiaLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class IndicadorCuadrePorTipoEstrategiaLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-pre");
	private EntityManager em = emf.createEntityManager();
  
	public IndicadorCuadrePorTipoEstrategiaLocal create(Long indc_oid_indi_cuad, Long ties_oid_tipo_estr) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("PRE_CUES_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		IndicadorCuadrePorTipoEstrategiaLocal local = new IndicadorCuadrePorTipoEstrategiaLocal(oid, indc_oid_indi_cuad, ties_oid_tipo_estr);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(IndicadorCuadrePorTipoEstrategiaLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(IndicadorCuadrePorTipoEstrategiaLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public IndicadorCuadrePorTipoEstrategiaLocal findByPrimaryKey(Long  oid) {
		IndicadorCuadrePorTipoEstrategiaLocal local = (IndicadorCuadrePorTipoEstrategiaLocal)em.find(IndicadorCuadrePorTipoEstrategiaLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
}
