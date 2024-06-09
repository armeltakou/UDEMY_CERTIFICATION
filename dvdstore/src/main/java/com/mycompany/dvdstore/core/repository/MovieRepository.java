package com.mycompany.dvdstore.core.repository;
/*
import com.mycompany.dvdstore.core.entity.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

@Repository
public class MovieRepository implements MovieRepositoryInterface {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Movie addMovie(Movie movie) {
        KeyHolder kh = new GeneratedKeyHolder();
        jdbcTemplate.update(connection ->{
                PreparedStatement ps = connection.prepareStatement("INSERT INTO MOVIE(TITRE, GENRE, DESCRIPTION) VALUES(?,?,?)",
                        Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, movie.getTitre());
                ps.setString(2, movie.getGenre());
                ps.setString(3, movie.getDescription());
                return ps;
        }, kh);
        movie.setId(kh.getKey().longValue());
        return movie;
    }

    @Override
    public List<Movie> list() {
        return jdbcTemplate.query("SELECT * FROM MOVIE",
                (rs, rowNum) -> new Movie(rs.getLong("id"),rs.getString("titre"),rs.getString("genre")));
    }

    @Override
    public Movie getById(long id) {
        return jdbcTemplate.queryForObject("SELECT * FROM MOVIE WHERE id=?",
                new Object[]{id},
                (rs, rowNum) -> new Movie(rs.getLong("id"),rs.getString("titre"),rs.getString("genre"),rs.getString("description")));
    }
}
*/