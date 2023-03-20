package ejfecjhonar;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Locale;

/**
 *
 * @author Jhoel Alexander Narváez Valarezo
 */
public class EjFecJhoNar {

    public static void main(String[] args) {
        LocalDate BornDate = LocalDate.of(2000, Month.NOVEMBER, 3);
        
        System.out.println("\nUSO DEL METODO NOW()\n");
        
        System.out.println("La fecha actual es: " + LocalDate.now());
        System.out.println("La hora actual es: " + LocalTime.now());
        System.out.println("La fecha y hora actual son: " + LocalDateTime.now());
        System.out.println("El instante actual es: " + Instant.now());
        System.out.println("La fecha y hora actuales con zona horaroa son: " + ZonedDateTime.now());

        System.out.println("\nUSO DEL METODO OF()\n");

        System.out.println("Fecha de mi cumpleaños: " + LocalDate.of(2000, Month.NOVEMBER, 3));
        System.out.println("Con la hora exacta: " + LocalDateTime.of(2000,
                Month.NOVEMBER, 3, 20, 06, 35, 0000));
        
        
        System.out.println("\nSUMA Y RESTA DE PERIODOS DE TIEMPO\n");
        
        System.out.println("La fecha dentro de 10 dias: " + LocalDate.now().plusDays(10));
        System.out.println("La fecha y hora de hace 32 horas: "+ LocalDateTime.now().minusHours(32));

        System.out.println("\nUSO DE AJUSTADORES\n");

        System.out.println("El primer día del próximo mes es: "
                + LocalDate.now().with(TemporalAdjusters.firstDayOfNextMonth()).getDayOfWeek());
        System.out.println("El último día de este mes es: "
                + LocalDate.now().with(TemporalAdjusters.lastDayOfMonth()));
        
        System.out.println("\nINTERVALOS DE TIEMPO\n");

        System.out.println("Tu edad es de " + ChronoUnit.YEARS.between(BornDate, LocalDate.now())+ " años.");

        LocalDate hoy = LocalDate.now();
        LocalDate finDeAnio = hoy.with(TemporalAdjusters.lastDayOfYear());

        Period hastaFinDeAnio = hoy.until(finDeAnio);
        int meses = hastaFinDeAnio.getMonths();
        int dias = hastaFinDeAnio.getDays();
        System.out.println("Faltan " + meses + " meses y " + dias + " días hasta final de año.");

        System.out.println("\nPARSEADO DE FECHAS\n");
        
        LocalDate tresNov = LocalDate.parse("3/11/2000", DateTimeFormatter.ofPattern("d/M/yyyy"));

        System.out.println("Fecha parseada: " + tresNov);
        System.out.println("Dia de la semana de la fecha parseada: " + tresNov.getDayOfWeek());
        System.out.println("\nFORMATO PERSONALIZADO DE CONVERSION A TEXTO\n");
        LocalDateTime fechaConHora = LocalDateTime.now();
        System.out.println("Formato por defecto: " + fechaConHora);

        System.out.println(
                "Formato ISO 8601 (explícito): " + fechaConHora.format(DateTimeFormatter.ISO_DATE_TIME));
        DateTimeFormatter esDateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss");
        System.out.println("Formato español (manual): "+ fechaConHora.format(esDateFormat));

       
        DateTimeFormatter esDateFormatLargo= 
                         DateTimeFormatter.ofPattern("EEEE, dd 'de' MMMM 'de' yyyy 'a las' hh:mm:ss")
                        .withLocale(new Locale("es", "ES"));
        System.out.println("Formato español (largo, localizado): "+ fechaConHora.format(esDateFormatLargo));

        String idiomaLocal = System.getProperty("user.language");
        String paisLocal = System.getProperty("user.country");
        System.out.println("Formato actual del sistema (" + idiomaLocal + "-"+ paisLocal + "): "
                + fechaConHora.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT)
                                .withLocale(new Locale(idiomaLocal, paisLocal))));


    }

}
