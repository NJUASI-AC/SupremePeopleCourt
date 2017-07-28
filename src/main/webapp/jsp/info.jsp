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
    <link rel="stylesheet" href="../css/spinner.css" type="text/css"/>
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
        <section id="content">
            <article>
                <div>
                    <h3>${caseInfo.header.caseNum}${caseInfo.header.nameOfDocument}</h3>
                </div>

                <div class="seperator" style="background-color: #535354; width: 100%;"></div>
                <div>
                    <%request.setAttribute("vEnter", " ");%>
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    ${fn:replace(caseInfo.fullText.text,vEnter,'<br/><br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;')}
                </div>
            </article>

        </section>

        <aside class="sidebar">
            <ul>
                <li>
                    <h4 style="border-bottom: none">
                        <a href="../jsp/upload.jsp" id="upload2">上传新的案例</a>
                    </h4>
                </li>
                <li>
                    <h4>案例信息</h4>
                    <ul>
                        <li>案号：<span>${caseInfo.header.caseNum}</span></li>
                        <li>法院：<span>${caseInfo.header.handlingCourt}</span></li>
                        <li>案由：<span>${caseInfo.proceedings.mainActionCause.actionCause}</span></li>
                        <li>文书名称：<span>${caseInfo.header.nameOfDocument}</span></li>
                        <li>程序：<span>${caseInfo.header.trialProcedure.repre}</span></li>
                    </ul>
                </li>

                <li>
                    <h4>诉讼参与者</h4>
                    <ul>
                        <c:forEach var="item" items="${caseInfo.litigationParticipants.litigants}">
                            <li>${item.partiesType}：
                                <span>${item.name}</span></li>
                        </c:forEach>
                    </ul>
                </li>

                <li>
                    <h4>帮助链接</h4>
                    <ul>
                        <li><a href="http://wenshu.court.gov.cn" title="web hosting">中国裁判文书网</a></li>
                        <li>
                            <a href="http://baike.baidu.com/link?url=0Ty6udmTRGaKZWVruL-W_YqaqqSxVVEe7OC4rKZJr4TQu4y1sf16qk-8h3YRND9hPkO-iXoE3UqjPfYc6Ag9xmh9uRBOU29NjKPvJ0Oe5eJB2iBmaNijyakI8sHO0WZ8"
                               title="web hosting">裁判文书</a></li>
                    </ul>
                </li>

            </ul>

        </aside>
        <div class="clear"></div>

        <div>
            <h3>推荐案例</h3>
            <div class="seperator" style="width: 100%;background-color: black"></div>
            <div class="spinner" id="spinner">
                <div class="rect1"></div>
                <div class="rect2"></div>
                <div class="rect3"></div>
                <div class="rect4"></div>
                <div class="rect5"></div>
            </div>
            <div id="list"></div>

        </div>
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
    $(document).ready(function(){
        reqRecommendation()
    });

    function reqRecommendation() {

        $.ajax({
            type: "get",
            async: true,
            url: "/reqRecommendation",
            contentType: "charset=UTF-8",
            data: {
                "caseID": "${caseInfo.caseID}"
            },

            success: function (result) {
                // 动态加入推荐案例信息

                $("#spinner").style="display:none";

                let array = result.split(";");
                let size = eval("(" + array[0] + ")");
                let weight = eval("(" + array[1] + ")");
                let detailMessages = eval("(" + array[2] + ")");
                $("#list").empty();
                for (let i = 0; i < detailMessages.length; i++) {
                    $("#list").append("<div class='recommend-single-wrap' name='cases' onclick='showDetail("+i+")'>" +
                        "<h4 style='color: #00A0EB'>" + weight[i]["caseNum"]+weight[i]["nameOfDocument"] + "</h4>" +
                        "<table style='width: 100%;padding: 3px; text-align: center;' align='center' class='single-info'>" +
                        "<tr>" +
                        "<td>指数</td>" +
                        "<td>" + weight[i]["weight"] + "</td>" +
                        "<td>法院</td>" +
                        "<td>" + weight[i]["handlingCourt"] + "</td>" +
                        "</tr>" +
                        "<tr>" +
                        "<td>案由</td>" +
                        "<td>" + weight[i]["actionCause"] + "</td>" +
                        "<td>类型</td>" +
                        "<td>" + weight[i]["nameOfDocument"] + "</td>" +
                        "</tr>" +
                        "</table>" +
                        "</div>" +
                        "<div style='display:none' name='details' value='0'>" +
                        "<p>" +detailMessages[i]["caseBasic"]["paragraphThisTrial"]+ "</p>" +
                        "<p>" +detailMessages[i]["caseBasic"]["defenceOpinion"]+ "</p>" +
                        "<p>" +detailMessages[i]["judgementResult"]["result"]+ "</p>" +
                        "</div>");
                }
            },
            error: function (result) {
                console.log("错误" + result);
            }
        });
    }


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