<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%--
  Created by IntelliJ IDEA.
  User: cuihua
  Date: 2017/7/17
  Time: 下午8:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>ASI-AC</title>
    <link rel="stylesheet" href="../css/styles.css" type="text/css"/>
    <link rel="stylesheet" href="../css/normalize.css" type="text/css"/>
    <!--[if lt IE 9]>
    <script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->
</head>
<body>
<div id="container">
    <header>
        <div class="width">
            <h1>司法案例推荐</h1>
            <h2>Nanjing University&nbsp;南京大学</h2>
        </div>
    </header>

    <div style="height: 5px; width: 1200px; margin: 0 auto; background-color: #00A0EB"></div>

    <div id="body" class="width">
        <c:set var="perPage" value="7" scope="page"/>
        <c:set var="totalPage" value="${(list.size()-(list.size()%perPage))/perPage}"/>
        <c:choose>
            <c:when test="${list.size()!=0}">
                <c:forEach begin="0" end="${totalPage}" var="i">
                    <div class="page${i==0?" active":""}" id="page${i+1}">
                        <c:forEach begin="0" end="${perPage-1}" var="j">
                            <c:if test="${list.size()>i*perPage+j}">
                                <div class="recommend-single-wrap">
                                    <h4 style='color: #00A0EB'></h4>
                                    <table style="width: 100%;padding: 3px; text-align: center;" align="center" class="single-info">
                                        <tr>
                                            </tr>
                                        <tr>
                                            </tr>
                                    </table>
                                </div>
                            </c:if>
                        </c:forEach>
                    </div>
                </c:forEach>
            </c:when>
            <c:when test="${list.size()==0}">
                <div>
                    无上传案件文档
                </div>
            </c:when>
        </c:choose>
    </div>


    <footer class="navbar-fixed-bottom" style="border-top-width:0px ">
        <div class="footer-bottom">
            <p>&copy; ASI-AC 2017. <a href="/">Supreme People Court</a> by Tyga</p>
        </div>
    </footer>
</div>
</body>

<script src="../js/jquery-3.2.1.min.js"></script>
<script>
    function showDetail(i) {
        let details = document.getElementsByName('details');
        for (let j = 0; j < 5; j++) {
            if (j == i) {
                if (details[j].value == 1) {
                    details[j].style = 'display:none';
                    details[j].value = 0;
                } else {
                    details[j].style = 'display:';
                    details[j].value = 1;
                }
            } else {
                details[j].style = 'display:none';
            }
        }

    }
</script>
</html>