package test.binter.contador;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ContadorApplication {

    public static void main(String[] args) {
        System.out.println("Bienvenido a Test Banco internacion \n" +
                "Autor: Carlos Patricio Fuentes Cortes \n"+
                "\n" +
                "SE DEBE TENER EN CUENTA QUE SE EJECUTA CON METODOS POST:\n" +
                "/counter {POST MESSAGE}");
        SpringApplication.run(ContadorApplication.class, args);
    }

    public void run(String... args) throws Exception {

    }

}
