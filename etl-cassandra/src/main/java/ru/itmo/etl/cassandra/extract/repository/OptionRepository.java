package ru.itmo.etl.cassandra.extract.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.itmo.etl.cassandra.extract.model.Option;
import ru.itmo.etl.cassandra.extract.model.Ticket;

import java.util.List;

/**
 * Репозиторий сущности "Дополнительная услуга"
 */
@Repository
public interface OptionRepository extends JpaRepository<Option, Long> {

    List<Option> findAllByTicket(Ticket ticket);
}
