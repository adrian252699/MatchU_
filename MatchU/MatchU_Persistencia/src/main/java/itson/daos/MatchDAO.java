package itson.daos;

import itson.matchu.model.Match;
import itson.matchu_utilerias.JPAUtil;
import jakarta.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Ricardo
 */
public class MatchDAO {

    public Match guardar(Match match) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(match);
            em.getTransaction().commit();
            return match;
        } catch (Exception e) {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            throw new RuntimeException("Error al guardar match: " + e.getMessage(), e);
        } finally {
            em.close();
        }
    }

    public Optional<Match> buscarEntre(Long idA, Long idB) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            List<Match> res = em.createQuery(
                "SELECT m FROM Match m WHERE m.activo = true AND (" +
                "  (m.estudiante1.idEstudiante = :a AND m.estudiante2.idEstudiante = :b) OR " +
                "  (m.estudiante1.idEstudiante = :b AND m.estudiante2.idEstudiante = :a))",
                Match.class
            ).setParameter("a", idA).setParameter("b", idB).getResultList();
            return res.isEmpty() ? Optional.empty() : Optional.of(res.get(0));
        } finally {
            em.close();
        }
    }

    public List<Match> listarMatchesDeEstudiante(Long idEstudiante) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.createQuery(
                "SELECT m FROM Match m WHERE m.activo = true AND (" +
                "  m.estudiante1.idEstudiante = :id OR m.estudiante2.idEstudiante = :id) " +
                "ORDER BY m.fechaMatch DESC",
                Match.class
            ).setParameter("id", idEstudiante).getResultList();
        } finally {
            em.close();
        }
    }

    public Optional<Match> buscarPorId(Long idMatch) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            Match m = em.find(Match.class, idMatch);
            if (m != null) m.getMensajes().size(); // forzar carga
            return Optional.ofNullable(m);
        } finally {
            em.close();
        }
    }
}