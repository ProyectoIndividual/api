package es.proyecto.apiproyecto.repository.customJPADAO;

import es.proyecto.apiproyecto.repository.modelo.User;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Repository
public class UserCustomJPADAO implements IUserCustomJPDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> findAllConTodo(String search) {

        StringBuilder queryBuilder = new StringBuilder();

        queryBuilder.append("select u from User u join fetch u.localitation l");

        Map<String, Object> parametros = new HashMap<String, Object>();
        List<String> clausulaWhere = new ArrayList<String>();

        this.generateQueryParams(search, clausulaWhere, parametros);

        if (!clausulaWhere.isEmpty()) {
            queryBuilder.append(" where " + StringUtils.join(clausulaWhere, " and "));
        }

        javax.persistence.Query jpaQuery = entityManager.createQuery(queryBuilder.toString());


        for (String key : parametros.keySet()) {
            jpaQuery.setParameter(key, parametros.get(key));
        }

        @SuppressWarnings("unchecked")
        List<User> user = jpaQuery.getResultList();


        return user;


    }

    private void generateQueryParams(String searchString, List<String> clausulaWhere, Map<String, Object> parametros) {


        Pattern pattern = Pattern.compile("([\\w\\d]+).([\\w\\d]+)(:|<|<=|>=|>|;)([\\w\\d\\.]+)");
        Matcher matcher = pattern.matcher(searchString);

        while (matcher.find()) {

            // Extraemos entidad
            String entidad = matcher.group(1);
            String atributo = matcher.group(2);
            String condicion = matcher.group(3);
            String valor = matcher.group(4);

            //Construimos la condicion

            this.buildCondicion(clausulaWhere, parametros, entidad, atributo, condicion, valor);

        }

    }

    private void buildCondicion(List<String> clausulaWhere, Map<String, Object> parametros, String entidad, String atributo, String condicion, String valor) {

        switch (entidad) {

            case "user":

                switch (atributo) {
                    case "name":
                        if (condicion.equals(":")) {
                            clausulaWhere.add(" u.name LIKE :uname ");
                            parametros.put("uname", "%"+valor+"%");
                            break;
                        }if (condicion.equals(";")){
                        clausulaWhere.add(" u.name LIKE :uname ");
                        parametros.put("uname", valor);
                        break;
                    }

                    case "email":
                        if (condicion.equals(":")) {
                            clausulaWhere.add(" u.email LIKE :uemail ");
                            parametros.put("uemail", "%"+valor+"%");
                            break;
                        }if (condicion.equals(";")){
                        clausulaWhere.add(" u.email LIKE :uemail ");
                        parametros.put("uemail", valor);
                        break;
                    }


                    case "surnames":
                        if (condicion.equals(":")) {
                            clausulaWhere.add(" u.surnames LIKE :usurnames ");
                            parametros.put("usurnames", "%"+valor+"%");
                            break;
                        }if (condicion.equals(";")){
                        clausulaWhere.add(" u.surnames LIKE :usurnames ");
                        parametros.put("usurnames", valor);
                        break;
                    }



                    case "registration":
                        if (condicion.equals(":")) {
                            clausulaWhere.add(" u.registrationDate  LIKE :uregistrationDate ");
                            parametros.put("uregistrationDate", "%"+valor+"%");
                            break;
                        }if (condicion.equals(";")){
                        clausulaWhere.add(" u.registrationDate LIKE :uregistrationDate ");
                        parametros.put("uregistrationDate",valor);
                        break;
                    }

                    case "password":
                        if (condicion.equals(":")) {
                            clausulaWhere.add(" u.password LIKE :upassword ");
                            parametros.put("upassword", "%"+valor+"%");
                            break;
                        }if (condicion.equals(";")){
                        clausulaWhere.add(" u.password LIKE :upassword ");
                        parametros.put("upassword", valor);
                        break;
                    }

                    default:
                        throw new IllegalArgumentException("Condición no valida.");
                }

                break;
            default:
                throw new IllegalArgumentException("Condición no valida.");
        }
    }
}
