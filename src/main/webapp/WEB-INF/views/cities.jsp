<%@ page import="com.myspring.models.Aircrafts" %>
<%@ page import="java.util.List" %>
<%@ page import="com.myspring.models.Countries" %>
<%@ page import="com.myspring.models.Cities" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!doctype html>
<html lang="en">
<jsp:include page="templates/head.jsp"></jsp:include>
<div class="cover-container d-flex w-100 h-100 p-3 mx-auto flex-column">
    <header class="masthead mb-auto">
        <div class="inner">
            <h3 class="masthead-brand">Cities</h3>
            <nav class="nav nav-masthead justify-content-center">

            </nav>
        </div>
    </header>
        <%
        List<Cities> cities= (List<Cities>)request.getAttribute("cities");
        List<Countries> countries= (List<Countries>)request.getAttribute("countries");%>

    <%--<main role="main" class="inner cover">--%>
    <form action="/city/add" style="position: absolute;left: 300px;top:100px">
        Add city
        <br>
        <input type="text" name="name" style="width: 250px;left: 300px;top:100px"  placeholder="name">
        <br>
        <input type="text" name="short_name" style="width: 250px" placeholder="short name">
        <br>
            <select name="country_id" style="width: 250px">
                <option value="" disabled selected>COUNTRY</option>
                <%for(Countries c:countries){%>
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
                NAME
            </th>
            <th>
                Short Name
            </th>

            <th>
                Activity
            </th>

        </tr>
        <%for (Cities c : cities) {%>
        <tr>
            <td><%=c.getId()%>
            </td>
            <td><%=c.getName()%>
            </td>
            <td><%=c.getShort_name()%>
            </td>
            <td>
                <form action="/city/delete/<%=c.getId()%>">
                    <input type="submit" class="btn btn-lg btn-secondary" style="width: 65px;height: 30px
   ;font-size: 11px;" value="Delete">
                </form>
            </td>
        </tr>
    </>
        <%}%>

    <jsp:include page="templates/footer.jsp"></jsp:include>
