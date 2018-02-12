package by.insrch.sdrw.service;

import by.insrch.sdrw.dao.NoteRepository;
import by.insrch.sdrw.dao.UserRepository;
import by.insrch.sdrw.pojo.Note;
import by.insrch.sdrw.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService  {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private NoteRepository noteRepository;

    User user1 = new User();
    User user2 = new User();
    User user3 = new User();
    Note note1 = new Note();
    Note note2 = new Note();

    public void addusers(){
        user1.setName("John");
        user1.setEmail("e.vavilkin@gmail.com");
        user1.setSurname("Vavilkin");
        user2.setName("Mich");
        user2.setEmail("e.Mich@gmail.com");
        user2.setSurname("Linking");
        user3.setName("Sasha");
        user3.setEmail("e.kubar@gmail.com");
        user3.setSurname("kubar");

        note1.setName("первый");
        //note1.setText("it provides implementations of more ...");
        note1.setText("The root interface in the collection hierarchy. A collection represents a group of objects, known as its elements. Some collections allow duplicate elements and others do not. Some are ordered and others unordered. The JDK does not provide any direct implementations of this interface: it provides implementations of more ...");
        note2.setName("second");
        //note2.setText("полностью:  https://news.tut.by/culture/580405.html");
        note2.setText("Я очень благодарна Алексею Навальному за то, что он сделал такое видео. Теперь я могу рассказать всем, как все было на самом деле на этой яхте. Раньше я боялась это сделать, потому что я понимаю, какие это люди и чем это чревато для меня… На самом деле это было групповое изнасилование», — заявила девушка Читать полностью:  https://news.tut.by/culture/580405.html");

        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);
        noteRepository.save(note1);
        noteRepository.save(note2);


    }
}
