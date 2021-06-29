package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.AfishaFilm;

import static org.junit.jupiter.api.Assertions.*;

public class FilmRepositoryTest {
    private FilmRepository filmRepository = new FilmRepository();
    private AfishaFilm first = new AfishaFilm(1, 1, "first", "thriller", "url1");
    private AfishaFilm second = new AfishaFilm(2, 2, "second", "melodrama", "url2");
    private AfishaFilm third = new AfishaFilm(3, 3, "third", "comedy", "url3");

    @BeforeEach
    public void setUp() {
        filmRepository.save(first);
        filmRepository.save(second);
        filmRepository.save(third);
    }

    @Test
    public void findAll() {
        AfishaFilm[] actual = filmRepository.findAll();
        AfishaFilm[] expected = new AfishaFilm[]{first, second, third};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindById() {
        int findId = 2;
        AfishaFilm actual = filmRepository.findById(findId);
        assertEquals(second, actual);
    }

    @Test
    public void shouldFindByIdIfNotExists() {
        int findId = 4;
        AfishaFilm actual = filmRepository.findById(findId);
        assertNull(actual);
    }

    @Test
    public void shouldRemoveById() {
        int idToRemove = 2;
        filmRepository.removeById(idToRemove);
        AfishaFilm[] actual = filmRepository.findAll();
        AfishaFilm[] expected = new AfishaFilm[]{first, third};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveAll() {
        filmRepository.removeAll();
        AfishaFilm[] actual = filmRepository.findAll();
        AfishaFilm[] expected = new AfishaFilm[0];
        assertArrayEquals(expected, actual);
    }
}
