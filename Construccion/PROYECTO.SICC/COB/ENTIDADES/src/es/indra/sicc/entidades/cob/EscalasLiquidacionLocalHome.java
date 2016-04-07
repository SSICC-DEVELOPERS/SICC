package es.indra.sicc.entidades.cob;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.cob.EscalasLiquidacionLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

import java.math.BigDecimal;

public class EscalasLiquidacionLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-cob");
	private EntityManager em = emf.createEntityManager();

	public EscalasLiquidacionLocal create(Integer ordenEscala, BigDecimal comisionPorcentaje, BigDecimal comision, Long metodoLiquidacion) throws MareException {
		final EntityTransaction et = em.getTransaction();
                Long oid = SecuenciadorOID.obtenerSiguienteValor("COB_ESLI_SEQ");
		et.begin();
		EscalasLiquidacionLocal local = new EscalasLiquidacionLocal(oid, ordenEscala, comisionPorcentaje, comision, metodoLiquidacion);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(EscalasLiquidacionLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(EscalasLiquidacionLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public EscalasLiquidacionLocal findByPrimaryKey(Long  oid) {
		EscalasLiquidacionLocal local = (EscalasLiquidacionLocal)em.find(EscalasLiquidacionLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
        public Collection findAll() {
            Query query=em.createNamedQuery("EscalasLiquidacionLocal.FindAll");          
            return query.getResultList();
        }


}
