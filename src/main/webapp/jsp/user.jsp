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
    <link rel="stylesheet" href="../css/bootstrap.min.css" type="text/css">
    <script src="../js/jquery-3.2.1.min.js"></script>
    <script src="../js/bootstrap.min.js"></script>
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

        <h3>历史案例</h3>
        <div class="seperator" style="width: 100%;background-color: black"></div>

        <c:set var="perPage" value="7" scope="page"/>
        <c:set var="totalPage" value="${(cases.size()-(cases.size()%perPage))/perPage}"/>
        <c:choose>
            <c:when test="${cases.size()!=0}">
                <c:forEach begin="0" end="${totalPage}" var="i">
                    <div class="page${i==0?" active":""}" id="page${i+1}">
                        <c:forEach begin="0" end="${perPage-1}" var="j">
                            <c:if test="${cases.size()>i*perPage+j}">
                                <div class="recommend-single-wrap" onclick="showDetail(${i*perPage+j})">
                                    <h4 style='color: #00A0EB'>${cases.get(i*perPage+j).header.caseNum}${cases.get(i*perPage+j).header.nameOfDocument}</h4>
                                    <table style="width: 100%;padding: 3px; text-align: center;" align="center" class="single-info">
                                        <tr>
                                            <td>法院</td>
                                            <td>${cases.get(i*perPage+j).header.handlingCourt}</td>
                                            <td>案由</td>
                                            <td>${cases.get(i*perPage+j).proceedings.mainActionCause.actionCause}</td>
                                            <td>类型</td>
                                            <td>${cases.get(i*perPage+j).header.nameOfDocument}</td>
                                        </tr>
                                    </table>
                                </div>
                                <div style='display:none' class='details'>

                                </div>
                            </c:if>
                        </c:forEach>
                    </div>
                </c:forEach>
            </c:when>
            <c:when test="${cases.size()==0}">
                <div>
                    无上传案件文档
                </div>
            </c:when>
        </c:choose>
        <c:if test="${totalPage>0}">
            <div>
                <ul class="pagination" id="pageination">
                    <c:forEach var="i" begin="1" end="${totalPage+1}">
                        <li class="${i==1?"active":""}"><a href="#page${i}" data-toggle="tab">${i}</a></li>
                    </c:forEach>

                </ul>
                <script type="text/javascript" language="JavaScript">
                    $("#pageination a").click(function(){
                        if($(".pagination").eq(i).is(":hidden")){
                            $(".pagination").toggle(false);
                            $(".pagination").eq(i).slideToggle();
                        }else{

                        }
                    });
                </script>
            </div>
        </c:if>
    </div>


    <footer class="navbar-fixed-bottom" style="border-top-width:0px ;margin-top: 20px;position: relative">
        <div class="footer-bottom">
            <p>&copy; ASI-AC 2017. <a href="/">Supreme People Court</a> by Tyga</p>
        </div>
    </footer>
</div>
</body>

<script src="../js/jquery-3.2.1.min.js"></script>
<script>
    function showDetail(i) {
        var caseID = "${cases.get(i).caseID}";
        window.location.href="/view/"+caseID;

    }
</script>
</html>