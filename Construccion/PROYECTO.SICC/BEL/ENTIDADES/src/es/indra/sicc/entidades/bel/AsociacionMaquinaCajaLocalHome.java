package es.indra.sicc.entidades.bel;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.bel.AsociacionMaquinaCajaLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class AsociacionMaquinaCajaLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-bel");
	private EntityManager em = emf.createEntityManager();

	public AsociacionMaquinaCajaLocal create(String val_maqu, Long caja_oid_caja) throws  MareException {
		final EntityTransaction et = em.getTransaction();
		et.begin();
                Long oid = SecuenciadorOID.obtenerSiguienteValor("BEL_MACA_SEQ");
		AsociacionMaquinaCajaLocal local = new AsociacionMaquinaCajaLocal(oid, val_maqu, caja_oid_caja);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(AsociacionMaquinaCajaLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(AsociacionMaquinaCajaLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public AsociacionMaquinaCajaLocal findByPrimaryKey(Long  oid) {
		AsociacionMaquinaCajaLocal local = (AsociacionMaquinaCajaLocal)em.find(AsociacionMaquinaCajaLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
	public AsociacionMaquinaCajaLocal findByUK(String maquina) {
		Query query=em.createNamedQuery("AsociacionMaquinaCajaLocal.FindByUK");
		query.setParameter(1, maquina);
		return (AsociacionMaquinaCajaLocal)(query.getSingleResult());
	}

}
