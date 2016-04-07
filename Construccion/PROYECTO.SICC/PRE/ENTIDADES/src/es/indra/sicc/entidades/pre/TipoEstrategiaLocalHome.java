package es.indra.sicc.entidades.pre;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.pre.TipoEstrategiaLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class TipoEstrategiaLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-pre");
	private EntityManager em = emf.createEntityManager();
 
	public TipoEstrategiaLocal create(String cod_tipo_estr, String des_tipo_estr) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("PRE_TIES_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		TipoEstrategiaLocal local = new TipoEstrategiaLocal(oid, cod_tipo_estr, des_tipo_estr);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(TipoEstrategiaLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(TipoEstrategiaLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public TipoEstrategiaLocal findByPrimaryKey(Long  oid) {
		TipoEstrategiaLocal local = (TipoEstrategiaLocal)em.find(TipoEstrategiaLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
	public TipoEstrategiaLocal findByUK(String codigoTipoEstrategia) {
		Query query=em.createNamedQuery("TipoEstrategiaLocal.FindByUK");
		
		query.setParameter(1, codigoTipoEstrategia);

		return (TipoEstrategiaLocal)(query.getSingleResult());
	}

}
