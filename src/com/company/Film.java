package com.company;

import java.util.Objects;

public class Film implements Comparable<Film> {

    String titol, any, original, direccio, interprets, sinopsi, idioma;

    public Film(String titol,String any, String original, String direccio, String interprets, String sinopsi, String idioma) {
        this.any = any;
        this.titol = titol;
        this.original = original;
        this.direccio = direccio;
        this.interprets = interprets;
        this.sinopsi = sinopsi;
        this.idioma = idioma;
    }

    public String getAny() {
        return any;
    }

    public String getTitol() {
        return titol;
    }

    public String getOriginal() {
        return original;
    }

    public String getDireccio() {
        return direccio;
    }

    public String getSinopsi() {
        return sinopsi;
    }

    public String getInterprets() {
        return interprets;
    }

    public String getIdioma() {
        return idioma;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Film film = (Film) o;
        return idioma.equals(film.idioma);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idioma);
    }

    @Override
    public String toString() {
        return "Film{" +
                "titol='" + titol + '\'' +
                ", any='" + any + '\'' +
                ", original='" + original + '\'' +
                ", direccio='" + direccio + '\'' +
                ", interprets='" + interprets + '\'' +
                ", sinopsi='" + sinopsi + '\'' +
                ", idioma='" + idioma + '\'' +
                '}';
    }

    @Override
    public int compareTo(Film film) {
        return this.titol.compareTo(film.titol);
    }
}
