package es.indra.sicc.entidades.mav;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.mav.ParametrizacionMAVLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class ParametrizacionMAVLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-mav");
	private EntityManager em = emf.createEntityManager();
  
	public ParametrizacionMAVLocal create(Long oidPais, Long oidEstrategia, Long numeroRegistrosAviso,
                                    Long limitePrecioAutorizacion, String direccionElectronicaEnvioFaltaStock,
                                    Long oidTipoClienteZona, Long oidTipoClienteRegion, Long oidAlmacenes,
                                    Boolean requerirAutorizacion) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("MAV_PARM_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		ParametrizacionMAVLocal local = new ParametrizacionMAVLocal(oid, oidPais, oidEstrategia, numeroRegistrosAviso,
                                 limitePrecioAutorizacion, direccionElectronicaEnvioFaltaStock,
                                 oidTipoClienteZona, oidTipoClienteRegion, oidAlmacenes,
                                 requerirAutorizacion);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(ParametrizacionMAVLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(ParametrizacionMAVLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public ParametrizacionMAVLocal findByPrimaryKey(Long  oid) {
		ParametrizacionMAVLocal local = (ParametrizacionMAVLocal)em.find(ParametrizacionMAVLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
	public ParametrizacionMAVLocal findByUK(Long oidPais) {
		Query query=em.createNamedQuery("ParametrizacionMAVLocal.FindByUK");
		
		query.setParameter(1, oidPais);

		return (ParametrizacionMAVLocal)(query.getSingleResult());
	}

}
