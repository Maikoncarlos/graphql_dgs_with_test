package github.maikoncarlos.graphql_dgs_spring.dataLoader;

import java.util.List;

public record Show(String title, Integer releaseYear) {
    public static List<Show> showList() {
        return List.of (
                new Show ("Stranger Things", 2016),
                new Show ("Ozark", 2017),
                new Show ("The Crown", 2016),
                new Show ("Dead to Me", 2019),
                new Show ("Orange is the New Black", 2013));
    }
}
