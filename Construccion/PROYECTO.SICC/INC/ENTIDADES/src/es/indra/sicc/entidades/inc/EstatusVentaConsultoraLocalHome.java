package es.indra.sicc.entidades.inc;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.inc.EstatusVentaConsultoraLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class EstatusVentaConsultoraLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-inc");
	private EntityManager em = emf.createEntityManager();

	public EstatusVentaConsultoraLocal create(Long copaOidParaGral, Long estaOidEstaClie, Long perdOidPeriDesd, Long perdOidPeriHast) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("INC_ESVC_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		EstatusVentaConsultoraLocal local = new EstatusVentaConsultoraLocal(oid, copaOidParaGral, estaOidEstaClie, perdOidPeriDesd, perdOidPeriHast);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(EstatusVentaConsultoraLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(EstatusVentaConsultoraLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public EstatusVentaConsultoraLocal findByPrimaryKey(Long  oid) {
		EstatusVentaConsultoraLocal local = (EstatusVentaConsultoraLocal)em.find(EstatusVentaConsultoraLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
    public Collection findAll() {
                    Query query = em.createNamedQuery("EstatusVentaConsultoraLocal.FindAll");
                    return query.getResultList();
            }

	public Collection findByConcurso(Long concurso) {
		Query query=em.createNamedQuery("EstatusVentaConsultoraLocal.FindByConcurso");
		
		query.setParameter(1, concurso);

	    return query.getResultList();
	}

	public EstatusVentaConsultoraLocal findByUk(Long concurso, Long estatusVenta) {
		Query query=em.createNamedQuery("EstatusVentaConsultoraLocal.FindByUk");
		
		query.setParameter(1, concurso);

		query.setParameter(2, estatusVenta);

		return (EstatusVentaConsultoraLocal)(query.getSingleResult());
	}

}
