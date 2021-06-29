package ru.netology.repository;


import ru.netology.domain.AfishaFilm;

public class FilmRepository {
    private AfishaFilm[] films = new AfishaFilm[0];

    public AfishaFilm[] findAll() {
        return films;
    }

    public void save(AfishaFilm film) {
        int length = films.length + 1;
        AfishaFilm[] tmp = new AfishaFilm[length];
        System.arraycopy(films, 0, tmp, 0, films.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = film;
        films = tmp;
    }

    public void removeById(int id) {
        int length = films.length - 1;
        AfishaFilm[] tmp = new AfishaFilm[length];
        int index = 0;
        for (AfishaFilm film : films) {
            if (film.getId() != id) {
                tmp[index] = film;
                index++;
            }
        }
        films = tmp;
    }

    public AfishaFilm findById(int id) {
        for (AfishaFilm film : films) {
            if (film.getId() == id) {
                return film;
            }
        }
        return null;
    }

    public void removeAll() {
        films = new AfishaFilm[0];
    }
}
