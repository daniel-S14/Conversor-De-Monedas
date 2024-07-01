package zazueta.daniel.conversor.controllers;

import zazueta.daniel.conversor.models.Conversion;
import zazueta.daniel.conversor.models.ConversionHistorial;
import zazueta.daniel.conversor.services.ConversionHistorialService;
import zazueta.daniel.conversor.services.ConversionService;

import java.util.List;

public class ConversionController {

    public ConversionController(){}

    public Conversion obtenerConversion(String base_code, String target_code, double ammount){
        ConversionService conversionService = new ConversionService();
        return conversionService.obtenerConversion(
                base_code,
                target_code,
                ammount);

    }

    public void guardarConversiones(List<ConversionHistorial> conversionHistorialList){
        ConversionHistorialService conversionHistorialService = new ConversionHistorialService();
        conversionHistorialService.guardarConversiones(conversionHistorialList);

    }

    public void abrirHistorial(){
        ConversionHistorialService conversionService = new ConversionHistorialService();
        conversionService.abrirHistorial();

    }
}
