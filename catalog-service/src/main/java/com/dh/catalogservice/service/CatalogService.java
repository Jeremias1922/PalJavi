package com.dh.catalogservice.service;

import com.dh.catalogservice.model.Catalog;
import com.dh.catalogservice.model.Movie;
import com.dh.catalogservice.model.Serie;
import com.dh.catalogservice.repositories.MoviesRespository;
import com.dh.catalogservice.repositories.SeriesRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
public class CatalogService implements ICatalogService {

    private MoviesRespository moviesRespository;
    private SeriesRepository seriesRepository;


    @Override
    public Catalog catalogo(String genre) {
        Catalog catalog1 = new Catalog();
        List<Serie> listSeries = seriesRepository.findAllByGenre(genre);
        List<Movie> movieList = moviesRespository.findByGenre(genre);
        catalog1.setSerieList(listSeries);
        catalog1.setMovieList(movieList);
        return catalog1;
    }

    @Override
    public Serie guardarSerie(Serie serie) {
        return seriesRepository.save(serie);
    }

    @Override
    public Movie guardarMovie(Movie movie) {
        return moviesRespository.save(movie);
    }

}
