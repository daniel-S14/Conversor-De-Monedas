package zazueta.daniel.conversor.controllers;

import zazueta.daniel.conversor.models.Codigos;
import zazueta.daniel.conversor.models.Conversion;
import zazueta.daniel.conversor.models.ConversionHistorial;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuController {

    private ConversionController conversionController = new ConversionController();
    private Codigos monedaBase, monedaObjetivo;
    private Conversion conversion;
    private Scanner scanner = new Scanner(System.in);
    private int opcion;
    private double cantidadAConvertir;
    private List<ConversionHistorial> conversionHistorialList = new ArrayList<>();

    public void ejecutar(){
        do {
            mostrarMenu("Seleccione moneda base: ");
            opcion = capturarOpcion();
            if (opcion != 0) {
                monedaBase = seleccionarMoneda(opcion);
                mostrarMenu("Seleccione moneda objetivo: ");
                opcion = capturarOpcion();
                if (opcion != 0) {
                    monedaObjetivo = seleccionarMoneda(opcion);
                    cantidadAConvertir = capturarMonto();
                    conversion = conversionController.obtenerConversion(monedaBase.name(),
                            monedaObjetivo.name(), cantidadAConvertir);
                    System.out.println("El resultado de convertr " + cantidadAConvertir + " "
                            + monedaBase + "(" + monedaBase.getCurrency() + ")"
                            + " es: "
                            + conversion.conversion_result() + " " + monedaObjetivo
                            + "(" + monedaObjetivo.getCurrency() + ")");
                    String fechaHoraConversion = obtenerFechaDeConversion();

                    ConversionHistorial conversionHistorial = new ConversionHistorial(conversion,
                            cantidadAConvertir, fechaHoraConversion);
                    conversionHistorialList.add(conversionHistorial);
                    System.out.println("Si desea realizar una conversión más ingrese 1 sino ingrese 0");
                    int opcion = scanner.nextInt();
                    if (opcion == 0){
                        salir();
                        break;
                    }

                }else {
                   salir();
                }
            } else {
                salir();
            }

        } while (opcion != 0);

        scanner.close();
    }

    public void mostrarMenu(String mensaje) {
        StringBuilder menu = new StringBuilder("""
                +------------------------------------------------+
                |               Menú de Opciones                 |
                +------------------------------------------------+
                """);
        int numero = 1;
        for (Codigos moneda : Codigos.values()) {
            menu.append("| ").append(numero).append(". ").append(moneda.getCurrency()).append("\n");
            numero++;
        }
        menu.append("""
                | 0. Salir                                       |
                +------------------------------------------------+
                """).append(mensaje);
        System.out.println(menu);
    }

    public boolean validarOpcion(int opcion) {
        return (opcion >= 0 && opcion <= Codigos.values().length);
    }

    public Codigos seleccionarMoneda(int opcion) {
        Codigos moneda;
        Codigos[] codigos = Codigos.values();
        moneda = codigos[opcion - 1];
        return moneda;
    }

    public int capturarOpcion() {
        Scanner scanner = new Scanner(System.in);
        String opcionCadena;
        int opcionEntero;
        while (true) {
            opcionCadena = scanner.nextLine();
            if (!contieneEspacio(opcionCadena)) {
                try {
                    opcionEntero = Integer.parseInt(opcionCadena);
                    if (validarOpcion(opcionEntero)) break;
                    else System.out.println("Seleccione una opcion válida");
                } catch (NumberFormatException e) {
                    System.out.println("Sólo números. Por favor, ingrese una opción válida");
                }
            }else {
                System.out.println("No ingrese espacios. Por favor");
            }
        }
        return opcionEntero;
    }

    boolean contieneEspacio(String entrada) {
        return entrada.contains(" ");
    }

    public double capturarMonto() {
        Scanner scanner = new Scanner(System.in);
        double montoCadena;
        double monto;
        System.out.println("Ingrese la cantidad a convertir");
        while (true) {
            if (scanner.hasNextDouble()) {
                monto = scanner.nextDouble();
                break;
            } else {
                System.out.println("Ingrese solo números decimales, intentelo de nuevo");
                scanner.next();
            }
        }
        return monto;
    }

    public String obtenerFechaDeConversion(){
        String fecha;
        LocalDateTime fechaHoraActual = LocalDateTime.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        fecha = fechaHoraActual.format(formato);
        return fecha;
    }

    public void salir(){
        if(!conversionHistorialList.isEmpty()) conversionController.guardarConversiones(conversionHistorialList);
        System.out.println("Si desea ver el historial ingrese 1 sino ingrese 0");
        int historial = scanner.nextInt();
        if (historial == 1){
            conversionController.abrirHistorial();
        }
        System.out.println("Saliendo del programa...");
    }

}
