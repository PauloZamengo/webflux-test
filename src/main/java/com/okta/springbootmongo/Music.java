package com.okta.springbootmongo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Music {

    private String name;
    private String artist;
    private Number value;
    private Boolean favorite;
}
