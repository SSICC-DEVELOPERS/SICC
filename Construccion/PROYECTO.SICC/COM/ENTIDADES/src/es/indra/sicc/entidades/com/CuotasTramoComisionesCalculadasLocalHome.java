package es.indra.sicc.entidades.com;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.com.CuotasTramoComisionesCalculadasLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class CuotasTramoComisionesCalculadasLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-com");
	private EntityManager em = emf.createEntityManager();

	public CuotasTramoComisionesCalculadasLocal create(Long idCuota, Integer codTerri) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("COM_CTCC_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		CuotasTramoComisionesCalculadasLocal local = new CuotasTramoComisionesCalculadasLocal(oid, idCuota, codTerri);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(CuotasTramoComisionesCalculadasLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(CuotasTramoComisionesCalculadasLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public CuotasTramoComisionesCalculadasLocal findByPrimaryKey(Long  oid) {
		CuotasTramoComisionesCalculadasLocal local = (CuotasTramoComisionesCalculadasLocal)em.find(CuotasTramoComisionesCalculadasLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}
        
        public Collection findAll() {
                Query query=em.createNamedQuery("CuotasTramoComisionesCalculadasLocal.FindAll");          
                return query.getResultList();
        }

}
