package sg.edu.nus.iss.day28workshop.model;

import java.util.List;

public record Pokemon(Integer id, String name, String image, List<String> type, Object stats) {
    
}
