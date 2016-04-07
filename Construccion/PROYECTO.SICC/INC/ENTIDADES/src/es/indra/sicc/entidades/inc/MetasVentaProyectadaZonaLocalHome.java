package es.indra.sicc.entidades.inc;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.inc.MetasVentaProyectadaZonaLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

import java.math.BigDecimal;

public class MetasVentaProyectadaZonaLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-inc");
	private EntityManager em = emf.createEntityManager();

	public MetasVentaProyectadaZonaLocal create(Integer numActiInic, Integer numActiFina, Integer impIngr, Integer impRein, Integer impEgre, Integer numOrde, Integer numPedi, Integer numUnidVend, Integer numClie, BigDecimal impVentNetaEsta, Long zzonOidZona, Long clieOidClie, Long copaOidParaGral, Long perdOidPeri) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("INC_MVPZ_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		MetasVentaProyectadaZonaLocal local = new MetasVentaProyectadaZonaLocal(oid, numActiInic, numActiFina, impIngr, impRein, impEgre, numOrde, numPedi, numUnidVend, numClie, impVentNetaEsta, zzonOidZona, clieOidClie, copaOidParaGral, perdOidPeri);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(MetasVentaProyectadaZonaLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(MetasVentaProyectadaZonaLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public MetasVentaProyectadaZonaLocal findByPrimaryKey(Long  oid) {
		MetasVentaProyectadaZonaLocal local = (MetasVentaProyectadaZonaLocal)em.find(MetasVentaProyectadaZonaLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
    public Collection findAll() {
                    Query query = em.createNamedQuery("MetasVentaProyectadaZonaLocal.FindAll");
                    return query.getResultList();
            }

	public Collection findByConcurso(Long oidConcurso) {
		Query query=em.createNamedQuery("MetasVentaProyectadaZonaLocal.FindByConcurso");
		
		query.setParameter(1, oidConcurso);

	    return query.getResultList();
	}

	public MetasVentaProyectadaZonaLocal findByUk(Long periodoCalculado, Long cliente, Long concurso, Long zona) {
		Query query=em.createNamedQuery("MetasVentaProyectadaZonaLocal.FindByUk");
		
		query.setParameter(1, periodoCalculado);

		query.setParameter(2, cliente);

		query.setParameter(3, concurso);

		query.setParameter(4, zona);

		return (MetasVentaProyectadaZonaLocal)(query.getSingleResult());
	}

}
