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
            <h3 class="masthead-brand">Flights</h3>
            <nav class="nav nav-masthead justify-content-center">

            </nav>
        </div>
    </header>
        <%
        List<Aircrafts> aircrafts= (List<Aircrafts>)request.getAttribute("aircrafts");
        List<Flights> flights= (List<Flights>)request.getAttribute("flights");
        List<Routes> routes= (List<Routes>)request.getAttribute("routes");
%>

    <%--<main role="main" class="inner cover">--%>
    <form action="/fly/add" style="position: absolute;left: 300px;top:100px">
        Add flight
        <br>
        <input type="datetime-local" name="date" style="width: 250px;left: 300px;top:100px"  placeholder="name">
        <br>
        <select name="aircraft_id" style="width: 250px">
            <option value="" disabled selected>Aircraft</option>
            <%for(Aircrafts a:aircrafts){%>
            <option value="<%=a.getId()%>"><%=a.getName()%></option>
            <%}%>
        </select>
        <br>

        <select name="route_id" style="width: 250px">
            <option value="" disabled selected>Route</option>
            <%for(Routes r:routes){%>
            <option value="<%=r.getId()%>"><%=r.getDeparture_city_id().getShort_name()%>-<%=r.getArrival_city_id().getShort_name()%></option>
            <%}%>
        </select>
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
                Route
            </th>
            <th>
                Aircraft
            </th>
            <th>
                Date
            </th>

            <th>
                Activity
            </th>

        </tr>
        <%for (Flights f : flights) {%>
        <tr>
            <td><%=f.getId()%>
            </td>
            <td><%=f.getRoutes_id().getDeparture_city_id().getShort_name()%>-<%=f.getRoutes_id().getArrival_city_id().getShort_name()%>
            </td>
            <td><%=f.getAircrafts_id().getName()%>
            </td>
            <td>
                <%=f.getDeparture_time()%>
            </td>
            <td>
                <form action="/fly/delete/<%=f.getId()%>">
                    <input type="submit" class="btn btn-lg btn-secondary" style="width: 65px;height: 30px
   ;font-size: 11px;" value="Delete">
                </form>
            </td>
        </tr>
    </>
        <%}%>

    <jsp:include page="templates/footer.jsp"></jsp:include>
