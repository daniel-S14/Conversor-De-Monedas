package zazueta.daniel.conversor.models;

public class ConversionHistorial {
    private String monedaBase;
    private String monedaObjetivo;
    private double cantidadAConvertir;
    private double resultadoConversion;
    private String fechaYHoraDeConversion;


    public ConversionHistorial(Conversion conversion, double cantidadAConvertir, String fechaYHoraDeConversion) {
        this.monedaBase = conversion.base_code();
        this.monedaObjetivo = conversion.target_code();
        this.cantidadAConvertir = cantidadAConvertir;
        this.resultadoConversion = conversion.conversion_result();
        this.fechaYHoraDeConversion = fechaYHoraDeConversion;
    }

    public double getResultadoConversion() {
        return resultadoConversion;
    }

    public void setResultadoConversion(double resultadoConversion) {
        this.resultadoConversion = resultadoConversion;
    }

    public String getMonedaBase() {
        return monedaBase;
    }

    public void setMonedaBase(String monedaBase) {
        this.monedaBase = monedaBase;
    }

    public String getMonedaObjetivo() {
        return monedaObjetivo;
    }

    public void setMonedaObjetivo(String monedaObjetivo) {
        this.monedaObjetivo = monedaObjetivo;
    }

    public double getCantidadAConvertir() {
        return cantidadAConvertir;
    }

    public void setCantidadAConvertir(double cantidadAConvertir) {
        this.cantidadAConvertir = cantidadAConvertir;
    }

    public String getFechaYHoraDeConversion() {
        return fechaYHoraDeConversion;
    }

    public void setFechaYHoraDeConversion(String fechaYHoraDeConversion) {
        this.fechaYHoraDeConversion = fechaYHoraDeConversion;
    }
}
