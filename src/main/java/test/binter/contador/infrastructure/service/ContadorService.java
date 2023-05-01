package test.binter.contador.infrastructure.service;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import test.binter.contador.domain.entities.Text;
@Service
public class ContadorService {
    public Text initPage (){

        System.out.println("ejecutando Servicio del package service.ContadorService.initPage");
        try {
            //para llamar este entorno, se realizo un entorno virtual o aislado para su ejecución.
            String uri = "http://192.168.18.183:8080/generator/word-counter/text";
            RestTemplate res = new RestTemplate();
            Text result = res.getForObject(uri, Text.class);
            System.out.println("ejecutando Servicio del package service.ContadorService.nextPage");
            for (int i = 1; i <= result.getTotal_pages(); i++) {
                Text result_page = nextPage(Integer.parseInt(result.getId()), i);
                result.setText(result.getText().toLowerCase()+" "+result_page.getText().toLowerCase());
            }
            return result;
        }catch (RuntimeException re) {
            throw new IllegalArgumentException("File not found");
        }
    }
    public Text nextPage(int id, int page){
        try {
        String uri = "http://192.168.18.183:8080/generator/word-counter/text?id="+id+"&&page="+page;
        RestTemplate res = new RestTemplate();
        Text result = res.getForObject(uri, Text.class);
        return result;
        }catch (RuntimeException re) {
            throw new IllegalArgumentException("File not found");
        }
    }
}
