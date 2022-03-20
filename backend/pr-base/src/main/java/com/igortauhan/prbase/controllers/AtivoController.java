package com.igortauhan.prbase.controllers;

import com.igortauhan.prbase.models.dto.AtivoDto;
import com.igortauhan.prbase.services.AtivoService;
import io.swagger.annotations.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping(value = "/ativos")
@Api(value = "API Rest Ativos")
@CrossOrigin(origins = "*")
public class AtivoController {

    private final AtivoService ativoService;

    public AtivoController(AtivoService ativoService) {
        this.ativoService = ativoService;
    }

    @GetMapping
    @ApiOperation(value = "Retorna todos os Ativos cadastrados", response = AtivoDto.class)
    @ApiParam(value = "Recebe um Pageable por parametros", allowEmptyValue = true)
    @ApiResponse(message = "Ok", code = 200)
    public ResponseEntity<Page<AtivoDto>> findAll(Pageable pageable) {
        Page<AtivoDto> ativos = ativoService.findAll(pageable);
        return ResponseEntity.ok(ativos);
    }

    @GetMapping(value = "/{id}")
    @ApiOperation(value = "Retorna um AtivoDto")
    @ApiParam(value = "Recebe um ID Long pela URL")
    @ApiResponses(value = {
            @ApiResponse(message = "Ok", code = 200),
            @ApiResponse(message = "Not Found", code = 404)
    })
    public ResponseEntity<AtivoDto> findById(@PathVariable Long id) {
        AtivoDto ativoDto = ativoService.findById(id);
        return ResponseEntity.ok(ativoDto);
    }

    @GetMapping(value = "/email")
    @ApiOperation(value = "Retorna um AtivoDto")
    @ApiParam(value = "Recebe um Email como parametro")
    @ApiResponses(value = {
            @ApiResponse(message = "Ok", code = 200),
            @ApiResponse(message = "Not Found", code = 404)
    })
    public ResponseEntity<AtivoDto> findByEmail(@RequestParam("email") String email) {
        AtivoDto ativoDto = ativoService.findByEmail(email);
        return ResponseEntity.ok(ativoDto);
    }

    @GetMapping(value = "/domain")
    @ApiOperation(value = "Retorna um AtivoDto")
    @ApiParam(value = "Recebe um Domain como parametro")
    @ApiResponses(value = {
            @ApiResponse(message = "Ok", code = 200),
            @ApiResponse(message = "Not Found", code = 404)
    })
    public ResponseEntity<AtivoDto> findByDomain(@RequestParam("domain") String domain) {
        AtivoDto ativoDto = ativoService.findByDomain(domain);
        return ResponseEntity.ok(ativoDto);
    }

    @PostMapping
    @ApiOperation("Insere um Ativo no Banco de Dados")
    @ApiParam("Recebe um AtivoDto pelo Body da requisicao")
    @ApiResponse(message = "Created", code = 201)
    public ResponseEntity<AtivoDto> insert(@Valid @RequestBody AtivoDto ativoDto) {
        ativoDto = ativoService.insert(ativoDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().buildAndExpand(ativoDto.getId()).toUri();
        return ResponseEntity.created(uri).body(ativoDto);
    }

    @PutMapping(value = "/{id}")
    @ApiOperation(value = "Atualiza um Ativo no Banco de Dados")
    @ApiParam("Recebe um AtivoDto pelo Body da requisicao e um Id Long pela URL")
    @ApiResponses(value = {
            @ApiResponse(message = "No content", code = 204),
            @ApiResponse(message = "Not Found", code = 404)
    })
    public ResponseEntity<AtivoDto> update(@Valid @RequestBody AtivoDto ativoDto, @PathVariable Long id) {
        ativoDto = ativoService.update(ativoDto, id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/{id}")
    @ApiOperation(value = "Deleta um Ativo do Banco de Dados")
    @ApiParam(value = "Recebe um ID Long pela URL")
    @ApiResponses(value = {
            @ApiResponse(message = "Ok", code = 200),
            @ApiResponse(message = "Not Found", code = 404)
    })
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        ativoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
