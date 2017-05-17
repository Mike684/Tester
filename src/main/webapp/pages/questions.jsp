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
<head>
    <title>Questions</title>
    <script src="https://code.jquery.com/jquery-1.11.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/jquery.validate.min.js"></script>
    <script src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/additional-methods.min.js"></script>
    <link href="<c:url value="/bootstrap/css/bootstrap.min.css"/>" rel="stylesheet">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="<c:url value="/js/create_question.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/js/delete_question.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/js/validator.js"/>"></script>
    <style>
        .quiz-wrapper{
            padding-top:40px;
        }
        .field-wrapper{
            margin-top:15px;
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
                        <h1 class="page-header">
                            <label id="qzTheme">${quiz.theme}</label>
                            <input type="hidden" id="quizID" name="quizID" value="${quiz.quizID}">
                        </h1>
                    </div>
                </div>
                <div class="table-responsive" border="1">
                    <table class="table table-bordered" id="questions">
                        <c:forEach items="${questions}" var="question">
                            <tr id="${question.questionID}">
                                <td><p id="qsText"><c:out value="${question.text}"/></p></td>
                                <td><p id="qsType"><c:out value="${question.type}"/></p></td>
                                <td><input class="btn btn-warning" type="submit"  name="editQz" value="Edit" id="editQz" onclick="window.location='options?id=${question.questionID}&type=${question.type}'"/></td>
                                <td><input class="btn btn-danger" type="submit"  name="deleteQz" value="Delete" id="deleteQz" onclick="del('${question.questionID}')"/></td>
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
                <form id="qsForm">
                <div class="modal-body">
                    <div class="form-group">

                        <div class="row">
                            <input class="form-control field-wrapper" placeholder="Question" name="question" type="text" id="question">
                        </div>
                        <div class="row">
                            <select class="selectpicker form-control field-wrapper" id="type" name="type" title="Select question type">
                                <option>TEST</option>
                                <option>MTEST</option>
                                <option>BLANK</option>
                                <option>ESSAY</option>
                            </select>
                        </div>
                        <div class="row">
                            <input class="form-control field-wrapper" placeholder="MaxMark" name="mark" type="text" id="mark">
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
