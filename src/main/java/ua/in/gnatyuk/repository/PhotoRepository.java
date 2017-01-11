package ua.in.gnatyuk.repository;

public interface PhotoRepository {
    String DEFAULT_IMAGE = "my_linux.jpg";
    String upload(java.io.File photo);
    boolean delete(String photo);
    java.io.File download(String photosId);
    String findIDByFileName(String fileName);
}
