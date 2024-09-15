package com.ltp.videoclubs.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ltp.videoclubs.entity.Movie;
import com.ltp.videoclubs.entity.Videoclub;
import com.ltp.videoclubs.exception.VideoclubNotFoundException;
import com.ltp.videoclubs.repository.MovieRepository;
import com.ltp.videoclubs.repository.VideoclubRepository;

@Service
public class VideoclubServiceImpl implements VideoclubService {

    @Autowired
    VideoclubRepository videoclubRepository;
    @Autowired
    MovieRepository movieRepository;

    @Override
    public Videoclub getVideoclub(Long id) {
        Optional<Videoclub> videoclub = videoclubRepository.findById(id);
        if (videoclub.isPresent()) {
            return videoclub.get();
        } else {
            throw new VideoclubNotFoundException(id);

        }
    }

    @Override
    public Videoclub saveVideoclub(Videoclub videoclub) {
        return videoclubRepository.save(videoclub);
    }

    @Override
    public void updateVideoclub(Long id, Videoclub videoclub) {
        Optional<Videoclub> existingVideoclubOptional = videoclubRepository.findById(id);
        if (existingVideoclubOptional.isPresent()) {
            Videoclub existingVideoclub = existingVideoclubOptional.get();
            existingVideoclub.setName(videoclub.getName());
            existingVideoclub.setPhoneNumber(videoclub.getPhoneNumber());
            existingVideoclub.setAddress(videoclub.getAddress());
            videoclubRepository.save(existingVideoclub);
        } else {
            throw new VideoclubNotFoundException(id);
        }
    }

    @Override
    public void deleteVideoclub(Long id) {
        Optional<Videoclub> videoclubOptional = videoclubRepository.findById(id);
        if (videoclubOptional.isPresent()) {
            Iterable<Movie> movies = movieRepository.findByVideoclub(videoclubOptional.get());
            movieRepository.deleteAll(movies);
            videoclubRepository.deleteById(id);
        } else {
            throw new VideoclubNotFoundException(id);
        }
    }

    @Override
    public Iterable<Videoclub> getVideoclubs() {
        return videoclubRepository.findAll();
    }

}