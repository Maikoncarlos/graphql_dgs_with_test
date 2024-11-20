package github.maikoncarlos.graphql_dgs_spring.dataLoader;

import com.netflix.graphql.dgs.DgsQueryExecutor;
import com.netflix.graphql.dgs.test.EnableDgsTest;
import org.intellij.lang.annotations.Language;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest(classes = {ShowsDataLoader.class})
@EnableDgsTest
class ShowsDataLoaderDGSTest {

    @Autowired
    DgsQueryExecutor dgsQueryExecutor;

    @Language("GraphQL")
    String queryOzark = "query MyQuery {getShows(titleFilter: \"Ozark\") {releaseYear   title }}";
    @Language("GraphQL")
    String queryAll = "query MyQuery {getShows {releaseYear   title }}";

    @Test
    void getShowsOzark() {
        var title = dgsQueryExecutor.
                executeAndExtractJsonPath (queryOzark, "data.getShows[*].title");

        assertEquals (List.of ("Ozark"), title);
    }

    @Test
    void getShowsAll() {
        List<String> titles = dgsQueryExecutor.
                executeAndExtractJsonPath (queryAll, "data.getShows[*].title");

        assertThat (titles).contains ("The Crown");
    }
}
