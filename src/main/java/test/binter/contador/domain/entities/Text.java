package test.binter.contador.domain.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Text {
    private String id;
    private String title;
    private Integer page;
    private Integer total_pages;
    private String text;
}
