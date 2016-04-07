package es.indra.sicc.entidades.fac;

import es.indra.mare.common.exception.MareException;
import es.indra.sicc.entidades.fac.MensajesFacturacionLocal;
import es.indra.sicc.util.SecuenciadorOID;

import java.sql.Timestamp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;


public class MensajesFacturacionLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-fac");
	private EntityManager em = emf.createEntityManager();

	public MensajesFacturacionLocal create(Long cliente, Long numeroSecuencial, Timestamp fecha, String datoVariable1, String datoVariable2, String datoVariable3, String datoVariable4, String datoVariable5, String datoVariable6, String datoVariable7, String datoVariable8, Long periodo, Long modulo, Boolean listaConsultoras, Boolean permanenciaMensaje, Boolean borrado, String codMensaje, Long cabecera, Long buzonMensaje) throws MareException {
		final EntityTransaction et = em.getTransaction();
		et.begin();
                Long oid = SecuenciadorOID.obtenerSiguienteValor("FAC_MEFA_SEQ");
		MensajesFacturacionLocal local = new MensajesFacturacionLocal(oid, cliente, numeroSecuencial, fecha, datoVariable1, datoVariable2, datoVariable3, datoVariable4, datoVariable5, datoVariable6, datoVariable7, datoVariable8, periodo, modulo, listaConsultoras, permanenciaMensaje, borrado, codMensaje, cabecera, buzonMensaje);
		em.persist(local);
		et.commit();
		return local;
	}
	
        public MensajesFacturacionLocal create(Long cliente, Long numeroSecuencial, Timestamp fecha, String datoVariable1, Long modulo, Boolean listaConsultoras, Boolean borrado, String codMensaje, Long cabecera, Long buzonMensaje) throws MareException {
                final EntityTransaction et = em.getTransaction();
                et.begin();
                Long oid = SecuenciadorOID.obtenerSiguienteValor("FAC_MEFA_SEQ");
                MensajesFacturacionLocal local = new MensajesFacturacionLocal(oid, cliente, numeroSecuencial, fecha, datoVariable1, modulo, listaConsultoras, borrado, codMensaje, cabecera, buzonMensaje);
                em.persist(local);
                et.commit();
                return local;
        }
    
	public void remove(MensajesFacturacionLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(MensajesFacturacionLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public MensajesFacturacionLocal findByPrimaryKey(Long  oid) {
		MensajesFacturacionLocal local = (MensajesFacturacionLocal)em.find(MensajesFacturacionLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
}
