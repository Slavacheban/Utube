package hw14.prototype;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Man implements Copiable {
    private String name;
    private int age;

    @Override
    public Copiable copy() {
        return new Man();
    }
}
