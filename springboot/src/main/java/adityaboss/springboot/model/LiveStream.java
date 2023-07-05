package adityaboss.springboot.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record LiveStream( String id, String title,
         String description,
         String url,
         LocalDateTime startDate,
         LocalDateTime endDate) {


}
