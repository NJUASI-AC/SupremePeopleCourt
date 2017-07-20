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
    <link rel="stylesheet" href="../css/normalize.css" type="text/css" />
    <!--[if lt IE 9]>
    <script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

    <script src="../js/jquery-3.2.1.min.js"></script>
</head>
<body>
<div id="container">
    <header>
        <div class="width" style="text-align: center; margin-top: 8%">
            <img src="../img/国徽.jpg" style="height: 60px; width: 60px"/>
            <h1>司法案例推荐</h1>
            <h2>Nanjing University</h2>
        </div>
    </header>

    <div id="body" class="width">
        <div style="margin: 50px; text-align: center">
            <form method="post" action="/upload" enctype="multipart/form-data">
                <p class="filename" id="filename">&nbsp;</p>
                <a href="javascript:" class="file">+
                    <input type="file" accept="text/xml" name="file" id="file"/>
                </a>
                <a href="javascript:" class="file">上传
                    <input type="submit"/>
                </a>
            </form>
            <script type="text/javascript">
                $("#file").change(function(){
                    let filepath = $(this).val();
                    let filename = filepath.substr(filepath.lastIndexOf("\\")+1);
                    $("#filename").text(filename);
                });
            </script>
        </div>
        <div class="clear"></div>
    </div>

    <footer style="position: absolute; bottom: 0; left: 0; right: 0">
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