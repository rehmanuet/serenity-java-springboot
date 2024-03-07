package com.lab.tas.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.Accessors;
import lombok.experimental.SuperBuilder;

@Getter(AccessLevel.PUBLIC)
@Setter(AccessLevel.PUBLIC)
@Accessors(fluent = true)
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class User {

    @JsonProperty
    protected String name;

    @JsonProperty
    protected String password;

    @JsonProperty
    protected String username;
    @JsonProperty
    protected String status;
}
