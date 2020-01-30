package shrinker.dto;


import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

public class NewUrlDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotEmpty(message = "Campo obrigatório.")
    private String urlOriginal;

    public String getUrlOriginal() {
        return urlOriginal;
    }

    public void setUrlOriginal(String urlOriginal) {
        this.urlOriginal = urlOriginal;
    }
}
