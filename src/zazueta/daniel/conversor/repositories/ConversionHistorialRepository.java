package zazueta.daniel.conversor.repositories;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import zazueta.daniel.conversor.models.ConversionHistorial;


import java.awt.*;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class ConversionHistorialRepository {

    public void agregarConversion(List<ConversionHistorial> conversionHistorialList, String nombreDeArchivo) {
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();
        Path rutaDelArchivo  = crearRutaDelArchivo(nombreDeArchivo);

        if (existeArchivo(rutaDelArchivo)) {
            try {
                String content = new String(Files.readAllBytes(rutaDelArchivo));
                Type listType = new TypeToken<List<ConversionHistorial>>() {
                }.getType();
                List<ConversionHistorial> conversionesExistentes = gson.fromJson(content, listType);
                conversionesExistentes.addAll(conversionHistorialList);
                Files.write(rutaDelArchivo, gson.toJson(conversionesExistentes).getBytes(),
                        StandardOpenOption.TRUNCATE_EXISTING);
            } catch (IOException e) {
                System.err.println("Error al agregar contenido al archivo: " + e.getMessage());
            }
        } else {
            try {
                Files.write(rutaDelArchivo, gson.toJson(conversionHistorialList).getBytes(),
                        StandardOpenOption.CREATE_NEW);
            } catch (IOException e) {
                System.err.println("Error al crear o guardar el archivo del historial de conversiones: "
                        + e.getMessage());
            }
        }

    }

    public void abrirArchivo(Path rutaDelArchivo){

        if (Desktop.isDesktopSupported()) {
            try {
                Desktop.getDesktop().open(rutaDelArchivo.toFile());
            } catch (IOException e) {
                System.err.println("Error al abrir el archivo: " + e.getMessage());
            }
        } else {
            System.err.println("Desktop no soportado");
        }
    }

    public boolean existeArchivo(Path rutaDelArchivo){
        return Files.exists(rutaDelArchivo);
    }

    public boolean contieneDatos(Path rutaDelArchivo){
        boolean contieneDatos = false;
        try {
            contieneDatos = Files.size(rutaDelArchivo) > 0;
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return contieneDatos;
    }

    public Path crearRutaDelArchivo(String nombreDelArchivo){
        Path proyectoRaiz = Paths.get("").toAbsolutePath();
        return proyectoRaiz.resolve(nombreDelArchivo);
    }


}
