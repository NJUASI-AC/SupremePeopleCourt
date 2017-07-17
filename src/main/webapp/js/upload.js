/**
 * Created by gkj on 2017/7/17.
 */
$().ready(function () {
    $("#file").change(function(){
        let filepath = $(this).val();
        alert(filepath);
        let filename = filepath.substr(filepath.lastIndexOf("\\")+1);
        alert(filename);
        $("#filename").text("文件名：" + filename);

    });

    $("#upload").click(function () {
        let file = $("#file").val();
        if(file === "") {
            alert("No File!");
        }
        $.ajaxFileUpload({
            type: "post",
            async: true,
            url: "/upload",
            fileElementId: "file",
            contentType: "application/json;charset=UTF-8",
            success: function () {
                alert("success")
            }
        });

        $("#filename").text("文件名：");

    })

});