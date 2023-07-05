package adityaboss.springboot.controller;

import adityaboss.springboot.model.LiveStream;
import adityaboss.springboot.repository.LiveStreamRepository;
import jakarta.validation.constraints.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static java.net.Proxy.Type.HTTP;

@RestController
@RequestMapping("/streams")
public class LiveStreamController {

    private final LiveStreamRepository repository;

    public LiveStreamController(LiveStreamRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<LiveStream> findAll()
    {
        return repository.findAll();
    }
@GetMapping("/{id}")
    public LiveStream findById(@PathVariable String id){
        return repository.findById(id);
    }
@ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public LiveStream create(LiveStream stream){
        return repository.create(stream);
    }

}
