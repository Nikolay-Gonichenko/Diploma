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
public class FLightsHumansCostPK implements Serializable {

    @PrimaryKeyColumn(name = "flight_id", type = PrimaryKeyType.PARTITIONED)
    private Long flight;

    @PrimaryKeyColumn(name = "human_id", type = PrimaryKeyType.CLUSTERED)
    private Long human;

    @PrimaryKeyColumn(name = "cost", type = PrimaryKeyType.CLUSTERED)
    private Integer cost;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FLightsHumansCostPK)) return false;
        FLightsHumansCostPK that = (FLightsHumansCostPK) o;
        return Objects.equals(getFlight(), that.getFlight()) && Objects.equals(getHuman(), that.getHuman()) && Objects.equals(getCost(), that.getCost());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFlight(), getHuman(), getCost());
    }
}
