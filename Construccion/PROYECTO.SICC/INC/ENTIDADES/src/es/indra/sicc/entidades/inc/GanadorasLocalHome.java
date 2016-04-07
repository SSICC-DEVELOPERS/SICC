package es.indra.sicc.entidades.inc;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.inc.GanadorasLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

import java.math.BigDecimal;

public class GanadorasLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-inc");
	private EntityManager em = emf.createEntityManager();

	public GanadorasLocal create(BigDecimal unidades, Boolean listarGanador, Boolean descontar, Boolean despachado, Long oidCliente, Long periodoDespacho, Long nivelPremiacion) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("INC_GANA_SEQ");     
		final EntityTransaction et = em.getTransaction();
		et.begin();
		GanadorasLocal local = new GanadorasLocal(oid, unidades, listarGanador, descontar, despachado, oidCliente, periodoDespacho, nivelPremiacion);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(GanadorasLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(GanadorasLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public GanadorasLocal findByPrimaryKey(Long  oid) {
		GanadorasLocal local = (GanadorasLocal)em.find(GanadorasLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
    public Collection findAll() {
                    Query query = em.createNamedQuery("GanadorasLocal.FindAll");
                    return query.getResultList();
            }

	public Collection findByUK(Long oidCliente, Long oidConcurso, Long numeroPremio) {
		Query query=em.createNamedQuery("GanadorasLocal.FindByUK");
		
		query.setParameter(1, oidCliente);

		query.setParameter(2, oidConcurso);

		query.setParameter(3, numeroPremio);

	    return query.getResultList();
	}

}
