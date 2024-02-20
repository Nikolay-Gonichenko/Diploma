package ru.itmo.etl.cassandra.load.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;
import ru.itmo.etl.cassandra.load.model.pk.AgeGroupedByFlightFrequencyPK;

/**
 * Сущность запроса "возраст - самый частый полёт"
 *
 * Запрос 1.
 */
@Table(value = "ages_grouped_by_flight_frequency")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AgeGroupedByFlightFrequency {

    @PrimaryKey
    private AgeGroupedByFlightFrequencyPK ageGroupedByFlightFrequencyPK;

    @Column(value = "count")
    private Integer count;


}
