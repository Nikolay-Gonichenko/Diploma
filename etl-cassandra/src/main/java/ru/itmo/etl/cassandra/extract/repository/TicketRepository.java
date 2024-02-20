package ru.itmo.etl.cassandra.extract.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.itmo.etl.cassandra.extract.model.Ticket;

import java.util.List;

/**
 * Репозиторий сущности "Билет"
 */
@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
    List<Ticket> findAllByFlightId(Long flight);

    List<Ticket> findAllByHumanId(Long human);
}
