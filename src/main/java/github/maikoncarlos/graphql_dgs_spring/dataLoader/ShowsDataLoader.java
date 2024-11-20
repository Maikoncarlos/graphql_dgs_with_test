package github.maikoncarlos.graphql_dgs_spring.dataLoader;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsQuery;
import org.springframework.graphql.data.method.annotation.Argument;

import java.util.List;

@DgsComponent
public class ShowsDataLoader {

    List<Show> shows = Show.showList ();

    @DgsQuery
    public List<Show> getShows(@Argument String titleFilter) {
        if (titleFilter == null) {
            return shows;
        }

        return shows.stream ()
                .filter (show -> show.title ().contains (titleFilter))
                .toList ();
    }
}
