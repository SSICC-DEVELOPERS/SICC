package es.indra.sicc.entidades.dto;

import es.indra.mare.common.exception.MareException;
import es.indra.sicc.entidades.dto.ParametroClasificacionLocal;
import es.indra.sicc.util.SecuenciadorOID;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;


public class ParametroClasificacionLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-dto");
	private EntityManager em = emf.createEntityManager();

	public ParametroClasificacionLocal create(Long clas_oid_clas, Long ind_valo_defe, Long ptdt_para_tipo_desc) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("DTO_VPCL_SEQ");
                final EntityTransaction et = em.getTransaction();
		et.begin();
		ParametroClasificacionLocal local = new ParametroClasificacionLocal(oid, clas_oid_clas, ind_valo_defe, ptdt_para_tipo_desc);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(ParametroClasificacionLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(ParametroClasificacionLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public ParametroClasificacionLocal findByPrimaryKey(Long  oid) {
		ParametroClasificacionLocal local = (ParametroClasificacionLocal)em.find(ParametroClasificacionLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
}
