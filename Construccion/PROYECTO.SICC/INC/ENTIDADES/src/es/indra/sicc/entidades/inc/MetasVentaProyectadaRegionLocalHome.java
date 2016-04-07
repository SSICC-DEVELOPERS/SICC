package es.indra.sicc.entidades.inc;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.inc.MetasVentaProyectadaRegionLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

import java.math.BigDecimal;

public class MetasVentaProyectadaRegionLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-inc");
	private EntityManager em = emf.createEntityManager();

	public MetasVentaProyectadaRegionLocal create(Integer valAnioCome, Integer numActiInic, Integer numActiFina, Integer impIngr, Integer impRein, Integer impEgre, Integer numOrde, Integer numPedi, Integer numUnidVend, Integer numClie, BigDecimal impVentNetaEsta, Long zorgOidRegi, Long clieOidClie, Long copaOidParaGral, Long perdOidPeri) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("INC_MVPR_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		MetasVentaProyectadaRegionLocal local = new MetasVentaProyectadaRegionLocal(oid, valAnioCome, numActiInic, numActiFina, impIngr, impRein, impEgre, numOrde, numPedi, numUnidVend, numClie, impVentNetaEsta, zorgOidRegi, clieOidClie, copaOidParaGral,  perdOidPeri);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(MetasVentaProyectadaRegionLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(MetasVentaProyectadaRegionLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public MetasVentaProyectadaRegionLocal findByPrimaryKey(Long  oid) {
		MetasVentaProyectadaRegionLocal local = (MetasVentaProyectadaRegionLocal)em.find(MetasVentaProyectadaRegionLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
    public Collection findAll() {
                    Query query = em.createNamedQuery("MetasVentaProyectadaRegionLocal.FindAll");
                    return query.getResultList();
            }

	public Collection findByConcurso(Long oidConcurso) {
		Query query=em.createNamedQuery("MetasVentaProyectadaRegionLocal.FindByConcurso");
		
		query.setParameter(1, oidConcurso);

	    return query.getResultList();
	}

	public MetasVentaProyectadaRegionLocal findByUk(Long periodoCalculado, Long cliente, Long concurso, Long region) {
		Query query=em.createNamedQuery("MetasVentaProyectadaRegionLocal.FindByUk");
		
		query.setParameter(1, periodoCalculado);

		query.setParameter(2, cliente);

		query.setParameter(3, concurso);

		query.setParameter(4, region);

		return (MetasVentaProyectadaRegionLocal)(query.getSingleResult());
	}

}
