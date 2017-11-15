package by.kish.subscribtionmanager.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data
@NoArgsConstructor
@ToString
public class Response implements Serializable{

    private String phrase;

    public Response(String phrase) {
        this.phrase = phrase;
    }
}
