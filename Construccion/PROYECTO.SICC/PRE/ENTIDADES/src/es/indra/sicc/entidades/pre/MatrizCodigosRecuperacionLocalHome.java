package es.indra.sicc.entidades.pre;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.pre.MatrizCodigosRecuperacionLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class MatrizCodigosRecuperacionLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-pre");
	private EntityManager em = emf.createEntityManager();

	public MatrizCodigosRecuperacionLocal create(Long mafa_oid_cod_ppal, Long mafa_oid_cod_recu, Boolean recupAuto, Boolean emiteMsj) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("PRE_MTRE_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		MatrizCodigosRecuperacionLocal local = new MatrizCodigosRecuperacionLocal(oid, mafa_oid_cod_ppal, mafa_oid_cod_recu, recupAuto, emiteMsj);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(MatrizCodigosRecuperacionLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(MatrizCodigosRecuperacionLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public MatrizCodigosRecuperacionLocal findByPrimaryKey(Long  oid) {
		MatrizCodigosRecuperacionLocal local = (MatrizCodigosRecuperacionLocal)em.find(MatrizCodigosRecuperacionLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
	public Collection findByOidPpal(Long oidCodPpal) {
		Query query=em.createNamedQuery("MatrizCodigosRecuperacionLocal.FindByOidPpal");
		
		query.setParameter(1, oidCodPpal);

		return query.getResultList();
	}

	public Collection findByOidRecu(Long oidCodRecu) {
		Query query=em.createNamedQuery("MatrizCodigosRecuperacionLocal.FindByOidRecu");
		
		query.setParameter(1, oidCodRecu);

		return query.getResultList();
	}

}
