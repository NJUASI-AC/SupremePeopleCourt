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
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>ASI-AC</title>
    <link rel="stylesheet" href="../css/styles.css" type="text/css" />
    <link rel="stylesheet" href="../css/normalize.css" type="text/css" />
    <!--[if lt IE 9]>
    <script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->
</head>
<body>
<div id="container">
    <header>
        <div class="width">
            <h1>Supreme People Court<span>-AC</span></h1>
            <h2>Nanjing University&nbsp;南京大学</h2>
        </div>
    </header>
    <nav>
        <div class="width">
            <ul>
                <li class=""><a href="../jsp/upload.jsp">Upload</a></li>
            </ul>
        </div>
    </nav>


    <div id="body" class="width">
        <section id="content">
            <article>
                <div>
                    <h3>${caseInfo.header.caseID}</h3>
                </div>

                <div class="seperator" style="background-color: #535354; width: 100%;"></div>
                <div>
                    <%request.setAttribute("vEnter", "\r\n");%>
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    ${fn:replace(caseInfo.fullText.text,vEnter,'<br/><br/>&nbsp;&nbsp;&nbsp;&nbsp;')}
                </div>
            </article>

        </section>

        <aside class="sidebar">
            <ul>
                <li>
                    <h4>Case Information</h4>
                    <ul>
                        <li>案号：<span>${caseInfo.header.caseNum}</span></li>
                        <li>法院：<span>${caseInfo.header.handlingCourt}</span></li>
                        <li>案由：<span>${caseInfo.proceedings.actionCause}</span></li>
                        <li>类型：<span>${caseInfo.header.nameOfDocument.repre}</span></li>
                        <li>程序：<span>${caseInfo.header.trialProcedure.repre}</span></li>
                    </ul>
                </li>

                <li>
                    <h4>Litigation Participants</h4>
                    <ul>
                        <c:forEach var="item" items="${caseInfo.litigationParticipants.litigants}">
                                <li>${item.litigantType.repre}：
                                    <span>${item.name}</span></li>
                        </c:forEach>
                    </ul>
                </li>

                <li>
                    <h4>Helpful Links</h4>
                    <ul>
                        <li><a href="http://wenshu.court.gov.cn" title="web hosting">中国裁判文书网</a></li>
                        <li><a href="http://baike.baidu.com/link?url=0Ty6udmTRGaKZWVruL-W_YqaqqSxVVEe7OC4rKZJr4TQu4y1sf16qk-8h3YRND9hPkO-iXoE3UqjPfYc6Ag9xmh9uRBOU29NjKPvJ0Oe5eJB2iBmaNijyakI8sHO0WZ8" title="web hosting">裁判文书</a></li>
                    </ul>
                </li>

            </ul>

        </aside>
        <div class="clear"></div>

        <div>
            <h3>推荐案例</h3>
            <div class="seperator" style="width: 100%;background-color: black"></div>
            <c:choose>
                <c:when test="${analyseInfo.size()!=0}">
                    <div>
                        <c:forEach step="1" begin="0" end="4" var="i">
                            <div class="recommend-single-wrap" onclick="showDetail(${i})">
                                <h4 style="color: #00A0EB">${analyseInfo.get(i).caseID}</h4>
                                <table style="width: 100%;padding: 3px; text-align: center;" align="center" class="single-info">
                                    <tr>
                                        <td>指数</td>
                                        <td>${analyseInfo.get(i).weight}</td>
                                        <td>法院</td>
                                        <td>${analyseInfo.get(i).handlingCourt}</td>
                                    </tr>
                                    <tr>
                                        <td>案由</td>
                                        <td>${analyseInfo.get(i).actionCause}</td>
                                        <td>类型</td>
                                        <td>${analyseInfo.get(i).nameOfDocument.repre}</td>
                                    </tr>
                                </table>
                            </div>
                            <div style="display: none" name="details" value="0">
                                <p>${detail.get(i).caseBasic.plaintiffClaim}</p>
                                <p>${detail.get(i).caseBasic.defendantArgue}</p>
                                <c:forEach var="item" items="${detail.get(i).caseBasic.evidence}">
                                    <p>${item}</p>
                                </c:forEach>
                                <c:forEach var="item2" items="${detail.get(i).caseBasic.facts}">
                                    <p>${item2}</p>
                                </c:forEach>
                            </div>
                        </c:forEach>
                    </div>

                </c:when>
                <c:when test="${list.size()==0}">
                    <div>
                        未搜索到推荐案例
                    </div>
                </c:when>
            </c:choose>
        </div>
    </div>



    <footer>
        <div class="footer-content width">
            <ul>
                <li><h4>Product Owner</h4></li>
                <li>
                    <th>冯俊杰</th>
                </li>
            </ul>
            <ul>
                <li><h4>Scrum Master</h4></li>
                <li>
                    <th>龚尘淼</th>
                </li>
            </ul>
            <ul class="endfooter">
                <li><h4>Team Member</h4></li>
                <li>
                    <th>董金玉&nbsp;&nbsp;</th>
                    <th>高源&nbsp;&nbsp;</th>
                    <th>顾恺嘉&nbsp;&nbsp;</th>
                    <th>顾逸飞&nbsp;&nbsp;</th>
                </li>
            </ul>

            <div class="clear"></div>
        </div>
        <div class="footer-bottom">
            <p>&copy; ASI-AC 2017. <a href="index.html">Supreme People Court</a> by Tyga</p>
        </div>
    </footer>
</div>
</body>

<script>
    function showDetail(i) {
        var details=document.getElementsByName('details');
        for(var j=0;j<5;j++){
            if(j==i){
                if(details[j].value==1){
                    details[j].style='display:none';
                    details[j].value=0;
                }else{
                    details[j].style='display:';
                    details[j].value=1;
                }
            }else{
                details[j].style='display:none';
            }
        }

    }
</script>
</html>