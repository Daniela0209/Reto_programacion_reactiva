package co.com.sofka.controller;


import co.com.sofka.model.BancolombiaTarjetas;
import co.com.sofka.repository.BancolombiaRepo;
import co.com.sofka.repository.IBancololmbiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/Bancolombia")
public class BancolombiaController {


    @Autowired
    private IBancololmbiaRepository repo;

    @GetMapping(value = "alistarTodos")
    public Flux<BancolombiaTarjetas> alistarTodos(){
        Flux<BancolombiaTarjetas> flux = repo.alistarTodos();
        return flux;
    }

    @GetMapping(value = "buscarTarjeta")
    public Mono<BancolombiaTarjetas> alistarPorId(String id){
      Mono<BancolombiaTarjetas> mono = repo.alistarPorId(id);
      return mono;
    }

    @GetMapping(value = "registrar")
    public Mono<BancolombiaTarjetas>  registrarTarjetaPorId(BancolombiaTarjetas bancolombiaTarjetas){
        Mono<BancolombiaTarjetas> mono = repo.resgistrarTarjeta(bancolombiaTarjetas);
        return mono;
    }
    @PutMapping(value = "/modificar")
    public Mono<BancolombiaTarjetas> modificarTarjetas(BancolombiaTarjetas bancolombiaTarjetas){
        Mono<BancolombiaTarjetas> mono = repo.modificarTarjeta(bancolombiaTarjetas);
        return mono;
    }

    @DeleteMapping (value = "/eliminar")
    public Mono<BancolombiaTarjetas> eliminarTarjeta(String id) {
        return Mono.empty();
    }
}
