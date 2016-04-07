package es.indra.sicc.entidades.bel;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.bel.MovimientosDeCajaCabeceraLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

import java.sql.Timestamp;

public class MovimientosDeCajaCabeceraLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-bel");
	private EntityManager em = emf.createEntityManager();

	public MovimientosDeCajaCabeceraLocal create(Long caja, Long numeroMovimiento, Timestamp fecha, String usuario) throws MareException{
		final EntityTransaction et = em.getTransaction();
		et.begin();
                Long oid = SecuenciadorOID.obtenerSiguienteValor("BEL_MCAC_SEQ");
                MovimientosDeCajaCabeceraLocal local = new MovimientosDeCajaCabeceraLocal(oid, caja, numeroMovimiento, fecha, usuario);
		em.persist(local);
		et.commit();
		return local;
	}
        
        public MovimientosDeCajaCabeceraLocal create(Long caja, Long numeroMovimiento, Timestamp fecha, String usuario, String observaciones) throws MareException{
                final EntityTransaction et = em.getTransaction();
                et.begin();
                Long oid = SecuenciadorOID.obtenerSiguienteValor("BEL_MCAC_SEQ");
                MovimientosDeCajaCabeceraLocal local = new MovimientosDeCajaCabeceraLocal(oid, caja, numeroMovimiento, fecha, usuario, observaciones);
                em.persist(local);
                et.commit();
                return local;
        }        
	
	public void remove(MovimientosDeCajaCabeceraLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(MovimientosDeCajaCabeceraLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public MovimientosDeCajaCabeceraLocal findByPrimaryKey(Long  oid) {
		MovimientosDeCajaCabeceraLocal local = (MovimientosDeCajaCabeceraLocal)em.find(MovimientosDeCajaCabeceraLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
}
