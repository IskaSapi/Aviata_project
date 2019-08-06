<%@ page import="java.util.List" %>
<%@ page import="com.myspring.models.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!doctype html>
<html lang="en">
<jsp:include page="templates/head.jsp"></jsp:include>
<div class="cover-container d-flex w-100 h-100 p-3 mx-auto flex-column">
    <header class="masthead mb-auto">
        <div class="inner">
            <nav class="nav nav-masthead justify-content-center">

            </nav>
        </div>
    </header>
        <%
        List<Flights> flights= (List<Flights>)request.getAttribute("flights");
        List<Tickets> ticket = (List<Tickets>)request.getAttribute("ticket");
%>

    <%--<main role="main" class="inner cover">--%>
    <form action="/tickets/add" style="position: absolute;left: 300px;top:100px">
        Buy ticket
        <br>
        <input type="text" name="name" style="width: 250px" placeholder="name">
        <br>
        <input type="text" name="surname" style="width: 250px" placeholder="surname">
        <br>
        <input type="number" name="pasport" style="width: 250px" placeholder="pasport">
        <br>

        <select name="fly_id" style="width: 250px">
            <option value="" disabled selected>Route</option>
            <%for(Flights f:flights){%>
            <option value="<%=f.getId()%>"><%=f.getRoutes_id().getArrival_city_id().getShort_name()%>-<%=f.getRoutes_id().getDeparture_city_id().getShort_name()%>- : <%=f.getDeparture_time()%> </option>
            <%}%>
        </select>
        <br>
        <input type="radio" name="bus" value="econom"> Econom
        <input type="radio" name="bus" value="business"> Business<br>


        <input type="submit" class="btn btn-lg btn-secondary" style="width: 150px;height: 30px
   ;font-size: 12px;" value="add">
    </form>



    <table style="position: absolute; top: 100px; left: 600px">
        <h1 style="position: absolute; top: 30px; left: 800px">Flights</h1>
        <tr>
            <th>
                ID
            </th>
            <th>
                Route
            </th>
            <th>
                Aircraft
            </th>

            <th>
                Date
            </th>

            <th>
                Business
            </th>

            <th>
                Econom
            </th>

        </tr>
        <%for (Flights f : flights) {%>
        <tr>
            <td><%=f.getId()%>
            </td>
            <td><%=f.getRoutes_id().getArrival_city_id().getShort_name()%>-<%=f.getRoutes_id().getDeparture_city_id().getShort_name()%>
            </td>
            <td><%=f.getAircrafts_id().getName()%>
            </td>
            <td>
                <%=f.getDeparture_time()%>
            </td>
            <td>
                <%=f.getAircrafts_id().getBusiness_capacity()%>
            </td>
            <td>
                <%=f.getAircrafts_id().getEconom_capacity()%>
            </td>
        </tr>
    </>
        <%}%>




    <table style="position: absolute; top: 400px; left: 300px">
        <h1 style="position: absolute; top: 335px; left: 380px">Tickets</h1>
        <tr>
            <th>
                ID
            </th>
            <th>
                Name
            </th>
            <th>
                Surname
            </th>

            <th>
                Pasport
            </th>

            <th>
                Route
            </th>
            <th>
                Business
            </th>

        </tr>
        <%for (Tickets t : ticket) {%>
        <tr>
            <td><%=t.getId()%>
            </td>
            <td><%=t.getName()%>
            </td>
            <td><%=t.getSurname()%>
            </td>
            <td>
                <%=t.getPassport_no()%>
            </td>

            <td>
                <%=t.getFlights_id().getRoutes_id().getArrival_city_id().getShort_name()%>-<%=t.getFlights_id().getRoutes_id().getDeparture_city_id().getShort_name()%>
            </td>
            <td>
                <%=t.isBusiness()%>
            </td>
        </tr>
    </>
        <%}%>

