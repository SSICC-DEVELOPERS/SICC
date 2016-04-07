package es.indra.sicc.entidades.bel;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.bel.RegistroAbastecimientoCabeceraLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class RegistroAbastecimientoCabeceraLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-bel");
	private EntityManager em = emf.createEntityManager();

	public RegistroAbastecimientoCabeceraLocal create(Long nSolicitud, Long periodo, Long almacen, Long subacceso, Long pais, Long estadoHojaDemanda, Long agrupacionStockCabecera) throws MareException {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		Long oid = SecuenciadorOID.obtenerSiguienteValor("BEL_RABC_SEQ");
                RegistroAbastecimientoCabeceraLocal local = new RegistroAbastecimientoCabeceraLocal(oid, nSolicitud, periodo, almacen, subacceso, pais, estadoHojaDemanda, agrupacionStockCabecera);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(RegistroAbastecimientoCabeceraLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(RegistroAbastecimientoCabeceraLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public RegistroAbastecimientoCabeceraLocal findByPrimaryKey(Long  oid) {
		RegistroAbastecimientoCabeceraLocal local = (RegistroAbastecimientoCabeceraLocal)em.find(RegistroAbastecimientoCabeceraLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
	public RegistroAbastecimientoCabeceraLocal findByUK(Long param1) {
		Query query=em.createNamedQuery("RegistroAbastecimientoCabeceraLocal.FindByUK");
		
		query.setParameter(1, param1);

		return (RegistroAbastecimientoCabeceraLocal)(query.getSingleResult());
	}

}
