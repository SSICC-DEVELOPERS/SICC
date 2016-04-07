package es.indra.sicc.entidades.bel;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.bel.AlertasStockLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

import java.math.BigDecimal;

import java.sql.Timestamp;

public class AlertasStockLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-bel");
	private EntityManager em = emf.createEntityManager();

	public AlertasStockLocal create(Timestamp fecAler, Long prodOidProd, Long subacceso, Long pais, BigDecimal indicador) throws MareException {
		final EntityTransaction et = em.getTransaction();
		et.begin();
                Long oid = SecuenciadorOID.obtenerSiguienteValor("BEL_ALST_SEQ");
                AlertasStockLocal local = new AlertasStockLocal(oid, fecAler, prodOidProd, subacceso, pais, indicador);
		em.persist(local);
		et.commit();
		return local;
	}
        
    public AlertasStockLocal create(Timestamp fecAler, Long prodOidProd) throws MareException {
            final EntityTransaction et = em.getTransaction();
            et.begin();
            Long oid = SecuenciadorOID.obtenerSiguienteValor("BEL_ALST_SEQ");
            AlertasStockLocal local = new AlertasStockLocal(oid, fecAler, prodOidProd);
            em.persist(local);
            et.commit();
            return local;
    }        
	
	public void remove(AlertasStockLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(AlertasStockLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public AlertasStockLocal findByPrimaryKey(Long  oid) {
		AlertasStockLocal local = (AlertasStockLocal)em.find(AlertasStockLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
	public Collection findAll() {
		Query query=em.createNamedQuery("AlertasStockLocal.FindAll");
		return query.getResultList();
	}

}
