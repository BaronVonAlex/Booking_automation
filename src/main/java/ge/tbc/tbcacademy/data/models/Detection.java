package ge.tbc.tbcacademy.data.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(fluent = true, chain = true)
public class Detection {
    @JsonProperty("language")
    private String language;
    @JsonProperty("isReliable")
    private boolean isReliable;
    @JsonProperty("confidence")
    private double confidence;
}
