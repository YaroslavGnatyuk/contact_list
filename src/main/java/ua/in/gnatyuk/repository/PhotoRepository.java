package ua.in.gnatyuk.repository;

public interface PhotoRepository {
    String upload(java.io.File photo);
    boolean delete(String photo);
    java.io.File download(String photosId);
}
