<%--
  Created by IntelliJ IDEA.
  User: cuihua
  Date: 2017/7/17
  Time: 下午8:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>ASI-AC-upload</title>
    <link rel="stylesheet" href="../css/styles.css" type="text/css" />
    <!--[if lt IE 9]>
    <script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

    <script src="../js/jquery.js"></script>
    <script src="../js/upload.js"></script>
    <script src="../js/ajaxfileupload.js"></script>
</head>
<body>
<div id="container">
    <header>
        <div class="width">
            <h1>Supreme People Court<span>-AC</span></h1>
            <h2>Nanjing University</h2>
        </div>
    </header>
    <nav>
        <div class="width">
            <ul>
                <li><a href="../jsp/index.jsp">主页</a></li>
                <li><a href="../jsp/upload.jsp">上传案件</a></li>
                <li><a href="../jsp/contact.jsp">联系我们</a></li>
            </ul>
        </div>
    </nav>


    <div id="body" class="width">
        <section id="content">
            <article>
                <div class="article-info">Posted on <time datetime="2017-07-16">16 July</time> by <a href="#" rel="author">TygaGu</a></div>

                <h3>Upload xml file at here:</h3>

                <div style="margin: 20px">
                    <a href="javascript:" class="file">选择文件
                        <input type="file" accept="text/xml" id="file">
                    </a>
                    <p id="filename">文件名</p>
                </div>
                <div style="margin: 20px">
                    <button id="upload">UPLOAD</button>
                </div>
            </article>
        </section>

        <aside class="sidebar">
            <ul>
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
            <p>&copy; ASI-AC 2017. <a href="/">Supreme People Court</a> by Tyga</p>
        </div>
    </footer>
</div>
</body>
</html>