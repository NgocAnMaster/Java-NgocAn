package org.example.xml.pomfile;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Properties {
    @JsonProperty("maven.compiler.source")
    private Integer mavenCompilerSource;
    @JsonProperty("maven.compiler.target")
    private Integer mavenCompilerTarget;
    @JsonProperty("project.build.sourceEncoding")
    private String projectBuildSourceEncoding;
}
