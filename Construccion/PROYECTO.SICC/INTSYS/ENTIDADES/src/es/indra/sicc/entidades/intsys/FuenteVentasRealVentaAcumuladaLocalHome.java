package es.indra.sicc.entidades.intsys;

import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.intsys.FuenteVentasRealVentaAcumuladaLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class FuenteVentasRealVentaAcumuladaLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-intsys");
	private EntityManager em = emf.createEntityManager();

	public FuenteVentasRealVentaAcumuladaLocal create(Long tipoSolicitud, Long tipoCliente, Long region, Long sociedad, Long zona, Long almacen, Long pais, Long periodo, Long territorio) throws MareException {
		final EntityTransaction et = em.getTransaction();
		et.begin();
                Long oid = SecuenciadorOID.obtenerSiguienteValor("INT_FVRA_SEQ");
		FuenteVentasRealVentaAcumuladaLocal local = new FuenteVentasRealVentaAcumuladaLocal(oid, tipoSolicitud, tipoCliente, region, sociedad, zona, almacen, pais, periodo, territorio);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(FuenteVentasRealVentaAcumuladaLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(FuenteVentasRealVentaAcumuladaLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public FuenteVentasRealVentaAcumuladaLocal findByPrimaryKey(Long  oid) {
		FuenteVentasRealVentaAcumuladaLocal local = em.find(FuenteVentasRealVentaAcumuladaLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
	public Collection findAll() {
		Query query=em.createNamedQuery("FuenteVentasRealVentaAcumuladaLocal.FindAll");
		return query.getResultList();
	}

}
