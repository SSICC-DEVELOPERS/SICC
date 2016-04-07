package es.indra.sicc.cmn.negocio.i18n;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.cmn.negocio.i18n.Entidadi18nLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class Entidadi18nLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-cmn");
	private EntityManager em = emf.createEntityManager();

	public Entidadi18nLocal create(String entidad, Long atributo, Long idioma, String detalle, Long entidad_pk) throws MareException {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		Long oid = SecuenciadorOID.obtenerSiguienteValor("GEN_I18N_SEQ");
		Entidadi18nLocal local = new Entidadi18nLocal(oid, entidad, atributo, idioma, detalle, entidad_pk);
		em.persist(local);
		et.commit();
                return local;
	}
	
	public void remove(Entidadi18nLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(Entidadi18nLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public Entidadi18nLocal findByPrimaryKey(Long  oid) {
		Entidadi18nLocal local = (Entidadi18nLocal)em.find(Entidadi18nLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
	public Collection findByEntAtrIdioValor(String entidad,Long atributo,Long idioma,String detalle) {
		Query query=em.createNamedQuery("Entidadi18nLocal.FindByEntAtrIdioValor");
		
		query.setParameter(1, entidad);
		query.setParameter(2, atributo);
		query.setParameter(3, idioma);
		query.setParameter(4, detalle);

		return query.getResultList();
	}

	public Collection findAll() {
		Query query=em.createNamedQuery("Entidadi18nLocal.FindAll");
		return query.getResultList();
	}

	public Entidadi18nLocal findByEntAtrIdioPK(String entidad,Long atributo,Long idioma,Long entidadPK) {
		Query query=em.createNamedQuery("Entidadi18nLocal.FindByEntAtrIdioPK");
		
		query.setParameter(1, entidad);
		query.setParameter(2, atributo);
		query.setParameter(3, idioma);
		query.setParameter(4, entidadPK);

		return (Entidadi18nLocal)query.getSingleResult();
	}

	public Collection findByEntAtrPK(String entidad,Long atributo, Long entidad_pk) {
		Query query=em.createNamedQuery("Entidadi18nLocal.FindByEntAtrPK");
		
		query.setParameter(1, entidad);
		query.setParameter(2, atributo);
		query.setParameter(3, entidad_pk);

		return query.getResultList();
	}

	public Collection findByEntPK(String entidad, Long pk) {
		Query query=em.createNamedQuery("Entidadi18nLocal.FindByEntPK");
		
		query.setParameter(1, entidad);
		query.setParameter(2, pk);

		return query.getResultList();
	}

}
