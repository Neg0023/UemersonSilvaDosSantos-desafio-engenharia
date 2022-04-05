package entities;

public class Pacote implements Comparable<Pacote>{
    private final String codigoDeBarras;
    private String origem;
    private Integer codOrigem;
    private String destino;
    private Integer codDestino;
    private String codigoLoggi;
    private String codigoVendedor;
    private String tipoProduto;
    private Boolean validacao;
    private Integer quantidade = 1;

    public Pacote(String codigoDeBarras, String origem, Integer codOrigem, String destino, Integer codDestino, String codigoLoggi, String codigoVendedor, String tipoProduto) {
        this.codigoDeBarras = codigoDeBarras;
        this.origem = origem;
        this.destino = destino;
        this.codigoLoggi = codigoLoggi;
        this.codigoVendedor = codigoVendedor;
        this.tipoProduto = tipoProduto;
        this.codOrigem = codOrigem;
        this.codDestino = codDestino;
    }

    public String getCodigoDeBarras() {
        return codigoDeBarras;
    }

    public String getOrigem() {
        return origem;
    }

    public Integer getCodOrigem() {
        return codOrigem;
    }

    public String getDestino() {
        return destino;
    }

    public Integer getCodDestino() {
        return codDestino;
    }

    public String getCodigoLoggi() {
        return codigoLoggi;
    }

    public String getCodigoVendedor() {
        return codigoVendedor;
    }

    public String getTipoProduto() {
        return tipoProduto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public Boolean getValidacao() {
        return validacao;
    }

    public void identificaCodigoTipoProduto(String tipoProduto) {
        switch (tipoProduto) {
            case "001":
                this.tipoProduto = "Joias";
                break;
            case "111":
                this.tipoProduto = "Livros";
                break;
            case "333":
                this.tipoProduto = "Eletronicos";
                break;
            case "555":
                this.tipoProduto = "Bebidas";
                break;
            case "888":
                this.tipoProduto = "Brinquedos";
                break;
            default:
                this.tipoProduto = null;
        }
    }

    public void identificaCodigoVendedor(String codigoVendedor) {
        String vendedorBloqueado = "367";
        if (codigoVendedor.equals(vendedorBloqueado)) {
            this.codigoVendedor = null;
        }
    }

    public void identificaCodigoLoggi(String codigoLoggi) {
        if (!(codigoLoggi.equals("555"))) {
            this.codigoLoggi = null;
        }
    }

    public void identificaCodigoDestino(String destino) {
        int destinoInt = Integer.parseInt(destino) ;
        if ((destinoInt >= 201) && (destinoInt <= 299)) {
           this.destino = "região Centro-oeste";
        } else if ((destinoInt >= 300) && (destinoInt <= 399)) {
            this.destino = "região Nordeste";
        } else if ((destinoInt >= 400) && (destinoInt <= 499)) {
            this.destino = "região Norte";
        } else if ((destinoInt >= 1) && (destinoInt <= 99)) {
            this.destino = "região Sudeste";
        } else if ((destinoInt >= 100) && (destinoInt <= 199)) {
            this.destino = "região Sul";
        } else {
            this.destino = null;
        }
    }

    public void identificaCodigoOrigem(String origem) {
        int oringemInt = Integer.parseInt(origem) ;
        if ((oringemInt >= 201) && (oringemInt <= 299)) {
            this.origem = "região Centro-oeste";
        } else if ((oringemInt >= 300) && (oringemInt <= 399)) {
            this.origem = "região Nordeste";
        } else if ((oringemInt >= 400) && (oringemInt <= 499)) {
            this.origem = "região Norte";
        } else if ((oringemInt >= 1) && (oringemInt <= 99)) {
            this.origem = "região Sudeste";
        } else if ((oringemInt >= 100) && (oringemInt <= 199)) {
            this.origem = "região Sul";
        } else {
            this.origem = null;
        }
    }

    public void restricao(){
        validacao = origem != null && destino != null && codigoLoggi != null && codigoVendedor != null && codigoVendedor != null && tipoProduto != null && (!origem.equals("região Centro-oeste") || (!tipoProduto.equals("Joias")));
    }

    public String toString() {
        return "Código: " + codigoDeBarras + "\nRegião de origem: " + origem + "\nRegião de destino: " + destino
                + "\nCodigo Loggi: " + codigoLoggi + "\nCodigo do vendedor do produto: " + codigoVendedor
                + "\nTipo do produto: " + tipoProduto;
    }

    @Override
    public int compareTo(Pacote oPacote) {
        return (oPacote.getCodDestino() - this.codDestino);
    }
}
