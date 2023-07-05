package adityaboss.springboot.repository;

import adityaboss.springboot.model.LiveStream;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Repository
public class LiveStreamRepository {
    List<LiveStream> streams=new ArrayList<>();

    public LiveStreamRepository() {
        streams.add(new LiveStream(UUID.randomUUID().toString(), "Building my REST API with spring boot",
                "Hi! This is my demo project", "http://hiboss/aditya",
                LocalDateTime.of(2023, 1, 7, 22, 22),
                LocalDateTime.of(2023, 1, 23, 1, 55)));
        streams.add(new LiveStream(UUID.randomUUID().toString(), "Building my REST API with spring boot",
                "Hi! This is not my demo project", "http://ghanta/aditya",
                LocalDateTime.of(2023, 1, 7, 22, 22),
                LocalDateTime.of(2023, 1, 23, 1, 55)));
    }
    public List<LiveStream> findAll() {
        return streams;
    }
    public LiveStream findById(String id) {
        return streams.stream().filter(stream -> stream.id().equals(id)).findFirst().orElseThrow(()-> new IllegalArgumentException("Stream not found"));
    }
    public LiveStream create(LiveStream stream){
        streams.add(stream);
        return stream;
    }
    public void update(LiveStream stream, String id){
        LiveStream existing= streams.stream().filter(s -> s.id().equals(id)).findFirst()
                .orElseThrow(()-> new IllegalArgumentException("Stream not found"));
        int i=streams.indexOf(existing);
        streams.set(i, stream);


    }
    public void delete(String id){
        streams.removeIf(stream -> stream.id().equals(id));
    }


    }

