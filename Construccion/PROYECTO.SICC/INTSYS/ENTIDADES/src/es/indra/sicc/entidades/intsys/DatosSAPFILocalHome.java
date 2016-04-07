package es.indra.sicc.entidades.intsys;

import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.intsys.DatosSAPFILocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

import java.math.BigDecimal;

import java.util.Date;

public class DatosSAPFILocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-intsys");
	private EntityManager em = emf.createEntityManager();

	public DatosSAPFILocal create(String indicadorFacturaCCC, String numeroLote, Date fechaContable, String tipoAsiento, Long tipoMovimientoSAPFI, String glosa, String indicadorDebeHaber, BigDecimal importe, String periodoContable, Short ejercicioContable, Long subacceso, Long moneda, Long sociedad) throws MareException {
		final EntityTransaction et = em.getTransaction();
		et.begin();
                Long oid = SecuenciadorOID.obtenerSiguienteValor("INT_DASF_SEQ");   
                DatosSAPFILocal local = new DatosSAPFILocal(oid, indicadorFacturaCCC, numeroLote, fechaContable, tipoAsiento, tipoMovimientoSAPFI, glosa, indicadorDebeHaber, importe, periodoContable, ejercicioContable, subacceso, moneda, sociedad);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(DatosSAPFILocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(DatosSAPFILocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public DatosSAPFILocal findByPrimaryKey(Long  oid) {
		DatosSAPFILocal local = em.find(DatosSAPFILocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
	public Collection findAll() {
		Query query=em.createNamedQuery("DatosSAPFILocal.FindAll");
		return query.getResultList();
	}

}
