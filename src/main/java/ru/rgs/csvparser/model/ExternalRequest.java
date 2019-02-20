package ru.rgs.csvparser.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ExternalRequest {

    private String clientName;
    private LocalDate contractDate;
}
