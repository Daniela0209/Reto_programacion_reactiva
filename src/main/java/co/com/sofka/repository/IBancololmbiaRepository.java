package co.com.sofka.repository;


import co.com.sofka.model.BancolombiaTarjetas;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


public interface IBancololmbiaRepository {

    Flux<BancolombiaTarjetas> alistarTodos();
    Mono<BancolombiaTarjetas> alistarPorId(String id);
    Mono<BancolombiaTarjetas> resgistrarTarjeta(BancolombiaTarjetas bancolombiaTarjetas);
    Mono<BancolombiaTarjetas> modificarTarjeta(BancolombiaTarjetas bancolombiaTarjetas);
    Mono<BancolombiaTarjetas> eliminarTarjeta(String id);

}
