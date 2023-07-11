package sg.edu.nus.iss.day28workshop.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class PokemonRepository {
    
    @Autowired
    private MongoTemplate template;

    /*
	 db.pokemon.distinct('type')
	 */
    public List<String> getAllTypes(){
        return template.findDistinct(new Query(), "type", "pokemon", String.class);
    }



}
