package com.example.letscode.demoletscode.domain.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@Setter
@Getter
public class CaptchaResponse {
    private boolean success;
    @JsonAlias("error-codes")
    private Set<String> errorCodes;
}
