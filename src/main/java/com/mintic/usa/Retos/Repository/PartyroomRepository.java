package com.mintic.usa.Retos.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mintic.usa.Retos.Model.Partyroom;
import com.mintic.usa.Retos.Repository.CRUD.PartyroomCrudRepoInterfaz;

@Repository
public class PartyroomRepository {
    
    @Autowired
    private PartyroomCrudRepoInterfaz partyroomCrudRepoInterfaz;

    public List<Partyroom> obtenerPartyroomall(){
        return (List<Partyroom>) partyroomCrudRepoInterfaz.findAll();

    }
    
    public Optional<Partyroom> obtenerPartyroomId(Integer id){
        return partyroomCrudRepoInterfaz.findById(id);
    }

    public Partyroom salvarPartyroom (Partyroom partyroom){
        return partyroomCrudRepoInterfaz.save(partyroom);
    }

    public void delete(Partyroom partyroom) {
        partyroomCrudRepoInterfaz.delete(partyroom);
        
    }


}
