package es.indra.sicc.entidades.intsys;

import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.intsys.DescuentosPersonalCabeceraLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

import java.sql.Date;

public class DescuentosPersonalCabeceraLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-intsys");
	private EntityManager em = emf.createEntityManager();

	public DescuentosPersonalCabeceraLocal create(Long numeroDocumento, Date fechaCreacion, Long pais, Long acceso, Long estado, Long marca) throws MareException {
		final EntityTransaction et = em.getTransaction();
		et.begin();
                Long oid = SecuenciadorOID.obtenerSiguienteValor("INT_DPEC_SEQ");
		DescuentosPersonalCabeceraLocal local = new DescuentosPersonalCabeceraLocal(oid, numeroDocumento, fechaCreacion, pais, acceso, estado, marca);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(DescuentosPersonalCabeceraLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(DescuentosPersonalCabeceraLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public DescuentosPersonalCabeceraLocal findByPrimaryKey(Long  oid) {
		DescuentosPersonalCabeceraLocal local = em.find(DescuentosPersonalCabeceraLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	public Collection findAll() {
		Query query=em.createNamedQuery("DescuentosPersonalCabeceraLocal.FindAll");
		return query.getResultList();
	}

	public DescuentosPersonalCabeceraLocal findByUK(Long pais,Long numeroDocumento) {
		Query query=em.createNamedQuery("DescuentosPersonalCabeceraLocal.FindByUK");
		query.setParameter(1, pais);
		query.setParameter(2, numeroDocumento);
		return (DescuentosPersonalCabeceraLocal)(query.getSingleResult());
	}

}
