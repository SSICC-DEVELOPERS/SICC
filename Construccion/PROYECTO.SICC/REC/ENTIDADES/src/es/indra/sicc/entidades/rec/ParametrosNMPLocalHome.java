package es.indra.sicc.entidades.rec;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.rec.ParametrosNMPLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class ParametrosNMPLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-rec");
	private EntityManager em = emf.createEntityManager();

	public ParametrosNMPLocal create(Double porcentajeRecargo, Long tipoCliente, Long pais, Long precioPerdida) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("REC_PNTC_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		ParametrosNMPLocal local = new ParametrosNMPLocal(oid, porcentajeRecargo, tipoCliente, pais, precioPerdida);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(ParametrosNMPLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(ParametrosNMPLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public ParametrosNMPLocal findByPrimaryKey(Long  oid) {
		ParametrosNMPLocal local = (ParametrosNMPLocal)em.find(ParametrosNMPLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
	public Collection findAll() {
		Query query=em.createNamedQuery("ParametrosNMPLocal.FindAll");
		
		return (query.getResultList());
	}

}
