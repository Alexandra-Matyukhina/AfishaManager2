package ru.netology.manager;

import ru.netology.domain.AfishaFilm;

public class FilmManager {
    private AfishaFilm[] films = new AfishaFilm[0];
    private int postLenght = 10;

    public FilmManager(int postLenght) {
        this.postLenght = postLenght;
    }

    public FilmManager() {
    }

    public void add(AfishaFilm film) {
        // создаём новый массив размером на единицу больше
        int length = films.length + 1;
        AfishaFilm[] tmp = new AfishaFilm[length];
        // itar + tab
        // копируем поэлементно
        // for (int i = 0; i < items.length; i++) {
        //   tmp[i] = items[i];
        // }
        System.arraycopy(films, 0, tmp, 0, films.length);
        // кладём последним наш элемент
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = film;
        films = tmp;
    }

    public AfishaFilm[] getAll() {
        AfishaFilm[] result = new AfishaFilm[films.length];
        // перебираем массив в прямом порядке
        // но кладём в результаты в обратном
        for (int i = 0; i < result.length; i++) {
            int index = films.length - i - 1;
            result[i] = films[index];
        }
        return result;
    }

    public AfishaFilm[] getPostLength() {
        int resultLength = Math.min(postLenght, films.length);

        AfishaFilm[] post = new AfishaFilm[resultLength];
        // перебираем массив в прямом порядке
        // но кладём в результаты в обратном
        for (int i = 0; i < resultLength; i++) {
            int index = films.length - i - 1;
            post[i] = films[index];
        }
        return post;
    }


}