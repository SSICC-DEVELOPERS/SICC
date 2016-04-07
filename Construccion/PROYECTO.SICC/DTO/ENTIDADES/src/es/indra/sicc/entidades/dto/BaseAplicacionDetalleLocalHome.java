package es.indra.sicc.entidades.dto;

import es.indra.mare.common.exception.MareException;
import es.indra.sicc.entidades.dto.BaseAplicacionDetalleLocal;
import es.indra.sicc.util.SecuenciadorOID;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;


public class BaseAplicacionDetalleLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-dto");
	private EntityManager em = emf.createEntityManager();

	public BaseAplicacionDetalleLocal create(Long oidCicloVida, Long oidCabecera, Long oidSuperGenerico, 
                                                    Long oidProducto, Long oidGenerico, Long oidMarcaProducto, Long oidUnidadNegocio, 
                                                    Long oidNegocio, Long oidTipoOferta) throws MareException {
		Long oid = SecuenciadorOID.obtenerSiguienteValor("DTO_BADE_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		BaseAplicacionDetalleLocal local = new BaseAplicacionDetalleLocal(oid, oidCicloVida, oidCabecera, oidSuperGenerico,
                                                                                    oidProducto, oidGenerico, oidMarcaProducto, oidUnidadNegocio, 
                                                                                    oidNegocio, oidTipoOferta);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(BaseAplicacionDetalleLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(BaseAplicacionDetalleLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public BaseAplicacionDetalleLocal findByPrimaryKey(Long  oid) {
		BaseAplicacionDetalleLocal local = (BaseAplicacionDetalleLocal)em.find(BaseAplicacionDetalleLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
}
