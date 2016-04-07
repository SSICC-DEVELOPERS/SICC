package es.indra.sicc.entidades.com;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.com.ComisionesCalculadasLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class ComisionesCalculadasLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-com");
	private EntityManager em = emf.createEntityManager();

	public ComisionesCalculadasLocal create(java.sql.Date fecCalc, Long perdOidPeri, Long clieOidClie, Long escoOidEstaComiClie, Long forpOidFormaPago, Long tplaOidTipoPlan, Long comiOidComi) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("COM_CCAL_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		ComisionesCalculadasLocal local = new ComisionesCalculadasLocal(oid, fecCalc, perdOidPeri, clieOidClie, escoOidEstaComiClie, forpOidFormaPago, tplaOidTipoPlan, comiOidComi);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(ComisionesCalculadasLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(ComisionesCalculadasLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public ComisionesCalculadasLocal findByPrimaryKey(Long  oid) {
		ComisionesCalculadasLocal local = (ComisionesCalculadasLocal)em.find(ComisionesCalculadasLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
        public Collection findAll() {
                Query query=em.createNamedQuery("ComisionesCalculadasLocal.FindAll");          
                return query.getResultList();
        }

	public Collection findByComision(Long b) {
		Query query=em.createNamedQuery("ComisionesCalculadasLocal.FindByComision");
		
		query.setParameter(1, b);

                return query.getResultList();
	}

	public Collection findByComisionCalculada(Long oidComision, Long estComCliCalculada) {
		Query query=em.createNamedQuery("ComisionesCalculadasLocal.FindByComisionCalculada");
		
		query.setParameter(1, oidComision);

		query.setParameter(2, estComCliCalculada);

                return query.getResultList();
	}

}
