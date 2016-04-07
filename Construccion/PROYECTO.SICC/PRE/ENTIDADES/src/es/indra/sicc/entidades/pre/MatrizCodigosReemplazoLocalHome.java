package es.indra.sicc.entidades.pre;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.pre.MatrizCodigosReemplazoLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class MatrizCodigosReemplazoLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-pre");
	private EntityManager em = emf.createEntityManager();

	public MatrizCodigosReemplazoLocal create(Long mafa_oid_cod_ppal, Long mafa_oid_cod_reem, Boolean antesDespuesCuadre, Boolean emiteMsj) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("PRE_MTRZ_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		MatrizCodigosReemplazoLocal local = new MatrizCodigosReemplazoLocal(oid, mafa_oid_cod_ppal, mafa_oid_cod_reem, antesDespuesCuadre, emiteMsj);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(MatrizCodigosReemplazoLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(MatrizCodigosReemplazoLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public MatrizCodigosReemplazoLocal findByPrimaryKey(Long  oid) {
		MatrizCodigosReemplazoLocal local = (MatrizCodigosReemplazoLocal)em.find(MatrizCodigosReemplazoLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
	public Collection findByOidPpal(Long oidCodPpal) {
		Query query=em.createNamedQuery("MatrizCodigosReemplazoLocal.FindByOidPpal");
		
		query.setParameter(1, oidCodPpal);

		return query.getResultList();
	}

	public Collection findByOidReemp(Long oidCodReem) {
		Query query=em.createNamedQuery("MatrizCodigosReemplazoLocal.FindByOidReemp");
		
		query.setParameter(1, oidCodReem);

		return query.getResultList();
	}

}
