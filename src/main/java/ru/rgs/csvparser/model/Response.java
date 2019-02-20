package ru.rgs.csvparser.model;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author ianazarov
 * (c) RGS
 * created 2019-02-19
 */
@Data
public class Response {

    private ResponseStatus status;
    private String description;
    private Double scoringValue;


}
