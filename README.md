# SPRING BOOT API REST


### **INFO**
  
     SpringBoot con una BD MYSQL , la bd se encuentra online en la direccion : server.estebajp.es .La direccion es localhost o server.estebanjp.es:9000.
     Puerto ApringBoot: 9000
     Path: friendshift
     Ejemplo: localhost:9000/friendshift/user
     
     
### **PETICIONES REST**

      Filtrados hechos por variable search=user.name:Ejemplo,user.surnames;Ejemplo (entidad, atributo, condicion, valor). Filtrado por campos del modelo a utilizar. Las relaciones sql estan hechas por los modelos y jpa (Se obtiene objeto cporel id no el id),
      
      Condición Carácter : (LIKE)
      Condición Carácter ; (=)

#### REST person TABLA User

      [GET]  localhost:9000/friendshift/user/count -> Get numero total de Usuarios
      [GET]  localhost:9000/friendshift/user  -> Get All users
      [GET]  localhost:9000/friendshift/user/1 -> Get Usuario id 1 
      [GET]  localhost:9000/friendshift/user?search=user.name:Esteban ->Obtenemos user por nombre (name, surnames, email)
      [POST] localhost:9000/friendshift/user -> +JSON User , add user
      [PUT]  localhost:9000/friendshift/user -> +JSON USer , edit user id 1
      [DELETE]  localhost:9000/friendshift/user -> +JSON USer , delete user id 1
      
      
#### REST post TABLA Localitation

      [GET]  localhost:9000/friendshift/localitation/count -> Get numero total de Localitation
      [GET]  localhost:9000/friendshift/localitation  -> Get All Localitation
      [GET]  localhost:9000/friendshift/localitation/1 -> Get Localitation id 1 
      [POST] localhost:9000/friendshift/localitation -> +JSON Localitation , add Localitation
      [PUT]  localhost:9000/friendshift/localitation/1 -> +JSON Localitation , edit Localitationa id 1
      [DELETE]  localhost:9000/friendshift/localitation/1 -> +JSON Localitation , delete Localitation id 1  
      
      
#### REST postState TABLA Invitation

      [GET]  localhost:9000/friendshift/invitation/count -> Get numero total de estados de Invitation
      [GET]  localhost:9000/friendshift/invitation  -> Get All Invitation
      [GET]  localhost:9000/friendshift/invitation/1 -> Get Invitation id 1 
      [GET]  localhost:9000/friendshift/invitation?search=user.id:1 ->Obtenemos Invitation del usuario id 1 ( user.id, user.name etc)
      [POST] localhost:9000/friendshift/invitation -> +JSON Invitation , add Invitation
      [PUT]  localhost:9000/friendshift/invitation/1 -> +JSON Invitation , edit Invitation id 1
      [DELETE]  localhost:9000/friendshift/invitation/1 -> +JSON Invitation , delete Invitation id 1       
      
 #### REST friend TABLA Event

      [GET]  localhost:9000/friendshift/event/count -> Get numero total de Event
      [GET]  localhost:9000/friendshift/event  -> Get All Event
      [GET]  localhost:9000/friendshift/event/1 -> Get Event relation id 1 
      [GET]  localhost:9000/friendshift/event?search=user.id:1 ->Obtenemos todas Event (user.id, user.name etc )
      [POST] localhost:9000/friendshift/event -> +JSON Event , add Event
      [PUT]  localhost:9000/friendshift/event/1 -> +JSON Event , edit Event id 1
      [DELETE]  localhost:9000/friendshift/event/1 -> +JSON Event , delete Event id 1
      
      
  #### REST evento TABLA EventStatus

      [GET]  localhost:9000/friendshift/eventStatus/count -> Get numero total de EventStatus
      [GET]  localhost:9000/friendshift/eventStatus  -> Get All EventStatus
      [GET]  localhost:9000/friendshift/eventStatus/1 -> Get  EventStatus id 1 
      [POST] localhost:9000/friendshift/eventStatus -> +JSON EventStatus , add EventStatus
      [PUT]  localhost:9000/friendshift/eventStatus/1 -> +JSON EventStatus , edit EventStatus id 1
      [DELETE]  localhost:9000/friendshift/eventStatus/1 -> +JSON EventStatus , delete EventStatus id 1 
      
 
