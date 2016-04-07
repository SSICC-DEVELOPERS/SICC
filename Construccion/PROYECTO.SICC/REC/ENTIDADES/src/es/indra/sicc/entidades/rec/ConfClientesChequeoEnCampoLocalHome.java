package es.indra.sicc.entidades.rec;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.rec.ConfClientesChequeoEnCampoLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class ConfClientesChequeoEnCampoLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-rec");
	private EntityManager em = emf.createEntityManager();

	public ConfClientesChequeoEnCampoLocal create(String cantidadTotalConsultoras, String periodoReclamo, Boolean indChequearNuevas, Boolean indGenerado, Long periodo, Long periodoInicial, Long periodofinal) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("REC_CCCC_SEQ");
                final EntityTransaction et = em.getTransaction();
		et.begin();
                ConfClientesChequeoEnCampoLocal local = new ConfClientesChequeoEnCampoLocal(oid, cantidadTotalConsultoras, periodoReclamo, indChequearNuevas, indGenerado, periodo, periodoInicial, periodofinal);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(ConfClientesChequeoEnCampoLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(ConfClientesChequeoEnCampoLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public ConfClientesChequeoEnCampoLocal findByPrimaryKey(Long  oid) {
		ConfClientesChequeoEnCampoLocal local = (ConfClientesChequeoEnCampoLocal)em.find(ConfClientesChequeoEnCampoLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
	public ConfClientesChequeoEnCampoLocal findByUK(Long param1) {
		Query query=em.createNamedQuery("ConfClientesChequeoEnCampoLocal.FindByUK");
		
		query.setParameter(1, param1);

		return (ConfClientesChequeoEnCampoLocal)(query.getSingleResult());
	}

	public Collection findAll() {
		Query query=em.createNamedQuery("ConfClientesChequeoEnCampoLocal.FindAll");
		
		return (query.getResultList());
	}

}
