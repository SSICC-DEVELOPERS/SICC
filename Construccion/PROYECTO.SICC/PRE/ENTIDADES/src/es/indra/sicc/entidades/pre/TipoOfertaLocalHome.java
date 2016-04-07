package es.indra.sicc.entidades.pre;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.pre.TipoOfertaLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class TipoOfertaLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-pre");
	private EntityManager em = emf.createEntityManager();
   
	public TipoOfertaLocal create(Long cana_oid_cana, String cod_tipo_ofer) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("PRE_TOFE_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		TipoOfertaLocal local = new TipoOfertaLocal(oid, cana_oid_cana, cod_tipo_ofer);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(TipoOfertaLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(TipoOfertaLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public TipoOfertaLocal findByPrimaryKey(Long  oid) {
		TipoOfertaLocal local = (TipoOfertaLocal)em.find(TipoOfertaLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
	public Collection findByOidCanal(Long oidCanal) {
		Query query=em.createNamedQuery("TipoOfertaLocal.FindByOidCanal");
		
		query.setParameter(1, oidCanal);

		return query.getResultList();
	}

	public TipoOfertaLocal findByUK(Long oidCanal,String codigoTipoOferta) {
		Query query=em.createNamedQuery("TipoOfertaLocal.FindByUK");
		
		query.setParameter(1, oidCanal);

		query.setParameter(2, codigoTipoOferta);

		return (TipoOfertaLocal)(query.getSingleResult());
	}

}
