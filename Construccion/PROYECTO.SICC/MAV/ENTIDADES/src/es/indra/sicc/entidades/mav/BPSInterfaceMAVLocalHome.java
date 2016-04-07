package es.indra.sicc.entidades.mav;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.mav.BPSInterfaceMAVLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class BPSInterfaceMAVLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-mav");
	private EntityManager em = emf.createEntityManager();

	public BPSInterfaceMAVLocal create(Double precioStandar, Long oidTipoOferta, Long oidProducto, Long oidTipoCliente, Long oidPeriodo, Long oidCicloVida) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("MAV_BPSI_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		BPSInterfaceMAVLocal local = new BPSInterfaceMAVLocal(oid, precioStandar, oidTipoOferta, oidProducto, oidTipoCliente, oidPeriodo, oidCicloVida);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(BPSInterfaceMAVLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(BPSInterfaceMAVLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public BPSInterfaceMAVLocal findByPrimaryKey(Long  oid) {
		BPSInterfaceMAVLocal local = (BPSInterfaceMAVLocal)em.find(BPSInterfaceMAVLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
	public BPSInterfaceMAVLocal findByUK(Long periodo, Long producto, Long cicloVida, Long tipoCliente, Long tipoOferta) {
		Query query=em.createNamedQuery("BPSInterfaceMAVLocal.FindByUK");
		
		query.setParameter(1, periodo);

		query.setParameter(2, producto);

		query.setParameter(3, cicloVida);

		query.setParameter(4, tipoCliente);

		query.setParameter(5, tipoOferta);

		return (BPSInterfaceMAVLocal)(query.getSingleResult());
	}

}
