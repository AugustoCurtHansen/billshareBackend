package com.billshare.backend.domain.userContext;

import java.time.LocalDateTime;

public class Checkin {
     private LocalDateTime diaHoraCheckin;

     private Long id;
     private Long idUsuario;

     public Checkin(LocalDateTime diaHoraCheckin) {
          this.diaHoraCheckin = diaHoraCheckin;
     }

     public Long getId() {
          return id;
     }

     public void setId(Long id) {
          this.id = id;
     }

     public Long getIdUsuario() {
          return idUsuario;
     }

     public void setIdUsuario(Long idUsuario) {
          this.idUsuario = idUsuario;
     }

     public LocalDateTime getDiaHoraCheckin() {
          return diaHoraCheckin;
     }

     public void setDiaHoraCheckin(LocalDateTime diaHoraCheckin) {
          this.diaHoraCheckin = diaHoraCheckin;
     }
}
