package org.example.xml.pomfile;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonRootName("project")
public class Project {
    private String modelVersion;
    private String groupId;
    private String artifactId;
    private String version;
    private Properties properties;
    private Dependencies dependencies;
    private Repositories repositories;
}
