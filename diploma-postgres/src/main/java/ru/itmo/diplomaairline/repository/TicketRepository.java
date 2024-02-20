package ru.itmo.diplomaairline.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.itmo.diplomaairline.model.entity.Ticket;

import java.util.List;

/**
 * Репозиторий сущности "Билет"
 */
@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
    List<Ticket> findAllByFlightId(Long flight);

    List<Ticket> findAllByHumanId(Long human);
}
