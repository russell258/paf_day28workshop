package sg.edu.nus.iss.day28workshop.repository;

import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
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

    public List<Document> getPokemonByType(String type){
        //create filter
        Criteria criteria = Criteria.where("type").regex(type,"i");

        //create query
        Query query = Query.query(criteria)
                            .with(Sort.by(Direction.ASC,"name"));

        //perform projection
        query.fields().exclude("_id").include("id","name","image","type","stats");
        
        return template.find(query,Document.class,"pokemon");
    }

}
