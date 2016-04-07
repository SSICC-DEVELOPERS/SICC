package es.indra.sicc.cmn.negocio.interfaces;

import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;
import java.util.Date;

import es.indra.sicc.cmn.negocio.interfaces.HistoricoLotesLocal;

public class HistoricoLotesLocalHome {

	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-cmn");
	private EntityManager em = emf.createEntityManager();

	public HistoricoLotesLocal create(String codigo, String numeroLote, Long pais, String descripcion, 
			Date fechaInicio, Date fechaFin, int registroProcesados, int registrosErroneos, 
			String observaciones) {
		
		final EntityTransaction et = em.getTransaction();
		et.begin();
		HistoricoLotesLocal local = new HistoricoLotesLocal(codigo,numeroLote,pais,descripcion,
		                                                    fechaInicio,fechaFin,registroProcesados,
															registrosErroneos,observaciones);
		em.persist(local);
		et.commit();
                return local;
	}
	
	public void remove(HistoricoLotesLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(HistoricoLotesLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public HistoricoLotesLocal findByPrimaryKey(HistoricoLotesPK pk) {
                HistoricoLotesLocal local = em.find(HistoricoLotesLocal.class, pk);
                if (local == null) throw new NoResultException();
                return local;
	}

	
	public Collection findAll() {
		Query query=em.createNamedQuery("HistoricoLotesLocal.FindAll");
		return query.getResultList();
	}

}
