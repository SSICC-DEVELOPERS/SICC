package es.indra.sicc.entidades.intsys;

import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;
import es.indra.sicc.util.SecuenciadorOID;

import es.indra.sicc.entidades.intsys.CodigoFaltanteBPSLocal;
import es.indra.mare.common.exception.MareException;

public class CodigoFaltanteBPSLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-intsys");
	private EntityManager em = emf.createEntityManager();

	public CodigoFaltanteBPSLocal create(String codigoFaltante, Long tipoPosicion, Long tipoSolicitudPais) throws MareException {
		final EntityTransaction et = em.getTransaction();
		et.begin();
                Long oid = SecuenciadorOID.obtenerSiguienteValor("INT_ICFB_SEQ");
		CodigoFaltanteBPSLocal local = new CodigoFaltanteBPSLocal(oid, codigoFaltante, tipoPosicion, tipoSolicitudPais);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(CodigoFaltanteBPSLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(CodigoFaltanteBPSLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public CodigoFaltanteBPSLocal findByPrimaryKey(Long  oid) {
		CodigoFaltanteBPSLocal local = em.find(CodigoFaltanteBPSLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
	public Collection findAll() {
		Query query=em.createNamedQuery("CodigoFaltanteBPSLocal.FindAll");
		return query.getResultList();
	}

}
