package ru.itmo.etl.cassandra.load.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;
import ru.itmo.etl.cassandra.load.model.pk.OptionsByFlightsTimePK;

import java.time.LocalDateTime;

/**
 * Сущность запроса "Частые опции по длительности полёта"
 *
 * Запрос 3.
 */
@Table(value = "flight_duration_options")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OptionsByFlightsTime {

    @PrimaryKey
    private OptionsByFlightsTimePK optionsByFlightsTimePK;

    @Column(value = "date_start")
    private LocalDateTime dateStart;
    @Column(value = "date_finish")
    private LocalDateTime dateFinish;

    @Column(value = "age")
    private Integer humanAge;
    @Column(value = "option_name")
    private String optionName;

    @Column(value = "airport_to")
    private String airportTo;
    @Column(value = "country_to")
    private String countryTo;
    @Column(value = "city_to")
    private String cityTo;

    @Column(value = "airport_from")
    private String airportFrom;
    @Column(value = "country_from")
    private String countryFrom;
    @Column(value = "city_from")
    private String cityFrom;

}
