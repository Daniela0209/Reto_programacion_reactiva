package co.com.sofka.repository;

import co.com.sofka.model.BancolombiaTarjetas;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BancolombiaRepo implements IBancololmbiaRepository{

    private static final Logger log = LoggerFactory.getLogger(BancolombiaRepo.class);


    @Override
    public Flux<BancolombiaTarjetas> alistarTodos() {
        List<BancolombiaTarjetas> tarjetas = new ArrayList<>();
        tarjetas.add(new BancolombiaTarjetas("1", "American Express Libre", "Disfruta de un $0 de cuota de manejo para tus compras", "0"));
        tarjetas.add(new BancolombiaTarjetas("2","Mastercard Idel","200 USD al año en seguro de protección de compras por daño accidental o hurto durante los primeros 45 días","15.390"));
        tarjetas.add(new BancolombiaTarjetas("3","Mastercard Joven","2x1 en Cine Colombia todos los días ","13.250"));
        tarjetas.add(new BancolombiaTarjetas("4","Visa Clásica"," 30% de descuento en más de 200 restaurantes con Martes Visa","6 meses a $0, si solicitas la tarjeta por internet. Despues , $23.690 mensuales"));
        tarjetas.add(new BancolombiaTarjetas("5","Mastercard Oro","Si el articulo comprado es más barato recibe reembolso por la diferencia con el seguro de protección de precio por 200 USD al año en los primeros 45 días. ","6 meses a $0 si solicitas la tarjeta por internet. Después, 27.590 mensuales"));
        return Flux.fromIterable(tarjetas);
    }

    @Override
    public Mono<BancolombiaTarjetas> alistarPorId(String id) {
        return Mono.just(new BancolombiaTarjetas("3","Mastercard Joven","2x1 en Cine Colombia todos los días ","13.250"));
    }

    @Override
    public Mono<BancolombiaTarjetas> resgistrarTarjeta(BancolombiaTarjetas bancolombiaTarjetas) {
       log.info(bancolombiaTarjetas.toString());
       return Mono.just(bancolombiaTarjetas);
    }

    @Override
    public Mono<BancolombiaTarjetas> modificarTarjeta(BancolombiaTarjetas bancolombiaTarjetas) {
        log.info(bancolombiaTarjetas.toString());
        return Mono.just(bancolombiaTarjetas);
    }

    @Override
    public Mono<BancolombiaTarjetas> eliminarTarjeta(String id) {
        return Mono.empty();
    }
}
