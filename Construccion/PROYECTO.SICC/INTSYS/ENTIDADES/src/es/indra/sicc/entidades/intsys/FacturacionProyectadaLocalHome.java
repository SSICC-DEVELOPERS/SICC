package es.indra.sicc.entidades.intsys;

import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.intsys.FacturacionProyectadaLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class FacturacionProyectadaLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-intsys");
	private EntityManager em = emf.createEntityManager();

	public FacturacionProyectadaLocal create(Long civiOidCiclVida, Long tofeOidTipoOfer, Long prodOidProd, Long perdOidPeri, Long prfiOidProgFide, Long cndpOidCondProm, Long ocatOidCata, Long variOidVari, Long moneOidMone, Long argvOidArguVent) throws MareException{
		final EntityTransaction et = em.getTransaction();
		et.begin();
                Long oid = SecuenciadorOID.obtenerSiguienteValor("INT_IFPR_SEQ");
                FacturacionProyectadaLocal local = new FacturacionProyectadaLocal(oid, civiOidCiclVida, tofeOidTipoOfer, prodOidProd, perdOidPeri, prfiOidProgFide, cndpOidCondProm, ocatOidCata, variOidVari, moneOidMone, argvOidArguVent);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(FacturacionProyectadaLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(FacturacionProyectadaLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public FacturacionProyectadaLocal findByPrimaryKey(Long  oid) {
		FacturacionProyectadaLocal local = em.find(FacturacionProyectadaLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
	public Collection findAll() {
		Query query=em.createNamedQuery("FacturacionProyectadaLocal.FindAll");
		return query.getResultList();
	}

	public FacturacionProyectadaLocal findByUK(Long prodOidProd,Long perdOidPeri,Long tofeOidTipoOfer,Long civiOidCiclVida) {
		Query query=em.createNamedQuery("FacturacionProyectadaLocal.FindByUK");
		query.setParameter(1, prodOidProd);
		query.setParameter(2, perdOidPeri);
		query.setParameter(3, tofeOidTipoOfer);
		query.setParameter(4, civiOidCiclVida);
		return (FacturacionProyectadaLocal)(query.getSingleResult());
	}

}
