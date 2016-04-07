package es.indra.sicc.entidades.fac;

import es.indra.mare.common.exception.MareException;
import es.indra.sicc.entidades.fac.RangosNumeracionOficialLocal;
import es.indra.sicc.util.SecuenciadorOID;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;


public class RangosNumeracionOficialLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-fac");
	private EntityManager em = emf.createEntityManager();

	public RangosNumeracionOficialLocal create(Long pais, Long empresa, Long subacceso, Long tipoDocumento, Long ordenUtilizacion, String serieDocumento, Long inicioRangoNumeracion, Long finRangoNumeracion) throws MareException {
		final EntityTransaction et = em.getTransaction();
		et.begin();
                Long oid = SecuenciadorOID.obtenerSiguienteValor("FAC_RNOF_SEQ");
		RangosNumeracionOficialLocal local = new RangosNumeracionOficialLocal(oid, pais, empresa, subacceso, tipoDocumento, ordenUtilizacion, serieDocumento, inicioRangoNumeracion, finRangoNumeracion);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(RangosNumeracionOficialLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(RangosNumeracionOficialLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public RangosNumeracionOficialLocal findByPrimaryKey(Long  oid) {
		RangosNumeracionOficialLocal local = (RangosNumeracionOficialLocal)em.find(RangosNumeracionOficialLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
	public RangosNumeracionOficialLocal findByUK(Long param1,Long param2,Long param3,Long param4,Long param5) {
		Query query=em.createNamedQuery("RangosNumeracionOficialLocal.FindByUK");
		query.setParameter(1, param1);
		query.setParameter(2, param2);
		query.setParameter(3, param3);
		query.setParameter(4, param4);
		query.setParameter(5, param5);
		return (RangosNumeracionOficialLocal)(query.getSingleResult());
	}

}
