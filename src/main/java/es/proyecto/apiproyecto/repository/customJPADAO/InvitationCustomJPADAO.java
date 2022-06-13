package es.proyecto.apiproyecto.repository.customJPADAO;

import es.proyecto.apiproyecto.repository.modelo.Invitation;
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
public class InvitationCustomJPADAO implements IInvitationCustomJPADAO{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Invitation> findAllConTodo(String search) {

        StringBuilder queryBuilder = new StringBuilder();

        queryBuilder.append("select i from Invitation i join fetch i.user u join fetch i.event e");

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
        List<Invitation> invitations = jpaQuery.getResultList();


        return invitations;

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

            case "invitation":

                switch (atributo) {
                    case "accept":
                        if (condicion.equals(":")&& valor.equalsIgnoreCase("false")) {
                            clausulaWhere.add(" i.accept = :accept ");
                            parametros.put("accept", Boolean.FALSE);
                            break;
                        }
                        clausulaWhere.add(" i.accept = :accept ");
                        parametros.put("accept", Boolean.TRUE);
                        break;


                    default:
                        throw new IllegalArgumentException("Condición no valida.");
                }
                break;

            case "user":

                switch (atributo) {

                    case "id":

                        clausulaWhere.add(" u.id = :usolduserid");
                        parametros.put("usolduserid", Integer.parseInt(valor));
                        break;

                    case "name":
                        if (condicion.equals(":")) {
                            clausulaWhere.add(" u.name LIKE :pusername ");
                            parametros.put("pusername", "%"+valor+"%");
                            break;
                        }if (condicion.equals(";")){
                        clausulaWhere.add(" u.name LIKE :pusername");
                        parametros.put("pusername", valor);
                        break;
                    }

                    case "surnames":
                        if (condicion.equals(":")) {
                            clausulaWhere.add(" u.surnames LIKE :pusernamesurnames ");
                            parametros.put("pusernamesurnames", "%"+valor+"%");
                            break;
                        }
                        clausulaWhere.add(" u.surnames = :pusernamesurnames");
                        parametros.put("pusernamesurnames", valor);
                        break;


                    case "email":
                        if (condicion.equals(":")) {
                            clausulaWhere.add(" u.email LIKE :uemail ");
                            parametros.put("uemail", "%"+valor+"%");
                            break;
                        }
                        clausulaWhere.add(" u.email = :uemail ");
                        parametros.put("uename", valor);
                        break;


                    default:
                        throw new IllegalArgumentException("Condición no valida.");
                }

                break;
            case "event":

                switch (atributo) {
                    case "id":

                        clausulaWhere.add(" e.id = :eid");
                        parametros.put("eid", Integer.parseInt(valor));
                        break;

                    case "public":
                        if (condicion.equals(":") && valor.equalsIgnoreCase("false")) {
                            clausulaWhere.add(" e.isPublic = :eisPublic ");
                            parametros.put("eisPublic", Boolean.FALSE);
                            break;
                        } else if (condicion.equals(":")) {
                            clausulaWhere.add(" e.isPublic = :eisPublic ");
                            parametros.put("eisPublic", Boolean.TRUE);
                        }
                        break;


                    case "price":
                        if (condicion.equals(":")) {
                            clausulaWhere.add(" e.price = :eprice ");
                            parametros.put("eprice", Float.parseFloat(valor));
                            break;
                        }
                        clausulaWhere.add(" e.price " + condicion + " :eprice ");
                        parametros.put("eprice", Float.parseFloat(valor));
                        break;

                    case "startTimePlanned":
                        if (condicion.equals(":")) {
                            clausulaWhere.add(" e.startTimePlanned  LIKE :estartTimePlanned ");
                            parametros.put("estartTimePlanned", "%" + valor + "%");
                            break;
                        }
                        if (condicion.equals(";")) {
                            clausulaWhere.add(" e.startTimePlanned LIKE :estartTimePlanned ");
                            parametros.put("estartTimePlanned", valor);
                            break;

                        }
                    case "endTimeActual":
                        if (condicion.equals(":")) {
                            clausulaWhere.add(" e.endTimeActual  LIKE :eendTimeActual ");
                            parametros.put("eendTimeActual", "%" + valor + "%");
                            break;
                        }
                        if (condicion.equals(";")) {
                            clausulaWhere.add(" e.endTimeActual LIKE :eendTimeActual");
                            parametros.put("eendTimeActual", valor);
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
