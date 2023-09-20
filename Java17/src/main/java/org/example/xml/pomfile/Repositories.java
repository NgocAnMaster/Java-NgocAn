package org.example.xml.pomfile;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Repositories {
    @JsonProperty("repository")
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<Repository> repositories;
}
