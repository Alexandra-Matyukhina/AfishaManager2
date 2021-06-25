package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.AfishaFilm;
import ru.netology.manager.FilmManager;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
public class FilmManagerTestNonEmptyWithSetup {
    private FilmManager manager = new FilmManager(10);
    private AfishaFilm first = new AfishaFilm(1, 1, "first", "thriller", "url1");
    private AfishaFilm second = new AfishaFilm(2, 2, "second", "melodrama", "url2");
    private AfishaFilm third = new AfishaFilm(3, 3, "third", "comedy", "url3");
    private AfishaFilm forth = new AfishaFilm(4, 4, "forth", "thriller", "url4");
    private AfishaFilm fifth = new AfishaFilm(5, 5, "fifth", "comedy", "url5");
    private AfishaFilm sixth = new AfishaFilm(6, 8, "sixth", "melodrama", "url8");
    private AfishaFilm seventh = new AfishaFilm(7, 12, "seventh", "horror", "url12");
    private AfishaFilm eighth = new AfishaFilm(8, 6, "eighth", "cartoon", "url6");
    private AfishaFilm ninth = new AfishaFilm(9, 10, "ninth", "thriller", "url10");
    private AfishaFilm tenth = new AfishaFilm(10, 7, "tenth", "cartoon", "url7");
    private AfishaFilm eleventh = new AfishaFilm(11, 11, "eleventh", "comedy", "url11");
    private AfishaFilm twelfth = new AfishaFilm(12, 9, "twelfth", "melodrama", "url9");

    @BeforeEach
    public void setUp() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(forth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eighth);
        manager.add(ninth);
        manager.add(tenth);
        manager.add(eleventh);
        manager.add(twelfth);
    }

    @Test
    public void shouldGetAll() {
        FilmManager manager = new FilmManager();
        manager.add(first);
        manager.add(second);
        AfishaFilm[] actual = manager.getAll();
        AfishaFilm[] expected = new AfishaFilm[]{second, first};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldPostTenFilms() {
        FilmManager manager = new FilmManager();
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(forth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eighth);
        manager.add(ninth);
        manager.add(tenth);
        manager.add(eleventh);
        manager.add(twelfth);

        AfishaFilm[] actual = manager.getPostLength();
        AfishaFilm[] expected = new AfishaFilm[]{twelfth, eleventh, tenth, ninth, eighth, seventh, sixth, fifth, forth, third};
        assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldReturnSomeFilms() {
        FilmManager manager = new FilmManager(5);
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(forth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eighth);
        manager.add(ninth);
        manager.add(tenth);
        manager.add(eleventh);
        manager.add(twelfth);

        AfishaFilm[] expected = new AfishaFilm[]{twelfth, eleventh, tenth, ninth, eighth};
        AfishaFilm[] actual = manager.getPostLength();
        assertArrayEquals(expected, actual);
    }
}