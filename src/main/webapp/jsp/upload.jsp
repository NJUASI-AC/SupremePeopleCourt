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

    <script src="../js/jquery-3.2.1.min.js"></script>
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
                <li class="start selected"><a href="../jsp/upload.jsp">上传案件</a></li>
                <li><a href="../jsp/contact.jsp">联系我们</a></li>
            </ul>
        </div>
    </nav>


    <div id="body" class="width" style="height: 450px">
        <div style="margin: 20px; text-align: center">
            <form method="post" action="/upload" enctype="multipart/form-data">
                <a href="javascript:" class="file">选择文件
                    <input type="file" accept="text/xml" name="file" id="file"/>
                </a>
                <p id="filename">文件名</p>
                <a href="javascript:" class="file">上传
                    <input type="submit"/>
                </a>
            </form>
            <script type="text/javascript">
                $("#file").change(function(){
                    let filepath = $(this).val();
                    let filename = filepath.substr(filepath.lastIndexOf("\\")+1);
                    $("#filename").text("文件名：" + filename);
                });
            </script>
        </div>
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