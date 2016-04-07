package es.indra.sicc.entidades.dto;

import es.indra.mare.common.exception.MareException;
import es.indra.sicc.entidades.dto.ParametroTipoClasificacionLocal;
import es.indra.sicc.util.SecuenciadorOID;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;


public class ParametroTipoClasificacionLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-dto");
	private EntityManager em = emf.createEntityManager();

	public ParametroTipoClasificacionLocal create(Long ptdt_oid_para_tipo_desc, Long tccl_oid_tipo_clas, Long ind_valor_defecto) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("DTO_VPTL_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		ParametroTipoClasificacionLocal local = new ParametroTipoClasificacionLocal(oid, ptdt_oid_para_tipo_desc, tccl_oid_tipo_clas, ind_valor_defecto);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(ParametroTipoClasificacionLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(ParametroTipoClasificacionLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public ParametroTipoClasificacionLocal findByPrimaryKey(Long  oid) {
		ParametroTipoClasificacionLocal local = (ParametroTipoClasificacionLocal)em.find(ParametroTipoClasificacionLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
}
