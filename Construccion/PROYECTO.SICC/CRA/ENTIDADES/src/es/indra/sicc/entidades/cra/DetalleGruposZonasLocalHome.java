package es.indra.sicc.entidades.cra;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.cra.DetalleGruposZonasLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class DetalleGruposZonasLocalHome	{

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-cra");
	private EntityManager em = emf.createEntityManager();

	public DetalleGruposZonasLocal create(Long zzon_oid_zona, Long cgzo_oid_cabe_grup_zona) throws MareException {
		Long oid = SecuenciadorOID.obtenerSiguienteValor("CRA_DEGZ_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		DetalleGruposZonasLocal local = new DetalleGruposZonasLocal(oid, zzon_oid_zona, cgzo_oid_cabe_grup_zona);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(DetalleGruposZonasLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(DetalleGruposZonasLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public DetalleGruposZonasLocal findByPrimaryKey(Long  oid) {
		DetalleGruposZonasLocal local = em.find(DetalleGruposZonasLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
	public Collection findByCabeceraPK(Long oidGrupo) {
		Query query=em.createNamedQuery("DetalleGruposZonasLocal.FindByCabeceraPK");
		query.setParameter(1, oidGrupo);
		return query.getResultList();
	}

	public Collection findByOidGrupoOidZona(Long OidGrupo, Long OidZona) {
		Query query=em.createNamedQuery("DetalleGruposZonasLocal.FindByOidGrupoOidZona");
		query.setParameter(1, OidGrupo);
		query.setParameter(2, OidZona);
		return query.getResultList();
	}

}
