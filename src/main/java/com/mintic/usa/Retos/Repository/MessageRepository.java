package com.mintic.usa.Retos.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mintic.usa.Retos.Model.Message;
import com.mintic.usa.Retos.Repository.CRUD.MessageCrudRepoInterfaz;

@Repository
public class MessageRepository {
    
    @Autowired
    private MessageCrudRepoInterfaz messageCrudRepoInterfaz;

    public List<Message> obtenerMessageCompleta(){
        return(List<Message>) messageCrudRepoInterfaz.findAll();
    }

    public Optional<Message> obtenerMessageId(Integer idMessage){
        return messageCrudRepoInterfaz.findById(idMessage);
    }
    public Message salvarMessage(Message message){
        return messageCrudRepoInterfaz.save(message);

    }

    public void delete(Message message) {
        messageCrudRepoInterfaz.delete(message);
        
    }


}
