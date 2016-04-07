package es.indra.sicc.entidades.pre;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.pre.TipoProductoLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class TipoProductoLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-pre");
	private EntityManager em = emf.createEntityManager();

	public TipoProductoLocal create(Integer cod_tipo_prod) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("PRE_TIPR_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		TipoProductoLocal local = new TipoProductoLocal(oid, cod_tipo_prod);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(TipoProductoLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(TipoProductoLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public TipoProductoLocal findByPrimaryKey(Long  oid) {
		TipoProductoLocal local = (TipoProductoLocal)em.find(TipoProductoLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
}
