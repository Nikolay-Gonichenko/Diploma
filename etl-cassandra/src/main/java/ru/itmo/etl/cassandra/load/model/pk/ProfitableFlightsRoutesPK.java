package ru.itmo.etl.cassandra.load.model.pk;

import lombok.*;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyClass;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@PrimaryKeyClass
public class ProfitableFlightsRoutesPK implements Serializable {

    @PrimaryKeyColumn(name = "flight_id", type = PrimaryKeyType.PARTITIONED)
    private Long flight;

    @PrimaryKeyColumn(name = "route_id", type = PrimaryKeyType.CLUSTERED)
    private Long route;

    @PrimaryKeyColumn(name = "date_time", type = PrimaryKeyType.CLUSTERED)
    private LocalDateTime dateTime;

    @PrimaryKeyColumn(name = "clean_profit", type = PrimaryKeyType.CLUSTERED)
    private Double cleanProfit;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProfitableFlightsRoutesPK)) return false;
        ProfitableFlightsRoutesPK that = (ProfitableFlightsRoutesPK) o;
        return Objects.equals(getFlight(), that.getFlight()) && Objects.equals(getRoute(), that.getRoute()) && Objects.equals(getDateTime(), that.getDateTime()) && Objects.equals(getCleanProfit(), that.getCleanProfit());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFlight(), getRoute(), getDateTime(), getCleanProfit());
    }
}
