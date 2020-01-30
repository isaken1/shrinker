package shrinker.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import shrinker.domain.URL;

import java.io.Serializable;
import java.util.Date;

public class UrlDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private Date dtCriacao;
    private String urlOriginal;
    private String urlEncurtada;

    public UrlDTO() {}

    public UrlDTO(URL url) {
        this.urlOriginal = url.getUrlOriginal();
        this.urlEncurtada = url.getUrlEncurtada();
        this.dtCriacao = url.getDataCriacao();
    }

    public String getUrlOriginal() {
        return urlOriginal;
    }

    public void setUrlOriginal(String urlOriginal) {
        this.urlOriginal = urlOriginal;
    }

    public String getUrlEncurtada() {
        return urlEncurtada;
    }

    public void setUrlEncurtada(String urlEncurtada) {
        this.urlEncurtada = urlEncurtada;
    }

    public Date getDtCriacao() {
        return dtCriacao;
    }

    public void setDtCriacao(Date dtCriacao) {
        this.dtCriacao = dtCriacao;
    }
}
