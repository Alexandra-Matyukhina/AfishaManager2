package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.domain.AfishaFilm;
import ru.netology.repository.FilmRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
class FilmManagerTest {
    @Mock
    private FilmRepository filmRepository;
    @InjectMocks
    FilmManager manager;
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
    public void GetAll() {
        // настройка заглушки
        AfishaFilm[] returned = new AfishaFilm[]{first, second, third};
        doReturn(returned).when(filmRepository).findAll();

        AfishaFilm[] expected = new AfishaFilm[]{first, second, third};
        AfishaFilm[] actual = manager.showAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void showAll() {
        AfishaFilm[] returned = new AfishaFilm[]{first, second, third};
        doReturn(returned).when(filmRepository).findAll();
        // вывод в прямом порядке
        AfishaFilm[] expected = new AfishaFilm[]{first, second, third};
        AfishaFilm[] actual = manager.showAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void getNumberedLastAdded() {
        AfishaFilm[] returned = new AfishaFilm[]{first, second, third, forth, fifth, sixth, seventh, eighth, ninth, tenth, eleventh, twelfth};
        doReturn(returned).when(filmRepository).findAll();
        // вывод 10 фильмов из 12 в обратном порядке
        AfishaFilm[] expected = new AfishaFilm[]{twelfth, eleventh, tenth, ninth, eighth, seventh, sixth, fifth, forth, third};
        AfishaFilm[] actual = manager.getAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void add() {
        AfishaFilm[] returned = new AfishaFilm[]{first, second, third};
        doReturn(returned).when(filmRepository).findAll();
        doNothing().when(filmRepository).save(third);
        manager.add(third);
        AfishaFilm[] expected = new AfishaFilm[]{third, second, first};
        AfishaFilm[] actual = manager.getAll();
        assertArrayEquals(expected, actual);
    }
}