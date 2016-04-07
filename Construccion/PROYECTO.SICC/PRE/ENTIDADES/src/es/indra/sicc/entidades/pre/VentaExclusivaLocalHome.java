package es.indra.sicc.entidades.pre;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.pre.VentaExclusivaLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class VentaExclusivaLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-pre");
	private EntityManager em = emf.createEntityManager();

	public VentaExclusivaLocal create(Long ofer_oid_ofer, Long oidSubtipoCliente, Long oidEstatusCliente, Long oidClasificacion, Long oidTipoCliente, Long oidTipoClasificacion)  throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("PRE_PVEN_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		VentaExclusivaLocal local = new VentaExclusivaLocal(oid, ofer_oid_ofer, oidSubtipoCliente, oidEstatusCliente, oidClasificacion, oidTipoCliente, oidTipoClasificacion);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(VentaExclusivaLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(VentaExclusivaLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public VentaExclusivaLocal findByPrimaryKey(Long  oid) {
		VentaExclusivaLocal local = (VentaExclusivaLocal)em.find(VentaExclusivaLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
	public Collection findByOidOferta(Long oidOferta) {
		Query query=em.createNamedQuery("VentaExclusivaLocal.FindByOidOferta");
		
		query.setParameter(1, oidOferta);

		return query.getResultList();
	}

}
