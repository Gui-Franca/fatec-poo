<%@page import="br.edu.fatecpg.poo.DBListenerP2"%>
<jsp:include page="includes/header.jsp" />
<%@page import="java.util.ArrayList"%>
<%@page import="br.edu.fatecpg.poo.Disciplina"%>
<main>
    
    <%
    String errorMessage = null;
    try{
        if(request.getParameter("insert")!=null){
            String name = request.getParameter("name");
            String ementa = request.getParameter("ementa");
            String ciclo = request.getParameter("ciclo");
            String nota = request.getParameter("nota");
            
            int cicloConv = Integer.parseInt(ciclo);
            int notaConv = Integer.parseInt(nota);
            
            Disciplina.insertDisciplina(name,ementa,cicloConv,notaConv);
            response.sendRedirect(request.getRequestURI());
        }
    }catch(Exception ex){
        errorMessage = "Erro ao inserir nova tarefa"+ex.getMessage();
    }
    try{
        if(request.getParameter("delete")!=null){
            String name = request.getParameter("name");
            Disciplina.deleteDisciplina(name);
            response.sendRedirect(request.getRequestURI());
        }
    }catch(Exception ex){
        errorMessage = "Erro ao excluir tarefa"+ex.getMessage();
    }
    ArrayList<String> disciplinas = new ArrayList<>();
    try{
        disciplinas = DBListenerP2.getDisciplinas();
    }catch(Exception ex){
        errorMessage = "Erro ao excluir tarefa"+ex.getMessage();
    }
%>
    
    <form>
            Nome: <input type="text" name="name" />
            Ementa: <input type="text" name="ementa" />
            Ciclo: <input type="text" name="ciclo" />
            Nota: <input type="text" name="nota" />
            <input type="submit" name="insert" value="Inserir tarefa" />
        </form>
        <hr/>
        <%if(errorMessage!=null){%>
            <div style="color: red"><%= errorMessage %></div>
            <hr/>
        <%}%>
        <h1>Disciplinas</h1>
        <table border="1">
            <tr>
                <th>Nome</th>
                <th>Ementa</th>
                <th>Ciclo</th>
                <th>Nota</th>
            </tr>
                <%for(String name: disciplinas){%>
                    <tr>
                <td><%= name %></td>
                <td>
                    <form>
                        <input type="hidden" name="name" value="<%=name%>"/>
                        <input type="submit" name="delete" value="Excluir"/>
                    </form>
                </td>
            </tr>
            <%}%>
        </table>
<jsp:include page="includes/footer.jsp" />