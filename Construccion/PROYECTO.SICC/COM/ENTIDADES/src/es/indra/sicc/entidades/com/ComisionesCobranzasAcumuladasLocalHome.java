package es.indra.sicc.entidades.com;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;
import java.math.BigDecimal;

import es.indra.sicc.entidades.com.ComisionesCobranzasAcumuladasLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class ComisionesCobranzasAcumuladasLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-com");
	private EntityManager em = emf.createEntityManager();

	public ComisionesCobranzasAcumuladasLocal create(BigDecimal cantidadFacturada, Long cliente, Long comision, Long periodo) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("COM_COC2_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		ComisionesCobranzasAcumuladasLocal local = new ComisionesCobranzasAcumuladasLocal(oid, cantidadFacturada, cliente, comision, periodo);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(ComisionesCobranzasAcumuladasLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(ComisionesCobranzasAcumuladasLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public ComisionesCobranzasAcumuladasLocal findByPrimaryKey(Long  oid) {
		ComisionesCobranzasAcumuladasLocal local = (ComisionesCobranzasAcumuladasLocal)em.find(ComisionesCobranzasAcumuladasLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}
        
        public Collection findAll() {
                Query query=em.createNamedQuery("ComisionesCobranzasAcumuladasLocal.FindAll");          
                return query.getResultList();
        }

}
