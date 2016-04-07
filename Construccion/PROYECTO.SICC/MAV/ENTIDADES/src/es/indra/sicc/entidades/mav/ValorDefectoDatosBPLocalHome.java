package es.indra.sicc.entidades.mav;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.mav.ValorDefectoDatosBPLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class ValorDefectoDatosBPLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-mav");
	private EntityManager em = emf.createEntityManager();

	public ValorDefectoDatosBPLocal create(Long oidActividad, String codigo, Long oidPais) throws MareException {
                Long oidValorDefecto = SecuenciadorOID.obtenerSiguienteValor("MAV_PDBP_SEQ");  
		final EntityTransaction et = em.getTransaction();
		et.begin();
		ValorDefectoDatosBPLocal local = new ValorDefectoDatosBPLocal(oidValorDefecto, oidActividad, codigo, oidPais);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(ValorDefectoDatosBPLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(ValorDefectoDatosBPLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public ValorDefectoDatosBPLocal findByPrimaryKey(Long  oidValorDefecto) {
		ValorDefectoDatosBPLocal local = (ValorDefectoDatosBPLocal)em.find(ValorDefectoDatosBPLocal.class, oidValorDefecto);
		if (local==null) throw new NoResultException();
		return local;
	}

	
	public Collection findAll() {
		Query query=em.createNamedQuery("ValorDefectoDatosBPLocal.FindAll");
		
		return query.getResultList();
	}

	public ValorDefectoDatosBPLocal findByUK(Long oidActividad,String codigo) {
		Query query=em.createNamedQuery("ValorDefectoDatosBPLocal.FindByUK");
		
		query.setParameter(1, oidActividad);

		query.setParameter(2, codigo);

		return (ValorDefectoDatosBPLocal)(query.getSingleResult());
	}

}
