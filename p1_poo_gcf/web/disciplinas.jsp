<jsp:include page="includes/header.jsp" />
<%@page import="java.util.ArrayList"%>
<%@page import="br.edu.fatecpg.poo.Disciplina"%>
<main>
        <h1>Disciplinas</h1>
        <%
            if(request.getParameter("nome")!= null){
            String nome = (String)request.getParameter("nome");
            String ementa = (String)request.getParameter("ementa");
            Integer ciclo = Integer.parseInt(request.getParameter("ciclo"));
            Double nota = Double.parseDouble(request.getParameter("nota"));
            
            Disciplina.insert(nome, ementa, ciclo, nota);
            }
            
            if(request.getParameter("id")!=null){
                Disciplina.delete(Long.parseLong(request.getParameter("id")));
            }
        %>
        <table border="1">
            <tr>
                <th>Nome</th>
                <th>Ementa</th>
                <th>Ciclo</th>
                <th>Nota</th>
            </tr>
                <% for(Disciplina d: Disciplina.getList()){ %>
                    <tr>
                        <th><%= d.getNome() %></th>
                        <th><%= d.getEmenta() %></th>
                        <th><%= d.getCiclo()%></th>
                        <th><%= d.getNota()%></th>
                        <td>
                            <form>
                                <input type="text" name="notaAtt"/>
                                <input type="hidden" name="x" value="x"/>
                                <input type="submit" name="atualiza" value="Atualizar"/>
                                <input type="hidden" name="id" value="<%= d.getRowid() %>"/>
                                <input type="submit" value="Apagar"/>
                            </form>
                        </td>
                    </tr>
                    <% } %>
                </table>
                    <h2>Adicionar disciplina</h2>
                    <form>
                        <input type"text" name="nome" placeholder="Nome"/>
                        <input type"text" name="ementa" placeholder="Ementa"/>
                        <input type"text" name="ciclo" placeholder="Ciclo"/>
                        <input type"text" name="nota" placeholder="Nota"/>
                        <input type="submit" value="ENVIAR"/>
                    </form>
<jsp:include page="includes/footer.jsp" />