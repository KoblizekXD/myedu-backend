package lol.koblizek.myedu.util;

public interface IdentifiedService<T, DTO, ID> {
    ID create(DTO dto);
    T get(ID id);
    void update(ID id, DTO dto);
    void delete(ID id);
}
