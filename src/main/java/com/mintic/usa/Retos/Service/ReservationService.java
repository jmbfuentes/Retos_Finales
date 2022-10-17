package com.mintic.usa.Retos.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mintic.usa.Retos.Model.Reservation;
import com.mintic.usa.Retos.Model.DTOs.CountClient;
import com.mintic.usa.Retos.Model.DTOs.CountStatus;
import com.mintic.usa.Retos.Repository.ReservationRepository;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;
    
    public List<Reservation> obtenerReservationall() {
        return reservationRepository.obtenerReservationAll();
    }

    public Optional<Reservation> obtenerReservationaId(Integer id) {
        return reservationRepository.obtenerReservationId(id);
    }

    public Reservation salvarReservation(Reservation reservation) {
        if(reservation.getIdReservation() == null){
            return reservationRepository.salvarReservation(reservation);

        }else{
            Optional<Reservation> reservationAuxiliar = reservationRepository.obtenerReservationId(reservation.getIdReservation());
            if (reservationAuxiliar.isEmpty()) {
                return reservationRepository.salvarReservation(reservation);
            
            }else{
                return reservation;
            }
        }
    }

   
    public Reservation actualizarReservation(Reservation reservation) {
        if (reservation.getIdReservation() != null) {
            Optional<Reservation> e = reservationRepository.obtenerReservationId(reservation.getIdReservation());
            if (!e.isEmpty()) {
                if (reservation.getStartDate() != null) {
                    e.get().setStartDate(reservation.getStartDate());
                }
                if (reservation.getDevolutionDate() != null) {
                    e.get().setDevolutionDate(reservation.getDevolutionDate());
                }
                if (reservation.getStatus() != null) {
                    e.get().setStatus(reservation.getStatus());
                }
                

                reservationRepository.salvarReservation(e.get());
                return e.get();

            } else {
                return reservation;
            }
        } else {
            return reservation;
        }
    }

    public boolean borrarReservation(int reservationId) {
        boolean flag=false;
        Optional<Reservation> c= reservationRepository.obtenerReservationId(reservationId);
        if(c.isPresent()){
            reservationRepository.delete(c.get());
            flag=true;
        }
        return flag;

    } 

    //reto 5

    public List<CountClient> getTopClients(){
        return reservationRepository.getTopClients();
    }

    public List<Reservation> getReservationPeriod(String dateA, String dateB){
        SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd");
        Date a = new Date();
        Date b = new Date();

        try {
            a = parser.parse(dateA);
            b = parser.parse(dateB);

        } catch (ParseException exception) {
            exception.printStackTrace();
        }

        if(a.before(b)){
            return reservationRepository.getReservationPeriod(a, b);
        
        }else{
            return new ArrayList<>();
        }
    }

    
    public CountStatus getReservationsStatus(){
        List<Reservation> completed = reservationRepository.getReservationByStatus("completed");

        List<Reservation> cancelled = reservationRepository.getReservationByStatus("cancelled");

        return new CountStatus((long) completed.size(), (long) cancelled.size());
        }

    
}
