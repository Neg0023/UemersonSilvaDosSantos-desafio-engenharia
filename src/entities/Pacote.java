package entities;

import java.util.ArrayList;
import java.util.List;

public class Pacote{

    private Integer codigoDeOrigem;
    private Integer codigoDeDestino;
    private Integer codigoLoggi;
    private Integer codigoVendedor;
    private Integer codigoTipoProduto;

    public Pacote(Integer codigoDeOrigem, Integer codigoDeDestino, Integer codigoLoggi, Integer codigoVendedor, Integer codigoTipoProduto) {
        this.codigoDeOrigem = codigoDeOrigem;
        this.codigoDeDestino = codigoDeDestino;
        this.codigoLoggi = codigoLoggi;
        this.codigoVendedor = codigoVendedor;
        this.codigoTipoProduto = codigoTipoProduto;
    }

    public Integer getCodigoDeOrigem() {
        return codigoDeOrigem;
    }

    public void setCodigoDeOrigem(Integer codigoDeOrigem) {
        this.codigoDeOrigem = codigoDeOrigem;
    }

    public Integer getCodigoDeDestino() {
        return codigoDeDestino;
    }

    public void setCodigoDeDestino(Integer codigoDeDestino) {
        this.codigoDeDestino = codigoDeDestino;
    }

    public Integer getCodigoLoggi() {
        return codigoLoggi;
    }

    public void setCodigoLoggi(Integer codigoLoggi) {
        this.codigoLoggi = codigoLoggi;
    }

    public Integer getCodigoVendedor() {
        return codigoVendedor;
    }

    public void setCodigoVendedor(Integer codigoVendedor) {
        this.codigoVendedor = codigoVendedor;
    }

    public Integer getCodigoTipoProduto() {
        return codigoTipoProduto;
    }

    public void setCodigoTipoProduto(Integer codigoTipoProduto) {
        this.codigoTipoProduto = codigoTipoProduto;
    }

    public String regiao(Integer codigoRegiao) {
        if (codigoRegiao >= 1 && codigoRegiao <= 99) {
            return "Sudeste";
        } else if (codigoRegiao <= 199) {
            return "Sul";
        } else if (codigoRegiao >= 201 && codigoRegiao <= 299) {
            return "Centro-oeste";
        } else if (codigoRegiao <= 300) {
            return "Nordeste";
        } else if (codigoRegiao <= 499) {
            return "Norte";
        } else {
            return null;
        }
    }

    public String identificaRegiaoOrigem() {
        return regiao(getCodigoDeDestino());
    }

    public String identificaRegiaoDestino() {
        return regiao(getCodigoDeDestino());
    }

    public String validaCodigoLoggi() {

        if (codigoLoggi != 555) {
            return null;
        } else {
            return "notNull";
        }
    }

    public String identificaVendedor() {
        List<Integer> vendedoresBloqueados = new ArrayList<>();
        vendedoresBloqueados.add(555);
        if (vendedoresBloqueados.contains(codigoVendedor)) {
            return null;
        } else {
            return "notNull";
        }
    }

    public String identificaTipoProduto() {
        switch (codigoTipoProduto) {
            case 1:
                return "Jóias";
            case 111:
                return "Livros";
            case 333:
                return "Eletrônicos";
            case 555:
                return "Bebidas";
            case 888:
                return "Brinquedos";
            default:
                return null;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Código: ").append(codigoDeOrigem).append(" ").append(codigoDeDestino).append(" ").append(codigoLoggi).append(" ").append(codigoVendedor).append(" ").append(codigoTipoProduto).append("\n");
        sb.append("Região de origem: ");
        sb.append("Cidade ").append(codigoDeOrigem).append(", região ").append(identificaRegiaoOrigem()).append("\n");
        sb.append("Cidade ").append(codigoDeDestino).append(", região ").append(identificaRegiaoDestino()).append("\n");
        sb.append("Código Loggi: ").append(codigoLoggi).append("\n");
        sb.append("Código do vendedor do produto: ").append(codigoVendedor).append("\n");
        sb.append("Tipo do produto: ").append(identificaTipoProduto()).append("\n");
        return sb.toString();
    }
}
