package com.ltp.videoclubs.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ltp.videoclubs.entity.Movie;
import com.ltp.videoclubs.entity.Videoclub;

@Repository
public interface MovieRepository extends CrudRepository<Movie, Long> {

    Iterable<Movie> findByVideoclub(Videoclub videoclub);

}
