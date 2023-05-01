package test.binter.contador.infrastructure.constants;

import test.binter.contador.domain.entities.Output;
import test.binter.contador.domain.entities.Ranking;
import test.binter.contador.domain.entities.Text;

import java.util.ArrayList;
import java.util.Map;

public class Salida {
    public Output llenado(Map<String, Integer> ranking, Text rank){

        ArrayList al = new ArrayList();
        Output salida = new Output();

        salida.setId(rank.getId());
        salida.setTitle(rank.getTitle());
        int count = 1;
        for (Map.Entry<String, Integer> entry : ranking.entrySet()) {
            Ranking rak = new Ranking();
            rak.setPosition(count);
            rak.setWord(entry.getKey());
            rak.setOcurrences(String.valueOf(entry.getValue()));
            al.add(rak);
            count ++;
        }
        salida.setRanking(al);
        return salida;
    }
}
