package chatbot.domain;

import chatbot.ChatApplication;
import chatbot.domain.Questioned;
import chatbot.domain.Requested;
import chatbot.domain.Searched;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Chat_table")
@Data
//<<< DDD / Aggregate Root
public class Chat {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String productId;

    private String questionMsg;

    private String requestMsg;

    private String requestType;

    private String userId;

    @PostPersist
    public void onPostPersist() {
        Searched searched = new Searched(this);
        searched.publishAfterCommit();
    }

    @PreUpdate
    public void onPreUpdate() {
        Questioned questioned = new Questioned(this);
        questioned.publishAfterCommit();

        Requested requested = new Requested(this);
        requested.publishAfterCommit();
    }

    public static ChatRepository repository() {
        ChatRepository chatRepository = ChatApplication.applicationContext.getBean(
            ChatRepository.class
        );
        return chatRepository;
    }

    //<<< Clean Arch / Port Method
    public static void changeRequestType(Refused refused) {
        //implement business logic here:

        /** Example 1:  new item 
        Chat chat = new Chat();
        repository().save(chat);

        */

        /** Example 2:  finding and process
        
        repository().findById(refused.get???()).ifPresent(chat->{
            
            chat // do something
            repository().save(chat);


         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void getUserId(Patched patched) {
        //implement business logic here:

        /** Example 1:  new item 
        Chat chat = new Chat();
        repository().save(chat);

        */

        /** Example 2:  finding and process
        
        repository().findById(patched.get???()).ifPresent(chat->{
            
            chat // do something
            repository().save(chat);


         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
