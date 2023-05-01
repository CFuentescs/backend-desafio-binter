package test.binter.contador.infrastructure.controller;

import org.apache.tomcat.util.json.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import test.binter.contador.domain.entities.Text;
import test.binter.contador.domain.entities.Output;
import test.binter.contador.domain.entities.Ranking;
import test.binter.contador.infrastructure.service.ContadorService;
import java.util.*;
import java.util.stream.Collectors;
import test.binter.contador.infrastructure.constants.Salida;
import test.binter.contador.infrastructure.constants.CrearMapa;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
@RequestMapping("/counter")
public class ContadorController {
    @PostMapping
    public ResponseEntity<?>  getNearbyByCoordinates(){
        try{
            ContadorService ser = new ContadorService();
            Salida salida = new Salida();
            CrearMapa mapeo = new CrearMapa();
            Text res = ser.initPage();
            //limpia el texto
            String text = res.getText().replaceAll("[!\\\"#$%&'()*+,-./:;<=>?@\\\\[\\\\]^_`{|}~]", "");
            String[] palabras = text.split(" ");
            // Crea mapa y realiza el conteo
            Map<String, Integer> sortedByCount = mapeo.Maps(palabras);
            Output out = salida.llenado(sortedByCount, res);
            return ResponseEntity.ok(out);
        }catch (RuntimeException e){
            return (ResponseEntity<?>) ResponseEntity.internalServerError();
        }

    }

    @ExceptionHandler(NoSuchElementFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<String> handleNoSuchElementFoundException(
            NoSuchElementFoundException exception
    ) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(exception.getMessage());
    }
}
