package test.binter.contador.infrastructure.service;
import org.junit.Assert;
import org.junit.jupiter.api.Test;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import test.binter.contador.domain.entities.Output;
import test.binter.contador.infrastructure.controller.ContadorController;
import static org.springframework.http.RequestEntity.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@WebMvcTest(ContadorController.class)
class ContadorServiceTest {

    @Autowired
    MockMvc mvc;
    @MockBean
    ContadorService contadorService;

    @Test
    public void addEmployeeTest() throws Exception {

        Output emp = new Output();
        mvc.perform((RequestBuilder) post("/counter")
                .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }
}