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
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>ASI-AC-upload</title>
    <link rel="stylesheet" href="../css/styles.css" type="text/css"/>
    <%--<link rel="stylesheet" href="../css/sweet-alert.css" type="text/css"/>--%>
    <link rel="stylesheet" href="../css/normalize.css" type="text/css"/>
    <link rel="stylesheet" href="../css/bootstrap.min.css" type="text/css">
</head>
<style rel="stylesheet" type="text/css">

    #selectFile {
        cursor: pointer;
    }

    footer .footer-content ul {
        width: 260px;
        list-style: none;
        margin: 0 65px 0 0;
        padding: 0;
    }

</style>

<body>
<div id="container">
    <header>
        <div class="width" style="text-align: center; margin-top: 8%">
            <img src="../img/国徽.jpg" style="height: 60px; width: 60px"/>
            <h1>司法案例推荐</h1>
            <h2>Nanjing University</h2>
        </div>
    </header>

    <div class="container">
        <div class="row">
            <div class="col-md-8 col-md-offset-2">
                <div class="input-group input">
                    <input id="filename" type="text" class="form-control input-lg" placeholder="上传文件名">
                    <span id="selectFile" class="input-group-addon" aria-hidden="true">
                        <span class="glyphicon glyphicon-align-left"></span>
                    </span>
                    <input type="file" style="display: none" accept="text/xml" id="fileInput" />
                    <span class="input-group-btn">
                        <button id="upload" class="btn btn-lg" type="button">上传文件</button>
                    </span>
                    <%--<span class="glyphicon glyphicon-star input-group-addon" aria-hidden="true">--%>
                    <%--<input type="file" accept="text/xml" name="file" id="file">--%>
                    <%--</span>--%>
                </div><!-- /input-group -->
            </div><!-- /.col-md-6 -->
        </div>
    </div>

    <%--<div id="body" class="width">--%>
        <%--<div style="margin: 50px; text-align: center">--%>
            <%--<form method="post" action="/upload" enctype="multipart/form-data" onsubmit="return NoFile()">--%>
                <%--<a href="javascript:" class="filename">--%>
                    <%--<input id="filename" style="width: 100%; height: 100%"/>--%>
                <%--</a>--%>
                <%--<a class="file">+--%>
                    <%--<input type="file" accept="text/xml" name="file" id="file"/>--%>
                <%--</a>--%>
                <%--<a class="file">上传--%>
                    <%--<input type="submit"/>--%>
                <%--</a>--%>
            <%--</form>--%>
        <%--</div>--%>
        <%--<div class="clear"></div>--%>
    <%--</div>--%>

    <footer class="navbar-fixed-bottom">
        <div class="footer-content">
            <div class="container">
                <div class="row">
                    <ul class="role col-md-4">
                        <li><h4>Product Owner</h4></li>
                        <li>
                            <th>冯俊杰</th>
                        </li>
                    </ul>
                    <ul class="role col-md-4">
                        <li><h4>Scrum Master</h4></li>
                        <li>
                            <th>龚尘淼</th>
                        </li>
                    </ul>
                    <ul class="role col-md-4">
                        <li><h4>Team Member</h4></li>
                        <li>
                            <th>董金玉&nbsp;&nbsp;</th>
                            <th>高源&nbsp;&nbsp;</th>
                            <th>顾恺嘉&nbsp;&nbsp;</th>
                            <th>顾逸飞&nbsp;&nbsp;</th>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
        <div class="footer-bottom">
            <p>&copy; ASI-AC 2017. <a href="/">Supreme People Court</a> by Tyga</p>
        </div>
    </footer>
</div>
</body>
<script src="../js/jquery-3.2.1.min.js"></script>
<%--<script src="../js/sweet-alert.js"></script>--%>
<script src="../js/bootstrap.min.js"></script>
<script type="text/javascript">
    $(document).ready(function () {
        $("#fileInput").change(function () {
            let filepath = $(this).val();
            let filename = filepath.substr(filepath.lastIndexOf("\\") + 1);
            $("#filename").val(filename);
        });
        function NoFile() {
            let filename = $("#file").val();
            if (filename === "") {
                swal("Oops...", "No File!", "error");
                return false;
            }
            return true;
        }

        $("#selectFile").on("click", function () {
            console.log("点击了");
            $("#fileInput").trigger("click");
        });
    });
</script>
</html>