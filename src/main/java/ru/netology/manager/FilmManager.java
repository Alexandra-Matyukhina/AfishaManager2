package ru.netology.manager;

import ru.netology.domain.AfishaFilm;
import ru.netology.repository.FilmRepository;

public class FilmManager {
    private FilmRepository repository;
    private int postLenght = 10;

    public FilmManager(FilmRepository repository) {
        this.repository = repository;
    }

    public FilmManager() {
    }

    public void add(AfishaFilm film) {
        repository.save(film);
    }

    public AfishaFilm[] getAll() {
        AfishaFilm[] films = repository.findAll();
        int resultLength = Math.min(postLenght, films.length);
        AfishaFilm[] result = new AfishaFilm[resultLength];
        for (int i = 0; i < result.length; i++) {
            int index = films.length - i - 1;
            result[i] = films[index];
        }
        return result;
    }

    public AfishaFilm[] showAll() {
        return repository.findAll();
    }


}