package es.proyecto.apiproyecto.rest.service;

import es.proyecto.apiproyecto.repository.customJPADAO.IUserCustomJPDAO;
import es.proyecto.apiproyecto.repository.jpa.IUserJPADAO;
import es.proyecto.apiproyecto.repository.modelo.User;
import es.proyecto.apiproyecto.rest.dto.UserDTO;
import es.proyecto.apiproyecto.rest.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    IUserJPADAO iUserJPADAO;

    @Autowired
    IUserCustomJPDAO iUserCustomJPDAO;

    public Long count() {
        return this.iUserJPADAO.count();
    }

    public List<UserDTO> findAll(Boolean conTodo, String search) {
        List<User> users = new ArrayList<>();

        if (search.equalsIgnoreCase("false")) {
            users = this.iUserJPADAO.findAll();
        } else {
           users = this.iUserCustomJPDAO.findAllConTodo(search);
        }

        return UserMapper.map(users, conTodo);

    }

    public UserDTO findById(Integer id, Boolean conTodo) {

        Optional<User> user = this.iUserJPADAO.findById(id);

        return UserMapper.map(user, conTodo);
    }

    public UserDTO create(UserDTO usersDTO) {

        User user = UserMapper.map(usersDTO, false);
        user = this.iUserJPADAO.save(user);

        return UserMapper.map(user, false);
    }
    public void update(UserDTO usersDTO) {

        User user = UserMapper.map(usersDTO, false);
        this.iUserJPADAO.save(user);

    }

    public void delete(UserDTO usersDTO) {
        User user = UserMapper.map(usersDTO, false);
        this.iUserJPADAO.delete(user);
    }

    public UserDTO login(UserDTO usersDTO) {

        String email = usersDTO.getEmail();
        String pass = usersDTO.getPassword();

        String search = "user.email:" + email;

        List<User> user = this.iUserCustomJPDAO.findAllConTodo(search);
        User usuario = new User();
        boolean correct= false;

       if (user.isEmpty() || user == null) {
            return null;
        } else {
            usuario = user.get(0);

            if (usuario.getPassword().equals(pass)) {
                correct=true;
            }
        }

        if (!correct){
            return null;
        }else{
            return UserMapper.map(usuario, false);
        }

    }

}
