package es.indra.sicc.entidades.bel;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.bel.AgrupacionStockCabeceraLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class AgrupacionStockCabeceraLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-bel");
	private EntityManager em = emf.createEntityManager();

	public AgrupacionStockCabeceraLocal create(Long pais, String codigoASC, Boolean indicadorDefecto) throws MareException {
                final EntityTransaction et = em.getTransaction();
		et.begin();
                Long oid = SecuenciadorOID.obtenerSiguienteValor("BEL_AGSC_SEQ");
                AgrupacionStockCabeceraLocal local = new AgrupacionStockCabeceraLocal(oid, pais, codigoASC, indicadorDefecto );
		em.persist(local);
		et.commit();
		return local;
	}
    
	
	public void remove(AgrupacionStockCabeceraLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(AgrupacionStockCabeceraLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public AgrupacionStockCabeceraLocal findByPrimaryKey(Long  oid) {
		AgrupacionStockCabeceraLocal local = (AgrupacionStockCabeceraLocal)em.find(AgrupacionStockCabeceraLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
	public AgrupacionStockCabeceraLocal findByClaveUnica(Long pais, String codigoASC) {
		Query query=em.createNamedQuery("AgrupacionStockCabeceraLocal.FindByClaveUnica");
		query.setParameter(1, pais);
		query.setParameter(2, codigoASC);
		return (AgrupacionStockCabeceraLocal)(query.getSingleResult());
	}

}
