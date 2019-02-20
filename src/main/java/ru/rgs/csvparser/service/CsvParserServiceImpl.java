package ru.rgs.csvparser.service;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import ru.rgs.csvparser.client.ExternalClient;
import ru.rgs.csvparser.model.Request;
import ru.rgs.csvparser.model.Response;
import ru.rgs.csvparser.model.ResponseStatus;

import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author ianazarov
 * (c) RGS
 * created 2019-02-20
 */
public class CsvParserServiceImpl implements CsvParserService {
    @Autowired
    private ExternalClient externalClient;

    private DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ISO_DATE;

    @Override
    @SneakyThrows
    public Path processCsv(Path source) {
        Path result = Files.createTempFile("csvParser", UUID.randomUUID().toString());
        List<String> lines = new ArrayList<>();
        lines.add("CLIENT_NAME,CONTRACT_DATE,SCORING");
        Files.lines(source).forEach(s -> {
            if (!s.startsWith("FIRST_NAME")) {
                String[] split = s.split(",");
                Request request = new Request();
                request.setClientName(split[0].toUpperCase() + " " + split[2].toUpperCase() + " " + split[1].toUpperCase());
                request.setContractDate(dateTimeFormatter.parse(split[3], LocalDate::from));
                Response clientScoring = externalClient.getClientScoring(request);
                if (clientScoring.getStatus() == ResponseStatus.COMPLETED) {
                    lines.add(request.getClientName() + "," + split[3] + "," + clientScoring.getScoringValue());
                } else if (clientScoring.getStatus() == ResponseStatus.FAILED) {
                    lines.add(request.getClientName() + "," + split[3] + "," + clientScoring.getDescription());
                } else if (clientScoring.getStatus() == ResponseStatus.NOT_FOUND) {
                    lines.add(request.getClientName() + "," + split[3] + ",не найден");
                }
            }
        });
        Files.write(result, lines);
        return result;
    }
}
