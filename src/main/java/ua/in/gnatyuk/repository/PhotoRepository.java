package ua.in.gnatyuk.repository;

public interface PhotoRepository {
    String uploadPhoto(java.io.File photo);
    boolean deletePhoto(String photo);
    java.io.File downloadPhoto(String photosId);
    String getFileIDByFileName(String fileName);
}
