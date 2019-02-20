package ru.rgs.csvparser.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Request {

    private String clientName;
    private LocalDate contractDate;
}
