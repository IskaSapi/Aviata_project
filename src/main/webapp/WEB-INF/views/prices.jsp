<%@ page import="com.myspring.models.Aircrafts" %>
<%@ page import="java.util.List" %>
<%@ page import="com.myspring.models.Countries" %>
<%@ page import="com.myspring.models.Flights" %>
<%@ page import="com.myspring.models.Prices" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!doctype html>
<html lang="en">
<jsp:include page="templates/head.jsp"></jsp:include>
<div class="cover-container d-flex w-100 h-100 p-3 mx-auto flex-column">
    <header class="masthead mb-auto">
        <div class="inner">
            <h3 class="masthead-brand">Prices</h3>
            <nav class="nav nav-masthead justify-content-center">

            </nav>
        </div>
    </header>
        <%
        List<Flights> flights= (List<Flights>)request.getAttribute("flights");
        List<Prices> prices = (List<Prices>) request.getAttribute("price");
%>

    <%--<main role="main" class="inner cover">--%>
    <form action="/price/add" style="position: absolute;left: 300px;top:100px">
        Add price
        <br>
        <input type="number" name="econom" style="width: 250px; left: 300px;top:100px" placeholder="Econom">
        <br>
        <input type="number" name="business" style="width: 250px; left: 300px;top:100px" placeholder="Business">
        <br>
        <select name="flight_id" style="width: 250px">
            <option value="" disabled selected>Routes</option>
            <%for(Flights f:flights){%>
            <option value="<%=f.getId()%>"><%=f.getRoutes_id().getArrival_city_id().getShort_name()%>-<%=f.getRoutes_id().getDeparture_city_id().getShort_name()%></option>
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
                Business
            </th>
            <th>
                Econom
            </th>

            <th>
                Route
            </th>

            <th>
                Activity
            </th>

        </tr>
        <%for (Prices p : prices) {%>
        <tr>
            <td><%=p.getId()%>
            </td>
            <td><%=p.getBusiness_value()%>
            </td>
            <td><%=p.getEconom_value()%>
            </td>
            <td>
                <%=p.getFlight().getRoutes_id().getDeparture_city_id().getShort_name()%>-<%=p.getFlight().getRoutes_id().getArrival_city_id().getShort_name()%>
            </td>
            <td>
                <form action="/price/delete/<%=p.getId()%>">
                    <input type="submit" class="btn btn-lg btn-secondary" style="width: 65px;height: 30px
   ;font-size: 11px;" value="Delete">
                </form>
            </td>
        </tr>
    </>
        <%}%>

    <jsp:include page="templates/footer.jsp"></jsp:include>
