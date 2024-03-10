package lk.ijse.Entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lk.ijse.Dto.BookDetailsDto;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

@Entity
public class User {
    @Id
    private String id;
    private String name;
    private String address;
    private int contact;
    private String gender;

    @OneToMany(mappedBy = "user" , targetEntity = BookDetails.class , cascade = CascadeType.ALL)
    private List<BookDetails> bookDetailsList = new ArrayList<>();

    public User(String id, String name, String address, int contact, String gender) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.contact = contact;
        this.gender = gender;
    }
}
