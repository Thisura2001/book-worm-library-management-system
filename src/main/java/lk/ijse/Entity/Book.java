package lk.ijse.Entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

@Entity
public class Book {
    @Id
    private String id;
    private String title;
    private String author;
    private int availability;

    @OneToMany(mappedBy = "book" , targetEntity = BookDetails.class)
    private List<BookDetails>bookDetailsList = new ArrayList<>();

    public Book(String id, String title, String author, int availability) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.availability = availability;
    }
}
