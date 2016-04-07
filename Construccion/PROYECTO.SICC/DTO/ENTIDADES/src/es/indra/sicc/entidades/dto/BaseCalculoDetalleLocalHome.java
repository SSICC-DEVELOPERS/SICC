package es.indra.sicc.entidades.dto;

import es.indra.mare.common.exception.MareException;
import es.indra.sicc.entidades.dto.BaseCalculoDetalleLocal;
import es.indra.sicc.util.SecuenciadorOID;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;


public class BaseCalculoDetalleLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-dto");
	private EntityManager em = emf.createEntityManager();

	public BaseCalculoDetalleLocal create(Long cicloVida, Long oidCabecera, Long oidSuperGenerico, Long oidProducto, 
                                                Long oidGenerico, Long oidMarcaProducto, Long oidUnidadNegocio, Long oidNegocio, 
                                                Long oidTipoOferta) throws MareException {
		Long oid = SecuenciadorOID.obtenerSiguienteValor("DTO_BCDE_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		BaseCalculoDetalleLocal local = new BaseCalculoDetalleLocal(oid, cicloVida, oidCabecera, oidSuperGenerico, oidProducto,
                                                                            oidGenerico, oidMarcaProducto, oidUnidadNegocio, oidNegocio, oidTipoOferta);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(BaseCalculoDetalleLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(BaseCalculoDetalleLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public BaseCalculoDetalleLocal findByPrimaryKey(Long  oid) {
		BaseCalculoDetalleLocal local = (BaseCalculoDetalleLocal)em.find(BaseCalculoDetalleLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
}
