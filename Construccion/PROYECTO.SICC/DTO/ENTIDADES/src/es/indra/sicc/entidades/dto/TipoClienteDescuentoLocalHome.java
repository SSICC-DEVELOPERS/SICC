package es.indra.sicc.entidades.dto;

import es.indra.mare.common.exception.MareException;
import es.indra.sicc.entidades.dto.TipoClienteDescuentoLocal;
import es.indra.sicc.util.SecuenciadorOID;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;


public class TipoClienteDescuentoLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-dto");
	private EntityManager em = emf.createEntityManager();

	public TipoClienteDescuentoLocal create(Long ticl_oid_tipo_clie, Long dcto_oid_desc) throws MareException  {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("DTO_TCDE_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		TipoClienteDescuentoLocal local = new TipoClienteDescuentoLocal(oid, ticl_oid_tipo_clie, dcto_oid_desc);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(TipoClienteDescuentoLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(TipoClienteDescuentoLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public TipoClienteDescuentoLocal findByPrimaryKey(Long  oid) {
		TipoClienteDescuentoLocal local = (TipoClienteDescuentoLocal)em.find(TipoClienteDescuentoLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
}
