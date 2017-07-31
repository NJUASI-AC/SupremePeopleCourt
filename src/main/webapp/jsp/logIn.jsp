
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="modal fade" id="login" tabindex="-1" role="dialog" aria-labelledby="loginLabel" aria-hidden="true">
    <div class="modal-dialog" style="width:30%">
        <div class="modal-content">
            <div class="modal-header text-center">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="loginLabel">登录</h4>
            </div>
            <div class="modal-body">
                <form id="loginForm" class="form-horizontal" role="form">
                    <div class="form-group">
                        <label class="col-md-3 control-label" for="login_username">用户名：</label>
                        <div class="col-md-7">
                            <input type="text" class="form-control" id="login_username" name="login_username" placeholder="请输入用户名">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-3 control-label" for="login_password">密码：</label>
                        <div class="col-md-7">
                            <input type="password" class="form-control" id="login_password" id="login_password" placeholder="请输入密码">
                        </div>
                    </div>
                    <strong class="col-md-offset-4" style="color:red;" id="errorMessageField"></strong>
                    <div class="row">
                    <li class="col-md-offset-7 col-md-5"><a href="#" data-toggle="modal" data-target="#register">没有账户？</a></li>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <div class="login-btn-group">
                    <button type="button" class="btn btn-primary" onclick="login()">登录</button>
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                </div>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>
<div class="modal fade" id="register" tabindex="-1" role="dialog" aria-labelledby="loginLabel" aria-hidden="true">
    <div class="modal-dialog" style="width:30%">
        <div class="modal-content">
            <div class="modal-header text-center">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="registerLabel">注册</h4>
            </div>
            <div class="modal-body" style="margin-left: 40px">
                <form id="registerForm" class="form-horizontal" role="form">
                    <div class="form-group">
                        <label class="col-md-3 control-label" for="reg_username" style="padding-left: 0">工作编号：</label>
                        <div class="col-md-7">
                            <input type="text" class="form-control" id="reg_username" name="reg_username" placeholder="请输入用户名">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-3 control-label" for="reg_password" style="padding-left: 0">用户密码：</label>
                        <div class="col-md-7">
                            <input type="password" class="form-control" id="reg_password" name="reg_password" placeholder="请输入密码">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-3 control-label" for="reg_password2" style="padding-left: 0">确认密码：</label>
                        <div class="col-md-7">
                            <input type="password" class="form-control" id="reg_password2" name="reg_password2" placeholder="请再次输入密码">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-3 control-label" for="name" style="padding-left: 0">法官姓名：</label>
                        <div class="col-md-7">
                            <input type="text" class="form-control" id="name" name="name" placeholder="请输入姓名">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-3 control-label" for="court" style="padding-left: 0">工作法院：</label>
                        <div class="col-md-7">
                            <input type="text" class="form-control" id="court" name="court" placeholder="请输入工作单位">
                        </div>
                    </div>
                    <strong class="col-md-offset-4" style="color:red;" id="errorMessageField2"></strong>
                </form>
            </div>
            <div class="modal-footer">
                <div class="login-btn-group">
                    <button type="button" class="btn btn-primary" onclick="register()">注册</button>
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                </div>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>

<div id="loader-wrapper">
    <div id="loader"></div>
    <div class="loader-section section-left"></div>
    <div class="loader-section section-right"></div>
</div>

<script type="text/javascript">
    /**
     * 登出
     */

    function login() {
        var userName = $("#login_username").val();
        var password = $("#login_password").val();


        $.ajax({
            type: "post",
            async: true,
            url: "/req_log_in",
//            contentType: 'application/json;charset=UTF-8',
            data: {
                "workID": userName,
                "password": password
            },

            success: function (result) {

                var array = result.split(";");

                if (array[0] == "1") {
                    window.location.reload();
                } else if (array[0] == "-1") {
                    $("#errorMessageField").html("您的用户名或密码错误");
                } else {
                    $("#errorMessageField").html("您的用户名或密码错误");
                }
            },
            error: function (result) {
                alert("错误" + result);
            }
        });
    }
    function register() {
        var userName = $("#reg_username").val();
        var password1 = $("#reg_password").val();
        var password2 = $("#reg_password2").val();
        var name = $("#name").val();
        var court = $("#court").val();

        $.ajax({
            type: "post",
            async: true,
            url: "/req_register",
            data: {
                "workID":userName,
                "password": password1,
                "name": name,
                "subordinationCourt": court
            },

            success: function (result) {
                var array = result.split(";");

                if (array[0] == "1") {
                    window.location.reload();
                } else if (array[0] == "-1") {
                    // 提示错误信息
                    $("#errorMessageField2").html(array[1]);
                } else {
                    $("#errorMessageField2").html("请再次确定输入信息");
                }
            },
            error: function (result) {
                alert("错误" + result);
            }
        });
    }
</script>
