package com.igortauhan.prbase.services;

import com.igortauhan.prbase.repositories.RecordsRepository;
import org.springframework.stereotype.Service;

@Service
public class RecordsService {

    private RecordsRepository recordsRepository;

    public RecordsService(RecordsRepository recordsRepository) {
        this.recordsRepository = recordsRepository;
    }
}
