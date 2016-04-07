package es.indra.sicc.entidades.pre;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.pre.DetalleOfertaPrecioLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

import java.math.BigDecimal;

public class DetalleOfertaPrecioLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-pre");
	private EntityManager em = emf.createEntityManager();

	public DetalleOfertaPrecioLocal create(Long numOrdeRang, Long numUnidDesd, Long numUnidHast, BigDecimal valPrecCata, BigDecimal valPrecPosi, Long ofdeOidDetaOfer) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("PRE_DEOP_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		DetalleOfertaPrecioLocal local = new DetalleOfertaPrecioLocal(oid, numOrdeRang, numUnidDesd, numUnidHast, valPrecCata, valPrecPosi, ofdeOidDetaOfer);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(DetalleOfertaPrecioLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(DetalleOfertaPrecioLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public DetalleOfertaPrecioLocal findByPrimaryKey(Long  oid) {
		DetalleOfertaPrecioLocal local = (DetalleOfertaPrecioLocal)em.find(DetalleOfertaPrecioLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
	public Collection findAll() {
		Query query=em.createNamedQuery("DetalleOfertaPrecioLocal.FindAll");
		
		return query.getResultList();
	}

	public Collection findByOidDetalle(Long oidDetaOfer) {
		Query query=em.createNamedQuery("DetalleOfertaPrecioLocal.FindByOidDetalle");
		
		query.setParameter(1, oidDetaOfer);

		return query.getResultList();
	}

}
