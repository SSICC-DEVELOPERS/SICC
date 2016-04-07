package es.indra.sicc.entidades.seg;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.seg.EmpresaLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class EmpresaLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-seg");
	private EntityManager em = emf.createEntityManager();

	public EmpresaLocal create(String codigo, String identificacionFiscal, Long pais, String denominacion) throws MareException {
		Long oid = SecuenciadorOID.obtenerSiguienteValor("SEG_SOCI_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		EmpresaLocal local = new EmpresaLocal(oid, codigo, identificacionFiscal, pais, denominacion);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(EmpresaLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(EmpresaLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public EmpresaLocal findByPrimaryKey(Long  oid) {
		EmpresaLocal local = (EmpresaLocal)em.find(EmpresaLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	public Collection findAll() {
		Query query=em.createNamedQuery("EmpresaLocal.FindAll");
		return query.getResultList();
	}

	public EmpresaLocal findByUK(String codigo) {
		Query query=em.createNamedQuery("EmpresaLocal.FindByUK");
		query.setParameter(1, codigo);
		return (EmpresaLocal)(query.getSingleResult());
	}

	public EmpresaLocal findByPaisYCodigo(Long pais,String codigo) {
		Query query=em.createNamedQuery("EmpresaLocal.FindByPaisYCodigo");
		query.setParameter(1, pais);
		query.setParameter(2, codigo);
		return (EmpresaLocal)(query.getSingleResult());
	}

}
