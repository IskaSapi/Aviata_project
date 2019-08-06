<%@ page import="com.myspring.models.Aircrafts" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!doctype html>
<html lang="en">
<jsp:include page="templates/head.jsp"></jsp:include>
<div class="cover-container d-flex w-100 h-100 p-3 mx-auto flex-column">
    <header class="masthead mb-auto">
        <div class="inner">
            <h3 class="masthead-brand">Aircrafts</h3>
            <nav class="nav nav-masthead justify-content-center">

            </nav>
        </div>
    </header>
        <%
        List<Aircrafts> aircrafts= (List<Aircrafts>)request.getAttribute("aircraftList");%>

    <%--<main role="main" class="inner cover">--%>
    <form action="/air/add" style="position: absolute;left: 300px;top:100px">
        Add aircraft
        <br>
        <input type="text" name="name" style="width: 250px" placeholder="name">
        <br>
        <input type="text" name="model" style="width: 250px" placeholder="model">
        <br>
        <input type="number" name="business" style="width: 250px" placeholder="business capacity">
        <br>
        <input type="number" name="econom" style="width: 250px" placeholder="econom capacity">
        <br>
        <br>
        <input type="submit" class="btn btn-lg btn-secondary" style="width: 150px;height: 30px
   ;font-size: 12px;" value="add">
    </form>



    <table style="position: absolute; top: 100px; left: 600px">
        <tr>
            <th>
                ID
            </th>
            <th>
                NAME
            </th>
            <th>
                MODEL
            </th>

            <th>
                Econom Capacity
            </th>

            <th>
                Business Capacity
            </th>

            <th>
                Activity
            </th>

        </tr>
        <%for(Aircrafts air:aircrafts){%>
        <tr>
            <td><%=air.getId()%></td>
            <td><%=air.getName()%></td>
            <td><%=air.getModel()%></td>
            <td><%=air.getEconom_capacity()%></td>
            <td><%=air.getBusiness_capacity()%></td>
            <td>
                <form action="/air/delete/<%=air.getId()%>">
                    <input type="submit" class="btn btn-lg btn-secondary" style="width: 65px;height: 30px
   ;font-size: 11px;" value="Delete">
                </form>
            </td>
        </tr>
        </>

        <%}%>

        <jsp:include page="templates/footer.jsp"></jsp:include>
