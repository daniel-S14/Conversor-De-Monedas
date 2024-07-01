package zazueta.daniel.conversor.models;

public enum Codigos {
    MXN("Peso mexicano"),
    RUB("Rublo ruso"),
    USD("Dolar estadounidense"),
    BRL("Real brazileño"),
    ARS("Peso argentino"),
    JPY("Yen japonés");

    private final String currency;

    Codigos(String currency){
        this.currency = currency;
    }

    public String getCurrency(){
        return currency;
    }

}
