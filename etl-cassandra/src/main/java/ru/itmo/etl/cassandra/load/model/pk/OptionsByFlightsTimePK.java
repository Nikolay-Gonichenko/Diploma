package ru.itmo.etl.cassandra.load.model.pk;

import lombok.*;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyClass;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@PrimaryKeyClass
public class OptionsByFlightsTimePK implements Serializable {

    @PrimaryKeyColumn(name = "flight_id", type = PrimaryKeyType.PARTITIONED)
    private Long flight;

    @PrimaryKeyColumn(name = "human_id", type = PrimaryKeyType.CLUSTERED)
    private Long human;

    @PrimaryKeyColumn(name = "option_id", type = PrimaryKeyType.CLUSTERED)
    private Long option;

    @PrimaryKeyColumn(name = "flight_time", type = PrimaryKeyType.CLUSTERED)
    private Double flightTime;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OptionsByFlightsTimePK)) return false;
        OptionsByFlightsTimePK that = (OptionsByFlightsTimePK) o;
        return Objects.equals(getFlight(), that.getFlight()) && Objects.equals(getHuman(), that.getHuman()) && Objects.equals(getOption(), that.getOption()) && Objects.equals(getFlightTime(), that.getFlightTime());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFlight(), getHuman(), getOption(), getFlightTime());
    }
}
