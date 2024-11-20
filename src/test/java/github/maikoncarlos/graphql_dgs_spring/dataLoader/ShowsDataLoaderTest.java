package github.maikoncarlos.graphql_dgs_spring.dataLoader;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ShowsDataLoaderTest {

    private ShowsDataLoader showsDataLoaderUnderTest;

    @BeforeEach
    void setUp() {
        showsDataLoaderUnderTest = new ShowsDataLoader();
    }

    @Test
    void testGetShows_TitleOzark() {
        // Setup
        final List<Show> expectedResult = List.of(new Show("Ozark", 2017));

        // Run the test
        final List<Show> result = showsDataLoaderUnderTest.getShows("Ozark");

        // Verify the results
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void testGetShows_Empty() {
        // Setup
        final List<Show> expectedResult = Show.showList();

        // Run the test
        final List<Show> result = showsDataLoaderUnderTest.getShows(null);

        // Verify the results
        assertThat(result).isEqualTo(expectedResult);
    }
}
