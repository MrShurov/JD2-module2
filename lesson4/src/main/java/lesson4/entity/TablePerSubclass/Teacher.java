package lesson4.entity.TablePerSubclass;

import lesson4.entity.DataEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TEACHER1")
@PrimaryKeyJoinColumn(name = "PERSON1_ID")
public class Teacher extends Person {
    private String subject;

    public Teacher(String s1,String s2,String s3){
        super(null,s1,s2);
        this.subject = s3;
    }
}
