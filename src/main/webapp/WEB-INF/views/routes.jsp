<%@ page import="com.myspring.models.Aircrafts" %>
<%@ page import="java.util.List" %>
<%@ page import="com.myspring.models.Countries" %>
<%@ page import="com.myspring.models.Cities" %>
<%@ page import="com.myspring.models.Routes" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!doctype html>
<html lang="en">
<jsp:include page="templates/head.jsp"></jsp:include>
<div class="cover-container d-flex w-100 h-100 p-3 mx-auto flex-column">
    <header class="masthead mb-auto">
        <div class="inner">
            <h3 class="masthead-brand">Routes</h3>
            <nav class="nav nav-masthead justify-content-center">

            </nav>
        </div>
    </header>
        <%
        List<Cities> cities= (List<Cities>)request.getAttribute("cities");
        List<Routes> routes= (List<Routes>)request.getAttribute("routes");
        %>

    <%--<main role="main" class="inner cover">--%>
    <form action="/route/add" style="position: absolute;left: 300px;top:100px">
        Add route
        <br>
        <select name="city_arr" style="width: 250px">
            <option value="" disabled selected>Arrival</option>
            <%for(Cities c:cities){%>
            <option value="<%=c.getId()%>"><%=c.getName()%></option>
            <%}%>
        </select>
        <br>
        <select name="city_dest" style="width: 250px">
            <option value="" disabled selected>Destination</option>
            <%for(Cities c:cities){%>
            <option value="<%=c.getId()%>"><%=c.getName()%></option>
            <%}%>
        </select>
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
                Arrival City
            </th>
            <th>
                Departure City
            </th>

            <th>
                Activity
            </th>

        </tr>
        <%for (Routes r : routes) {%>
        <tr>
            <td><%=r.getId()%>
            </td>
            <td><%=r.getArrival_city_id().getShort_name()%>
            </td>
            <td><%=r.getDeparture_city_id().getShort_name()%>
            </td>
            <td>
                <form action="/route/delete/<%=r.getId()%>">
                    <input type="submit" class="btn btn-lg btn-secondary" style="width: 65px;height: 30px
   ;font-size: 11px;" value="Delete">
                </form>
            </td>
        </tr>
    </>
        <%}%>

    <jsp:include page="templates/footer.jsp"></jsp:include>
