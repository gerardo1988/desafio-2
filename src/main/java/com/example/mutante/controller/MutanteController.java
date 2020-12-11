package com.example.mutante.controller;

import com.example.mutante.services.MutanteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
//@RequestMapping(path = "api/v1")
public class MutanteController {

    private MutanteService mutanteService;

    public MutanteController (MutanteService mutanteService){

        this.mutanteService= mutanteService;
    }


    @PostMapping("/mutante")
    public ResponseEntity buscaMutante(/*@RequestBody*/ String[][] m){

        try{
            return ResponseEntity.status(HttpStatus.OK).body(mutanteService.buscaMutante(m));


        }catch (Exception e){

            return  ResponseEntity.status(HttpStatus.FORBIDDEN).body("{\"error\":\"no se ha encontrado un mutante.\"}");
        }

    }
}
