package es.indra.sicc.entidades.pre;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.pre.ArgumentoVentaLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class ArgumentoVentaLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-pre");
	private EntityManager em = emf.createEntityManager();

	public ArgumentoVentaLocal create(Integer cod_argu_vent) throws MareException{
                Long oid = SecuenciadorOID.obtenerSiguienteValor("PRE_ARGV_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		ArgumentoVentaLocal local = new ArgumentoVentaLocal(oid, cod_argu_vent);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(ArgumentoVentaLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(ArgumentoVentaLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public ArgumentoVentaLocal findByPrimaryKey(Long  oid) {
		ArgumentoVentaLocal local = (ArgumentoVentaLocal)em.find(ArgumentoVentaLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
	public Collection findByTipoEstrategia(Long oidTipoEstr) {
		Query query=em.createNamedQuery("ArgumentoVentaLocal.FindByTipoEstrategia");
		
		query.setParameter(1, oidTipoEstr);

		return query.getResultList();
	}

	public ArgumentoVentaLocal findByUK(Integer codigoArgumento) {
		Query query=em.createNamedQuery("ArgumentoVentaLocal.FindByUK");
		
		query.setParameter(1, codigoArgumento);

		return (ArgumentoVentaLocal)(query.getSingleResult());
	}

}
