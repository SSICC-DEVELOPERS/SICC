package es.indra.sicc.entidades.com;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.com.ComisionesLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class ComisionesLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-com");
	private EntityManager em = emf.createEntityManager();

	public ComisionesLocal create(String codComi, Integer numVers, Long plcpOidPlanComiPais, Long plcmOidPlanComiMarc, Long perdOidPeri, Long tplaOidTipoPlan, Long perdOidPeriHast, Long estado, Long plcoOidPlanComi, String indVentCob) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("COM_COMI_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		ComisionesLocal local = new ComisionesLocal(oid, codComi, numVers, plcpOidPlanComiPais, plcmOidPlanComiMarc, perdOidPeri, tplaOidTipoPlan, perdOidPeriHast, estado, plcoOidPlanComi, indVentCob);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(ComisionesLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(ComisionesLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public ComisionesLocal findByPrimaryKey(Long  oid) {
		ComisionesLocal local = (ComisionesLocal)em.find(ComisionesLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
    public Collection findAll() {
            Query query=em.createNamedQuery("ComisionesLocal.FindAll");          
            return query.getResultList();
    }
}
