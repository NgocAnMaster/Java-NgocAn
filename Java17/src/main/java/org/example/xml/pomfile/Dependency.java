package org.example.xml.pomfile;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)

public class Dependency {
    private String groupId;
    private String artifactId;
    private String version;
    private String type;
    private String scope;
}
