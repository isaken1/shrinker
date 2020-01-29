package shrinker.domain.enums;

public enum PerfisUsuario {

    USER(1, "ROLE_USUARIO");

    private int cod;
    private String descricao;

    private PerfisUsuario(int cod, String descricao) {
        this.cod = cod;
        this.descricao = descricao;
    }

    public int getCod() {
        return cod;
    }

    public String getDescricao() {
        return descricao;
    }

    public static PerfisUsuario toEnum(Integer cod) {
        if (cod == null) {
            return null;
        }

        for (PerfisUsuario x : PerfisUsuario.values()) {
            if (cod.equals(x.getCod())) {
                return x;
            }
        }

        throw new IllegalArgumentException("Id inválido: " + cod);
    }


}
