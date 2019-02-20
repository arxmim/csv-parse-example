package ru.rgs.csvparser.model;

import lombok.Data;

@Data
public class ExternalResponse {

    private ExternalResponseStatus status;
    private String description;
    private Double scoringValue;

}
