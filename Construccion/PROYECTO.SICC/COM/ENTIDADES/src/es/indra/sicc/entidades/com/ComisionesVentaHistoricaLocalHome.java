package es.indra.sicc.entidades.com;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.com.ComisionesVentaHistoricaLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class ComisionesVentaHistoricaLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-com");
	private EntityManager em = emf.createEntityManager();

	public ComisionesVentaHistoricaLocal create(Long comision, Long periodoFinal, Long periodoInicial) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("COM_COVH_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		ComisionesVentaHistoricaLocal local = new ComisionesVentaHistoricaLocal(oid, comision, periodoFinal, periodoInicial);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(ComisionesVentaHistoricaLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(ComisionesVentaHistoricaLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public ComisionesVentaHistoricaLocal findByPrimaryKey(Long  oid) {
		ComisionesVentaHistoricaLocal local = (ComisionesVentaHistoricaLocal)em.find(ComisionesVentaHistoricaLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
        public Collection findAll() {
                Query query=em.createNamedQuery("ComisionesVentaHistoricaLocal.FindAll");          
                return query.getResultList();
        }

	public ComisionesVentaHistoricaLocal findByUK(Long oidComision) {
		Query query=em.createNamedQuery("ComisionesVentaHistoricaLocal.FindByUK");
		
		query.setParameter(1, oidComision);

		return (ComisionesVentaHistoricaLocal)(query.getSingleResult());
	}

}
