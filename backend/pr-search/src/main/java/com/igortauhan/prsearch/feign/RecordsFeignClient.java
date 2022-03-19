package com.igortauhan.prsearch.feign;

import com.igortauhan.prsearch.models.Records;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "pr-base", path = "/records")
@Component
public interface RecordsFeignClient {

    @PostMapping
    ResponseEntity<List<Records>> insert(@RequestBody String recordsJson, @RequestParam Long ativoId);
}
