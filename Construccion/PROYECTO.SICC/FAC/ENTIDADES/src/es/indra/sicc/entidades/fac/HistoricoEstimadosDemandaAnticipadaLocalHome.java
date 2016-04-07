package es.indra.sicc.entidades.fac;

import es.indra.mare.common.exception.MareException;
import es.indra.sicc.entidades.fac.HistoricoEstimadosDemandaAnticipadaLocal;
import es.indra.sicc.util.SecuenciadorOID;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;


public class HistoricoEstimadosDemandaAnticipadaLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-fac");
	private EntityManager em = emf.createEntityManager();

	public HistoricoEstimadosDemandaAnticipadaLocal create(Long pais, Long periodo, Long producto, Integer unidEstimadasMarketing, BigDecimal pupMarketing, BigDecimal pupReal, BigDecimal pupDemanda, Character estadoDemanda, BigDecimal a1, BigDecimal b1, BigDecimal c1, BigDecimal s) throws MareException{
		final EntityTransaction et = em.getTransaction();
		et.begin();
                Long oid = SecuenciadorOID.obtenerSiguienteValor("FAC_HEDA_SEQ");
		HistoricoEstimadosDemandaAnticipadaLocal local = new HistoricoEstimadosDemandaAnticipadaLocal(oid, pais, periodo, producto, unidEstimadasMarketing, pupMarketing, pupReal, pupDemanda, estadoDemanda, a1, b1, c1, s);
		em.persist(local);
		et.commit();
		return local;
	}
	

	public void remove(HistoricoEstimadosDemandaAnticipadaLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(HistoricoEstimadosDemandaAnticipadaLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public HistoricoEstimadosDemandaAnticipadaLocal findByPrimaryKey(Long  oid) {
		HistoricoEstimadosDemandaAnticipadaLocal local = (HistoricoEstimadosDemandaAnticipadaLocal)em.find(HistoricoEstimadosDemandaAnticipadaLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
}
