package ru.rgs.csvparser.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.rgs.csvparser.model.ExternalRequest;
import ru.rgs.csvparser.model.ExternalResponse;

@FeignClient("external")
public interface ExternalClient {

    @RequestMapping(method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
            path = "/score")
    ExternalResponse getClientScoring(@RequestBody ExternalRequest externalRequest);
}
