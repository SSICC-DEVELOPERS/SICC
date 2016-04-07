package es.indra.sicc.entidades.inc;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.inc.EstatusVentaLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class EstatusVentaLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-inc");
	private EntityManager em = emf.createEntityManager();

	public EstatusVentaLocal create(Long consurso, Long estatusVenta, Long periodoDesde, Long periodoHasta) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("INC_ESTV_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		EstatusVentaLocal local = new EstatusVentaLocal(oid, consurso, estatusVenta, periodoDesde, periodoHasta);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(EstatusVentaLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(EstatusVentaLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public EstatusVentaLocal findByPrimaryKey(Long  oid) {
		EstatusVentaLocal local = (EstatusVentaLocal)em.find(EstatusVentaLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
        public Collection findAll() {
                    Query query = em.createNamedQuery("EstatusVentaLocal.FindAll");
                    return query.getResultList();
            }

	public Collection findByConcurso(Long concurso) {
		Query query=em.createNamedQuery("EstatusVentaLocal.FindByConcurso");
		
		query.setParameter(1, concurso);

	    return query.getResultList();
	}

	public EstatusVentaLocal findByUk(Long concurso, Long estatusVenta) {
		Query query=em.createNamedQuery("EstatusVentaLocal.FindByUk");
		
		query.setParameter(1, concurso);

		query.setParameter(2, estatusVenta);

		return (EstatusVentaLocal)(query.getSingleResult());
	}

}
