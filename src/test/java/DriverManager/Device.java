package DriverManager;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;
import lombok.experimental.Accessors;
import org.openqa.selenium.remote.DesiredCapabilities;

@Data
@Accessors(fluent = true)
public class Device {

    @JsonProperty
    private Driver driver;

    @JsonProperty
    private String url;

}
