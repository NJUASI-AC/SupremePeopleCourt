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
                <li class="start selected"><a href="index.html">Home</a></li>
                <li class=""><a href="upload.html">Upload</a></li>
                <li class="end"><a href="contact.html">Contact</a></li>
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
                    <h4>Categories</h4>
                    <ul>
                        <li><a href="../jsp/index.jsp">主页</a></li>
                        <li><a href="../jsp/upload.jsp">上传案件</a></li>
                        <li><a href="../jsp/contact.jsp">联系我们</a></li>
                    </ul>
                </li>

                <li>
                    <h4>About us</h4>
                    <ul>
                        <li class="text">
                            <p style="margin: 0;">ASI-AC<a href="contact.html" class="readmore">Read More &raquo;</a></p>
                        </li>
                    </ul>
                </li>

                <li>
                    <h4>Search site</h4>
                    <ul>
                        <li class="text">
                            <form method="get" class="searchform" action="#" >
                                <p>
                                    <input type="text" size="32" value="" name="search" class="s" />
                                </p>
                            </form>
                        </li>
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
            <h2>推荐案例</h2>
            <div class="seperator" style="width: 100%;background-color: black"></div>
            <c:choose>
                <c:when test="${analyseInfo.size()!=0}">
                    <div>
                        <c:forEach var="item" items="${analyseInfo}">
                            <div class="recommend-single-wrap">
                                <h4>${item.caseID}</h4>
                                <table style="width: 100%;padding: 3px; text-align: center;" align="center" class="single-info">
                                    <tr>
                                        <td>指数</td>
                                        <td>${item.weight}</td>
                                        <td>法院</td>
                                        <td>${item.handlingCourt}</td>
                                    </tr>
                                    <tr>
                                        <td>案由</td>
                                        <td>${item.actionCause}</td>
                                        <td>类型</td>
                                        <td>${item.nameOfDocument.repre}</td>
                                    </tr>
                                </table>
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

</script>
</html>