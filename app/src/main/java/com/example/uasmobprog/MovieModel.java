package com.example.uasmobprog;

public class MovieModel {
    String movieid;
    String moviename;
    String movieurl;

    public MovieModel(String movieid, String moviename, String movieurl) {
        this.movieid = movieid;
        this.moviename = moviename;
        this.movieurl = movieurl;
    }

    public MovieModel() {
    }

    public String getMovieid() {
        return movieid;
    }

    public void setMovieid(String movieid) {
        this.movieid = movieid;
    }

    public String getMoviename() {
        return moviename;
    }

    public void setMoviename(String moviename) {
        this.moviename = moviename;
    }

    public String getMovieurl() {
        return movieurl;
    }

    public void setMovieurl(String movieurl) {
        this.movieurl = movieurl;
    }
}
