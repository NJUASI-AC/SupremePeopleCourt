/**
 * Created by gkj on 2017/7/17.
 */
$().ready(function () {
    $("#file").change(function(){
        let filepath = $(this).val();
        let filename = filepath.substr(filepath.lastIndexOf("\\")+1);
        $("#filename").text(filename);

    })

    $("#upload").click(function () {
        let file = $("#file").val();
        if(file == "")
            alert("No File!");
        $.ajax({
            url: "/upload",
            type: "POST",
            data: file,
            dataType: "json",
            success: function () {
                alert("success")
            }
        })
    })

})