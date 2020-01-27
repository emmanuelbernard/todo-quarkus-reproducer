package fr.allianz.quarkus;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * @author Emmanuel Bernard emmanuel@hibernate.org
 */
@Entity
public class Todo extends PanacheEntity {
    @Column(unique = true)
    @NotBlank
    public String title;
    public String url;
    public boolean completed;
    @Column(name = "ordering")
    public int order;

    public static List<Todo> search(String word, Integer pageNumber) {
        return find("completed = ?1 and title like ?2", false, "%" + word + "%")
                .page(pageNumber, 3).list();
    }
}
