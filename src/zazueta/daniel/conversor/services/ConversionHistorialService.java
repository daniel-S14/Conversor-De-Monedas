package zazueta.daniel.conversor.services;

import zazueta.daniel.conversor.models.ConversionHistorial;
import zazueta.daniel.conversor.repositories.ConversionHistorialRepository;

import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class ConversionHistorialService {

    public void guardarConversiones(List<ConversionHistorial> conversionHistorialList){

        ConversionHistorialRepository conversionHistorialRepository = new ConversionHistorialRepository();
        String fechaActual = obtenerFechaActual();
        String nombreDeArchivo = crearNombreDeArchivo(fechaActual);
        conversionHistorialRepository.agregarConversion(conversionHistorialList, nombreDeArchivo);

    }

    public static String obtenerFechaActual(){
        LocalDate hoy = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return hoy.format(formatter);
    }

    public static String crearNombreDeArchivo(String fecha){
        return "Conversiones_"+ fecha + ".json";
    }

    public void abrirHistorial(){
        ConversionHistorialRepository conversionHistorialRepository = new ConversionHistorialRepository();
        String fechaActual = obtenerFechaActual();
        String nombreDelArchivo = crearNombreDeArchivo(fechaActual);
        Path rutaDelArchivo = conversionHistorialRepository.crearRutaDelArchivo(nombreDelArchivo);
        if(conversionHistorialRepository.existeArchivo(rutaDelArchivo)){
            if (conversionHistorialRepository.contieneDatos(rutaDelArchivo)){
                conversionHistorialRepository.abrirArchivo(rutaDelArchivo);
            }
        }else {
            System.out.println("No hay historial de conversiones");
        }
    }

}
