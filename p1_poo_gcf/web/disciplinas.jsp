<%@page import="java.util.ArrayList"%>
<%@page import="br.edu.fatecpg.poo.Disciplina"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>P1 POO</title>
    </head>
    <body>
        <h1>Disciplinas</h1>
        <%
            //Criando objeto Disciplina
            Disciplina disc = new Disciplina("","",2);
            disc.getList(1);
            //Criando arrayList disciplina
            ArrayList<Disciplina> disciplinas = new ArrayList<Disciplina>();
            //Populando ArrayList
            for(int y=0; y<6;y++){
                disciplinas.add(disc.getList(y));
            }
            if (request.getParameter("atualiza") != null) {
                int i = Integer.parseInt(request.getParameter("x"));
                Disciplina altera = disciplinas.get(i);
                try{
                String txt = request.getParameter("notaAtt");
                double num = Double.parseDouble(txt);
                altera.setNota(num);
                }catch(Exception ex){
                    ex.getMessage();
                }
                response.sendRedirect(request.getRequestURI());
            }

        
        %>
        <table border="1">
            <tr>
                <th>Nome</th>
                <th>Ementa</th>
                <th>Ciclo</th>
                <th>Nota</th>
            </tr>
                <%
                    for(int x = 0; x<6;x++){%>
                    <tr>
                        <% Disciplina d = disciplinas.get(x);%>
                        <th><%= d.getNome() %></th>
                        <th><%= d.getEmenta() %></th>
                        <th><%= d.getCiclo()%></th>
                        <th><%= d.getNota()%></th>
                        <td>
                            <form>
                                <input type="text" name="notaAtt"/>
                                <input type="hidden" name="x" value="<%= x%>"/>
                                <input type="submit" name="atualiza" value="Atualizar"/>
                            </form>
                        </td>
                    </tr>
                    <%}
                %>
        </table>
    </body>
</html>
