package com.ltp.videoclubs;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
//import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ltp.videoclubs.entity.Movie;
import com.ltp.videoclubs.entity.Videoclub;
import com.ltp.videoclubs.repository.MovieRepository;
import com.ltp.videoclubs.repository.VideoclubRepository;

//import com.ltp.videoclubs.entity.Videoclub;
//import com.ltp.videoclubs.repository.VideoclubRepository;

@SpringBootApplication
public class VideoclubsApplication implements CommandLineRunner {

	@Autowired
	VideoclubRepository videoclubRepository;
	@Autowired
	MovieRepository movieRepository;

	public static void main(String[] args) {
		SpringApplication.run(VideoclubsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Videoclub[] videoclubs = new Videoclub[] {
				new Videoclub(1L, "Panorama", "6973729725", "Athens"),
				new Videoclub(2L, "Rainbow", "6935738900", "Patras"),
				new Videoclub(3L, "Videoland", "6983729947", "Thessaloniki"),
				new Videoclub(4L, "Seven", "6943792785", "Athens")
		};

		for (int i = 0; i < videoclubs.length; i++) {
			videoclubRepository.save(videoclubs[i]);
		}

		Movie[] movies = new Movie[] {
				new Movie(5L, "Wings of Desire", "Romantic", LocalDate.parse("1987-05-17"), videoclubs[2]),
				new Movie(6L, "Jojo Rabbit", "Drama", LocalDate.parse("2019-05-17"), videoclubs[0]),
				new Movie(7L, "Το κλάμα βγήκε από τον παράδεισο", "Comedy", LocalDate.parse("2001-10-25"),
						videoclubs[1]),
				new Movie(8L, "Brazil", "Sci-fi", LocalDate.parse("1985-10-22"), videoclubs[3]),
				new Movie(9L, "The Crow", "Superhero", LocalDate.parse("1994-11-18"), videoclubs[2]),
				new Movie(10L, "Network", "Drama", LocalDate.parse("1976-10-27"), videoclubs[0]),
				new Movie(11L, "Dark City", "Sci-fi", LocalDate.parse("1998-02-27"), videoclubs[1]),
				new Movie(12L, "Blade Runner", "Sci-fi", LocalDate.parse("1982-06-25"), videoclubs[3]),
		};

		for (int i = 0; i < movies.length; i++) {
			movieRepository.save(movies[i]);
		}

	}

}
