package es.indra.sicc.entidades.cob;

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

import es.indra.sicc.entidades.cob.CompromisoPagoLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class CompromisoPagoLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-cob");
	private EntityManager em = emf.createEntityManager();

	public CompromisoPagoLocal create(Long codigoCompromisoPago, Date fechaPago, BigDecimal importePago, Date fechaSeguimientoPrevisto, Long sucursal, Long orden) throws MareException {
		final EntityTransaction et = em.getTransaction();
                Long oid = SecuenciadorOID.obtenerSiguienteValor("COB_CPGO_SEQ");
		et.begin();
		CompromisoPagoLocal local = new CompromisoPagoLocal(oid, codigoCompromisoPago, fechaPago, importePago, fechaSeguimientoPrevisto, sucursal, orden);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(CompromisoPagoLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(CompromisoPagoLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public CompromisoPagoLocal findByPrimaryKey(Long  oid) {
		CompromisoPagoLocal local = (CompromisoPagoLocal)em.find(CompromisoPagoLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
        public Collection findAll() {
            Query query=em.createNamedQuery("CompromisoPagoLocal.FindAll");          
            return query.getResultList();
        }

}
