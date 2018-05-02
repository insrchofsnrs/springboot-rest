package by.insrch.sdrw.exception;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class EmailExistsException extends Exception{

    private String exceptionMessage(String string){
        System.out.println(string);
        return string;
    }

    public EmailExistsException (String string){
        exceptionMessage(string);
    }

}
