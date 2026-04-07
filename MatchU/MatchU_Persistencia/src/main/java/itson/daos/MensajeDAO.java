package itson.daos;

import itson.matchu.model.Mensaje;
import itson.matchu_utilerias.JPAUtil;
import jakarta.persistence.EntityManager;
import java.util.List;

/**
 *
 * @author Ricardo
 */
public class MensajeDAO {

    public Mensaje guardar(Mensaje mensaje) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(mensaje);
            em.getTransaction().commit();
            return mensaje;
        } catch (Exception e) {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            throw new RuntimeException("Error al guardar mensaje: " + e.getMessage(), e);
        } finally {
            em.close();
        }
    }

    public List<Mensaje> listarPorMatch(Long idMatch) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.createQuery(
                "SELECT m FROM Mensaje m WHERE m.match.idMatch = :idMatch " +
                "ORDER BY m.fechaEnvio ASC",
                Mensaje.class
            ).setParameter("idMatch", idMatch).getResultList();
        } finally {
            em.close();
        }
    }

    public void marcarComoLeidos(Long idMatch, Long idDestinatario) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.createQuery(
                "UPDATE Mensaje m SET m.leido = true " +
                "WHERE m.match.idMatch = :idMatch " +
                "  AND m.remitente.idEstudiante <> :idDestinatario AND m.leido = false"
            ).setParameter("idMatch", idMatch)
             .setParameter("idDestinatario", idDestinatario)
             .executeUpdate();
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    public long contarNoLeidos(Long idMatch, Long idDestinatario) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.createQuery(
                "SELECT COUNT(m) FROM Mensaje m WHERE m.match.idMatch = :idMatch " +
                "  AND m.remitente.idEstudiante <> :idDestinatario AND m.leido = false",
                Long.class
            ).setParameter("idMatch", idMatch)
             .setParameter("idDestinatario", idDestinatario)
             .getSingleResult();
        } finally {
            em.close();
        }
    }
}