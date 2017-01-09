package ua.in.gnatyuk.repository;

public interface PhotoRepository {
    boolean upload(java.io.File photo);
    void delete(String photo);
    java.io.File download();
}
