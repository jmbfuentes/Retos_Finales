package com.mintic.usa.Retos.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mintic.usa.Retos.Model.Client;
import com.mintic.usa.Retos.Model.Reservation;
import com.mintic.usa.Retos.Model.DTOs.CountClient;
import com.mintic.usa.Retos.Repository.CRUD.ReservationCrudRepoInterfaz;

@Repository
public class ReservationRepository {
    
    @Autowired
    private ReservationCrudRepoInterfaz reservationCrudRepoInterfaz;

    public List<Reservation> obtenerReservationAll(){
        return (List<Reservation>) reservationCrudRepoInterfaz.findAll();
    }

    public Optional<Reservation> obtenerReservationId(Integer id){
        return reservationCrudRepoInterfaz.findById(id);
    }

    public Reservation salvarReservation(Reservation reservation){
        return reservationCrudRepoInterfaz.save(reservation);
    }

    public void delete(Reservation reservation) {
        reservationCrudRepoInterfaz.delete(reservation);
        
    }
    //reto5

    public List<CountClient> getTopClients(){
        List<CountClient> respuesta = new ArrayList<>();
        
        List<Object[]> reporte = reservationCrudRepoInterfaz.countTotalReservationByClients();

        for (int i = 0; i < reporte.size(); i++){
            respuesta.add(new CountClient((Long)reporte.get(i)[1], (Client)reporte.get(i)[0]));
        }
        return respuesta;
    }

    public List<Reservation> getReservationPeriod(Date a, Date b){
        return reservationCrudRepoInterfaz.findAllByStartDateAfterAndDevolutionDateBefore(a, b);
    }

    public List<Reservation> getReservationByStatus(String status){
        return reservationCrudRepoInterfaz.findAllByStatus(status);
    }






}
