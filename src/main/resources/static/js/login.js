$(function () {
    validateRule();
    $("#capthca").click(function () {
        this.src = ctx + "capthca.jpg";
    });
});

$.validator.setDefaults({
                            submitHandler: function () {
                                login();
                            }
                        });

function login() {
    layer.load(0, {shade: false});
    $.modal.loading();
    layui.use('form', function () {
        var form = layui.form;
        //监听提交
        form.on('submit(*)', function (data) {
            $.post('/login', data.field, function (res) {
                if (res.code == 200) {
                    location.href = "/user/center";
                } else {
                    $("#capthca").click();
                    layer.msg(res.msg);
                }
                $.modal.closeLoading();
            });
            $.modal.closeLoading();
            return false;
        });
    });
    $.modal.closeLoading();
}

function validateRule() {
    $("#loginForm").validate({
                                 wrapper:"span",
                                 rules: {
                                     username: "required",
                                     password: "required",
                                     vercode: "required",
                                     username: {
                                         required: true,
                                         minlength: 2
                                     },
                                     password: {
                                         required: true,
                                         minlength: 6
                                     },
                                     vercode: {
                                         required: true,
                                         minlength: 4
                                     }
                                 },
                                 messages: {
                                     username: {
                                         required: "请输入用户名",
                                         minlength: "用户名必需由两个字母组成"
                                     },
                                     password: {
                                         required: "请输入密码",
                                         minlength: "密码长度不能小于 6 个字母或数字！"
                                     },
                                     vercode: "请输入验证码"
                                 }
                             });
}
