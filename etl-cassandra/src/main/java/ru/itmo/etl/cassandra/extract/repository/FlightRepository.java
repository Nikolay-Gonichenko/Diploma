package ru.itmo.etl.cassandra.extract.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ru.itmo.etl.cassandra.extract.model.Flight;

import java.util.Optional;

/**
 * Репозиторий сущности "Полёт"
 */
@Repository
public interface FlightRepository extends PagingAndSortingRepository<Flight, Long> {
    Page<Flight> findAll(Pageable pageable);

    Optional<Flight> findById(Long id);

    Flight save(Flight flight);
}
