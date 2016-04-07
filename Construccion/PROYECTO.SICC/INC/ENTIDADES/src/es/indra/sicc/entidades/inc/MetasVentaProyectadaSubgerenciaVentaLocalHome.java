package es.indra.sicc.entidades.inc;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.inc.MetasVentaProyectadaSubgerenciaVentaLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

import java.math.BigDecimal;

public class MetasVentaProyectadaSubgerenciaVentaLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-inc");
	private EntityManager em = emf.createEntityManager();

	public MetasVentaProyectadaSubgerenciaVentaLocal create(Integer valAnioCome, Integer numActiInic, Integer numActiFina, Integer impIngr, Integer impRein, Integer impEgre, Integer numOrde, Integer numPedi, Integer numUnidVend, Integer numClie, BigDecimal impVentNetaEsta, Long clieOidClie, Long zsgvOidSubgVent, Long copaOidParaGral, Long perdOidPeri) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("INC_MVPS_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		MetasVentaProyectadaSubgerenciaVentaLocal local = new MetasVentaProyectadaSubgerenciaVentaLocal(oid, valAnioCome, numActiInic, numActiFina, impIngr, impRein, impEgre, numOrde, numPedi, numUnidVend, numClie, impVentNetaEsta, clieOidClie, zsgvOidSubgVent, copaOidParaGral, perdOidPeri);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(MetasVentaProyectadaSubgerenciaVentaLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(MetasVentaProyectadaSubgerenciaVentaLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public MetasVentaProyectadaSubgerenciaVentaLocal findByPrimaryKey(Long  oid) {
		MetasVentaProyectadaSubgerenciaVentaLocal local = (MetasVentaProyectadaSubgerenciaVentaLocal)em.find(MetasVentaProyectadaSubgerenciaVentaLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
    public Collection findAll() {
                    Query query = em.createNamedQuery("MetasVentaProyectadaSubgerenciaVentaLocal.FindAll");
                    return query.getResultList();
            }

	public Collection findByConcurso(Long oidConcurso) {
		Query query=em.createNamedQuery("MetasVentaProyectadaSubgerenciaVentaLocal.FindByConcurso");
		
		query.setParameter(1, oidConcurso);

	    return query.getResultList();
	}

	public MetasVentaProyectadaSubgerenciaVentaLocal findByUk(Long periodoCalculado, Long cliente, Long concurso, Long subgerencia) {
		Query query=em.createNamedQuery("MetasVentaProyectadaSubgerenciaVentaLocal.FindByUk");
		
		query.setParameter(1, periodoCalculado);

		query.setParameter(2, cliente);

		query.setParameter(3, concurso);

		query.setParameter(4, subgerencia);

		return (MetasVentaProyectadaSubgerenciaVentaLocal)(query.getSingleResult());
	}

}
