package es.indra.sicc.entidades.com;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;
import java.sql.Date;
import java.math.BigDecimal;

import es.indra.sicc.entidades.com.CongeladosLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class CongeladosLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-com");
	private EntityManager em = emf.createEntityManager();

	public CongeladosLocal create(Long codCong, Date fecDesd, Date fecHast, BigDecimal impCong, Boolean indDescAuto, Long clieOidClie) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("COM_CONG_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		CongeladosLocal local = new CongeladosLocal(oid, codCong, fecDesd, fecHast, impCong, indDescAuto, clieOidClie);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(CongeladosLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(CongeladosLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public CongeladosLocal findByPrimaryKey(Long  oid) {
		CongeladosLocal local = (CongeladosLocal)em.find(CongeladosLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}
        
        public Collection findAll() {
                Query query=em.createNamedQuery("CongeladosLocal.FindAll");          
                return query.getResultList();
        }

}
