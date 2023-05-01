package test.binter.contador.infrastructure.constants;

import test.binter.contador.domain.entities.Output;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class CrearMapa {

    public Map<String, Integer> Maps (String[] palabras){

        HashMap<String, Integer> mapaDeFrecuencias = new HashMap<>();
        for (String palabra : palabras) {
            if (mapaDeFrecuencias.containsKey(palabra)) {
                mapaDeFrecuencias.put(palabra, mapaDeFrecuencias.get(palabra) + 1);
            } else {
                mapaDeFrecuencias.put(palabra, 1);
            }
        }
        //los ordena de manera decendente
        final Map<String, Integer> sortedByCount = mapaDeFrecuencias.entrySet()
                .stream()
                .sorted((Map.Entry.<String, Integer>comparingByValue().reversed()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        return sortedByCount;
    }
}
