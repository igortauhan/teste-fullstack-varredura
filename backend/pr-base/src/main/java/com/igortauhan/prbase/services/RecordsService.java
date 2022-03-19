package com.igortauhan.prbase.services;

import com.igortauhan.prbase.config.GsonConfig;
import com.igortauhan.prbase.models.Ativo;
import com.igortauhan.prbase.models.GenericRequestClass;
import com.igortauhan.prbase.models.Records;
import com.igortauhan.prbase.models.dto.AtivoDto;
import com.igortauhan.prbase.repositories.RecordsRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecordsService {

    private final RecordsRepository recordsRepository;
    private final AtivoService ativoService;
    private final GsonConfig gsonConfig;

    public RecordsService(RecordsRepository recordsRepository, AtivoService ativoService, GsonConfig gsonConfig) {
        this.recordsRepository = recordsRepository;
        this.ativoService = ativoService;
        this.gsonConfig = gsonConfig;
    }

    public List<Records> insert(String recordsJson, Long ativoId) {
        GenericRequestClass genericRequestClass = convertJsonToGenericClass(recordsJson);
        List<Records> records = getRecordsFromGenericClass(genericRequestClass);
        records = records.stream().map(x -> recordsSetAtivo(x, ativoId)).collect(Collectors.toList());
        records = records.stream().map(recordsRepository::save).collect(Collectors.toList());
        return records;
    }

    private Records recordsSetAtivo(Records records, Long ativoId) {
        AtivoDto ativoDto = ativoService.findById(ativoId);
        Ativo ativo = ativoService.fromDto(ativoDto);
        records.setAtivo(ativo);
        records.setId(null);
        return records;
    }

    private GenericRequestClass convertJsonToGenericClass(String recordsJson) {
        return gsonConfig.gson().fromJson(recordsJson, GenericRequestClass.class);
    }

    private List<Records> getRecordsFromGenericClass(GenericRequestClass genericRequestClass) {
        return genericRequestClass.getRecords();
    }
}
