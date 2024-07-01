package zazueta.daniel.conversor.services;

import zazueta.daniel.conversor.models.Conversion;
import zazueta.daniel.conversor.repositories.ConversionRepository;

public class ConversionService {


    public Conversion obtenerConversion(String base_code, String target_code, double amount){
        ConversionRepository conversionRepository = new ConversionRepository();
        Conversion conversion;
        conversion = conversionRepository.obtenerConversion(base_code, target_code, amount);
        return conversion;
    }

}
