package es.indra.sicc.entidades.dto;

import es.indra.mare.common.exception.MareException;
import es.indra.sicc.entidades.dto.DetalleMatrizDescuentoLocal;
import es.indra.sicc.util.SecuenciadorOID;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;


public class DetalleMatrizDescuentoLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-dto");
	private EntityManager em = emf.createEntityManager();

	public DetalleMatrizDescuentoLocal create(Long padt_oid_para, Long mdes_oid_tipo_desc, Long ind_visu, Long ind_obli, Long ind_modi) throws MareException {
		Long oid = SecuenciadorOID.obtenerSiguienteValor("DTO_PTDT_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		DetalleMatrizDescuentoLocal local = new DetalleMatrizDescuentoLocal(oid, padt_oid_para, mdes_oid_tipo_desc, ind_visu, ind_obli, ind_modi);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(DetalleMatrizDescuentoLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(DetalleMatrizDescuentoLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public DetalleMatrizDescuentoLocal findByPrimaryKey(Long  oid) {
		DetalleMatrizDescuentoLocal local = (DetalleMatrizDescuentoLocal)em.find(DetalleMatrizDescuentoLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
	public Collection findByOidMatriz(Long oid) {
		Query query=em.createNamedQuery("DetalleMatrizDescuentoLocal.FindByOidMatriz");
		
		query.setParameter(1, oid);

		return query.getResultList();
	}

	public DetalleMatrizDescuentoLocal findByClaveUnica(Long oidParametro,Long oidCabeceraMatriz) {
		Query query=em.createNamedQuery("DetalleMatrizDescuentoLocal.FindByClaveUnica");
		
		query.setParameter(1, oidParametro);

		query.setParameter(2, oidCabeceraMatriz);

		return (DetalleMatrizDescuentoLocal)(query.getSingleResult());
	}

}
