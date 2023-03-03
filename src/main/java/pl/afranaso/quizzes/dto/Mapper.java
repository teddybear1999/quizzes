package pl.afranaso.quizzes.dto;

public interface Mapper<E, D> {
    D mapToDto(E entity);
}