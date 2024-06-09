package com.mycompany.dvdstore.core.repository.file;

import com.mycompany.dvdstore.core.entity.Actor;
import com.mycompany.dvdstore.core.entity.Movie;
import com.mycompany.dvdstore.core.repository.MovieRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

//@Repository
public class FileMovieRepository implements MovieRepositoryInterface {

    @Value("${movie.file.location}")
    private File file;

    private static List<Movie> movies = new ArrayList<>();

    @Autowired
    private MovieRepositoryInterface movieRepositoryInterface;

    public MovieRepositoryInterface getMovieRepositoryInterface() {
        return movieRepositoryInterface;
    }

    public void setMovieRepositoryInterface(MovieRepositoryInterface movieRepositoryInterface) {
        this.movieRepositoryInterface = movieRepositoryInterface;
    }

    public Movie save(Movie movie){
        FileWriter writer;
        long lastId= StreamSupport.stream(findAll().spliterator(), false).map(Movie::getId_movie).max(Long::compare).orElse(0L);
        movie.setId_movie(lastId+1);
        try{
            writer=new FileWriter(file,true);
            writer.write(movie.getId_movie()+"; "+movie.getTitre()+"; "+movie.getGenre()+"; "+movie.getDescription()+"\n");
            writer.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return movie;
    }

    public File getFile() {return file;}

    public void setFile(File file) {this.file = file;}

    @Override
    public <S extends Movie> Iterable<S> saveAll(Iterable<S> entities) {throw new UnsupportedOperationException();}

    @Override
    public Optional<Movie> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {throw new UnsupportedOperationException();}

    @Override
    public List<Movie> findAll(){
        List<Movie> movies=new ArrayList<>();

        try(BufferedReader br = new BufferedReader(new FileReader(file))) {
            for(String line; (line = br.readLine()) != null; ) {
                final Movie movie=new Movie();
                final String[] val = line.split("\\;");
                movie.setId_movie(Long.parseLong(val[0]));
                movie.setTitre(val[1]);
                movie.setGenre(val[2]);
                movie.setDescription(val[3]);
                movie.setActor(new Actor());
                movies.add(movie);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return movies;
    }

    @Override
    public Iterable<Movie> findAllById(Iterable<Long> longs) {throw new UnsupportedOperationException();}

    @Override
    public long count() {throw new UnsupportedOperationException();}

    @Override
    public void deleteById(Long aLong) {throw new UnsupportedOperationException();}

    @Override
    public void delete(Movie entity) {throw new UnsupportedOperationException();}

    @Override
    public void deleteAll(Iterable<? extends Movie> entities) {throw new UnsupportedOperationException();}

    @Override
    public void deleteAll() {throw new UnsupportedOperationException();}

    @Override
    public Optional<Movie> findById(long id) {
        final Movie movie = new Movie();
        movie.setId_movie(id);
        try(BufferedReader br = new BufferedReader(new FileReader(file))) {
            for(String line; (line = br.readLine()) != null; ) {

                final String[] allProperties = line.split("\\;");
                final long nextMovieId=Long.parseLong(allProperties[0]);
                if (nextMovieId==id) {
                    movie.setTitre(allProperties[1]);
                    movie.setGenre(allProperties[2]);
                    movie.setDescription(allProperties[3]);
                    return Optional.of(movie);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.err.println("A movie from the file does not have a proper id");
            e.printStackTrace();
        }
        //movie.setTitre("UNKNOWN");
        //movie.setGenre("UNKNOWN");
        //movie.setDescription("UNKNOWN");
        return Optional.of(movie);
    }
}
