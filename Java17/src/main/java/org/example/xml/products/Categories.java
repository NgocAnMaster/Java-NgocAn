package org.example.xml.products;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Categories {
    @JsonProperty("category")
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<Category> categories;
}
