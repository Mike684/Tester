<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Mike
  Date: 12.05.2017
  Time: 23:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<html>
<head>
    <title>Main page</title>
    <script src="https://code.jquery.com/jquery-1.11.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/jquery.validate.min.js"></script>
    <script src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/additional-methods.min.js"></script>
    <link href="<c:url value="/bootstrap/css/bootstrap.min.css"/>" rel="stylesheet">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="<c:url value="/js/create_blank.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/js/delete_blank.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/js/validator.js"/>"></script>
    <style>
        .quiz-wrapper{
            padding-top:40px;
        }
        .field-wrapper{
            margin:15px;
        }
    </style>
</head>
<body>
    <jsp:include page="header.jsp" />
    <div class="container quiz-wrapper">
        <div class="row">
            <div class="col-lg-11">
                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header"><label>${question.text}</label>
                            <input type="hidden" id="questionID" value="${question.questionID}">
                        </h1>
                    </div>
                </div>
                <div class="table-responsive" border="1">
                    <table class="table table-bordered" id="blanks">
                        <c:forEach items="${blanks}" var="blank">
                            <tr id="${blank.blankID}">
                                <td><p id="blAnswer"><c:out value="${blank.answer}"/></p></td>
                                <td><input class="btn btn-danger" type="submit"  name="deleteBl" value="Delete" id="deleteBl" onclick="del('${blank.blankID}')"/></td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
                <div>
                    <input class="btn btn-success" type="submit"  name="btnAddQuiz" value="Add"
                           data-toggle="modal" data-target="#myModal"/>
                </div>
                <div id="resultreturn" style="display: none"></div>
            </div>
        </div>
    </div>

    <!-- Modal -->
    <div class="modal fade" id="myModal" role="dialog">
        <div class="modal-dialog">

            <!-- Modal content-->
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title">Question creating</h4>
                </div>
                <form id="blForm">
                <div class="modal-body">
                    <div class="form-group">
                        <div class="row field-wrapper">
                            <input class="form-control" placeholder="Answer" name="answer" type="text" id="answer">
                        </div>
                    </div>
                </div>
                </form>
                <div class="modal-footer">
                    <button type="button" class="btn btn-success" data-dismiss="modal" id="bAdd">Create</button>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
